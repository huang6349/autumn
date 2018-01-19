package org.autumn.uua.captcha;

import org.autumn.uua.captcha.enums.CaptchaType;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * 授权验证码的数据访问类接口
 */
public interface CaptchaRepository {

    /**
     * 保存授权验证码
     *
     * @param request 请求
     * @param captcha 授权验证码信息
     * @param type    授权验证码类型
     */
    void save(ServletWebRequest request, Captcha captcha, CaptchaType type);

    /**
     * 获取授权验证码
     *
     * @param request 请求
     * @param type    授权验证码类型
     * @return Captcha
     */
    Captcha get(ServletWebRequest request, CaptchaType type);

    /**
     * 移除授权验证码
     *
     * @param request 请求
     */
    void remove(ServletWebRequest request);
}
