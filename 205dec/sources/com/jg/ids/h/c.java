package com.jg.ids.h;

/* loaded from: E:\TSN-r\205dec\93344.dex */
final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f37831a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ a f37832b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str) {
        this.f37832b = aVar;
        this.f37831a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f37832b.b(this.f37831a);
    }
}
