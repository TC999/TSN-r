package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SameCommonReporter.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private String f39728a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f39729b;

    /* compiled from: SameCommonReporter.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f39730a;

        /* renamed from: b  reason: collision with root package name */
        private Map<String, String> f39731b = new HashMap();

        public a(String str) {
            this.f39730a = str;
        }

        public final f a() {
            return new f(this);
        }
    }

    public final void a(String str) {
        String str2;
        if (TextUtils.isEmpty(this.f39728a)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("key=");
        sb.append(this.f39728a);
        com.mbridge.msdk.foundation.same.net.g.d dVar = null;
        try {
            str2 = a(this.f39729b);
        } catch (Exception unused) {
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        if (b.a().c()) {
            b.a().a(sb.toString());
            return;
        }
        try {
            dVar = e.a(sb.toString(), com.mbridge.msdk.foundation.controller.a.f().j(), str);
        } catch (Exception unused2) {
        }
        if (dVar != null) {
            try {
                new com.mbridge.msdk.foundation.same.report.d.a(com.mbridge.msdk.foundation.controller.a.f().j()).c(0, com.mbridge.msdk.foundation.same.net.f.d.a().f39564a, dVar, new com.mbridge.msdk.foundation.same.report.d.b() { // from class: com.mbridge.msdk.foundation.same.report.f.1
                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void a(String str3) {
                    }

                    @Override // com.mbridge.msdk.foundation.same.report.d.b
                    public final void b(String str3) {
                    }
                });
            } catch (Exception unused3) {
            }
        }
    }

    private f(a aVar) {
        this.f39728a = aVar.f39730a;
        this.f39729b = aVar.f39731b;
    }

    private String a(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            StringBuilder sb = new StringBuilder();
            try {
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = map.get(str);
                        if (!TextUtils.isEmpty(str2)) {
                            try {
                                str2 = URLEncoder.encode(str2, "utf-8");
                            } catch (Exception unused) {
                            }
                            sb.append("&");
                            sb.append(str);
                            sb.append("=");
                            sb.append(str2);
                        }
                    }
                }
            } catch (Exception unused2) {
                sb = null;
            }
            if (sb != null && sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }
}
