package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<String, ArrayList<String>> f30231c = new HashMap<>();

    public static ArrayList<String> c(Context context, String str) {
        Signature[] w3;
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (f30231c.get(str) != null) {
                return f30231c.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : w(context, packageName)) {
                    String str2 = "error!";
                    if ("MD5".equals(str)) {
                        str2 = c(signature, "MD5");
                    } else if ("SHA1".equals(str)) {
                        str2 = c(signature, "SHA1");
                    } else if ("SHA256".equals(str)) {
                        str2 = c(signature, "SHA256");
                    }
                    arrayList.add(str2);
                }
            } catch (Exception e4) {
                a.xv(e4.toString());
            }
            f30231c.put(str, arrayList);
        }
        return arrayList;
    }

    private static Signature[] w(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e4) {
            a.xv(e4.toString());
            return null;
        }
    }

    public static String c(Context context) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> c4 = c(context, "SHA1");
        if (c4 != null && c4.size() != 0) {
            for (int i4 = 0; i4 < c4.size(); i4++) {
                sb.append(c4.get(i4));
                if (i4 < c4.size() - 1) {
                    sb.append(",");
                }
            }
        }
        return sb.toString();
    }

    private static String c(Signature signature, String str) {
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
                return sb.substring(0, sb.length() - 1).toString();
            }
            return "error!";
        } catch (Exception e4) {
            a.xv(e4.toString());
            return "error!";
        }
    }
}
