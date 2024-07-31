package com.beizi.p051ad.internal.p058b.p059a;

import java.io.File;
import java.io.IOException;

/* renamed from: com.beizi.ad.internal.b.a.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class TotalSizeLruDiskUsage extends LruDiskUsage {

    /* renamed from: a */
    private final long f10006a;

    public TotalSizeLruDiskUsage(long j) {
        if (j > 0) {
            this.f10006a = j;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    @Override // com.beizi.p051ad.internal.p058b.p059a.LruDiskUsage, com.beizi.p051ad.internal.p058b.p059a.DiskUsage
    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo49629a(File file) throws IOException {
        super.mo49629a(file);
    }

    @Override // com.beizi.p051ad.internal.p058b.p059a.LruDiskUsage
    /* renamed from: a */
    protected boolean mo49628a(File file, long j, int i) {
        return j <= this.f10006a;
    }
}
