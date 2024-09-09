package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.au;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMInternalUtils.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53506a = au.b().b("pri");

    /* renamed from: b  reason: collision with root package name */
    private static final String f53507b = "um_common_strength";

    /* renamed from: c  reason: collision with root package name */
    private static final String f53508c = "um_common_battery";

    public static String a(Context context) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f53506a, 0)) == null) {
            return null;
        }
        return sharedPreferences.getString("um_common_battery", null);
    }

    public static void a(Context context, String str) {
        SharedPreferences sharedPreferences;
        if (context == null || TextUtils.isEmpty(str) || (sharedPreferences = StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(f53506a, 0)) == null) {
            return;
        }
        sharedPreferences.edit().putString("um_common_battery", str).commit();
    }
}
