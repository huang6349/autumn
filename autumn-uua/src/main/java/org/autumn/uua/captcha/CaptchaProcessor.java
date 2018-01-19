package org.autumn.uua.captcha;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 授权验证码的处理器接口类
 */
public interface CaptchaProcessor {

    /**
     * 创建授权验证码
     *
     * @param request 请求
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;

    /**
     * 校验授权验证码
     *
     * @param request 请求
     */
    void validate(ServletWebRequest request);
}
