package com.basedata.vo;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

public class PkxxExport {
	// excel 表头
	public static String[] heads = { "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日" };
	// excel 列
	public static String[] cols = { "第一节", "第二节", "第三节", "第四节", "中午1", "中午2", "第五节", "第六节", "第七节", "第八节", "第九节", "第十节",
			"第十一节", "第十二节" };
	// excle导出名称
	private String sheetName = "排课信息";
	// list集合
	private HashMap<String, Object> list[][];
	// 输出流
	private OutputStream out;

	private String title;

	// 构造函数 带数字类型
	public PkxxExport(String title, List<HashMap<String, Object>> list, OutputStream out) {
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
					cellval = cur.get("kcmc") + "\r\n" + cur.get("bjmc") + "\r\n" + cur.get("pkzc") + "\r\n"
							+ cur.get("skjsxm");
				}
				cell.setCellStyle(boldCellStyle(workbook));
				cell.setCellValue(new HSSFRichTextString(cellval));
			}
		}

		// 删除中午
		delBlankRow(workbook, 6, 7, 1);
		// 删除晚上
		int end = workbook.getSheetAt(0).getLastRowNum();
		int start = end - 3;
		delBlankRow(workbook, start, end, 2);
		// 删除周末
		hideWeekendBlankRow(workbook);
		// 合并单元格
		mergeRows(workbook);
		// 整理
		cleanSheet(workbook);

		// excel生成完毕，写到输出流
		try {
			workbook.write(out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 1、删除中午晚上的空白行 type为1 时从中间删除，为2时表示从末尾删除
	private void delBlankRow(HSSFWorkbook workbook, int start, int end, int type) {
		HSSFSheet sheet = workbook.getSheetAt(0);
		List<HSSFRow> list = new ArrayList<HSSFRow>();
		for (int i = start; i <= end; i++) {
			HSSFRow row = sheet.getRow(i);
			list.add(row);
		}
		boolean needRemoveBlankRow = needRemoveBlankRow(workbook, list);
		if (needRemoveBlankRow) {
			// 中午
			if (type == 1) {
				for (int j = end; j >= start; j--) {
					removeRow(sheet, j);
				}
			}
			// 晚上 直接从末尾删除
			if (type == 2) {
				int last = sheet.getLastRowNum();
				for (int j = 0; j < 4; j++) {
					removeRow(sheet, last - j);
				}

			}
		}
	}

	// 2、删除周末
	private void hideWeekendBlankRow(HSSFWorkbook workbook) {
		boolean flag = false;
		HSSFSheet sheet = workbook.getSheetAt(0);
		int rownum = sheet.getLastRowNum();
		for (int i = 2; i <= rownum; i++) {
			for (int j = 7; j <= 8; j++) {
				String cellval = sheet.getRow(i).getCell(j).getStringCellValue();
				if (StringUtils.isNotBlank(cellval)) {
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}

		if (!flag) {
			// 删除周六日的空格
			for (int k = 0; k <= rownum; k++) {
				sheet.getRow(k).removeCell(sheet.getRow(k).getCell(7));
				sheet.getRow(k).removeCell(sheet.getRow(k).getCell(8));
			}
		}
		// 确定第一行合并的位置，合并第一行，
		sheet.addMergedRegion(
				new CellRangeAddress(0, 0, 0, sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells() - 1));
	}

	private boolean needRemoveBlankRow(HSSFWorkbook workbook, List<HSSFRow> list) {
		boolean flag = false;
		for (HSSFRow row : list) {
			for (int i = 2; i < row.getPhysicalNumberOfCells(); i++) {
				String celval = row.getCell(i).getStringCellValue();
				if (StringUtils.isNotBlank(celval)) {
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		return !flag;
	}

	public static void removeRow(HSSFSheet sheet, int rowIndex) {
		int lastRowNum = sheet.getLastRowNum();
		if (rowIndex >= 0 && rowIndex < lastRowNum)
			sheet.shiftRows(rowIndex + 1, lastRowNum, -1);
		if (rowIndex == lastRowNum) {
			HSSFRow removingRow = sheet.getRow(rowIndex);
			if (removingRow != null)
				sheet.removeRow(removingRow);
		}
	}

	// 3、合并单元格
	private void mergeRows(HSSFWorkbook workbook) {
		HSSFSheet sheet = workbook.getSheetAt(0);
		for (int col = 0; col < sheet.getRow(sheet.getLastRowNum()).getPhysicalNumberOfCells(); col++) {
			int start = 2;
			int end = 2;
			for (int row = 2; row < sheet.getLastRowNum(); row++) {
				HSSFRow curRow = sheet.getRow(row);
				String curval = curRow.getCell(col).getStringCellValue();
				if (StringUtils.isBlank(curval)) {
					start++;
					end++;
				} else {
					HSSFRow nextRow = sheet.getRow(row + 1);
					String nextval = nextRow.getCell(col).getStringCellValue();
					if (curval.equals(nextval)) {
						end++;
						// 处理匹配到最后
						if (end == sheet.getLastRowNum()) {
							sheet.addMergedRegion(new CellRangeAddress(start, end, col, col));
						}
					} else {
						sheet.addMergedRegion(new CellRangeAddress(start, end, col, col));
						end++;
						start = end;
					}
				}
			}
		}
	}

	// 4、整理表格
	private void cleanSheet(HSSFWorkbook workbook) {
		HSSFSheet sheet = workbook.getSheetAt(0);
		sheet.setColumnWidth(0, 10 * 256);// 10个字符
		HSSFPrintSetup printSetup = sheet.getPrintSetup();
		printSetup.setLandscape(true);
		printSetup.setPaperSize(HSSFPrintSetup.A4_PAPERSIZE);
		sheet.setDisplayGridlines(false);
		sheet.setPrintGridlines(false);
		sheet.setHorizontallyCenter(true);// 设置打印页面为水平居中
		sheet.setVerticallyCenter(true);// 设置打印页面为垂直居中

		sheet.setMargin(HSSFSheet.TopMargin, 0.2);
		sheet.setMargin(HSSFSheet.BottomMargin, 0.2);
		sheet.setMargin(HSSFSheet.LeftMargin, 0.2);
		sheet.setMargin(HSSFSheet.RightMargin, 0.2);
		int lastRowNum = sheet.getLastRowNum();

		// 设置行高
		for (int i = 0; i <= lastRowNum; i++) {
			if (i == 0) {
				sheet.getRow(0).getCell(0).setCellValue(this.title);
				sheet.getRow(i).setHeight((short) (3 * 256));
				int cols = sheet.getRow(0).getPhysicalNumberOfCells();
				for (int k = 0; k < cols; k++) {
					sheet.getRow(0).getCell(k).setCellStyle(buildBaseStyle(workbook));
				}
			} else if (i == 1) {
				sheet.getRow(i).setHeight((short) (2 * 256));
			} else {
				sheet.getRow(i).setHeightInPoints(36);
			}

		}
		// 设置列宽
		for (int j = 1; j < sheet.getRow(1).getPhysicalNumberOfCells(); j++) {
			sheet.setColumnWidth(j, 256 * 18 + 184);// 10个字符
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