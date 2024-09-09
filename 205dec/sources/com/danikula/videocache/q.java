package com.danikula.videocache;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: Source.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public interface q {
    void a(long j4) throws ProxyCacheException;

    void close() throws ProxyCacheException;

    long length() throws ProxyCacheException;

    int read(byte[] bArr) throws ProxyCacheException;
}
