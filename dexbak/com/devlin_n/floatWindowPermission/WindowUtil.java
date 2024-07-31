package com.devlin_n.floatWindowPermission;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* renamed from: com.devlin_n.floatWindowPermission.h */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class WindowUtil {
    /* renamed from: a */
    public static Activity m35782a(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return m35782a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }
}
