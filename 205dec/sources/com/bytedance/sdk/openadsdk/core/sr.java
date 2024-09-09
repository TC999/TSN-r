package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Initializer;
import com.bykv.vk.openvk.api.proto.Manager;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.adsdk.ugeno.w.o;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.openadsdk.core.live.TTLiveCommerceHelper;
import com.bytedance.sdk.openadsdk.ys.w.c;
import j0.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class sr extends com.bytedance.sdk.openadsdk.ys.w.c implements Initializer {

    /* renamed from: c  reason: collision with root package name */
    private static int f34528c;

    /* renamed from: w  reason: collision with root package name */
    private static Boolean f34529w;
    private final me xv = new me();
    private volatile boolean sr = false;
    private volatile Bridge ux = null;

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f34530f = new AtomicBoolean(false);

    public sr(Bundle bundle) {
        if (bundle == null || !bundle.containsKey("_pl_update_event_listener_")) {
            return;
        }
        Serializable serializable = bundle.getSerializable("_pl_update_event_listener_");
        if (serializable instanceof EventListener) {
            com.bytedance.sdk.openadsdk.core.gb.c.w.c().c((EventListener) serializable);
        }
    }

    private static boolean f() {
        if (f34529w == null) {
            try {
                Class.forName("kotlin.Result");
                f34529w = Boolean.TRUE;
            } catch (Throwable unused) {
                f34529w = Boolean.FALSE;
            }
        }
        return f34529w.booleanValue();
    }

    private void r() {
        b.a().b(ls.getContext(), new o() { // from class: com.bytedance.sdk.openadsdk.core.sr.6
            @Override // com.bytedance.adsdk.ugeno.w.o
            public List<com.bytedance.adsdk.ugeno.w.n> c() {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new com.bytedance.adsdk.ugeno.w.n("RecyclerLayout") { // from class: com.bytedance.sdk.openadsdk.core.sr.6.1
                    @Override // com.bytedance.adsdk.ugeno.w.n
                    public com.bytedance.adsdk.ugeno.component.b c(Context context) {
                        return new com.bytedance.adsdk.ugeno.c.c.b(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.n("Video") { // from class: com.bytedance.sdk.openadsdk.core.sr.6.2
                    @Override // com.bytedance.adsdk.ugeno.w.n
                    public com.bytedance.adsdk.ugeno.component.b c(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.video.w(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.n("Gif") { // from class: com.bytedance.sdk.openadsdk.core.sr.6.3
                    @Override // com.bytedance.adsdk.ugeno.w.n
                    public com.bytedance.adsdk.ugeno.component.b c(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.gif.c(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.n("VideoPlaceholder") { // from class: com.bytedance.sdk.openadsdk.core.sr.6.4
                    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.sdk.openadsdk.core.ugeno.component.c.c, com.bytedance.adsdk.ugeno.component.b] */
                    @Override // com.bytedance.adsdk.ugeno.w.n
                    public com.bytedance.adsdk.ugeno.component.b c(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.c.c(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.n("Lottie") { // from class: com.bytedance.sdk.openadsdk.core.sr.6.5
                    @Override // com.bytedance.adsdk.ugeno.w.n
                    public com.bytedance.adsdk.ugeno.component.b c(Context context) {
                        return new com.bytedance.adsdk.xv.a(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.n("InteractionWebView") { // from class: com.bytedance.sdk.openadsdk.core.sr.6.6
                    @Override // com.bytedance.adsdk.ugeno.w.n
                    public com.bytedance.adsdk.ugeno.component.b c(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.n("WebView") { // from class: com.bytedance.sdk.openadsdk.core.sr.6.7
                    @Override // com.bytedance.adsdk.ugeno.w.n
                    public com.bytedance.adsdk.ugeno.component.b c(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.webview.c(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.n("Blur") { // from class: com.bytedance.sdk.openadsdk.core.sr.6.8
                    @Override // com.bytedance.adsdk.ugeno.w.n
                    public com.bytedance.adsdk.ugeno.component.b c(Context context) {
                        return new com.bytedance.sdk.openadsdk.core.ugeno.component.c(context);
                    }
                });
                arrayList.add(new com.bytedance.adsdk.ugeno.w.n("Swiper") { // from class: com.bytedance.sdk.openadsdk.core.sr.6.9
                    @Override // com.bytedance.adsdk.ugeno.w.n
                    public com.bytedance.adsdk.ugeno.component.b c(Context context) {
                        return new j0.c(context);
                    }
                });
                return arrayList;
            }
        }, new com.bytedance.sdk.openadsdk.core.ugeno.xv());
    }

    private static int ux() {
        if (f34528c == 0) {
            try {
                try {
                    Class.forName("androidx.core.content.FileProvider");
                    f34528c = 1;
                } catch (Throwable unused) {
                    Class.forName("androidx.core.content.FileProvider");
                    f34528c = 2;
                }
            } catch (Throwable unused2) {
                f34528c = -1;
            }
        }
        return f34528c;
    }

    static /* synthetic */ int xv() {
        return ux();
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public Manager getManager() {
        return this.xv;
    }

    @Override // com.bykv.vk.openvk.api.proto.Initializer
    public void init(Context context, ValueSet valueSet) {
        c(context, valueSet, (EventListener) valueSet.objectValue(15, EventListener.class));
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.c, com.bykv.vk.openvk.api.proto.Initializer
    public boolean isInitSuccess() {
        return this.sr;
    }

    static /* synthetic */ boolean w() {
        return f();
    }

    private void w(@ForbidWrapParam com.bytedance.sdk.openadsdk.ys.w.xv.c cVar, @ForbidWrapParam ValueSet valueSet) {
        if (cVar == null) {
            return;
        }
        String w3 = cVar.w();
        if (w3 == null || w3.isEmpty()) {
            w3 = com.bytedance.sdk.openadsdk.core.r.c.w(ls.getContext());
        }
        Bridge bridge = (Bridge) valueSet.objectValue(16, Bridge.class);
        if (bridge != null) {
            k.sr().c(bridge);
        }
        k.sr().w(w3);
        k.sr().c(cVar.c());
        k.sr().xv(cVar.xv());
        k.sr().xv(cVar.sr());
        k.sr().sr(cVar.ux());
        k.sr().w(cVar.f());
        k.sr().sr(cVar.r());
        k.sr().c(cVar.gd());
        k.sr().ev(cVar.p());
        k.sr().r(cVar.fp());
        k.sr().c(cVar.a());
        if (eq.f33190w >= 5500) {
            k.sr().sr(cVar.t());
            k.sr().c(cVar.bk());
        } else {
            k.sr().sr(valueSet.intValue(7));
            k.sr().c(valueSet.intValue(8));
        }
        if (c(cVar)) {
            com.bytedance.sdk.component.utils.a.w();
            com.bytedance.sdk.openadsdk.tools.w.w();
        }
        try {
            Boolean bool = (Boolean) valueSet.objectValue(14, Boolean.class);
            if (bool != null) {
                eq.f33187c = bool.booleanValue();
            }
        } catch (Exception unused) {
        }
    }

    private static void c(com.bytedance.sdk.openadsdk.ys.w.xv.c cVar, boolean z3) {
        if (c(cVar)) {
            com.bytedance.sdk.openadsdk.tools.w.xv(1, z3 ? "1" : "0");
            c(cVar.a());
            com.bytedance.sdk.openadsdk.tools.w.w(2, cVar.c());
            try {
                Thread.currentThread().getContextClassLoader().loadClass("com.bytedance.sdk.openadsdk.core.GlobalInfo");
                com.bytedance.sdk.openadsdk.tools.w.xv(2, "0");
            } catch (Exception unused) {
                com.bytedance.sdk.openadsdk.tools.w.xv(2, "1");
            }
            com.bytedance.sdk.openadsdk.tools.w.w(0, eq.xv);
        }
    }

    private static void c(com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar) {
        com.bytedance.sdk.openadsdk.ys.w.xv.xv ev;
        String str;
        if (srVar == null) {
            srVar = k.f33817c;
        }
        if (srVar != null) {
            com.bytedance.sdk.openadsdk.tools.w.xv(19, srVar == k.f33817c ? "1" : "0");
            com.bytedance.sdk.openadsdk.tools.w.xv(7, String.valueOf(srVar.c() ? 1 : 0));
            String str2 = "";
            if (srVar.ev() != null) {
                str = ev.c() + "," + ev.w();
            } else {
                str = "";
            }
            com.bytedance.sdk.openadsdk.tools.w.xv(8, str);
            com.bytedance.sdk.openadsdk.tools.w.xv(9, String.valueOf(srVar.xv() ? 1 : 0));
            String gd = srVar.gd();
            com.bytedance.sdk.openadsdk.tools.w.xv(10, gd != null ? gd.trim() : "");
            com.bytedance.sdk.openadsdk.tools.w.xv(11, String.valueOf(srVar.sr() ? 1 : 0));
            com.bytedance.sdk.openadsdk.tools.w.xv(12, String.valueOf(srVar.ux() ? 1 : 0));
            com.bytedance.sdk.openadsdk.tools.w.xv(17, String.valueOf(srVar.w() ? 1 : 0));
            if (eq.f33190w >= 4600) {
                com.bytedance.sdk.openadsdk.tools.w.xv(22, String.valueOf(srVar.f() ? 1 : 0));
            }
            String p3 = srVar.p();
            com.bytedance.sdk.openadsdk.tools.w.xv(18, p3 != null ? p3.trim() : "");
            try {
                if (srVar.k() != null) {
                    str2 = srVar.k().trim();
                }
                com.bytedance.sdk.openadsdk.tools.w.xv(13, str2);
            } catch (Exception unused) {
                com.bytedance.sdk.component.utils.a.xv("Get oaid from controller failed");
            }
            com.bytedance.sdk.openadsdk.tools.w.xv(14, String.valueOf(k.sr().ls() ? 1 : 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(@ForbidWrapParam final Context context, final long j4, final long j5, final long j6, final n nVar, final boolean z3, final com.bytedance.sdk.openadsdk.ys.w.xv.c cVar, final String str, final int i4, @ForbidWrapParam final ValueSet valueSet) {
        q.xv();
        if (ls.w().mt()) {
            com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.sr.2
                @Override // com.bytedance.sdk.openadsdk.p.c.c
                public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                    boolean r3 = k.sr().r();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", j4);
                    jSONObject.put("is_async", z3);
                    jSONObject.put("is_multi_process", cVar.k());
                    jSONObject.put("is_debug", sr.c(cVar));
                    jSONObject.put("is_use_texture_view", cVar.p());
                    jSONObject.put("is_activate_init", r3);
                    jSONObject.put("is_plugin", eq.c());
                    jSONObject.put("has_kotlin", sr.w());
                    jSONObject.put("is_androidx", sr.xv());
                    jSONObject.put("host_abi", com.bytedance.sdk.openadsdk.core.gb.w.w.c());
                    jSONObject.put("minSdkVersion", com.bytedance.sdk.openadsdk.core.eq.wv.ev(context));
                    jSONObject.put("targetSdkVersion", com.bytedance.sdk.openadsdk.core.eq.wv.r(context));
                    jSONObject.put("ttvideo_plugin_config", true);
                    jSONObject.put("ttvideo_can_use", eq.w());
                    jSONObject.put("is_keva_init_success", com.bytedance.sdk.openadsdk.core.eq.ba.w());
                    jSONObject.put("thread_name", str);
                    jSONObject.put("thread_priority", i4);
                    jSONObject.put("is_boost", eq.f33187c ? 1 : 0);
                    k.sr().w(false);
                    Object objectValue = valueSet.objectValue(9, Object.class);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("main_cost", j4);
                    jSONObject2.put("callback_cost", j5);
                    jSONObject2.put("total_cost", j6);
                    if (objectValue != null) {
                        jSONObject2.put("plugin", objectValue);
                    }
                    JSONObject jSONObject3 = new JSONObject();
                    nVar.c(jSONObject3, 20L);
                    jSONObject2.put("init", jSONObject3);
                    jSONObject.put("cost", jSONObject2);
                    com.bytedance.sdk.component.utils.a.w("TTAdSdk", "re sdk init");
                    com.bytedance.sdk.openadsdk.core.fz.c.xv w3 = com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("pangle_sdk_init").w(jSONObject.toString());
                    return w3.ux(j5 + "");
                }
            }, "pangle_sdk_init");
        }
    }

    public static boolean c(com.bytedance.sdk.openadsdk.ys.w.xv.c cVar) {
        return cVar.ev() && com.bytedance.sdk.openadsdk.core.eq.ev.c();
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.c
    public com.bytedance.sdk.openadsdk.ys.c.c c() {
        return this.xv;
    }

    @Override // com.bytedance.sdk.openadsdk.ys.w.c
    public void c(Context context, @ForbidWrapParam ValueSet valueSet, @ForbidWrapParam c.InterfaceC0537c interfaceC0537c, @ForbidWrapParam EventListener eventListener) {
        com.bykv.c.c.c.c.b k4 = com.bykv.c.c.c.c.b.k(valueSet);
        if (interfaceC0537c.c("_pangle_init_start_time") != null) {
            k4.h(1, interfaceC0537c.c("_pangle_init_start_time"));
        }
        if (interfaceC0537c.c("_t_n") != null) {
            k4.h(2, interfaceC0537c.c("_t_n"));
        }
        if (interfaceC0537c.c("_t_p") != null) {
            k4.h(3, interfaceC0537c.c("_t_p"));
        }
        if (interfaceC0537c.c("_l_s") != null) {
            k4.h(4, interfaceC0537c.c("_l_s"));
        }
        if (interfaceC0537c.c("_s_c") != null) {
            k4.h(5, interfaceC0537c.c("_s_c"));
        }
        if (interfaceC0537c.c("_ext_api_code") != null) {
            k4.h(6, interfaceC0537c.c("_ext_api_code"));
        }
        if (interfaceC0537c.c("age_group") != null) {
            k4.h(7, interfaceC0537c.c("age_group"));
        }
        if (interfaceC0537c.c("plugin_update_conf") != null) {
            k4.h(8, interfaceC0537c.c("plugin_update_conf"));
        }
        if (interfaceC0537c.c("_sdk_v_c_") != null) {
            k4.h(10, interfaceC0537c.c("_sdk_v_c_"));
        }
        if (interfaceC0537c.c("_sdk_v_n_") != null) {
            k4.h(11, interfaceC0537c.c("_sdk_v_n_"));
        }
        if (interfaceC0537c.c("plugin") != null) {
            k4.h(9, interfaceC0537c.c("plugin"));
        }
        c(context, k4.l(), eventListener);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(final android.content.Context r20, @com.bytedance.pangle.annotations.ForbidWrapParam final com.bykv.vk.openvk.api.proto.ValueSet r21, @com.bytedance.pangle.annotations.ForbidWrapParam final com.bykv.vk.openvk.api.proto.EventListener r22) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.sr.c(android.content.Context, com.bykv.vk.openvk.api.proto.ValueSet, com.bykv.vk.openvk.api.proto.EventListener):void");
    }

    private void c(final EventListener eventListener) {
        com.bytedance.sdk.openadsdk.core.xv.c.c();
        com.bytedance.sdk.component.utils.ev.c().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.sr.4
            @Override // java.lang.Runnable
            public void run() {
                if (eventListener != null) {
                    com.bytedance.sdk.component.utils.a.w("TTAdSdk", "Init done success, call back");
                    eventListener.onEvent(AVMDLDataLoader.KeyIsLiveSetP2pAllow, com.bykv.c.c.c.c.a.a().e(true).f());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@ForbidWrapParam Context context, @ForbidWrapParam com.bytedance.sdk.openadsdk.ys.w.xv.c cVar, @ForbidWrapParam EventListener eventListener, n nVar) {
        if (this.sr) {
            c(eventListener);
            return;
        }
        try {
            c(context, cVar, nVar);
            this.sr = true;
            c(context, cVar);
            nVar.w("async_init_cost");
            com.bytedance.sdk.component.utils.a.f("TTAdSdk", "Init done finish: 6106");
            c(eventListener);
        } catch (Throwable th) {
            if (eventListener != null) {
                String message = th.getMessage();
                if (message == null) {
                    message = "init error";
                }
                eventListener.onEvent(1, com.bykv.c.c.c.c.a.a().e(false).b(4000).d(message).f());
            }
            com.bytedance.sdk.component.utils.a.f("TTAdSdk", "Init done failed");
            this.sr = false;
        }
        c(cVar, this.sr);
    }

    private void c(@ForbidWrapParam Context context, @ForbidWrapParam com.bytedance.sdk.openadsdk.ys.w.xv.c cVar, n nVar) {
        if (com.bytedance.sdk.openadsdk.core.z.f.c()) {
            try {
                if (c(cVar)) {
                    com.bytedance.sdk.openadsdk.core.eq.ia.c();
                    com.bykv.vk.openvk.component.video.api.f.xv.c();
                    com.bytedance.sdk.component.ev.c.c();
                    com.bytedance.sdk.openadsdk.tools.w.w();
                }
            } catch (Throwable unused) {
            }
            nVar.w("debug_set_cost");
            com.bytedance.sdk.openadsdk.core.multipro.sr.c(context);
            nVar.w("web_dir_cost");
            com.bytedance.sdk.component.ev.xv.c.c((ThreadPoolExecutor) com.bytedance.sdk.component.gd.ev.c());
            nVar.w("thread_pool_cost");
            com.bykv.vk.openvk.component.video.api.xv.c(cVar.k());
            if (cVar.k()) {
                com.bytedance.sdk.openadsdk.core.multipro.w.c();
                k.sr().s();
            } else {
                com.bytedance.sdk.openadsdk.core.multipro.w.w();
            }
            nVar.w("multi_cost");
            com.bykv.vk.openvk.component.video.api.xv.c(context, null);
            com.bykv.vk.openvk.component.video.c.c.c(context);
            nVar.w("video_config_cost");
            q.ux();
            nVar.w("dyna_init_cost");
            com.bytedance.sdk.component.panglearmor.f.c(context, String.valueOf(6106), eq.c(context));
            com.bytedance.sdk.component.panglearmor.ev.c(new com.bytedance.sdk.component.panglearmor.r() { // from class: com.bytedance.sdk.openadsdk.core.sr.5
                @Override // com.bytedance.sdk.component.panglearmor.r
                public void c(long j4, boolean z3) {
                    com.bytedance.sdk.component.panglearmor.ev.c((com.bytedance.sdk.component.panglearmor.r) null);
                    com.bytedance.sdk.openadsdk.core.fz.a.c().c(10001, j4, Boolean.valueOf(z3), (String) null);
                }
            });
        }
    }

    private void c(@ForbidWrapParam com.bytedance.sdk.openadsdk.ys.w.xv.c cVar, @ForbidWrapParam ValueSet valueSet) {
        w(cVar, valueSet);
        q.sr();
        com.bytedance.sdk.openadsdk.core.fz.w.w();
        try {
            r();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (cVar.k()) {
            com.bytedance.sdk.openadsdk.core.eq.ba.c();
        }
        com.bytedance.sdk.openadsdk.core.xv.sr.c().c(cVar.k());
    }

    private void c(@ForbidWrapParam final Context context, @ForbidWrapParam final com.bytedance.sdk.openadsdk.ys.w.xv.c cVar) {
        com.bytedance.sdk.component.gd.ev.c(new com.bytedance.sdk.component.gd.p("init sync") { // from class: com.bytedance.sdk.openadsdk.core.sr.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.core.z.r w3 = ls.w();
                    if (!w3.yh()) {
                        synchronized (w3) {
                            if (!w3.yh()) {
                                w3.c();
                            }
                        }
                    }
                    com.bykv.vk.openvk.component.video.api.xv.c(com.bytedance.sdk.openadsdk.core.q.ux.c().w().ux());
                    com.bytedance.sdk.openadsdk.core.fz.w.c(context, cVar.k());
                    yu.xv();
                    com.bykv.vk.openvk.component.video.c.c.c(com.bytedance.sdk.openadsdk.n.ev.c(0));
                    if (w3.ev()) {
                        final com.bykv.vk.openvk.component.video.api.c.w c4 = com.bytedance.sdk.openadsdk.n.ev.c(1);
                        com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("preloadTTVideo") { // from class: com.bytedance.sdk.openadsdk.core.sr.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.bytedance.sdk.component.utils.a.w("TTAdSdk", "init video start");
                                com.bytedance.sdk.component.k.w.w.c(context, c4.sr(), 52428800, com.bytedance.sdk.openadsdk.n.ev.w(), com.bytedance.sdk.openadsdk.n.ev.xv(), sr.c(cVar), new VideoEventEngineUploader() { // from class: com.bytedance.sdk.openadsdk.core.sr.7.1.1
                                    @Override // com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader
                                    public void onEvent(String str, JSONObject jSONObject) {
                                        r.c().c(str, jSONObject);
                                    }
                                });
                            }
                        });
                    }
                    if (k.sr().u() != null) {
                        k.sr().u().call(20, com.bykv.c.c.c.c.b.f24740c, Void.class);
                    } else {
                        com.bytedance.sdk.component.utils.a.f("TTAdSdk", "\u4e0b\u8f7dSDK \u521d\u59cb\u5316\u5931\u8d25 \uff0c bridge = null \uff01\uff01\uff01");
                    }
                    com.bytedance.sdk.openadsdk.core.eq.gd.a();
                    q.c(context);
                    com.bytedance.sdk.component.gd.ev.c(true);
                    com.bytedance.sdk.component.gd.ev.c(new com.bytedance.sdk.openadsdk.core.fz.w.c());
                    com.bytedance.sdk.openadsdk.core.dislike.c.c();
                    com.bytedance.sdk.openadsdk.core.eq.gd.c(context);
                    com.bytedance.sdk.openadsdk.core.eq.gd.ux(context);
                    com.bytedance.sdk.openadsdk.core.eq.gd.f(context);
                    if (eq.ux) {
                        com.bytedance.sdk.openadsdk.tools.w.xv(21, "0");
                        com.bytedance.sdk.openadsdk.tools.w.xv(20, "0");
                        TTLiveCommerceHelper tTLiveCommerceHelper = TTLiveCommerceHelper.getInstance();
                        if (sr.this.ux != null) {
                            tTLiveCommerceHelper.setLiveAdBridge(sr.this.ux);
                            sr.this.ux = null;
                        }
                    }
                    if (com.bytedance.sdk.openadsdk.k.xv.c()) {
                        com.bytedance.sdk.openadsdk.k.c.c(context);
                    }
                    if (Build.VERSION.SDK_INT >= 29) {
                        try {
                            com.bytedance.sdk.component.utils.u.c();
                            com.bytedance.sdk.component.utils.ys.c(new com.bytedance.sdk.openadsdk.n.ux());
                        } catch (Exception unused) {
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.eq.a.c();
                    com.bytedance.sdk.openadsdk.core.eq.ev.c(cVar);
                    com.bytedance.sdk.openadsdk.core.eq.q.c();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.a.sr("TTAdSdk", "Unexpected asyn init error: " + th);
                }
            }
        }, 10);
        final boolean k4 = cVar.k();
        com.bytedance.sdk.component.utils.ev.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.sr.8
            @Override // java.lang.Runnable
            public void run() {
                if (k.sr().ia()) {
                    com.bytedance.sdk.component.utils.a.f("lqmt", "setting req is fb, qw, Sdk.iB: true");
                    return;
                }
                if (k4) {
                    if (com.bytedance.sdk.component.utils.s.c(context)) {
                        com.bytedance.sdk.openadsdk.core.z.ux.c(ls.w()).sr();
                        com.bytedance.sdk.component.utils.a.xv("TTAdSdk", "Load setting in main process");
                    }
                } else {
                    com.bytedance.sdk.openadsdk.core.z.ux.c(ls.w()).sr();
                }
                com.bytedance.sdk.openadsdk.core.fz.w.sr();
            }
        }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        com.bytedance.sdk.component.utils.ev.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.sr.9
            @Override // java.lang.Runnable
            public void run() {
                if (k.sr().ia()) {
                    com.bytedance.sdk.component.utils.a.f("lqmt", "upApL is fb, qw, Sdk.iB: true");
                } else {
                    com.bytedance.sdk.openadsdk.t.c.xv();
                }
            }
        }, 60000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@ForbidWrapParam final Context context, final long j4, final long j5, final long j6, final n nVar, final boolean z3, final com.bytedance.sdk.openadsdk.ys.w.xv.c cVar, final String str, final int i4, @ForbidWrapParam final ValueSet valueSet) {
        com.bytedance.sdk.component.utils.ev.c().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.sr.10
            @Override // java.lang.Runnable
            public void run() {
                try {
                    sr.this.w(context, j4, j5, j6, nVar, z3, cVar, str, i4, valueSet);
                } catch (Throwable unused) {
                }
            }
        }, 5000L);
    }
}
