package com.beizi.fusion.model;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class IncentiveConfig {
    @JsonNode(key = "authUrl")
    private String authUrl;
    @JsonNode(key = "configVersion")
    private String configVersion;
    @JsonNode(key = "macro")
    private String macro;
    @JsonNode(key = "rtaUrl")
    private String rtaUrl;
    @JsonNode(key = "transferUrl")
    private String transferUrl;
    @JsonNode(key = "userInfoUrl")
    private String userInfoUrl;

    public static IncentiveConfig objectFromData(String str) {
        try {
            return (IncentiveConfig) JsonResolver.fromJson(str, (Class<Object>) IncentiveConfig.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getAuthUrl() {
        return this.authUrl;
    }

    public String getConfigVersion() {
        return this.configVersion;
    }

    public String getMacro() {
        return this.macro;
    }

    public String getRtaUrl() {
        return this.rtaUrl;
    }

    public String getTransferUrl() {
        return this.transferUrl;
    }

    public String getUserInfoUrl() {
        return this.userInfoUrl;
    }

    public void setAuthUrl(String str) {
        this.authUrl = str;
    }

    public void setConfigVersion(String str) {
        this.configVersion = str;
    }

    public void setMacro(String str) {
        this.macro = str;
    }

    public void setRtaUrl(String str) {
        this.rtaUrl = str;
    }

    public void setTransferUrl(String str) {
        this.transferUrl = str;
    }

    public void setUserInfoUrl(String str) {
        this.userInfoUrl = str;
    }

    public static IncentiveConfig objectFromData(String str, String str2) {
        try {
            return (IncentiveConfig) JsonResolver.fromJson(new JSONObject(str).getString(str), (Class<Object>) IncentiveConfig.class);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
