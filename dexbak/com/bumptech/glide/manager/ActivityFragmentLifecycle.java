package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.C3771k;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.bumptech.glide.manager.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class ActivityFragmentLifecycle implements Lifecycle {

    /* renamed from: a */
    private final Set<LifecycleListener> f14269a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b */
    private boolean f14270b;

    /* renamed from: c */
    private boolean f14271c;

    @Override // com.bumptech.glide.manager.Lifecycle
    /* renamed from: a */
    public void mo44762a(@NonNull LifecycleListener lifecycleListener) {
        this.f14269a.remove(lifecycleListener);
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    /* renamed from: b */
    public void mo44761b(@NonNull LifecycleListener lifecycleListener) {
        this.f14269a.add(lifecycleListener);
        if (this.f14271c) {
            lifecycleListener.onDestroy();
        } else if (this.f14270b) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m44770c() {
        this.f14271c = true;
        for (LifecycleListener lifecycleListener : C3771k.m44380k(this.f14269a)) {
            lifecycleListener.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m44769d() {
        this.f14270b = true;
        for (LifecycleListener lifecycleListener : C3771k.m44380k(this.f14269a)) {
            lifecycleListener.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m44768e() {
        this.f14270b = false;
        for (LifecycleListener lifecycleListener : C3771k.m44380k(this.f14269a)) {
            lifecycleListener.onStop();
        }
    }
}
