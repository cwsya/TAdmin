package org.cwsya.tadmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.cwsya.tadmin.pojo.PO.UserEntity;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}
