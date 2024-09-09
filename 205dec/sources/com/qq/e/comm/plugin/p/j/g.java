package com.qq.e.comm.plugin.p.j;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class g implements d, com.qq.e.comm.plugin.p.g {

    /* renamed from: a  reason: collision with root package name */
    private final long f45254a;

    /* renamed from: b  reason: collision with root package name */
    private final int f45255b;

    /* renamed from: c  reason: collision with root package name */
    private final c[] f45256c;

    /* renamed from: d  reason: collision with root package name */
    private com.qq.e.comm.plugin.p.g f45257d;

    public g(long j4, long[] jArr, long[] jArr2) {
        this.f45254a = j4;
        int length = jArr.length;
        this.f45255b = length;
        this.f45256c = new c[length];
        for (int i4 = 0; i4 < this.f45255b; i4++) {
            this.f45256c[i4] = new i(jArr[i4], jArr2[i4]);
            this.f45256c[i4].a(this);
        }
    }

    public c a(int i4) {
        if (i4 < 0 || i4 >= this.f45255b) {
            return null;
        }
        return this.f45256c[i4];
    }

    public long b() {
        return this.f45254a;
    }

    @Override // com.qq.e.comm.plugin.p.j.d
    public long a() {
        long j4 = 0;
        for (c cVar : this.f45256c) {
            j4 += cVar.a();
        }
        return j4;
    }

    @Override // com.qq.e.comm.plugin.p.g
    public void a(long j4, long j5) {
        com.qq.e.comm.plugin.p.g gVar = this.f45257d;
        if (gVar != null) {
            gVar.a(a(), b());
        }
    }

    @Override // com.qq.e.comm.plugin.p.j.d
    public void a(com.qq.e.comm.plugin.p.g gVar) {
        this.f45257d = gVar;
    }
}
