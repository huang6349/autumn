package org.autumn.uua.captcha.impl;

import org.autumn.uua.captcha.Captcha;
import org.autumn.uua.captcha.CaptchaRepository;
import org.autumn.uua.captcha.enums.CaptchaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.ServletWebRequest;

public class DefaultCaptchaRepository implements CaptchaRepository {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void save(ServletWebRequest request, Captcha captcha, CaptchaType type) {
        logger.error("请实现[CaptchaRepository]类，完成验证码的保存逻辑");
        throw new NullPointerException();
    }

    @Override
    public Captcha get(ServletWebRequest request, CaptchaType type) {
        logger.error("请实现[CaptchaRepository]类，完成验证码的获取逻辑");
        throw new NullPointerException();
    }

    @Override
    public void remove(ServletWebRequest request) {
        logger.error("请实现[CaptchaRepository]类，完成验证码的移除逻辑");
        throw new NullPointerException();
    }
}
