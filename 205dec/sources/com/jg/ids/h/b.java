package com.jg.ids.h;

/* loaded from: E:\TSN-r\205dec\93344.dex */
final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f37829a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ a f37830b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str) {
        this.f37830b = aVar;
        this.f37829a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f37830b.c(this.f37829a);
    }
}
