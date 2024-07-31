package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashAdListener;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.dt */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2702dt extends AbstractC2619bg {

    /* renamed from: G */
    private static int f9036G;

    /* renamed from: M */
    private static C2702dt f9037M;

    /* renamed from: A */
    private int f9038A;

    /* renamed from: B */
    private boolean f9039B;

    /* renamed from: C */
    private boolean f9040C;

    /* renamed from: D */
    private boolean f9041D;

    /* renamed from: E */
    private boolean f9042E;

    /* renamed from: F */
    private int f9043F;

    /* renamed from: H */
    private SplashAdListener f9044H;

    /* renamed from: I */
    private SplashAd.OnFinishListener f9045I;

    /* renamed from: J */
    private SplashAd.SplashFocusAdListener f9046J;

    /* renamed from: K */
    private SplashAd.SplashCardAdListener f9047K;

    /* renamed from: L */
    private RequestParameters f9048L;

    /* renamed from: N */
    private C2573a f9049N;

    /* renamed from: O */
    private SplashAd.SplashAdDownloadDialogListener f9050O;

    /* renamed from: P */
    private HashMap<String, String> f9051P;

    /* renamed from: a */
    protected int f9052a;

    /* renamed from: q */
    protected int f9053q;

    /* renamed from: r */
    public boolean f9054r;

    /* renamed from: s */
    public boolean f9055s;

    /* renamed from: t */
    public boolean f9056t;

    /* renamed from: u */
    public boolean f9057u;

    /* renamed from: v */
    private RelativeLayout f9058v;

    /* renamed from: w */
    private String f9059w;

    /* renamed from: x */
    private int f9060x;

    /* renamed from: y */
    private int f9061y;

    /* renamed from: z */
    private int f9062z;

    public C2702dt(Context context, String str, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context);
        this.f9043F = 60;
        this.f9052a = 67;
        this.f9053q = ViewCompat.MEASURED_STATE_MASK;
        this.f9055s = false;
        this.f9056t = false;
        this.f9057u = false;
        this.f9059w = str;
        this.f9060x = i;
        this.f9061y = i2;
        this.f9062z = i3;
        this.f9038A = i4;
        this.f9039B = z;
        this.f9040C = z2;
        this.f9041D = z4;
        this.f9042E = z3;
    }

    /* renamed from: b */
    private void m50443b(Intent intent, SplashAd.OnFinishListener onFinishListener) {
        Context context = this.f8663h;
        if (context == null || intent == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        this.f8663h.startActivity(intent);
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            return;
        }
        Context context2 = this.f8663h;
        if (context2 instanceof Activity) {
            ((Activity) context2).finish();
        }
    }

    /* renamed from: e */
    public static void m50434e(int i) {
        f9036G = i;
    }

    /* renamed from: k */
    private String m50424k(String str) {
        if (this.f9048L == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, String> extras = this.f9048L.getExtras();
            if (extras != null) {
                return extras.get(str);
            }
            return null;
        } catch (Throwable th) {
            this.f8664i.m50726d(AbstractC2619bg.f8657b, th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b_ */
    public void mo50440b_() {
        SplashAdListener splashAdListener = this.f9044H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheSuccess();
        }
        super.mo50440b_();
    }

    /* renamed from: c */
    public void m50439c(int i) {
        this.f9053q = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: c_ */
    public void mo50437c_() {
        SplashAdListener splashAdListener = this.f9044H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheFailed();
        }
        super.mo50437c_();
    }

    /* renamed from: d */
    public void m50435d(int i) {
        this.f9043F = i;
    }

    /* renamed from: f */
    public void m50432f() {
        IAdInterListener iAdInterListener;
        if (this.f9054r || (iAdInterListener = this.f8666k) == null) {
            return;
        }
        iAdInterListener.setAdContainer(this.f9058v);
        this.f8666k.showAd();
    }

    /* renamed from: g */
    public boolean m50430g() {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("event_type", "splash_focus_card_enable");
            m50818a(jSONObject, hashMap);
            Object obj = hashMap.get("splash_focus_card_enable");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (JSONException e) {
            C2634bs.m50744a().m50729c(e);
            return false;
        } catch (Throwable th) {
            C2634bs.m50744a().m50729c(th);
            return false;
        }
    }

    /* renamed from: h */
    public C2573a m50428h() {
        return this.f9049N;
    }

    /* renamed from: j */
    public Object m50426j(String str) {
        if (this.f9049N != null) {
            if ("request_id".equals(str)) {
                return this.f9049N.m51109U();
            }
            return this.f9049N.m51105a(str);
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: l */
    public JSONObject mo50423l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.f9038A);
            jSONObject.put("splashTipStyle", this.f9062z);
            jSONObject.put("bitmapDisplayMode", f9036G);
            jSONObject.put("countDownNew", "true");
            jSONObject.put("Display_Down_Info", "" + this.f9039B);
            jSONObject.put("popDialogIfDl", "" + this.f9040C);
            jSONObject.put("limitRegionClick", "" + this.f9041D);
            jSONObject.put("displayClickButton", "" + this.f9042E);
            jSONObject.put("needCache", true);
            jSONObject.put("onlyLoadAd", this.f9054r);
            jSONObject.put("cacheVideoOnlyWifi", true);
            jSONObject.put("shakeLogoSize", this.f9043F);
            jSONObject.put("twistLogoHeightDp", this.f9052a);
            jSONObject.put("twistBgColor", this.f9053q);
            RequestParameters requestParameters = this.f9048L;
            if (requestParameters != null) {
                mo50471a(requestParameters.getExtras());
            }
            return C2714k.m50362a(jSONObject, m50813b(this.f8668m));
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: q */
    public void mo50422q() {
        SplashAdListener splashAdListener = this.f9044H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdPresent();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.f9046J;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdIconShow();
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.f9047K;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: t */
    public void mo50421t() {
        SplashAd.OnFinishListener onFinishListener = this.f9045I;
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            this.f9045I = null;
        } else {
            Context context = this.f8663h;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }
        this.f8663h = null;
        this.f9058v = null;
        super.mo50421t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: u */
    public void mo50420u() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.f9050O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpClose();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: v */
    public void mo50419v() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.f9050O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADFunctionLpClose();
    }

    /* renamed from: a */
    public void m50456a(RelativeLayout relativeLayout) {
        this.f9058v = relativeLayout;
    }

    /* renamed from: c */
    public void m50438c(Map<String, String> map) {
        try {
            this.f9051P = C2714k.m50365a(map);
        } catch (Throwable unused) {
            this.f9051P = new HashMap<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: d */
    public void mo50436d() {
        SplashAdListener splashAdListener = this.f9044H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onLpClosed();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.f9046J;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onLpClosed();
        }
        super.mo50436d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: e */
    public void mo50433e(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.f9050O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpShow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: h */
    public void mo50427h(IOAdEvent iOAdEvent) {
        this.f9055s = true;
        SplashAdListener splashAdListener = this.f9044H;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdClick();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.f9046J;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdClick();
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.f9047K;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardClick();
        }
    }

    /* renamed from: a */
    public void m50460a(int i) {
        this.f9052a = i;
    }

    /* renamed from: a */
    public void m50450a(SplashAdListener splashAdListener) {
        this.f9044H = splashAdListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: f */
    public void mo50431f(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.f9050O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADFunctionLpShow();
    }

    /* renamed from: a */
    public void m50451a(SplashAd.SplashFocusAdListener splashFocusAdListener) {
        this.f9046J = splashFocusAdListener;
        this.f9056t = false;
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: k */
    public JSONObject mo50425k() {
        String str = "1";
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            this.f8666k.createProdHandler(jSONObject2);
            m50805n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f9059w);
            jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,RSPLASHHTML");
            jSONObject.put("n", "1");
            jSONObject.put("at", "26");
            jSONObject.put(IAdInterListener.AdReqParam.MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f9060x);
            jSONObject.put("h", "" + this.f9061y);
            jSONObject.put("msa", 399);
            if (!TextUtils.isEmpty(this.f8670o)) {
                jSONObject.put("appid", this.f8670o);
            }
            String m50424k = m50424k(SplashAd.KEY_USE_ADAPTIVE_AD);
            if (!TextUtils.isEmpty(m50424k)) {
                if (!Boolean.parseBoolean(m50424k)) {
                    str = "0";
                }
                jSONObject.put("adtv", str);
            }
            jSONObject = C2714k.m50362a(jSONObject, m50813b(this.f9051P));
            m50812b(jSONObject);
            return jSONObject;
        } catch (Exception e) {
            e.printStackTrace();
            return jSONObject;
        }
    }

    /* renamed from: a */
    public void m50452a(SplashAd.SplashCardAdListener splashCardAdListener) {
        this.f9047K = splashCardAdListener;
        this.f9056t = false;
    }

    /* renamed from: b */
    public boolean m50444b(Activity activity) {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        try {
            this.f8666k.removeAllListeners();
            this.f8666k.addEventListener(C2736x.f9247M, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9242H, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9257W, this.f8665j);
            this.f9044H = null;
            jSONObject.putOpt("event_type", "splash_focus_card");
            hashMap.put("splash_focus_activity", activity);
            m50818a(jSONObject, hashMap);
            Object obj = hashMap.get("splash_focus_card_show");
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            return false;
        } catch (JSONException e) {
            C2634bs.m50744a().m50729c(e);
            return false;
        } catch (Throwable th) {
            C2634bs.m50744a().m50729c(th);
            return false;
        }
    }

    /* renamed from: a */
    public void m50454a(RequestParameters requestParameters) {
        this.f9048L = requestParameters;
        m50438c(requestParameters.getExt());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: g */
    public void mo50429g(IOAdEvent iOAdEvent) {
        if (this.f9056t) {
            return;
        }
        this.f9056t = true;
        Map<String, Object> data = iOAdEvent.getData();
        if (this.f9046J != null && data != null && data.containsKey("splash_close_reason")) {
            this.f9046J.onAdClose();
            return;
        }
        SplashAd.SplashCardAdListener splashCardAdListener = this.f9047K;
        if (splashCardAdListener != null) {
            splashCardAdListener.onCardClose();
            return;
        }
        super.mo50429g(iOAdEvent);
        SplashAdListener splashAdListener = this.f9044H;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdDismissed();
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50356a() {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener == null) {
            this.f8667l = false;
            return;
        }
        this.f8667l = true;
        if (!this.f9054r) {
            iAdInterListener.setAdContainer(this.f9058v);
        }
        this.f8666k.loadAd(mo50425k(), mo50423l());
    }

    /* renamed from: a */
    public void m50457a(@NonNull Intent intent, @Nullable SplashAd.OnFinishListener onFinishListener) {
        try {
            if (!this.f9055s && intent != null && this.f8666k != null && !this.f9057u && (this.f8663h instanceof Activity)) {
                this.f9045I = onFinishListener;
                JSONObject jSONObject = new JSONObject();
                HashMap hashMap = new HashMap();
                try {
                    jSONObject.putOpt("event_type", "splash_focus_start_activity");
                    hashMap.put("splash_focus_user_intent", intent);
                } catch (JSONException e) {
                    C2634bs.m50744a().m50738a(e);
                }
                this.f8666k.removeAllListeners();
                this.f8666k.addEventListener(C2736x.f9260Z, this.f8665j);
                this.f8666k.addEventListener(C2736x.f9247M, this.f8665j);
                this.f8666k.addEventListener(C2736x.f9242H, this.f8665j);
                this.f8666k.addEventListener(C2736x.f9257W, this.f8665j);
                this.f8666k.addEventListener(C2736x.f9258X, this.f8665j);
                m50818a(jSONObject, hashMap);
                this.f9044H = null;
                f9037M = this;
                C2614bb.m50841a().m50838a(new C2703du(this), 3L, TimeUnit.SECONDS);
                return;
            }
            m50443b(intent, onFinishListener);
        } catch (Throwable th) {
            th.printStackTrace();
            m50443b(intent, onFinishListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    public void mo50442b(String str, int i) {
        this.f9057u = true;
        if (this.f9044H != null) {
            m50448a(i + "==" + str);
            this.f9044H.onAdFailed(str);
        }
        super.mo50442b(str, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    public void mo50441b(String str, boolean z) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.f9050O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z) {
            splashAdDownloadDialogListener.adDownloadWindowShow();
        } else {
            splashAdDownloadDialogListener.adDownloadWindowClose();
        }
    }

    /* renamed from: a */
    public static void m50458a(Activity activity, JSONObject jSONObject, SplashAd.SplashFocusAdListener splashFocusAdListener) {
        C2702dt c2702dt = f9037M;
        if (c2702dt != null) {
            c2702dt.m50451a(splashFocusAdListener);
            HashMap hashMap = new HashMap();
            JSONObject jSONObject2 = new JSONObject();
            try {
                try {
                    jSONObject2.putOpt("event_type", "splash_focus_register_transition");
                    jSONObject2.putOpt("splash_focus_params", jSONObject);
                    hashMap.put("splash_focus_activity", activity);
                    f9037M.m50818a(jSONObject2, hashMap);
                } catch (JSONException e) {
                    C2634bs.m50744a().m50729c(e);
                } catch (Throwable th) {
                    C2634bs.m50744a().m50729c(th);
                }
            } finally {
                f9037M = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50455a(IOAdEvent iOAdEvent) {
        List<C2573a> m50843a;
        if (iOAdEvent != null && (m50843a = C2612b.m50842a(iOAdEvent.getMessage()).m50843a()) != null && m50843a.size() > 0) {
            this.f9049N = m50843a.get(0);
        }
        SplashAdListener splashAdListener = this.f9044H;
        if (splashAdListener != null) {
            splashAdListener.onADLoaded();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50459a(int i, String str) {
        this.f9057u = true;
        SplashAdListener splashAdListener = this.f9044H;
        if (splashAdListener != null) {
            splashAdListener.onAdFailed("广告无填充");
        }
        super.mo50459a(i, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50447a(String str, boolean z) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.f9050O;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z) {
            splashAdDownloadDialogListener.onADPermissionShow();
        } else {
            splashAdDownloadDialogListener.onADPermissionClose();
        }
    }

    /* renamed from: a */
    public void m50453a(SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.f9050O = splashAdDownloadDialogListener;
    }

    /* renamed from: a */
    public void m50446a(boolean z, String str) {
        m50445a(z, str, (HashMap<String, Object>) null);
    }

    /* renamed from: a */
    public void m50445a(boolean z, String str, HashMap<String, Object> hashMap) {
        C2573a c2573a = this.f9049N;
        if (c2573a != null) {
            m50820a(c2573a.m51122H(), z, str, hashMap);
        }
    }

    /* renamed from: a */
    public void m50448a(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("msg", str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("msg", "sendSplashFailedLog");
            } catch (JSONException e) {
                C2634bs.m50744a().m50738a(e);
            }
            m50818a(jSONObject, hashMap);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
