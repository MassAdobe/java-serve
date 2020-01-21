package com.massadobe.means.demo.dao;

import com.massadobe.means.demo.entity.DataDict;
import com.massadobe.means.demo.tk.mybatis.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DataDictMapper extends MyMapper<DataDict> {
}