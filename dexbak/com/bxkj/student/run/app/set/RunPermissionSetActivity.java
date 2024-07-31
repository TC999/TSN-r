package com.bxkj.student.run.app.set;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.SystemUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.common.utils.SQZSManager;
import com.bxkj.student.run.app.StartRunActivity;
import com.bxkj.student.run.app.set.brandset.HUAWEISetFragment;
import com.bxkj.student.run.app.set.brandset.MeizuFragment;
import com.bxkj.student.run.app.set.brandset.OPPOSetFragment;
import com.bxkj.student.run.app.set.brandset.OtherSetFramgment;
import com.bxkj.student.run.app.set.brandset.VivoSetFragment;
import com.bxkj.student.run.app.set.brandset.XiaomiSetFragment;
import master.flame.danmaku.danmaku.model.android.DanmakuFactory;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RunPermissionSetActivity extends BaseActivity {

    /* renamed from: k */
    private Button f19394k;

    /* renamed from: l */
    private TextView f19395l;

    /* renamed from: m */
    private LinearLayout f19396m;

    /* renamed from: n */
    private Button f19397n;

    /* renamed from: o */
    private CheckBox f19398o;

    /* renamed from: com.bxkj.student.run.app.set.RunPermissionSetActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class CountDownTimerC5352a extends CountDownTimer {
        CountDownTimerC5352a(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            RunPermissionSetActivity.this.f19397n.setEnabled(true);
            RunPermissionSetActivity.this.f19397n.setText("开始跑步");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            Button button = RunPermissionSetActivity.this.f19397n;
            button.setText("开始跑步(" + (millisUntilFinished / 1000) + "秒)");
        }
    }

    /* renamed from: m0 */
    private void m39763m0(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(C4215R.C4219id.fl_bottom, fragment);
        beginTransaction.commit();
    }

    /* renamed from: n0 */
    private void m39762n0() {
        Button button = this.f19394k;
        SQZSManager.C5547a c5547a = SQZSManager.f20133a;
        button.setEnabled(!c5547a.m39067b());
        this.f19394k.setText(c5547a.m39067b() ? "权限已开启" : "一键自动开启");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void m39761o0(View view) {
        SQZSManager.f20133a.m39064e(this.f1670i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ void m39760p0(View view) {
        LoginUser.getLoginUser().setCheckIgnoreRunSet(this.f19398o.isChecked());
        startActivity(new Intent(this.f1669h, StartRunActivity.class));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public /* synthetic */ void m39759q0(View view) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.f1669h.getPackageName(), null));
    }

    /* renamed from: r0 */
    private void m39758r0() {
        new iOSOneButtonDialog(this.f1669h).setMessage(getString(C4215R.C4224string.not_support_fast_set_please_self_set)).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunPermissionSetActivity.this.m39759q0(view);
            }
        }).show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f19394k.setVisibility(LoggedInUser.f15182b.m43634a().m43689B() == 1 ? 0 : 8);
        this.f19394k.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunPermissionSetActivity.this.m39761o0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_run_permission_set;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("isShowBottom") && getIntent().getBooleanExtra("isShowBottom", false)) {
            this.f19396m.setVisibility(0);
            new CountDownTimerC5352a(DanmakuFactory.f43786r, 1000L).start();
            this.f19397n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RunPermissionSetActivity.this.m39760p0(view);
                }
            });
        }
        String m44002d = SystemUtils.m44002d();
        TextView textView = this.f19395l;
        textView.setText("您的手机品牌：" + m44002d);
        if (m44002d.equals("Xiaomi")) {
            m39763m0(new XiaomiSetFragment());
        } else if (m44002d.equals("HUAWEI")) {
            m39763m0(new HUAWEISetFragment());
        } else if (m44002d.equals("OPPO")) {
            m39763m0(new OPPOSetFragment());
        } else if (m44002d.equals("Vivo")) {
            m39763m0(new VivoSetFragment());
        } else if (m44002d.equals("Meizu")) {
            m39763m0(new MeizuFragment());
        } else {
            m39763m0(new OtherSetFramgment());
        }
        m39762n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("运动权限设置");
        m57921f0(ContextCompat.getColor(this, 2131034196));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f19394k = (Button) findViewById(C4215R.C4219id.bt_fast_set);
        this.f19395l = (TextView) findViewById(C4215R.C4219id.tv_brand);
        this.f19396m = (LinearLayout) findViewById(2131232167);
        this.f19397n = (Button) findViewById(C4215R.C4219id.bt_start);
        this.f19398o = (CheckBox) findViewById(C4215R.C4219id.cb_ignore);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m39762n0();
    }
}
