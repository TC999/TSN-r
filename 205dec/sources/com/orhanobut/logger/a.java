package com.orhanobut.logger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AndroidLogAdapter.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a implements g {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final f f41349a;

    public a() {
        this.f41349a = l.k().a();
    }

    @Override // com.orhanobut.logger.g
    public void a(int i4, @Nullable String str, @NonNull String str2) {
        this.f41349a.a(i4, str, str2);
    }

    @Override // com.orhanobut.logger.g
    public boolean b(int i4, @Nullable String str) {
        return true;
    }

    public a(@NonNull f fVar) {
        this.f41349a = (f) n.a(fVar);
    }
}
