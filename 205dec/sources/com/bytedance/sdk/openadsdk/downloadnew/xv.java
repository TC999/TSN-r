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
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.bytedance.sdk.openadsdk.downloadnew.w;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.ev;
import com.ss.android.download.api.config.ia;
import com.ss.android.download.api.config.p;
import com.ss.android.download.api.config.r;
import com.ss.android.download.api.config.u;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.c;
import com.ss.android.download.api.model.w;
import com.ss.android.downloadlib.addownload.c.c;
import com.ss.android.downloadlib.addownload.w.f;
import com.ss.android.socialbase.downloader.depend.ck;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.ss.android.socialbase.downloader.network.gd;
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

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    public static volatile String f35829c;

    /* renamed from: f  reason: collision with root package name */
    private static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> f35830f;

    /* renamed from: r  reason: collision with root package name */
    private static final com.ss.android.download.api.download.c.c f35831r;
    private static Context ux;
    public static ITTDownloadVisitor xv;
    private static final AtomicBoolean sr = new AtomicBoolean(false);

    /* renamed from: w  reason: collision with root package name */
    public static boolean f35832w = true;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class ux implements IDownloadHttpService {
        public gd downloadWithConnection(int i4, String str, List<com.ss.android.socialbase.downloader.model.xv> list) throws IOException {
            final w.c c4 = com.bytedance.sdk.openadsdk.downloadnew.w.c(str, list);
            if (c4 != null) {
                return new gd() { // from class: com.bytedance.sdk.openadsdk.downloadnew.xv.ux.1
                    @Override // com.ss.android.socialbase.downloader.network.gd
                    public InputStream c() {
                        return c4.f35827c;
                    }

                    @Override // com.ss.android.socialbase.downloader.network.gd
                    public void sr() {
                        try {
                            c4.sr.disconnect();
                        } catch (Exception unused) {
                        }
                    }

                    public int w() {
                        return c4.xv;
                    }

                    public void xv() {
                    }

                    public String c(String str2) {
                        Map<String, String> map = c4.f35828w;
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
            f35829c = com.bytedance.sdk.openadsdk.api.plugin.w.c(getContext(), Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
        f35831r = new com.ss.android.download.api.download.c.c() { // from class: com.bytedance.sdk.openadsdk.downloadnew.xv.6
            @Override // com.ss.android.download.api.download.c.c
            public void c(DownloadModel downloadModel, DownloadController downloadController, DownloadEventConfig downloadEventConfig) {
                com.bytedance.sdk.openadsdk.api.xv.w("TTDownloadVisitor", "completeListener: onDownloadStart");
            }

            @Override // com.ss.android.download.api.download.c.c
            public void w(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.xv.w("TTDownloadVisitor", "completeListener: onInstalled");
                xv.xv(str);
            }

            @Override // com.ss.android.download.api.download.c.c
            public void c(DownloadInfo downloadInfo, String str) {
                com.bytedance.sdk.openadsdk.api.xv.w("TTDownloadVisitor", "completeListener: onDownloadFinished");
            }

            @Override // com.ss.android.download.api.download.c.c
            public void c(DownloadInfo downloadInfo, BaseException baseException, String str) {
                com.bytedance.sdk.openadsdk.api.xv.w("TTDownloadVisitor", "completeListener: onDownloadFailed");
            }

            @Override // com.ss.android.download.api.download.c.c
            public void c(DownloadInfo downloadInfo) {
                com.bytedance.sdk.openadsdk.api.xv.w("TTDownloadVisitor", "completeListener: onCanceled");
            }
        };
    }

    private static boolean f() {
        return false;
    }

    private static Context getContext() {
        Context context = ux;
        return context == null ? TTAppContextHolder.getContext() : context;
    }

    static /* synthetic */ ITTDownloadVisitor sr() {
        return ux();
    }

    private static ITTDownloadVisitor ux() {
        ITTDownloadVisitor iTTDownloadVisitor = xv;
        if (iTTDownloadVisitor == null) {
            TTAdManager adManager = TTAdSdk.getAdManager();
            if (adManager == null) {
                return null;
            }
            return (ITTDownloadVisitor) adManager.getExtra(ITTDownloadVisitor.class, com.bytedance.sdk.openadsdk.downloadnew.c.c(1));
        }
        return iTTDownloadVisitor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xv(String str) {
        com.ss.android.downloadad.api.c.w c4;
        JSONObject r3;
        if (TextUtils.isEmpty(str) || (c4 = f.c().c(str)) == null || (r3 = c4.r()) == null || ux() == null) {
            return;
        }
        ux().checkAutoControl(r3, str);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements r {
        private void xv(com.ss.android.download.api.model.xv xvVar) {
            if (xvVar == null) {
                return;
            }
            Object a4 = xvVar.a();
            TTDownloadEventModel label = TTDownloadEventModel.builder().setTag(xvVar.w()).setExtJson(xvVar.ev()).setMaterialMeta(a4 instanceof JSONObject ? (JSONObject) a4 : null).setLabel(xvVar.xv());
            boolean z3 = "download_notification".equals(xvVar.w()) || "landing_h5_download_ad_button".equals(xvVar.w());
            if (xv.sr() != null) {
                xv.sr().executeLogUpload(label, z3);
            }
        }

        @Override // com.ss.android.download.api.config.r
        public void c(com.ss.android.download.api.model.xv xvVar) {
            com.bytedance.sdk.openadsdk.api.xv.w("LibEventLogger", "onV3Event");
            c(xvVar, true);
        }

        @Override // com.ss.android.download.api.config.r
        public void w(com.ss.android.download.api.model.xv xvVar) {
            com.bytedance.sdk.openadsdk.api.xv.w("LibEventLogger", "onEvent called");
            c(xvVar, false);
            xv(xvVar);
        }

        private void c(com.ss.android.download.api.model.xv xvVar, boolean z3) {
            TTDownloadEventLogger tTDownloadEventLogger;
            if (xv.sr() == null || (tTDownloadEventLogger = xv.sr().getTTDownloadEventLogger()) == null || xvVar == null) {
                return;
            }
            if (tTDownloadEventLogger.shouldFilterOpenSdkLog() && xv.sr().isOpenSdkEvent(xvVar.toString())) {
                return;
            }
            if (z3) {
                tTDownloadEventLogger.onV3Event(xv.w(xvVar));
            } else {
                tTDownloadEventLogger.onEvent(xv.w(xvVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.downloadnew.xv$xv  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class C0527xv implements com.ss.android.download.api.config.gd {
        @Override // com.ss.android.download.api.config.gd
        public void c(Activity activity, int i4, String[] strArr, int[] iArr) {
        }

        @Override // com.ss.android.download.api.config.gd
        public void c(Activity activity, String[] strArr, final u uVar) {
            if (xv.sr() != null) {
                xv.sr().requestPermission(activity, strArr, new ITTPermissionCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.xv.xv.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onDenied(String str) {
                        u uVar2 = uVar;
                        if (uVar2 != null) {
                            uVar2.c(str);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback
                    public void onGranted() {
                        u uVar2 = uVar;
                        if (uVar2 != null) {
                            uVar2.c();
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.gd
        public boolean c(Context context, String str) {
            if (xv.sr() != null) {
                return xv.sr().hasPermission(context, str);
            }
            return false;
        }
    }

    public static void c(Context context) {
        if (context == null) {
            context = TTAppContextHolder.getContext();
        }
        if (context == null) {
            return;
        }
        AtomicBoolean atomicBoolean = sr;
        if (atomicBoolean.get()) {
            return;
        }
        synchronized (xv.class) {
            if (!atomicBoolean.get()) {
                ux = StubApp.getOrigApplicationContext(context.getApplicationContext());
                if (ux() != null) {
                    String initPath = ux().initPath(f35832w);
                    if (!TextUtils.isEmpty(initPath)) {
                        f35829c = initPath;
                    }
                }
                atomicBoolean.set(w(ux));
            }
        }
    }

    public static void w() {
        c().r();
        if (ux() != null) {
            ux().clearAllData(f35829c);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class sr implements com.ss.android.download.api.config.a {

        /* renamed from: c  reason: collision with root package name */
        private final WeakReference<Context> f35834c;

        public sr(Context context) {
            this.f35834c = new WeakReference<>(context);
        }

        private DialogBuilder xv(final com.ss.android.download.api.model.w wVar) {
            return DialogBuilder.builder().setTitle(wVar.f48260w).setMessage(wVar.xv).setNegativeBtnText(wVar.ux).setPositiveBtnText(wVar.sr).setIcon(wVar.f48259r).setDialogStatusChangedListener(new IDialogStatusChangedListener() { // from class: com.bytedance.sdk.openadsdk.downloadnew.xv.sr.1
                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onCancel(DialogInterface dialogInterface) {
                    w.InterfaceC0938w interfaceC0938w = wVar.ev;
                    if (interfaceC0938w != null) {
                        interfaceC0938w.xv(dialogInterface);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onNegativeBtnClick(DialogInterface dialogInterface) {
                    w.InterfaceC0938w interfaceC0938w = wVar.ev;
                    if (interfaceC0938w != null) {
                        try {
                            interfaceC0938w.w(dialogInterface);
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.IDialogStatusChangedListener
                public void onPositiveBtnClick(DialogInterface dialogInterface) {
                    w.InterfaceC0938w interfaceC0938w = wVar.ev;
                    if (interfaceC0938w != null) {
                        interfaceC0938w.c(dialogInterface);
                    }
                }
            });
        }

        @Override // com.ss.android.download.api.config.a
        public void c(int i4, Context context, DownloadModel downloadModel, String str, Drawable drawable, int i5) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                Toast.makeText(context, str, 0).show();
            } catch (Exception e4) {
                com.ss.android.socialbase.downloader.xv.c.ux("LibUIFactory", "showToastWithDuration e " + e4.getMessage());
            }
        }

        @Override // com.ss.android.download.api.config.a
        /* renamed from: c */
        public AlertDialog w(com.ss.android.download.api.model.w wVar) {
            if (wVar != null && xv.sr() != null) {
                Context context = wVar.f48256c;
                if (context != null && (context instanceof Activity)) {
                    return xv.sr().showDialogBySelf((Activity) wVar.f48256c, wVar.f48258p == 1, xv(wVar));
                }
                xv.sr().showDialogByDelegate(this.f35834c, wVar.f48258p == 1, xv(wVar));
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class w implements ev {
        private w() {
        }

        @Override // com.ss.android.download.api.config.ev
        public void c(String str, String str2, Map<String, Object> map, final com.ss.android.download.api.config.s sVar) {
            str.hashCode();
            int i4 = 0;
            if (!str.equals("GET") && str.equals("POST")) {
                i4 = 1;
            }
            if (xv.sr() != null) {
                xv.sr().execute(i4, str2, map, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.xv.w.1
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        com.ss.android.download.api.config.s sVar2 = sVar;
                        if (sVar2 != null) {
                            sVar2.c(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        com.ss.android.download.api.config.s sVar2 = sVar;
                        if (sVar2 != null) {
                            sVar2.c(str3);
                        }
                    }
                });
            }
        }

        @Override // com.ss.android.download.api.config.ev
        public void c(String str, byte[] bArr, String str2, int i4, final com.ss.android.download.api.config.s sVar) {
            if (xv.sr() != null) {
                xv.sr().postBody(str, bArr, str2, new ITTHttpCallback() { // from class: com.bytedance.sdk.openadsdk.downloadnew.xv.w.2
                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onError(Throwable th) {
                        com.ss.android.download.api.config.s sVar2 = sVar;
                        if (sVar2 != null) {
                            sVar2.c(th);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback
                    public void onResponse(String str3) {
                        com.ss.android.download.api.config.s sVar2 = sVar;
                        if (sVar2 != null) {
                            sVar2.c(str3);
                        }
                    }
                });
            }
        }
    }

    private static boolean w(Context context) {
        com.ss.android.download.api.c c4;
        if (context == null) {
            return false;
        }
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        String packageName = origApplicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        if (f()) {
            try {
                c4 = com.ss.android.downloadlib.ev.c(origApplicationContext).c("pangolin");
            } catch (Throwable unused) {
                c4 = com.ss.android.downloadlib.ev.c(origApplicationContext).c();
            }
        } else {
            c4 = com.ss.android.downloadlib.ev.c(origApplicationContext).c();
        }
        if (c4 == null) {
            return false;
        }
        com.ss.android.download.api.c c5 = c4.c(new C0527xv()).c(new c()).c(new sr(origApplicationContext)).c(new w()).c(new p() { // from class: com.bytedance.sdk.openadsdk.downloadnew.xv.3
            @Override // com.ss.android.download.api.config.p
            public JSONObject c() {
                if (xv.sr() != null) {
                    return xv.sr().getDownloadSettings();
                }
                return new JSONObject();
            }
        }).c(new com.ss.android.download.api.config.w() { // from class: com.bytedance.sdk.openadsdk.downloadnew.xv.2
            @Override // com.ss.android.download.api.config.w
            public boolean c() {
                if (xv.sr() != null) {
                    return xv.sr().getAppIsBackground();
                }
                return false;
            }
        }).c(new c.C0936c().w("143").c("open_news").xv("6.1.0.6").sr(String.valueOf(6106)).c()).c(new ia() { // from class: com.bytedance.sdk.openadsdk.downloadnew.xv.1
            @Override // com.ss.android.download.api.config.ia
            public byte[] c(byte[] bArr, int i4) {
                return new byte[0];
            }
        });
        c5.c(packageName + ".TTFileProvider").c(c(origApplicationContext, ux() != null ? ux().getDownloadSettings() : new JSONObject())).c();
        com.ss.android.downloadlib.r.c.c();
        com.ss.android.downloadlib.ev.c(origApplicationContext).sr().c(1);
        com.ss.android.downloadlib.ev.c(origApplicationContext).c(f35831r);
        com.ss.android.socialbase.appdownloader.sr.p().c(new y() { // from class: com.bytedance.sdk.openadsdk.downloadnew.xv.4
            public boolean c(Intent intent) {
                return false;
            }
        });
        TTDownloadEventLogger tTDownloadEventLogger = ux() != null ? ux().getTTDownloadEventLogger() : null;
        if (tTDownloadEventLogger != null) {
            tTDownloadEventLogger.onDownloadConfigReady();
        }
        return true;
    }

    public static Map<Integer, ITTDownloadAdapter.OnEventLogHandler> xv() {
        return f35830f;
    }

    public static void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f35829c = str;
    }

    public static com.ss.android.downloadlib.ev c() {
        c(getContext());
        return com.ss.android.downloadlib.ev.c(getContext());
    }

    public static boolean c(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return c().ux().c(context, uri, downloadModel, downloadEventConfig, downloadController, iDownloadButtonClickListener);
    }

    public static boolean c(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        return c().ux().c(context, uri, downloadModel, downloadEventConfig, downloadController);
    }

    public static boolean c(Uri uri) {
        return com.ss.android.downloadlib.w.p.c(uri);
    }

    public static void c(int i4) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> map = f35830f;
        if (map != null) {
            map.remove(Integer.valueOf(i4));
        }
    }

    public static void c(int i4, ITTDownloadAdapter.OnEventLogHandler onEventLogHandler) {
        if (onEventLogHandler != null) {
            if (f35830f == null) {
                f35830f = Collections.synchronizedMap(new WeakHashMap());
            }
            f35830f.put(Integer.valueOf(i4), onEventLogHandler);
        }
    }

    public static boolean c(String str, String str2, JSONObject jSONObject, Object obj) {
        Map<Integer, ITTDownloadAdapter.OnEventLogHandler> xv2;
        boolean z3 = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && jSONObject != null && (xv2 = xv()) != null) {
            for (Map.Entry<Integer, ITTDownloadAdapter.OnEventLogHandler> entry : xv2.entrySet()) {
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

    private static DownloaderBuilder c(Context context, JSONObject jSONObject) {
        return new DownloaderBuilder(context).downloadSetting(new ck() { // from class: com.bytedance.sdk.openadsdk.downloadnew.xv.5
            @Override // com.ss.android.socialbase.downloader.depend.ck
            public JSONObject c() {
                if (xv.sr() != null) {
                    return xv.sr().getDownloadSettings();
                }
                return new JSONObject();
            }
        }).downloadExpSwitch(jSONObject.optInt("download_exp_switch_temp", 1040187391)).httpService(new ux());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject w(com.ss.android.download.api.model.xv xvVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("category", xvVar.c());
            jSONObject.put("tag", xvVar.w());
            jSONObject.put("label", xvVar.xv());
            jSONObject.put("isAd", xvVar.sr());
            jSONObject.put("adId", xvVar.ux());
            jSONObject.put("logExtra", xvVar.f());
            jSONObject.put("extValue", xvVar.r());
            jSONObject.put("extJson", xvVar.ev());
            jSONObject.put("paramsJson", xvVar.gd());
            jSONObject.put("eventSource", xvVar.k());
            jSONObject.put("extraObject", xvVar.a());
            jSONObject.put("clickTrackUrl", xvVar.p());
            jSONObject.put("isV3", xvVar.bk());
            jSONObject.put("V3EventName", xvVar.t());
            jSONObject.put("V3EventParams", xvVar.ys());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject;
    }

    public static boolean c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<DownloadInfo> w3 = com.ss.android.socialbase.appdownloader.sr.p().w(context);
            if (!w3.isEmpty()) {
                for (DownloadInfo downloadInfo : w3) {
                    if (downloadInfo != null && str.equals(downloadInfo.getUrl())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean c(Activity activity, final ExitInstallListener exitInstallListener) {
        return com.ss.android.downloadlib.addownload.c.c.c().c(activity, false, new c.InterfaceC0941c() { // from class: com.bytedance.sdk.openadsdk.downloadnew.xv.7
            @Override // com.ss.android.downloadlib.addownload.c.c.InterfaceC0941c
            public void c() {
                ExitInstallListener exitInstallListener2 = ExitInstallListener.this;
                if (exitInstallListener2 != null) {
                    exitInstallListener2.onExitInstall();
                }
            }
        });
    }
}
