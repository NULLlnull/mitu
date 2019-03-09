package com.basedata.vo;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

public class PkxxAllExport {
    // excel 表头
    public static String[] heads = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
    // excel 列
    public static String[] cols = {"1", "2", "3", "4", "中1", "中2", "1", "2", "3", "4", "晚1", "晚2", "晚3", "晚4"};
    // excle导出名称
    private String sheetName = "全校课程表";
    // list集合
    private HashMap<String, Object> list[][];
    // 输出流
    private OutputStream out;

    private String title;

    // 构造函数 带数字类型
    public PkxxAllExport(String title, List<HashMap<String, Object>> list, OutputStream out) {
        this.title = title;
        this.list = convert(list);
        this.out = out;
    }

    public void exportExcel() {
        HSSFWorkbook workbook = new HSSFWorkbook(); // 创建一个excel对象
        HSSFSheet sheet = workbook.createSheet(); // 工作表
        // 工作表名称
        workbook.setSheetName(0, sheetName);

        // 输出excel 表头
        HSSFRow titlerow = sheet.createRow(0);
        HSSFRow headrow = sheet.createRow(1);
        if (heads != null && heads.length > 0) {
            HSSFCell title_first = titlerow.createCell(0, Cell.CELL_TYPE_STRING);
            title_first.setCellValue("");
            title_first.setCellStyle(buildBaseStyle(workbook));
            HSSFCell title_second = titlerow.createCell(1, Cell.CELL_TYPE_STRING);
            title_second.setCellValue("");

            HSSFCell head_first = headrow.createCell(0, Cell.CELL_TYPE_STRING);
            head_first.setCellValue("");
            head_first.setCellStyle(buildBaseStyle(workbook));
            HSSFCell head_second = headrow.createCell(1, Cell.CELL_TYPE_STRING);
            head_second.setCellValue("");
            head_second.setCellStyle(buildBaseStyle(workbook));
            for (int h = 0; h < heads.length; h++) {
                HSSFCell title_cell = titlerow.createCell(h + 2, Cell.CELL_TYPE_STRING);
                title_cell.setCellValue("");
                title_cell.setCellStyle(buildBaseStyle(workbook));

                HSSFCell headcell = headrow.createCell(h + 2, Cell.CELL_TYPE_STRING);
                headcell.setCellValue(heads[h]);
                headcell.setCellStyle(buildBaseStyle(workbook));
            }
        }

        // 输出数据
        for (int curRow = 1; curRow <= cols.length; curRow++) {
            // 每列的数据
            HashMap<String, Object> data[] = list[curRow - 1];
            // 创建excel行 表头1行 导致数据行数 延后一行
            HSSFRow datarow = sheet.createRow(curRow + 1);

            HSSFCell timecell = datarow.createCell(0);
            timecell.setCellStyle(buildBaseStyle(workbook));
            if (curRow <= 4) {
                timecell.setCellValue("上午");
            } else if (curRow <= 6) {
                timecell.setCellValue("中午");
            } else if (curRow <= 10) {
                timecell.setCellValue("下午");
            } else if (curRow <= 14) {
                timecell.setCellValue("晚上");
            }

            HSSFCell datacell = datarow.createCell(1);
            datacell.setCellStyle(buildBaseStyle(workbook));
            datacell.setCellValue(cols[curRow - 1]);

            for (int k = 1; k <= heads.length; k++) {
                HSSFCell cell = datarow.createCell(k + 1);
                String cellval = "";
                if (data != null && data[k - 1] != null) {
                    HashMap<String, Object> cur = data[k - 1];
                    cellval = cur.get("kcmc") + "\r\n" + cur.get("bjmc") + "\r\n" + cur.get("pkzc") + "\r\n" + cur.get("skjsxm");
                }
                cell.setCellStyle(boldCellStyle(workbook));
                cell.setCellValue(new HSSFRichTextString(cellval));
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
        return cellstyle;
    }

    // 居中
    private HSSFCellStyle buildBaseStyle(HSSFWorkbook workbook) {
        HSSFCellStyle cellstyle = workbook.createCellStyle();
        cellstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
        cellstyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
        cellstyle.setWrapText(true);
        cellstyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
        cellstyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
        cellstyle.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
        cellstyle.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
        return cellstyle;
    }

    @SuppressWarnings("unchecked")
    public HashMap<String, Object>[][] convert(List<HashMap<String, Object>> data) {
        HashMap<String, Object>[][] result = new HashMap[cols.length][heads.length];
        for (HashMap<String, Object> map : data) {
            int jc = Integer.parseInt(map.get("jc").toString()) - 1;
            int xqs = Integer.parseInt(map.get("xqs").toString()) - 1;
            result[jc][xqs] = map;
        }
        return result;
    }

}