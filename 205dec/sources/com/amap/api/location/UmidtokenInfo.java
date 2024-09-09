package com.amap.api.location;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.p0003l.i4;
import com.autonavi.aps.amapapi.utils.b;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class UmidtokenInfo {

    /* renamed from: d  reason: collision with root package name */
    private static AMapLocationClient f10678d;

    /* renamed from: a  reason: collision with root package name */
    static Handler f10675a = new Handler();

    /* renamed from: b  reason: collision with root package name */
    static String f10676b = null;

    /* renamed from: e  reason: collision with root package name */
    private static long f10679e = PolicyConfig.mServerBusyRetryBaseInternal;

    /* renamed from: c  reason: collision with root package name */
    static boolean f10677c = true;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class a implements AMapLocationListener {
        a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            try {
                if (UmidtokenInfo.f10678d != null) {
                    UmidtokenInfo.f10675a.removeCallbacksAndMessages(null);
                    UmidtokenInfo.f10678d.onDestroy();
                }
            } catch (Throwable th) {
                b.a(th, "UmidListener", "onLocationChanged");
            }
        }
    }

    public static String getUmidtoken() {
        return f10676b;
    }

    public static void setLocAble(boolean z3) {
        f10677c = z3;
    }

    public static synchronized void setUmidtoken(Context context, String str) {
        synchronized (UmidtokenInfo.class) {
            try {
                f10676b = str;
                i4.s(str);
                if (f10678d == null && f10677c) {
                    a aVar = new a();
                    f10678d = new AMapLocationClient(context);
                    AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
                    aMapLocationClientOption.setOnceLocation(true);
                    aMapLocationClientOption.setNeedAddress(false);
                    f10678d.setLocationOption(aMapLocationClientOption);
                    f10678d.setLocationListener(aVar);
                    f10678d.startLocation();
                    f10675a.postDelayed(new Runnable() { // from class: com.amap.api.location.UmidtokenInfo.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (UmidtokenInfo.f10678d != null) {
                                    UmidtokenInfo.f10678d.onDestroy();
                                }
                            } catch (Throwable th) {
                                b.a(th, "UmidListener", "postDelayed");
                            }
                        }
                    }, PolicyConfig.mServerBusyRetryBaseInternal);
                }
            } catch (Throwable th) {
                b.a(th, "UmidListener", "setUmidtoken");
            }
        }
    }
}
