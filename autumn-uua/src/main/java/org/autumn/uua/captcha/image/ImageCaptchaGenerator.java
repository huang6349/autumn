package org.autumn.uua.captcha.image;

import org.autumn.uua.captcha.Captcha;
import org.autumn.uua.captcha.CaptchaGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageCaptchaGenerator implements CaptchaGenerator {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Captcha generate() {
        logger.error("请继承[CaptchaGenerator]类，实现[imageCaptchaGenerator][bean]，完成图形验证码的生成逻辑");
        throw new NullPointerException();
    }
}
