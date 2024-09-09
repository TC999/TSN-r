package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashAdListener;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import xyz.adscope.ad.advertisings.constants.ConstantAd;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class dw extends bj {
    private static int G;
    private static dw M;
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private SplashAdListener H;
    private SplashAd.OnFinishListener I;
    private SplashAd.SplashFocusAdListener J;
    private SplashAd.SplashCardAdListener K;

    /* renamed from: L  reason: collision with root package name */
    private RequestParameters f12837L;
    private a N;
    private SplashAd.SplashAdDownloadDialogListener O;
    private HashMap<String, String> P;

    /* renamed from: a  reason: collision with root package name */
    protected int f12838a;

    /* renamed from: q  reason: collision with root package name */
    protected int f12839q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f12840r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f12841s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f12842t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f12843u;

    /* renamed from: v  reason: collision with root package name */
    private RelativeLayout f12844v;

    /* renamed from: w  reason: collision with root package name */
    private String f12845w;

    /* renamed from: x  reason: collision with root package name */
    private int f12846x;

    /* renamed from: y  reason: collision with root package name */
    private int f12847y;

    /* renamed from: z  reason: collision with root package name */
    private int f12848z;

    public dw(Context context, String str, int i4, int i5, int i6, int i7, boolean z3, boolean z4, boolean z5, boolean z6) {
        super(context);
        this.F = 60;
        this.f12838a = 67;
        this.f12839q = -16777216;
        this.f12841s = false;
        this.f12842t = false;
        this.f12843u = false;
        this.f12845w = str;
        this.f12846x = i4;
        this.f12847y = i5;
        this.f12848z = i6;
        this.A = i7;
        this.B = z3;
        this.C = z4;
        this.D = z6;
        this.E = z5;
    }

    private void b(Intent intent, SplashAd.OnFinishListener onFinishListener) {
        Context context = this.f12481h;
        if (context == null || intent == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        this.f12481h.startActivity(intent);
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            return;
        }
        Context context2 = this.f12481h;
        if (context2 instanceof Activity) {
            ((Activity) context2).finish();
        }
    }

    public static void e(int i4) {
        G = i4;
    }

    private String k(String str) {
        if (this.f12837L == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, String> extras = this.f12837L.getExtras();
            if (extras != null) {
                return extras.get(str);
            }
            return null;
        } catch (Throwable th) {
            this.f12482i.d("XAbstractProdTemplate", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b_() {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheSuccess();
        }
        super.b_();
    }

    public void c(int i4) {
        this.f12839q = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void c_() {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheFailed();
        }
        super.c_();
    }

    public void d(int i4) {
        this.F = i4;
    }

    public void f() {
        IAdInterListener iAdInterListener;
        if (this.f12840r || (iAdInterListener = this.f12484k) == null) {
            return;
        }
        iAdInterListener.setAdContainer(this.f12844v);
        this.f12484k.showAd();
    }

    public boolean g() {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("event_type", "splash_focus_card_enable");
            a(jSONObject, hashMap);
            Object obj = hashMap.get("splash_focus_card_enable");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (JSONException e4) {
            bv.a().c(e4);
            return false;
        } catch (Throwable th) {
            bv.a().c(th);
            return false;
        }
    }

    public a h() {
        return this.N;
    }

    public Object j(String str) {
        if (this.N != null) {
            if (ConstantAd.KEY_CACHE_AD.equals(str)) {
                return this.N.U();
            }
            return this.N.a(str);
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.A);
            jSONObject.put("splashTipStyle", this.f12848z);
            jSONObject.put("bitmapDisplayMode", G);
            jSONObject.put("countDownNew", "true");
            jSONObject.put("Display_Down_Info", "" + this.B);
            jSONObject.put("popDialogIfDl", "" + this.C);
            jSONObject.put("limitRegionClick", "" + this.D);
            jSONObject.put("displayClickButton", "" + this.E);
            jSONObject.put("needCache", true);
            jSONObject.put("onlyLoadAd", this.f12840r);
            jSONObject.put("cacheVideoOnlyWifi", true);
            jSONObject.put("shakeLogoSize", this.F);
            jSONObject.put("twistLogoHeightDp", this.f12838a);
            jSONObject.put("twistBgColor", this.f12839q);
            RequestParameters requestParameters = this.f12837L;
            if (requestParameters != null) {
                a(requestParameters.getExtras());
            }
            return k.a(jSONObject, b(this.f12486m));
        } catch (Exception e4) {
            e4.printStackTrace();
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void q() {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdPresent();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.J;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdIconShow();
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.K;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void t() {
        SplashAd.OnFinishListener onFinishListener = this.I;
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            this.I = null;
        } else {
            Context context = this.f12481h;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }
        this.f12481h = null;
        this.f12844v = null;
        super.t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void u() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpClose();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void v() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADFunctionLpClose();
    }

    public void a(RelativeLayout relativeLayout) {
        this.f12844v = relativeLayout;
    }

    public void c(Map<String, String> map) {
        try {
            this.P = k.a(map);
        } catch (Throwable unused) {
            this.P = new HashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void d() {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onLpClosed();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.J;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onLpClosed();
        }
        super.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(IOAdEvent iOAdEvent) {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdExposed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        this.f12841s = true;
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdClick();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.J;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdClick();
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.K;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardClick();
        }
    }

    public void a(int i4) {
        this.f12838a = i4;
    }

    public void a(SplashAdListener splashAdListener) {
        this.H = splashAdListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpShow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void f(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADFunctionLpShow();
    }

    public void a(SplashAd.SplashFocusAdListener splashFocusAdListener) {
        this.J = splashFocusAdListener;
        this.f12842t = false;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject k() {
        String str = "1";
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("prod", "rsplash");
            this.f12484k.createProdHandler(jSONObject2);
            n();
            jSONObject.put("prod", "rsplash");
            jSONObject.put("apid", this.f12845w);
            jSONObject.put("fet", "ANTI,HTML,MSSP,VIDEO,RSPLASHHTML");
            jSONObject.put("n", "1");
            jSONObject.put("at", "26");
            jSONObject.put("mimetype", "video/mp4,image/jpg,image/gif,image/png");
            jSONObject.put("w", "" + this.f12846x);
            jSONObject.put("h", "" + this.f12847y);
            jSONObject.put("msa", 399);
            if (!TextUtils.isEmpty(this.f12488o)) {
                jSONObject.put("appid", this.f12488o);
            }
            String k4 = k("adaptive_ad");
            if (!TextUtils.isEmpty(k4)) {
                if (!Boolean.parseBoolean(k4)) {
                    str = "0";
                }
                jSONObject.put("adtv", str);
            }
            jSONObject = k.a(jSONObject, b(this.P));
            b(jSONObject);
            return jSONObject;
        } catch (Exception e4) {
            e4.printStackTrace();
            return jSONObject;
        }
    }

    public void a(SplashAd.SplashCardAdListener splashCardAdListener) {
        this.K = splashCardAdListener;
        this.f12842t = false;
    }

    public boolean b(Activity activity) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            this.f12484k.removeAllListeners();
            this.f12484k.addEventListener(x.N, this.f12483j);
            this.f12484k.addEventListener(x.I, this.f12483j);
            this.f12484k.addEventListener(x.X, this.f12483j);
            this.H = null;
            jSONObject.putOpt("event_type", "splash_focus_card");
            hashMap.put("splash_focus_activity", activity);
            a(jSONObject, hashMap);
            Object obj = hashMap.get("splash_focus_card_show");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (JSONException e4) {
            bv.a().c(e4);
            return false;
        } catch (Throwable th) {
            bv.a().c(th);
            return false;
        }
    }

    public void a(RequestParameters requestParameters) {
        this.f12837L = requestParameters;
        c(requestParameters.getExt());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void g(IOAdEvent iOAdEvent) {
        if (this.f12842t) {
            return;
        }
        this.f12842t = true;
        Map<String, Object> data = iOAdEvent.getData();
        if (this.J != null && data != null && data.containsKey("splash_close_reason")) {
            this.J.onAdClose();
            return;
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.K;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardClose();
            return;
        }
        super.g(iOAdEvent);
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdDismissed();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener == null) {
            this.f12485l = false;
            return;
        }
        this.f12485l = true;
        if (!this.f12840r) {
            iAdInterListener.setAdContainer(this.f12844v);
        }
        this.f12484k.loadAd(k(), l());
    }

    public void a(@NonNull Intent intent, @Nullable SplashAd.OnFinishListener onFinishListener) {
        try {
            if (!this.f12841s && intent != null && this.f12484k != null && !this.f12843u && (this.f12481h instanceof Activity)) {
                this.I = onFinishListener;
                JSONObject jSONObject = new JSONObject();
                HashMap hashMap = new HashMap();
                try {
                    jSONObject.putOpt("event_type", "splash_focus_start_activity");
                    hashMap.put("splash_focus_user_intent", intent);
                } catch (JSONException e4) {
                    bv.a().a(e4);
                }
                this.f12484k.removeAllListeners();
                this.f12484k.addEventListener(x.aa, this.f12483j);
                this.f12484k.addEventListener(x.N, this.f12483j);
                this.f12484k.addEventListener(x.I, this.f12483j);
                this.f12484k.addEventListener(x.X, this.f12483j);
                this.f12484k.addEventListener(x.Y, this.f12483j);
                a(jSONObject, hashMap);
                this.H = null;
                M = this;
                be.a().a(new dx(this), 3L, TimeUnit.SECONDS);
                return;
            }
            b(intent, onFinishListener);
        } catch (Throwable th) {
            th.printStackTrace();
            b(intent, onFinishListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void g(String str) {
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdSkip();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i4) {
        this.f12843u = true;
        if (this.H != null) {
            a(i4 + "==" + str);
            this.H.onAdFailed(str);
        }
        super.b(str, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, boolean z3) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z3) {
            splashAdDownloadDialogListener.adDownloadWindowShow();
        } else {
            splashAdDownloadDialogListener.adDownloadWindowClose();
        }
    }

    public static void a(Activity activity, JSONObject jSONObject, SplashAd.SplashFocusAdListener splashFocusAdListener) {
        dw dwVar = M;
        if (dwVar != null) {
            dwVar.a(splashFocusAdListener);
            HashMap hashMap = new HashMap();
            JSONObject jSONObject2 = new JSONObject();
            try {
                try {
                    jSONObject2.putOpt("event_type", "splash_focus_register_transition");
                    jSONObject2.putOpt("splash_focus_params", jSONObject);
                    hashMap.put("splash_focus_activity", activity);
                    M.a(jSONObject2, hashMap);
                } catch (JSONException e4) {
                    bv.a().c(e4);
                } catch (Throwable th) {
                    bv.a().c(th);
                }
            } finally {
                M = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
        List<a> a4;
        if (iOAdEvent != null && (a4 = b.a(iOAdEvent.getMessage()).a()) != null && a4.size() > 0) {
            this.N = a4.get(0);
        }
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null) {
            splashAdListener.onADLoaded();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(int i4, String str) {
        this.f12843u = true;
        SplashAdListener splashAdListener = this.H;
        if (splashAdListener != null) {
            splashAdListener.onAdFailed("\u5e7f\u544a\u65e0\u586b\u5145");
        }
        super.a(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(String str, boolean z3) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z3) {
            splashAdDownloadDialogListener.onADPermissionShow();
        } else {
            splashAdDownloadDialogListener.onADPermissionClose();
        }
    }

    public void a(SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.O = splashAdDownloadDialogListener;
    }

    public void a(boolean z3, String str) {
        a(z3, str, (LinkedHashMap<String, Object>) null);
    }

    public void a(boolean z3, String str, LinkedHashMap<String, Object> linkedHashMap) {
        a aVar = this.N;
        if (aVar != null) {
            a(aVar.H(), z3, str, linkedHashMap);
        }
    }

    public void a(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("msg", str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msg", "sendSplashFailedLog");
            } catch (JSONException e4) {
                bv.a().a(e4);
            }
            a(jSONObject, hashMap);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
