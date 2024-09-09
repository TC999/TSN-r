package com.tencent.turingfd.sdk.ams.au;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Pegasus extends Aquila {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReference<String> f52154a = new AtomicReference<>(null);

    /* renamed from: b  reason: collision with root package name */
    public final boolean f52155b;

    public Pegasus(boolean z3) {
        this.f52155b = z3;
    }

    public String toString() {
        synchronized (this.f52154a) {
            String str = this.f52154a.get();
            if (str != null) {
                return str;
            }
            try {
                this.f52154a.wait(2000L);
            } catch (InterruptedException unused) {
            }
            return this.f52154a.get();
        }
    }
}
