package org.autumn.utils;

import org.autumn.domain.ResultEntity;

/**
 * 响应客户端请求，返回JSON数据的工具类
 */
final class ResultUtil {

    /**
     * 请求成功，响应的状态码
     */
    private static final int SUCCESS = 200;

    /**
     * 请求失败，响应的状态码
     */
    private static final int ERROR = 500;

    /**
     * 私有构造方法，防止类的实例化，因为工具类不需要实例化
     */
    private ResultUtil() {
        super();
    }

    /**
     * 客户端请求成功，响应的数据
     *
     * @param data 请求成功，响应的数据
     * @return ResultEntity
     */
    static ResultEntity success(Object data) {
        return new ResultEntity(SUCCESS, "请求成功", data);
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @return ResultEntity
     */
    static ResultEntity error() {
        return new ResultEntity(ERROR, "请求失败");
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @param message 请求失败，响应的信息
     * @return ResultEntity
     */
    static ResultEntity error(String message) {
        return new ResultEntity(ERROR, message);
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @param state 请求失败，响应的状态码
     * @return ResultEntity
     */
    static ResultEntity error(Integer state) {
        return new ResultEntity(state, "请求失败");
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @param state   请求失败，响应的状态码
     * @param message 请求失败，响应的信息
     * @return ResultEntity
     */
    static ResultEntity error(Integer state, String message) {
        return new ResultEntity(state, message);
    }

    /**
     * 客户端请求失败，响应的数据
     *
     * @param state   请求失败，响应的状态码
     * @param message 请求失败，响应的信息
     * @param data    请求失败，响应的数据
     * @return ResultEntity
     */
    static ResultEntity error(Integer state, String message, Object data) {
        return new ResultEntity(state, message, data);
    }
}
