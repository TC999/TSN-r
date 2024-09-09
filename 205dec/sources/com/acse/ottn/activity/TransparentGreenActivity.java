package com.acse.ottn.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.acse.ottn.R;
import com.acse.ottn.animator.SwitchOnAnimView;
import com.acse.ottn.g0;
import com.acse.ottn.h1;
import com.acse.ottn.j0;
import com.acse.ottn.util.HelpShopAppUtil;
import com.acse.ottn.z1;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class TransparentGreenActivity extends com.acse.ottn.z {

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f4716e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f4717f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f4718g = new Handler();

    /* renamed from: h  reason: collision with root package name */
    public SwitchOnAnimView f4719h;

    /* renamed from: i  reason: collision with root package name */
    public SwitchOnAnimView f4720i;

    /* renamed from: j  reason: collision with root package name */
    public ImageView f4721j;

    /* renamed from: k  reason: collision with root package name */
    public TextView f4722k;

    /* renamed from: l  reason: collision with root package name */
    public TextView f4723l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f4724m;

    /* renamed from: n  reason: collision with root package name */
    public String f4725n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f4726o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f4727p;

    /* renamed from: q  reason: collision with root package name */
    public AnimatorSet f4728q;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AnimatorSet animatorSet = TransparentGreenActivity.this.f4728q;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (TransparentGreenActivity.this.f4719h != null) {
                TransparentGreenActivity.this.f4719h.f();
                TransparentGreenActivity.this.f4719h = null;
            }
            if (TransparentGreenActivity.this.f4720i != null) {
                TransparentGreenActivity.this.f4720i.f();
                TransparentGreenActivity.this.f4720i = null;
            }
            TransparentGreenActivity.this.finishAndRemoveTask();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AnimatorSet animatorSet = TransparentGreenActivity.this.f4728q;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            if (TransparentGreenActivity.this.f4719h != null) {
                TransparentGreenActivity.this.f4719h.f();
                TransparentGreenActivity.this.f4719h = null;
            }
            if (TransparentGreenActivity.this.f4720i != null) {
                TransparentGreenActivity.this.f4720i.f();
                TransparentGreenActivity.this.f4720i = null;
            }
            TransparentGreenActivity.this.finishAndRemoveTask();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TransparentGreenActivity.this.f4719h.b();
                TransparentGreenActivity.this.f4720i.b();
            } catch (Exception e4) {
                z1.b("TransparentActivity", e4.getMessage());
            }
        }
    }

    static {
        StubApp.interface11(4687);
    }

    public static Bitmap d() {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = HelpShopAppUtil.getContext().getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(HelpShopAppUtil.getContext().getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return a(packageManager.getApplicationIcon(applicationInfo));
    }

    public String c() {
        return h1.c().b();
    }

    public final void e() {
        g0.a().a(this, this.f4726o);
        this.f4725n = g0.a().e(this);
    }

    public final void f() {
        ((TextView) findViewById(R.id.tv_step)).setText(Html.fromHtml("\u6ed1\u52a8\u5217\u8868\u627e\u5230\u201c<font color=" + this.f4725n + ">" + j0.f5759a + "</font>\u201d"));
        Spanned fromHtml = Html.fromHtml("\u1f449\u3010<font color=" + this.f4725n + ">" + j0.f5759a + "</font>\u3011\u2014\u8bf7\u542f\u7528\u1f3c3");
        TextView textView = (TextView) findViewById(R.id.tv_permission_name);
        this.f4727p = textView;
        textView.setText(fromHtml);
        this.f4724m = (TextView) findViewById(R.id.tv_permission);
        ((TextView) findViewById(R.id.tv_step_two)).setText(Html.fromHtml("\u7b2c\u4e8c\u6b65\uff1a\u6ed1\u52a8\u5217\u8868\uff0c\u627e\u5230\u201c<font color=" + this.f4725n + ">" + j0.f5759a + "</font>\u201d"));
        this.f4722k = (TextView) findViewById(R.id.tv_step_one);
        StringBuilder sb = new StringBuilder();
        sb.append("\u7b2c\u4e00\u6b65\uff1a\u6ed1\u52a8\u5217\u8868\uff0c\u6253\u5f00\u201c<font color=");
        sb.append(this.f4725n);
        sb.append(">\u5df2\u5b89\u88c5\u7684\u670d\u52a1</font>\u201d");
        this.f4722k.setText(Html.fromHtml(sb.toString()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006d, code lost:
        if (r0.equals("oppo") == false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g() {
        /*
            Method dump skipped, instructions count: 960
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.activity.TransparentGreenActivity.g():void");
    }

    @Override // com.acse.ottn.z, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // com.acse.ottn.z, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        AnimatorSet animatorSet = this.f4728q;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        SwitchOnAnimView switchOnAnimView = this.f4719h;
        if (switchOnAnimView != null) {
            switchOnAnimView.f();
            this.f4719h = null;
        }
        SwitchOnAnimView switchOnAnimView2 = this.f4720i;
        if (switchOnAnimView2 != null) {
            switchOnAnimView2.f();
            this.f4720i = null;
        }
        super.onDestroy();
    }

    public static Bitmap a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    public void a(ImageView imageView) {
        g0.a().a(this, imageView);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "translationY", -20.0f, 20.0f, -20.0f);
        ofFloat.setDuration(500L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.start();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat);
        animatorSet.setStartDelay(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        animatorSet.start();
    }
}
