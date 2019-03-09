package com.basedata.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadUtils {

	/**
	 * 上传文件
	 * 
	 * @param request
	 * @param pdir
	 * @param file
	 */
	public static String uploadFile(HttpServletRequest request, String pdir, MultipartFile file) {
		String trueFileName = "";
		try {
			String fileName = file.getOriginalFilename();
			// 判断文件类型
			String type = fileName.indexOf(".") != -1
					? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : "";
			if (StringUtils.isBlank(type)) {
				return "";
			}
			String realPath = request.getSession().getServletContext().getRealPath("/attachement/" + pdir + "/");
			File dir = new File(realPath);
			if (!dir.isDirectory())
				dir.mkdir();
			// 自定义的文件名称
			trueFileName = System.currentTimeMillis() + "_" + UUID.randomUUID() + "." + type;
			// 转存文件到指定的路径
			file.transferTo(new File(realPath, trueFileName));
		} catch (IOException e) {
			e.printStackTrace();
			trueFileName = "";
		}
		return trueFileName;

	}

}
