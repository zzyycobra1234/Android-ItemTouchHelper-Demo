package co.paulburke.android.itemtouchhelperdemo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/1 0001.
 */
public class CreateMainWorkTools {


    public static List<MainWorkNode> createMainWorks() {
        List<MainWorkNode> treeNodes = new ArrayList<MainWorkNode>();
//        treeNodes.add(new MainWorkNode( ManyMainWorkNodeTree.ROOT_NODE, 0,  "root"));
        treeNodes.add(new MainWorkNode(10001L,  0, "android "));
        treeNodes.add(new MainWorkNode(10002L,  0, "IOs "));
        treeNodes.add(new MainWorkNode(10003L,  0, "设计 "));

        treeNodes.add(new MainWorkNode(10011L, 10001L, "android sub1 "));
        treeNodes.add(new MainWorkNode(10012L, 10001L, "android sub2 "));
        treeNodes.add(new MainWorkNode(10013L, 10001L, "android sub3 "));

        treeNodes.add(new MainWorkNode(10021L, 10002L, "IOs sub1 "));
        treeNodes.add(new MainWorkNode(10022L, 10002L, "IOs sub1 "));
        treeNodes.add(new MainWorkNode(10023L, 10002L, "IOs sub1 "));

        treeNodes.add(new MainWorkNode(10031L, 10003L, "设计 sub1 "));
        treeNodes.add(new MainWorkNode(10032L, 10003L, "设计 sub2"));
        treeNodes.add(new MainWorkNode(10036L, 10003L, "设计 sub3"));
//
        treeNodes.add(new MainWorkNode(10033L, 10032L, "设计  sub2 sub3"));
        treeNodes.add(new MainWorkNode(10034L, 10032L, "设计  sub2 sub4 "));
        treeNodes.add(new MainWorkNode(10035L, 10032L, "设计  sub2 sub5"));
//
        treeNodes.add(new MainWorkNode(10017L, 10001L, "android sub6 "));
        treeNodes.add(new MainWorkNode(10018L, 10001L, "android sub7 "));
        treeNodes.add(new MainWorkNode(10019L, 10001L, "android sub8 "));

        ManyMainWorkNodeTree tree = new ManyMainWorkNodeTree();
//        System.out.println(tree.iteratorTree(tree.createTree(treeNodes).getRoot()));

        return tree.iteratorTreeToList(tree.createTree(treeNodes).getRoot());


    }

}
