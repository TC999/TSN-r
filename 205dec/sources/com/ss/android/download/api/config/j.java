package com.ss.android.download.api.config;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.download.DownloadModel;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public interface j {
    Dialog a(@NonNull com.ss.android.download.api.model.a aVar);

    void ok(int i4, @Nullable Context context, @Nullable DownloadModel downloadModel, String str, Drawable drawable, int i5);
}
