package com.kwad.components.core.p304n.p311b.p312a;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.p296g.C8660d;
import com.kwad.components.core.p304n.p311b.p313b.C8737a;
import com.kwad.components.core.p304n.p311b.p314c.C8757e;
import com.kwad.components.core.p304n.p311b.p315d.C8761b;
import com.kwad.components.core.webview.tachikoma.C9295g;
import com.kwad.components.core.webview.tachikoma.C9303h;
import com.kwad.components.offline.api.core.IOfflineHostApi;
import com.kwad.components.offline.api.core.adlive.ILive;
import com.kwad.components.offline.api.core.api.IAsync;
import com.kwad.components.offline.api.core.api.IBundleLoadListener;
import com.kwad.components.offline.api.core.api.IBundleService;
import com.kwad.components.offline.api.core.api.ICache;
import com.kwad.components.offline.api.core.api.ICrash;
import com.kwad.components.offline.api.core.api.ICrashCustomKeyValue;
import com.kwad.components.offline.api.core.api.ICrashOccurListener;
import com.kwad.components.offline.api.core.api.IDownloader;
import com.kwad.components.offline.api.core.api.IEncrypt;
import com.kwad.components.offline.api.core.api.IEnvironment;
import com.kwad.components.offline.api.core.api.IFlowUuid;
import com.kwad.components.offline.api.core.api.IImageLoader;
import com.kwad.components.offline.api.core.api.ILifeCycle;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.core.api.INet;
import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;
import com.kwad.components.offline.api.core.api.ISystemProperties;
import com.kwad.components.offline.api.core.api.IVibratorUtil;
import com.kwad.components.offline.api.core.api.IZipper;
import com.kwad.components.offline.api.core.imageplayer.IImagePlayer;
import com.kwad.components.offline.api.core.network.IIdc;
import com.kwad.components.offline.api.core.network.INetworkManager;
import com.kwad.components.offline.api.core.video.IVideo;
import com.kwad.components.offline.api.core.webview.IWebView;
import com.kwad.components.offline.api.p341tk.model.report.TKExceptionUploadParams;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.download.C10296a;
import com.kwad.sdk.service.C10974c;
import com.kwad.sdk.service.p449a.InterfaceC10965c;
import com.kwad.sdk.service.p449a.InterfaceC10969g;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.utils.C11026as;
import com.kwad.sdk.utils.C11061bk;
import java.io.File;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.n.b.a.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8720j implements IOfflineHostApi {

    /* renamed from: MQ */
    private IAsync f28391MQ;

    /* renamed from: MR */
    private IEnvironment f28392MR;

    /* renamed from: MS */
    private IZipper f28393MS;

    /* renamed from: MT */
    private INet f28394MT;

    /* renamed from: MU */
    private IEncrypt f28395MU;

    /* renamed from: MV */
    private IOfflineCompoLogcat f28396MV;

    /* renamed from: MW */
    private ICrash f28397MW;

    /* renamed from: MX */
    private ILoggerReporter f28398MX;

    /* renamed from: MY */
    private IDownloader f28399MY;

    /* renamed from: MZ */
    private IImageLoader f28400MZ;

    /* renamed from: Na */
    private IVideo f28401Na;

    /* renamed from: Nb */
    private ILive f28402Nb;

    /* renamed from: Nc */
    private ICache f28403Nc;

    /* renamed from: Nd */
    private IWebView f28404Nd;

    /* renamed from: Ne */
    private IVibratorUtil f28405Ne;

    /* renamed from: Nf */
    private IIdc f28406Nf;

    /* renamed from: Ng */
    private IImagePlayer f28407Ng;

    /* renamed from: Nh */
    private ILifeCycle f28408Nh;

    /* renamed from: Ni */
    private INetworkManager f28409Ni;

    /* renamed from: Nj */
    private ISystemProperties f28410Nj;

    /* renamed from: Nk */
    private IFlowUuid f28411Nk;

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IAsync async() {
        if (this.f28391MQ == null) {
            this.f28391MQ = new C8704a();
        }
        return this.f28391MQ;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IBundleService bundleService() {
        return new IBundleService() { // from class: com.kwad.components.core.n.b.a.j.4
            @Override // com.kwad.components.offline.api.core.api.IBundleService
            public final void loadBundle(Context context, String str, final IBundleLoadListener iBundleLoadListener) {
                C9295g.m29088sy().m29089b(context, str, new C9295g.InterfaceC9301b() { // from class: com.kwad.components.core.n.b.a.j.4.1
                    @Override // com.kwad.components.core.webview.tachikoma.C9295g.InterfaceC9301b
                    public final void onFailed(String str2) {
                        IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                        if (iBundleLoadListener2 != null) {
                            iBundleLoadListener2.onFailed(str2);
                        }
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.C9295g.InterfaceC9301b
                    public final void onSuccess() {
                        IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                        if (iBundleLoadListener2 != null) {
                            iBundleLoadListener2.onSuccess();
                        }
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.api.IBundleService
            public final void loadBundleWithString(Context context, String str, final IBundleLoadListener iBundleLoadListener) {
                C9295g.m29088sy().m29092a(context, str, new C9295g.InterfaceC9301b() { // from class: com.kwad.components.core.n.b.a.j.4.2
                    @Override // com.kwad.components.core.webview.tachikoma.C9295g.InterfaceC9301b
                    public final void onFailed(String str2) {
                        IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                        if (iBundleLoadListener2 != null) {
                            iBundleLoadListener2.onFailed(str2);
                        }
                    }

                    @Override // com.kwad.components.core.webview.tachikoma.C9295g.InterfaceC9301b
                    public final void onSuccess() {
                        IBundleLoadListener iBundleLoadListener2 = iBundleLoadListener;
                        if (iBundleLoadListener2 != null) {
                            iBundleLoadListener2.onSuccess();
                        }
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.api.IBundleService
            public final void unloadBundle(String str) {
                C9295g.m29088sy().unloadBundle(str);
            }
        };
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICache cache() {
        if (this.f28403Nc == null) {
            this.f28403Nc = new C8705b();
        }
        return this.f28403Nc;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ICrash crash() {
        if (this.f28397MW == null) {
            this.f28397MW = new ICrash() { // from class: com.kwad.components.core.n.b.a.j.1
                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void addCustomKeyValue(final ICrashCustomKeyValue iCrashCustomKeyValue) {
                    C10974c.m24285b(new InterfaceC10965c() { // from class: com.kwad.components.core.n.b.a.j.1.1
                        @Override // com.kwad.sdk.service.p449a.InterfaceC10965c
                        public final String getKey() {
                            ICrashCustomKeyValue iCrashCustomKeyValue2 = iCrashCustomKeyValue;
                            if (iCrashCustomKeyValue2 != null) {
                                return iCrashCustomKeyValue2.getKey();
                            }
                            return null;
                        }

                        @Override // com.kwad.sdk.service.p449a.InterfaceC10965c
                        public final JSONObject getValue() {
                            ICrashCustomKeyValue iCrashCustomKeyValue2 = iCrashCustomKeyValue;
                            if (iCrashCustomKeyValue2 != null) {
                                return iCrashCustomKeyValue2.getValue();
                            }
                            return null;
                        }
                    });
                }

                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void addOnCrashListener(final ICrashOccurListener iCrashOccurListener) {
                    C10974c.m24286a(new InterfaceC10969g() { // from class: com.kwad.components.core.n.b.a.j.1.2
                        @Override // com.kwad.sdk.service.p449a.InterfaceC10969g
                        /* renamed from: l */
                        public final void mo24328l(int i, String str) {
                            ICrashOccurListener iCrashOccurListener2 = iCrashOccurListener;
                            if (iCrashOccurListener2 != null) {
                                iCrashOccurListener2.onCrashOccur(i, str);
                            }
                        }
                    });
                }

                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void gatherException(Throwable th) {
                    C10974c.gatherException(th);
                }

                @Override // com.kwad.components.offline.api.core.api.ICrash
                public final void gatherException(TKExceptionUploadParams tKExceptionUploadParams) {
                    C10974c.m24287G(tKExceptionUploadParams.key, tKExceptionUploadParams.toJson().toString());
                }
            };
        }
        return this.f28397MW;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IDownloader downloader() {
        if (this.f28399MY == null) {
            this.f28399MY = new IDownloader() { // from class: com.kwad.components.core.n.b.a.j.3
                @Override // com.kwad.components.offline.api.core.api.IDownloader
                @WorkerThread
                public final boolean downloadSync(File file, String str) {
                    return C10296a.m26374d(str, file);
                }
            };
        }
        return this.f28399MY;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEncrypt encrypt() {
        if (this.f28395MU == null) {
            this.f28395MU = new C8706c();
        }
        return this.f28395MU;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IEnvironment env() {
        if (this.f28392MR == null) {
            this.f28392MR = new C8707d();
        }
        return this.f28392MR;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IFlowUuid flowUuid() {
        if (this.f28411Nk == null) {
            this.f28411Nk = new C8708e();
        }
        return this.f28411Nk;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getAppIconId(Context context) {
        return C11026as.getAppIconId(context);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getDrawableId(Context context, String str) {
        return C11026as.m24082at(context, str);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getId(Context context, String str) {
        return C11026as.getId(context, str);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final long getSystemTimeInMs(Context context, boolean z) {
        return C11061bk.m23868v(context, z);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final int getTKErrorDetailCount() {
        return C10251d.getTKErrorDetailCount();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final List<String> getTKPreloadMemCacheTemplates() {
        return C10251d.getTKPreloadMemCacheTemplates();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IIdc idc() {
        if (this.f28406Nf == null) {
            this.f28406Nf = new C8731m();
        }
        return this.f28406Nf;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IImageLoader imageLoader() {
        if (this.f28400MZ == null) {
            this.f28400MZ = new C8709f();
        }
        return this.f28400MZ;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IImagePlayer imagePlayer() {
        C8660d c8660d = new C8660d();
        this.f28407Ng = c8660d;
        return c8660d;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final boolean isOrientationPortrait() {
        return C11015ai.isOrientationPortrait();
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILifeCycle lifeCycle() {
        if (this.f28408Nh == null) {
            this.f28408Nh = new C8714g();
        }
        return this.f28408Nh;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILive live() {
        if (this.f28402Nb == null) {
            this.f28402Nb = new C8737a();
        }
        return this.f28402Nb;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IOfflineCompoLogcat log() {
        if (this.f28396MV == null) {
            this.f28396MV = new C8729k();
        }
        return this.f28396MV;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ILoggerReporter loggerReporter() {
        if (this.f28398MX == null) {
            this.f28398MX = new ILoggerReporter() { // from class: com.kwad.components.core.n.b.a.j.2
                @Override // com.kwad.components.offline.api.core.api.ILoggerReporter
                public final void reportEvent(C9821c c9821c) {
                    C9815b.m27672d(c9821c);
                }
            };
        }
        return this.f28398MX;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final INet net() {
        if (this.f28394MT == null) {
            this.f28394MT = new C8716h();
        }
        return this.f28394MT;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final INetworkManager networkManager() {
        if (this.f28409Ni == null) {
            this.f28409Ni = new C8717i();
        }
        return this.f28409Ni;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final void saveTKTemplateCache(String str, int i, String str2) {
        C9303h.m29077sB().m29080b(str, i, str2);
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final ISystemProperties systemProperty() {
        if (this.f28410Nj == null) {
            this.f28410Nj = new C8732n();
        }
        return this.f28410Nj;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IVibratorUtil vibratorUtil() {
        if (this.f28405Ne == null) {
            this.f28405Ne = new C8733o();
        }
        return this.f28405Ne;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IVideo video() {
        if (this.f28401Na == null) {
            this.f28401Na = new C8757e();
        }
        return this.f28401Na;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IWebView webview() {
        if (this.f28404Nd == null) {
            this.f28404Nd = new C8761b();
        }
        return this.f28404Nd;
    }

    @Override // com.kwad.components.offline.api.core.IOfflineHostApi
    public final IZipper zipper() {
        if (this.f28393MS == null) {
            this.f28393MS = new C8734p();
        }
        return this.f28393MS;
    }
}
