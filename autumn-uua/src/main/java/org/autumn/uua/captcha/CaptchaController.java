package org.autumn.uua.captcha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
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

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    /**
     * 注入授权验证码处理器的服务提供类，{@link CaptchaProcessorProvice}接口的实现
     */
    @Autowired
    private CaptchaProcessorProvice captchaProcessorProvice;

    /**
     * 创建验证码，根据验证码的类型不同，调用不同的{@link CaptchaProcessorProvice}接口实现
     *
     * @param request  请求
     * @param response 响应
     * @param type     验证码的类型
     * @throws Exception
     */
    @GetMapping("/captcha/{type}")
    public void create(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {
        try {
            captchaProcessorProvice.findCaptchaProcessor(type).create(new ServletWebRequest(request, response));
        } catch (CaptchaException e) {
            authenticationFailureHandler.onAuthenticationFailure(request, response, e);
            return;
        }
    }
}
