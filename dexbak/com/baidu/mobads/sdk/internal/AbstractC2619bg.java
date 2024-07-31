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
import com.baidu.mobads.sdk.internal.p050a.C2576c;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.bg */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractC2619bg extends Observable {

    /* renamed from: a */
    private static final String f8656a = "b_f";

    /* renamed from: b */
    public static final String f8657b = "XAbstractProdTemplate";

    /* renamed from: c */
    public static final String f8658c = "error_message";

    /* renamed from: d */
    public static final String f8659d = "error_code";

    /* renamed from: e */
    protected static final String f8660e = "instanceInfo";

    /* renamed from: f */
    protected static final String f8661f = "showState";

    /* renamed from: g */
    protected RelativeLayout f8662g;

    /* renamed from: h */
    protected Context f8663h;

    /* renamed from: m */
    public HashMap<String, String> f8668m;

    /* renamed from: n */
    public String f8669n;

    /* renamed from: o */
    public String f8670o;

    /* renamed from: i */
    protected C2634bs f8664i = C2634bs.m50744a();

    /* renamed from: k */
    public IAdInterListener f8666k = null;

    /* renamed from: l */
    public boolean f8667l = true;

    /* renamed from: p */
    public int f8671p = -1;

    /* renamed from: j */
    public IOAdEventListener f8665j = new C2620a();

    /* renamed from: com.baidu.mobads.sdk.internal.bg$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C2620a implements IOAdEventListener {
        public C2620a() {
        }

        /* renamed from: a */
        private String m50801a(IOAdEvent iOAdEvent) {
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
            AbstractC2619bg.m50825a(new RunnableC2623bj(this, iOAdEvent));
        }
    }

    public AbstractC2619bg(Context context) {
        this.f8663h = context;
        C2580aa.m51057a().m51056a(this.f8663h, new C2621bh(this));
    }

    /* renamed from: a */
    public abstract void mo50356a();

    /* renamed from: a */
    public void m50826a(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, m50822a(IAdInterListener.AdCommandType.AD_IMPRESSION, jSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo50455a(IOAdEvent iOAdEvent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo50447a(String str, boolean z) {
    }

    /* renamed from: b */
    public void m50815b(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, m50822a(IAdInterListener.AdCommandType.AD_CLICK, jSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void mo50516b(IOAdEvent iOAdEvent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void mo50441b(String str, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void mo50468b(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b_ */
    public void mo50440b_() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void mo50515c(IOAdEvent iOAdEvent) {
    }

    /* renamed from: c */
    public void m50811c(String str) {
        if (TextUtils.isEmpty(str)) {
            mo50442b("bidding id is empty", 2);
        }
        if (this.f8666k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bid_id", str);
            m50823a("load_bidding_ad", (Map<String, Object>) hashMap);
            return;
        }
        mo50442b("Initialization doesn't finish yet.", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c_ */
    public void mo50437c_() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public void mo50436d() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public void mo50580d(IOAdEvent iOAdEvent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public void mo50512d(String str) {
    }

    /* renamed from: e */
    public void m50810e() {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener != null) {
            iAdInterListener.destroyAd();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public void mo50511e(IOAdEvent iOAdEvent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e */
    public void mo50433e(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public void mo50509f(IOAdEvent iOAdEvent) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public void mo50431f(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public void mo50429g(IOAdEvent iOAdEvent) {
        m50802r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public void mo50465g(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: h */
    public void mo50427h(IOAdEvent iOAdEvent) {
    }

    /* renamed from: h */
    public void m50809h(String str) {
        this.f8670o = str;
    }

    /* renamed from: i */
    public void mo50497i() {
        this.f8666k = (IAdInterListener) C2603as.m50950a(C2736x.f9313k, C2632br.m50753a(this.f8663h), new Class[]{Context.class}, this.f8663h);
        if (this.f8667l) {
            return;
        }
        mo50356a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public void mo50506i(IOAdEvent iOAdEvent) {
    }

    /* renamed from: j */
    public void m50807j() {
        mo50442b("SDK未初始化", 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public void mo50505j(IOAdEvent iOAdEvent) {
    }

    /* renamed from: k */
    public JSONObject mo50425k() {
        return new JSONObject();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public void mo50504k(IOAdEvent iOAdEvent) {
    }

    /* renamed from: l */
    public JSONObject mo50423l() {
        return new JSONObject();
    }

    /* renamed from: m */
    public String m50806m() {
        JSONObject mo50425k = mo50425k();
        JSONObject mo50423l = mo50423l();
        HashMap hashMap = new HashMap();
        hashMap.put("param_info", mo50425k);
        hashMap.put("ad_buss_param", mo50423l);
        m50823a("get_request_token", (Map<String, Object>) hashMap);
        Object obj = hashMap.get("request_token");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    /* renamed from: n */
    public void m50805n() {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener != null) {
            iAdInterListener.addEventListener(C2576c.f8509h, new C2576c.C2577a());
            this.f8666k.addEventListener(C2736x.f9242H, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9244J, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9246L, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9247M, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9257W, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9320r, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9258X, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9321s, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9248N, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9249O, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9245K, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9238D, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9280ac, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9281ad, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9278aa, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9256V, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9282ae, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9283af, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9284ag, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9285ah, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9286ai, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9287aj, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9288ak, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9289al, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9279ab, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9290am, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9259Y, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9291an, this.f8665j);
            this.f8666k.addEventListener(C2736x.f9292ao, this.f8665j);
        }
    }

    /* renamed from: o */
    public void m50804o() {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener != null) {
            iAdInterListener.onAttachedToWindow();
        }
    }

    /* renamed from: p */
    public void m50803p() {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener != null) {
            iAdInterListener.onDetachedFromWindow();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: q */
    public void mo50422q() {
    }

    /* renamed from: r */
    public void m50802r() {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener != null) {
            iAdInterListener.removeAllListeners();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: s */
    public void mo50461s() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: t */
    public void mo50421t() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u */
    public void mo50420u() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: v */
    public void mo50419v() {
    }

    /* renamed from: w */
    public View mo50557w() {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener != null) {
            return iAdInterListener.getAdContainerView();
        }
        return null;
    }

    /* renamed from: a */
    public void m50827a(Activity activity) {
        if (this.f8666k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("setActivity", activity);
            this.f8666k.onAdTaskProcess(m50822a(IAdInterListener.AdCommandType.CHANGE_ACTIVITY, new JSONObject()), hashMap);
        }
    }

    /* renamed from: b */
    public void m50814b(String str) {
        if (TextUtils.isEmpty(str)) {
            mo50442b("bidding data is empty", 2);
        }
        if (this.f8666k != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("bidding_data", str);
            m50823a("load_bidding_data", (Map<String, Object>) hashMap);
            return;
        }
        mo50442b("Initialization doesn't finish yet.", 1);
    }

    /* renamed from: i */
    public String m50808i(String str) {
        IXAdContainerFactory m51049c;
        C2580aa m51057a = C2580aa.m51057a();
        if (m51057a != null && (m51049c = m51057a.m51049c()) != null) {
            Object remoteParam = m51049c.getRemoteParam(str, new Object[0]);
            if (remoteParam instanceof String) {
                return (String) remoteParam;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m50819a(JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(m50822a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject));
        }
    }

    /* renamed from: b */
    public void m50816b(int i) {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowVisibilityChanged(i);
        }
    }

    /* renamed from: a */
    public void m50818a(JSONObject jSONObject, Map<String, Object> map) {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(m50822a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void mo50442b(String str, int i) {
        m50802r();
    }

    /* renamed from: a */
    public void m50823a(String str, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", "server_bidding");
            jSONObject.put("msg", str);
            IAdInterListener iAdInterListener = this.f8666k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(m50822a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    public JSONObject m50813b(Map<String, String> map) {
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
    /* renamed from: b */
    public void m50812b(JSONObject jSONObject) {
        int i = this.f8671p;
        if (i < 0 || jSONObject == null) {
            return;
        }
        try {
            jSONObject.put(f8656a, i);
        } catch (Throwable th) {
            this.f8664i.m50738a(th);
        }
    }

    /* renamed from: a */
    public void m50821a(String str, boolean z, String str2) {
        m50820a(str, z, str2, null);
    }

    /* renamed from: a */
    public void m50820a(String str, boolean z, String str2, HashMap<String, Object> hashMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("uniqueId", str);
            jSONObject.put(CommonNetImpl.RESULT, z);
            jSONObject.put("replacement", str2);
            if (hashMap != null) {
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    jSONObject.put(String.valueOf(entry.getKey()), entry.getValue());
                }
            }
            IAdInterListener iAdInterListener = this.f8666k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(m50822a("onBiddingResult", jSONObject), (Map<String, Object>) null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m50824a(String str, HashMap<String, Object> hashMap) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_type", str);
            IAdInterListener iAdInterListener = this.f8666k;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(m50822a(IAdInterListener.AdCommandType.NOVEL_EVENT, jSONObject), hashMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m50817a(boolean z) {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowFocusChanged(z);
        }
    }

    /* renamed from: a */
    public boolean m50828a(int i, KeyEvent keyEvent) {
        IAdInterListener iAdInterListener = this.f8666k;
        if (iAdInterListener != null) {
            return iAdInterListener.onKeyDown(i, keyEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo50459a(int i, String str) {
        m50802r();
    }

    /* renamed from: a */
    public static void m50825a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(new RunnableC2622bi(runnable));
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public void mo50471a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f8668m = (HashMap) map;
    }

    /* renamed from: a */
    private String m50822a(String str, JSONObject jSONObject) {
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
