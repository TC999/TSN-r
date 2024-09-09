package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class e {
    private static HashMap<String, ArrayList<String>> aOg = new HashMap<>();
    private static String aOh;

    @Nullable
    private static ArrayList<String> K(Context context, String str) {
        String packageName;
        Signature[] L2;
        if (context == null || (packageName = context.getPackageName()) == null) {
            return null;
        }
        if (aOg.get(str) != null) {
            return aOg.get(str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Signature signature : L(context, packageName)) {
                String str2 = "error!";
                if ("MD5".equals(str)) {
                    str2 = a(signature, "MD5");
                } else if ("SHA1".equals(str)) {
                    str2 = a(signature, "SHA1");
                } else if ("SHA256".equals(str)) {
                    str2 = a(signature, "SHA256");
                }
                arrayList.add(str2);
            }
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.e("AppSigningUtil", "\u7b7e\u540d\u4fe1\u606f\u5217\u8868\u83b7\u53d6\u5931\u8d25 " + e4.getMessage());
        }
        aOg.put(str, arrayList);
        return arrayList;
    }

    private static Signature[] L(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.signatures;
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.e("AppSigningUtil", e4.getMessage());
            return null;
        }
    }

    private static String a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest != null) {
                byte[] digest = messageDigest.digest(byteArray);
                StringBuilder sb = new StringBuilder();
                for (byte b4 : digest) {
                    sb.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3).toUpperCase());
                    sb.append(":");
                }
                return sb.substring(0, sb.length() - 1);
            }
            return "error!";
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.e("AppSigningUtil", e4.getMessage());
            return "error!";
        }
    }

    @Nullable
    public static String bG(Context context) {
        if (!TextUtils.isEmpty(aOh)) {
            return aOh;
        }
        ArrayList<String> K = K(context, "SHA1");
        if (K != null && K.size() != 0) {
            aOh = K.get(0);
        }
        return aOh;
    }
}
