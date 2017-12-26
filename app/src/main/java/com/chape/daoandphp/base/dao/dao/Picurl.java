package com.chape.daoandphp.base.dao.dao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2017/10/7.
 */
@Entity
public class Picurl {
    @Id(autoincrement = true)
    private Long id;
    private String pic_title;
    private String pic_content;
    @Generated(hash = 1383378813)
    public Picurl(Long id, String pic_title, String pic_content) {
        this.id = id;
        this.pic_title = pic_title;
        this.pic_content = pic_content;
    }
    @Generated(hash = 1146726670)
    public Picurl() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPic_title() {
        return this.pic_title;
    }
    public void setPic_title(String pic_title) {
        this.pic_title = pic_title;
    }
    public String getPic_content() {
        return this.pic_content;
    }
    public void setPic_content(String pic_content) {
        this.pic_content = pic_content;
    }
}
