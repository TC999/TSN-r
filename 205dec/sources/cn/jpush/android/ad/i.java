package cn.jpush.android.ad;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import java.io.FileInputStream;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static String f4020a;

    private static String a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        return null;
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(f4020a)) {
            String a4 = a();
            f4020a = a4;
            if (TextUtils.isEmpty(a4)) {
                String b4 = b();
                f4020a = b4;
                if (TextUtils.isEmpty(b4)) {
                    String c4 = c();
                    f4020a = c4;
                    String str = !TextUtils.isEmpty(c4) ? f4020a : "";
                    f4020a = str;
                    return str;
                }
                return f4020a;
            }
            return f4020a;
        }
        return f4020a;
    }

    private static String b() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Throwable th) {
            Logger.w("ProcessUtil", "getCurrentProcessNameByActivityThread failed, " + th.getMessage());
            return null;
        }
    }

    private static String c() {
        FileInputStream fileInputStream;
        byte[] bArr;
        int i4;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream("/proc/self/cmdline");
            } catch (Throwable unused) {
            }
            try {
                bArr = new byte[256];
                i4 = 0;
                while (true) {
                    int read = fileInputStream.read();
                    if (read <= 0 || i4 >= 256) {
                        break;
                    }
                    bArr[i4] = (byte) read;
                    i4++;
                }
            } catch (Throwable unused2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                    return "";
                }
                return "";
            }
            if (i4 <= 0) {
                fileInputStream.close();
                return "";
            }
            String str = new String(bArr, 0, i4, "UTF-8");
            try {
                fileInputStream.close();
            } catch (Throwable unused3) {
            }
            return str;
        } catch (Throwable unused4) {
            return "";
        }
    }
}
