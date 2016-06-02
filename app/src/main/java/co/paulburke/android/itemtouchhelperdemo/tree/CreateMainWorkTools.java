package co.paulburke.android.itemtouchhelperdemo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/1 0001.
 */
public class CreateMainWorkTools {

    public static final long ROOT_ID = 190000l;

    public static List<MainWorkNode> createMainWorks() {
        List<MainWorkNode> treeNodes = new ArrayList<MainWorkNode>();
        treeNodes.add(new MainWorkNode(ROOT_ID, 0, 0, "root"));
        treeNodes.add(new MainWorkNode(10001L, ROOT_ID, 0, "android "));
        treeNodes.add(new MainWorkNode(10002L, ROOT_ID, 0, "IOs "));
        treeNodes.add(new MainWorkNode(10003L, ROOT_ID, 0, "设计 "));

        treeNodes.add(new MainWorkNode(10011L, 10001L, 0, "android sub1 "));
        treeNodes.add(new MainWorkNode(10012L, 10001L, 0, "android sub1 "));
        treeNodes.add(new MainWorkNode(10013L, 10001L, 0, "android sub1 "));

        treeNodes.add(new MainWorkNode(10021L, 10002L, 0, "IOs sub1 "));
        treeNodes.add(new MainWorkNode(10022L, 10002L, 0, "IOs sub1 "));
        treeNodes.add(new MainWorkNode(10023L, 10002L, 0, "IOs sub1 "));

        treeNodes.add(new MainWorkNode(10031L, 10003L, 0, "设计 sub1 "));
        treeNodes.add(new MainWorkNode(10032L, 10003L, 0, "设计 sub2"));
        treeNodes.add(new MainWorkNode(10033L, 10003L, 0, "设计 sub3"));


        ManyMainWorkNodeTree tree = new ManyMainWorkNodeTree();
        System.out.println(tree.iteratorTree(tree.createTree(treeNodes).getRoot()));

        return tree.iteratorTreeToList(tree.createTree(treeNodes).getRoot());

        //        List<MainWorkNode> mItems = new ArrayList<>();
        //        MainWorkNode rootMainWorkRenderNode = new MainWorkNode();
        //
        //        MainWorkNode androidMainWork = new MainWorkNode();
        //        androidMainWork.setLevel(1);
        //        androidMainWork.setTitle("Android 开发");
        //        androidMainWork.setId(10000);
        //        androidMainWork.setDirectParent(rootMainWorkRenderNode);
        //
        //        MainWorkNode androidSubMainWork1 = new MainWorkNode();
        //        androidSubMainWork1.setLevel(2);
        //        androidSubMainWork1.setTitle("Android 开发  bug 1");
        //        androidSubMainWork1.setId(10010);
        //        androidSubMainWork1.setDirectParent(androidMainWork);
        //
        //        MainWorkNode androidSubMainWork2 = new MainWorkNode();
        //        androidSubMainWork2.setLevel(2);
        //        androidSubMainWork2.setTitle("Android 开发  bug 2");
        //        androidSubMainWork2.setId(10020);
        //        androidSubMainWork2.setDirectParent(androidMainWork);
        //
        //
        //        MainWorkNode iosMainWork = new MainWorkNode();
        //        iosMainWork.setLevel(1);
        //        iosMainWork.setTitle("IOS 开发");
        //        iosMainWork.setId(10001);
        //        iosMainWork.setDirectParent(rootMainWorkRenderNode);
        //
        //        MainWorkNode iosSubMainWork = new MainWorkNode();
        //        iosSubMainWork.setLevel(2);
        //        iosSubMainWork.setTitle("IOS 开发   bug 1");
        //        iosSubMainWork.setId(10031);
        //        iosSubMainWork.setDirectParent(iosMainWork);
        //
        //        MainWorkNode iosSubMainWork2 = new MainWorkNode();
        //        iosSubMainWork2.setLevel(2);
        //        iosSubMainWork2.setTitle("IOS 开发   bug 2");
        //        iosSubMainWork2.setId(10032);
        //        iosSubMainWork2.setDirectParent(iosMainWork);
        //
        //
        //        MainWorkNode deisgnMainWork = new MainWorkNode();
        //        deisgnMainWork.setLevel(1);
        //        deisgnMainWork.setTitle("设计 开发");
        //        deisgnMainWork.setId(10002);
        //        deisgnMainWork.setDirectParent(rootMainWorkRenderNode);
        //
        //        MainWorkNode deisgnMainWork1 = new MainWorkNode();
        //        deisgnMainWork1.setLevel(2);
        //        deisgnMainWork1.setTitle("矜持的设计");
        //        deisgnMainWork1.setId(10041);
        //        deisgnMainWork1.setDirectParent(deisgnMainWork);
        //
        //        MainWorkNode deisgnMainWork2 = new MainWorkNode();
        //        deisgnMainWork2.setLevel(2);
        //        deisgnMainWork2.setTitle("撕逼的设计");
        //        deisgnMainWork2.setId(10042);
        //        deisgnMainWork2.setDirectParent(deisgnMainWork);
        //
        //
        //        rootMainWorkRenderNode.addSon(androidMainWork);
        //        rootMainWorkRenderNode.addSon(androidSubMainWork1);
        //        rootMainWorkRenderNode.addSon(androidSubMainWork2);
        //
        //        rootMainWorkRenderNode.addSon(iosMainWork);
        //        rootMainWorkRenderNode.addSon(iosSubMainWork);
        //        rootMainWorkRenderNode.addSon(iosSubMainWork2);
        //
        //        rootMainWorkRenderNode.addSon(deisgnMainWork);
        //        rootMainWorkRenderNode.addSon(deisgnMainWork1);
        //        rootMainWorkRenderNode.addSon(deisgnMainWork2);
        //
        //
        //        //        for (int i = 0; i < 3; i++) {
        //        //            MainWorkNode subRootMainWorkRender = new MainWorkNode();
        //        //            subRootMainWorkRender.setLevel(1);
        //        //            subRootMainWorkRender.setTitle("测试消息1列表--" + (i + 1));
        //        //            subRootMainWorkRender.setId(10000 + i);
        //        //            rootMainWorkRenderNode.addSon(subRootMainWorkRender);
        //        ////                        mItems.add(subRootMainWorkRender);
        //        //
        //        //            for (int j = 0; j < 2; j++) {
        //        //                MainWorkNode son2 = new MainWorkNode();
        //        //                son2.setLevel(2);
        //        //                son2.setTitle("测试消息2级列表**" + (j + 1));
        //        //                son2.setDirectParent(subRootMainWorkRender);
        //        //                rootMainWorkRenderNode.addSon(son2);
        //        //                subRootMainWorkRender.addSon(son2);
        //        //
        //        //                //                mItems.add(son2);
        //        //
        //        //
        //        //                for (int k = 0; k < 2; k++) {
        //        //                    MainWorkNode son3 = new MainWorkNode();
        //        //                    son3.setLevel(3);
        //        //                    son3.setTitle("测试消息3级列表==" + (k + 1));
        //        //                    son3.setDirectParent(son2);
        //        //                    rootMainWorkRenderNode.addSon(son3);
        //        //                    subRootMainWorkRender.addSon(son3);
        //        //                    son2.addSon(son3);
        //        //
        //        //
        //        //                    //                    mItems.add(son3);
        //        //
        //        //                }
        //        //            }
        //        //        }
        //
        //
        //        //        List<MainWorkNode> list = new ArrayList<>(rootMainWorkRenderNode.getSons());
        //        //        Collections.reverse(list);
        //        //        mItems.addAll(list);
        //        List<MainWorkNode> mainWorkRenderNodes = rootMainWorkRenderNode.getSons();
        //        for (int i = 0; i < mainWorkRenderNodes.size(); i++) {
        //            MainWorkNode node = mainWorkRenderNodes.get(i);
        //            while (node.getSons() != null && !node.getSons().isEmpty()) {
        //
        //
        //
        //
        //            }
        //        }


    }

}
