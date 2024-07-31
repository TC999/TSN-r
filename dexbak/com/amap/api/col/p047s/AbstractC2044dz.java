package com.amap.api.col.p047s;

import android.text.TextUtils;
import com.amap.api.col.p047s.C2163u2;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Request.java */
/* renamed from: com.amap.api.col.s.dz */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractC2044dz {

    /* renamed from: d */
    C2163u2.InterfaceC2164a f6052d;

    /* renamed from: h */
    private String f6056h;

    /* renamed from: i */
    private boolean f6057i;

    /* renamed from: j */
    private boolean f6058j;

    /* renamed from: a */
    int f6049a = 20000;

    /* renamed from: b */
    int f6050b = 20000;

    /* renamed from: c */
    Proxy f6051c = null;

    /* renamed from: e */
    private boolean f6053e = false;

    /* renamed from: f */
    private int f6054f = 20000;

    /* renamed from: g */
    private boolean f6055g = true;

    /* renamed from: k */
    private EnumC2045a f6059k = EnumC2045a.NORMAL;

    /* renamed from: l */
    private EnumC2046b f6060l = EnumC2046b.FIRST_NONDEGRADE;

    /* compiled from: Request.java */
    /* renamed from: com.amap.api.col.s.dz$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2045a {
        NORMAL(0),
        INTERRUPT_IO(1),
        NEVER(2),
        FIX(3),
        SINGLE(4);
        

        /* renamed from: f */
        private int f6067f;

        EnumC2045a(int i) {
            this.f6067f = i;
        }
    }

    /* compiled from: Request.java */
    /* renamed from: com.amap.api.col.s.dz$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2046b {
        FIRST_NONDEGRADE(0),
        NEVER_GRADE(1),
        DEGRADE_BYERROR(2),
        DEGRADE_ONLY(3),
        FIX_NONDEGRADE(4),
        FIX_DEGRADE_BYERROR(5),
        FIX_DEGRADE_ONLY(6);
        

        /* renamed from: h */
        private int f6076h;

        EnumC2046b(int i) {
            this.f6076h = i;
        }

        /* renamed from: a */
        public final int m53048a() {
            return this.f6076h;
        }

        /* renamed from: b */
        public final boolean m53047b() {
            int i = this.f6076h;
            return i == FIRST_NONDEGRADE.f6076h || i == NEVER_GRADE.f6076h || i == FIX_NONDEGRADE.f6076h;
        }

        /* renamed from: c */
        public final boolean m53046c() {
            int i = this.f6076h;
            return i == DEGRADE_BYERROR.f6076h || i == DEGRADE_ONLY.f6076h || i == FIX_DEGRADE_BYERROR.f6076h || i == FIX_DEGRADE_ONLY.f6076h;
        }

        /* renamed from: d */
        public final boolean m53045d() {
            int i = this.f6076h;
            return i == DEGRADE_BYERROR.f6076h || i == FIX_DEGRADE_BYERROR.f6076h;
        }

        /* renamed from: e */
        public final boolean m53044e() {
            return this.f6076h == NEVER_GRADE.f6076h;
        }
    }

    /* compiled from: Request.java */
    /* renamed from: com.amap.api.col.s.dz$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2047c {
        HTTP(0),
        HTTPS(1);
        

        /* renamed from: c */
        private int f6080c;

        EnumC2047c(int i) {
            this.f6080c = i;
        }
    }

    /* renamed from: b */
    private String m53066b(String str) {
        byte[] mo52382q = mo52382q();
        if (mo52382q == null || mo52382q.length == 0) {
            return str;
        }
        Map<String, String> mo52383o = mo52383o();
        HashMap<String, String> hashMap = C2163u2.f6551e;
        if (hashMap != null) {
            if (mo52383o != null) {
                mo52383o.putAll(hashMap);
            } else {
                mo52383o = hashMap;
            }
        }
        if (mo52383o == null) {
            return str;
        }
        String m52306h = C2202x2.m52306h(mo52383o);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("?");
        stringBuffer.append(m52306h);
        return stringBuffer.toString();
    }

    /* renamed from: c */
    private static String m53065c(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        try {
            if (map.containsKey("platinfo")) {
                return m53060i(map.get("platinfo"));
            }
            return null;
        } catch (Throwable th) {
            C2041d2.m53085e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "pnfh");
            return null;
        }
    }

    /* renamed from: i */
    private static String m53060i(String str) {
        String str2;
        String str3 = "";
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("&");
                if (split.length > 1) {
                    int length = split.length;
                    int i = 0;
                    String str4 = "";
                    while (true) {
                        if (i >= length) {
                            str2 = "";
                            break;
                        }
                        str2 = split[i];
                        if (str2.contains("sdkversion")) {
                            str4 = str2;
                        }
                        if (str2.contains("product")) {
                            break;
                        }
                        i++;
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        String[] split2 = str2.split("=");
                        if (split2.length > 1) {
                            str3 = split2[1].trim();
                            if (!TextUtils.isEmpty(str4) && TextUtils.isEmpty(C2139s1.m52470a(str3))) {
                                String[] split3 = str4.split("=");
                                if (split3.length > 1) {
                                    C2139s1.m52469b(str3, split3[1].trim());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            C2041d2.m53085e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "pnfp");
        }
        return str3;
    }

    /* renamed from: A */
    public final C2163u2.InterfaceC2164a m53073A() {
        return this.f6052d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: B */
    public final EnumC2046b m53072B() {
        return this.f6060l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C */
    public final int m53071C() {
        return this.f6054f;
    }

    /* renamed from: D */
    public final void m53070D() {
        this.f6055g = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: E */
    public final String m53069E() {
        return this.f6056h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: F */
    public final boolean m53068F() {
        return this.f6057i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: G */
    public final String m53067G() {
        String str;
        try {
            str = mo52630m();
        } catch (Throwable th) {
            th = th;
            str = "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                if (this.f6053e) {
                    str = m53060i(((AbstractC2188v2) this).m52385N());
                } else {
                    str = m53065c(mo52199p());
                }
            }
        } catch (Throwable th2) {
            th = th2;
            C2041d2.m53085e(th, DownloadCommon.DOWNLOAD_REPORT_HOST, "pnfr");
            return str;
        }
        return str;
    }

    /* renamed from: a */
    public String mo52200a() {
        return mo52180h();
    }

    /* renamed from: d */
    public final void m53064d(int i) {
        this.f6049a = i;
    }

    /* renamed from: e */
    public final void m53063e(EnumC2045a enumC2045a) {
        this.f6059k = enumC2045a;
    }

    /* renamed from: f */
    public final void m53062f(EnumC2046b enumC2046b) {
        this.f6060l = enumC2046b;
    }

    /* renamed from: g */
    public final void m53061g(EnumC2047c enumC2047c) {
        this.f6058j = enumC2047c == EnumC2047c.HTTPS;
    }

    /* renamed from: h */
    public abstract String mo52180h();

    /* renamed from: j */
    public final void m53059j(int i) {
        this.f6050b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public boolean mo53010k() {
        return this.f6055g;
    }

    /* renamed from: l */
    public final void m53058l(int i) {
        this.f6054f = i;
    }

    /* renamed from: m */
    public String mo52630m() {
        return "";
    }

    /* renamed from: n */
    public final void m53057n(String str) {
        this.f6056h = str;
    }

    /* renamed from: o */
    public abstract Map<String, String> mo52383o();

    /* renamed from: p */
    public abstract Map<String, String> mo52199p();

    /* renamed from: q */
    public byte[] mo52382q() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: r */
    public String mo52198r() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public final String m53056s() {
        return m53066b(mo52180h());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: t */
    public final String m53055t() {
        return m53066b(mo52200a());
    }

    /* renamed from: u */
    public final int m53054u() {
        return this.f6049a;
    }

    /* renamed from: v */
    public final Proxy m53053v() {
        return this.f6051c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: w */
    public final EnumC2045a m53052w() {
        return this.f6059k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: x */
    public final boolean m53051x() {
        return this.f6053e;
    }

    /* renamed from: y */
    public final void m53050y() {
        this.f6053e = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: z */
    public final boolean m53049z() {
        return this.f6058j;
    }
}
