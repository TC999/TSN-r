package com.amap.api.col.s;

import android.text.TextUtils;
import com.amap.api.col.s.u2;
import com.bytedance.msdk.adapter.pangle_csjm.PangleAdapterUtils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Request.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class dz {

    /* renamed from: d  reason: collision with root package name */
    u2.a f9780d;

    /* renamed from: h  reason: collision with root package name */
    private String f9784h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9785i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9786j;

    /* renamed from: a  reason: collision with root package name */
    int f9777a = 20000;

    /* renamed from: b  reason: collision with root package name */
    int f9778b = 20000;

    /* renamed from: c  reason: collision with root package name */
    Proxy f9779c = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9781e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f9782f = 20000;

    /* renamed from: g  reason: collision with root package name */
    private boolean f9783g = true;

    /* renamed from: k  reason: collision with root package name */
    private a f9787k = a.NORMAL;

    /* renamed from: l  reason: collision with root package name */
    private b f9788l = b.FIRST_NONDEGRADE;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Request.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum a {
        NORMAL(0),
        INTERRUPT_IO(1),
        NEVER(2),
        FIX(3),
        SINGLE(4);
        

        /* renamed from: f  reason: collision with root package name */
        private int f9795f;

        a(int i4) {
            this.f9795f = i4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Request.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum b {
        FIRST_NONDEGRADE(0),
        NEVER_GRADE(1),
        DEGRADE_BYERROR(2),
        DEGRADE_ONLY(3),
        FIX_NONDEGRADE(4),
        FIX_DEGRADE_BYERROR(5),
        FIX_DEGRADE_ONLY(6);
        

        /* renamed from: h  reason: collision with root package name */
        private int f9804h;

        b(int i4) {
            this.f9804h = i4;
        }

        public final int a() {
            return this.f9804h;
        }

        public final boolean b() {
            int i4 = this.f9804h;
            return i4 == FIRST_NONDEGRADE.f9804h || i4 == NEVER_GRADE.f9804h || i4 == FIX_NONDEGRADE.f9804h;
        }

        public final boolean c() {
            int i4 = this.f9804h;
            return i4 == DEGRADE_BYERROR.f9804h || i4 == DEGRADE_ONLY.f9804h || i4 == FIX_DEGRADE_BYERROR.f9804h || i4 == FIX_DEGRADE_ONLY.f9804h;
        }

        public final boolean d() {
            int i4 = this.f9804h;
            return i4 == DEGRADE_BYERROR.f9804h || i4 == FIX_DEGRADE_BYERROR.f9804h;
        }

        public final boolean e() {
            return this.f9804h == NEVER_GRADE.f9804h;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Request.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum c {
        HTTP(0),
        HTTPS(1);
        

        /* renamed from: c  reason: collision with root package name */
        private int f9808c;

        c(int i4) {
            this.f9808c = i4;
        }
    }

    private String b(String str) {
        byte[] q3 = q();
        if (q3 == null || q3.length == 0) {
            return str;
        }
        Map<String, String> o4 = o();
        HashMap<String, String> hashMap = u2.f10279e;
        if (hashMap != null) {
            if (o4 != null) {
                o4.putAll(hashMap);
            } else {
                o4 = hashMap;
            }
        }
        if (o4 == null) {
            return str;
        }
        String h4 = x2.h(o4);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?");
        stringBuffer.append(h4);
        return stringBuffer.toString();
    }

    private static String c(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return i(map.get("platinfo"));
            }
            return null;
        } catch (Throwable th) {
            d2.e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "pnfh");
            return null;
        }
    }

    private static String i(String str) {
        String str2;
        String str3 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("&");
                if (split.length > 1) {
                    int length = split.length;
                    int i4 = 0;
                    String str4 = "";
                    while (true) {
                        if (i4 >= length) {
                            str2 = "";
                            break;
                        }
                        str2 = split[i4];
                        if (str2.contains("sdkversion")) {
                            str4 = str2;
                        }
                        if (str2.contains(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT)) {
                            break;
                        }
                        i4++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split2 = str2.split("=");
                        if (split2.length > 1) {
                            str3 = split2[1].trim();
                            if (!TextUtils.isEmpty(str4) && TextUtils.isEmpty(s1.a(str3))) {
                                String[] split3 = str4.split("=");
                                if (split3.length > 1) {
                                    s1.b(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            d2.e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "pnfp");
        }
        return str3;
    }

    public final u2.a A() {
        return this.f9780d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b B() {
        return this.f9788l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int C() {
        return this.f9782f;
    }

    public final void D() {
        this.f9783g = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String E() {
        return this.f9784h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean F() {
        return this.f9785i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String G() {
        String str;
        try {
            str = m();
        } catch (Throwable th) {
            th = th;
            str = "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                if (this.f9781e) {
                    str = i(((v2) this).N());
                } else {
                    str = c(p());
                }
            }
        } catch (Throwable th2) {
            th = th2;
            d2.e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "pnfr");
            return str;
        }
        return str;
    }

    public String a() {
        return h();
    }

    public final void d(int i4) {
        this.f9777a = i4;
    }

    public final void e(a aVar) {
        this.f9787k = aVar;
    }

    public final void f(b bVar) {
        this.f9788l = bVar;
    }

    public final void g(c cVar) {
        this.f9786j = cVar == c.HTTPS;
    }

    public abstract String h();

    public final void j(int i4) {
        this.f9778b = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean k() {
        return this.f9783g;
    }

    public final void l(int i4) {
        this.f9782f = i4;
    }

    public String m() {
        return "";
    }

    public final void n(String str) {
        this.f9784h = str;
    }

    public abstract Map<String, String> o();

    public abstract Map<String, String> p();

    public byte[] q() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String r() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String s() {
        return b(h());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String t() {
        return b(a());
    }

    public final int u() {
        return this.f9777a;
    }

    public final Proxy v() {
        return this.f9779c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a w() {
        return this.f9787k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean x() {
        return this.f9781e;
    }

    public final void y() {
        this.f9781e = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean z() {
        return this.f9786j;
    }
}
