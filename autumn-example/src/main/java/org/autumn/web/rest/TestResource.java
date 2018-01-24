package org.autumn.web.rest;

import org.autumn.commons.domain.ResultEntity;
import org.autumn.commons.enums.Result;
import org.autumn.commons.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestResource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PostMapping("/test")
    public ResultEntity create() {
        logger.debug("添加数据");
        return ResultUtil.success(Result.Type.POST);
    }
}
