package com.kwad.sdk.utils;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10967e;

/* renamed from: com.kwad.sdk.utils.ay */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractRunnableC11033ay implements Runnable {
    public abstract void doTask();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            doTask();
        } catch (Throwable th) {
            InterfaceC10967e interfaceC10967e = (InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class);
            if (interfaceC10967e != null) {
                interfaceC10967e.gatherException(th);
            }
        }
    }
}
