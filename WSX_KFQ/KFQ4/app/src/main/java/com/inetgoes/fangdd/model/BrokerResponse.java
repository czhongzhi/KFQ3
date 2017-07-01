package com.inetgoes.fangdd.model;

import java.io.Serializable;

/**
 * Created by czz on 2015/11/13.
 */
public class BrokerResponse implements Serializable {
    private Long id;   //用户id

    private String tranid; //事务ID

    private Long createdate; //抢单时间

    private Integer brokerid;  //经纪人id

    private String seled; //是否被申请人选中

    private String cancelreason;  //经纪人主动取消的原因 (已经被选中)

    //关联字段
    private String userimage_ver;  //经纪人竖照
    private String username;   //经纪人姓名
    private String profname;  //经纪人职称
    private Float skillyear;  //经验年数
    private Float starlevel; //等级
    private Integer ordernum;  //完成订单数
    private String createdate_str;  //抢单时间
    private  Integer fangtotal;   //房源数量


    public BrokerResponse() {

    }


    public String getUserimage_ver() {
        return userimage_ver;
    }


    public void setUserimage_ver(String userimage_ver) {
        this.userimage_ver = userimage_ver;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getProfname() {
        return profname;
    }


    public void setProfname(String profname) {
        this.profname = profname;
    }


    public Float getSkillyear() {
        return skillyear;
    }


    public void setSkillyear(Float skillyear) {
        this.skillyear = skillyear;
    }


    public Float getStarlevel() {
        return starlevel;
    }


    public void setStarlevel(Float starlevel) {
        this.starlevel = starlevel;
    }


    public Integer getOrdernum() {
        return ordernum;
    }


    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }


    public String getCreatedate_str() {
        return createdate_str;
    }


    public void setCreatedate_str(String createdate_str) {
        this.createdate_str = createdate_str;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTranid() {
        return tranid;
    }

    public void setTranid(String tranid) {
        this.tranid = tranid;
    }

    public Long getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Long createdate) {
        this.createdate = createdate;
    }

    public Integer getBrokerid() {
        return brokerid;
    }

    public void setBrokerid(Integer brokerid) {
        this.brokerid = brokerid;
    }

    public String getSeled() {
        return seled;
    }

    public void setSeled(String seled) {
        this.seled = seled;
    }

    public String getCancelreason() {
        return cancelreason;
    }

    public void setCancelreason(String cancelreason) {
        this.cancelreason = cancelreason;
    }

    public Integer getFangtotal() {
        return fangtotal;
    }

    public void setFangtotal(Integer fangtotal) {
        this.fangtotal = fangtotal;
    }
}
