package org.autumn.uua.captcha;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 授权验证码的实体类，授权验证码的创建和校验都会用到它
 */
public class Captcha implements Serializable {

    private static final long serialVersionUID = -6031870407057896469L;

    /**
     * 授权验证码
     */
    private String code;

    /**
     * 授权验证码的到期时间
     */
    private LocalDateTime expireTime;

    /**
     * 设置验证码
     *
     * @param code     授权验证码
     * @param expireIn 授权验证码的有效期时间（单位：秒）
     */
    public Captcha(String code, int expireIn) {
        super();
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    /**
     * 设置验证码
     *
     * @param code       授权验证码
     * @param expireTime 授权验证码的到期时间
     */
    public Captcha(String code, LocalDateTime expireTime) {
        super();
        this.code = code;
        this.expireTime = expireTime;
    }

    /**
     * 判断验证码是否过期
     *
     * @return boolean
     */
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(this.expireTime);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
