package com.kwad.components.core.webview.tachikoma;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.github.mikephil.charting.utils.Utils;
import com.kwad.components.core.C8526a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p289e.p294e.C8642g;
import com.kwad.components.core.p289e.p294e.InterfaceC8641f;
import com.kwad.components.core.p304n.p305a.p309d.InterfaceC8701c;
import com.kwad.components.core.p304n.p305a.p309d.p310a.C8699a;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.webview.jshandler.C9031a;
import com.kwad.components.core.webview.jshandler.C9036aa;
import com.kwad.components.core.webview.jshandler.C9043ac;
import com.kwad.components.core.webview.jshandler.C9046ad;
import com.kwad.components.core.webview.jshandler.C9057ag;
import com.kwad.components.core.webview.jshandler.C9067aj;
import com.kwad.components.core.webview.jshandler.C9072ak;
import com.kwad.components.core.webview.jshandler.C9091ap;
import com.kwad.components.core.webview.jshandler.C9092aq;
import com.kwad.components.core.webview.jshandler.C9107av;
import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.core.webview.jshandler.C9119az;
import com.kwad.components.core.webview.jshandler.C9161l;
import com.kwad.components.core.webview.jshandler.C9163m;
import com.kwad.components.core.webview.jshandler.C9166o;
import com.kwad.components.core.webview.jshandler.C9169p;
import com.kwad.components.core.webview.jshandler.C9185x;
import com.kwad.components.core.webview.jshandler.C9189y;
import com.kwad.components.core.webview.jshandler.C9191z;
import com.kwad.components.core.webview.tachikoma.p333a.AbstractC9196d;
import com.kwad.components.core.webview.tachikoma.p333a.C9193a;
import com.kwad.components.core.webview.tachikoma.p333a.C9195c;
import com.kwad.components.core.webview.tachikoma.p333a.C9200f;
import com.kwad.components.core.webview.tachikoma.p333a.C9207j;
import com.kwad.components.core.webview.tachikoma.p333a.C9208k;
import com.kwad.components.core.webview.tachikoma.p333a.C9213l;
import com.kwad.components.core.webview.tachikoma.p333a.C9216o;
import com.kwad.components.core.webview.tachikoma.p333a.C9218p;
import com.kwad.components.core.webview.tachikoma.p333a.C9220r;
import com.kwad.components.core.webview.tachikoma.p333a.C9221s;
import com.kwad.components.core.webview.tachikoma.p333a.C9223t;
import com.kwad.components.core.webview.tachikoma.p333a.C9228v;
import com.kwad.components.core.webview.tachikoma.p333a.C9232x;
import com.kwad.components.core.webview.tachikoma.p334b.C9241b;
import com.kwad.components.core.webview.tachikoma.p334b.C9246g;
import com.kwad.components.core.webview.tachikoma.p334b.C9252m;
import com.kwad.components.core.webview.tachikoma.p334b.C9253n;
import com.kwad.components.core.webview.tachikoma.p334b.C9257r;
import com.kwad.components.core.webview.tachikoma.p334b.C9258s;
import com.kwad.components.core.webview.tachikoma.p334b.C9259t;
import com.kwad.components.core.webview.tachikoma.p334b.C9264y;
import com.kwad.components.core.webview.tachikoma.p335c.DialogFragmentC9274e;
import com.kwad.components.core.webview.tachikoma.p336d.C9283b;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.p341tk.ITkOfflineCompo;
import com.kwad.components.offline.api.p341tk.TKDownloadListener;
import com.kwad.components.offline.api.p341tk.TkLoggerReporter;
import com.kwad.components.offline.api.p341tk.model.StyleTemplate;
import com.kwad.components.offline.api.p341tk.model.report.TKPerformMsg;
import com.kwad.sdk.C10756f;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.commercial.p376e.C9830a;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.components.InterfaceC9867h;
import com.kwad.sdk.components.InterfaceC9868i;
import com.kwad.sdk.components.InterfaceC9869j;
import com.kwad.sdk.components.InterfaceC9870k;
import com.kwad.sdk.components.InterfaceC9872m;
import com.kwad.sdk.components.InterfaceC9873n;
import com.kwad.sdk.components.InterfaceC9874o;
import com.kwad.sdk.components.InterfaceC9875p;
import com.kwad.sdk.components.InterfaceC9876q;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.download.C10296a;
import com.kwad.sdk.core.download.C10303b;
import com.kwad.sdk.core.download.C10326d;
import com.kwad.sdk.core.download.C10327e;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.network.C10415c;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.core.view.InterfaceC10592b;
import com.kwad.sdk.core.view.InterfaceC10594d;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.C10643e;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10631g;
import com.kwad.sdk.core.webview.p423d.C10633a;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10636b;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.utils.C11029av;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.utils.C11100i;
import com.kwad.sdk.utils.C11122q;
import com.kwad.sdk.utils.C11128v;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.PathCenter;
import io.netty.handler.codec.http.multipart.HttpPostBodyUtil;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Future;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.tachikoma.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9305i implements InterfaceC8641f, InterfaceC9873n, InterfaceC10592b, InterfaceC10635a {

    /* renamed from: Zb */
    private static Map<Integer, WeakReference<DialogFragmentC9274e>> f29358Zb = new HashMap();

    /* renamed from: EW */
    private long f29359EW;

    /* renamed from: SA */
    private StyleTemplate f29360SA;

    /* renamed from: VB */
    private C10326d f29361VB;

    /* renamed from: YI */
    private DialogFragmentC9274e f29362YI;

    /* renamed from: YJ */
    protected InterfaceC9339j f29363YJ;

    /* renamed from: YK */
    private InterfaceC10631g f29364YK;

    /* renamed from: YL */
    private InterfaceC8701c f29365YL;

    /* renamed from: YM */
    private Future<?> f29366YM;

    /* renamed from: YN */
    private InterfaceC9876q f29367YN;

    /* renamed from: YO */
    private C9218p f29368YO;

    /* renamed from: YP */
    private C9107av f29369YP;

    /* renamed from: YQ */
    private InterfaceC10594d f29370YQ;

    /* renamed from: YR */
    private boolean f29371YR;

    /* renamed from: YS */
    private boolean f29372YS;

    /* renamed from: YT */
    private boolean f29373YT;

    /* renamed from: YU */
    private boolean f29374YU;

    /* renamed from: YV */
    private boolean f29375YV;

    /* renamed from: YW */
    private int f29376YW;

    /* renamed from: YX */
    private long f29377YX;

    /* renamed from: YY */
    private long f29378YY;

    /* renamed from: YZ */
    private long f29379YZ;

    /* renamed from: Za */
    private Map<String, Object> f29380Za;

    /* renamed from: Zc */
    private int f29381Zc;

    /* renamed from: Zd */
    private int f29382Zd;

    /* renamed from: Ze */
    private boolean f29383Ze;

    /* renamed from: Zf */
    private String f29384Zf;

    /* renamed from: Zg */
    private String f29385Zg;

    /* renamed from: Zh */
    protected C10643e f29386Zh;

    /* renamed from: Zi */
    private InterfaceC9338a f29387Zi;

    /* renamed from: Zj */
    private InterfaceC9874o f29388Zj;

    /* renamed from: Zk */
    private InterfaceC9869j f29389Zk;

    /* renamed from: Zl */
    private final Runnable f29390Zl;

    /* renamed from: Zm */
    private final Runnable f29391Zm;

    /* renamed from: cQ */
    private C9109aw f29392cQ;

    /* renamed from: gO */
    private final C9002l f29393gO;
    @Nullable
    private Activity mActivity;
    private AdResultData mAdResultData;
    protected final Context mContext;

    /* renamed from: wp */
    private final C9264y f29394wp;

    /* renamed from: xs */
    protected long f29395xs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.webview.tachikoma.i$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9338a {
        void onFailed();

        void onSuccess();
    }

    public C9305i(Context context) {
        this(context, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aB */
    public InterfaceC9868i m29053aB(final AdTemplate adTemplate) {
        final C8619c c8619c = new C8619c(adTemplate);
        c8619c.m30138ob();
        return new InterfaceC9868i() { // from class: com.kwad.components.core.webview.tachikoma.i.24
            @Override // com.kwad.sdk.components.InterfaceC9868i
            /* renamed from: a */
            public final void mo27493a(final InterfaceC9867h interfaceC9867h) {
                c8619c.m30151b(new AbstractC10298a() { // from class: com.kwad.components.core.webview.tachikoma.i.24.1
                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFailed() {
                        interfaceC9867h.onDownloadFailed();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadFinished() {
                        interfaceC9867h.onDownloadFinished();
                    }

                    @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a, com.kwad.sdk.api.KsAppDownloadListener
                    public final void onDownloadStarted() {
                        interfaceC9867h.onDownloadStarted();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onIdle() {
                        interfaceC9867h.onIdle();
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onInstalled() {
                        interfaceC9867h.onInstalled();
                    }

                    @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
                    public final void onPaused(int i) {
                        interfaceC9867h.onPaused(i);
                    }

                    @Override // com.kwad.sdk.api.KsAppDownloadListener
                    public final void onProgressUpdate(int i) {
                        interfaceC9867h.onProgressUpdate(i);
                    }
                });
            }

            @Override // com.kwad.sdk.components.InterfaceC9868i
            public final void cancelDownload() {
                C10296a.m26370dx(C10487e.m25638dT(adTemplate));
            }

            @Override // com.kwad.sdk.components.InterfaceC9868i
            public final void installApp() {
                c8619c.m30133og();
            }

            @Override // com.kwad.sdk.components.InterfaceC9868i
            public final void openApp() {
                c8619c.m30135oe();
            }

            @Override // com.kwad.sdk.components.InterfaceC9868i
            public final void pauseDownload() {
                c8619c.m30131oi();
            }

            @Override // com.kwad.sdk.components.InterfaceC9868i
            public final void resumeDownload() {
                c8619c.m30130oj();
            }

            @Override // com.kwad.sdk.components.InterfaceC9868i
            public final void setCustomReportParam(String str) {
                try {
                    c8619c.m30145d(new JSONObject(str));
                } catch (Throwable th) {
                    C10331c.printStackTrace(th);
                }
            }

            @Override // com.kwad.sdk.components.InterfaceC9868i
            public final void startDownload() {
                c8619c.m30132oh();
            }

            @Override // com.kwad.sdk.components.InterfaceC9868i
            public final void stopDownload() {
                c8619c.m30131oi();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aP */
    public void m29052aP(String str) {
        m29047b(TKRenderFailReason.TK_FILE_LOAD_ERROR);
        m29050aR(str);
    }

    /* renamed from: aQ */
    private static StyleTemplate m29051aQ(String str) {
        C9861c.m27501f(DevelopMangerComponents.class);
        return null;
    }

    /* renamed from: aR */
    private void m29050aR(String str) {
        mo29036f(this.f29363YJ.getTkTemplateId(), str);
        StyleTemplate m29014sH = m29014sH();
        if (m29014sH == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.f29376YW).setRenderState(4).setErrorReason(str).setTemplateId(this.f29363YJ.getTkTemplateId()).setVersionCode(String.valueOf(m29014sH.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: aS */
    public void m29049aS(String str) {
        C10331c.m26254d("TKLoadController", "logTkRenderFail : " + str + ", templateId = " + this.f29363YJ.getTkTemplateId());
        mo29033g(this.f29363YJ.getTkTemplateId(), str);
        if (!this.f29373YT || this.f29374YU) {
            return;
        }
        this.f29374YU = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.f29376YW).setRenderState(2).setErrorReason(str).setTemplateId(this.f29363YJ.getTkTemplateId()).setVersionCode(String.valueOf(this.f29360SA.templateVersionCode)).toJson());
    }

    private static boolean isLocalDebugEnable() {
        C9861c.m27501f(DevelopMangerComponents.class);
        return false;
    }

    /* renamed from: sE */
    private void m29017sE() {
        this.f29373YT = false;
        this.f29374YU = false;
        this.f29371YR = false;
        this.f29372YS = false;
        this.f29375YV = false;
        this.f29359EW = 0L;
        this.f29378YY = 0L;
        this.f29379YZ = 0L;
        this.f29377YX = 0L;
    }

    /* renamed from: sF */
    private void m29016sF() {
        if (isLocalDebugEnable()) {
            this.f29381Zc = 2000;
            this.f29382Zd = 3000;
        }
        C11064bn.runOnUiThreadDelay(this.f29390Zl, this.f29381Zc);
        int i = this.f29382Zd;
        if (i > 0) {
            C11064bn.runOnUiThreadDelay(this.f29391Zm, i);
        }
        this.f29366YM = GlobalThreadPools.m25601FH().submit(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.tachikoma.i.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9305i.this.f29359EW = SystemClock.elapsedRealtime();
                C10331c.m26254d("TKLoadController", "开始读取模板 id: " + C9305i.this.f29363YJ.getTkTemplateId());
                C9305i.this.m29061a(new TKDownloadListener() { // from class: com.kwad.components.core.webview.tachikoma.i.1.1
                    @Override // com.kwad.components.offline.api.p341tk.TKDownloadListener
                    public final void onFailed(String str) {
                        C9305i.this.m29052aP(str);
                    }

                    @Override // com.kwad.components.offline.api.p341tk.TKDownloadListener
                    public final void onSuccess(@NonNull StyleTemplate styleTemplate) {
                        C9305i.this.m29043b(styleTemplate);
                    }
                });
            }
        });
    }

    /* renamed from: sG */
    private static boolean m29015sG() {
        C9861c.m27501f(DevelopMangerComponents.class);
        return false;
    }

    /* renamed from: sH */
    private StyleTemplate m29014sH() {
        String tkTemplateId = this.f29363YJ.getTkTemplateId();
        StyleTemplate styleTemplate = this.f29360SA;
        if (styleTemplate != null) {
            tkTemplateId = styleTemplate.templateId;
        }
        StyleTemplate m29051aQ = m29051aQ(tkTemplateId);
        if (m29051aQ != null) {
            return m29051aQ;
        }
        if (isLocalDebugEnable()) {
            StyleTemplate styleTemplate2 = new StyleTemplate();
            styleTemplate2.templateId = tkTemplateId;
            styleTemplate2.templateVersion = "1.0.4";
            styleTemplate2.templateVersionCode = 104;
            if (m29015sG()) {
                styleTemplate2.templateUrl = "http://" + OfflineHostProvider.getApi().env().localIpAddress() + ":9292/" + tkTemplateId + ".104.coverage.zip";
            } else {
                styleTemplate2.templateUrl = "http://" + OfflineHostProvider.getApi().env().localIpAddress() + ":9292/" + tkTemplateId + ".104.zip";
            }
            return styleTemplate2;
        }
        StyleTemplate styleTemplate3 = this.f29360SA;
        if (styleTemplate3 != null) {
            return styleTemplate3;
        }
        AdMatrixInfo.MatrixTemplate m25668k = C10484b.m25668k(m29012sJ(), this.f29363YJ.getTkTemplateId());
        if (m25668k == null) {
            return null;
        }
        InterfaceC8701c interfaceC8701c = this.f29365YL;
        if (interfaceC8701c == null) {
            StyleTemplate styleTemplate4 = new StyleTemplate();
            styleTemplate4.templateId = m25668k.templateId;
            styleTemplate4.templateMd5 = m25668k.templateMd5;
            styleTemplate4.templateUrl = m25668k.templateUrl;
            styleTemplate4.templateVersionCode = (int) m25668k.templateVersionCode;
            styleTemplate4.tkSouce = 0;
            return styleTemplate4;
        }
        return interfaceC8701c.checkStyleTemplateById(this.mContext, m25668k.templateId, m25668k.templateMd5, m25668k.templateUrl, (int) m25668k.templateVersionCode);
    }

    /* renamed from: sI */
    private void m29013sI() {
        this.f29386Zh.m25239a(!C11015ai.m24123LZ() ? 1 : 0, this.f29363YJ.getTouchCoordsView(), this.f29363YJ.getTKContainer(), this.f29363YJ.getTkTemplateId());
    }

    /* renamed from: sK */
    private void m29011sK() {
        StyleTemplate m29014sH = m29014sH();
        if (m29014sH == null) {
            return;
        }
        this.f29376YW = m29014sH.tkSouce;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.f29376YW).setRenderState(-1).setTemplateId(this.f29363YJ.getTkTemplateId()).setVersionCode(String.valueOf(m29014sH.templateVersionCode)).toJson());
    }

    /* renamed from: sL */
    private void m29010sL() {
        this.f29373YT = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.f29376YW).setRenderState(0).setTemplateId(this.f29363YJ.getTkTemplateId()).setVersionCode(String.valueOf(this.f29360SA.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sM */
    public void m29009sM() {
        C10331c.m26254d("TKLoadController", "logTkRenderSuccess, templateId = " + this.f29363YJ.getTkTemplateId());
        if (!this.f29373YT || this.f29374YU) {
            return;
        }
        this.f29374YU = true;
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.APM_LOG, new TKPerformMsg(this.f29376YW).setRenderState(1).setRenderTime(this.f29377YX > 0 ? SystemClock.elapsedRealtime() - this.f29377YX : 0L).setTemplateId(this.f29363YJ.getTkTemplateId()).setLoadTime(this.f29378YY - this.f29359EW).setInitTime(this.f29379YZ).setVersionCode(String.valueOf(this.f29360SA.templateVersionCode)).toJson());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sN */
    public void m29008sN() {
        C10331c.m26254d("TKLoadController", "logTkRenderFail : timeout, templateId = " + this.f29363YJ.getTkTemplateId());
        StyleTemplate m29014sH = m29014sH();
        if (m29014sH == null) {
            return;
        }
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.f29376YW).setRenderState(3).setErrorReason("timeout").setTemplateId(this.f29363YJ.getTkTemplateId()).setVersionCode(String.valueOf(m29014sH.templateVersionCode)).toJson());
    }

    /* renamed from: sO */
    private Map<String, Object> m29007sO() {
        if (this.f29380Za == null) {
            HashMap hashMap = new HashMap();
            this.f29380Za = hashMap;
            hashMap.put("TKVersion", "5.1.7");
            this.f29380Za.put("SDKVersion", BuildConfig.VERSION_NAME);
            this.f29380Za.put("sdkType", 1);
        }
        return this.f29380Za;
    }

    /* renamed from: sP */
    private void m29006sP() {
        if (this.f29365YL == null || this.f29367YN == null) {
            return;
        }
        File file = new File(new File(this.f29365YL.getJsBaseDir(this.mContext, this.f29363YJ.getTkTemplateId())), "kcov.json");
        if (file.exists()) {
            try {
                String m23738V = C11122q.m23738V(file);
                if (TextUtils.isEmpty(m23738V)) {
                    return;
                }
                C10331c.m26254d("TKLoadController", "kcov.json:" + m23738V);
                JSONObject jSONObject = new JSONObject(m23738V);
                final String string = jSONObject.getString("gitHeadCommit");
                final String string2 = jSONObject.getString("coverageApi");
                final String string3 = jSONObject.getString("coverageTaskId");
                final String string4 = jSONObject.getString("currentBranch");
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2) && !TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                    StringBuilder sb = new StringBuilder("尝试获取覆盖率统计... ");
                    sb.append(this.f29360SA);
                    C10331c.m26254d("TKLoadController", sb.toString() != null ? this.f29360SA.templateId : "");
                    Object execute = this.f29367YN.execute("JSON.stringify(this.__coverage__)");
                    if (execute instanceof String) {
                        final String str = (String) execute;
                        C11095g.execute(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.19
                            @Override // java.lang.Runnable
                            public final void run() {
                                JSONObject jSONObject2 = new JSONObject();
                                try {
                                    jSONObject2.put("coverage_task_id", Integer.valueOf(string3));
                                    jSONObject2.put(PathCenter.f37694m, "");
                                    jSONObject2.put(CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis() / 1000);
                                    jSONObject2.put("branch_name", string4);
                                    jSONObject2.put(ConstantHelper.LOG_VS, BuildConfig.VERSION_NAME);
                                    jSONObject2.put("tk_version", String.valueOf(C9305i.this.f29360SA.templateVersionCode));
                                    jSONObject2.put("tk_template_ids", C9305i.this.f29360SA.templateId);
                                } catch (JSONException e) {
                                    C10331c.printStackTrace(e);
                                }
                                AdHttpProxy m24902xT = C10756f.m24902xT();
                                C10415c doPost = m24902xT.doPost(string2 + "/analysis/add/pkg/info", (Map<String, String>) null, jSONObject2);
                                if (doPost.m26112DM()) {
                                    C10331c.m26254d("TKLoadController", "上传TK覆盖率pkg完成:" + doPost.avs);
                                } else {
                                    C10331c.m26254d("TKLoadController", "上传覆盖率pkg失败");
                                }
                                AdHttpProxy m24902xT2 = C10756f.m24902xT();
                                C10415c doPost2 = m24902xT2.doPost(string2 + "/attachment/ec", (Map<String, String>) null, new AdHttpBodyBuilder() { // from class: com.kwad.components.core.webview.tachikoma.i.19.1
                                    @Override // com.kwad.sdk.export.proxy.AdHttpBodyBuilder
                                    public final void buildFormData(AdHttpFormDataBuilder adHttpFormDataBuilder) {
                                        adHttpFormDataBuilder.addFormDataPart("task_id", string3);
                                        adHttpFormDataBuilder.addFormDataPart("os_build_model", Build.MODEL);
                                        adHttpFormDataBuilder.addFormDataPart("os_build_serial", "unknown");
                                        adHttpFormDataBuilder.addFormDataPart("os_build_brand", Build.BRAND);
                                        adHttpFormDataBuilder.addFormDataPart("app_version", BuildConfig.VERSION_NAME);
                                        adHttpFormDataBuilder.addFormDataPart("git_head_commit", string);
                                        adHttpFormDataBuilder.addFormDataPart("execute_type", "manual_qa");
                                        adHttpFormDataBuilder.addFormDataPart("uid", "");
                                        adHttpFormDataBuilder.addFormDataPart("did", C11029av.getDeviceId());
                                        adHttpFormDataBuilder.addFormDataPart("execute_user", "");
                                        adHttpFormDataBuilder.addFormDataPart("url_type", "transform");
                                        try {
                                            adHttpFormDataBuilder.addFormDataPart(IDataSource.f43973c, UUID.randomUUID().toString() + ".json", HttpPostBodyUtil.DEFAULT_BINARY_CONTENT_TYPE, str.getBytes("UTF-8"));
                                        } catch (UnsupportedEncodingException e2) {
                                            C10331c.printStackTrace(e2);
                                        }
                                    }
                                });
                                if (doPost2.m26112DM()) {
                                    C10331c.m26254d("TKLoadController", "上传TK覆盖率完成:" + doPost2.avs);
                                    return;
                                }
                                C10331c.m26254d("TKLoadController", "上传TK覆盖率失败");
                            }
                        });
                        return;
                    }
                    return;
                }
                C10331c.m26254d("TKLoadController", "kcov.json数据不合法，缺少关键字段gitHeadCommit | coverageApi | coverageTaskId | currentBranch");
            } catch (Throwable th) {
                C10331c.printStackTraceOnly(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29056a(C10605b c10605b, C8619c c8619c, InterfaceC9876q interfaceC9876q, ViewGroup viewGroup) {
    }

    @Override // com.kwad.sdk.components.InterfaceC9873n
    public final void callJS(String str) {
        InterfaceC9876q interfaceC9876q = this.f29367YN;
        if (interfaceC9876q != null) {
            interfaceC9876q.mo27483a(str, null, null);
        }
    }

    @Override // com.kwad.components.core.p289e.p294e.InterfaceC8641f
    public void dismiss() {
        C9109aw c9109aw = this.f29392cQ;
        if (c9109aw != null) {
            c9109aw.m29264sv();
        }
    }

    /* renamed from: f */
    protected void mo29036f(String str, String str2) {
    }

    /* renamed from: g */
    protected void mo29033g(String str, String str2) {
    }

    public final String getTkTemplateId() {
        InterfaceC9339j interfaceC9339j = this.f29363YJ;
        if (interfaceC9339j == null) {
            return null;
        }
        return interfaceC9339j.getTkTemplateId();
    }

    /* renamed from: jp */
    public void mo29029jp() {
        InterfaceC10594d interfaceC10594d = this.f29370YQ;
        if (interfaceC10594d != null) {
            interfaceC10594d.getWindowFocusChangeHelper().m25358b(this);
            this.f29370YQ = null;
        }
        Future<?> future = this.f29366YM;
        if (future != null) {
            future.cancel(true);
        }
        C11064bn.m23858c(this.f29390Zl);
        C11064bn.m23858c(this.f29391Zm);
        C8642g.m30090or().m30091b(this);
        if (this.f29361VB != null) {
            C10303b.m26364De().m26357a(this.f29361VB);
        }
        DialogFragmentC9274e dialogFragmentC9274e = this.f29362YI;
        if (dialogFragmentC9274e != null) {
            dialogFragmentC9274e.dismiss();
        }
        if (C8526a.f28050md.booleanValue()) {
            m29006sP();
        }
        InterfaceC8701c interfaceC8701c = this.f29365YL;
        if (interfaceC8701c != null) {
            interfaceC8701c.onDestroy();
        }
        final InterfaceC9876q interfaceC9876q = this.f29367YN;
        if (interfaceC9876q != null) {
            this.f29367YN = null;
            C11064bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.18
                @Override // java.lang.Runnable
                public final void run() {
                    InterfaceC9876q interfaceC9876q2 = interfaceC9876q;
                    if (interfaceC9876q2 != null) {
                        interfaceC9876q2.onDestroy();
                    }
                }
            });
        }
    }

    /* renamed from: nk */
    protected boolean mo29024nk() {
        return false;
    }

    /* renamed from: sD */
    public final C10605b m29018sD() {
        return this.f29386Zh;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: sJ */
    public final AdTemplate m29012sJ() {
        return this.f29386Zh.getAdTemplate();
    }

    @Override // com.kwad.components.core.p289e.p294e.InterfaceC8641f
    public void show() {
        C9109aw c9109aw = this.f29392cQ;
        if (c9109aw != null) {
            c9109aw.m29263sw();
        }
    }

    public C9305i(Context context, boolean z) {
        this.f29371YR = false;
        this.f29372YS = false;
        this.f29373YT = false;
        this.f29374YU = false;
        this.f29375YV = false;
        this.f29376YW = 0;
        this.f29395xs = -1L;
        this.f29381Zc = 1000;
        this.f29382Zd = 0;
        this.f29383Ze = true;
        this.f29386Zh = new C10643e();
        this.f29387Zi = new InterfaceC9338a() { // from class: com.kwad.components.core.webview.tachikoma.i.20
            @Override // com.kwad.components.core.webview.tachikoma.C9305i.InterfaceC9338a
            public final void onFailed() {
                C9305i.this.m29047b(TKRenderFailReason.RENDER_ERROR);
                C10331c.m26254d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.C9305i.InterfaceC9338a
            public final void onSuccess() {
                C10331c.m26254d("TKLoadController", "JS执行成功");
            }
        };
        this.f29388Zj = new InterfaceC9874o() { // from class: com.kwad.components.core.webview.tachikoma.i.22
            @Override // com.kwad.sdk.components.InterfaceC9874o
            /* renamed from: a */
            public final void mo27488a(InterfaceC9870k interfaceC9870k) {
                Activity activity = C9305i.this.mActivity;
                if (activity == null) {
                    C10232b.m26625DD();
                    activity = C10232b.getCurrentActivity();
                }
                if (activity != null && !activity.isFinishing()) {
                    StyleTemplate styleTemplate = null;
                    final String viewKey = interfaceC9870k.getViewKey();
                    if (viewKey == null) {
                        styleTemplate = new StyleTemplate();
                        try {
                            styleTemplate.parseJson(styleTemplate, new JSONObject(interfaceC9870k.getStyleTemplate()));
                        } catch (Throwable th) {
                            C10331c.printStackTrace(th);
                            interfaceC9870k.callbackPageStatus(false, "template parse failed");
                            return;
                        }
                    }
                    DialogFragmentC9274e.C9277b c9277b = new DialogFragmentC9274e.C9277b();
                    c9277b.m29132d(C9305i.this.mAdResultData);
                    c9277b.m29134c(interfaceC9870k);
                    if (styleTemplate != null) {
                        c9277b.m29139a(styleTemplate);
                    }
                    if (viewKey != null) {
                        c9277b.m29140a(new AbstractC9340k() { // from class: com.kwad.components.core.webview.tachikoma.i.22.1
                            @Override // com.kwad.components.core.webview.tachikoma.AbstractC9340k
                            /* renamed from: a */
                            public final InterfaceC9872m mo28978a(Object... objArr) {
                                if (C9305i.this.f29367YN != null) {
                                    return C9305i.this.f29367YN.mo27482aY(viewKey);
                                }
                                return null;
                            }
                        });
                    }
                    DialogFragmentC9274e m29149b = DialogFragmentC9274e.m29149b(c9277b);
                    m29149b.show(activity.getFragmentManager(), "");
                    C9305i.f29358Zb.put(Integer.valueOf(interfaceC9870k.getDialogId()), new WeakReference(m29149b));
                    return;
                }
                interfaceC9870k.callbackPageStatus(false, "no host activity");
            }

            @Override // com.kwad.sdk.components.InterfaceC9874o
            /* renamed from: b */
            public final void mo27486b(InterfaceC9870k interfaceC9870k) {
                WeakReference weakReference = (WeakReference) C9305i.f29358Zb.get(Integer.valueOf(interfaceC9870k.getDialogId()));
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((DialogFragmentC9274e) weakReference.get()).dismiss();
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
                if (r0 != com.kwad.sdk.core.p391c.C10232b.getCurrentActivity()) goto L41;
             */
            @Override // com.kwad.sdk.components.InterfaceC9874o
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void mo27487a(com.kwad.sdk.components.InterfaceC9871l r8) {
                /*
                    r7 = this;
                    com.kwad.components.core.webview.tachikoma.i r0 = com.kwad.components.core.webview.tachikoma.C9305i.this
                    android.app.Activity r0 = com.kwad.components.core.webview.tachikoma.C9305i.m29046b(r0)
                    if (r0 == 0) goto L11
                    com.kwad.sdk.core.p391c.C10232b.m26625DD()
                    android.app.Activity r1 = com.kwad.sdk.core.p391c.C10232b.getCurrentActivity()
                    if (r0 == r1) goto L18
                L11:
                    com.kwad.sdk.core.p391c.C10232b.m26625DD()
                    android.app.Activity r0 = com.kwad.sdk.core.p391c.C10232b.getCurrentActivity()
                L18:
                    r1 = 0
                    if (r0 != 0) goto L21
                    java.lang.String r0 = "no host activity"
                    r8.callbackPageStatus(r1, r0)
                    return
                L21:
                    android.content.Intent r2 = r8.getIntent()
                    java.lang.Class<com.kwad.sdk.api.proxy.app.FeedDownloadActivity> r3 = com.kwad.sdk.api.proxy.app.FeedDownloadActivity.class
                    java.lang.String r4 = r8.getTemplateString()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 == 0) goto L62
                    java.lang.String r4 = r8.getViewKey()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto L3c
                    goto L62
                L3c:
                    java.lang.String r4 = r8.getClassName()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto Lb9
                    java.lang.String r4 = r8.getClassName()     // Catch: java.lang.ClassNotFoundException -> L59
                    java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.ClassNotFoundException -> L59
                    com.kwad.sdk.service.C10973b.m24291a(r3, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.C9305i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                    goto Lb9
                L59:
                    r0 = move-exception
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                L62:
                    java.lang.Class<com.kwad.components.core.r.a.a> r4 = com.kwad.components.core.p327r.p328a.C8902a.class
                    com.kwad.sdk.service.C10973b.m24291a(r3, r4)
                    int r4 = com.kwad.components.core.p327r.p328a.C8902a.m29635qR()
                    java.lang.String r5 = "native_intent"
                    com.kwad.components.core.p327r.p328a.C8902a.m29640a(r4, r5, r8)
                    com.kwad.components.core.webview.tachikoma.i r5 = com.kwad.components.core.webview.tachikoma.C9305i.this
                    com.kwad.sdk.core.response.model.AdResultData r5 = com.kwad.components.core.webview.tachikoma.C9305i.m29042c(r5)
                    if (r5 == 0) goto L8b
                    com.kwad.components.core.c.f r5 = com.kwad.components.core.p287c.C8552f.m30378mE()
                    com.kwad.components.core.webview.tachikoma.i r6 = com.kwad.components.core.webview.tachikoma.C9305i.this
                    com.kwad.sdk.core.response.model.AdResultData r6 = com.kwad.components.core.webview.tachikoma.C9305i.m29042c(r6)
                    int r5 = r5.m30379i(r6)
                    java.lang.String r6 = "ad_result_cache_idx"
                    r2.putExtra(r6, r5)
                L8b:
                    java.lang.String r5 = r8.getTemplateString()
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L9f
                    java.lang.String r5 = r8.getTemplateString()
                    java.lang.String r6 = "tk_style_template"
                    r2.putExtra(r6, r5)
                    goto Lad
                L9f:
                    java.lang.String r5 = r8.getViewKey()
                    com.kwad.components.core.webview.tachikoma.i$22$2 r6 = new com.kwad.components.core.webview.tachikoma.i$22$2
                    r6.<init>()
                    java.lang.String r5 = "tk_view_holder"
                    com.kwad.components.core.p327r.p328a.C8902a.m29640a(r4, r5, r6)
                Lad:
                    java.lang.String r5 = "tk_id"
                    r2.putExtra(r5, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.C9305i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                Lb9:
                    java.lang.String r3 = r8.getUrl()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Lce
                    java.lang.String r3 = r8.getUrl()
                    android.net.Uri r3 = android.net.Uri.parse(r3)
                    r2.setData(r3)
                Lce:
                    r0.startActivity(r2)     // Catch: java.lang.Throwable -> Ld7
                    r0 = 1
                    r2 = 0
                    r8.callbackPageStatus(r0, r2)     // Catch: java.lang.Throwable -> Ld7
                    return
                Ld7:
                    r0 = move-exception
                    com.kwad.sdk.core.p397e.C10331c.printStackTraceOnly(r0)
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.C9305i.C932222.mo27487a(com.kwad.sdk.components.l):void");
            }
        };
        this.f29389Zk = new InterfaceC9869j() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            @Override // com.kwad.sdk.components.InterfaceC9869j
            /* renamed from: aS */
            public final InterfaceC9868i mo27492aS(int i) {
                return C9305i.this.m29053aB(C10485c.m25661n(C8699a.m30005at(i)));
            }

            @Override // com.kwad.sdk.components.InterfaceC9869j
            /* renamed from: aT */
            public final InterfaceC9868i mo27491aT(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return C9305i.this.m29053aB(adTemplate);
                } catch (Throwable th) {
                    C10331c.printStackTrace(th);
                    return null;
                }
            }
        };
        this.f29390Zl = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.25
            @Override // java.lang.Runnable
            public final void run() {
                C10331c.m26254d("TKLoadController", "已经超时" + C9305i.this.f29363YJ.getTkTemplateId());
                C9305i.this.m29008sN();
                C9305i.m29062a(C9305i.this, true);
                C9305i.this.m29047b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.f29391Zm = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            @Override // java.lang.Runnable
            public final void run() {
                C9305i.m29044b(C9305i.this, true);
                C9305i.this.m29047b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.f29393gO = new C9002l() { // from class: com.kwad.components.core.webview.tachikoma.i.17
            /* renamed from: g */
            private void m28999g(double d) {
                C9305i.this.f29394wp.aax = false;
                C9305i.this.f29394wp.aat = false;
                C9305i.this.f29394wp.f29321nE = (int) ((d / 1000.0d) + 0.5d);
                m28998iU();
            }

            /* renamed from: iU */
            private void m28998iU() {
                if (C9305i.this.f29368YO == null || C9305i.this.f29394wp == null) {
                    return;
                }
                C9305i.this.f29368YO.m29178a(C9305i.this.f29394wp);
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayCompleted() {
                C9305i.this.f29394wp.aat = true;
                C9305i.this.f29394wp.aax = false;
                C9305i.this.f29394wp.f29321nE = C10483a.m25976L(C10487e.m25641dQ(C9305i.this.m29012sJ()));
                m28998iU();
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayError(int i, int i2) {
                C9305i.this.f29394wp.aax = true;
                C9305i.this.f29394wp.aat = false;
                m28998iU();
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayProgress(long j, long j2) {
                m28999g(j2);
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayStart() {
                m28999g(Utils.DOUBLE_EPSILON);
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPreparing() {
                m28999g(Utils.DOUBLE_EPSILON);
            }
        };
        this.mContext = context;
        this.f29395xs = -1L;
        this.f29381Zc = 1000;
        this.f29383Ze = z;
        this.f29394wp = new C9264y();
    }

    /* renamed from: c */
    static /* synthetic */ boolean m29041c(C9305i c9305i, boolean z) {
        c9305i.f29375YV = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m29035f(Throwable th) {
        C10331c.m26254d("TKLoadController", "logTkRenderFail : " + th + ", templateId = " + this.f29363YJ.getTkTemplateId());
        String tkTemplateId = this.f29363YJ.getTkTemplateId();
        StringBuilder sb = new StringBuilder("error:");
        sb.append(th.toString());
        mo29033g(tkTemplateId, sb.toString());
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.f29376YW).setRenderState(3).setErrorReason(th.toString()).setTemplateId(this.f29363YJ.getTkTemplateId()).setVersionCode(String.valueOf(this.f29360SA.templateVersionCode)).toJson());
    }

    @Override // com.kwad.sdk.core.view.InterfaceC10592b
    /* renamed from: i */
    public final void mo25360i(View view, boolean z) {
        C9107av c9107av;
        FrameLayout tKContainer = this.f29363YJ.getTKContainer();
        if (tKContainer == null || !tKContainer.equals(view) || (c9107av = this.f29369YP) == null) {
            return;
        }
        c9107av.m29270aU(z);
    }

    /* renamed from: b */
    static /* synthetic */ boolean m29044b(C9305i c9305i, boolean z) {
        c9305i.f29372YS = true;
        return true;
    }

    /* renamed from: c */
    protected C9072ak mo29040c(C10605b c10605b) {
        return new C9072ak(c10605b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m29043b(final StyleTemplate styleTemplate) {
        C11100i.m23786e("", "renderType_tk", styleTemplate.templateId, styleTemplate.templateUrl);
        C10331c.m26254d("TKLoadController", "读取完毕，总耗时" + (SystemClock.elapsedRealtime() - this.f29359EW) + ", 读取成功" + styleTemplate.templateId);
        if (this.f29371YR) {
            return;
        }
        C10331c.m26254d("TKLoadController", "没有超时");
        C11064bn.m23858c(this.f29390Zl);
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.tachikoma.i.12
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9305i c9305i = C9305i.this;
                c9305i.m29059a(styleTemplate, c9305i.f29387Zi);
            }
        });
        FrameLayout tKContainer = this.f29363YJ.getTKContainer();
        if (tKContainer instanceof InterfaceC10594d) {
            InterfaceC10594d interfaceC10594d = (InterfaceC10594d) tKContainer;
            this.f29370YQ = interfaceC10594d;
            interfaceC10594d.getWindowFocusChangeHelper().m25359a(this);
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m29062a(C9305i c9305i, boolean z) {
        c9305i.f29371YR = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m29047b(final TKRenderFailReason tKRenderFailReason) {
        C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.tachikoma.i.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                if (C9305i.this.f29375YV) {
                    return;
                }
                C9305i.m29041c(C9305i.this, true);
                C9305i.this.f29363YJ.mo28989a(tKRenderFailReason);
                C8642g.m30090or().m30091b(C9305i.this);
                C9283b.m29107tc().m29108s(C9305i.this.f29384Zf, C9305i.this.f29385Zg);
            }
        });
    }

    /* renamed from: a */
    public final void m29060a(StyleTemplate styleTemplate) {
        this.f29360SA = styleTemplate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m29048b(C9067aj.C9070a c9070a) {
        FrameLayout tKContainer = this.f29363YJ.getTKContainer();
        if (tKContainer != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) tKContainer.getLayoutParams();
            layoutParams.height = C10751a.m24924a(this.mContext, c9070a.height);
            layoutParams.leftMargin = C10751a.m24924a(this.mContext, c9070a.leftMargin);
            layoutParams.rightMargin = C10751a.m24924a(this.mContext, c9070a.rightMargin);
            layoutParams.bottomMargin = C10751a.m24924a(this.mContext, c9070a.bottomMargin);
            layoutParams.width = -1;
            tKContainer.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: a */
    public void mo29075a(@Nullable Activity activity, AdResultData adResultData, InterfaceC9339j interfaceC9339j) {
        this.mActivity = activity;
        this.mAdResultData = adResultData;
        this.f29386Zh.m25323d(adResultData);
        this.f29363YJ = interfaceC9339j;
        this.f29384Zf = interfaceC9339j.getTkTemplateId();
        this.f29385Zg = this.f29363YJ.getTKReaderScene();
        m29017sE();
        FrameLayout tKContainer = this.f29363YJ.getTKContainer();
        if (tKContainer != null) {
            tKContainer.removeAllViews();
        }
        if (!C10251d.m26572BV()) {
            m29047b(TKRenderFailReason.SWITCH_CLOSE);
            return;
        }
        this.f29365YL = (InterfaceC8701c) C9861c.m27501f(InterfaceC8701c.class);
        m29011sK();
        C10331c.m26254d("TKLoadController", "bind mTKPlugin: " + this.f29365YL);
        if (TextUtils.isEmpty(this.f29384Zf)) {
            C9830a.m27577e(m29012sJ(), this.f29385Zg);
        }
        if (this.f29365YL != null) {
            m29016sF();
            return;
        }
        m29047b(TKRenderFailReason.PLUGIN_NOT_READY);
        mo29036f(this.f29384Zf, TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED);
        TkLoggerReporter.get().reportTKPerform(ILoggerReporter.Category.ERROR_LOG, new TKPerformMsg(this.f29376YW).setRenderState(4).setErrorReason(TKPerformMsg.ERROR_REASON.KSAD_TK_OFFLINE_FAILED).setTemplateId(this.f29384Zf).toJson());
    }

    public C9305i(long j, Context context) {
        this.f29371YR = false;
        this.f29372YS = false;
        this.f29373YT = false;
        this.f29374YU = false;
        this.f29375YV = false;
        this.f29376YW = 0;
        this.f29395xs = -1L;
        this.f29381Zc = 1000;
        this.f29382Zd = 0;
        this.f29383Ze = true;
        this.f29386Zh = new C10643e();
        this.f29387Zi = new InterfaceC9338a() { // from class: com.kwad.components.core.webview.tachikoma.i.20
            @Override // com.kwad.components.core.webview.tachikoma.C9305i.InterfaceC9338a
            public final void onFailed() {
                C9305i.this.m29047b(TKRenderFailReason.RENDER_ERROR);
                C10331c.m26254d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.C9305i.InterfaceC9338a
            public final void onSuccess() {
                C10331c.m26254d("TKLoadController", "JS执行成功");
            }
        };
        this.f29388Zj = new InterfaceC9874o() { // from class: com.kwad.components.core.webview.tachikoma.i.22
            @Override // com.kwad.sdk.components.InterfaceC9874o
            /* renamed from: a */
            public final void mo27488a(InterfaceC9870k interfaceC9870k) {
                Activity activity = C9305i.this.mActivity;
                if (activity == null) {
                    C10232b.m26625DD();
                    activity = C10232b.getCurrentActivity();
                }
                if (activity != null && !activity.isFinishing()) {
                    StyleTemplate styleTemplate = null;
                    final String viewKey = interfaceC9870k.getViewKey();
                    if (viewKey == null) {
                        styleTemplate = new StyleTemplate();
                        try {
                            styleTemplate.parseJson(styleTemplate, new JSONObject(interfaceC9870k.getStyleTemplate()));
                        } catch (Throwable th) {
                            C10331c.printStackTrace(th);
                            interfaceC9870k.callbackPageStatus(false, "template parse failed");
                            return;
                        }
                    }
                    DialogFragmentC9274e.C9277b c9277b = new DialogFragmentC9274e.C9277b();
                    c9277b.m29132d(C9305i.this.mAdResultData);
                    c9277b.m29134c(interfaceC9870k);
                    if (styleTemplate != null) {
                        c9277b.m29139a(styleTemplate);
                    }
                    if (viewKey != null) {
                        c9277b.m29140a(new AbstractC9340k() { // from class: com.kwad.components.core.webview.tachikoma.i.22.1
                            @Override // com.kwad.components.core.webview.tachikoma.AbstractC9340k
                            /* renamed from: a */
                            public final InterfaceC9872m mo28978a(Object... objArr) {
                                if (C9305i.this.f29367YN != null) {
                                    return C9305i.this.f29367YN.mo27482aY(viewKey);
                                }
                                return null;
                            }
                        });
                    }
                    DialogFragmentC9274e m29149b = DialogFragmentC9274e.m29149b(c9277b);
                    m29149b.show(activity.getFragmentManager(), "");
                    C9305i.f29358Zb.put(Integer.valueOf(interfaceC9870k.getDialogId()), new WeakReference(m29149b));
                    return;
                }
                interfaceC9870k.callbackPageStatus(false, "no host activity");
            }

            @Override // com.kwad.sdk.components.InterfaceC9874o
            /* renamed from: b */
            public final void mo27486b(InterfaceC9870k interfaceC9870k) {
                WeakReference weakReference = (WeakReference) C9305i.f29358Zb.get(Integer.valueOf(interfaceC9870k.getDialogId()));
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((DialogFragmentC9274e) weakReference.get()).dismiss();
            }

            @Override // com.kwad.sdk.components.InterfaceC9874o
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void mo27487a(com.kwad.sdk.components.InterfaceC9871l r8) {
                /*
                    r7 = this;
                    com.kwad.components.core.webview.tachikoma.i r0 = com.kwad.components.core.webview.tachikoma.C9305i.this
                    android.app.Activity r0 = com.kwad.components.core.webview.tachikoma.C9305i.m29046b(r0)
                    if (r0 == 0) goto L11
                    com.kwad.sdk.core.p391c.C10232b.m26625DD()
                    android.app.Activity r1 = com.kwad.sdk.core.p391c.C10232b.getCurrentActivity()
                    if (r0 == r1) goto L18
                L11:
                    com.kwad.sdk.core.p391c.C10232b.m26625DD()
                    android.app.Activity r0 = com.kwad.sdk.core.p391c.C10232b.getCurrentActivity()
                L18:
                    r1 = 0
                    if (r0 != 0) goto L21
                    java.lang.String r0 = "no host activity"
                    r8.callbackPageStatus(r1, r0)
                    return
                L21:
                    android.content.Intent r2 = r8.getIntent()
                    java.lang.Class<com.kwad.sdk.api.proxy.app.FeedDownloadActivity> r3 = com.kwad.sdk.api.proxy.app.FeedDownloadActivity.class
                    java.lang.String r4 = r8.getTemplateString()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 == 0) goto L62
                    java.lang.String r4 = r8.getViewKey()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto L3c
                    goto L62
                L3c:
                    java.lang.String r4 = r8.getClassName()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto Lb9
                    java.lang.String r4 = r8.getClassName()     // Catch: java.lang.ClassNotFoundException -> L59
                    java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.ClassNotFoundException -> L59
                    com.kwad.sdk.service.C10973b.m24291a(r3, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.C9305i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                    goto Lb9
                L59:
                    r0 = move-exception
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                L62:
                    java.lang.Class<com.kwad.components.core.r.a.a> r4 = com.kwad.components.core.p327r.p328a.C8902a.class
                    com.kwad.sdk.service.C10973b.m24291a(r3, r4)
                    int r4 = com.kwad.components.core.p327r.p328a.C8902a.m29635qR()
                    java.lang.String r5 = "native_intent"
                    com.kwad.components.core.p327r.p328a.C8902a.m29640a(r4, r5, r8)
                    com.kwad.components.core.webview.tachikoma.i r5 = com.kwad.components.core.webview.tachikoma.C9305i.this
                    com.kwad.sdk.core.response.model.AdResultData r5 = com.kwad.components.core.webview.tachikoma.C9305i.m29042c(r5)
                    if (r5 == 0) goto L8b
                    com.kwad.components.core.c.f r5 = com.kwad.components.core.p287c.C8552f.m30378mE()
                    com.kwad.components.core.webview.tachikoma.i r6 = com.kwad.components.core.webview.tachikoma.C9305i.this
                    com.kwad.sdk.core.response.model.AdResultData r6 = com.kwad.components.core.webview.tachikoma.C9305i.m29042c(r6)
                    int r5 = r5.m30379i(r6)
                    java.lang.String r6 = "ad_result_cache_idx"
                    r2.putExtra(r6, r5)
                L8b:
                    java.lang.String r5 = r8.getTemplateString()
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L9f
                    java.lang.String r5 = r8.getTemplateString()
                    java.lang.String r6 = "tk_style_template"
                    r2.putExtra(r6, r5)
                    goto Lad
                L9f:
                    java.lang.String r5 = r8.getViewKey()
                    com.kwad.components.core.webview.tachikoma.i$22$2 r6 = new com.kwad.components.core.webview.tachikoma.i$22$2
                    r6.<init>()
                    java.lang.String r5 = "tk_view_holder"
                    com.kwad.components.core.p327r.p328a.C8902a.m29640a(r4, r5, r6)
                Lad:
                    java.lang.String r5 = "tk_id"
                    r2.putExtra(r5, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.C9305i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                Lb9:
                    java.lang.String r3 = r8.getUrl()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Lce
                    java.lang.String r3 = r8.getUrl()
                    android.net.Uri r3 = android.net.Uri.parse(r3)
                    r2.setData(r3)
                Lce:
                    r0.startActivity(r2)     // Catch: java.lang.Throwable -> Ld7
                    r0 = 1
                    r2 = 0
                    r8.callbackPageStatus(r0, r2)     // Catch: java.lang.Throwable -> Ld7
                    return
                Ld7:
                    r0 = move-exception
                    com.kwad.sdk.core.p397e.C10331c.printStackTraceOnly(r0)
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.C9305i.C932222.mo27487a(com.kwad.sdk.components.l):void");
            }
        };
        this.f29389Zk = new InterfaceC9869j() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            @Override // com.kwad.sdk.components.InterfaceC9869j
            /* renamed from: aS */
            public final InterfaceC9868i mo27492aS(int i) {
                return C9305i.this.m29053aB(C10485c.m25661n(C8699a.m30005at(i)));
            }

            @Override // com.kwad.sdk.components.InterfaceC9869j
            /* renamed from: aT */
            public final InterfaceC9868i mo27491aT(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return C9305i.this.m29053aB(adTemplate);
                } catch (Throwable th) {
                    C10331c.printStackTrace(th);
                    return null;
                }
            }
        };
        this.f29390Zl = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.25
            @Override // java.lang.Runnable
            public final void run() {
                C10331c.m26254d("TKLoadController", "已经超时" + C9305i.this.f29363YJ.getTkTemplateId());
                C9305i.this.m29008sN();
                C9305i.m29062a(C9305i.this, true);
                C9305i.this.m29047b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.f29391Zm = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            @Override // java.lang.Runnable
            public final void run() {
                C9305i.m29044b(C9305i.this, true);
                C9305i.this.m29047b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.f29393gO = new C9002l() { // from class: com.kwad.components.core.webview.tachikoma.i.17
            /* renamed from: g */
            private void m28999g(double d) {
                C9305i.this.f29394wp.aax = false;
                C9305i.this.f29394wp.aat = false;
                C9305i.this.f29394wp.f29321nE = (int) ((d / 1000.0d) + 0.5d);
                m28998iU();
            }

            /* renamed from: iU */
            private void m28998iU() {
                if (C9305i.this.f29368YO == null || C9305i.this.f29394wp == null) {
                    return;
                }
                C9305i.this.f29368YO.m29178a(C9305i.this.f29394wp);
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayCompleted() {
                C9305i.this.f29394wp.aat = true;
                C9305i.this.f29394wp.aax = false;
                C9305i.this.f29394wp.f29321nE = C10483a.m25976L(C10487e.m25641dQ(C9305i.this.m29012sJ()));
                m28998iU();
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayError(int i, int i2) {
                C9305i.this.f29394wp.aax = true;
                C9305i.this.f29394wp.aat = false;
                m28998iU();
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayProgress(long j2, long j22) {
                m28999g(j22);
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayStart() {
                m28999g(Utils.DOUBLE_EPSILON);
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPreparing() {
                m28999g(Utils.DOUBLE_EPSILON);
            }
        };
        this.mContext = context;
        this.f29395xs = j;
        this.f29394wp = new C9264y();
    }

    /* renamed from: a */
    public final void m29055a(InterfaceC10631g interfaceC10631g) {
        this.f29364YK = interfaceC10631g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m29061a(TKDownloadListener tKDownloadListener) {
        StyleTemplate m29014sH = m29014sH();
        if (m29014sH == null) {
            tKDownloadListener.onFailed("no template");
            return;
        }
        if (!isLocalDebugEnable()) {
            String m29079o = C9303h.m29077sB().m29079o(m29014sH.templateId, m29014sH.templateVersionCode);
            if (!TextUtils.isEmpty(m29079o) && !isLocalDebugEnable()) {
                m29014sH.jsStr = m29079o;
                m29014sH.tkSouce = 4;
                C10331c.m26254d("TKLoadController", "使用TK模板缓存");
                tKDownloadListener.onSuccess(m29014sH);
                return;
            }
        }
        this.f29365YL.loadTkFileByTemplateId(this.mContext, m29014sH.templateId, m29014sH.templateMd5, m29014sH.templateUrl, m29014sH.templateVersionCode, tKDownloadListener);
    }

    public C9305i(Context context, int i, int i2) {
        this.f29371YR = false;
        this.f29372YS = false;
        this.f29373YT = false;
        this.f29374YU = false;
        this.f29375YV = false;
        this.f29376YW = 0;
        this.f29395xs = -1L;
        this.f29381Zc = 1000;
        this.f29382Zd = 0;
        this.f29383Ze = true;
        this.f29386Zh = new C10643e();
        this.f29387Zi = new InterfaceC9338a() { // from class: com.kwad.components.core.webview.tachikoma.i.20
            @Override // com.kwad.components.core.webview.tachikoma.C9305i.InterfaceC9338a
            public final void onFailed() {
                C9305i.this.m29047b(TKRenderFailReason.RENDER_ERROR);
                C10331c.m26254d("TKLoadController", "JS执行成功");
            }

            @Override // com.kwad.components.core.webview.tachikoma.C9305i.InterfaceC9338a
            public final void onSuccess() {
                C10331c.m26254d("TKLoadController", "JS执行成功");
            }
        };
        this.f29388Zj = new InterfaceC9874o() { // from class: com.kwad.components.core.webview.tachikoma.i.22
            @Override // com.kwad.sdk.components.InterfaceC9874o
            /* renamed from: a */
            public final void mo27488a(InterfaceC9870k interfaceC9870k) {
                Activity activity = C9305i.this.mActivity;
                if (activity == null) {
                    C10232b.m26625DD();
                    activity = C10232b.getCurrentActivity();
                }
                if (activity != null && !activity.isFinishing()) {
                    StyleTemplate styleTemplate = null;
                    final String viewKey = interfaceC9870k.getViewKey();
                    if (viewKey == null) {
                        styleTemplate = new StyleTemplate();
                        try {
                            styleTemplate.parseJson(styleTemplate, new JSONObject(interfaceC9870k.getStyleTemplate()));
                        } catch (Throwable th) {
                            C10331c.printStackTrace(th);
                            interfaceC9870k.callbackPageStatus(false, "template parse failed");
                            return;
                        }
                    }
                    DialogFragmentC9274e.C9277b c9277b = new DialogFragmentC9274e.C9277b();
                    c9277b.m29132d(C9305i.this.mAdResultData);
                    c9277b.m29134c(interfaceC9870k);
                    if (styleTemplate != null) {
                        c9277b.m29139a(styleTemplate);
                    }
                    if (viewKey != null) {
                        c9277b.m29140a(new AbstractC9340k() { // from class: com.kwad.components.core.webview.tachikoma.i.22.1
                            @Override // com.kwad.components.core.webview.tachikoma.AbstractC9340k
                            /* renamed from: a */
                            public final InterfaceC9872m mo28978a(Object... objArr) {
                                if (C9305i.this.f29367YN != null) {
                                    return C9305i.this.f29367YN.mo27482aY(viewKey);
                                }
                                return null;
                            }
                        });
                    }
                    DialogFragmentC9274e m29149b = DialogFragmentC9274e.m29149b(c9277b);
                    m29149b.show(activity.getFragmentManager(), "");
                    C9305i.f29358Zb.put(Integer.valueOf(interfaceC9870k.getDialogId()), new WeakReference(m29149b));
                    return;
                }
                interfaceC9870k.callbackPageStatus(false, "no host activity");
            }

            @Override // com.kwad.sdk.components.InterfaceC9874o
            /* renamed from: b */
            public final void mo27486b(InterfaceC9870k interfaceC9870k) {
                WeakReference weakReference = (WeakReference) C9305i.f29358Zb.get(Integer.valueOf(interfaceC9870k.getDialogId()));
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((DialogFragmentC9274e) weakReference.get()).dismiss();
            }

            @Override // com.kwad.sdk.components.InterfaceC9874o
            /* renamed from: a */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void mo27487a(com.kwad.sdk.components.InterfaceC9871l r8) {
                /*
                    r7 = this;
                    com.kwad.components.core.webview.tachikoma.i r0 = com.kwad.components.core.webview.tachikoma.C9305i.this
                    android.app.Activity r0 = com.kwad.components.core.webview.tachikoma.C9305i.m29046b(r0)
                    if (r0 == 0) goto L11
                    com.kwad.sdk.core.p391c.C10232b.m26625DD()
                    android.app.Activity r1 = com.kwad.sdk.core.p391c.C10232b.getCurrentActivity()
                    if (r0 == r1) goto L18
                L11:
                    com.kwad.sdk.core.p391c.C10232b.m26625DD()
                    android.app.Activity r0 = com.kwad.sdk.core.p391c.C10232b.getCurrentActivity()
                L18:
                    r1 = 0
                    if (r0 != 0) goto L21
                    java.lang.String r0 = "no host activity"
                    r8.callbackPageStatus(r1, r0)
                    return
                L21:
                    android.content.Intent r2 = r8.getIntent()
                    java.lang.Class<com.kwad.sdk.api.proxy.app.FeedDownloadActivity> r3 = com.kwad.sdk.api.proxy.app.FeedDownloadActivity.class
                    java.lang.String r4 = r8.getTemplateString()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 == 0) goto L62
                    java.lang.String r4 = r8.getViewKey()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto L3c
                    goto L62
                L3c:
                    java.lang.String r4 = r8.getClassName()
                    boolean r4 = android.text.TextUtils.isEmpty(r4)
                    if (r4 != 0) goto Lb9
                    java.lang.String r4 = r8.getClassName()     // Catch: java.lang.ClassNotFoundException -> L59
                    java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch: java.lang.ClassNotFoundException -> L59
                    com.kwad.sdk.service.C10973b.m24291a(r3, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.C9305i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                    goto Lb9
                L59:
                    r0 = move-exception
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                L62:
                    java.lang.Class<com.kwad.components.core.r.a.a> r4 = com.kwad.components.core.p327r.p328a.C8902a.class
                    com.kwad.sdk.service.C10973b.m24291a(r3, r4)
                    int r4 = com.kwad.components.core.p327r.p328a.C8902a.m29635qR()
                    java.lang.String r5 = "native_intent"
                    com.kwad.components.core.p327r.p328a.C8902a.m29640a(r4, r5, r8)
                    com.kwad.components.core.webview.tachikoma.i r5 = com.kwad.components.core.webview.tachikoma.C9305i.this
                    com.kwad.sdk.core.response.model.AdResultData r5 = com.kwad.components.core.webview.tachikoma.C9305i.m29042c(r5)
                    if (r5 == 0) goto L8b
                    com.kwad.components.core.c.f r5 = com.kwad.components.core.p287c.C8552f.m30378mE()
                    com.kwad.components.core.webview.tachikoma.i r6 = com.kwad.components.core.webview.tachikoma.C9305i.this
                    com.kwad.sdk.core.response.model.AdResultData r6 = com.kwad.components.core.webview.tachikoma.C9305i.m29042c(r6)
                    int r5 = r5.m30379i(r6)
                    java.lang.String r6 = "ad_result_cache_idx"
                    r2.putExtra(r6, r5)
                L8b:
                    java.lang.String r5 = r8.getTemplateString()
                    boolean r5 = android.text.TextUtils.isEmpty(r5)
                    if (r5 != 0) goto L9f
                    java.lang.String r5 = r8.getTemplateString()
                    java.lang.String r6 = "tk_style_template"
                    r2.putExtra(r6, r5)
                    goto Lad
                L9f:
                    java.lang.String r5 = r8.getViewKey()
                    com.kwad.components.core.webview.tachikoma.i$22$2 r6 = new com.kwad.components.core.webview.tachikoma.i$22$2
                    r6.<init>()
                    java.lang.String r5 = "tk_view_holder"
                    com.kwad.components.core.p327r.p328a.C8902a.m29640a(r4, r5, r6)
                Lad:
                    java.lang.String r5 = "tk_id"
                    r2.putExtra(r5, r4)
                    com.kwad.components.core.webview.tachikoma.i r4 = com.kwad.components.core.webview.tachikoma.C9305i.this
                    android.content.Context r4 = r4.mContext
                    r2.setClass(r4, r3)
                Lb9:
                    java.lang.String r3 = r8.getUrl()
                    boolean r3 = android.text.TextUtils.isEmpty(r3)
                    if (r3 != 0) goto Lce
                    java.lang.String r3 = r8.getUrl()
                    android.net.Uri r3 = android.net.Uri.parse(r3)
                    r2.setData(r3)
                Lce:
                    r0.startActivity(r2)     // Catch: java.lang.Throwable -> Ld7
                    r0 = 1
                    r2 = 0
                    r8.callbackPageStatus(r0, r2)     // Catch: java.lang.Throwable -> Ld7
                    return
                Ld7:
                    r0 = move-exception
                    com.kwad.sdk.core.p397e.C10331c.printStackTraceOnly(r0)
                    java.lang.String r0 = r0.getMessage()
                    r8.callbackPageStatus(r1, r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.core.webview.tachikoma.C9305i.C932222.mo27487a(com.kwad.sdk.components.l):void");
            }
        };
        this.f29389Zk = new InterfaceC9869j() { // from class: com.kwad.components.core.webview.tachikoma.i.23
            @Override // com.kwad.sdk.components.InterfaceC9869j
            /* renamed from: aS */
            public final InterfaceC9868i mo27492aS(int i3) {
                return C9305i.this.m29053aB(C10485c.m25661n(C8699a.m30005at(i3)));
            }

            @Override // com.kwad.sdk.components.InterfaceC9869j
            /* renamed from: aT */
            public final InterfaceC9868i mo27491aT(String str) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(jSONObject);
                    return C9305i.this.m29053aB(adTemplate);
                } catch (Throwable th) {
                    C10331c.printStackTrace(th);
                    return null;
                }
            }
        };
        this.f29390Zl = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.25
            @Override // java.lang.Runnable
            public final void run() {
                C10331c.m26254d("TKLoadController", "已经超时" + C9305i.this.f29363YJ.getTkTemplateId());
                C9305i.this.m29008sN();
                C9305i.m29062a(C9305i.this, true);
                C9305i.this.m29047b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.f29391Zm = new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.26
            @Override // java.lang.Runnable
            public final void run() {
                C9305i.m29044b(C9305i.this, true);
                C9305i.this.m29047b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
            }
        };
        this.f29393gO = new C9002l() { // from class: com.kwad.components.core.webview.tachikoma.i.17
            /* renamed from: g */
            private void m28999g(double d) {
                C9305i.this.f29394wp.aax = false;
                C9305i.this.f29394wp.aat = false;
                C9305i.this.f29394wp.f29321nE = (int) ((d / 1000.0d) + 0.5d);
                m28998iU();
            }

            /* renamed from: iU */
            private void m28998iU() {
                if (C9305i.this.f29368YO == null || C9305i.this.f29394wp == null) {
                    return;
                }
                C9305i.this.f29368YO.m29178a(C9305i.this.f29394wp);
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayCompleted() {
                C9305i.this.f29394wp.aat = true;
                C9305i.this.f29394wp.aax = false;
                C9305i.this.f29394wp.f29321nE = C10483a.m25976L(C10487e.m25641dQ(C9305i.this.m29012sJ()));
                m28998iU();
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayError(int i3, int i22) {
                C9305i.this.f29394wp.aax = true;
                C9305i.this.f29394wp.aat = false;
                m28998iU();
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayProgress(long j2, long j22) {
                m28999g(j22);
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayStart() {
                m28999g(Utils.DOUBLE_EPSILON);
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPreparing() {
                m28999g(Utils.DOUBLE_EPSILON);
            }
        };
        this.mContext = context;
        this.f29381Zc = i;
        this.f29394wp = new C9264y();
        this.f29382Zd = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m29059a(StyleTemplate styleTemplate, final InterfaceC9338a interfaceC9338a) {
        this.f29360SA = styleTemplate;
        C10331c.m26246w("TKLoadController", "addTKView mTKPlugin.getState(): " + this.f29365YL.getState());
        if (this.f29365YL.getState() == ITkOfflineCompo.TKState.SO_FAIL) {
            m29050aR(TKPerformMsg.ERROR_REASON.KSAD_TK_SO_FAIL);
            if (interfaceC9338a != null) {
                interfaceC9338a.onFailed();
            }
        } else if (TextUtils.isEmpty(styleTemplate.jsStr)) {
            m29049aS(TKPerformMsg.ERROR_REASON.KSAD_TK_NO_TEMPLATE);
            if (interfaceC9338a != null) {
                interfaceC9338a.onFailed();
            }
        } else {
            try {
                m29010sL();
                this.f29378YY = SystemClock.elapsedRealtime();
                InterfaceC9876q mo28841a = this.f29365YL.mo28841a(this.mContext, styleTemplate.templateId, styleTemplate.templateVersionCode, styleTemplate.tkSouce, this.f29383Ze);
                C8699a.m30006a(mo28841a.getUniqId(), this.mAdResultData);
                mo28841a.mo27484a(this.f29388Zj);
                mo28841a.mo27485a(this.f29389Zk);
                AdResultData adResultData = this.mAdResultData;
                if (adResultData != null && C10485c.m25661n(adResultData).mAdScene != null) {
                    m29007sO().put("adStyle", Integer.valueOf(C10485c.m25661n(this.mAdResultData).mAdScene.getAdStyle()));
                    m29007sO().put("adScene", C10485c.m25661n(this.mAdResultData).mAdScene.toJson().toString());
                }
                if (this.f29360SA != null) {
                    m29007sO().put("styleTemplate", this.f29360SA.toJson().toString());
                }
                m29007sO().put("adCacheId", Integer.valueOf(mo28841a.getUniqId()));
                m29007sO().put("appId", ServiceProvider.getAppId());
                m29007sO().put("isDebug", C8526a.f28050md);
                mo28841a.setCustomEnv(m29007sO());
                this.f29367YN = mo28841a;
                C10232b.m26625DD();
                Activity currentActivity = C10232b.getCurrentActivity();
                if (currentActivity != null) {
                    ViewGroup viewGroup = (ViewGroup) currentActivity.getWindow().getDecorView();
                    m29007sO().put("isImmersiveMode", Boolean.valueOf(C10751a.m24928C(viewGroup) && C10751a.m24920aI(currentActivity) == viewGroup.getHeight()));
                }
                mo28841a.setCustomEnv(m29007sO());
                InterfaceC10631g interfaceC10631g = this.f29364YK;
                if (interfaceC10631g != null) {
                    mo28841a.mo27481b(interfaceC10631g);
                }
                this.f29379YZ = SystemClock.elapsedRealtime() - this.f29378YY;
                this.f29377YX = SystemClock.elapsedRealtime();
                m29013sI();
                m29058a(mo28841a);
                File file = new File(this.f29365YL.getJsBaseDir(this.mContext, this.f29363YJ.getTkTemplateId()));
                String str = styleTemplate.jsStr;
                mo28841a.mo27483a(str, file.getAbsolutePath() + "/", new InterfaceC9875p() { // from class: com.kwad.components.core.webview.tachikoma.i.21
                    @Override // com.kwad.sdk.components.InterfaceC9875p
                    public final void onFailed(Throwable th) {
                        InterfaceC9338a interfaceC9338a2 = interfaceC9338a;
                        if (interfaceC9338a2 != null) {
                            interfaceC9338a2.onFailed();
                        }
                        C9305i.this.m29035f(th);
                    }

                    @Override // com.kwad.sdk.components.InterfaceC9875p
                    public final void onSuccess() {
                        InterfaceC9338a interfaceC9338a2 = interfaceC9338a;
                        if (interfaceC9338a2 != null) {
                            interfaceC9338a2.onSuccess();
                        }
                    }
                });
                FrameLayout tKContainer = this.f29363YJ.getTKContainer();
                if (tKContainer == null || !this.f29383Ze) {
                    return;
                }
                View view = mo28841a.getView();
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                tKContainer.addView(view);
            } catch (Throwable th) {
                C10331c.printStackTrace(th);
                m29035f(th);
                if (interfaceC9338a != null) {
                    interfaceC9338a.onFailed();
                }
            }
        }
    }

    /* renamed from: a */
    private void m29058a(InterfaceC9876q interfaceC9876q) {
        C8619c c8619c = m29012sJ() != null ? new C8619c(m29012sJ()) : null;
        this.f29363YJ.mo28983a(interfaceC9876q, this.f29386Zh);
        m29057a(interfaceC9876q, new C9166o());
        m29057a(interfaceC9876q, new C9169p());
        C9221s c9221s = new C9221s();
        c9221s.m29177a(new C9221s.InterfaceC9222a() { // from class: com.kwad.components.core.webview.tachikoma.i.3
            @Override // com.kwad.components.core.webview.tachikoma.p333a.C9221s.InterfaceC9222a
            /* renamed from: a */
            public final void mo28997a(C9258s c9258s) {
                if (TextUtils.isEmpty(c9258s.message)) {
                    return;
                }
                C11128v.m23667d(C9305i.this.mContext, c9258s.message, 0L);
            }
        });
        m29057a(interfaceC9876q, c9221s);
        m29057a(interfaceC9876q, mo29040c(this.f29386Zh));
        m29057a(interfaceC9876q, new C9161l(this.f29386Zh));
        m29057a(interfaceC9876q, new C9163m(this.f29386Zh));
        m29057a(interfaceC9876q, new C10633a());
        m29057a(interfaceC9876q, new C9200f());
        m29057a(interfaceC9876q, new C9232x());
        if (mo29024nk()) {
            C9185x c9185x = new C9185x(this.f29386Zh, c8619c, this);
            if (!this.f29384Zf.equals(C10484b.m25776cP(this.f29386Zh.getAdTemplate()))) {
                C8642g.m30090or().m30092a(this);
            }
            m29057a(interfaceC9876q, c9185x);
        } else {
            m29057a(interfaceC9876q, new C9036aa(this.f29386Zh, c8619c, this, (byte) 0));
        }
        m29057a(interfaceC9876q, new C9191z());
        m29057a(interfaceC9876q, new C9208k());
        m29057a(interfaceC9876q, new C9046ad(this.f29386Zh));
        m29057a(interfaceC9876q, new C9057ag(this.f29386Zh));
        m29057a(interfaceC9876q, new C9091ap(this.mContext, m29012sJ()));
        C9043ac c9043ac = new C9043ac(this.f29386Zh);
        c9043ac.m29330a(new C9043ac.InterfaceC9045b() { // from class: com.kwad.components.core.webview.tachikoma.i.4
            @Override // com.kwad.components.core.webview.jshandler.C9043ac.InterfaceC9045b
            /* renamed from: c */
            public final void mo28996c(C9043ac.C9044a c9044a) {
                C9305i.this.f29363YJ.mo28981b(c9044a);
            }
        });
        m29057a(interfaceC9876q, c9043ac);
        m29057a(interfaceC9876q, new C9067aj(this.f29386Zh, new C9067aj.InterfaceC9071b() { // from class: com.kwad.components.core.webview.tachikoma.i.5
            @Override // com.kwad.components.core.webview.jshandler.C9067aj.InterfaceC9071b
            /* renamed from: a */
            public final void mo28995a(C9067aj.C9070a c9070a) {
                C9305i.this.m29048b(c9070a);
            }
        }));
        m29057a(interfaceC9876q, new C9092aq(new C9092aq.InterfaceC9095b() { // from class: com.kwad.components.core.webview.tachikoma.i.6
            @Override // com.kwad.components.core.webview.jshandler.C9092aq.InterfaceC9095b
            /* renamed from: a */
            public final void mo28994a(C9092aq.C9094a c9094a) {
                if (c9094a.status == 1) {
                    if (!C9305i.this.f29372YS) {
                        C11064bn.m23858c(C9305i.this.f29391Zm);
                        C9305i.this.m29009sM();
                        if (C9305i.this.f29363YJ != null) {
                            C11064bn.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.i.6.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    C9305i.this.f29363YJ.mo28980bF();
                                }
                            });
                            C9283b.m29107tc().m29110c(C9305i.this.f29363YJ.getTkTemplateId(), C9305i.this.f29378YY - C9305i.this.f29359EW, C9305i.this.f29379YZ, C9305i.this.f29377YX > 0 ? SystemClock.elapsedRealtime() - C9305i.this.f29377YX : 0L);
                            return;
                        }
                        return;
                    }
                    C9305i.this.m29047b(TKRenderFailReason.TK_FILE_LOAD_TIMEOUT);
                    return;
                }
                C9305i.this.m29047b(TKRenderFailReason.RENDER_ERROR);
                C9305i.this.m29049aS(c9094a.errorMsg);
            }
        }));
        C9109aw c9109aw = new C9109aw();
        this.f29392cQ = c9109aw;
        m29057a(interfaceC9876q, c9109aw);
        this.f29363YJ.mo28990a(this.f29392cQ);
        C9107av c9107av = new C9107av();
        this.f29369YP = c9107av;
        m29057a(interfaceC9876q, c9107av);
        m29057a(interfaceC9876q, new C9119az(this.f29386Zh, c8619c));
        C9218p c9218p = new C9218p();
        this.f29368YO = c9218p;
        m29057a(interfaceC9876q, c9218p);
        this.f29363YJ.mo28987a(this.f29368YO);
        m29057a(interfaceC9876q, new C9031a(new C9031a.InterfaceC9034b() { // from class: com.kwad.components.core.webview.tachikoma.i.7
            @Override // com.kwad.components.core.webview.jshandler.C9031a.InterfaceC9034b
            /* renamed from: c */
            public final void mo28993c(C9031a.C9033a c9033a) {
                C9305i.this.f29363YJ.mo28991a(c9033a);
            }
        }));
        if (m29012sJ() != null && C10483a.m25956aF(C10487e.m25641dQ(m29012sJ()))) {
            final C9213l c9213l = new C9213l();
            m29057a(interfaceC9876q, c9213l);
            this.f29361VB = new C10326d(m29012sJ()) { // from class: com.kwad.components.core.webview.tachikoma.i.8
                @Override // com.kwad.sdk.core.download.C10326d, com.kwad.sdk.core.download.InterfaceC10325c
                /* renamed from: b */
                public final void mo26277b(String str, String str2, C10327e c10327e) {
                    super.mo26277b(str, str2, c10327e);
                    C9241b c9241b = new C9241b();
                    c9241b.aaf = 1;
                    c9213l.m29182a(c9241b);
                }
            };
            C10303b.m26364De().m26356a(this.f29361VB, m29012sJ());
        }
        C9223t c9223t = new C9223t();
        c9223t.m29176a(new C9223t.InterfaceC9224a() { // from class: com.kwad.components.core.webview.tachikoma.i.9
            @Override // com.kwad.components.core.webview.tachikoma.p333a.C9223t.InterfaceC9224a
            /* renamed from: b */
            public final void mo28992b(C9259t c9259t) {
                C9305i.this.f29363YJ.mo28985a(c9259t);
            }
        });
        m29057a(interfaceC9876q, c9223t);
        C9228v c9228v = new C9228v();
        c9228v.m29173a(new C9228v.InterfaceC9229a() { // from class: com.kwad.components.core.webview.tachikoma.i.10
            @Override // com.kwad.components.core.webview.tachikoma.p333a.C9228v.InterfaceC9229a
            /* renamed from: b */
            public final void mo29004b(C9252m c9252m) {
                C9305i.this.f29363YJ.mo28986a(c9252m);
            }
        });
        m29057a(interfaceC9876q, c9228v);
        C9216o c9216o = new C9216o();
        m29057a(interfaceC9876q, c9216o);
        this.f29363YJ.mo28988a(c9216o);
        m29057a(interfaceC9876q, new C9220r() { // from class: com.kwad.components.core.webview.tachikoma.i.11
            @Override // com.kwad.components.core.webview.tachikoma.p333a.C9220r
            /* renamed from: a */
            public final void mo29003a(C9257r c9257r) {
                super.mo29003a(c9257r);
                if (C9305i.this.mActivity == null) {
                    C9305i c9305i = C9305i.this;
                    C10232b.m26625DD();
                    c9305i.mActivity = C10232b.getCurrentActivity();
                }
                if (C9305i.this.mActivity == null || C9305i.this.mActivity.isFinishing()) {
                    return;
                }
                if (C9305i.this.f29362YI != null) {
                    C9305i.this.f29362YI.dismiss();
                }
                DialogFragmentC9274e.C9277b c9277b = new DialogFragmentC9274e.C9277b();
                c9277b.m29132d(C9305i.this.mAdResultData);
                c9277b.m29138aU(c9257r.templateId);
                C9305i.this.f29362YI = DialogFragmentC9274e.m29149b(c9277b);
                C9305i.this.f29362YI.show(C9305i.this.mActivity.getFragmentManager(), "");
            }
        });
        m29057a(interfaceC9876q, new C9195c() { // from class: com.kwad.components.core.webview.tachikoma.i.13
            @Override // com.kwad.components.core.webview.tachikoma.p333a.C9195c
            /* renamed from: iX */
            public final void mo29002iX() {
                super.mo29002iX();
                if (C9305i.this.f29362YI != null) {
                    C9305i.this.f29362YI.dismiss();
                }
                InterfaceC9339j interfaceC9339j = C9305i.this.f29363YJ;
                if (interfaceC9339j != null) {
                    interfaceC9339j.mo28979bG();
                }
            }
        });
        m29057a(interfaceC9876q, new C9189y(new InterfaceC10636b() { // from class: com.kwad.components.core.webview.tachikoma.i.14
            @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10636b
            /* renamed from: b */
            public final void mo25244b(WebCloseStatus webCloseStatus) {
                C9305i.this.f29363YJ.mo28984a(webCloseStatus);
            }
        }));
        m29057a(interfaceC9876q, new AbstractC9196d() { // from class: com.kwad.components.core.webview.tachikoma.i.15
            @Override // com.kwad.components.core.webview.tachikoma.p333a.AbstractC9196d
            /* renamed from: a */
            public final void mo29001a(C9246g c9246g) {
                int i = c9246g.f29316VN;
                AdTemplate m25663a = i >= 0 ? C10485c.m25663a(C8699a.m30005at(i), c9246g.f29314Jj) : null;
                if (m25663a == null) {
                    m25663a = C9305i.this.m29012sJ();
                }
                C8766a.m29888qi().m29918a(c9246g.actionType, m25663a, c9246g.f29315KG);
            }
        });
        m29057a(interfaceC9876q, new C9207j() { // from class: com.kwad.components.core.webview.tachikoma.i.16
            @Override // com.kwad.components.core.webview.tachikoma.p333a.C9207j
            /* renamed from: a */
            public final void mo29000a(C9253n c9253n) {
                super.mo29000a(c9253n);
                AdWebViewActivityProxy.launch(C9305i.this.mContext, new AdWebViewActivityProxy.C8777a.C8778a().m29855as(c9253n.title).m29854at(c9253n.url).m29857aE(!c9253n.aap).m29852m(C9305i.this.mAdResultData).m29851pl());
            }
        });
        m29057a(interfaceC9876q, new C9193a(m29012sJ()));
        m29057a(interfaceC9876q, new C9192a(m29012sJ()));
        mo29056a(this.f29386Zh, c8619c, interfaceC9876q, this.f29363YJ.getTKContainer());
    }

    /* renamed from: a */
    private static void m29057a(InterfaceC9876q interfaceC9876q, InterfaceC10625a interfaceC10625a) {
        interfaceC9876q.mo27480c(interfaceC10625a);
    }

    /* renamed from: a */
    public final void m29054a(String str, Object obj) {
        m29007sO().put(str, obj);
    }

    @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
    /* renamed from: a */
    public final void mo25245a(@Nullable C10640a c10640a) {
        InterfaceC9339j interfaceC9339j = this.f29363YJ;
        if (interfaceC9339j != null) {
            interfaceC9339j.mo28982a(c10640a);
        }
    }
}
