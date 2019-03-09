package com.basedata.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ExcelPkUtils {
    //工作簿
    private HSSFWorkbook workbook = null;
    //工作表
    private HSSFSheet sheet = null;
    // excel 表头
    private List<String[]> heads;
    // list集合
    private List<String[]> list;
    // 输出流
    private OutputStream out;
    private HSSFCellStyle titleStyle;
    private HSSFCellStyle[] contentStyles = new HSSFCellStyle[2];

    // 构造函数 带数字类型
    public ExcelPkUtils(List<String[]> heads, List<String[]> list, OutputStream out) {
        this.heads = heads;
        this.list = list;
        this.out = out;
        init();
    }

    //生成Excel表格
    public void exportExcel() {
        createHead();
        createContent();
        cleanBlankRow();
        mergeCell();
        writeFile();
    }

    //初始化
    private void init() {
        workbook = new HSSFWorkbook(); // 创建一个excel对象
        sheet = workbook.createSheet(); // 工作表

        sheet.setHorizontallyCenter(true);// 设置打印页面为水平居中
        sheet.setVerticallyCenter(true);// 设置打印页面为垂直居中
        sheet.getPrintSetup().setLandscape(true);//页面横向打印
        sheet.getPrintSetup().setPaperSize(HSSFPrintSetup.A4_PAPERSIZE); //纸张类型

        sheet.setMargin(HSSFSheet.TopMargin, 0.2);
        sheet.setMargin(HSSFSheet.BottomMargin, 0.2);
        sheet.setMargin(HSSFSheet.LeftMargin, 0.2);
        sheet.setMargin(HSSFSheet.RightMargin, 0.2);
        sheet.setDefaultColumnWidth(10 * 256);
        sheet.setColumnWidth(0, 15 * 256);

        titleStyle = titleStyle(workbook);
        contentStyles[0] = contentStyle(workbook);
        contentStyles[0].setFillForegroundColor(IndexedColors.WHITE.getIndex());
        contentStyles[0].setFillPattern(CellStyle.SOLID_FOREGROUND);
        contentStyles[1] = contentStyle(workbook);
        contentStyles[1].setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        contentStyles[1].setFillPattern(CellStyle.SOLID_FOREGROUND);
    }

    //创建标题行和表头
    private void createHead() {
        int curRow = 0, colCount = 0;
        for (String[] head : heads) {
            HSSFRow headRow = sheet.createRow(curRow);
            headRow.setHeight((short) (curRow == 0 ? 3 * 256 : 2 * 256));
            for (int h = 0; h < head.length; h++) {
                HSSFCell headCell = headRow.createCell(h, Cell.CELL_TYPE_STRING);
                headCell.setCellValue(head[h]);
                if (curRow == 0)
                    headCell.setCellStyle(titleStyle);
                else
                    headCell.setCellStyle(contentStyles[0]);
            }
            colCount = Math.max(colCount, head.length);
            curRow++;
        }

        //标题行
        sheet.addMergedRegion(new CellRangeAddress(0, 0, (short) 0, colCount - 1));
    }

    //创建内容表格
    public void createContent() {
        // 输出数据
        for (int curRow = 0; list != null && curRow < list.size(); curRow++) {
            String[] arr = list.get(curRow);
            // 创建excel行 表头1行 导致数据行数 延后一行
            HSSFRow dataRow = sheet.createRow(curRow + heads.size());
            dataRow.setHeight((short) (5 * 256));

            for (int curCol = 0; curCol < arr.length; curCol++) {
                HSSFCell cell = dataRow.createCell(curCol);
                cell.setCellStyle(contentStyles[(curCol + 13) / 14 % 2]);
                cell.setCellValue(arr[curCol]);
            }
        }
    }

    //清除空行
    private void cleanBlankRow() {
        //System.out.println("getLastRowNum=" + sheet.getLastRowNum());
        //getLastRowNum返回索引号（0开始）,不找最后一行
        for (int r = 1; r < sheet.getLastRowNum(); r++) {
            try {
                HSSFRow row = sheet.getRow(r);
                String content = "";
                //getLastCellNum返回列数（1开始）
                //System.out.println("row=" + r + ",getLastCellNum=" + row.getLastCellNum());
                for (int c = 1; c < row.getLastCellNum(); c++) {
                    content += row.getCell(c).getStringCellValue();
                }
                //System.out.println("row" + r + "[" + content + "]");
                if (content.trim().equalsIgnoreCase(""))
                    sheet.shiftRows(r + 1, sheet.getLastRowNum(), -1);
            } catch (Exception ex) {
                //ex.printStackTrace();
            }
        }
    }

    //合并单元格
    private void mergeCell() {
        for (int r = 0; r <= sheet.getLastRowNum(); r++) {
            HSSFRow row = sheet.getRow(r);
            //合并单元格起始列
            int startCol = -1;
            for (int c = 0; c < row.getLastCellNum() - 1; c++) {
                String text_cur = row.getCell(c).getStringCellValue().trim();
                String text_next = row.getCell(c + 1).getStringCellValue().trim();
                //合并起始位
                if (text_cur.equals(text_next) && startCol == -1 && text_cur != "") {
                    startCol = c;
                }
                //合并结束位
                if (startCol > -1 && !text_cur.equals(text_next)) {
                    sheet.addMergedRegion(new CellRangeAddress(r, r, startCol, c));
                    row.getCell(startCol).setCellValue(text_cur);
                    startCol = -1;
                }
                //System.out.println("[]r=" + r + ",c=" + c + ":startCol=" + startCol);
            }
            if (startCol > -1) {
                sheet.addMergedRegion(new CellRangeAddress(r, r, startCol, row.getLastCellNum() - 1));
                row.getCell(startCol).setCellValue(row.getCell(startCol).getStringCellValue());
            }
        }
    }

    //写入文件
    private void writeFile() {
        // excel生成完毕，写到输出流
        try {
            workbook.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 选中的加粗和背景
    private HSSFCellStyle titleStyle(HSSFWorkbook workbook) {
        HSSFCellStyle cellstyle = workbook.createCellStyle();
        HSSFFont font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
        cellstyle.setFont(font);// 选择需要用到的字体格式
        cellstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
        cellstyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        return cellstyle;
    }

    // 居中
    private HSSFCellStyle contentStyle(HSSFWorkbook workbook) {
        HSSFCellStyle cellstyle = workbook.createCellStyle();
        cellstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
        cellstyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cellstyle.setWrapText(true);
        cellstyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellstyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellstyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellstyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        return cellstyle;
    }

}