package com.bytedance.sdk.component.panglearmor;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.util.ArrayMap;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.stub.StubApp;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static volatile xv f30027c;

    /* renamed from: w  reason: collision with root package name */
    private final ArrayList<String> f30032w = new ArrayList<>();
    private final AtomicBoolean xv = new AtomicBoolean(false);
    private long sr = System.currentTimeMillis();
    private long ux = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f30028f = 0;

    /* renamed from: r  reason: collision with root package name */
    private String f30031r = "";
    private String ev = "";
    private String gd = "";

    /* renamed from: p  reason: collision with root package name */
    private boolean f30030p = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f30029k = false;

    public static xv c(Application application) {
        if (f30027c == null) {
            synchronized (xv.class) {
                if (f30027c == null) {
                    f30027c = new xv();
                    f30027c.f30030p = gd.c(application);
                    f30027c.f30029k = gd.c(StubApp.getOrigApplicationContext(application.getApplicationContext()), "android.permission.SYSTEM_ALERT_WINDOW") == 0;
                    f30027c.c();
                }
            }
        }
        return f30027c;
    }

    public void w(@ForbidWrapParam Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.f30032w.contains(localClassName)) {
            this.f30032w.remove(localClassName);
        }
        if (this.f30032w.size() == 0) {
            this.sr = System.currentTimeMillis();
            this.xv.set(true);
            this.ev = localClassName;
        }
    }

    public void c(@ForbidWrapParam Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.f30032w.size() == 0) {
            this.f30031r = localClassName;
            this.ux = System.currentTimeMillis();
            this.f30028f = System.currentTimeMillis() - this.sr;
            this.xv.set(false);
        }
        if (!this.f30032w.contains(localClassName)) {
            this.f30032w.add(localClassName);
        }
        this.gd = localClassName;
    }

    private void c() {
        int size;
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Class<?> cls = Class.forName("android.app.ActivityThread");
                Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(null, new Object[0]);
                Field declaredField = cls.getDeclaredField("mActivities");
                declaredField.setAccessible(true);
                ArrayMap arrayMap = (ArrayMap) declaredField.get(invoke);
                if (arrayMap != null && (size = arrayMap.size()) > 0) {
                    Class<?> cls2 = Class.forName("android.app.ActivityThread$ActivityClientRecord");
                    Field declaredField2 = cls2.getDeclaredField("stopped");
                    declaredField2.setAccessible(true);
                    Field declaredField3 = cls2.getDeclaredField("activity");
                    declaredField3.setAccessible(true);
                    for (int i4 = 0; i4 < size; i4++) {
                        Object valueAt = arrayMap.valueAt(i4);
                        if (!((Boolean) declaredField2.get(valueAt)).booleanValue()) {
                            String localClassName = ((Activity) declaredField3.get(valueAt)).getLocalClassName();
                            if (!this.f30032w.contains(localClassName)) {
                                this.f30032w.add(localClassName);
                            }
                        }
                    }
                    this.xv.set(this.f30032w.size() <= 0);
                }
            } catch (Exception unused) {
            }
        }
    }

    public String c(String str, long j4, int i4, boolean z3) {
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        long j5 = currentTimeMillis - this.ux;
        long j6 = currentTimeMillis - j4;
        int i5 = j6 < 500 ? 1 : 0;
        if (this.xv.get() && this.f30029k) {
            i5 |= 2;
        }
        if (!this.xv.get() && this.f30028f >= 5000 && j5 < 1000) {
            i5 = this.ev.equals(this.gd) ? i5 | 4 : i5 | 8;
        }
        try {
            str2 = new JSONObject().put("rst", i5).put("bakdur", this.f30028f).put("popt", j5).put("uct", j6).put("isbak", this.xv).put("alert", this.f30029k).put("rit", i4).put("tag", str).put("sys", this.f30030p).put("size", this.f30032w.size()).put("mutipro", z3).toString();
        } catch (JSONException unused) {
            str2 = "";
        }
        this.f30031r = "";
        this.f30028f = 0L;
        this.ux = 0L;
        this.sr = System.currentTimeMillis();
        return str2;
    }
}
