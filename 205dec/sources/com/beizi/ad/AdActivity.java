package com.beizi.ad;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Display;
import android.view.Menu;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import com.beizi.ad.internal.utilities.DeviceInfo;
import com.beizi.ad.internal.utilities.WebviewUtil;
import com.stub.StubApp;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AdActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f13046a;

    /* renamed from: b  reason: collision with root package name */
    static Class f13047b;

    /* renamed from: c  reason: collision with root package name */
    private a f13048c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* renamed from: com.beizi.ad.AdActivity$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i4 = 0;
            while (i4 != 3) {
                i4++;
                if (AdActivity.f13046a) {
                    AdActivity.f13046a = false;
                    AdActivity.this.finish();
                    i4 = 3;
                }
                SystemClock.sleep(500L);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* renamed from: com.beizi.ad.AdActivity$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f13050a;

        static {
            int[] iArr = new int[b.values().length];
            f13050a = iArr;
            try {
                iArr[b.none.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13050a[b.landscape.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13050a[b.portrait.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();

        void e();

        WebView f();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum b {
        portrait,
        landscape,
        none
    }

    static {
        StubApp.interface11(8814);
        f13047b = AdActivity.class;
    }

    public static Class a() {
        return f13047b;
    }

    public static void b(Activity activity) {
        activity.setRequestedOrientation(-1);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        a aVar = this.f13048c;
        if (aVar != null) {
            aVar.b();
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
        a aVar = this.f13048c;
        if (aVar != null) {
            aVar.c();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        a aVar = this.f13048c;
        if (aVar != null) {
            WebviewUtil.onPause(aVar.f());
        }
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.stopSync();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        a aVar = this.f13048c;
        if (aVar != null) {
            WebviewUtil.onResume(aVar.f());
        }
        CookieSyncManager cookieSyncManager = CookieSyncManager.getInstance();
        if (cookieSyncManager != null) {
            cookieSyncManager.startSync();
        }
        super.onResume();
    }

    public static void a(Activity activity) {
        b(activity, activity.getResources().getConfiguration().orientation);
    }

    @TargetApi(9)
    private static void b(Activity activity, int i4) {
        String str = DeviceInfo.getInstance().model;
        Locale locale = Locale.US;
        String upperCase = str.toUpperCase(locale);
        boolean z3 = DeviceInfo.getInstance().brand.toUpperCase(locale).equals("AMAZON") && (upperCase.equals("KFTT") || upperCase.equals("KFJWI") || upperCase.equals("KFJWA"));
        Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
        if (i4 == 1) {
            int rotation = defaultDisplay.getRotation();
            if (rotation != 1 && rotation != 2) {
                activity.setRequestedOrientation(1);
            } else {
                activity.setRequestedOrientation(9);
            }
        } else if (i4 == 2) {
            int rotation2 = defaultDisplay.getRotation();
            if (z3) {
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

    public static void a(Activity activity, int i4) {
        b(activity, i4);
    }

    public static void a(Activity activity, b bVar) {
        int i4 = activity.getResources().getConfiguration().orientation;
        int i5 = AnonymousClass2.f13050a[bVar.ordinal()];
        if (i5 != 1) {
            if (i5 == 2) {
                i4 = 2;
            } else if (i5 == 3) {
                i4 = 1;
            }
            b(activity, i4);
            return;
        }
        activity.setRequestedOrientation(-1);
    }
}
