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
import cn.bluemobi.dylan.base.view.MyGridView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ApplyAvoidRunDetailActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f22296k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f22297l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f22298m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f22299n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f22300o;

    /* renamed from: p  reason: collision with root package name */
    private MyGridView f22301p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f22302q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f22303r;

    /* renamed from: s  reason: collision with root package name */
    private String f22304s;

    /* renamed from: t  reason: collision with root package name */
    private List<String> f22305t;

    /* renamed from: u  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> f22306u;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d */
        public void a(ViewHolder holder, String s3) {
            holder.s(2131231436, s3);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyAvoidRunDetailActivity.this.R().setVisibility(0);
            TextView textView = ApplyAvoidRunDetailActivity.this.f22296k;
            textView.setText("\u59d3\u540d\uff1a" + JsonParse.getString(data, "name"));
            TextView textView2 = ApplyAvoidRunDetailActivity.this.f22297l;
            textView2.setText("\u5b66\u53f7\uff1a" + JsonParse.getString(data, "userNum"));
            TextView textView3 = ApplyAvoidRunDetailActivity.this.f22298m;
            textView3.setText("\u5b66\u671f\uff1a" + JsonParse.getString(data, "sysTermName"));
            TextView textView4 = ApplyAvoidRunDetailActivity.this.f22300o;
            textView4.setText("\u539f\u56e0\uff1a" + JsonParse.getString(data, "applyReason"));
            TextView textView5 = ApplyAvoidRunDetailActivity.this.f22303r;
            textView5.setText("\u72b6\u6001\uff1a" + JsonParse.getString(data, "avoidRunningState"));
            TextView textView6 = ApplyAvoidRunDetailActivity.this.f22302q;
            textView6.setText("\u65f6\u95f4\uff1a" + JsonParse.getString(data, "applyTime"));
            ApplyAvoidRunDetailActivity.this.f22305t = JsonParse.getList(data, "imgs", String.class);
            ApplyAvoidRunDetailActivity.this.f22306u.c(ApplyAvoidRunDetailActivity.this.f22305t);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements AdapterView.OnItemClickListener {
        c() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ApplyAvoidRunDetailActivity applyAvoidRunDetailActivity = ApplyAvoidRunDetailActivity.this;
            applyAvoidRunDetailActivity.s0((String[]) applyAvoidRunDetailActivity.f22305t.toArray(new String[ApplyAvoidRunDetailActivity.this.f22305t.size()]), position);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(String[] arr, int position) {
        Intent intent = new Intent(this.f1656h, ImagePagerActivity.class);
        intent.putExtra("image_urls", arr);
        intent.putExtra("image_index", position);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22301p.setOnItemClickListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427365;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("id")) {
            this.f22304s = getIntent().getStringExtra("id");
        }
        a aVar = new a(this.f1656h, 2131427721, this.f22305t);
        this.f22306u = aVar;
        this.f22301p.setAdapter((ListAdapter) aVar);
        Http.with(this.f1656h).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).k(this.f22304s)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7533\u8bf7\u514d\u8dd1\u8be6\u60c5");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22296k = (TextView) findViewById(2131233040);
        this.f22297l = (TextView) findViewById(2131233051);
        this.f22298m = (TextView) findViewById(2131233194);
        this.f22299n = (TextView) findViewById(2131233211);
        this.f22300o = (TextView) findViewById(2131233119);
        this.f22301p = (MyGridView) findViewById(2131231336);
        this.f22302q = (TextView) findViewById(2131233198);
        this.f22303r = (TextView) findViewById(2131233169);
        this.f22299n.setVisibility(8);
        R().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
