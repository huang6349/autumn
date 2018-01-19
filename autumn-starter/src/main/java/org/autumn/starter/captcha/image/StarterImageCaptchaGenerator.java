package org.autumn.starter.captcha.image;

import com.google.code.kaptcha.Producer;
import org.autumn.uua.captcha.Captcha;
import org.autumn.uua.captcha.CaptchaGenerator;
import org.autumn.uua.captcha.image.ImageCaptcha;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;

@Component(value = "imageCaptchaGenerator")
public class StarterImageCaptchaGenerator implements CaptchaGenerator {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private Producer defaultKaptcha;

    @Override
    public Captcha generate() {
        logger.info("完成图形验证码的生成");
        String capText = defaultKaptcha.createText();
        int expireIn = 300;
        BufferedImage bi = defaultKaptcha.createImage(capText);
        return new ImageCaptcha(capText, expireIn, bi);
    }
}
