package com.qq.e.comm.plugin.q0.u;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.compliance.DownloadConfirmCallBack;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.apkmanager.c;
import com.qq.e.comm.plugin.apkmanager.k;
import com.qq.e.comm.plugin.apkmanager.n;
import com.qq.e.comm.plugin.i.u;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.q0.s.e;
import com.qq.e.comm.plugin.util.a1;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.q0;
import com.qq.e.comm.plugin.util.v0;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e extends j {

    /* renamed from: h  reason: collision with root package name */
    private static final String f45579h = "e";

    /* renamed from: d  reason: collision with root package name */
    private com.qq.e.comm.plugin.q0.s.g f45583d;

    /* renamed from: e  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f45584e;

    /* renamed from: f  reason: collision with root package name */
    private com.qq.e.comm.plugin.n0.c f45585f;

    /* renamed from: a  reason: collision with root package name */
    private AtomicBoolean f45580a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private ConcurrentHashMap<String, String> f45581b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private Map<Integer, String> f45582c = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private com.qq.e.comm.plugin.apkmanager.w.a f45586g = new f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements DownloadConfirmCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ApkDownloadTask f45587a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f45588b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.q0.s.g f45589c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f45590d;

        a(ApkDownloadTask apkDownloadTask, String str, com.qq.e.comm.plugin.q0.s.g gVar, String str2) {
            this.f45587a = apkDownloadTask;
            this.f45588b = str;
            this.f45589c = gVar;
            this.f45590d = str2;
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmCallBack
        public void onCancel() {
            e.this.a(this.f45589c, this.f45590d, 20);
            com.qq.e.comm.plugin.n0.w.b.a(4001027, 4, 104, e.this.f45585f);
            com.qq.e.comm.plugin.apkmanager.x.d.a(this.f45588b, 1100912, e.this.f45585f);
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmCallBack
        public void onConfirm() {
            k.e().c(this.f45587a);
            com.qq.e.comm.plugin.n0.w.b.a(4001026, 4, 104, e.this.f45585f);
            com.qq.e.comm.plugin.apkmanager.x.d.a(this.f45588b, 1100911, e.this.f45585f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements com.qq.e.comm.plugin.i.d0.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.q0.s.g f45592a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f45593b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f45594c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ApkDownloadTask f45595d;

        b(com.qq.e.comm.plugin.q0.s.g gVar, String str, String str2, ApkDownloadTask apkDownloadTask) {
            this.f45592a = gVar;
            this.f45593b = str;
            this.f45594c = str2;
            this.f45595d = apkDownloadTask;
        }

        @Override // com.qq.e.comm.plugin.i.d0.c
        public void a(boolean z3) {
        }

        @Override // com.qq.e.comm.plugin.i.d0.c
        public void b(boolean z3) {
            if (z3) {
                return;
            }
            onCancel();
            com.qq.e.comm.plugin.apkmanager.x.d.a(this.f45594c, 1100922, e.this.f45585f);
        }

        @Override // com.qq.e.comm.plugin.i.d0.c
        public void onCancel() {
            e.this.a(this.f45592a, this.f45593b, 20);
            com.qq.e.comm.plugin.n0.w.b.a(4001027, 4, 104, e.this.f45585f);
            com.qq.e.comm.plugin.apkmanager.x.d.a(this.f45594c, 1100912, e.this.f45585f);
        }

        @Override // com.qq.e.comm.plugin.i.d0.c
        public boolean onConfirm() {
            k.e().c(this.f45595d);
            com.qq.e.comm.plugin.n0.w.b.a(4001026, 4, 104, e.this.f45585f);
            com.qq.e.comm.plugin.apkmanager.x.d.a(this.f45594c, 1100911, e.this.f45585f);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements DownloadConfirmCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f45597a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.q0.s.g f45598b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ JSONObject f45599c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f45600d;

        c(Context context, com.qq.e.comm.plugin.q0.s.g gVar, JSONObject jSONObject, String str) {
            this.f45597a = context;
            this.f45598b = gVar;
            this.f45599c = jSONObject;
            this.f45600d = str;
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmCallBack
        public void onCancel() {
            e.this.a(this.f45598b, this.f45600d, 20);
        }

        @Override // com.qq.e.comm.compliance.DownloadConfirmCallBack
        public void onConfirm() {
            e.this.a(this.f45597a, this.f45598b, this.f45599c, this.f45600d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d implements com.qq.e.comm.plugin.i.d0.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.q0.s.g f45602a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f45603b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f45604c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ JSONObject f45605d;

        d(com.qq.e.comm.plugin.q0.s.g gVar, String str, Context context, JSONObject jSONObject) {
            this.f45602a = gVar;
            this.f45603b = str;
            this.f45604c = context;
            this.f45605d = jSONObject;
        }

        @Override // com.qq.e.comm.plugin.i.d0.c
        public void a(boolean z3) {
        }

        @Override // com.qq.e.comm.plugin.i.d0.c
        public void b(boolean z3) {
            if (z3) {
                return;
            }
            onCancel();
        }

        @Override // com.qq.e.comm.plugin.i.d0.c
        public void onCancel() {
            e.this.a(this.f45602a, this.f45603b, 20);
        }

        @Override // com.qq.e.comm.plugin.i.d0.c
        public boolean onConfirm() {
            e.this.a(this.f45604c, this.f45602a, this.f45605d, this.f45603b);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.q0.u.e$e  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0879e implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f45607c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.i.d0.c f45608d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ boolean f45609e;

        RunnableC0879e(Context context, com.qq.e.comm.plugin.i.d0.c cVar, boolean z3) {
            this.f45607c = context;
            this.f45608d = cVar;
            this.f45609e = z3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.f0.f.a(this.f45607c, e.this.f45584e, this.f45608d, this.f45609e ? 8 : 0);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class f implements com.qq.e.comm.plugin.apkmanager.w.a {
        f() {
        }

        @Override // com.qq.e.comm.plugin.apkmanager.w.a
        public void a(String str, int i4, int i5, long j4) {
            if (i4 == 128 || TextUtils.isEmpty(str) || !e.this.f45581b.containsKey(str)) {
                return;
            }
            String str2 = (String) e.this.f45581b.get(str);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("code", 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("status", e.this.a(i4));
                jSONObject2.put("progress", i5);
                jSONObject2.put("total", j4);
                jSONObject.put("data", jSONObject2);
            } catch (JSONException e4) {
                d1.a(e4.getMessage(), e4);
            }
            e.this.f45583d.a(new com.qq.e.comm.plugin.q0.s.e(new com.qq.e.comm.plugin.q0.s.d(str2), e.a.f45548c, jSONObject, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static /* synthetic */ class g {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f45612a;

        static {
            int[] iArr = new int[com.qq.e.comm.plugin.d0.e.d.values().length];
            f45612a = iArr;
            try {
                iArr[com.qq.e.comm.plugin.d0.e.d.NET_4G.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45612a[com.qq.e.comm.plugin.d0.e.d.NET_3G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45612a[com.qq.e.comm.plugin.d0.e.d.NET_2G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45612a[com.qq.e.comm.plugin.d0.e.d.WIFI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class h implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private final String f45613a;

        /* renamed from: b  reason: collision with root package name */
        private final String f45614b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f45615c;

        /* renamed from: d  reason: collision with root package name */
        private final com.qq.e.comm.plugin.g0.e f45616d;

        /* renamed from: e  reason: collision with root package name */
        private final long f45617e = System.currentTimeMillis();

        /* renamed from: f  reason: collision with root package name */
        private final com.qq.e.comm.plugin.n0.c f45618f;

        public h(String str, String str2, boolean z3, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.n0.c cVar) {
            this.f45614b = str;
            this.f45613a = str2;
            this.f45615c = z3;
            this.f45616d = eVar;
            this.f45618f = cVar;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public void a(int i4, String str, boolean z3) {
            String str2;
            ApkDownloadTask apkDownloadTask;
            if (i4 != 0 || z3) {
                return;
            }
            a1.a(this.f45613a);
            com.qq.e.comm.plugin.apkmanager.x.f a4 = com.qq.e.comm.plugin.n0.w.b.a(this.f45614b);
            com.qq.e.comm.plugin.g0.e eVar = this.f45616d;
            str2 = "";
            if (eVar != null) {
                com.qq.e.comm.plugin.g0.b q3 = eVar.q();
                String a5 = q3 != null ? q3.a() : "";
                str2 = this.f45616d.b();
                apkDownloadTask = new ApkDownloadTask(this.f45616d, null, null, null, a5, this.f45614b, 0);
            } else {
                apkDownloadTask = new ApkDownloadTask(this.f45614b);
            }
            apkDownloadTask.a(str2, null, true);
            if (!this.f45615c) {
                e.b(4001011, false, this.f45617e, this.f45618f);
            } else {
                a4.f41948d = 9;
                com.qq.e.comm.plugin.apkmanager.x.d.c(1100905, apkDownloadTask);
                e.b(4001043, true, this.f45617e, this.f45618f);
            }
            a4.f41953i = 2;
            u.a(apkDownloadTask);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public boolean a() {
            return false;
        }
    }

    public e(com.qq.e.comm.plugin.g0.e eVar) {
        this.f45584e = eVar;
        this.f45585f = com.qq.e.comm.plugin.n0.c.a(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i4) {
        if (i4 != 1) {
            if (i4 != 4) {
                if (i4 != 8) {
                    if (i4 != 16) {
                        if (i4 != 32) {
                            if (i4 != 64) {
                                return i4 != 128 ? 0 : 10;
                            }
                            return 9;
                        }
                        return 6;
                    }
                    return 5;
                }
                return 4;
            }
            return 3;
        }
        return 1;
    }

    public int b(Context context, JSONObject jSONObject) {
        boolean z3;
        d1.a("gdt_tag_download_apk", "openApp()");
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("packageName");
        Intent intent = new Intent();
        try {
            if (!TextUtils.isEmpty(optString)) {
                Uri parse = Uri.parse(optString);
                if ("http".equalsIgnoreCase(parse.getScheme()) || "https".equalsIgnoreCase(parse.getScheme())) {
                    return 11;
                }
                intent.setData(parse);
                intent.setAction("android.intent.action.VIEW");
                if (!TextUtils.isEmpty(optString2)) {
                    intent.setPackage(optString2);
                }
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    intent = context.getPackageManager().getLaunchIntentForPackage(optString2);
                    if (intent == null) {
                        return 12;
                    }
                    intent.addFlags(268435456);
                    if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                        return 12;
                    }
                } else {
                    z3 = true;
                    u.a(intent, optString2, optString, z3);
                    context.startActivity(intent);
                    com.qq.e.comm.plugin.apkmanager.x.f a4 = com.qq.e.comm.plugin.n0.w.b.a(optString2);
                    a4.f41949e = 3;
                    a4.f41953i = 1;
                    com.qq.e.comm.plugin.apkmanager.x.d.a(optString2, this.f45585f, true);
                    return 0;
                }
            } else {
                intent = context.getPackageManager().getLaunchIntentForPackage(optString2);
                if (intent == null) {
                    return 12;
                }
                intent.addFlags(268435456);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    return 12;
                }
            }
            u.a(intent, optString2, optString, z3);
            context.startActivity(intent);
            com.qq.e.comm.plugin.apkmanager.x.f a42 = com.qq.e.comm.plugin.n0.w.b.a(optString2);
            a42.f41949e = 3;
            a42.f41953i = 1;
            com.qq.e.comm.plugin.apkmanager.x.d.a(optString2, this.f45585f, true);
            return 0;
        } catch (Exception unused) {
            com.qq.e.comm.plugin.apkmanager.x.d.a(optString2, this.f45585f, false);
            d1.a("open App Exception!");
            return 1000;
        }
        z3 = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0191  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(android.content.Context r24, com.qq.e.comm.plugin.q0.s.g r25, org.json.JSONObject r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 420
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.q0.u.e.c(android.content.Context, com.qq.e.comm.plugin.q0.s.g, org.json.JSONObject, java.lang.String):void");
    }

    public int a(Context context, JSONObject jSONObject) {
        d1.a("gdt_tag_download_apk", "isAppInstall(context, option)");
        return com.qq.e.comm.plugin.apkmanager.x.b.b(context, jSONObject.optString("packageName")) ? 1 : 0;
    }

    public int a(JSONObject jSONObject) {
        boolean z3;
        d1.a("gdt_tag_download_apk", "pauseDownload(option)");
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            return 10;
        }
        ApkDownloadTask c4 = k.e().c(optString);
        if (c4 != null) {
            com.qq.e.comm.plugin.n0.w.b.b(4001004, c4, 1, 102);
            z3 = k.e().a(c4);
        } else {
            z3 = false;
        }
        return z3 ? 0 : 15;
    }

    private void a(com.qq.e.comm.plugin.q0.s.g gVar, String str, int i4, String str2, int i5) {
        JSONObject jSONObject = new JSONObject();
        boolean z3 = i4 == 0;
        try {
            jSONObject.put("marketResult", z3);
            if (!z3) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("code", i4);
                jSONObject2.put("scheme", str2);
                jSONObject.put("errorMessage", jSONObject2);
            }
            d1.a("openAppMarketResult %s", jSONObject);
        } catch (JSONException e4) {
            d1.a(e4.getMessage(), e4);
        }
        gVar.a(new com.qq.e.comm.plugin.q0.s.e(new com.qq.e.comm.plugin.q0.s.d(str), e.a.f45548c, jSONObject, i5));
    }

    private boolean a(Context context, com.qq.e.comm.plugin.q0.s.g gVar, String str, ApkDownloadTask apkDownloadTask, long j4) {
        String r3 = apkDownloadTask.r();
        d1.a(f45579h, "tryOpenAppMarket, pckName = %s, supportMarket = %s", r3, Long.valueOf(j4));
        v.a(1100418, this.f45585f, 2);
        if (context != null && !TextUtils.isEmpty(r3)) {
            if (!q0.a(j4)) {
                v.a(1100420, this.f45585f, 2, Integer.valueOf((int) MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME), null);
                a(gVar, str, MediaPlayer.MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME, (String) null, 1);
                return false;
            }
            com.qq.e.comm.plugin.n0.w.b.a(r3).f41952h = 1;
            Intent a4 = q0.a(context, r3, j4);
            if (a4 == null) {
                v.a(1100420, this.f45585f, 2, Integer.valueOf((int) MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT), null);
                a(gVar, str, MediaPlayer.MEDIA_PLAYER_OPTION_STREAM_FORMAT, q0.a(r3), 1);
                return false;
            }
            try {
                context.startActivity(a4);
                a(gVar, str, 0, (String) null, 0);
                com.qq.e.comm.plugin.apkmanager.x.a.b(apkDownloadTask, null);
                v.a(1100419, this.f45585f, 2);
                a(r3, true, com.qq.e.comm.plugin.apkmanager.x.a.b(apkDownloadTask));
                return true;
            } catch (Throwable th) {
                d1.a(f45579h, "tryOpenMarketFail", th);
                v.a(1100420, this.f45585f, 2, Integer.valueOf((int) MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT), null);
                a(gVar, str, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT, a4.getDataString(), 1);
                return false;
            }
        }
        v.a(1100420, this.f45585f, 2, 206, null);
        a(gVar, str, 206, (String) null, 1);
        return false;
    }

    public int b(JSONObject jSONObject) {
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            return 0;
        }
        return a(k.e().b(optString));
    }

    private String b() {
        com.qq.e.comm.plugin.g0.e eVar = this.f45584e;
        return eVar == null ? "" : eVar.e0();
    }

    public void b(com.qq.e.comm.plugin.q0.s.g gVar, JSONObject jSONObject, String str) {
        d1.a("gdt_tag_download_apk", "removeDownload()");
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            a(gVar, str, 10);
            return;
        }
        ApkDownloadTask c4 = k.e().c(optString);
        if (c4 != null) {
            com.qq.e.comm.plugin.n0.w.b.a(optString).f44822b = 4;
            com.qq.e.comm.plugin.n0.w.b.a(4001074, c4, 1);
            if (k.e().a(c4, true)) {
                com.qq.e.comm.plugin.n0.w.b.a(4001075, c4, 1);
            } else {
                a(gVar, str, 22);
            }
        }
    }

    public void b(Context context, com.qq.e.comm.plugin.q0.s.g gVar, JSONObject jSONObject, String str) {
        com.qq.e.comm.plugin.g0.e eVar = this.f45584e;
        String r3 = eVar != null ? eVar.r() : "";
        com.qq.e.comm.plugin.g0.e eVar2 = this.f45584e;
        boolean z3 = eVar2 != null && com.qq.e.comm.plugin.i.i.c(eVar2, 8);
        String b4 = b();
        DownloadConfirmListener a4 = com.qq.e.comm.plugin.b.j.b().a(b4);
        d1.a("DownloadConfirm web install traceId:" + b4 + " listener:" + a4, new Object[0]);
        if (z3 && a4 != null && (context instanceof Activity)) {
            a4.onDownloadConfirm((Activity) context, MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE, r3, new c(context, gVar, jSONObject, str));
        } else if (z3) {
            a(context, (com.qq.e.comm.plugin.i.d0.c) new d(gVar, str, context, jSONObject), r3, true);
        } else {
            a(context, gVar, jSONObject, str);
        }
    }

    public void a(com.qq.e.comm.plugin.q0.s.g gVar, JSONObject jSONObject, String str) {
        d1.a("gdt_tag_download_apk", "registerListener()");
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            a(gVar, str, 10);
            return;
        }
        a(gVar, optString, str);
        a(gVar);
    }

    public void a(Context context, com.qq.e.comm.plugin.q0.s.g gVar, JSONObject jSONObject, String str) {
        d1.a("gdt_tag_download_apk", "installApp()");
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            a(gVar, str, 10);
            return;
        }
        int b4 = k.e().b(optString);
        if (!com.qq.e.comm.plugin.apkmanager.w.d.d(b4)) {
            d1.a(String.format("install call failed(%s,%s)", Integer.valueOf(b4), optString), new Object[0]);
            a(gVar, str, 17);
            return;
        }
        File b5 = b1.b(optString + ".apk");
        if (b5 != null && b5.exists()) {
            b(4001010, false, 0L, this.f45585f);
            ApkDownloadTask apkDownloadTask = new ApkDownloadTask(optString, this.f45584e);
            if (!new n(context, apkDownloadTask).b(b5)) {
                a(gVar, str, 19);
                return;
            }
            com.qq.e.comm.plugin.apkmanager.x.f a4 = com.qq.e.comm.plugin.n0.w.b.a(optString);
            a4.f41949e = 3;
            a4.f41952h = 2;
            a4.f41948d = 8;
            a4.f41950f = 1;
            com.qq.e.comm.plugin.apkmanager.x.d.c(1100905, apkDownloadTask);
            a(gVar, optString, str);
            a(gVar);
            a(optString, false, this.f45582c.get(2));
            return;
        }
        a(gVar, str, 18);
    }

    public void c(com.qq.e.comm.plugin.q0.s.g gVar, JSONObject jSONObject, String str) {
        d1.a("gdt_tag_download_apk", "resumeDownload()");
        String optString = jSONObject.optString("packageName");
        if (TextUtils.isEmpty(optString)) {
            a(gVar, str, 10);
            return;
        }
        ApkDownloadTask c4 = k.e().c(optString);
        if (c4 != null) {
            c4.a(this.f45584e);
            com.qq.e.comm.plugin.n0.w.b.a(optString).f44822b = 4;
            com.qq.e.comm.plugin.n0.w.b.b(4001005, c4, 1, 102);
        }
        if (k.e().b(c4)) {
            a(gVar, optString, str);
            a(gVar);
            return;
        }
        a(gVar, str, 15);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i4, boolean z3, long j4, com.qq.e.comm.plugin.n0.c cVar) {
        com.qq.e.comm.plugin.n0.w.a aVar = new com.qq.e.comm.plugin.n0.w.a(cVar);
        if (z3) {
            aVar.f(3);
        } else {
            aVar.c(1);
            aVar.f(4);
        }
        if (j4 > 0) {
            aVar.a(System.currentTimeMillis() - j4);
        }
        com.qq.e.comm.plugin.n0.w.b.a(i4, aVar);
    }

    private void a(String str, boolean z3, String str2) {
        h hVar = new h(str, str2, z3, this.f45584e, this.f45585f);
        ApkDownloadTask apkDownloadTask = new ApkDownloadTask(str, this.f45584e);
        apkDownloadTask.a("appStore", z3 ? 1 : 0);
        n.h.f41862c.a(hVar, apkDownloadTask);
    }

    @Override // com.qq.e.comm.plugin.q0.u.j
    public com.qq.e.comm.plugin.q0.s.f<String> a(com.qq.e.comm.plugin.q0.h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
        JSONObject d4 = dVar.d();
        if (d4 == null) {
            return new com.qq.e.comm.plugin.q0.s.f<>("13");
        }
        if (hVar.a() == null) {
            return new com.qq.e.comm.plugin.q0.s.f<>(null);
        }
        com.qq.e.comm.plugin.q0.s.g c4 = hVar.c();
        Context context = hVar.getContext();
        String a4 = dVar.a();
        d1.a("GDTAppHandler handleAction %s,%s", a4, d4);
        String b4 = dVar.b();
        if ("openApp".equals(a4)) {
            return new com.qq.e.comm.plugin.q0.s.f<>(b(context, d4) + "");
        } else if ("isAppInstall".equals(a4)) {
            return new com.qq.e.comm.plugin.q0.s.f<>(a(context, d4) + "");
        } else if ("getDownloadStatus".equals(a4)) {
            return new com.qq.e.comm.plugin.q0.s.f<>(b(d4) + "");
        } else if ("pauseDownload".equals(a4)) {
            return new com.qq.e.comm.plugin.q0.s.f<>(a(d4) + "");
        } else if ("startDownload".equals(a4)) {
            c(context, c4, d4, b4);
            return new com.qq.e.comm.plugin.q0.s.f<>(null);
        } else if ("resumeDownload".equals(a4)) {
            c(c4, d4, b4);
            return new com.qq.e.comm.plugin.q0.s.f<>(null);
        } else if ("removeDownload".equals(a4)) {
            b(c4, d4, b4);
            return new com.qq.e.comm.plugin.q0.s.f<>(null);
        } else if ("registerListener".equals(a4)) {
            a(c4, d4, b4);
            return new com.qq.e.comm.plugin.q0.s.f<>(null);
        } else if ("installApp".equals(a4)) {
            b(context, c4, d4, b4);
            return new com.qq.e.comm.plugin.q0.s.f<>(null);
        } else if ("type".equals(a4)) {
            return new com.qq.e.comm.plugin.q0.s.f<>(c());
        } else {
            if ("reportMsgByUrl".equals(a4)) {
                return new com.qq.e.comm.plugin.q0.s.f<>(c(d4) + "");
            } else if ("network".equals(dVar.e())) {
                return new com.qq.e.comm.plugin.q0.u.g().a(hVar, dVar);
            } else {
                d1.a("Unsupported action " + a4);
                return new com.qq.e.comm.plugin.q0.s.f<>(null);
            }
        }
    }

    public int c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return 21;
        }
        int optInt = jSONObject.optInt("type");
        this.f45582c.put(Integer.valueOf(optInt), jSONObject.optString("reportUrl"));
        return 0;
    }

    public String c() {
        if (v0.e()) {
            int i4 = g.f45612a[com.qq.e.comm.plugin.d0.a.d().c().n().ordinal()];
            return i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? "unknown" : "wifi" : "2g" : "3g" : "4g";
        }
        return "none";
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<Integer, String> entry : this.f45582c.entrySet()) {
            try {
                jSONObject.put(entry.getKey() + "", entry.getValue());
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return jSONObject;
    }

    private void a(com.qq.e.comm.plugin.q0.s.g gVar, String str) {
        gVar.a(new com.qq.e.comm.plugin.q0.s.e(new com.qq.e.comm.plugin.q0.s.d(str), e.a.f45548c, "", 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.qq.e.comm.plugin.q0.s.g gVar, String str, int i4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", i4);
        } catch (JSONException e4) {
            d1.a(e4.getMessage(), e4);
        }
        gVar.a(new com.qq.e.comm.plugin.q0.s.e(new com.qq.e.comm.plugin.q0.s.d(str), e.a.f45548c, jSONObject));
    }

    private void a(com.qq.e.comm.plugin.q0.s.g gVar) {
        this.f45583d = gVar;
        if (this.f45580a.compareAndSet(false, true)) {
            k.e().a(this.f45586g);
        }
    }

    private void a(com.qq.e.comm.plugin.q0.s.g gVar, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String remove = this.f45581b.remove(str);
        if (!TextUtils.isEmpty(remove)) {
            a(gVar, remove);
        }
        this.f45581b.put(str, str2);
    }

    private void a(Context context, com.qq.e.comm.plugin.i.d0.c cVar, String str, boolean z3) {
        p0.a((Runnable) new RunnableC0879e(context, cVar, z3));
    }
}
