package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ActivityFragmentLifecycle.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class a implements h {

    /* renamed from: a  reason: collision with root package name */
    private final Set<i> f17586a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f17587b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17588c;

    @Override // com.bumptech.glide.manager.h
    public void a(@NonNull i iVar) {
        this.f17586a.remove(iVar);
    }

    @Override // com.bumptech.glide.manager.h
    public void b(@NonNull i iVar) {
        this.f17586a.add(iVar);
        if (this.f17588c) {
            iVar.onDestroy();
        } else if (this.f17587b) {
            iVar.onStart();
        } else {
            iVar.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f17588c = true;
        for (i iVar : com.bumptech.glide.util.k.k(this.f17586a)) {
            iVar.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f17587b = true;
        for (i iVar : com.bumptech.glide.util.k.k(this.f17586a)) {
            iVar.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        this.f17587b = false;
        for (i iVar : com.bumptech.glide.util.k.k(this.f17586a)) {
            iVar.onStop();
        }
    }
}
