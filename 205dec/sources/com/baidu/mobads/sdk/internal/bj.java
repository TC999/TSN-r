package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.a.c;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Observable;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class bj extends Observable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12474a = "b_f";

    /* renamed from: b  reason: collision with root package name */
    public static final String f12475b = "XAbstractProdTemplate";

    /* renamed from: c  reason: collision with root package name */
    public static final String f12476c = "error_message";

    /* renamed from: d  reason: collision with root package name */
    public static final String f12477d = "error_code";

    /* renamed from: e  reason: collision with root package name */
    protected static final String f12478e = "instanceInfo";

    /* renamed from: f  reason: collision with root package name */
    protected static final String f12479f = "showState";

    /* renamed from: g  reason: collision with root package name */
    protected RelativeLayout f12480g;

    /* renamed from: h  reason: collision with root package name */
    protected Context f12481h;

    /* renamed from: m  reason: collision with root package name */
    public HashMap<String, String> f12486m;

    /* renamed from: n  reason: collision with root package name */
    public String f12487n;

    /* renamed from: o  reason: collision with root package name */
    public String f12488o;

    /* renamed from: i  reason: collision with root package name */
    protected bv f12482i = bv.a();

    /* renamed from: k  reason: collision with root package name */
    public IAdInterListener f12484k = null;

    /* renamed from: l  reason: collision with root package name */
    public boolean f12485l = true;

    /* renamed from: p  reason: collision with root package name */
    public int f12489p = -1;

    /* renamed from: j  reason: collision with root package name */
    public IOAdEventListener f12483j = new a();

    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a implements IOAdEventListener {
        public a() {
        }

        private String a(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            Object obj;
            if (iOAdEvent != null) {
                String message = iOAdEvent.getMessage();
                return (!TextUtils.isEmpty(message) || (data = iOAdEvent.getData()) == null || (obj = data.get("msg")) == null || !(obj instanceof String)) ? message : (String) obj;
            }
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            bj.a(new bm(this, iOAdEvent));
        }
    }

    public bj(Context context) {
        this.f12481h = context;
        aa.a().a(this.f12481h, new bk(this));
    }

    public abstract void a();

    public void a(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a("onAdImpression", jSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(IOAdEvent iOAdEvent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, boolean z3) {
    }

    public void b(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a("onAdClick", jSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(IOAdEvent iOAdEvent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, boolean z3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(boolean z3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b_() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(IOAdEvent iOAdEvent) {
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            b("bidding id is empty", 2);
        }
        if (this.f12484k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bid_id", str);
            a("load_bidding_ad", (Map<String, Object>) hashMap);
            return;
        }
        b("Initialization doesn't finish yet.", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c_() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(IOAdEvent iOAdEvent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(String str) {
    }

    public void e() {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener != null) {
            iAdInterListener.destroyAd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(IOAdEvent iOAdEvent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(IOAdEvent iOAdEvent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(IOAdEvent iOAdEvent) {
        r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(IOAdEvent iOAdEvent) {
    }

    public void h(String str) {
        this.f12488o = str;
    }

    public void i() {
        this.f12484k = (IAdInterListener) av.a(x.f13030k, bu.a(this.f12481h), new Class[]{Context.class}, this.f12481h);
        if (this.f12485l) {
            return;
        }
        a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(IOAdEvent iOAdEvent) {
    }

    public void j() {
        b("SDK\u672a\u521d\u59cb\u5316", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j(IOAdEvent iOAdEvent) {
    }

    public JSONObject k() {
        return new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(IOAdEvent iOAdEvent) {
    }

    public JSONObject l() {
        return new JSONObject();
    }

    public String m() {
        JSONObject k4 = k();
        JSONObject l4 = l();
        HashMap hashMap = new HashMap();
        hashMap.put("param_info", k4);
        hashMap.put("ad_buss_param", l4);
        a("get_request_token", (Map<String, Object>) hashMap);
        Object obj = hashMap.get("request_token");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public void n() {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener != null) {
            iAdInterListener.addEventListener("p_e", new c.a());
            this.f12484k.addEventListener(x.I, this.f12483j);
            this.f12484k.addEventListener(x.K, this.f12483j);
            this.f12484k.addEventListener(x.M, this.f12483j);
            this.f12484k.addEventListener(x.N, this.f12483j);
            this.f12484k.addEventListener(x.X, this.f12483j);
            this.f12484k.addEventListener(x.f13038s, this.f12483j);
            this.f12484k.addEventListener(x.Y, this.f12483j);
            this.f12484k.addEventListener(x.f13039t, this.f12483j);
            this.f12484k.addEventListener(x.O, this.f12483j);
            this.f12484k.addEventListener(x.P, this.f12483j);
            this.f12484k.addEventListener(x.f13019L, this.f12483j);
            this.f12484k.addEventListener(x.E, this.f12483j);
            this.f12484k.addEventListener(x.ad, this.f12483j);
            this.f12484k.addEventListener(x.ae, this.f12483j);
            this.f12484k.addEventListener(x.ab, this.f12483j);
            this.f12484k.addEventListener(x.W, this.f12483j);
            this.f12484k.addEventListener(x.af, this.f12483j);
            this.f12484k.addEventListener(x.ag, this.f12483j);
            this.f12484k.addEventListener(x.ah, this.f12483j);
            this.f12484k.addEventListener(x.ai, this.f12483j);
            this.f12484k.addEventListener(x.aj, this.f12483j);
            this.f12484k.addEventListener(x.ak, this.f12483j);
            this.f12484k.addEventListener(x.al, this.f12483j);
            this.f12484k.addEventListener(x.am, this.f12483j);
            this.f12484k.addEventListener(x.ac, this.f12483j);
            this.f12484k.addEventListener(x.an, this.f12483j);
            this.f12484k.addEventListener(x.Z, this.f12483j);
            this.f12484k.addEventListener(x.ao, this.f12483j);
            this.f12484k.addEventListener(x.ap, this.f12483j);
        }
    }

    public void o() {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener != null) {
            iAdInterListener.onAttachedToWindow();
        }
    }

    public void p() {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener != null) {
            iAdInterListener.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q() {
    }

    public void r() {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener != null) {
            iAdInterListener.removeAllListeners();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void u() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v() {
    }

    public View w() {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener != null) {
            return iAdInterListener.getAdContainerView();
        }
        return null;
    }

    public void a(Activity activity) {
        if (this.f12484k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("setActivity", activity);
            this.f12484k.onAdTaskProcess(a("onChangeActivity", new JSONObject()), hashMap);
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            b("bidding data is empty", 2);
        }
        if (this.f12484k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bidding_data", str);
            a("load_bidding_data", (Map<String, Object>) hashMap);
            return;
        }
        b("Initialization doesn't finish yet.", 1);
    }

    public String i(String str) {
        IXAdContainerFactory c4;
        aa a4 = aa.a();
        if (a4 != null && (c4 = a4.c()) != null) {
            Object remoteParam = c4.getRemoteParam(str, new Object[0]);
            if (remoteParam instanceof String) {
                return (String) remoteParam;
            }
        }
        return null;
    }

    public void a(JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a("onHandleEvent", jSONObject));
        }
    }

    public void b(int i4) {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowVisibilityChanged(i4);
        }
    }

    public void a(JSONObject jSONObject, Map<String, Object> map) {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a("onHandleEvent", jSONObject), map);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, int i4) {
        r();
    }

    public void a(String str, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", "server_bidding");
            jSONObject.put("msg", str);
            IAdInterListener iAdInterListener = this.f12484k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a("onHandleEvent", jSONObject), map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public JSONObject b(Map<String, String> map) {
        if (map != null) {
            if (!map.isEmpty()) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return new JSONObject(map);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(JSONObject jSONObject) {
        int i4 = this.f12489p;
        if (i4 < 0 || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(f12474a, i4);
        } catch (Throwable th) {
            this.f12482i.a(th);
        }
    }

    public void a(String str, boolean z3, String str2) {
        a(str, z3, str2, null);
    }

    public void a(String str, boolean z3, String str2, LinkedHashMap<String, Object> linkedHashMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", str);
            jSONObject.put("result", z3);
            jSONObject.put("replacement", str2);
            if (linkedHashMap != null) {
                for (Map.Entry<String, Object> entry : linkedHashMap.entrySet()) {
                    jSONObject.put(String.valueOf(entry.getKey()), entry.getValue());
                }
            }
            IAdInterListener iAdInterListener = this.f12484k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a("onBiddingResult", jSONObject), (Map<String, Object>) null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(String str, HashMap<String, Object> hashMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", str);
            IAdInterListener iAdInterListener = this.f12484k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a("onNovelEvent", jSONObject), hashMap);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a(boolean z3) {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowFocusChanged(z3);
        }
    }

    public boolean a(int i4, KeyEvent keyEvent) {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener != null) {
            return iAdInterListener.onKeyDown(i4, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i4, String str) {
        r();
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(new bl(runnable));
            }
        } catch (Exception unused) {
        }
    }

    public void a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f12486m = (HashMap) map;
    }

    private String a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return "bdsdk://" + str + "?jsonObj=" + Uri.encode(jSONObject.toString());
    }
}
