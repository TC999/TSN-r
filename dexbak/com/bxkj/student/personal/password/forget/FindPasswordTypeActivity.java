package com.bxkj.student.personal.password.forget;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class FindPasswordTypeActivity extends BaseActivity {

    /* renamed from: k */
    private LinearLayout f18902k;

    /* renamed from: l */
    private LinearLayout f18903l;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j0 */
    public /* synthetic */ void m40411j0(View view) {
        startActivity(new Intent(this.f1669h, InputNumberActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18903l.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.personal.password.forget.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FindPasswordTypeActivity.this.m40411j0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_find_password_type;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("选择找回密码方式");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18902k = (LinearLayout) findViewById(C4215R.C4219id.ll_by_phone);
        this.f18903l = (LinearLayout) findViewById(C4215R.C4219id.ll_by_id_and_classmate);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
