package co.paulburke.android.itemtouchhelperdemo.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/2 0002.
 */
public class ManyMainWorkNodeTree {
    public static final long ROOT_NODE = 100000;

    /**
     * 树根
     */
    private MainWorkNode root;

    /**
     * 构造函数
     */
    public ManyMainWorkNodeTree() {
        root = new MainWorkNode(ROOT_NODE);
    }

    /**
     * 生成一颗多叉树，根节点为root
     *
     * @param mainWorkNodes 生成多叉树的节点集合
     * @return ManyMainWorkNodeTree
     */
    public ManyMainWorkNodeTree createTree(List<MainWorkNode> mainWorkNodes) {
        if (mainWorkNodes == null || mainWorkNodes.size() < 0)
            return null;

        ManyMainWorkNodeTree manyMainWorkNodeTree = new ManyMainWorkNodeTree();
        //将所有节点添加到多叉树中
        for (MainWorkNode mainWorkNode : mainWorkNodes) {
            if (mainWorkNode.getParentId() == 0) {
                //向根添加一个节点
                manyMainWorkNodeTree.getRoot().getChildList().add(mainWorkNode);
            } else {
                addChild(manyMainWorkNodeTree.getRoot(), mainWorkNode);
            }
        }

        return manyMainWorkNodeTree;
    }

    /**
     * 向指定多叉树节点添加子节点
     *
     * @param mainWorkManyTreeNode 多叉树节点
     * @param child                节点
     */
    public void addChild(MainWorkNode mainWorkManyTreeNode, MainWorkNode child) {
        for (MainWorkNode item : mainWorkManyTreeNode.getChildList()) {
            if (item.getId() == child.getParentId()) {
                //找到对应的父亲
                if (!item.getChildList().contains(child)) {
                    child.setLevel(item.getLevel() + 1);
                    item.getChildList().add(child);
                }

                break;
            } else {
                if (item.getChildList() != null && item.getChildList().size() > 0) {
                    addChild(item, child);
                }
            }
        }
    }

    /**
     * 遍历多叉树
     *
     * @param mainWorkManyTreeNode 多叉树节点
     * @return
     */
    public String iteratorTree(MainWorkNode mainWorkManyTreeNode) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("\n");

        if (mainWorkManyTreeNode != null) {
            for (MainWorkNode index : mainWorkManyTreeNode.getChildList()) {
                buffer.append(index.getId() + ",");

                if (index.getChildList() != null && index.getChildList().size() > 0) {
                    buffer.append(iteratorTree(index));
                }
            }
        }

        buffer.append("\n");

        return buffer.toString();
    }

    public List<MainWorkNode> iteratorTreeToList(MainWorkNode mainWorkManyTreeNode) {
        List<MainWorkNode> buffer = new ArrayList<>();
        if (mainWorkManyTreeNode != null) {
            for (MainWorkNode index : mainWorkManyTreeNode.getChildList()) {
                if (!buffer.contains(index))
                    buffer.add(index);
                if (index.getChildList() != null && index.getChildList().size() > 0) {
                    buffer.addAll(iteratorTreeToList(index));
                }

            }
        }
        return buffer;
    }


    public MainWorkNode getRoot() {
        return root;
    }

    public void setRoot(MainWorkNode root) {
        this.root = root;
    }


}
