package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.pm.Signature;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.transient  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Ctransient {
    public static Signature[] a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Throwable unused) {
            return null;
        }
    }
}
