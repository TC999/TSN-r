package com.p521ss.android.download.api.p525ok;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.p521ss.android.download.api.config.InterfaceC11964q;
import com.p521ss.android.download.api.config.InterfaceC11970u;

/* renamed from: com.ss.android.download.api.ok.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C11991a implements InterfaceC11964q {

    /* renamed from: ok */
    private InterfaceC11970u f33920ok;

    @Override // com.p521ss.android.download.api.config.InterfaceC11964q
    /* renamed from: ok */
    public void mo19531ok(@NonNull Activity activity, @NonNull String[] strArr, InterfaceC11970u interfaceC11970u) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f33920ok = interfaceC11970u;
            activity.requestPermissions(strArr, 1);
        } else if (interfaceC11970u != null) {
            interfaceC11970u.mo18984ok();
        }
    }

    @Override // com.p521ss.android.download.api.config.InterfaceC11964q
    /* renamed from: ok */
    public boolean mo19530ok(@Nullable Context context, @NonNull String str) {
        return context != null && ContextCompat.checkSelfPermission(context, str) == 0;
    }

    @Override // com.p521ss.android.download.api.config.InterfaceC11964q
    /* renamed from: ok */
    public void mo19532ok(@NonNull Activity activity, int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        InterfaceC11970u interfaceC11970u;
        if (iArr.length <= 0 || (interfaceC11970u = this.f33920ok) == null) {
            return;
        }
        if (iArr[0] == -1) {
            interfaceC11970u.mo18983ok(strArr[0]);
        } else if (iArr[0] == 0) {
            interfaceC11970u.mo18984ok();
        }
    }
}
