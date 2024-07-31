package com.bxkj.student.home.teaching.healthstatus;

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
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ApplyHealthStatusDetailActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f16929k;

    /* renamed from: l */
    private TextView f16930l;

    /* renamed from: m */
    private TextView f16931m;

    /* renamed from: n */
    private TextView f16932n;

    /* renamed from: o */
    private TextView f16933o;

    /* renamed from: p */
    private MyGridView f16934p;

    /* renamed from: q */
    private TextView f16935q;

    /* renamed from: r */
    private TextView f16936r;

    /* renamed from: s */
    private String f16937s;

    /* renamed from: t */
    private List<String> f16938t;

    /* renamed from: u */
    private CommonAdapter<String> f16939u;

    /* renamed from: com.bxkj.student.home.teaching.healthstatus.ApplyHealthStatusDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4506a extends CommonAdapter<String> {
        C4506a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, String s) {
            holder.m57851s(C4215R.C4219id.iv_img, s);
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.healthstatus.ApplyHealthStatusDetailActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4507b extends HttpCallBack {
        C4507b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyHealthStatusDetailActivity.this.m57932R().setVisibility(0);
            TextView textView = ApplyHealthStatusDetailActivity.this.f16929k;
            textView.setText("姓名：" + JsonParse.getString(data, "applyerName"));
            TextView textView2 = ApplyHealthStatusDetailActivity.this.f16930l;
            textView2.setText("学号：" + JsonParse.getString(data, "userNum"));
            TextView textView3 = ApplyHealthStatusDetailActivity.this.f16932n;
            textView3.setText("类型：" + JsonParse.getString(data, "type"));
            TextView textView4 = ApplyHealthStatusDetailActivity.this.f16933o;
            textView4.setText("原因：" + JsonParse.getString(data, "applyMemo"));
            TextView textView5 = ApplyHealthStatusDetailActivity.this.f16936r;
            textView5.setText("状态：" + JsonParse.getString(data, "status"));
            TextView textView6 = ApplyHealthStatusDetailActivity.this.f16935q;
            textView6.setText("时间：" + JsonParse.getString(data, "applyDate"));
            ApplyHealthStatusDetailActivity.this.f16938t = JsonParse.getList(data, "imgs", String.class);
            ApplyHealthStatusDetailActivity.this.f16939u.m57842c(ApplyHealthStatusDetailActivity.this.f16938t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public /* synthetic */ void m42154s0(AdapterView adapterView, View view, int i, long j) {
        m42153t0((String[]) this.f16938t.toArray(new String[this.f16938t.size()]), i);
    }

    /* renamed from: t0 */
    private void m42153t0(String[] arr, int position) {
        Intent intent = new Intent(this.f1669h, ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.f1869h, arr);
        intent.putExtra(ImagePagerActivity.f1868g, position);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16934p.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.healthstatus.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                ApplyHealthStatusDetailActivity.this.m42154s0(adapterView, view, i, j);
            }
        });
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
            this.f16937s = getIntent().getStringExtra("id");
        }
        C4506a c4506a = new C4506a(this.f1669h, C4215R.C4221layout.item_for_lost_img, this.f16938t);
        this.f16939u = c4506a;
        this.f16934p.setAdapter((ListAdapter) c4506a);
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m155N(this.f16937s)).setDataListener(new C4507b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("申请状态详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16929k = (TextView) findViewById(2131233040);
        this.f16930l = (TextView) findViewById(2131233051);
        this.f16931m = (TextView) findViewById(C4215R.C4219id.tv_team);
        this.f16932n = (TextView) findViewById(2131233211);
        this.f16933o = (TextView) findViewById(C4215R.C4219id.tv_reason);
        this.f16934p = (MyGridView) findViewById(C4215R.C4219id.gv_img);
        this.f16935q = (TextView) findViewById(2131233198);
        this.f16936r = (TextView) findViewById(2131233169);
        this.f16931m.setVisibility(8);
        m57932R().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
