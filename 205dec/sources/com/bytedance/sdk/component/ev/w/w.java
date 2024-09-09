package com.bytedance.sdk.component.ev.w;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.sdk.component.ev.sr.ux;
import com.bytedance.sdk.component.w.c.a;
import com.bytedance.sdk.component.w.c.c;
import com.bytedance.sdk.component.w.c.f;
import com.bytedance.sdk.component.w.c.fp;
import com.bytedance.sdk.component.w.c.ia;
import com.bytedance.sdk.component.w.c.r;
import com.bytedance.sdk.component.w.c.t;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends xv {

    /* renamed from: c  reason: collision with root package name */
    public static final com.bytedance.sdk.component.w.c.c f29743c = new c.C0455c().c().w();

    /* renamed from: w  reason: collision with root package name */
    public static final com.bytedance.sdk.component.w.c.c f29744w = new c.C0455c().w();
    private com.bytedance.sdk.component.w.c.c ev;
    private boolean gd;

    /* renamed from: p  reason: collision with root package name */
    private Map<String, String> f29745p;

    public w(a aVar) {
        super(aVar);
        this.ev = f29743c;
        this.gd = false;
        this.f29745p = new HashMap();
    }

    public void c(String str, String str2) {
        if (str == null) {
            ux.w("GetExecutor", "name cannot be null !!!");
        } else {
            this.f29745p.put(str, str2);
        }
    }

    public void c(final com.bytedance.sdk.component.ev.c.c cVar) {
        try {
            t.c cVar2 = new t.c();
            if (this.gd) {
                cVar2.c(this.f29749f);
            } else {
                r.c cVar3 = new r.c();
                Uri parse = Uri.parse(this.f29749f);
                cVar3.c(parse.getScheme());
                cVar3.w(parse.getHost());
                String encodedPath = parse.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith(TTPathConst.sSeparator)) {
                        encodedPath = encodedPath.substring(1);
                    }
                    cVar3.xv(encodedPath);
                }
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str : queryParameterNames) {
                        this.f29745p.put(str, parse.getQueryParameter(str));
                    }
                }
                for (Map.Entry<String, String> entry : this.f29745p.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String encode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        cVar3.c(encode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                cVar2.c(cVar3.w());
            }
            c(cVar2);
            cVar2.c(this.ev);
            cVar2.c((Object) w());
            this.xv.c(cVar2.c().w()).c(new com.bytedance.sdk.component.w.c.xv() { // from class: com.bytedance.sdk.component.ev.w.w.1
                @Override // com.bytedance.sdk.component.w.c.xv
                public void onFailure(com.bytedance.sdk.component.w.c.w wVar, IOException iOException) {
                    com.bytedance.sdk.component.ev.c.c cVar4 = cVar;
                    if (cVar4 != null) {
                        cVar4.c(w.this, iOException);
                    }
                }

                @Override // com.bytedance.sdk.component.w.c.xv
                public void onResponse(com.bytedance.sdk.component.w.c.w wVar, fp fpVar) throws IOException {
                    if (cVar != null) {
                        HashMap hashMap = new HashMap();
                        if (fpVar != null) {
                            f r3 = fpVar.r();
                            if (r3 != null) {
                                for (int i4 = 0; i4 < r3.c(); i4++) {
                                    hashMap.put(r3.c(i4), r3.w(i4));
                                }
                            }
                            ia f4 = fpVar.f();
                            cVar.c(w.this, new com.bytedance.sdk.component.ev.w(fpVar.sr(), fpVar.xv(), fpVar.ux(), hashMap, f4 == null ? "" : f4.w(), fpVar.w(), fpVar.c()));
                        }
                    }
                }
            });
        } catch (Throwable th) {
            if (ux.c()) {
                th.printStackTrace();
            }
            if (cVar != null) {
                cVar.c(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.bytedance.sdk.component.ev.w.xv
    public com.bytedance.sdk.component.ev.w c() {
        try {
            t.c cVar = new t.c();
            String str = "";
            if (this.gd) {
                cVar.c(this.f29749f);
            } else {
                r.c cVar2 = new r.c();
                Uri parse = Uri.parse(this.f29749f);
                cVar2.c(parse.getScheme());
                cVar2.w(parse.getHost());
                String encodedPath = parse.getEncodedPath();
                if (!TextUtils.isEmpty(encodedPath)) {
                    if (encodedPath.startsWith(TTPathConst.sSeparator)) {
                        encodedPath = encodedPath.substring(1);
                    }
                    cVar2.xv(encodedPath);
                }
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    for (String str2 : queryParameterNames) {
                        this.f29745p.put(str2, parse.getQueryParameter(str2));
                    }
                }
                for (Map.Entry<String, String> entry : this.f29745p.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key)) {
                        String encode = URLEncoder.encode(key, "UTF-8");
                        if (value == null) {
                            value = "";
                        }
                        cVar2.c(encode, URLEncoder.encode(value, "UTF-8"));
                    }
                }
                cVar.c(cVar2.w());
            }
            c(cVar);
            cVar.c(this.ev);
            cVar.c((Object) w());
            fp c4 = this.xv.c(cVar.c().w()).c();
            if (c4 != null) {
                HashMap hashMap = new HashMap();
                f r3 = c4.r();
                if (r3 != null) {
                    for (int i4 = 0; i4 < r3.c(); i4++) {
                        hashMap.put(r3.c(i4), r3.w(i4));
                    }
                }
                ia f4 = c4.f();
                if (f4 != null) {
                    str = f4.w();
                }
                return new com.bytedance.sdk.component.ev.w(c4.sr(), c4.xv(), c4.ux(), hashMap, str, c4.w(), c4.c());
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
