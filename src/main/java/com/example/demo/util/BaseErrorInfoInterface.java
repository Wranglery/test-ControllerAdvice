package com.example.demo.util;

/**
 * @author lyd
 * @Description:
 * @date 16:15
 */
public interface BaseErrorInfoInterface {


	/**
	 * 得到错误码
	 *
	 * @return {@link String}
	 */
	String getResultCode();

	/**
	 * 得到错误信息
	 *
	 * @return {@link String}
	 */
	String getResultMsg();

}
