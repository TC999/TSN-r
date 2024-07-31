package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Route;
import java.util.LinkedHashSet;
import java.util.Set;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RouteDatabase {

    /* renamed from: a */
    private final Set<Route> f978a = new LinkedHashSet();

    /* renamed from: a */
    public synchronized void m58721a(Route route) {
        this.f978a.remove(route);
    }

    /* renamed from: b */
    public synchronized void m58720b(Route route) {
        this.f978a.add(route);
    }

    /* renamed from: c */
    public synchronized boolean m58719c(Route route) {
        return this.f978a.contains(route);
    }
}
