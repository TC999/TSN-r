package com.bxkj.student.run.app.set;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RunSettingActivity extends BaseActivity {

    /* renamed from: k */
    private LinearLayout f19400k;

    /* renamed from: l */
    private LinearLayout f19401l;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k0 */
    public /* synthetic */ void m39755k0(View view) {
        startActivity(new Intent(this.f1669h, RunPermissionSetActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l0 */
    public /* synthetic */ void m39754l0(View view) {
        startActivity(new Intent(this.f1669h, RunFrequencySetActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f19400k.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunSettingActivity.this.m39755k0(view);
            }
        });
        this.f19401l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunSettingActivity.this.m39754l0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_run_setting;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("跑步设置");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f19400k = (LinearLayout) findViewById(C4215R.C4219id.ll_permission_set);
        this.f19401l = (LinearLayout) findViewById(C4215R.C4219id.ll_frequency_set);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
