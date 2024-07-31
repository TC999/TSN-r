package com.kwad.sdk.api.p367a;

import com.kwad.sdk.api.C9702c;

/* renamed from: com.kwad.sdk.api.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractRunnableC9699a implements Runnable {
    public abstract void doTask();

    @Override // java.lang.Runnable
    public void run() {
        try {
            doTask();
        } catch (Throwable th) {
            C9702c.m28016m(th);
        }
    }
}
