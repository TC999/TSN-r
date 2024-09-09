package cn.jpush.android.ad;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.JNotifyActivity;
import cn.jpush.android.ui.PopWinActivity;
import cn.jpush.android.ui.PushActivity;
import com.acse.ottn.f3;
import com.stub.StubApp;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static List<String> f3969a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private static LinkedHashMap<String, String> f3970b = new LinkedHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static String f3971c;

    /* renamed from: d  reason: collision with root package name */
    private static String f3972d;

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f3973e;

    /* renamed from: f  reason: collision with root package name */
    private static final byte[] f3974f;

    /* renamed from: g  reason: collision with root package name */
    private static final byte[] f3975g;

    /* renamed from: h  reason: collision with root package name */
    private static String f3976h;

    /* renamed from: i  reason: collision with root package name */
    private static String f3977i;

    /* renamed from: j  reason: collision with root package name */
    private static String f3978j;

    static {
        f3969a.add("image/png");
        f3969a.add("image/jpg");
        f3969a.add("image/jpeg");
        f3971c = "";
        f3973e = new byte[]{105, 120, 117, 66, 79, 112, 108, 56, 102, 85, 66, 114, 97, 98, 63, 103, 69, 123, 91, 115, 101, 68, 73, 119, 111, 101};
        f3974f = new byte[]{83, 124, 124, 87, 125, 92, 79, 110, 78, Byte.MAX_VALUE, 125, 85, 97, 122, 107, 115, 98, 67};
        f3975g = new byte[]{123, 115, 101, 122, 65, 111, 105, 69, 114, 66, 73, 105, 124, 83, Byte.MAX_VALUE, 81, 66, 117, 109, 114};
        f3976h = "";
        f3977i = "android.permission.POST_NOTIFICATIONS";
        f3978j = "";
    }

    public static int a(String str, String str2) {
        if (str.equals(str2)) {
            return 0;
        }
        try {
            String[] split = str.split("[._]");
            String[] split2 = str2.split("[._]");
            if (split.length > split2.length) {
                split2 = (String[]) Arrays.copyOf(split2, split.length);
            } else if (split.length < split2.length) {
                split = (String[]) Arrays.copyOf(split, split2.length);
            }
            for (int i4 = 0; i4 < split.length; i4++) {
                long parseLong = (TextUtils.isEmpty(split[i4]) ? 0L : Long.parseLong(split[i4])) - (TextUtils.isEmpty(split2[i4]) ? 0L : Long.parseLong(split2[i4]));
                if (parseLong > 0) {
                    return 1;
                }
                if (parseLong < 0) {
                    return -1;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return str.compareTo(str2);
        }
    }

    public static Intent a(Bundle bundle) {
        Intent intent = new Intent();
        if (bundle == null) {
            return intent;
        }
        try {
            String string = bundle.getString("intent_action");
            if (!TextUtils.isEmpty(string)) {
                intent.setAction(string);
            }
            Uri uri = (Uri) bundle.getParcelable("intent_data");
            if (uri != null) {
                intent.setData(uri);
            }
            String[] stringArray = bundle.getStringArray("intent_categories");
            if (stringArray != null && stringArray.length > 0) {
                for (String str : stringArray) {
                    intent.addCategory(str);
                }
            }
            Parcelable parcelable = bundle.getParcelable("intent_component");
            if (parcelable != null) {
                intent.setComponent((ComponentName) parcelable);
            }
            intent.putExtras(bundle);
            intent.setFlags(bundle.getInt("intent_flags"));
            String string2 = bundle.getString("intent_package");
            if (!TextUtils.isEmpty(string2)) {
                intent.setPackage(string2);
            }
            String string3 = bundle.getString("intent_type");
            if (!TextUtils.isEmpty(string3)) {
                intent.setType(string3);
            }
        } catch (Throwable unused) {
        }
        return intent;
    }

    public static Intent a(String str, int i4) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent parseUri = Intent.parseUri(str, i4);
        Intent intent = new Intent(parseUri);
        parseUri.addCategory("android.intent.category.BROWSABLE");
        parseUri.setComponent(null);
        parseUri.setSelector(null);
        return intent;
    }

    public static ComponentInfo a(Context context, String str, Class<?> cls) {
        int i4;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || cls == null) {
            Logger.w("AndroidUtil", "Action - hasComponent, invalide param, context:" + context + ",packageName:" + str + ",cls:" + cls);
            return null;
        }
        try {
            i4 = Service.class.isAssignableFrom(cls) ? 4 : BroadcastReceiver.class.isAssignableFrom(cls) ? 2 : Activity.class.isAssignableFrom(cls) ? 1 : ContentProvider.class.isAssignableFrom(cls) ? 8 : 0;
            packageInfo = JCoreHelper.getPackageInfo(context, str, i4);
        } catch (Throwable th) {
            Logger.ww("AndroidUtil", "hasComponent error:" + th.getMessage());
        }
        if (packageInfo == null) {
            return null;
        }
        ComponentInfo[] componentInfoArr = i4 != 1 ? i4 != 2 ? i4 != 4 ? i4 != 8 ? null : packageInfo.providers : packageInfo.services : packageInfo.receivers : packageInfo.activities;
        if (componentInfoArr == null) {
            return null;
        }
        for (ComponentInfo componentInfo : componentInfoArr) {
            if (cls.isAssignableFrom(Class.forName(componentInfo.name, false, cls.getClassLoader()))) {
                return componentInfo;
            }
        }
        return null;
    }

    public static Bundle a(Intent intent) {
        Bundle bundle = new Bundle();
        if (intent == null) {
            return bundle;
        }
        try {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action)) {
                bundle.putString("intent_action", action);
            }
            Uri data = intent.getData();
            if (data != null) {
                bundle.putParcelable("intent_data", data);
            }
            Set<String> categories = intent.getCategories();
            if (categories != null && categories.size() > 0) {
                bundle.putStringArray("intent_categories", (String[]) categories.toArray(new String[0]));
            }
            ComponentName component = intent.getComponent();
            if (component != null) {
                bundle.putParcelable("intent_component", component);
            }
            Bundle extras = intent.getExtras();
            if (extras != null) {
                bundle.putAll(extras);
            }
            bundle.putInt("intent_flags", intent.getFlags());
            String str = intent.getPackage();
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("intent_package", str);
            }
            String type = intent.getType();
            if (!TextUtils.isEmpty(type)) {
                bundle.putString("intent_type", type);
            }
        } catch (Throwable unused) {
        }
        return bundle;
    }

    public static String a(String str) {
        try {
            String str2 = f3970b.get(str);
            f3970b.remove(str);
            return str2;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(l.f4021a);
            messageDigest.update(bArr);
            return b(messageDigest.digest());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static List<String> a(Context context, List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!a(context, str)) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static void a(Context context, Intent intent, String str) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(action) || JPushInterface.ACTION_NOTIFICATION_OPENED.equals(action)) {
            List<String> b4 = b(context, intent, str);
            if (b4 == null || b4.isEmpty()) {
                Logger.ww("AndroidUtil", "sendBroadcast failed again: receiver not found, action:" + intent.getAction());
                return;
            }
            for (String str2 : b4) {
                try {
                    Intent intent2 = (Intent) intent.clone();
                    intent2.setComponent(new ComponentName(context.getPackageName(), str2));
                    if (TextUtils.isEmpty(str)) {
                        context.sendBroadcast(intent2);
                    } else {
                        context.sendBroadcast(intent2, str);
                    }
                } catch (Exception e4) {
                    Logger.ww("AndroidUtil", "sendBroadcast failed again:" + e4.getMessage() + ", action:" + intent.getAction());
                }
            }
        }
    }

    public static void a(WebSettings webSettings) {
        try {
            Logger.d("AndroidUtil", "fix.");
            webSettings.setAllowFileAccess(false);
            Class.forName(d.b(f3973e)).getMethod(d.b(f3974f), Boolean.TYPE).invoke(webSettings, Boolean.TRUE);
        } catch (Throwable th) {
            Logger.w("AndroidUtil", "something is wrong:" + th.getMessage());
        }
    }

    public static void a(final WebView webView) {
        try {
            int i4 = Build.VERSION.SDK_INT;
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
            if (i4 >= 21) {
                webView.getSettings().setMixedContentMode(0);
            }
        } catch (Throwable th) {
            Logger.e("AndroidUtil", "fixSecure failed, error:" + th);
            webView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: cn.jpush.android.ad.a.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    WebSettings settings = webView.getSettings();
                    if (settings != null) {
                        try {
                            Method declaredMethod = settings.getClass().getDeclaredMethod("removeJavascriptInterface", String.class);
                            if (declaredMethod != null) {
                                declaredMethod.invoke(webView, "searchBoxJavaBridge_");
                                declaredMethod.invoke(webView, "accessibility");
                                declaredMethod.invoke(webView, "accessibilityTraversal");
                            }
                        } catch (Throwable th2) {
                            Logger.e("AndroidUtil", "removeJavascriptInterface failed, error:" + th2);
                        }
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
        }
    }

    private static void a(StringBuffer stringBuffer, byte b4) {
        stringBuffer.append("0123456789ABCDEF".charAt((b4 >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b4 & 15));
    }

    public static boolean a() {
        boolean z3;
        try {
            z3 = Environment.getExternalStorageState().equals("mounted");
        } catch (Throwable th) {
            Logger.w("AndroidUtil", "isSdcardExist exception: " + th);
            z3 = false;
        }
        if (!z3) {
            Logger.d("AndroidUtil", "SDCard is not mounted");
        }
        return z3;
    }

    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Context context, Class<?> cls) {
        if (context != null) {
            try {
                boolean z3 = context.getPackageManager().resolveActivity(new Intent(context, cls), 0) != null;
                if (z3) {
                    return z3;
                }
                return a(context, context.getPackageName(), cls) != null;
            } catch (Throwable th) {
                Logger.dd("AndroidUtil", "hasActivityResolves error:" + th.getMessage());
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (r5.checkSelfPermission(r6) == 0) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "AndroidUtil"
            r1 = 0
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L53
            r3 = 23
            r4 = 1
            if (r2 < r3) goto L18
            android.content.pm.ApplicationInfo r2 = r5.getApplicationInfo()     // Catch: java.lang.Throwable -> L53
            int r2 = r2.targetSdkVersion     // Catch: java.lang.Throwable -> L53
            if (r2 < r3) goto L1a
            int r5 = r5.checkSelfPermission(r6)     // Catch: java.lang.Throwable -> L53
            if (r5 != 0) goto L36
        L18:
            r1 = 1
            goto L36
        L1a:
            java.lang.String r6 = android.app.AppOpsManager.permissionToOp(r6)     // Catch: java.lang.Throwable -> L53
            if (r6 != 0) goto L21
            goto L35
        L21:
            java.lang.String r2 = "appops"
            java.lang.Object r2 = r5.getSystemService(r2)     // Catch: java.lang.Throwable -> L53
            android.app.AppOpsManager r2 = (android.app.AppOpsManager) r2     // Catch: java.lang.Throwable -> L53
            java.lang.String r5 = r5.getPackageName()     // Catch: java.lang.Throwable -> L53
            int r5 = r2.noteProxyOpNoThrow(r6, r5)     // Catch: java.lang.Throwable -> L53
            if (r5 != 0) goto L34
            r1 = 1
        L34:
            r4 = r1
        L35:
            r1 = r4
        L36:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L53
            r5.<init>()     // Catch: java.lang.Throwable -> L53
            java.lang.String r6 = "use "
            r5.append(r6)     // Catch: java.lang.Throwable -> L53
            if (r1 == 0) goto L46
            java.lang.String r6 = " had current permission,no need to request"
            goto L48
        L46:
            java.lang.String r6 = " need to request permission"
        L48:
            r5.append(r6)     // Catch: java.lang.Throwable -> L53
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L53
            cn.jpush.android.helper.Logger.w(r0, r5)     // Catch: java.lang.Throwable -> L53
            goto L6c
        L53:
            r5 = move-exception
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r2 = "checkPermission error:"
            r6.append(r2)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            cn.jpush.android.helper.Logger.w(r0, r5)
        L6c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.ad.a.a(android.content.Context, java.lang.String):boolean");
    }

    public static boolean a(Context context, String str, String str2) {
        if (c(context, str)) {
            return true;
        }
        Logger.d("AndroidUtil", "p not:" + str);
        try {
            return b(context, str, str2);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(String str, boolean z3) {
        HttpURLConnection httpURLConnection;
        String contentType;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
        }
        try {
            contentType = httpURLConnection.getContentType();
            Logger.v("AndroidUtil", "httpGetIconBytes contentType:" + contentType);
        } catch (Throwable unused3) {
            httpURLConnection2 = httpURLConnection;
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            return false;
        }
        if (e(contentType)) {
            if (z3) {
                b(str, contentType);
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused4) {
            }
            return true;
        }
        Logger.ke("AndroidUtil", "only support suffix jpg/jpeg/png!! current type=" + contentType);
        httpURLConnection.disconnect();
        return false;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(f3971c)) {
            try {
                f3971c = context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0)).toString();
            } catch (Throwable unused) {
            }
            return f3971c;
        }
        return f3971c;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            int indexOf = str.indexOf("?");
            if (indexOf > 0) {
                str = str.substring(0, indexOf);
                if (TextUtils.isEmpty(str)) {
                    return "";
                }
            }
            return str.substring(str.lastIndexOf("."));
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b4 : bArr) {
            a(stringBuffer, b4);
        }
        return stringBuffer.toString();
    }

    public static List<String> b(Context context, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            PackageManager packageManager = context.getPackageManager();
            for (ResolveInfo resolveInfo : queryBroadcastReceivers) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null) {
                    String str2 = activityInfo.name;
                    if (!TextUtils.isEmpty(str2)) {
                        boolean z3 = true;
                        if (!TextUtils.isEmpty(str) && packageManager.checkPermission(str, resolveInfo.activityInfo.packageName) != 0) {
                            z3 = false;
                        }
                        if (z3) {
                            arrayList.add(str2);
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public static void b(Context context, String str) {
        try {
            Intent f4 = f(context);
            if (f4 != null) {
                if (!TextUtils.isEmpty(str)) {
                    f4.putExtra("extra", str);
                }
                context.startActivity(f4);
            }
        } catch (Throwable th) {
            Logger.dd("AndroidUtil", "startMainActivity error:" + th.getMessage());
        }
    }

    public static void b(WebSettings webSettings) {
        try {
            Class.forName(d.b(f3973e)).getMethod(d.b(f3975g), Boolean.TYPE).invoke(webSettings, Boolean.TRUE);
        } catch (Throwable th) {
            Logger.w("AndroidUtil", "something is wrong:" + th.getMessage());
        }
    }

    private static void b(String str, String str2) {
        try {
            if (f3970b.containsKey(str)) {
                return;
            }
            f3970b.put(str, str2);
        } catch (Throwable unused) {
        }
    }

    public static boolean b() {
        try {
            String d4 = d();
            Logger.d("AndroidUtil", "vivoVersion:" + d4);
            if (!Build.MANUFACTURER.equalsIgnoreCase("vivo") && !d4.startsWith("Funtouch")) {
                String f4 = f("ro.iqoo.os.build.display.id");
                Logger.d("AndroidUtil", "iqooMonsterUI:" + f4);
                if (f4 == null) {
                    return false;
                }
                if (TextUtils.isEmpty(f4.trim())) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean b(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        Logger.d("AndroidUtil", "try d:" + str2);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
        if (!TextUtils.isEmpty(str)) {
            intent.setPackage(str);
        }
        return context.getPackageManager().resolveActivity(intent, 0) != null;
    }

    public static String c() {
        if (TextUtils.isEmpty(f3978j)) {
            try {
                f3978j = Build.MANUFACTURER;
            } catch (Throwable unused) {
            }
            return f3978j;
        }
        return f3978j;
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(f3972d)) {
            try {
                f3972d = i.a(JPushConstants.getAppContext(context));
            } catch (Throwable th) {
                Logger.ww("AndroidUtil", "#unexcepted - getCurProcessName failed:" + th.getMessage());
            }
            return f3972d;
        }
        return f3972d;
    }

    public static void c(WebSettings webSettings) {
        webSettings.setAllowFileAccess(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setDomStorageEnabled(true);
        b(webSettings);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setCacheMode(2);
        webSettings.setSaveFormData(false);
        webSettings.setSavePassword(false);
    }

    public static boolean c(Context context, String str) {
        return (TextUtils.isEmpty(str) || JCoreHelper.getPackageInfo(context, str, 0) == null) ? false : true;
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String trim = str.trim();
        boolean matches = trim.matches("^[http|https]+://.*");
        if (!matches) {
            Logger.w("AndroidUtil", "Invalid url - " + trim);
        }
        return matches;
    }

    private static String d() {
        if (TextUtils.isEmpty(f3976h)) {
            String f4 = f("ro.vivo.os.build.display.id");
            f3976h = f4;
            return f4;
        }
        return f3976h;
    }

    public static String d(String str) {
        if (str == null || "".equals(str)) {
            return null;
        }
        return a(str.getBytes());
    }

    public static void d(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                String c4 = c(context);
                String packageName = context.getPackageName();
                if (c4 == null || packageName == null || packageName.equals(c4)) {
                    return;
                }
                WebView.setDataDirectorySuffix(c4);
                Logger.d("AndroidUtil", "setDataDirectorySuffix =" + c4);
            }
        } catch (Throwable th) {
            Logger.e("AndroidUtil", "fixWebViewProcess e:" + th);
        }
    }

    public static boolean d(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent(str);
            intent.addCategory(context.getPackageName());
            return packageManager.resolveActivity(intent, 0) != null;
        } catch (Throwable th) {
            Logger.dd("AndroidUtil", "hasActivityIntentFilter error:" + th.getMessage());
            return true;
        }
    }

    public static String e(Context context, String str) {
        return context.getPackageName() + "." + str;
    }

    public static void e(Context context) {
        b(context, (String) null);
    }

    private static boolean e(String str) {
        try {
            return f3969a.contains(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Intent f(Context context) {
        Throwable th;
        Intent intent;
        PackageManager packageManager;
        String packageName;
        try {
            packageManager = context.getPackageManager();
            packageName = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
        } catch (Throwable th2) {
            th = th2;
            intent = null;
        }
        if (TextUtils.isEmpty(packageName)) {
            Logger.ww("AndroidUtil", "The package with the given name cannot be found!");
            return null;
        }
        intent = packageManager.getLaunchIntentForPackage(packageName);
        try {
        } catch (Throwable th3) {
            th = th3;
            Logger.w("AndroidUtil", "getLaunchIntent error:" + th.getMessage());
            return intent;
        }
        if (intent == null) {
            Logger.ww("AndroidUtil", "Can't get launch intent for this package!");
            return null;
        }
        intent.addFlags(268435456);
        return intent;
    }

    private static String f(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod(f3.f5657f, String.class).invoke(cls, str);
            Logger.i("AndroidUtil", "get " + str + " version is:" + str2);
            return str2;
        } catch (Throwable th) {
            Logger.e("AndroidUtil", " get " + str + "wrong error:" + th.getMessage());
            return "";
        }
    }

    public static boolean g(Context context) {
        Logger.dd("AndroidUtil", "action:checkValidManifest");
        if (!a(context, PushActivity.class)) {
            Logger.ww("AndroidUtil", "AndroidManifest.xml missing required activity: " + PushActivity.class.getCanonicalName());
            Logger.ww("AndroidUtil", "You will unable to use rich push type.");
        }
        if (!a(context, PopWinActivity.class)) {
            Logger.ww("AndroidUtil", "AndroidManifest.xml missing activity: " + PopWinActivity.class.getCanonicalName());
            Logger.ww("AndroidUtil", "You will unable to use pop-window rich push type.");
        }
        if (!d(context, "cn.jpush.android.ui.PushActivity")) {
            Logger.w("AndroidUtil", "AndroidManifest.xml missing required intent filter for PushActivity: cn.jpush.android.ui.PushActivity");
        }
        if (h(context)) {
            if (TextUtils.isEmpty(JPushConstants.getMessageReceiverClass(context))) {
                Logger.ke("AndroidUtil", "AndroidManifest.xml missing required receiver: please custom receiver extends JPushMessageReceiver. Otherwise no service");
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean h(Context context) {
        if (context != null) {
            try {
                String packageName = context.getPackageName();
                PackageManager packageManager = context.getPackageManager();
                ResolveInfo resolveActivity = packageManager.resolveActivity(new Intent(context, JNotifyActivity.class), 0);
                if (resolveActivity == null) {
                    Logger.ke("AndroidUtil", "AndroidManifest.xml missing required activity: " + JNotifyActivity.class.getCanonicalName() + ", Otherwise no service");
                    return false;
                }
                if (JCoreHelper.getJCoreSDKVersionInt() < 336 && JPushConstants.SDK_VERSION_CODE >= 483) {
                    Logger.ke("AndroidUtil", "JPush current version is " + JPushConstants.SDK_VERSION_CODE + "\uff0cmust use JCore 336 or higher.");
                }
                if (context.getResources().getIdentifier("JPushTheme", "style", packageName) != resolveActivity.activityInfo.theme) {
                    Logger.ke("AndroidUtil", "JNotifyActivity theme must use android:theme=\\\"@style/JPushTheme\\\">\\n\" ,and the JPushTheme name not confused keep it. Otherwise no service");
                    return false;
                }
                Intent intent = new Intent();
                intent.setAction("cn.jpush.android.intent.JNotifyActivity");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.addCategory(context.getPackageName());
                if (packageManager.resolveActivity(intent, 0) == null) {
                    Logger.ke("AndroidUtil", "AndroidManifest.xml activity JNotifyActivity Action Must be <action android:name=\"cn.jpush.android.intent.JNotifyActivity\" />");
                    Logger.ke("AndroidUtil", "AndroidManifest.xml activity JNotifyActivity Action Must be <category android:name=\"android.intent.category.DEFAULT\" />");
                    Logger.ke("AndroidUtil", "AndroidManifest.xml activity JNotifyActivity Action Must be <category android:name=\"${applicationId}\" />\n");
                    Logger.ke("AndroidUtil", "AndroidManifest.xml activity JNotifyActivity not set <data>. Otherwise no service");
                    return false;
                }
                return true;
            } catch (Throwable th) {
                Logger.kd("AndroidUtil", "checkJNotifyActivity error:" + th.getMessage());
            }
        }
        return false;
    }

    public static boolean i(Context context) {
        return JPushConstants.isForeGround == 0;
    }

    public static Activity j(Context context) {
        if (context != null) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mActivities");
                declaredField.setAccessible(true);
                Map map = (Map) declaredField.get(invoke);
                if (map == null) {
                    Logger.w("AndroidUtil", "get current activities for currentActivityThread, activities is null");
                    return null;
                }
                for (Object obj : map.values()) {
                    Class<?> cls2 = obj.getClass();
                    Field declaredField2 = cls2.getDeclaredField("paused");
                    declaredField2.setAccessible(true);
                    if (!declaredField2.getBoolean(obj)) {
                        Field declaredField3 = cls2.getDeclaredField("activity");
                        declaredField3.setAccessible(true);
                        Activity activity = (Activity) declaredField3.get(obj);
                        if (activity == null) {
                            Logger.w("AndroidUtil", "[getCurrentActivity] activity is null");
                            return null;
                        } else if (activity.getPackageName().equals(context.getPackageName())) {
                            Logger.d("AndroidUtil", "getCurrentActivity: " + activity.getLocalClassName());
                            return activity;
                        } else {
                            Logger.w("AndroidUtil", "current activity packageName: " + activity.getPackageName() + ", appPackageName: " + context.getPackageName());
                            return null;
                        }
                    }
                }
            } catch (Throwable th) {
                Logger.w("AndroidUtil", "[getCurrentActivity] error: " + th.getMessage());
            }
        }
        return null;
    }

    public static void k(Context context) {
        if (!(context instanceof Activity)) {
            Logger.ww("AndroidUtil", "[requestRequiredPermission] context must instanceof Activity");
            return;
        }
        try {
            LinkedList linkedList = new LinkedList();
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 33) {
                linkedList.add(f3977i);
                if (!((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled()) {
                    Logger.ww("AndroidUtil", "request " + f3977i + "\uff0cneed go to settings and turn on app notification switch");
                }
            } else {
                Logger.d("AndroidUtil", " Build.VERSION.SDK_INT:" + i4 + " < 33, not need to request POST_NOTIFICATIONS");
            }
            List<String> a4 = a(context, linkedList);
            if (a4 != null && !a4.isEmpty()) {
                Logger.v("AndroidUtil", "lackPermissions:" + a4);
                Class.forName("android.app.Activity").getDeclaredMethod("requestPermissions", String[].class, Integer.TYPE).invoke(context, a4.toArray(new String[a4.size()]), 1);
            }
        } catch (Exception e4) {
            Logger.ww("AndroidUtil", "#unexcepted - requestRequiredPermission e:" + e4);
        }
    }
}
