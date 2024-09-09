package com.acse.ottn.animator;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.acse.ottn.R;
import com.acse.ottn.a0;
import com.acse.ottn.i;
import com.acse.ottn.i4;
import com.acse.ottn.n4;
import com.acse.ottn.p2;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class SwitchOnAnimView extends FrameLayout {

    /* renamed from: g  reason: collision with root package name */
    public static final int f4804g = 300;

    /* renamed from: h  reason: collision with root package name */
    public static final int f4805h = 500;

    /* renamed from: a  reason: collision with root package name */
    public Handler f4806a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f4807b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f4808c;

    /* renamed from: d  reason: collision with root package name */
    public float f4809d;

    /* renamed from: e  reason: collision with root package name */
    public float f4810e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4811f;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends a0 {

        /* renamed from: com.acse.ottn.animator.SwitchOnAnimView$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class RunnableC0080a implements Runnable {

            /* renamed from: com.acse.ottn.animator.SwitchOnAnimView$a$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\6329136.dex */
            public class RunnableC0081a implements Runnable {
                public RunnableC0081a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (SwitchOnAnimView.this.f4808c != null) {
                        SwitchOnAnimView.this.f4808c.setBackgroundResource(R.mipmap.finger_normal);
                    }
                    SwitchOnAnimView.this.d();
                }
            }

            public RunnableC0080a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwitchOnAnimView.this.f4807b == null || SwitchOnAnimView.this.f4806a == null) {
                    return;
                }
                SwitchOnAnimView.this.f4807b.setBackgroundResource(R.mipmap.switch_on_circle_point);
                SwitchOnAnimView.this.c();
                SwitchOnAnimView.this.f4806a.postDelayed(new RunnableC0081a(), 100L);
            }
        }

        public a() {
        }

        @Override // com.acse.ottn.a0, com.acse.ottn.i.a
        public void b(com.acse.ottn.i iVar) {
            if (SwitchOnAnimView.this.f4808c == null || SwitchOnAnimView.this.f4806a == null) {
                return;
            }
            SwitchOnAnimView.this.f4808c.setBackgroundResource(R.mipmap.finger_click);
            SwitchOnAnimView.this.f4806a.postDelayed(new RunnableC0080a(), 200L);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b extends a0 {

        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwitchOnAnimView.this.f4811f) {
                    return;
                }
                SwitchOnAnimView.this.b();
            }
        }

        public b() {
        }

        @Override // com.acse.ottn.a0, com.acse.ottn.i.a
        public void b(com.acse.ottn.i iVar) {
            SwitchOnAnimView.this.f4806a.postDelayed(new a(), 1000L);
        }
    }

    public SwitchOnAnimView(Context context) {
        this(context, null);
    }

    public void setFingerVisible(boolean z3) {
        if (z3) {
            this.f4808c.setVisibility(0);
        } else {
            this.f4808c.setVisibility(8);
        }
    }

    public SwitchOnAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4806a = new Handler();
        this.f4811f = false;
        LayoutInflater.from(context).inflate(R.layout.finger_switch_on_guide_layout, (ViewGroup) this, true);
        a();
    }

    public final void a() {
        this.f4807b = (ImageView) findViewById(R.id.switch_anim_circle_point);
        this.f4808c = (ImageView) findViewById(R.id.finger_switch);
        this.f4809d = n4.a(getContext(), 20.0f);
        this.f4810e = n4.a(getContext(), 17.5f);
    }

    public void b() {
        this.f4811f = false;
        i4.i(this.f4807b, 0.0f);
        this.f4807b.setBackgroundResource(R.mipmap.switch_off_circle_point);
        this.f4808c.setBackgroundResource(R.mipmap.finger_normal);
        e();
    }

    public final void c() {
        ImageView imageView = this.f4807b;
        if (imageView == null) {
            return;
        }
        p2 a4 = p2.a(imageView, "translationX", 0.0f, this.f4810e);
        a4.f(500L);
        a4.k();
    }

    public final void d() {
        ImageView imageView = this.f4808c;
        if (imageView == null) {
            return;
        }
        p2 a4 = p2.a(imageView, "translationY", -this.f4809d, 0.0f);
        a4.f(300L);
        a4.a((i.a) new b());
        a4.k();
    }

    public final void e() {
        p2 a4 = p2.a(this.f4808c, "translationY", 0.0f, -this.f4809d);
        a4.f(300L);
        a4.a((i.a) new a());
        a4.k();
    }

    public void f() {
        this.f4811f = true;
    }
}
