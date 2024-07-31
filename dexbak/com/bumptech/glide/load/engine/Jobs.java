package com.bumptech.glide.load.engine;

import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.engine.r */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class Jobs {

    /* renamed from: a */
    private final Map<Key, EngineJob<?>> f13897a = new HashMap();

    /* renamed from: b */
    private final Map<Key, EngineJob<?>> f13898b = new HashMap();

    /* renamed from: c */
    private Map<Key, EngineJob<?>> m45144c(boolean z) {
        return z ? this.f13898b : this.f13897a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public EngineJob<?> m45146a(Key key, boolean z) {
        return m45144c(z).get(key);
    }

    @VisibleForTesting
    /* renamed from: b */
    Map<Key, EngineJob<?>> m45145b() {
        return Collections.unmodifiableMap(this.f13897a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m45143d(Key key, EngineJob<?> engineJob) {
        m45144c(engineJob.m45185q()).put(key, engineJob);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m45142e(Key key, EngineJob<?> engineJob) {
        Map<Key, EngineJob<?>> m45144c = m45144c(engineJob.m45185q());
        if (engineJob.equals(m45144c.get(key))) {
            m45144c.remove(key);
        }
    }
}
