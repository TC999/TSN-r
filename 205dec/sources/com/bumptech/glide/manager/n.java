package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: RequestTracker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class n {

    /* renamed from: d  reason: collision with root package name */
    private static final String f17620d = "RequestTracker";

    /* renamed from: a  reason: collision with root package name */
    private final Set<com.bumptech.glide.request.d> f17621a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final List<com.bumptech.glide.request.d> f17622b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private boolean f17623c;

    private boolean b(@Nullable com.bumptech.glide.request.d dVar, boolean z3) {
        boolean z4 = true;
        if (dVar == null) {
            return true;
        }
        boolean remove = this.f17621a.remove(dVar);
        if (!this.f17622b.remove(dVar) && !remove) {
            z4 = false;
        }
        if (z4) {
            dVar.clear();
            if (z3) {
                dVar.recycle();
            }
        }
        return z4;
    }

    @VisibleForTesting
    void a(com.bumptech.glide.request.d dVar) {
        this.f17621a.add(dVar);
    }

    public boolean c(@Nullable com.bumptech.glide.request.d dVar) {
        return b(dVar, true);
    }

    public void d() {
        for (com.bumptech.glide.request.d dVar : com.bumptech.glide.util.k.k(this.f17621a)) {
            b(dVar, false);
        }
        this.f17622b.clear();
    }

    public boolean e() {
        return this.f17623c;
    }

    public void f() {
        this.f17623c = true;
        for (com.bumptech.glide.request.d dVar : com.bumptech.glide.util.k.k(this.f17621a)) {
            if (dVar.isRunning() || dVar.a()) {
                dVar.clear();
                this.f17622b.add(dVar);
            }
        }
    }

    public void g() {
        this.f17623c = true;
        for (com.bumptech.glide.request.d dVar : com.bumptech.glide.util.k.k(this.f17621a)) {
            if (dVar.isRunning()) {
                dVar.clear();
                this.f17622b.add(dVar);
            }
        }
    }

    public void h() {
        for (com.bumptech.glide.request.d dVar : com.bumptech.glide.util.k.k(this.f17621a)) {
            if (!dVar.a() && !dVar.g()) {
                dVar.clear();
                if (!this.f17623c) {
                    dVar.j();
                } else {
                    this.f17622b.add(dVar);
                }
            }
        }
    }

    public void i() {
        this.f17623c = false;
        for (com.bumptech.glide.request.d dVar : com.bumptech.glide.util.k.k(this.f17621a)) {
            if (!dVar.a() && !dVar.isRunning()) {
                dVar.j();
            }
        }
        this.f17622b.clear();
    }

    public void j(@NonNull com.bumptech.glide.request.d dVar) {
        this.f17621a.add(dVar);
        if (!this.f17623c) {
            dVar.j();
            return;
        }
        dVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f17622b.add(dVar);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f17621a.size() + ", isPaused=" + this.f17623c + "}";
    }
}
