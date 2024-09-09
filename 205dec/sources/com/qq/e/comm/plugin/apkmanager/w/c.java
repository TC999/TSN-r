package com.qq.e.comm.plugin.apkmanager.w;

import com.qq.e.comm.plugin.util.p2;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final p2<String, a> f41937a = new p2<>();

    public void a(String str, a aVar) {
        this.f41937a.a((p2<String, a>) str, (String) aVar);
    }

    public void b(a aVar) {
        b("*", aVar);
    }

    public void a(a aVar) {
        this.f41937a.a((p2<String, a>) "*", (String) aVar);
    }

    public void b(String str, a aVar) {
        this.f41937a.a(str, (String) aVar);
    }

    public void a(String str, int i4, int i5, long j4) {
        for (a aVar : this.f41937a.a(str)) {
            aVar.a(str, i4, i5, j4);
        }
        for (a aVar2 : this.f41937a.a("*")) {
            aVar2.a(str, i4, i5, j4);
        }
    }
}
