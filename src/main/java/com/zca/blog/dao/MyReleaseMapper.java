package com.zca.blog.dao;

import com.zca.blog.entities.MyRelease;
import com.zca.blog.vo.LookUpReleaseVo;

import java.util.List;

public interface MyReleaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MyRelease record);

    int insertSelective(MyRelease record);

    MyRelease selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MyRelease record);

    int updateByPrimaryKeyWithBLOBs(MyRelease record);

    int updateByPrimaryKey(MyRelease record);

    List<MyRelease> selectAll();

    List<MyRelease> selectRelease(LookUpReleaseVo vo);

}