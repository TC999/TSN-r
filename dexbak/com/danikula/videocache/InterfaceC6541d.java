package com.danikula.videocache;

/* compiled from: Cache.java */
/* renamed from: com.danikula.videocache.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public interface InterfaceC6541d {
    /* renamed from: a */
    void mo35942a(byte[] bArr, int i) throws ProxyCacheException;

    long available() throws ProxyCacheException;

    /* renamed from: b */
    int mo35941b(byte[] bArr, long j, int i) throws ProxyCacheException;

    void close() throws ProxyCacheException;

    void complete() throws ProxyCacheException;

    boolean isCompleted();
}
