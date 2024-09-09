package com.bytedance.embedapplog;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IOaidObserver {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class Oaid {
        @Nullable
        public final String id;

        public Oaid(@Nullable String str) {
            this.id = str;
        }
    }

    @AnyThread
    void onOaidLoaded(@NonNull Oaid oaid);
}
