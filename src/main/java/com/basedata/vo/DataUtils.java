package com.basedata.vo;

import java.util.ArrayList;

public class DataUtils {

	public static DataTables tableData(PageView pageView, DataTables dataTables) {
		dataTables.setRecordsTotal(pageView.getRowCount());
		dataTables.setRecordsFiltered(pageView.getRowCount());
		dataTables.setData(pageView.getRecords() != null ? pageView.getRecords() : new ArrayList<>());
		return dataTables;
	}

}
