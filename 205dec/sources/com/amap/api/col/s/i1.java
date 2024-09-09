package com.amap.api.col.s;

import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SDKInfo.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i1 {

    /* renamed from: a  reason: collision with root package name */
    private String f9915a;

    /* renamed from: b  reason: collision with root package name */
    private String f9916b;

    /* renamed from: c  reason: collision with root package name */
    private int f9917c;

    /* renamed from: d  reason: collision with root package name */
    private String f9918d;

    /* renamed from: e  reason: collision with root package name */
    private String f9919e;

    /* renamed from: f  reason: collision with root package name */
    private String f9920f;

    /* renamed from: g  reason: collision with root package name */
    private String f9921g;

    /* renamed from: h  reason: collision with root package name */
    private String f9922h;

    /* renamed from: i  reason: collision with root package name */
    private String f9923i;

    /* renamed from: j  reason: collision with root package name */
    private String f9924j;

    /* renamed from: k  reason: collision with root package name */
    private String f9925k;

    /* renamed from: l  reason: collision with root package name */
    private String[] f9926l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: SDKInfo.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private String f9927a;

        /* renamed from: b  reason: collision with root package name */
        private String f9928b;

        /* renamed from: c  reason: collision with root package name */
        private String f9929c;

        /* renamed from: d  reason: collision with root package name */
        private String f9930d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f9931e = true;

        /* renamed from: f  reason: collision with root package name */
        private String f9932f = "standard";

        /* renamed from: g  reason: collision with root package name */
        private String[] f9933g = null;

        public a(String str, String str2, String str3) {
            this.f9927a = str2;
            this.f9928b = str2;
            this.f9930d = str3;
            this.f9929c = str;
        }

        public final a a(String str) {
            this.f9928b = str;
            return this;
        }

        public final a b(boolean z3) {
            this.f9931e = z3;
            return this;
        }

        public final a c(String[] strArr) {
            if (strArr != null) {
                this.f9933g = (String[]) strArr.clone();
            }
            return this;
        }

        public final i1 d() throws bv {
            if (this.f9933g != null) {
                return new i1(this, (byte) 0);
            }
            throw new bv("sdk packages is null");
        }
    }

    /* synthetic */ i1(a aVar, byte b4) {
        this(aVar);
    }

    private static String a(String[] strArr) {
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

    private static String[] c(String str) {
        try {
            return str.split(";");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void b() {
        this.f9917c = 1;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.f9924j) && !TextUtils.isEmpty(this.f9915a)) {
            this.f9924j = j1.t(this.f9915a);
        }
        return this.f9924j;
    }

    public final String e() {
        return this.f9921g;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (i1.class != obj.getClass()) {
            return false;
        }
        try {
            if (this.f9924j.equals(((i1) obj).f9924j) && this.f9921g.equals(((i1) obj).f9921g)) {
                if (this.f9922h.equals(((i1) obj).f9922h)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final String f() {
        if (TextUtils.isEmpty(this.f9922h) && !TextUtils.isEmpty(this.f9916b)) {
            this.f9922h = j1.t(this.f9916b);
        }
        return this.f9922h;
    }

    public final String g() {
        if (TextUtils.isEmpty(this.f9925k) && !TextUtils.isEmpty(this.f9920f)) {
            this.f9925k = j1.t(this.f9920f);
        }
        if (TextUtils.isEmpty(this.f9925k)) {
            this.f9925k = "standard";
        }
        return this.f9925k;
    }

    public final boolean h() {
        return this.f9917c == 1;
    }

    public final String[] i() {
        String[] strArr = this.f9926l;
        if ((strArr == null || strArr.length == 0) && !TextUtils.isEmpty(this.f9919e)) {
            this.f9926l = c(j1.t(this.f9919e));
        }
        return (String[]) this.f9926l.clone();
    }

    private i1() {
        this.f9917c = 1;
        this.f9926l = null;
    }

    private i1(a aVar) {
        this.f9917c = 1;
        this.f9926l = null;
        this.f9921g = aVar.f9927a;
        this.f9922h = aVar.f9928b;
        this.f9924j = aVar.f9929c;
        this.f9923i = aVar.f9930d;
        this.f9917c = aVar.f9931e ? 1 : 0;
        this.f9925k = aVar.f9932f;
        this.f9926l = aVar.f9933g;
        this.f9916b = j1.q(this.f9922h);
        this.f9915a = j1.q(this.f9924j);
        this.f9918d = j1.q(this.f9923i);
        this.f9919e = j1.q(a(this.f9926l));
        this.f9920f = j1.q(this.f9925k);
    }
}
