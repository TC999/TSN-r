package com.baidu.mobads.sdk.internal;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
final class bl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Runnable f12493a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(Runnable runnable) {
        this.f12493a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f12493a.run();
    }
}
