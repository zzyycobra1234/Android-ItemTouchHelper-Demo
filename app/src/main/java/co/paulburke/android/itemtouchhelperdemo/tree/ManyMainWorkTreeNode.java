package co.paulburke.android.itemtouchhelperdemo.tree;

/**
 * Created by Administrator on 2016/6/2 0002.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 多叉树节点
 *
 * @author Walker
 * @verion 1.0.0.0
 */
public class ManyMainWorkTreeNode {
    /**
     * 树节点
     */
    private MainWorkNode data;
    /**
     * 子树集合
     */
    private List<ManyMainWorkTreeNode> childList;

    /**
     * 构造函数
     *
     * @param data 树节点
     */
    public ManyMainWorkTreeNode(MainWorkNode data) {
        this.data = data;
        this.childList = new ArrayList<ManyMainWorkTreeNode>();
    }

    /**
     * 构造函数
     *
     * @param data      树节点
     * @param childList 子树集合
     */
    public ManyMainWorkTreeNode(MainWorkNode data, List<ManyMainWorkTreeNode> childList) {
        this.data = data;
        this.childList = childList;
    }

    public MainWorkNode getData() {
        return data;
    }

    public void setData(MainWorkNode data) {
        this.data = data;
    }

    public List<ManyMainWorkTreeNode> getChildList() {
        return childList;
    }

    public void setChildList(List<ManyMainWorkTreeNode> childList) {
        this.childList = childList;
    }

}