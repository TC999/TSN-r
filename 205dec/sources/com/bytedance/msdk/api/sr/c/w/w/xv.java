package com.bytedance.msdk.api.sr.c.w.w;

import android.app.Activity;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class xv extends w {
    public abstract void c(Activity activity);

    public final void w(Activity activity) {
        try {
            this.f27603c = true;
            c(activity);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
