package com.p521ss.android.socialbase.appdownloader;

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
import androidx.core.provider.FontsContractCompat;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12317n;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12318ok;
import com.p521ss.android.socialbase.appdownloader.p546ok.AbstractC12348ok;
import com.p521ss.android.socialbase.appdownloader.p546ok.C12341a;
import com.p521ss.android.socialbase.appdownloader.p546ok.C12346kf;
import com.p521ss.android.socialbase.appdownloader.p546ok.C12352s;
import com.p521ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p554ok.C12646ok;
import com.p521ss.android.socialbase.downloader.p555p.HandlerC12663p;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.appdownloader.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12284a {

    /* renamed from: a */
    private static InterfaceC12288bl f34637a = null;

    /* renamed from: bl */
    private static C12290ok f34638bl = null;

    /* renamed from: ok */
    private static final String f34639ok = "a";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.ss.android.socialbase.appdownloader.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12287a {
        /* renamed from: ok */
        boolean mo18450ok(@NonNull Context context);
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.a$bl */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12288bl {
        /* renamed from: ok */
        void mo18449ok(DownloadInfo downloadInfo, C12340ok c12340ok);
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.a$n */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C12289n implements HandlerC12663p.InterfaceC12664ok {

        /* renamed from: a */
        private static int f34640a;

        /* renamed from: ok */
        public static int f34641ok;

        /* renamed from: bl */
        private final Context f34642bl;

        /* renamed from: h */
        private final long f34643h;

        /* renamed from: kf */
        private final Handler f34644kf;

        /* renamed from: n */
        private final InterfaceC12287a f34645n;

        /* renamed from: p */
        private Future<Boolean> f34646p;

        /* renamed from: q */
        private boolean f34647q = false;

        /* renamed from: s */
        private final Intent f34648s;

        public C12289n(Context context, Intent intent, int i, InterfaceC12287a interfaceC12287a, long j) {
            this.f34642bl = context;
            this.f34648s = intent;
            f34640a = i;
            this.f34645n = interfaceC12287a;
            this.f34644kf = new HandlerC12663p(Looper.getMainLooper(), this);
            this.f34643h = j;
        }

        @Override // com.p521ss.android.socialbase.downloader.p555p.HandlerC12663p.InterfaceC12664ok
        /* renamed from: ok */
        public void mo16744ok(Message message) {
            if (message != null) {
                int i = message.what;
                if (i == 1) {
                    long j = this.f34643h;
                    if (j <= 0 || j > 10000) {
                        return;
                    }
                    f34641ok = 1;
                    this.f34646p = C12490bl.m17812j().submit(new CallableC12291s(this.f34644kf, this.f34642bl, this.f34645n, this.f34643h));
                } else if (i == 2) {
                    f34641ok = 2;
                    this.f34644kf.removeMessages(2);
                    this.f34644kf.removeMessages(1);
                    Future<Boolean> future = this.f34646p;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.f34647q && (Build.VERSION.SDK_INT < 29 || C12646ok.m16846ok().m16854a())) {
                        Intent intent = this.f34648s;
                        if (intent != null) {
                            C12284a.m18479a(this.f34642bl, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.f34642bl).getDownloadInfo(f34640a);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                C12293bl.m18442a(this.f34642bl, f34640a, false);
                            }
                        }
                        this.f34647q = true;
                    }
                    C12284a.m18481a(f34640a, this.f34648s == null, C12284a.m18470ok(this.f34642bl));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.socialbase.appdownloader.a$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12290ok implements C12646ok.InterfaceC12650ok {

        /* renamed from: a */
        private final int f34649a;

        /* renamed from: bl */
        private JSONObject f34650bl;

        /* renamed from: ok */
        private final C12289n f34651ok;

        public C12290ok(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC12287a interfaceC12287a) {
            this.f34650bl = jSONObject;
            int optInt = jSONObject.optInt("query_interval", 1000);
            this.f34649a = optInt;
            this.f34651ok = new C12289n(context, intent, i, interfaceC12287a, optInt);
        }

        @Override // com.p521ss.android.socialbase.downloader.p554ok.C12646ok.InterfaceC12650ok
        /* renamed from: a */
        public void mo16836a() {
            if (!this.f34651ok.f34647q) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                this.f34651ok.f34644kf.sendMessage(obtain);
            }
            C12646ok.m16846ok().m16853a(this);
            C12290ok unused = C12284a.f34638bl = null;
        }

        @Override // com.p521ss.android.socialbase.downloader.p554ok.C12646ok.InterfaceC12650ok
        /* renamed from: bl */
        public void mo16835bl() {
            int optInt = this.f34650bl.optInt("time_out_second", 20);
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.f34651ok.f34644kf.sendMessage(obtain);
            if (optInt <= 0 || optInt >= 60) {
                return;
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            this.f34651ok.f34644kf.sendMessageDelayed(obtain2, optInt * 1000);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.a$s */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class CallableC12291s implements Callable<Boolean> {

        /* renamed from: a */
        private final InterfaceC12287a f34652a;

        /* renamed from: bl */
        private final Handler f34653bl;

        /* renamed from: ok */
        private final Context f34654ok;

        /* renamed from: s */
        private final long f34655s;

        public CallableC12291s(Handler handler, Context context, InterfaceC12287a interfaceC12287a, long j) {
            this.f34654ok = context;
            this.f34652a = interfaceC12287a;
            this.f34653bl = handler;
            this.f34655s = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            InterfaceC12287a interfaceC12287a;
            try {
                interfaceC12287a = this.f34652a;
            } catch (Throwable unused) {
            }
            if (interfaceC12287a != null) {
                long j = this.f34655s;
                if (j > 0 && j <= 10000) {
                    Context context = this.f34654ok;
                    boolean mo18450ok = context != null ? interfaceC12287a.mo18450ok(context) : false;
                    Message obtain = Message.obtain();
                    if (mo18450ok) {
                        obtain.what = 2;
                        this.f34653bl.sendMessage(obtain);
                    } else {
                        obtain.what = 1;
                        this.f34653bl.sendMessageDelayed(obtain, this.f34655s);
                    }
                    return Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 26)
    /* renamed from: n */
    public static boolean m18474n(Context context) {
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
    /* renamed from: s */
    public static boolean m18451s(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* renamed from: a */
    private static boolean m18478a(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull C12340ok c12340ok) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            c12340ok.f34806s = "custom";
            AbstractC12348ok m18107ok = C12352s.m18107ok(context, "custom", jSONObject, downloadInfo);
            if (m18107ok != null && m18107ok.m18109ok()) {
                Intent mo18106a = m18107ok.mo18106a();
                if (mo18106a == null) {
                    return false;
                }
                if (m18456ok(new File(savePath), downloadInfo, jSONObject)) {
                    if (m18479a(context, mo18106a)) {
                        c12340ok.f34802a = 0;
                        return true;
                    }
                    c12340ok.f34802a = 1;
                } else {
                    c12340ok.f34802a = 6;
                }
                return false;
            }
            c12340ok.f34802a = 3;
        }
        return false;
    }

    /* renamed from: bl */
    public static void m18476bl(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C12490bl.m17752vk().mo16495a(i, "guide_auth_open_setting", jSONObject2);
    }

    /* renamed from: s */
    private static void m18452s(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C12490bl.m17752vk().mo16495a(i, "guide_auth_dialog_show", jSONObject2);
    }

    /* renamed from: ok */
    public static boolean m18463ok(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        JSONArray m17601n = C12534ok.m17599ok(downloadInfo.getId()).m17601n("ah_plans");
        if (m17601n != null) {
            int length = m17601n.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = m17601n.optJSONObject(i);
                if (C12318ok.m18215ok(optJSONObject) && m18464ok(context, downloadInfo, intent, optJSONObject, z)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0173  */
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m18464ok(android.content.Context r11, com.p521ss.android.socialbase.downloader.model.DownloadInfo r12, android.content.Intent r13, org.json.JSONObject r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.appdownloader.C12284a.m18464ok(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, android.content.Intent, org.json.JSONObject, boolean):boolean");
    }

    /* renamed from: a */
    public static C12340ok m18477a(JSONObject jSONObject, C12534ok c12534ok) {
        C12340ok c12340ok = new C12340ok();
        if (jSONObject == null) {
            return c12340ok;
        }
        c12340ok.f34805ok = jSONObject.optString("type");
        c12340ok.f34804n = "vbi";
        if (C12352s.m18108ok(C12490bl.m17807l(), "vbi", jSONObject, c12534ok)) {
            c12340ok.f34802a = 0;
        } else {
            m18458ok(c12340ok, 3);
        }
        return c12340ok;
    }

    /* renamed from: a */
    public static void m18482a(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C12490bl.m17752vk().mo16495a(i, "guide_auth_dialog_cancel", jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m18481a(int i, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        int i2 = 1;
        try {
            jSONObject.put("scene", z ? 1 : 2);
            if (!z2) {
                i2 = 2;
            }
            jSONObject.put(FontsContractCompat.Columns.RESULT_CODE, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C12490bl.m17752vk().mo16495a(i, "guide_auth_result", jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static boolean m18479a(Context context, Intent intent) {
        return m18465ok(context, intent, true);
    }

    /* renamed from: ok */
    private static boolean m18461ok(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull C12340ok c12340ok, C12534ok c12534ok) {
        boolean z;
        String optString = jSONObject.optString("type");
        c12340ok.f34805ok = optString;
        Intent mo18106a = C12352s.m18107ok(context, "vbi", jSONObject, downloadInfo).mo18106a();
        StringBuilder sb = new StringBuilder();
        try {
            z = m18479a(context, mo18106a);
        } catch (Throwable th) {
            sb.append(optString);
            sb.append(" startActivity failed : ");
            sb.append(m18455ok(th));
            m18458ok(c12340ok, 1);
            z = false;
        }
        if (!z) {
            c12340ok.f34803bl = sb.toString();
        } else {
            c12340ok.f34802a = 0;
        }
        return true;
    }

    /* renamed from: ok */
    private static boolean m18462ok(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, C12340ok c12340ok) {
        boolean z;
        if (context != null && jSONObject != null) {
            String optString = jSONObject.optString("device_plans");
            c12340ok.f34804n = optString;
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
                int i = 0;
                while (true) {
                    z = true;
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    String str2 = split[i];
                    AbstractC12348ok m18107ok = C12352s.m18107ok(context, str2, jSONObject, downloadInfo);
                    if (m18107ok != null) {
                        Intent mo18106a = m18107ok.mo18106a();
                        if (mo18106a != null) {
                            if (m18456ok(file, downloadInfo, jSONObject)) {
                                try {
                                    m18465ok(context, mo18106a, false);
                                    str = str2;
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str2);
                                    sb.append(" startActivity failed : ");
                                    sb.append(m18455ok(th));
                                    m18458ok(c12340ok, 1);
                                }
                            } else {
                                m18458ok(c12340ok, 6);
                                sb.append(str2);
                                sb.append(" createDescFile failed! ");
                            }
                        } else {
                            m18458ok(c12340ok, 3);
                            sb.append(str2);
                            sb.append(" resolveActivity failed! ");
                        }
                    }
                    sb.append("  ");
                    i++;
                }
                if (!z) {
                    c12340ok.f34803bl = sb.toString();
                } else {
                    c12340ok.f34806s = str;
                    c12340ok.f34802a = 0;
                }
                return z;
            }
        }
        return false;
    }

    /* renamed from: ok */
    public static int m18457ok(@NonNull C12534ok c12534ok) {
        JSONObject m17588s = c12534ok.m17588s("download_dir");
        if (m17588s != null ? !TextUtils.isEmpty(m17588s.optString("dir_name")) : false) {
            if (C12534ok.m17605bl().m17595ok("get_download_info_by_list")) {
                JSONArray m17601n = c12534ok.m17601n("ah_plans");
                int i = -1;
                if (m17601n != null) {
                    int length = m17601n.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject optJSONObject = m17601n.optJSONObject(i2);
                        if (C12318ok.m18215ok(optJSONObject)) {
                            String optString = optJSONObject.optString("type");
                            if (!"plan_a".equals(optString) && !"plan_b".equals(optString) && !"plan_e".equals(optString) && !"plan_f".equals(optString)) {
                                if ("plan_d".equalsIgnoreCase(optString) || "plan_h".equalsIgnoreCase(optString) || ("plan_g".equalsIgnoreCase(optString) && (i = m18477a(optJSONObject, c12534ok).f34802a) == 0)) {
                                    return 0;
                                }
                            } else {
                                i = m18454ok(optJSONObject, c12534ok).f34802a;
                                if (i == 0) {
                                    return 0;
                                }
                            }
                        }
                    }
                }
                return i;
            }
            return 4;
        }
        return 5;
    }

    @NonNull
    /* renamed from: ok */
    public static C12340ok m18454ok(JSONObject jSONObject, C12534ok c12534ok) {
        C12340ok c12340ok = new C12340ok();
        if (jSONObject == null) {
            return c12340ok;
        }
        String optString = jSONObject.optString("type");
        c12340ok.f34805ok = optString;
        if ("plan_b".equals(optString)) {
            c12340ok.f34804n = "custom";
            if (C12352s.m18108ok(C12490bl.m17807l(), "custom", jSONObject, c12534ok)) {
                c12340ok.f34802a = 0;
                return c12340ok;
            }
            m18458ok(c12340ok, 3);
        } else {
            String optString2 = jSONObject.optString("device_plans");
            c12340ok.f34804n = optString2;
            if (!TextUtils.isEmpty(optString2)) {
                for (String str : optString2.split(",")) {
                    if (C12352s.m18108ok(C12490bl.m17807l(), str, jSONObject, c12534ok)) {
                        c12340ok.f34802a = 0;
                        return c12340ok;
                    }
                    m18458ok(c12340ok, 3);
                }
            }
        }
        return c12340ok;
    }

    /* renamed from: ok */
    public static C12340ok m18453ok(JSONObject jSONObject, String str, Context context, C12534ok c12534ok) {
        C12340ok c12340ok = new C12340ok();
        if (jSONObject != null && C12317n.m18244bl()) {
            c12340ok.f34805ok = jSONObject.optString("type");
            if (c12534ok.m17593ok("bi", 0) == 1) {
                c12340ok.f34802a = 0;
                return c12340ok;
            } else if (m18470ok(context)) {
                c12340ok.f34802a = 2;
            } else if (C12318ok.m18219ok(str) != null) {
                c12340ok.f34802a = 0;
            } else {
                c12340ok.f34802a = 9;
            }
        }
        return c12340ok;
    }

    /* renamed from: ok */
    private static void m18458ok(C12340ok c12340ok, int i) {
        int i2 = c12340ok.f34802a;
        if (i2 != -1) {
            c12340ok.f34802a = (i2 * 10) + i;
        } else {
            c12340ok.f34802a = i;
        }
    }

    /* renamed from: ok */
    private static boolean m18456ok(File file, DownloadInfo downloadInfo, @NonNull JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject m17588s = C12534ok.m17599ok(downloadInfo.getId()).m17588s("download_dir");
        File file2 = null;
        String optString = m17588s != null ? m17588s.optString("ins_desc") : null;
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

    /* renamed from: ok */
    public static boolean m18466ok(Context context, @Nullable Intent intent, JSONObject jSONObject, int i, @Nullable C12340ok c12340ok) {
        if (context != null && jSONObject != null) {
            long optLong = jSONObject.optLong("jump_interval", 0L);
            if (optLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences("sp_ah_config", 0);
            if ((System.currentTimeMillis() - sharedPreferences.getLong("last_jump_unknown_source_time", 0L)) / 60000 >= optLong && !m18470ok(context)) {
                sharedPreferences.edit().putLong("last_jump_unknown_source_time", System.currentTimeMillis()).apply();
                if (jSONObject.optInt("show_unknown_source_dialog", 0) == 1) {
                    Intent intent2 = new Intent(context, JumpUnknownSourceActivity.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("id", i);
                    try {
                        if (m18465ok(context, intent2, false)) {
                            m18452s(i, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (c12340ok != null) {
                            c12340ok.f34802a = 1;
                            c12340ok.f34803bl = "tryShowUnknownSourceDialog" + m18455ok(th);
                        }
                        return false;
                    }
                }
                if (m18468ok(context, intent, i, jSONObject)) {
                    m18476bl(i, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: ok */
    public static boolean m18468ok(Context context, @Nullable Intent intent, int i, JSONObject jSONObject) {
        try {
            if (C12317n.m18244bl() && Build.VERSION.SDK_INT < 26 && !m18451s(context)) {
                C12346kf c12346kf = new C12346kf(context);
                if (c12346kf.m18109ok()) {
                    m18467ok(context, intent, i, jSONObject, new InterfaceC12287a() { // from class: com.ss.android.socialbase.appdownloader.a.1
                        @Override // com.p521ss.android.socialbase.appdownloader.C12284a.InterfaceC12287a
                        /* renamed from: ok */
                        public boolean mo18450ok(@NonNull Context context2) {
                            return C12284a.m18451s(context2);
                        }
                    });
                    return m18479a(context, c12346kf.mo18106a());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !m18474n(context)) {
                C12341a c12341a = new C12341a(context);
                if (c12341a.m18109ok()) {
                    m18467ok(context, intent, i, jSONObject, new InterfaceC12287a() { // from class: com.ss.android.socialbase.appdownloader.a.2
                        @Override // com.p521ss.android.socialbase.appdownloader.C12284a.InterfaceC12287a
                        /* renamed from: ok */
                        public boolean mo18450ok(@NonNull Context context2) {
                            return C12284a.m18474n(context2);
                        }
                    });
                    return m18479a(context, c12341a.mo18106a());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* renamed from: ok */
    public static boolean m18470ok(Context context) {
        if (context == null) {
            return true;
        }
        if (C12317n.m18244bl() && Build.VERSION.SDK_INT < 26) {
            return m18451s(context);
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return m18474n(context);
        }
        return true;
    }

    /* renamed from: ok */
    public static boolean m18473ok() {
        return C12289n.f34641ok == 1;
    }

    /* renamed from: ok */
    public static void m18472ok(int i, JSONObject jSONObject) {
        int i2 = 1;
        boolean z = jSONObject.optInt("show_unknown_source_on_startup") == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i2 = 2;
        }
        try {
            jSONObject2.put("scene", i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C12490bl.m17752vk().mo16495a(i, "guide_auth_dialog_confirm", jSONObject2);
    }

    /* renamed from: ok */
    private static void m18467ok(Context context, Intent intent, int i, JSONObject jSONObject, InterfaceC12287a interfaceC12287a) {
        if (f34638bl != null) {
            C12646ok.m16846ok().m16853a(f34638bl);
            f34638bl = null;
        }
        f34638bl = new C12290ok(context, intent, i, jSONObject, interfaceC12287a);
        C12646ok.m16846ok().m16843ok(f34638bl);
    }

    /* renamed from: ok */
    public static boolean m18465ok(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
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

    /* renamed from: ok */
    public static String m18455ok(Throwable th) {
        String th2 = th.toString();
        return th2.length() > 800 ? th2.substring(0, 500) : th2;
    }

    /* renamed from: ok */
    public static void m18460ok(InterfaceC12288bl interfaceC12288bl) {
        f34637a = interfaceC12288bl;
    }
}
