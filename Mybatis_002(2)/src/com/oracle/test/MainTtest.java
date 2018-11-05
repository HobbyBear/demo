package com.oracle.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.oracle.mapper.Goods;
import com.oracle.mapper.GoodsMapper;
import com.oracle.mapper.GoodsType;
import com.oracle.mapper.GoodsTypeMapper;
import com.oracle.mapper.UserMapper;
import com.oracle.mapper.Users;
import com.oracle.vo.SearchVO;

public class MainTtest {
	private SqlSession session;
	
	@Test
	public void test5_2() {
		GoodsTypeMapper mapper=session.getMapper(GoodsTypeMapper.class);
		GoodsType g=mapper.findByIdJoinGoods2(2);
		System.out.println(g.getTypeName());
		System.out.println(g.getGoodsList2()+"-----");
		List<Goods> list=g.getGoodsList2();
		for (Goods goods : list) {
			System.out.println(goods.getGoodsName());
			
		}
	}
	@Test
	public void test5_1() {
		GoodsTypeMapper mapper=session.getMapper(GoodsTypeMapper.class);
		GoodsType g=mapper.findByIdJoinGoods(1);
		System.out.println(g.getTypeName());
		System.out.println(g.getGoodsList()+"-----");
		List<Goods> list=g.getGoodsList();
		for (Goods goods : list) {
			System.out.println(goods.getGoodsName());
			
		}
	}
	
	@Test
	public void test7() {
		GoodsMapper mapper=session.getMapper(GoodsMapper.class);
		List<Goods> list=mapper.findByTypeId(2);
		for (Goods goods : list) {
			System.out.println(goods.getGoodsName());
		}
	}
	
	@Test
	public void test5() {
		GoodsTypeMapper mapper=session.getMapper(GoodsTypeMapper.class);
		GoodsType g=mapper.findById(1);
		System.out.println(g.getTypeName());
	}
	
	@Test
	public void test4_2() {
		GoodsMapper mapper=session.getMapper(GoodsMapper.class);
		Goods g=mapper.findById2(1);
		System.out.println(g.getGoodsName()+"------"+g.getGoodsType());
		System.out.println(g.getType1().getTypeName());
	}
	
	@Test
	public void test4_3() {
		GoodsMapper mapper=session.getMapper(GoodsMapper.class);
		Goods g=mapper.findById3(1);
		System.out.println(g.getGoodsName()+"------"+g.getGoodsType());
		System.out.println(g.getType1().getTypeName());
		System.out.println(g.getType2().getTypeName());
	}
	
	@Test
	public void test4_4() {
		GoodsMapper mapper=session.getMapper(GoodsMapper.class);
		Goods g=mapper.findById4(1);
		System.out.println(g.getGoodsName()+"------"+g.getGoodsType());
		System.out.println(g.getType1());
		System.out.println(g.getType2());
		System.out.println(g.getType3().getTypeName());
	}
	
	@Test
	public void test4() {
		GoodsMapper mapper=session.getMapper(GoodsMapper.class);
		Goods g=mapper.findById(1);
		
		System.out.println(g.getGoodsName()+"------"+g.getGoodsType());
		System.out.println("------"+g.getType1());
	}
	@Test
	public void test3() {
		UserMapper mapper=session.getMapper(UserMapper.class);
		SearchVO vo=new SearchVO();
		List<Users> u=mapper.findByCondition(vo);
		System.out.println(u.size());
	}
	@Test
	public void test2() {
		UserMapper mapper=session.getMapper(UserMapper.class);
		Users u=mapper.login2("qq", "qq");
		System.out.println(u.getUserName());
	}

	@Test
	public void test() {
		UserMapper mapper=session.getMapper(UserMapper.class);
		Users u=mapper.findById(1);
		System.out.println(u.getUserName());
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
