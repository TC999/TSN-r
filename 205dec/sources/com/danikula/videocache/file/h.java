package com.danikula.videocache.file;

import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: TotalSizeLruDiskUsage.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class h extends e {

    /* renamed from: c  reason: collision with root package name */
    private final long f36747c;

    public h(long j4) {
        if (j4 > 0) {
            this.f36747c = j4;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    @Override // com.danikula.videocache.file.e
    protected boolean b(File file, long j4, int i4) {
        return j4 <= this.f36747c;
    }
}
