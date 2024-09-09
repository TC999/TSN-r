package com.bxkj.student.home.physicaltest.apply;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ApplyTestScoreDetailActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f19787k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f19788l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f19789m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f19790n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f19791o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f19792p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f19793q;

    /* renamed from: r  reason: collision with root package name */
    private MyGridView f19794r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f19795s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f19796t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f19797u;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyTestScoreDetailActivity.this.R().setVisibility(0);
            TextView textView = ApplyTestScoreDetailActivity.this.f19787k;
            textView.setText("\u59d3\u3000\u3000\u540d\uff1a" + JsonParse.getString(data, "userName"));
            TextView textView2 = ApplyTestScoreDetailActivity.this.f19788l;
            textView2.setText("\u5b66\u3000\u3000\u53f7\uff1a" + JsonParse.getString(data, "userNum"));
            TextView textView3 = ApplyTestScoreDetailActivity.this.f19793q;
            textView3.setText("\u539f\u3000\u3000\u56e0\uff1a" + JsonParse.getString(data, "applyReason"));
            TextView textView4 = ApplyTestScoreDetailActivity.this.f19796t;
            textView4.setText("\u72b6\u3000\u3000\u6001\uff1a" + JsonParse.getString(data, "status"));
            TextView textView5 = ApplyTestScoreDetailActivity.this.f19797u;
            textView5.setText("\u65f6\u3000\u3000\u95f4\uff1a" + JsonParse.getString(data, "createTime"));
            TextView textView6 = ApplyTestScoreDetailActivity.this.f19789m;
            textView6.setText("\u5b66\u3000\u3000\u5e74\uff1a" + JsonParse.getString(data, "year"));
            TextView textView7 = ApplyTestScoreDetailActivity.this.f19790n;
            textView7.setText("\u9879\u3000\u3000\u76ee\uff1a" + JsonParse.getString(data, "examName"));
            TextView textView8 = ApplyTestScoreDetailActivity.this.f19791o;
            textView8.setText("\u539f\u59cb\u6210\u7ee9\uff1a" + JsonParse.getString(data, "rawScores"));
            TextView textView9 = ApplyTestScoreDetailActivity.this.f19792p;
            textView9.setText("\u7533\u8bc9\u6210\u7ee9\uff1a" + JsonParse.getString(data, "complaintResults"));
            TextView textView10 = ApplyTestScoreDetailActivity.this.f19795s;
            textView10.setText("\u8054\u7cfb\u7535\u8bdd\uff1a" + JsonParse.getString(data, "userPhone"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427368;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("id")) {
            Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).A(getIntent().getStringExtra("id"))).setDataListener(new a());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4f53\u6d4b\u6210\u7ee9\u7533\u8bc9\u8be6\u60c5");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19787k = (TextView) findViewById(2131233040);
        this.f19788l = (TextView) findViewById(2131233051);
        this.f19789m = (TextView) findViewById(2131233194);
        this.f19790n = (TextView) findViewById(2131233107);
        this.f19791o = (TextView) findViewById(2131233146);
        this.f19792p = (TextView) findViewById(2131233147);
        this.f19793q = (TextView) findViewById(2131233119);
        this.f19794r = (MyGridView) findViewById(2131231336);
        this.f19795s = (TextView) findViewById(2131233089);
        this.f19796t = (TextView) findViewById(2131233169);
        this.f19797u = (TextView) findViewById(2131233198);
        R().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
