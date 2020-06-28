package com.zca.blog.controller;

import com.zca.blog.comment.R;
import com.zca.blog.entities.MyRelease;
import com.zca.blog.serive.IMyReleaseService;
import com.zca.blog.vo.LookUpReleaseVo;
import com.zca.blog.vo.ReleaseVo;
import com.zca.blog.vo.ReleaseTableVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Altria
 * Date: 2020/6/19 13:51
 */
@RestController
@RequestMapping("/release")
@Slf4j
public class MyReleaseController {

    @Autowired
    private IMyReleaseService releaseService;

    @PostMapping("/add")
    public R addRelease(@RequestBody ReleaseVo vo) {
        Integer res = releaseService.addRelease(vo);
        return R.ok().put("data", res);
    }

    /**
     * 获取到当前的所有文章标题和标签, 用于首页展示
     * @return
     */
    @GetMapping("/getTitleAndTag")
    public R getTitleAndTag() {
        List<ReleaseTableVo> tt = releaseService.getTitleAndTag();
        return R.ok().put("data", tt);
    }

//    @RequestParam(required = false)
    @GetMapping("/getReleaseTable")
    public R getReleaseTable(LookUpReleaseVo vo) {
        log.info("查询内容: {}", vo);
        List<ReleaseTableVo> vos = releaseService.getReleaseTable(vo);
        return R.ok().put("data", vos);
    }

    /**
     * 获取到当个文章的数据
     * @param id
     * @return
     */
    @GetMapping("/get")
    public R getRelease(@RequestParam("id") Integer id) {
        MyRelease release = releaseService.getRelease(id);
        return R.ok().put("data", release);
    }

    @PostMapping("/update")
    public R updateRelease(@RequestBody ReleaseVo vo) {
        Integer res = releaseService.updateRelease(vo);
        return R.ok().put("data", res);
    }

    @PostMapping("/state")
    public R updataState(@RequestBody ReleaseVo vo) {
        Integer res = releaseService.updateState(vo);
        return R.ok().put("data", res);
    }

}
