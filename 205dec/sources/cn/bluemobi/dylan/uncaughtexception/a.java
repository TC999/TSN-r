package cn.bluemobi.dylan.uncaughtexception;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import cat.ereza.customactivityoncrash.R;
import cn.bluemobi.dylan.uncaughtexception.activity.DefaultErrorActivity;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.zip.ZipFile;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: CustomActivityOnCrash.java */
@SuppressLint({"NewApi"})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1983a = "cat.ereza.customactivityoncrash.ERROR";

    /* renamed from: b  reason: collision with root package name */
    private static final String f1984b = "cat.ereza.customactivityoncrash.RESTART";

    /* renamed from: c  reason: collision with root package name */
    private static Application f1985c;

    /* renamed from: d  reason: collision with root package name */
    private static WeakReference<Activity> f1986d = new WeakReference<>(null);

    /* renamed from: e  reason: collision with root package name */
    private static boolean f1987e = false;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f1988f = true;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f1989g = true;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f1990h = true;

    /* renamed from: i  reason: collision with root package name */
    private static int f1991i = R.drawable.customactivityoncrash_error_image;

    /* renamed from: j  reason: collision with root package name */
    private static Class<? extends Activity> f1992j = null;

    /* renamed from: k  reason: collision with root package name */
    private static Class<? extends Activity> f1993k = null;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f1994l = true;

    /* renamed from: m  reason: collision with root package name */
    private static String[] f1995m;

    /* renamed from: n  reason: collision with root package name */
    private static String f1996n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: CustomActivityOnCrash.java */
    /* renamed from: cn.bluemobi.dylan.uncaughtexception.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    static class C0043a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f1997a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
        /* compiled from: CustomActivityOnCrash.java */
        /* renamed from: cn.bluemobi.dylan.uncaughtexception.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        class C0044a extends Thread {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Throwable f1998a;

            C0044a(Throwable th) {
                this.f1998a = th;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                StringWriter stringWriter = new StringWriter();
                this.f1998a.printStackTrace(new PrintWriter(stringWriter));
                String stringWriter2 = stringWriter.toString();
                if (stringWriter2.length() > 131071) {
                    stringWriter2 = stringWriter2.substring(0, 131047) + " [stack trace too large]";
                }
                if (!TextUtils.isEmpty(a.D())) {
                    a.X(a.D(), "{ \"msgtype\": \"text\", \"text\": {\"content\": \"" + a.v(C0043a.this.f1997a, stringWriter2) + "\"}}");
                }
                d.b.a(a.y(C0043a.this.f1997a), a.v(C0043a.this.f1997a, stringWriter2));
                a.W();
                System.exit(0);
            }
        }

        C0043a(Context context) {
            this.f1997a = context;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            Log.e("CustomActivityOnCrash", "App has crashed, executing CustomActivityOnCrash's UncaughtExceptionHandler", th);
            if (!a.f1994l) {
                new C0044a(th).start();
                return;
            }
            if (a.f1992j == null) {
                Class unused = a.f1992j = a.O(a.f1985c);
            }
            if (a.V(th, a.f1992j)) {
                Log.e("CustomActivityOnCrash", "Your application class or your error activity have crashed, the custom activity will not be launched!");
            } else if (a.f1988f || !a.f1987e) {
                Intent intent = new Intent(a.f1985c, a.f1992j);
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                String stringWriter2 = stringWriter.toString();
                if (stringWriter2.length() > 131071) {
                    stringWriter2 = stringWriter2.substring(0, 131047) + " [stack trace too large]";
                }
                if (a.f1990h && a.f1993k == null) {
                    Class unused2 = a.f1993k = a.P(a.f1985c);
                } else if (!a.f1990h) {
                    Class unused3 = a.f1993k = null;
                }
                intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_STACK_TRACE", stringWriter2);
                intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_RESTART_ACTIVITY_CLASS", a.f1993k);
                intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_SHOW_ERROR_DETAILS", a.f1989g);
                intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_IMAGE_DRAWABLE_ID", a.f1991i);
                intent.setFlags(268468224);
                a.f1985c.startActivity(intent);
            }
            Activity activity = (Activity) a.f1986d.get();
            if (activity != null) {
                activity.finish();
                a.f1986d.clear();
            }
            a.W();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: CustomActivityOnCrash.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    static class b implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a  reason: collision with root package name */
        int f2000a = 0;

        b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity.getClass() != a.f1992j) {
                WeakReference unused = a.f1986d = new WeakReference(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            int i4 = this.f2000a + 1;
            this.f2000a = i4;
            boolean unused = a.f1987e = i4 == 0;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            int i4 = this.f2000a - 1;
            this.f2000a = i4;
            boolean unused = a.f1987e = i4 == 0;
        }
    }

    public static int A() {
        return f1991i;
    }

    public static int B(Intent intent) {
        return intent.getIntExtra("cat.ereza.customactivityoncrash.EXTRA_IMAGE_DRAWABLE_ID", R.drawable.customactivityoncrash_error_image);
    }

    private static String C() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return t(str2);
        }
        return t(str) + " " + str2;
    }

    public static String D() {
        return f1996n;
    }

    public static String[] E() {
        return f1995m;
    }

    public static Class<? extends Activity> F() {
        return f1992j;
    }

    private static Class<? extends Activity> G(Context context) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent().setAction("cat.ereza.customactivityoncrash.ERROR").setPackage(context.getPackageName()), 64);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return null;
        }
        try {
            return Class.forName(queryIntentActivities.get(0).activityInfo.name);
        } catch (ClassNotFoundException e4) {
            Log.e("CustomActivityOnCrash", "Failed when resolving the error activity class via intent filter, stack trace follows!", e4);
            return null;
        }
    }

    private static Class<? extends Activity> H(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage != null) {
            try {
                return Class.forName(launchIntentForPackage.getComponent().getClassName());
            } catch (ClassNotFoundException e4) {
                Log.e("CustomActivityOnCrash", "Failed when resolving the restart activity class via getLaunchIntentForPackage, stack trace follows!", e4);
                return null;
            }
        }
        return null;
    }

    public static Class<? extends Activity> I() {
        return f1993k;
    }

    public static Class<? extends Activity> J(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("cat.ereza.customactivityoncrash.EXTRA_RESTART_ACTIVITY_CLASS");
        if (serializableExtra == null || !(serializableExtra instanceof Class)) {
            return null;
        }
        return (Class) serializableExtra;
    }

    private static Class<? extends Activity> K(Context context) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent().setAction("cat.ereza.customactivityoncrash.RESTART").setPackage(context.getPackageName()), 64);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return null;
        }
        try {
            return Class.forName(queryIntentActivities.get(0).activityInfo.name);
        } catch (ClassNotFoundException e4) {
            Log.e("CustomActivityOnCrash", "Failed when resolving the restart activity class via intent filter, stack trace follows!", e4);
            return null;
        }
    }

    public static String L(Intent intent) {
        return intent.getStringExtra("cat.ereza.customactivityoncrash.EXTRA_STACK_TRACE");
    }

    private static String M() {
        return Arrays.toString(Build.SUPPORTED_ABIS);
    }

    private static String N(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Class<? extends Activity> O(Context context) {
        Class<? extends Activity> G = G(context);
        return G == null ? DefaultErrorActivity.class : G;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Class<? extends Activity> P(Context context) {
        Class<? extends Activity> K = K(context);
        return K == null ? H(context) : K;
    }

    public static void Q(Context context) {
        try {
            if (context == null) {
                Log.e("CustomActivityOnCrash", "Install failed: context is null!");
                return;
            }
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null && defaultUncaughtExceptionHandler.getClass().getName().startsWith("cat.ereza.customactivityoncrash")) {
                Log.e("CustomActivityOnCrash", "You have already installed CustomActivityOnCrash, doing nothing!");
                return;
            }
            if (defaultUncaughtExceptionHandler != null && !defaultUncaughtExceptionHandler.getClass().getName().startsWith("com.android.internal.os")) {
                Log.e("CustomActivityOnCrash", "IMPORTANT WARNING! You already have an UncaughtExceptionHandler, are you sure this is correct? If you use ACRA, Crashlytics or similar libraries, you must initialize them AFTER CustomActivityOnCrash! Installing anyway, but your original handler will not be called.");
            }
            f1985c = (Application) StubApp.getOrigApplicationContext(context.getApplicationContext());
            Thread.setDefaultUncaughtExceptionHandler(new C0043a(context));
            f1985c.registerActivityLifecycleCallbacks(new b());
            Log.i("CustomActivityOnCrash", "CustomActivityOnCrash has been installed.");
        } catch (Throwable th) {
            Log.e("CustomActivityOnCrash", "An unknown error occurred while installing CustomActivityOnCrash, it may not have been properly initialized. Please report this as a bug if needed.", th);
        }
    }

    public static boolean R() {
        return f1990h;
    }

    public static boolean S() {
        return f1988f;
    }

    public static boolean T() {
        return f1989g;
    }

    public static boolean U(Intent intent) {
        return intent.getBooleanExtra("cat.ereza.customactivityoncrash.EXTRA_SHOW_ERROR_DETAILS", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean V(Throwable th, Class<? extends Activity> cls) {
        StackTraceElement[] stackTrace;
        do {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if ((stackTraceElement.getClassName().equals("android.app.ActivityThread") && stackTraceElement.getMethodName().equals("handleBindApplication")) || stackTraceElement.getClassName().equals(cls.getName())) {
                    return true;
                }
            }
            th = th.getCause();
        } while (th != null);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void W() {
        Process.killProcess(Process.myPid());
        System.exit(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void X(String str, String str2) {
        try {
            PrintStream printStream = System.out;
            printStream.println("Post\u65b9\u5f0f\u8bf7\u6c42\u5730\u5740httpUrl--->" + str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            httpURLConnection.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(str2.getBytes());
            dataOutputStream.flush();
            dataOutputStream.close();
            if (httpURLConnection.getResponseCode() == 200) {
                String i02 = i0(httpURLConnection.getInputStream());
                PrintStream printStream2 = System.out;
                printStream2.println("Post\u65b9\u5f0f\u8bf7\u6c42\u6210\u529f\uff0cresult--->" + i02);
            } else {
                System.out.println("Post\u65b9\u5f0f\u8bf7\u6c42\u5931\u8d25");
            }
            httpURLConnection.disconnect();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void Y(Activity activity, Intent intent) {
        intent.addFlags(268468224);
        activity.finish();
        activity.startActivity(intent);
        W();
    }

    public static void Z(boolean z3) {
        f1994l = z3;
    }

    public static void a0(int i4) {
    }

    public static void b0(String str) {
        f1996n = str;
    }

    public static void c0(String[] strArr) {
        f1995m = strArr;
    }

    public static void d0(boolean z3) {
    }

    public static void e0(Class<? extends Activity> cls) {
    }

    public static void f0(boolean z3) {
    }

    public static void g0(Class<? extends Activity> cls) {
    }

    public static void h0(boolean z3) {
    }

    public static String i0(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.close();
                    inputStream.close();
                    return new String(byteArrayOutputStream.toByteArray());
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static String t(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    public static void u(Activity activity) {
        activity.finish();
        W();
    }

    public static String v(Context context, String str) {
        SimpleDateFormat simpleDateFormat;
        Date date = new Date();
        String x3 = x(context, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA));
        String str2 = "ApplicationName: " + y(context) + " \n";
        return ((((((str2 + "Build version: " + N(context) + " \n") + "Build date: " + x3 + " \n") + "Current date: " + simpleDateFormat.format(date) + " \n") + "Device: " + C() + " \n") + "SupportedAbis: " + M() + " \n\n") + "Stack trace:  \n") + str;
    }

    public static String w(Context context, Intent intent) {
        SimpleDateFormat simpleDateFormat;
        Date date = new Date();
        String x3 = x(context, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA));
        String str = "ApplicationName: " + y(context) + " \n";
        return ((((((str + "Build version: " + N(context) + " \n") + "Build date: " + x3 + " \n") + "Current date: " + simpleDateFormat.format(date) + " \n") + "Device: " + C() + " \n") + "SupportedAbis: " + M() + " \n\n") + "Stack trace:  \n") + L(intent);
    }

    public static String x(Context context, DateFormat dateFormat) {
        long j4;
        try {
            j4 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            j4 = 0;
        }
        return dateFormat.format(new Date(j4));
    }

    public static String y(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = context.getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    private static String z(Context context, DateFormat dateFormat) {
        try {
            ZipFile zipFile = new ZipFile(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir);
            String format = dateFormat.format(new Date(zipFile.getEntry("classes.dex").getTime()));
            zipFile.close();
            return format;
        } catch (Exception unused) {
            return "Unknown";
        }
    }
}
