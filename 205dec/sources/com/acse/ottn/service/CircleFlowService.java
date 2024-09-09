package com.acse.ottn.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.R;
import com.acse.ottn.i2;
import com.acse.ottn.j0;
import com.acse.ottn.l0;
import com.acse.ottn.m0;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.s0;
import com.acse.ottn.service.C1391a;
import com.acse.ottn.w1;
import com.acse.ottn.z1;
import com.stub.StubApp;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class CircleFlowService extends Service {

    /* renamed from: h  reason: collision with root package name */
    public static View f6274h = null;

    /* renamed from: i  reason: collision with root package name */
    public static WindowManager f6275i = null;

    /* renamed from: j  reason: collision with root package name */
    public static String f6276j = "MainService";

    /* renamed from: k  reason: collision with root package name */
    public static TimerTask f6277k;

    /* renamed from: a  reason: collision with root package name */
    public WindowManager.LayoutParams f6278a;

    /* renamed from: b  reason: collision with root package name */
    public RelativeLayout f6279b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f6280c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f6281d;

    /* renamed from: e  reason: collision with root package name */
    public AccessiblityModel f6282e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f6283f;

    /* renamed from: g  reason: collision with root package name */
    public m0 f6284g = new d();

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessiblityModel f6285a;

        public a(AccessiblityModel accessiblityModel) {
            this.f6285a = accessiblityModel;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TimerTask timerTask = CircleFlowService.f6277k;
            if (timerTask != null) {
                timerTask.cancel();
            }
            CircleFlowService.this.f();
            i2.a().a("tb_lj_circle_click");
            C1391a.b().a(CircleFlowService.this, this.f6285a, (C1391a.m0) null);
            w1.b().a();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            CircleFlowService.this.f();
            i2.a().a("tb_lj_circle_close");
            w1.b().a();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements l0.d {

        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j0.f5763e) {
                    return;
                }
                TimerTask timerTask = CircleFlowService.f6277k;
                if (timerTask != null) {
                    timerTask.cancel();
                }
                w1.b().a();
                CircleFlowService.this.f();
            }
        }

        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class b implements View.OnClickListener {

            /* loaded from: E:\TSN-r\205dec\6329136.dex */
            public class a implements View.OnClickListener {
                public a() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    TimerTask timerTask = CircleFlowService.f6277k;
                    if (timerTask != null) {
                        timerTask.cancel();
                    }
                    i2.a().a("tb_lj_circle_again");
                    CircleFlowService.this.f();
                    if (CircleFlowService.this.f6282e == null) {
                        return;
                    }
                    C1391a b4 = C1391a.b();
                    CircleFlowService circleFlowService = CircleFlowService.this;
                    b4.a(circleFlowService, circleFlowService.f6282e, (C1391a.m0) null);
                    w1.b().a();
                }
            }

            /* renamed from: com.acse.ottn.service.CircleFlowService$c$b$b  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\6329136.dex */
            public class C0092b implements l0.d {

                /* renamed from: com.acse.ottn.service.CircleFlowService$c$b$b$a */
                /* loaded from: E:\TSN-r\205dec\6329136.dex */
                public class a implements Runnable {
                    public a() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (j0.f5763e) {
                            return;
                        }
                        TimerTask timerTask = CircleFlowService.f6277k;
                        if (timerTask != null) {
                            timerTask.cancel();
                        }
                        w1.b().a();
                        CircleFlowService.this.f();
                    }
                }

                public C0092b() {
                }

                @Override // com.acse.ottn.l0.d
                public void a(long j4) {
                    new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
                }

                @Override // com.acse.ottn.l0.d
                public void a() {
                    w1.b().a();
                    CircleFlowService.this.f();
                }
            }

            public b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                i2.a().a("tb_lj_fan_click");
                CircleFlowService.this.f6280c.setVisibility(8);
                CircleFlowService.this.f6283f.setVisibility(0);
                CircleFlowService.this.f6281d.setVisibility(0);
                CircleFlowService.this.f6278a.width = s0.a((Context) CircleFlowService.this, 106.0f);
                CircleFlowService.this.f6278a.height = s0.a((Context) CircleFlowService.this, 80.0f);
                CircleFlowService.f6275i.updateViewLayout(CircleFlowService.f6274h, CircleFlowService.this.f6278a);
                CircleFlowService.this.f6281d.setOnClickListener(new a());
                CircleFlowService.f6277k = l0.a().b(CircleFlowService.this.f6282e.getData().getTime_four(), 500, new C0092b());
            }
        }

        /* renamed from: com.acse.ottn.service.CircleFlowService$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class C0093c implements l0.d {

            /* renamed from: com.acse.ottn.service.CircleFlowService$c$c$a */
            /* loaded from: E:\TSN-r\205dec\6329136.dex */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (j0.f5763e) {
                        return;
                    }
                    TimerTask timerTask = CircleFlowService.f6277k;
                    if (timerTask != null) {
                        timerTask.cancel();
                    }
                    w1.b().a();
                    CircleFlowService.this.f();
                }
            }

            public C0093c() {
            }

            @Override // com.acse.ottn.l0.d
            public void a(long j4) {
                new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
            }

            @Override // com.acse.ottn.l0.d
            public void a() {
                w1.b().a();
                CircleFlowService.this.f();
            }
        }

        public c() {
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            new Handler(Looper.getMainLooper()).postDelayed(new a(), 0L);
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            z1.a(CircleFlowService.f6276j, "\u7ed3\u675f\u4e86");
            CircleFlowService.this.f6281d.setVisibility(8);
            CircleFlowService.this.f6283f.setVisibility(8);
            CircleFlowService.this.f6280c.setVisibility(0);
            CircleFlowService.this.f6278a.width = s0.a((Context) CircleFlowService.this, 59.0f);
            CircleFlowService.this.f6278a.height = s0.a((Context) CircleFlowService.this, 71.0f);
            CircleFlowService.f6275i.updateViewLayout(CircleFlowService.f6274h, CircleFlowService.this.f6278a);
            CircleFlowService.this.f6280c.setOnClickListener(new b());
            CircleFlowService.f6277k = l0.a().b(CircleFlowService.this.f6282e.getData().getCoupon_detail_url(), 500, new C0093c());
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements m0 {
        public d() {
        }

        @Override // com.acse.ottn.m0
        public void a() {
            TimerTask timerTask = CircleFlowService.f6277k;
            if (timerTask != null) {
                timerTask.cancel();
            }
            CircleFlowService.this.f();
        }
    }

    static {
        StubApp.interface11(5021);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void e() {
        this.f6278a = new WindowManager.LayoutParams();
        f6275i = (WindowManager) getApplication().getSystemService("window");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f6278a.type = 2038;
        } else {
            this.f6278a.type = 2002;
        }
        WindowManager.LayoutParams layoutParams = this.f6278a;
        layoutParams.format = 1;
        layoutParams.flags = 8;
        layoutParams.gravity = 85;
        layoutParams.x = 0;
        layoutParams.y = 700;
        layoutParams.width = s0.a((Context) this, 106.0f);
        this.f6278a.height = s0.a((Context) this, 80.0f);
    }

    public void f() {
        try {
            View view = f6274h;
            if (view != null) {
                view.setVisibility(8);
            }
            f6275i.removeView(f6274h);
            stopSelf();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        e();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        try {
            AccessiblityModel accessiblityModel = (AccessiblityModel) intent.getSerializableExtra("model");
            this.f6282e = accessiblityModel;
            if (accessiblityModel != null && accessiblityModel.getData() != null) {
                a(this.f6282e);
            }
        } catch (Exception e4) {
            try {
                String str = f6276j;
                z1.a(str, "Exception =" + e4.getMessage());
            } catch (Exception unused) {
            }
        }
        return super.onStartCommand(intent, i4, i5);
    }

    public final void d() {
        f6277k = l0.a().b(this.f6282e.getData().getThird_price(), 500, new c());
    }

    public final void a(int i4) {
        try {
            View inflate = LayoutInflater.from(getApplication()).inflate(i4, (ViewGroup) null);
            f6274h = inflate;
            inflate.measure(0, 0);
        } catch (Exception unused) {
        }
    }

    public void a(AccessiblityModel accessiblityModel) {
        a(R.layout.circle_lj_background);
        this.f6279b = (RelativeLayout) f6274h.findViewById(R.id.treasure_box);
        this.f6283f = (TextView) f6274h.findViewById(R.id.tv_context);
        this.f6280c = (ImageView) f6274h.findViewById(R.id.tv_fan);
        this.f6281d = (ImageView) f6274h.findViewById(R.id.image);
        this.f6283f.setText(accessiblityModel.getData().getSpop_title());
        this.f6281d.setOnClickListener(new a(accessiblityModel));
        ((ImageView) f6274h.findViewById(R.id.iv_didi_setting)).setOnClickListener(new b());
        f6275i.addView(f6274h, this.f6278a);
        if (accessiblityModel.getData().getThird_price() == 0) {
            this.f6281d.setVisibility(8);
            this.f6283f.setVisibility(8);
            this.f6280c.setVisibility(0);
            this.f6278a.width = s0.a((Context) this, 59.0f);
            this.f6278a.height = s0.a((Context) this, 71.0f);
            f6275i.updateViewLayout(f6274h, this.f6278a);
        }
        d();
        j0.a(this.f6284g);
    }
}
