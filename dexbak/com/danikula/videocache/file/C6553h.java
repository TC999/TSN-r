package com.danikula.videocache.file;

import java.io.File;

/* compiled from: TotalSizeLruDiskUsage.java */
/* renamed from: com.danikula.videocache.file.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6553h extends AbstractC6550e {

    /* renamed from: c */
    private final long f23080c;

    public C6553h(long j) {
        if (j > 0) {
            this.f23080c = j;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    @Override // com.danikula.videocache.file.AbstractC6550e
    /* renamed from: b */
    protected boolean mo35926b(File file, long j, int i) {
        return j <= this.f23080c;
    }
}
