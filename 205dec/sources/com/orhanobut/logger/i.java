package com.orhanobut.logger;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: LogcatLogStrategy.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class i implements h {

    /* renamed from: a  reason: collision with root package name */
    static final String f41372a = "NO_TAG";

    @Override // com.orhanobut.logger.h
    public void a(int i4, @Nullable String str, @NonNull String str2) {
        n.a(str2);
        if (str == null) {
            str = "NO_TAG";
        }
        Log.println(i4, str, str2);
    }
}
