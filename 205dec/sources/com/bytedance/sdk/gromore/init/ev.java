package com.bytedance.sdk.gromore.init;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Loader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.pangle_csjm.PluginInitConfig;
import com.bytedance.sdk.gromore.c.c.sr.fp;
import com.bytedance.sdk.gromore.c.c.sr.ia;
import com.bytedance.sdk.openadsdk.ys.w.xv.w;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ev implements Loader {

    /* renamed from: c  reason: collision with root package name */
    private Loader f31252c;

    /* renamed from: w  reason: collision with root package name */
    private Context f31253w;

    public ev(Context context, Loader loader) {
        this.f31252c = loader;
        this.f31253w = context;
    }

    private ValueSet c(ValueSet valueSet) {
        JSONArray jSONArray;
        if (valueSet == null) {
            return null;
        }
        String ls = new com.bytedance.sdk.openadsdk.ys.w.xv.w(valueSet).ls();
        try {
            if (TextUtils.isEmpty(ls)) {
                jSONArray = new JSONArray();
            } else {
                jSONArray = new JSONArray(ls);
            }
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                if (optJSONObject != null && TextUtils.equals("personal_ads_type", optJSONObject.optString("name"))) {
                    return valueSet;
                }
            }
            JSONObject jSONObject = new JSONObject();
            PluginInitConfig w3 = com.bytedance.msdk.core.w.k().w();
            if (w3 != null) {
                String str = w3.isLimitPersonalAds() ? "0" : "1";
                jSONObject.put("name", "personal_ads_type");
                jSONObject.put("value", str);
                jSONArray.put(jSONObject);
                return com.bytedance.sdk.openadsdk.mediation.c.w.c.c(valueSet, jSONArray.toString());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return valueSet;
    }

    @Override // com.bykv.vk.openvk.api.proto.Loader
    public void load(int i4, ValueSet valueSet, EventListener eventListener) {
        if (valueSet == null) {
            return;
        }
        if (!com.bytedance.msdk.core.bk.c.c().xv()) {
            if (this.f31252c != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TMe", "load csj \u4ee3\u7801\u4f4d\u672a\u5f00\u542f\u805a\u5408\u5f00\u5173");
                this.f31252c.load(i4, valueSet, eventListener);
                return;
            }
            return;
        }
        com.bytedance.msdk.adapter.sr.xv.w("TTMediationSDK", "CSJM_loadAD Type:" + i4);
        final com.bytedance.sdk.gromore.c.c cVar = new com.bytedance.sdk.gromore.c.c(valueSet);
        boolean z3 = true;
        Bridge bridge = (Bridge) valueSet.objectValue(1, Bridge.class);
        w.c cVar2 = new w.c(new com.bytedance.sdk.openadsdk.ys.w.xv.w(valueSet));
        com.bytedance.msdk.core.bk.c.c().c(cVar.ev());
        if (cVar.c() != 0 && (cVar.c() == cVar.xv() || cVar.xv() == 0.0f)) {
            cVar2.c(com.bytedance.msdk.api.ux.w(this.f31253w, cVar.c()));
        } else {
            cVar2.c(cVar.xv());
        }
        if (cVar.xv() != 0.0f && cVar.sr() == 0.0f) {
            cVar2.w(cVar.sr());
        } else if (cVar.w() != 0 && (cVar.w() == cVar.sr() || cVar.sr() == 0.0f)) {
            cVar2.w(com.bytedance.msdk.api.ux.w(this.f31253w, cVar.w()));
        } else {
            cVar2.w(cVar.sr());
        }
        if (cVar.c() == 0 && cVar.xv() != 0.0f) {
            cVar2.c(com.bytedance.msdk.api.ux.c(this.f31253w, cVar.xv()));
        }
        if (cVar.w() == 0 && cVar.sr() != 0.0f) {
            cVar2.w(com.bytedance.msdk.api.ux.c(this.f31253w, cVar.sr()));
        }
        com.bytedance.sdk.openadsdk.mediation.c.w.c cVar3 = new com.bytedance.sdk.openadsdk.mediation.c.w.c(com.bytedance.sdk.openadsdk.mediation.c.w.c.c(cVar2.c()));
        if (i4 == 1) {
            if (com.bytedance.msdk.core.bk.c.c().c(cVar.ux(), 1)) {
                com.bytedance.sdk.gromore.c.c.c.sr srVar = new com.bytedance.sdk.gromore.c.c.c.sr(bridge);
                if (this.f31253w instanceof Activity) {
                    com.bytedance.msdk.adapter.sr.xv.w("TMe", "load m banner \u5e7f\u544a\u4f4d = " + cVar.ux());
                    new com.bytedance.sdk.gromore.c.c.c.xv((Activity) this.f31253w, cVar3, srVar).c();
                    return;
                }
                srVar.onError(81005, "context is null or not Activity");
            } else if (this.f31252c != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TMe", "load csj banner \u4ee3\u7801\u4f4d = " + cVar.ux());
                this.f31252c.load(i4, c(valueSet), eventListener);
            }
        } else if (i4 == 3) {
            if (com.bytedance.msdk.core.bk.c.c().c(cVar.ux(), 3)) {
                com.bytedance.msdk.adapter.sr.xv.w("TMe", "load m splash \u5e7f\u544a\u4f4d = " + cVar.ux());
            } else if (!com.bytedance.msdk.ux.c.c.p().ev() || cVar.r() == null || TextUtils.isEmpty(cVar.r().c()) || TextUtils.isEmpty(cVar.r().xv()) || TextUtils.isEmpty(cVar.r().w())) {
                z3 = false;
            } else {
                com.bytedance.msdk.adapter.sr.xv.w("TMe", "load m splash \u5f00\u5c4f\u515c\u5e95\u4ee3\u7801\u4f4d = " + cVar.r().w());
            }
            if (z3) {
                com.bytedance.sdk.gromore.c.c.f.ux uxVar = new com.bytedance.sdk.gromore.c.c.f.ux(bridge);
                Context context = this.f31253w;
                if (context instanceof Activity) {
                    final com.bytedance.sdk.gromore.c.c.f.sr srVar2 = new com.bytedance.sdk.gromore.c.c.f.sr((Activity) context, cVar3, uxVar);
                    com.bytedance.msdk.api.sr.gd.c(new com.bytedance.msdk.api.sr.c.gd.c() { // from class: com.bytedance.sdk.gromore.init.ev.1
                        @Override // com.bytedance.msdk.api.sr.c.gd.c
                        public void c() {
                            if (cVar.gd() != 0) {
                                srVar2.c(cVar.gd());
                            } else {
                                srVar2.c();
                            }
                        }
                    });
                    return;
                }
                uxVar.onSplashLoadFail(new com.bytedance.sdk.gromore.c.c.c(81005, "context is null or not Activity"));
            } else if (this.f31252c != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TMe", "load csj splash \u4ee3\u7801\u4f4d = " + cVar.ux());
                this.f31252c.load(i4, c(valueSet), eventListener);
            }
        } else if (i4 == 5) {
            boolean booleanValue = valueSet.booleanValue(2);
            if (com.bytedance.msdk.core.bk.c.c().c(cVar.ux(), 5)) {
                com.bytedance.msdk.adapter.sr.xv.w("TMe", "load m feed \u5e7f\u544a\u4f4d = " + cVar.ux() + ", isExpress: " + booleanValue);
                if (booleanValue) {
                    com.bytedance.sdk.gromore.c.c.sr.ys ysVar = new com.bytedance.sdk.gromore.c.c.sr.ys(bridge);
                    Context context2 = this.f31253w;
                    if (context2 != null) {
                        new com.bytedance.sdk.gromore.c.c.sr.t(context2, cVar3, ysVar).c();
                        return;
                    } else {
                        ysVar.onError(81005, "context is null or not Activity");
                        return;
                    }
                }
                ia iaVar = new ia(bridge);
                Context context3 = this.f31253w;
                if (context3 != null) {
                    new fp(context3, cVar3, iaVar).c();
                } else {
                    iaVar.onError(81005, "context is null or not Activity");
                }
            } else if (this.f31252c != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TMe", "load csj feed \u4ee3\u7801\u4f4d = " + cVar.ux() + ", isExpress: " + booleanValue);
                this.f31252c.load(i4, c(valueSet), eventListener);
            }
        } else if (i4 == 7) {
            if (com.bytedance.msdk.core.bk.c.c().c(cVar.ux(), 7)) {
                com.bytedance.sdk.gromore.c.c.ux.ux uxVar2 = new com.bytedance.sdk.gromore.c.c.ux.ux(bridge);
                if (this.f31253w instanceof Activity) {
                    com.bytedance.msdk.adapter.sr.xv.w("TMe", "load m reward video \u5e7f\u544a\u4f4d = " + cVar.ux());
                    new com.bytedance.sdk.gromore.c.c.ux.sr((Activity) this.f31253w, cVar3, uxVar2).c();
                    return;
                }
                uxVar2.onError(81005, "context is null or not Activity");
            } else if (this.f31252c != null) {
                com.bytedance.msdk.adapter.sr.xv.w("TMe", "load csj reward video \u4ee3\u7801\u4f4d = " + cVar.ux());
                this.f31252c.load(i4, c(valueSet), eventListener);
            }
        } else if (i4 == 8) {
            if (!com.bytedance.msdk.core.bk.c.c().c(cVar.ux(), 8) && !com.bytedance.msdk.core.bk.c.c().c(cVar.ux(), 10)) {
                if (this.f31252c != null) {
                    com.bytedance.msdk.adapter.sr.xv.w("TMe", "load csj full");
                    this.f31252c.load(i4, c(valueSet), eventListener);
                    return;
                }
                return;
            }
            com.bytedance.sdk.gromore.c.c.xv.ev evVar = new com.bytedance.sdk.gromore.c.c.xv.ev(bridge);
            if (this.f31253w instanceof Activity) {
                com.bytedance.msdk.core.k.w c4 = com.bytedance.msdk.core.c.w().c(cVar3.f(), 8, 101);
                if (c4 == null) {
                    c4 = com.bytedance.msdk.core.c.w().c(cVar3.f(), 10, 101);
                }
                if (c4 != null && c4.yu() == 8) {
                    com.bytedance.msdk.adapter.sr.xv.w("TMe", "load m full \u5e7f\u544a\u4f4d = " + cVar.ux());
                    new com.bytedance.sdk.gromore.c.c.xv.xv((Activity) this.f31253w, cVar3, evVar).c();
                    return;
                }
                com.bytedance.msdk.adapter.sr.xv.w("TMe", "load m interstitial full \u4ee3\u7801\u4f4d = " + cVar.ux());
                new com.bytedance.sdk.gromore.c.c.xv.r((Activity) this.f31253w, cVar3, evVar).c();
                return;
            }
            evVar.onError(81005, "context is null or not Activity");
        } else if (i4 != 9) {
            com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK", "CSJM_loadAD load default mCSJLoader = " + this.f31252c);
            Loader loader = this.f31252c;
            if (loader != null) {
                loader.load(i4, c(valueSet), eventListener);
            }
        } else if (com.bytedance.msdk.core.bk.c.c().c(cVar.ux(), 9)) {
            com.bytedance.msdk.adapter.sr.xv.w("TMe", "load m draw \u5e7f\u544a\u4f4d = " + cVar.ux());
            com.bytedance.sdk.gromore.c.c.w.ux uxVar3 = new com.bytedance.sdk.gromore.c.c.w.ux(bridge);
            Context context4 = this.f31253w;
            if (context4 != null) {
                new com.bytedance.sdk.gromore.c.c.w.sr(context4, cVar3, uxVar3).c();
            } else {
                uxVar3.onError(81005, "context is null or not Activity");
            }
        } else if (this.f31252c != null) {
            com.bytedance.msdk.adapter.sr.xv.w("TMe", "load csj draw \u4ee3\u7801\u4f4d = " + cVar.ux());
            this.f31252c.load(i4, c(valueSet), eventListener);
        }
    }
}
