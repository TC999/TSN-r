package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.else  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Celse {
    public static int a(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null && TextUtils.equals(registerReceiver.getAction(), "android.intent.action.BATTERY_CHANGED")) {
                int intExtra = registerReceiver.getIntExtra("level", 0);
                int intExtra2 = registerReceiver.getIntExtra("scale", 100);
                if (intExtra2 == 0) {
                    return -1;
                }
                int i4 = (intExtra * 100) / intExtra2;
                int i5 = i4 >= 0 ? i4 : 0;
                if (i5 > 100) {
                    return 100;
                }
                return i5;
            }
            return -1;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
