package com.inetgoes.fangdd.model;

import java.io.Serializable;

/**
 * Created by czz on 2015/11/30.
 */
public class KanFangListStateResp implements Serializable {

    private Long kanrecid; // 本身看房记录id
    private Integer brokerid; // 经纪人id
    private String userimage; // 经纪人大头照
    private String username; // 经纪人姓名
    private Float starlevel; // 等级
    private String state; // 订单状态
    // 值有:已看房，待看房，用户取消，经纪人取消
    private String requestdate_str; // 申请时间
    private String newcode; // 楼盘id
    private String loupanname; // 楼盘名称
    private String pricedesc; // 单价描述
    private String loupan_image_url; // 楼盘概览图片地址
    private String loupan_addr; // 楼盘项目地址

    private String huxing_type;     //字符串  户型类型

    public String getHuxing_type() {
        return huxing_type;
    }

    public void setHuxing_type(String huxing_type) {
        this.huxing_type = huxing_type;
    }

    public KanFangListStateResp() {
    }

    public Long getKanrecid() {
        return kanrecid;
    }

    public void setKanrecid(Long kanrecid) {
        this.kanrecid = kanrecid;
    }

    public Integer getBrokerid() {
        return brokerid;
    }

    public void setBrokerid(Integer brokerid) {
        this.brokerid = brokerid;
    }

    public String getUserimage() {
        return userimage;
    }

    public void setUserimage(String userimage) {
        this.userimage = userimage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Float getStarlevel() {
        return starlevel;
    }

    public void setStarlevel(Float starlevel) {
        this.starlevel = starlevel;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRequestdate_str() {
        return requestdate_str;
    }

    public void setRequestdate_str(String requestdate_str) {
        this.requestdate_str = requestdate_str;
    }

    public String getNewcode() {
        return newcode;
    }

    public void setNewcode(String newcode) {
        this.newcode = newcode;
    }

    public String getLoupanname() {
        return loupanname;
    }

    public void setLoupanname(String loupanname) {
        this.loupanname = loupanname;
    }

    public String getPricedesc() {
        return pricedesc;
    }

    public void setPricedesc(String pricedesc) {
        this.pricedesc = pricedesc;
    }

    public String getLoupan_image_url() {
        return loupan_image_url;
    }

    public void setLoupan_image_url(String loupan_image_url) {
        this.loupan_image_url = loupan_image_url;
    }

    public String getLoupan_addr() {
        return loupan_addr;
    }

    public void setLoupan_addr(String loupan_addr) {
        this.loupan_addr = loupan_addr;
    }

}
