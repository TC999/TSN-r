package com.bxkj.student.run.app.my;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.run.app.record.RunRecorderListActivity;
import com.bxkj.student.run.app.set.RunSettingActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MyRunActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private LinearLayout f22458k;

    /* renamed from: l  reason: collision with root package name */
    private LinearLayout f22459l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f22460m;

    /* renamed from: n  reason: collision with root package name */
    private LinearLayout f22461n;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(View view) {
        startActivity(new Intent(this.f1656h, RunRecorderListActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(View view) {
        startActivity(new Intent(this.f1656h, RunSettingActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(View view) {
        startActivity(new Intent(this.f1656h, RunRankActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0(View view) {
        startActivity(new Intent(this.f1656h, RunStatisticsActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22458k.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.my.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRunActivity.this.m0(view);
            }
        });
        this.f22461n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.my.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRunActivity.this.n0(view);
            }
        });
        this.f22460m.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.my.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRunActivity.this.o0(view);
            }
        });
        this.f22459l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.my.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyRunActivity.this.p0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427442;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u7684\u8dd1\u6b65");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22458k = (LinearLayout) findViewById(2131232219);
        this.f22459l = (LinearLayout) findViewById(2131232221);
        this.f22460m = (LinearLayout) findViewById(2131232218);
        this.f22461n = (LinearLayout) findViewById(2131232220);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
