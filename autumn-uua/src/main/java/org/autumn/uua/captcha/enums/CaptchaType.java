package org.autumn.uua.captcha.enums;

/**
 * 授权验证码类型的枚举类
 */
public enum CaptchaType {
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return "imageCode";
        }

        @Override
        public String getParamNoteOnValidate() {
            return "图形验证码";
        }
    };

    public abstract String getParamNameOnValidate();

    public abstract String getParamNoteOnValidate();
}
