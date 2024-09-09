package com.qq.e.comm.plugin.apkmanager;

import com.qq.e.comm.plugin.util.d1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class h {

    /* renamed from: a  reason: collision with root package name */
    private com.qq.e.comm.plugin.d0.e.d f41789a;

    /* renamed from: b  reason: collision with root package name */
    int f41790b = 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(com.qq.e.comm.plugin.d0.e.d dVar) {
        this.f41789a = dVar;
    }

    public int a() {
        int a4 = com.qq.e.comm.plugin.edgeanalytics.e.a(this.f41789a, -1);
        if (a4 == -1) {
            this.f41790b = -1;
            a4 = 3;
        }
        d1.a("Apk download threadCount=" + a4, new Object[0]);
        return a4;
    }
}
