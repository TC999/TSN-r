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
public class SwitchOnAnimView extends FrameLayout {

    /* renamed from: a */
    private static final int f2248a = 300;

    /* renamed from: b */
    private static final int f2249b = 500;

    /* renamed from: c */
    private Handler f2250c;

    /* renamed from: d */
    private ImageView f2251d;

    /* renamed from: e */
    private ImageView f2252e;

    /* renamed from: f */
    private float f2253f;

    /* renamed from: g */
    private float f2254g;

    /* renamed from: h */
    private boolean f2255h;

    public SwitchOnAnimView(Context context) {
        this(context, null);
    }

    public SwitchOnAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2250c = new Handler();
        this.f2255h = false;
        LayoutInflater.from(context).inflate(C1239R.C1244layout.finger_switch_on_guide_layout, (ViewGroup) this, true);
        m57200c();
    }

    /* renamed from: c */
    private void m57200c() {
        this.f2251d = (ImageView) findViewById(C1239R.C1242id.switch_anim_circle_point);
        this.f2252e = (ImageView) findViewById(C1239R.C1242id.finger_switch);
        this.f2253f = C1400l.m56851a(getContext(), 20.0f);
        this.f2254g = C1400l.m56851a(getContext(), 17.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m57198d() {
        ImageView imageView = this.f2251d;
        if (imageView == null) {
            return;
        }
        C1355m m57047a = C1355m.m57047a(imageView, "translationX", 0.0f, this.f2254g);
        m57047a.mo57054a(500L);
        m57047a.mo57038j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m57196e() {
        ImageView imageView = this.f2252e;
        if (imageView == null) {
            return;
        }
        C1355m m57047a = C1355m.m57047a(imageView, "translationY", -this.f2253f, 0.0f);
        m57047a.mo57054a(300L);
        m57047a.m57118a((AbstractC1334a.InterfaceC1335a) new C1399k(this));
        m57047a.mo57038j();
    }

    /* renamed from: f */
    private void m57194f() {
        C1355m m57047a = C1355m.m57047a(this.f2252e, "translationY", 0.0f, -this.f2253f);
        m57047a.mo57054a(300L);
        m57047a.m57118a((AbstractC1334a.InterfaceC1335a) new C1397i(this));
        m57047a.mo57038j();
    }

    /* renamed from: a */
    public void m57204a() {
        this.f2255h = false;
        C1376a.m56981i(this.f2251d, 0.0f);
        this.f2251d.setBackgroundResource(C1239R.mipmap.switch_off_circle_point);
        this.f2252e.setBackgroundResource(C1239R.mipmap.finger_normal);
        m57194f();
    }

    /* renamed from: b */
    public void m57202b() {
        this.f2255h = true;
    }

    public void setFingerVisible(boolean z) {
        ImageView imageView;
        int i;
        if (z) {
            imageView = this.f2252e;
            i = 0;
        } else {
            imageView = this.f2252e;
            i = 8;
        }
        imageView.setVisibility(i);
    }
}
