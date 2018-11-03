package com.demo.vo;

/**
 * 
 * @Desciption z-tree返回的数据格式
 * @author HobbyBear
 * @date 2018年10月19日 上午9:52:47
 */
public class TreeVo {

	private int id;
	private int pid;
	private boolean isParent;
	private String name;

	public TreeVo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(boolean isParent) {
		this.isParent = isParent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
