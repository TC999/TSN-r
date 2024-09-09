package com.amap.api.col.p0003l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.stub.StubApp;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: H5LocationClient.java */
/* renamed from: com.amap.api.col.3l.s6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class s6 {

    /* renamed from: b  reason: collision with root package name */
    private Context f8946b;

    /* renamed from: d  reason: collision with root package name */
    private WebView f8948d;

    /* renamed from: h  reason: collision with root package name */
    c f8952h;

    /* renamed from: a  reason: collision with root package name */
    Object f8945a = new Object();

    /* renamed from: c  reason: collision with root package name */
    private AMapLocationClient f8947c = null;

    /* renamed from: e  reason: collision with root package name */
    private String f8949e = "AMap.Geolocation.cbk";

    /* renamed from: f  reason: collision with root package name */
    AMapLocationClientOption f8950f = null;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f8951g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: H5LocationClient.java */
    /* renamed from: com.amap.api.col.3l.s6$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a implements ValueCallback<String> {
        a() {
        }

        @Override // android.webkit.ValueCallback
        public final /* bridge */ /* synthetic */ void onReceiveValue(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: H5LocationClient.java */
    /* renamed from: com.amap.api.col.3l.s6$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f8954a;

        b(String str) {
            this.f8954a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WebView webView = s6.this.f8948d;
            webView.loadUrl("javascript:" + s6.this.f8949e + "('" + this.f8954a + "')");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: H5LocationClient.java */
    /* renamed from: com.amap.api.col.3l.s6$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class c implements AMapLocationListener {
        c() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            if (s6.this.f8951g) {
                s6.this.i(s6.g(aMapLocation));
            }
        }
    }

    public s6(Context context, WebView webView) {
        this.f8948d = null;
        this.f8952h = null;
        this.f8946b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f8948d = webView;
        this.f8952h = new c();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0058 A[Catch: all -> 0x007a, TryCatch #2 {all -> 0x007a, blocks: (B:21:0x0051, B:23:0x0058, B:25:0x0067, B:29:0x006d, B:31:0x0072, B:24:0x0060), top: B:41:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0060 A[Catch: all -> 0x007a, TryCatch #2 {all -> 0x007a, blocks: (B:21:0x0051, B:23:0x0058, B:25:0x0067, B:29:0x006d, B:31:0x0072, B:24:0x0060), top: B:41:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0072 A[Catch: all -> 0x007a, TRY_LEAVE, TryCatch #2 {all -> 0x007a, blocks: (B:21:0x0051, B:23:0x0058, B:25:0x0067, B:29:0x006d, B:31:0x0072, B:24:0x0060), top: B:41:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(java.lang.String r10) {
        /*
            r9 = this;
            com.amap.api.location.AMapLocationClientOption r0 = r9.f8950f
            if (r0 != 0) goto Lb
            com.amap.api.location.AMapLocationClientOption r0 = new com.amap.api.location.AMapLocationClientOption
            r0.<init>()
            r9.f8950f = r0
        Lb:
            r0 = 5
            r1 = 30000(0x7530, double:1.4822E-319)
            r3 = 1
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4f
            r5.<init>(r10)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r10 = "to"
            long r1 = r5.optLong(r10, r1)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r10 = "useGPS"
            int r10 = r5.optInt(r10, r3)     // Catch: java.lang.Throwable -> L4f
            if (r10 != r3) goto L27
            r10 = 1
            goto L28
        L27:
            r10 = 0
        L28:
            java.lang.String r6 = "watch"
            int r6 = r5.optInt(r6, r4)     // Catch: java.lang.Throwable -> L50
            if (r6 != r3) goto L33
            r6 = 1
            goto L34
        L33:
            r6 = 0
        L34:
            java.lang.String r7 = "interval"
            int r0 = r5.optInt(r7, r0)     // Catch: java.lang.Throwable -> L51
            java.lang.String r7 = "callback"
            r8 = 0
            java.lang.String r5 = r5.optString(r7, r8)     // Catch: java.lang.Throwable -> L51
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L51
            if (r7 != 0) goto L4a
            r9.f8949e = r5     // Catch: java.lang.Throwable -> L51
            goto L51
        L4a:
            java.lang.String r5 = "AMap.Geolocation.cbk"
            r9.f8949e = r5     // Catch: java.lang.Throwable -> L51
            goto L51
        L4f:
            r10 = 0
        L50:
            r6 = 0
        L51:
            com.amap.api.location.AMapLocationClientOption r5 = r9.f8950f     // Catch: java.lang.Throwable -> L7a
            r5.setHttpTimeOut(r1)     // Catch: java.lang.Throwable -> L7a
            if (r10 == 0) goto L60
            com.amap.api.location.AMapLocationClientOption r10 = r9.f8950f     // Catch: java.lang.Throwable -> L7a
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r1 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy     // Catch: java.lang.Throwable -> L7a
            r10.setLocationMode(r1)     // Catch: java.lang.Throwable -> L7a
            goto L67
        L60:
            com.amap.api.location.AMapLocationClientOption r10 = r9.f8950f     // Catch: java.lang.Throwable -> L7a
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r1 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving     // Catch: java.lang.Throwable -> L7a
            r10.setLocationMode(r1)     // Catch: java.lang.Throwable -> L7a
        L67:
            com.amap.api.location.AMapLocationClientOption r10 = r9.f8950f     // Catch: java.lang.Throwable -> L7a
            if (r6 != 0) goto L6c
            goto L6d
        L6c:
            r3 = 0
        L6d:
            r10.setOnceLocation(r3)     // Catch: java.lang.Throwable -> L7a
            if (r6 == 0) goto L7a
            com.amap.api.location.AMapLocationClientOption r10 = r9.f8950f     // Catch: java.lang.Throwable -> L7a
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L7a
            r10.setInterval(r0)     // Catch: java.lang.Throwable -> L7a
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.s6.e(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(AMapLocation aMapLocation) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (aMapLocation == null) {
                jSONObject.put("errorCode", -1);
                jSONObject.put("errorInfo", "unknownError");
            } else if (aMapLocation.getErrorCode() == 0) {
                jSONObject.put("errorCode", 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", aMapLocation.getLongitude());
                jSONObject2.put("y", aMapLocation.getLatitude());
                jSONObject2.put("precision", aMapLocation.getAccuracy());
                jSONObject2.put("type", aMapLocation.getLocationType());
                jSONObject2.put("country", aMapLocation.getCountry());
                jSONObject2.put("province", aMapLocation.getProvince());
                jSONObject2.put("city", aMapLocation.getCity());
                jSONObject2.put("cityCode", aMapLocation.getCityCode());
                jSONObject2.put("district", aMapLocation.getDistrict());
                jSONObject2.put("adCode", aMapLocation.getAdCode());
                jSONObject2.put("street", aMapLocation.getStreet());
                jSONObject2.put("streetNum", aMapLocation.getStreetNum());
                jSONObject2.put("floor", aMapLocation.getFloor());
                jSONObject2.put("address", aMapLocation.getAddress());
                jSONObject.put("result", jSONObject2);
            } else {
                jSONObject.put("errorCode", aMapLocation.getErrorCode());
                jSONObject.put("errorInfo", aMapLocation.getErrorInfo());
                jSONObject.put("locationDetail", aMapLocation.getLocationDetail());
            }
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void i(String str) {
        try {
            WebView webView = this.f8948d;
            if (webView != null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript("javascript:" + this.f8949e + "('" + str + "')", new a());
                    return;
                }
                webView.post(new b(str));
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "H5LocationClient", "callbackJs()");
        }
    }

    public final void c() {
        if (this.f8948d == null || this.f8946b == null || this.f8951g) {
            return;
        }
        try {
            this.f8948d.getSettings().setJavaScriptEnabled(true);
            this.f8948d.addJavascriptInterface(this, "AMapAndroidLoc");
            if (!TextUtils.isEmpty(this.f8948d.getUrl())) {
                this.f8948d.reload();
            }
            if (this.f8947c == null) {
                AMapLocationClient aMapLocationClient = new AMapLocationClient(this.f8946b);
                this.f8947c = aMapLocationClient;
                aMapLocationClient.setLocationListener(this.f8952h);
            }
            this.f8951g = true;
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public final void getLocation(String str) {
        synchronized (this.f8945a) {
            if (this.f8951g) {
                e(str);
                AMapLocationClient aMapLocationClient = this.f8947c;
                if (aMapLocationClient != null) {
                    aMapLocationClient.setLocationOption(this.f8950f);
                    this.f8947c.stopLocation();
                    this.f8947c.startLocation();
                }
            }
        }
    }

    public final void h() {
        synchronized (this.f8945a) {
            this.f8951g = false;
            AMapLocationClient aMapLocationClient = this.f8947c;
            if (aMapLocationClient != null) {
                aMapLocationClient.unRegisterLocationListener(this.f8952h);
                this.f8947c.stopLocation();
                this.f8947c.onDestroy();
                this.f8947c = null;
            }
            this.f8950f = null;
        }
    }

    @JavascriptInterface
    public final void stopLocation() {
        AMapLocationClient aMapLocationClient;
        if (this.f8951g && (aMapLocationClient = this.f8947c) != null) {
            aMapLocationClient.stopLocation();
        }
    }
}
