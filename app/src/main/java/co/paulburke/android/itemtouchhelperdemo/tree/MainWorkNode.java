package co.paulburke.android.itemtouchhelperdemo.tree;/*

/**
 * 树节点
 *
 * @author Walker
 * @version 1.0.0.0
 */

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
     * 构造函数
     *
     * @param id 节点Id
     */
    public MainWorkNode(long id) {
        this.id = id;
    }

    /**
     * 构造函数
     *
     * @param id       节点Id
     * @param parentId 父节点Id
     */
    public MainWorkNode(long id, long parentId,  String title) {
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

}
