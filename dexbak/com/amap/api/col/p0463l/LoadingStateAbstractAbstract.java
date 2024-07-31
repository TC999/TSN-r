package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.k1 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class LoadingStateAbstractAbstract extends AbstractCanDeleteStateAbstract {
    public LoadingStateAbstractAbstract(CityObject cityObject) {
        super(0, cityObject);
    }

    @Override // com.amap.api.col.p0463l.AbstractCityStateImp
    /* renamed from: b */
    public final void mo54415b(int i) {
        m55088e(this.f4091b.m55619m(i));
        CityObject cityObject = this.f4091b;
        cityObject.m55622j(cityObject.m55619m(i));
        this.f4091b.m55618s().mo54413h();
    }

    @Override // com.amap.api.col.p0463l.ICityState
    /* renamed from: h */
    public final void mo54413h() {
        this.f4091b.m55617t();
    }

    @Override // com.amap.api.col.p0463l.AbstractCityStateImp
    /* renamed from: i */
    public final void mo54412i() {
        m55088e(this.f4091b.f3576i);
        CityObject cityObject = this.f4091b;
        cityObject.m55622j(cityObject.f3576i);
        this.f4091b.m55618s().mo54413h();
    }

    @Override // com.amap.api.col.p0463l.AbstractCityStateImp
    /* renamed from: k */
    public final void mo54451k() {
        m55088e(this.f4091b.f3577j);
        CityObject cityObject = this.f4091b;
        cityObject.m55622j(cityObject.f3577j);
        this.f4091b.m55618s().mo54413h();
    }
}
