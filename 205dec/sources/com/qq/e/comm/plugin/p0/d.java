package com.qq.e.comm.plugin.p0;

import com.qq.e.comm.plugin.p0.a;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
final class d {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f45321a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    private final String f45322b;

    /* renamed from: c  reason: collision with root package name */
    private final int f45323c;

    /* renamed from: d  reason: collision with root package name */
    private volatile c f45324d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements a.InterfaceC0871a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f45325a;

        a(d dVar, c cVar) {
            this.f45325a = cVar;
        }

        @Override // com.qq.e.comm.plugin.p0.a.InterfaceC0871a
        public void a(boolean z3) {
            this.f45325a.a(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str, int i4) throws k {
        this.f45322b = (String) i.a(str);
        this.f45323c = i4;
    }

    private c b() throws k {
        c cVar;
        com.qq.e.comm.plugin.p0.a aVar = new com.qq.e.comm.plugin.p0.a(this.f45322b);
        if (this.f45323c > 0) {
            cVar = new f(aVar, this.f45322b);
        } else {
            cVar = new c(aVar, this.f45322b);
        }
        aVar.a(new a(this, cVar));
        cVar.a(aVar.g());
        return cVar;
    }

    private synchronized void c() throws k {
        this.f45324d = this.f45324d == null ? b() : this.f45324d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(b bVar, Socket socket) throws k, IOException {
        c();
        try {
            this.f45321a.incrementAndGet();
            this.f45324d.a(bVar, socket);
        } finally {
            a();
        }
    }

    private synchronized void a() {
        if (this.f45321a.decrementAndGet() <= 0) {
            this.f45324d.b();
            this.f45324d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(String str) {
        if (this.f45324d != null) {
            this.f45324d.a(str);
        }
    }
}
