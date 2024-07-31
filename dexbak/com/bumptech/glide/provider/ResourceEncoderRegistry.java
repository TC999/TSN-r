package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.provider.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ResourceEncoderRegistry {

    /* renamed from: a */
    private final List<C3743a<?>> f14325a = new ArrayList();

    /* compiled from: ResourceEncoderRegistry.java */
    /* renamed from: com.bumptech.glide.provider.f$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static final class C3743a<T> {

        /* renamed from: a */
        private final Class<T> f14326a;

        /* renamed from: b */
        final ResourceEncoder<T> f14327b;

        C3743a(@NonNull Class<T> cls, @NonNull ResourceEncoder<T> resourceEncoder) {
            this.f14326a = cls;
            this.f14327b = resourceEncoder;
        }

        /* renamed from: a */
        boolean m44682a(@NonNull Class<?> cls) {
            return this.f14326a.isAssignableFrom(cls);
        }
    }

    /* renamed from: a */
    public synchronized <Z> void m44685a(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        this.f14325a.add(new C3743a<>(cls, resourceEncoder));
    }

    @Nullable
    /* renamed from: b */
    public synchronized <Z> ResourceEncoder<Z> m44684b(@NonNull Class<Z> cls) {
        int size = this.f14325a.size();
        for (int i = 0; i < size; i++) {
            C3743a<?> c3743a = this.f14325a.get(i);
            if (c3743a.m44682a(cls)) {
                return (ResourceEncoder<Z>) c3743a.f14327b;
            }
        }
        return null;
    }

    /* renamed from: c */
    public synchronized <Z> void m44683c(@NonNull Class<Z> cls, @NonNull ResourceEncoder<Z> resourceEncoder) {
        this.f14325a.add(0, new C3743a<>(cls, resourceEncoder));
    }
}
