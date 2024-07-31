package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.baidu.mobads.sdk.api.CPUAdType;
import com.baidu.mobads.sdk.api.CPUDramaDetailConfig;
import com.baidu.mobads.sdk.api.CPUDramaListener;
import com.baidu.mobads.sdk.api.CPUDramaRequestParams;
import com.baidu.mobads.sdk.api.CPUDramaResponse;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.concrete.FragmentDelegate;
import com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate;
import com.baidu.mobads.sdk.internal.p050a.C2579e;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.cy */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2680cy extends AbstractC2619bg {

    /* renamed from: a */
    private CPUDramaRequestParams f8919a;

    /* renamed from: q */
    private CPUDramaResponse f8920q;

    /* renamed from: r */
    private boolean f8921r;

    /* renamed from: s */
    private CPUDramaListener f8922s;

    public C2680cy(Context context, CPUDramaRequestParams cPUDramaRequestParams, CPUDramaListener cPUDramaListener) {
        super(context);
        this.f8919a = cPUDramaRequestParams;
        this.f8922s = cPUDramaListener;
        this.f8921r = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m50570l(IOAdEvent iOAdEvent) {
        if (this.f8922s != null) {
            CPUDramaResponse cPUDramaResponse = null;
            if (iOAdEvent != null) {
                try {
                    Map<String, Object> data = iOAdEvent.getData();
                    cPUDramaResponse = new CPUDramaResponse().setContentId((String) data.get("contentId")).setSubVideoId((String) data.get("subVideoId")).setTitle((String) data.get("title")).setRepresent(((Integer) data.get("represent")).intValue()).setCoverImageUrl((String) data.get("coverImageUrl"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.f8922s.onVideoCollect(cPUDramaResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m50569m(IOAdEvent iOAdEvent) {
        if (this.f8922s != null) {
            CPUDramaResponse cPUDramaResponse = null;
            if (iOAdEvent != null) {
                try {
                    Map<String, Object> data = iOAdEvent.getData();
                    cPUDramaResponse = new CPUDramaResponse().setContentId((String) data.get("contentId")).setSubVideoId((String) data.get("subVideoId")).setTitle((String) data.get("title")).setRepresent(((Integer) data.get("represent")).intValue()).setCoverImageUrl((String) data.get("coverImageUrl"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.f8922s.onVideoPlay(cPUDramaResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50459a(int i, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50455a(IOAdEvent iOAdEvent) {
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: b */
    public void mo50442b(String str, int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: e */
    public void mo50511e(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.f8922s == null || iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        Object obj = data.get("adType");
        if (obj instanceof String) {
            this.f8922s.onADExposed(CPUAdType.parse((String) obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public void m50571f() {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "refresh");
        } catch (JSONException e) {
            C2634bs.m50744a().m50738a(e);
        }
        m50818a(jSONObject, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: h */
    public void mo50427h(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.f8922s == null || iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        Object obj = data.get("adType");
        if (obj instanceof String) {
            this.f8922s.onAdClick(CPUAdType.parse((String) obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public Fragment m50573b(C2579e c2579e) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "getSupportFragment");
            m50818a(jSONObject, hashMap);
            Object obj = hashMap.get("frag");
            if (obj instanceof FragmentV4Delegate) {
                FragmentV4Delegate fragmentV4Delegate = (FragmentV4Delegate) obj;
                fragmentV4Delegate.setProxy(c2579e);
                return fragmentV4Delegate;
            }
            return null;
        } catch (JSONException e) {
            C2634bs.m50744a().m50738a(e);
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: a */
    public void mo50356a() {
        HashMap hashMap;
        String str;
        Object remove;
        String str2;
        if (this.f8666k != null && this.f8919a != null) {
            this.f8667l = true;
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(IAdInterListener.AdReqParam.PROD, "cpu_drama");
                this.f8666k.createProdHandler(jSONObject3);
                m50805n();
                C2681cz c2681cz = new C2681cz(this);
                this.f8666k.addEventListener("onContentLoaded", c2681cz);
                this.f8666k.addEventListener("onContentFailed", c2681cz);
                this.f8666k.addEventListener(C2736x.f9295ar, c2681cz);
                this.f8666k.addEventListener(C2736x.f9296as, c2681cz);
                hashMap = new HashMap(this.f8919a.getExtras());
                str = (String) hashMap.remove("subChannelId");
                remove = hashMap.remove("dramaDetailConfig");
                str2 = (String) hashMap.remove("appsid");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                jSONObject.put(IAdInterListener.AdReqParam.PROD, "cpu_drama");
                jSONObject.put("subChannelId", str);
                jSONObject.put("appid", str2);
                jSONObject.put("isDramaListRequest", this.f8921r);
                CPUDramaResponse cPUDramaResponse = this.f8920q;
                if (cPUDramaResponse != null) {
                    jSONObject.put("dramaContentId", cPUDramaResponse.getDramaContentId());
                    jSONObject.put("dramaSubVideoId", this.f8920q.getDramaSubVideoId());
                    jSONObject.put("dramaRepresent", this.f8920q.getRepresent());
                }
                jSONObject2 = C2714k.m50367a((HashMap<String, Object>) hashMap);
                if (remove instanceof CPUDramaDetailConfig) {
                    jSONObject2.put("freeCount", ((CPUDramaDetailConfig) remove).mFreeCount);
                    jSONObject2.put("unLockCount", ((CPUDramaDetailConfig) remove).mUnLockCount);
                }
                this.f8666k.loadAd(jSONObject, jSONObject2);
                return;
            }
            CPUDramaListener cPUDramaListener = this.f8922s;
            if (cPUDramaListener != null) {
                cPUDramaListener.onContentFailed(-2, "短剧请求缺少sid 或 scid！");
            }
            C2607aw.m50919c().mo50864e("短剧请求缺少sid 或 scid！");
            return;
        }
        this.f8667l = false;
        CPUDramaListener cPUDramaListener2 = this.f8922s;
        if (cPUDramaListener2 != null) {
            cPUDramaListener2.onContentFailed(-2, "短剧请求缺少必要参数！");
        }
        C2607aw.m50919c().mo50864e("短剧请求缺少必要参数！");
    }

    public C2680cy(Context context, CPUDramaRequestParams cPUDramaRequestParams, CPUDramaResponse cPUDramaResponse, CPUDramaListener cPUDramaListener) {
        super(context);
        this.f8919a = cPUDramaRequestParams;
        this.f8920q = cPUDramaResponse;
        this.f8922s = cPUDramaListener;
        this.f8921r = false;
    }

    @Override // com.baidu.mobads.sdk.internal.AbstractC2619bg
    /* renamed from: f */
    public void mo50509f(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.f8922s == null || iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        Object obj = data.get("adType");
        if (obj instanceof String) {
            this.f8922s.onADExposureFailed(CPUAdType.parse((String) obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public android.app.Fragment m50576a(C2579e c2579e) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "getFragment");
            m50818a(jSONObject, hashMap);
            Object obj = hashMap.get("frag");
            if (obj instanceof FragmentDelegate) {
                FragmentDelegate fragmentDelegate = (FragmentDelegate) obj;
                fragmentDelegate.setProxy(c2579e);
                return fragmentDelegate;
            }
            return null;
        } catch (JSONException e) {
            C2634bs.m50744a().m50738a(e);
            return null;
        }
    }
}
