package org.autumn.uua.captcha.image.impl;

import org.autumn.uua.captcha.image.ImageCaptcha;
import org.autumn.uua.captcha.image.ImageCaptchaGetter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;

public class DefaultImageCaptchaGetter implements ImageCaptchaGetter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void get(ServletWebRequest request, ImageCaptcha imageCaptcha) throws IOException {
        logger.error("请实现[ImageCaptchaGetter]类，完成图形验证码的获取逻辑");
        throw new NullPointerException();
    }
}
