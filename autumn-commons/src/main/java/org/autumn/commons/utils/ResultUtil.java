package org.autumn.commons.utils;

import org.apache.commons.lang.StringUtils;
import org.autumn.commons.domain.ResultEntity;
import org.autumn.commons.enums.Result;

/**
 * 响应客户端请求，返回JSON数据的工具类
 */
public final class ResultUtil {

    /**
     * 私有构造方法，防止类的实例化，因为工具类不需要实例化
     */
    private ResultUtil() {
        super();
    }

    /**
     * 客户端请求成功，响应的数据
     *
     * @return ResultEntity
     */
    public static ResultEntity success() {
        return request(Type.SUCCESS, Result.Type.DEFAULT, null, null, null);
    }

    /**
     * 客户端请求成功，响应的数据
     *
     * @param type 请求类型
     * @return ResultEntity
     */
    public static ResultEntity success(Result.Type type) {
        return request(Type.SUCCESS, type, null, null, null);
    }

    /**
     * 客户端请求成功，响应的数据
     *
     * @param data 请求成功，响应的数据
     * @return ResultEntity
     */
    public static ResultEntity success(Object data) {
        return request(Type.SUCCESS, Result.Type.DEFAULT, null, null, data);
    }

    /**
     * 客户端请求成功，响应的数据
     *
     * @param type 请求类型
     * @param data 请求成功，响应的数据
     * @return ResultEntity
     */
    public static ResultEntity success(Result.Type type, Object data) {
        return request(Type.SUCCESS, type, null, null, data);
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @return ResultEntity
     */
    public static ResultEntity error() {
        return request(Type.ERROR, Result.Type.DEFAULT, null, null, null);
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @param type 请求类型
     * @return ResultEntity
     */
    public static ResultEntity error(Result.Type type) {
        return request(Type.ERROR, type, null, null, null);
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @param state 请求失败，响应的状态码
     * @return ResultEntity
     */
    public static ResultEntity error(Integer state) {
        return request(Type.ERROR, Result.Type.DEFAULT, state, null, null);
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @param type  请求类型
     * @param state 请求失败，响应的信息
     * @return ResultEntity
     */
    public static ResultEntity error(Result.Type type, Integer state) {
        return request(Type.ERROR, type, state, null, null);
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @param message 请求失败，响应的信息
     * @return ResultEntity
     */
    public static ResultEntity error(String message) {
        return request(Type.ERROR, Result.Type.DEFAULT, null, message, null);
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @param state   请求失败，响应的状态码
     * @param message 请求失败，响应的信息
     * @return ResultEntity
     */
    public static ResultEntity error(Integer state, String message) {
        return request(Type.ERROR, Result.Type.DEFAULT, state, message, null);
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @param state   请求失败，响应的状态码
     * @param message 请求失败，响应的信息
     * @param data    请求失败，响应的数据
     * @return ResultEntity
     */
    public static ResultEntity error(Integer state, String message, Object data) {
        return request(Type.ERROR, Result.Type.DEFAULT, state, message, data);
    }

    /**
     * 请求是否成功
     */
    private enum Type {
        // 请求成功
        SUCCESS(0),
        // 请求失败
        ERROR(1);

        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 客户端请求，响应的数据
     *
     * @param bool    请求是否成功
     * @param type    请求类型
     * @param state   响应的状态码
     * @param message 响应的信息
     * @param data    响应的数据
     * @return ResultEntity
     */
    private static ResultEntity request(Type bool, Result.Type type, Integer state, String message, Object data) {
        switch (type) {
            case POST:
                state = (state == null) ? ((Type.SUCCESS == bool) ? Result.SUCCESS_POST.getState() : Result.ERROR_POST.getState()) : state;
                message = StringUtils.isBlank(message) ? ((Type.SUCCESS == bool) ? Result.SUCCESS_POST.getMessage() : Result.ERROR_POST.getMessage()) : message;
                break;
            case DELETE:
                state = (state == null) ? ((Type.SUCCESS == bool) ? Result.SUCCESS_DELETE.getState() : Result.ERROR_DELETE.getState()) : state;
                message = StringUtils.isBlank(message) ? ((Type.SUCCESS == bool) ? Result.SUCCESS_DELETE.getMessage() : Result.ERROR_DELETE.getMessage()) : message;
                break;
            case GET:
                state = (state == null) ? ((Type.SUCCESS == bool) ? Result.SUCCESS_GET.getState() : Result.ERROR_GET.getState()) : state;
                message = StringUtils.isBlank(message) ? ((Type.SUCCESS == bool) ? Result.SUCCESS_GET.getMessage() : Result.ERROR_GET.getMessage()) : message;
                break;
            case PUT:
                state = (state == null) ? ((Type.SUCCESS == bool) ? Result.SUCCESS_PUT.getState() : Result.ERROR_PUT.getState()) : state;
                message = StringUtils.isBlank(message) ? ((Type.SUCCESS == bool) ? Result.SUCCESS_PUT.getMessage() : Result.ERROR_PUT.getMessage()) : message;
                break;
            default:
                state = (state == null) ? ((Type.SUCCESS == bool) ? Result.SUCCESS.getState() : Result.ERROR.getState()) : state;
                message = StringUtils.isBlank(message) ? ((Type.SUCCESS == bool) ? Result.SUCCESS.getMessage() : Result.ERROR.getMessage()) : message;
        }
        return new ResultEntity(state, message, data);
    }
}
