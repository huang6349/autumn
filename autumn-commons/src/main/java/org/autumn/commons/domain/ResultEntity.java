package org.autumn.commons.domain;

import java.io.Serializable;

/**
 * 响应客户端请求，返回JSON数据的实体类
 */
public class ResultEntity implements Serializable {

    private static final long serialVersionUID = -5148279655072754735L;

    /**
     * 响应的状态码
     */
    private Integer state;

    /**
     * 响应的信息
     */
    private String message;

    /**
     * 响应的数据
     */
    private Object data;

    public ResultEntity() {
        super();
    }

    public ResultEntity(Integer state, String message) {
        super();
        this.state = state;
        this.message = message;
    }

    public ResultEntity(Integer state, String message, Object data) {
        super();
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
