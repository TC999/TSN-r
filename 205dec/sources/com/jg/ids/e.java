package com.jg.ids;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f37816a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ a f37817b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar, String str) {
        this.f37817b = aVar;
        this.f37816a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f37817b.a(this.f37816a);
    }
}
