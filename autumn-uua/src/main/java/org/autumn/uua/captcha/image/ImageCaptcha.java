package org.autumn.uua.captcha.image;

import org.autumn.uua.captcha.Captcha;

import java.awt.image.BufferedImage;

/**
 * 图形验证码的实体类
 */
public class ImageCaptcha extends Captcha {

    private static final long serialVersionUID = -825145745226185454L;

    /**
     * 图形验证码
     */
    private BufferedImage image;

    /**
     * 设置图形验证码
     *
     * @param code     授权验证码
     * @param expireIn 授权验证码的有效期时间（单位：秒）
     * @param image    图形验证码
     */
    public ImageCaptcha(String code, int expireIn, BufferedImage image) {
        super(code, expireIn);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
