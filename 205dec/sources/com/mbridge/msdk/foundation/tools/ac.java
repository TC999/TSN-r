package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SameTool.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ac extends h {

    /* renamed from: q  reason: collision with root package name */
    private static Map<String, String> f39764q;

    /* renamed from: r  reason: collision with root package name */
    private static Map<String, String> f39765r;

    /* renamed from: a  reason: collision with root package name */
    private static char[] f39748a = {'A', 'p', 'p', 'l', 'i', 'c', 'a', 't', 'i', 'o', 'n', 'I', 'n', 'f', 'o'};

    /* renamed from: b  reason: collision with root package name */
    private static char[] f39749b = {'.', 'X'};

    /* renamed from: c  reason: collision with root package name */
    private static int f39750c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static int f39751d = 1;

    /* renamed from: e  reason: collision with root package name */
    private static int f39752e = 2;

    /* renamed from: f  reason: collision with root package name */
    private static int f39753f = 3;

    /* renamed from: g  reason: collision with root package name */
    private static int f39754g = 0;

    /* renamed from: h  reason: collision with root package name */
    private static int f39755h = 7;

    /* renamed from: i  reason: collision with root package name */
    private static int f39756i = 14;

    /* renamed from: j  reason: collision with root package name */
    private static int f39757j = 19;

    /* renamed from: k  reason: collision with root package name */
    private static int f39758k = 16;

    /* renamed from: l  reason: collision with root package name */
    private static int f39759l = 26;

    /* renamed from: m  reason: collision with root package name */
    private static String f39760m = "[\u4e00-\u9fa5]";

    /* renamed from: n  reason: collision with root package name */
    private static Pattern f39761n = Pattern.compile("[\u4e00-\u9fa5]");

    /* renamed from: o  reason: collision with root package name */
    private static int f39762o = 1;

    /* renamed from: p  reason: collision with root package name */
    private static boolean f39763p = true;

    /* renamed from: s  reason: collision with root package name */
    private static volatile Boolean f39766s = null;

    public static <T extends String> boolean a(T t3) {
        return t3 == null || t3.length() == 0;
    }

    public static boolean b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return "wifi".equals(activeNetworkInfo.getTypeName().toLowerCase(Locale.US));
            }
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static int c(int i4) {
        if ((i4 <= 100 || i4 >= 199) && i4 != 2) {
            if ((i4 <= 200 || i4 >= 299) && i4 != 4) {
                return (i4 <= 500 || i4 >= 599) ? -1 : 5;
            }
            return 2;
        }
        return 1;
    }

    public static boolean c(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static float d(Context context) {
        if (context != null) {
            try {
                float f4 = context.getResources().getDisplayMetrics().density;
                if (f4 == 0.0f) {
                    return 2.5f;
                }
                return f4;
            } catch (Exception e4) {
                e4.printStackTrace();
                return 2.5f;
            }
        }
        return 2.5f;
    }

    public static int e(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static float f(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int g(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return n(context).heightPixels;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static int h(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return n(context).widthPixels;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static int i(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static int j(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static int k(Context context) {
        if (context != null) {
            return 0;
        }
        try {
            if (context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") != 0) {
                return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return 0;
    }

    public static boolean l(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static int m(Context context) {
        PackageInfo packageInfo;
        if (context == null) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                packageInfo = WebView.getCurrentWebViewPackage();
            } else {
                packageInfo = context.getPackageManager().getPackageInfo("com.google.android.webview", 1);
            }
            com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
            if (b4 == null) {
                b4 = com.mbridge.msdk.c.b.a().b();
            }
            if (packageInfo == null || TextUtils.isEmpty(packageInfo.versionName) || !packageInfo.versionName.equals("77.0.3865.92")) {
                return b4.aX();
            }
            return 5;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static DisplayMetrics n(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics;
        } catch (Throwable th) {
            th.printStackTrace();
            return context.getResources().getDisplayMetrics();
        }
    }

    public static boolean a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            return !TextUtils.isEmpty(campaignEx.getDeepLinkURL());
        }
        return false;
    }

    public static int a(Context context, float f4) {
        float f5 = 2.5f;
        if (context != null) {
            try {
                float f6 = context.getResources().getDisplayMetrics().density;
                if (f6 != 0.0f) {
                    f5 = f6;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return (int) ((f4 / f5) + 0.5f);
    }

    public static Object d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return WXAPIFactory.class.getMethod("createWXAPI", Context.class, String.class).invoke(null, com.mbridge.msdk.foundation.controller.a.f().j(), str);
        } catch (ClassNotFoundException e4) {
            x.d("SameTools", e4.getMessage());
            return null;
        } catch (IllegalAccessException e5) {
            x.d("SameTools", e5.getMessage());
            return null;
        } catch (NoSuchMethodException e6) {
            x.d("SameTools", e6.getMessage());
            return null;
        } catch (InvocationTargetException e7) {
            x.d("SameTools", e7.getMessage());
            return null;
        }
    }

    public static final synchronized String f(String str) {
        String str2;
        int i4;
        int i5;
        boolean z3;
        boolean z4;
        Map<String, String> map;
        synchronized (ac.class) {
            try {
                str2 = com.mbridge.msdk.foundation.controller.a.f().k() + "_" + str;
                com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
                i4 = 3;
                if (b4 != null) {
                    boolean aH = b4.aH();
                    z4 = b4.aF();
                    i4 = Math.max(0, b4.aG());
                    z3 = aH;
                } else {
                    z3 = true;
                    z4 = false;
                }
            } catch (Exception e4) {
                x.d("SameTools", e4.getMessage());
            }
            if (z4 && i4 != 0) {
                if (z3 && (map = f39764q) != null && map.containsKey(str2)) {
                    return f39764q.get(str2);
                }
                StringBuilder sb = new StringBuilder("");
                StackTraceElement[] stackTrace = new Exception().getStackTrace();
                if (stackTrace != null && stackTrace.length > 0) {
                    List<String> a4 = a(stackTrace);
                    Collections.reverse(a4);
                    ArrayList arrayList = new ArrayList();
                    for (String str3 : a4) {
                        if (!str3.startsWith(MBridgeConstans.APPLICATION_STACK_COM_ANDROID) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_OS) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_APP) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_REFLECT_METHOD) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_VIEW) && !arrayList.contains(str3)) {
                            arrayList.add(str3);
                        }
                    }
                    int min = Math.min(arrayList.size(), i4);
                    if (min > 0) {
                        for (i5 = 0; i5 < min; i5++) {
                            sb.append((String) arrayList.get(i5));
                            if (i5 < min - 1) {
                                sb.append("|");
                            }
                        }
                    }
                    JSONObject jSONObject = null;
                    if (!TextUtils.isEmpty(sb.toString())) {
                        jSONObject = new JSONObject();
                        jSONObject.put("1", sb.toString());
                    }
                    if (jSONObject == null || jSONObject.length() <= 0) {
                        return "";
                    }
                    String a5 = a.a(jSONObject.toString());
                    if (z3 && !TextUtils.isEmpty(a5)) {
                        if (f39764q == null) {
                            f39764q = new HashMap();
                        }
                        f39764q.put(str2, a5);
                    }
                    return a5;
                }
                return "";
            }
            return "";
        }
    }

    public static String c(String str) {
        try {
            return ag.b(str) ? URLEncoder.encode(str, "utf-8") : "";
        } catch (Throwable th) {
            x.b("SameTools", th.getMessage(), th);
            return "";
        }
    }

    public static synchronized String g(String str) {
        synchronized (ac.class) {
            String str2 = com.mbridge.msdk.foundation.controller.a.f().k() + "_" + str;
            Map<String, String> map = f39765r;
            if (map == null || !map.containsKey(str2)) {
                return null;
            }
            return f39765r.get(str2);
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0052: MOVE  (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r2 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:29:0x0052 */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean h(java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L53
            r0 = 1
            if (r4 == 0) goto L45
            java.lang.String r2 = "dyview"
            java.lang.String r2 = r4.getQueryParameter(r2)     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L53
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L53
            if (r3 == 0) goto L21
            java.lang.String r2 = "view"
            java.lang.String r2 = r4.getQueryParameter(r2)     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L53
        L21:
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L46 java.lang.Throwable -> L53
            if (r3 != 0) goto L32
            r3 = -1
            int r3 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.Exception -> L2c java.lang.Throwable -> L53
        L2c:
            int r3 = r3 % 2
            if (r3 != 0) goto L32
            r2 = 1
            goto L33
        L32:
            r2 = 0
        L33:
            java.lang.String r3 = "natmp"
            java.lang.String r4 = r4.getQueryParameter(r3)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L52
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Exception -> L43 java.lang.Throwable -> L52
            if (r4 != 0) goto L41
            r1 = 1
            goto L45
        L41:
            r1 = r2
            goto L45
        L43:
            r4 = move-exception
            goto L48
        L45:
            return r1
        L46:
            r4 = move-exception
            r2 = 0
        L48:
            java.lang.String r0 = "SameTools"
            java.lang.String r4 = r4.getMessage()     // Catch: java.lang.Throwable -> L52
            com.mbridge.msdk.foundation.tools.x.d(r0, r4)     // Catch: java.lang.Throwable -> L52
            return r1
        L52:
            r1 = r2
        L53:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ac.h(java.lang.String):boolean");
    }

    public static boolean i(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            try {
                Uri parse = Uri.parse(str);
                if (parse != null) {
                    return !TextUtils.isEmpty(parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW));
                }
                return false;
            } catch (Exception e4) {
                x.d("SameTools", e4.getMessage());
                return false;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(MBridgeConstans.ENDCARD_URL_IS_PLAYABLE);
                if (TextUtils.isEmpty(queryParameter)) {
                    return false;
                }
                return queryParameter.equals("0");
            }
            return false;
        } catch (Exception e4) {
            x.d("SameTools", e4.getMessage());
            return false;
        }
    }

    public static int l(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW);
                if (TextUtils.isEmpty(queryParameter)) {
                    queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
                }
                if (TextUtils.isEmpty(queryParameter)) {
                    return -1;
                }
                try {
                    return Integer.parseInt(queryParameter);
                } catch (Exception unused) {
                    return -1;
                }
            }
            return -1;
        } catch (Exception e4) {
            x.d("SameTools", e4.getMessage());
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (r2 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002a, code lost:
        if (r2 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x002d, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long a(java.io.File r4) throws java.lang.Exception {
        /*
            r0 = 0
            r2 = 0
            boolean r3 = r4.exists()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L2a
            if (r3 == 0) goto L1a
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L2a
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L2a
            int r4 = r3.available()     // Catch: java.lang.Throwable -> L15 java.lang.Exception -> L18
            long r0 = (long) r4
            r2 = r3
            goto L1d
        L15:
            r4 = move-exception
            r2 = r3
            goto L24
        L18:
            r2 = r3
            goto L2a
        L1a:
            r4.createNewFile()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L2a
        L1d:
            if (r2 == 0) goto L2d
        L1f:
            r2.close()     // Catch: java.lang.Exception -> L2d
            goto L2d
        L23:
            r4 = move-exception
        L24:
            if (r2 == 0) goto L29
            r2.close()     // Catch: java.lang.Exception -> L29
        L29:
            throw r4
        L2a:
            if (r2 == 0) goto L2d
            goto L1f
        L2d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ac.a(java.io.File):long");
    }

    public static int b(Context context, float f4) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f4 * resources.getDisplayMetrics().density) + 0.5f);
    }

    public static boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_CAN_ANIM);
                if (TextUtils.isEmpty(queryParameter)) {
                    return false;
                }
                return queryParameter.equals("1");
            }
            return false;
        } catch (Exception e4) {
            x.d("SameTools", e4.getMessage());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c A[Catch: Exception -> 0x005f, LOOP:0: B:18:0x004a->B:19:0x004c, LOOP_END, TryCatch #0 {Exception -> 0x005f, blocks: (B:3:0x0002, B:5:0x0014, B:6:0x001c, B:8:0x0023, B:10:0x002a, B:12:0x0040, B:16:0x0046, B:19:0x004c, B:20:0x0054, B:22:0x005a), top: B:27:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(int r6) {
        /*
            java.lang.String r0 = ""
            com.mbridge.msdk.c.b r1 = com.mbridge.msdk.c.b.a()     // Catch: java.lang.Exception -> L5f
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.a.f()     // Catch: java.lang.Exception -> L5f
            java.lang.String r2 = r2.k()     // Catch: java.lang.Exception -> L5f
            com.mbridge.msdk.c.a r1 = r1.b(r2)     // Catch: java.lang.Exception -> L5f
            if (r1 != 0) goto L1c
            com.mbridge.msdk.c.b r1 = com.mbridge.msdk.c.b.a()     // Catch: java.lang.Exception -> L5f
            com.mbridge.msdk.c.a r1 = r1.b()     // Catch: java.lang.Exception -> L5f
        L1c:
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: java.lang.Exception -> L5f
            r2.<init>()     // Catch: java.lang.Exception -> L5f
            if (r1 == 0) goto L54
            int r1 = r1.ai()     // Catch: java.lang.Exception -> L5f
            r3 = 1
            if (r1 != r3) goto L54
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.a.f()     // Catch: java.lang.Exception -> L5f
            android.content.Context r1 = r1.j()     // Catch: java.lang.Exception -> L5f
            com.mbridge.msdk.foundation.db.i r1 = com.mbridge.msdk.foundation.db.i.a(r1)     // Catch: java.lang.Exception -> L5f
            com.mbridge.msdk.foundation.db.l r1 = com.mbridge.msdk.foundation.db.l.a(r1)     // Catch: java.lang.Exception -> L5f
            long[] r1 = r1.a()     // Catch: java.lang.Exception -> L5f
            if (r1 == 0) goto L54
            int r3 = r1.length     // Catch: java.lang.Exception -> L5f
            if (r3 <= r6) goto L49
            if (r6 != 0) goto L46
            goto L49
        L46:
            int r6 = r3 - r6
            goto L4a
        L49:
            r6 = 0
        L4a:
            if (r6 >= r3) goto L54
            r4 = r1[r6]     // Catch: java.lang.Exception -> L5f
            r2.put(r4)     // Catch: java.lang.Exception -> L5f
            int r6 = r6 + 1
            goto L4a
        L54:
            int r6 = r2.length()     // Catch: java.lang.Exception -> L5f
            if (r6 <= 0) goto L63
            java.lang.String r0 = a(r2)     // Catch: java.lang.Exception -> L5f
            goto L63
        L5f:
            r6 = move-exception
            r6.printStackTrace()
        L63:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ac.b(int):java.lang.String");
    }

    public static synchronized boolean c(Context context, String str) {
        boolean z3;
        synchronized (ac.class) {
            z3 = false;
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if (b(str, context) != null) {
                            z3 = true;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return z3;
    }

    public static int e(String str) {
        try {
            return ((Integer) IWXAPI.class.getMethod("getWXAppSupportAPI", new Class[0]).invoke(t.f(str), new Object[0])).intValue();
        } catch (Throwable th) {
            x.d("SameTools", th.getMessage());
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        if ((r6 + (r4 * 1000)) >= r8) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0071, code lost:
        if ((r6 + (r4.W() * 1000)) >= r8) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0074, code lost:
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
        if (r12 == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
        r3 = r3.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007b, code lost:
        if (r3 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0081, code lost:
        if (r3.size() <= 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0083, code lost:
        r2.addAll(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m(java.lang.String r17) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r17)
            java.lang.String r1 = ""
            if (r0 == 0) goto L9
            return r1
        L9:
            java.util.concurrent.ConcurrentHashMap r0 = com.mbridge.msdk.foundation.same.a.d.c(r17)
            if (r0 == 0) goto L9c
            int r2 = r0.size()
            if (r2 <= 0) goto L9c
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L22:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L87
            java.lang.Object r3 = r0.next()
            com.mbridge.msdk.foundation.entity.c r3 = (com.mbridge.msdk.foundation.entity.c) r3
            if (r3 == 0) goto L22
            long r4 = r3.d()
            long r6 = r3.e()
            long r8 = java.lang.System.currentTimeMillis()
            r10 = 0
            r12 = 1
            r13 = 0
            r14 = 1000(0x3e8, double:4.94E-321)
            int r16 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r16 <= 0) goto L4e
            long r4 = r4 * r14
            long r6 = r6 + r4
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 < 0) goto L74
            goto L75
        L4e:
            com.mbridge.msdk.c.b r4 = com.mbridge.msdk.c.b.a()
            com.mbridge.msdk.foundation.controller.a r5 = com.mbridge.msdk.foundation.controller.a.f()
            java.lang.String r5 = r5.k()
            com.mbridge.msdk.c.a r4 = r4.b(r5)
            if (r4 != 0) goto L68
            com.mbridge.msdk.c.b r4 = com.mbridge.msdk.c.b.a()
            com.mbridge.msdk.c.a r4 = r4.b()
        L68:
            long r4 = r4.W()
            long r4 = r4 * r14
            long r6 = r6 + r4
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 < 0) goto L74
            goto L75
        L74:
            r12 = 0
        L75:
            if (r12 == 0) goto L22
            java.util.List r3 = r3.c()
            if (r3 == 0) goto L22
            int r4 = r3.size()
            if (r4 <= 0) goto L22
            r2.addAll(r3)
            goto L22
        L87:
            int r0 = r2.size()
            if (r0 <= 0) goto L9c
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>(r2)
            r2.clear()
            r2.addAll(r0)
            java.lang.String r1 = r2.toString()
        L9c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.ac.m(java.lang.String):java.lang.String");
    }

    public static boolean c() {
        return !TextUtils.isEmpty(com.mbridge.msdk.foundation.controller.a.f().m());
    }

    public static int a() {
        int i4 = f39762o;
        f39762o = i4 + 1;
        return i4;
    }

    public static int d() {
        try {
            return ((Integer) com.tencent.mm.opensdk.constants.Build.class.getField("SDK_INT").get(null)).intValue();
        } catch (Throwable th) {
            x.d("SameTools", th.getMessage());
            return 0;
        }
    }

    public static String a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return "";
        }
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 == null) {
            b4 = com.mbridge.msdk.c.b.a().b();
        }
        int V = b4.V();
        if (jSONArray.length() > V) {
            JSONArray jSONArray2 = new JSONArray();
            for (int i4 = 0; i4 < V; i4++) {
                try {
                    jSONArray2.put(jSONArray.get(i4));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            return jSONArray2.toString();
        }
        return jSONArray.toString();
    }

    public static final int e() {
        if (f39766s == null) {
            try {
                f39766s = o.a.a().e();
            } catch (Exception e4) {
                x.d("SameTools", e4.getMessage());
            }
        }
        if (f39766s != null) {
            return f39766s.booleanValue() ? 1 : 0;
        }
        return -1;
    }

    private static final char[] d(int i4) {
        StringBuilder sb;
        if (i4 == 0) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(ab.f39747c, f39755h)));
            sb.append(f39749b[f39754g]);
            sb.append(String.valueOf(Arrays.copyOfRange(ab.f39747c, f39755h, f39756i)));
            sb.append(f39749b[f39754g]);
            sb.append(String.valueOf(Arrays.copyOfRange(ab.f39747c, f39756i, f39758k)));
            sb.append(f39749b[f39754g]);
            sb.append(String.valueOf(aa.f39740c));
        } else if (i4 == 1) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(ab.f39747c, f39755h)));
            sb.append(f39749b[f39754g]);
            sb.append(String.valueOf(Arrays.copyOfRange(ab.f39747c, f39755h, f39756i)));
            sb.append(f39749b[f39754g]);
            sb.append(String.valueOf(Arrays.copyOfRange(ab.f39747c, f39757j, f39759l)));
        } else if (i4 == 2) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(ab.f39747c, f39758k, f39757j)));
            sb.append(String.valueOf(f39748a));
        } else if (i4 != 3) {
            sb = null;
        } else {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(ab.f39747c, f39758k, f39757j)));
            sb.append(String.valueOf(aa.f39740c));
        }
        return sb.toString().toCharArray();
    }

    public static boolean b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                return campaignEx.getRetarget_offer() == 1;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return false;
    }

    public static double b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0.0d;
            }
            return Double.parseDouble(str);
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0.0d;
        }
    }

    public static boolean a(String str, Context context) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static List<String> b(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        String optString = jSONArray.optString(i4);
                        if (ag.b(optString)) {
                            arrayList.add(optString);
                        }
                    }
                    return arrayList;
                }
                return null;
            } catch (Throwable th) {
                x.b("SameTools", th.getMessage(), th);
                return null;
            }
        }
        return null;
    }

    public static int a(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof String) {
                    return Integer.parseInt((String) obj);
                }
                return 0;
            } catch (Throwable th) {
                x.b("SameTools", th.getMessage(), th);
                return 0;
            }
        }
        return 0;
    }

    public static double a(Double d4) {
        try {
            String format = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US)).format(d4);
            if (ag.b(format)) {
                return Double.parseDouble(format);
            }
            return 0.0d;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0.0d;
        }
    }

    public static boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static String b(Context context, String str) {
        String str2;
        str2 = "";
        try {
            JSONArray a4 = a(context, str);
            str2 = a4.length() > 0 ? a(a4) : "";
            x.b("SameTools", "get excludes:" + str2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return str2;
    }

    public static void a(View view) {
        if (view == null) {
            return;
        }
        try {
            view.setSystemUiVisibility(4102);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(ImageView imageView) {
        if (imageView == null) {
            return;
        }
        try {
            imageView.setImageResource(0);
            imageView.setImageDrawable(null);
            imageView.setImageURI(null);
            imageView.setImageBitmap(null);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
        }
    }

    private static Object b(String str, Context context) {
        try {
            return Class.forName(String.valueOf(d(f39750c))).getMethod(String.valueOf(d(f39752e)), String.class, Integer.TYPE).invoke(Class.forName(String.valueOf(d(f39751d))).getMethod(String.valueOf(d(f39753f)), new Class[0]).invoke(context, new Object[0]), str, 8192);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final String f() {
        return o.a.a().f();
    }

    public static JSONArray a(Context context, String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
            if (b4 == null) {
                b4 = com.mbridge.msdk.c.b.a().b();
            }
            if (b4 != null && b4.ai() == 1) {
                x.b("SameTools", "fqci cfc:" + b4.ai());
                long[] a4 = com.mbridge.msdk.foundation.db.l.a(com.mbridge.msdk.foundation.db.i.a(context)).a();
                if (a4 != null) {
                    for (long j4 : a4) {
                        x.b("SameTools", "cfc campaignIds:" + a4);
                        jSONArray.put(j4);
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return jSONArray;
    }

    public static void a(String str, CampaignEx campaignEx, int i4) {
        if (TextUtils.isEmpty(str) || campaignEx == null || com.mbridge.msdk.foundation.controller.a.f().j() == null) {
            return;
        }
        com.mbridge.msdk.foundation.db.k a4 = com.mbridge.msdk.foundation.db.k.a(com.mbridge.msdk.foundation.db.i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
        com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
        gVar.a(System.currentTimeMillis());
        gVar.b(str);
        gVar.a(campaignEx.getId());
        gVar.a(i4);
        a4.a(gVar);
    }

    private static synchronized String a(String str, Context context, String str2) {
        StringBuilder sb;
        String sb2;
        synchronized (ac.class) {
            try {
                Set<String> queryParameterNames = Uri.parse(str).getQueryParameterNames();
                if (queryParameterNames != null && queryParameterNames.size() > 0) {
                    sb = new StringBuilder("&rtins_type=");
                } else {
                    sb = new StringBuilder("?rtins_type=");
                }
            } catch (Exception unused) {
                sb = new StringBuilder("&rtins_type=");
            }
            try {
                if (b(str2, context) != null) {
                    sb.append(1);
                } else {
                    sb.append(2);
                }
            } catch (Exception unused2) {
                sb.append(0);
            }
            sb2 = sb.toString();
        }
        return sb2;
    }

    public static synchronized String a(Context context, String str, String str2) {
        String sb;
        synchronized (ac.class) {
            StringBuilder sb2 = new StringBuilder(str2);
            try {
                sb2.append(a(str2, context, str));
            } catch (Exception unused) {
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static synchronized void a(String str, String str2) {
        synchronized (ac.class) {
            if (f39765r == null) {
                f39765r = new HashMap();
            }
            f39765r.put(com.mbridge.msdk.foundation.controller.a.f().k() + "_" + str, str2);
        }
    }

    private static List<String> a(StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                arrayList.add(stackTraceElement.getClassName());
            }
        }
        return arrayList;
    }

    public static boolean a(JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0 || jSONObject.optInt("v", -1) != -1) ? false : true;
    }
}
