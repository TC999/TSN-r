package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.CpuAdView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.clj.fastble.BleManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.cs */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2674cs extends AbstractC2619bg {

    /* renamed from: a */
    private HashMap<String, Object> f8905a;

    /* renamed from: q */
    private int f8906q;

    /* renamed from: r */
    private RelativeLayout f8907r;

    /* renamed from: s */
    private CpuAdView.CpuAdViewInternalStatusListener f8908s;

    public C2674cs(Context context, RelativeLayout relativeLayout, String str, int i, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        this.f8670o = str;
        this.f8907r = relativeLayout;
        this.f8906q = i;
        if (cPUWebAdRequestParam == null) {
            C2607aw.m50919c().mo50864e("内容联盟模板需要传入 CPUWebAdRequestParam配置信息");
        } else {
            this.f8905a = (HashMap) cPUWebAdRequestParam.getParameters();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m50581c(Map<String, Object> map) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m50577h() {
        C2598ao.m50984b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    public void mo50442b(String str, int i) {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f8908s;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.loadDataError(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: d */
    public void mo50436d() {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f8908s;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.onExitLp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: e */
    public void mo50511e(IOAdEvent iOAdEvent) {
        Map<String, Object> data = iOAdEvent.getData();
        Boolean bool = (Boolean) data.get("isImpressionFeAd");
        String str = (String) data.get("nums");
        if (this.f8908s != null && bool != null && bool.booleanValue()) {
            this.f8908s.onAdImpression(str);
            return;
        }
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f8908s;
        if (cpuAdViewInternalStatusListener == null || bool == null) {
            return;
        }
        cpuAdViewInternalStatusListener.onContentImpression(str);
    }

    /* renamed from: f */
    public Activity m50579f() {
        return C2598ao.m50981c();
    }

    /* renamed from: g */
    public boolean m50578g() {
        return C2598ao.m50980d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: h */
    public void mo50427h(IOAdEvent iOAdEvent) {
        Boolean bool = (Boolean) iOAdEvent.getData().get("isClickFeAd");
        if (this.f8908s != null && bool != null && bool.booleanValue()) {
            this.f8908s.onAdClick();
            return;
        }
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f8908s;
        if (cpuAdViewInternalStatusListener == null || bool == null) {
            return;
        }
        cpuAdViewInternalStatusListener.onContentClick();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: d */
    public void mo50580d(IOAdEvent iOAdEvent) {
        if (this.f8908s == null || iOAdEvent == null) {
            return;
        }
        this.f8908s.onLpContentStatus(iOAdEvent.getData());
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
        if (this.f8666k != null) {
            try {
                jSONObject.put("channel", this.f8906q);
                jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_h5");
                jSONObject.put("timeout", BleManager.f22896l);
                if (!TextUtils.isEmpty(this.f8670o)) {
                    jSONObject.put("appid", this.f8670o);
                }
                if (this.f8907r != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(IAdInterListener.AdReqParam.PROD, "cpu_h5");
                    this.f8666k.createProdHandler(jSONObject2);
                    this.f8666k.setAdContainer(this.f8907r);
                    m50805n();
                    this.f8666k.addEventListener("Update_fbReader_Setting", new C2675ct(this));
                    this.f8666k.addEventListener("closeInterstitialAd", new C2676cu(this));
                    this.f8666k.addEventListener("feOpenFbReader", new C2677cv(this));
                    JSONObject m50367a = C2714k.m50367a(this.f8905a);
                    m50367a.put("isInitNovelSDK", C2598ao.m50978f());
                    this.f8666k.loadAd(jSONObject, m50367a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m50586a(int i, int i2, String str, int i3, int i4, String str2) {
        C2598ao.m50994a(i);
        C2598ao.m50983b(i2);
        C2598ao.m50988a(new C2678cw(this, i3, i4, str2));
        C2598ao.m50990a(this.f8663h, str);
    }

    /* renamed from: a */
    public void m50585a(CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        this.f8908s = cpuAdViewInternalStatusListener;
    }
}
