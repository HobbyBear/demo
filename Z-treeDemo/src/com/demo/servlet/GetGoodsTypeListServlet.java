package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.demo.service.GoodsTypeService;
import com.demo.vo.TreeVo;

@WebServlet("/getGoodsTypeList.do")
public class GetGoodsTypeListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsTypeService goodsTypeService = new GoodsTypeService();
		List<TreeVo> treeVosList = new ArrayList<TreeVo>();
		String pid = request.getParameter("id");
		if (pid == null) {
			treeVosList = goodsTypeService.getGoodsTypesListByPid(null);
		} else {
			Integer pidnum = Integer.valueOf(pid);
			treeVosList = goodsTypeService.getGoodsTypesListByPid(pidnum);
		}
		PrintWriter pw = response.getWriter();
		pw.print(JSON.toJSONString(treeVosList));
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
