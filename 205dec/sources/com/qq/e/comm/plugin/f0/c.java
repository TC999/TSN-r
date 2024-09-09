package com.qq.e.comm.plugin.f0;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.k;
import com.qq.e.comm.plugin.util.m1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c extends Dialog implements View.OnClickListener {

    /* renamed from: m  reason: collision with root package name */
    private static final String f43073m = c.class.getSimpleName();

    /* renamed from: n  reason: collision with root package name */
    private static volatile long f43074n = 0;

    /* renamed from: c  reason: collision with root package name */
    private final Context f43075c;

    /* renamed from: d  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f43076d;

    /* renamed from: e  reason: collision with root package name */
    private final com.qq.e.comm.plugin.i.d0.c f43077e;

    /* renamed from: f  reason: collision with root package name */
    private final int f43078f;

    /* renamed from: g  reason: collision with root package name */
    private final int f43079g;

    /* renamed from: h  reason: collision with root package name */
    private final int f43080h;

    /* renamed from: i  reason: collision with root package name */
    private final int f43081i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f43082j;

    /* renamed from: k  reason: collision with root package name */
    private com.qq.e.comm.plugin.f0.a f43083k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f43084l;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements DialogInterface.OnDismissListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.i.d0.c f43085c;

        a(com.qq.e.comm.plugin.i.d0.c cVar) {
            this.f43085c = cVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            d1.a(c.f43073m, "Dialog onDismiss");
            c.this.f43083k.f();
            com.qq.e.comm.plugin.i.d0.c cVar = this.f43085c;
            if (cVar != null) {
                cVar.b(c.this.f43084l);
            }
            long unused = c.f43074n = 0L;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements DialogInterface.OnShowListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            try {
                c.this.getWindow().setWindowAnimations(0);
            } catch (Throwable unused) {
            }
        }
    }

    public c(Context context, com.qq.e.comm.plugin.g0.e eVar, com.qq.e.comm.plugin.i.d0.c cVar, int i4) {
        super(context, m1.b(context, "DialogFullScreen"));
        Window window;
        this.f43084l = false;
        this.f43075c = context;
        this.f43076d = eVar;
        this.f43077e = cVar;
        this.f43078f = i4;
        this.f43079g = context.getResources().getConfiguration().orientation;
        if (com.qq.e.comm.plugin.apkmanager.w.d.e(this.f43078f)) {
            this.f43080h = 2;
        } else {
            int b4 = com.qq.e.comm.plugin.apkmanager.x.c.b(this.f43076d);
            if (b4 == 3 && (com.qq.e.comm.plugin.apkmanager.w.d.d(i4) || com.qq.e.comm.plugin.d0.a.d().c().n() != com.qq.e.comm.plugin.d0.e.d.WIFI)) {
                b4 = 2;
            }
            this.f43080h = b4;
        }
        this.f43081i = com.qq.e.comm.plugin.apkmanager.x.c.a(this.f43076d);
        this.f43082j = this.f43080h == 3;
        com.qq.e.comm.plugin.apkmanager.x.f a4 = com.qq.e.comm.plugin.n0.w.b.a(eVar.q().e());
        int i5 = this.f43080h;
        if (i5 == 1) {
            a4.f41951g = 6;
        } else if (i5 == 2) {
            a4.f41951g = 7;
        } else if (i5 == 3) {
            a4.f41951g = 8;
        }
        requestWindowFeature(1);
        if (this.f43079g == 2 && Build.VERSION.SDK_INT > 19 && (window = getWindow()) != null) {
            window.getDecorView().setSystemUiVisibility(4100);
        }
        setCanceledOnTouchOutside(true);
        b();
        setOnDismissListener(new a(cVar));
    }

    private void c() {
        try {
            Activity a4 = k.a(this.f43075c);
            if (a4 == null || k.a(a4)) {
                dismiss();
            }
        } catch (Throwable th) {
            d1.a(f43073m, "tryDismiss Exception", th);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        d1.a(f43073m, "Dialog cancel");
        super.cancel();
        this.f43084l = true;
        com.qq.e.comm.plugin.i.d0.c cVar = this.f43077e;
        if (cVar != null) {
            cVar.onCancel();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.f43083k.b()) {
            d1.a(f43073m, "\u4e94\u8981\u7d20\u5f39\u7a97 Close");
            com.qq.e.comm.plugin.i.d0.c cVar = this.f43077e;
            if (cVar != null) {
                cVar.onCancel();
                this.f43084l = true;
                c();
            }
        } else if (view == this.f43083k.d()) {
            d1.a(f43073m, "\u4e94\u8981\u7d20\u5f39\u7a97 Confirm");
            com.qq.e.comm.plugin.i.d0.c cVar2 = this.f43077e;
            if (cVar2 != null) {
                boolean onConfirm = cVar2.onConfirm();
                this.f43084l = true;
                if (onConfirm) {
                    c();
                }
            }
        } else {
            this.f43083k.a(view);
        }
    }

    @Override // android.app.Dialog
    protected void onStart() {
        int i4;
        int a4 = f1.a(this.f43075c);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i5 = this.f43079g;
        if (i5 == 1) {
            attributes.width = -1;
            if (this.f43080h == 1) {
                double d4 = a4;
                Double.isNaN(d4);
                i4 = (int) (d4 * 0.6d);
            } else {
                i4 = -2;
            }
            attributes.height = i4;
            attributes.gravity = 80;
            attributes.windowAnimations = m1.b(this.f43075c, "DialogAnimationUp");
        } else if (i5 == 2) {
            attributes.width = f1.a(this.f43075c, (int) MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS);
            attributes.height = -1;
            attributes.gravity = 5;
            attributes.windowAnimations = m1.b(this.f43075c, "DialogAnimationRight");
        }
        attributes.dimAmount = 0.5f;
        window.setAttributes(attributes);
        setOnShowListener(new b());
        this.f43083k.e();
    }

    @Override // android.app.Dialog
    public void show() {
        if (f43074n == 0 || System.currentTimeMillis() - f43074n >= 1000) {
            f43074n = System.currentTimeMillis();
            super.show();
            com.qq.e.comm.plugin.i.d0.c cVar = this.f43077e;
            if (cVar != null) {
                cVar.a(true);
            }
        }
    }

    private void b() {
        if (this.f43080h == 1) {
            this.f43083k = new i(this.f43075c, this, this.f43076d.r());
        } else {
            this.f43083k = new h(this.f43075c, this, this.f43076d, this.f43082j, this.f43081i, this.f43078f);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(0, 0);
        float a4 = f1.a(this.f43075c, 12);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        int i4 = this.f43079g;
        if (i4 == 1) {
            fArr = new float[]{a4, a4, a4, a4, 0.0f, 0.0f, 0.0f, 0.0f};
        } else if (i4 == 2) {
            fArr = new float[]{a4, a4, 0.0f, 0.0f, 0.0f, 0.0f, a4, a4};
        }
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(-1);
        this.f43083k.setBackgroundDrawable(gradientDrawable);
        if (com.qq.e.comm.plugin.apkmanager.w.d.d(this.f43078f)) {
            this.f43083k.d("\u7acb\u5373\u5b89\u88c5");
        } else if (com.qq.e.comm.plugin.apkmanager.w.d.e(this.f43078f)) {
            this.f43083k.d(String.format("\u4e0b\u8f7d\u4e2d(%d%%)", Integer.valueOf(com.qq.e.comm.plugin.apkmanager.k.e().a(this.f43076d.q().e()))));
        } else {
            this.f43083k.d("\u7acb\u5373\u4e0b\u8f7d");
        }
        this.f43083k.a(this);
        setContentView(this.f43083k, new FrameLayout.LayoutParams(-1, -1));
    }
}
