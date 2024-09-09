package com.bxkj.student.personal.password.forget;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.base.BaseActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class FindPasswordTypeActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private LinearLayout f22186k;

    /* renamed from: l  reason: collision with root package name */
    private LinearLayout f22187l;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(View view) {
        startActivity(new Intent(this.f1656h, InputNumberActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22187l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.password.forget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FindPasswordTypeActivity.this.j0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427402;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u9009\u62e9\u627e\u56de\u5bc6\u7801\u65b9\u5f0f");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22186k = (LinearLayout) findViewById(2131232171);
        this.f22187l = (LinearLayout) findViewById(2131232170);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
