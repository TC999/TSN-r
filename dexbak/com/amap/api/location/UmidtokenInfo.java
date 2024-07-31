package com.amap.api.location;

import android.content.Context;
import android.os.Handler;
import com.amap.api.col.p0463l.DeviceInfo;
import com.autonavi.aps.amapapi.utils.C2428b;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class UmidtokenInfo {

    /* renamed from: d */
    private static AMapLocationClient f6974d;

    /* renamed from: a */
    static Handler f6971a = new Handler();

    /* renamed from: b */
    static String f6972b = null;

    /* renamed from: e */
    private static long f6975e = 30000;

    /* renamed from: c */
    static boolean f6973c = true;

    /* renamed from: com.amap.api.location.UmidtokenInfo$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static class C2240a implements AMapLocationListener {
        C2240a() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            try {
                if (UmidtokenInfo.f6974d != null) {
                    UmidtokenInfo.f6971a.removeCallbacksAndMessages(null);
                    UmidtokenInfo.f6974d.onDestroy();
                }
            } catch (Throwable th) {
                C2428b.m51299a(th, "UmidListener", "onLocationChanged");
            }
        }
    }

    public static String getUmidtoken() {
        return f6972b;
    }

    public static void setLocAble(boolean z) {
        f6973c = z;
    }

    public static synchronized void setUmidtoken(Context context, String str) {
        synchronized (UmidtokenInfo.class) {
            try {
                f6972b = str;
                DeviceInfo.m54765s(str);
                if (f6974d == null && f6973c) {
                    C2240a c2240a = new C2240a();
                    f6974d = new AMapLocationClient(context);
                    AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
                    aMapLocationClientOption.setOnceLocation(true);
                    aMapLocationClientOption.setNeedAddress(false);
                    f6974d.setLocationOption(aMapLocationClientOption);
                    f6974d.setLocationListener(c2240a);
                    f6974d.startLocation();
                    f6971a.postDelayed(new Runnable() { // from class: com.amap.api.location.UmidtokenInfo.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                if (UmidtokenInfo.f6974d != null) {
                                    UmidtokenInfo.f6974d.onDestroy();
                                }
                            } catch (Throwable th) {
                                C2428b.m51299a(th, "UmidListener", "postDelayed");
                            }
                        }
                    }, 30000L);
                }
            } catch (Throwable th) {
                C2428b.m51299a(th, "UmidListener", "setUmidtoken");
            }
        }
    }
}
