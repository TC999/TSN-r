package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.util.concurrent.TimeUnit;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class CacheControl {

    /* renamed from: a */
    private final boolean f1255a;

    /* renamed from: b */
    private final boolean f1256b;

    /* renamed from: c */
    private final int f1257c;

    /* renamed from: d */
    private final int f1258d;

    /* renamed from: e */
    private final boolean f1259e;

    /* renamed from: f */
    private final boolean f1260f;

    /* renamed from: g */
    private final boolean f1261g;

    /* renamed from: h */
    private final int f1262h;

    /* renamed from: i */
    private final int f1263i;

    /* renamed from: j */
    private final boolean f1264j;

    /* renamed from: k */
    private final boolean f1265k;

    /* renamed from: l */
    private final boolean f1266l;

    /* renamed from: m */
    String f1267m;

    static {
        new C1064a().m58428b().m58430a();
        new C1064a().m58427c().m58429a(Integer.MAX_VALUE, TimeUnit.SECONDS).m58430a();
    }

    private CacheControl(boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, int i3, int i4, boolean z6, boolean z7, boolean z8, String str) {
        this.f1255a = z;
        this.f1256b = z2;
        this.f1257c = i;
        this.f1258d = i2;
        this.f1259e = z3;
        this.f1260f = z4;
        this.f1261g = z5;
        this.f1262h = i3;
        this.f1263i = i4;
        this.f1264j = z6;
        this.f1265k = z7;
        this.f1266l = z8;
        this.f1267m = str;
    }

    /* renamed from: k */
    private String m58431k() {
        StringBuilder sb = new StringBuilder();
        if (this.f1255a) {
            sb.append("no-cache, ");
        }
        if (this.f1256b) {
            sb.append("no-store, ");
        }
        if (this.f1257c != -1) {
            sb.append("max-age=");
            sb.append(this.f1257c);
            sb.append(", ");
        }
        if (this.f1258d != -1) {
            sb.append("s-maxage=");
            sb.append(this.f1258d);
            sb.append(", ");
        }
        if (this.f1259e) {
            sb.append("private, ");
        }
        if (this.f1260f) {
            sb.append("public, ");
        }
        if (this.f1261g) {
            sb.append("must-revalidate, ");
        }
        if (this.f1262h != -1) {
            sb.append("max-stale=");
            sb.append(this.f1262h);
            sb.append(", ");
        }
        if (this.f1263i != -1) {
            sb.append("min-fresh=");
            sb.append(this.f1263i);
            sb.append(", ");
        }
        if (this.f1264j) {
            sb.append("only-if-cached, ");
        }
        if (this.f1265k) {
            sb.append("no-transform, ");
        }
        if (this.f1266l) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    /* renamed from: a */
    public boolean m58442a() {
        return this.f1266l;
    }

    /* renamed from: b */
    public boolean m58440b() {
        return this.f1259e;
    }

    /* renamed from: c */
    public boolean m58439c() {
        return this.f1260f;
    }

    /* renamed from: d */
    public int m58438d() {
        return this.f1257c;
    }

    /* renamed from: e */
    public int m58437e() {
        return this.f1262h;
    }

    /* renamed from: f */
    public int m58436f() {
        return this.f1263i;
    }

    /* renamed from: g */
    public boolean m58435g() {
        return this.f1261g;
    }

    /* renamed from: h */
    public boolean m58434h() {
        return this.f1255a;
    }

    /* renamed from: i */
    public boolean m58433i() {
        return this.f1256b;
    }

    /* renamed from: j */
    public boolean m58432j() {
        return this.f1264j;
    }

    public String toString() {
        String str = this.f1267m;
        if (str != null) {
            return str;
        }
        String m58431k = m58431k();
        this.f1267m = m58431k;
        return m58431k;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.CacheControl m58441a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Headers r22) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.CacheControl.m58441a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r):bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d");
    }

    /* compiled from: CacheControl.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.d$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class C1064a {

        /* renamed from: a */
        boolean f1268a;

        /* renamed from: b */
        boolean f1269b;

        /* renamed from: c */
        int f1270c = -1;

        /* renamed from: d */
        int f1271d = -1;

        /* renamed from: e */
        int f1272e = -1;

        /* renamed from: f */
        boolean f1273f;

        /* renamed from: g */
        boolean f1274g;

        /* renamed from: h */
        boolean f1275h;

        /* renamed from: a */
        public C1064a m58429a(int i, TimeUnit timeUnit) {
            if (i >= 0) {
                long seconds = timeUnit.toSeconds(i);
                this.f1271d = seconds > 2147483647L ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i);
        }

        /* renamed from: b */
        public C1064a m58428b() {
            this.f1268a = true;
            return this;
        }

        /* renamed from: c */
        public C1064a m58427c() {
            this.f1273f = true;
            return this;
        }

        /* renamed from: a */
        public CacheControl m58430a() {
            return new CacheControl(this);
        }
    }

    CacheControl(C1064a c1064a) {
        this.f1255a = c1064a.f1268a;
        this.f1256b = c1064a.f1269b;
        this.f1257c = c1064a.f1270c;
        this.f1258d = -1;
        this.f1259e = false;
        this.f1260f = false;
        this.f1261g = false;
        this.f1262h = c1064a.f1271d;
        this.f1263i = c1064a.f1272e;
        this.f1264j = c1064a.f1273f;
        this.f1265k = c1064a.f1274g;
        this.f1266l = c1064a.f1275h;
    }
}
