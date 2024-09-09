package com.bytedance.sdk.component.adexpress.c.w;

import android.os.Environment;
import android.view.animation.Interpolator;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {
    public static File c() {
        if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && com.bytedance.sdk.openadsdk.api.plugin.w.xv(com.bytedance.sdk.component.adexpress.c.c.c.c().xv().getContext()) != null) {
            return com.bytedance.sdk.openadsdk.api.plugin.w.xv(com.bytedance.sdk.component.adexpress.c.c.c.c().xv().getContext());
        }
        return com.bytedance.sdk.openadsdk.api.plugin.w.w(com.bytedance.sdk.component.adexpress.c.c.c.c().xv().getContext());
    }

    public static Interpolator c(float f4, float f5, float f6, float f7) {
        return new com.bytedance.sdk.component.adexpress.widget.c(f4, f5, f6, f7);
    }
}
