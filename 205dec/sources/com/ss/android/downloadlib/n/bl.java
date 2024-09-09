package com.ss.android.downloadlib.n;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.appdownloader.kf.kf;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl implements com.ss.android.download.api.a.ok {

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class ok {
        private static bl ok = new bl();
    }

    public static bl ok() {
        return ok.ok;
    }

    public void a(String str) {
        a(true, str);
    }

    public void a(boolean z3, String str) {
        if (a()) {
            return;
        }
        if (z3) {
            a(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        j.ok(jSONObject, "msg", str);
        j.ok(jSONObject, "stack", ok(new Throwable()));
        r.p().ok("service_ttdownloader", 3, jSONObject);
    }

    @Override // com.ss.android.download.api.a.ok
    public void ok(Throwable th, String str) {
        ok(true, th, str);
    }

    public void ok(boolean z3, Throwable th, String str) {
        if (a()) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        if (z3) {
            a(th);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        j.ok(jSONObject, "msg", str);
        j.ok(jSONObject, "stack", Log.getStackTraceString(th));
        r.p().ok("service_ttdownloader", 1, jSONObject);
    }

    private void a(Throwable th) {
        if (kf.a(r.getContext())) {
            throw new com.ss.android.downloadlib.n.ok(th);
        }
    }

    private boolean a() {
        return r.q().optInt("enable_monitor", 1) != 1;
    }

    public void ok(String str) {
        ok(true, str);
    }

    public void ok(boolean z3, String str) {
        if (a()) {
            return;
        }
        if (z3) {
            a(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        j.ok(jSONObject, "msg", str);
        j.ok(jSONObject, "stack", ok(new Throwable()));
        r.p().ok("service_ttdownloader", 2, jSONObject);
    }

    public static String ok(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception unused) {
            return null;
        }
    }
}
