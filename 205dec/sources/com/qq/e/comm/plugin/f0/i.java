package com.qq.e.comm.plugin.f0;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.q0.u.j;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.m1;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i extends com.qq.e.comm.plugin.f0.a implements com.qq.e.comm.plugin.q0.f {

    /* renamed from: n  reason: collision with root package name */
    private static final String f43137n = i.class.getSimpleName();

    /* renamed from: g  reason: collision with root package name */
    private final Context f43138g;

    /* renamed from: h  reason: collision with root package name */
    private final String f43139h;

    /* renamed from: i  reason: collision with root package name */
    private ViewGroup f43140i;

    /* renamed from: j  reason: collision with root package name */
    private com.qq.e.comm.plugin.q0.h f43141j;

    /* renamed from: k  reason: collision with root package name */
    private ProgressBar f43142k;

    /* renamed from: l  reason: collision with root package name */
    private Button f43143l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f43144m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a extends j {
        a() {
        }

        @Override // com.qq.e.comm.plugin.q0.u.j
        public com.qq.e.comm.plugin.q0.s.f<String> a(com.qq.e.comm.plugin.q0.h hVar, com.qq.e.comm.plugin.q0.s.d dVar) {
            JSONObject d4 = dVar.d();
            d1.a("doConfirmWithInfo handleAction paramsObj:" + d4, new Object[0]);
            if (hVar.a() != null && d4 != null) {
                String a4 = dVar.a();
                d1.a("doConfirmWithInfo handleAction action:" + a4, new Object[0]);
                if ("download_confirm_action".equals(a4)) {
                    i.this.p();
                    return new com.qq.e.comm.plugin.q0.s.f<>("");
                }
                d1.a("DownloadApkConfirmDialog Unsupported action");
                return new com.qq.e.comm.plugin.q0.s.f<>(null);
            }
            return new com.qq.e.comm.plugin.q0.s.f<>(null);
        }
    }

    public i(Context context, c cVar, String str) {
        super(context, cVar);
        this.f43144m = false;
        this.f43138g = context;
        this.f43139h = str;
        l();
    }

    private void c(int i4) {
        Button button = new Button(this.f43138g, null, 16843563);
        this.f43056d = button;
        button.setTextSize(16.0f);
        this.f43056d.setTextColor(-1);
        this.f43056d.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(i4 / 2);
        gradientDrawable.setColor(-13531652);
        this.f43056d.setBackgroundDrawable(gradientDrawable);
    }

    private FrameLayout i() {
        FrameLayout frameLayout = new FrameLayout(this.f43138g);
        this.f43140i = m();
        frameLayout.addView(this.f43140i, new FrameLayout.LayoutParams(-1, -1));
        this.f43140i.setVisibility(8);
        ProgressBar progressBar = new ProgressBar(this.f43138g);
        this.f43142k = progressBar;
        progressBar.setIndeterminate(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        frameLayout.addView(this.f43142k, layoutParams);
        Button button = new Button(this.f43138g);
        this.f43143l = button;
        button.setText("\u91cd\u65b0\u52a0\u8f7d");
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        this.f43143l.setVisibility(8);
        frameLayout.addView(this.f43143l, layoutParams2);
        return frameLayout;
    }

    private View k() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f43138g);
        TextView textView = new TextView(this.f43138g);
        textView.setText("\u5e94\u7528\u8be6\u60c5");
        textView.setTextSize(18.0f);
        textView.setTextColor(-16777216);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        relativeLayout.addView(textView, layoutParams);
        this.f43055c = new ImageView(this.f43138g);
        int a4 = f1.a(this.f43138g, 15);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a4, a4);
        layoutParams2.addRule(21);
        layoutParams2.addRule(15);
        relativeLayout.addView(this.f43055c, layoutParams2);
        this.f43055c.setImageBitmap(m1.a("iVBORw0KGgoAAAANSUhEUgAAABkAAAAZCAYAAADE6YVjAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAGaADAAQAAAABAAAAGQAAAABY85deAAABiklEQVRIDa2WwW2DMBSGsZtTB0AMkEP36A1YoO2tirJO71HFreoCwK0bMEAOGQB1h0D/37JRQjB+hFoiD+L/fx9+2GDVNM1j27Z7pdRvmqbfiH20svV9r+q6fkGMkyQ5bAjAxQeOqKqqZ8TdGhD8Cnk+Ed95r8gfaY7A3Tg7rEC5/5bEMYBe5te2RIVLdi/IAyhMfib3CbIsE5Uu5B/KEhK6kY6jxDdA7hmRBMC8V5AlIClgEiIBLQF4IQHQHtP8AJBZByaJUsXcJLkpF02uTd0x+k44tk6DdTALoG4WQoEHxC4utCDA6Iw68APQQ1mWR8iGEeD8lOf5E0DngD3SIYEdyWEEoG1rn02wGrMQT6n4TExDv+hd54VMAfgMbIkWvesmIT6AnaZnG8Wgm3oGAMMHTapjXa8gS4w0S/UDRGpg8ssm8RmIRHiZeHwe8quQYJzQdz2bBwvqteu6L2eWviqc/jJOgbTWbxodsROuATAH/P3E9I433Bdx2wLBv+y7CELbYd/1wwEw/x/EKvlUxiHD9QAAAABJRU5ErkJggg=="));
        return relativeLayout;
    }

    private void l() {
        int a4 = f1.a(this.f43138g, 20);
        setPadding(a4, f1.a(this.f43138g, 16), a4, f1.a(this.f43138g, 15));
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 0.0f;
        addView(k(), layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.weight = 1.0f;
        layoutParams2.setMargins(0, f1.a(this.f43138g, 20), 0, 0);
        addView(i(), layoutParams2);
    }

    private ViewGroup m() {
        LinearLayout linearLayout = new LinearLayout(this.f43138g);
        linearLayout.setOrientation(1);
        com.qq.e.comm.plugin.q0.h a4 = new com.qq.e.comm.plugin.q0.d(this.f43138g).a();
        this.f43141j = a4;
        a4.a(this);
        this.f43141j.c().a("download_confirm_service", new a());
        View a5 = this.f43141j.a();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, f1.a(this.f43138g, 12));
        layoutParams.weight = 1.0f;
        linearLayout.addView(a5, layoutParams);
        int a6 = f1.a(this.f43138g, 44);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, a6);
        layoutParams2.weight = 0.0f;
        c(a6);
        linearLayout.addView(this.f43056d, layoutParams2);
        return linearLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        this.f43144m = true;
        this.f43142k.setVisibility(8);
        this.f43140i.setVisibility(8);
        this.f43143l.setVisibility(0);
        this.f43143l.setText("\u91cd\u65b0\u52a0\u8f7d");
        this.f43143l.setEnabled(true);
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a() {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(int i4) {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(ValueCallback<Uri> valueCallback, Intent intent) {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(String str) {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(String str, Bitmap bitmap) {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void b(String str) {
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public boolean b(ValueCallback<Uri[]> valueCallback, Intent intent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.qq.e.comm.plugin.f0.a
    public void e() {
        o();
    }

    void o() {
        if (TextUtils.isEmpty(this.f43139h)) {
            this.f43142k.setVisibility(8);
            this.f43140i.setVisibility(8);
            this.f43143l.setVisibility(0);
            this.f43143l.setText("\u62b1\u6b49\uff0c\u5e94\u7528\u4fe1\u606f\u83b7\u53d6\u5931\u8d25");
            this.f43143l.setEnabled(false);
            return;
        }
        this.f43144m = false;
        this.f43141j.loadUrl(this.f43139h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.qq.e.comm.plugin.f0.a
    public void a(View.OnClickListener onClickListener) {
        super.a(onClickListener);
        this.f43143l.setOnClickListener(onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.qq.e.comm.plugin.f0.a
    public void a(View view) {
        if (view == this.f43143l) {
            d1.a(f43137n, "\u4e94\u8981\u7d20\u5f39\u7a97 WebView Reload");
            o();
        }
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void a(int i4, String str, String str2) {
        d1.a("doConfirmWithInfo onReceivedError:" + str + " " + str2, new Object[0]);
        p();
    }

    @Override // com.qq.e.comm.plugin.q0.f
    public void c(String str) {
        d1.a("doConfirmWithInfo web onPageFinished", new Object[0]);
        if (this.f43144m) {
            return;
        }
        this.f43142k.setVisibility(8);
        this.f43143l.setVisibility(8);
        this.f43140i.setVisibility(0);
    }
}
