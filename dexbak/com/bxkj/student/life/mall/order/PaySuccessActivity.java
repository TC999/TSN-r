package com.bxkj.student.life.mall.order;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class PaySuccessActivity extends BaseActivity {

    /* renamed from: com.bxkj.student.life.mall.order.PaySuccessActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class View$OnClickListenerC5030a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ String f18475a;

        View$OnClickListenerC5030a(final String val$orderId) {
            this.f18475a = val$orderId;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            PaySuccessActivity.this.startActivity(new Intent(((BaseActivity) PaySuccessActivity.this).f1669h, OrderDetailActivity.class).putExtra("orderId", this.f18475a));
            PaySuccessActivity.this.finish();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_runner_pay_success;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("orderId")) {
            ((Button) findViewById(2131230990)).setOnClickListener(new View$OnClickListenerC5030a(getIntent().getStringExtra("orderId")));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("支付结果");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
