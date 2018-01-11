package org.autumn.utils;

import org.autumn.domain.ResultEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ResultUtilTest {

    /**
     * 测试[客户端请求成功，响应的数据]
     *
     * @throws Exception
     */
    @Test
    public void success() throws Exception {
        int data1 = 1;
        this.console(ResultUtil.success(data1));
        String data2 = "1";
        this.console(ResultUtil.success(data2));
        List<String> data3 = new ArrayList<>();
        data3.add("1");
        data3.add("2");
        data3.add("3");
        this.console(ResultUtil.success(data3));
        for (int i = 0; i <= 9999; i++) {
            this.console(ResultUtil.success("高性能测试" + i));
        }
    }

    /**
     * 测试[客户端请求失败，响应的数据]
     *
     * @throws Exception
     */
    @Test
    public void error() throws Exception {
        this.console(ResultUtil.error());
        this.console(ResultUtil.error("用户不存在"));
        this.console(ResultUtil.error(400));
        this.console(ResultUtil.error(400, "用户不存在"));
        List<String> data = new ArrayList<>();
        data.add("1");
        data.add("2");
        data.add("3");
        this.console(ResultUtil.error(400, "用户不存在", data));
    }

    /**
     * 打印响应的数据
     *
     * @param resultEntity 响应数据的实体类
     */
    private void console(ResultEntity resultEntity) {
        System.out.print("state:" + resultEntity.getState());
        System.out.print(",");
        System.out.print("message:" + resultEntity.getMessage());
        System.out.print(",");
        System.out.println("data:" + resultEntity.getData());
    }
}
