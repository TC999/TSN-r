package com.kwad.sdk.p437i;

/* renamed from: com.kwad.sdk.i.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
abstract class AbstractRunnableC10807n implements Runnable {
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
