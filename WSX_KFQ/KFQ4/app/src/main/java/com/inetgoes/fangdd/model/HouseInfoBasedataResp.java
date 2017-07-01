package com.inetgoes.fangdd.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by czz on 2015/11/20.
 */
public class HouseInfoBasedataResp implements Serializable {
    private boolean recfirm;  //新增字段, 表示是否被用户确认看房
    //如果 recfirm为 true表示用户已确认过, 否则未确认

    private String newcode; // 字符串, 楼盘id
    private String loupanname;
    private String pricedesc; // 单价描述
    private String loupan_image_url; // 楼盘概览图片地址
    private String address; // 项目地址
    private Integer kanfang_time; // 该楼盘的总的看房次数
    private Integer tran_success_num; // 该楼盘的总的成交量
    private Integer broker_num; // 代理该楼盘的经纪人数量
    private Integer evaluation_num; // 该楼盘的评测文章数量
    private String right_year; // 产权年限
    private String dimension; // 容积率
    private String developer; // 开发商
    private String startTime; // 开盘时间
    private String finishdate; // 入住时间
    private String propertymanage; // 物业管理公司
    private String total_door; // 总户数
    private String buildarea; // 建筑面积
    private String propertyfee; // 物业费
    private String projtype; // 物业类型, 高层或普通
    private String projfitment; // 装修状况
    private List<HouseinfoHuxing> huxingarr = new ArrayList<>();

    public HouseInfoBasedataResp() {

    }

    public boolean isRecfirm() {
        return recfirm;
    }

    public void setRecfirm(boolean recfirm) {
        this.recfirm = recfirm;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getKanfang_time() {
        return kanfang_time;
    }

    public void setKanfang_time(Integer kanfang_time) {
        this.kanfang_time = kanfang_time;
    }

    public Integer getTran_success_num() {
        return tran_success_num;
    }

    public void setTran_success_num(Integer tran_success_num) {
        this.tran_success_num = tran_success_num;
    }

    public Integer getBroker_num() {
        return broker_num;
    }

    public void setBroker_num(Integer broker_num) {
        this.broker_num = broker_num;
    }

    public Integer getEvaluation_num() {
        return evaluation_num;
    }

    public void setEvaluation_num(Integer evaluation_num) {
        this.evaluation_num = evaluation_num;
    }

    public String getRight_year() {
        return right_year;
    }

    public void setRight_year(String right_year) {
        this.right_year = right_year;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getFinishdate() {
        return finishdate;
    }

    public void setFinishdate(String finishdate) {
        this.finishdate = finishdate;
    }

    public String getPropertymanage() {
        return propertymanage;
    }

    public void setPropertymanage(String propertymanage) {
        this.propertymanage = propertymanage;
    }

    public String getTotal_door() {
        return total_door;
    }

    public void setTotal_door(String total_door) {
        this.total_door = total_door;
    }

    public String getBuildarea() {
        return buildarea;
    }

    public void setBuildarea(String buildarea) {
        this.buildarea = buildarea;
    }

    public String getPropertyfee() {
        return propertyfee;
    }

    public void setPropertyfee(String propertyfee) {
        this.propertyfee = propertyfee;
    }

    public String getProjtype() {
        return projtype;
    }

    public void setProjtype(String projtype) {
        this.projtype = projtype;
    }

    public String getProjfitment() {
        return projfitment;
    }

    public void setProjfitment(String projfitment) {
        this.projfitment = projfitment;
    }

    public List<HouseinfoHuxing> getHuxingarr() {
        return huxingarr;
    }

    public void setHuxingarr(List<HouseinfoHuxing> huxingarr) {
        this.huxingarr = huxingarr;
    }

}
