package com.bytedance.sdk.component.xv.w.c.w;

import com.bytedance.sdk.component.xv.w.eq;
import com.bytedance.sdk.component.xv.w.fp;
import com.bytedance.sdk.component.xv.w.fz;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class f {

    /* renamed from: c  reason: collision with root package name */
    private final com.bytedance.sdk.component.xv.w.c f30912c;

    /* renamed from: f  reason: collision with root package name */
    private int f30913f;
    private final fp sr;

    /* renamed from: w  reason: collision with root package name */
    private final sr f30915w;
    private final com.bytedance.sdk.component.xv.w.ux xv;
    private List<Proxy> ux = Collections.emptyList();

    /* renamed from: r  reason: collision with root package name */
    private List<InetSocketAddress> f30914r = Collections.emptyList();
    private final List<eq> ev = new ArrayList();

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        private final List<eq> f30916c;

        /* renamed from: w  reason: collision with root package name */
        private int f30917w = 0;

        c(List<eq> list) {
            this.f30916c = list;
        }

        public boolean c() {
            return this.f30917w < this.f30916c.size();
        }

        public eq w() {
            if (c()) {
                List<eq> list = this.f30916c;
                int i4 = this.f30917w;
                this.f30917w = i4 + 1;
                return list.get(i4);
            }
            throw new NoSuchElementException();
        }

        public List<eq> xv() {
            return new ArrayList(this.f30916c);
        }
    }

    public f(com.bytedance.sdk.component.xv.w.c cVar, sr srVar, com.bytedance.sdk.component.xv.w.ux uxVar, fp fpVar) throws IOException {
        this.f30912c = cVar;
        this.f30915w = srVar;
        this.xv = uxVar;
        this.sr = fpVar;
        c(cVar.c(), cVar.ev());
    }

    private Proxy sr() throws IOException {
        if (xv()) {
            List<Proxy> list = this.ux;
            int i4 = this.f30913f;
            this.f30913f = i4 + 1;
            Proxy proxy = list.get(i4);
            c(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f30912c.c().r() + "; exhausted proxy configurations: " + this.ux);
    }

    private boolean xv() {
        return this.f30913f < this.ux.size();
    }

    public boolean c() {
        return xv() || !this.ev.isEmpty();
    }

    public c w() throws IOException {
        if (c()) {
            ArrayList arrayList = new ArrayList();
            while (xv()) {
                Proxy sr = sr();
                int size = this.f30914r.size();
                for (int i4 = 0; i4 < size; i4++) {
                    eq eqVar = new eq(this.f30912c, sr, this.f30914r.get(i4));
                    if (this.f30915w.xv(eqVar)) {
                        this.ev.add(eqVar);
                    } else {
                        arrayList.add(eqVar);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.ev);
                this.ev.clear();
            }
            return new c(arrayList);
        }
        throw new NoSuchElementException();
    }

    public void c(eq eqVar, IOException iOException) {
        if (eqVar.w().type() != Proxy.Type.DIRECT && this.f30912c.r() != null) {
            this.f30912c.r().connectFailed(this.f30912c.c().w(), eqVar.w().address(), iOException);
        }
        this.f30915w.c(eqVar);
    }

    private void c(fz fzVar, Proxy proxy) throws IOException {
        List<Proxy> c4;
        if (proxy != null) {
            this.ux = Collections.singletonList(proxy);
        } else {
            try {
                List<Proxy> select = this.f30912c.r().select(fzVar.w());
                if (select != null && !select.isEmpty()) {
                    c4 = com.bytedance.sdk.component.xv.w.c.xv.c(select);
                } else {
                    c4 = com.bytedance.sdk.component.xv.w.c.xv.c(Proxy.NO_PROXY);
                }
                this.ux = c4;
            } catch (IllegalArgumentException unused) {
                throw new IOException();
            }
        }
        this.f30913f = 0;
    }

    private void c(Proxy proxy) throws IOException {
        String r3;
        int ev;
        this.f30914r = new ArrayList();
        if (proxy.type() != Proxy.Type.DIRECT && proxy.type() != Proxy.Type.SOCKS) {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                r3 = c(inetSocketAddress);
                ev = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        } else {
            r3 = this.f30912c.c().r();
            ev = this.f30912c.c().ev();
        }
        if (ev >= 1 && ev <= 65535) {
            if (proxy.type() == Proxy.Type.SOCKS) {
                this.f30914r.add(InetSocketAddress.createUnresolved(r3, ev));
                return;
            }
            this.sr.c(this.xv, r3);
            List<InetAddress> c4 = this.f30912c.w().c(r3);
            if (c4.isEmpty()) {
                return;
            }
            this.sr.c(this.xv, r3, c4);
            int size = c4.size();
            for (int i4 = 0; i4 < size; i4++) {
                this.f30914r.add(new InetSocketAddress(c4.get(i4), ev));
            }
            return;
        }
        throw new SocketException("No route to " + r3 + ":" + ev + "; port is out of range");
    }

    static String c(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }
}
