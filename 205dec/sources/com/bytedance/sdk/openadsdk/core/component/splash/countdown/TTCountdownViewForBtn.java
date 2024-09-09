package com.bytedance.sdk.openadsdk.core.component.splash.countdown;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTCountdownViewForBtn extends LinearLayout implements n.c, w {

    /* renamed from: c  reason: collision with root package name */
    protected final n f32881c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private AtomicBoolean f32882f;

    /* renamed from: r  reason: collision with root package name */
    private int f32883r;
    private TextView sr;
    private c ux;

    /* renamed from: w  reason: collision with root package name */
    private Context f32884w;
    private TextView xv;

    public TTCountdownViewForBtn(Context context) {
        super(context);
        this.f32882f = new AtomicBoolean(true);
        this.f32881c = new n(Looper.getMainLooper(), this);
        this.f32883r = 5;
        this.ev = 1;
        this.f32884w = context;
        sr();
    }

    private void f() {
        try {
            if (this.xv == null) {
                return;
            }
            r();
            int i4 = this.ev;
            if (i4 >= this.f32883r + 1) {
                c cVar = this.ux;
                if (cVar != null) {
                    cVar.w();
                    return;
                }
                return;
            }
            this.ev = i4 + 1;
            this.f32881c.sendEmptyMessageDelayed(1, 1000L);
        } catch (Exception unused) {
        }
    }

    private void r() {
        if (this.xv != null) {
            StringBuilder sb = new StringBuilder();
            int i4 = this.ev;
            int i5 = this.f32883r;
            sb.append(i4 <= i5 ? i5 - i4 : 0);
            sb.append("s");
            this.xv.setText(sb.toString());
        }
    }

    private void sr() {
        setOrientation(0);
        setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#99333333"));
        int ux = xk.ux(this.f32884w, 14.0f);
        gradientDrawable.setCornerRadius(ux);
        int i4 = ux * 2;
        gradientDrawable.setSize(i4, i4);
        setBackground(gradientDrawable);
        this.xv = new TextView(this.f32884w);
        int ux2 = xk.ux(this.f32884w, 6.0f);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.xv.setTextColor(-1);
        this.xv.setTextSize(2, 14.0f);
        addView(this.xv, layoutParams);
        View view = new View(this.f32884w);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.width = xk.ux(this.f32884w, 1.0f);
        layoutParams2.height = xk.ux(this.f32884w, 12.0f);
        layoutParams2.leftMargin = ux2;
        layoutParams2.rightMargin = ux2;
        view.setBackgroundColor(-1);
        addView(view, layoutParams2);
        this.sr = new TextView(this.f32884w);
        ViewGroup.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.sr.setTextColor(-1);
        this.sr.setTextSize(2, 14.0f);
        this.sr.setText("\u8df3\u8fc7");
        addView(this.sr, layoutParams3);
    }

    private void ux() {
        n nVar = this.f32881c;
        if (nVar != null) {
            nVar.removeMessages(1);
        }
        this.ev = 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.w
    public void c() {
        ux();
        f();
        this.ux.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.w
    public View getView() {
        return this;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ux();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        this.f32882f.set(z3);
        if (!this.f32882f.get()) {
            w();
            c cVar = this.ux;
            if (cVar != null) {
                cVar.xv();
                return;
            }
            return;
        }
        xv();
        c cVar2 = this.ux;
        if (cVar2 != null) {
            cVar2.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.w
    public void setCountDownTime(int i4) {
        this.f32883r = i4;
        r();
        ux();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.w
    public void setCountdownListener(c cVar) {
        this.ux = cVar;
        if (this.f32882f.get() || cVar == null) {
            return;
        }
        cVar.xv();
    }

    public void w() {
        try {
            n nVar = this.f32881c;
            if (nVar != null) {
                nVar.removeMessages(1);
            }
        } catch (Throwable unused) {
        }
    }

    public void xv() {
        try {
            f();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        if (message.what == 1) {
            f();
        }
    }
}
