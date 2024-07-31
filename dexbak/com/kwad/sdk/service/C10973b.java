package com.kwad.sdk.service;

import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.core.internal.api.C8680d;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.internal.api.VideoPlayConfigImpl;
import com.kwad.components.core.p318p.C8770b;
import com.kwad.components.core.p327r.p328a.C8902a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.page.AdWebViewVideoActivityProxy;
import com.kwad.components.core.page.C8791a;
import com.kwad.components.core.page.C8836d;
import com.kwad.components.p208ad.feed.FeedDownloadActivityProxy;
import com.kwad.components.p208ad.fullscreen.KsFullScreenLandScapeVideoActivityProxy;
import com.kwad.components.p208ad.fullscreen.KsFullScreenVideoActivityProxy;
import com.kwad.components.p208ad.reward.KSRewardLandScapeVideoActivityProxy;
import com.kwad.components.p208ad.reward.KSRewardVideoActivityProxy;
import com.kwad.framework.filedownloader.services.FileDownloadServiceProxy;
import com.kwad.sdk.collector.p371b.C9787a;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.kwad.sdk.service.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C10973b {
    private static final Map<Class<?>, Class<?>> aNV = new HashMap();
    private static final Map<Class<?>, Class<?>> aNW = new HashMap();
    private static boolean aNX = false;
    private static boolean aNY = false;

    /* renamed from: KJ */
    private static synchronized void m24295KJ() {
        synchronized (C10973b.class) {
            if (aNX) {
                return;
            }
            m24294KK();
            aNX = true;
        }
    }

    @ForInvoker(methodId = "initComponentProxyForInvoker")
    /* renamed from: KK */
    private static void m24294KK() {
        FeedDownloadActivityProxy.register();
        KsFullScreenLandScapeVideoActivityProxy.register();
        KsFullScreenVideoActivityProxy.register();
        KSRewardLandScapeVideoActivityProxy.register();
        KSRewardVideoActivityProxy.register();
        C8791a.register();
        AdWebViewActivityProxy.register();
        AdWebViewVideoActivityProxy.register();
        C8836d.register();
        C8902a.register();
        FileDownloadServiceProxy.register();
        C9787a.register();
        C10961a.register();
    }

    /* renamed from: KL */
    private static synchronized void m24293KL() {
        synchronized (C10973b.class) {
            if (aNY) {
                return;
            }
            m24292KM();
            aNY = true;
        }
    }

    @ForInvoker(methodId = "initModeImplForInvoker")
    /* renamed from: KM */
    private static void m24292KM() {
        KSAdVideoPlayConfigImpl.register();
        C8680d.register();
        VideoPlayConfigImpl.register();
        C8770b.register();
        SceneImpl.register();
    }

    /* renamed from: a */
    public static void m24291a(Class<?> cls, Class<?> cls2) {
        aNV.put(cls, cls2);
    }

    /* renamed from: b */
    public static void m24290b(Class cls, Class cls2) {
        aNW.put(cls, cls2);
    }

    /* renamed from: g */
    public static Class<?> m24289g(Class<?> cls) {
        m24295KJ();
        return aNV.get(cls);
    }

    /* renamed from: h */
    public static Class<?> m24288h(Class<?> cls) {
        m24293KL();
        return aNW.get(cls);
    }

    public static void init() {
        m24295KJ();
        m24293KL();
    }
}
