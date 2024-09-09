package com.orhanobut.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: DiskLogAdapter.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d implements g {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final f f41368a;

    public d() {
        this.f41368a = c.c().a();
    }

    @Override // com.orhanobut.logger.g
    public void a(int i4, @Nullable String str, @NonNull String str2) {
        this.f41368a.a(i4, str, str2);
    }

    @Override // com.orhanobut.logger.g
    public boolean b(int i4, @Nullable String str) {
        return true;
    }

    public d(@NonNull f fVar) {
        this.f41368a = (f) n.a(fVar);
    }
}
