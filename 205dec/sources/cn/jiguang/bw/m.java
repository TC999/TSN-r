package cn.jiguang.bw;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class m extends i {

    /* renamed from: e  reason: collision with root package name */
    private int f3071e;

    /* renamed from: f  reason: collision with root package name */
    private int f3072f;

    /* renamed from: g  reason: collision with root package name */
    private int f3073g;

    /* renamed from: h  reason: collision with root package name */
    private g f3074h;

    @Override // cn.jiguang.bw.i
    void a(b bVar) {
        this.f3071e = bVar.g();
        this.f3072f = bVar.g();
        this.f3073g = bVar.g();
        this.f3074h = new g(bVar);
    }

    @Override // cn.jiguang.bw.i
    void a(c cVar, a aVar, boolean z3) {
        cVar.c(this.f3071e);
        cVar.c(this.f3072f);
        cVar.c(this.f3073g);
        this.f3074h.a(cVar, (a) null, z3);
    }

    @Override // cn.jiguang.bw.i
    String b() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f3071e + " ");
        stringBuffer.append(this.f3072f + " ");
        stringBuffer.append(this.f3073g + " ");
        stringBuffer.append(this.f3074h);
        return stringBuffer.toString();
    }

    public int j() {
        return this.f3073g;
    }

    public g k() {
        return this.f3074h;
    }
}
