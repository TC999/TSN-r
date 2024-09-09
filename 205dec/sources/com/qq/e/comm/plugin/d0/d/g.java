package com.qq.e.comm.plugin.d0.d;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class g extends b {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object a(String str) {
        return this.f42239a.opt(str);
    }

    public String toString() {
        return "GDTSDKSetting[" + this.f42239a.toString() + "]";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, Object obj) {
        try {
            this.f42239a.putOpt(str, obj);
        } catch (JSONException unused) {
            GDTLogger.d("Exception while update setting");
        }
    }
}
