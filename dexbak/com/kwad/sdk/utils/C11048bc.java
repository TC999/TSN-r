package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;

/* renamed from: com.kwad.sdk.utils.bc */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11048bc {
    private static String TAG = "plugin.signature";
    public static Signature[] aPZ = new Signature[0];

    @Nullable
    @SuppressLint({"PackageManagerGetSignatures"})
    /* renamed from: cS */
    private static Signature[] m23954cS(Context context) {
        Signature[] signatureArr = aPZ;
        if (signatureArr == null || signatureArr.length <= 0) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
                if (packageInfo != null) {
                    aPZ = packageInfo.signatures;
                }
            } catch (PackageManager.NameNotFoundException e) {
                String str = TAG;
                C10331c.m26246w(str, "Can not get signature, error = " + e.getLocalizedMessage());
                C10331c.m26245w(TAG, e);
            }
            return aPZ;
        }
        return signatureArr;
    }

    /* renamed from: cT */
    public static String m23953cT(Context context) {
        try {
            Signature[] m23954cS = m23954cS(context);
            if (m23954cS != null && m23954cS.length > 0) {
                return C11010ad.m24141l(m23954cS[0].toByteArray());
            }
            return "";
        } catch (Exception e) {
            C10331c.m26245w(TAG, e);
            return "";
        }
    }
}
