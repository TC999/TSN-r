package com.qq.e.comm.plugin.n0;

import android.content.Context;
import java.util.List;
import java.util.Set;
import yaq.pro;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class r extends a<p> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Context context) {
        super(context);
    }

    @Override // com.qq.e.comm.plugin.n0.a
    public void a(Set<Integer> set) {
        j.a(this.f44725a).b().a(set);
    }

    @Override // com.qq.e.comm.plugin.n0.a
    public List<p> b() {
        return j.a(this.f44725a).b().b();
    }

    @Override // com.qq.e.comm.plugin.n0.a
    public void c(List<p> list) {
        j.a(this.f44725a).b().a(list);
    }

    @Override // com.qq.e.comm.plugin.n0.a
    void d(List<p> list) {
        pro.getVresult(482, 0, this, list);
    }

    @Override // com.qq.e.comm.plugin.n0.a
    boolean e() {
        return pro.getZresult(483, 0, this);
    }
}
