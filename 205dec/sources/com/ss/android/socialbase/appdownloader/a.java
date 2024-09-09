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
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.ok.ok;
import com.ss.android.socialbase.downloader.p.p;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static bl f49020a = null;
    private static ok bl = null;
    private static final String ok = "a";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.socialbase.appdownloader.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface InterfaceC0965a {
        boolean ok(@NonNull Context context);
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface bl {
        void ok(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.ok okVar);
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class n implements p.ok {

        /* renamed from: a  reason: collision with root package name */
        private static int f49021a;
        public static int ok;
        private final Context bl;

        /* renamed from: h  reason: collision with root package name */
        private final long f49022h;
        private final Handler kf;

        /* renamed from: n  reason: collision with root package name */
        private final InterfaceC0965a f49023n;

        /* renamed from: p  reason: collision with root package name */
        private Future<Boolean> f49024p;

        /* renamed from: q  reason: collision with root package name */
        private boolean f49025q = false;

        /* renamed from: s  reason: collision with root package name */
        private final Intent f49026s;

        public n(Context context, Intent intent, int i4, InterfaceC0965a interfaceC0965a, long j4) {
            this.bl = context;
            this.f49026s = intent;
            f49021a = i4;
            this.f49023n = interfaceC0965a;
            this.kf = new com.ss.android.socialbase.downloader.p.p(Looper.getMainLooper(), this);
            this.f49022h = j4;
        }

        @Override // com.ss.android.socialbase.downloader.p.p.ok
        public void ok(Message message) {
            if (message != null) {
                int i4 = message.what;
                if (i4 == 1) {
                    long j4 = this.f49022h;
                    if (j4 <= 0 || j4 > ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                        return;
                    }
                    ok = 1;
                    this.f49024p = com.ss.android.socialbase.downloader.downloader.bl.j().submit(new s(this.kf, this.bl, this.f49023n, this.f49022h));
                } else if (i4 == 2) {
                    ok = 2;
                    this.kf.removeMessages(2);
                    this.kf.removeMessages(1);
                    Future<Boolean> future = this.f49024p;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.f49025q && (Build.VERSION.SDK_INT < 29 || com.ss.android.socialbase.downloader.ok.ok.ok().a())) {
                        Intent intent = this.f49026s;
                        if (intent != null) {
                            a.a(this.bl, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.bl).getDownloadInfo(f49021a);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.ss.android.socialbase.appdownloader.bl.a(this.bl, f49021a, false);
                            }
                        }
                        this.f49025q = true;
                    }
                    a.a(f49021a, this.f49026s == null, a.ok(this.bl));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok implements ok.InterfaceC1022ok {

        /* renamed from: a  reason: collision with root package name */
        private final int f49027a;
        private JSONObject bl;
        private final n ok;

        public ok(Context context, Intent intent, int i4, JSONObject jSONObject, InterfaceC0965a interfaceC0965a) {
            this.bl = jSONObject;
            int optInt = jSONObject.optInt("query_interval", 1000);
            this.f49027a = optInt;
            this.ok = new n(context, intent, i4, interfaceC0965a, optInt);
        }

        @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC1022ok
        public void a() {
            if (!this.ok.f49025q) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                this.ok.kf.sendMessage(obtain);
            }
            com.ss.android.socialbase.downloader.ok.ok.ok().a(this);
            ok unused = a.bl = null;
        }

        @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC1022ok
        public void bl() {
            int optInt = this.bl.optInt("time_out_second", 20);
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.ok.kf.sendMessage(obtain);
            if (optInt <= 0 || optInt >= 60) {
                return;
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            this.ok.kf.sendMessageDelayed(obtain2, optInt * 1000);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class s implements Callable<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        private final InterfaceC0965a f49028a;
        private final Handler bl;
        private final Context ok;

        /* renamed from: s  reason: collision with root package name */
        private final long f49029s;

        public s(Handler handler, Context context, InterfaceC0965a interfaceC0965a, long j4) {
            this.ok = context;
            this.f49028a = interfaceC0965a;
            this.bl = handler;
            this.f49029s = j4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            InterfaceC0965a interfaceC0965a;
            try {
                interfaceC0965a = this.f49028a;
            } catch (Throwable unused) {
            }
            if (interfaceC0965a != null) {
                long j4 = this.f49029s;
                if (j4 > 0 && j4 <= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                    Context context = this.ok;
                    boolean ok = context != null ? interfaceC0965a.ok(context) : false;
                    Message obtain = Message.obtain();
                    if (ok) {
                        obtain.what = 2;
                        this.bl.sendMessage(obtain);
                    } else {
                        obtain.what = 1;
                        this.bl.sendMessageDelayed(obtain, this.f49029s);
                    }
                    return Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 26)
    public static boolean n(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean s(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean a(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.ok okVar) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            okVar.f49161s = "custom";
            com.ss.android.socialbase.appdownloader.ok.ok ok2 = com.ss.android.socialbase.appdownloader.ok.s.ok(context, "custom", jSONObject, downloadInfo);
            if (ok2 != null && ok2.ok()) {
                Intent a4 = ok2.a();
                if (a4 == null) {
                    return false;
                }
                if (ok(new File(savePath), downloadInfo, jSONObject)) {
                    if (a(context, a4)) {
                        okVar.f49159a = 0;
                        return true;
                    }
                    okVar.f49159a = 1;
                } else {
                    okVar.f49159a = 6;
                }
                return false;
            }
            okVar.f49159a = 3;
        }
        return false;
    }

    public static void bl(int i4, JSONObject jSONObject) {
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
        com.ss.android.socialbase.downloader.downloader.bl.vk().a(i4, "guide_auth_open_setting", jSONObject2);
    }

    private static void s(int i4, JSONObject jSONObject) {
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
        com.ss.android.socialbase.downloader.downloader.bl.vk().a(i4, "guide_auth_dialog_show", jSONObject2);
    }

    public static boolean ok(Context context, DownloadInfo downloadInfo, Intent intent, boolean z3) {
        JSONArray n4 = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).n("ah_plans");
        if (n4 != null) {
            int length = n4.length();
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject optJSONObject = n4.optJSONObject(i4);
                if (com.ss.android.socialbase.appdownloader.kf.ok.ok(optJSONObject) && ok(context, downloadInfo, intent, optJSONObject, z3)) {
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
    private static boolean ok(android.content.Context r11, com.ss.android.socialbase.downloader.model.DownloadInfo r12, android.content.Intent r13, org.json.JSONObject r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.a.ok(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, android.content.Intent, org.json.JSONObject, boolean):boolean");
    }

    public static com.ss.android.socialbase.appdownloader.ok a(JSONObject jSONObject, com.ss.android.socialbase.downloader.h.ok okVar) {
        com.ss.android.socialbase.appdownloader.ok okVar2 = new com.ss.android.socialbase.appdownloader.ok();
        if (jSONObject == null) {
            return okVar2;
        }
        okVar2.ok = jSONObject.optString("type");
        okVar2.f49160n = "vbi";
        if (com.ss.android.socialbase.appdownloader.ok.s.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), "vbi", jSONObject, okVar)) {
            okVar2.f49159a = 0;
        } else {
            ok(okVar2, 3);
        }
        return okVar2;
    }

    public static void a(int i4, JSONObject jSONObject) {
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
        com.ss.android.socialbase.downloader.downloader.bl.vk().a(i4, "guide_auth_dialog_cancel", jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i4, boolean z3, boolean z4) {
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
        com.ss.android.socialbase.downloader.downloader.bl.vk().a(i4, "guide_auth_result", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Context context, Intent intent) {
        return ok(context, intent, true);
    }

    private static boolean ok(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.ok okVar, com.ss.android.socialbase.downloader.h.ok okVar2) {
        boolean z3;
        String optString = jSONObject.optString("type");
        okVar.ok = optString;
        Intent a4 = com.ss.android.socialbase.appdownloader.ok.s.ok(context, "vbi", jSONObject, downloadInfo).a();
        StringBuilder sb = new StringBuilder();
        try {
            z3 = a(context, a4);
        } catch (Throwable th) {
            sb.append(optString);
            sb.append(" startActivity failed : ");
            sb.append(ok(th));
            ok(okVar, 1);
            z3 = false;
        }
        if (!z3) {
            okVar.bl = sb.toString();
        } else {
            okVar.f49159a = 0;
        }
        return true;
    }

    private static boolean ok(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.ok okVar) {
        boolean z3;
        if (context != null && jSONObject != null) {
            String optString = jSONObject.optString("device_plans");
            okVar.f49160n = optString;
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
                    com.ss.android.socialbase.appdownloader.ok.ok ok2 = com.ss.android.socialbase.appdownloader.ok.s.ok(context, str2, jSONObject, downloadInfo);
                    if (ok2 != null) {
                        Intent a4 = ok2.a();
                        if (a4 != null) {
                            if (ok(file, downloadInfo, jSONObject)) {
                                try {
                                    ok(context, a4, false);
                                    str = str2;
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str2);
                                    sb.append(" startActivity failed : ");
                                    sb.append(ok(th));
                                    ok(okVar, 1);
                                }
                            } else {
                                ok(okVar, 6);
                                sb.append(str2);
                                sb.append(" createDescFile failed! ");
                            }
                        } else {
                            ok(okVar, 3);
                            sb.append(str2);
                            sb.append(" resolveActivity failed! ");
                        }
                    }
                    sb.append("  ");
                    i4++;
                }
                if (!z3) {
                    okVar.bl = sb.toString();
                } else {
                    okVar.f49161s = str;
                    okVar.f49159a = 0;
                }
                return z3;
            }
        }
        return false;
    }

    public static int ok(@NonNull com.ss.android.socialbase.downloader.h.ok okVar) {
        JSONObject s3 = okVar.s("download_dir");
        if (s3 != null ? !TextUtils.isEmpty(s3.optString("dir_name")) : false) {
            if (com.ss.android.socialbase.downloader.h.ok.bl().ok("get_download_info_by_list")) {
                JSONArray n4 = okVar.n("ah_plans");
                int i4 = -1;
                if (n4 != null) {
                    int length = n4.length();
                    for (int i5 = 0; i5 < length; i5++) {
                        JSONObject optJSONObject = n4.optJSONObject(i5);
                        if (com.ss.android.socialbase.appdownloader.kf.ok.ok(optJSONObject)) {
                            String optString = optJSONObject.optString("type");
                            if (!"plan_a".equals(optString) && !"plan_b".equals(optString) && !"plan_e".equals(optString) && !"plan_f".equals(optString)) {
                                if ("plan_d".equalsIgnoreCase(optString) || "plan_h".equalsIgnoreCase(optString) || ("plan_g".equalsIgnoreCase(optString) && (i4 = a(optJSONObject, okVar).f49159a) == 0)) {
                                    return 0;
                                }
                            } else {
                                i4 = ok(optJSONObject, okVar).f49159a;
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
    public static com.ss.android.socialbase.appdownloader.ok ok(JSONObject jSONObject, com.ss.android.socialbase.downloader.h.ok okVar) {
        com.ss.android.socialbase.appdownloader.ok okVar2 = new com.ss.android.socialbase.appdownloader.ok();
        if (jSONObject == null) {
            return okVar2;
        }
        String optString = jSONObject.optString("type");
        okVar2.ok = optString;
        if ("plan_b".equals(optString)) {
            okVar2.f49160n = "custom";
            if (com.ss.android.socialbase.appdownloader.ok.s.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), "custom", jSONObject, okVar)) {
                okVar2.f49159a = 0;
                return okVar2;
            }
            ok(okVar2, 3);
        } else {
            String optString2 = jSONObject.optString("device_plans");
            okVar2.f49160n = optString2;
            if (!TextUtils.isEmpty(optString2)) {
                for (String str : optString2.split(",")) {
                    if (com.ss.android.socialbase.appdownloader.ok.s.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), str, jSONObject, okVar)) {
                        okVar2.f49159a = 0;
                        return okVar2;
                    }
                    ok(okVar2, 3);
                }
            }
        }
        return okVar2;
    }

    public static com.ss.android.socialbase.appdownloader.ok ok(JSONObject jSONObject, String str, Context context, com.ss.android.socialbase.downloader.h.ok okVar) {
        com.ss.android.socialbase.appdownloader.ok okVar2 = new com.ss.android.socialbase.appdownloader.ok();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.kf.n.bl()) {
            okVar2.ok = jSONObject.optString("type");
            if (okVar.ok("bi", 0) == 1) {
                okVar2.f49159a = 0;
                return okVar2;
            } else if (ok(context)) {
                okVar2.f49159a = 2;
            } else if (com.ss.android.socialbase.appdownloader.kf.ok.ok(str) != null) {
                okVar2.f49159a = 0;
            } else {
                okVar2.f49159a = 9;
            }
        }
        return okVar2;
    }

    private static void ok(com.ss.android.socialbase.appdownloader.ok okVar, int i4) {
        int i5 = okVar.f49159a;
        if (i5 != -1) {
            okVar.f49159a = (i5 * 10) + i4;
        } else {
            okVar.f49159a = i4;
        }
    }

    private static boolean ok(File file, DownloadInfo downloadInfo, @NonNull JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject s3 = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).s("download_dir");
        File file2 = null;
        String optString = s3 != null ? s3.optString("ins_desc") : null;
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

    public static boolean ok(Context context, @Nullable Intent intent, JSONObject jSONObject, int i4, @Nullable com.ss.android.socialbase.appdownloader.ok okVar) {
        if (context != null && jSONObject != null) {
            long optLong = jSONObject.optLong("jump_interval", 0L);
            if (optLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("sp_ah_config", 0);
            if ((System.currentTimeMillis() - sharedPreferences.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= optLong && !ok(context)) {
                sharedPreferences.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                    Intent intent2 = new Intent(context, JumpUnknownSourceActivity.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("id", i4);
                    try {
                        if (ok(context, intent2, false)) {
                            s(i4, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (okVar != null) {
                            okVar.f49159a = 1;
                            okVar.bl = "tryShowUnknownSourceDialog" + ok(th);
                        }
                        return false;
                    }
                }
                if (ok(context, intent, i4, jSONObject)) {
                    bl(i4, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean ok(Context context, @Nullable Intent intent, int i4, JSONObject jSONObject) {
        try {
            if (com.ss.android.socialbase.appdownloader.kf.n.bl() && Build.VERSION.SDK_INT < 26 && !s(context)) {
                com.ss.android.socialbase.appdownloader.ok.kf kfVar = new com.ss.android.socialbase.appdownloader.ok.kf(context);
                if (kfVar.ok()) {
                    ok(context, intent, i4, jSONObject, new InterfaceC0965a() { // from class: com.ss.android.socialbase.appdownloader.a.1
                        @Override // com.ss.android.socialbase.appdownloader.a.InterfaceC0965a
                        public boolean ok(@NonNull Context context2) {
                            return a.s(context2);
                        }
                    });
                    return a(context, kfVar.a());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !n(context)) {
                com.ss.android.socialbase.appdownloader.ok.a aVar = new com.ss.android.socialbase.appdownloader.ok.a(context);
                if (aVar.ok()) {
                    ok(context, intent, i4, jSONObject, new InterfaceC0965a() { // from class: com.ss.android.socialbase.appdownloader.a.2
                        @Override // com.ss.android.socialbase.appdownloader.a.InterfaceC0965a
                        public boolean ok(@NonNull Context context2) {
                            return a.n(context2);
                        }
                    });
                    return a(context, aVar.a());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean ok(Context context) {
        if (context == null) {
            return true;
        }
        if (com.ss.android.socialbase.appdownloader.kf.n.bl() && Build.VERSION.SDK_INT < 26) {
            return s(context);
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return n(context);
        }
        return true;
    }

    public static boolean ok() {
        return n.ok == 1;
    }

    public static void ok(int i4, JSONObject jSONObject) {
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
        com.ss.android.socialbase.downloader.downloader.bl.vk().a(i4, "guide_auth_dialog_confirm", jSONObject2);
    }

    private static void ok(Context context, Intent intent, int i4, JSONObject jSONObject, InterfaceC0965a interfaceC0965a) {
        if (bl != null) {
            com.ss.android.socialbase.downloader.ok.ok.ok().a(bl);
            bl = null;
        }
        bl = new ok(context, intent, i4, jSONObject, interfaceC0965a);
        com.ss.android.socialbase.downloader.ok.ok.ok().ok(bl);
    }

    public static boolean ok(Context context, Intent intent, boolean z3) {
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

    public static String ok(Throwable th) {
        String th2 = th.toString();
        return th2.length() > 800 ? th2.substring(0, 500) : th2;
    }

    public static void ok(bl blVar) {
        f49020a = blVar;
    }
}
