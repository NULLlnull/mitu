package com.basedata.controller;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.basedata.utils.Utils;
import org.apache.commons.beanutils.ConvertUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import com.basedata.annotation.NeedPage;
import com.basedata.model.Ryjcxx;
import com.basedata.service.IRyjcxxService;
import com.basedata.vo.DataTables;
import com.basedata.vo.DataUtils;
import com.basedata.vo.PageView;
import com.basedata.vo.Result;
import com.basedata.vo.SystemContext;

/**
 * 教师
 * 
 * @author Administrator
 *
 */
@RequestMapping("/ryjcxx")
@Controller
public class RyjcxxController extends BaseController<Ryjcxx> {

	@Autowired
	private IRyjcxxService ryjcxxService;

	/**
	 * 教师列表页数据
	 * 
	 * @param model
	 * @param ryjcxx
	 * @return
	 */
	@NeedPage
	@ResponseBody
	@RequestMapping(value = "list.do", produces = "application/json; charset=utf-8")
	public String list(ModelMap model, Ryjcxx ryjcxx) {
		DataTables dataTables = DataTables.getInstance(request, null);
		PageView pageView = new PageView(SystemContext.getOffset());
		ryjcxxService.query(pageView, ryjcxx, dataTables, request);
		return JSONObject.toJSONString(DataUtils.tableData(pageView, dataTables));
	}

	/**
	 * 教师详情页数据
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "edit.do", produces = "application/json; charset=utf-8")
	public String edit(ModelMap model, String id) {
		return JSONObject.toJSONString(ryjcxxService.getById(id));
	}

	/**
	 * 更新记录
	 * 
	 * @param model
	 * @param ryjcxx
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "update.do", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public String update(ModelMap model, Ryjcxx ryjcxx) {
		Result result = new Result();
		result = ryjcxxService.update(ryjcxx, result);
		return JSONObject.toJSONString(result);
	}

	/**
	 * 添加记录
	 * 
	 * @param model
	 * @param ryjcxx
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "add.do", produces = "application/json; charset=utf-8")
	public String add(ModelMap model, Ryjcxx ryjcxx) {
		Result result = new Result();
		result = ryjcxxService.save(ryjcxx, result);
		return JSONObject.toJSONString(result);
	}

	/**
	 * 删除记录
	 * 
	 * @param ids
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "del.do", produces = "application/json; charset=utf-8")
	public String del(String ids) {
		Result result = new Result();
		Integer[] idList = (Integer[]) ConvertUtils.convert(ids.split(","), Integer.class);
		result = ryjcxxService.delByIds(Arrays.asList(idList), result);
		return JSONObject.toJSONString(result);
	}

	/**
	 * 导出数据
	 * 
	 * @param model
	 * @param ryjcxx
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "exportData.do")
	@ResponseBody
	public List<Ryjcxx> exportData(ModelMap model, Ryjcxx ryjcxx) throws Exception {
		DataTables dataTables = DataTables.getInstance(request, null);
		List<Ryjcxx> data = ryjcxxService.exportData(dataTables, request);
		return data;
	}

	/**
	 * 上传照片
	 *
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "uploadImg.do")
	public Result uploadImg(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Result result = new Result();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("file");
		if (file == null) {
			result.setStatus(-1);
			return result;
		}
		String fileName = request.getParameter("fileName");// 文件原名称
		// 判断文件类型
		String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length())
				: null;
		if (type == null) {
			result.setStatus(-1);
			return result;
		}

		if ("GIF".equalsIgnoreCase(type) || "PNG".equalsIgnoreCase(type) || "JPG".equalsIgnoreCase(type)) {
			// 项目在容器中实际发布运行的根路径
			String realPath = request.getSession().getServletContext().getRealPath("/headImg/");
			File dir = new File(realPath);
			if (!dir.isDirectory())
				dir.mkdir();
			// 自定义的文件名称
			String trueFileName = System.currentTimeMillis() + "_" + UUID.randomUUID() + "_." + type;
			// 转存文件到指定的路径
			file.transferTo(new File(realPath, trueFileName));
			result.setData(trueFileName);
		} else {
			result.setStatus(-1);
		}
		return result;
	}

}
