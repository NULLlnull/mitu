package com.basedata.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.basedata.model.Zddm;
import com.basedata.service.IZddmService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Utils {
    /**
     * 上传附件
     */
    public static StringBuffer[] getAttachmets(MultipartFile[] files, HttpServletRequest request, String dict) {
        StringBuffer[] stringBuffers = {new StringBuffer(), new StringBuffer()};
        if (files != null && files.length > 0) {
            // 循环获取file数组中得文件
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                String fileName = UploadUtils.uploadFile(request, dict, file);
                if (StringUtils.isNotBlank(fileName)) {
                    stringBuffers[0].append(fileName);
                    stringBuffers[1].append(file.getOriginalFilename());
                    if (i != files.length - 1) {
                        stringBuffers[0].append("||");
                        stringBuffers[1].append("||");
                    }
                }
            }
        }
        return stringBuffers;
    }

    /**
     * 获取指定字典，并返回hashmap
     */
    public static HashMap<String, String> getZddmMap(IZddmService zddmService, String zdlbs) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            HashMap<String, List<Zddm>> data = (HashMap<String, List<Zddm>>) zddmService.property(zdlbs).getData();
            String[] arr_zdlb = zdlbs.split(",");
            for (String zdlb : arr_zdlb) {
                List<Zddm> list = data.get(zdlb);
                for (Zddm zddm : list) {
                    hashMap.put(zddm.getDmbh(), zddm.getDmmc());
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        //验证 输出
//        Iterator iter = hashMap.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry entry = (Map.Entry) iter.next();
//            Object key = entry.getKey();
//            Object val = entry.getValue();
//            System.out.println("[zddm]" + key + ":" + val);
//        }
        return hashMap;
    }

    public static String getInMap(HashMap<String, String> map, String key) {
        String val = map.get(key);
//        System.out.println("[getInMap]" + key + val);
        return StringUtils.isEmpty(val) ? "" : val;
    }

    //返回整型
    public static int toInt(Object o, int def) {
        try {
            return (int) Double.parseDouble(o.toString());
        } catch (Exception e) {
        }
        return def;
    }

    public static int toInt(Object o) {
        return toInt(o, 0);
    }

    //返回整型
    public static byte toByte(Object o) {
        try {
            return Byte.parseByte(o.toString());
        } catch (Exception e) {
        }
        return 0;
    }

    public static void main(String[] args) {
    }
}
