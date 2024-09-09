package com.amap.api.col.p0003l;

import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SDKInfo.java */
@hk(a = "a")
/* renamed from: com.amap.api.col.3l.p4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class p4 {
    @hl(a = "a1", b = 6)

    /* renamed from: a  reason: collision with root package name */
    private String f8623a;
    @hl(a = "a2", b = 6)

    /* renamed from: b  reason: collision with root package name */
    private String f8624b;
    @hl(a = "a6", b = 2)

    /* renamed from: c  reason: collision with root package name */
    private int f8625c;
    @hl(a = "a3", b = 6)

    /* renamed from: d  reason: collision with root package name */
    private String f8626d;
    @hl(a = "a4", b = 6)

    /* renamed from: e  reason: collision with root package name */
    private String f8627e;
    @hl(a = "a5", b = 6)

    /* renamed from: f  reason: collision with root package name */
    private String f8628f;

    /* renamed from: g  reason: collision with root package name */
    private String f8629g;

    /* renamed from: h  reason: collision with root package name */
    private String f8630h;

    /* renamed from: i  reason: collision with root package name */
    private String f8631i;

    /* renamed from: j  reason: collision with root package name */
    private String f8632j;

    /* renamed from: k  reason: collision with root package name */
    private String f8633k;

    /* renamed from: l  reason: collision with root package name */
    private String[] f8634l;

    /* compiled from: SDKInfo.java */
    /* renamed from: com.amap.api.col.3l.p4$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f8635a;

        /* renamed from: b  reason: collision with root package name */
        private String f8636b;

        /* renamed from: c  reason: collision with root package name */
        private String f8637c;

        /* renamed from: d  reason: collision with root package name */
        private String f8638d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f8639e = true;

        /* renamed from: f  reason: collision with root package name */
        private String f8640f = "standard";

        /* renamed from: g  reason: collision with root package name */
        private String[] f8641g = null;

        public a(String str, String str2, String str3) {
            this.f8635a = str2;
            this.f8636b = str2;
            this.f8638d = str3;
            this.f8637c = str;
        }

        public final a a(String str) {
            this.f8636b = str;
            return this;
        }

        public final a b(String[] strArr) {
            if (strArr != null) {
                this.f8641g = (String[]) strArr.clone();
            }
            return this;
        }

        public final p4 c() throws fk {
            if (this.f8641g != null) {
                return new p4(this, (byte) 0);
            }
            throw new fk("sdk packages is null");
        }
    }

    /* synthetic */ p4(a aVar, byte b4) {
        this(aVar);
    }

    private static String b(String[] strArr) {
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

    private static String[] d(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final String a() {
        if (TextUtils.isEmpty(this.f8632j) && !TextUtils.isEmpty(this.f8623a)) {
            this.f8632j = q4.u(this.f8623a);
        }
        return this.f8632j;
    }

    public final void c(boolean z3) {
        this.f8625c = z3 ? 1 : 0;
    }

    public final String e() {
        return this.f8629g;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (p4.class != obj.getClass()) {
            return false;
        }
        try {
            if (this.f8632j.equals(((p4) obj).f8632j) && this.f8629g.equals(((p4) obj).f8629g)) {
                if (this.f8630h.equals(((p4) obj).f8630h)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final String f() {
        if (TextUtils.isEmpty(this.f8630h) && !TextUtils.isEmpty(this.f8624b)) {
            this.f8630h = q4.u(this.f8624b);
        }
        return this.f8630h;
    }

    public final String g() {
        if (TextUtils.isEmpty(this.f8633k) && !TextUtils.isEmpty(this.f8628f)) {
            this.f8633k = q4.u(this.f8628f);
        }
        if (TextUtils.isEmpty(this.f8633k)) {
            this.f8633k = "standard";
        }
        return this.f8633k;
    }

    public final boolean h() {
        return this.f8625c == 1;
    }

    public final String[] i() {
        String[] strArr = this.f8634l;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.f8627e)) {
            this.f8634l = d(q4.u(this.f8627e));
        }
        return (String[]) this.f8634l.clone();
    }

    private p4() {
        this.f8625c = 1;
        this.f8634l = null;
    }

    private p4(a aVar) {
        this.f8625c = 1;
        this.f8634l = null;
        this.f8629g = aVar.f8635a;
        this.f8630h = aVar.f8636b;
        this.f8632j = aVar.f8637c;
        this.f8631i = aVar.f8638d;
        this.f8625c = aVar.f8639e ? 1 : 0;
        this.f8633k = aVar.f8640f;
        this.f8634l = aVar.f8641g;
        this.f8624b = q4.q(this.f8630h);
        this.f8623a = q4.q(this.f8632j);
        this.f8626d = q4.q(this.f8631i);
        this.f8627e = q4.q(b(this.f8634l));
        this.f8628f = q4.q(this.f8633k);
    }
}
