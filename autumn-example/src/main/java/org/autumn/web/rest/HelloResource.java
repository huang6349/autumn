package org.autumn.web.rest;

import org.autumn.domain.Hello;
import org.autumn.repository.HelloRepository;
import org.autumn.uua.domain.ResultEntity;
import org.autumn.uua.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class HelloResource {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private HelloRepository helloRepository;

    @PostMapping("/hello")
    public ResultEntity create(@Valid @RequestBody Hello hello) {
        logger.debug("添加数据", hello);
        Hello result = helloRepository.save(hello);
        return ResultUtil.success(result);
    }

    @DeleteMapping("/hello/{id}")
    public ResultEntity delete(@PathVariable Long id) {
        logger.debug("删除数据", id);
        helloRepository.delete(id);
        return ResultUtil.success();
    }

    @GetMapping("/hello")
    public ResultEntity getAll(Pageable pageable) {
        logger.debug("分页查询数据");
        Page<Hello> hellos = helloRepository.findAll(pageable);
        return ResultUtil.success(hellos);
    }

    @GetMapping("/hello/{id}")
    public ResultEntity getById(@PathVariable Long id) {
        logger.debug("根据编号查询数据", id);
        Hello hello = helloRepository.findOne(id);
        return ResultUtil.success(hello);
    }

    @PutMapping("/hello")
    public ResultEntity update(@Valid @RequestBody Hello hello) {
        logger.debug("修改数据", hello);
        Hello result = helloRepository.save(hello);
        return ResultUtil.success(result);
    }
}
