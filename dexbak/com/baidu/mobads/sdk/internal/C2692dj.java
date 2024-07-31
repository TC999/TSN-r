package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.EntryResponse;
import com.baidu.mobads.sdk.api.ExpressResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.XAdEntryResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.C2705f;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.dj */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2692dj extends AbstractC2619bg {

    /* renamed from: A */
    private C2705f.InterfaceC2706a f8982A;

    /* renamed from: B */
    private BaiduNativeManager.ExpressAdListener f8983B;

    /* renamed from: C */
    private BaiduNativeManager.EntryAdListener f8984C;

    /* renamed from: D */
    private C2705f.InterfaceC2707b f8985D;

    /* renamed from: E */
    private int f8986E;

    /* renamed from: a */
    private List<NativeResponse> f8987a;

    /* renamed from: q */
    private List<ExpressResponse> f8988q;

    /* renamed from: r */
    private List<EntryResponse> f8989r;

    /* renamed from: s */
    private int f8990s;

    /* renamed from: t */
    private boolean f8991t;

    /* renamed from: u */
    private String f8992u;

    /* renamed from: v */
    private String f8993v;

    /* renamed from: w */
    private int f8994w;

    /* renamed from: x */
    private int f8995x;

    /* renamed from: y */
    private RequestParameters f8996y;

    /* renamed from: z */
    private boolean f8997z;

    public C2692dj(Context context, String str, String str2, boolean z, int i) {
        super(context);
        this.f8997z = false;
        this.f8986E = 0;
        this.f8993v = str;
        this.f8992u = str2;
        this.f8991t = z;
        this.f8990s = i;
        this.f8994w = 600;
        this.f8995x = 500;
    }

    /* renamed from: a */
    public void m50519a(C2705f.InterfaceC2706a interfaceC2706a) {
        this.f8982A = interfaceC2706a;
    }

    /* renamed from: b */
    public void m50517b(Activity activity) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "bindExpressActivity");
            hashMap.put(TTDownloadField.TT_ACTIVITY, activity);
        } catch (JSONException e) {
            C2634bs.m50744a().m50738a(e);
        }
        m50818a(jSONObject, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b_ */
    public void mo50440b_() {
        C2705f.InterfaceC2706a interfaceC2706a = this.f8982A;
        if (interfaceC2706a != null) {
            interfaceC2706a.mo50400b();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.f8983B;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadSuccess();
        }
    }

    /* renamed from: c */
    public void m50513c(boolean z) {
        this.f8997z = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: c_ */
    public void mo50437c_() {
        C2705f.InterfaceC2706a interfaceC2706a = this.f8982A;
        if (interfaceC2706a != null) {
            interfaceC2706a.mo50397c();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.f8983B;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: d */
    public void mo50436d() {
        C2705f.InterfaceC2706a interfaceC2706a = this.f8982A;
        if (interfaceC2706a != null) {
            interfaceC2706a.mo50405a();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.f8983B;
        if (expressAdListener != null) {
            expressAdListener.onLpClosed();
            return;
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.f8984C;
        if (entryAdListener != null) {
            entryAdListener.onLpClosed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: e */
    public void mo50511e(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i = 0;
        if (this.f8982A != null && !TextUtils.isEmpty(message) && this.f8987a != null) {
            while (i < this.f8987a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f8987a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.f8982A.mo50403a(xAdNativeResponse);
                }
                i++;
            }
        } else if (this.f8983B != null && !TextUtils.isEmpty(message) && this.f8988q != null) {
            while (i < this.f8988q.size()) {
                C2630bp c2630bp = (C2630bp) this.f8988q.get(i);
                if (TextUtils.equals(message, c2630bp.m50774a())) {
                    c2630bp.m50765c();
                }
                i++;
            }
        } else if (this.f8984C == null || TextUtils.isEmpty(message) || this.f8989r == null) {
        } else {
            while (i < this.f8989r.size()) {
                XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f8989r.get(i);
                if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                    xAdEntryResponse.onADExposed();
                }
                i++;
            }
        }
    }

    /* renamed from: f */
    public String m50510f() {
        return this.f8992u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: g */
    public void mo50429g(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.f8983B == null || iOAdEvent == null || this.f8988q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        for (int i = 0; i < this.f8988q.size(); i++) {
            C2630bp c2630bp = (C2630bp) this.f8988q.get(i);
            if (TextUtils.equals(c2630bp.m50774a(), str)) {
                c2630bp.m50770a(c2630bp);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: h */
    public void mo50427h(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i = 0;
        if (this.f8982A != null && !TextUtils.isEmpty(message) && this.f8987a != null) {
            while (i < this.f8987a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f8987a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.f8982A.mo50398b(xAdNativeResponse);
                }
                i++;
            }
        } else if (this.f8983B != null && !TextUtils.isEmpty(message) && this.f8988q != null) {
            while (i < this.f8988q.size()) {
                C2630bp c2630bp = (C2630bp) this.f8988q.get(i);
                if (TextUtils.equals(message, c2630bp.m50774a())) {
                    c2630bp.m50767b();
                }
                i++;
            }
        } else if (this.f8984C == null || TextUtils.isEmpty(message) || this.f8989r == null) {
        } else {
            while (i < this.f8989r.size()) {
                XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f8989r.get(i);
                if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                    xAdEntryResponse.onAdClick();
                }
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: i */
    public void mo50506i(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.f8983B == null || iOAdEvent == null || this.f8988q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int intValue = ((Integer) data.get("viewWidth")).intValue();
        int intValue2 = ((Integer) data.get("viewHeight")).intValue();
        for (int i = 0; i < this.f8988q.size(); i++) {
            C2630bp c2630bp = (C2630bp) this.f8988q.get(i);
            if (TextUtils.equals(c2630bp.m50774a(), str)) {
                c2630bp.m50772a(view, intValue, intValue2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: j */
    public void mo50505j(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.f8983B == null || iOAdEvent == null || this.f8988q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int intValue = ((Integer) data.get("error_code")).intValue();
        String str2 = (String) data.get("error_message");
        for (int i = 0; i < this.f8988q.size(); i++) {
            C2630bp c2630bp = (C2630bp) this.f8988q.get(i);
            if (TextUtils.equals(c2630bp.m50774a(), str)) {
                c2630bp.m50771a(view, str2, intValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: k */
    public void mo50504k(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || this.f8987a == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        for (int i = 0; i < this.f8987a.size(); i++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f8987a.get(i);
            if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str) && TextUtils.equals("dismiss", str2)) {
                xAdNativeResponse.onShakeViewDismiss();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: l */
    public JSONObject mo50423l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.f8990s);
            jSONObject.put("isCacheVideo", this.f8991t);
            jSONObject.put("cacheVideoOnlyWifi", this.f8997z);
            RequestParameters requestParameters = this.f8996y;
            jSONObject.put("appConfirmPolicy", requestParameters == null ? 1 : requestParameters.getAPPConfirmPolicy());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
        if (com.baidu.mobads.sdk.internal.C2635bt.m50723a(r16.f8663h, r9) != false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00fa A[SYNTHETIC] */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo50422q() {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.C2692dj.mo50422q():void");
    }

    /* renamed from: a */
    public void m50522a(BaiduNativeManager.ExpressAdListener expressAdListener) {
        this.f8983B = expressAdListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: c */
    public void mo50515c(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.f8983B == null || iOAdEvent == null || this.f8988q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        for (int i = 0; i < this.f8988q.size(); i++) {
            C2630bp c2630bp = (C2630bp) this.f8988q.get(i);
            if (TextUtils.equals(c2630bp.m50774a(), str)) {
                if (TextUtils.equals(TTLogUtil.TAG_EVENT_SHOW, str2)) {
                    c2630bp.m50764d();
                } else if (TextUtils.equals(CampaignEx.JSON_NATIVE_VIDEO_CLICK, str2)) {
                    Object obj = data.get(MediationConstant.KEY_REASON);
                    c2630bp.m50769a(obj instanceof String ? (String) obj : "");
                } else if (TextUtils.equals("close", str2)) {
                    c2630bp.m50763e();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: f */
    public void mo50509f(IOAdEvent iOAdEvent) {
        if (iOAdEvent == null) {
            return;
        }
        Map<String, Object> data = iOAdEvent.getData();
        int i = 0;
        if (this.f8982A != null && data != null && this.f8987a != null) {
            String str = (String) data.get("instanceInfo");
            while (i < this.f8987a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f8987a.get(i);
                if (xAdNativeResponse != null && xAdNativeResponse.getUniqueId().equals(str)) {
                    this.f8982A.mo50402a(xAdNativeResponse, Integer.parseInt((String) data.get("showState")));
                }
                i++;
            }
        } else if (this.f8984C == null || data == null || this.f8989r == null) {
        } else {
            String str2 = (String) data.get("instanceInfo");
            while (i < this.f8989r.size()) {
                XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f8989r.get(i);
                if (xAdEntryResponse != null && xAdEntryResponse.getUniqueId().equals(str2)) {
                    xAdEntryResponse.onADExposureFailed(Integer.parseInt((String) data.get("showState")));
                }
                i++;
            }
        }
    }

    /* renamed from: a */
    public void m50523a(BaiduNativeManager.EntryAdListener entryAdListener) {
        this.f8984C = entryAdListener;
    }

    /* renamed from: a */
    public void m50518a(C2705f.InterfaceC2707b interfaceC2707b) {
        this.f8985D = interfaceC2707b;
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
        iAdInterListener.loadAd(mo50425k(), mo50423l());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    public void mo50516b(IOAdEvent iOAdEvent) {
        if (this.f8985D == null || iOAdEvent == null || this.f8987a == null) {
            return;
        }
        String message = iOAdEvent.getMessage();
        for (int i = 0; i < this.f8987a.size(); i++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f8987a.get(i);
            if (xAdNativeResponse.getUniqueId().equals(message)) {
                this.f8985D.mo50396a(xAdNativeResponse);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: d */
    public void mo50512d(String str) {
        if (!TextUtils.isEmpty(str) && this.f8987a != null) {
            for (int i = 0; i < this.f8987a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f8987a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdUnionClick();
                }
            }
        }
        if (!TextUtils.isEmpty(str) && this.f8988q != null) {
            for (int i2 = 0; i2 < this.f8988q.size(); i2++) {
                C2630bp c2630bp = (C2630bp) this.f8988q.get(i2);
                if (TextUtils.equals(str, c2630bp.m50774a())) {
                    c2630bp.m50762f();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f8989r == null) {
            return;
        }
        for (int i3 = 0; i3 < this.f8989r.size(); i3++) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f8989r.get(i3);
            if (TextUtils.equals(str, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdUnionClick();
            }
        }
    }

    /* renamed from: g */
    public RequestParameters m50508g() {
        return this.f8996y;
    }

    /* renamed from: a */
    public void m50521a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.f8994w = width;
            this.f8995x = height;
        }
        this.f8996y = requestParameters;
        mo50471a(requestParameters.getExtras());
        m50514c(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: k */
    public JSONObject mo50425k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.f8992u);
            this.f8666k.createProdHandler(jSONObject2);
            this.f8666k.setAdContainer(this.f8662g);
            m50805n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.f8992u);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.f8993v);
            if (C2670cp.m50608a().m50601b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.f8670o)) {
                jSONObject.put("appid", this.f8670o);
            }
            if ("video".equals(this.f8992u)) {
                jSONObject.put("at", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ);
                jSONObject.put(IAdInterListener.AdReqParam.MIME_TYPE, "video/mp4,image/jpg,image/gif,image/png");
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,NMON");
            } else {
                jSONObject.put("at", "2");
            }
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.f8994w);
            jSONObject.put("h", "" + this.f8995x);
            jSONObject.put("msa", TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE);
            jSONObject = C2714k.m50362a(jSONObject, m50813b(this.f8668m));
            jSONObject.put("opt", this.f8986E);
            if (this.f8986E == 0) {
                jSONObject.put("optn", 1);
            }
            m50812b(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    public void mo50442b(String str, int i) {
        C2705f.InterfaceC2706a interfaceC2706a = this.f8982A;
        if (interfaceC2706a != null) {
            interfaceC2706a.mo50399b(i, str);
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.f8983B;
        if (expressAdListener != null) {
            expressAdListener.onNativeFail(i, str);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.f8984C;
        if (entryAdListener != null) {
            entryAdListener.onNativeFail(i, str);
        }
    }

    /* renamed from: a */
    public void m50526a(int i) {
        this.f8986E = i;
    }

    /* renamed from: a */
    public ViewGroup m50520a(C2573a c2573a) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "initExpressContainer");
            jSONObject.put("uniqueId", c2573a.m51122H());
        } catch (JSONException e) {
            C2634bs.m50744a().m50738a(e);
        }
        m50818a(jSONObject, hashMap);
        Object obj = hashMap.get("container");
        if (obj instanceof ViewGroup) {
            return (ViewGroup) obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: e */
    public void mo50433e(String str) {
        if (!TextUtils.isEmpty(str) && this.f8987a != null) {
            for (int i = 0; i < this.f8987a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f8987a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPrivacyClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f8988q == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f8988q.size(); i2++) {
            C2630bp c2630bp = (C2630bp) this.f8988q.get(i2);
            if (TextUtils.equals(str, c2630bp.m50774a())) {
                c2630bp.m50761g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: f */
    public void mo50431f(String str) {
        if (!TextUtils.isEmpty(str) && this.f8987a != null) {
            for (int i = 0; i < this.f8987a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f8987a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADFunctionClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f8988q == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f8988q.size(); i2++) {
            C2630bp c2630bp = (C2630bp) this.f8988q.get(i2);
            if (TextUtils.equals(str, c2630bp.m50774a())) {
                c2630bp.m50760h();
            }
        }
    }

    /* renamed from: h */
    public String m50507h() {
        return this.f8993v;
    }

    /* renamed from: c */
    public void m50514c(Map<String, String> map) {
        try {
            HashMap<String, String> m50365a = C2714k.m50365a(map);
            if (this.f8668m == null) {
                this.f8668m = new HashMap<>();
            }
            if (m50365a.isEmpty()) {
                return;
            }
            for (String str : m50365a.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    String str2 = m50365a.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        this.f8668m.put(str, str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    public void mo50441b(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.f8987a != null) {
            for (int i = 0; i < this.f8987a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f8987a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdDownloadWindow(z);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f8988q == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f8988q.size(); i2++) {
            C2630bp c2630bp = (C2630bp) this.f8988q.get(i2);
            if (TextUtils.equals(str, c2630bp.m50774a())) {
                c2630bp.m50766b(z);
            }
        }
    }

    /* renamed from: a */
    public void m50524a(ViewGroup viewGroup, C2573a c2573a) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "renderExpressView");
            jSONObject.put("uniqueId", c2573a.m51122H());
            hashMap.put("container", viewGroup);
        } catch (JSONException e) {
            C2634bs.m50744a().m50738a(e);
        }
        m50818a(jSONObject, hashMap);
    }

    /* renamed from: a */
    public boolean m50525a(View view, C2573a c2573a, int i) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "switchTheme");
            hashMap.put(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, view);
            hashMap.put("code", Integer.valueOf(i));
        } catch (JSONException e) {
            C2634bs.m50744a().m50738a(e);
        }
        m50818a(jSONObject, hashMap);
        Object obj = hashMap.get(CommonNetImpl.RESULT);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50459a(int i, String str) {
        C2705f.InterfaceC2706a interfaceC2706a = this.f8982A;
        if (interfaceC2706a != null) {
            interfaceC2706a.mo50404a(i, str);
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.f8983B;
        if (expressAdListener != null) {
            expressAdListener.onNoAd(i, str);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.f8984C;
        if (entryAdListener != null) {
            entryAdListener.onNoAd(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50447a(String str, boolean z) {
        if (!TextUtils.isEmpty(str) && this.f8987a != null) {
            for (int i = 0; i < this.f8987a.size(); i++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f8987a.get(i);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPermissionShow(z);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f8988q == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f8988q.size(); i2++) {
            C2630bp c2630bp = (C2630bp) this.f8988q.get(i2);
            if (TextUtils.equals(str, c2630bp.m50774a())) {
                c2630bp.m50768a(z);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50471a(Map<String, String> map) {
        String[] strArr;
        int length;
        if (map == null || map.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap(map);
        HashMap<String, String> hashMap2 = new HashMap<>();
        int i = 0;
        for (String str : ArticleInfo.PREDEFINED_KEYS) {
            if (hashMap.containsKey(str)) {
                String str2 = (String) hashMap.remove(str);
                if (!TextUtils.isEmpty(str2) && (length = str2.length() + i) < 150) {
                    hashMap2.put(str, str2);
                    i = length;
                }
            }
        }
        if (!hashMap.isEmpty()) {
            for (String str3 : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = (String) hashMap.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        int length2 = i + str3.length() + str4.length();
                        if (length2 >= 150) {
                            break;
                        }
                        hashMap2.put("c_" + str3, str4);
                        i = length2 + 2;
                    } else {
                        continue;
                    }
                }
            }
        }
        this.f8668m = hashMap2;
    }
}
