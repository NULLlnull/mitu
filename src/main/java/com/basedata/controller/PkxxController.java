package com.basedata.controller;

import com.basedata.model.Bjxx;
import com.basedata.model.Jxrw;
import com.basedata.model.Pkxx;
import com.basedata.service.IBjxxService;
import com.basedata.service.IJxrwService;
import com.basedata.service.IPkxxService;
import com.basedata.utils.ExcelPkUtils;
import com.basedata.utils.ServletUtil;
import com.basedata.utils.Utils;
import com.basedata.vo.ExcelUtils;
import com.basedata.vo.PkxxExport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RequestMapping("/pkxx")
@Controller
public class PkxxController extends BaseController<Pkxx> {

	@Autowired
	private IPkxxService pkxxService;

	@Autowired
	private IJxrwService jxrwService;

    @Autowired
    private IBjxxService bjxxService;
	/**
	 * 加载班级
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "loadClazz")
	@ResponseBody
	public List<Jxrw> loadClazz(ModelMap model) {
		List<Jxrw> list = jxrwService.getClazz();
		return list;
	}

	/**
	 * 加载教师
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "loadTeachers")
	@ResponseBody
	public List<Pkxx> loadTeachers(ModelMap model) {
		List<Pkxx> list = pkxxService.getTeachers();
		return list;
	}

	/**
	 * 加载场地
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "loadSpaces")
	@ResponseBody
	public List<Pkxx> loadSpaces(ModelMap model) {
		List<Pkxx> list = pkxxService.getSpaces();
		return list;
	}

	/**
	 * 根据班级获取排课信息
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "loadPkxxByclazz")
	@ResponseBody
	public List<HashMap<String, Object>> loadPkxxByclazz(ModelMap model) {
		Map<String, String> params = new HashMap<String, String>();
		String ssbj = request.getParameter("ssbj");
		if (StringUtils.isNotBlank(ssbj)) {
			params.put("ssbj", ssbj);
		}
		List<HashMap<String, Object>> list = pkxxService.loadPkxxByclazz(params);
		return list;
	}

	/**
	 * 排课信息
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "loadPkxx")
	@ResponseBody
	public List<HashMap<String, Object>> loadPkxx(ModelMap model) {
		Map<String, String> params = new HashMap<String, String>();
		String skjs = request.getParameter("skjs");
		String skcddm = request.getParameter("skcddm");
		if (StringUtils.isNotBlank(skjs)) {
			params.put("skjs", skjs);
		}
		if (StringUtils.isNotBlank(skcddm)) {
			params.put("skcddm", skcddm);
		}
		List<HashMap<String, Object>> list = pkxxService.getPkxx(params);
		return list;
	}

	/**
	 * 导出execl表
	 * 
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "exportExecl")
	public void exportExecl(ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HashMap<String, String> params = new HashMap<String, String>();
		String param = request.getParameter("param");
		String type = request.getParameter("type");

		List<HashMap<String, Object>> data = null;
		String title = "";
		// 班级
		if ("1".equals(type)) {
			params.put("ssbj", param);
			data = pkxxService.loadPkxxByclazz(params);
			title = data.get(0) != null ? data.get(0).get("title") + "" : "";
		} else if ("2".equals(type)) {
			params.put("skjs", param);
			data = pkxxService.getPkxx(params);
			title = data.get(0) != null ? data.get(0).get("skjsxm") + " 课程表" : "";
		} else if ("3".equals(type)) {
			params.put("skcddm", param);
			data = pkxxService.getPkxx(params);
			title = data.get(0) != null ? data.get(0).get("skcdmc") + " 课程表" : "";
		}

		String fileName = new Date().getTime() + ".xls";
		ServletUtil su = new ServletUtil(fileName, req, resp);
		su.poiExcelServlet();
		PkxxExport pkxx = new PkxxExport(title, data, su.getOut());
		pkxx.exportExcel();
	}

    public static String[] heads = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
    public static String[] heads2 = {"1", "2", "3", "4", "中1", "中2", "1", "2", "3", "4", "晚1", "晚2", "晚3", "晚4"};

    /**
     * 导出全校课表
     */
    @RequestMapping(value = "exportAll")
    public void exportAll(ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String[] title = {"全校课程表"};
        String[] head_xq = new String[heads.length * heads2.length + 1];
        String[] head_jc = new String[heads.length * heads2.length + 1];
        for (int i = 1; i < head_jc.length; i++) {
            head_xq[i] = heads[(i - 1) / heads2.length];
            head_jc[i] = heads2[(i - 1) % heads2.length];
        }
        List<String[]> list_heads = new ArrayList<>();
        list_heads.add(title);
        list_heads.add(head_xq);
        list_heads.add(head_jc);

        HashMap<String, String> params = new HashMap<>();
        List<HashMap<String, Object>> data = pkxxService.getPkxx(params);
        List<String[]> list = convertToArray(data);

        String fileName = new Date().getTime() + ".xls";
        ServletUtil su = new ServletUtil(fileName, req, resp);
        su.poiExcelServlet();
        ExcelPkUtils excelUtils = new ExcelPkUtils(list_heads, list, su.getOut());
        excelUtils.exportExcel();
    }

    /**
     * 实体列表转数组列表
     */
    private List<String[]> convertToArray(List<HashMap<String, Object>> data) {
        List<Bjxx> list_bjxx = bjxxService.queryAll(new Bjxx());
        String[][] result = new String[list_bjxx.size()][heads.length * heads2.length + 1];
        for (HashMap<String, Object> map : data) {
            int idx = getIdx(list_bjxx, map.get("ssbj").toString());
            if (idx < 0)
                continue;
            int col = (Utils.toInt(map.get("xqs")) - 1) * heads2.length + Utils.toInt(map.get("jc")) - 1;
            if (col > result[idx].length)
                continue;
            result[idx][0] = map.get("bjmc").toString();
            result[idx][col + 1] = map.get("skjsxm") + "\r\n《" + map.get("kcmc") + "》\r\n" + map.get("skcdmc");
        }
        List<String[]> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            list.add(result[i]);
        }
        return list;
    }

    private int getIdx(List<Bjxx> list, String bjdm) {
        int idx = 0;
        for (Bjxx bjxx : list) {
            if (bjdm.equalsIgnoreCase(bjxx.getBjdm()))
                return idx;
            idx++;
        }
        return -1;
    }
}
