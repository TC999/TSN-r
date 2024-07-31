package com.bxkj.student.run.app.set;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RunFrequencySetActivity extends BaseActivity {

    /* renamed from: k */
    private RadioGroup f19392k;

    /* renamed from: l */
    private Button f19393l;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void m39769k0(RadioGroup radioGroup, int i) {
        LoginUser loginUser = LoginUser.getLoginUser();
        RadioGroup radioGroup2 = this.f19392k;
        loginUser.setFrequency(radioGroup2.indexOfChild(radioGroup2.findViewById(i)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0 */
    public /* synthetic */ void m39768l0(View view) {
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f19392k.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.bxkj.student.run.app.set.b
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i) {
                RunFrequencySetActivity.this.m39769k0(radioGroup, i);
            }
        });
        this.f19393l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunFrequencySetActivity.this.m39768l0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_set_frequency;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        ((RadioButton) this.f19392k.getChildAt(LoginUser.getLoginUser().getFrequency())).setChecked(true);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("播报频率设置");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f19392k = (RadioGroup) findViewById(2131232489);
        this.f19393l = (Button) findViewById(2131230989);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
