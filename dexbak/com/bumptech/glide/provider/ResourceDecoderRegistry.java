package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.ResourceDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.bumptech.glide.provider.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ResourceDecoderRegistry {

    /* renamed from: a */
    private final List<String> f14320a = new ArrayList();

    /* renamed from: b */
    private final Map<String, List<C3742a<?, ?>>> f14321b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ResourceDecoderRegistry.java */
    /* renamed from: com.bumptech.glide.provider.e$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3742a<T, R> {

        /* renamed from: a */
        private final Class<T> f14322a;

        /* renamed from: b */
        final Class<R> f14323b;

        /* renamed from: c */
        final ResourceDecoder<T, R> f14324c;

        public C3742a(@NonNull Class<T> cls, @NonNull Class<R> cls2, ResourceDecoder<T, R> resourceDecoder) {
            this.f14322a = cls;
            this.f14323b = cls2;
            this.f14324c = resourceDecoder;
        }

        /* renamed from: a */
        public boolean m44686a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f14322a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f14323b);
        }
    }

    @NonNull
    /* renamed from: c */
    private synchronized List<C3742a<?, ?>> m44690c(@NonNull String str) {
        List<C3742a<?, ?>> list;
        if (!this.f14320a.contains(str)) {
            this.f14320a.add(str);
        }
        list = this.f14321b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f14321b.put(str, list);
        }
        return list;
    }

    /* renamed from: a */
    public synchronized <T, R> void m44692a(@NonNull String str, @NonNull ResourceDecoder<T, R> resourceDecoder, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        m44690c(str).add(new C3742a<>(cls, cls2, resourceDecoder));
    }

    @NonNull
    /* renamed from: b */
    public synchronized <T, R> List<ResourceDecoder<T, R>> m44691b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f14320a) {
            List<C3742a<?, ?>> list = this.f14321b.get(str);
            if (list != null) {
                for (C3742a<?, ?> c3742a : list) {
                    if (c3742a.m44686a(cls, cls2)) {
                        arrayList.add(c3742a.f14324c);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: d */
    public synchronized <T, R> List<Class<R>> m44689d(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f14320a) {
            List<C3742a<?, ?>> list = this.f14321b.get(str);
            if (list != null) {
                for (C3742a<?, ?> c3742a : list) {
                    if (c3742a.m44686a(cls, cls2) && !arrayList.contains(c3742a.f14323b)) {
                        arrayList.add(c3742a.f14323b);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public synchronized <T, R> void m44688e(@NonNull String str, @NonNull ResourceDecoder<T, R> resourceDecoder, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        m44690c(str).add(0, new C3742a<>(cls, cls2, resourceDecoder));
    }

    /* renamed from: f */
    public synchronized void m44687f(@NonNull List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.f14320a);
        this.f14320a.clear();
        this.f14320a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f14320a.add(str);
            }
        }
    }
}
