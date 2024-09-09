package com.bytedance.msdk.f;

import android.content.Context;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p {

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<String, ArrayList<String>> f28348c = new HashMap<>();

    public static ArrayList<String> c(Context context, String str) {
        Signature[] w3;
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (f28348c.get(str) != null) {
                return f28348c.get(str);
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
                com.bytedance.msdk.adapter.sr.xv.xv(e4.toString());
            }
            f28348c.put(str, arrayList);
        }
        return arrayList;
    }

    private static Signature[] w(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e4) {
            com.bytedance.msdk.adapter.sr.xv.xv(e4.toString());
            return null;
        }
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
            com.bytedance.msdk.adapter.sr.xv.xv(e4.toString());
            return "error!";
        }
    }
}
