package org.autumn.starter.exception;

import org.autumn.commons.domain.ResultEntity;
import org.autumn.commons.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class StarterExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultEntity error(HttpServletRequest request, HttpServletResponse response, Exception e) {
        logger.error("[" + request.getRequestURI() + "]发生错误：" + e.getMessage());
        return ResultUtil.error(e.getMessage());
    }
}
