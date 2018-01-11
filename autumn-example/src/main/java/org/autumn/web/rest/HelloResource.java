package org.autumn.web.rest;

import org.autumn.uua.domain.ResultEntity;
import org.autumn.uua.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloResource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/hello/{id}")
    public ResultEntity getById(@PathVariable Long id) {
        logger.debug("根据编号查询数据", id);
        return ResultUtil.success(id);
    }
}
