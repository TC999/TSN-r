package com.bytedance.pangle.a;

import com.bytedance.pangle.d.e;
import java.util.concurrent.CountDownLatch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    final CountDownLatch f28614a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f28615b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* renamed from: com.bytedance.pangle.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0424a {
        void a();
    }

    private a(InterfaceC0424a[] interfaceC0424aArr) {
        this.f28614a = new CountDownLatch(interfaceC0424aArr.length);
        for (final InterfaceC0424a interfaceC0424a : interfaceC0424aArr) {
            e.a(new Runnable() { // from class: com.bytedance.pangle.a.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        interfaceC0424a.a();
                    } catch (Throwable th) {
                        a.this.f28615b = th;
                    }
                    a.this.f28614a.countDown();
                }
            });
        }
    }

    public static void a(InterfaceC0424a... interfaceC0424aArr) {
        a aVar = new a(interfaceC0424aArr);
        try {
            aVar.f28614a.await();
            Throwable th = aVar.f28615b;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e4) {
            throw new RuntimeException(e4);
        }
    }
}
