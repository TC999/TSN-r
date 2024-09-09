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
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.z;
import com.bxkj.student.run.app.StartRunActivity;
import com.bxkj.student.run.app.set.brandset.HUAWEISetFragment;
import com.bxkj.student.run.app.set.brandset.MeizuFragment;
import com.bxkj.student.run.app.set.brandset.OPPOSetFragment;
import com.bxkj.student.run.app.set.brandset.OtherSetFramgment;
import com.bxkj.student.run.app.set.brandset.VivoSetFragment;
import com.bxkj.student.run.app.set.brandset.XiaomiSetFragment;
import com.bxkj.student.v2.common.utils.n;
import com.ss.android.download.api.constant.BaseConstants;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RunPermissionSetActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private Button f22625k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f22626l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f22627m;

    /* renamed from: n  reason: collision with root package name */
    private Button f22628n;

    /* renamed from: o  reason: collision with root package name */
    private CheckBox f22629o;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CountDownTimer {
        a(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            RunPermissionSetActivity.this.f22628n.setEnabled(true);
            RunPermissionSetActivity.this.f22628n.setText("\u5f00\u59cb\u8dd1\u6b65");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            Button button = RunPermissionSetActivity.this.f22628n;
            button.setText("\u5f00\u59cb\u8dd1\u6b65(" + (millisUntilFinished / 1000) + "\u79d2)");
        }
    }

    private void m0(Fragment fragment) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(2131231304, fragment);
        beginTransaction.commit();
    }

    private void n0() {
        Button button = this.f22625k;
        n.a aVar = n.f23377a;
        button.setEnabled(!aVar.b());
        this.f22625k.setText(aVar.b() ? "\u6743\u9650\u5df2\u5f00\u542f" : "\u4e00\u952e\u81ea\u52a8\u5f00\u542f");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(View view) {
        n.f23377a.e(this.f1657i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(View view) {
        LoginUser.getLoginUser().setCheckIgnoreRunSet(this.f22629o.isChecked());
        startActivity(new Intent(this.f1656h, StartRunActivity.class));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q0(View view) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", this.f1656h.getPackageName(), null));
    }

    private void r0() {
        new iOSOneButtonDialog(this.f1656h).setMessage(getString(2131821123)).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunPermissionSetActivity.this.q0(view);
            }
        }).show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22625k.setVisibility(com.bxkj.base.v2.data.a.b.a().B() == 1 ? 0 : 8);
        this.f22625k.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunPermissionSetActivity.this.o0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427475;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("isShowBottom") && getIntent().getBooleanExtra("isShowBottom", false)) {
            this.f22627m.setVisibility(0);
            new a(4000L, 1000L).start();
            this.f22628n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RunPermissionSetActivity.this.p0(view);
                }
            });
        }
        String d4 = z.d();
        TextView textView = this.f22626l;
        textView.setText("\u60a8\u7684\u624b\u673a\u54c1\u724c\uff1a" + d4);
        if (d4.equals("Xiaomi")) {
            m0(new XiaomiSetFragment());
        } else if (d4.equals("HUAWEI")) {
            m0(new HUAWEISetFragment());
        } else if (d4.equals(BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
            m0(new OPPOSetFragment());
        } else if (d4.equals("Vivo")) {
            m0(new VivoSetFragment());
        } else if (d4.equals("Meizu")) {
            m0(new MeizuFragment());
        } else {
            m0(new OtherSetFramgment());
        }
        n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8fd0\u52a8\u6743\u9650\u8bbe\u7f6e");
        f0(ContextCompat.getColor(this, 2131034196));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22625k = (Button) findViewById(2131230977);
        this.f22626l = (TextView) findViewById(2131232883);
        this.f22627m = (LinearLayout) findViewById(2131232167);
        this.f22628n = (Button) findViewById(2131231012);
        this.f22629o = (CheckBox) findViewById(2131231084);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        n0();
    }
}
