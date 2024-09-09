package com.qq.e.comm.plugin.q0;

import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class q {

    /* renamed from: c  reason: collision with root package name */
    private static final String f45518c = "q";

    /* renamed from: a  reason: collision with root package name */
    private final com.qq.e.comm.plugin.q0.s.g f45519a;

    /* renamed from: b  reason: collision with root package name */
    private int f45520b = -1;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q.this.a();
        }
    }

    public q(com.qq.e.comm.plugin.q0.s.g gVar) {
        this.f45519a = gVar;
    }

    public void a(int i4) {
        if (this.f45520b != -1) {
            String str = f45518c;
            d1.a(str, "emitEvent, pending...  replace [pendingVisibility] to : " + i4);
            this.f45520b = i4;
            return;
        }
        String str2 = f45518c;
        d1.a(str2, "emitEvent, idle...  start pending, [pendingVisibility] : " + i4);
        this.f45520b = i4;
        p0.a(new a(), 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        String str = f45518c;
        d1.a(str, "pending finish, emit [pendingVisibility] : " + this.f45520b);
        com.qq.e.comm.plugin.q0.s.g gVar = this.f45519a;
        if (gVar == null) {
            this.f45520b = -1;
            return;
        }
        if (this.f45520b == 0) {
            gVar.a(new com.qq.e.comm.plugin.q0.s.b("onPageShown", null));
            d1.a("onPageShown", new Object[0]);
        } else {
            gVar.a(new com.qq.e.comm.plugin.q0.s.b("onPageHidden", null));
            d1.a("onPageHidden", new Object[0]);
        }
        this.f45520b = -1;
    }
}
