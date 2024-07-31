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
import com.baidu.idl.face.platform.FaceEnvironment;
import com.github.mikephil.charting.utils.Utils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.FqInfo;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.p472db.FqInfoDao;
import com.mbridge.msdk.foundation.p472db.FrequenceDao;
import com.mbridge.msdk.foundation.tools.MIMManager;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.tencent.p562mm.opensdk.openapi.IWXAPI;
import com.tencent.p562mm.opensdk.openapi.WXAPIFactory;
import com.umeng.analytics.pro.CoreProtocolImpl;
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

/* renamed from: com.mbridge.msdk.foundation.tools.ac */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SameTool extends DomainSameTool {

    /* renamed from: q */
    private static Map<String, String> f30991q;

    /* renamed from: r */
    private static Map<String, String> f30992r;

    /* renamed from: a */
    private static char[] f30975a = {'A', 'p', 'p', 'l', 'i', 'c', 'a', 't', 'i', 'o', 'n', 'I', 'n', 'f', 'o'};

    /* renamed from: b */
    private static char[] f30976b = {'.', 'X'};

    /* renamed from: c */
    private static int f30977c = 0;

    /* renamed from: d */
    private static int f30978d = 1;

    /* renamed from: e */
    private static int f30979e = 2;

    /* renamed from: f */
    private static int f30980f = 3;

    /* renamed from: g */
    private static int f30981g = 0;

    /* renamed from: h */
    private static int f30982h = 7;

    /* renamed from: i */
    private static int f30983i = 14;

    /* renamed from: j */
    private static int f30984j = 19;

    /* renamed from: k */
    private static int f30985k = 16;

    /* renamed from: l */
    private static int f30986l = 26;

    /* renamed from: m */
    private static String f30987m = "[一-龥]";

    /* renamed from: n */
    private static Pattern f30988n = Pattern.compile("[一-龥]");

    /* renamed from: o */
    private static int f30989o = 1;

    /* renamed from: p */
    private static boolean f30990p = true;

    /* renamed from: s */
    private static volatile Boolean f30993s = null;

    /* renamed from: a */
    public static <T extends String> boolean m22012a(T t) {
        return t == null || t.length() == 0;
    }

    /* renamed from: b */
    public static boolean m22002b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return "wifi".equals(activeNetworkInfo.getTypeName().toLowerCase(Locale.US));
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: c */
    public static int m21994c(int i) {
        if ((i <= 100 || i >= 199) && i != 2) {
            if ((i <= 200 || i >= 299) && i != 4) {
                return (i <= 500 || i >= 599) ? -1 : 5;
            }
            return 2;
        }
        return 1;
    }

    /* renamed from: c */
    public static boolean m21993c(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: d */
    public static float m21988d(Context context) {
        if (context != null) {
            try {
                float f = context.getResources().getDisplayMetrics().density;
                if (f == 0.0f) {
                    return 2.5f;
                }
                return f;
            } catch (Exception e) {
                e.printStackTrace();
                return 2.5f;
            }
        }
        return 2.5f;
    }

    /* renamed from: e */
    public static int m21985e(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: f */
    public static float m21982f(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: g */
    public static int m21980g(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return m21966n(context).heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: h */
    public static int m21978h(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return m21966n(context).widthPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: i */
    public static int m21976i(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: j */
    public static int m21974j(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: k */
    public static int m21972k(Context context) {
        if (context != null) {
            return 0;
        }
        try {
            if (context.getResources().getIdentifier("config_showNavigationBar", "bool", FaceEnvironment.f8430OS) != 0) {
                return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", FaceEnvironment.f8430OS));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /* renamed from: l */
    public static boolean m21970l(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: m */
    public static int m21968m(Context context) {
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
            Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
            if (m23252b == null) {
                m23252b = SettingManager.m23261a().m23253b();
            }
            if (packageInfo == null || TextUtils.isEmpty(packageInfo.versionName) || !packageInfo.versionName.equals("77.0.3865.92")) {
                return m23252b.m23374aX();
            }
            return 5;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: n */
    private static DisplayMetrics m21966n(Context context) {
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

    /* renamed from: a */
    public static boolean m22016a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            return !TextUtils.isEmpty(campaignEx.getDeepLinkURL());
        }
        return false;
    }

    /* renamed from: a */
    public static int m22021a(Context context, float f) {
        float f2 = 2.5f;
        if (context != null) {
            try {
                float f3 = context.getResources().getDisplayMetrics().density;
                if (f3 != 0.0f) {
                    f2 = f3;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (int) ((f / f2) + 0.5f);
    }

    /* renamed from: d */
    public static Object m21987d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return WXAPIFactory.class.getMethod("createWXAPI", Context.class, String.class).invoke(null, MBSDKContext.m22865f().m22861j(), str);
        } catch (ClassNotFoundException e) {
            SameLogTool.m21733d("SameTools", e.getMessage());
            return null;
        } catch (IllegalAccessException e2) {
            SameLogTool.m21733d("SameTools", e2.getMessage());
            return null;
        } catch (NoSuchMethodException e3) {
            SameLogTool.m21733d("SameTools", e3.getMessage());
            return null;
        } catch (InvocationTargetException e4) {
            SameLogTool.m21733d("SameTools", e4.getMessage());
            return null;
        }
    }

    /* renamed from: f */
    public static final synchronized String m21981f(String str) {
        String str2;
        int i;
        int i2;
        boolean z;
        boolean z2;
        Map<String, String> map;
        synchronized (SameTool.class) {
            try {
                str2 = MBSDKContext.m22865f().m22860k() + "_" + str;
                Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
                i = 3;
                if (m23252b != null) {
                    boolean m23390aH = m23252b.m23390aH();
                    z2 = m23252b.m23392aF();
                    i = Math.max(0, m23252b.m23391aG());
                    z = m23390aH;
                } else {
                    z = true;
                    z2 = false;
                }
            } catch (Exception e) {
                SameLogTool.m21733d("SameTools", e.getMessage());
            }
            if (z2 && i != 0) {
                if (z && (map = f30991q) != null && map.containsKey(str2)) {
                    return f30991q.get(str2);
                }
                StringBuilder sb = new StringBuilder("");
                StackTraceElement[] stackTrace = new Exception().getStackTrace();
                if (stackTrace != null && stackTrace.length > 0) {
                    List<String> m22005a = m22005a(stackTrace);
                    Collections.reverse(m22005a);
                    ArrayList arrayList = new ArrayList();
                    for (String str3 : m22005a) {
                        if (!str3.startsWith(MBridgeConstans.APPLICATION_STACK_COM_ANDROID) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_OS) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_APP) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_REFLECT_METHOD) && !str3.startsWith(MBridgeConstans.APPLICATION_STACK_ANDROID_VIEW) && !arrayList.contains(str3)) {
                            arrayList.add(str3);
                        }
                    }
                    int min = Math.min(arrayList.size(), i);
                    if (min > 0) {
                        for (i2 = 0; i2 < min; i2++) {
                            sb.append((String) arrayList.get(i2));
                            if (i2 < min - 1) {
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
                    String m22044a = AESCBCUtil.m22044a(jSONObject.toString());
                    if (z && !TextUtils.isEmpty(m22044a)) {
                        if (f30991q == null) {
                            f30991q = new HashMap();
                        }
                        f30991q.put(str2, m22044a);
                    }
                    return m22044a;
                }
                return "";
            }
            return "";
        }
    }

    /* renamed from: c */
    public static String m21991c(String str) {
        try {
            return StringUtils.m21956b(str) ? URLEncoder.encode(str, "utf-8") : "";
        } catch (Throwable th) {
            SameLogTool.m21735b("SameTools", th.getMessage(), th);
            return "";
        }
    }

    /* renamed from: g */
    public static synchronized String m21979g(String str) {
        synchronized (SameTool.class) {
            String str2 = MBSDKContext.m22865f().m22860k() + "_" + str;
            Map<String, String> map = f30992r;
            if (map == null || !map.containsKey(str2)) {
                return null;
            }
            return f30992r.get(str2);
        }
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0052: MOVE  (r1 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r2 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]), block:B:29:0x0052 */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m21977h(java.lang.String r4) {
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
            com.mbridge.msdk.foundation.tools.SameLogTool.m21733d(r0, r4)     // Catch: java.lang.Throwable -> L52
            return r1
        L52:
            r1 = r2
        L53:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.SameTool.m21977h(java.lang.String):boolean");
    }

    /* renamed from: i */
    public static boolean m21975i(String str) {
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
            } catch (Exception e) {
                SameLogTool.m21733d("SameTools", e.getMessage());
                return false;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: j */
    public static boolean m21973j(String str) {
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
        } catch (Exception e) {
            SameLogTool.m21733d("SameTools", e.getMessage());
            return false;
        }
    }

    /* renamed from: l */
    public static int m21969l(String str) {
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
        } catch (Exception e) {
            SameLogTool.m21733d("SameTools", e.getMessage());
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long m22015a(java.io.File r4) throws java.lang.Exception {
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
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.SameTool.m22015a(java.io.File):long");
    }

    /* renamed from: b */
    public static int m22001b(Context context, float f) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: k */
    public static boolean m21971k(String str) {
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
        } catch (Exception e) {
            SameLogTool.m21733d("SameTools", e.getMessage());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004c A[Catch: Exception -> 0x005f, LOOP:0: B:18:0x004a->B:19:0x004c, LOOP_END, TryCatch #0 {Exception -> 0x005f, blocks: (B:3:0x0002, B:5:0x0014, B:6:0x001c, B:8:0x0023, B:10:0x002a, B:12:0x0040, B:16:0x0046, B:19:0x004c, B:20:0x0054, B:22:0x005a), top: B:27:0x0002 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m22003b(int r6) {
        /*
            java.lang.String r0 = ""
            com.mbridge.msdk.c.b r1 = com.mbridge.msdk.p457c.SettingManager.m23261a()     // Catch: java.lang.Exception -> L5f
            com.mbridge.msdk.foundation.controller.a r2 = com.mbridge.msdk.foundation.controller.MBSDKContext.m22865f()     // Catch: java.lang.Exception -> L5f
            java.lang.String r2 = r2.m22860k()     // Catch: java.lang.Exception -> L5f
            com.mbridge.msdk.c.a r1 = r1.m23252b(r2)     // Catch: java.lang.Exception -> L5f
            if (r1 != 0) goto L1c
            com.mbridge.msdk.c.b r1 = com.mbridge.msdk.p457c.SettingManager.m23261a()     // Catch: java.lang.Exception -> L5f
            com.mbridge.msdk.c.a r1 = r1.m23253b()     // Catch: java.lang.Exception -> L5f
        L1c:
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: java.lang.Exception -> L5f
            r2.<init>()     // Catch: java.lang.Exception -> L5f
            if (r1 == 0) goto L54
            int r1 = r1.m23363ai()     // Catch: java.lang.Exception -> L5f
            r3 = 1
            if (r1 != r3) goto L54
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.MBSDKContext.m22865f()     // Catch: java.lang.Exception -> L5f
            android.content.Context r1 = r1.m22861j()     // Catch: java.lang.Exception -> L5f
            com.mbridge.msdk.foundation.db.i r1 = com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper.m22721a(r1)     // Catch: java.lang.Exception -> L5f
            com.mbridge.msdk.foundation.db.l r1 = com.mbridge.msdk.foundation.p472db.FrequenceDao.m22703a(r1)     // Catch: java.lang.Exception -> L5f
            long[] r1 = r1.m22704a()     // Catch: java.lang.Exception -> L5f
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
            java.lang.String r0 = m22007a(r2)     // Catch: java.lang.Exception -> L5f
            goto L63
        L5f:
            r6 = move-exception
            r6.printStackTrace()
        L63:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.SameTool.m22003b(int):java.lang.String");
    }

    /* renamed from: c */
    public static synchronized boolean m21992c(Context context, String str) {
        boolean z;
        synchronized (SameTool.class) {
            z = false;
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if (m21997b(str, context) != null) {
                            z = true;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return z;
    }

    /* renamed from: e */
    public static int m21984e(String str) {
        try {
            return ((Integer) IWXAPI.class.getMethod("getWXAppSupportAPI", new Class[0]).invoke(SameDiTool.m21780f(str), new Object[0])).intValue();
        } catch (Throwable th) {
            SameLogTool.m21733d("SameTools", th.getMessage());
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        if ((r6 + (r4 * 1000)) >= r8) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0071, code lost:
        if ((r6 + (r4.m23408W() * 1000)) >= r8) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0074, code lost:
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
        if (r12 == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
        r3 = r3.m22613c();
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
    /* renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m21967m(java.lang.String r17) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r17)
            java.lang.String r1 = ""
            if (r0 == 0) goto L9
            return r1
        L9:
            java.util.concurrent.ConcurrentHashMap r0 = com.mbridge.msdk.foundation.same.p474a.StaticDataPoll.m22368c(r17)
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
            com.mbridge.msdk.foundation.entity.c r3 = (com.mbridge.msdk.foundation.entity.BidCacheBean) r3
            if (r3 == 0) goto L22
            long r4 = r3.m22610d()
            long r6 = r3.m22609e()
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
            com.mbridge.msdk.c.b r4 = com.mbridge.msdk.p457c.SettingManager.m23261a()
            com.mbridge.msdk.foundation.controller.a r5 = com.mbridge.msdk.foundation.controller.MBSDKContext.m22865f()
            java.lang.String r5 = r5.m22860k()
            com.mbridge.msdk.c.a r4 = r4.m23252b(r5)
            if (r4 != 0) goto L68
            com.mbridge.msdk.c.b r4 = com.mbridge.msdk.p457c.SettingManager.m23261a()
            com.mbridge.msdk.c.a r4 = r4.m23253b()
        L68:
            long r4 = r4.m23408W()
            long r4 = r4 * r14
            long r6 = r6 + r4
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 < 0) goto L74
            goto L75
        L74:
            r12 = 0
        L75:
            if (r12 == 0) goto L22
            java.util.List r3 = r3.m22613c()
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
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.SameTool.m21967m(java.lang.String):java.lang.String");
    }

    /* renamed from: c */
    public static boolean m21995c() {
        return !TextUtils.isEmpty(MBSDKContext.m22865f().m22858m());
    }

    /* renamed from: a */
    public static int m22022a() {
        int i = f30989o;
        f30989o = i + 1;
        return i;
    }

    /* renamed from: d */
    public static int m21990d() {
        try {
            return ((Integer) com.tencent.p562mm.opensdk.constants.Build.class.getField("SDK_INT").get(null)).intValue();
        } catch (Throwable th) {
            SameLogTool.m21733d("SameTools", th.getMessage());
            return 0;
        }
    }

    /* renamed from: a */
    public static String m22007a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return "";
        }
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b == null) {
            m23252b = SettingManager.m23261a().m23253b();
        }
        int m23410V = m23252b.m23410V();
        if (jSONArray.length() > m23410V) {
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < m23410V; i++) {
                try {
                    jSONArray2.put(jSONArray.get(i));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return jSONArray2.toString();
        }
        return jSONArray.toString();
    }

    /* renamed from: e */
    public static final int m21986e() {
        if (f30993s == null) {
            try {
                f30993s = MIMManager.C11426a.m21818a().m21822e();
            } catch (Exception e) {
                SameLogTool.m21733d("SameTools", e.getMessage());
            }
        }
        if (f30993s != null) {
            return f30993s.booleanValue() ? 1 : 0;
        }
        return -1;
    }

    /* renamed from: d */
    private static final char[] m21989d(int i) {
        StringBuilder sb;
        if (i == 0) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(SameSDKTool.f30974c, f30982h)));
            sb.append(f30976b[f30981g]);
            sb.append(String.valueOf(Arrays.copyOfRange(SameSDKTool.f30974c, f30982h, f30983i)));
            sb.append(f30976b[f30981g]);
            sb.append(String.valueOf(Arrays.copyOfRange(SameSDKTool.f30974c, f30983i, f30985k)));
            sb.append(f30976b[f30981g]);
            sb.append(String.valueOf(SameSDCardTool.f30967c));
        } else if (i == 1) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(SameSDKTool.f30974c, f30982h)));
            sb.append(f30976b[f30981g]);
            sb.append(String.valueOf(Arrays.copyOfRange(SameSDKTool.f30974c, f30982h, f30983i)));
            sb.append(f30976b[f30981g]);
            sb.append(String.valueOf(Arrays.copyOfRange(SameSDKTool.f30974c, f30984j, f30986l)));
        } else if (i == 2) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(SameSDKTool.f30974c, f30985k, f30984j)));
            sb.append(String.valueOf(f30975a));
        } else if (i != 3) {
            sb = null;
        } else {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(SameSDKTool.f30974c, f30985k, f30984j)));
            sb.append(String.valueOf(SameSDCardTool.f30967c));
        }
        return sb.toString().toCharArray();
    }

    /* renamed from: b */
    public static boolean m21999b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                return campaignEx.getRetarget_offer() == 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /* renamed from: b */
    public static double m21998b(String str) {
        try {
            return !TextUtils.isEmpty(str) ? Double.parseDouble(str) : Utils.DOUBLE_EPSILON;
        } catch (Exception e) {
            e.printStackTrace();
            return Utils.DOUBLE_EPSILON;
        }
    }

    /* renamed from: a */
    public static boolean m22011a(String str, Context context) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static List<String> m21996b(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String optString = jSONArray.optString(i);
                        if (StringUtils.m21956b(optString)) {
                            arrayList.add(optString);
                        }
                    }
                    return arrayList;
                }
                return null;
            } catch (Throwable th) {
                SameLogTool.m21735b("SameTools", th.getMessage(), th);
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static int m22013a(Object obj) {
        if (obj != null) {
            try {
                if (obj instanceof String) {
                    return Integer.parseInt((String) obj);
                }
                return 0;
            } catch (Throwable th) {
                SameLogTool.m21735b("SameTools", th.getMessage(), th);
                return 0;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static double m22014a(Double d) {
        try {
            String format = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US)).format(d);
            return StringUtils.m21956b(format) ? Double.parseDouble(format) : Utils.DOUBLE_EPSILON;
        } catch (Exception e) {
            e.printStackTrace();
            return Utils.DOUBLE_EPSILON;
        }
    }

    /* renamed from: b */
    public static boolean m22004b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* renamed from: b */
    public static String m22000b(Context context, String str) {
        String str2;
        str2 = "";
        try {
            JSONArray m22020a = m22020a(context, str);
            str2 = m22020a.length() > 0 ? m22007a(m22020a) : "";
            SameLogTool.m21736b("SameTools", "get excludes:" + str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str2;
    }

    /* renamed from: a */
    public static void m22018a(View view) {
        if (view == null) {
            return;
        }
        try {
            view.setSystemUiVisibility(CoreProtocolImpl.C13167a.f38404f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m22017a(ImageView imageView) {
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

    /* renamed from: b */
    private static Object m21997b(String str, Context context) {
        try {
            return Class.forName(String.valueOf(m21989d(f30977c))).getMethod(String.valueOf(m21989d(f30979e)), String.class, Integer.TYPE).invoke(Class.forName(String.valueOf(m21989d(f30978d))).getMethod(String.valueOf(m21989d(f30980f)), new Class[0]).invoke(context, new Object[0]), str, 8192);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: f */
    public static final String m21983f() {
        return MIMManager.C11426a.m21818a().m21820f();
    }

    /* renamed from: a */
    public static JSONArray m22020a(Context context, String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
            if (m23252b == null) {
                m23252b = SettingManager.m23261a().m23253b();
            }
            if (m23252b != null && m23252b.m23363ai() == 1) {
                SameLogTool.m21736b("SameTools", "fqci cfc:" + m23252b.m23363ai());
                long[] m22704a = FrequenceDao.m22703a(CommonSDKDBHelper.m22721a(context)).m22704a();
                if (m22704a != null) {
                    for (long j : m22704a) {
                        SameLogTool.m21736b("SameTools", "cfc campaignIds:" + m22704a);
                        jSONArray.put(j);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static void m22009a(String str, CampaignEx campaignEx, int i) {
        if (TextUtils.isEmpty(str) || campaignEx == null || MBSDKContext.m22865f().m22861j() == null) {
            return;
        }
        FqInfoDao m22708a = FqInfoDao.m22708a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
        FqInfo fqInfo = new FqInfo();
        fqInfo.m22560a(System.currentTimeMillis());
        fqInfo.m22557b(str);
        fqInfo.m22559a(campaignEx.getId());
        fqInfo.m22561a(i);
        m22708a.m22707a(fqInfo);
    }

    /* renamed from: a */
    private static synchronized String m22010a(String str, Context context, String str2) {
        StringBuilder sb;
        String sb2;
        synchronized (SameTool.class) {
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
                if (m21997b(str2, context) != null) {
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

    /* renamed from: a */
    public static synchronized String m22019a(Context context, String str, String str2) {
        String sb;
        synchronized (SameTool.class) {
            StringBuilder sb2 = new StringBuilder(str2);
            try {
                sb2.append(m22010a(str2, context, str));
            } catch (Exception unused) {
            }
            sb = sb2.toString();
        }
        return sb;
    }

    /* renamed from: a */
    public static synchronized void m22008a(String str, String str2) {
        synchronized (SameTool.class) {
            if (f30992r == null) {
                f30992r = new HashMap();
            }
            f30992r.put(MBSDKContext.m22865f().m22860k() + "_" + str, str2);
        }
    }

    /* renamed from: a */
    private static List<String> m22005a(StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                arrayList.add(stackTraceElement.getClassName());
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static boolean m22006a(JSONObject jSONObject) {
        return (jSONObject == null || jSONObject.length() == 0 || jSONObject.optInt("v", -1) != -1) ? false : true;
    }
}
