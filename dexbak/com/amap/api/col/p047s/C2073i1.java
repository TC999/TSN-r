package com.amap.api.col.p047s;

import android.text.TextUtils;

/* compiled from: SDKInfo.java */
/* renamed from: com.amap.api.col.s.i1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2073i1 {

    /* renamed from: a */
    private String f6187a;

    /* renamed from: b */
    private String f6188b;

    /* renamed from: c */
    private int f6189c;

    /* renamed from: d */
    private String f6190d;

    /* renamed from: e */
    private String f6191e;

    /* renamed from: f */
    private String f6192f;

    /* renamed from: g */
    private String f6193g;

    /* renamed from: h */
    private String f6194h;

    /* renamed from: i */
    private String f6195i;

    /* renamed from: j */
    private String f6196j;

    /* renamed from: k */
    private String f6197k;

    /* renamed from: l */
    private String[] f6198l;

    /* compiled from: SDKInfo.java */
    /* renamed from: com.amap.api.col.s.i1$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2074a {

        /* renamed from: a */
        private String f6199a;

        /* renamed from: b */
        private String f6200b;

        /* renamed from: c */
        private String f6201c;

        /* renamed from: d */
        private String f6202d;

        /* renamed from: e */
        private boolean f6203e = true;

        /* renamed from: f */
        private String f6204f = "standard";

        /* renamed from: g */
        private String[] f6205g = null;

        public C2074a(String str, String str2, String str3) {
            this.f6199a = str2;
            this.f6200b = str2;
            this.f6202d = str3;
            this.f6201c = str;
        }

        /* renamed from: a */
        public final C2074a m52912a(String str) {
            this.f6200b = str;
            return this;
        }

        /* renamed from: b */
        public final C2074a m52911b(boolean z) {
            this.f6203e = z;
            return this;
        }

        /* renamed from: c */
        public final C2074a m52910c(String[] strArr) {
            if (strArr != null) {
                this.f6205g = (String[]) strArr.clone();
            }
            return this;
        }

        /* renamed from: d */
        public final C2073i1 m52909d() throws C2022bv {
            if (this.f6205g != null) {
                return new C2073i1(this, (byte) 0);
            }
            throw new C2022bv("sdk packages is null");
        }
    }

    /* synthetic */ C2073i1(C2074a c2074a, byte b) {
        this(c2074a);
    }

    /* renamed from: a */
    private static String m52921a(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            for (String str : strArr) {
                sb.append(str);
                sb.append(";");
            }
            return sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: c */
    private static String[] m52919c(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    public final void m52920b() {
        this.f6189c = 1;
    }

    /* renamed from: d */
    public final String m52918d() {
        if (TextUtils.isEmpty(this.f6196j) && !TextUtils.isEmpty(this.f6187a)) {
            this.f6196j = C2079j1.m52857t(this.f6187a);
        }
        return this.f6196j;
    }

    /* renamed from: e */
    public final String m52917e() {
        return this.f6193g;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (C2073i1.class != obj.getClass()) {
            return false;
        }
        try {
            if (this.f6196j.equals(((C2073i1) obj).f6196j) && this.f6193g.equals(((C2073i1) obj).f6193g)) {
                if (this.f6194h.equals(((C2073i1) obj).f6194h)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: f */
    public final String m52916f() {
        if (TextUtils.isEmpty(this.f6194h) && !TextUtils.isEmpty(this.f6188b)) {
            this.f6194h = C2079j1.m52857t(this.f6188b);
        }
        return this.f6194h;
    }

    /* renamed from: g */
    public final String m52915g() {
        if (TextUtils.isEmpty(this.f6197k) && !TextUtils.isEmpty(this.f6192f)) {
            this.f6197k = C2079j1.m52857t(this.f6192f);
        }
        if (TextUtils.isEmpty(this.f6197k)) {
            this.f6197k = "standard";
        }
        return this.f6197k;
    }

    /* renamed from: h */
    public final boolean m52914h() {
        return this.f6189c == 1;
    }

    /* renamed from: i */
    public final String[] m52913i() {
        String[] strArr = this.f6198l;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.f6191e)) {
            this.f6198l = m52919c(C2079j1.m52857t(this.f6191e));
        }
        return (String[]) this.f6198l.clone();
    }

    private C2073i1() {
        this.f6189c = 1;
        this.f6198l = null;
    }

    private C2073i1(C2074a c2074a) {
        this.f6189c = 1;
        this.f6198l = null;
        this.f6193g = c2074a.f6199a;
        this.f6194h = c2074a.f6200b;
        this.f6196j = c2074a.f6201c;
        this.f6195i = c2074a.f6202d;
        this.f6189c = c2074a.f6203e ? 1 : 0;
        this.f6197k = c2074a.f6204f;
        this.f6198l = c2074a.f6205g;
        this.f6188b = C2079j1.m52860q(this.f6194h);
        this.f6187a = C2079j1.m52860q(this.f6196j);
        this.f6190d = C2079j1.m52860q(this.f6195i);
        this.f6191e = C2079j1.m52860q(m52921a(this.f6198l));
        this.f6192f = C2079j1.m52860q(this.f6197k);
    }
}
