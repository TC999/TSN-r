package com.amap.api.col.p0463l;

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
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.district.DistrictSearchQuery;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.r6 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class H5LocationClient {

    /* renamed from: b */
    private Context f5179b;

    /* renamed from: d */
    private WebView f5181d;

    /* renamed from: h */
    C1931c f5185h;

    /* renamed from: a */
    Object f5178a = new Object();

    /* renamed from: c */
    private AMapLocationClient f5180c = null;

    /* renamed from: e */
    private String f5182e = "AMap.Geolocation.cbk";

    /* renamed from: f */
    AMapLocationClientOption f5183f = null;

    /* renamed from: g */
    private volatile boolean f5184g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: H5LocationClient.java */
    /* renamed from: com.amap.api.col.3l.r6$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C1929a implements ValueCallback<String> {
        C1929a() {
        }

        @Override // android.webkit.ValueCallback
        public final /* bridge */ /* synthetic */ void onReceiveValue(String str) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: H5LocationClient.java */
    /* renamed from: com.amap.api.col.3l.r6$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC1930b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f5187a;

        RunnableC1930b(String str) {
            this.f5187a = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            WebView webView = H5LocationClient.this.f5181d;
            webView.loadUrl("javascript:" + H5LocationClient.this.f5182e + "('" + this.f5187a + "')");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: H5LocationClient.java */
    /* renamed from: com.amap.api.col.3l.r6$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C1931c implements AMapLocationListener {
        C1931c() {
        }

        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            if (H5LocationClient.this.f5184g) {
                H5LocationClient.this.m54036i(H5LocationClient.m54038g(aMapLocation));
            }
        }
    }

    public H5LocationClient(Context context, WebView webView) {
        this.f5181d = null;
        this.f5185h = null;
        this.f5179b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f5181d = webView;
        this.f5185h = new C1931c();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0055 A[Catch: all -> 0x0077, TryCatch #0 {all -> 0x0077, blocks: (B:21:0x004e, B:23:0x0055, B:25:0x0064, B:29:0x006a, B:31:0x006f, B:24:0x005d), top: B:36:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005d A[Catch: all -> 0x0077, TryCatch #0 {all -> 0x0077, blocks: (B:21:0x004e, B:23:0x0055, B:25:0x0064, B:29:0x006a, B:31:0x006f, B:24:0x005d), top: B:36:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006f A[Catch: all -> 0x0077, TRY_LEAVE, TryCatch #0 {all -> 0x0077, blocks: (B:21:0x004e, B:23:0x0055, B:25:0x0064, B:29:0x006a, B:31:0x006f, B:24:0x005d), top: B:36:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x004e -> B:36:0x004e). Please submit an issue!!! */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m54040e(java.lang.String r10) {
        /*
            r9 = this;
            com.amap.api.location.AMapLocationClientOption r0 = r9.f5183f
            if (r0 != 0) goto Lb
            com.amap.api.location.AMapLocationClientOption r0 = new com.amap.api.location.AMapLocationClientOption
            r0.<init>()
            r9.f5183f = r0
        Lb:
            r0 = 5
            r1 = 30000(0x7530, double:1.4822E-319)
            r3 = 1
            r4 = 0
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4c
            r5.<init>(r10)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r10 = "to"
            long r1 = r5.optLong(r10, r1)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r10 = "useGPS"
            int r10 = r5.optInt(r10, r3)     // Catch: java.lang.Throwable -> L4c
            if (r10 != r3) goto L25
            r10 = 1
            goto L26
        L25:
            r10 = 0
        L26:
            java.lang.String r6 = "watch"
            int r6 = r5.optInt(r6, r4)     // Catch: java.lang.Throwable -> L4d
            if (r6 != r3) goto L30
            r6 = 1
            goto L31
        L30:
            r6 = 0
        L31:
            java.lang.String r7 = "interval"
            int r0 = r5.optInt(r7, r0)     // Catch: java.lang.Throwable -> L4e
            java.lang.String r7 = "callback"
            r8 = 0
            java.lang.String r5 = r5.optString(r7, r8)     // Catch: java.lang.Throwable -> L4e
            boolean r7 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L4e
            if (r7 != 0) goto L47
            r9.f5182e = r5     // Catch: java.lang.Throwable -> L4e
            goto L4e
        L47:
            java.lang.String r5 = "AMap.Geolocation.cbk"
            r9.f5182e = r5     // Catch: java.lang.Throwable -> L4e
            goto L4e
        L4c:
            r10 = 0
        L4d:
            r6 = 0
        L4e:
            com.amap.api.location.AMapLocationClientOption r5 = r9.f5183f     // Catch: java.lang.Throwable -> L77
            r5.setHttpTimeOut(r1)     // Catch: java.lang.Throwable -> L77
            if (r10 == 0) goto L5d
            com.amap.api.location.AMapLocationClientOption r10 = r9.f5183f     // Catch: java.lang.Throwable -> L77
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r1 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Hight_Accuracy     // Catch: java.lang.Throwable -> L77
            r10.setLocationMode(r1)     // Catch: java.lang.Throwable -> L77
            goto L64
        L5d:
            com.amap.api.location.AMapLocationClientOption r10 = r9.f5183f     // Catch: java.lang.Throwable -> L77
            com.amap.api.location.AMapLocationClientOption$AMapLocationMode r1 = com.amap.api.location.AMapLocationClientOption.AMapLocationMode.Battery_Saving     // Catch: java.lang.Throwable -> L77
            r10.setLocationMode(r1)     // Catch: java.lang.Throwable -> L77
        L64:
            com.amap.api.location.AMapLocationClientOption r10 = r9.f5183f     // Catch: java.lang.Throwable -> L77
            if (r6 != 0) goto L69
            goto L6a
        L69:
            r3 = 0
        L6a:
            r10.setOnceLocation(r3)     // Catch: java.lang.Throwable -> L77
            if (r6 == 0) goto L77
            com.amap.api.location.AMapLocationClientOption r10 = r9.f5183f     // Catch: java.lang.Throwable -> L77
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch: java.lang.Throwable -> L77
            r10.setInterval(r0)     // Catch: java.lang.Throwable -> L77
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.H5LocationClient.m54040e(java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static String m54038g(AMapLocation aMapLocation) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (aMapLocation == null) {
                jSONObject.put("errorCode", -1);
                jSONObject.put(MyLocationStyle.ERROR_INFO, "unknownError");
            } else if (aMapLocation.getErrorCode() == 0) {
                jSONObject.put("errorCode", 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("x", aMapLocation.getLongitude());
                jSONObject2.put("y", aMapLocation.getLatitude());
                jSONObject2.put("precision", aMapLocation.getAccuracy());
                jSONObject2.put("type", aMapLocation.getLocationType());
                jSONObject2.put("country", aMapLocation.getCountry());
                jSONObject2.put(DistrictSearchQuery.KEYWORDS_PROVINCE, aMapLocation.getProvince());
                jSONObject2.put(DistrictSearchQuery.KEYWORDS_CITY, aMapLocation.getCity());
                jSONObject2.put("cityCode", aMapLocation.getCityCode());
                jSONObject2.put(DistrictSearchQuery.KEYWORDS_DISTRICT, aMapLocation.getDistrict());
                jSONObject2.put("adCode", aMapLocation.getAdCode());
                jSONObject2.put("street", aMapLocation.getStreet());
                jSONObject2.put("streetNum", aMapLocation.getStreetNum());
                jSONObject2.put("floor", aMapLocation.getFloor());
                jSONObject2.put("address", aMapLocation.getAddress());
                jSONObject.put(CommonNetImpl.RESULT, jSONObject2);
            } else {
                jSONObject.put("errorCode", aMapLocation.getErrorCode());
                jSONObject.put(MyLocationStyle.ERROR_INFO, aMapLocation.getErrorInfo());
                jSONObject.put("locationDetail", aMapLocation.getLocationDetail());
            }
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: i */
    public void m54036i(String str) {
        try {
            WebView webView = this.f5181d;
            if (webView != null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    webView.evaluateJavascript("javascript:" + this.f5182e + "('" + str + "')", new C1929a());
                    return;
                }
                webView.post(new RunnableC1930b(str));
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "H5LocationClient", "callbackJs()");
        }
    }

    /* renamed from: c */
    public final void m54042c() {
        if (this.f5181d == null || this.f5179b == null || this.f5184g) {
            return;
        }
        try {
            this.f5181d.getSettings().setJavaScriptEnabled(true);
            this.f5181d.addJavascriptInterface(this, "AMapAndroidLoc");
            if (!TextUtils.isEmpty(this.f5181d.getUrl())) {
                this.f5181d.reload();
            }
            if (this.f5180c == null) {
                AMapLocationClient aMapLocationClient = new AMapLocationClient(this.f5179b);
                this.f5180c = aMapLocationClient;
                aMapLocationClient.setLocationListener(this.f5185h);
            }
            this.f5184g = true;
        } catch (Throwable unused) {
        }
    }

    @JavascriptInterface
    public final void getLocation(String str) {
        synchronized (this.f5178a) {
            if (this.f5184g) {
                m54040e(str);
                AMapLocationClient aMapLocationClient = this.f5180c;
                if (aMapLocationClient != null) {
                    aMapLocationClient.setLocationOption(this.f5183f);
                    this.f5180c.stopLocation();
                    this.f5180c.startLocation();
                }
            }
        }
    }

    /* renamed from: h */
    public final void m54037h() {
        synchronized (this.f5178a) {
            this.f5184g = false;
            AMapLocationClient aMapLocationClient = this.f5180c;
            if (aMapLocationClient != null) {
                aMapLocationClient.unRegisterLocationListener(this.f5185h);
                this.f5180c.stopLocation();
                this.f5180c.onDestroy();
                this.f5180c = null;
            }
            this.f5183f = null;
        }
    }

    @JavascriptInterface
    public final void stopLocation() {
        AMapLocationClient aMapLocationClient;
        if (this.f5184g && (aMapLocationClient = this.f5180c) != null) {
            aMapLocationClient.stopLocation();
        }
    }
}
