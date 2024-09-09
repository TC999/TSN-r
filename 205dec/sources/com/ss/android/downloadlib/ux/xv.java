package com.ss.android.downloadlib.ux;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.downloadlib.r.a;
import com.ss.android.socialbase.appdownloader.f.f;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv implements com.ss.android.download.api.w.c {

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static class c {

        /* renamed from: c  reason: collision with root package name */
        private static xv f48951c = new xv();
    }

    public static xv c() {
        return c.f48951c;
    }

    public void w(String str) {
        w(true, str);
    }

    @Override // com.ss.android.download.api.w.c
    public void c(Throwable th, String str) {
        c(true, th, str);
    }

    public void w(boolean z3, String str) {
        if (w()) {
            return;
        }
        if (z3) {
            w(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        a.c(jSONObject, "msg", str);
        a.c(jSONObject, "stack", c(new Throwable()));
        k.ev().c("service_ttdownloader", 3, jSONObject);
    }

    public void c(boolean z3, Throwable th, String str) {
        if (w()) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        if (z3) {
            w(th);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        a.c(jSONObject, "msg", str);
        a.c(jSONObject, "stack", Log.getStackTraceString(th));
        k.ev().c("service_ttdownloader", 1, jSONObject);
    }

    private void w(Throwable th) {
        if (f.w(k.getContext())) {
            throw new com.ss.android.downloadlib.ux.c(th);
        }
    }

    private boolean w() {
        return k.gd().optInt("enable_monitor", 1) != 1;
    }

    public void c(String str) {
        c(true, str);
    }

    public void c(boolean z3, String str) {
        if (w()) {
            return;
        }
        if (z3) {
            w(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        a.c(jSONObject, "msg", str);
        a.c(jSONObject, "stack", c(new Throwable()));
        k.ev().c("service_ttdownloader", 2, jSONObject);
    }

    public static String c(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception unused) {
            return null;
        }
    }
}
