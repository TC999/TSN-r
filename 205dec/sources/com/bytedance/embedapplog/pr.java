package com.bytedance.embedapplog;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class pr extends i {
    private final n ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public pr(n nVar) {
        super(true, false, false);
        this.ux = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.i
    public boolean c(JSONObject jSONObject) {
        SharedPreferences sr = this.ux.sr();
        String string = sr.getString("install_id", null);
        String string2 = sr.getString("device_id", null);
        String string3 = sr.getString("ssid", null);
        ck.c(jSONObject, "install_id", string);
        ck.c(jSONObject, "device_id", string2);
        ck.c(jSONObject, "ssid", string3);
        long j4 = 0;
        long j5 = sr.getLong("register_time", 0L);
        if ((ck.w(string) && ck.w(string2)) || j5 == 0) {
            j4 = j5;
        } else {
            sr.edit().putLong("register_time", 0L).apply();
        }
        jSONObject.put("register_time", j4);
        return true;
    }
}
