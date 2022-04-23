package org.cwsya.tadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.cwsya.tadmin.pojo.PO.UserAllEntity;
import org.cwsya.tadmin.pojo.VO.UserEntity;

@Mapper
public interface UserAllMapper extends BaseMapper<UserAllEntity> {
    UserAllEntity selectUserAll(UserEntity userEntity);
}
