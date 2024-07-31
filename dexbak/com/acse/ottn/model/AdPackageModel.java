package com.acse.ottn.model;

import com.acse.ottn.util.CommonUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AdPackageModel {
    private int arl;
    private int cost_time;
    private String new_package_setting;

    /* renamed from: r */
    private int f2901r;
    private List<String> keywords_names = new ArrayList();
    private List<String> new_package_name = new ArrayList();
    private String readpage_type = "0";
    private int readpage_time = 7000;
    private int delay_readpage_time = 500;
    private String send_state = "0";
    private String readpage_activity_type = "0";
    private String jd_readpage_type = "0";
    private String tb_readpage_type = "0";
    private String read_timeout = "0";
    private int jd_readpage_size = CommonUtil.JD_READ_SIZE;
    private int tb_readpage_size = CommonUtil.TB_READ_SIZE;
    private String is_click_jd_title = "0";
    private String read_description = "0";

    public int getArl() {
        return this.arl;
    }

    public int getCost_time() {
        return this.cost_time;
    }

    public int getDelay_readpage_time() {
        return this.delay_readpage_time;
    }

    public String getIs_click_jd_title() {
        return this.is_click_jd_title;
    }

    public int getJd_readpage_size() {
        return this.jd_readpage_size;
    }

    public String getJd_readpage_type() {
        return this.jd_readpage_type;
    }

    public List<String> getKeywords_names() {
        return this.keywords_names;
    }

    public List<String> getNew_package_name() {
        return this.new_package_name;
    }

    public String getNew_package_setting() {
        return this.new_package_setting;
    }

    public int getR() {
        return this.f2901r;
    }

    public String getRead_description() {
        return this.read_description;
    }

    public String getRead_timeout() {
        return this.read_timeout;
    }

    public String getReadpage_activity_type() {
        return this.readpage_activity_type;
    }

    public int getReadpage_time() {
        return this.readpage_time;
    }

    public String getReadpage_type() {
        return this.readpage_type;
    }

    public String getSend_state() {
        return this.send_state;
    }

    public int getTb_readpage_size() {
        return this.tb_readpage_size;
    }

    public String getTb_readpage_type() {
        return this.tb_readpage_type;
    }

    public void setArl(int i) {
        this.arl = i;
    }

    public void setCost_time(int i) {
        this.cost_time = i;
    }

    public void setDelay_readpage_time(int i) {
        this.delay_readpage_time = i;
    }

    public void setIs_click_jd_title(String str) {
        this.is_click_jd_title = str;
    }

    public void setJd_readpage_size(int i) {
        this.jd_readpage_size = i;
    }

    public void setJd_readpage_type(String str) {
        this.jd_readpage_type = str;
    }

    public void setKeywords_names(List<String> list) {
        this.keywords_names = list;
    }

    public void setNew_package_name(List<String> list) {
        this.new_package_name = list;
    }

    public void setNew_package_setting(String str) {
        this.new_package_setting = str;
    }

    public void setR(int i) {
        this.f2901r = i;
    }

    public void setRead_description(String str) {
        this.read_description = str;
    }

    public void setRead_timeout(String str) {
        this.read_timeout = str;
    }

    public void setReadpage_activity_type(String str) {
        this.readpage_activity_type = str;
    }

    public void setReadpage_time(int i) {
        this.readpage_time = i;
    }

    public void setReadpage_type(String str) {
        this.readpage_type = str;
    }

    public void setSend_state(String str) {
        this.send_state = str;
    }

    public void setTb_readpage_size(int i) {
        this.tb_readpage_size = i;
    }

    public void setTb_readpage_type(String str) {
        this.tb_readpage_type = str;
    }

    public String toString() {
        return "AdPackageModel{r=" + this.f2901r + ", arl=" + this.arl + ", new_package_setting='" + this.new_package_setting + "', keywords_names=" + this.keywords_names + ", new_package_name=" + this.new_package_name + ", readpage_type='" + this.readpage_type + "', readpage_time=" + this.readpage_time + ", readpage_activity_type='" + this.readpage_activity_type + "', jd_readpage_type='" + this.jd_readpage_type + "', tb_readpage_type='" + this.tb_readpage_type + "', read_timeout='" + this.read_timeout + "', jd_readpage_size=" + this.jd_readpage_size + ", tb_readpage_size=" + this.tb_readpage_size + ", is_click_jd_title='" + this.is_click_jd_title + "', read_description='" + this.read_description + "', cost_time=" + this.cost_time + '}';
    }
}
