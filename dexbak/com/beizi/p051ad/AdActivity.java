package com.beizi.p051ad;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Display;
import android.view.Menu;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.beizi.p051ad.internal.utilities.DeviceInfo;
import com.beizi.p051ad.internal.utilities.WebviewUtil;
import com.stub.StubApp;
import java.util.Locale;

/* renamed from: com.beizi.ad.AdActivity */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AdActivity extends Activity {

    /* renamed from: a */
    public static boolean f9329a;

    /* renamed from: b */
    static Class f9330b;

    /* renamed from: c */
    private InterfaceC2741a f9331c;

    /* renamed from: com.beizi.ad.AdActivity$1 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class RunnableC27391 implements Runnable {
        RunnableC27391() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            while (i != 3) {
                i++;
                if (AdActivity.f9329a) {
                    AdActivity.f9329a = false;
                    AdActivity.this.finish();
                    i = 3;
                }
                SystemClock.sleep(500L);
            }
        }
    }

    /* renamed from: com.beizi.ad.AdActivity$2 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static /* synthetic */ class C27402 {

        /* renamed from: a */
        static final /* synthetic */ int[] f9333a;

        static {
            int[] iArr = new int[EnumC2742b.values().length];
            f9333a = iArr;
            try {
                iArr[EnumC2742b.none.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9333a[EnumC2742b.landscape.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9333a[EnumC2742b.portrait.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: com.beizi.ad.AdActivity$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2741a {
        /* renamed from: a */
        void mo49656a();

        /* renamed from: b */
        void mo49655b();

        /* renamed from: c */
        void mo49654c();

        /* renamed from: d */
        void mo49653d();

        /* renamed from: e */
        void mo49652e();

        /* renamed from: f */
        WebView mo49651f();
    }

    /* renamed from: com.beizi.ad.AdActivity$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC2742b {
        portrait,
        landscape,
        none
    }

    static {
        StubApp.interface11(7935);
        f9330b = AdActivity.class;
    }

    /* renamed from: a */
    public static Class m50215a() {
        return f9330b;
    }

    /* renamed from: b */
    public static void m50211b(Activity activity) {
        activity.setRequestedOrientation(-1);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        InterfaceC2741a interfaceC2741a = this.f9331c;
        if (interfaceC2741a != null) {
            interfaceC2741a.mo49655b();
        }
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        InterfaceC2741a interfaceC2741a = this.f9331c;
        if (interfaceC2741a != null) {
            interfaceC2741a.mo49654c();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        InterfaceC2741a interfaceC2741a = this.f9331c;
        if (interfaceC2741a != null) {
            WebviewUtil.onPause(interfaceC2741a.mo49651f());
        }
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.stopSync();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        InterfaceC2741a interfaceC2741a = this.f9331c;
        if (interfaceC2741a != null) {
            WebviewUtil.onResume(interfaceC2741a.mo49651f());
        }
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.startSync();
        }
        super.onResume();
    }

    /* renamed from: a */
    public static void m50214a(Activity activity) {
        m50210b(activity, activity.getResources().getConfiguration().orientation);
    }

    @TargetApi(9)
    /* renamed from: b */
    private static void m50210b(Activity activity, int i) {
        String str = DeviceInfo.getInstance().model;
        Locale locale = Locale.US;
        String upperCase = str.toUpperCase(locale);
        boolean z = DeviceInfo.getInstance().brand.toUpperCase(locale).equals("AMAZON") && (upperCase.equals("KFTT") || upperCase.equals("KFJWI") || upperCase.equals("KFJWA"));
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        if (i == 1) {
            int rotation = defaultDisplay.getRotation();
            if (rotation != 1 && rotation != 2) {
                activity.setRequestedOrientation(1);
            } else {
                activity.setRequestedOrientation(9);
            }
        } else if (i == 2) {
            int rotation2 = defaultDisplay.getRotation();
            if (z) {
                if (rotation2 != 0 && rotation2 != 1) {
                    activity.setRequestedOrientation(0);
                } else {
                    activity.setRequestedOrientation(8);
                }
            } else if (rotation2 != 0 && rotation2 != 1) {
                activity.setRequestedOrientation(8);
            } else {
                activity.setRequestedOrientation(0);
            }
        }
    }

    /* renamed from: a */
    public static void m50213a(Activity activity, int i) {
        m50210b(activity, i);
    }

    /* renamed from: a */
    public static void m50212a(Activity activity, EnumC2742b enumC2742b) {
        int i = activity.getResources().getConfiguration().orientation;
        int i2 = C27402.f9333a[enumC2742b.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                i = 2;
            } else if (i2 == 3) {
                i = 1;
            }
            m50210b(activity, i);
            return;
        }
        activity.setRequestedOrientation(-1);
    }
}
