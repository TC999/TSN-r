package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: EncoderRegistry.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<C0179a<?>> f17628a = new ArrayList();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: EncoderRegistry.java */
    /* renamed from: com.bumptech.glide.provider.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static final class C0179a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f17629a;

        /* renamed from: b  reason: collision with root package name */
        final com.bumptech.glide.load.a<T> f17630b;

        C0179a(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.a<T> aVar) {
            this.f17629a = cls;
            this.f17630b = aVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.f17629a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.a<T> aVar) {
        this.f17628a.add(new C0179a<>(cls, aVar));
    }

    @Nullable
    public synchronized <T> com.bumptech.glide.load.a<T> b(@NonNull Class<T> cls) {
        for (C0179a<?> c0179a : this.f17628a) {
            if (c0179a.a(cls)) {
                return (com.bumptech.glide.load.a<T>) c0179a.f17630b;
            }
        }
        return null;
    }

    public synchronized <T> void c(@NonNull Class<T> cls, @NonNull com.bumptech.glide.load.a<T> aVar) {
        this.f17628a.add(0, new C0179a<>(cls, aVar));
    }
}
