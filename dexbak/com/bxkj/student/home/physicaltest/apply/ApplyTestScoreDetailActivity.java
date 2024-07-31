package com.bxkj.student.home.physicaltest.apply;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ApplyTestScoreDetailActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f16397k;

    /* renamed from: l */
    private TextView f16398l;

    /* renamed from: m */
    private TextView f16399m;

    /* renamed from: n */
    private TextView f16400n;

    /* renamed from: o */
    private TextView f16401o;

    /* renamed from: p */
    private TextView f16402p;

    /* renamed from: q */
    private TextView f16403q;

    /* renamed from: r */
    private MyGridView f16404r;

    /* renamed from: s */
    private TextView f16405s;

    /* renamed from: t */
    private TextView f16406t;

    /* renamed from: u */
    private TextView f16407u;

    /* renamed from: com.bxkj.student.home.physicaltest.apply.ApplyTestScoreDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4334a extends HttpCallBack {
        C4334a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyTestScoreDetailActivity.this.m57932R().setVisibility(0);
            TextView textView = ApplyTestScoreDetailActivity.this.f16397k;
            textView.setText("姓\u3000\u3000名：" + JsonParse.getString(data, "userName"));
            TextView textView2 = ApplyTestScoreDetailActivity.this.f16398l;
            textView2.setText("学\u3000\u3000号：" + JsonParse.getString(data, "userNum"));
            TextView textView3 = ApplyTestScoreDetailActivity.this.f16403q;
            textView3.setText("原\u3000\u3000因：" + JsonParse.getString(data, "applyReason"));
            TextView textView4 = ApplyTestScoreDetailActivity.this.f16406t;
            textView4.setText("状\u3000\u3000态：" + JsonParse.getString(data, "status"));
            TextView textView5 = ApplyTestScoreDetailActivity.this.f16407u;
            textView5.setText("时\u3000\u3000间：" + JsonParse.getString(data, "createTime"));
            TextView textView6 = ApplyTestScoreDetailActivity.this.f16399m;
            textView6.setText("学\u3000\u3000年：" + JsonParse.getString(data, "year"));
            TextView textView7 = ApplyTestScoreDetailActivity.this.f16400n;
            textView7.setText("项\u3000\u3000目：" + JsonParse.getString(data, "examName"));
            TextView textView8 = ApplyTestScoreDetailActivity.this.f16401o;
            textView8.setText("原始成绩：" + JsonParse.getString(data, "rawScores"));
            TextView textView9 = ApplyTestScoreDetailActivity.this.f16402p;
            textView9.setText("申诉成绩：" + JsonParse.getString(data, "complaintResults"));
            TextView textView10 = ApplyTestScoreDetailActivity.this.f16405s;
            textView10.setText("联系电话：" + JsonParse.getString(data, "userPhone"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_apply_test_score_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("id")) {
            Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m189A(getIntent().getStringExtra("id"))).setDataListener(new C4334a());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("体测成绩申诉详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16397k = (TextView) findViewById(2131233040);
        this.f16398l = (TextView) findViewById(2131233051);
        this.f16399m = (TextView) findViewById(C4215R.C4219id.tv_team);
        this.f16400n = (TextView) findViewById(2131233107);
        this.f16401o = (TextView) findViewById(2131233146);
        this.f16402p = (TextView) findViewById(C4215R.C4219id.tv_score_apply);
        this.f16403q = (TextView) findViewById(C4215R.C4219id.tv_reason);
        this.f16404r = (MyGridView) findViewById(C4215R.C4219id.gv_img);
        this.f16405s = (TextView) findViewById(2131233089);
        this.f16406t = (TextView) findViewById(2131233169);
        this.f16407u = (TextView) findViewById(2131233198);
        m57932R().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
