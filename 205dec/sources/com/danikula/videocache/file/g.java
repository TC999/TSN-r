package com.danikula.videocache.file;

import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: TotalCountLruDiskUsage.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class g extends e {

    /* renamed from: c  reason: collision with root package name */
    private final int f36746c;

    public g(int i4) {
        if (i4 > 0) {
            this.f36746c = i4;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }

    @Override // com.danikula.videocache.file.e
    protected boolean b(File file, long j4, int i4) {
        return i4 <= this.f36746c;
    }
}
