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
public class SwitchOnAnimSmallView extends FrameLayout {

    /* renamed from: g  reason: collision with root package name */
    public static final int f4791g = 300;

    /* renamed from: h  reason: collision with root package name */
    public static final int f4792h = 500;

    /* renamed from: a  reason: collision with root package name */
    public Handler f4793a;

    /* renamed from: b  reason: collision with root package name */
    public ImageView f4794b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f4795c;

    /* renamed from: d  reason: collision with root package name */
    public float f4796d;

    /* renamed from: e  reason: collision with root package name */
    public float f4797e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4798f;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends a0 {

        /* renamed from: com.acse.ottn.animator.SwitchOnAnimSmallView$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6329136.dex */
        public class RunnableC0078a implements Runnable {

            /* renamed from: com.acse.ottn.animator.SwitchOnAnimSmallView$a$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\6329136.dex */
            public class RunnableC0079a implements Runnable {
                public RunnableC0079a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (SwitchOnAnimSmallView.this.f4795c != null) {
                        SwitchOnAnimSmallView.this.f4795c.setBackgroundResource(R.mipmap.finger_normal);
                    }
                    SwitchOnAnimSmallView.this.d();
                }
            }

            public RunnableC0078a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (SwitchOnAnimSmallView.this.f4794b == null || SwitchOnAnimSmallView.this.f4793a == null) {
                    return;
                }
                SwitchOnAnimSmallView.this.f4794b.setBackgroundResource(R.mipmap.switch_on_circle_point);
                SwitchOnAnimSmallView.this.c();
                SwitchOnAnimSmallView.this.f4793a.postDelayed(new RunnableC0079a(), 100L);
            }
        }

        public a() {
        }

        @Override // com.acse.ottn.a0, com.acse.ottn.i.a
        public void b(com.acse.ottn.i iVar) {
            if (SwitchOnAnimSmallView.this.f4795c == null || SwitchOnAnimSmallView.this.f4793a == null) {
                return;
            }
            SwitchOnAnimSmallView.this.f4795c.setBackgroundResource(R.mipmap.finger_click);
            SwitchOnAnimSmallView.this.f4793a.postDelayed(new RunnableC0078a(), 200L);
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
                if (SwitchOnAnimSmallView.this.f4798f) {
                    return;
                }
                SwitchOnAnimSmallView.this.b();
            }
        }

        public b() {
        }

        @Override // com.acse.ottn.a0, com.acse.ottn.i.a
        public void b(com.acse.ottn.i iVar) {
            SwitchOnAnimSmallView.this.f4793a.postDelayed(new a(), 1000L);
        }
    }

    public SwitchOnAnimSmallView(Context context) {
        this(context, null);
    }

    public void setFingerVisible(boolean z3) {
        if (z3) {
            this.f4795c.setVisibility(0);
        } else {
            this.f4795c.setVisibility(8);
        }
    }

    public SwitchOnAnimSmallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4793a = new Handler();
        this.f4798f = false;
        LayoutInflater.from(context).inflate(R.layout.finger_switch_on_guide_small_layout, (ViewGroup) this, true);
        a();
    }

    public final void a() {
        this.f4794b = (ImageView) findViewById(R.id.switch_anim_circle_point);
        this.f4795c = (ImageView) findViewById(R.id.finger_switch);
        this.f4796d = n4.a(getContext(), 8.0f);
        this.f4797e = n4.a(getContext(), 5.0f);
    }

    public void b() {
        this.f4798f = false;
        i4.i(this.f4794b, 0.0f);
        this.f4794b.setBackgroundResource(R.mipmap.switch_off_circle_point);
        this.f4795c.setBackgroundResource(R.mipmap.finger_normal);
        e();
    }

    public final void c() {
        ImageView imageView = this.f4794b;
        if (imageView == null) {
            return;
        }
        p2 a4 = p2.a(imageView, "translationX", 0.0f, this.f4797e);
        a4.f(500L);
        a4.k();
    }

    public final void d() {
        ImageView imageView = this.f4795c;
        if (imageView == null) {
            return;
        }
        p2 a4 = p2.a(imageView, "translationY", -this.f4796d, 0.0f);
        a4.f(300L);
        a4.a((i.a) new b());
        a4.k();
    }

    public final void e() {
        p2 a4 = p2.a(this.f4795c, "translationY", 0.0f, -this.f4796d);
        a4.f(300L);
        a4.a((i.a) new a());
        a4.k();
    }

    public void f() {
        this.f4798f = true;
    }
}
