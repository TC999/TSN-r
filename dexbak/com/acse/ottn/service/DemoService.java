package com.acse.ottn.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.acse.ottn.C1239R;
import com.acse.ottn.util.C1631H;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1694ra;
import com.stub.StubApp;
import java.util.TimerTask;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class DemoService extends Service {

    /* renamed from: a */
    private static View f2955a = null;

    /* renamed from: b */
    private static WindowManager f2956b = null;

    /* renamed from: c */
    private static String f2957c = "WebViewService";

    /* renamed from: d */
    public static TimerTask f2958d;

    /* renamed from: e */
    private WindowManager.LayoutParams f2959e;

    /* renamed from: f */
    private TextView f2960f;

    /* renamed from: g */
    private int f2961g = -1;

    /* renamed from: h */
    private boolean f2962h = false;

    static {
        StubApp.interface11(4496);
    }

    /* renamed from: a */
    private static int m56430a(Context context, int i) {
        return (int) (i * context.getResources().getDisplayMetrics().density);
    }

    /* renamed from: a */
    private static void m56431a(int i) {
        f2958d = C1648S.m56165a().m56163b(i, 1000, new C1591b());
    }

    /* renamed from: a */
    private void m56429a(String str) {
        C1694ra.m55917a(f2957c, "webview悬浮窗");
        m56427b(C1239R.C1244layout.demo_service);
        TextView textView = (TextView) f2955a.findViewById(C1239R.C1242id.tv_text);
        this.f2960f = textView;
        textView.setText(str);
        WindowManager.LayoutParams layoutParams = this.f2959e;
        layoutParams.height = -2;
        try {
            f2956b.addView(f2955a, layoutParams);
        } catch (Exception e) {
            String str2 = f2957c;
            C1694ra.m55917a(str2, "添加失败 e=" + e.getMessage());
        }
        m56431a(8000);
    }

    /* renamed from: b */
    public static void m56428b() {
        try {
            View view = f2955a;
            if (view != null) {
                view.setVisibility(8);
            }
            f2956b.removeView(f2955a);
        } catch (Exception e) {
            String str = f2957c;
            C1694ra.m55917a(str, "dismiss e=" + e.getMessage());
        }
    }

    /* renamed from: b */
    private void m56427b(int i) {
        try {
            View inflate = LayoutInflater.from(getApplication()).inflate(i, (ViewGroup) null);
            f2955a = inflate;
            inflate.measure(0, 0);
        } catch (Exception e) {
            String str = f2957c;
            C1694ra.m55917a(str, "setLayoutView e = " + e.getMessage());
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: c */
    private void m56426c() {
        WindowManager.LayoutParams layoutParams;
        int i;
        this.f2959e = new WindowManager.LayoutParams();
        f2956b = (WindowManager) getApplication().getSystemService("window");
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.f2959e;
            i = 2038;
        } else {
            layoutParams = this.f2959e;
            i = 2002;
        }
        layoutParams.type = i;
        WindowManager.LayoutParams layoutParams2 = this.f2959e;
        layoutParams2.format = 1;
        layoutParams2.flags = 8;
        layoutParams2.gravity = 51;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -1;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C1694ra.m55914c(f2957c, "MainService Created");
        m56426c();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            TimerTask timerTask = f2958d;
            if (timerTask != null) {
                timerTask.cancel();
                f2958d = null;
            }
            C1586Y.m56383b();
            C1586Y.m56378c();
            View view = f2955a;
            if (view != null) {
                f2956b.removeView(view);
            }
        } catch (Exception e) {
            String str = f2957c;
            C1694ra.m55914c(str, "onDestroy e=" + e.getMessage());
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            String stringExtra = intent.getStringExtra("url");
            if (!TextUtils.isEmpty(stringExtra)) {
                m56429a(stringExtra);
            }
            String stringExtra2 = intent.getStringExtra("shortLink");
            if (!TextUtils.isEmpty(stringExtra2)) {
                C1631H.m56262a().m56260a(this, stringExtra2);
            }
        } catch (Exception e) {
            String str = f2957c;
            C1694ra.m55917a(str, "Exception =" + e.getMessage());
        }
        return super.onStartCommand(intent, i, i2);
    }
}
