package com.p521ss.android.downloadlib.p534h;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.p521ss.android.download.api.config.InterfaceC11969td;
import com.p521ss.android.download.api.download.DownloadController;
import com.p521ss.android.downloadad.api.download.AdDownloadController;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok;
import com.p521ss.android.downloadlib.C12184h;
import com.p521ss.android.downloadlib.C12265s;
import com.p521ss.android.downloadlib.activity.JumpKllkActivity;
import com.p521ss.android.downloadlib.activity.TTDelegateActivity;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12031h;
import com.p521ss.android.downloadlib.addownload.p528a.C12032kf;
import com.p521ss.android.downloadlib.addownload.p528a.C12035n;
import com.p521ss.android.downloadlib.p527a.C12010k;
import com.p521ss.android.downloadlib.p527a.C12011kf;
import com.p521ss.android.downloadlib.p527a.C12018ok;
import com.p521ss.android.downloadlib.p536n.C12235bl;
import com.p521ss.android.downloadlib.p537ok.p538ok.C12246a;
import com.p521ss.android.downloadlib.p537ok.p538ok.C12251ok;
import com.p521ss.android.downloadlib.p537ok.p538ok.InterfaceC12254s;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12315bl;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12317n;
import com.p521ss.android.socialbase.appdownloader.p543kf.C12318ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.ccg.CcgConstant;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.h.p */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12205p {
    /* renamed from: bl */
    private static C12031h m18716bl(Context context, C12035n c12035n, String str) {
        Intent intent = new Intent(context, JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("dl", true);
        intent.putExtra("p", str);
        intent.putExtra("id", c12035n.f34079ok);
        if (Build.VERSION.SDK_INT >= 29) {
            intent.putExtra("bk", "com.heytap.browser");
        } else if (C12197j.m18796n(context, "com.android.browser")) {
            intent.putExtra("bk", "com.android.browser");
        } else if (C12197j.m18796n(context, "com.coloros.browser")) {
            intent.putExtra("bk", "com.coloros.browser");
        } else {
            return m18705ok(context, Uri.parse("market://details?id=" + str));
        }
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new C12031h(7, "am_kllk3");
        } catch (Throwable unused) {
            m18720a(c12035n, jSONObject, 1, 3, "market://details?id=" + str);
            return m18705ok(context, Uri.parse("market://details?id=" + str));
        }
    }

    /* renamed from: h */
    private static void m18713h(final Context context, final C12035n c12035n, final String str) {
        C12265s.m18554ok().m18553ok(new Runnable() { // from class: com.ss.android.downloadlib.h.p.7
            @Override // java.lang.Runnable
            public void run() {
                JSONObject m18946q = C12128r.m18946q();
                String optString = m18946q.optString("s");
                final JSONObject jSONObject = new JSONObject();
                String m18260ok = C12315bl.m18260ok(m18946q.optString("x"), optString);
                JSONObject jSONObject2 = new JSONObject();
                C12197j.m18778ok(jSONObject2, UMCommonContent.f37782aL, "v");
                C12197j.m18778ok(jSONObject2, "p", str);
                byte[] bytes = jSONObject2.toString().getBytes();
                C12128r.m18943s().mo19647ok(m18260ok, C12128r.m18941td().mo19636ok(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new InterfaceC11969td() { // from class: com.ss.android.downloadlib.h.p.7.1
                    @Override // com.p521ss.android.download.api.config.InterfaceC11969td
                    /* renamed from: ok */
                    public void mo18687ok(String str2) {
                        RunnableC122137 runnableC122137 = RunnableC122137.this;
                        C12205p.m18721a(context, str, str2, c12035n, jSONObject);
                    }

                    @Override // com.p521ss.android.download.api.config.InterfaceC11969td
                    /* renamed from: ok */
                    public void mo18686ok(Throwable th) {
                        Context context2 = context;
                        C12018ok.m19380ok(C12205p.m18705ok(context2, Uri.parse("market://details?id=" + str)), c12035n, true);
                        C12197j.m18778ok(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                        C12035n c12035n2 = c12035n;
                        JSONObject jSONObject3 = jSONObject;
                        C12205p.m18720a(c12035n2, jSONObject3, 7, 5, "market://details?id=" + str);
                    }
                });
            }
        });
    }

    /* renamed from: kf */
    private static void m18712kf(Context context, C12035n c12035n, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.m19349ok(str, c12035n.f34079ok);
        } catch (Exception unused) {
            C12018ok.m19380ok(m18705ok(context, Uri.parse("market://details?id=" + str)), c12035n, true);
            m18720a(c12035n, jSONObject, 13, 10, "market://details?id=" + str);
        }
    }

    /* renamed from: n */
    private static void m18711n(final Context context, final C12035n c12035n, final String str) {
        C12265s.m18554ok().m18553ok(new Runnable() { // from class: com.ss.android.downloadlib.h.p.6
            @Override // java.lang.Runnable
            public void run() {
                JSONObject m18946q = C12128r.m18946q();
                final JSONObject jSONObject = new JSONObject();
                try {
                    String optString = m18946q.optString("s");
                    String m18260ok = C12315bl.m18260ok(m18946q.optString("bw"), optString);
                    String m18260ok2 = C12315bl.m18260ok(m18946q.optString("bx"), optString);
                    String m18260ok3 = C12315bl.m18260ok(m18946q.optString("by"), optString);
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme("https").authority(m18260ok).appendPath(m18260ok2).appendQueryParameter(m18260ok3, str);
                    C12128r.m18943s().mo19648ok("GET", builder.build().toString(), null, new InterfaceC11969td() { // from class: com.ss.android.downloadlib.h.p.6.1
                        /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
                        /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
                        @Override // com.p521ss.android.download.api.config.InterfaceC11969td
                        /* renamed from: ok */
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public void mo18687ok(java.lang.String r6) {
                            /*
                                r5 = this;
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                r1 = 1
                                if (r0 != 0) goto L28
                                java.lang.String r6 = com.p521ss.android.downloadlib.p534h.C12205p.m18693ok(r6)
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                if (r0 != 0) goto L28
                                java.lang.String r6 = com.p521ss.android.downloadlib.p534h.C12205p.m18719a(r6)
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                if (r0 != 0) goto L28
                                com.ss.android.downloadlib.h.p$6 r0 = com.p521ss.android.downloadlib.p534h.C12205p.RunnableC122116.this
                                android.content.Context r2 = r2
                                com.ss.android.downloadlib.addownload.a.n r3 = r3
                                java.lang.String r0 = r1
                                com.p521ss.android.downloadlib.p534h.C12205p.m18702ok(r2, r3, r0, r6)
                                r6 = 1
                                goto L29
                            L28:
                                r6 = 0
                            L29:
                                if (r6 != 0) goto L73
                                com.ss.android.downloadlib.h.p$6 r6 = com.p521ss.android.downloadlib.p534h.C12205p.RunnableC122116.this
                                android.content.Context r6 = r2
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                r0.<init>()
                                java.lang.String r2 = "market://details?id="
                                r0.append(r2)
                                com.ss.android.downloadlib.h.p$6 r3 = com.p521ss.android.downloadlib.p534h.C12205p.RunnableC122116.this
                                java.lang.String r3 = r1
                                r0.append(r3)
                                java.lang.String r0 = r0.toString()
                                android.net.Uri r0 = android.net.Uri.parse(r0)
                                com.ss.android.downloadlib.addownload.a.h r6 = com.p521ss.android.downloadlib.p534h.C12205p.m18705ok(r6, r0)
                                com.ss.android.downloadlib.h.p$6 r0 = com.p521ss.android.downloadlib.p534h.C12205p.RunnableC122116.this
                                com.ss.android.downloadlib.addownload.a.n r0 = r3
                                com.p521ss.android.downloadlib.p527a.C12018ok.m19380ok(r6, r0, r1)
                                com.ss.android.downloadlib.h.p$6 r6 = com.p521ss.android.downloadlib.p534h.C12205p.RunnableC122116.this
                                com.ss.android.downloadlib.addownload.a.n r6 = r3
                                org.json.JSONObject r0 = r2
                                r1 = 10
                                r3 = 9
                                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                                r4.<init>()
                                r4.append(r2)
                                com.ss.android.downloadlib.h.p$6 r2 = com.p521ss.android.downloadlib.p534h.C12205p.RunnableC122116.this
                                java.lang.String r2 = r1
                                r4.append(r2)
                                java.lang.String r2 = r4.toString()
                                com.p521ss.android.downloadlib.p534h.C12205p.m18694ok(r6, r0, r1, r3, r2)
                            L73:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.downloadlib.p534h.C12205p.RunnableC122116.C122121.mo18687ok(java.lang.String):void");
                        }

                        @Override // com.p521ss.android.download.api.config.InterfaceC11969td
                        /* renamed from: ok */
                        public void mo18686ok(Throwable th) {
                            Context context2 = context;
                            C12018ok.m19380ok(C12205p.m18705ok(context2, Uri.parse("market://details?id=" + str)), c12035n, true);
                            C12197j.m18778ok(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                            C12035n c12035n2 = c12035n;
                            JSONObject jSONObject2 = jSONObject;
                            C12205p.m18720a(c12035n2, jSONObject2, 11, 9, "market://details?id=" + str);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    C12035n c12035n2 = c12035n;
                    C12205p.m18720a(c12035n2, jSONObject, 4, 9, "market://details?id=" + str);
                }
            }
        });
    }

    /* renamed from: p */
    private static void m18691p(Context context, C12035n c12035n, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.m19348ok(str, c12035n.f34079ok, "need_comment");
        } catch (Exception unused) {
            C12018ok.m19380ok(m18705ok(context, Uri.parse("market://details?id=" + str)), c12035n, true);
            m18720a(c12035n, jSONObject, 9, 8, "market://details?id=" + str);
        }
    }

    /* renamed from: s */
    private static C12031h m18689s(@NonNull Context context, @NonNull String str) {
        try {
            Uri parse = Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(parse);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new C12031h(5);
        } catch (Exception unused) {
            return new C12031h(6, 14);
        }
    }

    /* renamed from: a */
    private static C12031h m18724a(Context context, C12035n c12035n, String str) {
        Intent intent = new Intent(context, JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("p", str);
        intent.putExtra("id", c12035n.f34079ok);
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new C12031h(7, "am_kllk2");
        } catch (Throwable unused) {
            m18720a(c12035n, jSONObject, 1, 3, "market://details?id=" + str);
            return m18705ok(context, Uri.parse("market://details?id=" + str));
        }
    }

    /* renamed from: ok */
    public static C12031h m18705ok(Context context, Uri uri) {
        if (!C12317n.m18244bl() && (context == null || uri == null || !"market".equals(uri.getScheme()))) {
            return new C12031h(6, 12);
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!C12197j.m18791ok(context, intent)) {
                return new C12031h(6, 13);
            }
            String m18239k = C12317n.m18239k();
            if (C12197j.m18796n(context, m18239k) && !C12317n.m18242h()) {
                intent.setPackage(m18239k);
            }
            if (C12534ok.m17605bl().m17595ok("fix_jump_market")) {
                intent.addFlags(335544320);
            } else if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (C12534ok.m17605bl().m17607a("test_jump_market_failed") == 1) {
                C12235bl.m18640ok().m18636ok(false, "jump market error");
                return new C12031h(6, 25);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new C12031h(5);
        } catch (Exception unused) {
            return new C12031h(6, 14);
        }
    }

    /* renamed from: s */
    private static void m18690s(final Context context, final C12035n c12035n, final String str) {
        C12265s.m18554ok().m18553ok(new Runnable() { // from class: com.ss.android.downloadlib.h.p.5
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                C12018ok.m19380ok(C12205p.m18705ok(context2, Uri.parse("market://details?id=" + str)), c12035n, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject m18946q = C12128r.m18946q();
                    Thread.sleep(m18946q.optInt("m2_delay_millis", 1000));
                    C12251ok.m18593ok().m18591ok(context, true);
                    C12246a c12246a = new C12246a();
                    c12246a.f34545ok = 1;
                    c12246a.f34541a = 0;
                    String m18260ok = C12315bl.m18260ok(m18946q.optString("v"), m18946q.optString("s"));
                    c12246a.f34542bl = String.format(m18260ok, str);
                    C12251ok.m18593ok().m18590ok(c12246a, (InterfaceC12254s) null);
                    C12251ok.m18593ok().m18595a();
                    C12205p.m18720a(c12035n, jSONObject, -1, 2, String.format(m18260ok, str));
                } catch (Throwable th) {
                    th.printStackTrace();
                    C12035n c12035n2 = c12035n;
                    C12205p.m18720a(c12035n2, jSONObject, 1, 2, "market://details?id=" + str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m18721a(Context context, String str, String str2, @NonNull C12035n c12035n, @NonNull JSONObject jSONObject) {
        C12197j.m18778ok(jSONObject, "ttdownloader_type", (Object) 5);
        try {
            String m18261ok = C12315bl.m18261ok(new JSONObject(str2).optString("a"));
            if (!TextUtils.isEmpty(m18261ok)) {
                TTDelegateActivity.m19347ok(str, c12035n.f34079ok, m18261ok, jSONObject);
            } else {
                C12018ok.m19380ok(m18705ok(context, Uri.parse("market://details?id=" + str)), c12035n, true);
                m18720a(c12035n, jSONObject, 5, 5, "market://details?id=" + str);
            }
        } catch (Exception unused) {
            C12018ok.m19380ok(m18705ok(context, Uri.parse("market://details?id=" + str)), c12035n, true);
            m18720a(c12035n, jSONObject, 6, 5, "market://details?id=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public static String m18688s(String str) {
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() > 0) {
            return pathSegments.get(pathSegments.size() - 1);
        }
        return null;
    }

    /* renamed from: bl */
    public static boolean m18717bl(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String m18239k = C12317n.m18239k();
        if (C12197j.m18796n(C12128r.getContext(), m18239k)) {
            intent.setPackage(m18239k);
        }
        if (C12197j.m18791ok(C12128r.getContext(), intent)) {
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e) {
                C12235bl.m18640ok().mo18637ok(e, "start HM2");
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m18726a(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String m18239k = C12317n.m18239k();
        if (C12197j.m18796n(C12128r.getContext(), m18239k)) {
            intent.setPackage(m18239k);
        }
        if (C12197j.m18791ok(C12128r.getContext(), intent)) {
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e) {
                C12235bl.m18640ok().mo18637ok(e, "start HM1");
                return false;
            }
        }
        return false;
    }

    /* renamed from: ok */
    public static C12031h m18704ok(final Context context, Uri uri, C12035n c12035n) {
        C11998a c11998a;
        if (context != null && C12010k.m19405ok(uri)) {
            try {
                final Intent intent = new Intent("android.intent.action.VIEW", uri);
                if (!C12197j.m18791ok(context, intent)) {
                    return new C12031h(6, 13);
                }
                String m18239k = C12317n.m18239k();
                if (C12197j.m18796n(context, m18239k)) {
                    intent.setPackage(m18239k);
                }
                intent.addFlags(335544320);
                if (C12534ok.m17605bl().m17607a("test_jump_market_failed") == 1 && "local_test".equals(C12128r.m18963k().f33907bl)) {
                    C12235bl.m18640ok().m18636ok(false, "jump market error");
                    return new C12031h(6, 25);
                }
                intent.putExtra("start_only_for_android", true);
                long optLong = C12128r.m18946q().optLong("market_jump_delay", 1000L);
                if (optLong > 0 && c12035n != null && (c11998a = c12035n.f34078n) != null && !c11998a.m19444to()) {
                    C12184h.m18835ok().m18841a().post(new Runnable() { // from class: com.ss.android.downloadlib.h.p.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C12128r.m18968bl().mo19528ok(8, C12128r.getContext(), null, "浏览器跳转失败，正在前往应用商店", null, 0);
                        }
                    });
                }
                C12265s.m18554ok().m18552ok(new Runnable() { // from class: com.ss.android.downloadlib.h.p.2
                    @Override // java.lang.Runnable
                    public void run() {
                        context.startActivity(intent);
                    }
                }, optLong);
                return new C12031h(5);
            } catch (Exception unused) {
                return new C12031h(6, 14);
            }
        }
        return new C12031h(6, 12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: bl */
    public static boolean m18715bl(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(268435456);
            intent.putExtra("open_url", str);
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m18720a(C12035n c12035n, JSONObject jSONObject, int i, int i2, String str) {
        C12197j.m18778ok(jSONObject, "error_code", Integer.valueOf(i));
        C12197j.m18778ok(jSONObject, "ttdownloader_type", Integer.valueOf(i2));
        C12197j.m18778ok(jSONObject, "rmu", str);
        C12197j.m18778ok(jSONObject, C12317n.m18239k(), Integer.valueOf(C12197j.m18806a(C12128r.getContext(), C12317n.m18239k())));
        C12270ok.m18539ok().m18540a("am_result", jSONObject, c12035n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C12031h m18722a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new C12031h(4, 11);
        }
        if (context == null) {
            context = C12128r.getContext();
        }
        Intent m18799h = C12197j.m18799h(context, str);
        if (m18799h == null) {
            return new C12031h(4, 22);
        }
        m18799h.putExtra("start_only_for_android", true);
        try {
            context.startActivity(m18799h);
            return new C12031h(3);
        } catch (Exception unused) {
            return new C12031h(4, 23);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bl */
    public static String m18714bl(String str) {
        String[] split;
        String[] split2;
        Matcher matcher = Pattern.compile("<input[\\s\\S]*>\\n").matcher(str);
        String group = matcher.find() ? matcher.group() : "";
        if (!group.equals(null) && group.length() > 0) {
            for (String str2 : group.split("\\n")) {
                if (str2.startsWith("<input")) {
                    for (String str3 : str2.split("\\s")) {
                        if (str3.startsWith(DomainCampaignEx.LOOPBACK_VALUE)) {
                            return str3.substring(7, str3.length() - 1);
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    /* renamed from: ok */
    public static C12031h m18700ok(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (C12317n.m18242h() && C12197j.m18796n(context, "com.sec.android.app.samsungapps")) {
                return m18689s(context, str);
            }
            return m18705ok(context, Uri.parse("market://details?id=" + str));
        }
        return new C12031h(6, 11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static C12031h m18718a(String str, @NonNull InterfaceC11999ok interfaceC11999ok) {
        if (TextUtils.isEmpty(str)) {
            return new C12031h(2, 21);
        }
        Context context = C12128r.getContext();
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.addFlags(268435456);
        intent.putExtra("open_url", str);
        intent.putExtra("start_only_for_android", true);
        if (C12534ok.m17605bl().m17595ok("fix_app_link_flag")) {
            intent.addFlags(67108864);
        }
        if (C12197j.m18807a(context, intent)) {
            if (C12128r.m18946q().optInt("open_url_mode") == 0 && C12128r.m18964j() != null && C12128r.m18964j().mo19656ok() && Build.VERSION.SDK_INT >= 26 && interfaceC11999ok.mo19288x()) {
                TTDelegateActivity.m19346ok(str, interfaceC11999ok);
            } else {
                try {
                    C12128r.getContext().startActivity(intent);
                } catch (Exception unused) {
                    return new C12031h(2);
                }
            }
            return new C12031h(1);
        }
        return new C12031h(2, 24);
    }

    /* renamed from: ok */
    public static C12031h m18703ok(Context context, C12035n c12035n, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (C12317n.m18242h() && C12197j.m18796n(context, "com.sec.android.app.samsungapps")) {
                return m18689s(context, str);
            }
            if (c12035n.f34076a.isAd() && c12035n.f34080s.enableAM()) {
                JSONArray optJSONArray = C12128r.m18946q().optJSONArray("am_plans");
                if (C12317n.m18237n() && C12318ok.m18217ok(optJSONArray, "am_3")) {
                    return m18724a(context, c12035n, str);
                }
                if (C12317n.m18238kf() && C12318ok.m18217ok(optJSONArray, "am_2")) {
                    m18690s(context, c12035n, str);
                    return new C12031h(7, "am_m2");
                } else if (C12317n.m18230s() && C12318ok.m18217ok(optJSONArray, "am_5")) {
                    m18713h(context, c12035n, str);
                    return new C12031h(7, "am_v1");
                } else {
                    if (C12317n.m18237n() && C12318ok.m18217ok(optJSONArray, "am_7")) {
                        DownloadController downloadController = c12035n.f34080s;
                        if ((downloadController instanceof AdDownloadController) && ((AdDownloadController) downloadController).enableOppoAutoDownload()) {
                            return m18716bl(context, c12035n, str);
                        }
                    }
                    if (C12317n.m18230s() && C12318ok.m18217ok(optJSONArray, "am_8") && C12197j.m18781ok(C12197j.m18801bl(context, "com.bbk.appstore"), "8.7.2.0") >= 0) {
                        m18691p(context, c12035n, str);
                        return new C12031h(7, "am_v2");
                    } else if ((C12317n.m18236ok() || C12317n.m18246a()) && C12318ok.m18217ok(optJSONArray, "am_9")) {
                        m18711n(context, c12035n, str);
                        return new C12031h(7, "am_hr");
                    } else if ((C12317n.m18236ok() || C12317n.m18246a()) && C12318ok.m18217ok(optJSONArray, "am_10")) {
                        m18712kf(context, c12035n, str);
                        return new C12031h(7, "am_hr2");
                    } else {
                        return m18705ok(context, Uri.parse("market://details?id=" + str));
                    }
                }
            }
            return m18705ok(context, Uri.parse("market://details?id=" + str));
        }
        return new C12031h(6, 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m18723a(Context context, @NonNull C12035n c12035n, @NonNull String str, @NonNull String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.m19365a(str, c12035n.f34079ok, str2);
        } catch (Exception unused) {
            C12018ok.m19380ok(m18705ok(context, Uri.parse("market://details?id=" + str)), c12035n, true);
            m18720a(c12035n, jSONObject, 12, 9, "market://details?id=" + str);
        }
    }

    /* renamed from: a */
    public static void m18725a(@NonNull Activity activity, String str, long j, String str2) {
        C12035n m19325n = C12032kf.m19324ok().m19325n(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject m18946q = C12128r.m18946q();
        String optString = m18946q.optString("s");
        String m18260ok = C12315bl.m18260ok(m18946q.optString("bz"), optString);
        String m18260ok2 = C12315bl.m18260ok(m18946q.optString("ca"), optString);
        String m18260ok3 = C12315bl.m18260ok(m18946q.optString("cb"), optString);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("hiapplink").authority("com.huawei.appmarket");
        if (!TextUtils.isEmpty(m18260ok)) {
            builder.appendQueryParameter(m18260ok, str2);
        }
        if (!TextUtils.isEmpty(m18260ok2) && !TextUtils.isEmpty(m18260ok3)) {
            builder.appendQueryParameter(m18260ok2, m18260ok3);
        }
        if (m18726a(activity, builder.build())) {
            m18720a(m19325n, jSONObject, -1, 9, "market://details?id=" + str);
            C12018ok.m19374ok("am_hr", jSONObject, m19325n, true);
            return;
        }
        m18720a(m19325n, jSONObject, 2, 9, "market://details?id=" + str);
        C12018ok.m19380ok(m18705ok((Context) activity, Uri.parse("market://details?id=" + str)), m19325n, true);
    }

    /* renamed from: ok */
    public static boolean m18701ok(Context context, C12035n c12035n, String str, JSONObject jSONObject, boolean z, int i) {
        C12197j.m18778ok(jSONObject, "download_scene", Integer.valueOf(c12035n.mo19290u()));
        C12270ok.m18539ok().m18540a("market_click_open", jSONObject, c12035n);
        C12031h m18705ok = m18705ok(context, Uri.parse(str));
        String m18774ok = C12197j.m18774ok(m18705ok.m19335a(), "open_market");
        int type = m18705ok.getType();
        if (type == 5) {
            C12018ok.m19374ok(m18774ok, jSONObject, c12035n, true);
        } else if (type == 6) {
            C12197j.m18778ok(jSONObject, "error_code", Integer.valueOf(m18705ok.m19334ok()));
            C12197j.m18778ok(jSONObject, "download_scene", Integer.valueOf(c12035n.mo19290u()));
            C12270ok.m18539ok().m18540a("market_open_failed", jSONObject, c12035n);
            return false;
        } else if (type != 7) {
            return false;
        }
        if (z) {
            C12270ok.m18539ok().m18537ok(c12035n.f34079ok, i);
        }
        return true;
    }

    /* renamed from: ok */
    public static void m18698ok(Context context, String str, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        C12035n m19325n = C12032kf.m19324ok().m19325n(j);
        try {
            JSONObject m18946q = C12128r.m18946q();
            String optString = m18946q.optString("s");
            String m18260ok = C12315bl.m18260ok(m18946q.optString("aa"), optString);
            String m18260ok2 = C12315bl.m18260ok(m18946q.optString("ac"), optString);
            String m18260ok3 = C12315bl.m18260ok(m18946q.optString("af"), optString);
            boolean m18214ok = C12318ok.m18214ok(m18946q, context, m18260ok2);
            StringBuilder sb = new StringBuilder(String.format(m18260ok, str, m18260ok3, m18260ok2));
            Intent intent = new Intent("android.intent.action.VIEW");
            String m18239k = C12317n.m18239k();
            if (C12197j.m18796n(context, m18239k)) {
                intent.setPackage(m18239k);
            }
            if (z) {
                sb.append(C12315bl.m18260ok(m18946q.optString("ae"), optString));
            } else {
                intent.addFlags(335544320);
            }
            C12197j.m18778ok(jSONObject, "mf", Boolean.valueOf(m18214ok));
            C12197j.m18778ok(jSONObject, "if", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            C12018ok.m19374ok("am_kllk2", jSONObject, m19325n, true);
            if (m18214ok) {
                m18720a(m19325n, jSONObject, -1, 3, sb.toString());
            } else {
                m18720a(m19325n, jSONObject, 3, 3, sb.toString());
            }
        } catch (Exception unused) {
            Context context2 = C12128r.getContext();
            C12018ok.m19380ok(m18705ok(context2, Uri.parse("market://details?id=" + str)), m19325n, true);
            m18720a(m19325n, jSONObject, 2, 3, "market://details?id=" + str);
        }
    }

    /* renamed from: ok */
    public static void m18699ok(final Context context, String str, long j, String str2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        C12035n m19325n = C12032kf.m19324ok().m19325n(j);
        try {
            JSONObject m18946q = C12128r.m18946q();
            String optString = m18946q.optString("s");
            String m18260ok = C12315bl.m18260ok(m18946q.optString("br"), optString);
            String m18260ok2 = C12315bl.m18260ok(m18946q.optString("bs_1"), optString);
            String m18260ok3 = C12315bl.m18260ok(m18946q.optString("bs_2"), optString);
            String m18260ok4 = C12315bl.m18260ok(m18946q.optString("bs_3"), optString);
            String m18260ok5 = C12315bl.m18260ok(m18946q.optString("bt"), optString);
            String m18260ok6 = C12315bl.m18260ok(m18946q.optString("bu"), optString);
            StringBuilder sb = new StringBuilder(String.format("https://", new Object[0]));
            sb.append(m18260ok);
            sb.append(m18260ok2);
            sb.append(m18260ok3);
            sb.append(m18260ok4);
            sb.append(m18260ok5);
            sb.append(m18260ok6);
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(str2);
            if (z) {
                sb.append("pkg=" + str);
                sb.append("&dl=true");
            } else {
                intent.addFlags(335544320);
            }
            C12197j.m18778ok(jSONObject, "dl", Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra("start_only_for_android", true);
            long optLong = C12128r.m18946q().optLong("oppo_browser_jump_delay", 1000L);
            if (optLong > 0) {
                C12184h.m18835ok().m18841a().post(new Runnable() { // from class: com.ss.android.downloadlib.h.p.3
                    @Override // java.lang.Runnable
                    public void run() {
                        C12128r.m18968bl().mo19528ok(12, C12128r.getContext(), null, "正在前往浏览器下载", null, 0);
                    }
                });
            }
            C12265s.m18554ok().m18552ok(new Runnable() { // from class: com.ss.android.downloadlib.h.p.4
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, optLong);
            C11998a c11998a = m19325n.f34078n;
            if (c11998a != null) {
                c11998a.m19441ul(true);
            }
            C12018ok.m19374ok("am_kllk3", jSONObject, m19325n, true);
            m18720a(m19325n, jSONObject, -1, 7, sb.toString());
        } catch (Exception unused) {
            C11998a c11998a2 = m19325n.f34078n;
            if (c11998a2 != null) {
                c11998a2.m19441ul(false);
            }
            Context context2 = C12128r.getContext();
            C12018ok.m19380ok(m18704ok(context2, Uri.parse("market://details?id=" + str), m19325n), m19325n, true);
            m18720a(m19325n, jSONObject, 2, 7, "market://details?id=" + str);
        }
    }

    /* renamed from: ok */
    private static boolean m18706ok(@NonNull Activity activity, @NonNull String str, @NonNull HashMap<String, String> hashMap) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + str));
        intent.putExtra("start_only_for_android", true);
        intent.putExtra("param", hashMap);
        String m18239k = C12317n.m18239k();
        if (C12197j.m18796n(C12128r.getContext(), m18239k)) {
            intent.setPackage(m18239k);
        }
        if (C12197j.m18791ok(C12128r.getContext(), intent)) {
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e) {
                C12235bl.m18640ok().mo18637ok(e, "start v1");
                return false;
            }
        }
        return false;
    }

    /* renamed from: ok */
    public static void m18707ok(@NonNull Activity activity, String str, long j, String str2, String str3) {
        JSONObject jSONObject;
        int i;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        C12035n m19325n = C12032kf.m19324ok().m19325n(j);
        try {
            JSONObject m18946q = C12128r.m18946q();
            boolean m18214ok = C12318ok.m18214ok(m18946q, activity, C12315bl.m18260ok(m18946q.optString("bg"), m18946q.optString("s")));
            HashMap<String, String> m18803a = C12197j.m18803a(new JSONObject(str2));
            if (m18214ok && !m18803a.isEmpty() && m18706ok(activity, str, m18803a)) {
                m18720a(m19325n, jSONObject, -1, 5, "market://details?id=" + str);
                C12018ok.m19374ok("am_v1", jSONObject, m19325n, true);
                return;
            }
            if (m18214ok) {
                i = m18803a.isEmpty() ? 1 : 2;
            } else {
                i = 3;
            }
            m18720a(m19325n, jSONObject, i, 5, "market://details?id=" + str);
            C12018ok.m19380ok(m18705ok((Context) activity, Uri.parse("market://details?id=" + str)), m19325n, true);
        } catch (Exception unused2) {
            Context context = C12128r.getContext();
            C12018ok.m19380ok(m18705ok(context, Uri.parse("market://details?id=" + str)), m19325n, true);
            m18720a(m19325n, jSONObject, 4, 5, "market://details?id=" + str);
        }
    }

    /* renamed from: ok */
    public static void m18708ok(@NonNull Activity activity, String str, long j, String str2) {
        C12035n m19325n = C12032kf.m19324ok().m19325n(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject m18946q = C12128r.m18946q();
        String m18260ok = C12315bl.m18260ok(m18946q.optString("bv"), m18946q.optString("s"));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("market").authority("details").appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(m18260ok)) {
            builder.appendQueryParameter(m18260ok, str2);
        }
        if (m18710ok(activity, builder.build())) {
            m18720a(m19325n, jSONObject, -1, 8, "market://details?id=" + str);
            C12018ok.m19374ok("am_v2", jSONObject, m19325n, true);
            return;
        }
        m18720a(m19325n, jSONObject, 2, 8, "market://details?id=" + str);
        C12018ok.m19380ok(m18705ok((Context) activity, Uri.parse("market://details?id=" + str)), m19325n, true);
    }

    /* renamed from: ok */
    public static boolean m18710ok(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String m18239k = C12317n.m18239k();
        if (C12197j.m18796n(C12128r.getContext(), m18239k)) {
            intent.setPackage(m18239k);
        }
        if (C12197j.m18791ok(C12128r.getContext(), intent)) {
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e) {
                C12235bl.m18640ok().mo18637ok(e, "start v2");
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public static C12031h m18697ok(Context context, String str, InterfaceC11999ok interfaceC11999ok) {
        Intent m18799h = C12197j.m18799h(context, str);
        if (m18799h == null) {
            return new C12031h(4, 22);
        }
        if (Build.VERSION.SDK_INT >= 26 && C12128r.m18946q().optInt("open_package_mode") == 1 && C12128r.m18964j() != null && C12128r.m18964j().mo19656ok() && interfaceC11999ok.mo19288x()) {
            TTDelegateActivity.m19364a(str, interfaceC11999ok);
            return new C12031h(3);
        }
        m18799h.putExtra("start_only_for_android", true);
        try {
            context.startActivity(m18799h);
            return new C12031h(3);
        } catch (Exception unused) {
            return new C12031h(4, 23);
        }
    }

    /* renamed from: ok */
    static C12031h m18692ok(String str, InterfaceC11999ok interfaceC11999ok) {
        return m18697ok(C12128r.getContext(), str, interfaceC11999ok);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public static C12031h m18695ok(@NonNull C11998a c11998a, String str, String str2) {
        C12031h m18718a = m18718a(str, c11998a);
        return (C12011kf.m19397ok(c11998a) && m18718a.getType() == 2) ? m18692ok(str2, c11998a) : m18718a;
    }

    /* renamed from: ok */
    public static void m18709ok(@NonNull Activity activity, String str, long j) {
        C12035n m19325n = C12032kf.m19324ok().m19325n(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject m18946q = C12128r.m18946q();
        String optString = m18946q.optString("s");
        String m18260ok = C12315bl.m18260ok(m18946q.optString("ca"), optString);
        String m18260ok2 = C12315bl.m18260ok(m18946q.optString(CcgConstant.f38530a), optString);
        StringBuilder sb = new StringBuilder("market://details?id=");
        if (!TextUtils.isEmpty(m18260ok) && !TextUtils.isEmpty(m18260ok2)) {
            sb.append(str);
            sb.append("&");
            sb.append(m18260ok);
            sb.append("=");
            sb.append(m18260ok2);
        }
        if (m18717bl(activity, Uri.parse(sb.toString()))) {
            m18720a(m19325n, jSONObject, -1, 10, "market://details?id=" + str);
            C12018ok.m19374ok("am_hr2", jSONObject, m19325n, true);
            return;
        }
        m18720a(m19325n, jSONObject, 2, 10, "market://details?id=" + str);
        C12018ok.m19380ok(m18705ok((Context) activity, Uri.parse("market://details?id=" + str)), m19325n, true);
    }
}
