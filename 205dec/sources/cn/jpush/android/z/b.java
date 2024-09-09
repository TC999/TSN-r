package cn.jpush.android.z;

import android.text.TextUtils;
import cn.jpush.android.helper.Logger;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {
    public static byte[] a(int i4) {
        d dVar = new d(128);
        dVar.a(i4);
        return dVar.a();
    }

    public static byte[] a(int i4, byte b4, long j4, String str) {
        d dVar = new d(128);
        dVar.b(i4);
        dVar.a((int) b4);
        dVar.a(j4);
        if (!TextUtils.isEmpty(str)) {
            dVar.a(b(str));
        }
        return dVar.a();
    }

    public static byte[] a(int i4, String str) {
        d dVar = new d(8192);
        dVar.a(i4);
        dVar.a(str);
        return dVar.a();
    }

    public static byte[] a(String str) {
        d dVar = new d(128);
        dVar.a(7);
        dVar.a(1);
        dVar.a(str != null ? b(str) : new byte[0]);
        return dVar.a();
    }

    public static byte[] a(String str, byte b4, boolean z3) {
        d dVar = new d(8192);
        dVar.a(TextUtils.isEmpty(str) ? new byte[0] : b(str));
        dVar.a((int) b4);
        dVar.a(!z3 ? 1 : 0);
        return dVar.a();
    }

    public static byte[] a(String str, int i4, String str2) {
        d dVar = new d(8192);
        if (i4 == 10) {
            dVar.a(b(str));
        }
        dVar.a(b(str2));
        return dVar.a();
    }

    public static byte[] b(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (Throwable th) {
            Logger.ee("PushPackage", "stringToUtf8Bytes error:" + th.getMessage());
            return str.getBytes();
        }
    }

    public static byte[] c(String str) {
        d dVar = new d(8192);
        dVar.a(b(str));
        return dVar.a();
    }
}
