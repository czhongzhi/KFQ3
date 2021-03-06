package com.inetgoes.fangdd.model;

import java.io.Serializable;

/**
 * Created by czz on 2015/11/18.
 * 经济人评论
 */
public class AllTalk implements Serializable {
    private Long id;  //本表ID
    private Integer userid;

    private String docid;

    //实体类型:1表示标准评测，2表示个性评测，3表示看房日记，4表示专题, 5表示顾问
    private Integer doctype;  //文档类型

    private Long createtime;

    private String contentdesc;

    private String levdesc;

    private Float starlevel;

    //以下是关联的字段
    private String username;   //用户姓名
    private String userimage_url;  //用户头像位置
    private String createtime_str;  //时间字符串表示法
    private String createtime_rel; //时间的相对字符串表示法

    public AllTalk() {
    }

    public Float getStarlevel() {
        return starlevel;
    }


    public void setStarlevel(Float starlevel) {
        this.starlevel = starlevel;
    }


    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserimage_url() {
        return userimage_url;
    }

    public void setUserimage_url(String userimage_url) {
        this.userimage_url = userimage_url;
    }

    public String getCreatetime_str() {
        return createtime_str;
    }

    public void setCreatetime_str(String createtime_str) {
        this.createtime_str = createtime_str;
    }

    public String getCreatetime_rel() {
        return createtime_rel;
    }

    public void setCreatetime_rel(String createtime_rel) {
        this.createtime_rel = createtime_rel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getDoctype() {
        return doctype;
    }

    public void setDoctype(Integer doctype) {
        this.doctype = doctype;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public String getContentdesc() {
        return contentdesc;
    }

    public void setContentdesc(String contentdesc) {
        this.contentdesc = contentdesc;
    }

    public String getLevdesc() {
        return levdesc;
    }

    public void setLevdesc(String levdesc) {
        this.levdesc = levdesc;
    }

}
