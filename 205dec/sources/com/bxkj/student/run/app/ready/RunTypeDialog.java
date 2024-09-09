package com.bxkj.student.run.app.ready;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bxkj.student.run.app.set.RunPermissionSetActivity;
import com.orhanobut.logger.j;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RunTypeDialog extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private Context f22500a;

    /* renamed from: b  reason: collision with root package name */
    private a f22501b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f22502c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f22503d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f22504e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f22505f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f22506g;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f22507h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f22508i;

    /* renamed from: j  reason: collision with root package name */
    private ImageView f22509j;

    /* renamed from: k  reason: collision with root package name */
    private Button f22510k;

    /* renamed from: l  reason: collision with root package name */
    private View f22511l;

    /* renamed from: m  reason: collision with root package name */
    private View f22512m;

    /* renamed from: n  reason: collision with root package name */
    private View f22513n;

    /* renamed from: o  reason: collision with root package name */
    private View f22514o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f22515p;

    /* renamed from: q  reason: collision with root package name */
    private ImageView f22516q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f22517r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f22518s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f22519t;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    public RunTypeDialog(Context context) {
        super(context, 2131886909);
        setContentView(2131427602);
        this.f22500a = context;
        k();
        j();
        if (context instanceof FragmentActivity) {
            ((FragmentActivity) context).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.student.run.app.ready.RunTypeDialog.1
                @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
                public void onResume() {
                    j.c("\u91cd\u65b0\u68c0\u67e5\u6743\u9650\u662f\u5426\u5f00\u542f");
                    RunTypeDialog.this.j();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.f22516q.setVisibility(8);
        this.f22517r.setVisibility(8);
        this.f22518s.setVisibility(8);
        this.f22519t.setVisibility(8);
        this.f22515p.setVisibility(8);
    }

    private void k() {
        this.f22516q = (ImageView) findViewById(2131231465);
        this.f22517r = (TextView) findViewById(2131232991);
        this.f22518s = (TextView) findViewById(2131232899);
        this.f22502c = (ImageView) findViewById(2131231437);
        this.f22504e = (ImageView) findViewById(2131231438);
        this.f22505f = (ImageView) findViewById(2131231463);
        this.f22503d = (ImageView) findViewById(2131231462);
        this.f22506g = (ImageView) findViewById(2131231420);
        this.f22507h = (ImageView) findViewById(2131231421);
        this.f22510k = (Button) findViewById(2131230979);
        this.f22511l = findViewById(2131232523);
        this.f22512m = findViewById(2131232530);
        this.f22513n = findViewById(2131232519);
        this.f22509j = (ImageView) findViewById(2131231427);
        this.f22508i = (ImageView) findViewById(2131231428);
        this.f22514o = findViewById(2131232518);
        this.f22515p = (TextView) findViewById(2131232939);
        TextView textView = (TextView) findViewById(2131230963);
        this.f22519t = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.l(view);
            }
        });
        findViewById(2131231397).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.m(view);
            }
        });
        this.f22511l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.n(view);
            }
        });
        this.f22512m.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.o(view);
            }
        });
        this.f22513n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.p(view);
            }
        });
        this.f22514o.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.q(view);
            }
        });
        x(this.f22502c);
        x(this.f22503d);
        w(this.f22505f);
        w(this.f22504e);
        x(this.f22506g);
        w(this.f22507h);
        x(this.f22509j);
        w(this.f22508i);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        window.setWindowAnimations(2131886892);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = i((Activity) this.f22500a);
        attributes.height = h((Activity) this.f22500a);
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        getContext().startActivity(new Intent(getContext(), RunPermissionSetActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(View view) {
        this.f22501b.c();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(View view) {
        this.f22501b.d();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(View view) {
        this.f22501b.a();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(View view) {
        this.f22501b.b();
        dismiss();
    }

    private void w(ImageView view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f22500a, 2130772054);
        loadAnimation.setInterpolator(new LinearInterpolator());
        view.startAnimation(loadAnimation);
    }

    private void x(ImageView view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f22500a, 2130772055);
        loadAnimation.setInterpolator(new LinearInterpolator());
        view.startAnimation(loadAnimation);
    }

    private void y(String healthRunName) {
        StringBuilder sb = new StringBuilder("\u5982\u5df2\u8bbe\u7f6e\u8fd0\u52a8\u6743\u9650,\u8bf7\u76f4\u63a5\u70b9\u51fb\u4e0b\u65b9");
        if (this.f22511l.getVisibility() == 0) {
            sb.append("\u3010\u65e9\u64cd\u8dd1\u6b65\u3011");
        }
        if (this.f22512m.getVisibility() == 0) {
            sb.append("\u3010\u9633\u5149\u8dd1\u6b65\u3011");
        }
        if (this.f22514o.getVisibility() == 0) {
            sb.append("\u3010\u81ea\u7531\u8dd1\u6b65\u3011");
        }
        if (this.f22513n.getVisibility() == 0) {
            this.f22510k.setText(healthRunName);
            sb.append("\u3010" + healthRunName + "\u3011");
        }
        sb.append("\u6309\u94ae\u5f00\u59cb\u8dd1\u6b65");
        this.f22515p.setText(sb);
    }

    public int h(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    public int i(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }

    public RunTypeDialog r(a clickListener) {
        this.f22501b = clickListener;
        return this;
    }

    public RunTypeDialog s(boolean isVisibalse) {
        if (isVisibalse) {
            this.f22514o.setVisibility(0);
        } else {
            this.f22514o.setVisibility(8);
        }
        return this;
    }

    public RunTypeDialog t(boolean isVisibalse, String healthRunName) {
        if (isVisibalse) {
            this.f22513n.setVisibility(0);
        } else {
            this.f22513n.setVisibility(8);
        }
        y(healthRunName);
        return this;
    }

    public RunTypeDialog u(boolean isVisibalse) {
        if (isVisibalse) {
            this.f22511l.setVisibility(0);
        } else {
            this.f22511l.setVisibility(8);
        }
        return this;
    }

    public RunTypeDialog v(boolean isVisibalse) {
        if (isVisibalse) {
            this.f22512m.setVisibility(0);
        } else {
            this.f22512m.setVisibility(8);
        }
        return this;
    }
}
