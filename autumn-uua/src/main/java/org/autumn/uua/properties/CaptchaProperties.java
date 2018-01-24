package org.autumn.uua.properties;

public class CaptchaProperties {

    private String parameter = "code";

    private ImageCaptchaProperties image = new ImageCaptchaProperties();

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public ImageCaptchaProperties getImage() {
        return image;
    }

    public void setImage(ImageCaptchaProperties image) {
        this.image = image;
    }
}
