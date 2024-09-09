package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.j;
import java.util.Collections;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Headers.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface h {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final h f17293a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final h f17294b = new j.a().c();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: Headers.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class a implements h {
        a() {
        }

        @Override // com.bumptech.glide.load.model.h
        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }
    }

    Map<String, String> getHeaders();
}
