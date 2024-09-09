package com.qq.e.comm.managers;

import android.content.Context;
import com.qq.e.comm.util.GDTLogger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class GDTAdSdk {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface OnStartListener {
        void onStartFailed(Exception exc);

        void onStartSuccess();
    }

    public static IGDTAdManager getGDTAdManger() {
        return a.b();
    }

    @Deprecated
    public static void init(Context context, String str) {
        GDTLogger.w("\u8be5\u65b9\u6cd5\u5df2\u88ab\u5e9f\u5f03\uff0c\u8bf7\u5c3d\u5feb\u5207\u6362\u521d\u59cb\u5316\u63a5\u53e3\u4e3aGDTAdSdk#initWithoutStart\u3001GDTAdSdk#start\uff0c\u8be6\u89c1\u63a5\u5165\u6587\u6863\u6216\u54a8\u8be2\u6280\u672f\u652f\u6301\u3002");
        a.b().a(context, str, true);
    }

    public static void initWithoutStart(Context context, String str) {
        a.b().a(context, str, false);
    }

    public static void start(OnStartListener onStartListener) {
        a.b().a(onStartListener);
    }
}
