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
import com.bytedance.sdk.openadsdk.downloadnew.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.h;
import com.ss.android.download.api.config.j;
import com.ss.android.download.api.config.k;
import com.ss.android.download.api.config.p;
import com.ss.android.download.api.config.td;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.config.x;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.a;
import com.ss.android.download.api.model.ok;
import com.ss.android.downloadlib.addownload.a.kf;
import com.ss.android.downloadlib.addownload.ok.ok;
import com.ss.android.socialbase.downloader.depend.fb;
import com.ss.android.socialbase.downloader.depend.vz;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.network.q;
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

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class bl {
    public static ITTDownloadVisitor bl;

    /* renamed from: h  reason: collision with root package name */
    private static final com.ss.android.download.api.download.ok.ok f35806h;
    private static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> kf;

    /* renamed from: n  reason: collision with root package name */
    private static Context f35807n;
    public static volatile String ok;

    /* renamed from: s  reason: collision with root package name */
    private static final AtomicBoolean f35808s = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    public static boolean f35805a = true;

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class n implements IDownloadHttpService {
        @Override // com.ss.android.socialbase.downloader.network.IDownloadHttpService
        public q downloadWithConnection(int i4, String str, List<com.ss.android.socialbase.downloader.model.bl> list) throws IOException {
            final a.ok ok = com.bytedance.sdk.openadsdk.downloadnew.a.ok(str, list);
            if (ok != null) {
                return new q() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.n.1
                    @Override // com.ss.android.socialbase.downloader.network.h
                    public int a() {
                        return ok.bl;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.h
                    public void bl() {
                    }

                    @Override // com.ss.android.socialbase.downloader.network.q
                    public InputStream ok() {
                        return ok.ok;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.q
                    public void s() {
                        try {
                            ok.f35804s.disconnect();
                        } catch (Exception unused) {
                        }
                    }

                    @Override // com.ss.android.socialbase.downloader.network.h
                    public String ok(String str2) {
                        Map<String, String> map = ok.f35803a;
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
            ok = getContext().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
        f35806h = new com.ss.android.download.api.download.ok.ok() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.6
            @Override // com.ss.android.download.api.download.ok.ok
            public void a(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.bl.a("TTDownloadVisitor", "completeListener: onInstalled");
                bl.bl(str);
            }

            @Override // com.ss.android.download.api.download.ok.ok
            public void ok(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
                com.bytedance.sdk.openadsdk.api.bl.a("TTDownloadVisitor", "completeListener: onDownloadStart");
            }

            @Override // com.ss.android.download.api.download.ok.ok
            public void ok(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.bl.a("TTDownloadVisitor", "completeListener: onDownloadFinished");
            }

            @Override // com.ss.android.download.api.download.ok.ok
            public void ok(DownloadInfo downloadInfo, BaseException baseException, String str) {
                com.bytedance.sdk.openadsdk.api.bl.a("TTDownloadVisitor", "completeListener: onDownloadFailed");
            }

            @Override // com.ss.android.download.api.download.ok.ok
            public void ok(DownloadInfo downloadInfo) {
                com.bytedance.sdk.openadsdk.api.bl.a("TTDownloadVisitor", "completeListener: onCanceled");
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bl(String str) {
        com.ss.android.downloadad.api.ok.a ok2;
        JSONObject h4;
        if (TextUtils.isEmpty(str) || (ok2 = kf.ok().ok(str)) == null || (h4 = ok2.h()) == null || n() == null) {
            return;
        }
        n().checkAutoControl(h4, str);
    }

    private static Context getContext() {
        Context context = f35807n;
        return context == null ? TTAppContextHolder.getContext() : context;
    }

    private static boolean kf() {
        return false;
    }

    private static ITTDownloadVisitor n() {
        ITTDownloadVisitor iTTDownloadVisitor = bl;
        if (iTTDownloadVisitor == null) {
            TTAdManager adManager = TTAdSdk.getAdManager();
            if (adManager == null) {
                return null;
            }
            return (ITTDownloadVisitor) adManager.getExtra(ITTDownloadVisitor.class, com.bytedance.sdk.openadsdk.downloadnew.ok.ok(1));
        }
        return iTTDownloadVisitor;
    }

    static /* synthetic */ ITTDownloadVisitor s() {
        return n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.bl$bl  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class C0526bl implements com.ss.android.download.api.config.q {
        @Override // com.ss.android.download.api.config.q
        public void ok(Activity activity, int i4, String[] strArr, int[] iArr) {
        }

        @Override // com.ss.android.download.api.config.q
        public void ok(Activity activity, String[] strArr, final u uVar) {
            if (bl.s() != null) {
                bl.s().requestPermission(activity, strArr, new ITTPermissionCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.bl.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onDenied(String str) {
                        u uVar2 = uVar;
                        if (uVar2 != null) {
                            uVar2.ok(str);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onGranted() {
                        u uVar2 = uVar;
                        if (uVar2 != null) {
                            uVar2.ok();
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.q
        public boolean ok(Context context, String str) {
            if (bl.s() != null) {
                return bl.s().hasPermission(context, str);
            }
            return false;
        }
    }

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class ok implements h {
        private void bl(com.ss.android.download.api.model.bl blVar) {
            if (blVar == null) {
                return;
            }
            Object j4 = blVar.j();
            TTDownloadEventModel label = TTDownloadEventModel.builder().setTag(blVar.a()).setExtJson(blVar.p()).setMaterialMeta(j4 instanceof JSONObject ? (JSONObject) j4 : null).setLabel(blVar.bl());
            boolean z3 = "download_notification".equals(blVar.a()) || "landing_h5_download_ad_button".equals(blVar.a());
            if (bl.s() != null) {
                bl.s().executeLogUpload(label, z3);
            }
        }

        @Override // com.ss.android.download.api.config.h
        public void a(com.ss.android.download.api.model.bl blVar) {
            com.bytedance.sdk.openadsdk.api.bl.a("LibEventLogger", "onEvent called");
            ok(blVar, false);
            bl(blVar);
        }

        @Override // com.ss.android.download.api.config.h
        public void ok(com.ss.android.download.api.model.bl blVar) {
            com.bytedance.sdk.openadsdk.api.bl.a("LibEventLogger", "onV3Event");
            ok(blVar, true);
        }

        private void ok(com.ss.android.download.api.model.bl blVar, boolean z3) {
            TTDownloadEventLogger tTDownloadEventLogger;
            if (bl.s() == null || (tTDownloadEventLogger = bl.s().getTTDownloadEventLogger()) == null || blVar == null) {
                return;
            }
            if (tTDownloadEventLogger.shouldFilterOpenSdkLog() && bl.s().isOpenSdkEvent(blVar.toString())) {
                return;
            }
            if (z3) {
                tTDownloadEventLogger.onV3Event(bl.a(blVar));
            } else {
                tTDownloadEventLogger.onEvent(bl.a(blVar));
            }
        }
    }

    public static void a() {
        ok().h();
        if (n() != null) {
            n().clearAllData(ok);
        }
    }

    public static void ok(Context context) {
        if (context == null) {
            context = TTAppContextHolder.getContext();
        }
        if (context == null) {
            return;
        }
        AtomicBoolean atomicBoolean = f35808s;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (bl.class) {
            if (!atomicBoolean.get()) {
                f35807n = StubApp.getOrigApplicationContext(context.getApplicationContext());
                if (n() != null) {
                    String initPath = n().initPath(f35805a);
                    if (!TextUtils.isEmpty(initPath)) {
                        ok = initPath;
                    }
                }
                atomicBoolean.set(a(f35807n));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class a implements p {
        private a() {
        }

        public void ok(String str, String str2, Map<String, Object> map, final td tdVar) {
            str.hashCode();
            int i4 = 0;
            if (!str.equals("GET") && str.equals("POST")) {
                i4 = 1;
            }
            if (bl.s() != null) {
                bl.s().execute(i4, str2, map, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.a.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        td tdVar2 = tdVar;
                        if (tdVar2 != null) {
                            tdVar2.ok(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        td tdVar2 = tdVar;
                        if (tdVar2 != null) {
                            tdVar2.ok(str3);
                        }
                    }
                });
            }
        }

        public void ok(String str, byte[] bArr, String str2, int i4, final td tdVar) {
            if (bl.s() != null) {
                bl.s().postBody(str, bArr, str2, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.a.2
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        td tdVar2 = tdVar;
                        if (tdVar2 != null) {
                            tdVar2.ok(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        td tdVar2 = tdVar;
                        if (tdVar2 != null) {
                            tdVar2.ok(str3);
                        }
                    }
                });
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class s implements j {
        private final WeakReference<Context> ok;

        public s(Context context) {
            this.ok = new WeakReference<>(context);
        }

        private DialogBuilder bl(final com.ss.android.download.api.model.a aVar) {
            return DialogBuilder.builder().setTitle(aVar.f48201a).setMessage(aVar.bl).setNegativeBtnText(aVar.f48204n).setPositiveBtnText(aVar.f48207s).setIcon(aVar.f48202h).setDialogStatusChangedListener(new IDialogStatusChangedListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.s.1
                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onCancel(DialogInterface dialogInterface) {
                    a.InterfaceC0935a interfaceC0935a = aVar.f48205p;
                    if (interfaceC0935a != null) {
                        interfaceC0935a.bl(dialogInterface);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onNegativeBtnClick(DialogInterface dialogInterface) {
                    a.InterfaceC0935a interfaceC0935a = aVar.f48205p;
                    if (interfaceC0935a != null) {
                        try {
                            interfaceC0935a.a(dialogInterface);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onPositiveBtnClick(DialogInterface dialogInterface) {
                    a.InterfaceC0935a interfaceC0935a = aVar.f48205p;
                    if (interfaceC0935a != null) {
                        interfaceC0935a.ok(dialogInterface);
                    }
                }
            });
        }

        @Override // com.ss.android.download.api.config.j
        public void ok(int i4, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i5) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Toast.makeText(context, str, 0).show();
            } catch (Exception e4) {
                com.ss.android.socialbase.downloader.bl.ok.n("LibUIFactory", "showToastWithDuration e " + e4.getMessage());
            }
        }

        @Override // com.ss.android.download.api.config.j
        /* renamed from: ok */
        public AlertDialog a(com.ss.android.download.api.model.a aVar) {
            if (aVar != null && bl.s() != null) {
                Context context = aVar.ok;
                if (context != null && (context instanceof Activity)) {
                    return bl.s().showDialogBySelf((Activity) aVar.ok, aVar.f48203k == 1, bl(aVar));
                }
                bl.s().showDialogByDelegate(this.ok, aVar.f48203k == 1, bl(aVar));
            }
            return null;
        }
    }

    private static boolean a(Context context) {
        com.ss.android.download.api.ok ok2;
        if (context == null) {
            return false;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        String packageName = origApplicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        if (kf()) {
            try {
                ok2 = com.ss.android.downloadlib.p.ok(origApplicationContext).ok("pangolin");
            } catch (Throwable unused) {
                ok2 = com.ss.android.downloadlib.p.ok(origApplicationContext).ok();
            }
        } else {
            ok2 = com.ss.android.downloadlib.p.ok(origApplicationContext).ok();
        }
        if (ok2 == null) {
            return false;
        }
        com.ss.android.download.api.ok ok3 = ok2.ok(new C0526bl()).ok(new ok()).ok(new s(origApplicationContext)).ok(new a()).ok(new k() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.3
            public JSONObject ok() {
                if (bl.s() != null) {
                    return bl.s().getDownloadSettings();
                }
                return new JSONObject();
            }
        }).ok(new com.ss.android.download.api.config.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.2
            public boolean ok() {
                if (bl.s() != null) {
                    return bl.s().getAppIsBackground();
                }
                return false;
            }
        }).ok(new ok.C0937ok().a("143").ok("open_news").bl("5.9.0.8").s(String.valueOf(5908)).ok()).ok(new x() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.1
            @Override // com.ss.android.download.api.config.x
            public byte[] ok(byte[] bArr, int i4) {
                return new byte[0];
            }
        });
        ok3.ok(packageName + ".TTFileProvider").ok(ok(origApplicationContext, n() != null ? n().getDownloadSettings() : new JSONObject())).ok();
        com.ss.android.downloadlib.h.ok.ok();
        com.ss.android.downloadlib.p.ok(origApplicationContext).s().ok(1);
        com.ss.android.downloadlib.p.ok(origApplicationContext).ok(f35806h);
        com.ss.android.socialbase.appdownloader.s.k().ok(new fb() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.4
            @Override // com.ss.android.socialbase.downloader.depend.fb
            public boolean ok(Intent intent) {
                return false;
            }
        });
        TTDownloadEventLogger tTDownloadEventLogger = n() != null ? n().getTTDownloadEventLogger() : null;
        if (tTDownloadEventLogger != null) {
            tTDownloadEventLogger.onDownloadConfigReady();
        }
        return true;
    }

    public static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> bl() {
        return kf;
    }

    public static void ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ok = str;
    }

    public static com.ss.android.downloadlib.p ok() {
        ok(getContext());
        return com.ss.android.downloadlib.p.ok(getContext());
    }

    public static boolean ok(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return ok().n().ok(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener);
    }

    public static boolean ok(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return ok().n().ok(context, uri, downloadModel, downloadEventConfig, downloadController);
    }

    public static boolean ok(Uri uri) {
        return com.ss.android.downloadlib.a.k.ok(uri);
    }

    public static void ok(int i4) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> map = kf;
        if (map != null) {
            map.remove(Integer.valueOf(i4));
        }
    }

    public static void ok(int i4, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        if (onEventLogHandler != null) {
            if (kf == null) {
                kf = Collections.synchronizedMap(new WeakHashMap());
            }
            kf.put(Integer.valueOf(i4), onEventLogHandler);
        }
    }

    public static boolean ok(String str, String str2, JSONObject jSONObject, Object obj) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> bl2;
        boolean z3 = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null && (bl2 = bl()) != null) {
            for (Map.Entry<Integer, ITTDownloadAdapter.OnEventLogHandler> entry : bl2.entrySet()) {
                int intValue = entry.getKey().intValue();
                ITTDownloadAdapter.OnEventLogHandler value = entry.getValue();
                if (value != null) {
                    boolean onEventLog = value.onEventLog(intValue, jSONObject.toString(), str, str2, obj);
                    if (!z3 && !onEventLog) {
                        z3 = true;
                    }
                }
            }
        }
        return z3;
    }

    private static DownloaderBuilder ok(Context context, JSONObject jSONObject) {
        return new DownloaderBuilder(context).downloadSetting(new vz() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.5
            @Override // com.ss.android.socialbase.downloader.depend.vz
            public JSONObject ok() {
                if (bl.s() != null) {
                    return bl.s().getDownloadSettings();
                }
                return new JSONObject();
            }
        }).downloadExpSwitch(jSONObject.optInt("download_exp_switch_temp", 1040187391)).httpService(new n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject a(com.ss.android.download.api.model.bl blVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", blVar.ok());
            jSONObject.put("tag", blVar.a());
            jSONObject.put("label", blVar.bl());
            jSONObject.put("isAd", blVar.s());
            jSONObject.put("adId", blVar.n());
            jSONObject.put("logExtra", blVar.kf());
            jSONObject.put("extValue", blVar.h());
            jSONObject.put("extJson", blVar.p());
            jSONObject.put("paramsJson", blVar.q());
            jSONObject.put("eventSource", blVar.r());
            jSONObject.put("extraObject", blVar.j());
            jSONObject.put("clickTrackUrl", blVar.k());
            jSONObject.put("isV3", blVar.z());
            jSONObject.put("V3EventName", blVar.rh());
            jSONObject.put("V3EventParams", blVar.t());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean ok(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<DownloadInfo> a4 = com.ss.android.socialbase.appdownloader.s.k().a(context);
            if (!a4.isEmpty()) {
                for (DownloadInfo downloadInfo : a4) {
                    if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean ok(Activity activity, final ExitInstallListener exitInstallListener) {
        return com.ss.android.downloadlib.addownload.ok.ok.ok().ok(activity, false, new ok.InterfaceC0944ok() { // from class: com.bytedance.sdk.openadsdk.downloadnew.bl.7
            @Override // com.ss.android.downloadlib.addownload.ok.ok.InterfaceC0944ok
            public void ok() {
                ExitInstallListener exitInstallListener2 = ExitInstallListener.this;
                if (exitInstallListener2 != null) {
                    exitInstallListener2.onExitInstall();
                }
            }
        });
    }
}
