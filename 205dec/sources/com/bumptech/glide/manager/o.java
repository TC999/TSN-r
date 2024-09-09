package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.request.target.p;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: TargetTracker.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class o implements i {

    /* renamed from: a  reason: collision with root package name */
    private final Set<p<?>> f17624a = Collections.newSetFromMap(new WeakHashMap());

    public void a() {
        this.f17624a.clear();
    }

    @NonNull
    public List<p<?>> c() {
        return com.bumptech.glide.util.k.k(this.f17624a);
    }

    public void d(@NonNull p<?> pVar) {
        this.f17624a.add(pVar);
    }

    public void e(@NonNull p<?> pVar) {
        this.f17624a.remove(pVar);
    }

    @Override // com.bumptech.glide.manager.i
    public void onDestroy() {
        for (p pVar : com.bumptech.glide.util.k.k(this.f17624a)) {
            pVar.onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.i
    public void onStart() {
        for (p pVar : com.bumptech.glide.util.k.k(this.f17624a)) {
            pVar.onStart();
        }
    }

    @Override // com.bumptech.glide.manager.i
    public void onStop() {
        for (p pVar : com.bumptech.glide.util.k.k(this.f17624a)) {
            pVar.onStop();
        }
    }
}
