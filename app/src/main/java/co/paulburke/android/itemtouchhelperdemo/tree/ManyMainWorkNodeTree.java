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
    private ManyMainWorkTreeNode root;

    /**
     * 构造函数
     */
    public ManyMainWorkNodeTree() {
        root = new ManyMainWorkTreeNode(new MainWorkNode(ROOT_NODE));
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
                manyMainWorkNodeTree.getRoot().getChildList().add(new ManyMainWorkTreeNode(mainWorkNode));
            } else {
                addChild(manyMainWorkNodeTree.getRoot(), mainWorkNode);
            }
        }

        return manyMainWorkNodeTree;
    }

    /**
     * 向指定多叉树节点添加子节点
     *
     * @param manyMainWorkTreeNode 多叉树节点
     * @param child        节点
     */
    public void addChild(ManyMainWorkTreeNode manyMainWorkTreeNode, MainWorkNode child) {
        for (ManyMainWorkTreeNode item : manyMainWorkTreeNode.getChildList()) {
            if (item.getData().getId() == child.getParentId()) {
                //找到对应的父亲
                item.getChildList().add(new ManyMainWorkTreeNode(child));
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
     * @param manyMainWorkTreeNode 多叉树节点
     * @return
     */
    public String iteratorTree(ManyMainWorkTreeNode manyMainWorkTreeNode) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("\n");

        if (manyMainWorkTreeNode != null) {
            for (ManyMainWorkTreeNode index : manyMainWorkTreeNode.getChildList()) {
                buffer.append(index.getData().getId() + ",");

                if (index.getChildList() != null && index.getChildList().size() > 0) {
                    buffer.append(iteratorTree(index));
                }
            }
        }

        buffer.append("\n");

        return buffer.toString();
    }

    public List<MainWorkNode> iteratorTreeToList(ManyMainWorkTreeNode manyMainWorkTreeNode) {
        List<MainWorkNode>  buffer = new ArrayList<>();

        if (manyMainWorkTreeNode != null) {
            for (ManyMainWorkTreeNode index : manyMainWorkTreeNode.getChildList()) {
                buffer.add(index.getData());

                if (index.getChildList() != null && index.getChildList().size() > 0) {
                    buffer.addAll(iteratorTreeToList(index));
                }
            }
        }


        return buffer;
    }


    public ManyMainWorkTreeNode getRoot() {
        return root;
    }

    public void setRoot(ManyMainWorkTreeNode root) {
        this.root = root;
    }


}
