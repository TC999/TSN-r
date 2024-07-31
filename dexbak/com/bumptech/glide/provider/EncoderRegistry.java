package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Encoder;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.provider.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class EncoderRegistry {

    /* renamed from: a */
    private final List<C3741a<?>> f14311a = new ArrayList();

    /* compiled from: EncoderRegistry.java */
    /* renamed from: com.bumptech.glide.provider.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static final class C3741a<T> {

        /* renamed from: a */
        private final Class<T> f14312a;

        /* renamed from: b */
        final Encoder<T> f14313b;

        C3741a(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
            this.f14312a = cls;
            this.f14313b = encoder;
        }

        /* renamed from: a */
        boolean m44702a(@NonNull Class<?> cls) {
            return this.f14312a.isAssignableFrom(cls);
        }
    }

    /* renamed from: a */
    public synchronized <T> void m44705a(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.f14311a.add(new C3741a<>(cls, encoder));
    }

    @Nullable
    /* renamed from: b */
    public synchronized <T> Encoder<T> m44704b(@NonNull Class<T> cls) {
        for (C3741a<?> c3741a : this.f14311a) {
            if (c3741a.m44702a(cls)) {
                return (Encoder<T>) c3741a.f14313b;
            }
        }
        return null;
    }

    /* renamed from: c */
    public synchronized <T> void m44703c(@NonNull Class<T> cls, @NonNull Encoder<T> encoder) {
        this.f14311a.add(0, new C3741a<>(cls, encoder));
    }
}
