package cn.jpush.android.m;

import cn.jiguang.internal.JConstants;
import cn.jpush.android.local.JPushConstants;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static int f4248a = 540;

    /* renamed from: b  reason: collision with root package name */
    public static String f4249b = "5.4.0";

    /* renamed from: c  reason: collision with root package name */
    public static final int f4250c = JConstants.SDK_VERSION_INT;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f4251d = false;

    public static boolean a() {
        try {
            return JPushConstants.THIRD_ENABLE;
        } catch (Throwable unused) {
            return true;
        }
    }
}
