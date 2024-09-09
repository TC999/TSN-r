package com.acse.ottn.model;

import com.acse.ottn.j0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class PageSettingTypeModel {
    String package_name;
    int read_time = 7000;
    String read_type = "0";
    int read_length = j0.f5771m;
    private String read_description = "0";
    private String is_click_jd_title = "0";

    public String getIs_click_jd_title() {
        return this.is_click_jd_title;
    }

    public String getPackage_name() {
        return this.package_name;
    }

    public String getRead_description() {
        return this.read_description;
    }

    public int getRead_length() {
        return this.read_length;
    }

    public int getRead_time() {
        return this.read_time;
    }

    public String getRead_type() {
        return this.read_type;
    }

    public void setIs_click_jd_title(String str) {
        this.is_click_jd_title = str;
    }

    public void setPackage_name(String str) {
        this.package_name = str;
    }

    public void setRead_description(String str) {
        this.read_description = str;
    }

    public void setRead_length(int i4) {
        this.read_length = i4;
    }

    public void setRead_time(int i4) {
        this.read_time = i4;
    }

    public void setRead_type(String str) {
        this.read_type = str;
    }

    public String toString() {
        return "PageSettingTypeModel{package_name='" + this.package_name + "', read_time='" + this.read_time + "', read_type='" + this.read_type + "', read_lenght='" + this.read_length + "'}";
    }
}
