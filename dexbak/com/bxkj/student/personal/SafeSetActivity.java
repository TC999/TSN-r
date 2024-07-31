package com.bxkj.student.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.C4215R;
import com.bxkj.student.personal.password.UpdatePasswordActivity;
import com.bxkj.student.personal.password.forget.FindPasswordTypeActivity;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SafeSetActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f18721k;

    /* renamed from: l */
    private TextView f18722l;

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18721k.setOnClickListener(this);
        this.f18722l.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_safe_set;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("安全设置");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18721k = (TextView) findViewById(C4215R.C4219id.tv_update_password);
        this.f18722l = (TextView) findViewById(C4215R.C4219id.tv_forget_password);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == 2131232974) {
            startActivity(new Intent(this.f1669h, FindPasswordTypeActivity.class));
        } else if (id != 2131233214) {
        } else {
            startActivity(new Intent(this.f1669h, UpdatePasswordActivity.class));
        }
    }
}
