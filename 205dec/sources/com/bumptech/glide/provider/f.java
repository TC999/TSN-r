package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.h;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ResourceEncoderRegistry.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?>> f17642a = new ArrayList();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ResourceEncoderRegistry.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static final class a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f17643a;

        /* renamed from: b  reason: collision with root package name */
        final h<T> f17644b;

        a(@NonNull Class<T> cls, @NonNull h<T> hVar) {
            this.f17643a = cls;
            this.f17644b = hVar;
        }

        boolean a(@NonNull Class<?> cls) {
            return this.f17643a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(@NonNull Class<Z> cls, @NonNull h<Z> hVar) {
        this.f17642a.add(new a<>(cls, hVar));
    }

    @Nullable
    public synchronized <Z> h<Z> b(@NonNull Class<Z> cls) {
        int size = this.f17642a.size();
        for (int i4 = 0; i4 < size; i4++) {
            a<?> aVar = this.f17642a.get(i4);
            if (aVar.a(cls)) {
                return (h<Z>) aVar.f17644b;
            }
        }
        return null;
    }

    public synchronized <Z> void c(@NonNull Class<Z> cls, @NonNull h<Z> hVar) {
        this.f17642a.add(0, new a<>(cls, hVar));
    }
}
