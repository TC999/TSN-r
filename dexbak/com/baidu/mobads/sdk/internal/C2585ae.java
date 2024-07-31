package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.NativeCPUAdData;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.ae */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2585ae extends AbstractC2619bg {

    /* renamed from: a */
    public static final int f8537a = 17;

    /* renamed from: q */
    private static final String f8538q = "javascript:";

    /* renamed from: A */
    private int f8539A;

    /* renamed from: B */
    private boolean f8540B;

    /* renamed from: C */
    private String f8541C;

    /* renamed from: r */
    private int f8542r;

    /* renamed from: s */
    private int f8543s;

    /* renamed from: t */
    private int[] f8544t;

    /* renamed from: u */
    private boolean f8545u;

    /* renamed from: v */
    private int f8546v;

    /* renamed from: w */
    private HashMap<String, Object> f8547w;

    /* renamed from: x */
    private NativeCPUManager.CPUAdListener f8548x;

    /* renamed from: y */
    private NativeCPUManager f8549y;

    /* renamed from: z */
    private int f8550z;

    public C2585ae(Context context) {
        super(context);
        this.f8550z = 5;
        this.f8539A = 60;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m51032c(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("adInnerPageInterval");
            Object obj2 = map.get("adBottomRefreshInterval");
            Object obj3 = map.get("adFrontChapterInterval");
            Object obj4 = map.get("isShowFeeds");
            Object obj5 = map.get("isAdSwitch");
            Object obj6 = map.get("showCount");
            Object obj7 = map.get("clickCount");
            if (obj != null && obj2 != null) {
                C2598ao.m50994a(((Integer) obj).intValue());
                C2598ao.m50983b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                C2598ao.m50992a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                C2598ao.m50986a(((Integer) obj5).intValue() != 0);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                C2598ao.m50993a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
        }
    }

    /* renamed from: j */
    private String m51028j(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void m51027x() {
        C2598ao.m50984b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b_ */
    public void mo50440b_() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.f8548x;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: c_ */
    public void mo50437c_() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.f8548x;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: d */
    public void mo50436d() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.f8548x;
        if (cPUAdListener != null) {
            cPUAdListener.onExitLp();
        }
    }

    /* renamed from: f */
    public void m51031f() {
        C2598ao.m50994a(this.f8550z);
        C2598ao.m50983b(this.f8539A);
        C2598ao.m50988a(new C2590aj(this));
    }

    /* renamed from: g */
    public Activity m51030g() {
        return C2598ao.m50981c();
    }

    /* renamed from: h */
    public boolean m51029h() {
        return C2598ao.m50980d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    public void mo50442b(String str, int i) {
        super.mo50442b(str, i);
        NativeCPUManager.CPUAdListener cPUAdListener = this.f8548x;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i);
        }
    }

    /* renamed from: a */
    public void m51037a(NativeCPUManager.CPUAdListener cPUAdListener) {
        this.f8548x = cPUAdListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: d */
    public void mo50580d(IOAdEvent iOAdEvent) {
        try {
            if (this.f8548x == null || iOAdEvent == null) {
                return;
            }
            HashMap<String, Object> hashMap = (HashMap) iOAdEvent.getData();
            this.f8548x.onLpCustomEventCallBack(hashMap, new C2588ah(this, hashMap.get(TTDownloadField.TT_ACTIVITY)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public C2585ae(Context context, String str, NativeCPUManager nativeCPUManager) {
        super(context);
        this.f8550z = 5;
        this.f8539A = 60;
        this.f8670o = str;
        this.f8549y = nativeCPUManager;
    }

    /* renamed from: a */
    public void m51039a(int i, int i2, int[] iArr, boolean z, HashMap<String, Object> hashMap) {
        this.f8543s = i;
        this.f8542r = i2;
        this.f8544t = iArr;
        this.f8545u = z;
        this.f8547w = hashMap;
        this.f8540B = C2598ao.m50978f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    public void mo50516b(IOAdEvent iOAdEvent) {
        notifyObservers(iOAdEvent);
        setChanged();
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50356a() {
        if (this.f8666k == null) {
            this.f8667l = false;
            return;
        }
        this.f8667l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, "cpu");
            this.f8666k.createProdHandler(jSONObject3);
            m50805n();
            this.f8666k.addEventListener("Update_fbReader_Setting", new C2586af(this));
            this.f8666k.addEventListener("closeInterstitialAd", new C2587ag(this));
            jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu");
            jSONObject.put("appsid", this.f8670o);
            jSONObject.put("pageIndex", this.f8543s);
            jSONObject.put("pageSize", this.f8542r);
            jSONObject.put("channels", this.f8544t);
            jSONObject.put("showAd", this.f8545u);
            jSONObject.put("openActivitylink", this.f8541C);
            if (!TextUtils.isEmpty(this.f8670o)) {
                jSONObject.put("appid", this.f8670o);
            }
            jSONObject2.put("timeout", this.f8546v);
            HashMap<String, Object> hashMap = this.f8547w;
            if (hashMap == null || hashMap.isEmpty()) {
                C2607aw.m50919c().mo50864e("内容联盟元素需要传入 CPUAdRequest配置信息");
            }
            jSONObject2 = C2714k.m50367a(this.f8547w);
            if (jSONObject2 != null) {
                jSONObject2.put("isInitNovelSDK", this.f8540B);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f8666k.loadAd(jSONObject, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: c */
    public void mo50515c(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            Map<String, Object> data = iOAdEvent.getData();
            Integer num = (Integer) data.get("position");
            String str = (String) data.get("mislikereason");
            NativeCPUManager.CPUAdListener cPUAdListener = this.f8548x;
            if (cPUAdListener == null || num == null || str == null) {
                return;
            }
            cPUAdListener.onDisLikeAdClick(num.intValue(), str);
        }
    }

    /* renamed from: a */
    public void m51040a(int i) {
        this.f8546v = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50455a(IOAdEvent iOAdEvent) {
        if (this.f8548x != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : (List) iOAdEvent.getData().get("cpuAdList")) {
                NativeCPUAdData nativeCPUAdData = new NativeCPUAdData(this.f8663h, obj, this.f8547w);
                arrayList.add(nativeCPUAdData);
                addObserver(nativeCPUAdData);
            }
            this.f8548x.onAdLoaded(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50459a(int i, String str) {
        super.mo50459a(i, str);
        NativeCPUManager.CPUAdListener cPUAdListener = this.f8548x;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m51038a(WebView webView, JSONObject jSONObject) {
        AbstractC2619bg.m50825a(new RunnableC2589ai(this, jSONObject, webView));
    }

    /* renamed from: a */
    public void m51034a(String str) {
        this.f8541C = str;
    }
}
