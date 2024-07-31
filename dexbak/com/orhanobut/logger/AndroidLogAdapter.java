package com.orhanobut.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: com.orhanobut.logger.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AndroidLogAdapter implements LogAdapter {
    @NonNull

    /* renamed from: a */
    private final FormatStrategy f32662a;

    public AndroidLogAdapter() {
        this.f32662a = PrettyFormatStrategy.m20444k().m20443a();
    }

    @Override // com.orhanobut.logger.LogAdapter
    /* renamed from: a */
    public void mo20475a(int i, @Nullable String str, @NonNull String str2) {
        this.f32662a.mo20454a(i, str, str2);
    }

    @Override // com.orhanobut.logger.LogAdapter
    /* renamed from: b */
    public boolean mo20474b(int i, @Nullable String str) {
        return true;
    }

    public AndroidLogAdapter(@NonNull FormatStrategy formatStrategy) {
        this.f32662a = (FormatStrategy) C11795n.m20423a(formatStrategy);
    }
}
