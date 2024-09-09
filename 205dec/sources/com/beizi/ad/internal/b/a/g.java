package com.beizi.ad.internal.b.a;

import java.io.File;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: TotalSizeLruDiskUsage.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class g extends e {

    /* renamed from: a  reason: collision with root package name */
    private final long f13683a;

    public g(long j4) {
        if (j4 > 0) {
            this.f13683a = j4;
            return;
        }
        throw new IllegalArgumentException("Max size must be positive number!");
    }

    @Override // com.beizi.ad.internal.b.a.e, com.beizi.ad.internal.b.a.a
    public /* bridge */ /* synthetic */ void a(File file) throws IOException {
        super.a(file);
    }

    @Override // com.beizi.ad.internal.b.a.e
    protected boolean a(File file, long j4, int i4) {
        return j4 <= this.f13683a;
    }
}
