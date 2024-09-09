package xyz.adscope.amps.model.config.response;

import xyz.adscope.common.json.util.JsonUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ConfigModel {
    private String configURL = "";
    private long checkTime = 0;
    private String biddingURL = "";
    private long maxExpireTime = 0;
    private String version = "";
    private long expireTime = 0;
    private String acceptEncrypt = "";
    private String customData = "";
    private String macro = "";
    private String ext = "";

    public String getAcceptEncrypt() {
        return this.acceptEncrypt;
    }

    public String getBiddingURL() {
        return this.biddingURL;
    }

    public long getCheckTime() {
        return this.checkTime;
    }

    public String getConfigURL() {
        return this.configURL;
    }

    public String getCustomData() {
        return this.customData;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getExt() {
        return this.ext;
    }

    public String getMacro() {
        return this.macro;
    }

    public long getMaxExpireTime() {
        return this.maxExpireTime;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAcceptEncrypt(String str) {
        this.acceptEncrypt = str;
    }

    public void setBiddingURL(String str) {
        this.biddingURL = str;
    }

    public void setCheckTime(long j4) {
        this.checkTime = j4;
    }

    public void setConfigURL(String str) {
        this.configURL = str;
    }

    public void setCustomData(String str) {
        this.customData = str;
    }

    public void setExpireTime(long j4) {
        this.expireTime = j4;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setMacro(String str) {
        this.macro = str;
    }

    public void setMaxExpireTime(long j4) {
        this.maxExpireTime = j4;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "{\"configURL\":\"" + this.configURL + "\", \"checkTime\":" + this.checkTime + ", \"biddingURL\":\"" + this.biddingURL + "\", \"maxExpireTime\":" + this.maxExpireTime + ", \"version\":\"" + this.version + "\", \"expireTime\":" + this.expireTime + ", \"acceptEncrypt\":\"" + this.acceptEncrypt + "\", \"customData\":\"" + JsonUtil.addEscapeChar(this.customData) + "\", \"macro\":\"" + JsonUtil.addEscapeChar(this.macro) + "\", \"ext\":\"" + this.ext + "\"}";
    }
}
