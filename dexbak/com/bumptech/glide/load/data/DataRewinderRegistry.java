package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.util.C3770j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.bumptech.glide.load.data.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DataRewinderRegistry {

    /* renamed from: b */
    private static final DataRewinder.InterfaceC3563a<?> f13480b = new C3564a();

    /* renamed from: a */
    private final Map<Class<?>, DataRewinder.InterfaceC3563a<?>> f13481a = new HashMap();

    /* compiled from: DataRewinderRegistry.java */
    /* renamed from: com.bumptech.glide.load.data.f$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3564a implements DataRewinder.InterfaceC3563a<Object> {
        C3564a() {
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.InterfaceC3563a
        @NonNull
        /* renamed from: a */
        public Class<Object> mo2887a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.bumptech.glide.load.data.DataRewinder.InterfaceC3563a
        @NonNull
        /* renamed from: b */
        public DataRewinder<Object> mo2886b(@NonNull Object obj) {
            return new C3565b(obj);
        }
    }

    /* compiled from: DataRewinderRegistry.java */
    /* renamed from: com.bumptech.glide.load.data.f$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private static final class C3565b implements DataRewinder<Object> {

        /* renamed from: a */
        private final Object f13482a;

        C3565b(@NonNull Object obj) {
            this.f13482a = obj;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        @NonNull
        /* renamed from: a */
        public Object mo2890a() {
            return this.f13482a;
        }

        @Override // com.bumptech.glide.load.data.DataRewinder
        /* renamed from: b */
        public void mo2889b() {
        }
    }

    @NonNull
    /* renamed from: a */
    public synchronized <T> DataRewinder<T> m45476a(@NonNull T t) {
        DataRewinder.InterfaceC3563a<?> interfaceC3563a;
        C3770j.m44392d(t);
        interfaceC3563a = this.f13481a.get(t.getClass());
        if (interfaceC3563a == null) {
            Iterator<DataRewinder.InterfaceC3563a<?>> it = this.f13481a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DataRewinder.InterfaceC3563a<?> next = it.next();
                if (next.mo2887a().isAssignableFrom(t.getClass())) {
                    interfaceC3563a = next;
                    break;
                }
            }
        }
        if (interfaceC3563a == null) {
            interfaceC3563a = f13480b;
        }
        return (DataRewinder<T>) interfaceC3563a.mo2886b(t);
    }

    /* renamed from: b */
    public synchronized void m45475b(@NonNull DataRewinder.InterfaceC3563a<?> interfaceC3563a) {
        this.f13481a.put(interfaceC3563a.mo2887a(), interfaceC3563a);
    }
}
