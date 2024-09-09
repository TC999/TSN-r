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
import com.acse.ottn.R;
import com.acse.ottn.activity.ExcessActivity;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.z1;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ExcessService extends Service {

    /* renamed from: e  reason: collision with root package name */
    public static View f6307e = null;

    /* renamed from: f  reason: collision with root package name */
    public static WindowManager f6308f = null;

    /* renamed from: g  reason: collision with root package name */
    public static String f6309g = "MainService";

    /* renamed from: a  reason: collision with root package name */
    public WindowManager.LayoutParams f6310a;

    /* renamed from: b  reason: collision with root package name */
    public AccessiblityModel f6311b;

    /* renamed from: c  reason: collision with root package name */
    public int f6312c = -1;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6313d = false;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f6314a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f6315b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f6316c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f6317d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6318e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f6319f;

        public a(String str, String str2, String str3, int i4, String str4, String str5) {
            this.f6314a = str;
            this.f6315b = str2;
            this.f6316c = str3;
            this.f6317d = i4;
            this.f6318e = str4;
            this.f6319f = str5;
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(ExcessService.this, ExcessActivity.class);
            intent.putExtra("password", this.f6314a);
            intent.putExtra("deeplink", this.f6315b);
            intent.putExtra("link", this.f6316c);
            intent.putExtra("time", this.f6317d);
            intent.putExtra("name", this.f6318e);
            intent.putExtra("origin_url", this.f6319f);
            intent.addFlags(268435456);
            ExcessService.this.startActivity(intent);
            ExcessService.this.b();
        }
    }

    static {
        StubApp.interface11(5027);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void a() {
        this.f6310a = new WindowManager.LayoutParams();
        f6308f = (WindowManager) getApplication().getSystemService("window");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6310a.type = 2038;
        } else {
            this.f6310a.type = 2002;
        }
        WindowManager.LayoutParams layoutParams = this.f6310a;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.windowAnimations = 16973827;
        layoutParams.gravity = 51;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.width = -2;
        layoutParams.height = -2;
    }

    public void b() {
        try {
            f6307e.setVisibility(8);
            f6308f.removeView(f6307e);
        } catch (Exception e4) {
            z1.a(f6309g, e4.getMessage());
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
        z1.c(f6309g, "MainService Created");
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            C1391a.b();
            C1391a.d();
            View view = f6307e;
            if (view != null) {
                f6308f.removeView(view);
            }
        } catch (Exception e4) {
            String str = f6309g;
            z1.c(str, "e=" + e4.getMessage());
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        try {
            a(intent);
            return 2;
        } catch (Exception e4) {
            String str = f6309g;
            z1.c(str, "onStartCommand e=" + e4.getMessage());
            return 2;
        }
    }

    public final void a(Intent intent) {
        if (intent == null) {
            return;
        }
        a(R.layout.excess_view);
        try {
            String stringExtra = intent.getStringExtra("password");
            String stringExtra2 = intent.getStringExtra("deeplink");
            String stringExtra3 = intent.getStringExtra("link");
            String stringExtra4 = intent.getStringExtra("origin_url");
            String stringExtra5 = intent.getStringExtra("name");
            int intExtra = intent.getIntExtra("time", 100);
            try {
                WindowManager windowManager = f6308f;
                if (windowManager != null) {
                    windowManager.addView(f6307e, this.f6310a);
                }
            } catch (Exception e4) {
                String str = f6309g;
                z1.a(str, "\u6dfb\u52a0\u5931\u8d25 e=" + e4.getMessage());
            }
            new Handler().postDelayed(new a(stringExtra, stringExtra2, stringExtra3, intExtra, stringExtra5, stringExtra4), 0L);
        } catch (Exception e5) {
            String str2 = f6309g;
            z1.a(str2, "startExcessActivity e=" + e5.getMessage());
        }
    }

    public final void a(int i4) {
        try {
            View inflate = LayoutInflater.from(getApplication()).inflate(i4, (ViewGroup) null);
            f6307e = inflate;
            inflate.measure(0, 0);
        } catch (Exception e4) {
            String str = f6309g;
            z1.a(str, "setLayoutView e = " + e4.getMessage());
        }
    }
}
