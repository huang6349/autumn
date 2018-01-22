package org.autumn.uua.captcha;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import org.autumn.commons.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 授权验证码的控制器类
 */
@RestController
public class CaptchaController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 注入授权验证码处理器的服务提供类，{@link CaptchaProcessorProvice}接口的实现
     */
    @Autowired
    private CaptchaProcessorProvice captchaProcessorProvice;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 创建授权验证码，根据验证码的类型不同，调用不同的{@link CaptchaProcessorProvice}接口实现
     *
     * @param request  请求
     * @param response 响应
     * @param type     验证码的类型
     * @throws Exception
     */
    @GetMapping("/captcha/{type}")
    public void create(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {
        logger.error("调用[" + StringUtils.upperCase(type) + "]授权验证码处理器");
        try {
            captchaProcessorProvice.findCaptchaProcessor(type).create(new ServletWebRequest(request, response));
        } catch (Exception e) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(ResultUtil.error(e.getMessage())));
            return;
        }
    }
}
