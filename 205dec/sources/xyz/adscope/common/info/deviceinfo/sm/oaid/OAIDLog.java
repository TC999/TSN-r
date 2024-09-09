package xyz.adscope.common.info.deviceinfo.sm.oaid;

import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public final class OAIDLog {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f64722a;

    public static void enable() {
        f64722a = true;
    }

    public static void print(Object obj) {
        if (f64722a) {
            if (obj == null) {
                obj = "<null>";
            }
            LogUtil.d("OAID", obj.toString());
        }
    }
}
