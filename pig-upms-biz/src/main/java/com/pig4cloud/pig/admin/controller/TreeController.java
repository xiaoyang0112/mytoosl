package com.pig4cloud.pig.admin.controller;
import com.alibaba.fastjson.JSON;
import org.jasypt.commons.CommonUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TreeController {

	public static String getTreeJson() {
     List<TreeBuilder.Node> nodeList = buildNode();
		String result = new TreeBuilder().buildTree(nodeList);
		return result;
	}


	public static void main(String[] args) {
		String result=getTreeJson();
		String result1=getTreeJson();
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