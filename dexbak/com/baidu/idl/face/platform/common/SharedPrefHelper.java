package com.baidu.idl.face.platform.common;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class SharedPrefHelper {
    private static final String SHARED_PREFERENCES_NAME_FACE_VALUE = "face_sdk_value";

    private SharedPrefHelper() {
    }

    private static SharedPreferences getPref(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME_FACE_VALUE, 0);
    }
}
