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
import com.baidu.mobads.sdk.internal.f;
import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class dm extends bj {
    private f.a A;
    private BaiduNativeManager.ExpressAdListener B;
    private BaiduNativeManager.EntryAdListener C;
    private f.b D;
    private int E;

    /* renamed from: a  reason: collision with root package name */
    private List<NativeResponse> f12788a;

    /* renamed from: q  reason: collision with root package name */
    private List<ExpressResponse> f12789q;

    /* renamed from: r  reason: collision with root package name */
    private List<EntryResponse> f12790r;

    /* renamed from: s  reason: collision with root package name */
    private int f12791s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f12792t;

    /* renamed from: u  reason: collision with root package name */
    private String f12793u;

    /* renamed from: v  reason: collision with root package name */
    private String f12794v;

    /* renamed from: w  reason: collision with root package name */
    private int f12795w;

    /* renamed from: x  reason: collision with root package name */
    private int f12796x;

    /* renamed from: y  reason: collision with root package name */
    private RequestParameters f12797y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f12798z;

    public dm(Context context, String str, String str2, boolean z3, int i4) {
        super(context);
        this.f12798z = false;
        this.E = 0;
        this.f12794v = str;
        this.f12793u = str2;
        this.f12792t = z3;
        this.f12791s = i4;
        this.f12795w = 600;
        this.f12796x = 500;
    }

    public void a(f.a aVar) {
        this.A = aVar;
    }

    public void b(Activity activity) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "bindExpressActivity");
            hashMap.put("activity", activity);
        } catch (JSONException e4) {
            bv.a().a(e4);
        }
        a(jSONObject, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b_() {
        f.a aVar = this.A;
        if (aVar != null) {
            aVar.b();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadSuccess();
        }
    }

    public void c(boolean z3) {
        this.f12798z = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void c_() {
        f.a aVar = this.A;
        if (aVar != null) {
            aVar.c();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onVideoDownloadFailed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void d() {
        f.a aVar = this.A;
        if (aVar != null) {
            aVar.a();
            return;
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onLpClosed();
            return;
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onLpClosed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i4 = 0;
        if (this.A != null && !TextUtils.isEmpty(message) && this.f12788a != null) {
            while (i4 < this.f12788a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f12788a.get(i4);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.A.a(xAdNativeResponse);
                }
                i4++;
            }
        } else if (this.B != null && !TextUtils.isEmpty(message) && this.f12789q != null) {
            while (i4 < this.f12789q.size()) {
                bs bsVar = (bs) this.f12789q.get(i4);
                if (TextUtils.equals(message, bsVar.a())) {
                    bsVar.c();
                }
                i4++;
            }
        } else if (this.C == null || TextUtils.isEmpty(message) || this.f12790r == null) {
        } else {
            while (i4 < this.f12790r.size()) {
                XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f12790r.get(i4);
                if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                    xAdEntryResponse.onADExposed();
                }
                i4++;
            }
        }
    }

    public String f() {
        return this.f12793u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void g(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.f12789q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        for (int i4 = 0; i4 < this.f12789q.size(); i4++) {
            bs bsVar = (bs) this.f12789q.get(i4);
            if (TextUtils.equals(bsVar.a(), str)) {
                bsVar.a(bsVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        String message = iOAdEvent.getMessage();
        int i4 = 0;
        if (this.A != null && !TextUtils.isEmpty(message) && this.f12788a != null) {
            while (i4 < this.f12788a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f12788a.get(i4);
                if (xAdNativeResponse.getUniqueId().equals(message)) {
                    this.A.b(xAdNativeResponse);
                }
                i4++;
            }
        } else if (this.B != null && !TextUtils.isEmpty(message) && this.f12789q != null) {
            while (i4 < this.f12789q.size()) {
                bs bsVar = (bs) this.f12789q.get(i4);
                if (TextUtils.equals(message, bsVar.a())) {
                    bsVar.b();
                }
                i4++;
            }
        } else if (this.C == null || TextUtils.isEmpty(message) || this.f12790r == null) {
        } else {
            while (i4 < this.f12790r.size()) {
                XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f12790r.get(i4);
                if (TextUtils.equals(message, xAdEntryResponse.getUniqueId())) {
                    xAdEntryResponse.onAdClick();
                }
                i4++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void i(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.f12789q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int intValue = ((Integer) data.get("viewWidth")).intValue();
        int intValue2 = ((Integer) data.get("viewHeight")).intValue();
        for (int i4 = 0; i4 < this.f12789q.size(); i4++) {
            bs bsVar = (bs) this.f12789q.get(i4);
            if (TextUtils.equals(bsVar.a(), str)) {
                bsVar.a(view, intValue, intValue2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void j(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.f12789q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        View view = (View) data.get("expressView");
        int intValue = ((Integer) data.get("error_code")).intValue();
        String str2 = (String) data.get("error_message");
        for (int i4 = 0; i4 < this.f12789q.size(); i4++) {
            bs bsVar = (bs) this.f12789q.get(i4);
            if (TextUtils.equals(bsVar.a(), str)) {
                bsVar.a(view, str2, intValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void k(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (iOAdEvent == null || this.f12788a == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        for (int i4 = 0; i4 < this.f12788a.size(); i4++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f12788a.get(i4);
            if (TextUtils.equals(xAdNativeResponse.getUniqueId(), str)) {
                if (TextUtils.equals("dismiss", str2)) {
                    xAdNativeResponse.onShakeViewDismiss();
                } else if (TextUtils.equals("coupon_float_dismiss", str2)) {
                    xAdNativeResponse.onCouponFloatDismiss();
                }
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.f12791s);
            jSONObject.put("isCacheVideo", this.f12792t);
            jSONObject.put("cacheVideoOnlyWifi", this.f12798z);
            RequestParameters requestParameters = this.f12797y;
            jSONObject.put("appConfirmPolicy", requestParameters == null ? 1 : requestParameters.getAPPConfirmPolicy());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
        if (com.baidu.mobads.sdk.internal.bw.a(r16.f12481h, r9) != false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00fa A[SYNTHETIC] */
    @Override // com.baidu.mobads.sdk.internal.bj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void q() {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.dm.q():void");
    }

    public void a(BaiduNativeManager.ExpressAdListener expressAdListener) {
        this.B = expressAdListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void c(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.B == null || iOAdEvent == null || this.f12789q == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        String str = (String) data.get("uniqueId");
        String str2 = (String) data.get("type");
        for (int i4 = 0; i4 < this.f12789q.size(); i4++) {
            bs bsVar = (bs) this.f12789q.get(i4);
            if (TextUtils.equals(bsVar.a(), str)) {
                if (TextUtils.equals("show", str2)) {
                    bsVar.d();
                } else if (TextUtils.equals("click", str2)) {
                    Object obj = data.get("reason");
                    bsVar.a(obj instanceof String ? (String) obj : "");
                } else if (TextUtils.equals("close", str2)) {
                    bsVar.e();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void f(IOAdEvent iOAdEvent) {
        if (iOAdEvent == null) {
            return;
        }
        Map<String, Object> data = iOAdEvent.getData();
        int i4 = 0;
        if (this.A != null && data != null && this.f12788a != null) {
            String str = (String) data.get("instanceInfo");
            while (i4 < this.f12788a.size()) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f12788a.get(i4);
                if (xAdNativeResponse != null && xAdNativeResponse.getUniqueId().equals(str)) {
                    this.A.a(xAdNativeResponse, Integer.parseInt((String) data.get("showState")));
                }
                i4++;
            }
        } else if (this.C == null || data == null || this.f12790r == null) {
        } else {
            String str2 = (String) data.get("instanceInfo");
            while (i4 < this.f12790r.size()) {
                XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f12790r.get(i4);
                if (xAdEntryResponse != null && xAdEntryResponse.getUniqueId().equals(str2)) {
                    xAdEntryResponse.onADExposureFailed(Integer.parseInt((String) data.get("showState")));
                }
                i4++;
            }
        }
    }

    public void a(BaiduNativeManager.EntryAdListener entryAdListener) {
        this.C = entryAdListener;
    }

    public void a(f.b bVar) {
        this.D = bVar;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        IAdInterListener iAdInterListener = this.f12484k;
        if (iAdInterListener == null) {
            this.f12485l = false;
            return;
        }
        this.f12485l = true;
        iAdInterListener.loadAd(k(), l());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(IOAdEvent iOAdEvent) {
        if (this.D == null || iOAdEvent == null || this.f12788a == null) {
            return;
        }
        String message = iOAdEvent.getMessage();
        for (int i4 = 0; i4 < this.f12788a.size(); i4++) {
            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f12788a.get(i4);
            if (xAdNativeResponse.getUniqueId().equals(message)) {
                this.D.a(xAdNativeResponse);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void d(String str) {
        if (!TextUtils.isEmpty(str) && this.f12788a != null) {
            for (int i4 = 0; i4 < this.f12788a.size(); i4++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f12788a.get(i4);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdUnionClick();
                }
            }
        }
        if (!TextUtils.isEmpty(str) && this.f12789q != null) {
            for (int i5 = 0; i5 < this.f12789q.size(); i5++) {
                bs bsVar = (bs) this.f12789q.get(i5);
                if (TextUtils.equals(str, bsVar.a())) {
                    bsVar.f();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f12790r == null) {
            return;
        }
        for (int i6 = 0; i6 < this.f12790r.size(); i6++) {
            XAdEntryResponse xAdEntryResponse = (XAdEntryResponse) this.f12790r.get(i6);
            if (TextUtils.equals(str, xAdEntryResponse.getUniqueId())) {
                xAdEntryResponse.onAdUnionClick();
            }
        }
    }

    public RequestParameters g() {
        return this.f12797y;
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.f12795w = width;
            this.f12796x = height;
        }
        this.f12797y = requestParameters;
        a(requestParameters.getExtras());
        c(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("prod", this.f12793u);
            this.f12484k.createProdHandler(jSONObject2);
            this.f12484k.setAdContainer(this.f12480g);
            n();
            jSONObject.put("prod", this.f12793u);
            jSONObject.put("apid", this.f12794v);
            if (cs.a().b()) {
                jSONObject.put("fet", "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put("fet", "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.f12488o)) {
                jSONObject.put("appid", this.f12488o);
            }
            if ("video".equals(this.f12793u)) {
                jSONObject.put("at", "10");
                jSONObject.put("mimetype", "video/mp4,image/jpg,image/gif,image/png");
                jSONObject.put("fet", "ANTI,HTML,MSSP,VIDEO,NMON");
            } else {
                jSONObject.put("at", "2");
            }
            jSONObject.put("w", "" + this.f12795w);
            jSONObject.put("h", "" + this.f12796x);
            jSONObject.put("msa", 143);
            jSONObject = k.a(jSONObject, b(this.f12486m));
            jSONObject.put("opt", this.E);
            if (this.E == 0) {
                jSONObject.put("optn", 1);
            }
            b(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i4) {
        f.a aVar = this.A;
        if (aVar != null) {
            aVar.b(i4, str);
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onNativeFail(i4, str);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onNativeFail(i4, str);
        }
    }

    public void a(int i4) {
        this.E = i4;
    }

    public ViewGroup a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "initExpressContainer");
            jSONObject.put("uniqueId", aVar.H());
        } catch (JSONException e4) {
            bv.a().a(e4);
        }
        a(jSONObject, hashMap);
        Object obj = hashMap.get("container");
        if (obj instanceof ViewGroup) {
            return (ViewGroup) obj;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(String str) {
        if (!TextUtils.isEmpty(str) && this.f12788a != null) {
            for (int i4 = 0; i4 < this.f12788a.size(); i4++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f12788a.get(i4);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPrivacyClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f12789q == null) {
            return;
        }
        for (int i5 = 0; i5 < this.f12789q.size(); i5++) {
            bs bsVar = (bs) this.f12789q.get(i5);
            if (TextUtils.equals(str, bsVar.a())) {
                bsVar.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void f(String str) {
        if (!TextUtils.isEmpty(str) && this.f12788a != null) {
            for (int i4 = 0; i4 < this.f12788a.size(); i4++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f12788a.get(i4);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADFunctionClick();
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f12789q == null) {
            return;
        }
        for (int i5 = 0; i5 < this.f12789q.size(); i5++) {
            bs bsVar = (bs) this.f12789q.get(i5);
            if (TextUtils.equals(str, bsVar.a())) {
                bsVar.h();
            }
        }
    }

    public String h() {
        return this.f12794v;
    }

    public void c(Map<String, String> map) {
        try {
            HashMap<String, String> a4 = k.a(map);
            if (this.f12486m == null) {
                this.f12486m = new HashMap<>();
            }
            if (a4.isEmpty()) {
                return;
            }
            for (String str : a4.keySet()) {
                if (!TextUtils.isEmpty(str)) {
                    String str2 = a4.get(str);
                    if (!TextUtils.isEmpty(str2)) {
                        this.f12486m.put(str, str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, boolean z3) {
        if (!TextUtils.isEmpty(str) && this.f12788a != null) {
            for (int i4 = 0; i4 < this.f12788a.size(); i4++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f12788a.get(i4);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onAdDownloadWindow(z3);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f12789q == null) {
            return;
        }
        for (int i5 = 0; i5 < this.f12789q.size(); i5++) {
            bs bsVar = (bs) this.f12789q.get(i5);
            if (TextUtils.equals(str, bsVar.a())) {
                bsVar.b(z3);
            }
        }
    }

    public void a(ViewGroup viewGroup, a aVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "renderExpressView");
            jSONObject.put("uniqueId", aVar.H());
            hashMap.put("container", viewGroup);
        } catch (JSONException e4) {
            bv.a().a(e4);
        }
        a(jSONObject, hashMap);
    }

    public boolean a(View view, a aVar, int i4) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "switchTheme");
            hashMap.put(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, view);
            hashMap.put("code", Integer.valueOf(i4));
        } catch (JSONException e4) {
            bv.a().a(e4);
        }
        a(jSONObject, hashMap);
        Object obj = hashMap.get("result");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(int i4, String str) {
        f.a aVar = this.A;
        if (aVar != null) {
            aVar.a(i4, str);
        }
        BaiduNativeManager.ExpressAdListener expressAdListener = this.B;
        if (expressAdListener != null) {
            expressAdListener.onNoAd(i4, str);
        }
        BaiduNativeManager.EntryAdListener entryAdListener = this.C;
        if (entryAdListener != null) {
            entryAdListener.onNoAd(i4, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(String str, boolean z3) {
        if (!TextUtils.isEmpty(str) && this.f12788a != null) {
            for (int i4 = 0; i4 < this.f12788a.size(); i4++) {
                XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) this.f12788a.get(i4);
                if (xAdNativeResponse.getUniqueId().equals(str)) {
                    xAdNativeResponse.onADPermissionShow(z3);
                }
            }
        }
        if (TextUtils.isEmpty(str) || this.f12789q == null) {
            return;
        }
        for (int i5 = 0; i5 < this.f12789q.size(); i5++) {
            bs bsVar = (bs) this.f12789q.get(i5);
            if (TextUtils.equals(str, bsVar.a())) {
                bsVar.a(z3);
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(Map<String, String> map) {
        String[] strArr;
        int length;
        if (map == null || map.isEmpty()) {
            return;
        }
        HashMap hashMap = new HashMap(map);
        HashMap<String, String> hashMap2 = new HashMap<>();
        int i4 = 0;
        for (String str : ArticleInfo.PREDEFINED_KEYS) {
            if (hashMap.containsKey(str)) {
                String str2 = (String) hashMap.remove(str);
                if (!TextUtils.isEmpty(str2) && (length = str2.length() + i4) < 150) {
                    hashMap2.put(str, str2);
                    i4 = length;
                }
            }
        }
        if (!hashMap.isEmpty()) {
            for (String str3 : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str3)) {
                    String str4 = (String) hashMap.get(str3);
                    if (!TextUtils.isEmpty(str4)) {
                        int length2 = i4 + str3.length() + str4.length();
                        if (length2 >= 150) {
                            break;
                        }
                        hashMap2.put("c_" + str3, str4);
                        i4 = length2 + 2;
                    } else {
                        continue;
                    }
                }
            }
        }
        this.f12486m = hashMap2;
    }
}
