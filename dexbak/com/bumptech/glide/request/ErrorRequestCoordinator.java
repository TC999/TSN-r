package com.bumptech.glide.request;

import androidx.annotation.Nullable;

/* renamed from: com.bumptech.glide.request.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ErrorRequestCoordinator implements RequestCoordinator, InterfaceC3744d {
    @Nullable

    /* renamed from: a */
    private final RequestCoordinator f14375a;

    /* renamed from: b */
    private InterfaceC3744d f14376b;

    /* renamed from: c */
    private InterfaceC3744d f14377c;

    public ErrorRequestCoordinator(@Nullable RequestCoordinator requestCoordinator) {
        this.f14375a = requestCoordinator;
    }

    /* renamed from: m */
    private boolean m44594m(InterfaceC3744d interfaceC3744d) {
        return interfaceC3744d.equals(this.f14376b) || (this.f14376b.mo44528f() && interfaceC3744d.equals(this.f14377c));
    }

    /* renamed from: n */
    private boolean m44593n() {
        RequestCoordinator requestCoordinator = this.f14375a;
        return requestCoordinator == null || requestCoordinator.mo44522l(this);
    }

    /* renamed from: o */
    private boolean m44592o() {
        RequestCoordinator requestCoordinator = this.f14375a;
        return requestCoordinator == null || requestCoordinator.mo44531c(this);
    }

    /* renamed from: p */
    private boolean m44591p() {
        RequestCoordinator requestCoordinator = this.f14375a;
        return requestCoordinator == null || requestCoordinator.mo44529e(this);
    }

    /* renamed from: q */
    private boolean m44590q() {
        RequestCoordinator requestCoordinator = this.f14375a;
        return requestCoordinator != null && requestCoordinator.mo44532b();
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: a */
    public boolean mo44533a() {
        return (this.f14376b.mo44528f() ? this.f14377c : this.f14376b).mo44533a();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: b */
    public boolean mo44532b() {
        return m44590q() || mo44530d();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: c */
    public boolean mo44531c(InterfaceC3744d interfaceC3744d) {
        return m44592o() && m44594m(interfaceC3744d);
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    public void clear() {
        this.f14376b.clear();
        if (this.f14377c.isRunning()) {
            this.f14377c.clear();
        }
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: d */
    public boolean mo44530d() {
        return (this.f14376b.mo44528f() ? this.f14377c : this.f14376b).mo44530d();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: e */
    public boolean mo44529e(InterfaceC3744d interfaceC3744d) {
        return m44591p() && m44594m(interfaceC3744d);
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: f */
    public boolean mo44528f() {
        return this.f14376b.mo44528f() && this.f14377c.mo44528f();
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: g */
    public boolean mo44527g() {
        return (this.f14376b.mo44528f() ? this.f14377c : this.f14376b).mo44527g();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: h */
    public void mo44526h(InterfaceC3744d interfaceC3744d) {
        if (!interfaceC3744d.equals(this.f14377c)) {
            if (this.f14377c.isRunning()) {
                return;
            }
            this.f14377c.mo44524j();
            return;
        }
        RequestCoordinator requestCoordinator = this.f14375a;
        if (requestCoordinator != null) {
            requestCoordinator.mo44526h(this);
        }
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: i */
    public boolean mo44525i(InterfaceC3744d interfaceC3744d) {
        if (interfaceC3744d instanceof ErrorRequestCoordinator) {
            ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) interfaceC3744d;
            return this.f14376b.mo44525i(errorRequestCoordinator.f14376b) && this.f14377c.mo44525i(errorRequestCoordinator.f14377c);
        }
        return false;
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    public boolean isRunning() {
        return (this.f14376b.mo44528f() ? this.f14377c : this.f14376b).isRunning();
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: j */
    public void mo44524j() {
        if (this.f14376b.isRunning()) {
            return;
        }
        this.f14376b.mo44524j();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: k */
    public void mo44523k(InterfaceC3744d interfaceC3744d) {
        RequestCoordinator requestCoordinator = this.f14375a;
        if (requestCoordinator != null) {
            requestCoordinator.mo44523k(this);
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: l */
    public boolean mo44522l(InterfaceC3744d interfaceC3744d) {
        return m44593n() && m44594m(interfaceC3744d);
    }

    /* renamed from: r */
    public void m44589r(InterfaceC3744d interfaceC3744d, InterfaceC3744d interfaceC3744d2) {
        this.f14376b = interfaceC3744d;
        this.f14377c = interfaceC3744d2;
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    public void recycle() {
        this.f14376b.recycle();
        this.f14377c.recycle();
    }
}
