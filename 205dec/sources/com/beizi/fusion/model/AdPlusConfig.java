package com.beizi.fusion.model;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AdPlusConfig {
    @JsonNode(key = "adUrl")
    private String adUrl;
    @JsonNode(key = "h5RedirectBlackList")
    private List<String> h5RedirectBlackList;
    @JsonNode(key = "version")
    private String version;

    public static AdPlusConfig objectFromData(String str) {
        try {
            return (AdPlusConfig) JsonResolver.fromJson(str, (Class<Object>) AdPlusConfig.class);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public String getAdUrl() {
        return this.adUrl;
    }

    public List<String> getH5RedirectBlackList() {
        return this.h5RedirectBlackList;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAdUrl(String str) {
        this.adUrl = str;
    }

    public void setH5RedirectBlackList(List<String> list) {
        this.h5RedirectBlackList = list;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public static AdPlusConfig objectFromData(String str, String str2) {
        try {
            return (AdPlusConfig) JsonResolver.fromJson(new JSONObject(str).getString(str), (Class<Object>) AdPlusConfig.class);
        } catch (JSONException e4) {
            e4.printStackTrace();
            return null;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }
}
