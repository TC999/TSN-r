package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ArrayPool.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f16876a = 65536;

    void a(int i4);

    void b();

    <T> T c(int i4, Class<T> cls);

    <T> T d(int i4, Class<T> cls);

    @Deprecated
    <T> void e(T t3, Class<T> cls);

    <T> void put(T t3);
}
