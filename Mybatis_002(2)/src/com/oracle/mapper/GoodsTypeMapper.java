package com.oracle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oracle.vo.SearchVO;

public interface GoodsTypeMapper {
	public GoodsType findById(Integer typeId);
	public GoodsType findByIdJoinGoods(Integer typeId);
	public GoodsType findByIdJoinGoods2(Integer typeId);
}
