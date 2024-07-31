package com.bxkj.student.life.mall.order;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.text.DecimalFormat;
import java.util.Map;
import p635q.MallApiService;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class OrderPayActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f18464k;

    /* renamed from: l */
    private Button f18465l;

    /* renamed from: m */
    private LinearLayout f18466m;

    /* renamed from: n */
    private LinearLayout f18467n;

    /* renamed from: o */
    private CheckBox f18468o;

    /* renamed from: p */
    private CheckBox f18469p;

    /* renamed from: q */
    private String f18470q;

    /* renamed from: r */
    private String f18471r;

    /* renamed from: s */
    private double f18472s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.order.OrderPayActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5028a extends HttpCallBack {
        C5028a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.order.OrderPayActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5029b extends HttpCallBack {
        C5029b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            JsonParse.getString(data, "appid");
            JsonParse.getString(data, "partnerid");
            JsonParse.getString(data, "prepayid");
            JsonParse.getString(data, "noncestr");
            JsonParse.getString(data, "package");
            JsonParse.getString(data, CampaignEx.JSON_KEY_TIMESTAMP);
            JsonParse.getString(data, "sign");
        }
    }

    /* renamed from: i0 */
    private void m40794i0() {
        Http.with(this.f1669h).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2240h(this.f18470q)).setDataListener(new C5028a());
    }

    /* renamed from: j0 */
    private void m40793j0() {
        Http.with(this.f1669h).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2252A(this.f18470q)).setDataListener(new C5029b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18465l.setOnClickListener(this);
        this.f18466m.setOnClickListener(this);
        this.f18467n.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_payment;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("orderId")) {
            this.f18470q = getIntent().getStringExtra("orderId");
        }
        if (getIntent().hasExtra("orderNo")) {
            this.f18471r = getIntent().getStringExtra("orderNo");
        }
        if (getIntent().hasExtra("payPrice")) {
            this.f18472s = getIntent().getDoubleExtra("payPrice", 100.0d);
        }
        this.f18464k.setText(new DecimalFormat("￥0.00").format(this.f18472s));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("订单支付");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18465l = (Button) findViewById(2131230992);
        this.f18464k = (TextView) findViewById(2131233035);
        this.f18466m = (LinearLayout) findViewById(2131232507);
        this.f18467n = (LinearLayout) findViewById(2131232533);
        this.f18468o = (CheckBox) findViewById(2131231081);
        this.f18469p = (CheckBox) findViewById(2131231088);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == 2131230992) {
            if (this.f18468o.isChecked()) {
                m40794i0();
            } else if (this.f18469p.isChecked()) {
                m40793j0();
            }
        } else if (id == 2131232507) {
            this.f18469p.setChecked(false);
            this.f18468o.setChecked(true);
        } else if (id != 2131232533) {
        } else {
            this.f18468o.setChecked(false);
            this.f18469p.setChecked(true);
        }
    }
}
