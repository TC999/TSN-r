package com.bytedance.sdk.openadsdk.r;

import android.content.Context;
import com.bytedance.sdk.component.ux.bk;
import com.bytedance.sdk.component.ux.sr;
import com.bytedance.sdk.component.ux.xv.ux;
import com.bytedance.sdk.component.ux.ys;
import com.bytedance.sdk.component.w.c.a;
import com.bytedance.sdk.component.w.c.f;
import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.t;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.n.ev;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {
    @ATSMethod
    public static ys c(Context context, bk bkVar) {
        return com.bytedance.sdk.component.ux.xv.w.c(context, bkVar);
    }

    @ATSMethod
    public static Context getContext() {
        return ls.getContext();
    }

    @ATSMethod
    public static bk c() {
        return new ux.c().c(new com.bytedance.sdk.component.ux.xv.c.c(Math.max(Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 83886080), 10485760), 41943040L, new File(ev.f()))).c(com.bytedance.sdk.component.gd.ev.c()).c(new sr() { // from class: com.bytedance.sdk.openadsdk.r.c.1
            private Map<String, String> c(com.bytedance.sdk.component.ux.ux uxVar, fp fpVar) {
                HashMap hashMap = new HashMap();
                if (uxVar.w()) {
                    f r3 = fpVar.r();
                    int c4 = r3.c();
                    for (int i4 = 0; i4 < c4; i4++) {
                        String c5 = r3.c(i4);
                        String w3 = r3.w(i4);
                        if (c5 != null) {
                            hashMap.put(c5, w3);
                        }
                    }
                }
                return hashMap;
            }

            @Override // com.bytedance.sdk.component.ux.sr
            public com.bytedance.sdk.component.ux.w.sr call(com.bytedance.sdk.component.ux.ux uxVar) {
                long currentTimeMillis = System.currentTimeMillis();
                a ux = com.bytedance.sdk.openadsdk.core.q.ux.c().w().ux();
                t w3 = new t.c().c(uxVar.c()).c().c("csj_client_source_from", "2").w();
                fp fpVar = null;
                com.bytedance.sdk.component.ux.w.ux uxVar2 = uxVar.xv() ? new com.bytedance.sdk.component.ux.w.ux() : null;
                if (uxVar2 != null) {
                    uxVar2.c(currentTimeMillis);
                }
                try {
                    fp c4 = ux.c(w3).c();
                    if (uxVar2 != null) {
                        try {
                            uxVar2.w(System.currentTimeMillis());
                        } catch (Throwable th) {
                            th = th;
                            fpVar = c4;
                            try {
                                return c(uxVar2, th);
                            } finally {
                                com.bytedance.sdk.component.ux.xv.xv.w.c(fpVar);
                            }
                        }
                    }
                    if (uxVar.sr() != null) {
                        uxVar.sr().c(3, null);
                    }
                    Map<String, String> c5 = c(uxVar, c4);
                    byte[] sr = c4.f().sr();
                    c5.put(CampaignEx.JSON_KEY_IMAGE_SIZE, String.valueOf(sr == null ? 0 : sr.length));
                    com.bytedance.sdk.component.ux.w.sr srVar = new com.bytedance.sdk.component.ux.w.sr(c4.xv(), sr, "", c5);
                    if (uxVar2 != null) {
                        uxVar2.xv(System.currentTimeMillis());
                    }
                    srVar.c(uxVar2);
                    com.bytedance.sdk.component.ux.xv.xv.w.c(c4);
                    return srVar;
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            private com.bytedance.sdk.component.ux.w.sr c(com.bytedance.sdk.component.ux.w.ux uxVar, Throwable th) {
                com.bytedance.sdk.component.utils.a.sr("ImageConfig", th.getMessage());
                if (uxVar != null) {
                    uxVar.xv(System.currentTimeMillis());
                }
                com.bytedance.sdk.component.ux.w.sr srVar = new com.bytedance.sdk.component.ux.w.sr(0, th, "net failed");
                srVar.c(uxVar);
                return srVar;
            }
        }).c();
    }
}
