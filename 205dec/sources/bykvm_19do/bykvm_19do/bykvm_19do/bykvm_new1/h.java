package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.content.pm.Signature;
import com.bytedance.msdk.adapter.util.Logger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: AppSigning.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, ArrayList<String>> f648a = new HashMap<>();

    public static ArrayList<String> a(Context context, String str) {
        Signature[] b4;
        String a4;
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (f648a.get(str) != null) {
                return f648a.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : b(context, packageName)) {
                    if ("MD5".equals(str)) {
                        a4 = a(signature, "MD5");
                    } else if ("SHA1".equals(str)) {
                        a4 = a(signature, "SHA1");
                    } else {
                        a4 = "SHA256".equals(str) ? a(signature, "SHA256") : "error!";
                    }
                    arrayList.add(a4);
                }
            } catch (Exception e4) {
                Logger.e(e4.toString());
            }
            f648a.put(str, arrayList);
        }
        return arrayList;
    }

    private static Signature[] b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e4) {
            Logger.e(e4.toString());
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
                return sb.substring(0, sb.length() - 1).toString();
            }
        } catch (Exception e4) {
            Logger.e(e4.toString());
        }
        return "error!";
    }
}
