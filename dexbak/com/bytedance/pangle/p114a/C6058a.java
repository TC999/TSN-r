package com.bytedance.pangle.p114a;

import com.bytedance.pangle.p119d.C6083e;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.bytedance.pangle.a.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6058a {

    /* renamed from: a */
    final CountDownLatch f21845a;

    /* renamed from: b */
    Throwable f21846b;

    /* renamed from: com.bytedance.pangle.a.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC6060a {
        /* renamed from: a */
        void mo37040a();
    }

    private C6058a(InterfaceC6060a[] interfaceC6060aArr) {
        this.f21845a = new CountDownLatch(interfaceC6060aArr.length);
        for (final InterfaceC6060a interfaceC6060a : interfaceC6060aArr) {
            C6083e.m37212a(new Runnable() { // from class: com.bytedance.pangle.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        interfaceC6060a.mo37040a();
                    } catch (Throwable th) {
                        C6058a.this.f21846b = th;
                    }
                    C6058a.this.f21845a.countDown();
                }
            });
        }
    }

    /* renamed from: a */
    public static void m37275a(InterfaceC6060a... interfaceC6060aArr) {
        C6058a c6058a = new C6058a(interfaceC6060aArr);
        try {
            c6058a.f21845a.await();
            Throwable th = c6058a.f21846b;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
