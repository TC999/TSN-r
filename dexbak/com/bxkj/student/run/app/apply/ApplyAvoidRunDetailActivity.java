package com.bxkj.student.run.app.apply;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.RunApiService;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ApplyAvoidRunDetailActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f19050k;

    /* renamed from: l */
    private TextView f19051l;

    /* renamed from: m */
    private TextView f19052m;

    /* renamed from: n */
    private TextView f19053n;

    /* renamed from: o */
    private TextView f19054o;

    /* renamed from: p */
    private MyGridView f19055p;

    /* renamed from: q */
    private TextView f19056q;

    /* renamed from: r */
    private TextView f19057r;

    /* renamed from: s */
    private String f19058s;

    /* renamed from: t */
    private List<String> f19059t;

    /* renamed from: u */
    private CommonAdapter<String> f19060u;

    /* renamed from: com.bxkj.student.run.app.apply.ApplyAvoidRunDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5206a extends CommonAdapter<String> {
        C5206a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, String s) {
            holder.m57851s(C4215R.C4219id.iv_img, s);
        }
    }

    /* renamed from: com.bxkj.student.run.app.apply.ApplyAvoidRunDetailActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5207b extends HttpCallBack {
        C5207b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyAvoidRunDetailActivity.this.m57932R().setVisibility(0);
            TextView textView = ApplyAvoidRunDetailActivity.this.f19050k;
            textView.setText("姓名：" + JsonParse.getString(data, "name"));
            TextView textView2 = ApplyAvoidRunDetailActivity.this.f19051l;
            textView2.setText("学号：" + JsonParse.getString(data, "userNum"));
            TextView textView3 = ApplyAvoidRunDetailActivity.this.f19052m;
            textView3.setText("学期：" + JsonParse.getString(data, "sysTermName"));
            TextView textView4 = ApplyAvoidRunDetailActivity.this.f19054o;
            textView4.setText("原因：" + JsonParse.getString(data, "applyReason"));
            TextView textView5 = ApplyAvoidRunDetailActivity.this.f19057r;
            textView5.setText("状态：" + JsonParse.getString(data, "avoidRunningState"));
            TextView textView6 = ApplyAvoidRunDetailActivity.this.f19056q;
            textView6.setText("时间：" + JsonParse.getString(data, "applyTime"));
            ApplyAvoidRunDetailActivity.this.f19059t = JsonParse.getList(data, "imgs", String.class);
            ApplyAvoidRunDetailActivity.this.f19060u.m57842c(ApplyAvoidRunDetailActivity.this.f19059t);
        }
    }

    /* renamed from: com.bxkj.student.run.app.apply.ApplyAvoidRunDetailActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5208c implements AdapterView.OnItemClickListener {
        C5208c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ApplyAvoidRunDetailActivity applyAvoidRunDetailActivity = ApplyAvoidRunDetailActivity.this;
            applyAvoidRunDetailActivity.m40087s0((String[]) applyAvoidRunDetailActivity.f19059t.toArray(new String[ApplyAvoidRunDetailActivity.this.f19059t.size()]), position);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public void m40087s0(String[] arr, int position) {
        Intent intent = new Intent(this.f1669h, ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.f1869h, arr);
        intent.putExtra(ImagePagerActivity.f1868g, position);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f19055p.setOnItemClickListener(new C5208c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_apply_mc_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("id")) {
            this.f19058s = getIntent().getStringExtra("id");
        }
        C5206a c5206a = new C5206a(this.f1669h, C4215R.C4221layout.item_for_lost_img, this.f19059t);
        this.f19060u = c5206a;
        this.f19055p.setAdapter((ListAdapter) c5206a);
        Http.with(this.f1669h).setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40110k(this.f19058s)).setDataListener(new C5207b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("申请免跑详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f19050k = (TextView) findViewById(2131233040);
        this.f19051l = (TextView) findViewById(2131233051);
        this.f19052m = (TextView) findViewById(C4215R.C4219id.tv_team);
        this.f19053n = (TextView) findViewById(2131233211);
        this.f19054o = (TextView) findViewById(C4215R.C4219id.tv_reason);
        this.f19055p = (MyGridView) findViewById(C4215R.C4219id.gv_img);
        this.f19056q = (TextView) findViewById(2131233198);
        this.f19057r = (TextView) findViewById(2131233169);
        this.f19053n.setVisibility(8);
        m57932R().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
