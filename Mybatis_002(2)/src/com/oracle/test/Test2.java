package com.oracle.test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oracle.mapper.Goods;
import com.oracle.mapper.GoodsMapper;
import com.oracle.vo.SearchVO;

public class Test2 {
	private SqlSession session;
	@Test
	public void test5() {
		GoodsMapper mapper=session.getMapper(GoodsMapper.class);
		PageHelper.startPage(2, 5);
		List<Goods> list=mapper.findAll();
		PageInfo<Goods> info=new PageInfo<Goods>(list);
		System.out.println(list.size());
		for (Goods goods : list) {
			System.out.println(goods.getGoodsId()+"---"+goods.getGoodsName());
		}
	}
	
	@Test
	public void test4() {
		GoodsMapper mapper=session.getMapper(GoodsMapper.class);
		List<Goods> list=new ArrayList<Goods>();
		for (int i = 0; i < 3; i++) {
			Goods g=new Goods();
			g.setGoodsName("aaa"+i);
			g.setGoodsNum(10+i);
			list.add(g);
		}
		mapper.save(list);
		session.commit();
	}
	
	@Test
	public void test3() {
		GoodsMapper mapper=session.getMapper(GoodsMapper.class);
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(89);
		list.add(90);
		list.add(91);
		mapper.delete(list);
		session.commit();
	}
	
	@Test
	public void test2() {
		GoodsMapper mapper=session.getMapper(GoodsMapper.class);
		SearchVO vo=new SearchVO();
		vo.setMaxNum(3000);
		vo.setMinPrice(50f);
		vo.setName("t");
		List<Goods> list=mapper.findByCondtion(vo);
		System.out.println("size:"+list.size());
		for (Goods goods : list) {
			System.out.println(goods.getGoodsName());
		}
	}
	@Test
	public void test() {
		GoodsMapper mapper=session.getMapper(GoodsMapper.class);
		Goods g=new Goods();
		g.setGoodsId(1);
		g.setGoodsPrice(3f);
		g.setGoodsNum(8885);
		g.setGoodsDate(new Date());
		mapper.update(g);
		session.commit();
	}
	@Before
	public void before() {
		try {
			Reader reader=Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactory f=new SqlSessionFactoryBuilder().build(reader);
			session=f.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@After
	public void after() {
		session.close();
	}
}
