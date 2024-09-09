package com.bxkj.student.life.mall.order;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import q.g;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ViewLogisticsActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private RecyclerView f21786k;

    /* renamed from: l  reason: collision with root package name */
    private List<Map<String, Object>> f21787l = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private String f21788m;

    /* renamed from: n  reason: collision with root package name */
    private String f21789n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f21790o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f21791p;

    /* renamed from: q  reason: collision with root package name */
    private LinearLayout f21792q;

    /* renamed from: r  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21793r;

    /* renamed from: s  reason: collision with root package name */
    private String f21794s;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            if (holder.f() == 0) {
                holder.r(2131231411, 2131558931);
                holder.K(2131233004, ViewLogisticsActivity.this.getResources().getColor(2131034190));
                holder.K(2131233198, ViewLogisticsActivity.this.getResources().getColor(2131034190));
            } else {
                holder.r(2131231411, 2131558582);
                holder.K(2131233004, ViewLogisticsActivity.this.getResources().getColor(2131034269));
                holder.K(2131233198, ViewLogisticsActivity.this.getResources().getColor(2131034269));
            }
            holder.J(2131233004, JsonParse.getString(stringObjectMap, "AcceptStation"));
            holder.J(2131233198, JsonParse.getString(stringObjectMap, "AcceptTime"));
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
            ViewLogisticsActivity.this.f21792q.setVisibility(0);
            TextView textView = ViewLogisticsActivity.this.f21790o;
            textView.setText("\u7269\u6d41\u516c\u53f8\uff1a" + JsonParse.getString(data, "ShipperName"));
            TextView textView2 = ViewLogisticsActivity.this.f21791p;
            textView2.setText("\u7269\u6d41\u5355\u53f7\uff1a" + JsonParse.getString(data, "LogisticCode"));
            ViewLogisticsActivity.this.f21787l = JsonParse.getList(data, "Traces");
            if (ViewLogisticsActivity.this.f21787l == null || ViewLogisticsActivity.this.f21787l.size() == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("AcceptStation", "\u6682\u65e0\u7269\u6d41\u4fe1\u606f");
                ViewLogisticsActivity.this.f21787l.add(hashMap);
            }
            Collections.reverse(ViewLogisticsActivity.this.f21787l);
            ViewLogisticsActivity.this.f21793r.g(ViewLogisticsActivity.this.f21787l);
        }
    }

    private void o0() {
        Http.with(this.f1656h).setObservable(((g) Http.getApiService(g.class)).y(this.f21794s)).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427522;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("orderId")) {
            this.f21794s = getIntent().getStringExtra("orderId");
        }
        if (getIntent().hasExtra("shipping_id")) {
            this.f21788m = getIntent().getStringExtra("shipping_id");
        }
        if (getIntent().hasExtra("invoice_no")) {
            this.f21789n = getIntent().getStringExtra("invoice_no");
        }
        o0();
        for (int i4 = 0; i4 < 4; i4++) {
            this.f21787l.add(new HashMap());
        }
        this.f21793r = new a(this.f1656h, 2131427719, this.f21787l);
        this.f21786k.setLayoutManager(new LinearLayoutManager(this.f1656h));
        this.f21786k.setAdapter(this.f21793r);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u67e5\u770b\u7269\u6d41");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21786k = (RecyclerView) findViewById(2131232245);
        this.f21790o = (TextView) findViewById(2131233040);
        this.f21791p = (TextView) findViewById(2131233045);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131232217);
        this.f21792q = linearLayout;
        linearLayout.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
