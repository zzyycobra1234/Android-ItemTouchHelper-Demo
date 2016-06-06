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
    private MainWorkManyTreeNode root;

    private boolean isExpand;

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    /**
     * 构造函数
     */
    public ManyMainWorkNodeTree() {
        root = new MainWorkManyTreeNode(new MainWorkNode(ROOT_NODE));
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
                MainWorkManyTreeNode temp = new MainWorkManyTreeNode(mainWorkNode);
                temp.setExpand(this.isExpand());
                manyMainWorkNodeTree.getRoot().getChildList().add(temp);
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
     * @param child                节点
     */
    public void addChild(MainWorkManyTreeNode manyMainWorkTreeNode, MainWorkNode child) {
        for (MainWorkManyTreeNode item : manyMainWorkTreeNode.getChildList()) {
            if (item.getData().getId() == child.getParentId()) {
                //找到对应的父亲
                MainWorkManyTreeNode temp = new MainWorkManyTreeNode(child);
                temp.setExpand(this.isExpand());
                item.getChildList().add(temp);
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
    public String iteratorTree(MainWorkManyTreeNode manyMainWorkTreeNode) {
        StringBuilder buffer = new StringBuilder();
        buffer.append("\n");

        if (manyMainWorkTreeNode != null) {
            for (MainWorkManyTreeNode index : manyMainWorkTreeNode.getChildList()) {
                buffer.append(index.getData().getId() + ",");

                if (index.getChildList() != null && index.getChildList().size() > 0) {
                    buffer.append(iteratorTree(index));
                }
            }
        }

        buffer.append("\n");

        return buffer.toString();
    }

    public List<MainWorkNode> iteratorTreeToList(MainWorkManyTreeNode manyMainWorkTreeNode) {
        List<MainWorkNode> buffer = new ArrayList<>();

        if (manyMainWorkTreeNode != null) {
            for (MainWorkManyTreeNode index : manyMainWorkTreeNode.getChildList()) {
                index.setLevel(manyMainWorkTreeNode.getLevel() + 1);
                buffer.add(index.getData());

                if (index.getChildList() != null && index.getChildList().size() > 0) {
                    buffer.addAll(iteratorTreeToList(index));
                }
            }
        }


        return buffer;
    }

    /**
     * 将所有的树节点加入到List中
     */
    public List<MainWorkManyTreeNode> iteratorTreeToManyList(MainWorkManyTreeNode manyMainWorkTreeNode) {
        List<MainWorkManyTreeNode> buffer = new ArrayList<>();

        if (manyMainWorkTreeNode != null) {
            for (MainWorkManyTreeNode index : manyMainWorkTreeNode.getChildList()) {
                index.setLevel(manyMainWorkTreeNode.getLevel() + 1);
                buffer.add(index);

                if (index.getChildList() != null && index.getChildList().size() > 0) {
                    buffer.addAll(iteratorTreeToManyList(index));
                }
            }
        }


        return buffer;
    }

    /**
     * 只是根节点加入到列表中
     *
     * @param manyMainWorkTreeNode
     * @return
     */
    public List<MainWorkManyTreeNode> iteratorTreeToRootChildList(MainWorkManyTreeNode manyMainWorkTreeNode) {
        List<MainWorkManyTreeNode> buffer = new ArrayList<>();
        if (manyMainWorkTreeNode != null) {
            buffer.addAll(manyMainWorkTreeNode.getChildList());
        }

        // 设置Level
        if (manyMainWorkTreeNode != null) {
            for (MainWorkManyTreeNode index : manyMainWorkTreeNode.getChildList()) {
                index.setLevel(manyMainWorkTreeNode.getLevel() + 1);

                if (index.getChildList() != null && index.getChildList().size() > 0) {
                    iteratorTreeToManyList(index);
                }
            }
        }


        return buffer;
    }


    public MainWorkManyTreeNode getRoot() {
        return root;
    }

    public void setRoot(MainWorkManyTreeNode root) {
        this.root = root;
    }


}
