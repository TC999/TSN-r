package com.qq.e.comm.plugin.util;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class w1 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f46680a = "w1";

    /* renamed from: e  reason: collision with root package name */
    private static String f46684e;

    /* renamed from: f  reason: collision with root package name */
    private static Boolean f46685f;

    /* renamed from: h  reason: collision with root package name */
    private static String f46687h;

    /* renamed from: b  reason: collision with root package name */
    public static final String f46681b = x1.a("YXJtNjQtdjhh");

    /* renamed from: c  reason: collision with root package name */
    private static final String f46682c = x1.a("YXJtZWFiaS12N2E");

    /* renamed from: d  reason: collision with root package name */
    public static final String f46683d = x1.a("YXJtZWFiaQ");

    /* renamed from: g  reason: collision with root package name */
    private static int f46686g = 0;

    public static boolean a(String str) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, IllegalArgumentException {
        Method declaredMethod;
        Runtime runtime = Runtime.getRuntime();
        Class<?> cls = Class.forName("java.lang.Runtime");
        Class<?>[] clsArr = {String.class, ClassLoader.class};
        int i4 = Build.VERSION.SDK_INT;
        if (i4 > 27) {
            declaredMethod = cls.getDeclaredMethod("nativeLoad", clsArr);
            declaredMethod.setAccessible(true);
        } else if (i4 > 24) {
            declaredMethod = cls.getDeclaredMethod("doLoad", clsArr);
            declaredMethod.setAccessible(true);
        } else {
            declaredMethod = cls.getDeclaredMethod("load", clsArr);
            declaredMethod.setAccessible(true);
        }
        ClassLoader classLoader = w1.class.getClassLoader();
        try {
            if (Build.VERSION.SDK_INT > 24) {
                if (((String) declaredMethod.invoke(runtime, str, classLoader)) != null) {
                    return false;
                }
            } else {
                declaredMethod.invoke(runtime, str, classLoader);
            }
            return true;
        } catch (InvocationTargetException e4) {
            String str2 = f46680a;
            d1.b(str2, "\u52a0\u8f7dso\u5e93\u5931\u8d25\uff0c\u539f\u56e0\uff1a" + e4);
            return false;
        }
    }

    public static String b() {
        if (f46687h == null) {
            int myTid = Process.myTid();
            int b4 = b("/proc/" + myTid + "/exe");
            if (b4 == 3) {
                f46687h = f46683d;
                f46686g = 3;
            } else if (b4 == 40) {
                f46687h = f46683d;
                f46686g = 1;
            } else if (b4 == 62) {
                f46687h = f46681b;
                f46686g = 4;
            } else if (b4 != 183) {
                f46687h = "unknown";
                f46686g = 999;
            } else {
                f46687h = f46681b;
                f46686g = 2;
            }
        }
        return f46687h;
    }

    public static boolean c() {
        Boolean bool = f46685f;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (Build.VERSION.SDK_INT >= 23 && Process.is64Bit()) {
            if (!TextUtils.equals(a(), f46681b)) {
                com.qq.e.comm.plugin.n0.v.a(9130032, null, 5, null, null);
            }
            if (!TextUtils.equals(b(), f46681b)) {
                com.qq.e.comm.plugin.n0.v.a(9130032, null, Integer.valueOf(f46686g), null, null);
            }
            f46685f = Boolean.TRUE;
            return true;
        } else if (Build.VERSION.SDK_INT < 23) {
            if (!TextUtils.equals(a(), b())) {
                com.qq.e.comm.plugin.n0.v.a(9130033, null, Integer.valueOf(f46686g), null, null);
            }
            Boolean valueOf = Boolean.valueOf(TextUtils.equals(b(), f46681b));
            f46685f = valueOf;
            return valueOf.booleanValue();
        } else {
            f46685f = Boolean.FALSE;
            return false;
        }
    }

    private static String a() {
        if (f46684e == null) {
            try {
                String readLine = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream())).readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    if (readLine.contains("x86")) {
                        f46684e = "x86";
                    } else if (readLine.contains(f46681b)) {
                        f46684e = f46681b;
                    } else if (readLine.contains(f46682c)) {
                        f46684e = f46682c;
                    } else {
                        f46684e = f46683d;
                    }
                } else {
                    f46684e = f46683d;
                }
            } catch (Exception e4) {
                d1.a("\u83b7\u53d6CPUABI\u5931\u8d25\uff0c\u539f\u56e0\uff1a%s", e4.toString());
                f46684e = f46683d;
            }
        }
        d1.a("\u5f53\u524dCPUABI\uff1a%s", f46684e);
        return f46684e;
    }

    private static int b(String str) {
        int i4 = 0;
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
                    try {
                        randomAccessFile2.seek(18L);
                        i4 = randomAccessFile2.read();
                        randomAccessFile2.close();
                    } catch (Exception e4) {
                        e = e4;
                        randomAccessFile = randomAccessFile2;
                        String str2 = f46680a;
                        d1.b(str2, "read ELF exception " + e);
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        return i4;
                    } catch (Throwable th) {
                        th = th;
                        randomAccessFile = randomAccessFile2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e5) {
                e = e5;
            }
        } catch (IOException unused2) {
        }
        return i4;
    }
}
