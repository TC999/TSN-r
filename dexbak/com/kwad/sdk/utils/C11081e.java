package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.UByte;

/* renamed from: com.kwad.sdk.utils.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11081e {
    private static HashMap<String, ArrayList<String>> aOg = new HashMap<>();
    private static String aOh;

    @Nullable
    /* renamed from: K */
    private static ArrayList<String> m23834K(Context context, String str) {
        String packageName;
        Signature[] m23833L;
        if (context == null || (packageName = context.getPackageName()) == null) {
            return null;
        }
        if (aOg.get(str) != null) {
            return aOg.get(str);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            for (Signature signature : m23833L(context, packageName)) {
                String str2 = "error!";
                if ("MD5".equals(str)) {
                    str2 = m23832a(signature, "MD5");
                } else if ("SHA1".equals(str)) {
                    str2 = m23832a(signature, "SHA1");
                } else if ("SHA256".equals(str)) {
                    str2 = m23832a(signature, "SHA256");
                }
                arrayList.add(str2);
            }
        } catch (Exception e) {
            C10331c.m26250e("AppSigningUtil", "签名信息列表获取失败 " + e.getMessage());
        }
        aOg.put(str, arrayList);
        return arrayList;
    }

    /* renamed from: L */
    private static Signature[] m23833L(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null) {
                return null;
            }
            return packageInfo.signatures;
        } catch (Exception e) {
            C10331c.m26250e("AppSigningUtil", e.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    private static String m23832a(Signature signature, String str) {
        byte[] byteArray = signature.toByteArray();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            if (messageDigest != null) {
                byte[] digest = messageDigest.digest(byteArray);
                StringBuilder sb = new StringBuilder();
                for (byte b : digest) {
                    sb.append(Integer.toHexString((b & UByte.f41242c) | 256).substring(1, 3).toUpperCase());
                    sb.append(":");
                }
                return sb.substring(0, sb.length() - 1);
            }
            return "error!";
        } catch (Exception e) {
            C10331c.m26250e("AppSigningUtil", e.getMessage());
            return "error!";
        }
    }

    @Nullable
    /* renamed from: bG */
    public static String m23831bG(Context context) {
        if (!TextUtils.isEmpty(aOh)) {
            return aOh;
        }
        ArrayList<String> m23834K = m23834K(context, "SHA1");
        if (m23834K != null && m23834K.size() != 0) {
            aOh = m23834K.get(0);
        }
        return aOh;
    }
}
