package ms.bz.bd.c.Pgl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class o0 {

    /* renamed from: a  reason: collision with root package name */
    static String f61425a;

    /* renamed from: b  reason: collision with root package name */
    static String f61426b;

    @SuppressLint({"MissingPermission"})
    public static synchronized String a(Context context) {
        TelephonyManager telephonyManager;
        synchronized (o0.class) {
            String str = f61425a;
            if (str != null) {
                return n1.a(str);
            }
            try {
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
            } catch (Throwable unused) {
            }
            if (telephonyManager != null) {
                Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pbly.d("6765744465766963654964")), new Class[0]);
                declaredMethod.setAccessible(true);
                f61425a = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
                return n1.a(f61425a);
            }
            throw new NullPointerException("null TM");
        }
    }

    @SuppressLint({"MissingPermission"})
    public static synchronized String b(Context context) {
        TelephonyManager telephonyManager;
        synchronized (o0.class) {
            String str = f61425a;
            if (str != null) {
                return n1.a(str);
            }
            try {
                telephonyManager = (TelephonyManager) context.getSystemService("phone");
            } catch (Throwable unused) {
            }
            if (telephonyManager != null) {
                Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pbly.d("676574537562736372696265724964")), new Class[0]);
                declaredMethod.setAccessible(true);
                f61426b = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
                return n1.a(f61426b);
            }
            throw new NullPointerException("null TM");
        }
    }
}
