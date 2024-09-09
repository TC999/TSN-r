package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.c.c;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.ev.ev;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static final String f49247c = "w";

    /* renamed from: w  reason: collision with root package name */
    private static xv f49248w;
    private static c xv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c implements c.InterfaceC0974c {

        /* renamed from: c  reason: collision with root package name */
        private final ux f49250c;

        /* renamed from: w  reason: collision with root package name */
        private final int f49251w;
        private JSONObject xv;

        public c(Context context, Intent intent, int i4, JSONObject jSONObject, InterfaceC0970w interfaceC0970w) {
            this.xv = jSONObject;
            int optInt = jSONObject.optInt("query_interval", 1000);
            this.f49251w = optInt;
            this.f49250c = new ux(context, intent, i4, interfaceC0970w, optInt);
        }

        @Override // com.ss.android.socialbase.downloader.c.c.InterfaceC0974c
        public void w() {
            if (!this.f49250c.gd) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                this.f49250c.f49256f.sendMessage(obtain);
            }
            com.ss.android.socialbase.downloader.c.c.c().w(this);
            c unused = w.xv = null;
        }

        @Override // com.ss.android.socialbase.downloader.c.c.InterfaceC0974c
        public void xv() {
            int optInt = this.xv.optInt("time_out_second", 20);
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.f49250c.f49256f.sendMessage(obtain);
            if (optInt <= 0 || optInt >= 60) {
                return;
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            this.f49250c.f49256f.sendMessageDelayed(obtain2, optInt * 1000);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static class sr implements Callable<Boolean> {

        /* renamed from: c  reason: collision with root package name */
        private final Context f49252c;
        private final long sr;

        /* renamed from: w  reason: collision with root package name */
        private final InterfaceC0970w f49253w;
        private final Handler xv;

        public sr(Handler handler, Context context, InterfaceC0970w interfaceC0970w, long j4) {
            this.f49252c = context;
            this.f49253w = interfaceC0970w;
            this.xv = handler;
            this.sr = j4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            InterfaceC0970w interfaceC0970w;
            try {
                interfaceC0970w = this.f49253w;
            } catch (Throwable unused) {
            }
            if (interfaceC0970w != null) {
                long j4 = this.sr;
                if (j4 > 0 && j4 <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    Context context = this.f49252c;
                    boolean c4 = context != null ? interfaceC0970w.c(context) : false;
                    Message obtain = Message.obtain();
                    if (c4) {
                        obtain.what = 2;
                        this.xv.sendMessage(obtain);
                    } else {
                        obtain.what = 1;
                        this.xv.sendMessageDelayed(obtain, this.sr);
                    }
                    return Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class ux implements ev.c {

        /* renamed from: c  reason: collision with root package name */
        public static int f49254c;

        /* renamed from: w  reason: collision with root package name */
        private static int f49255w;
        private Future<Boolean> ev;

        /* renamed from: f  reason: collision with root package name */
        private final Handler f49256f;
        private boolean gd = false;

        /* renamed from: r  reason: collision with root package name */
        private final long f49257r;
        private final Intent sr;
        private final InterfaceC0970w ux;
        private final Context xv;

        public ux(Context context, Intent intent, int i4, InterfaceC0970w interfaceC0970w, long j4) {
            this.xv = context;
            this.sr = intent;
            f49255w = i4;
            this.ux = interfaceC0970w;
            this.f49256f = new com.ss.android.socialbase.downloader.ev.ev(Looper.getMainLooper(), this);
            this.f49257r = j4;
        }

        @Override // com.ss.android.socialbase.downloader.ev.ev.c
        public void c(Message message) {
            if (message != null) {
                int i4 = message.what;
                if (i4 == 1) {
                    long j4 = this.f49257r;
                    if (j4 <= 0 || j4 > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                        return;
                    }
                    f49254c = 1;
                    this.ev = com.ss.android.socialbase.downloader.downloader.xv.a().submit(new sr(this.f49256f, this.xv, this.ux, this.f49257r));
                } else if (i4 == 2) {
                    f49254c = 2;
                    this.f49256f.removeMessages(2);
                    this.f49256f.removeMessages(1);
                    Future<Boolean> future = this.ev;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.gd && (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.c.c.c().w())) {
                        Intent intent = this.sr;
                        if (intent != null) {
                            w.w(this.xv, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.xv).getDownloadInfo(f49255w);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.ss.android.socialbase.appdownloader.xv.w(this.xv, f49255w, false);
                            }
                        }
                        this.gd = true;
                    }
                    w.w(f49255w, this.sr == null, w.c(this.xv));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.socialbase.appdownloader.w$w  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface InterfaceC0970w {
        boolean c(@NonNull Context context);
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface xv {
        void c(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.c cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean sr(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 26)
    public static boolean ux(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    private static void sr(int i4, JSONObject jSONObject) {
        int i5 = 1;
        boolean z3 = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z3) {
            i5 = 2;
        }
        try {
            jSONObject2.put("scene", i5);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.xv.up().w(i4, "guide_auth_dialog_show", jSONObject2);
    }

    private static boolean w(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.c cVar) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            cVar.sr = "custom";
            com.ss.android.socialbase.appdownloader.c.c c4 = com.ss.android.socialbase.appdownloader.c.sr.c(context, "custom", jSONObject, downloadInfo);
            if (c4 != null && c4.c()) {
                Intent w3 = c4.w();
                if (w3 == null) {
                    return false;
                }
                if (c(new File(savePath), downloadInfo, jSONObject)) {
                    if (w(context, w3)) {
                        cVar.f49036w = 0;
                        return true;
                    }
                    cVar.f49036w = 1;
                } else {
                    cVar.f49036w = 6;
                }
                return false;
            }
            cVar.f49036w = 3;
        }
        return false;
    }

    public static void xv(int i4, JSONObject jSONObject) {
        int i5 = 1;
        boolean z3 = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z3) {
            i5 = 2;
        }
        try {
            jSONObject2.put("scene", i5);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.xv.up().w(i4, "guide_auth_open_setting", jSONObject2);
    }

    public static boolean c(Context context, DownloadInfo downloadInfo, Intent intent, boolean z3) {
        JSONArray ux2 = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).ux("ah_plans");
        if (ux2 != null) {
            int length = ux2.length();
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject optJSONObject = ux2.optJSONObject(i4);
                if (com.ss.android.socialbase.appdownloader.f.c.c(optJSONObject) && c(context, downloadInfo, intent, optJSONObject, z3)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean c(android.content.Context r11, com.ss.android.socialbase.downloader.model.DownloadInfo r12, android.content.Intent r13, org.json.JSONObject r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.w.c(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, android.content.Intent, org.json.JSONObject, boolean):boolean");
    }

    public static com.ss.android.socialbase.appdownloader.c w(JSONObject jSONObject, com.ss.android.socialbase.downloader.r.c cVar) {
        com.ss.android.socialbase.appdownloader.c cVar2 = new com.ss.android.socialbase.appdownloader.c();
        if (jSONObject == null) {
            return cVar2;
        }
        cVar2.f49035c = jSONObject.optString("type");
        cVar2.ux = "vbi";
        if (com.ss.android.socialbase.appdownloader.c.sr.c(com.ss.android.socialbase.downloader.downloader.xv.gw(), "vbi", jSONObject, cVar)) {
            cVar2.f49036w = 0;
        } else {
            c(cVar2, 3);
        }
        return cVar2;
    }

    public static void w(int i4, JSONObject jSONObject) {
        int i5 = 1;
        boolean z3 = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z3) {
            i5 = 2;
        }
        try {
            jSONObject2.put("scene", i5);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.xv.up().w(i4, "guide_auth_dialog_cancel", jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(int i4, boolean z3, boolean z4) {
        JSONObject jSONObject = new JSONObject();
        int i5 = 1;
        try {
            jSONObject.put("scene", z3 ? 1 : 2);
            if (!z4) {
                i5 = 2;
            }
            jSONObject.put("result_code", i5);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.xv.up().w(i4, "guide_auth_result", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean w(Context context, Intent intent) {
        return c(context, intent, true);
    }

    private static boolean c(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.c cVar, com.ss.android.socialbase.downloader.r.c cVar2) {
        boolean z3;
        String optString = jSONObject.optString("type");
        cVar.f49035c = optString;
        Intent w3 = com.ss.android.socialbase.appdownloader.c.sr.c(context, "vbi", jSONObject, downloadInfo).w();
        StringBuilder sb = new StringBuilder();
        try {
            z3 = w(context, w3);
        } catch (Throwable th) {
            sb.append(optString);
            sb.append(" startActivity failed : ");
            sb.append(c(th));
            c(cVar, 1);
            z3 = false;
        }
        if (!z3) {
            cVar.xv = sb.toString();
        } else {
            cVar.f49036w = 0;
        }
        return true;
    }

    private static boolean c(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.c cVar) {
        boolean z3;
        if (context != null && jSONObject != null) {
            String optString = jSONObject.optString("device_plans");
            cVar.ux = optString;
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(",");
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                File file = new File(savePath);
                StringBuilder sb = new StringBuilder();
                String str = null;
                int length = split.length;
                int i4 = 0;
                while (true) {
                    z3 = true;
                    if (i4 >= length) {
                        z3 = false;
                        break;
                    }
                    String str2 = split[i4];
                    com.ss.android.socialbase.appdownloader.c.c c4 = com.ss.android.socialbase.appdownloader.c.sr.c(context, str2, jSONObject, downloadInfo);
                    if (c4 != null) {
                        Intent w3 = c4.w();
                        if (w3 != null) {
                            if (c(file, downloadInfo, jSONObject)) {
                                try {
                                    c(context, w3, false);
                                    str = str2;
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str2);
                                    sb.append(" startActivity failed : ");
                                    sb.append(c(th));
                                    c(cVar, 1);
                                }
                            } else {
                                c(cVar, 6);
                                sb.append(str2);
                                sb.append(" createDescFile failed! ");
                            }
                        } else {
                            c(cVar, 3);
                            sb.append(str2);
                            sb.append(" resolveActivity failed! ");
                        }
                    }
                    sb.append("  ");
                    i4++;
                }
                if (!z3) {
                    cVar.xv = sb.toString();
                } else {
                    cVar.sr = str;
                    cVar.f49036w = 0;
                }
                return z3;
            }
        }
        return false;
    }

    public static int c(@NonNull com.ss.android.socialbase.downloader.r.c cVar) {
        JSONObject sr2 = cVar.sr("download_dir");
        if (sr2 != null ? !TextUtils.isEmpty(sr2.optString("dir_name")) : false) {
            if (com.ss.android.socialbase.downloader.r.c.xv().c("get_download_info_by_list")) {
                JSONArray ux2 = cVar.ux("ah_plans");
                int i4 = -1;
                if (ux2 != null) {
                    int length = ux2.length();
                    for (int i5 = 0; i5 < length; i5++) {
                        JSONObject optJSONObject = ux2.optJSONObject(i5);
                        if (com.ss.android.socialbase.appdownloader.f.c.c(optJSONObject)) {
                            String optString = optJSONObject.optString("type");
                            if (!"plan_a".equals(optString) && !"plan_b".equals(optString) && !"plan_e".equals(optString) && !"plan_f".equals(optString)) {
                                if ("plan_d".equalsIgnoreCase(optString) || "plan_h".equalsIgnoreCase(optString) || ("plan_g".equalsIgnoreCase(optString) && (i4 = w(optJSONObject, cVar).f49036w) == 0)) {
                                    return 0;
                                }
                            } else {
                                i4 = c(optJSONObject, cVar).f49036w;
                                if (i4 == 0) {
                                    return 0;
                                }
                            }
                        }
                    }
                }
                return i4;
            }
            return 4;
        }
        return 5;
    }

    @NonNull
    public static com.ss.android.socialbase.appdownloader.c c(JSONObject jSONObject, com.ss.android.socialbase.downloader.r.c cVar) {
        com.ss.android.socialbase.appdownloader.c cVar2 = new com.ss.android.socialbase.appdownloader.c();
        if (jSONObject == null) {
            return cVar2;
        }
        String optString = jSONObject.optString("type");
        cVar2.f49035c = optString;
        if ("plan_b".equals(optString)) {
            cVar2.ux = "custom";
            if (com.ss.android.socialbase.appdownloader.c.sr.c(com.ss.android.socialbase.downloader.downloader.xv.gw(), "custom", jSONObject, cVar)) {
                cVar2.f49036w = 0;
                return cVar2;
            }
            c(cVar2, 3);
        } else {
            String optString2 = jSONObject.optString("device_plans");
            cVar2.ux = optString2;
            if (!TextUtils.isEmpty(optString2)) {
                for (String str : optString2.split(",")) {
                    if (com.ss.android.socialbase.appdownloader.c.sr.c(com.ss.android.socialbase.downloader.downloader.xv.gw(), str, jSONObject, cVar)) {
                        cVar2.f49036w = 0;
                        return cVar2;
                    }
                    c(cVar2, 3);
                }
            }
        }
        return cVar2;
    }

    public static com.ss.android.socialbase.appdownloader.c c(JSONObject jSONObject, String str, Context context, com.ss.android.socialbase.downloader.r.c cVar) {
        com.ss.android.socialbase.appdownloader.c cVar2 = new com.ss.android.socialbase.appdownloader.c();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.f.ux.xv()) {
            cVar2.f49035c = jSONObject.optString("type");
            if (cVar.c("bi", 0) == 1) {
                cVar2.f49036w = 0;
                return cVar2;
            } else if (c(context)) {
                cVar2.f49036w = 2;
            } else if (com.ss.android.socialbase.appdownloader.f.c.c(str) != null) {
                cVar2.f49036w = 0;
            } else {
                cVar2.f49036w = 9;
            }
        }
        return cVar2;
    }

    private static void c(com.ss.android.socialbase.appdownloader.c cVar, int i4) {
        int i5 = cVar.f49036w;
        if (i5 != -1) {
            cVar.f49036w = (i5 * 10) + i4;
        } else {
            cVar.f49036w = i4;
        }
    }

    private static boolean c(File file, DownloadInfo downloadInfo, @NonNull JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject sr2 = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).sr("download_dir");
        File file2 = null;
        String optString = sr2 != null ? sr2.optString("ins_desc") : null;
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString)) {
            file2 = new File(path + File.separator + optString);
        }
        if (file2 != null) {
            try {
                if (file2.createNewFile()) {
                    file2.deleteOnExit();
                    return true;
                }
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(Context context, @Nullable Intent intent, JSONObject jSONObject, int i4, @Nullable com.ss.android.socialbase.appdownloader.c cVar) {
        if (context != null && jSONObject != null) {
            long optLong = jSONObject.optLong("jump_interval", 0L);
            if (optLong <= 0) {
                return false;
            }
            SharedPreferences w3 = com.bytedance.sdk.openadsdk.api.plugin.w.w(context, "sp_ah_config", 0);
            if ((System.currentTimeMillis() - w3.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= optLong && !c(context)) {
                w3.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                    Intent intent2 = new Intent(context, JumpUnknownSourceActivity.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("id", i4);
                    try {
                        if (c(context, intent2, false)) {
                            sr(i4, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (cVar != null) {
                            cVar.f49036w = 1;
                            cVar.xv = "tryShowUnknownSourceDialog" + c(th);
                        }
                        return false;
                    }
                }
                if (c(context, intent, i4, jSONObject)) {
                    xv(i4, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean c(Context context, @Nullable Intent intent, int i4, JSONObject jSONObject) {
        try {
            if (com.ss.android.socialbase.appdownloader.f.ux.xv() && Build.VERSION.SDK_INT < 26 && !sr(context)) {
                com.ss.android.socialbase.appdownloader.c.f fVar = new com.ss.android.socialbase.appdownloader.c.f(context);
                if (fVar.c()) {
                    c(context, intent, i4, jSONObject, new InterfaceC0970w() { // from class: com.ss.android.socialbase.appdownloader.w.1
                        @Override // com.ss.android.socialbase.appdownloader.w.InterfaceC0970w
                        public boolean c(@NonNull Context context2) {
                            return w.sr(context2);
                        }
                    });
                    return w(context, fVar.w());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !ux(context)) {
                com.ss.android.socialbase.appdownloader.c.w wVar = new com.ss.android.socialbase.appdownloader.c.w(context);
                if (wVar.c()) {
                    c(context, intent, i4, jSONObject, new InterfaceC0970w() { // from class: com.ss.android.socialbase.appdownloader.w.2
                        @Override // com.ss.android.socialbase.appdownloader.w.InterfaceC0970w
                        public boolean c(@NonNull Context context2) {
                            return w.ux(context2);
                        }
                    });
                    return w(context, wVar.w());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean c(Context context) {
        if (context == null) {
            return true;
        }
        if (com.ss.android.socialbase.appdownloader.f.ux.xv() && Build.VERSION.SDK_INT < 26) {
            return sr(context);
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return ux(context);
        }
        return true;
    }

    public static boolean c() {
        return ux.f49254c == 1;
    }

    public static void c(int i4, JSONObject jSONObject) {
        int i5 = 1;
        boolean z3 = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z3) {
            i5 = 2;
        }
        try {
            jSONObject2.put("scene", i5);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        com.ss.android.socialbase.downloader.downloader.xv.up().w(i4, "guide_auth_dialog_confirm", jSONObject2);
    }

    private static void c(Context context, Intent intent, int i4, JSONObject jSONObject, InterfaceC0970w interfaceC0970w) {
        if (xv != null) {
            com.ss.android.socialbase.downloader.c.c.c().w(xv);
            xv = null;
        }
        xv = new c(context, intent, i4, jSONObject, interfaceC0970w);
        com.ss.android.socialbase.downloader.c.c.c().c(xv);
    }

    public static boolean c(Context context, Intent intent, boolean z3) {
        if (context == null || intent == null) {
            return false;
        }
        if (z3) {
            try {
                intent.putExtra("start_only_for_android", true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra("start_only_for_android", true);
        context.startActivity(intent);
        return true;
    }

    public static String c(Throwable th) {
        String th2 = th.toString();
        return th2.length() > 800 ? th2.substring(0, 500) : th2;
    }

    public static void c(xv xvVar) {
        f49248w = xvVar;
    }
}
