package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.request.InterfaceC3744d;
import com.bumptech.glide.util.C3771k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.bumptech.glide.manager.n */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RequestTracker {

    /* renamed from: d */
    private static final String f14303d = "RequestTracker";

    /* renamed from: a */
    private final Set<InterfaceC3744d> f14304a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    private final List<InterfaceC3744d> f14305b = new ArrayList();

    /* renamed from: c */
    private boolean f14306c;

    /* renamed from: b */
    private boolean m44724b(@Nullable InterfaceC3744d interfaceC3744d, boolean z) {
        boolean z2 = true;
        if (interfaceC3744d == null) {
            return true;
        }
        boolean remove = this.f14304a.remove(interfaceC3744d);
        if (!this.f14305b.remove(interfaceC3744d) && !remove) {
            z2 = false;
        }
        if (z2) {
            interfaceC3744d.clear();
            if (z) {
                interfaceC3744d.recycle();
            }
        }
        return z2;
    }

    @VisibleForTesting
    /* renamed from: a */
    void m44725a(InterfaceC3744d interfaceC3744d) {
        this.f14304a.add(interfaceC3744d);
    }

    /* renamed from: c */
    public boolean m44723c(@Nullable InterfaceC3744d interfaceC3744d) {
        return m44724b(interfaceC3744d, true);
    }

    /* renamed from: d */
    public void m44722d() {
        for (InterfaceC3744d interfaceC3744d : C3771k.m44380k(this.f14304a)) {
            m44724b(interfaceC3744d, false);
        }
        this.f14305b.clear();
    }

    /* renamed from: e */
    public boolean m44721e() {
        return this.f14306c;
    }

    /* renamed from: f */
    public void m44720f() {
        this.f14306c = true;
        for (InterfaceC3744d interfaceC3744d : C3771k.m44380k(this.f14304a)) {
            if (interfaceC3744d.isRunning() || interfaceC3744d.mo44533a()) {
                interfaceC3744d.clear();
                this.f14305b.add(interfaceC3744d);
            }
        }
    }

    /* renamed from: g */
    public void m44719g() {
        this.f14306c = true;
        for (InterfaceC3744d interfaceC3744d : C3771k.m44380k(this.f14304a)) {
            if (interfaceC3744d.isRunning()) {
                interfaceC3744d.clear();
                this.f14305b.add(interfaceC3744d);
            }
        }
    }

    /* renamed from: h */
    public void m44718h() {
        for (InterfaceC3744d interfaceC3744d : C3771k.m44380k(this.f14304a)) {
            if (!interfaceC3744d.mo44533a() && !interfaceC3744d.mo44527g()) {
                interfaceC3744d.clear();
                if (!this.f14306c) {
                    interfaceC3744d.mo44524j();
                } else {
                    this.f14305b.add(interfaceC3744d);
                }
            }
        }
    }

    /* renamed from: i */
    public void m44717i() {
        this.f14306c = false;
        for (InterfaceC3744d interfaceC3744d : C3771k.m44380k(this.f14304a)) {
            if (!interfaceC3744d.mo44533a() && !interfaceC3744d.isRunning()) {
                interfaceC3744d.mo44524j();
            }
        }
        this.f14305b.clear();
    }

    /* renamed from: j */
    public void m44716j(@NonNull InterfaceC3744d interfaceC3744d) {
        this.f14304a.add(interfaceC3744d);
        if (!this.f14306c) {
            interfaceC3744d.mo44524j();
            return;
        }
        interfaceC3744d.clear();
        if (Log.isLoggable(f14303d, 2)) {
            Log.v(f14303d, "Paused, delaying request");
        }
        this.f14305b.add(interfaceC3744d);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f14304a.size() + ", isPaused=" + this.f14306c + "}";
    }
}
