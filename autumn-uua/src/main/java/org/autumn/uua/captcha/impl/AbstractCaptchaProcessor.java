package org.autumn.uua.captcha.impl;

import org.apache.commons.lang.StringUtils;
import org.autumn.uua.captcha.*;
import org.autumn.uua.captcha.enums.CaptchaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Map;

/**
 * 授权验证码的处理器抽象实现类
 *
 * @param <T>
 */
public abstract class AbstractCaptchaProcessor<T extends Captcha> implements CaptchaProcessor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 收集系统中所有的{@link CaptchaGenerator}接口的实现
     */
    @Autowired
    private Map<String, CaptchaGenerator> captchaGeneratorMap;

    /**
     * 注入授权验证码的数据访问类，{@link CaptchaRepository}接口的实现
     */
    @Autowired
    private CaptchaRepository captchaRepository;

    /**
     * 创建授权验证码
     *
     * @param request 请求
     * @throws Exception
     */
    @Override
    public void create(ServletWebRequest request) throws Exception {
        logger.info("创建授权验证码");
        T t = generate();
        save(request, t);
        send(request, t);
    }

    /**
     * 校验授权验证码
     *
     * @param request 请求
     */
    @Override
    public void validate(ServletWebRequest request) {
        logger.info("校验授权验证码");
        CaptchaType type = getCaptchaType();
        T t = (T) captchaRepository.get(request, type);
        String codeInRequest;
        try {
            codeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(), type.getParamNameOnValidate());
        } catch (ServletRequestBindingException e) {
            e.printStackTrace();
            throw new CaptchaException(type.getParamNoteOnValidate() + "获取失败");
        }
        if (StringUtils.isBlank(codeInRequest)) {
            throw new CaptchaException(type.getParamNoteOnValidate() + "不能为空");
        }
        if (t == null) {
            throw new CaptchaException(type.getParamNoteOnValidate() + "不存在");
        }
        if (t.isExpried()) {
            captchaRepository.remove(request);
            throw new CaptchaException(type.getParamNoteOnValidate() + "已经过期");
        }
        if (!StringUtils.equalsIgnoreCase(t.getCode(), codeInRequest)) {
            throw new CaptchaException(type.getParamNoteOnValidate() + "填写错误");
        }
        captchaRepository.remove(request);
    }

    /**
     * 生成授权验证码
     *
     * @return T
     */
    private T generate() {
        String generatorName = getCaptchaType().toString().toLowerCase() + CaptchaGenerator.class.getSimpleName();
        CaptchaGenerator captchaGenerator = captchaGeneratorMap.get(generatorName);
        if (captchaGenerator == null) {
            throw new CaptchaException("授权验证码生成器[" + generatorName + "]不存在");
        }
        return (T) captchaGenerator.generate();
    }

    /**
     * 获取授权验证码的类型
     *
     * @return CaptchaType
     */
    private CaptchaType getCaptchaType() {
        return CaptchaType.valueOf(StringUtils.substringBefore(getClass().getSimpleName(), CaptchaProcessor.class.getSimpleName()).toUpperCase());
    }

    /**
     * 保存授权验证码
     *
     * @param request 请求
     * @param t       授权验证码的信息
     */
    private void save(ServletWebRequest request, T t) {
        captchaRepository.save(request, t, getCaptchaType());
    }

    /**
     * 发送授权验证码
     *
     * @param request 请求
     * @param t       授权验证码的信息
     * @throws Exception
     */
    protected abstract void send(ServletWebRequest request, T t) throws Exception;
}
