package com.example.demo.exception;

import com.example.demo.util.ResultBody;
import com.example.demo.util.CommonEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lyd
 * @Description:自定义全局异常处理类
 * @date 16:12
 */
@ControllerAdvice
public class MyExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

	/**
	 * 自定义的业务异常处理程序
	 *
	 * @param httpServletRequest http servlet请求
	 * @param ex
	 * @return {@link ResultBody}
	 */
	@ExceptionHandler(value = BizException.class)
	@ResponseBody
	public ResultBody bizExceptionHandler(HttpServletRequest httpServletRequest, BizException ex) {
		logger.error("啦啦啦啦啦发生业务异常，原因是：" + ex.getErrorMsg());
		return ResultBody.error(ex.getErrorCode(), ex.getErrorMsg());
	}

	/**
	 * 空指针异常处理程序
	 *
	 * @param req 要求的事情
	 * @param e   e
	 * @return {@link ResultBody}
	 */
	@ExceptionHandler(value = NullPointerException.class)
	@ResponseBody
	public ResultBody exceptionHandler(HttpServletRequest req, NullPointerException e) {
		logger.error("啦啦啦啦发生空指针异常！原因是:", e);
		return ResultBody.error(CommonEnum.BODY_NOT_MATCH);
	}

	/**
	 * 其他异常处理程序
	 *
	 * @param req 要求的事情
	 * @param e   e
	 * @return {@link ResultBody}
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResultBody exceptionHandler(HttpServletRequest req, Exception e) {
		logger.error("啦啦啦啦发生未知异常！原因是:", e);
		return ResultBody.error(CommonEnum.INTERNAL_SERVER_ERROR);
	}

}