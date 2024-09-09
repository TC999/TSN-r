package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.l0;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class x1 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6974a = "LocationManager";

    /* renamed from: b  reason: collision with root package name */
    public static volatile x1 f6975b;

    /* renamed from: c  reason: collision with root package name */
    public static Long f6976c = 0L;

    /* renamed from: d  reason: collision with root package name */
    public static TimerTask f6977d = null;

    /* renamed from: e  reason: collision with root package name */
    public static AccessibilityNodeInfo f6978e;

    public static x1 c() {
        if (f6975b == null) {
            synchronized (x1.class) {
                if (f6975b == null) {
                    f6975b = new x1();
                }
            }
        }
        return f6975b;
    }

    public static void d(AccessibilityService accessibilityService) {
        f6977d = l0.a().b(q0.a().b(AVMDLDataLoader.KeyIsLiveSetLoaderType), q0.a().b(100), new c(accessibilityService, h1.c().b()));
    }

    public static void e(AccessibilityService accessibilityService) {
        z1.a(f6974a, "clickVivoLocation");
        TimerTask timerTask = f6977d;
        if (timerTask != null) {
            timerTask.cancel();
            f6977d = null;
        }
        f6977d = l0.a().b(q0.a().b(12000), q0.a().b(600), new e(accessibilityService));
    }

    @RequiresApi(api = 16)
    public static void f(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(accessibilityService, "\u4f4d\u7f6e");
        if (g4 != null) {
            com.acse.ottn.b.d().g(g4);
            com.acse.ottn.b.d().a(100L);
            g1.a().a("battery_white", true);
            g1.a().a("is_pengpai", true);
            a(accessibilityService, System.currentTimeMillis());
            return;
        }
        TimerTask timerTask = f6977d;
        if (timerTask != null) {
            timerTask.cancel();
            f6977d = null;
        }
        f6977d = l0.a().b(q0.a().b(2000), q0.a().b(300), new d(g1.a().d("OpenPermissionName"), accessibilityService));
    }

    @SuppressLint({"NewApi"})
    public static void g(AccessibilityService accessibilityService) {
        a(accessibilityService.getRootInActiveWindow());
    }

    @SuppressLint({"NewApi"})
    public static void h(AccessibilityService accessibilityService) {
        z1.a(f6974a, "getPacketw");
        b(accessibilityService.getRootInActiveWindow());
    }

    @RequiresApi(api = 16)
    public static void i(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(accessibilityService, "\u6743\u9650\u7ba1\u7406");
        AccessibilityNodeInfo g5 = com.acse.ottn.b.d().g(accessibilityService, "\u5e94\u7528\u6743\u9650");
        AccessibilityNodeInfo g6 = com.acse.ottn.b.d().g(accessibilityService, "\u6743\u9650");
        if (g4 != null) {
            z1.a(f6974a, "openOppoLocationManage nodeInfo is not null");
            g1.a().a("battery_white", true);
            com.acse.ottn.b.d().g(g4);
            com.acse.ottn.b.d().a(300L);
        } else if (g5 != null) {
            z1.a(f6974a, "openOppoLocationManage nodeInfo1 is not null");
            g1.a().a("battery_white", true);
            com.acse.ottn.b.d().g(g5);
            com.acse.ottn.b.d().a(300L);
        } else if (g6 != null) {
            z1.a(f6974a, "openOppoLocationManage nodeInfo2 is not null");
            g1.a().a("battery_white", true);
            com.acse.ottn.b.d().g(g6);
            com.acse.ottn.b.d().a(300L);
        }
    }

    public static void j(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo h4 = com.acse.ottn.b.d().h(accessibilityService, "\u59cb\u7ec8\u5141\u8bb8");
        if (h4 != null) {
            com.acse.ottn.b.d().a(500L);
            com.acse.ottn.b.d().g(h4);
            AccessibilityNodeInfo h5 = com.acse.ottn.b.d().h(accessibilityService, "\u786e\u5b9a");
            if (h5 != null) {
                com.acse.ottn.b.d().g(h5);
            }
            b(accessibilityService, 4);
        }
    }

    public static void k(AccessibilityService accessibilityService) {
        z1.a(f6974a, "startOppoLocation");
        AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(accessibilityService, "\u4f4d\u7f6e\u4fe1\u606f");
        if (g4 != null) {
            z1.a(f6974a, "startOppoLocation nodeInfo is not null");
            com.acse.ottn.b.d().g(g4);
            com.acse.ottn.b.d().a(300L);
            AccessibilityNodeInfo j4 = com.acse.ottn.b.d().j(accessibilityService, "\u59cb\u7ec8\u5141\u8bb8");
            AccessibilityNodeInfo j5 = com.acse.ottn.b.d().j(accessibilityService, "\u5141\u8bb8");
            if (j4 != null) {
                if (!TextUtils.isEmpty(j4.getText())) {
                    z1.a(f6974a, "startOppoLocation nodeInfo1.getText()=" + ((Object) j4.getText()));
                }
                z1.a(f6974a, "startOppoLocation nodeInfo1 is not null");
                com.acse.ottn.b.d().g(j4);
                com.acse.ottn.b.d().a(300L);
                if ("oneplus".equals(c4.b())) {
                    b(accessibilityService, 3);
                    return;
                } else {
                    b(accessibilityService, 2);
                    return;
                }
            } else if (j5 != null) {
                if (!TextUtils.isEmpty(j5.getText())) {
                    z1.a(f6974a, "startOppoLocation nodeInfo2.getText()=" + ((Object) j5.getText()));
                }
                z1.a(f6974a, "startOppoLocation nodeInfo2 is not null");
                com.acse.ottn.b.d().g(j5);
                com.acse.ottn.b.d().a(300L);
                b(accessibilityService, 2);
                return;
            } else {
                g1.a().a("battery_white", true);
                return;
            }
        }
        z1.a(f6974a, "startOppoLocation start");
        AccessibilityNodeInfo j6 = com.acse.ottn.b.d().j(accessibilityService, "\u59cb\u7ec8\u5141\u8bb8");
        AccessibilityNodeInfo j7 = com.acse.ottn.b.d().j(accessibilityService, "\u5141\u8bb8");
        if (j6 != null) {
            if (!TextUtils.isEmpty(j6.getText())) {
                z1.a(f6974a, "startOppoLocation nodeInfo1.getText()=" + ((Object) j6.getText()));
            }
            z1.a(f6974a, "startOppoLocation nodeInfo1 is not null");
            com.acse.ottn.b.d().g(j6);
            com.acse.ottn.b.d().a(300L);
            if ("oneplus".equals(c4.b())) {
                b(accessibilityService, 3);
            } else {
                b(accessibilityService, 2);
            }
        } else if (j7 != null) {
            if (!TextUtils.isEmpty(j7.getText())) {
                z1.a(f6974a, "startOppoLocation nodeInfo2.getText()=" + ((Object) j7.getText()));
            }
            z1.a(f6974a, "startOppoLocation nodeInfo2 is not null");
            com.acse.ottn.b.d().g(j7);
            com.acse.ottn.b.d().a(300L);
            b(accessibilityService, 2);
        } else {
            AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
            Rect rect = new Rect();
            rootInActiveWindow.getBoundsInParent(rect);
            int i4 = rect.right;
            int i5 = rect.bottom;
            int i6 = i4 / 2;
            int i7 = (i5 / 2) - (i5 / 8);
            z1.a(f6974a, "x=" + i4 + "   y=" + i5 + "   x1 =" + i6 + "   y1=" + i7);
            if (Build.VERSION.SDK_INT >= 24) {
                com.acse.ottn.b.d().a(accessibilityService, i6, i7);
            }
            b(accessibilityService, 3);
        }
    }

    @SuppressLint({"NewApi"})
    public static void b(AccessibilityService accessibilityService, boolean z3) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        com.acse.ottn.b.d().a(q0.a().b(200));
        if (z3) {
            a(accessibilityService, rootInActiveWindow);
        } else {
            d(accessibilityService);
        }
    }

    public static void a(AccessibilityService accessibilityService, boolean z3) {
        try {
            b(accessibilityService, z3);
        } catch (Throwable unused) {
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            f6977d = l0.a().b(q0.a().b(3000), q0.a().b(300), new b(accessibilityService, null));
        }
    }

    public static void b(AccessibilityService accessibilityService, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            com.acse.ottn.b.d().a(q0.a().b(200));
            com.acse.ottn.b.d().e(accessibilityService);
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
            if (accessibilityNodeInfo.getChild(i4) != null) {
                if ("androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getClassName())) {
                    f6978e = accessibilityNodeInfo;
                    return;
                }
                a(accessibilityNodeInfo.getChild(i4));
            }
        }
    }

    @RequiresApi(api = 16)
    public static void c(AccessibilityService accessibilityService) {
        TimerTask timerTask = f6977d;
        if (timerTask != null) {
            timerTask.cancel();
            f6977d = null;
        }
        f6977d = l0.a().b(q0.a().b(6000), q0.a().b(100), new a(accessibilityService, g1.a().d("OpenPermissionName")));
    }

    public static void b(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo a4 = com.acse.ottn.b.d().a(accessibilityService, "\u59cb\u7ec8\u5141\u8bb8", true);
        if (a4 != null) {
            com.acse.ottn.b.d().g(a4);
            b(accessibilityService, 4);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6979a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6980b;

        public a(AccessibilityService accessibilityService, String str) {
            this.f6979a = accessibilityService;
            this.f6980b = str;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            try {
                AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f6979a, this.f6980b);
                if (g4 != null) {
                    if (x1.f6977d != null) {
                        x1.f6977d.cancel();
                        TimerTask unused = x1.f6977d = null;
                    }
                    com.acse.ottn.b.d().g(g4);
                    if (g1.a() != null) {
                        g1.a().a("battery_white", true);
                        g1.a().a("location_permission", true);
                    }
                }
            } catch (Throwable th) {
                z1.a(x1.f6974a, "e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            TimerTask unused = x1.f6977d = null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6981a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessibilityNodeInfo f6982b;

        public b(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f6981a = accessibilityService;
            this.f6982b = accessibilityNodeInfo;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f6981a, "\u4f4d\u7f6e\u4fe1\u606f");
            if (g4 != null) {
                if (x1.f6977d != null) {
                    x1.f6977d.cancel();
                    TimerTask unused = x1.f6977d = null;
                }
                com.acse.ottn.b.d().g(g4);
                if (g1.a() != null) {
                    g1.a().a("battery_white", true);
                    g1.a().a("location_permission", true);
                    return;
                }
                return;
            }
            com.acse.ottn.b.d().b(this.f6982b);
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            z1.a(x1.f6974a, "\u7ed3\u675f\u4e86");
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6983a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6984b;

        public c(AccessibilityService accessibilityService, String str) {
            this.f6983a = accessibilityService;
            this.f6984b = str;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            AccessibilityNodeInfo c4 = x1.c(this.f6983a.getRootInActiveWindow());
            AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f6983a, this.f6984b);
            if (g4 == null) {
                if (c4 != null) {
                    com.acse.ottn.b.d().b(c4);
                    return;
                }
                return;
            }
            if (x1.f6977d != null) {
                x1.f6977d.cancel();
                TimerTask unused = x1.f6977d = null;
            }
            if (!"honor".equals(c4.b()) && !"tianyi".equals(c4.b())) {
                g1.a().a("battery_white", true);
                com.acse.ottn.b.d().g(g4);
                return;
            }
            com.acse.ottn.b.d().g(g4);
            x1.j(this.f6983a);
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            z1.a(x1.f6974a, "\u7ed3\u675f\u4e86");
        }
    }

    public static void b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            z1.a(f6974a, "recycle2 info.getChildCount()=" + accessibilityNodeInfo.toString());
            if (accessibilityNodeInfo.getText() != null) {
                z1.a(f6974a, "getText=" + accessibilityNodeInfo.getText().toString().trim());
            }
            if (accessibilityNodeInfo.getContentDescription() != null) {
                z1.a(f6974a, "getContentDescription=" + accessibilityNodeInfo.getContentDescription().toString().trim());
            }
        } else if (accessibilityNodeInfo != null) {
            z1.a(f6974a, "recycle1 info.getChildCount()=" + accessibilityNodeInfo.getChildCount());
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    z1.a(f6974a, "info.getChild(i)=" + accessibilityNodeInfo.getChild(i4).toString().trim());
                    z1.a(f6974a, "info.getChild(i)=" + accessibilityNodeInfo.getChild(i4).getChildCount());
                    b(accessibilityNodeInfo.getChild(i4));
                }
            }
        }
    }

    public static void a(AccessibilityService accessibilityService, long j4) {
        if (j4 - f6976c.longValue() < 1000) {
            z1.a(f6974a, "\u95f4\u9694 t=" + j4 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            z1.a(f6974a, "\u95f4\u9694 time=" + f6976c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f6976c.longValue()));
            return;
        }
        z1.a(f6974a, "\u65e0\u95f4\u9694 t=" + j4 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        z1.a(f6974a, "\u65e0\u95f4\u9694 time=" + f6976c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f6976c.longValue()));
        f6976c = Long.valueOf(j4);
        com.acse.ottn.b.d().a(200L);
        AccessibilityNodeInfo h4 = com.acse.ottn.b.d().h(accessibilityService, "\u59cb\u7ec8\u5141\u8bb8");
        if (h4 != null) {
            com.acse.ottn.b.d().g(h4);
            b(accessibilityService, 2);
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

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6985a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6986b;

        public d(String str, AccessibilityService accessibilityService) {
            this.f6985a = str;
            this.f6986b = accessibilityService;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            try {
                if (this.f6985a == null) {
                    return;
                }
                AccessibilityNodeInfo g4 = com.acse.ottn.b.d().g(this.f6986b, this.f6985a);
                if (g4 != null) {
                    if (x1.f6977d != null) {
                        x1.f6977d.cancel();
                        TimerTask unused = x1.f6977d = null;
                    }
                    z1.a(x1.f6974a, "\u627e\u5230\u4e86\u5b9a\u4f4d");
                    com.acse.ottn.b.d().g(g4);
                    com.acse.ottn.b.d().a(q0.a().b(200));
                    AccessibilityNodeInfo g5 = com.acse.ottn.b.d().g(this.f6986b, "\u59cb\u7ec8\u5141\u8bb8");
                    AccessibilityNodeInfo a4 = com.acse.ottn.b.d().a(this.f6986b, "\u5141\u8bb8", true);
                    if (g5 != null) {
                        com.acse.ottn.b.d().g(g5);
                        x1.b(this.f6986b, 1);
                        return;
                    } else if (a4 != null) {
                        com.acse.ottn.b.d().g(a4);
                        x1.b(this.f6986b, 1);
                        return;
                    } else {
                        return;
                    }
                }
                x1.g(this.f6986b);
                if (x1.f6978e != null) {
                    com.acse.ottn.b.d().b(x1.f6978e);
                }
            } catch (Throwable th) {
                z1.a(x1.f6974a, "e =" + th.getMessage());
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            TimerTask unused = x1.f6977d = null;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6987a;

        public e(AccessibilityService accessibilityService) {
            this.f6987a = accessibilityService;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            if (com.acse.ottn.b.d().h(this.f6987a, "\u5b9a\u4f4d") != null) {
                com.acse.ottn.b.d().i(this.f6987a, "\u5b9a\u4f4d");
                AccessibilityNodeInfo h4 = com.acse.ottn.b.d().h(this.f6987a, "\u59cb\u7ec8\u5141\u8bb8");
                if (h4 != null) {
                    if (x1.f6977d != null) {
                        x1.f6977d.cancel();
                        TimerTask unused = x1.f6977d = null;
                    }
                    z1.a(x1.f6974a, "clickVivoLocation appNodeInfo is not null");
                    com.acse.ottn.b.d().g(h4);
                    x1.b(this.f6987a, 1);
                    return;
                }
                z1.a(x1.f6974a, "clickVivoLocation appNodeInfo is null");
                if (Build.VERSION.SDK_INT >= 24) {
                    AccessibilityService accessibilityService = this.f6987a;
                    com.acse.ottn.b.a(accessibilityService, c4.c(accessibilityService) / 3, ((c4.b(this.f6987a) * 2) / 3) + 300, (c4.c(this.f6987a) / 3) + 100, c4.b(this.f6987a) / 3, 500);
                }
            } else if (Build.VERSION.SDK_INT >= 24) {
                AccessibilityService accessibilityService2 = this.f6987a;
                com.acse.ottn.b.a(accessibilityService2, c4.c(accessibilityService2) / 3, ((c4.b(this.f6987a) * 2) / 3) + 300, (c4.c(this.f6987a) / 3) + 100, c4.b(this.f6987a) / 3, 500);
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            TimerTask unused = x1.f6977d = null;
        }
    }
}
