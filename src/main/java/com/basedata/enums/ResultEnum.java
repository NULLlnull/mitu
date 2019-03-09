package com.basedata.enums;

public enum ResultEnum {

	SUCCESS(1, "成功"), FAIL(-1, "失败"), PARAM(-2, "缺少必要参数"), UNEXIST(-3, "记录不存在");
	private int code;
	private String msg;

	private ResultEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
