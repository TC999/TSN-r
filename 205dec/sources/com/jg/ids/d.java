package com.jg.ids;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ String f37813a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ a f37814b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, String str) {
        this.f37814b = aVar;
        this.f37813a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f37814b.b(this.f37813a);
    }
}
