package com.bxkj.student.run.app.p092my;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.record.RunRecorderListActivity;
import com.bxkj.student.run.app.set.RunSettingActivity;

/* renamed from: com.bxkj.student.run.app.my.MyRunActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MyRunActivity extends BaseActivity {

    /* renamed from: k */
    private LinearLayout f19221k;

    /* renamed from: l */
    private LinearLayout f19222l;

    /* renamed from: m */
    private LinearLayout f19223m;

    /* renamed from: n */
    private LinearLayout f19224n;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void m39943m0(View view) {
        startActivity(new Intent(this.f1669h, RunRecorderListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public /* synthetic */ void m39942n0(View view) {
        startActivity(new Intent(this.f1669h, RunSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void m39941o0(View view) {
        startActivity(new Intent(this.f1669h, RunRankActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ void m39940p0(View view) {
        startActivity(new Intent(this.f1669h, RunStatisticsActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f19221k.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.my.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRunActivity.this.m39943m0(view);
            }
        });
        this.f19224n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.my.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRunActivity.this.m39942n0(view);
            }
        });
        this.f19223m.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.my.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRunActivity.this.m39941o0(view);
            }
        });
        this.f19222l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.my.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRunActivity.this.m39940p0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_my_run;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我的跑步");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f19221k = (LinearLayout) findViewById(C4215R.C4219id.ll_run_record);
        this.f19222l = (LinearLayout) findViewById(C4215R.C4219id.ll_run_statistics);
        this.f19223m = (LinearLayout) findViewById(C4215R.C4219id.ll_run_rank);
        this.f19224n = (LinearLayout) findViewById(C4215R.C4219id.ll_run_set);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
