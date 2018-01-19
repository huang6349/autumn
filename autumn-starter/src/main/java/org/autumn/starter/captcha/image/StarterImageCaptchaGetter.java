package org.autumn.starter.captcha.image;

import org.autumn.uua.captcha.image.ImageCaptcha;
import org.autumn.uua.captcha.image.ImageCaptchaGetter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import java.io.IOException;

@Component
public class StarterImageCaptchaGetter implements ImageCaptchaGetter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void get(ServletWebRequest request, ImageCaptcha imageCaptcha) throws IOException {
        logger.info("完成图形验证码的获取");
        ServletOutputStream out = request.getResponse().getOutputStream();
        ImageIO.write(imageCaptcha.getImage(), "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
    }
}
