package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.baidu.mobads.sdk.api.CPUAdType;
import com.baidu.mobads.sdk.api.CPUDramaDetailConfig;
import com.baidu.mobads.sdk.api.CPUDramaListener;
import com.baidu.mobads.sdk.api.CPUDramaRequestParams;
import com.baidu.mobads.sdk.api.CPUDramaResponse;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.internal.concrete.FragmentDelegate;
import com.baidu.mobads.sdk.internal.concrete.FragmentV4Delegate;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class db extends bj {

    /* renamed from: a  reason: collision with root package name */
    private CPUDramaRequestParams f12739a;

    /* renamed from: q  reason: collision with root package name */
    private CPUDramaResponse f12740q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f12741r;

    /* renamed from: s  reason: collision with root package name */
    private CPUDramaListener f12742s;

    public db(Context context, CPUDramaRequestParams cPUDramaRequestParams, CPUDramaListener cPUDramaListener) {
        super(context);
        this.f12739a = cPUDramaRequestParams;
        this.f12742s = cPUDramaListener;
        this.f12741r = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(IOAdEvent iOAdEvent) {
        if (this.f12742s != null) {
            CPUDramaResponse cPUDramaResponse = null;
            if (iOAdEvent != null) {
                try {
                    Map<String, Object> data = iOAdEvent.getData();
                    cPUDramaResponse = new CPUDramaResponse().setContentId((String) data.get("contentId")).setSubVideoId((String) data.get("subVideoId")).setTitle((String) data.get("title")).setRepresent(((Integer) data.get("represent")).intValue()).setCoverImageUrl((String) data.get("coverImageUrl"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.f12742s.onVideoCollect(cPUDramaResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(IOAdEvent iOAdEvent) {
        if (this.f12742s != null) {
            CPUDramaResponse cPUDramaResponse = null;
            if (iOAdEvent != null) {
                try {
                    Map<String, Object> data = iOAdEvent.getData();
                    cPUDramaResponse = new CPUDramaResponse().setContentId((String) data.get("contentId")).setSubVideoId((String) data.get("subVideoId")).setTitle((String) data.get("title")).setRepresent(((Integer) data.get("represent")).intValue()).setCoverImageUrl((String) data.get("coverImageUrl"));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.f12742s.onVideoPlay(cPUDramaResponse);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(int i4, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(IOAdEvent iOAdEvent) {
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void b(String str, int i4) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void e(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.f12742s == null || iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        Object obj = data.get("adType");
        if (obj instanceof String) {
            this.f12742s.onADExposed(CPUAdType.parse((String) obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "refresh");
        } catch (JSONException e4) {
            bv.a().a(e4);
        }
        a(jSONObject, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.mobads.sdk.internal.bj
    public void h(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.f12742s == null || iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        Object obj = data.get("adType");
        if (obj instanceof String) {
            this.f12742s.onAdClick(CPUAdType.parse((String) obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment b(com.baidu.mobads.sdk.internal.a.e eVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "getSupportFragment");
            a(jSONObject, hashMap);
            Object obj = hashMap.get("frag");
            if (obj instanceof FragmentV4Delegate) {
                FragmentV4Delegate fragmentV4Delegate = (FragmentV4Delegate) obj;
                fragmentV4Delegate.setProxy(eVar);
                return fragmentV4Delegate;
            }
            return null;
        } catch (JSONException e4) {
            bv.a().a(e4);
            return null;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        HashMap hashMap;
        String str;
        Object remove;
        String str2;
        if (this.f12484k != null && this.f12739a != null) {
            this.f12485l = true;
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("prod", "cpu_drama");
                this.f12484k.createProdHandler(jSONObject3);
                n();
                dc dcVar = new dc(this);
                this.f12484k.addEventListener("onContentLoaded", dcVar);
                this.f12484k.addEventListener("onContentFailed", dcVar);
                this.f12484k.addEventListener(x.as, dcVar);
                this.f12484k.addEventListener(x.at, dcVar);
                hashMap = new HashMap(this.f12739a.getExtras());
                str = (String) hashMap.remove("subChannelId");
                remove = hashMap.remove("dramaDetailConfig");
                str2 = (String) hashMap.remove("appsid");
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                jSONObject.put("prod", "cpu_drama");
                jSONObject.put("subChannelId", str);
                jSONObject.put("appid", str2);
                jSONObject.put("isDramaListRequest", this.f12741r);
                CPUDramaResponse cPUDramaResponse = this.f12740q;
                if (cPUDramaResponse != null) {
                    jSONObject.put("dramaContentId", cPUDramaResponse.getDramaContentId());
                    jSONObject.put("dramaSubVideoId", this.f12740q.getDramaSubVideoId());
                    jSONObject.put("dramaRepresent", this.f12740q.getRepresent());
                }
                jSONObject2 = k.a((HashMap<String, Object>) hashMap);
                if (remove instanceof CPUDramaDetailConfig) {
                    jSONObject2.put("freeCount", ((CPUDramaDetailConfig) remove).mFreeCount);
                    jSONObject2.put("unLockCount", ((CPUDramaDetailConfig) remove).mUnLockCount);
                }
                this.f12484k.loadAd(jSONObject, jSONObject2);
                return;
            }
            CPUDramaListener cPUDramaListener = this.f12742s;
            if (cPUDramaListener != null) {
                cPUDramaListener.onContentFailed(-2, "\u77ed\u5267\u8bf7\u6c42\u7f3a\u5c11sid \u6216 scid\uff01");
            }
            az.c().e("\u77ed\u5267\u8bf7\u6c42\u7f3a\u5c11sid \u6216 scid\uff01");
            return;
        }
        this.f12485l = false;
        CPUDramaListener cPUDramaListener2 = this.f12742s;
        if (cPUDramaListener2 != null) {
            cPUDramaListener2.onContentFailed(-2, "\u77ed\u5267\u8bf7\u6c42\u7f3a\u5c11\u5fc5\u8981\u53c2\u6570\uff01");
        }
        az.c().e("\u77ed\u5267\u8bf7\u6c42\u7f3a\u5c11\u5fc5\u8981\u53c2\u6570\uff01");
    }

    public db(Context context, CPUDramaRequestParams cPUDramaRequestParams, CPUDramaResponse cPUDramaResponse, CPUDramaListener cPUDramaListener) {
        super(context);
        this.f12739a = cPUDramaRequestParams;
        this.f12740q = cPUDramaResponse;
        this.f12742s = cPUDramaListener;
        this.f12741r = false;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void f(IOAdEvent iOAdEvent) {
        Map<String, Object> data;
        if (this.f12742s == null || iOAdEvent == null || (data = iOAdEvent.getData()) == null) {
            return;
        }
        Object obj = data.get("adType");
        if (obj instanceof String) {
            this.f12742s.onADExposureFailed(CPUAdType.parse((String) obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public android.app.Fragment a(com.baidu.mobads.sdk.internal.a.e eVar) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.put("msg", "getFragment");
            a(jSONObject, hashMap);
            Object obj = hashMap.get("frag");
            if (obj instanceof FragmentDelegate) {
                FragmentDelegate fragmentDelegate = (FragmentDelegate) obj;
                fragmentDelegate.setProxy(eVar);
                return fragmentDelegate;
            }
            return null;
        } catch (JSONException e4) {
            bv.a().a(e4);
            return null;
        }
    }
}
