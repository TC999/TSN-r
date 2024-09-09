package com.bxkj.student.run.app.set;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.base.BaseActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RunSettingActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private LinearLayout f22631k;

    /* renamed from: l  reason: collision with root package name */
    private LinearLayout f22632l;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(View view) {
        startActivity(new Intent(this.f1656h, RunPermissionSetActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l0(View view) {
        startActivity(new Intent(this.f1656h, RunFrequencySetActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22631k.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunSettingActivity.this.k0(view);
            }
        });
        this.f22632l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunSettingActivity.this.l0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427478;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8dd1\u6b65\u8bbe\u7f6e");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22631k = (LinearLayout) findViewById(2131232209);
        this.f22632l = (LinearLayout) findViewById(2131232191);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
