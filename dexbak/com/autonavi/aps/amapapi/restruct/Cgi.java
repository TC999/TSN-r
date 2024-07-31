package com.autonavi.aps.amapapi.restruct;

/* renamed from: com.autonavi.aps.amapapi.restruct.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class Cgi {

    /* renamed from: l */
    public int f8132l;

    /* renamed from: n */
    public boolean f8134n;

    /* renamed from: a */
    public int f8121a = 0;

    /* renamed from: b */
    public int f8122b = 0;

    /* renamed from: c */
    public int f8123c = 0;

    /* renamed from: d */
    public int f8124d = 0;

    /* renamed from: e */
    public long f8125e = 0;

    /* renamed from: f */
    public int f8126f = 0;

    /* renamed from: g */
    public int f8127g = 0;

    /* renamed from: h */
    public int f8128h = 0;

    /* renamed from: i */
    public int f8129i = 0;

    /* renamed from: j */
    public int f8130j = 0;

    /* renamed from: k */
    public int f8131k = -113;

    /* renamed from: m */
    public short f8133m = 0;

    /* renamed from: o */
    public int f8135o = 32767;

    /* renamed from: p */
    public int f8136p = Integer.MAX_VALUE;

    /* renamed from: q */
    public int f8137q = Integer.MAX_VALUE;

    /* renamed from: r */
    public boolean f8138r = true;

    /* renamed from: s */
    public int f8139s = 99;

    /* renamed from: t */
    public long f8140t = 0;

    public Cgi(int i, boolean z) {
        this.f8132l = i;
        this.f8134n = z;
    }

    /* renamed from: e */
    private String m51575e() {
        int i = this.f8132l;
        return this.f8132l + "#" + this.f8121a + "#" + this.f8122b + "#0#" + m51579a();
    }

    /* renamed from: f */
    private String m51574f() {
        return this.f8132l + "#" + this.f8128h + "#" + this.f8129i + "#" + this.f8130j;
    }

    /* renamed from: a */
    public final long m51579a() {
        if (this.f8132l == 5) {
            return this.f8125e;
        }
        return this.f8124d;
    }

    /* renamed from: b */
    public final String m51578b() {
        int i = this.f8132l;
        if (i != 1) {
            if (i == 2) {
                return m51574f();
            }
            if (i != 3 && i != 4 && i != 5) {
                return null;
            }
        }
        return m51575e();
    }

    /* renamed from: c */
    public final String m51577c() {
        String m51578b = m51578b();
        if (m51578b == null || m51578b.length() <= 0) {
            return "";
        }
        boolean z = this.f8138r;
        return (z ? 1 : 0) + "#" + m51578b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final Cgi clone() {
        Cgi cgi = new Cgi(this.f8132l, this.f8134n);
        cgi.f8121a = this.f8121a;
        cgi.f8122b = this.f8122b;
        cgi.f8123c = this.f8123c;
        cgi.f8124d = this.f8124d;
        cgi.f8125e = this.f8125e;
        cgi.f8126f = this.f8126f;
        cgi.f8127g = this.f8127g;
        cgi.f8128h = this.f8128h;
        cgi.f8129i = this.f8129i;
        cgi.f8130j = this.f8130j;
        cgi.f8131k = this.f8131k;
        cgi.f8133m = this.f8133m;
        cgi.f8135o = this.f8135o;
        cgi.f8136p = this.f8136p;
        cgi.f8137q = this.f8137q;
        cgi.f8138r = this.f8138r;
        cgi.f8139s = this.f8139s;
        cgi.f8140t = this.f8140t;
        return cgi;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cgi)) {
            Cgi cgi = (Cgi) obj;
            int i = cgi.f8132l;
            if (i != 1) {
                return i != 2 ? i != 3 ? i != 4 ? i == 5 && this.f8132l == 5 && cgi.f8123c == this.f8123c && cgi.f8125e == this.f8125e && cgi.f8137q == this.f8137q : this.f8132l == 4 && cgi.f8123c == this.f8123c && cgi.f8124d == this.f8124d && cgi.f8122b == this.f8122b : this.f8132l == 3 && cgi.f8123c == this.f8123c && cgi.f8124d == this.f8124d && cgi.f8122b == this.f8122b : this.f8132l == 2 && cgi.f8130j == this.f8130j && cgi.f8129i == this.f8129i && cgi.f8128h == this.f8128h;
            } else if (this.f8132l == 1 && cgi.f8123c == this.f8123c && cgi.f8124d == this.f8124d && cgi.f8122b == this.f8122b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = String.valueOf(this.f8132l).hashCode();
        if (this.f8132l == 2) {
            hashCode = String.valueOf(this.f8130j).hashCode() + String.valueOf(this.f8129i).hashCode();
            hashCode2 = String.valueOf(this.f8128h).hashCode();
        } else {
            hashCode = String.valueOf(this.f8123c).hashCode() + String.valueOf(this.f8124d).hashCode();
            hashCode2 = String.valueOf(this.f8122b).hashCode();
        }
        return hashCode3 + hashCode + hashCode2;
    }
}
