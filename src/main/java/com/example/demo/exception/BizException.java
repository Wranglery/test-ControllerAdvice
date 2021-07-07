package com.example.demo.exception;

import com.example.demo.util.BaseErrorInfoInterface;

/**
 * @author lyd
 * @Description: 自定义异常类
 * @date 16:25
 */
public class BizException extends RuntimeException {


	/**
	 * 错误代码
	 */
	private String errorCode;
	/**
	 * 错误信息
	 */
	private String errorMsg;

	public BizException() {
		super();
	}

	public BizException(String message, String errorMsg) {
		super(message);
		this.errorMsg = errorMsg;
	}

	public BizException(String message, String errorCode, String errorMsg) {
		super(message);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public BizException(BaseErrorInfoInterface baseErrorInfoInterface) {
		super(baseErrorInfoInterface.getResultCode());
		this.errorCode = baseErrorInfoInterface.getResultCode();
		this.errorMsg = baseErrorInfoInterface.getResultMsg();
	}

	public BizException(BaseErrorInfoInterface baseErrorInfoInterface, Throwable cause) {
		super(baseErrorInfoInterface.getResultCode(), cause);
		this.errorCode = baseErrorInfoInterface.getResultCode();
		this.errorMsg = baseErrorInfoInterface.getResultMsg();
	}

	public BizException(Throwable cause, String errorCode, String errorMsg) {
		super(errorCode, cause);
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public synchronized Throwable fillInStackTrace() {
		return super.fillInStackTrace();
	}
}