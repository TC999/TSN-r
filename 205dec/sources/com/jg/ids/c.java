package com.jg.ids;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f37810a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ a f37811b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar, String str) {
        this.f37811b = aVar;
        this.f37810a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f37811b.c(this.f37810a);
    }
}
