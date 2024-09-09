package com.bxkj.student.life.mall.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import cn.bluemobi.dylan.base.BaseActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class PaySuccessActivity extends BaseActivity {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f21784a;

        a(final String val$orderId) {
            this.f21784a = val$orderId;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            PaySuccessActivity.this.startActivity(new Intent(((BaseActivity) PaySuccessActivity.this).f1656h, OrderDetailActivity.class).putExtra("orderId", this.f21784a));
            PaySuccessActivity.this.finish();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427481;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("orderId")) {
            ((Button) findViewById(2131230990)).setOnClickListener(new a(getIntent().getStringExtra("orderId")));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u652f\u4ed8\u7ed3\u679c");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
