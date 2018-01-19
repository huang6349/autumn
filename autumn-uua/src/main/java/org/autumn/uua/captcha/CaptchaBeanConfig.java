package org.autumn.uua.captcha;

import org.autumn.uua.captcha.image.ImageCaptchaGenerator;
import org.autumn.uua.captcha.image.ImageCaptchaGetter;
import org.autumn.uua.captcha.image.impl.DefaultImageCaptchaGetter;
import org.autumn.uua.captcha.impl.DefaultCaptchaRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 授权验证码的[baen]配置类
 */
@Configuration
public class CaptchaBeanConfig {

    @Bean
    @ConditionalOnMissingBean(name = "imageCaptchaGenerator")
    public CaptchaGenerator imageCaptchaGenerator() {
        return new ImageCaptchaGenerator();
    }

    @Bean
    @ConditionalOnMissingBean(ImageCaptchaGetter.class)
    public ImageCaptchaGetter imageCaptchaGetter() {
        return new DefaultImageCaptchaGetter();
    }

    @Bean
    @ConditionalOnMissingBean(CaptchaRepository.class)
    public CaptchaRepository captchaRepository() {
        return new DefaultCaptchaRepository();
    }
}
