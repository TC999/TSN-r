package com.danikula.videocache.file;

import java.io.File;

/* renamed from: com.danikula.videocache.file.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TotalCountLruDiskUsage extends AbstractC6550e {

    /* renamed from: c */
    private final int f23079c;

    public TotalCountLruDiskUsage(int i) {
        if (i > 0) {
            this.f23079c = i;
            return;
        }
        throw new IllegalArgumentException("Max count must be positive number!");
    }

    @Override // com.danikula.videocache.file.AbstractC6550e
    /* renamed from: b */
    protected boolean mo35926b(File file, long j, int i) {
        return i <= this.f23079c;
    }
}
