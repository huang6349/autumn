package org.autumn.captcha;

import org.apache.commons.lang.StringUtils;
import org.autumn.domain.ValidateCode;
import org.autumn.repository.ValidateCodeRepository;
import org.autumn.uua.captcha.Captcha;
import org.autumn.uua.captcha.CaptchaException;
import org.autumn.uua.captcha.CaptchaRepository;
import org.autumn.uua.captcha.enums.CaptchaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

@Component
public class ExampleCaptchaRepository implements CaptchaRepository {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static final String CLIENT_ID = "clientId";

    @Autowired
    private ValidateCodeRepository validateCodeRepository;

    @Override
    public void save(ServletWebRequest request, Captcha captcha, CaptchaType type) {
        logger.info("保存授权验证码[" + captcha.getCode() + "]");
        String clientId = buildKey(request);
        ValidateCode validateCode = validateCodeRepository.findByClientId(clientId);
        if (validateCode != null) {
            validateCodeRepository.save(new ValidateCode(validateCode.getId(), clientId, captcha));
        } else {
            validateCodeRepository.save(new ValidateCode(clientId, captcha));
        }
    }

    @Override
    public Captcha get(ServletWebRequest request, CaptchaType type) {
        logger.info("获取授权验证码");
        ValidateCode validateCode = validateCodeRepository.findByClientId(buildKey(request));
        if (validateCode == null) {
            return null;
        }
        return new Captcha(validateCode.getCode(), validateCode.getExpireTime());
    }

    @Override
    public void remove(ServletWebRequest request) {
        logger.info("移除授权验证码");
        ValidateCode validateCode = validateCodeRepository.findByClientId(buildKey(request));
        validateCodeRepository.delete(validateCode);
    }

    private String buildKey(ServletWebRequest request) {
        String clientId = request.getHeader(CLIENT_ID);
        if (StringUtils.isBlank(clientId)) {
            throw new RuntimeException("请在请求头中携带[" + CLIENT_ID + "]参数");
        }
        return clientId;
    }
}
