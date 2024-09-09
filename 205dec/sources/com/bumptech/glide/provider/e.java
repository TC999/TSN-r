package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ResourceDecoderRegistry.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f17637a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, List<a<?, ?>>> f17638b = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: ResourceDecoderRegistry.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class a<T, R> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<T> f17639a;

        /* renamed from: b  reason: collision with root package name */
        final Class<R> f17640b;

        /* renamed from: c  reason: collision with root package name */
        final g<T, R> f17641c;

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, g<T, R> gVar) {
            this.f17639a = cls;
            this.f17640b = cls2;
            this.f17641c = gVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.f17639a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f17640b);
        }
    }

    @NonNull
    private synchronized List<a<?, ?>> c(@NonNull String str) {
        List<a<?, ?>> list;
        if (!this.f17637a.contains(str)) {
            this.f17637a.add(str);
        }
        list = this.f17638b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.f17638b.put(str, list);
        }
        return list;
    }

    public synchronized <T, R> void a(@NonNull String str, @NonNull g<T, R> gVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        c(str).add(new a<>(cls, cls2, gVar));
    }

    @NonNull
    public synchronized <T, R> List<g<T, R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f17637a) {
            List<a<?, ?>> list = this.f17638b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f17641c);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> d(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.f17637a) {
            List<a<?, ?>> list = this.f17638b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f17640b)) {
                        arrayList.add(aVar.f17640b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void e(@NonNull String str, @NonNull g<T, R> gVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        c(str).add(0, new a<>(cls, cls2, gVar));
    }

    public synchronized void f(@NonNull List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.f17637a);
        this.f17637a.clear();
        this.f17637a.addAll(list);
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f17637a.add(str);
            }
        }
    }
}
