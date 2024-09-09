package com.devlin_n.floatWindowPermission;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: WindowUtil.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class h {
    public static Activity a(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }
}
