package com.zca.blog.serive.impl;

import com.zca.blog.dao.MyReleaseMapper;
import com.zca.blog.entities.MyRelease;
import com.zca.blog.serive.IMyReleaseService;
import com.zca.blog.vo.LookUpReleaseVo;
import com.zca.blog.vo.ReleaseVo;
import com.zca.blog.vo.ReleaseTableVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Altria
 * Date: 2020/6/19 13:54
 */
@Service
public class MyReleaseServiceImpl implements IMyReleaseService {

    @Resource
    private MyReleaseMapper releaseMapper;

    @Override
    public Integer addRelease(ReleaseVo vo) {
        MyRelease release = new MyRelease();
        BeanUtils.copyProperties(vo, release);
        String tag = "";
        for (String s : vo.getListTag()) {
            tag = tag + ";" + s;
        }
        String substring = tag.substring(1);
        release.setCTag(substring);
        return releaseMapper.insertSelective(release);
    }

    @Override
    public List<ReleaseTableVo> getTitleAndTag() {
        List<MyRelease> myReleases = releaseMapper.selectAll();
        List<ReleaseTableVo> tt = myReleases.stream().map(data -> {
            ReleaseTableVo releaseTableVo = new ReleaseTableVo();
            releaseTableVo.setTitle(data.getTitle());
            releaseTableVo.setId(data.getId());
            List<String> strings = Arrays.asList(data.getCTag().split(";"));
            releaseTableVo.setListTag(strings);
            return releaseTableVo;
        }).collect(Collectors.toList());
        return tt;
    }

    @Override
    public MyRelease getRelease(Integer Id) {
        MyRelease release = releaseMapper.selectByPrimaryKey(Id);
        return release;
    }

    @Override
    public Integer updateRelease(ReleaseVo vo) {
        MyRelease release = new MyRelease();
        BeanUtils.copyProperties(vo, release);
        String tag = "";
        for (String s : vo.getListTag()) {
            tag = tag + ";" + s;
        }
        String substring = tag.substring(1);
        release.setCTag(substring);
        return releaseMapper.updateByPrimaryKeySelective(release);
    }

    @Override
    public List<ReleaseTableVo> getReleaseTable(LookUpReleaseVo vo) {

        List<MyRelease> myReleases = releaseMapper.selectRelease(vo);
        List<ReleaseTableVo> tt = myReleases.stream().map(data -> {
            ReleaseTableVo releaseTableVo = new ReleaseTableVo();
            releaseTableVo.setTitle(data.getTitle());
            releaseTableVo.setId(data.getId());
            releaseTableVo.setState(data.getState());
            List<String> strings = Arrays.asList(data.getCTag().split(";"));
            releaseTableVo.setListTag(strings);
            return releaseTableVo;
        }).collect(Collectors.toList());
        return tt;
    }

    @Override
    public Integer updateState(ReleaseVo vo) {
        MyRelease release = new MyRelease();
        release.setId(vo.getId());
        release.setState(vo.getState());
        return releaseMapper.updateByPrimaryKeySelective(release);
    }
}
