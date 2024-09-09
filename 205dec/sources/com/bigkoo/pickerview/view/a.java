package com.bigkoo.pickerview.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.bigkoo.pickerview.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BasePickerView.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    private Context f16314b;

    /* renamed from: c  reason: collision with root package name */
    protected ViewGroup f16315c;

    /* renamed from: d  reason: collision with root package name */
    private ViewGroup f16316d;

    /* renamed from: e  reason: collision with root package name */
    private ViewGroup f16317e;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f16318f;

    /* renamed from: l  reason: collision with root package name */
    private i.b f16324l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f16325m;

    /* renamed from: n  reason: collision with root package name */
    private Animation f16326n;

    /* renamed from: o  reason: collision with root package name */
    private Animation f16327o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f16328p;

    /* renamed from: r  reason: collision with root package name */
    private Dialog f16330r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f16331s;

    /* renamed from: t  reason: collision with root package name */
    protected View f16332t;

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout.LayoutParams f16313a = new FrameLayout.LayoutParams(-1, -2, 80);

    /* renamed from: g  reason: collision with root package name */
    protected int f16319g = -16417281;

    /* renamed from: h  reason: collision with root package name */
    protected int f16320h = -4007179;

    /* renamed from: i  reason: collision with root package name */
    protected int f16321i = -657931;

    /* renamed from: j  reason: collision with root package name */
    protected int f16322j = -16777216;

    /* renamed from: k  reason: collision with root package name */
    protected int f16323k = -1;

    /* renamed from: q  reason: collision with root package name */
    private int f16329q = 80;

    /* renamed from: u  reason: collision with root package name */
    private View.OnKeyListener f16333u = new c();

    /* renamed from: v  reason: collision with root package name */
    private final View.OnTouchListener f16334v = new d();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BasePickerView.java */
    /* renamed from: com.bigkoo.pickerview.view.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class View$OnClickListenerC0158a implements View.OnClickListener {
        View$OnClickListenerC0158a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BasePickerView.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class b implements Animation.AnimationListener {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: BasePickerView.java */
        /* renamed from: com.bigkoo.pickerview.view.a$b$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        class RunnableC0159a implements Runnable {
            RunnableC0159a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f();
            }
        }

        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.f16316d.post(new RunnableC0159a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BasePickerView.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class c implements View.OnKeyListener {
        c() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i4, KeyEvent keyEvent) {
            if (i4 == 4 && keyEvent.getAction() == 0 && a.this.n()) {
                a.this.d();
                return true;
            }
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BasePickerView.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                a.this.d();
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BasePickerView.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class e implements DialogInterface.OnDismissListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (a.this.f16324l != null) {
                a.this.f16324l.a(a.this);
            }
        }
    }

    public a(Context context) {
        this.f16314b = context;
    }

    private void o(View view) {
        this.f16316d.addView(view);
        this.f16315c.startAnimation(this.f16327o);
    }

    public void c() {
        if (this.f16318f != null) {
            Dialog dialog = new Dialog(this.f16314b, R.style.custom_dialog2);
            this.f16330r = dialog;
            dialog.setCancelable(this.f16331s);
            this.f16330r.setContentView(this.f16318f);
            this.f16330r.setOnDismissListener(new e());
        }
    }

    public void d() {
        if (m()) {
            e();
        } else if (this.f16325m) {
        } else {
            this.f16325m = true;
            this.f16326n.setAnimationListener(new b());
            this.f16315c.startAnimation(this.f16326n);
        }
    }

    public void e() {
        Dialog dialog = this.f16330r;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void f() {
        this.f16316d.removeView(this.f16317e);
        this.f16328p = false;
        this.f16325m = false;
        i.b bVar = this.f16324l;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public View g(int i4) {
        return this.f16315c.findViewById(i4);
    }

    public Animation h() {
        return AnimationUtils.loadAnimation(this.f16314b, k.a.a(this.f16329q, true));
    }

    public Animation i() {
        return AnimationUtils.loadAnimation(this.f16314b, k.a.a(this.f16329q, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        this.f16327o = h();
        this.f16326n = i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        LayoutInflater from = LayoutInflater.from(this.f16314b);
        if (m()) {
            ViewGroup viewGroup = (ViewGroup) from.inflate(R.layout.layout_basepickerview, (ViewGroup) null, false);
            this.f16318f = viewGroup;
            viewGroup.setBackgroundColor(0);
            ViewGroup viewGroup2 = (ViewGroup) this.f16318f.findViewById(R.id.content_container);
            this.f16315c = viewGroup2;
            FrameLayout.LayoutParams layoutParams = this.f16313a;
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            viewGroup2.setLayoutParams(layoutParams);
            c();
            this.f16318f.setOnClickListener(new View$OnClickListenerC0158a());
        } else {
            ViewGroup viewGroup3 = (ViewGroup) ((Activity) this.f16314b).getWindow().getDecorView().findViewById(16908290);
            this.f16316d = viewGroup3;
            ViewGroup viewGroup4 = (ViewGroup) from.inflate(R.layout.layout_basepickerview, viewGroup3, false);
            this.f16317e = viewGroup4;
            viewGroup4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            ViewGroup viewGroup5 = (ViewGroup) this.f16317e.findViewById(R.id.content_container);
            this.f16315c = viewGroup5;
            viewGroup5.setLayoutParams(this.f16313a);
        }
        q(true);
    }

    public boolean m() {
        return false;
    }

    public boolean n() {
        if (m()) {
            return false;
        }
        return this.f16317e.getParent() != null || this.f16328p;
    }

    public void p(boolean z3) {
        this.f16331s = z3;
    }

    public a q(boolean z3) {
        ViewGroup viewGroup;
        if (m()) {
            viewGroup = this.f16318f;
        } else {
            viewGroup = this.f16317e;
        }
        viewGroup.setFocusable(z3);
        viewGroup.setFocusableInTouchMode(z3);
        if (z3) {
            viewGroup.setOnKeyListener(this.f16333u);
        } else {
            viewGroup.setOnKeyListener(null);
        }
        return this;
    }

    public a r(i.b bVar) {
        this.f16324l = bVar;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a s(boolean z3) {
        ViewGroup viewGroup = this.f16317e;
        if (viewGroup != null) {
            View findViewById = viewGroup.findViewById(R.id.outmost_container);
            if (z3) {
                findViewById.setOnTouchListener(this.f16334v);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void t() {
        if (m()) {
            v();
        } else if (n()) {
        } else {
            this.f16328p = true;
            o(this.f16317e);
            this.f16317e.requestFocus();
        }
    }

    public void u(View view) {
        this.f16332t = view;
        t();
    }

    public void v() {
        Dialog dialog = this.f16330r;
        if (dialog != null) {
            dialog.show();
        }
    }
}
