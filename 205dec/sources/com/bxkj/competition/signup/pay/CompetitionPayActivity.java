package com.bxkj.competition.signup.pay;

import android.content.Intent;
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
import cn.bluemobi.dylan.pay.AliPay;
import cn.bluemobi.dylan.pay.PayListener;
import cn.bluemobi.dylan.pay.WeChatPay;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.R;
import com.bxkj.competition.signup.CompetitionDetailActivity;
import com.bxkj.competition.signup.CostProjectListActivity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.text.DecimalFormat;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CompetitionPayActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f19213k;

    /* renamed from: l  reason: collision with root package name */
    private Button f19214l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f19215m;

    /* renamed from: n  reason: collision with root package name */
    private LinearLayout f19216n;

    /* renamed from: o  reason: collision with root package name */
    private CheckBox f19217o;

    /* renamed from: p  reason: collision with root package name */
    private CheckBox f19218p;

    /* renamed from: q  reason: collision with root package name */
    private String f19219q;

    /* renamed from: r  reason: collision with root package name */
    private String f19220r;

    /* renamed from: s  reason: collision with root package name */
    private double f19221s;

    /* renamed from: t  reason: collision with root package name */
    private double f19222t;

    /* renamed from: u  reason: collision with root package name */
    private double f19223u;

    /* renamed from: v  reason: collision with root package name */
    private double f19224v;

    /* renamed from: w  reason: collision with root package name */
    private PayListener f19225w = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionPayActivity.this.m0(JsonParse.getString(data, "data"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            String string = JsonParse.getString(data, "appid");
            String string2 = JsonParse.getString(data, "partnerid");
            String string3 = JsonParse.getString(data, "prepayid");
            String string4 = JsonParse.getString(data, "noncestr");
            String string5 = JsonParse.getString(data, "package");
            String string6 = JsonParse.getString(data, CampaignEx.JSON_KEY_TIMESTAMP);
            String string7 = JsonParse.getString(data, "sign");
            JsonParse.getString(data, "attach");
            new WeChatPay(((BaseActivity) CompetitionPayActivity.this).f1656h).setPayLisitener(CompetitionPayActivity.this.f19225w).pay(string, string2, string3, string5, string4, string6, string7, "App");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements PayListener {
        c() {
        }

        public void a() {
            CompetitionPayActivity.this.h0("\u53d6\u6d88\u652f\u4ed8");
        }

        public void b() {
            CompetitionPayActivity.this.h0("\u652f\u4ed8\u5931\u8d25");
        }

        public void c() {
            CompetitionPayActivity.this.h0("\u652f\u4ed8\u6210\u529f");
            CompetitionPayActivity.this.startActivity(new Intent(((BaseActivity) CompetitionPayActivity.this).f1656h, CompetePaySuccessActivity.class));
            try {
                cn.bluemobi.dylan.base.utils.a.n().getActivity(CompetitionDetailActivity.class).finish();
                cn.bluemobi.dylan.base.utils.a.n().getActivity(CostProjectListActivity.class).finish();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            CompetitionPayActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(String orderInfo) {
        new AliPay(this).pay(orderInfo).setPayLisitener(this.f19225w);
    }

    private void n0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).s(this.f19219q, LoginUser.getLoginUser().getUserId(), this.f19220r, this.f19222t, this.f19223u, this.f19224v, this.f19221s)).setDataListener(new a());
    }

    private void o0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).u(this.f19219q, LoginUser.getLoginUser().getUserId(), this.f19220r, this.f19222t, this.f19223u, this.f19224v, this.f19221s)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19214l.setOnClickListener(this);
        this.f19215m.setOnClickListener(this);
        this.f19216n.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_competition_payment;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("competitionId")) {
            this.f19219q = getIntent().getStringExtra("competitionId");
        }
        if (getIntent().hasExtra("itemIds")) {
            this.f19220r = getIntent().getStringExtra("itemIds");
        }
        if (getIntent().hasExtra("insuranceFee")) {
            this.f19222t = getIntent().getDoubleExtra("insuranceFee", 0.0d);
        }
        if (getIntent().hasExtra("competitionFee")) {
            this.f19223u = getIntent().getDoubleExtra("competitionFee", 0.0d);
        }
        if (getIntent().hasExtra("totalPrice")) {
            this.f19224v = getIntent().getDoubleExtra("totalPrice", 0.0d);
        }
        if (getIntent().hasExtra("payPrize")) {
            this.f19221s = getIntent().getDoubleExtra("payPrize", 0.0d);
        }
        this.f19213k.setText(new DecimalFormat("\uffe50.00").format(this.f19221s));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8ba2\u5355\u652f\u4ed8");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19214l = (Button) findViewById(R.id.bt_pay);
        this.f19213k = (TextView) findViewById(R.id.tv_money);
        this.f19215m = (LinearLayout) findViewById(R.id.rl_alipay);
        this.f19216n = (LinearLayout) findViewById(R.id.rl_wechatpay);
        this.f19217o = (CheckBox) findViewById(R.id.cb_alipay);
        this.f19218p = (CheckBox) findViewById(R.id.cb_wecahtpay);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        int id = v3.getId();
        if (id == R.id.rl_alipay) {
            this.f19218p.setChecked(false);
            this.f19217o.setChecked(true);
        } else if (id == R.id.rl_wechatpay) {
            this.f19217o.setChecked(false);
            this.f19218p.setChecked(true);
        } else if (id == R.id.bt_pay) {
            if (this.f19217o.isChecked()) {
                n0();
            } else if (this.f19218p.isChecked()) {
                o0();
            }
        }
    }
}
