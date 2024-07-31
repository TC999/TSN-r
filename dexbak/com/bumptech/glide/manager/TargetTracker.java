package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.C3771k;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.bumptech.glide.manager.o */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class TargetTracker implements LifecycleListener {

    /* renamed from: a */
    private final Set<Target<?>> f14307a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: a */
    public void m44715a() {
        this.f14307a.clear();
    }

    @NonNull
    /* renamed from: c */
    public List<Target<?>> m44714c() {
        return C3771k.m44380k(this.f14307a);
    }

    /* renamed from: d */
    public void m44713d(@NonNull Target<?> target) {
        this.f14307a.add(target);
    }

    /* renamed from: e */
    public void m44712e(@NonNull Target<?> target) {
        this.f14307a.remove(target);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        for (Target target : C3771k.m44380k(this.f14307a)) {
            target.onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        for (Target target : C3771k.m44380k(this.f14307a)) {
            target.onStart();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        for (Target target : C3771k.m44380k(this.f14307a)) {
            target.onStop();
        }
    }
}
