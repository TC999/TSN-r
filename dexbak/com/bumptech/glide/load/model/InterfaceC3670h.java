package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders;
import java.util.Collections;
import java.util.Map;

/* compiled from: Headers.java */
/* renamed from: com.bumptech.glide.load.model.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface InterfaceC3670h {
    @Deprecated

    /* renamed from: a */
    public static final InterfaceC3670h f13976a = new C3671a();

    /* renamed from: b */
    public static final InterfaceC3670h f13977b = new LazyHeaders.C3672a().m45083c();

    /* compiled from: Headers.java */
    /* renamed from: com.bumptech.glide.load.model.h$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class C3671a implements InterfaceC3670h {
        C3671a() {
        }

        @Override // com.bumptech.glide.load.model.InterfaceC3670h
        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }
    }

    Map<String, String> getHeaders();
}
