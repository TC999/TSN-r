package com.kwad.sdk.i;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
abstract class n implements Runnable {
    abstract void doTask();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            doTask();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
