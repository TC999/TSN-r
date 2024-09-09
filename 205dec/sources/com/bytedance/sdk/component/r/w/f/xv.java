package com.bytedance.sdk.component.r.w.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.local.JPushConstants;
import com.bytedance.sdk.component.utils.a;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.json.JSONObject;
import xyz.adscope.ad.control.track.AdScopeTrackerTool;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements w {

    /* renamed from: c  reason: collision with root package name */
    private final Context f30086c;

    /* renamed from: w  reason: collision with root package name */
    private final ux f30087w;
    private com.bytedance.sdk.component.r.c.ux xv;

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c extends com.bytedance.sdk.component.r.w.ux.w {
        private final Map<String, String> sr;

        /* renamed from: w  reason: collision with root package name */
        private final sr f30091w;
        private final String xv;

        private String xv(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.contains("{TS}") || str.contains(AdScopeTrackerTool.ts)) {
                long currentTimeMillis = System.currentTimeMillis();
                str = str.replace("{TS}", String.valueOf(currentTimeMillis)).replace(AdScopeTrackerTool.ts, String.valueOf(currentTimeMillis));
            }
            return ((str.contains("{UID}") || str.contains("__UID__")) && !TextUtils.isEmpty(this.xv)) ? str.replace("{UID}", this.xv).replace("__UID__", this.xv) : str;
        }

        boolean c(String str) {
            return !TextUtils.isEmpty(str) && (str.startsWith(JPushConstants.HTTP_PRE) || str.startsWith(JPushConstants.HTTPS_PRE));
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.sdk.component.r.c.sr sr = xv.this.xv.sr();
            if (sr == null || xv.this.xv.getContext() == null || !sr.sr() || !c(this.f30091w.w())) {
                return;
            }
            if (this.f30091w.sr() == 0) {
                xv.this.f30087w.delete(this.f30091w);
                return;
            }
            try {
                sr.bk();
                if (this.f30091w.sr() == 5) {
                    xv.this.f30087w.insert(this.f30091w);
                }
                if (sr.c(xv.this.getContext())) {
                    long currentTimeMillis = System.currentTimeMillis();
                    String w3 = this.f30091w.w();
                    if (sr.p() == 0) {
                        w3 = xv(this.f30091w.w());
                        if (this.f30091w.xv()) {
                            w3 = w(w3);
                        }
                    }
                    String str = w3;
                    com.bytedance.sdk.component.r.c.c.w r3 = sr.r();
                    if (r3 == null) {
                        return;
                    }
                    r3.c("User-Agent", sr.ux());
                    r3.c("csj_client_source_from", "1");
                    if (this.sr != null) {
                        JSONObject jSONObject = new JSONObject();
                        for (Map.Entry<String, String> entry : this.sr.entrySet()) {
                            jSONObject.put(entry.getKey(), entry.getValue());
                        }
                        r3.c("csj_extra_info", jSONObject.toString());
                    }
                    r3.c(str);
                    com.bytedance.sdk.component.r.c.c.ux uxVar = null;
                    try {
                        uxVar = r3.c();
                        sr.c(uxVar.c());
                    } catch (Throwable unused) {
                    }
                    if (uxVar != null && uxVar.c()) {
                        xv.this.f30087w.delete(this.f30091w);
                        com.bytedance.sdk.component.r.w.xv.xv.c("trackurl", "track success : " + this.f30091w.w());
                        sr.c(true, 200, null, str, System.currentTimeMillis() - currentTimeMillis);
                        return;
                    }
                    if (uxVar != null && uxVar.xv() == 8848) {
                        a.w("trackurl", "block url : " + uxVar.sr());
                        xv.this.f30087w.delete(this.f30091w);
                    }
                    com.bytedance.sdk.component.r.w.xv.xv.c("trackurl", "track fail : " + this.f30091w.w(), xv.this.xv);
                    sr srVar = this.f30091w;
                    srVar.c(srVar.sr() + (-1));
                    if (this.f30091w.sr() == 0) {
                        xv.this.f30087w.delete(this.f30091w);
                        com.bytedance.sdk.component.r.w.xv.xv.c("trackurl", "track fail and delete : " + this.f30091w.w(), xv.this.xv);
                    } else {
                        xv.this.f30087w.update(this.f30091w);
                    }
                    if (uxVar != null) {
                        sr.c(false, uxVar.xv(), uxVar.sr(), str, System.currentTimeMillis());
                    } else {
                        sr.c(false, 0, null, str, System.currentTimeMillis());
                    }
                }
            } catch (Throwable unused2) {
            }
        }

        String w(String str) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return str.replace("[ss_random]", String.valueOf(xv.w().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
            } catch (Exception e4) {
                e4.printStackTrace();
                return str;
            }
        }

        private c(sr srVar, String str, Map<String, String> map) {
            super("AdsStats");
            this.f30091w = srVar;
            this.xv = str;
            this.sr = map;
        }
    }

    public xv(ux uxVar, com.bytedance.sdk.component.r.c.ux uxVar2) {
        this.f30086c = uxVar2.getContext();
        this.f30087w = uxVar;
        this.xv = uxVar2;
    }

    private static Random xv() {
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                return SecureRandom.getInstanceStrong();
            } catch (Throwable unused) {
                return new SecureRandom();
            }
        }
        return new SecureRandom();
    }

    @Override // com.bytedance.sdk.component.r.w.f.w
    public void c() {
    }

    public Context getContext() {
        Context context = this.f30086c;
        return context == null ? this.xv.getContext() : context;
    }

    static /* synthetic */ Random w() {
        return xv();
    }

    @Override // com.bytedance.sdk.component.r.w.f.w
    public void c(String str, List<String> list, boolean z3, Map<String, String> map) {
        com.bytedance.sdk.component.r.c.sr sr = this.xv.sr();
        if (sr == null || this.xv.getContext() == null || sr.ev() == null || !sr.sr() || list == null || list.size() == 0) {
            return;
        }
        for (String str2 : list) {
            sr.ev().execute(new c(new sr(UUID.randomUUID().toString() + "_" + System.currentTimeMillis(), str2, z3, 5), str, map));
        }
    }

    @Override // com.bytedance.sdk.component.r.w.f.w
    public void c(final String str) {
        com.bytedance.sdk.component.r.c.sr sr = this.xv.sr();
        if (sr == null || this.xv.getContext() == null || !sr.sr()) {
            return;
        }
        com.bytedance.sdk.component.r.w.ux.w wVar = new com.bytedance.sdk.component.r.w.ux.w("trackFailedUrls") { // from class: com.bytedance.sdk.component.r.w.f.xv.1
            @Override // java.lang.Runnable
            public void run() {
                xv.this.c(xv.this.f30087w.c(), str);
            }
        };
        wVar.c(1);
        if (sr.ev() != null) {
            sr.ev().execute(wVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<sr> list, String str) {
        if (list == null || list.size() == 0) {
            return;
        }
        com.bytedance.sdk.component.r.c.sr sr = this.xv.sr();
        for (sr srVar : list) {
            if (sr != null && sr.ev() != null) {
                sr.ev().execute(new c(srVar, str, null));
            }
        }
    }
}
