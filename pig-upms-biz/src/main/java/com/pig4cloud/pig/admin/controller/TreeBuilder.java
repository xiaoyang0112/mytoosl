package com.pig4cloud.pig.admin.controller;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

//图层结构
public class TreeBuilder {

	List<Node> nodes = new ArrayList<>();

	public String buildTree(List<Node> nodes) {
		TreeBuilder treeBuilder = new TreeBuilder(nodes);
		return treeBuilder.buildJSONTree();
	}

	public TreeBuilder() {}

	public TreeBuilder(List<Node> nodes) {
		super();
		this.nodes = nodes;
	}

	// 构建JSON树形结构
	public String buildJSONTree() {
		List<Node> nodeTree = buildTree();
		String jsonStr = JSON.toJSONString(nodeTree);
		return jsonStr;
	}

	// 构建树形结构
	public List<Node> buildTree() {
		List<Node> treeNodes = new ArrayList<>();
		List<Node> rootNodes = getRootNodes();
		for (Node rootNode : rootNodes) {
			buildChildNodes(rootNode);
			treeNodes.add(rootNode);
		}
		return treeNodes;
	}

	// 递归子节点
	public void buildChildNodes(Node node) {
		List<Node> children = getChildNodes(node);
		if (!children.isEmpty()) {
			for (Node child : children) {
				buildChildNodes(child);
			}
			node.setChildren(children);
		}
	}

	// 获取父节点下所有的子节点
	public List<Node> getChildNodes(Node pnode) {
		List<Node> childNodes = new ArrayList<>();
		for (Node n : nodes) {
			if (pnode.getId().equals(n.getParentId())) {
				childNodes.add(n);
			}
		}
		return childNodes;
	}

	// 判断是否为根节点
	public boolean rootNode(Node node) {
		boolean isRootNode = true;
		for (Node n : nodes) {
			if (node.getParentId().equals(n.getId())) {
				isRootNode = false;
				break;
			}
		}
		return isRootNode;
	}

	// 获取集合中所有的根节点
	public List<Node> getRootNodes() {
		List<Node> rootNodes = new ArrayList<>();
		for (Node n : nodes) {
			if (rootNode(n)) {
				rootNodes.add(n);
			}
		}
		return rootNodes;
	}

	public static class Node {
		private Integer id;
		private Integer parentId;
		private String name;
		private String code;
		private Integer level;
		private List<Node> children;

		public Node() {}
		public Node(Integer id,Integer parentId,String name,String code,Integer level){
			super();
			this.id = id;
			this.parentId = parentId;
			this.name = name;
			this.code = code;
			this.level = level;
		}


		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getParentId() {
			return parentId;
		}

		public void setParentId(Integer parentId) {
			this.parentId = parentId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public Integer getLevel() {
			return level;
		}

		public void setLevel(Integer level) {
			this.level = level;
		}

		public List<Node> getChildren() {
			return children;
		}

		public void setChildren(List<Node> children) {
			this.children = children;
		}
	}

	public static List<TreeBuilder.Node> buildNode(){
		List<TreeBuilder.Node> nodeList = new ArrayList<>();
		TreeBuilder.Node node = new TreeBuilder.Node(0,-1,"地球","WORD",1);
		TreeBuilder.Node node1 = new TreeBuilder.Node(1,0,"中国","CHN",1);

		TreeBuilder.Node node2 = new TreeBuilder.Node(2,1,"华北区域","A",2);
		TreeBuilder.Node node3 = new TreeBuilder.Node(3,1,"华南区域","B",2);
		TreeBuilder.Node node4 = new TreeBuilder.Node(4,1,"华东区域","C",2);
		TreeBuilder.Node node5 = new TreeBuilder.Node(5,1,"华西区域","D",2);
		TreeBuilder.Node node6 = new TreeBuilder.Node(6,1,"华中区域","E",2);

		TreeBuilder.Node node7 = new TreeBuilder.Node(7,6,"河南","豫",3);
		TreeBuilder.Node node8 = new TreeBuilder.Node(8,6,"湖北","鄂",3);
		TreeBuilder.Node node9 = new TreeBuilder.Node(9,6,"湖南","湘",3);
		TreeBuilder.Node node10 = new TreeBuilder.Node(10,6,"江西","赣",3);

		TreeBuilder.Node node11 = new TreeBuilder.Node(11,7,"郑州","豫A",4);
		TreeBuilder.Node node12 = new TreeBuilder.Node(12,7,"开封","豫B",4);
		TreeBuilder.Node node13 = new TreeBuilder.Node(13,7,"洛阳","豫C",4);
		TreeBuilder.Node node14 = new TreeBuilder.Node(14,7,"南阳","豫R",4);

		TreeBuilder.Node node15 = new TreeBuilder.Node(15,11,"金水区","豫A-1",5);

		nodeList.add(node);
		nodeList.add(node1);nodeList.add(node2);nodeList.add(node3);
		nodeList.add(node4);nodeList.add(node5);nodeList.add(node6);
		nodeList.add(node7);nodeList.add(node8);nodeList.add(node9);
		nodeList.add(node10);nodeList.add(node11);nodeList.add(node12);
		nodeList.add(node13);nodeList.add(node14);nodeList.add(node15);

		return nodeList;
	}
}