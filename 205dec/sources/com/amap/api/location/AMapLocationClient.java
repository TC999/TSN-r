package com.amap.api.location;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebView;
import com.amap.api.col.p0003l.d2;
import com.amap.api.col.p0003l.ft;
import com.amap.api.col.p0003l.i4;
import com.amap.api.col.p0003l.n4;
import com.amap.api.col.p0003l.q6;
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.d;
import com.autonavi.aps.amapapi.utils.h;
import com.stub.StubApp;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AMapLocationClient {

    /* renamed from: a  reason: collision with root package name */
    Context f10614a;

    /* renamed from: b  reason: collision with root package name */
    d2 f10615b;

    public AMapLocationClient(Context context) throws Exception {
        a(context);
        try {
            if (context != null) {
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                this.f10614a = origApplicationContext;
                d.a(origApplicationContext);
                this.f10615b = new d2(context, null, null);
                return;
            }
            throw new IllegalArgumentException("Context\u53c2\u6570\u4e0d\u80fd\u4e3anull");
        } catch (Throwable th) {
            b.a(th, "AMClt", "ne1");
        }
    }

    private static void a(Context context) throws Exception {
        n4 a4 = ft.a(context, b.c());
        if (a4.f8385a == ft.c.SuccessCode) {
            return;
        }
        Log.e("AMapLocationClient", a4.f8386b);
        throw new Exception(a4.f8386b);
    }

    public static String getDeviceId(Context context) {
        return i4.a0(context);
    }

    public static void setApiKey(String str) {
        try {
            AMapLocationClientOption.f10616a = str;
        } catch (Throwable th) {
            b.a(th, "AMClt", "sKey");
        }
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            q6.f8834a = -1;
            q6.f8835b = "";
            return;
        }
        q6.f8834a = 1;
        q6.f8835b = str;
    }

    public static void updatePrivacyAgree(Context context, boolean z3) {
        ft.i(context, z3, b.c());
    }

    public static void updatePrivacyShow(Context context, boolean z3, boolean z4) {
        ft.j(context, z3, z4, b.c());
    }

    public void disableBackgroundLocation(boolean z3) {
        try {
            d2 d2Var = this.f10615b;
            if (d2Var != null) {
                d2Var.B(z3);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "dBackL");
        }
    }

    public void enableBackgroundLocation(int i4, Notification notification) {
        try {
            d2 d2Var = this.f10615b;
            if (d2Var != null) {
                d2Var.e(i4, notification);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "eBackL");
        }
    }

    public AMapLocation getLastKnownLocation() {
        try {
            d2 d2Var = this.f10615b;
            if (d2Var != null) {
                return d2Var.c0();
            }
            return null;
        } catch (Throwable th) {
            b.a(th, "AMClt", "gLastL");
            return null;
        }
    }

    public String getVersion() {
        return "6.4.3";
    }

    public boolean isStarted() {
        try {
            d2 d2Var = this.f10615b;
            if (d2Var != null) {
                return d2Var.C();
            }
            return false;
        } catch (Throwable th) {
            b.a(th, "AMClt", "isS");
            return false;
        }
    }

    public void onDestroy() {
        try {
            d2 d2Var = this.f10615b;
            if (d2Var != null) {
                d2Var.W();
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "onDy");
        }
    }

    public void setLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            if (aMapLocationListener != null) {
                d2 d2Var = this.f10615b;
                if (d2Var != null) {
                    d2Var.x(aMapLocationListener);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("listener\u53c2\u6570\u4e0d\u80fd\u4e3anull");
        } catch (Throwable th) {
            b.a(th, "AMClt", "sLocL");
        }
    }

    public void setLocationOption(AMapLocationClientOption aMapLocationClientOption) {
        try {
            if (aMapLocationClientOption != null) {
                d2 d2Var = this.f10615b;
                if (d2Var != null) {
                    d2Var.w(aMapLocationClientOption);
                }
                if (aMapLocationClientOption.f10622b) {
                    aMapLocationClientOption.f10622b = false;
                    JSONObject jSONObject = new JSONObject();
                    if (!TextUtils.isEmpty(aMapLocationClientOption.f10623c)) {
                        jSONObject.put("amap_loc_scenes_type", aMapLocationClientOption.f10623c);
                    }
                    h.a(this.f10614a, "O019", jSONObject);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("LocationManagerOption\u53c2\u6570\u4e0d\u80fd\u4e3anull");
        } catch (Throwable th) {
            b.a(th, "AMClt", "sLocnO");
        }
    }

    public void startAssistantLocation(WebView webView) {
        try {
            d2 d2Var = this.f10615b;
            if (d2Var != null) {
                d2Var.m(webView);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "sttAssL1");
        }
    }

    public void startLocation() {
        try {
            d2 d2Var = this.f10615b;
            if (d2Var != null) {
                d2Var.G();
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "stl");
        }
    }

    public void stopAssistantLocation() {
        try {
            d2 d2Var = this.f10615b;
            if (d2Var != null) {
                d2Var.f0();
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "stAssL");
        }
    }

    public void stopLocation() {
        try {
            d2 d2Var = this.f10615b;
            if (d2Var != null) {
                d2Var.R();
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "stl");
        }
    }

    public void unRegisterLocationListener(AMapLocationListener aMapLocationListener) {
        try {
            d2 d2Var = this.f10615b;
            if (d2Var != null) {
                d2Var.N(aMapLocationListener);
            }
        } catch (Throwable th) {
            b.a(th, "AMClt", "unRL");
        }
    }

    public AMapLocationClient(Context context, Intent intent) throws Exception {
        a(context);
        try {
            if (context != null) {
                this.f10614a = StubApp.getOrigApplicationContext(context.getApplicationContext());
                this.f10615b = new d2(this.f10614a, intent, null);
                return;
            }
            throw new IllegalArgumentException("Context\u53c2\u6570\u4e0d\u80fd\u4e3anull");
        } catch (Throwable th) {
            b.a(th, "AMClt", "ne2");
        }
    }

    public AMapLocationClient(Looper looper, Context context) throws Exception {
        a(context);
        try {
            if (context != null) {
                this.f10614a = StubApp.getOrigApplicationContext(context.getApplicationContext());
                this.f10615b = new d2(this.f10614a, null, looper);
                return;
            }
            throw new IllegalArgumentException("Context\u53c2\u6570\u4e0d\u80fd\u4e3anull");
        } catch (Throwable th) {
            b.a(th, "AMClt", "ne3");
        }
    }
}
