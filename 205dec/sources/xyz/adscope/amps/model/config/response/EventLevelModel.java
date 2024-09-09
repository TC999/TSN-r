package xyz.adscope.amps.model.config.response;

import java.util.List;
import xyz.adscope.common.json.util.JsonUtil;
import xyz.adscope.common.tool.utils.StringUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class EventLevelModel {
    private List<String> codes;
    private String macro = "";
    private String count = "";
    private String reportURL = "";
    private String time = "";
    private String acceptEncrypt = "";
    private String ext = "";

    public String getAcceptEncrypt() {
        return this.acceptEncrypt;
    }

    public List<String> getCodes() {
        return this.codes;
    }

    public String getCount() {
        return this.count;
    }

    public String getExt() {
        return this.ext;
    }

    public String getMacro() {
        return this.macro;
    }

    public String getReportURL() {
        return this.reportURL;
    }

    public String getTime() {
        return this.time;
    }

    public void setAcceptEncrypt(String str) {
        this.acceptEncrypt = str;
    }

    public void setCodes(List<String> list) {
        this.codes = list;
    }

    public void setCount(String str) {
        this.count = str;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setMacro(String str) {
        this.macro = str;
    }

    public void setReportURL(String str) {
        this.reportURL = str;
    }

    public void setTime(String str) {
        this.time = str;
    }

    public String toString() {
        return "{\"macro\":\"" + JsonUtil.addEscapeChar(this.macro) + "\", \"count\":\"" + this.count + "\", \"codes\":" + StringUtil.ListToString(this.codes) + ", \"reportURL\":\"" + this.reportURL + "\", \"time\":\"" + this.time + "\", \"acceptEncrypt\":\"" + this.acceptEncrypt + "\", \"ext\":\"" + this.ext + "\"}";
    }
}
