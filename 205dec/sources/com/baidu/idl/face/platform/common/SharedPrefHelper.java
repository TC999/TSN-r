package com.baidu.idl.face.platform.common;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class SharedPrefHelper {
    private static final String SHARED_PREFERENCES_NAME_FACE_VALUE = "face_sdk_value";

    private SharedPrefHelper() {
    }

    private static SharedPreferences getPref(Context context) {
        return context.getSharedPreferences("face_sdk_value", 0);
    }
}
