package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.n1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class UnzipStateAbstract extends AbstractCityStateImp {
    public UnzipStateAbstract(CityObject cityObject) {
        super(1, cityObject);
    }

    @Override // com.amap.api.col.p0463l.AbstractCityStateImp
    /* renamed from: b */
    public final void mo54415b(int i) {
        m55088e(this.f4091b.f3580m);
        CityObject cityObject = this.f4091b;
        cityObject.m55622j(cityObject.f3580m);
        this.f4091b.m55618s().mo54413h();
    }

    @Override // com.amap.api.col.p0463l.AbstractCityStateImp
    /* renamed from: f */
    public final void mo54414f() {
        this.f4091b.m55617t();
    }

    @Override // com.amap.api.col.p0463l.ICityState
    /* renamed from: h */
    public final void mo54413h() {
        this.f4091b.setCompleteCode(0);
        this.f4091b.m55617t();
    }

    @Override // com.amap.api.col.p0463l.AbstractCityStateImp
    /* renamed from: k */
    public final void mo54451k() {
        m55088e(this.f4091b.f3578k);
        CityObject cityObject = this.f4091b;
        cityObject.m55622j(cityObject.f3578k);
        this.f4091b.m55618s().mo54413h();
    }
}
