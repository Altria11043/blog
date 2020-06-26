package com.zca.blog.serive;

import com.zca.blog.entities.MyRelease;
import com.zca.blog.vo.ReleaseVo;
import com.zca.blog.vo.ReleaseTableVo;

import java.util.List;

public interface IMyReleaseService {

    Integer addRelease(ReleaseVo vo);

    List<ReleaseTableVo> getTitleAndTag();

    MyRelease getRelease(Integer Id);

    Integer updateRelease(ReleaseVo vo);

    List<ReleaseTableVo> getReleaseTable();
}
