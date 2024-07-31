package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.bumptech.glide.load.resource.transcode.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TranscoderRegistry {

    /* renamed from: a */
    private final List<C3734a<?, ?>> f14256a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TranscoderRegistry.java */
    /* renamed from: com.bumptech.glide.load.resource.transcode.f$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3734a<Z, R> {

        /* renamed from: a */
        private final Class<Z> f14257a;

        /* renamed from: b */
        private final Class<R> f14258b;

        /* renamed from: c */
        final ResourceTranscoder<Z, R> f14259c;

        C3734a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull ResourceTranscoder<Z, R> resourceTranscoder) {
            this.f14257a = cls;
            this.f14258b = cls2;
            this.f14259c = resourceTranscoder;
        }

        /* renamed from: a */
        public boolean m44785a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f14257a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f14258b);
        }
    }

    @NonNull
    /* renamed from: a */
    public synchronized <Z, R> ResourceTranscoder<Z, R> m44788a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return UnitTranscoder.m44783b();
        }
        for (C3734a<?, ?> c3734a : this.f14256a) {
            if (c3734a.m44785a(cls, cls2)) {
                return (ResourceTranscoder<Z, R>) c3734a.f14259c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    @NonNull
    /* renamed from: b */
    public synchronized <Z, R> List<Class<R>> m44787b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (C3734a<?, ?> c3734a : this.f14256a) {
            if (c3734a.m44785a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    /* renamed from: c */
    public synchronized <Z, R> void m44786c(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull ResourceTranscoder<Z, R> resourceTranscoder) {
        this.f14256a.add(new C3734a<>(cls, cls2, resourceTranscoder));
    }
}
