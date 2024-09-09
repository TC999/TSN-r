package com.bytedance.sdk.component.panglearmor;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static int f30007a = 1012;
    public static int bk = 1013;

    /* renamed from: c  reason: collision with root package name */
    public static int f30008c = 1001;
    public static int ev = 1008;

    /* renamed from: f  reason: collision with root package name */
    public static int f30009f = 1006;
    private static String fp = "";
    private static int fz = 0;
    public static int gd = 1009;

    /* renamed from: i  reason: collision with root package name */
    private static volatile DisplayManager.DisplayListener f30010i = null;
    private static String ia = "";

    /* renamed from: j  reason: collision with root package name */
    private static String f30011j = null;

    /* renamed from: k  reason: collision with root package name */
    public static int f30012k = 1011;

    /* renamed from: p  reason: collision with root package name */
    public static int f30013p = 1010;

    /* renamed from: q  reason: collision with root package name */
    private static volatile boolean f30014q = false;

    /* renamed from: r  reason: collision with root package name */
    public static int f30015r = 1007;

    /* renamed from: s  reason: collision with root package name */
    private static long f30016s = 0;
    public static int sr = 1004;

    /* renamed from: t  reason: collision with root package name */
    private static String f30017t = "";

    /* renamed from: u  reason: collision with root package name */
    private static w f30018u = null;
    public static int ux = 1005;

    /* renamed from: w  reason: collision with root package name */
    public static int f30019w = 1002;
    public static int xv = 1003;
    private static Context ys;

    public static int ev() {
        return fz;
    }

    public static String f() {
        return fp;
    }

    public static long r() {
        return f30016s;
    }

    public static String sr() {
        if (f30011j == null) {
            f30011j = c(f30012k, new Object[0]);
        }
        String str = f30011j;
        return str != null ? str : "";
    }

    public static Context ux() {
        return ys;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public static void w(Handler handler) {
        if (!ev.w() || f30014q || ux() == null) {
            return;
        }
        f30014q = true;
        if (f30010i == null) {
            f30010i = new DisplayManager.DisplayListener() { // from class: com.bytedance.sdk.component.panglearmor.f.2
                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayAdded(int i4) {
                    if (i4 != 0) {
                        try {
                            f.c(f.xv, new Object[]{Integer.valueOf(i4), f.ux()});
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayChanged(int i4) {
                    if (i4 != 0) {
                        try {
                            f.c(f.ux, new Object[]{Integer.valueOf(i4), f.ux()});
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayRemoved(int i4) {
                    if (i4 != 0) {
                        try {
                            f.c(f.sr, new Object[]{Integer.valueOf(i4), f.ux()});
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            };
        }
        ((DisplayManager) ux().getSystemService("display")).registerDisplayListener(f30010i, handler);
    }

    public static JSONObject xv() {
        return SoftDecTool.gdh();
    }

    public static void c(Context context, String str, String str2) {
        ys = context;
        ia = str;
        fp = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @DungeonFlag
    public static String w(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stts", 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            f30017t = Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable th2) {
            th2.printStackTrace();
            f30017t = "eyJzdHRzIjozfQ==";
        }
        return f30017t;
    }

    @DungeonFlag
    public static String c() {
        if (ev.w()) {
            final Handler c4 = com.bytedance.sdk.component.utils.ev.c();
            c4.post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.f.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        w unused = f.f30018u = w.c((Application) f.ys);
                        f.w(c4);
                        ux.c(f.ys);
                        String unused2 = f.f30017t = f.c(f.f30008c, new Object[]{f.ys});
                    } catch (Throwable th) {
                        String unused3 = f.f30017t = f.w(th);
                    }
                }
            });
        }
        if (TextUtils.isEmpty(f30017t)) {
            String gc = SoftDecTool.gc();
            if (!TextUtils.isEmpty(gc)) {
                f30017t = gc;
            }
        }
        return TextUtils.isEmpty(f30017t) ? "eyJzdHRzIjoxfQ==" : f30017t;
    }

    @DungeonFlag
    public static String c(int i4, Object[] objArr) {
        return SoftDecTool.cn(i4, objArr);
    }

    public static String w() {
        return c(f30007a, new Object[0]);
    }

    @DungeonFlag
    public static void c(final MotionEvent motionEvent) {
        if (motionEvent == null || !ev.w() || ux() == null) {
            return;
        }
        if (motionEvent.getRawX() > 0.0f || motionEvent.getRawY() > 0.0f) {
            com.bytedance.sdk.component.utils.ev.c().post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.f.3
                @Override // java.lang.Runnable
                public void run() {
                    f.c(f.f30019w, new Object[]{Integer.valueOf(motionEvent.getDeviceId()), f.ux()});
                }
            });
        }
    }

    @DungeonFlag
    public static void c(long j4, int i4) {
        f30016s = j4;
        fz = i4;
    }

    public static String c(String str, long j4, int i4, boolean z3) {
        try {
            w wVar = f30018u;
            if (wVar != null) {
                return wVar.c(str, j4, i4, z3);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(String str, String str2) {
        String c4 = c(f30013p, new String[]{str, str2});
        return c4 == null ? str2 : c4;
    }
}
