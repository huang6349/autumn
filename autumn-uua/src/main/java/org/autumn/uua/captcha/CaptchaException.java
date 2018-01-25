package org.autumn.uua.captcha;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;

/**
 * 授权验证码的异常处理器，当用户进行授权验证码校验未能通过的时候，会抛出这个异常
 */
public class CaptchaException extends AuthenticationException {

    private static final long serialVersionUID = 6846651629788435794L;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public CaptchaException(String msg) {
        super(msg);
        logger.error(msg);
    }

    public CaptchaException(String msg, Throwable t) {
        super(msg, t);
        logger.error(msg, t);
    }
}
