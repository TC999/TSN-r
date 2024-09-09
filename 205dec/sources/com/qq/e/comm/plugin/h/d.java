package com.qq.e.comm.plugin.h;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final f f43996a;

    public d(f fVar) {
        this.f43996a = fVar;
        if (fVar.g() != null) {
            fVar.g().a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(T t3) {
        f fVar = this.f43996a;
        if (fVar == null || fVar.isDestroyed()) {
            return;
        }
        b(t3);
    }

    public abstract void b(T t3);
}
