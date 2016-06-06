package co.paulburke.android.itemtouchhelperdemo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/1 0001.
 */
public class CreateMainWorkTools {


    public static List<MainWorkManyTreeNode> createMainWorks() {
        List<MainWorkNode> treeNodes = new ArrayList<MainWorkNode>();

        treeNodes.add(new MainWorkNode(10001L, 0, "android "));
        treeNodes.add(new MainWorkNode(10002L, 0, "IOs "));
        treeNodes.add(new MainWorkNode(10003L, 0, "设计 "));

        treeNodes.add(new MainWorkNode(10011L, 10001L, "android 2级列表 李骚骚 "));
        treeNodes.add(new MainWorkNode(10012L, 10001L, "android 2级列表 李豆豆 "));
        treeNodes.add(new MainWorkNode(10013L, 10001L, "android 2级列表 李小贱 "));

        treeNodes.add(new MainWorkNode(10013L, 10011L, "android su22222b1 "));
        treeNodes.add(new MainWorkNode(10013L, 10011L, "android su222b1 "));
        treeNodes.add(new MainWorkNode(10013L, 10011L, "android sub2e13123211 "));

        treeNodes.add(new MainWorkNode(10021L, 10002L, "IOs sub1 "));
        treeNodes.add(new MainWorkNode(10022L, 10002L, "IOs sub1 "));
        treeNodes.add(new MainWorkNode(10023L, 10002L, "IOs sub1 "));

        treeNodes.add(new MainWorkNode(10031L, 10003L, "设计 sub1 "));
        treeNodes.add(new MainWorkNode(10032L, 10003L, "设计 sub2"));
        treeNodes.add(new MainWorkNode(10033L, 10003L, "设计 sub3"));


        treeNodes.add(new MainWorkNode(15031L, 10002L, "设计 sub1 "));
        treeNodes.add(new MainWorkNode(10532L, 10001L, "设计 sub2"));
        treeNodes.add(new MainWorkNode(10043L, 0, "4级"));


        ManyMainWorkNodeTree tree = new ManyMainWorkNodeTree();
        tree.setExpand(false);
        System.out.println(tree.iteratorTree(tree.createTree(treeNodes).getRoot()));

        return tree.iteratorTreeToRootChildList(tree.createTree(treeNodes).getRoot());

//        return tree.iteratorTreeToManyList(tree.createTree(treeNodes).getRoot());


    }

}
