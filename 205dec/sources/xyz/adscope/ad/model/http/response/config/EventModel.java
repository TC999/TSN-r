package xyz.adscope.ad.model.http.response.config;

import java.util.List;
import xyz.adscope.common.json.util.JsonUtil;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class EventModel {
    private String acceptEncrypt;
    private int checkInterval;
    private List<String> codes;
    private int count;
    private int eventType;
    private String macros;
    private String time;
    private String uploadUrl;

    public String getAcceptEncrypt() {
        return this.acceptEncrypt;
    }

    public int getCheckInterval() {
        return this.checkInterval;
    }

    public List<String> getCodes() {
        return this.codes;
    }

    public int getCount() {
        return this.count;
    }

    public int getEventType() {
        return this.eventType;
    }

    public String getMacros() {
        return this.macros;
    }

    public String getTime() {
        return this.time;
    }

    public String getUploadUrl() {
        return this.uploadUrl;
    }

    public void setAcceptEncrypt(String str) {
        this.acceptEncrypt = str;
    }

    public void setCheckInterval(int i4) {
        this.checkInterval = i4;
    }

    public void setCodes(List<String> list) {
        this.codes = list;
    }

    public void setCount(int i4) {
        this.count = i4;
    }

    public void setEventType(int i4) {
        this.eventType = i4;
    }

    public void setMacros(String str) {
        this.macros = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public void setUploadUrl(String str) {
        this.uploadUrl = str;
    }

    public String toString() {
        return "{\"codes\":" + StringUtil.ListToString(this.codes) + ", \"checkInterval\":" + this.checkInterval + ", \"uploadUrl\":\"" + this.uploadUrl + "\", \"macros\":\"" + JsonUtil.addEscapeChar(this.macros) + "\", \"eventType\":" + this.eventType + ", \"time\":\"" + this.time + "\", \"acceptEncrypt\":\"" + this.acceptEncrypt + "\", \"count\":" + this.count + '}';
    }
}
