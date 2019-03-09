package com.basedata.vo;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ExcelUtils {
    private String title;
    // excel 表头
    private String[] heads;
    // list集合
    private List<String[]> list;
    // 输出流
    private OutputStream out;

    // 构造函数 带数字类型
    public ExcelUtils(String title, String[] heads, List<String[]> list, OutputStream out) {
        this.title = title;
        this.heads = heads;
        this.list = list;
        this.out = out;
    }

    public void exportExcel() {
        HSSFWorkbook workbook = new HSSFWorkbook(); // 创建一个excel对象
        HSSFSheet sheet = workbook.createSheet(); // 工作表

        sheet.setHorizontallyCenter(true);// 设置打印页面为水平居中
        sheet.setVerticallyCenter(true);// 设置打印页面为垂直居中

        sheet.setMargin(HSSFSheet.TopMargin, 0.2);
        sheet.setMargin(HSSFSheet.BottomMargin, 0.2);
        sheet.setMargin(HSSFSheet.LeftMargin, 0.2);
        sheet.setMargin(HSSFSheet.RightMargin, 0.2);
        sheet.setDefaultColumnWidth(20);
        sheet.setColumnWidth(0, 30 * 256);// 30个字符

        // 输出excel 表头
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.setHeight((short) (2 * 256));
        HSSFRow headRow = sheet.createRow(1);
        headRow.setHeight((short) (1.5 * 256));

        //表头
        HSSFCellStyle boldStyle = boldCellStyle(workbook);
        if (heads != null && heads.length > 0) {
            for (int h = 0; h < heads.length; h++) {
                HSSFCell title_cell = titleRow.createCell(h, Cell.CELL_TYPE_STRING);
                title_cell.setCellValue(title);
                title_cell.setCellStyle(boldStyle);

                HSSFCell headCell = headRow.createCell(h, Cell.CELL_TYPE_STRING);
                headCell.setCellValue(heads[h]);
                headCell.setCellStyle(boldStyle);
            }
        }

        CellRangeAddress region = new CellRangeAddress(0, 0, (short) 0, (short) heads.length - 1);
        sheet.addMergedRegion(region);

        // 输出数据
        //HSSFCellStyle baseStyle = buildBaseStyle(workbook);
        for (int curRow = 0; list != null && curRow < list.size(); curRow++) {
            String[] arr = list.get(curRow);
            // 创建excel行 表头1行 导致数据行数 延后一行
            HSSFRow dataRow = sheet.createRow(curRow + 2);
            dataRow.setHeight((short) (1.5 * 256));

            for (int curCol = 0; curCol < arr.length; curCol++) {
                HSSFCell cell = dataRow.createCell(curCol);
                //cell.setCellStyle(baseStyle);
                cell.setCellValue(arr[curCol]);
            }
        }

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
    private HSSFCellStyle boldCellStyle(HSSFWorkbook workbook) {
        HSSFCellStyle cellstyle = buildBaseStyle(workbook);
        HSSFFont font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
        cellstyle.setFont(font);// 选择需要用到的字体格式
        cellstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
        cellstyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        return cellstyle;
    }

    // 居中
    private HSSFCellStyle buildBaseStyle(HSSFWorkbook workbook) {
        HSSFCellStyle cellstyle = workbook.createCellStyle();
        cellstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
        cellstyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cellstyle.setWrapText(true);
        return cellstyle;
    }

}