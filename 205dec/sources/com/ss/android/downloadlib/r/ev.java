package com.ss.android.downloadlib.r;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import cn.jpush.android.local.JPushConstants;
import com.bytedance.pangle.sdk.component.log.impl.net.EventNetApiImpl;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ss.android.download.api.config.s;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ev {
    private static void ev(Context context, com.ss.android.downloadlib.addownload.w.ux uxVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.c(str, uxVar.f48722c, "need_comment");
        } catch (Exception unused) {
            com.ss.android.downloadlib.w.c.c(c(context, Uri.parse("market://details?id=" + str)), uxVar, true);
            w(uxVar, jSONObject, 9, 8, "market://details?id=" + str);
        }
    }

    private static void f(Context context, com.ss.android.downloadlib.addownload.w.ux uxVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.c(str, uxVar.f48722c);
        } catch (Exception unused) {
            com.ss.android.downloadlib.w.c.c(c(context, Uri.parse("market://details?id=" + str)), uxVar, true);
            w(uxVar, jSONObject, 13, 10, "market://details?id=" + str);
        }
    }

    private static void r(final Context context, final com.ss.android.downloadlib.addownload.w.ux uxVar, final String str) {
        com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.r.ev.7
            @Override // java.lang.Runnable
            public void run() {
                JSONObject gd = com.ss.android.downloadlib.addownload.k.gd();
                String optString = gd.optString("s");
                final JSONObject jSONObject = new JSONObject();
                String c4 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("x"), optString);
                JSONObject jSONObject2 = new JSONObject();
                a.c(jSONObject2, "t", "v");
                a.c(jSONObject2, "p", str);
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.k.sr().c(c4, com.ss.android.downloadlib.addownload.k.s().c(bytes, bytes.length), EventNetApiImpl.CONTENT_TYPE_APPLICATION_STREAM, 0, new s() { // from class: com.ss.android.downloadlib.r.ev.7.1
                    @Override // com.ss.android.download.api.config.s
                    public void c(String str2) {
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        ev.w(context, str, str2, uxVar, jSONObject);
                    }

                    @Override // com.ss.android.download.api.config.s
                    public void c(Throwable th) {
                        Context context2 = context;
                        com.ss.android.downloadlib.w.c.c(ev.c(context2, Uri.parse("market://details?id=" + str)), uxVar, true);
                        a.c(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                        com.ss.android.downloadlib.addownload.w.ux uxVar2 = uxVar;
                        JSONObject jSONObject3 = jSONObject;
                        ev.w(uxVar2, jSONObject3, 7, 5, "market://details?id=" + str);
                    }
                });
            }
        });
    }

    private static com.ss.android.downloadlib.addownload.w.r sr(@NonNull Context context, @NonNull String str) {
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
            return new com.ss.android.downloadlib.addownload.w.r(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.w.r(6, 14);
        }
    }

    private static void ux(final Context context, final com.ss.android.downloadlib.addownload.w.ux uxVar, final String str) {
        com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.r.ev.6
            @Override // java.lang.Runnable
            public void run() {
                JSONObject gd = com.ss.android.downloadlib.addownload.k.gd();
                final JSONObject jSONObject = new JSONObject();
                try {
                    String optString = gd.optString("s");
                    String c4 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("bw"), optString);
                    String c5 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("bx"), optString);
                    String c6 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("by"), optString);
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme("https").authority(c4).appendPath(c5).appendQueryParameter(c6, str);
                    com.ss.android.downloadlib.addownload.k.sr().c("GET", builder.build().toString(), null, new s() { // from class: com.ss.android.downloadlib.r.ev.6.1
                        /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
                        /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
                        @Override // com.ss.android.download.api.config.s
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public void c(java.lang.String r6) {
                            /*
                                r5 = this;
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                r1 = 1
                                if (r0 != 0) goto L28
                                java.lang.String r6 = com.ss.android.downloadlib.r.ev.c(r6)
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                if (r0 != 0) goto L28
                                java.lang.String r6 = com.ss.android.downloadlib.r.ev.w(r6)
                                boolean r0 = android.text.TextUtils.isEmpty(r6)
                                if (r0 != 0) goto L28
                                com.ss.android.downloadlib.r.ev$6 r0 = com.ss.android.downloadlib.r.ev.AnonymousClass6.this
                                android.content.Context r2 = r2
                                com.ss.android.downloadlib.addownload.w.ux r3 = r3
                                java.lang.String r0 = r1
                                com.ss.android.downloadlib.r.ev.c(r2, r3, r0, r6)
                                r6 = 1
                                goto L29
                            L28:
                                r6 = 0
                            L29:
                                if (r6 != 0) goto L73
                                com.ss.android.downloadlib.r.ev$6 r6 = com.ss.android.downloadlib.r.ev.AnonymousClass6.this
                                android.content.Context r6 = r2
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                r0.<init>()
                                java.lang.String r2 = "market://details?id="
                                r0.append(r2)
                                com.ss.android.downloadlib.r.ev$6 r3 = com.ss.android.downloadlib.r.ev.AnonymousClass6.this
                                java.lang.String r3 = r1
                                r0.append(r3)
                                java.lang.String r0 = r0.toString()
                                android.net.Uri r0 = android.net.Uri.parse(r0)
                                com.ss.android.downloadlib.addownload.w.r r6 = com.ss.android.downloadlib.r.ev.c(r6, r0)
                                com.ss.android.downloadlib.r.ev$6 r0 = com.ss.android.downloadlib.r.ev.AnonymousClass6.this
                                com.ss.android.downloadlib.addownload.w.ux r0 = r3
                                com.ss.android.downloadlib.w.c.c(r6, r0, r1)
                                com.ss.android.downloadlib.r.ev$6 r6 = com.ss.android.downloadlib.r.ev.AnonymousClass6.this
                                com.ss.android.downloadlib.addownload.w.ux r6 = r3
                                org.json.JSONObject r0 = r2
                                r1 = 10
                                r3 = 9
                                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                                r4.<init>()
                                r4.append(r2)
                                com.ss.android.downloadlib.r.ev$6 r2 = com.ss.android.downloadlib.r.ev.AnonymousClass6.this
                                java.lang.String r2 = r1
                                r4.append(r2)
                                java.lang.String r2 = r4.toString()
                                com.ss.android.downloadlib.r.ev.c(r6, r0, r1, r3, r2)
                            L73:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.r.ev.AnonymousClass6.AnonymousClass1.c(java.lang.String):void");
                        }

                        @Override // com.ss.android.download.api.config.s
                        public void c(Throwable th) {
                            Context context2 = context;
                            com.ss.android.downloadlib.w.c.c(ev.c(context2, Uri.parse("market://details?id=" + str)), uxVar, true);
                            a.c(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : "null");
                            com.ss.android.downloadlib.addownload.w.ux uxVar2 = uxVar;
                            JSONObject jSONObject2 = jSONObject;
                            ev.w(uxVar2, jSONObject2, 11, 9, "market://details?id=" + str);
                        }
                    });
                } catch (Exception e4) {
                    e4.printStackTrace();
                    com.ss.android.downloadlib.addownload.w.ux uxVar2 = uxVar;
                    ev.w(uxVar2, jSONObject, 4, 9, "market://details?id=" + str);
                }
            }
        });
    }

    private static com.ss.android.downloadlib.addownload.w.r xv(Context context, com.ss.android.downloadlib.addownload.w.ux uxVar, String str) {
        Intent intent = new Intent(context, JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("dl", true);
        intent.putExtra("p", str);
        intent.putExtra("id", uxVar.f48722c);
        if (Build.VERSION.SDK_INT >= 29) {
            intent.putExtra("bk", "com.heytap.browser");
        } else if (a.ux(context, "com.android.browser")) {
            intent.putExtra("bk", "com.android.browser");
        } else if (a.ux(context, "com.coloros.browser")) {
            intent.putExtra("bk", "com.coloros.browser");
        } else {
            return c(context, Uri.parse("market://details?id=" + str));
        }
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.w.r(7, "am_kllk3");
        } catch (Throwable unused) {
            w(uxVar, jSONObject, 1, 3, "market://details?id=" + str);
            return c(context, Uri.parse("market://details?id=" + str));
        }
    }

    private static com.ss.android.downloadlib.addownload.w.r w(Context context, com.ss.android.downloadlib.addownload.w.ux uxVar, String str) {
        Intent intent = new Intent(context, JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("p", str);
        intent.putExtra("id", uxVar.f48722c);
        intent.putExtra("start_only_for_android", true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.w.r(7, "am_kllk2");
        } catch (Throwable unused) {
            w(uxVar, jSONObject, 1, 3, "market://details?id=" + str);
            return c(context, Uri.parse("market://details?id=" + str));
        }
    }

    public static com.ss.android.downloadlib.addownload.w.r c(Context context, Uri uri) {
        Intent intent;
        if (!com.ss.android.socialbase.appdownloader.f.ux.xv() && (context == null || uri == null || !"market".equals(uri.getScheme()))) {
            return new com.ss.android.downloadlib.addownload.w.r(6, 12);
        }
        try {
            String p3 = com.ss.android.socialbase.appdownloader.f.ux.p();
            if (com.ss.android.socialbase.appdownloader.f.ux.ia() && (TextUtils.isEmpty(p3) || !a.ux(context, p3))) {
                p3 = "com.huawei.appmarket";
                Uri.Builder buildUpon = uri.buildUpon();
                buildUpon.scheme("market");
                intent = new Intent("android.intent.action.VIEW", buildUpon.build());
            } else {
                intent = new Intent("android.intent.action.VIEW", uri);
            }
            if (!a.c(context, intent)) {
                return new com.ss.android.downloadlib.addownload.w.r(6, 13);
            }
            if (a.ux(context, p3) && !com.ss.android.socialbase.appdownloader.f.ux.r()) {
                intent.setPackage(p3);
            }
            if (com.ss.android.socialbase.downloader.r.c.xv().c("fix_jump_market")) {
                intent.addFlags(335544320);
            } else if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (com.ss.android.socialbase.downloader.r.c.xv().w("test_jump_market_failed") == 1) {
                com.ss.android.downloadlib.ux.xv.c().c(false, "jump market error");
                return new com.ss.android.downloadlib.addownload.w.r(6, 25);
            }
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.w.r(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.w.r(6, 14);
        }
    }

    private static void sr(final Context context, final com.ss.android.downloadlib.addownload.w.ux uxVar, final String str) {
        com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.r.ev.5
            @Override // java.lang.Runnable
            public void run() {
                Context context2 = context;
                com.ss.android.downloadlib.w.c.c(ev.c(context2, Uri.parse("market://details?id=" + str)), uxVar, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject gd = com.ss.android.downloadlib.addownload.k.gd();
                    Thread.sleep(gd.optInt("m2_delay_millis", 1000));
                    com.ss.android.downloadlib.c.c.c.c().c(context, true);
                    com.ss.android.downloadlib.c.c.w wVar = new com.ss.android.downloadlib.c.c.w();
                    wVar.f48781c = 1;
                    wVar.f48783w = 0;
                    String c4 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("v"), gd.optString("s"));
                    wVar.xv = String.format(c4, str);
                    com.ss.android.downloadlib.c.c.c.c().c(wVar, (com.ss.android.downloadlib.c.c.sr) null);
                    com.ss.android.downloadlib.c.c.c.c().w();
                    ev.w(uxVar, jSONObject, -1, 2, String.format(c4, str));
                } catch (Throwable th) {
                    th.printStackTrace();
                    com.ss.android.downloadlib.addownload.w.ux uxVar2 = uxVar;
                    ev.w(uxVar2, jSONObject, 1, 2, "market://details?id=" + str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String sr(String str) {
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() > 0) {
            return pathSegments.get(pathSegments.size() - 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(Context context, String str, String str2, @NonNull com.ss.android.downloadlib.addownload.w.ux uxVar, @NonNull JSONObject jSONObject) {
        a.c(jSONObject, "ttdownloader_type", (Object) 5);
        try {
            String c4 = com.ss.android.socialbase.appdownloader.f.xv.c(new JSONObject(str2).optString("a"));
            if (!TextUtils.isEmpty(c4)) {
                TTDelegateActivity.c(str, uxVar.f48722c, c4, jSONObject);
            } else {
                com.ss.android.downloadlib.w.c.c(c(context, Uri.parse("market://details?id=" + str)), uxVar, true);
                w(uxVar, jSONObject, 5, 5, "market://details?id=" + str);
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.w.c.c(c(context, Uri.parse("market://details?id=" + str)), uxVar, true);
            w(uxVar, jSONObject, 6, 5, "market://details?id=" + str);
        }
    }

    public static boolean xv(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String p3 = com.ss.android.socialbase.appdownloader.f.ux.p();
        if (a.ux(com.ss.android.downloadlib.addownload.k.getContext(), p3)) {
            intent.setPackage(p3);
        }
        if (a.c(com.ss.android.downloadlib.addownload.k.getContext(), intent)) {
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e4) {
                com.ss.android.downloadlib.ux.xv.c().c(e4, "start HM2");
                return false;
            }
        }
        return false;
    }

    public static boolean w(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String p3 = com.ss.android.socialbase.appdownloader.f.ux.p();
        if (a.ux(com.ss.android.downloadlib.addownload.k.getContext(), p3)) {
            intent.setPackage(p3);
        }
        if (a.c(com.ss.android.downloadlib.addownload.k.getContext(), intent)) {
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e4) {
                com.ss.android.downloadlib.ux.xv.c().c(e4, "start HM1");
                return false;
            }
        }
        return false;
    }

    public static com.ss.android.downloadlib.addownload.w.r c(final Context context, Uri uri, com.ss.android.downloadlib.addownload.w.ux uxVar) {
        com.ss.android.downloadad.api.c.w wVar;
        if (context != null && com.ss.android.downloadlib.w.p.c(uri)) {
            try {
                final Intent intent = new Intent("android.intent.action.VIEW", uri);
                if (!a.c(context, intent)) {
                    return new com.ss.android.downloadlib.addownload.w.r(6, 13);
                }
                String p3 = com.ss.android.socialbase.appdownloader.f.ux.p();
                if (a.ux(context, p3)) {
                    intent.setPackage(p3);
                }
                intent.addFlags(335544320);
                if (com.ss.android.socialbase.downloader.r.c.xv().w("test_jump_market_failed") == 1 && "local_test".equals(com.ss.android.downloadlib.addownload.k.p().xv)) {
                    com.ss.android.downloadlib.ux.xv.c().c(false, "jump market error");
                    return new com.ss.android.downloadlib.addownload.w.r(6, 25);
                }
                intent.putExtra("start_only_for_android", true);
                long optLong = com.ss.android.downloadlib.addownload.k.gd().optLong("market_jump_delay", 1000L);
                if (optLong > 0 && uxVar != null && (wVar = uxVar.ux) != null && !wVar.fm()) {
                    com.ss.android.downloadlib.r.c().w().post(new Runnable() { // from class: com.ss.android.downloadlib.r.ev.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.downloadlib.addownload.k.xv().c(8, com.ss.android.downloadlib.addownload.k.getContext(), null, "\u6d4f\u89c8\u5668\u8df3\u8f6c\u5931\u8d25\uff0c\u6b63\u5728\u524d\u5f80\u5e94\u7528\u5546\u5e97", null, 0);
                        }
                    });
                }
                com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.r.ev.2
                    @Override // java.lang.Runnable
                    public void run() {
                        context.startActivity(intent);
                    }
                }, optLong);
                return new com.ss.android.downloadlib.addownload.w.r(5);
            } catch (Exception unused) {
                return new com.ss.android.downloadlib.addownload.w.r(6, 14);
            }
        }
        return new com.ss.android.downloadlib.addownload.w.r(6, 12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean xv(Context context, String str) {
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
    public static void w(com.ss.android.downloadlib.addownload.w.ux uxVar, JSONObject jSONObject, int i4, int i5, String str) {
        a.c(jSONObject, "error_code", Integer.valueOf(i4));
        a.c(jSONObject, "ttdownloader_type", Integer.valueOf(i5));
        a.c(jSONObject, "rmu", str);
        a.c(jSONObject, com.ss.android.socialbase.appdownloader.f.ux.p(), Integer.valueOf(a.w(com.ss.android.downloadlib.addownload.k.getContext(), com.ss.android.socialbase.appdownloader.f.ux.p())));
        com.ss.android.downloadlib.sr.c.c().w("am_result", jSONObject, uxVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ss.android.downloadlib.addownload.w.r w(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.w.r(4, 11);
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.k.getContext();
        }
        Intent r3 = a.r(context, str);
        if (r3 == null) {
            return new com.ss.android.downloadlib.addownload.w.r(4, 22);
        }
        r3.putExtra("start_only_for_android", true);
        try {
            context.startActivity(r3);
            return new com.ss.android.downloadlib.addownload.w.r(3);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.w.r(4, 23);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String xv(String str) {
        String[] split;
        String[] split2;
        Matcher matcher = Pattern.compile("<input[\\s\\S]*>\\n").matcher(str);
        String group = matcher.find() ? matcher.group() : "";
        if (!group.equals(null) && group.length() > 0) {
            for (String str2 : group.split("\\n")) {
                if (str2.startsWith("<input")) {
                    for (String str3 : str2.split("\\s")) {
                        if (str3.startsWith("value")) {
                            return str3.substring(7, str3.length() - 1);
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ss.android.downloadlib.addownload.w.r w(String str, @NonNull com.ss.android.downloadad.api.c.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.w.r(2, 21);
        }
        Context context = com.ss.android.downloadlib.addownload.k.getContext();
        Uri parse = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.addFlags(268435456);
        intent.putExtra("open_url", str);
        intent.putExtra("start_only_for_android", true);
        if (com.ss.android.socialbase.downloader.r.c.xv().c("fix_app_link_flag")) {
            intent.addFlags(TTAdConstant.KEY_CLICK_AREA);
        }
        if (a.w(context, intent)) {
            if (com.ss.android.downloadlib.addownload.k.gd().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.addownload.k.a() != null && com.ss.android.downloadlib.addownload.k.a().c() && Build.VERSION.SDK_INT >= 26 && cVar.ia()) {
                TTDelegateActivity.c(str, cVar);
            } else {
                try {
                    com.ss.android.downloadlib.addownload.k.getContext().startActivity(intent);
                } catch (Exception unused) {
                    return new com.ss.android.downloadlib.addownload.w.r(2);
                }
            }
            return new com.ss.android.downloadlib.addownload.w.r(1);
        }
        return new com.ss.android.downloadlib.addownload.w.r(2, 24);
    }

    public static com.ss.android.downloadlib.addownload.w.r c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.f.ux.r() && a.ux(context, "com.sec.android.app.samsungapps")) {
                return sr(context, str);
            }
            return c(context, com.ss.android.download.api.xv.c.c(str));
        }
        return new com.ss.android.downloadlib.addownload.w.r(6, 11);
    }

    public static com.ss.android.downloadlib.addownload.w.r c(Context context, com.ss.android.downloadlib.addownload.w.ux uxVar, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.f.ux.r() && a.ux(context, "com.sec.android.app.samsungapps")) {
                return sr(context, str);
            }
            if (uxVar.f48723w.isAd() && uxVar.sr.enableAM()) {
                JSONArray optJSONArray = com.ss.android.downloadlib.addownload.k.gd().optJSONArray("am_plans");
                if (com.ss.android.socialbase.appdownloader.f.ux.ux() && com.ss.android.socialbase.appdownloader.f.c.c(optJSONArray, "am_3")) {
                    return w(context, uxVar, str);
                }
                if (com.ss.android.socialbase.appdownloader.f.ux.f() && com.ss.android.socialbase.appdownloader.f.c.c(optJSONArray, "am_2")) {
                    sr(context, uxVar, str);
                    return new com.ss.android.downloadlib.addownload.w.r(7, "am_m2");
                } else if (com.ss.android.socialbase.appdownloader.f.ux.sr() && com.ss.android.socialbase.appdownloader.f.c.c(optJSONArray, "am_5")) {
                    r(context, uxVar, str);
                    return new com.ss.android.downloadlib.addownload.w.r(7, "am_v1");
                } else {
                    if (com.ss.android.socialbase.appdownloader.f.ux.ux() && com.ss.android.socialbase.appdownloader.f.c.c(optJSONArray, "am_7")) {
                        DownloadController downloadController = uxVar.sr;
                        if ((downloadController instanceof AdDownloadController) && ((AdDownloadController) downloadController).enableOppoAutoDownload()) {
                            return xv(context, uxVar, str);
                        }
                    }
                    if (com.ss.android.socialbase.appdownloader.f.ux.sr() && com.ss.android.socialbase.appdownloader.f.c.c(optJSONArray, "am_8") && a.c(a.xv(context, "com.bbk.appstore"), "8.7.2.0") >= 0) {
                        ev(context, uxVar, str);
                        return new com.ss.android.downloadlib.addownload.w.r(7, "am_v2");
                    } else if ((com.ss.android.socialbase.appdownloader.f.ux.c() || com.ss.android.socialbase.appdownloader.f.ux.w()) && com.ss.android.socialbase.appdownloader.f.c.c(optJSONArray, "am_9")) {
                        ux(context, uxVar, str);
                        return new com.ss.android.downloadlib.addownload.w.r(7, "am_hr");
                    } else if ((com.ss.android.socialbase.appdownloader.f.ux.c() || com.ss.android.socialbase.appdownloader.f.ux.w()) && com.ss.android.socialbase.appdownloader.f.c.c(optJSONArray, "am_10")) {
                        f(context, uxVar, str);
                        return new com.ss.android.downloadlib.addownload.w.r(7, "am_hr2");
                    } else {
                        return c(context, Uri.parse("market://details?id=" + str));
                    }
                }
            }
            return c(context, Uri.parse("market://details?id=" + str));
        }
        return new com.ss.android.downloadlib.addownload.w.r(6, 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(Context context, @NonNull com.ss.android.downloadlib.addownload.w.ux uxVar, @NonNull String str, @NonNull String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.w(str, uxVar.f48722c, str2);
        } catch (Exception unused) {
            com.ss.android.downloadlib.w.c.c(c(context, Uri.parse("market://details?id=" + str)), uxVar, true);
            w(uxVar, jSONObject, 12, 9, "market://details?id=" + str);
        }
    }

    public static void w(@NonNull Activity activity, String str, long j4, String str2) {
        com.ss.android.downloadlib.addownload.w.ux ux = com.ss.android.downloadlib.addownload.w.f.c().ux(j4);
        JSONObject jSONObject = new JSONObject();
        JSONObject gd = com.ss.android.downloadlib.addownload.k.gd();
        String optString = gd.optString("s");
        String c4 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("bz"), optString);
        String c5 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("ca"), optString);
        String c6 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("cb"), optString);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("hiapplink").authority("com.huawei.appmarket");
        if (!TextUtils.isEmpty(c4)) {
            builder.appendQueryParameter(c4, str2);
        }
        if (!TextUtils.isEmpty(c5) && !TextUtils.isEmpty(c6)) {
            builder.appendQueryParameter(c5, c6);
        }
        if (w(activity, builder.build())) {
            w(ux, jSONObject, -1, 9, "market://details?id=" + str);
            com.ss.android.downloadlib.w.c.c("am_hr", jSONObject, ux, true);
            return;
        }
        w(ux, jSONObject, 2, 9, "market://details?id=" + str);
        com.ss.android.downloadlib.w.c.c(c((Context) activity, Uri.parse("market://details?id=" + str)), ux, true);
    }

    public static boolean c(Context context, com.ss.android.downloadlib.addownload.w.ux uxVar, String str, JSONObject jSONObject, boolean z3, int i4) {
        a.c(jSONObject, "download_scene", Integer.valueOf(uxVar.u()));
        com.ss.android.downloadlib.sr.c.c().w("market_click_open", jSONObject, uxVar);
        com.ss.android.downloadlib.addownload.w.r c4 = c(context, Uri.parse(str));
        String c5 = a.c(c4.w(), "open_market");
        int type = c4.getType();
        if (type == 5) {
            com.ss.android.downloadlib.w.c.c(c5, jSONObject, uxVar, true);
        } else if (type == 6) {
            a.c(jSONObject, "error_code", Integer.valueOf(c4.c()));
            a.c(jSONObject, "download_scene", Integer.valueOf(uxVar.u()));
            com.ss.android.downloadlib.sr.c.c().w("market_open_failed", jSONObject, uxVar);
            return false;
        } else if (type != 7) {
            return false;
        }
        if (z3) {
            com.ss.android.downloadlib.sr.c.c().c(uxVar.f48722c, i4);
        }
        return true;
    }

    public static void c(Context context, String str, long j4, boolean z3) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.w.ux ux = com.ss.android.downloadlib.addownload.w.f.c().ux(j4);
        try {
            JSONObject gd = com.ss.android.downloadlib.addownload.k.gd();
            String optString = gd.optString("s");
            String c4 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("aa"), optString);
            String c5 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("ac"), optString);
            String c6 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("af"), optString);
            boolean c7 = com.ss.android.socialbase.appdownloader.f.c.c(gd, context, c5);
            StringBuilder sb = new StringBuilder(String.format(c4, str, c6, c5));
            Intent intent = new Intent("android.intent.action.VIEW");
            String p3 = com.ss.android.socialbase.appdownloader.f.ux.p();
            if (a.ux(context, p3)) {
                intent.setPackage(p3);
            }
            if (z3) {
                sb.append(com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("ae"), optString));
            } else {
                intent.addFlags(335544320);
            }
            a.c(jSONObject, "mf", Boolean.valueOf(c7));
            a.c(jSONObject, "if", Boolean.valueOf(z3));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra("start_only_for_android", true);
            context.startActivity(intent);
            com.ss.android.downloadlib.w.c.c("am_kllk2", jSONObject, ux, true);
            if (c7) {
                w(ux, jSONObject, -1, 3, sb.toString());
            } else {
                w(ux, jSONObject, 3, 3, sb.toString());
            }
        } catch (Exception unused) {
            Context context2 = com.ss.android.downloadlib.addownload.k.getContext();
            com.ss.android.downloadlib.w.c.c(c(context2, Uri.parse("market://details?id=" + str)), ux, true);
            w(ux, jSONObject, 2, 3, "market://details?id=" + str);
        }
    }

    public static void c(final Context context, String str, long j4, String str2, boolean z3) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.w.ux ux = com.ss.android.downloadlib.addownload.w.f.c().ux(j4);
        try {
            JSONObject gd = com.ss.android.downloadlib.addownload.k.gd();
            String optString = gd.optString("s");
            String c4 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("br"), optString);
            String c5 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("bs_1"), optString);
            String c6 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("bs_2"), optString);
            String c7 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("bs_3"), optString);
            String c8 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("bt"), optString);
            String c9 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("bu"), optString);
            StringBuilder sb = new StringBuilder(String.format(JPushConstants.HTTPS_PRE, new Object[0]));
            sb.append(c4);
            sb.append(c5);
            sb.append(c6);
            sb.append(c7);
            sb.append(c8);
            sb.append(c9);
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(str2);
            if (z3) {
                sb.append("pkg=" + str);
                sb.append("&dl=true");
            } else {
                intent.addFlags(335544320);
            }
            a.c(jSONObject, "dl", Boolean.valueOf(z3));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra("start_only_for_android", true);
            long optLong = com.ss.android.downloadlib.addownload.k.gd().optLong("oppo_browser_jump_delay", 1000L);
            if (optLong > 0) {
                com.ss.android.downloadlib.r.c().w().post(new Runnable() { // from class: com.ss.android.downloadlib.r.ev.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.ss.android.downloadlib.addownload.k.xv().c(12, com.ss.android.downloadlib.addownload.k.getContext(), null, "\u6b63\u5728\u524d\u5f80\u6d4f\u89c8\u5668\u4e0b\u8f7d", null, 0);
                    }
                });
            }
            com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.r.ev.4
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, optLong);
            com.ss.android.downloadad.api.c.w wVar = ux.ux;
            if (wVar != null) {
                wVar.q(true);
            }
            com.ss.android.downloadlib.w.c.c("am_kllk3", jSONObject, ux, true);
            w(ux, jSONObject, -1, 7, sb.toString());
        } catch (Exception unused) {
            com.ss.android.downloadad.api.c.w wVar2 = ux.ux;
            if (wVar2 != null) {
                wVar2.q(false);
            }
            Context context2 = com.ss.android.downloadlib.addownload.k.getContext();
            com.ss.android.downloadlib.w.c.c(c(context2, Uri.parse("market://details?id=" + str), ux), ux, true);
            w(ux, jSONObject, 2, 7, "market://details?id=" + str);
        }
    }

    private static boolean c(@NonNull Activity activity, @NonNull String str, @NonNull HashMap<String, String> hashMap) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("market://details?id=" + str));
        intent.putExtra("start_only_for_android", true);
        intent.putExtra("param", hashMap);
        String p3 = com.ss.android.socialbase.appdownloader.f.ux.p();
        if (a.ux(com.ss.android.downloadlib.addownload.k.getContext(), p3)) {
            intent.setPackage(p3);
        }
        if (a.c(com.ss.android.downloadlib.addownload.k.getContext(), intent)) {
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e4) {
                com.ss.android.downloadlib.ux.xv.c().c(e4, "start v1");
                return false;
            }
        }
        return false;
    }

    public static void c(@NonNull Activity activity, String str, long j4, String str2, String str3) {
        JSONObject jSONObject;
        int i4;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        com.ss.android.downloadlib.addownload.w.ux ux = com.ss.android.downloadlib.addownload.w.f.c().ux(j4);
        try {
            JSONObject gd = com.ss.android.downloadlib.addownload.k.gd();
            boolean c4 = com.ss.android.socialbase.appdownloader.f.c.c(gd, activity, com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("bg"), gd.optString("s")));
            HashMap<String, String> w3 = a.w(new JSONObject(str2));
            if (c4 && !w3.isEmpty() && c(activity, str, w3)) {
                w(ux, jSONObject, -1, 5, "market://details?id=" + str);
                com.ss.android.downloadlib.w.c.c("am_v1", jSONObject, ux, true);
                return;
            }
            if (c4) {
                i4 = w3.isEmpty() ? 1 : 2;
            } else {
                i4 = 3;
            }
            w(ux, jSONObject, i4, 5, "market://details?id=" + str);
            com.ss.android.downloadlib.w.c.c(c((Context) activity, Uri.parse("market://details?id=" + str)), ux, true);
        } catch (Exception unused2) {
            Context context = com.ss.android.downloadlib.addownload.k.getContext();
            com.ss.android.downloadlib.w.c.c(c(context, Uri.parse("market://details?id=" + str)), ux, true);
            w(ux, jSONObject, 4, 5, "market://details?id=" + str);
        }
    }

    public static void c(@NonNull Activity activity, String str, long j4, String str2) {
        com.ss.android.downloadlib.addownload.w.ux ux = com.ss.android.downloadlib.addownload.w.f.c().ux(j4);
        JSONObject jSONObject = new JSONObject();
        JSONObject gd = com.ss.android.downloadlib.addownload.k.gd();
        String c4 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("bv"), gd.optString("s"));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("market").authority(BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(c4)) {
            builder.appendQueryParameter(c4, str2);
        }
        if (c(activity, builder.build())) {
            w(ux, jSONObject, -1, 8, "market://details?id=" + str);
            com.ss.android.downloadlib.w.c.c("am_v2", jSONObject, ux, true);
            return;
        }
        w(ux, jSONObject, 2, 8, "market://details?id=" + str);
        com.ss.android.downloadlib.w.c.c(c((Context) activity, Uri.parse("market://details?id=" + str)), ux, true);
    }

    public static boolean c(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra("start_only_for_android", true);
        String p3 = com.ss.android.socialbase.appdownloader.f.ux.p();
        if (a.ux(com.ss.android.downloadlib.addownload.k.getContext(), p3)) {
            intent.setPackage(p3);
        }
        if (a.c(com.ss.android.downloadlib.addownload.k.getContext(), intent)) {
            try {
                activity.startActivity(intent);
                return true;
            } catch (Exception e4) {
                com.ss.android.downloadlib.ux.xv.c().c(e4, "start v2");
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ss.android.downloadlib.addownload.w.r c(Context context, String str, com.ss.android.downloadad.api.c.c cVar) {
        Intent r3 = a.r(context, str);
        if (r3 == null) {
            return new com.ss.android.downloadlib.addownload.w.r(4, 22);
        }
        if (Build.VERSION.SDK_INT >= 26 && com.ss.android.downloadlib.addownload.k.gd().optInt("open_package_mode") == 1 && com.ss.android.downloadlib.addownload.k.a() != null && com.ss.android.downloadlib.addownload.k.a().c() && cVar.ia()) {
            TTDelegateActivity.w(str, cVar);
            return new com.ss.android.downloadlib.addownload.w.r(3);
        }
        r3.putExtra("start_only_for_android", true);
        try {
            context.startActivity(r3);
            return new com.ss.android.downloadlib.addownload.w.r(3);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.w.r(4, 23);
        }
    }

    static com.ss.android.downloadlib.addownload.w.r c(String str, com.ss.android.downloadad.api.c.c cVar) {
        return c(com.ss.android.downloadlib.addownload.k.getContext(), str, cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static com.ss.android.downloadlib.addownload.w.r c(@NonNull com.ss.android.downloadad.api.c.w wVar, String str, String str2) {
        com.ss.android.downloadlib.addownload.w.r w3 = w(str, wVar);
        return (com.ss.android.downloadlib.w.f.c(wVar) && w3.getType() == 2) ? c(str2, wVar) : w3;
    }

    public static void c(@NonNull Activity activity, String str, long j4) {
        com.ss.android.downloadlib.addownload.w.ux ux = com.ss.android.downloadlib.addownload.w.f.c().ux(j4);
        JSONObject jSONObject = new JSONObject();
        JSONObject gd = com.ss.android.downloadlib.addownload.k.gd();
        String optString = gd.optString("s");
        String c4 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("ca"), optString);
        String c5 = com.ss.android.socialbase.appdownloader.f.xv.c(gd.optString("cc"), optString);
        StringBuilder sb = new StringBuilder("market://details?id=");
        if (!TextUtils.isEmpty(c4) && !TextUtils.isEmpty(c5)) {
            sb.append(str);
            sb.append("&");
            sb.append(c4);
            sb.append("=");
            sb.append(c5);
        }
        if (xv(activity, Uri.parse(sb.toString()))) {
            w(ux, jSONObject, -1, 10, "market://details?id=" + str);
            com.ss.android.downloadlib.w.c.c("am_hr2", jSONObject, ux, true);
            return;
        }
        w(ux, jSONObject, 2, 10, "market://details?id=" + str);
        com.ss.android.downloadlib.w.c.c(c((Context) activity, Uri.parse("market://details?id=" + str)), ux, true);
    }
}
