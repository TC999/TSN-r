package com.acse.ottn.d.a;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.C1421ca;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.S;
import com.acse.ottn.util.V;
import com.acse.ottn.util.ra;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5404a = "LocationManager";

    /* renamed from: b  reason: collision with root package name */
    private static volatile f f5405b;

    /* renamed from: c  reason: collision with root package name */
    private static Long f5406c = 0L;

    /* renamed from: d  reason: collision with root package name */
    private static TimerTask f5407d = null;

    /* renamed from: e  reason: collision with root package name */
    private static AccessibilityNodeInfo f5408e;

    public static void a(AccessibilityService accessibilityService, long j4) {
        if (j4 - f5406c.longValue() < 1000) {
            ra.a("LocationManager", "\u95f4\u9694 t=" + j4 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            ra.a("LocationManager", "\u95f4\u9694 time=" + f5406c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f5406c.longValue()));
            return;
        }
        ra.a("LocationManager", "\u65e0\u95f4\u9694 t=" + j4 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        ra.a("LocationManager", "\u65e0\u95f4\u9694 time=" + f5406c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f5406c.longValue()));
        f5406c = Long.valueOf(j4);
        C1442n.c().a(200L);
        AccessibilityNodeInfo h4 = C1442n.c().h(accessibilityService, "\u59cb\u7ec8\u5141\u8bb8");
        if (h4 != null) {
            C1442n.c().f(h4);
            b(accessibilityService, 2);
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            f5407d = S.a().b(V.a().b(3000), V.a().b(300), new b(accessibilityService, null));
        }
    }

    public static void a(AccessibilityService accessibilityService, boolean z3) {
        b(accessibilityService, z3);
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
            if (accessibilityNodeInfo.getChild(i4) != null) {
                if ("androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getClassName())) {
                    f5408e = accessibilityNodeInfo;
                    return;
                }
                a(accessibilityNodeInfo.getChild(i4));
            }
        }
    }

    public static void b(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo a4 = C1442n.c().a(accessibilityService, "\u59cb\u7ec8\u5141\u8bb8", true);
        if (a4 != null) {
            C1442n.c().f(a4);
            b(accessibilityService, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(AccessibilityService accessibilityService, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            C1442n.c().a(V.a().b(200));
            C1442n.c().d(accessibilityService);
        }
    }

    @SuppressLint({"NewApi"})
    private static void b(AccessibilityService accessibilityService, boolean z3) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        C1442n.c().a(V.a().b(200));
        if (z3) {
            a(accessibilityService, rootInActiveWindow);
        } else {
            i(accessibilityService);
        }
    }

    public static void b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            ra.a("LocationManager", "recycle2 info.getChildCount()=" + accessibilityNodeInfo.toString());
            if (accessibilityNodeInfo.getText() != null) {
                ra.a("LocationManager", "getText=" + accessibilityNodeInfo.getText().toString().trim());
            }
            if (accessibilityNodeInfo.getContentDescription() != null) {
                ra.a("LocationManager", "getContentDescription=" + accessibilityNodeInfo.getContentDescription().toString().trim());
            }
        } else if (accessibilityNodeInfo != null) {
            ra.a("LocationManager", "recycle1 info.getChildCount()=" + accessibilityNodeInfo.getChildCount());
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    ra.a("LocationManager", "info.getChild(i)=" + accessibilityNodeInfo.getChild(i4).toString().trim());
                    ra.a("LocationManager", "info.getChild(i)=" + accessibilityNodeInfo.getChild(i4).getChildCount());
                    b(accessibilityNodeInfo.getChild(i4));
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static AccessibilityNodeInfo c(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if (accessibilityNodeInfo.getChild(i4) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i4).getClassName()) && accessibilityNodeInfo.getChild(i4).isScrollable()) {
                    return accessibilityNodeInfo.getChild(i4);
                }
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    c(accessibilityNodeInfo.getChild(i4));
                }
            }
            return null;
        }
        return null;
    }

    public static f c() {
        if (f5405b == null) {
            synchronized (f.class) {
                if (f5405b == null) {
                    f5405b = new f();
                }
            }
        }
        return f5405b;
    }

    @RequiresApi(api = 16)
    public static void c(AccessibilityService accessibilityService) {
        TimerTask timerTask = f5407d;
        if (timerTask != null) {
            timerTask.cancel();
            f5407d = null;
        }
        f5407d = S.a().b(V.a().b(6000), V.a().b(100), new a(accessibilityService, C1419ba.a().d("OpenPermissionName")));
    }

    public static void d(AccessibilityService accessibilityService) {
        ra.a("LocationManager", "clickVivoLocation");
        TimerTask timerTask = f5407d;
        if (timerTask != null) {
            timerTask.cancel();
            f5407d = null;
        }
        f5407d = S.a().b(V.a().b(900), V.a().b(300), new e(accessibilityService));
    }

    @RequiresApi(api = 16)
    public static void e(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = C1442n.c().g(accessibilityService, "\u4f4d\u7f6e");
        if (g4 != null) {
            C1442n.c().f(g4);
            C1442n.c().a(500L);
            a(accessibilityService, System.currentTimeMillis());
            C1419ba.a().a("battery_white", true);
            C1419ba.a().a("is_pengpai", true);
            return;
        }
        TimerTask timerTask = f5407d;
        if (timerTask != null) {
            timerTask.cancel();
            f5407d = null;
        }
        f5407d = S.a().b(V.a().b(2000), V.a().b(300), new d(C1419ba.a().d("OpenPermissionName"), accessibilityService));
    }

    @RequiresApi(api = 16)
    public static void f(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = C1442n.c().g(accessibilityService, "\u6743\u9650\u7ba1\u7406");
        AccessibilityNodeInfo g5 = C1442n.c().g(accessibilityService, "\u5e94\u7528\u6743\u9650");
        AccessibilityNodeInfo g6 = C1442n.c().g(accessibilityService, "\u6743\u9650");
        if (g4 != null) {
            ra.a("LocationManager", "openOppoLocationManage nodeInfo is not null");
            C1419ba.a().a("battery_white", true);
            C1442n.c().f(g4);
        } else if (g5 != null) {
            ra.a("LocationManager", "openOppoLocationManage nodeInfo1 is not null");
            C1419ba.a().a("battery_white", true);
            C1442n.c().f(g5);
        } else if (g6 == null) {
            return;
        } else {
            ra.a("LocationManager", "openOppoLocationManage nodeInfo2 is not null");
            C1419ba.a().a("battery_white", true);
            C1442n.c().f(g6);
        }
        C1442n.c().a(300L);
    }

    public static void g(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo h4 = C1442n.c().h(accessibilityService, "\u59cb\u7ec8\u5141\u8bb8");
        if (h4 != null) {
            C1442n.c().a(500L);
            C1442n.c().f(h4);
            AccessibilityNodeInfo h5 = C1442n.c().h(accessibilityService, "\u786e\u5b9a");
            if (h5 != null) {
                C1442n.c().f(h5);
            }
            b(accessibilityService, 4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0085, code lost:
        if ("oneplus".equals(com.acse.ottn.util.Ka.b()) != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x010e, code lost:
        if ("oneplus".equals(com.acse.ottn.util.Ka.b()) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void h(android.accessibilityservice.AccessibilityService r12) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.d.a.f.h(android.accessibilityservice.AccessibilityService):void");
    }

    private static void i(AccessibilityService accessibilityService) {
        f5407d = S.a().b(V.a().b(AVMDLDataLoader.KeyIsLiveSetLoaderType), V.a().b(100), new c(accessibilityService, C1421ca.c().b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public static void j(AccessibilityService accessibilityService) {
        a(accessibilityService.getRootInActiveWindow());
    }

    @SuppressLint({"NewApi"})
    private static void k(AccessibilityService accessibilityService) {
        ra.a("LocationManager", "getPacketw");
        b(accessibilityService.getRootInActiveWindow());
    }
}
