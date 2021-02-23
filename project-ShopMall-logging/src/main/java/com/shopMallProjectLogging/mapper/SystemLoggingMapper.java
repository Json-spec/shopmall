package com.shopMallProjectLogging.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.shopMallProjectlogging.model.SysLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SystemLoggingMapper extends BaseMapper<SysLog> {

    //int insertSelective(SysLog sysLog);
}
