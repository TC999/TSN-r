package com.baidu.liantian;

import android.R;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Window;
import com.amap.api.col.p0003l.f4;
import com.baidu.liantian.b.r;
import com.baidu.liantian.core.ApkInfo;
import com.baidu.liantian.core.g;
import com.stub.StubApp;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class LiantianActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f12075a = false;

    /* renamed from: b  reason: collision with root package name */
    protected a f12076b = new a();

    /* renamed from: c  reason: collision with root package name */
    protected Activity f12077c = null;

    /* renamed from: d  reason: collision with root package name */
    protected Configuration f12078d = null;

    /* renamed from: e  reason: collision with root package name */
    protected ActivityInfo f12079e = null;

    /* renamed from: q  reason: collision with root package name */
    private Resources f12080q;

    /* renamed from: i  reason: collision with root package name */
    public static Method f12067i = f.a((Class<?>) Activity.class, "onCreate", (Class<?>[]) new Class[]{Bundle.class});

    /* renamed from: j  reason: collision with root package name */
    public static Method f12068j = f.a((Class<?>) Activity.class, "onPostCreate", (Class<?>[]) new Class[]{Bundle.class});

    /* renamed from: k  reason: collision with root package name */
    public static Method f12069k = f.a((Class<?>) Activity.class, "onStart", (Class<?>[]) new Class[0]);

    /* renamed from: l  reason: collision with root package name */
    public static Method f12070l = f.a((Class<?>) Activity.class, "onResume", (Class<?>[]) new Class[0]);

    /* renamed from: m  reason: collision with root package name */
    public static Method f12071m = f.a((Class<?>) Activity.class, "onPostResume", (Class<?>[]) new Class[0]);

    /* renamed from: n  reason: collision with root package name */
    public static Method f12072n = f.a((Class<?>) Activity.class, "onPause", (Class<?>[]) new Class[0]);

    /* renamed from: o  reason: collision with root package name */
    public static Method f12073o = f.a((Class<?>) Activity.class, "onStop", (Class<?>[]) new Class[0]);

    /* renamed from: p  reason: collision with root package name */
    public static Method f12074p = f.a((Class<?>) Activity.class, "onDestroy", (Class<?>[]) new Class[0]);

    /* renamed from: f  reason: collision with root package name */
    public static Field f12064f = f.a(Activity.class, "mCurrentConfig");

    /* renamed from: g  reason: collision with root package name */
    public static Field f12065g = f.a(Activity.class, "mConfigChangeFlags");

    /* renamed from: h  reason: collision with root package name */
    public static Field f12066h = f.a(Activity.class, "mCalled");

    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f12083a = false;

        /* renamed from: b  reason: collision with root package name */
        public String f12084b;

        /* renamed from: c  reason: collision with root package name */
        public String f12085c;

        /* renamed from: d  reason: collision with root package name */
        public String f12086d;

        /* renamed from: e  reason: collision with root package name */
        public Intent f12087e;

        public final String toString() {
            try {
                return a.class.getSimpleName() + ": mode=" + this.f12083a + ", activity=" + this.f12084b + ", path=" + this.f12085c + ",pkgName=" + this.f12086d;
            } catch (Throwable unused) {
                com.baidu.liantian.b.e.a();
                return "";
            }
        }
    }

    private static boolean a(a aVar, Intent intent) {
        try {
            String stringExtra = intent.getStringExtra("from_plugin_package");
            String stringExtra2 = intent.getStringExtra("target_class");
            if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2)) {
                aVar.f12083a = true;
                aVar.f12086d = stringExtra;
                aVar.f12084b = stringExtra2;
                aVar.f12087e = intent;
                return true;
            }
            return false;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return false;
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        boolean z3;
        try {
            super.onConfigurationChanged(configuration);
            if (!this.f12075a || this.f12077c == null) {
                return;
            }
            if (!a(configuration)) {
                boolean z4 = true;
                f12066h.setBoolean(this.f12077c, false);
                this.f12077c.onConfigurationChanged(configuration);
                try {
                    z3 = f12066h.getBoolean(this.f12077c);
                    z4 = false;
                } catch (Throwable th) {
                    th.getMessage();
                    b.b();
                    z3 = false;
                }
                if (z4 || z3) {
                    try {
                        f12065g.setInt(this.f12077c, 0);
                    } catch (Throwable th2) {
                        th2.getMessage();
                        b.b();
                    }
                    try {
                        f12064f.set(this.f12077c, new Configuration(configuration));
                    } catch (Throwable th3) {
                        th3.getMessage();
                        b.b();
                    }
                }
            }
            Configuration configuration2 = this.f12078d;
            if (configuration2 != null) {
                configuration2.updateFrom(configuration);
            }
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        ActivityInfo[] activityInfoArr;
        String str;
        ActivityInfo activityInfo;
        Method method;
        try {
            b.a();
            final Intent intent = getIntent();
            if ("a".equals(intent.getStringExtra("t"))) {
                final Context origApplicationContext = StubApp.getOrigApplicationContext(getApplicationContext());
                r.a().a(new Runnable() { // from class: com.baidu.liantian.LiantianActivity.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            intent.toString();
                            b.a();
                            String stringExtra = intent.getStringExtra("c");
                            Intent intent2 = new Intent();
                            intent2.putExtra("t", "a");
                            intent2.putExtra("c", stringExtra);
                            com.baidu.liantian.a.a(StubApp.getOrigApplicationContext(origApplicationContext.getApplicationContext()), intent2);
                        } catch (Throwable unused) {
                            com.baidu.liantian.b.e.a();
                        }
                    }
                });
            }
            g a4 = g.a();
            if (a4 == null) {
                b.a();
                super.onCreate(bundle);
                finish();
                return;
            }
            a(this.f12076b, intent);
            this.f12076b.toString();
            b.a();
            if (TextUtils.isEmpty(this.f12076b.f12086d)) {
                b.a();
                super.onCreate(bundle);
                finish();
                return;
            }
            ApkInfo d4 = a4.d(this.f12076b.f12086d);
            if (d4 != null && (activityInfoArr = d4.activities) != null) {
                int length = activityInfoArr.length;
                int i4 = 0;
                while (true) {
                    str = null;
                    if (i4 >= length) {
                        activityInfo = null;
                        break;
                    }
                    activityInfo = activityInfoArr[i4];
                    if (activityInfo.name.equals(this.f12076b.f12084b)) {
                        break;
                    }
                    i4++;
                }
                if (activityInfo == null) {
                    b.a();
                    super.onCreate(bundle);
                    finish();
                    return;
                }
                this.f12079e = activityInfo;
                int i5 = activityInfo.theme;
                if (i5 == 0) {
                    i5 = d4.applicationTheme;
                }
                if (i5 == 0) {
                    i5 = 16973829;
                }
                setTheme(i5);
                this.f12075a = true;
                Object newInstance = d4.classLoader.loadClass(this.f12076b.f12084b).newInstance();
                if (!(newInstance instanceof Activity)) {
                    newInstance.toString();
                    b.a();
                    finish();
                    return;
                }
                this.f12077c = (Activity) newInstance;
                Activity activity = (Activity) newInstance;
                f.a(this, activity);
                Field a5 = f.a(ContextThemeWrapper.class, "mInflater");
                Field a6 = f.a(ContextThemeWrapper.class, "mTheme");
                Field a7 = f.a(ContextThemeWrapper.class, "mResources");
                if (a5 != null) {
                    try {
                        a5.set(activity, null);
                    } catch (Throwable th) {
                        th.getMessage();
                        b.b();
                    }
                }
                if (a6 != null) {
                    a6.set(activity, null);
                }
                if (a7 != null) {
                    Resources resources = getResources();
                    AssetManager assetManager = new AssetManager();
                    assetManager.addAssetPath(d4.pkgPath);
                    b.a();
                    this.f12080q = new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
                    f4.a(this.f12080q);
                    b.a();
                    if (activityInfo.labelRes > 0) {
                        this.f12080q.getString(activityInfo.labelRes);
                        b.a();
                    }
                    a7.set(activity, this.f12080q);
                }
                activity.setTheme(i5);
                activity.getTheme().applyStyle(i5, true);
                b.a();
                Window window = activity.getWindow();
                Field a8 = f.a(window.getClass(), "mLayoutInflater");
                if (a8 != null) {
                    a8.setAccessible(true);
                    try {
                        a8.set(window, ((LayoutInflater) a8.get(window)).cloneInContext(activity));
                    } catch (Throwable th2) {
                        th2.getMessage();
                        b.b();
                    }
                }
                Field a9 = f.a(Window.class, "mCallback");
                if (a9 != null) {
                    try {
                        a9.set(activity.getWindow(), this.f12077c);
                    } catch (IllegalAccessException | IllegalArgumentException unused) {
                    }
                }
                Field a10 = f.a(Activity.class, "mActivityInfo");
                if (a10 != null) {
                    try {
                        a10.set(activity, activityInfo);
                    } catch (Throwable th3) {
                        th3.getMessage();
                        b.b();
                    }
                }
                Field a11 = f.a(Activity.class, "mComponent");
                if (a11 != null) {
                    try {
                        a11.set(activity, new ComponentName(activityInfo.packageName, activityInfo.name));
                    } catch (Throwable th4) {
                        th4.getMessage();
                        b.b();
                    }
                }
                Field a12 = f.a(Activity.class, "mTitle");
                if (a12 != null) {
                    CharSequence charSequence = activityInfo.nonLocalizedLabel;
                    if (charSequence != null) {
                        str = charSequence.toString();
                    } else if (activityInfo.labelRes != 0) {
                        if (this.f12080q != null) {
                            b.a();
                            f4.a(this.f12080q);
                            b.a();
                            str = this.f12080q.getString(activityInfo.labelRes);
                        }
                    } else {
                        str = activityInfo.name;
                        if (str == null) {
                            str = activityInfo.packageName;
                        }
                    }
                    try {
                        a12.set(activity, str);
                    } catch (Throwable th5) {
                        th5.getMessage();
                        b.b();
                    }
                }
                Window window2 = activity.getWindow();
                TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(R.styleable.Window);
                Field a13 = f.a(activity.getWindow().getClass(), "mWindowStyle");
                if (a13 != null) {
                    try {
                        a13.set(window2, obtainStyledAttributes);
                    } catch (Throwable th6) {
                        th6.getMessage();
                        b.b();
                    }
                }
                this.f12076b.f12087e.setExtrasClassLoader(d4.classLoader);
                activity.setIntent(this.f12076b.f12087e);
                if (this.f12075a && (method = f12067i) != null && this.f12077c != null) {
                    method.invoke(newInstance, bundle);
                }
                super.onCreate(bundle);
                b.a();
                return;
            }
            b.a();
            super.onCreate(bundle);
            finish();
        } catch (Throwable unused2) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        Method method;
        Activity activity;
        try {
            super.onDestroy();
            if (!this.f12075a || (method = f12074p) == null || (activity = this.f12077c) == null) {
                return;
            }
            method.invoke(activity, new Object[0]);
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        Method method;
        Activity activity;
        try {
            super.onPause();
            if (!this.f12075a || (method = f12072n) == null || (activity = this.f12077c) == null) {
                return;
            }
            method.invoke(activity, new Object[0]);
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        Method method;
        Activity activity;
        try {
            super.onPostCreate(bundle);
            if (!this.f12075a || (method = f12068j) == null || (activity = this.f12077c) == null) {
                return;
            }
            method.invoke(activity, bundle);
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        Method method;
        Activity activity;
        try {
            super.onPostResume();
            if (!this.f12075a || (method = f12071m) == null || (activity = this.f12077c) == null) {
                return;
            }
            method.invoke(activity, new Object[0]);
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        Method method;
        Activity activity;
        try {
            super.onResume();
            if (!this.f12075a || (method = f12070l) == null || (activity = this.f12077c) == null) {
                return;
            }
            method.invoke(activity, new Object[0]);
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        Method method;
        Activity activity;
        try {
            super.onStart();
            if (!this.f12075a || (method = f12069k) == null || (activity = this.f12077c) == null) {
                return;
            }
            method.invoke(activity, new Object[0]);
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        Method method;
        Activity activity;
        try {
            super.onStop();
            if (!this.f12075a || (method = f12073o) == null || (activity = this.f12077c) == null) {
                return;
            }
            method.invoke(activity, new Object[0]);
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
        }
    }

    private boolean a(Configuration configuration) {
        try {
            Configuration configuration2 = this.f12078d;
            if (configuration2 == null) {
                return false;
            }
            int i4 = this.f12079e.configChanges;
            int diff = configuration2.diff(configuration);
            return diff != 0 && (diff & i4) == 0;
        } catch (Throwable unused) {
            com.baidu.liantian.b.e.a();
            return false;
        }
    }
}
