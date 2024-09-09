package com.bxkj.base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.MessageManager;
import com.bxkj.base.intercept.f;
import com.bxkj.base.user.LoginUser;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class BaseApp extends Application {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f18099a = true;

    /* renamed from: b  reason: collision with root package name */
    private static BaseApp f18100b;

    private void a() {
        Http.getHttp().addInterceptor(new com.bxkj.base.intercept.b());
        Http.getHttp().addInterceptor(new r.b());
        Http.getHttp().setResponseInterceptor(new f());
    }

    public static BaseApp b() {
        return f18100b;
    }

    private void d() {
        Http.getHttp().init(p.f.class, LoginUser.getLoginUser().getServerUrl(), "returnCode", "data", "returnMsg", 200);
        Http.getHttp().setShowMessageModel(MessageManager.MessageModel.All);
    }

    public static boolean f() {
        return f18099a;
    }

    public static void g(boolean z3) {
        f18099a = z3;
    }

    public String c(Context context, int i4) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == i4) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    public boolean e() {
        try {
            String c4 = c(StubApp.getOrigApplicationContext(getApplicationContext()), Process.myPid());
            if (TextUtils.isEmpty(c4)) {
                return true;
            }
            return getPackageName().equalsIgnoreCase(c4);
        } catch (Exception e4) {
            e4.printStackTrace();
            return true;
        }
    }

    public abstract void h(Context context);

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f18100b = this;
        if (e()) {
            a();
            d();
        }
    }
}
