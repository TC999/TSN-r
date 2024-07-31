package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTAppContextHolder;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.api.C6280bl;
import com.bytedance.sdk.openadsdk.downloadnew.C6389a;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.p521ss.android.download.api.InterfaceC11990ok;
import com.p521ss.android.download.api.config.IDownloadButtonClickListener;
import com.p521ss.android.download.api.config.InterfaceC11953a;
import com.p521ss.android.download.api.config.InterfaceC11955h;
import com.p521ss.android.download.api.config.InterfaceC11958j;
import com.p521ss.android.download.api.config.InterfaceC11959k;
import com.p521ss.android.download.api.config.InterfaceC11963p;
import com.p521ss.android.download.api.config.InterfaceC11964q;
import com.p521ss.android.download.api.config.InterfaceC11969td;
import com.p521ss.android.download.api.config.InterfaceC11970u;
import com.p521ss.android.download.api.config.InterfaceC11971x;
import com.p521ss.android.download.api.download.DownloadController;
import com.p521ss.android.download.api.download.DownloadEventConfig;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.download.api.download.p524ok.InterfaceC11979ok;
import com.p521ss.android.download.api.model.C11980a;
import com.p521ss.android.download.api.model.C11984bl;
import com.p521ss.android.download.api.model.C11986ok;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.C12257p;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p531ok.C12117ok;
import com.p521ss.android.downloadlib.p527a.C12010k;
import com.p521ss.android.downloadlib.p534h.C12202ok;
import com.p521ss.android.socialbase.appdownloader.C12361s;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12429fb;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12481vz;
import com.p521ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.C12601bl;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12635q;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.stub.StubApp;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.downloadnew.bl */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6391bl {

    /* renamed from: bl */
    public static ITTDownloadVisitor f22537bl;

    /* renamed from: h */
    private static final InterfaceC11979ok f22538h;

    /* renamed from: kf */
    private static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> f22539kf;

    /* renamed from: n */
    private static Context f22540n;

    /* renamed from: ok */
    public static volatile String f22541ok;

    /* renamed from: s */
    private static final AtomicBoolean f22542s = new AtomicBoolean(false);

    /* renamed from: a */
    public static boolean f22536a = true;

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.bl$n */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6404n implements IDownloadHttpService {
        @Override // com.p521ss.android.socialbase.downloader.network.IDownloadHttpService
        public InterfaceC12635q downloadWithConnection(int i, String str, List<C12601bl> list) throws IOException {
            final C6389a.C6390ok m36497ok = C6389a.m36497ok(str, list);
            if (m36497ok != null) {
                return new InterfaceC12635q() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.n.1
                    @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12620h
                    /* renamed from: a */
                    public int mo16918a() {
                        return m36497ok.f22533bl;
                    }

                    @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12620h
                    /* renamed from: bl */
                    public void mo16917bl() {
                    }

                    @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12635q
                    /* renamed from: ok */
                    public InputStream mo16909ok() {
                        return m36497ok.f22534ok;
                    }

                    @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12635q
                    /* renamed from: s */
                    public void mo16908s() {
                        try {
                            m36497ok.f22535s.disconnect();
                        } catch (Exception unused) {
                        }
                    }

                    @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12620h
                    /* renamed from: ok */
                    public String mo16912ok(String str2) {
                        Map<String, String> map = m36497ok.f22532a;
                        if (map != null) {
                            return map.get(str2);
                        }
                        return null;
                    }
                };
            }
            return null;
        }
    }

    static {
        try {
            f22541ok = getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
        f22538h = new InterfaceC11979ok() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.6
            @Override // com.p521ss.android.download.api.download.p524ok.InterfaceC11979ok
            /* renamed from: a */
            public void mo19615a(DownloadInfo downloadInfo, String str) {
                C6280bl.m36774a("TTDownloadVisitor", "completeListener: onInstalled");
                C6391bl.m36489bl(str);
            }

            @Override // com.p521ss.android.download.api.download.p524ok.InterfaceC11979ok
            /* renamed from: ok */
            public void mo19614ok(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
                C6280bl.m36774a("TTDownloadVisitor", "completeListener: onDownloadStart");
            }

            @Override // com.p521ss.android.download.api.download.p524ok.InterfaceC11979ok
            /* renamed from: ok */
            public void mo19611ok(DownloadInfo downloadInfo, String str) {
                C6280bl.m36774a("TTDownloadVisitor", "completeListener: onDownloadFinished");
            }

            @Override // com.p521ss.android.download.api.download.p524ok.InterfaceC11979ok
            /* renamed from: ok */
            public void mo19612ok(DownloadInfo downloadInfo, BaseException baseException, String str) {
                C6280bl.m36774a("TTDownloadVisitor", "completeListener: onDownloadFailed");
            }

            @Override // com.p521ss.android.download.api.download.p524ok.InterfaceC11979ok
            /* renamed from: ok */
            public void mo19613ok(DownloadInfo downloadInfo) {
                C6280bl.m36774a("TTDownloadVisitor", "completeListener: onCanceled");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bl */
    public static void m36489bl(String str) {
        C11998a m19314ok;
        JSONObject mo19307h;
        if (TextUtils.isEmpty(str) || (m19314ok = C12032kf.m19324ok().m19314ok(str)) == null || (mo19307h = m19314ok.mo19307h()) == null || m36487n() == null) {
            return;
        }
        m36487n().checkAutoControl(mo19307h, str);
    }

    private static Context getContext() {
        Context context = f22540n;
        return context == null ? TTAppContextHolder.getContext() : context;
    }

    /* renamed from: kf */
    private static boolean m36488kf() {
        return false;
    }

    /* renamed from: n */
    private static ITTDownloadVisitor m36487n() {
        ITTDownloadVisitor iTTDownloadVisitor = f22537bl;
        if (iTTDownloadVisitor == null) {
            TTAdManager adManager = TTAdSdk.getAdManager();
            if (adManager == null) {
                return null;
            }
            return (ITTDownloadVisitor) adManager.getExtra(ITTDownloadVisitor.class, C6409ok.m36468ok(1));
        }
        return iTTDownloadVisitor;
    }

    /* renamed from: s */
    static /* synthetic */ ITTDownloadVisitor m36473s() {
        return m36487n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.bl$bl */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6402bl implements InterfaceC11964q {
        @Override // com.p521ss.android.download.api.config.InterfaceC11964q
        /* renamed from: ok */
        public void mo19532ok(Activity activity, int i, String[] strArr, int[] iArr) {
        }

        @Override // com.p521ss.android.download.api.config.InterfaceC11964q
        /* renamed from: ok */
        public void mo19531ok(Activity activity, String[] strArr, final InterfaceC11970u interfaceC11970u) {
            if (C6391bl.m36473s() != null) {
                C6391bl.m36473s().requestPermission(activity, strArr, new ITTPermissionCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.bl.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onDenied(String str) {
                        InterfaceC11970u interfaceC11970u2 = interfaceC11970u;
                        if (interfaceC11970u2 != null) {
                            interfaceC11970u2.mo18983ok(str);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onGranted() {
                        InterfaceC11970u interfaceC11970u2 = interfaceC11970u;
                        if (interfaceC11970u2 != null) {
                            interfaceC11970u2.mo18984ok();
                        }
                    }
                });
            }
        }

        @Override // com.p521ss.android.download.api.config.InterfaceC11964q
        /* renamed from: ok */
        public boolean mo19530ok(Context context, String str) {
            if (C6391bl.m36473s() != null) {
                return C6391bl.m36473s().hasPermission(context, str);
            }
            return false;
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.bl$ok */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6406ok implements InterfaceC11955h {
        /* renamed from: bl */
        private void m36472bl(C11984bl c11984bl) {
            if (c11984bl == null) {
                return;
            }
            Object m19590j = c11984bl.m19590j();
            TTDownloadEventModel label = TTDownloadEventModel.builder().setTag(c11984bl.m19593a()).setExtJson(c11984bl.m19585p()).setMaterialMeta(m19590j instanceof JSONObject ? (JSONObject) m19590j : null).setLabel(c11984bl.m19592bl());
            boolean z = "download_notification".equals(c11984bl.m19593a()) || "landing_h5_download_ad_button".equals(c11984bl.m19593a());
            if (C6391bl.m36473s() != null) {
                C6391bl.m36473s().executeLogUpload(label, z);
            }
        }

        @Override // com.p521ss.android.download.api.config.InterfaceC11955h
        /* renamed from: a */
        public void mo19655a(C11984bl c11984bl) {
            C6280bl.m36774a("LibEventLogger", "onEvent called");
            m36471ok(c11984bl, false);
            m36472bl(c11984bl);
        }

        @Override // com.p521ss.android.download.api.config.InterfaceC11955h
        /* renamed from: ok */
        public void mo19654ok(C11984bl c11984bl) {
            C6280bl.m36774a("LibEventLogger", "onV3Event");
            m36471ok(c11984bl, true);
        }

        /* renamed from: ok */
        private void m36471ok(C11984bl c11984bl, boolean z) {
            TTDownloadEventLogger tTDownloadEventLogger;
            if (C6391bl.m36473s() == null || (tTDownloadEventLogger = C6391bl.m36473s().getTTDownloadEventLogger()) == null || c11984bl == null) {
                return;
            }
            if (tTDownloadEventLogger.shouldFilterOpenSdkLog() && C6391bl.m36473s().isOpenSdkEvent(c11984bl.toString())) {
                return;
            }
            if (z) {
                tTDownloadEventLogger.onV3Event(C6391bl.m36492a(c11984bl));
            } else {
                tTDownloadEventLogger.onEvent(C6391bl.m36492a(c11984bl));
            }
        }
    }

    /* renamed from: a */
    public static void m36494a() {
        m36486ok().m18576h();
        if (m36487n() != null) {
            m36487n().clearAllData(f22541ok);
        }
    }

    /* renamed from: ok */
    public static void m36482ok(Context context) {
        if (context == null) {
            context = TTAppContextHolder.getContext();
        }
        if (context == null) {
            return;
        }
        AtomicBoolean atomicBoolean = f22542s;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (C6391bl.class) {
            if (!atomicBoolean.get()) {
                f22540n = StubApp.getOrigApplicationContext(context.getApplicationContext());
                if (m36487n() != null) {
                    String initPath = m36487n().initPath(f22536a);
                    if (!TextUtils.isEmpty(initPath)) {
                        f22541ok = initPath;
                    }
                }
                atomicBoolean.set(m36493a(f22540n));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.bl$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6399a implements InterfaceC11963p {
        private C6399a() {
        }

        @Override // com.p521ss.android.download.api.config.InterfaceC11963p
        /* renamed from: ok */
        public void mo19648ok(String str, String str2, Map<String, Object> map, final InterfaceC11969td interfaceC11969td) {
            str.hashCode();
            int i = 0;
            if (!str.equals("GET") && str.equals("POST")) {
                i = 1;
            }
            if (C6391bl.m36473s() != null) {
                C6391bl.m36473s().execute(i, str2, map, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.a.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        InterfaceC11969td interfaceC11969td2 = interfaceC11969td;
                        if (interfaceC11969td2 != null) {
                            interfaceC11969td2.mo18686ok(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        InterfaceC11969td interfaceC11969td2 = interfaceC11969td;
                        if (interfaceC11969td2 != null) {
                            interfaceC11969td2.mo18687ok(str3);
                        }
                    }
                });
            }
        }

        @Override // com.p521ss.android.download.api.config.InterfaceC11963p
        /* renamed from: ok */
        public void mo19647ok(String str, byte[] bArr, String str2, int i, final InterfaceC11969td interfaceC11969td) {
            if (C6391bl.m36473s() != null) {
                C6391bl.m36473s().postBody(str, bArr, str2, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.a.2
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        InterfaceC11969td interfaceC11969td2 = interfaceC11969td;
                        if (interfaceC11969td2 != null) {
                            interfaceC11969td2.mo18686ok(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        InterfaceC11969td interfaceC11969td2 = interfaceC11969td;
                        if (interfaceC11969td2 != null) {
                            interfaceC11969td2.mo18687ok(str3);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.bl$s */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6407s implements InterfaceC11958j {

        /* renamed from: ok */
        private final WeakReference<Context> f22552ok;

        public C6407s(Context context) {
            this.f22552ok = new WeakReference<>(context);
        }

        /* renamed from: bl */
        private DialogBuilder m36470bl(final C11980a c11980a) {
            return DialogBuilder.builder().setTitle(c11980a.f33853a).setMessage(c11980a.f33854bl).setNegativeBtnText(c11980a.f33858n).setPositiveBtnText(c11980a.f33862s).setIcon(c11980a.f33855h).setDialogStatusChangedListener(new IDialogStatusChangedListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.s.1
                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onCancel(DialogInterface dialogInterface) {
                    C11980a.InterfaceC11982a interfaceC11982a = c11980a.f33860p;
                    if (interfaceC11982a != null) {
                        interfaceC11982a.mo18861bl(dialogInterface);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onNegativeBtnClick(DialogInterface dialogInterface) {
                    C11980a.InterfaceC11982a interfaceC11982a = c11980a.f33860p;
                    if (interfaceC11982a != null) {
                        try {
                            interfaceC11982a.mo18862a(dialogInterface);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onPositiveBtnClick(DialogInterface dialogInterface) {
                    C11980a.InterfaceC11982a interfaceC11982a = c11980a.f33860p;
                    if (interfaceC11982a != null) {
                        interfaceC11982a.mo18860ok(dialogInterface);
                    }
                }
            });
        }

        @Override // com.p521ss.android.download.api.config.InterfaceC11958j
        /* renamed from: ok */
        public void mo19528ok(int i, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i2) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Toast.makeText(context, str, 0).show();
            } catch (Exception e) {
                C12409ok.m17900n("LibUIFactory", "showToastWithDuration e " + e.getMessage());
            }
        }

        @Override // com.p521ss.android.download.api.config.InterfaceC11958j
        /* renamed from: ok */
        public AlertDialog mo19529a(C11980a c11980a) {
            if (c11980a != null && C6391bl.m36473s() != null) {
                Context context = c11980a.f33859ok;
                if (context != null && (context instanceof Activity)) {
                    return C6391bl.m36473s().showDialogBySelf((Activity) c11980a.f33859ok, c11980a.f33856k == 1, m36470bl(c11980a));
                }
                C6391bl.m36473s().showDialogByDelegate(this.f22552ok, c11980a.f33856k == 1, m36470bl(c11980a));
            }
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m36493a(Context context) {
        InterfaceC11990ok m18573ok;
        if (context == null) {
            return false;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        String packageName = origApplicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        if (m36488kf()) {
            try {
                m18573ok = C12257p.m18572ok(origApplicationContext).m18568ok("pangolin");
            } catch (Throwable unused) {
                m18573ok = C12257p.m18572ok(origApplicationContext).m18573ok();
            }
        } else {
            m18573ok = C12257p.m18572ok(origApplicationContext).m18573ok();
        }
        if (m18573ok == null) {
            return false;
        }
        InterfaceC11990ok mo18654ok = m18573ok.mo18655ok(new C6402bl()).mo18659ok(new C6406ok()).mo18658ok(new C6407s(origApplicationContext)).mo18656ok(new C6399a()).mo18657ok(new InterfaceC11959k() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.3
            @Override // com.p521ss.android.download.api.config.InterfaceC11959k
            /* renamed from: ok */
            public JSONObject mo19652ok() {
                if (C6391bl.m36473s() != null) {
                    return C6391bl.m36473s().getDownloadSettings();
                }
                return new JSONObject();
            }
        }).mo18660ok(new InterfaceC11953a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.2
            @Override // com.p521ss.android.download.api.config.InterfaceC11953a
            /* renamed from: ok */
            public boolean mo19656ok() {
                if (C6391bl.m36473s() != null) {
                    return C6391bl.m36473s().getAppIsBackground();
                }
                return false;
            }
        }).mo18653ok(new C11986ok.C11987ok().m19547a("143").m19541ok("open_news").m19545bl("5.9.0.8").m19539s(String.valueOf(5908)).m19543ok()).mo18654ok(new InterfaceC11971x() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.1
            @Override // com.p521ss.android.download.api.config.InterfaceC11971x
            /* renamed from: ok */
            public byte[] mo19636ok(byte[] bArr, int i) {
                return new byte[0];
            }
        });
        mo18654ok.mo18651ok(packageName + ".TTFileProvider").mo18652ok(m36478ok(origApplicationContext, m36487n() != null ? m36487n().getDownloadSettings() : new JSONObject())).mo18661ok();
        C12202ok.m18730ok();
        C12257p.m18572ok(origApplicationContext).m18560s().mo18625ok(1);
        C12257p.m18572ok(origApplicationContext).m18570ok(f22538h);
        C12361s.m18068k().m18052ok(new InterfaceC12429fb() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.4
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12429fb
            /* renamed from: ok */
            public boolean mo17881ok(Intent intent) {
                return false;
            }
        });
        TTDownloadEventLogger tTDownloadEventLogger = m36487n() != null ? m36487n().getTTDownloadEventLogger() : null;
        if (tTDownloadEventLogger != null) {
            tTDownloadEventLogger.onDownloadConfigReady();
        }
        return true;
    }

    /* renamed from: bl */
    public static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> m36490bl() {
        return f22539kf;
    }

    /* renamed from: ok */
    public static void m36475ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f22541ok = str;
    }

    /* renamed from: ok */
    public static C12257p m36486ok() {
        m36482ok(getContext());
        return C12257p.m18572ok(getContext());
    }

    /* renamed from: ok */
    public static boolean m36480ok(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return m36486ok().m18574n().mo19417ok(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener);
    }

    /* renamed from: ok */
    public static boolean m36481ok(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return m36486ok().m18574n().mo19418ok(context, uri, downloadModel, downloadEventConfig, downloadController);
    }

    /* renamed from: ok */
    public static boolean m36477ok(Uri uri) {
        return C12010k.m19405ok(uri);
    }

    /* renamed from: ok */
    public static void m36485ok(int i) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> map = f22539kf;
        if (map != null) {
            map.remove(Integer.valueOf(i));
        }
    }

    /* renamed from: ok */
    public static void m36484ok(int i, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        if (onEventLogHandler != null) {
            if (f22539kf == null) {
                f22539kf = Collections.synchronizedMap(new WeakHashMap());
            }
            f22539kf.put(Integer.valueOf(i), onEventLogHandler);
        }
    }

    /* renamed from: ok */
    public static boolean m36474ok(String str, String str2, JSONObject jSONObject, Object obj) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> m36490bl;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null && (m36490bl = m36490bl()) != null) {
            for (Map.Entry<Integer, ITTDownloadAdapter.OnEventLogHandler> entry : m36490bl.entrySet()) {
                int intValue = entry.getKey().intValue();
                ITTDownloadAdapter.OnEventLogHandler value = entry.getValue();
                if (value != null) {
                    boolean onEventLog = value.onEventLog(intValue, jSONObject.toString(), str, str2, obj);
                    if (!z && !onEventLog) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: ok */
    private static DownloaderBuilder m36478ok(Context context, JSONObject jSONObject) {
        return new DownloaderBuilder(context).downloadSetting(new InterfaceC12481vz() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.5
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12481vz
            /* renamed from: ok */
            public JSONObject mo17845ok() {
                if (C6391bl.m36473s() != null) {
                    return C6391bl.m36473s().getDownloadSettings();
                }
                return new JSONObject();
            }
        }).downloadExpSwitch(jSONObject.optInt("download_exp_switch_temp", 1040187391)).httpService(new C6404n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static JSONObject m36492a(C11984bl c11984bl) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", c11984bl.m19586ok());
            jSONObject.put("tag", c11984bl.m19593a());
            jSONObject.put(TTDownloadField.TT_LABEL, c11984bl.m19592bl());
            jSONObject.put(TTDownloadField.TT_IS_AD, c11984bl.m19581s());
            jSONObject.put("adId", c11984bl.m19587n());
            jSONObject.put(TTDownloadField.TT_LOG_EXTRA, c11984bl.m19588kf());
            jSONObject.put("extValue", c11984bl.m19591h());
            jSONObject.put("extJson", c11984bl.m19585p());
            jSONObject.put(TTDownloadField.TT_PARAMS_JSON, c11984bl.m19584q());
            jSONObject.put("eventSource", c11984bl.m19583r());
            jSONObject.put(TTDownloadField.TT_EXTRA_OBJECT, c11984bl.m19590j());
            jSONObject.put(TTDownloadField.TT_CLICK_TRACK_URL, c11984bl.m19589k());
            jSONObject.put("isV3", c11984bl.m19579z());
            jSONObject.put("V3EventName", c11984bl.m19582rh());
            jSONObject.put("V3EventParams", c11984bl.m19580t());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* renamed from: ok */
    public static boolean m36479ok(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<DownloadInfo> m18078a = C12361s.m18068k().m18078a(context);
            if (!m18078a.isEmpty()) {
                for (DownloadInfo downloadInfo : m18078a) {
                    if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: ok */
    public static boolean m36483ok(Activity activity, final ExitInstallListener exitInstallListener) {
        return C12117ok.m19022ok().m19019ok(activity, false, new C12117ok.InterfaceC12119ok() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.7
            @Override // com.p521ss.android.downloadlib.addownload.p531ok.C12117ok.InterfaceC12119ok
            /* renamed from: ok */
            public void mo19013ok() {
                ExitInstallListener exitInstallListener2 = ExitInstallListener.this;
                if (exitInstallListener2 != null) {
                    exitInstallListener2.onExitInstall();
                }
            }
        });
    }
}
