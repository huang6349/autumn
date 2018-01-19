package org.autumn.uua.captcha.image;

import org.autumn.uua.captcha.impl.AbstractCaptchaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

@Component("imageCaptchaProcessor")
public class ImageCaptchaProcessor extends AbstractCaptchaProcessor<ImageCaptcha> {

    @Autowired
    private ImageCaptchaGetter imageCaptchaGetter;

    @Override
    protected void send(ServletWebRequest request, ImageCaptcha imageCaptcha) throws Exception {
        imageCaptchaGetter.get(request, imageCaptcha);
    }
}
