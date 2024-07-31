package com.p521ss.android.downloadlib.p536n;

import android.text.TextUtils;
import android.util.Log;
import com.p521ss.android.download.api.p522a.InterfaceC11950ok;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12316kf;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.n.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12235bl implements InterfaceC11950ok {

    /* renamed from: com.ss.android.downloadlib.n.bl$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C12236ok {

        /* renamed from: ok */
        private static C12235bl f34516ok = new C12235bl();
    }

    /* renamed from: ok */
    public static C12235bl m18640ok() {
        return C12236ok.f34516ok;
    }

    /* renamed from: a */
    public void m18643a(String str) {
        m18641a(true, str);
    }

    /* renamed from: a */
    public void m18641a(boolean z, String str) {
        if (m18644a()) {
            return;
        }
        if (z) {
            m18642a(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        C12197j.m18778ok(jSONObject, "msg", str);
        C12197j.m18778ok(jSONObject, "stack", m18638ok(new Throwable()));
        C12128r.m18947p().mo18933ok("service_ttdownloader", 3, jSONObject);
    }

    @Override // com.p521ss.android.download.api.p522a.InterfaceC11950ok
    /* renamed from: ok */
    public void mo18637ok(Throwable th, String str) {
        m18635ok(true, th, str);
    }

    /* renamed from: ok */
    public void m18635ok(boolean z, Throwable th, String str) {
        if (m18644a()) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        if (z) {
            m18642a(th);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        C12197j.m18778ok(jSONObject, "msg", str);
        C12197j.m18778ok(jSONObject, "stack", Log.getStackTraceString(th));
        C12128r.m18947p().mo18933ok("service_ttdownloader", 1, jSONObject);
    }

    /* renamed from: a */
    private void m18642a(Throwable th) {
        if (C12316kf.m18258a(C12128r.getContext())) {
            throw new C12237ok(th);
        }
    }

    /* renamed from: a */
    private boolean m18644a() {
        return C12128r.m18946q().optInt("enable_monitor", 1) != 1;
    }

    /* renamed from: ok */
    public void m18639ok(String str) {
        m18636ok(true, str);
    }

    /* renamed from: ok */
    public void m18636ok(boolean z, String str) {
        if (m18644a()) {
            return;
        }
        if (z) {
            m18642a(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        C12197j.m18778ok(jSONObject, "msg", str);
        C12197j.m18778ok(jSONObject, "stack", m18638ok(new Throwable()));
        C12128r.m18947p().mo18933ok("service_ttdownloader", 2, jSONObject);
    }

    /* renamed from: ok */
    public static String m18638ok(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception unused) {
            return null;
        }
    }
}
