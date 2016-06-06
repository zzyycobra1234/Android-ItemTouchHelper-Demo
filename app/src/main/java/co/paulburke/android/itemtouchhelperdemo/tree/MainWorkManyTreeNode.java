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
public class MainWorkManyTreeNode {
    /**
     * 树节点
     */
    private MainWorkNode data;
    /**
     * 子树集合
     */
    private List<MainWorkManyTreeNode> childList;

    private boolean isExpand;

    private int level;




    /**
     * 构造函数
     *
     * @param data 树节点
     */
    public MainWorkManyTreeNode(MainWorkNode data) {
        this.data = data;
        this.childList = new ArrayList<MainWorkManyTreeNode>();
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * 构造函数
     *
     * @param data      树节点
     * @param childList 子树集合
     */
    public MainWorkManyTreeNode(MainWorkNode data, List<MainWorkManyTreeNode> childList) {
        this.data = data;
        this.childList = childList;
    }

    public MainWorkNode getData() {
        return data;
    }

    public void setData(MainWorkNode data) {
        this.data = data;
    }

    public List<MainWorkManyTreeNode> getChildList() {
        return childList;
    }

    public void setChildList(List<MainWorkManyTreeNode> childList) {
        this.childList = childList;
    }

}