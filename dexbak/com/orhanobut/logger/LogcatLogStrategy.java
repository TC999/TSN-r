package com.orhanobut.logger;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* renamed from: com.orhanobut.logger.i */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class LogcatLogStrategy implements LogStrategy {

    /* renamed from: a */
    static final String f32685a = "NO_TAG";

    @Override // com.orhanobut.logger.LogStrategy
    /* renamed from: a */
    public void mo20473a(int i, @Nullable String str, @NonNull String str2) {
        C11795n.m20423a(str2);
        if (str == null) {
            str = f32685a;
        }
        Log.println(i, str, str2);
    }
}
