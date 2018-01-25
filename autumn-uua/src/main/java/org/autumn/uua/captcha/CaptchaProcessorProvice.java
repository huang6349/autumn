package org.autumn.uua.captcha;

import org.autumn.uua.captcha.enums.CaptchaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 授权验证码处理器的服务提供类
 */
@Component
public class CaptchaProcessorProvice {

    /**
     * 收集系统中所有的{@link CaptchaProcessor}接口的实现
     */
    @Autowired
    private Map<String, CaptchaProcessor> captchaProcessorMap;

    /**
     * 查找系统中的授权验证码处理器
     *
     * @param type 授权验证码的类型
     * @return CaptchaProcessor
     */
    CaptchaProcessor findCaptchaProcessor(CaptchaType type) {
        return findCaptchaProcessor(type.toString().toLowerCase());
    }

    /**
     * 查找系统中的授权验证码处理器
     *
     * @param type 授权验证码的类型
     * @return CaptchaProcessor
     */
    CaptchaProcessor findCaptchaProcessor(String type) {
        String name = type.toLowerCase() + CaptchaProcessor.class.getSimpleName();
        CaptchaProcessor captchaProcessor = captchaProcessorMap.get(name);
        if (captchaProcessor == null) {
            throw new CaptchaException("验证码处理器[" + name + "]不存在");
        }
        return captchaProcessor;
    }
}
