package com.oracle.mapper;

import java.util.List;
import java.util.Map;

import com.oracle.vo.SearchVO;

public interface GoodsMapper {
	public Goods findById(Integer goodsId);
	public Goods findById2(Integer goodsId);
	public Goods findById3(Integer goodsId);
	public Goods findById4(Integer goodsId);
	public List<Goods> findByTypeId(Integer typeId);
	public List<Goods> findByCondtion(SearchVO vo);
	public List<Goods> findAll();
	
	public void update(Goods g);
	public void delete(List<Integer> list);
	public void save(List<Goods> list);
}
