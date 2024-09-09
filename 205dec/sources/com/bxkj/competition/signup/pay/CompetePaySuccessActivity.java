package com.bxkj.competition.signup.pay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.competition.R;
import com.bxkj.competition.signup.my.MyCompetitionListActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CompetePaySuccessActivity extends BaseActivity {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            CompetePaySuccessActivity.this.startActivity(new Intent(((BaseActivity) CompetePaySuccessActivity.this).f1656h, MyCompetitionListActivity.class));
            CompetePaySuccessActivity.this.finish();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_pay_success;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        Button button = (Button) findViewById(R.id.bt_order);
        button.setText("\u67e5\u770b\u62a5\u540d");
        button.setOnClickListener(new a());
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
