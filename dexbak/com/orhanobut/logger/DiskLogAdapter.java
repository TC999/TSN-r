package com.orhanobut.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: com.orhanobut.logger.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DiskLogAdapter implements LogAdapter {
    @NonNull

    /* renamed from: a */
    private final FormatStrategy f32681a;

    public DiskLogAdapter() {
        this.f32681a = CsvFormatStrategy.m20483c().m20482a();
    }

    @Override // com.orhanobut.logger.LogAdapter
    /* renamed from: a */
    public void mo20475a(int i, @Nullable String str, @NonNull String str2) {
        this.f32681a.mo20454a(i, str, str2);
    }

    @Override // com.orhanobut.logger.LogAdapter
    /* renamed from: b */
    public boolean mo20474b(int i, @Nullable String str) {
        return true;
    }

    public DiskLogAdapter(@NonNull FormatStrategy formatStrategy) {
        this.f32681a = (FormatStrategy) C11795n.m20423a(formatStrategy);
    }
}
