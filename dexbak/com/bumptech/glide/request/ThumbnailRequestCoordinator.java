package com.bumptech.glide.request;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/* renamed from: com.bumptech.glide.request.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ThumbnailRequestCoordinator implements RequestCoordinator, InterfaceC3744d {
    @Nullable

    /* renamed from: a */
    private final RequestCoordinator f14436a;

    /* renamed from: b */
    private InterfaceC3744d f14437b;

    /* renamed from: c */
    private InterfaceC3744d f14438c;

    /* renamed from: d */
    private boolean f14439d;

    @VisibleForTesting
    ThumbnailRequestCoordinator() {
        this(null);
    }

    /* renamed from: m */
    private boolean m44521m() {
        RequestCoordinator requestCoordinator = this.f14436a;
        return requestCoordinator == null || requestCoordinator.mo44522l(this);
    }

    /* renamed from: n */
    private boolean m44520n() {
        RequestCoordinator requestCoordinator = this.f14436a;
        return requestCoordinator == null || requestCoordinator.mo44531c(this);
    }

    /* renamed from: o */
    private boolean m44519o() {
        RequestCoordinator requestCoordinator = this.f14436a;
        return requestCoordinator == null || requestCoordinator.mo44529e(this);
    }

    /* renamed from: p */
    private boolean m44518p() {
        RequestCoordinator requestCoordinator = this.f14436a;
        return requestCoordinator != null && requestCoordinator.mo44532b();
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: a */
    public boolean mo44533a() {
        return this.f14437b.mo44533a() || this.f14438c.mo44533a();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: b */
    public boolean mo44532b() {
        return m44518p() || mo44530d();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: c */
    public boolean mo44531c(InterfaceC3744d interfaceC3744d) {
        return m44520n() && interfaceC3744d.equals(this.f14437b) && !mo44532b();
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    public void clear() {
        this.f14439d = false;
        this.f14438c.clear();
        this.f14437b.clear();
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: d */
    public boolean mo44530d() {
        return this.f14437b.mo44530d() || this.f14438c.mo44530d();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: e */
    public boolean mo44529e(InterfaceC3744d interfaceC3744d) {
        return m44519o() && (interfaceC3744d.equals(this.f14437b) || !this.f14437b.mo44530d());
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: f */
    public boolean mo44528f() {
        return this.f14437b.mo44528f();
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: g */
    public boolean mo44527g() {
        return this.f14437b.mo44527g();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: h */
    public void mo44526h(InterfaceC3744d interfaceC3744d) {
        RequestCoordinator requestCoordinator;
        if (interfaceC3744d.equals(this.f14437b) && (requestCoordinator = this.f14436a) != null) {
            requestCoordinator.mo44526h(this);
        }
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: i */
    public boolean mo44525i(InterfaceC3744d interfaceC3744d) {
        if (interfaceC3744d instanceof ThumbnailRequestCoordinator) {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator = (ThumbnailRequestCoordinator) interfaceC3744d;
            InterfaceC3744d interfaceC3744d2 = this.f14437b;
            if (interfaceC3744d2 == null) {
                if (thumbnailRequestCoordinator.f14437b != null) {
                    return false;
                }
            } else if (!interfaceC3744d2.mo44525i(thumbnailRequestCoordinator.f14437b)) {
                return false;
            }
            InterfaceC3744d interfaceC3744d3 = this.f14438c;
            InterfaceC3744d interfaceC3744d4 = thumbnailRequestCoordinator.f14438c;
            if (interfaceC3744d3 == null) {
                if (interfaceC3744d4 != null) {
                    return false;
                }
            } else if (!interfaceC3744d3.mo44525i(interfaceC3744d4)) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    public boolean isRunning() {
        return this.f14437b.isRunning();
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    /* renamed from: j */
    public void mo44524j() {
        this.f14439d = true;
        if (!this.f14437b.mo44533a() && !this.f14438c.isRunning()) {
            this.f14438c.mo44524j();
        }
        if (!this.f14439d || this.f14437b.isRunning()) {
            return;
        }
        this.f14437b.mo44524j();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: k */
    public void mo44523k(InterfaceC3744d interfaceC3744d) {
        if (interfaceC3744d.equals(this.f14438c)) {
            return;
        }
        RequestCoordinator requestCoordinator = this.f14436a;
        if (requestCoordinator != null) {
            requestCoordinator.mo44523k(this);
        }
        if (this.f14438c.mo44533a()) {
            return;
        }
        this.f14438c.clear();
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    /* renamed from: l */
    public boolean mo44522l(InterfaceC3744d interfaceC3744d) {
        return m44521m() && interfaceC3744d.equals(this.f14437b);
    }

    /* renamed from: q */
    public void m44517q(InterfaceC3744d interfaceC3744d, InterfaceC3744d interfaceC3744d2) {
        this.f14437b = interfaceC3744d;
        this.f14438c = interfaceC3744d2;
    }

    @Override // com.bumptech.glide.request.InterfaceC3744d
    public void recycle() {
        this.f14437b.recycle();
        this.f14438c.recycle();
    }

    public ThumbnailRequestCoordinator(@Nullable RequestCoordinator requestCoordinator) {
        this.f14436a = requestCoordinator;
    }
}
