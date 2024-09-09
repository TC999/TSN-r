package cn.jpush.android.r;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import cn.jpush.android.helper.Logger;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private boolean f4313a = false;

    /* renamed from: b  reason: collision with root package name */
    private String f4314b = "";

    /* renamed from: c  reason: collision with root package name */
    private WindowManager f4315c;

    public static int a(Context context) {
        int i4 = 48;
        if (context != null) {
            try {
                i4 = context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
            } catch (Throwable th) {
                Logger.w("InAppWinManager", "get status bar height error, " + th.getMessage());
            }
        }
        Logger.d("InAppWinManager", "status bar height: " + i4);
        return i4;
    }

    private WindowManager.LayoutParams a(Context context, cn.jpush.android.t.a aVar) {
        if (aVar == null || context == null) {
            return null;
        }
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(aVar.c(), aVar.d(), 1003, aVar.a() | 131072 | 32 | 8, -3);
            layoutParams.x = 0;
            layoutParams.y = a(context);
            layoutParams.dimAmount = 0.3f;
            layoutParams.gravity = aVar.b();
            layoutParams.windowAnimations = 0;
            return layoutParams;
        } catch (Throwable th) {
            Logger.w("InAppWinManager", "[getLayoutParams] error." + th.getMessage());
            return null;
        }
    }

    private WindowManager b(Context context) {
        if (context == null) {
            Logger.w("InAppWinManager", "getWindowManager context is null");
            return null;
        }
        return (WindowManager) context.getSystemService("window");
    }

    public boolean a(Context context, cn.jpush.android.u.b bVar) {
        try {
            this.f4314b = "";
            cn.jpush.android.t.a k4 = bVar.k();
            View e4 = bVar.e();
            if (e4 == null) {
                Logger.w("InAppWinManager", "notify inapp show failed, wbView is null");
                return false;
            }
            this.f4315c = b(context);
            if (context instanceof Activity) {
                this.f4314b = context.getClass().getCanonicalName();
                context = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            if (this.f4315c == null) {
                Logger.w("InAppWinManager", "notify inapp show failed, wm is null");
                return false;
            }
            WindowManager.LayoutParams a4 = a(context, k4);
            if (a4 == null) {
                Logger.w("InAppWinManager", "notify inapp show failed, layout param is null");
                return false;
            }
            this.f4315c.addView(e4, a4);
            bVar.h();
            this.f4313a = true;
            return true;
        } catch (Throwable th) {
            Logger.w("InAppWinManager", "notify inapp show failed, " + th.getMessage());
            return false;
        }
    }

    public boolean a(cn.jpush.android.u.b bVar) {
        if (bVar == null || bVar.e() == null) {
            return false;
        }
        boolean isShown = bVar.e().isShown();
        Logger.d("InAppWinManager", "webview is displayed, status: " + isShown + ", isDisplayed: " + this.f4313a);
        return isShown && this.f4313a;
    }

    public boolean a(String str) {
        Logger.d("InAppWinManager", "[checkShouldDestroy], showActivityName: " + this.f4314b + ", curActivityName: " + str);
        return TextUtils.equals(str, this.f4314b);
    }

    public void b(Context context, cn.jpush.android.u.b bVar) {
        try {
            if (bVar == null || context == null) {
                Logger.w("InAppWinManager", "destroy param is null, wrapper: " + bVar);
                return;
            }
            View e4 = bVar.e();
            if (e4 != null) {
                if (this.f4315c != null && a(bVar)) {
                    this.f4315c.removeViewImmediate(e4);
                    this.f4313a = false;
                    Logger.d("InAppWinManager", "[destroy] - window manager removeViewImmediate view succeed.");
                }
                bVar.c();
            }
            this.f4314b = "";
        } catch (Throwable th) {
            Logger.w("InAppWinManager", "notify inapp destroy failed, " + th.getMessage());
        }
    }

    public boolean b(cn.jpush.android.u.b bVar) {
        return (bVar == null || bVar.e() == null) ? false : true;
    }
}
