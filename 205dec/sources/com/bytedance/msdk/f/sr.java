package com.bytedance.msdk.f;

import android.content.Context;
import android.content.Intent;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();

        void c(Throwable th);
    }

    public static void c(Context context, Intent intent, c cVar) {
        if (context == null || intent == null) {
            return;
        }
        try {
            context.startActivity(intent);
            if (cVar != null) {
                cVar.c();
            }
        } catch (Throwable th) {
            if (cVar != null) {
                cVar.c(th);
            }
        }
    }
}
