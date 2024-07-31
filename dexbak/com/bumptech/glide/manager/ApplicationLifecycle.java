package com.bumptech.glide.manager;

import androidx.annotation.NonNull;

/* renamed from: com.bumptech.glide.manager.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class ApplicationLifecycle implements Lifecycle {
    @Override // com.bumptech.glide.manager.Lifecycle
    /* renamed from: a */
    public void mo44762a(@NonNull LifecycleListener lifecycleListener) {
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    /* renamed from: b */
    public void mo44761b(@NonNull LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }
}
