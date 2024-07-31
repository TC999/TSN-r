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
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.set.RunPermissionSetActivity;
import com.orhanobut.logger.C11792j;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RunTypeDialog extends Dialog {

    /* renamed from: a */
    private Context f19264a;

    /* renamed from: b */
    private InterfaceC5309a f19265b;

    /* renamed from: c */
    private ImageView f19266c;

    /* renamed from: d */
    private ImageView f19267d;

    /* renamed from: e */
    private ImageView f19268e;

    /* renamed from: f */
    private ImageView f19269f;

    /* renamed from: g */
    private ImageView f19270g;

    /* renamed from: h */
    private ImageView f19271h;

    /* renamed from: i */
    private ImageView f19272i;

    /* renamed from: j */
    private ImageView f19273j;

    /* renamed from: k */
    private Button f19274k;

    /* renamed from: l */
    private View f19275l;

    /* renamed from: m */
    private View f19276m;

    /* renamed from: n */
    private View f19277n;

    /* renamed from: o */
    private View f19278o;

    /* renamed from: p */
    private TextView f19279p;

    /* renamed from: q */
    private ImageView f19280q;

    /* renamed from: r */
    private TextView f19281r;

    /* renamed from: s */
    private TextView f19282s;

    /* renamed from: t */
    private TextView f19283t;

    /* renamed from: com.bxkj.student.run.app.ready.RunTypeDialog$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public interface InterfaceC5309a {
        /* renamed from: a */
        void mo39891a();

        /* renamed from: b */
        void mo39890b();

        /* renamed from: c */
        void mo39889c();

        /* renamed from: d */
        void mo39888d();
    }

    public RunTypeDialog(Context context) {
        super(context, C4215R.C4225style.run_type_dialog);
        setContentView(C4215R.C4221layout.dialog_run_type);
        this.f19264a = context;
        m39906k();
        m39907j();
        if (context instanceof FragmentActivity) {
            ((FragmentActivity) context).getLifecycle().addObserver(new LifecycleObserver() { // from class: com.bxkj.student.run.app.ready.RunTypeDialog.1
                @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
                public void onResume() {
                    C11792j.m20470c("重新检查权限是否开启");
                    RunTypeDialog.this.m39907j();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m39907j() {
        this.f19280q.setVisibility(8);
        this.f19281r.setVisibility(8);
        this.f19282s.setVisibility(8);
        this.f19283t.setVisibility(8);
        this.f19279p.setVisibility(8);
    }

    /* renamed from: k */
    private void m39906k() {
        this.f19280q = (ImageView) findViewById(C4215R.C4219id.iv_permission);
        this.f19281r = (TextView) findViewById(C4215R.C4219id.tv_hint);
        this.f19282s = (TextView) findViewById(C4215R.C4219id.tv_choose_shoe_name);
        this.f19266c = (ImageView) findViewById(C4215R.C4219id.iv_in);
        this.f19268e = (ImageView) findViewById(C4215R.C4219id.iv_in_in);
        this.f19269f = (ImageView) findViewById(C4215R.C4219id.iv_out_out);
        this.f19267d = (ImageView) findViewById(C4215R.C4219id.iv_out);
        this.f19270g = (ImageView) findViewById(C4215R.C4219id.iv_free_in);
        this.f19271h = (ImageView) findViewById(C4215R.C4219id.iv_free_out);
        this.f19274k = (Button) findViewById(C4215R.C4219id.bt_health);
        this.f19275l = findViewById(C4215R.C4219id.rl_morning_exercise);
        this.f19276m = findViewById(C4215R.C4219id.rl_sunshine_running);
        this.f19277n = findViewById(C4215R.C4219id.rl_health_running);
        this.f19273j = (ImageView) findViewById(C4215R.C4219id.iv_health_circle_in);
        this.f19272i = (ImageView) findViewById(C4215R.C4219id.iv_health_circle_out);
        this.f19278o = findViewById(C4215R.C4219id.rl_free_run);
        this.f19279p = (TextView) findViewById(2131232939);
        TextView textView = (TextView) findViewById(C4215R.C4219id.bt_check);
        this.f19283t = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.m39905l(view);
            }
        });
        findViewById(C4215R.C4219id.iv_cancel).setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.m39904m(view);
            }
        });
        this.f19275l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.m39903n(view);
            }
        });
        this.f19276m.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.m39902o(view);
            }
        });
        this.f19277n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.m39901p(view);
            }
        });
        this.f19278o.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.ready.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunTypeDialog.this.m39900q(view);
            }
        });
        m39893x(this.f19266c);
        m39893x(this.f19267d);
        m39894w(this.f19269f);
        m39894w(this.f19268e);
        m39893x(this.f19270g);
        m39894w(this.f19271h);
        m39893x(this.f19273j);
        m39894w(this.f19272i);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        window.setWindowAnimations(C4215R.C4225style.ios_bottom_dialog_anim);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = m39908i((Activity) this.f19264a);
        attributes.height = m39909h((Activity) this.f19264a);
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public /* synthetic */ void m39905l(View view) {
        getContext().startActivity(new Intent(getContext(), RunPermissionSetActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public /* synthetic */ void m39904m(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public /* synthetic */ void m39903n(View view) {
        this.f19265b.mo39889c();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o */
    public /* synthetic */ void m39902o(View view) {
        this.f19265b.mo39888d();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void m39901p(View view) {
        this.f19265b.mo39891a();
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public /* synthetic */ void m39900q(View view) {
        this.f19265b.mo39890b();
        dismiss();
    }

    /* renamed from: w */
    private void m39894w(ImageView view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f19264a, C4215R.anim.img_animation_clockwise);
        loadAnimation.setInterpolator(new LinearInterpolator());
        view.startAnimation(loadAnimation);
    }

    /* renamed from: x */
    private void m39893x(ImageView view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f19264a, C4215R.anim.img_animation_counterclockwise);
        loadAnimation.setInterpolator(new LinearInterpolator());
        view.startAnimation(loadAnimation);
    }

    /* renamed from: y */
    private void m39892y(String healthRunName) {
        StringBuilder sb = new StringBuilder("如已设置运动权限,请直接点击下方");
        if (this.f19275l.getVisibility() == 0) {
            sb.append("【早操跑步】");
        }
        if (this.f19276m.getVisibility() == 0) {
            sb.append("【阳光跑步】");
        }
        if (this.f19278o.getVisibility() == 0) {
            sb.append("【自由跑步】");
        }
        if (this.f19277n.getVisibility() == 0) {
            this.f19274k.setText(healthRunName);
            sb.append("【" + healthRunName + "】");
        }
        sb.append("按钮开始跑步");
        this.f19279p.setText(sb);
    }

    /* renamed from: h */
    public int m39909h(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    /* renamed from: i */
    public int m39908i(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }

    /* renamed from: r */
    public RunTypeDialog m39899r(InterfaceC5309a clickListener) {
        this.f19265b = clickListener;
        return this;
    }

    /* renamed from: s */
    public RunTypeDialog m39898s(boolean isVisibalse) {
        if (isVisibalse) {
            this.f19278o.setVisibility(0);
        } else {
            this.f19278o.setVisibility(8);
        }
        return this;
    }

    /* renamed from: t */
    public RunTypeDialog m39897t(boolean isVisibalse, String healthRunName) {
        if (isVisibalse) {
            this.f19277n.setVisibility(0);
        } else {
            this.f19277n.setVisibility(8);
        }
        m39892y(healthRunName);
        return this;
    }

    /* renamed from: u */
    public RunTypeDialog m39896u(boolean isVisibalse) {
        if (isVisibalse) {
            this.f19275l.setVisibility(0);
        } else {
            this.f19275l.setVisibility(8);
        }
        return this;
    }

    /* renamed from: v */
    public RunTypeDialog m39895v(boolean isVisibalse) {
        if (isVisibalse) {
            this.f19276m.setVisibility(0);
        } else {
            this.f19276m.setVisibility(8);
        }
        return this;
    }
}
