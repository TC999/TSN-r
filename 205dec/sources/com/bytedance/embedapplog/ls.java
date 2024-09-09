package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ls extends i {
    private final Context ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ls(Context context) {
        super(false, false);
        this.ux = context;
    }

    public static String w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(Base64.decode(str.getBytes("UTF-8"), 0));
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.i
    public boolean c(JSONObject jSONObject) {
        SharedPreferences w3 = com.bytedance.sdk.openadsdk.api.plugin.w.w(this.ux, "snssdk_openudid", 0);
        String w4 = w(w3.getString("custom_a", null));
        if (TextUtils.isEmpty(w4)) {
            w4 = w3.getString("clientudid", null);
        }
        if (!ck.c(w4)) {
            try {
                w4 = UUID.randomUUID().toString();
                w4 = c("clientudid.dat", w4);
            } catch (Exception unused) {
            }
            String c4 = c(w4);
            SharedPreferences.Editor edit = w3.edit();
            edit.putString("custom_a", c4);
            edit.apply();
        }
        jSONObject.put("clientudid", w4);
        return true;
    }

    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return Base64.encodeToString(str.getBytes("UTF-8"), 0);
        } catch (UnsupportedEncodingException e4) {
            e4.printStackTrace();
            return str;
        }
    }
}
