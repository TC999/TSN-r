package com.qq.e.comm.plugin.fs.f.e.c;

import com.qq.e.comm.plugin.r0.n;
import com.qq.e.comm.plugin.rewardvideo.q;
import java.util.Locale;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e extends a {

    /* renamed from: d  reason: collision with root package name */
    protected final String f43402d;

    public e(n nVar, com.qq.e.comm.plugin.g0.e eVar) {
        super(nVar);
        this.f43402d = (String) q.d(eVar).first;
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.c.a
    public int a() {
        return com.qq.e.comm.plugin.fs.e.d.b();
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.c.a
    protected void c() {
        if (this.f43391a.getVisibility() != 0) {
            this.f43391a.setVisibility(0);
        }
        this.f43391a.a(String.format("\u606d\u559c\u83b7\u5f97%s", this.f43402d));
    }

    @Override // com.qq.e.comm.plugin.fs.f.e.c.a
    protected void d() {
        if (this.f43391a.getVisibility() != 0) {
            this.f43391a.setVisibility(0);
        }
        this.f43391a.a(String.format(Locale.getDefault(), "%s\u5c06\u4e8e", this.f43402d), String.valueOf(a() / 1000), "\u79d2\u540e\u53d1\u653e");
    }
}
