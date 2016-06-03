package co.paulburke.android.itemtouchhelperdemo.tree;/*

/**
 * 树节点
 *
 * @author Walker
 * @version 1.0.0.0
 */

import java.util.ArrayList;
import java.util.List;

public class MainWorkNode {
    /**
     * 节点Id
     */
    private long id;
    /**
     * 父节点Id
     */
    private long parentId;
    /**
     * 文本内容
     */
    private String title;
    /**
     * 层级数
     */
    private int level;

    private List<MainWorkNode> childList;


    /**
     * 构造函数
     *
     * @param id 节点Id
     */
    public MainWorkNode(long id) {
        this.id = id;
    }


    public List<MainWorkNode> getChildList() {
        if (childList == null)
            childList = new ArrayList<>();
        return childList;

    }

    public void setChildList(List<MainWorkNode> childList) {
        this.childList = childList;
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
     * @param id       节点Id
     * @param parentId 父节点Id
     */
    public MainWorkNode(long id, long parentId, String title) {
        this.id = id;
        this.parentId = parentId;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public boolean equals(Object other) {       //重写equals方法，后面最好重写hashCode方法

        if (this == other)                                      //先检查是否其自反性，后比较other是否为空。这样效率高
            return true;
        if (other == null)
            return false;
        if (!(other instanceof MainWorkNode))
            return false;

        final MainWorkNode cat = (MainWorkNode) other;

        if (getId() == cat.getId())
            return false;
        return false;
    }
}
