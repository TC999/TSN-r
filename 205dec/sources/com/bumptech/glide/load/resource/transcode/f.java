package com.bumptech.glide.load.resource.transcode;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: TranscoderRegistry.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<?, ?>> f17573a = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: TranscoderRegistry.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class a<Z, R> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<Z> f17574a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<R> f17575b;

        /* renamed from: c  reason: collision with root package name */
        final e<Z, R> f17576c;

        a(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
            this.f17574a = cls;
            this.f17575b = cls2;
            this.f17576c = eVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f17574a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f17575b);
        }
    }

    @NonNull
    public synchronized <Z, R> e<Z, R> a(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.b();
        }
        for (a<?, ?> aVar : this.f17573a) {
            if (aVar.a(cls, cls2)) {
                return (e<Z, R>) aVar.f17576c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    @NonNull
    public synchronized <Z, R> List<Class<R>> b(@NonNull Class<Z> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> aVar : this.f17573a) {
            if (aVar.a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void c(@NonNull Class<Z> cls, @NonNull Class<R> cls2, @NonNull e<Z, R> eVar) {
        this.f17573a.add(new a<>(cls, cls2, eVar));
    }
}
