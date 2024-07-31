package com.acse.ottn.p042d.p043a;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1652V;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1663ca;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import com.p518qq.p519e.comm.constants.ErrorCode;
import java.util.TimerTask;

/* renamed from: com.acse.ottn.d.a.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1490f {

    /* renamed from: a */
    private static final String f2732a = "LocationManager";

    /* renamed from: b */
    private static volatile C1490f f2733b;

    /* renamed from: c */
    private static Long f2734c = 0L;

    /* renamed from: d */
    private static TimerTask f2735d = null;

    /* renamed from: e */
    private static AccessibilityNodeInfo f2736e;

    /* renamed from: a */
    public static void m56676a(AccessibilityService accessibilityService, long j) {
        if (j - f2734c.longValue() < 1000) {
            C1694ra.m55917a(f2732a, "间隔 t=" + j + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            C1694ra.m55917a(f2732a, "间隔 time=" + f2734c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f2734c.longValue()));
            return;
        }
        C1694ra.m55917a(f2732a, "无间隔 t=" + j + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        C1694ra.m55917a(f2732a, "无间隔 time=" + f2734c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f2734c.longValue()));
        f2734c = Long.valueOf(j);
        C1684n.m55975c().m56005a(200L);
        AccessibilityNodeInfo m55953h = C1684n.m55975c().m55953h(accessibilityService, "始终允许");
        if (m55953h != null) {
            C1684n.m55975c().m55958f(m55953h);
            m56669b(accessibilityService, 2);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m56675a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            f2735d = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(3000), C1652V.m56140a().m56132b(300), new C1486b(accessibilityService, null));
        }
    }

    /* renamed from: a */
    public static void m56674a(AccessibilityService accessibilityService, boolean z) {
        m56668b(accessibilityService, z);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m56673a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
            if (accessibilityNodeInfo.getChild(i) != null) {
                if ("androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getClassName())) {
                    f2736e = accessibilityNodeInfo;
                    return;
                }
                m56673a(accessibilityNodeInfo.getChild(i));
            }
        }
    }

    /* renamed from: b */
    public static void m56670b(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo m55996a = C1684n.m55975c().m55996a(accessibilityService, "始终允许", true);
        if (m55996a != null) {
            C1684n.m55975c().m55958f(m55996a);
            m56669b(accessibilityService, 4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m56669b(AccessibilityService accessibilityService, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(200));
            C1684n.m55975c().m55969d(accessibilityService);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    private static void m56668b(AccessibilityService accessibilityService, boolean z) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(200));
        if (z) {
            m56675a(accessibilityService, rootInActiveWindow);
        } else {
            m56658i(accessibilityService);
        }
    }

    /* renamed from: b */
    public static void m56667b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            C1694ra.m55917a(f2732a, "recycle2 info.getChildCount()=" + accessibilityNodeInfo.toString());
            if (accessibilityNodeInfo.getText() != null) {
                C1694ra.m55917a(f2732a, "getText=" + accessibilityNodeInfo.getText().toString().trim());
            }
            if (accessibilityNodeInfo.getContentDescription() != null) {
                C1694ra.m55917a(f2732a, "getContentDescription=" + accessibilityNodeInfo.getContentDescription().toString().trim());
            }
        } else if (accessibilityNodeInfo != null) {
            C1694ra.m55917a(f2732a, "recycle1 info.getChildCount()=" + accessibilityNodeInfo.getChildCount());
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                if (accessibilityNodeInfo.getChild(i) != null) {
                    C1694ra.m55917a(f2732a, "info.getChild(i)=" + accessibilityNodeInfo.getChild(i).toString().trim());
                    C1694ra.m55917a(f2732a, "info.getChild(i)=" + accessibilityNodeInfo.getChild(i).getChildCount());
                    m56667b(accessibilityNodeInfo.getChild(i));
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    public static AccessibilityNodeInfo m56664c(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                if (accessibilityNodeInfo.getChild(i) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i).getClassName()) && accessibilityNodeInfo.getChild(i).isScrollable()) {
                    return accessibilityNodeInfo.getChild(i);
                }
                if (accessibilityNodeInfo.getChild(i) != null) {
                    m56664c(accessibilityNodeInfo.getChild(i));
                }
            }
            return null;
        }
        return null;
    }

    /* renamed from: c */
    public static C1490f m56666c() {
        if (f2733b == null) {
            synchronized (C1490f.class) {
                if (f2733b == null) {
                    f2733b = new C1490f();
                }
            }
        }
        return f2733b;
    }

    @RequiresApi(api = 16)
    /* renamed from: c */
    public static void m56665c(AccessibilityService accessibilityService) {
        TimerTask timerTask = f2735d;
        if (timerTask != null) {
            timerTask.cancel();
            f2735d = null;
        }
        f2735d = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(ErrorCode.UNKNOWN_ERROR), C1652V.m56140a().m56132b(100), new C1485a(accessibilityService, C1661ba.m56097a().m56086d("OpenPermissionName")));
    }

    /* renamed from: d */
    public static void m56663d(AccessibilityService accessibilityService) {
        C1694ra.m55917a(f2732a, "clickVivoLocation");
        TimerTask timerTask = f2735d;
        if (timerTask != null) {
            timerTask.cancel();
            f2735d = null;
        }
        f2735d = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(900), C1652V.m56140a().m56132b(300), new C1489e(accessibilityService));
    }

    @RequiresApi(api = 16)
    /* renamed from: e */
    public static void m56662e(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(accessibilityService, "位置");
        if (m55955g != null) {
            C1684n.m55975c().m55958f(m55955g);
            C1684n.m55975c().m56005a(500L);
            m56676a(accessibilityService, System.currentTimeMillis());
            C1661ba.m56097a().m56092a("battery_white", true);
            C1661ba.m56097a().m56092a("is_pengpai", true);
            return;
        }
        TimerTask timerTask = f2735d;
        if (timerTask != null) {
            timerTask.cancel();
            f2735d = null;
        }
        f2735d = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(2000), C1652V.m56140a().m56132b(300), new C1488d(C1661ba.m56097a().m56086d("OpenPermissionName"), accessibilityService));
    }

    @RequiresApi(api = 16)
    /* renamed from: f */
    public static void m56661f(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(accessibilityService, "权限管理");
        AccessibilityNodeInfo m55955g2 = C1684n.m55975c().m55955g(accessibilityService, "应用权限");
        AccessibilityNodeInfo m55955g3 = C1684n.m55975c().m55955g(accessibilityService, "权限");
        if (m55955g != null) {
            C1694ra.m55917a(f2732a, "openOppoLocationManage nodeInfo is not null");
            C1661ba.m56097a().m56092a("battery_white", true);
            C1684n.m55975c().m55958f(m55955g);
        } else if (m55955g2 != null) {
            C1694ra.m55917a(f2732a, "openOppoLocationManage nodeInfo1 is not null");
            C1661ba.m56097a().m56092a("battery_white", true);
            C1684n.m55975c().m55958f(m55955g2);
        } else if (m55955g3 == null) {
            return;
        } else {
            C1694ra.m55917a(f2732a, "openOppoLocationManage nodeInfo2 is not null");
            C1661ba.m56097a().m56092a("battery_white", true);
            C1684n.m55975c().m55958f(m55955g3);
        }
        C1684n.m55975c().m56005a(300L);
    }

    /* renamed from: g */
    public static void m56660g(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo m55953h = C1684n.m55975c().m55953h(accessibilityService, "始终允许");
        if (m55953h != null) {
            C1684n.m55975c().m56005a(500L);
            C1684n.m55975c().m55958f(m55953h);
            AccessibilityNodeInfo m55953h2 = C1684n.m55975c().m55953h(accessibilityService, "确定");
            if (m55953h2 != null) {
                C1684n.m55975c().m55958f(m55953h2);
            }
            m56669b(accessibilityService, 4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0085, code lost:
        if ("oneplus".equals(com.acse.ottn.util.C1638Ka.m56193b()) != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x010e, code lost:
        if ("oneplus".equals(com.acse.ottn.util.C1638Ka.m56193b()) != false) goto L13;
     */
    /* renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m56659h(android.accessibilityservice.AccessibilityService r12) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.p042d.p043a.C1490f.m56659h(android.accessibilityservice.AccessibilityService):void");
    }

    /* renamed from: i */
    private static void m56658i(AccessibilityService accessibilityService) {
        f2735d = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(8000), C1652V.m56140a().m56132b(100), new C1487c(accessibilityService, C1663ca.m56080c().m56081b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: j */
    public static void m56657j(AccessibilityService accessibilityService) {
        m56673a(accessibilityService.getRootInActiveWindow());
    }

    @SuppressLint({"NewApi"})
    /* renamed from: k */
    private static void m56656k(AccessibilityService accessibilityService) {
        C1694ra.m55917a(f2732a, "getPacketw");
        m56667b(accessibilityService.getRootInActiveWindow());
    }
}
