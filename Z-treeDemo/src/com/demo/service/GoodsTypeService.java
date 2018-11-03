package com.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.demo.dao.GoodsTypeDAO;
import com.demo.pojo.GoodsType;
import com.demo.vo.TreeVo;

public class GoodsTypeService {

	private GoodsTypeDAO goodsTypeDAO = new GoodsTypeDAO();

	/**
	 * 根据父id查询子目录
	 * 
	 * @param pid
	 * @return
	 */
	public List<TreeVo> getGoodsTypesListByPid(Integer pid) {
		Collection<GoodsType> collection = null;
		if (pid == null || pid == 0) {
			// 返回一级目录类型
			List<GoodsType> goodsTypesList = goodsTypeDAO.findByTypeLv(1);
			collection = goodsTypesList;
		} else {
			// 获得父级类型
			GoodsType goodsType = goodsTypeDAO.findById(pid);
			// 获得父级类型的子级类型
			collection = goodsType.getGoodsTypes();
		}
		List<TreeVo> treeVosList = new ArrayList<TreeVo>();
		for (GoodsType goodsType : collection) {
			TreeVo treeVo = new TreeVo();
			treeVo.setId(goodsType.getTypeId());
			if (goodsType.getGoodsType() == null) {
				// 没有父级类型
				treeVo.setIsParent(true);
				treeVo.setPid(0);
			} else {
				treeVo.setIsParent(false);
				treeVo.setPid(goodsType.getGoodsType().getTypeId());
			}

			treeVo.setName(goodsType.getTypeName());
			treeVosList.add(treeVo);
		}
		return treeVosList;
	}
}
