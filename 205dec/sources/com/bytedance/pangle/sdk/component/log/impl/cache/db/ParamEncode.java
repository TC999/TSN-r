package com.bytedance.pangle.sdk.component.log.impl.cache.db;

import android.text.TextUtils;
import android.util.Base64;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ParamEncode {
    public static String decode(String str) {
        return TextUtils.isEmpty(str) ? "" : new String(Base64.decode(str, 10));
    }

    public static String encode(String str) {
        return TextUtils.isEmpty(str) ? "" : Base64.encodeToString(str.getBytes(), 10);
    }
}
