package com.bytedance.sdk.openadsdk.core.ls;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.sdk.openadsdk.ats.ATS;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.eq.c;
import com.bytedance.sdk.openadsdk.core.ls;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

@ATS(single = true, value = {"pitaya"})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux implements c.w, xv {

    /* renamed from: c  reason: collision with root package name */
    private AtomicBoolean f33887c = new AtomicBoolean(false);

    /* renamed from: w  reason: collision with root package name */
    private AtomicBoolean f33888w = new AtomicBoolean(false);
    private EventListener xv;

    private void ev() {
        if (this.xv == null) {
            this.xv = new r() { // from class: com.bytedance.sdk.openadsdk.core.ls.ux.3
                @Override // com.bytedance.sdk.openadsdk.core.ls.r, com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i4, Result result) {
                    try {
                        if (i4 == 1) {
                            JSONObject jSONObject = (JSONObject) result.values().objectValue(10, JSONObject.class);
                            c.c().c(jSONObject.optString("module"), jSONObject.optString(DomainCampaignEx.LOOPBACK_KEY), jSONObject.optString("value"));
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("success", true);
                            return b.a().h(37, jSONObject2).l();
                        } else if (i4 != 2) {
                            return super.onEvent(i4, result);
                        } else {
                            JSONObject jSONObject3 = (JSONObject) result.values().objectValue(10, JSONObject.class);
                            String optString = jSONObject3.optString("module");
                            String optString2 = jSONObject3.optString(DomainCampaignEx.LOOPBACK_KEY);
                            String c4 = c.c().c(optString, optString2);
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put(optString2, c4);
                            return b.a().h(37, jSONObject4).l();
                        }
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                        return b.a().h(37, new JSONObject()).l();
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        com.bytedance.sdk.openadsdk.core.eq.c xv = com.bytedance.sdk.openadsdk.core.k.sr().xv();
        if (xv != null) {
            xv.c(this);
        }
    }

    private Bridge r() {
        Bridge c4 = ls.c(10003);
        if (c4 != null && sr()) {
            return c4;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.xv
    @ATSMethod(5)
    public void c(String str, com.bytedance.sdk.component.r.c.w wVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.xv
    @ATSMethod(3)
    public boolean sr() {
        return this.f33888w.get();
    }

    public boolean ux() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.xv
    @ATSMethod(2)
    public boolean xv() {
        int i4;
        if (eq.c() && eq.f33190w >= 5003 && (i4 = Build.VERSION.SDK_INT) >= 28) {
            if (ux() && i4 == 29) {
                return false;
            }
            return com.bytedance.sdk.openadsdk.core.s.w.w(ls.w().q());
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.eq.c.w
    public void w() {
        try {
            Bridge r3 = r();
            if (r3 != null) {
                r3.call(1008, b.a().e(36, 0).l(), null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j4, sr srVar) {
        com.bytedance.sdk.openadsdk.core.fz.a.c().c(j4, srVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.eq.c.w
    public void c() {
        try {
            Bridge r3 = r();
            if (r3 != null) {
                r3.call(1008, b.a().e(36, 1).l(), null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.xv
    @ATSMethod(4)
    public void c(final String str, JSONObject jSONObject, EventListener eventListener) {
        Bridge c4 = ls.c(10003);
        if (c4 == null) {
            if (eventListener != null) {
                eventListener.onEvent(8, new Result() { // from class: com.bytedance.sdk.openadsdk.core.ls.ux.1
                    @Override // com.bykv.vk.openvk.api.proto.Result
                    public int code() {
                        return -6;
                    }

                    @Override // com.bykv.vk.openvk.api.proto.Result
                    public boolean isSuccess() {
                        return false;
                    }

                    @Override // com.bykv.vk.openvk.api.proto.Result
                    public String message() {
                        return "predict bridge is null";
                    }

                    @Override // com.bykv.vk.openvk.api.proto.Result
                    public ValueSet values() {
                        b a4 = b.a();
                        a4.i(5, str);
                        return a4.l();
                    }
                });
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("run_package_start", System.currentTimeMillis());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        c4.call(1003, b.a().i(25, str).h(26, jSONObject).h(1, eventListener).h(37, jSONObject2).l(), null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.xv
    @ATSMethod(1)
    public void c(Context context, final EventListener eventListener) {
        final long currentTimeMillis = System.currentTimeMillis();
        Bridge c4 = ls.c(10003);
        if (c4 == null) {
            com.bytedance.sdk.component.utils.a.w("pitaya_ext_plugin", "extBridgeService is null");
            if (eventListener != null) {
                eventListener.onEvent(-1, null);
            }
        } else if (sr()) {
            com.bytedance.sdk.component.utils.a.w("pitaya_ext_plugin", "pit has init success");
            if (eventListener != null) {
                eventListener.onEvent(0, null);
            }
        } else {
            try {
                if (this.f33887c.compareAndSet(false, true)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("aid", "1371");
                    jSONObject.put("channel", eq.f33188f);
                    jSONObject.put("core_api_version", eq.xv);
                    jSONObject.put("core_plugin_version", "6.1.0.6");
                    jSONObject.put("debug", false);
                    jSONObject.put("update", true);
                    jSONObject.put("download_concurrency", 2);
                    jSONObject.put("py_concurrency", 2);
                    jSONObject.put("provide_applog", true);
                    jSONObject.put(EventMonitor.KEY_SDK_SESSION_ID, com.bytedance.sdk.openadsdk.core.fz.w.f33686c);
                    ev();
                    c4.call(1001, b.a().h(21, jSONObject).h(22, context).h(38, this.xv).h(1, new r() { // from class: com.bytedance.sdk.openadsdk.core.ls.ux.2
                        @Override // com.bytedance.sdk.openadsdk.core.ls.r
                        protected ValueSet c(int i4, sr srVar) {
                            ux.this.f33888w.set(srVar.c());
                            if (!srVar.c()) {
                                if (srVar.w() != null) {
                                    com.bytedance.sdk.component.utils.a.f("pitaya_ext_plugin", "pit error:" + srVar.w().toString());
                                }
                                EventListener eventListener2 = eventListener;
                                if (eventListener2 != null) {
                                    eventListener2.onEvent(-1, null);
                                }
                            } else {
                                EventListener eventListener3 = eventListener;
                                if (eventListener3 != null) {
                                    eventListener3.onEvent(0, null);
                                }
                                ux.this.f();
                                com.bytedance.sdk.component.utils.a.w("pitaya_ext_plugin", "-----> pit init suc <------");
                            }
                            ux.this.c(System.currentTimeMillis() - currentTimeMillis, srVar);
                            return super.c(i4, srVar);
                        }
                    }).h(13, com.bytedance.sdk.component.gd.ev.c()).l(), null);
                } else {
                    com.bytedance.sdk.component.utils.a.w("pitaya_ext_plugin", "is initing");
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.a.f("pitaya_ext_plugin", "pit#initPit:" + th.getMessage());
                if (eventListener != null) {
                    eventListener.onEvent(-1, null);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ls.xv
    @ATSMethod(6)
    public void c(String str, EventListener eventListener) {
        Bridge c4 = ls.c(10003);
        if (c4 != null) {
            b a4 = b.a();
            a4.h(1, eventListener);
            a4.i(25, str);
            c4.call(1004, a4.l(), null);
        }
    }
}
