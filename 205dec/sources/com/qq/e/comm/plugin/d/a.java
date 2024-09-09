package com.qq.e.comm.plugin.d;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import java.io.File;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final long f42166a = System.currentTimeMillis();

    /* renamed from: b  reason: collision with root package name */
    private static Context f42167b;

    /* renamed from: c  reason: collision with root package name */
    private static String f42168c;

    /* renamed from: d  reason: collision with root package name */
    private static int f42169d;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f42170e;

    /* renamed from: f  reason: collision with root package name */
    private static String f42171f;

    /* renamed from: g  reason: collision with root package name */
    private static String f42172g;

    /* renamed from: h  reason: collision with root package name */
    private static long[] f42173h;

    /* renamed from: i  reason: collision with root package name */
    private static long f42174i;

    /* renamed from: j  reason: collision with root package name */
    private static long f42175j;

    /* renamed from: k  reason: collision with root package name */
    private static File f42176k;

    /* renamed from: l  reason: collision with root package name */
    private static String f42177l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object[] objArr) throws Exception {
        pro.getVresult(208, 1, objArr);
    }

    public static String b() {
        return f42171f;
    }

    public static File c() {
        if (f42176k == null) {
            f42176k = new File(f42172g, "cd");
        }
        f42176k.mkdirs();
        return f42176k;
    }

    public static long d() {
        return f42174i;
    }

    public static long e() {
        return f42175j;
    }

    public static String f() {
        return f42177l;
    }

    public static long g() {
        return f42166a;
    }

    public static long[] h() {
        return f42173h;
    }

    public static int i() {
        return f42169d;
    }

    public static String j() {
        return f42168c;
    }

    public static boolean k() {
        return f42170e;
    }

    public static Context a() {
        return f42167b;
    }

    private static long[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new long[]{ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT};
        }
        String[] split = str.split(",");
        int length = split.length;
        if (length % 2 == 0) {
            return new long[]{ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT};
        }
        long[] jArr = new long[length];
        int i4 = length - 1;
        jArr[i4] = Long.parseLong(split[i4]);
        for (int i5 = 0; i5 < i4; i5++) {
            long parseLong = Long.parseLong(split[i5]);
            if (i5 % 2 == 0) {
                jArr[i5] = parseLong + f42166a;
            } else {
                jArr[i5] = parseLong;
            }
        }
        return jArr;
    }
}
