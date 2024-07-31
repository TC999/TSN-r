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
import cat.ereza.customactivityoncrash.C1085R;
import cn.bluemobi.dylan.uncaughtexception.activity.DefaultErrorActivity;
import com.baidu.mobads.sdk.internal.C2594an;
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
import p580d.C13570a;
import p588f.ReportByEmail;

@SuppressLint({"NewApi"})
/* renamed from: cn.bluemobi.dylan.uncaughtexception.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class CustomActivityOnCrash {

    /* renamed from: a */
    private static final String f2006a = "cat.ereza.customactivityoncrash.ERROR";

    /* renamed from: b */
    private static final String f2007b = "cat.ereza.customactivityoncrash.RESTART";

    /* renamed from: c */
    private static Application f2008c;

    /* renamed from: d */
    private static WeakReference<Activity> f2009d = new WeakReference<>(null);

    /* renamed from: e */
    private static boolean f2010e = false;

    /* renamed from: f */
    private static boolean f2011f = true;

    /* renamed from: g */
    private static boolean f2012g = true;

    /* renamed from: h */
    private static boolean f2013h = true;

    /* renamed from: i */
    private static int f2014i = C1085R.C1087drawable.customactivityoncrash_error_image;

    /* renamed from: j */
    private static Class<? extends Activity> f2015j = null;

    /* renamed from: k */
    private static Class<? extends Activity> f2016k = null;

    /* renamed from: l */
    private static boolean f2017l = true;

    /* renamed from: m */
    private static String[] f2018m;

    /* renamed from: n */
    private static String f2019n;

    /* compiled from: CustomActivityOnCrash.java */
    /* renamed from: cn.bluemobi.dylan.uncaughtexception.a$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1230a implements Thread.UncaughtExceptionHandler {

        /* renamed from: a */
        final /* synthetic */ Context f2020a;

        /* compiled from: CustomActivityOnCrash.java */
        /* renamed from: cn.bluemobi.dylan.uncaughtexception.a$a$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        class C1231a extends Thread {

            /* renamed from: a */
            final /* synthetic */ Throwable f2021a;

            C1231a(Throwable th) {
                this.f2021a = th;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                StringWriter stringWriter = new StringWriter();
                this.f2021a.printStackTrace(new PrintWriter(stringWriter));
                String stringWriter2 = stringWriter.toString();
                if (stringWriter2.length() > 131071) {
                    stringWriter2 = stringWriter2.substring(0, 131047) + " [stack trace too large]";
                }
                if (!TextUtils.isEmpty(CustomActivityOnCrash.m57440D())) {
                    CustomActivityOnCrash.m57420X(CustomActivityOnCrash.m57440D(), "{ \"msgtype\": \"text\", \"text\": {\"content\": \"" + CustomActivityOnCrash.m57387v(C1230a.this.f2020a, stringWriter2) + "\"}}");
                }
                ReportByEmail.m12781a(CustomActivityOnCrash.m57384y(C1230a.this.f2020a), CustomActivityOnCrash.m57387v(C1230a.this.f2020a, stringWriter2));
                CustomActivityOnCrash.m57421W();
                System.exit(0);
            }
        }

        C1230a(Context context) {
            this.f2020a = context;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            Log.e("CustomActivityOnCrash", "App has crashed, executing CustomActivityOnCrash's UncaughtExceptionHandler", th);
            if (!CustomActivityOnCrash.f2017l) {
                new C1231a(th).start();
                return;
            }
            if (CustomActivityOnCrash.f2015j == null) {
                Class unused = CustomActivityOnCrash.f2015j = CustomActivityOnCrash.m57429O(CustomActivityOnCrash.f2008c);
            }
            if (CustomActivityOnCrash.m57422V(th, CustomActivityOnCrash.f2015j)) {
                Log.e("CustomActivityOnCrash", "Your application class or your error activity have crashed, the custom activity will not be launched!");
            } else if (CustomActivityOnCrash.f2011f || !CustomActivityOnCrash.f2010e) {
                Intent intent = new Intent(CustomActivityOnCrash.f2008c, CustomActivityOnCrash.f2015j);
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                String stringWriter2 = stringWriter.toString();
                if (stringWriter2.length() > 131071) {
                    stringWriter2 = stringWriter2.substring(0, 131047) + " [stack trace too large]";
                }
                if (CustomActivityOnCrash.f2013h && CustomActivityOnCrash.f2016k == null) {
                    Class unused2 = CustomActivityOnCrash.f2016k = CustomActivityOnCrash.m57428P(CustomActivityOnCrash.f2008c);
                } else if (!CustomActivityOnCrash.f2013h) {
                    Class unused3 = CustomActivityOnCrash.f2016k = null;
                }
                intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_STACK_TRACE", stringWriter2);
                intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_RESTART_ACTIVITY_CLASS", CustomActivityOnCrash.f2016k);
                intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_SHOW_ERROR_DETAILS", CustomActivityOnCrash.f2012g);
                intent.putExtra("cat.ereza.customactivityoncrash.EXTRA_IMAGE_DRAWABLE_ID", CustomActivityOnCrash.f2014i);
                intent.setFlags(268468224);
                CustomActivityOnCrash.f2008c.startActivity(intent);
            }
            Activity activity = (Activity) CustomActivityOnCrash.f2009d.get();
            if (activity != null) {
                activity.finish();
                CustomActivityOnCrash.f2009d.clear();
            }
            CustomActivityOnCrash.m57421W();
        }
    }

    /* compiled from: CustomActivityOnCrash.java */
    /* renamed from: cn.bluemobi.dylan.uncaughtexception.a$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1232b implements Application.ActivityLifecycleCallbacks {

        /* renamed from: a */
        int f2023a = 0;

        C1232b() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity.getClass() != CustomActivityOnCrash.f2015j) {
                WeakReference unused = CustomActivityOnCrash.f2009d = new WeakReference(activity);
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
            int i = this.f2023a + 1;
            this.f2023a = i;
            boolean unused = CustomActivityOnCrash.f2010e = i == 0;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            int i = this.f2023a - 1;
            this.f2023a = i;
            boolean unused = CustomActivityOnCrash.f2010e = i == 0;
        }
    }

    /* renamed from: A */
    public static int m57443A() {
        return f2014i;
    }

    /* renamed from: B */
    public static int m57442B(Intent intent) {
        return intent.getIntExtra("cat.ereza.customactivityoncrash.EXTRA_IMAGE_DRAWABLE_ID", C1085R.C1087drawable.customactivityoncrash_error_image);
    }

    /* renamed from: C */
    private static String m57441C() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return m57389t(str2);
        }
        return m57389t(str) + " " + str2;
    }

    /* renamed from: D */
    public static String m57440D() {
        return f2019n;
    }

    /* renamed from: E */
    public static String[] m57439E() {
        return f2018m;
    }

    /* renamed from: F */
    public static Class<? extends Activity> m57438F() {
        return f2015j;
    }

    /* renamed from: G */
    private static Class<? extends Activity> m57437G(Context context) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent().setAction(f2006a).setPackage(context.getPackageName()), 64);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return null;
        }
        try {
            return Class.forName(queryIntentActivities.get(0).activityInfo.name);
        } catch (ClassNotFoundException e) {
            Log.e("CustomActivityOnCrash", "Failed when resolving the error activity class via intent filter, stack trace follows!", e);
            return null;
        }
    }

    /* renamed from: H */
    private static Class<? extends Activity> m57436H(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage != null) {
            try {
                return Class.forName(launchIntentForPackage.getComponent().getClassName());
            } catch (ClassNotFoundException e) {
                Log.e("CustomActivityOnCrash", "Failed when resolving the restart activity class via getLaunchIntentForPackage, stack trace follows!", e);
                return null;
            }
        }
        return null;
    }

    /* renamed from: I */
    public static Class<? extends Activity> m57435I() {
        return f2016k;
    }

    /* renamed from: J */
    public static Class<? extends Activity> m57434J(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("cat.ereza.customactivityoncrash.EXTRA_RESTART_ACTIVITY_CLASS");
        if (serializableExtra == null || !(serializableExtra instanceof Class)) {
            return null;
        }
        return (Class) serializableExtra;
    }

    /* renamed from: K */
    private static Class<? extends Activity> m57433K(Context context) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent().setAction(f2007b).setPackage(context.getPackageName()), 64);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            return null;
        }
        try {
            return Class.forName(queryIntentActivities.get(0).activityInfo.name);
        } catch (ClassNotFoundException e) {
            Log.e("CustomActivityOnCrash", "Failed when resolving the restart activity class via intent filter, stack trace follows!", e);
            return null;
        }
    }

    /* renamed from: L */
    public static String m57432L(Intent intent) {
        return intent.getStringExtra("cat.ereza.customactivityoncrash.EXTRA_STACK_TRACE");
    }

    /* renamed from: M */
    private static String m57431M() {
        return Arrays.toString(Build.SUPPORTED_ABIS);
    }

    /* renamed from: N */
    private static String m57430N(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public static Class<? extends Activity> m57429O(Context context) {
        Class<? extends Activity> m57437G = m57437G(context);
        return m57437G == null ? DefaultErrorActivity.class : m57437G;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: P */
    public static Class<? extends Activity> m57428P(Context context) {
        Class<? extends Activity> m57433K = m57433K(context);
        return m57433K == null ? m57436H(context) : m57433K;
    }

    /* renamed from: Q */
    public static void m57427Q(Context context) {
        try {
            if (context == null) {
                Log.e("CustomActivityOnCrash", "Install failed: context is null!");
                return;
            }
            Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (defaultUncaughtExceptionHandler != null && defaultUncaughtExceptionHandler.getClass().getName().startsWith(C13570a.f40100b)) {
                Log.e("CustomActivityOnCrash", "You have already installed CustomActivityOnCrash, doing nothing!");
                return;
            }
            if (defaultUncaughtExceptionHandler != null && !defaultUncaughtExceptionHandler.getClass().getName().startsWith("com.android.internal.os")) {
                Log.e("CustomActivityOnCrash", "IMPORTANT WARNING! You already have an UncaughtExceptionHandler, are you sure this is correct? If you use ACRA, Crashlytics or similar libraries, you must initialize them AFTER CustomActivityOnCrash! Installing anyway, but your original handler will not be called.");
            }
            f2008c = (Application) StubApp.getOrigApplicationContext(context.getApplicationContext());
            Thread.setDefaultUncaughtExceptionHandler(new C1230a(context));
            f2008c.registerActivityLifecycleCallbacks(new C1232b());
            Log.i("CustomActivityOnCrash", "CustomActivityOnCrash has been installed.");
        } catch (Throwable th) {
            Log.e("CustomActivityOnCrash", "An unknown error occurred while installing CustomActivityOnCrash, it may not have been properly initialized. Please report this as a bug if needed.", th);
        }
    }

    /* renamed from: R */
    public static boolean m57426R() {
        return f2013h;
    }

    /* renamed from: S */
    public static boolean m57425S() {
        return f2011f;
    }

    /* renamed from: T */
    public static boolean m57424T() {
        return f2012g;
    }

    /* renamed from: U */
    public static boolean m57423U(Intent intent) {
        return intent.getBooleanExtra("cat.ereza.customactivityoncrash.EXTRA_SHOW_ERROR_DETAILS", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: V */
    public static boolean m57422V(Throwable th, Class<? extends Activity> cls) {
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
    /* renamed from: W */
    public static void m57421W() {
        Process.killProcess(Process.myPid());
        System.exit(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: X */
    public static void m57420X(String str, String str2) {
        try {
            PrintStream printStream = System.out;
            printStream.println("Post方式请求地址httpUrl--->" + str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestProperty("Content-Type", C2594an.f8583d);
            httpURLConnection.connect();
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(str2.getBytes());
            dataOutputStream.flush();
            dataOutputStream.close();
            if (httpURLConnection.getResponseCode() == 200) {
                String m57400i0 = m57400i0(httpURLConnection.getInputStream());
                PrintStream printStream2 = System.out;
                printStream2.println("Post方式请求成功，result--->" + m57400i0);
            } else {
                System.out.println("Post方式请求失败");
            }
            httpURLConnection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: Y */
    public static void m57419Y(Activity activity, Intent intent) {
        intent.addFlags(268468224);
        activity.finish();
        activity.startActivity(intent);
        m57421W();
    }

    /* renamed from: Z */
    public static void m57418Z(boolean z) {
        f2017l = z;
    }

    /* renamed from: a0 */
    public static void m57416a0(int i) {
    }

    /* renamed from: b0 */
    public static void m57414b0(String str) {
        f2019n = str;
    }

    /* renamed from: c0 */
    public static void m57412c0(String[] strArr) {
        f2018m = strArr;
    }

    /* renamed from: d0 */
    public static void m57410d0(boolean z) {
    }

    /* renamed from: e0 */
    public static void m57408e0(Class<? extends Activity> cls) {
    }

    /* renamed from: f0 */
    public static void m57406f0(boolean z) {
    }

    /* renamed from: g0 */
    public static void m57404g0(Class<? extends Activity> cls) {
    }

    /* renamed from: h0 */
    public static void m57402h0(boolean z) {
    }

    /* renamed from: i0 */
    public static String m57400i0(InputStream inputStream) {
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: t */
    private static String m57389t(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        char charAt = str.charAt(0);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        return Character.toUpperCase(charAt) + str.substring(1);
    }

    /* renamed from: u */
    public static void m57388u(Activity activity) {
        activity.finish();
        m57421W();
    }

    /* renamed from: v */
    public static String m57387v(Context context, String str) {
        SimpleDateFormat simpleDateFormat;
        Date date = new Date();
        String m57385x = m57385x(context, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA));
        String str2 = "ApplicationName: " + m57384y(context) + " \n";
        return ((((((str2 + "Build version: " + m57430N(context) + " \n") + "Build date: " + m57385x + " \n") + "Current date: " + simpleDateFormat.format(date) + " \n") + "Device: " + m57441C() + " \n") + "SupportedAbis: " + m57431M() + " \n\n") + "Stack trace:  \n") + str;
    }

    /* renamed from: w */
    public static String m57386w(Context context, Intent intent) {
        SimpleDateFormat simpleDateFormat;
        Date date = new Date();
        String m57385x = m57385x(context, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA));
        String str = "ApplicationName: " + m57384y(context) + " \n";
        return ((((((str + "Build version: " + m57430N(context) + " \n") + "Build date: " + m57385x + " \n") + "Current date: " + simpleDateFormat.format(date) + " \n") + "Device: " + m57441C() + " \n") + "SupportedAbis: " + m57431M() + " \n\n") + "Stack trace:  \n") + m57432L(intent);
    }

    /* renamed from: x */
    public static String m57385x(Context context, DateFormat dateFormat) {
        long j;
        try {
            j = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            j = 0;
        }
        return dateFormat.format(new Date(j));
    }

    /* renamed from: y */
    public static String m57384y(Context context) {
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

    /* renamed from: z */
    private static String m57383z(Context context, DateFormat dateFormat) {
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
