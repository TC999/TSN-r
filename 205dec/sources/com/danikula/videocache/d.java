package com.danikula.videocache;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: Cache.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public interface d {
    void a(byte[] bArr, int i4) throws ProxyCacheException;

    long available() throws ProxyCacheException;

    int b(byte[] bArr, long j4, int i4) throws ProxyCacheException;

    void close() throws ProxyCacheException;

    void complete() throws ProxyCacheException;

    boolean isCompleted();
}
