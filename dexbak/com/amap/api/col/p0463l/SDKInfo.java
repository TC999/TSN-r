package com.amap.api.col.p0463l;

import android.text.TextUtils;

@EntityClass(m54740a = "a")
/* renamed from: com.amap.api.col.3l.o4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class SDKInfo {
    @EntityField(m54738a = "a1", m54737b = 6)

    /* renamed from: a */
    private String f4784a;
    @EntityField(m54738a = "a2", m54737b = 6)

    /* renamed from: b */
    private String f4785b;
    @EntityField(m54738a = "a6", m54737b = 2)

    /* renamed from: c */
    private int f4786c;
    @EntityField(m54738a = "a3", m54737b = 6)

    /* renamed from: d */
    private String f4787d;
    @EntityField(m54738a = "a4", m54737b = 6)

    /* renamed from: e */
    private String f4788e;
    @EntityField(m54738a = "a5", m54737b = 6)

    /* renamed from: f */
    private String f4789f;

    /* renamed from: g */
    private String f4790g;

    /* renamed from: h */
    private String f4791h;

    /* renamed from: i */
    private String f4792i;

    /* renamed from: j */
    private String f4793j;

    /* renamed from: k */
    private String f4794k;

    /* renamed from: l */
    private String[] f4795l;

    /* compiled from: SDKInfo.java */
    /* renamed from: com.amap.api.col.3l.o4$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1869a {

        /* renamed from: a */
        private String f4796a;

        /* renamed from: b */
        private String f4797b;

        /* renamed from: c */
        private String f4798c;

        /* renamed from: d */
        private String f4799d;

        /* renamed from: e */
        private boolean f4800e = true;

        /* renamed from: f */
        private String f4801f = "standard";

        /* renamed from: g */
        private String[] f4802g = null;

        public C1869a(String str, String str2, String str3) {
            this.f4796a = str2;
            this.f4797b = str2;
            this.f4799d = str3;
            this.f4798c = str;
        }

        /* renamed from: a */
        public final C1869a m54391a(String str) {
            this.f4797b = str;
            return this;
        }

        /* renamed from: b */
        public final C1869a m54390b(String[] strArr) {
            if (strArr != null) {
                this.f4802g = (String[]) strArr.clone();
            }
            return this;
        }

        /* renamed from: c */
        public final SDKInfo m54389c() throws AMapCoreException {
            if (this.f4802g != null) {
                return new SDKInfo(this, (byte) 0);
            }
            throw new AMapCoreException("sdk packages is null");
        }
    }

    /* synthetic */ SDKInfo(C1869a c1869a, byte b) {
        this(c1869a);
    }

    /* renamed from: b */
    private static String m54399b(String[] strArr) {
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

    /* renamed from: d */
    private static String[] m54397d(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public final String m54400a() {
        if (TextUtils.isEmpty(this.f4793j) && !TextUtils.isEmpty(this.f4784a)) {
            this.f4793j = C1925p4.m54183u(this.f4784a);
        }
        return this.f4793j;
    }

    /* renamed from: c */
    public final void m54398c(boolean z) {
        this.f4786c = z ? 1 : 0;
    }

    /* renamed from: e */
    public final String m54396e() {
        return this.f4790g;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (SDKInfo.class != obj.getClass()) {
            return false;
        }
        try {
            if (this.f4793j.equals(((SDKInfo) obj).f4793j) && this.f4790g.equals(((SDKInfo) obj).f4790g)) {
                if (this.f4791h.equals(((SDKInfo) obj).f4791h)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: f */
    public final String m54395f() {
        if (TextUtils.isEmpty(this.f4791h) && !TextUtils.isEmpty(this.f4785b)) {
            this.f4791h = C1925p4.m54183u(this.f4785b);
        }
        return this.f4791h;
    }

    /* renamed from: g */
    public final String m54394g() {
        if (TextUtils.isEmpty(this.f4794k) && !TextUtils.isEmpty(this.f4789f)) {
            this.f4794k = C1925p4.m54183u(this.f4789f);
        }
        if (TextUtils.isEmpty(this.f4794k)) {
            this.f4794k = "standard";
        }
        return this.f4794k;
    }

    /* renamed from: h */
    public final boolean m54393h() {
        return this.f4786c == 1;
    }

    /* renamed from: i */
    public final String[] m54392i() {
        String[] strArr = this.f4795l;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.f4788e)) {
            this.f4795l = m54397d(C1925p4.m54183u(this.f4788e));
        }
        return (String[]) this.f4795l.clone();
    }

    private SDKInfo() {
        this.f4786c = 1;
        this.f4795l = null;
    }

    private SDKInfo(C1869a c1869a) {
        this.f4786c = 1;
        this.f4795l = null;
        this.f4790g = c1869a.f4796a;
        this.f4791h = c1869a.f4797b;
        this.f4793j = c1869a.f4798c;
        this.f4792i = c1869a.f4799d;
        this.f4786c = c1869a.f4800e ? 1 : 0;
        this.f4794k = c1869a.f4801f;
        this.f4795l = c1869a.f4802g;
        this.f4785b = C1925p4.m54187q(this.f4791h);
        this.f4784a = C1925p4.m54187q(this.f4793j);
        this.f4787d = C1925p4.m54187q(this.f4792i);
        this.f4788e = C1925p4.m54187q(m54399b(this.f4795l));
        this.f4789f = C1925p4.m54187q(this.f4794k);
    }
}
