package xyz.adscope.ad.model.http.response.config;

import java.util.List;
import xyz.adscope.common.json.util.JsonUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class TaskModel {
    private int count;
    private int delay;
    private int interval;
    private String macros;
    private List<PkgModel> pkgs;
    private String reportUrl;
    private int taskReport;
    private int taskType;
    private List<TaskUrlsModel> taskUrls;

    public int getCount() {
        return this.count;
    }

    public int getDelay() {
        return this.delay;
    }

    public int getInterval() {
        return this.interval;
    }

    public String getMacros() {
        return this.macros;
    }

    public List<PkgModel> getPkgs() {
        return this.pkgs;
    }

    public String getReportUrl() {
        return this.reportUrl;
    }

    public int getTaskReport() {
        return this.taskReport;
    }

    public int getTaskType() {
        return this.taskType;
    }

    public List<TaskUrlsModel> getTaskUrls() {
        return this.taskUrls;
    }

    public void setCount(int i4) {
        this.count = i4;
    }

    public void setDelay(int i4) {
        this.delay = i4;
    }

    public void setInterval(int i4) {
        this.interval = i4;
    }

    public void setMacros(String str) {
        this.macros = str;
    }

    public void setPkgs(List<PkgModel> list) {
        this.pkgs = list;
    }

    public void setReportUrl(String str) {
        this.reportUrl = str;
    }

    public void setTaskReport(int i4) {
        this.taskReport = i4;
    }

    public void setTaskType(int i4) {
        this.taskType = i4;
    }

    public void setTaskUrls(List<TaskUrlsModel> list) {
        this.taskUrls = list;
    }

    public String toString() {
        return "{\"taskType\":" + this.taskType + ", \"taskReport\":" + this.taskReport + ", \"pkgs\":" + this.pkgs + ", \"delay\":" + this.delay + ", \"interval\":" + this.interval + ", \"taskUrls\":" + this.taskUrls + ", \"macros\":\"" + JsonUtil.addEscapeChar(this.macros) + "\", \"reportUrl\":\"" + this.reportUrl + "\", \"count\":" + this.count + '}';
    }
}
