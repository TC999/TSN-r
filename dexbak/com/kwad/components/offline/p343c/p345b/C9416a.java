package com.kwad.components.offline.p343c.p345b;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.components.offline.api.p341tk.ITkOfflineCompo;
import com.kwad.components.offline.api.p341tk.TkLoggerReporter;
import com.kwad.components.offline.api.p341tk.model.report.TKDownloadMsg;
import com.kwad.library.p355b.C9586a;
import com.kwad.library.solder.lib.ext.InterfaceC9629b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.p360a.AbstractC9604a;
import com.kwad.library.solder.lib.p360a.AbstractC9608e;
import com.kwad.library.solder.lib.p361b.C9614c;
import com.kwad.library.solder.lib.p362c.C9617b;
import com.kwad.library.solder.p359a.C9602a;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.network.idc.C10425a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.C11006aa;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.components.offline.c.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9416a {
    private static long adB;
    private static final AtomicBoolean acE = new AtomicBoolean(false);
    private static final String adv = C11006aa.format("lib%s.so", "tk_runtime_v0_0_38");
    private static final String adw = C11006aa.format("lib%s.so", "tk_runtime_lite_v0_0_38");
    private static final String adx = C11006aa.format("lib%s.so", "kwai-v8");
    private static final String ady = C11006aa.format("lib%s.so", "kwai-v8-lite");
    private static final String adz = C11006aa.format("lib%s.so", "kwad-fb");
    private static final String adA = C11006aa.format("lib%s.so", "kwad-yoga");
    private static final String acF = C11006aa.format("lib%s.so", "c++_shared");
    private static Boolean adC = null;

    /* renamed from: a */
    public static void m28839a(Context context, @NonNull final SoLoadListener soLoadListener) {
        String m26586BH;
        String str;
        String str2;
        AtomicBoolean atomicBoolean = acE;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        HashMap<String, String> hashMap = new HashMap<>();
        boolean useTkLite = useTkLite();
        if (AbiUtil.isArm64(context)) {
            m26586BH = C10251d.m26585BI();
            if (TextUtils.isEmpty(m26586BH)) {
                m26586BH = useTkLite ? "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/ks_tk_so_v8_lite_3334" : "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/ks_tk_so_v8_3334";
            }
            str = useTkLite ? "sotk-v8a-lite" : "sotk-v8a";
            str2 = useTkLite ? "39df505f83794e951720e9c753824d0c" : "2c0fb7069df4a3e6fd55e417229bcb6b";
            if (useTkLite) {
                hashMap.put(adw, "a5009e795307441cc05dbd3e8aeaead3");
                hashMap.put(ady, "77545ba1892c1a1d4a039db37b3249eb");
            } else {
                hashMap.put(adv, "e1478b9b4f377d667c7e510e88ae1bcb");
                hashMap.put(adx, "7316cd8d074b04e6cb21486288d314ce");
            }
            hashMap.put(adz, "31f065607e6da6b741330d1df0b35460");
            hashMap.put(adA, "76308532f64b68fd5a930c42cceec22b");
            hashMap.put(acF, "6ca7958ee0b0192a7c52c16faffaa8ba");
        } else {
            m26586BH = C10251d.m26586BH();
            if (TextUtils.isEmpty(m26586BH)) {
                m26586BH = useTkLite ? "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/ks_tk_so_v7_lite_3334" : "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/tachikoma/ks_tk_so_v7_3334";
            }
            str = useTkLite ? "sotk-v7a-lite" : "sotk-v7a";
            str2 = useTkLite ? "a46a370ee3a1a61a0d6041b3c69c0ab7" : "f8d270613187202ab45cfec0dca9deee";
            if (useTkLite) {
                hashMap.put(adw, "8ffd76abe9e5fe33f4035b56b9d6e8e3");
                hashMap.put(ady, "2dbd72527a0739740746adaae48ed2e0");
            } else {
                hashMap.put(adv, "55e6b8f6cd2091d8f8412dafcf9f381a");
                hashMap.put(adx, "519ba633e88efafb8fbd536d800da734");
            }
            hashMap.put(adz, "eff11bebb8a3c872fa30b0484b460d12");
            hashMap.put(adA, "2c6f402c6a565d2e6912b0013fa59380");
            hashMap.put(acF, "7cb16c2840085bbdf4be628e6604bac1");
        }
        C9617b c9617b = new C9617b();
        c9617b.akg = C10425a.m26107DU().m26085dU(m26586BH);
        c9617b.f29489Jd = true;
        c9617b.akf = str;
        c9617b.version = useTkLite ? "3.3.59-lite" : "3.3.59";
        c9617b.akj = false;
        c9617b.aki = str2;
        c9617b.akl = hashMap;
        C9586a m28255i = C9602a.m28255i(context, ITkOfflineCompo.PACKAGE_NAME);
        C10331c.m26254d("TkSoLoadHelper", "tkOfflineCompoPlugin: " + m28255i);
        if (m28255i instanceof C9586a) {
            c9617b.ako = m28255i.m28309wU();
        }
        C9602a.m28256a(context, c9617b, new InterfaceC9629b.C9632c() { // from class: com.kwad.components.offline.c.b.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: b */
            public void mo28157e(C9614c c9614c) {
                super.mo28157e(c9614c);
                SoLoadListener.this.onPreUpdate();
                long unused = C9416a.adB = SystemClock.elapsedRealtime();
                TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(0).setRetryCount(c9614c.m28223xr()).setThreadPoolCoreSize(c9614c.m28229xl().mo28177wY().m28147xz()).toJson());
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: c */
            public void mo25119d(C9614c c9614c) {
                super.mo25119d(c9614c);
                if (c9614c.getState() == 4) {
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setRetryCount(c9614c.m28223xr()).setDownloadTime(SystemClock.elapsedRealtime() - C9416a.adB).setDownloadState(1).setThreadPoolCoreSize(c9614c.m28229xl().mo28177wY().m28147xz()).toJson());
                }
            }

            /* renamed from: tG */
            private void m28833tG() {
                SoLoadListener.this.onLoaded();
            }

            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: a */
            public final /* synthetic */ void mo24651a(AbstractC9608e abstractC9608e, AbstractC9604a abstractC9604a) {
                m28833tG();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: a */
            public void mo24650a(C9614c c9614c, PluginError pluginError) {
                SoLoadListener.this.onFailed(pluginError.getCode(), pluginError);
                if (c9614c.getState() == 1) {
                    TkLoggerReporter.get().reportTKSODownload(ILoggerReporter.Category.ERROR_LOG, new TKDownloadMsg().setRetryCount(c9614c.m28223xr()).setErrorReason(String.valueOf(pluginError.getCode())).setDownloadState(2).toJson());
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.library.solder.lib.ext.InterfaceC9629b.C9631b, com.kwad.library.solder.lib.ext.InterfaceC9629b
            /* renamed from: a */
            public void mo25118f(C9614c c9614c) {
                super.mo25118f(c9614c);
            }
        });
    }

    public static boolean useTkLite() {
        if (adC == null) {
            adC = Boolean.valueOf(!C10251d.m26527a(C10250c.aqY));
        }
        return adC.booleanValue();
    }
}
