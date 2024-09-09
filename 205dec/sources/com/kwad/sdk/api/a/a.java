package com.kwad.sdk.api.a;

import com.kwad.sdk.api.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a implements Runnable {
    public abstract void doTask();

    @Override // java.lang.Runnable
    public void run() {
        try {
            doTask();
        } catch (Throwable th) {
            c.m(th);
        }
    }
}
