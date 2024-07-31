package com.acse.ottn.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.acse.ottn.C1239R;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.util.C1694ra;
import com.stub.StubApp;
import io.netty.handler.codec.rtsp.RtspHeaders;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ExcessService extends Service {

    /* renamed from: a */
    private static View f2965a = null;

    /* renamed from: b */
    private static WindowManager f2966b = null;

    /* renamed from: c */
    private static String f2967c = "MainService";

    /* renamed from: d */
    private WindowManager.LayoutParams f2968d;

    /* renamed from: e */
    private AccessiblityModel f2969e;

    /* renamed from: f */
    private int f2970f = -1;

    /* renamed from: g */
    private boolean f2971g = false;

    static {
        StubApp.interface11(4498);
    }

    /* renamed from: a */
    private void m56424a(int i) {
        try {
            View inflate = LayoutInflater.from(getApplication()).inflate(i, (ViewGroup) null);
            f2965a = inflate;
            inflate.measure(0, 0);
        } catch (Exception e) {
            String str = f2967c;
            C1694ra.m55917a(str, "setLayoutView e = " + e.getMessage());
        }
    }

    /* renamed from: a */
    private void m56423a(Intent intent) {
        if (intent == null) {
            return;
        }
        m56424a(C1239R.C1244layout.excess_view);
        try {
            String stringExtra = intent.getStringExtra("password");
            String stringExtra2 = intent.getStringExtra("deeplink");
            String stringExtra3 = intent.getStringExtra("link");
            String stringExtra4 = intent.getStringExtra("origin_url");
            String stringExtra5 = intent.getStringExtra("name");
            int intExtra = intent.getIntExtra(RtspHeaders.Values.TIME, 100);
            try {
                WindowManager windowManager = f2966b;
                if (windowManager != null) {
                    windowManager.addView(f2965a, this.f2968d);
                }
            } catch (Exception e) {
                String str = f2967c;
                StringBuilder sb = new StringBuilder();
                sb.append("添加失败 e=");
                sb.append(e.getMessage());
                C1694ra.m55917a(str, sb.toString());
            }
            new Handler().postDelayed(new RunnableC1593c(this, stringExtra, stringExtra2, stringExtra3, intExtra, stringExtra5, stringExtra4), 0L);
        } catch (Exception e2) {
            String str2 = f2967c;
            C1694ra.m55917a(str2, "startExcessActivity e=" + e2.getMessage());
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: b */
    private void m56422b() {
        WindowManager.LayoutParams layoutParams;
        int i;
        this.f2968d = new WindowManager.LayoutParams();
        f2966b = (WindowManager) getApplication().getSystemService("window");
        if (Build.VERSION.SDK_INT >= 26) {
            layoutParams = this.f2968d;
            i = 2038;
        } else {
            layoutParams = this.f2968d;
            i = 2002;
        }
        layoutParams.type = i;
        WindowManager.LayoutParams layoutParams2 = this.f2968d;
        layoutParams2.format = 1;
        layoutParams2.flags = 8;
        layoutParams2.windowAnimations = 16973827;
        layoutParams2.gravity = 51;
        layoutParams2.x = 0;
        layoutParams2.y = 0;
        layoutParams2.width = -2;
        layoutParams2.height = -2;
    }

    /* renamed from: a */
    public void m56425a() {
        try {
            f2965a.setVisibility(8);
            f2966b.removeView(f2965a);
        } catch (Exception e) {
            C1694ra.m55917a(f2967c, e.getMessage());
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C1694ra.m55914c(f2967c, "MainService Created");
        m56422b();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            C1586Y.m56383b();
            C1586Y.m56378c();
            View view = f2965a;
            if (view != null) {
                f2966b.removeView(view);
            }
        } catch (Exception e) {
            String str = f2967c;
            C1694ra.m55914c(str, "e=" + e.getMessage());
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            m56423a(intent);
            return 2;
        } catch (Exception e) {
            String str = f2967c;
            C1694ra.m55914c(str, "onStartCommand e=" + e.getMessage());
            return 2;
        }
    }
}
