package com.ss.android.download.api.ok;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.ss.android.download.api.config.q;
import com.ss.android.download.api.config.u;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements q {
    private u ok;

    @Override // com.ss.android.download.api.config.q
    public void ok(@NonNull Activity activity, @NonNull String[] strArr, u uVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.ok = uVar;
            activity.requestPermissions(strArr, 1);
        } else if (uVar != null) {
            uVar.ok();
        }
    }

    @Override // com.ss.android.download.api.config.q
    public boolean ok(@Nullable Context context, @NonNull String str) {
        return context != null && ContextCompat.checkSelfPermission(context, str) == 0;
    }

    @Override // com.ss.android.download.api.config.q
    public void ok(@NonNull Activity activity, int i4, @NonNull String[] strArr, @NonNull int[] iArr) {
        u uVar;
        if (iArr.length <= 0 || (uVar = this.ok) == null) {
            return;
        }
        if (iArr[0] == -1) {
            uVar.ok(strArr[0]);
        } else if (iArr[0] == 0) {
            uVar.ok();
        }
    }
}
