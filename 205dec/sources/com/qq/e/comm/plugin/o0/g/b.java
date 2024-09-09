package com.qq.e.comm.plugin.o0.g;

import android.text.TextUtils;
import java.io.File;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f45080a;

    /* renamed from: b  reason: collision with root package name */
    private final File f45081b;

    /* renamed from: c  reason: collision with root package name */
    private final String f45082c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f45083d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f45084e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f45085f;

    /* renamed from: g  reason: collision with root package name */
    private String f45086g;

    /* renamed from: h  reason: collision with root package name */
    private long f45087h;

    /* renamed from: i  reason: collision with root package name */
    private double f45088i;

    /* renamed from: j  reason: collision with root package name */
    private String f45089j;

    /* renamed from: k  reason: collision with root package name */
    private com.qq.e.comm.plugin.n0.c f45090k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f45091l;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.o0.g.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class C0867b {

        /* renamed from: a  reason: collision with root package name */
        private String f45092a;

        /* renamed from: b  reason: collision with root package name */
        private File f45093b;

        /* renamed from: c  reason: collision with root package name */
        private String f45094c;

        /* renamed from: g  reason: collision with root package name */
        private String f45098g;

        /* renamed from: h  reason: collision with root package name */
        private long f45099h;

        /* renamed from: j  reason: collision with root package name */
        private String f45101j;

        /* renamed from: k  reason: collision with root package name */
        private com.qq.e.comm.plugin.n0.c f45102k;

        /* renamed from: d  reason: collision with root package name */
        private boolean f45095d = true;

        /* renamed from: e  reason: collision with root package name */
        private boolean f45096e = true;

        /* renamed from: f  reason: collision with root package name */
        private boolean f45097f = false;

        /* renamed from: i  reason: collision with root package name */
        private double f45100i = 1.0d;

        /* renamed from: l  reason: collision with root package name */
        private boolean f45103l = true;

        public C0867b a(File file) {
            this.f45093b = file;
            return this;
        }

        public C0867b b(boolean z3) {
            this.f45096e = z3;
            return this;
        }

        public C0867b c(String str) {
            this.f45101j = str;
            return this;
        }

        public C0867b d(String str) {
            this.f45092a = str;
            return this;
        }

        public C0867b a(String str) {
            this.f45094c = str;
            return this;
        }

        public C0867b b(String str) {
            this.f45098g = str;
            return this;
        }

        public C0867b c(boolean z3) {
            this.f45097f = z3;
            return this;
        }

        public C0867b d(boolean z3) {
            this.f45095d = z3;
            return this;
        }

        public C0867b a(double d4) {
            if (d4 <= 0.0d || d4 > 1.0d) {
                d4 = 1.0d;
            }
            this.f45100i = d4;
            return this;
        }

        public C0867b a(com.qq.e.comm.plugin.n0.c cVar) {
            this.f45102k = cVar;
            return this;
        }

        public C0867b a(boolean z3) {
            this.f45103l = z3;
            return this;
        }

        public b a() {
            b bVar = new b(this.f45093b, this.f45094c, this.f45092a, this.f45095d);
            bVar.f45085f = this.f45097f;
            bVar.f45084e = this.f45096e;
            bVar.f45086g = this.f45098g;
            bVar.f45087h = this.f45099h;
            bVar.f45088i = this.f45100i;
            bVar.f45089j = this.f45101j;
            bVar.f45090k = this.f45102k;
            bVar.f45091l = this.f45103l || this.f45095d;
            return bVar;
        }
    }

    public String d() {
        return this.f45082c;
    }

    public String e() {
        if (TextUtils.isEmpty(this.f45086g)) {
            return this.f45080a;
        }
        return this.f45086g;
    }

    public String f() {
        return this.f45089j;
    }

    public String g() {
        return this.f45080a;
    }

    public boolean h() {
        return this.f45091l;
    }

    public boolean i() {
        return this.f45084e;
    }

    public boolean j() {
        return this.f45085f;
    }

    public boolean k() {
        return this.f45083d;
    }

    private b(File file, String str, String str2, boolean z3) {
        this.f45084e = true;
        this.f45085f = false;
        this.f45081b = file;
        this.f45082c = str;
        this.f45080a = str2;
        this.f45083d = z3;
    }

    public double c() {
        return this.f45088i;
    }

    public File b() {
        return this.f45081b;
    }

    public com.qq.e.comm.plugin.n0.c a() {
        return this.f45090k;
    }
}
