package com.ss.android.downloadlib.addownload.compliance;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.ss.android.downloadlib.addownload.k;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f48444c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private static f f48451c = new f();
    }

    private f() {
        this.f48444c = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String w() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f48444c.get() < 3 ? "https://apps.bytesfield.com" : "https://apps.bytesfield-b.com");
        sb.append("/customer/api/app/deep_link");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(@NonNull final com.ss.android.downloadlib.addownload.w.ux uxVar, final String str, final byte[] bArr, final ev evVar) {
        k.sr().c(str, bArr, "application/json; charset=utf-8", 0, new com.ss.android.download.api.config.s() { // from class: com.ss.android.downloadlib.addownload.compliance.f.2
            @Override // com.ss.android.download.api.config.s
            public void c(String str2) {
                f.this.c(uxVar, str2, evVar);
            }

            @Override // com.ss.android.download.api.config.s
            public void c(Throwable th) {
                f.this.c(uxVar, str, bArr, evVar);
            }
        });
    }

    public static f c() {
        return c.f48451c;
    }

    public void c(final com.ss.android.downloadlib.addownload.w.ux uxVar, final ev evVar) {
        if (k.sr() == null) {
            com.ss.android.downloadlib.ux.xv.c().c("getDownloadNetworkFactory == NULL");
            c(401, uxVar);
            return;
        }
        com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.f.1
            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                fVar.w(uxVar, fVar.w(), f.this.c(uxVar, true, 4), evVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.ss.android.downloadlib.addownload.w.ux uxVar, String str, byte[] bArr, ev evVar) {
        if (this.f48444c.get() < 6) {
            this.f48444c.incrementAndGet();
            w(uxVar, str, bArr, evVar);
            return;
        }
        c("\u5f53\u524d\u7f51\u7edc\u4e0d\u4f73\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5");
        this.f48444c.set(0);
        c(402, uxVar);
    }

    private void c(final String str) {
        com.ss.android.downloadlib.r.c().w().post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.f.3
            @Override // java.lang.Runnable
            public void run() {
                k.xv().c(6, k.getContext(), null, str, null, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] c(com.ss.android.downloadlib.addownload.w.ux uxVar, boolean z3, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DownloadModel.DOWNLOAD_URL, uxVar.c());
            jSONObject.put("package_name", uxVar.ux());
            jSONObject.put("call_scene", 50);
            if (z3) {
                jSONObject.put("sender_package_name", k.getContext().getPackageName());
                jSONObject.put("sender_version", k.p().ux);
                if (i4 > 0) {
                    jSONObject.put("store", i4);
                }
            } else {
                jSONObject.put("id", String.valueOf(uxVar.w()));
                if (uxVar.i().getDeepLink() != null) {
                    if (TextUtils.isEmpty(uxVar.i().getDeepLink().getWebUrl())) {
                        com.ss.android.downloadlib.ux.xv.c().c("web_url is null");
                    }
                    jSONObject.put("web_url", uxVar.i().getDeepLink().getWebUrl());
                } else {
                    com.ss.android.downloadlib.ux.xv.c().c("deeplink is null");
                }
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.ux.xv.c().c("param build error");
        }
        return jSONObject.toString().getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull com.ss.android.downloadlib.addownload.w.ux uxVar, String str, ev evVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.ux.xv.c().c("response content is null");
                c(404, uxVar);
                evVar.c();
                return;
            }
            this.f48444c.set(0);
            ux r3 = ux.r(str);
            if (r3.c() != 0) {
                c(403, uxVar);
                evVar.c();
            } else if (TextUtils.isEmpty(r3.w())) {
                c(405, uxVar);
                evVar.c();
            } else {
                evVar.c(r3.w());
            }
        } catch (Exception e4) {
            com.ss.android.downloadlib.ux.xv.c().c(e4, "DownloadMiuiMarketHelper parseResponse");
        }
    }

    public void c(int i4, com.ss.android.downloadlib.addownload.w.ux uxVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_miui_market_fail_code", Integer.valueOf(i4));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadlib.sr.c.c().c("get_miui_market_compliance_error", jSONObject, uxVar);
    }

    public void c(int i4, com.ss.android.downloadlib.addownload.w.ux uxVar, JSONObject jSONObject) {
        try {
            jSONObject.putOpt("download_miui_market_success_result", Integer.valueOf(i4));
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.ss.android.downloadlib.sr.c.c().c("get_miui_market_compliance_success", jSONObject, uxVar);
    }
}
