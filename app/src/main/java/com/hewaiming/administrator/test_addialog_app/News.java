package com.hewaiming.administrator.test_addialog_app;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/9/22 0022.
 */

public class News implements Serializable {
    private String title;
    private String desc;
    private int photoId;

    /**
     * Constructs a new instance of {@code Object}.
     */
    public News(String name, String age, int photoId) {
        this.title=name;
        this.desc=age;
        this.photoId=photoId;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getDesc() {
        return desc;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getTitle() {
        return title;
    }
}
