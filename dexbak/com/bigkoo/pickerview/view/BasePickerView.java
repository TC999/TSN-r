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
import androidx.core.view.ViewCompat;
import com.bigkoo.pickerview.C3501R;
import p600i.OnDismissListener;
import p610k.PickerViewAnimateUtil;

/* renamed from: com.bigkoo.pickerview.view.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BasePickerView {

    /* renamed from: b */
    private Context f13116b;

    /* renamed from: c */
    protected ViewGroup f13117c;

    /* renamed from: d */
    private ViewGroup f13118d;

    /* renamed from: e */
    private ViewGroup f13119e;

    /* renamed from: f */
    private ViewGroup f13120f;

    /* renamed from: l */
    private OnDismissListener f13126l;

    /* renamed from: m */
    private boolean f13127m;

    /* renamed from: n */
    private Animation f13128n;

    /* renamed from: o */
    private Animation f13129o;

    /* renamed from: p */
    private boolean f13130p;

    /* renamed from: r */
    private Dialog f13132r;

    /* renamed from: s */
    private boolean f13133s;

    /* renamed from: t */
    protected View f13134t;

    /* renamed from: a */
    private final FrameLayout.LayoutParams f13115a = new FrameLayout.LayoutParams(-1, -2, 80);

    /* renamed from: g */
    protected int f13121g = -16417281;

    /* renamed from: h */
    protected int f13122h = -4007179;

    /* renamed from: i */
    protected int f13123i = -657931;

    /* renamed from: j */
    protected int f13124j = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: k */
    protected int f13125k = -1;

    /* renamed from: q */
    private int f13131q = 80;

    /* renamed from: u */
    private View.OnKeyListener f13135u = new View$OnKeyListenerC3517c();

    /* renamed from: v */
    private final View.OnTouchListener f13136v = new View$OnTouchListenerC3518d();

    /* compiled from: BasePickerView.java */
    /* renamed from: com.bigkoo.pickerview.view.a$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class View$OnClickListenerC3514a implements View.OnClickListener {
        View$OnClickListenerC3514a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BasePickerView.this.m45874d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasePickerView.java */
    /* renamed from: com.bigkoo.pickerview.view.a$b  reason: invalid class name */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class animationAnimation$AnimationListenerC3515b implements Animation.AnimationListener {

        /* compiled from: BasePickerView.java */
        /* renamed from: com.bigkoo.pickerview.view.a$b$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        class RunnableC3516a implements Runnable {
            RunnableC3516a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BasePickerView.this.m45872f();
            }
        }

        animationAnimation$AnimationListenerC3515b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            BasePickerView.this.f13118d.post(new RunnableC3516a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: BasePickerView.java */
    /* renamed from: com.bigkoo.pickerview.view.a$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class View$OnKeyListenerC3517c implements View.OnKeyListener {
        View$OnKeyListenerC3517c() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0 && BasePickerView.this.m45864n()) {
                BasePickerView.this.m45874d();
                return true;
            }
            return false;
        }
    }

    /* compiled from: BasePickerView.java */
    /* renamed from: com.bigkoo.pickerview.view.a$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    class View$OnTouchListenerC3518d implements View.OnTouchListener {
        View$OnTouchListenerC3518d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                BasePickerView.this.m45874d();
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BasePickerView.java */
    /* renamed from: com.bigkoo.pickerview.view.a$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class DialogInterface$OnDismissListenerC3519e implements DialogInterface.OnDismissListener {
        DialogInterface$OnDismissListenerC3519e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (BasePickerView.this.f13126l != null) {
                BasePickerView.this.f13126l.m12720a(BasePickerView.this);
            }
        }
    }

    public BasePickerView(Context context) {
        this.f13116b = context;
    }

    /* renamed from: o */
    private void m45863o(View view) {
        this.f13118d.addView(view);
        this.f13117c.startAnimation(this.f13129o);
    }

    /* renamed from: c */
    public void m45875c() {
        if (this.f13120f != null) {
            Dialog dialog = new Dialog(this.f13116b, C3501R.C3507style.custom_dialog2);
            this.f13132r = dialog;
            dialog.setCancelable(this.f13133s);
            this.f13132r.setContentView(this.f13120f);
            this.f13132r.setOnDismissListener(new DialogInterface$OnDismissListenerC3519e());
        }
    }

    /* renamed from: d */
    public void m45874d() {
        if (mo45865m()) {
            m45873e();
        } else if (this.f13127m) {
        } else {
            this.f13127m = true;
            this.f13128n.setAnimationListener(new animationAnimation$AnimationListenerC3515b());
            this.f13117c.startAnimation(this.f13128n);
        }
    }

    /* renamed from: e */
    public void m45873e() {
        Dialog dialog = this.f13132r;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* renamed from: f */
    public void m45872f() {
        this.f13118d.removeView(this.f13119e);
        this.f13130p = false;
        this.f13127m = false;
        OnDismissListener onDismissListener = this.f13126l;
        if (onDismissListener != null) {
            onDismissListener.m12720a(this);
        }
    }

    /* renamed from: g */
    public View m45871g(int i) {
        return this.f13117c.findViewById(i);
    }

    /* renamed from: h */
    public Animation m45870h() {
        return AnimationUtils.loadAnimation(this.f13116b, PickerViewAnimateUtil.m12658a(this.f13131q, true));
    }

    /* renamed from: i */
    public Animation m45869i() {
        return AnimationUtils.loadAnimation(this.f13116b, PickerViewAnimateUtil.m12658a(this.f13131q, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public void m45868j() {
        this.f13129o = m45870h();
        this.f13128n = m45869i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public void m45867k() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: l */
    public void m45866l() {
        LayoutInflater from = LayoutInflater.from(this.f13116b);
        if (mo45865m()) {
            ViewGroup viewGroup = (ViewGroup) from.inflate(C3501R.C3505layout.layout_basepickerview, (ViewGroup) null, false);
            this.f13120f = viewGroup;
            viewGroup.setBackgroundColor(0);
            ViewGroup viewGroup2 = (ViewGroup) this.f13120f.findViewById(C3501R.C3504id.content_container);
            this.f13117c = viewGroup2;
            FrameLayout.LayoutParams layoutParams = this.f13115a;
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            viewGroup2.setLayoutParams(layoutParams);
            m45875c();
            this.f13120f.setOnClickListener(new View$OnClickListenerC3514a());
        } else {
            ViewGroup viewGroup3 = (ViewGroup) ((Activity) this.f13116b).getWindow().getDecorView().findViewById(16908290);
            this.f13118d = viewGroup3;
            ViewGroup viewGroup4 = (ViewGroup) from.inflate(C3501R.C3505layout.layout_basepickerview, viewGroup3, false);
            this.f13119e = viewGroup4;
            viewGroup4.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            ViewGroup viewGroup5 = (ViewGroup) this.f13119e.findViewById(C3501R.C3504id.content_container);
            this.f13117c = viewGroup5;
            viewGroup5.setLayoutParams(this.f13115a);
        }
        m45861q(true);
    }

    /* renamed from: m */
    public boolean mo45865m() {
        return false;
    }

    /* renamed from: n */
    public boolean m45864n() {
        if (mo45865m()) {
            return false;
        }
        return this.f13119e.getParent() != null || this.f13130p;
    }

    /* renamed from: p */
    public void m45862p(boolean z) {
        this.f13133s = z;
    }

    /* renamed from: q */
    public BasePickerView m45861q(boolean z) {
        ViewGroup viewGroup;
        if (mo45865m()) {
            viewGroup = this.f13120f;
        } else {
            viewGroup = this.f13119e;
        }
        viewGroup.setFocusable(z);
        viewGroup.setFocusableInTouchMode(z);
        if (z) {
            viewGroup.setOnKeyListener(this.f13135u);
        } else {
            viewGroup.setOnKeyListener(null);
        }
        return this;
    }

    /* renamed from: r */
    public BasePickerView m45860r(OnDismissListener onDismissListener) {
        this.f13126l = onDismissListener;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: s */
    public BasePickerView m45859s(boolean z) {
        ViewGroup viewGroup = this.f13119e;
        if (viewGroup != null) {
            View findViewById = viewGroup.findViewById(C3501R.C3504id.outmost_container);
            if (z) {
                findViewById.setOnTouchListener(this.f13136v);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    /* renamed from: t */
    public void m45858t() {
        if (mo45865m()) {
            m45856v();
        } else if (m45864n()) {
        } else {
            this.f13130p = true;
            m45863o(this.f13119e);
            this.f13119e.requestFocus();
        }
    }

    /* renamed from: u */
    public void m45857u(View view) {
        this.f13134t = view;
        m45858t();
    }

    /* renamed from: v */
    public void m45856v() {
        Dialog dialog = this.f13132r;
        if (dialog != null) {
            dialog.show();
        }
    }
}
