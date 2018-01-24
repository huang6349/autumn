package org.autumn.uua.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "autumn.security")
public class SecurityProperties {

    private CaptchaProperties captcha = new CaptchaProperties();

    public CaptchaProperties getCaptcha() {
        return captcha;
    }

    public void setCaptcha(CaptchaProperties captcha) {
        this.captcha = captcha;
    }
}
