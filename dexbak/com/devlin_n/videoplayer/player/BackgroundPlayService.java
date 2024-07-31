package com.devlin_n.videoplayer.player;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.devlin_n.videoplayer.controller.FloatController;
import com.devlin_n.videoplayer.widget.FloatView;
import com.google.android.material.badge.BadgeDrawable;
import com.stub.StubApp;
import p601i0.C13583a;
import p601i0.C13584f;
import p601i0.KeyUtil;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BackgroundPlayService extends Service {

    /* renamed from: a */
    private WindowManager f23297a;

    /* renamed from: b */
    private WindowManager.LayoutParams f23298b;

    /* renamed from: c */
    private IjkVideoView f23299c;

    /* renamed from: d */
    private String f23300d;

    /* renamed from: e */
    private FloatView f23301e;

    /* renamed from: f */
    private int f23302f;

    /* renamed from: g */
    private boolean f23303g;

    /* renamed from: a */
    private void m35750a() {
        this.f23297a = C13584f.m12704g(StubApp.getOrigApplicationContext(getApplicationContext()));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f23298b = layoutParams;
        layoutParams.type = 2003;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.gravity = BadgeDrawable.TOP_START;
        int m12710a = C13584f.m12710a(StubApp.getOrigApplicationContext(getApplicationContext()), 250.0f);
        WindowManager.LayoutParams layoutParams2 = this.f23298b;
        layoutParams2.width = m12710a;
        layoutParams2.height = (m12710a * 9) / 16;
        layoutParams2.x = C13584f.m12706e(StubApp.getOrigApplicationContext(getApplicationContext())) - m12710a;
        this.f23298b.y = C13584f.m12707d(StubApp.getOrigApplicationContext(getApplicationContext()), false) / 2;
        FloatView floatView = new FloatView(StubApp.getOrigApplicationContext(getApplicationContext()), this.f23297a, this.f23298b);
        this.f23301e = floatView;
        this.f23299c = floatView.f23390c;
    }

    /* renamed from: b */
    private void m35749b() {
        if (this.f23303g) {
            this.f23299c.m35728U();
        }
        this.f23299c.m35705i0(this.f23300d, this.f23302f).m35709g0(new FloatController(StubApp.getOrigApplicationContext(getApplicationContext()))).start();
        this.f23297a.addView(this.f23301e, this.f23298b);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        m35750a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C13583a.f40164c = false;
        FloatView floatView = this.f23301e;
        if (floatView != null) {
            this.f23297a.removeView(floatView);
        }
        this.f23299c.m35721a0();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        this.f23300d = intent.getStringExtra("url");
        this.f23302f = intent.getIntExtra("position", 0);
        this.f23303g = intent.getBooleanExtra(KeyUtil.f40168c, false);
        C13583a.f40164c = true;
        m35749b();
        return 2;
    }
}
