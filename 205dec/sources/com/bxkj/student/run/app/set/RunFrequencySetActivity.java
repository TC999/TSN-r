package com.bxkj.student.run.app.set;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.base.user.LoginUser;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RunFrequencySetActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private RadioGroup f22623k;

    /* renamed from: l  reason: collision with root package name */
    private Button f22624l;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(RadioGroup radioGroup, int i4) {
        LoginUser loginUser = LoginUser.getLoginUser();
        RadioGroup radioGroup2 = this.f22623k;
        loginUser.setFrequency(radioGroup2.indexOfChild(radioGroup2.findViewById(i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(View view) {
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22623k.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.bxkj.student.run.app.set.b
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i4) {
                RunFrequencySetActivity.this.k0(radioGroup, i4);
            }
        });
        this.f22624l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunFrequencySetActivity.this.l0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427491;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        ((RadioButton) this.f22623k.getChildAt(LoginUser.getLoginUser().getFrequency())).setChecked(true);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u64ad\u62a5\u9891\u7387\u8bbe\u7f6e");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22623k = (RadioGroup) findViewById(2131232489);
        this.f22624l = (Button) findViewById(2131230989);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
