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
public class ApplyHealthStatusDetailActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f20299k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f20300l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20301m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f20302n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f20303o;

    /* renamed from: p  reason: collision with root package name */
    private MyGridView f20304p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f20305q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f20306r;

    /* renamed from: s  reason: collision with root package name */
    private String f20307s;

    /* renamed from: t  reason: collision with root package name */
    private List<String> f20308t;

    /* renamed from: u  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> f20309u;

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
            ApplyHealthStatusDetailActivity.this.R().setVisibility(0);
            TextView textView = ApplyHealthStatusDetailActivity.this.f20299k;
            textView.setText("\u59d3\u540d\uff1a" + JsonParse.getString(data, "applyerName"));
            TextView textView2 = ApplyHealthStatusDetailActivity.this.f20300l;
            textView2.setText("\u5b66\u53f7\uff1a" + JsonParse.getString(data, "userNum"));
            TextView textView3 = ApplyHealthStatusDetailActivity.this.f20302n;
            textView3.setText("\u7c7b\u578b\uff1a" + JsonParse.getString(data, "type"));
            TextView textView4 = ApplyHealthStatusDetailActivity.this.f20303o;
            textView4.setText("\u539f\u56e0\uff1a" + JsonParse.getString(data, "applyMemo"));
            TextView textView5 = ApplyHealthStatusDetailActivity.this.f20306r;
            textView5.setText("\u72b6\u6001\uff1a" + JsonParse.getString(data, "status"));
            TextView textView6 = ApplyHealthStatusDetailActivity.this.f20305q;
            textView6.setText("\u65f6\u95f4\uff1a" + JsonParse.getString(data, "applyDate"));
            ApplyHealthStatusDetailActivity.this.f20308t = JsonParse.getList(data, "imgs", String.class);
            ApplyHealthStatusDetailActivity.this.f20309u.c(ApplyHealthStatusDetailActivity.this.f20308t);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s0(AdapterView adapterView, View view, int i4, long j4) {
        t0((String[]) this.f20308t.toArray(new String[this.f20308t.size()]), i4);
    }

    private void t0(String[] arr, int position) {
        Intent intent = new Intent(this.f1656h, ImagePagerActivity.class);
        intent.putExtra("image_urls", arr);
        intent.putExtra("image_index", position);
        startActivity(intent);
        overridePendingTransition(2130772087, 2130772088);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20304p.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.healthstatus.a
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
                ApplyHealthStatusDetailActivity.this.s0(adapterView, view, i4, j4);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427365;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("id")) {
            this.f20307s = getIntent().getStringExtra("id");
        }
        a aVar = new a(this.f1656h, 2131427721, this.f20308t);
        this.f20309u = aVar;
        this.f20304p.setAdapter((ListAdapter) aVar);
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).N(this.f20307s)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7533\u8bf7\u72b6\u6001\u8be6\u60c5");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20299k = (TextView) findViewById(2131233040);
        this.f20300l = (TextView) findViewById(2131233051);
        this.f20301m = (TextView) findViewById(2131233194);
        this.f20302n = (TextView) findViewById(2131233211);
        this.f20303o = (TextView) findViewById(2131233119);
        this.f20304p = (MyGridView) findViewById(2131231336);
        this.f20305q = (TextView) findViewById(2131233198);
        this.f20306r = (TextView) findViewById(2131233169);
        this.f20301m.setVisibility(8);
        R().setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
