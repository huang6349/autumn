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
        return request(Result.Network.SUCCESS, Result.Type.DEFAULT, null, null, null);
    }

    /**
     * 客户端请求成功，响应的数据
     *
     * @param type 请求类型
     * @return ResultEntity
     */
    public static ResultEntity success(Result.Type type) {
        return request(Result.Network.SUCCESS, type, null, null, null);
    }

    /**
     * 客户端请求成功，响应的数据
     *
     * @param data 请求成功，响应的数据
     * @return ResultEntity
     */
    public static ResultEntity success(Object data) {
        return request(Result.Network.SUCCESS, Result.Type.DEFAULT, null, null, data);
    }

    /**
     * 客户端请求成功，响应的数据
     *
     * @param type 请求类型
     * @param data 请求成功，响应的数据
     * @return ResultEntity
     */
    public static ResultEntity success(Result.Type type, Object data) {
        return request(Result.Network.SUCCESS, type, null, null, data);
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @return ResultEntity
     */
    public static ResultEntity error() {
        return request(Result.Network.ERROR, Result.Type.DEFAULT, null, null, null);
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @param type 请求类型
     * @return ResultEntity
     */
    public static ResultEntity error(Result.Type type) {
        return request(Result.Network.ERROR, type, null, null, null);
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @param state 请求失败，响应的状态码
     * @return ResultEntity
     */
    public static ResultEntity error(Integer state) {
        return request(Result.Network.ERROR, Result.Type.DEFAULT, state, null, null);
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @param type  请求类型
     * @param state 请求失败，响应的信息
     * @return ResultEntity
     */
    public static ResultEntity error(Result.Type type, Integer state) {
        return request(Result.Network.ERROR, type, state, null, null);
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @param message 请求失败，响应的信息
     * @return ResultEntity
     */
    public static ResultEntity error(String message) {
        return request(Result.Network.ERROR, Result.Type.DEFAULT, null, message, null);
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @param state   请求失败，响应的状态码
     * @param message 请求失败，响应的信息
     * @return ResultEntity
     */
    public static ResultEntity error(Integer state, String message) {
        return request(Result.Network.ERROR, Result.Type.DEFAULT, state, message, null);
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
        return request(Result.Network.ERROR, Result.Type.DEFAULT, state, message, data);
    }

    /**
     * 客户端请求，响应的数据
     *
     * @param network 请求是否成功
     * @param type    请求类型
     * @param state   响应的状态码
     * @param message 响应的信息
     * @param data    响应的数据
     * @return ResultEntity
     */
    private static ResultEntity request(Result.Network network, Result.Type type, Integer state, String message, Object data) {
        return new ResultEntity(type.getState(network, state), type.getMessage(network, message), data);
    }
}
