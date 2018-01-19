package org.autumn.domain;

import org.autumn.uua.captcha.Captcha;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_VALIDATE_CODE")
public class ValidateCode implements Serializable {

    private static final long serialVersionUID = 1057540337303322585L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(max = 188)
    @Column(name = "clientId", length = 188, unique = true)
    private String clientId;

    @Size(max = 188)
    @Column(name = "code", length = 188)
    private String code;

    @Column(name = "expireTime")
    private LocalDateTime expireTime;

    public ValidateCode() {
        super();
    }

    public ValidateCode(String clientId, Captcha captcha) {
        this.clientId = clientId;
        this.code = captcha.getCode();
        this.expireTime = captcha.getExpireTime();
    }

    public ValidateCode(Long id, String clientId, Captcha captcha) {
        this.id = id;
        this.clientId = clientId;
        this.code = captcha.getCode();
        this.expireTime = captcha.getExpireTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
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
