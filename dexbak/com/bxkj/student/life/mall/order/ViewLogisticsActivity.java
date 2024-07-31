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
import com.bxkj.student.C4215R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p635q.MallApiService;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ViewLogisticsActivity extends BaseActivity {

    /* renamed from: k */
    private RecyclerView f18477k;

    /* renamed from: l */
    private List<Map<String, Object>> f18478l = new ArrayList();

    /* renamed from: m */
    private String f18479m;

    /* renamed from: n */
    private String f18480n;

    /* renamed from: o */
    private TextView f18481o;

    /* renamed from: p */
    private TextView f18482p;

    /* renamed from: q */
    private LinearLayout f18483q;

    /* renamed from: r */
    private CommonAdapter<Map<String, Object>> f18484r;

    /* renamed from: s */
    private String f18485s;

    /* renamed from: com.bxkj.student.life.mall.order.ViewLogisticsActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5031a extends CommonAdapter<Map<String, Object>> {
        C5031a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            if (holder.m57864f() == 0) {
                holder.m57852r(C4215R.C4219id.iv_dot, C4215R.mipmap.red_dot);
                holder.m57873K(2131233004, ViewLogisticsActivity.this.getResources().getColor(2131034190));
                holder.m57873K(2131233198, ViewLogisticsActivity.this.getResources().getColor(2131034190));
            } else {
                holder.m57852r(C4215R.C4219id.iv_dot, C4215R.mipmap.gray_dot);
                holder.m57873K(2131233004, ViewLogisticsActivity.this.getResources().getColor(2131034269));
                holder.m57873K(2131233198, ViewLogisticsActivity.this.getResources().getColor(2131034269));
            }
            holder.m57874J(2131233004, JsonParse.getString(stringObjectMap, "AcceptStation"));
            holder.m57874J(2131233198, JsonParse.getString(stringObjectMap, "AcceptTime"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.order.ViewLogisticsActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5032b extends HttpCallBack {
        C5032b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ViewLogisticsActivity.this.f18483q.setVisibility(0);
            TextView textView = ViewLogisticsActivity.this.f18481o;
            textView.setText("物流公司：" + JsonParse.getString(data, "ShipperName"));
            TextView textView2 = ViewLogisticsActivity.this.f18482p;
            textView2.setText("物流单号：" + JsonParse.getString(data, "LogisticCode"));
            ViewLogisticsActivity.this.f18478l = JsonParse.getList(data, "Traces");
            if (ViewLogisticsActivity.this.f18478l == null || ViewLogisticsActivity.this.f18478l.size() == 0) {
                HashMap hashMap = new HashMap();
                hashMap.put("AcceptStation", "暂无物流信息");
                ViewLogisticsActivity.this.f18478l.add(hashMap);
            }
            Collections.reverse(ViewLogisticsActivity.this.f18478l);
            ViewLogisticsActivity.this.f18484r.m57836g(ViewLogisticsActivity.this.f18478l);
        }
    }

    /* renamed from: o0 */
    private void m40785o0() {
        Http.with(this.f1669h).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2223y(this.f18485s)).setDataListener(new C5032b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_view_logistics;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("orderId")) {
            this.f18485s = getIntent().getStringExtra("orderId");
        }
        if (getIntent().hasExtra("shipping_id")) {
            this.f18479m = getIntent().getStringExtra("shipping_id");
        }
        if (getIntent().hasExtra("invoice_no")) {
            this.f18480n = getIntent().getStringExtra("invoice_no");
        }
        m40785o0();
        for (int i = 0; i < 4; i++) {
            this.f18478l.add(new HashMap());
        }
        this.f18484r = new C5031a(this.f1669h, C4215R.C4221layout.item_for_logistics, this.f18478l);
        this.f18477k.setLayoutManager(new LinearLayoutManager(this.f1669h));
        this.f18477k.setAdapter(this.f18484r);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("查看物流");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18477k = (RecyclerView) findViewById(2131232245);
        this.f18481o = (TextView) findViewById(2131233040);
        this.f18482p = (TextView) findViewById(2131233045);
        LinearLayout linearLayout = (LinearLayout) findViewById(2131232217);
        this.f18483q = linearLayout;
        linearLayout.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
