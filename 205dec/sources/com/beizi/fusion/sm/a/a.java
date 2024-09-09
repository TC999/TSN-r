package com.beizi.fusion.sm.a;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AdvertisingIdInfo.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a {

    /* compiled from: DeviceID.java */
    /* renamed from: com.beizi.fusion.sm.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    private static class C0146a {

        /* renamed from: a  reason: collision with root package name */
        static final a f15037a = new a(null);
    }

    public static String a(Context context) {
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "oaid_limit_state");
            if (TextUtils.isEmpty(string) || Boolean.parseBoolean(string)) {
                return "";
            }
            String string2 = Settings.Global.getString(context.getContentResolver(), AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY);
            return !TextUtils.isEmpty(string2) ? string2 : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }
}
