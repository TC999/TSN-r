package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DataRewinderRegistry.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class f {

    /* renamed from: b  reason: collision with root package name */
    private static final e.a<?> f16803b = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f16804a = new HashMap();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DataRewinderRegistry.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements e.a<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        public e<Object> b(@NonNull Object obj) {
            return new b(obj);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: DataRewinderRegistry.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static final class b implements e<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f16805a;

        b(@NonNull Object obj) {
            this.f16805a = obj;
        }

        @Override // com.bumptech.glide.load.data.e
        @NonNull
        public Object a() {
            return this.f16805a;
        }

        @Override // com.bumptech.glide.load.data.e
        public void b() {
        }
    }

    @NonNull
    public synchronized <T> e<T> a(@NonNull T t3) {
        e.a<?> aVar;
        com.bumptech.glide.util.j.d(t3);
        aVar = this.f16804a.get(t3.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.f16804a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.a().isAssignableFrom(t3.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f16803b;
        }
        return (e<T>) aVar.b(t3);
    }

    public synchronized void b(@NonNull e.a<?> aVar) {
        this.f16804a.put(aVar.a(), aVar);
    }
}
