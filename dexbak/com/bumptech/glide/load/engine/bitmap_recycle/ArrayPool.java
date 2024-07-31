package com.bumptech.glide.load.engine.bitmap_recycle;

/* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface ArrayPool {

    /* renamed from: a */
    public static final int f13553a = 65536;

    /* renamed from: a */
    void mo45396a(int i);

    /* renamed from: b */
    void mo45395b();

    /* renamed from: c */
    <T> T mo45394c(int i, Class<T> cls);

    /* renamed from: d */
    <T> T mo45393d(int i, Class<T> cls);

    @Deprecated
    /* renamed from: e */
    <T> void mo45392e(T t, Class<T> cls);

    <T> void put(T t);
}
