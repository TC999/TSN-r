package com.tencent.turingfd.sdk.ams.au;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Marc implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f52151c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AtomicReference f52152d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object f52153e;

    public Marc(AtomicBoolean atomicBoolean, AtomicReference atomicReference, Object obj) {
        this.f52151c = atomicBoolean;
        this.f52152d = atomicReference;
        this.f52153e = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        StackTraceElement[] stackTrace;
        if (this.f52151c.get()) {
            return;
        }
        try {
            throw new Exception("");
        } catch (Exception e4) {
            String a4 = Cextends.a(Cextends.F0);
            for (StackTraceElement stackTraceElement : e4.getStackTrace()) {
                if (a4.equals(stackTraceElement.getClassName() + "_" + stackTraceElement.getMethodName())) {
                    this.f52152d.set(Boolean.TRUE);
                }
            }
            synchronized (this.f52153e) {
                this.f52153e.notify();
            }
        }
    }
}
