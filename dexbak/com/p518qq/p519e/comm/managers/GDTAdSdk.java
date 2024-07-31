package com.p518qq.p519e.comm.managers;

import android.content.Context;
import com.p518qq.p519e.comm.util.GDTLogger;

/* renamed from: com.qq.e.comm.managers.GDTAdSdk */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class GDTAdSdk {

    /* renamed from: com.qq.e.comm.managers.GDTAdSdk$OnStartListener */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface OnStartListener {
        void onStartFailed(Exception exc);

        void onStartSuccess();
    }

    public static IGDTAdManager getGDTAdManger() {
        return C11815a.m20349b();
    }

    @Deprecated
    public static void init(Context context, String str) {
        GDTLogger.m20304w("该方法已被废弃，请尽快切换初始化接口为GDTAdSdk#initWithoutStart、GDTAdSdk#start，详见接入文档或咨询技术支持。");
        C11815a.m20349b().m20353a(context, str, true);
    }

    public static void initWithoutStart(Context context, String str) {
        C11815a.m20349b().m20353a(context, str, false);
    }

    public static void start(OnStartListener onStartListener) {
        C11815a.m20349b().m20352a(onStartListener);
    }
}
