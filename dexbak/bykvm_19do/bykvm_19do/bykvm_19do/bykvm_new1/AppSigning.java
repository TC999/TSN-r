package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.content.pm.Signature;
import com.bytedance.msdk.adapter.util.Logger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.UByte;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AppSigning {

    /* renamed from: a */
    private static HashMap<String, ArrayList<String>> f655a = new HashMap<>();

    /* renamed from: a */
    public static ArrayList<String> m59226a(Context context, String str) {
        Signature[] m59224b;
        String m59225a;
        ArrayList<String> arrayList = null;
        if (context != null && str != null) {
            String packageName = context.getPackageName();
            if (packageName == null) {
                return null;
            }
            if (f655a.get(str) != null) {
                return f655a.get(str);
            }
            arrayList = new ArrayList<>();
            try {
                for (Signature signature : m59224b(context, packageName)) {
                    if ("MD5".equals(str)) {
                        m59225a = m59225a(signature, "MD5");
                    } else if ("SHA1".equals(str)) {
                        m59225a = m59225a(signature, "SHA1");
                    } else {
                        m59225a = "SHA256".equals(str) ? m59225a(signature, "SHA256") : "error!";
                    }
                    arrayList.add(m59225a);
                }
            } catch (Exception e) {
                Logger.m37558e(e.toString());
            }
            f655a.put(str, arrayList);
        }
        return arrayList;
    }

    /* renamed from: b */
    private static Signature[] m59224b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 64).signatures;
        } catch (Exception e) {
            Logger.m37558e(e.toString());
            return null;
        }
    }

    /* renamed from: a */
    private static String m59225a(Signature signature, String str) {
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
                return sb.substring(0, sb.length() - 1).toString();
            }
        } catch (Exception e) {
            Logger.m37558e(e.toString());
        }
        return "error!";
    }
}
