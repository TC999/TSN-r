package com.bxkj.competition.signup.pay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.competition.C4017R;
import com.bxkj.competition.signup.p087my.MyCompetitionListActivity;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CompetePaySuccessActivity extends BaseActivity {

    /* renamed from: com.bxkj.competition.signup.pay.CompetePaySuccessActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class View$OnClickListenerC4126a implements View.OnClickListener {
        View$OnClickListenerC4126a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            CompetePaySuccessActivity.this.startActivity(new Intent(((BaseActivity) CompetePaySuccessActivity.this).f1669h, MyCompetitionListActivity.class));
            CompetePaySuccessActivity.this.finish();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4017R.C4023layout.ac_pay_success;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        Button button = (Button) findViewById(C4017R.C4021id.bt_order);
        button.setText("查看报名");
        button.setOnClickListener(new View$OnClickListenerC4126a());
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
