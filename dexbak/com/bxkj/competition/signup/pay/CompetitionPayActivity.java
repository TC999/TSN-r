package com.bxkj.competition.signup.pay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.pay.AliPay;
import cn.bluemobi.dylan.pay.PayListener;
import cn.bluemobi.dylan.pay.WeChatPay;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.C4017R;
import com.bxkj.competition.CompeApiService;
import com.bxkj.competition.signup.CompetitionDetailActivity;
import com.bxkj.competition.signup.CostProjectListActivity;
import com.github.mikephil.charting.utils.Utils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.text.DecimalFormat;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CompetitionPayActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f15683k;

    /* renamed from: l */
    private Button f15684l;

    /* renamed from: m */
    private LinearLayout f15685m;

    /* renamed from: n */
    private LinearLayout f15686n;

    /* renamed from: o */
    private CheckBox f15687o;

    /* renamed from: p */
    private CheckBox f15688p;

    /* renamed from: q */
    private String f15689q;

    /* renamed from: r */
    private String f15690r;

    /* renamed from: s */
    private double f15691s;

    /* renamed from: t */
    private double f15692t;

    /* renamed from: u */
    private double f15693u;

    /* renamed from: v */
    private double f15694v;

    /* renamed from: w */
    private PayListener f15695w = new C4129c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.pay.CompetitionPayActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4127a extends HttpCallBack {
        C4127a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionPayActivity.this.m43139m0(JsonParse.getString(data, "data"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.pay.CompetitionPayActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4128b extends HttpCallBack {
        C4128b() {
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
            new WeChatPay(((BaseActivity) CompetitionPayActivity.this).f1669h).setPayLisitener(CompetitionPayActivity.this.f15695w).pay(string, string2, string3, string5, string4, string6, string7, "App");
        }
    }

    /* renamed from: com.bxkj.competition.signup.pay.CompetitionPayActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4129c implements PayListener {
        C4129c() {
        }

        /* renamed from: a */
        public void m43136a() {
            CompetitionPayActivity.this.m57919h0("取消支付");
        }

        /* renamed from: b */
        public void m43135b() {
            CompetitionPayActivity.this.m57919h0("支付失败");
        }

        /* renamed from: c */
        public void m43134c() {
            CompetitionPayActivity.this.m57919h0("支付成功");
            CompetitionPayActivity.this.startActivity(new Intent(((BaseActivity) CompetitionPayActivity.this).f1669h, CompetePaySuccessActivity.class));
            try {
                AppManager.m57776n().getActivity(CompetitionDetailActivity.class).finish();
                AppManager.m57776n().getActivity(CostProjectListActivity.class).finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
            CompetitionPayActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public void m43139m0(String orderInfo) {
        new AliPay(this).pay(orderInfo).setPayLisitener(this.f15695w);
    }

    /* renamed from: n0 */
    private void m43138n0() {
        Http.with(this.f1669h).setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43438s(this.f15689q, LoginUser.getLoginUser().getUserId(), this.f15690r, this.f15692t, this.f15693u, this.f15694v, this.f15691s)).setDataListener(new C4127a());
    }

    /* renamed from: o0 */
    private void m43137o0() {
        Http.with(this.f1669h).setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43436u(this.f15689q, LoginUser.getLoginUser().getUserId(), this.f15690r, this.f15692t, this.f15693u, this.f15694v, this.f15691s)).setDataListener(new C4128b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15684l.setOnClickListener(this);
        this.f15685m.setOnClickListener(this);
        this.f15686n.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4017R.C4023layout.ac_competition_payment;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("competitionId")) {
            this.f15689q = getIntent().getStringExtra("competitionId");
        }
        if (getIntent().hasExtra("itemIds")) {
            this.f15690r = getIntent().getStringExtra("itemIds");
        }
        if (getIntent().hasExtra("insuranceFee")) {
            this.f15692t = getIntent().getDoubleExtra("insuranceFee", Utils.DOUBLE_EPSILON);
        }
        if (getIntent().hasExtra("competitionFee")) {
            this.f15693u = getIntent().getDoubleExtra("competitionFee", Utils.DOUBLE_EPSILON);
        }
        if (getIntent().hasExtra("totalPrice")) {
            this.f15694v = getIntent().getDoubleExtra("totalPrice", Utils.DOUBLE_EPSILON);
        }
        if (getIntent().hasExtra("payPrize")) {
            this.f15691s = getIntent().getDoubleExtra("payPrize", Utils.DOUBLE_EPSILON);
        }
        this.f15683k.setText(new DecimalFormat("￥0.00").format(this.f15691s));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("订单支付");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15684l = (Button) findViewById(C4017R.C4021id.bt_pay);
        this.f15683k = (TextView) findViewById(C4017R.C4021id.tv_money);
        this.f15685m = (LinearLayout) findViewById(C4017R.C4021id.rl_alipay);
        this.f15686n = (LinearLayout) findViewById(C4017R.C4021id.rl_wechatpay);
        this.f15687o = (CheckBox) findViewById(C4017R.C4021id.cb_alipay);
        this.f15688p = (CheckBox) findViewById(C4017R.C4021id.cb_wecahtpay);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int id = v.getId();
        if (id == C4017R.C4021id.rl_alipay) {
            this.f15688p.setChecked(false);
            this.f15687o.setChecked(true);
        } else if (id == C4017R.C4021id.rl_wechatpay) {
            this.f15687o.setChecked(false);
            this.f15688p.setChecked(true);
        } else if (id == C4017R.C4021id.bt_pay) {
            if (this.f15687o.isChecked()) {
                m43138n0();
            } else if (this.f15688p.isChecked()) {
                m43137o0();
            }
        }
    }
}
