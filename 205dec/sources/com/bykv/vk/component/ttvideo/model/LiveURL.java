package com.bykv.vk.component.ttvideo.model;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.Keep;
import org.json.JSONException;
import org.json.JSONObject;

@Keep
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class LiveURL {
    public final String backupURL;
    public final String mainURL;
    public String sdkParams;

    public LiveURL(String str, String str2, String str3) {
        this.mainURL = str;
        this.backupURL = str2;
        this.sdkParams = str3;
    }

    public static LiveURL build(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new LiveURL(jSONObject.optString("main_play_url"), jSONObject.optString("backup_play_url"), jSONObject.optString("SdkParams"));
    }

    public String getVCodec() {
        JSONObject jSONObject;
        try {
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        if (this.sdkParams != null) {
            jSONObject = new JSONObject(this.sdkParams);
            if (jSONObject == null && jSONObject.has("VCodec")) {
                String optString = jSONObject.optString("VCodec");
                if (TextUtils.isEmpty(optString)) {
                    return null;
                }
                return optString;
            }
        }
        jSONObject = null;
        return jSONObject == null ? null : null;
    }
}
