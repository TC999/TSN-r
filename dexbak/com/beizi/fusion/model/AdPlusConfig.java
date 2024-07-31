package com.beizi.fusion.model;

import com.baidu.idl.face.platform.common.ConstantHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdPlusConfig {
    @JsonNode(key = "adUrl")
    private String adUrl;
    @JsonNode(key = ConstantHelper.LOG_VS)
    private String version;

    public static AdPlusConfig objectFromData(String str) {
        try {
            return (AdPlusConfig) JsonResolver.fromJson(str, (Class<Object>) AdPlusConfig.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getAdUrl() {
        return this.adUrl;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAdUrl(String str) {
        this.adUrl = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public static AdPlusConfig objectFromData(String str, String str2) {
        try {
            return (AdPlusConfig) JsonResolver.fromJson(new JSONObject(str).getString(str), (Class<Object>) AdPlusConfig.class);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
