package com.bytedance.sdk.component.xv.w;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class eq {

    /* renamed from: c  reason: collision with root package name */
    final c f30971c;

    /* renamed from: w  reason: collision with root package name */
    final Proxy f30972w;
    final InetSocketAddress xv;

    public eq(c cVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (cVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress != null) {
            this.f30971c = cVar;
            this.f30972w = proxy;
            this.xv = inetSocketAddress;
            return;
        }
        throw new NullPointerException("inetSocketAddress == null");
    }

    public c c() {
        return this.f30971c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof eq) {
            eq eqVar = (eq) obj;
            if (eqVar.f30971c.equals(this.f30971c) && eqVar.f30972w.equals(this.f30972w) && eqVar.xv.equals(this.xv)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f30971c.hashCode()) * 31) + this.f30972w.hashCode()) * 31) + this.xv.hashCode();
    }

    public boolean sr() {
        return this.f30971c.gd != null && this.f30972w.type() == Proxy.Type.HTTP;
    }

    public String toString() {
        return "Route{" + this.xv + "}";
    }

    public Proxy w() {
        return this.f30972w;
    }

    public InetSocketAddress xv() {
        return this.xv;
    }
}
