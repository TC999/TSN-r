package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.NativeCPUAdData;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ae extends bj {

    /* renamed from: a  reason: collision with root package name */
    public static final int f12333a = 17;

    /* renamed from: q  reason: collision with root package name */
    private static final String f12334q = "javascript:";
    private int A;
    private boolean B;
    private String C;

    /* renamed from: r  reason: collision with root package name */
    private int f12335r;

    /* renamed from: s  reason: collision with root package name */
    private int f12336s;

    /* renamed from: t  reason: collision with root package name */
    private int[] f12337t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f12338u;

    /* renamed from: v  reason: collision with root package name */
    private int f12339v;

    /* renamed from: w  reason: collision with root package name */
    private HashMap<String, Object> f12340w;

    /* renamed from: x  reason: collision with root package name */
    private NativeCPUManager.CPUAdListener f12341x;

    /* renamed from: y  reason: collision with root package name */
    private NativeCPUManager f12342y;

    /* renamed from: z  reason: collision with root package name */
    private int f12343z;

    public ae(Context context) {
        super(context);
        this.f12343z = 5;
        this.A = 60;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("adInnerPageInterval");
            Object obj2 = map.get("adBottomRefreshInterval");
            Object obj3 = map.get("adFrontChapterInterval");
            Object obj4 = map.get("isShowFeeds");
            Object obj5 = map.get("isAdSwitch");
            Object obj6 = map.get("showCount");
            Object obj7 = map.get("clickCount");
            if (obj != null && obj2 != null) {
                ao.a(((Integer) obj).intValue());
                ao.b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                ao.a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                ao.a(((Integer) obj5).intValue() != 0);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                ao.a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
        }
    }

    private String j(String str) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        ao.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b_() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.f12341x;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void c_() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.f12341x;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void d() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.f12341x;
        if (cPUAdListener != null) {
            cPUAdListener.onExitLp();
        }
    }

    public void f() {
        ao.a(this.f12343z);
        ao.b(this.A);
        ao.a(new aj(this));
    }

    public Activity g() {
        return ao.c();
    }

    public boolean h() {
        return ao.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i4) {
        super.b(str, i4);
        NativeCPUManager.CPUAdListener cPUAdListener = this.f12341x;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i4);
        }
    }

    public void a(NativeCPUManager.CPUAdListener cPUAdListener) {
        this.f12341x = cPUAdListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void d(IOAdEvent iOAdEvent) {
        try {
            if (this.f12341x == null || iOAdEvent == null) {
                return;
            }
            HashMap<String, Object> hashMap = (HashMap) iOAdEvent.getData();
            this.f12341x.onLpCustomEventCallBack(hashMap, new ah(this, hashMap.get("activity")));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ae(Context context, String str, NativeCPUManager nativeCPUManager) {
        super(context);
        this.f12343z = 5;
        this.A = 60;
        this.f12488o = str;
        this.f12342y = nativeCPUManager;
    }

    public void a(int i4, int i5, int[] iArr, boolean z3, HashMap<String, Object> hashMap) {
        this.f12336s = i4;
        this.f12335r = i5;
        this.f12337t = iArr;
        this.f12338u = z3;
        this.f12340w = hashMap;
        this.B = ao.f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(IOAdEvent iOAdEvent) {
        notifyObservers(iOAdEvent);
        setChanged();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.f12484k == null) {
            this.f12485l = false;
            return;
        }
        this.f12485l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("prod", "cpu");
            this.f12484k.createProdHandler(jSONObject3);
            n();
            this.f12484k.addEventListener("Update_fbReader_Setting", new af(this));
            this.f12484k.addEventListener("closeInterstitialAd", new ag(this));
            jSONObject.put("prod", "cpu");
            jSONObject.put("appsid", this.f12488o);
            jSONObject.put("pageIndex", this.f12336s);
            jSONObject.put("pageSize", this.f12335r);
            jSONObject.put("channels", this.f12337t);
            jSONObject.put("showAd", this.f12338u);
            jSONObject.put("openActivitylink", this.C);
            if (!TextUtils.isEmpty(this.f12488o)) {
                jSONObject.put("appid", this.f12488o);
            }
            jSONObject2.put("timeout", this.f12339v);
            HashMap<String, Object> hashMap = this.f12340w;
            if (hashMap == null || hashMap.isEmpty()) {
                az.c().e("\u5185\u5bb9\u8054\u76df\u5143\u7d20\u9700\u8981\u4f20\u5165 CPUAdRequest\u914d\u7f6e\u4fe1\u606f");
            }
            jSONObject2 = k.a(this.f12340w);
            if (jSONObject2 != null) {
                jSONObject2.put("isInitNovelSDK", this.B);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f12484k.loadAd(jSONObject, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void c(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            Map<String, Object> data = iOAdEvent.getData();
            Integer num = (Integer) data.get("position");
            String str = (String) data.get("mislikereason");
            NativeCPUManager.CPUAdListener cPUAdListener = this.f12341x;
            if (cPUAdListener == null || num == null || str == null) {
                return;
            }
            cPUAdListener.onDisLikeAdClick(num.intValue(), str);
        }
    }

    public void a(int i4) {
        this.f12339v = i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
        if (this.f12341x != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : (List) iOAdEvent.getData().get("cpuAdList")) {
                NativeCPUAdData nativeCPUAdData = new NativeCPUAdData(this.f12481h, obj, this.f12340w);
                arrayList.add(nativeCPUAdData);
                addObserver(nativeCPUAdData);
            }
            this.f12341x.onAdLoaded(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(int i4, String str) {
        super.a(i4, str);
        NativeCPUManager.CPUAdListener cPUAdListener = this.f12341x;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(WebView webView, JSONObject jSONObject) {
        bj.a(new ai(this, jSONObject, webView));
    }

    public void a(String str) {
        this.C = str;
    }
}
