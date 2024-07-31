package com.amap.api.col.p0463l;

/* renamed from: com.amap.api.col.3l.m1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class PauseStateAbstractAbstract extends AbstractCanDeleteStateAbstract {
    public PauseStateAbstractAbstract(CityObject cityObject) {
        super(3, cityObject);
    }

    @Override // com.amap.api.col.p0463l.AbstractCityStateImp
    /* renamed from: g */
    public final void mo54531g() {
        m55088e(this.f4091b.f3574g);
        CityObject cityObject = this.f4091b;
        cityObject.m55622j(cityObject.f3574g);
        this.f4091b.m55618s().mo54413h();
    }

    @Override // com.amap.api.col.p0463l.ICityState
    /* renamed from: h */
    public final void mo54413h() {
        this.f4091b.m55617t();
        this.f4091b.m55633G();
    }
}
