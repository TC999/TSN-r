package com.devlin_n.videoplayer.player;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import c1.f;
import com.devlin_n.videoplayer.controller.FloatController;
import com.devlin_n.videoplayer.widget.FloatView;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class BackgroundPlayService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private WindowManager f36919a;

    /* renamed from: b  reason: collision with root package name */
    private WindowManager.LayoutParams f36920b;

    /* renamed from: c  reason: collision with root package name */
    private IjkVideoView f36921c;

    /* renamed from: d  reason: collision with root package name */
    private String f36922d;

    /* renamed from: e  reason: collision with root package name */
    private FloatView f36923e;

    /* renamed from: f  reason: collision with root package name */
    private int f36924f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f36925g;

    private void a() {
        this.f36919a = f.g(StubApp.getOrigApplicationContext(getApplicationContext()));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f36920b = layoutParams;
        layoutParams.type = 2003;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.gravity = 8388659;
        int a4 = f.a(StubApp.getOrigApplicationContext(getApplicationContext()), 250.0f);
        WindowManager.LayoutParams layoutParams2 = this.f36920b;
        layoutParams2.width = a4;
        layoutParams2.height = (a4 * 9) / 16;
        layoutParams2.x = f.e(StubApp.getOrigApplicationContext(getApplicationContext())) - a4;
        this.f36920b.y = f.d(StubApp.getOrigApplicationContext(getApplicationContext()), false) / 2;
        FloatView floatView = new FloatView(StubApp.getOrigApplicationContext(getApplicationContext()), this.f36919a, this.f36920b);
        this.f36923e = floatView;
        this.f36921c = floatView.f36986c;
    }

    private void b() {
        if (this.f36925g) {
            this.f36921c.T();
        }
        this.f36921c.h0(this.f36922d, this.f36924f).f0(new FloatController(StubApp.getOrigApplicationContext(getApplicationContext()))).start();
        this.f36919a.addView(this.f36923e, this.f36920b);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        c1.a.c = false;
        FloatView floatView = this.f36923e;
        if (floatView != null) {
            this.f36919a.removeView(floatView);
        }
        this.f36921c.Z();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        this.f36922d = intent.getStringExtra("url");
        this.f36924f = intent.getIntExtra("position", 0);
        this.f36925g = intent.getBooleanExtra("enable_cache", false);
        c1.a.c = true;
        b();
        return 2;
    }
}
