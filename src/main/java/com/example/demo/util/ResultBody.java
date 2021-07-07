package com.example.demo.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @author lyd
 * @Description: 自定义数据传输格式
 * @date 16:40
 */
public class ResultBody {

	/**
	 * 响应代码
	 */
	private String code;
	/**
	 * 响应消息
	 */
	private String message;
	/**
	 * 响应结果
	 */
	private Object result;

	public ResultBody() {
	}

	public ResultBody(BaseErrorInfoInterface baseErrorInfoInterface) {
		this.code = baseErrorInfoInterface.getResultCode();
		this.message = baseErrorInfoInterface.getResultMsg();
	}

	/**
	 * 成功
	 *
	 * @param data 数据
	 * @return {@link ResultBody}
	 */
	public static ResultBody success(Object data) {
		ResultBody resultBody = new ResultBody();
		resultBody.setCode(CommonEnum.SUCCESS.getResultCode());
		resultBody.setMessage(CommonEnum.SUCCESS.getResultMsg());
		resultBody.setResult(data);
		return resultBody;
	}

	/**
	 * 错误
	 *
	 * @param errorInfo 错误信息
	 * @return {@link ResultBody}
	 */
	public static ResultBody error(BaseErrorInfoInterface errorInfo) {
		ResultBody resultBody = new ResultBody();
		resultBody.setCode(errorInfo.getResultCode());
		resultBody.setMessage(errorInfo.getResultMsg());
		resultBody.setResult(null);
		return resultBody;
	}

	/**
	 * 错误
	 *
	 * @return {@link ResultBody}
	 */
	public static ResultBody error(String code, String message) {
		ResultBody resultBody = new ResultBody();
		resultBody.setCode(code);
		resultBody.setMessage(message);
		resultBody.setResult(null);
		return resultBody;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
}