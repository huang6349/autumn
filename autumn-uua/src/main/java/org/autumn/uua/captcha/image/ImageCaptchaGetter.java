package org.autumn.uua.captcha.image;

import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;

public interface ImageCaptchaGetter {

    void get(ServletWebRequest request, ImageCaptcha imageCaptcha) throws IOException;
}
