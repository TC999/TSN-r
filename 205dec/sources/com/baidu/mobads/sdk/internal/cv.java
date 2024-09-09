package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.CPUWebAdRequestParam;
import com.baidu.mobads.sdk.api.CpuAdView;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class cv extends bj {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, Object> f12725a;

    /* renamed from: q  reason: collision with root package name */
    private int f12726q;

    /* renamed from: r  reason: collision with root package name */
    private RelativeLayout f12727r;

    /* renamed from: s  reason: collision with root package name */
    private CpuAdView.CpuAdViewInternalStatusListener f12728s;

    public cv(Context context, RelativeLayout relativeLayout, String str, int i4, CPUWebAdRequestParam cPUWebAdRequestParam) {
        super(context);
        this.f12488o = str;
        this.f12727r = relativeLayout;
        this.f12726q = i4;
        if (cPUWebAdRequestParam == null) {
            az.c().e("\u5185\u5bb9\u8054\u76df\u6a21\u677f\u9700\u8981\u4f20\u5165 CPUWebAdRequestParam\u914d\u7f6e\u4fe1\u606f");
        } else {
            this.f12725a = (HashMap) cPUWebAdRequestParam.getParameters();
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        ao.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i4) {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f12728s;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.loadDataError(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void d() {
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f12728s;
        if (cpuAdViewInternalStatusListener != null) {
            cpuAdViewInternalStatusListener.onExitLp();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(IOAdEvent iOAdEvent) {
        Map<String, Object> data = iOAdEvent.getData();
        Boolean bool = (Boolean) data.get("isImpressionFeAd");
        String str = (String) data.get("nums");
        if (this.f12728s != null && bool != null && bool.booleanValue()) {
            this.f12728s.onAdImpression(str);
            return;
        }
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f12728s;
        if (cpuAdViewInternalStatusListener == null || bool == null) {
            return;
        }
        cpuAdViewInternalStatusListener.onContentImpression(str);
    }

    public Activity f() {
        return ao.c();
    }

    public boolean g() {
        return ao.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        Boolean bool = (Boolean) iOAdEvent.getData().get("isClickFeAd");
        if (this.f12728s != null && bool != null && bool.booleanValue()) {
            this.f12728s.onAdClick();
            return;
        }
        CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener = this.f12728s;
        if (cpuAdViewInternalStatusListener == null || bool == null) {
            return;
        }
        cpuAdViewInternalStatusListener.onContentClick();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void d(IOAdEvent iOAdEvent) {
        if (this.f12728s == null || iOAdEvent == null) {
            return;
        }
        this.f12728s.onLpContentStatus(iOAdEvent.getData());
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.f12484k == null) {
            this.f12485l = false;
            return;
        }
        this.f12485l = true;
        JSONObject jSONObject = new JSONObject();
        if (this.f12484k != null) {
            try {
                jSONObject.put("channel", this.f12726q);
                jSONObject.put("prod", "cpu_h5");
                jSONObject.put("timeout", 10000);
                if (!TextUtils.isEmpty(this.f12488o)) {
                    jSONObject.put("appid", this.f12488o);
                }
                if (this.f12727r != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("prod", "cpu_h5");
                    this.f12484k.createProdHandler(jSONObject2);
                    this.f12484k.setAdContainer(this.f12727r);
                    n();
                    this.f12484k.addEventListener("Update_fbReader_Setting", new cw(this));
                    this.f12484k.addEventListener("closeInterstitialAd", new cx(this));
                    this.f12484k.addEventListener("feOpenFbReader", new cy(this));
                    JSONObject a4 = k.a(this.f12725a);
                    a4.put("isInitNovelSDK", ao.f());
                    this.f12484k.loadAd(jSONObject, a4);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4, int i5, String str, int i6, int i7, String str2) {
        ao.a(i4);
        ao.b(i5);
        ao.a(new cz(this, i6, i7, str2));
        ao.a(this.f12481h, str);
    }

    public void a(CpuAdView.CpuAdViewInternalStatusListener cpuAdViewInternalStatusListener) {
        this.f12728s = cpuAdViewInternalStatusListener;
    }
}
