package com.jg.ids.h;

/* loaded from: E:\TSN-r\205dec\93344.dex */
final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f37833a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ a f37834b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, String str) {
        this.f37834b = aVar;
        this.f37833a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f37834b.a(this.f37833a);
    }
}
