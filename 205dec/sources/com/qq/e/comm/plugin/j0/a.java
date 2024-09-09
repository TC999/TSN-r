package com.qq.e.comm.plugin.j0;

import com.qq.e.comm.plugin.util.d1;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {
    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, JSONObject jSONObject) {
        try {
            jSONObject.putOpt("ctrl_config", com.qq.e.comm.plugin.d0.a.d().f().b(str));
        } catch (JSONException e4) {
            d1.a(e4.getMessage(), e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, JSONObject jSONObject) {
        com.qq.e.comm.plugin.d0.a.d().f().a(str, jSONObject.optJSONObject("ctrl_config"));
    }
}
