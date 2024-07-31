package com.amap.api.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.amap.api.col.p0463l.AmapLocationManager;
import com.amap.api.col.p0463l.BaseNetManager;
import com.amap.api.col.p0463l.DeviceInfo;
import com.amap.api.col.p0463l.Privacy;
import com.amap.api.col.p0463l.PrivacyError;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.stub.StubApp;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AMapLocationClient {

    /* renamed from: a */
    Context f6900a;

    /* renamed from: b */
    AmapLocationManager f6901b;

    public AMapLocationClient(Context context) throws Exception {
        m52133a(context);
        try {
            if (context != null) {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                this.f6900a = origApplicationContext;
                DebugUtils.m51284a(origApplicationContext);
                this.f6901b = new AmapLocationManager(context, null, null);
                return;
            }
            throw new IllegalArgumentException("Context参数不能为null");
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMClt", "ne1");
        }
    }

    /* renamed from: a */
    private static void m52133a(Context context) throws Exception {
        PrivacyError m54995a = Privacy.m54995a(context, C2428b.m51294c());
        if (m54995a.f4676a == Privacy.EnumC1812c.SuccessCode) {
            return;
        }
        Log.e("AMapLocationClient", m54995a.f4677b);
        throw new Exception(m54995a.f4677b);
    }

    public static String getDeviceId(Context context) {
        return DeviceInfo.m54794a0(context);
    }

    public static void setApiKey(String str) {
        try {
            AMapLocationClientOption.f6902a = str;
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMClt", "sKey");
        }
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            BaseNetManager.f5076a = -1;
            BaseNetManager.f5077b = "";
            return;
        }
        BaseNetManager.f5076a = 1;
        BaseNetManager.f5077b = str;
    }

    public static void updatePrivacyAgree(Context context, boolean z) {
        Privacy.m54987i(context, z, C2428b.m51294c());
    }

    public static void updatePrivacyShow(Context context, boolean z, boolean z2) {
        Privacy.m54986j(context, z, z2, C2428b.m51294c());
    }

    public void disableBackgroundLocation(boolean z) {
        try {
            AmapLocationManager amapLocationManager = this.f6901b;
            if (amapLocationManager != null) {
                amapLocationManager.m55409B(z);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMClt", "dBackL");
        }
    }

    public void enableBackgroundLocation(int i, Notification notification) {
        try {
            AmapLocationManager amapLocationManager = this.f6901b;
            if (amapLocationManager != null) {
                amapLocationManager.m55376e(i, notification);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMClt", "eBackL");
        }
    }

    public AMapLocation getLastKnownLocation() {
        try {
            AmapLocationManager amapLocationManager = this.f6901b;
            if (amapLocationManager != null) {
                return amapLocationManager.m55379c0();
            }
            return null;
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMClt", "gLastL");
            return null;
        }
    }

    public String getVersion() {
        return "6.4.3";
    }

    public boolean isStarted() {
        try {
            AmapLocationManager amapLocationManager = this.f6901b;
            if (amapLocationManager != null) {
                return amapLocationManager.m55408C();
            }
            return false;
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMClt", "isS");
            return false;
        }
    }

    public void onDestroy() {
        try {
            AmapLocationManager amapLocationManager = this.f6901b;
            if (amapLocationManager != null) {
                amapLocationManager.m55388W();
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMClt", "onDy");
        }
    }

    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            if (aMapLocationListener != null) {
                AmapLocationManager amapLocationManager = this.f6901b;
                if (amapLocationManager != null) {
                    amapLocationManager.m55338x(aMapLocationListener);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("listener参数不能为null");
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMClt", "sLocL");
        }
    }

    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            if (aMapLocationClientOption != null) {
                AmapLocationManager amapLocationManager = this.f6901b;
                if (amapLocationManager != null) {
                    amapLocationManager.m55340w(aMapLocationClientOption);
                }
                if (aMapLocationClientOption.f6916b) {
                    aMapLocationClientOption.f6916b = false;
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(aMapLocationClientOption.f6917c)) {
                        jSONObject.put("amap_loc_scenes_type", aMapLocationClientOption.f6917c);
                    }
                    ReportUtil.m51236a(this.f6900a, "O019", jSONObject);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("LocationManagerOption参数不能为null");
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMClt", "sLocnO");
        }
    }

    public void startAssistantLocation(WebView webView) {
        try {
            AmapLocationManager amapLocationManager = this.f6901b;
            if (amapLocationManager != null) {
                amapLocationManager.m55360m(webView);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMClt", "sttAssL1");
        }
    }

    public void startLocation() {
        try {
            AmapLocationManager amapLocationManager = this.f6901b;
            if (amapLocationManager != null) {
                amapLocationManager.m55404G();
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMClt", "stl");
        }
    }

    public void stopAssistantLocation() {
        try {
            AmapLocationManager amapLocationManager = this.f6901b;
            if (amapLocationManager != null) {
                amapLocationManager.m55373f0();
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMClt", "stAssL");
        }
    }

    public void stopLocation() {
        try {
            AmapLocationManager amapLocationManager = this.f6901b;
            if (amapLocationManager != null) {
                amapLocationManager.m55393R();
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMClt", "stl");
        }
    }

    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            AmapLocationManager amapLocationManager = this.f6901b;
            if (amapLocationManager != null) {
                amapLocationManager.m55397N(aMapLocationListener);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMClt", "unRL");
        }
    }

    public AMapLocationClient(Context context, Intent intent) throws Exception {
        m52133a(context);
        try {
            if (context != null) {
                this.f6900a = StubApp.getOrigApplicationContext(context.getApplicationContext());
                this.f6901b = new AmapLocationManager(this.f6900a, intent, null);
                return;
            }
            throw new IllegalArgumentException("Context参数不能为null");
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMClt", "ne2");
        }
    }

    public AMapLocationClient(Looper looper, Context context) throws Exception {
        m52133a(context);
        try {
            if (context != null) {
                this.f6900a = StubApp.getOrigApplicationContext(context.getApplicationContext());
                this.f6901b = new AmapLocationManager(this.f6900a, null, looper);
                return;
            }
            throw new IllegalArgumentException("Context参数不能为null");
        } catch (Throwable th) {
            C2428b.m51299a(th, "AMClt", "ne3");
        }
    }
}
