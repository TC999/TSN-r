package com.ss.android.download.api.c;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.ss.android.download.api.config.gd;
import com.ss.android.download.api.config.u;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w implements gd {

    /* renamed from: c  reason: collision with root package name */
    private u f48158c;

    @Override // com.ss.android.download.api.config.gd
    public void c(@NonNull Activity activity, @NonNull String[] strArr, u uVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f48158c = uVar;
            activity.requestPermissions(strArr, 1);
        } else if (uVar != null) {
            uVar.c();
        }
    }

    @Override // com.ss.android.download.api.config.gd
    public boolean c(@Nullable Context context, @NonNull String str) {
        return context != null && ContextCompat.checkSelfPermission(context, str) == 0;
    }

    @Override // com.ss.android.download.api.config.gd
    public void c(@NonNull Activity activity, int i4, @NonNull String[] strArr, @NonNull int[] iArr) {
        u uVar;
        if (iArr.length <= 0 || (uVar = this.f48158c) == null) {
            return;
        }
        if (iArr[0] == -1) {
            uVar.c(strArr[0]);
        } else if (iArr[0] == 0) {
            uVar.c();
        }
    }
}
