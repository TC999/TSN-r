package com.bxkj.base;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.MessageManager;
import com.bxkj.base.intercept.RequestIntercept;
import com.bxkj.base.intercept.ResponseInterceptor;
import com.bxkj.base.user.LoginUser;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.stub.StubApp;
import p635q.MainApiService;
import p641s.HttpTimeoutInterceptor;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class BaseApp extends Application {

    /* renamed from: a */
    private static boolean f14582a = true;

    /* renamed from: b */
    private static BaseApp f14583b;

    /* renamed from: a */
    private void m44342a() {
        Http.getHttp().addInterceptor(new RequestIntercept());
        Http.getHttp().addInterceptor(new HttpTimeoutInterceptor());
        Http.getHttp().setResponseInterceptor(new ResponseInterceptor());
    }

    /* renamed from: b */
    public static BaseApp m44341b() {
        return f14583b;
    }

    /* renamed from: d */
    private void m44339d() {
        Http.getHttp().init(MainApiService.class, LoginUser.getLoginUser().getServerUrl(), "returnCode", "data", "returnMsg", 200);
        Http.getHttp().setShowMessageModel(MessageManager.MessageModel.All);
    }

    /* renamed from: f */
    public static boolean m44337f() {
        return f14582a;
    }

    /* renamed from: g */
    public static void m44336g(boolean z) {
        f14582a = z;
    }

    /* renamed from: c */
    public String m44340c(Context context, int i) {
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == i) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    /* renamed from: e */
    public boolean m44338e() {
        try {
            String m44340c = m44340c(StubApp.getOrigApplicationContext(getApplicationContext()), Process.myPid());
            if (TextUtils.isEmpty(m44340c)) {
                return true;
            }
            return getPackageName().equalsIgnoreCase(m44340c);
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /* renamed from: h */
    public abstract void mo43012h(Context context);

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        f14583b = this;
        if (m44338e()) {
            m44342a();
            m44339d();
        }
    }
}
