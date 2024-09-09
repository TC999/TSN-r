package com.bytedance.sdk.component.ev.w;

import android.text.TextUtils;
import com.bytedance.sdk.component.w.c.a;
import com.bytedance.sdk.component.w.c.f;
import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.ia;
import com.bytedance.sdk.component.w.c.p;
import com.bytedance.sdk.component.w.c.t;
import com.bytedance.sdk.component.w.c.ux;
import com.bytedance.sdk.component.w.c.ys;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr extends xv {

    /* renamed from: c  reason: collision with root package name */
    ys f29740c;

    public sr(a aVar) {
        super(aVar);
        this.f29740c = null;
    }

    public void xv(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.f29740c = ys.c(p.c("application/json; charset=utf-8"), str);
    }

    public void c(JSONObject jSONObject) {
        this.f29740c = ys.c(p.c("application/json; charset=utf-8"), jSONObject != null ? jSONObject.toString() : "{}");
    }

    public void c(Map<String, String> map) {
        ux.c cVar = new ux.c();
        if (map != null && !map.isEmpty()) {
            for (String str : map.keySet()) {
                cVar.c(str, map.get(str));
            }
        }
        this.f29740c = cVar.c();
    }

    public void c(String str, byte[] bArr) {
        this.f29740c = ys.c(p.c(str), bArr);
    }

    public void c(final com.bytedance.sdk.component.ev.c.c cVar) {
        try {
            t.c cVar2 = new t.c();
            if (TextUtils.isEmpty(this.f29749f)) {
                cVar.c(this, new IOException("Url is Empty"));
                return;
            }
            cVar2.c(this.f29749f);
            if (this.f29740c == null) {
                if (cVar != null) {
                    cVar.c(this, new IOException("RequestBody is null, content type is not support!!"));
                    return;
                }
                return;
            }
            c(cVar2);
            cVar2.c((Object) w());
            this.xv.c(cVar2.c(this.f29740c).w()).c(new com.bytedance.sdk.component.w.c.xv() { // from class: com.bytedance.sdk.component.ev.w.sr.1
                @Override // com.bytedance.sdk.component.w.c.xv
                public void onFailure(com.bytedance.sdk.component.w.c.w wVar, IOException iOException) {
                    com.bytedance.sdk.component.ev.c.c cVar3 = cVar;
                    if (cVar3 != null) {
                        cVar3.c(sr.this, iOException);
                    }
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:40:0x00eb  */
                /* JADX WARN: Removed duplicated region for block: B:41:0x00f3  */
                @Override // com.bytedance.sdk.component.w.c.xv
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void onResponse(com.bytedance.sdk.component.w.c.w r13, com.bytedance.sdk.component.w.c.fp r14) throws java.io.IOException {
                    /*
                        Method dump skipped, instructions count: 260
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.ev.w.sr.AnonymousClass1.onResponse(com.bytedance.sdk.component.w.c.w, com.bytedance.sdk.component.w.c.fp):void");
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            cVar.c(this, new IOException(th.getMessage()));
        }
    }

    @Override // com.bytedance.sdk.component.ev.w.xv
    public com.bytedance.sdk.component.ev.w c() {
        com.bytedance.sdk.component.ev.w wVar;
        try {
            t.c cVar = new t.c();
            if (TextUtils.isEmpty(this.f29749f)) {
                com.bytedance.sdk.component.ev.sr.ux.w("PostExecutor", "execute: Url is Empty");
                return new com.bytedance.sdk.component.ev.w(false, 5000, "URL_NULL_MSG", null, "URL_NULL_BODY", 1L, 1L);
            }
            cVar.c(this.f29749f);
            if (this.f29740c == null) {
                com.bytedance.sdk.component.ev.sr.ux.w("PostExecutor", "RequestBody is null, content type is not support!!");
                return new com.bytedance.sdk.component.ev.w(false, 5000, "BODY_NULL_MSG", null, "BODY_NULL_BODY", 1L, 1L);
            }
            c(cVar);
            cVar.c((Object) w());
            fp c4 = this.xv.c(cVar.c(this.f29740c).w()).c();
            if (c4 != null) {
                HashMap hashMap = new HashMap();
                f r3 = c4.r();
                if (r3 != null) {
                    for (int i4 = 0; i4 < r3.c(); i4++) {
                        String c5 = r3.c(i4);
                        String w3 = r3.w(i4);
                        hashMap.put(c5, w3);
                        if (c5 != null && c5.equalsIgnoreCase("content-type")) {
                            hashMap.put("content-type", w3 == null ? "" : w3.toLowerCase());
                        }
                    }
                }
                if (com.bytedance.sdk.component.ev.sr.c.c(hashMap)) {
                    byte[] sr = c4.f().sr();
                    wVar = new com.bytedance.sdk.component.ev.w(c4.sr(), c4.xv(), c4.ux(), hashMap, null, c4.w(), c4.c());
                    wVar.c(sr);
                } else if (this.f29750r) {
                    byte[] sr2 = c4.f().sr();
                    wVar = new com.bytedance.sdk.component.ev.w(c4.sr(), c4.xv(), c4.ux(), hashMap, new String(sr2, c(c(c4.f()))), c4.w(), c4.c());
                    wVar.c(sr2);
                } else {
                    wVar = new com.bytedance.sdk.component.ev.w(c4.sr(), c4.xv(), c4.ux(), hashMap, c4.f().w(), c4.w(), c4.c());
                }
                c(wVar, c4);
                return wVar;
            }
            return null;
        } catch (Throwable th) {
            return new com.bytedance.sdk.component.ev.w(false, 5001, th.getMessage(), null, "BODY_NULL_BODY", 1L, 1L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Charset c(p pVar) {
        try {
            return pVar != null ? pVar.c(com.bytedance.sdk.component.w.c.w.p.f30443c) : com.bytedance.sdk.component.w.c.w.p.f30443c;
        } catch (Exception unused) {
            return com.bytedance.sdk.component.w.c.w.p.f30443c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public p c(ia iaVar) {
        try {
            return iaVar.ux();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.component.ev.w wVar, fp fpVar) {
        if (wVar == null || fpVar == null) {
            return;
        }
        wVar.c(fpVar.gd());
    }
}
