package com.bxkj.student.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.personal.password.UpdatePasswordActivity;
import com.bxkj.student.personal.password.forget.FindPasswordTypeActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SafeSetActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f22021k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f22022l;

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22021k.setOnClickListener(this);
        this.f22022l.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427482;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5b89\u5168\u8bbe\u7f6e");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22021k = (TextView) findViewById(2131233214);
        this.f22022l = (TextView) findViewById(2131232974);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        int id = v3.getId();
        if (id == 2131232974) {
            startActivity(new Intent(this.f1656h, FindPasswordTypeActivity.class));
        } else if (id != 2131233214) {
        } else {
            startActivity(new Intent(this.f1656h, UpdatePasswordActivity.class));
        }
    }
}
