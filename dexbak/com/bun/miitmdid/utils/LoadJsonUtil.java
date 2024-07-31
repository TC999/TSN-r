package com.bun.miitmdid.utils;

import android.content.Context;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.netease.nis.sdkwrapper.Utils;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LoadJsonUtil {
    public static String LoadJsonFromAsset(Context context, String str) {
        Object[] objArr = new Object[5];
        objArr[1] = context;
        objArr[2] = str;
        objArr[3] = Integer.valueOf((int) TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE);
        objArr[4] = 1606976968606L;
        return (String) Utils.m20485rL(objArr);
    }
}
