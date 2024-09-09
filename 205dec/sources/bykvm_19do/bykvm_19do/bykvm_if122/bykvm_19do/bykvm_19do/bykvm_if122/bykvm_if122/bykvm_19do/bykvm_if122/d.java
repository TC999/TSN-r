package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0;
import java.util.LinkedHashSet;
import java.util.Set;

/* compiled from: RouteDatabase.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Set<c0> f971a = new LinkedHashSet();

    public synchronized void a(c0 c0Var) {
        this.f971a.remove(c0Var);
    }

    public synchronized void b(c0 c0Var) {
        this.f971a.add(c0Var);
    }

    public synchronized boolean c(c0 c0Var) {
        return this.f971a.contains(c0Var);
    }
}
