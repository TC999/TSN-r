package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.util.concurrent.TimeUnit;

/* compiled from: CacheControl.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f1248a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1249b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1250c;

    /* renamed from: d  reason: collision with root package name */
    private final int f1251d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f1252e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f1253f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f1254g;

    /* renamed from: h  reason: collision with root package name */
    private final int f1255h;

    /* renamed from: i  reason: collision with root package name */
    private final int f1256i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f1257j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f1258k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f1259l;

    /* renamed from: m  reason: collision with root package name */
    String f1260m;

    static {
        new a().b().a();
        new a().c().a(Integer.MAX_VALUE, TimeUnit.SECONDS).a();
    }

    private d(boolean z3, boolean z4, int i4, int i5, boolean z5, boolean z6, boolean z7, int i6, int i7, boolean z8, boolean z9, boolean z10, String str) {
        this.f1248a = z3;
        this.f1249b = z4;
        this.f1250c = i4;
        this.f1251d = i5;
        this.f1252e = z5;
        this.f1253f = z6;
        this.f1254g = z7;
        this.f1255h = i6;
        this.f1256i = i7;
        this.f1257j = z8;
        this.f1258k = z9;
        this.f1259l = z10;
        this.f1260m = str;
    }

    private String k() {
        StringBuilder sb = new StringBuilder();
        if (this.f1248a) {
            sb.append("no-cache, ");
        }
        if (this.f1249b) {
            sb.append("no-store, ");
        }
        if (this.f1250c != -1) {
            sb.append("max-age=");
            sb.append(this.f1250c);
            sb.append(", ");
        }
        if (this.f1251d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f1251d);
            sb.append(", ");
        }
        if (this.f1252e) {
            sb.append("private, ");
        }
        if (this.f1253f) {
            sb.append("public, ");
        }
        if (this.f1254g) {
            sb.append("must-revalidate, ");
        }
        if (this.f1255h != -1) {
            sb.append("max-stale=");
            sb.append(this.f1255h);
            sb.append(", ");
        }
        if (this.f1256i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f1256i);
            sb.append(", ");
        }
        if (this.f1257j) {
            sb.append("only-if-cached, ");
        }
        if (this.f1258k) {
            sb.append("no-transform, ");
        }
        if (this.f1259l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public boolean a() {
        return this.f1259l;
    }

    public boolean b() {
        return this.f1252e;
    }

    public boolean c() {
        return this.f1253f;
    }

    public int d() {
        return this.f1250c;
    }

    public int e() {
        return this.f1255h;
    }

    public int f() {
        return this.f1256i;
    }

    public boolean g() {
        return this.f1254g;
    }

    public boolean h() {
        return this.f1248a;
    }

    public boolean i() {
        return this.f1249b;
    }

    public boolean j() {
        return this.f1257j;
    }

    public String toString() {
        String str = this.f1260m;
        if (str != null) {
            return str;
        }
        String k4 = k();
        this.f1260m = k4;
        return k4;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r r22) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r):bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d");
    }

    /* compiled from: CacheControl.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f1261a;

        /* renamed from: b  reason: collision with root package name */
        boolean f1262b;

        /* renamed from: c  reason: collision with root package name */
        int f1263c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f1264d = -1;

        /* renamed from: e  reason: collision with root package name */
        int f1265e = -1;

        /* renamed from: f  reason: collision with root package name */
        boolean f1266f;

        /* renamed from: g  reason: collision with root package name */
        boolean f1267g;

        /* renamed from: h  reason: collision with root package name */
        boolean f1268h;

        public a a(int i4, TimeUnit timeUnit) {
            if (i4 >= 0) {
                long seconds = timeUnit.toSeconds(i4);
                this.f1264d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i4);
        }

        public a b() {
            this.f1261a = true;
            return this;
        }

        public a c() {
            this.f1266f = true;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    d(a aVar) {
        this.f1248a = aVar.f1261a;
        this.f1249b = aVar.f1262b;
        this.f1250c = aVar.f1263c;
        this.f1251d = -1;
        this.f1252e = false;
        this.f1253f = false;
        this.f1254g = false;
        this.f1255h = aVar.f1264d;
        this.f1256i = aVar.f1265e;
        this.f1257j = aVar.f1266f;
        this.f1258k = aVar.f1267g;
        this.f1259l = aVar.f1268h;
    }
}
