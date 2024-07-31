package com.acse.ottn.animator;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.acse.ottn.C1239R;
import com.acse.ottn.animator.p031a.AbstractC1334a;
import com.acse.ottn.animator.p031a.C1355m;
import com.acse.ottn.animator.p033c.C1376a;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class SwitchOnAnimSmallView extends FrameLayout {

    /* renamed from: a */
    private static final int f2240a = 300;

    /* renamed from: b */
    private static final int f2241b = 500;

    /* renamed from: c */
    private Handler f2242c;

    /* renamed from: d */
    private ImageView f2243d;

    /* renamed from: e */
    private ImageView f2244e;

    /* renamed from: f */
    private float f2245f;

    /* renamed from: g */
    private float f2246g;

    /* renamed from: h */
    private boolean f2247h;

    public SwitchOnAnimSmallView(Context context) {
        this(context, null);
    }

    public SwitchOnAnimSmallView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2242c = new Handler();
        this.f2247h = false;
        LayoutInflater.from(context).inflate(C1239R.C1244layout.finger_switch_on_guide_small_layout, (ViewGroup) this, true);
        m57212c();
    }

    /* renamed from: c */
    private void m57212c() {
        this.f2243d = (ImageView) findViewById(C1239R.C1242id.switch_anim_circle_point);
        this.f2244e = (ImageView) findViewById(C1239R.C1242id.finger_switch);
        this.f2245f = C1400l.m56851a(getContext(), 8.0f);
        this.f2246g = C1400l.m56851a(getContext(), 5.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m57210d() {
        ImageView imageView = this.f2243d;
        if (imageView == null) {
            return;
        }
        C1355m m57047a = C1355m.m57047a(imageView, "translationX", 0.0f, this.f2246g);
        m57047a.mo57054a(500L);
        m57047a.mo57038j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m57208e() {
        ImageView imageView = this.f2244e;
        if (imageView == null) {
            return;
        }
        C1355m m57047a = C1355m.m57047a(imageView, "translationY", -this.f2245f, 0.0f);
        m57047a.mo57054a(300L);
        m57047a.m57118a((AbstractC1334a.InterfaceC1335a) new C1394f(this));
        m57047a.mo57038j();
    }

    /* renamed from: f */
    private void m57206f() {
        C1355m m57047a = C1355m.m57047a(this.f2244e, "translationY", 0.0f, -this.f2245f);
        m57047a.mo57054a(300L);
        m57047a.m57118a((AbstractC1334a.InterfaceC1335a) new C1392d(this));
        m57047a.mo57038j();
    }

    /* renamed from: a */
    public void m57216a() {
        this.f2247h = false;
        C1376a.m56981i(this.f2243d, 0.0f);
        this.f2243d.setBackgroundResource(C1239R.mipmap.switch_off_circle_point);
        this.f2244e.setBackgroundResource(C1239R.mipmap.finger_normal);
        m57206f();
    }

    /* renamed from: b */
    public void m57214b() {
        this.f2247h = true;
    }

    public void setFingerVisible(boolean z) {
        ImageView imageView;
        int i;
        if (z) {
            imageView = this.f2244e;
            i = 0;
        } else {
            imageView = this.f2244e;
            i = 8;
        }
        imageView.setVisibility(i);
    }
}
