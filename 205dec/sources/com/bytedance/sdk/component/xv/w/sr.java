package com.bytedance.sdk.component.xv.w;

import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class sr {

    /* renamed from: c  reason: collision with root package name */
    public static final sr f31098c = new c().c().xv();

    /* renamed from: w  reason: collision with root package name */
    public static final sr f31099w = new c().w().c(Integer.MAX_VALUE, TimeUnit.SECONDS).xv();

    /* renamed from: a  reason: collision with root package name */
    private final int f31100a;
    private final boolean bk;
    private final boolean ev;

    /* renamed from: f  reason: collision with root package name */
    private final int f31101f;
    private final boolean gd;

    /* renamed from: k  reason: collision with root package name */
    private final int f31102k;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f31103p;

    /* renamed from: r  reason: collision with root package name */
    private final int f31104r;
    private final boolean sr;

    /* renamed from: t  reason: collision with root package name */
    private final boolean f31105t;
    private final boolean ux;
    String xv;
    private final boolean ys;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        boolean f31106c;
        boolean ev;

        /* renamed from: f  reason: collision with root package name */
        boolean f31107f;

        /* renamed from: r  reason: collision with root package name */
        boolean f31108r;

        /* renamed from: w  reason: collision with root package name */
        boolean f31109w;
        int xv = -1;
        int sr = -1;
        int ux = -1;

        public c c() {
            this.f31106c = true;
            return this;
        }

        public c w() {
            this.f31107f = true;
            return this;
        }

        public sr xv() {
            return new sr(this);
        }

        public c c(int i4, TimeUnit timeUnit) {
            if (i4 >= 0) {
                long seconds = timeUnit.toSeconds(i4);
                this.sr = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i4);
        }
    }

    private sr(boolean z3, boolean z4, int i4, int i5, boolean z5, boolean z6, boolean z7, int i6, int i7, boolean z8, boolean z9, boolean z10, String str) {
        this.sr = z3;
        this.ux = z4;
        this.f31101f = i4;
        this.f31104r = i5;
        this.ev = z5;
        this.gd = z6;
        this.f31103p = z7;
        this.f31102k = i6;
        this.f31100a = i7;
        this.bk = z8;
        this.f31105t = z9;
        this.ys = z10;
        this.xv = str;
    }

    private String k() {
        StringBuilder sb = new StringBuilder();
        if (this.sr) {
            sb.append("no-cache, ");
        }
        if (this.ux) {
            sb.append("no-store, ");
        }
        if (this.f31101f != -1) {
            sb.append("max-age=");
            sb.append(this.f31101f);
            sb.append(", ");
        }
        if (this.f31104r != -1) {
            sb.append("s-maxage=");
            sb.append(this.f31104r);
            sb.append(", ");
        }
        if (this.ev) {
            sb.append("private, ");
        }
        if (this.gd) {
            sb.append("public, ");
        }
        if (this.f31103p) {
            sb.append("must-revalidate, ");
        }
        if (this.f31102k != -1) {
            sb.append("max-stale=");
            sb.append(this.f31102k);
            sb.append(", ");
        }
        if (this.f31100a != -1) {
            sb.append("min-fresh=");
            sb.append(this.f31100a);
            sb.append(", ");
        }
        if (this.bk) {
            sb.append("only-if-cached, ");
        }
        if (this.f31105t) {
            sb.append("no-transform, ");
        }
        if (this.ys) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean c() {
        return this.sr;
    }

    public int ev() {
        return this.f31100a;
    }

    public boolean f() {
        return this.f31103p;
    }

    public boolean gd() {
        return this.bk;
    }

    public boolean p() {
        return this.ys;
    }

    public int r() {
        return this.f31102k;
    }

    public boolean sr() {
        return this.ev;
    }

    public String toString() {
        String str = this.xv;
        if (str != null) {
            return str;
        }
        String k4 = k();
        this.xv = k4;
        return k4;
    }

    public boolean ux() {
        return this.gd;
    }

    public boolean w() {
        return this.ux;
    }

    public int xv() {
        return this.f31101f;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bytedance.sdk.component.xv.w.sr c(com.bytedance.sdk.component.xv.w.s r22) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.xv.w.sr.c(com.bytedance.sdk.component.xv.w.s):com.bytedance.sdk.component.xv.w.sr");
    }

    sr(c cVar) {
        this.sr = cVar.f31106c;
        this.ux = cVar.f31109w;
        this.f31101f = cVar.xv;
        this.f31104r = -1;
        this.ev = false;
        this.gd = false;
        this.f31103p = false;
        this.f31102k = cVar.sr;
        this.f31100a = cVar.ux;
        this.bk = cVar.f31107f;
        this.f31105t = cVar.f31108r;
        this.ys = cVar.ev;
    }
}
