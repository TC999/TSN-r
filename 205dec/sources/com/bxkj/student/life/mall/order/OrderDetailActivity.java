package com.bxkj.student.life.mall.order;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.life.mall.GoodsDetailActivity;
import com.bxkj.student.life.mall.order.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import q.g;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class OrderDetailActivity extends BaseActivity {
    private String A;
    private Map<String, Object> B;
    private CommonAdapter<Map<String, Object>> C;
    private Map<String, Object> D;

    /* renamed from: k  reason: collision with root package name */
    private ScrollView f21728k;

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f21729l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f21730m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f21731n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f21732o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f21733p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f21734q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f21735r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f21736s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f21737t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f21738u;

    /* renamed from: v  reason: collision with root package name */
    private CardView f21739v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f21740w;

    /* renamed from: x  reason: collision with root package name */
    private Button f21741x;

    /* renamed from: y  reason: collision with root package name */
    private Button f21742y;

    /* renamed from: z  reason: collision with root package name */
    private List<Map<String, Object>> f21743z = new ArrayList();

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
            holder.t(2131231451, JsonParse.getString(stringObjectMap, "showImg"), 2131558744, 2131558744);
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "commName"));
            holder.J(2131233101, "\uffe5" + JsonParse.getMoney(stringObjectMap, "commPrize"));
            holder.J(2131232914, "x" + JsonParse.getInt(stringObjectMap, "commNum"));
            holder.J(2131233033, JsonParse.getString(stringObjectMap, "modelName"));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements a.e {
        b() {
        }

        @Override // com.bxkj.student.life.mall.order.a.e
        public void a() {
            OrderDetailActivity.this.r0();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.bxkj.student.life.mall.order.a f21746a;

        c(final com.bxkj.student.life.mall.order.a val$orderButtonOnClick) {
            this.f21746a = val$orderButtonOnClick;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            this.f21746a.d(OrderDetailActivity.this.f21741x.getText().toString().trim(), JsonParse.getString(OrderDetailActivity.this.B, "id"), JsonParse.getString(OrderDetailActivity.this.B, "orderNum"), JsonParse.getDouble(OrderDetailActivity.this.B, "totalPrize"));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.bxkj.student.life.mall.order.a f21748a;

        d(final com.bxkj.student.life.mall.order.a val$orderButtonOnClick) {
            this.f21748a = val$orderButtonOnClick;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            this.f21748a.d(OrderDetailActivity.this.f21742y.getText().toString().trim(), JsonParse.getString(OrderDetailActivity.this.B, "id"), JsonParse.getString(OrderDetailActivity.this.B, "orderNum"), JsonParse.getDouble(OrderDetailActivity.this.B, "totalPrize"));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class e implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        e() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
            OrderDetailActivity.this.startActivity(new Intent(((BaseActivity) OrderDetailActivity.this).f1656h, GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString((Map) OrderDetailActivity.this.C.getItem(position), "commId")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            OrderDetailActivity.this.B = data;
            OrderDetailActivity.this.f21728k.setVisibility(0);
            OrderDetailActivity.this.s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        Http.with(this.f1656h).setObservable(((g) Http.getApiService(g.class)).n(this.A)).setDataListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        this.f21730m.setText(JsonParse.getString(this.B, "state"));
        this.f21731n.setText(JsonParse.getString(this.B, "orderNum"));
        this.f21732o.setText(JsonParse.getString(this.B, "createTime"));
        this.f21733p.setText(JsonParse.getString(this.B, "receiverName"));
        this.f21734q.setText(JsonParse.getString(this.B, "receiverPhone"));
        this.f21735r.setText(JsonParse.getString(this.B, "address"));
        List<Map<String, Object>> list = JsonParse.getList(this.B, "commArr");
        this.f21743z = list;
        this.C.g(list);
        String string = JsonParse.getString(this.B, "memo");
        if (!TextUtils.isEmpty(string)) {
            this.f21739v.setVisibility(0);
            this.f21740w.setText(string);
        }
        TextView textView = this.f21736s;
        textView.setText("\uffe5" + JsonParse.getMoney(this.B, "commPrize"));
        TextView textView2 = this.f21737t;
        textView2.setText("\uffe5" + JsonParse.getMoney(this.B, "postFee"));
        TextView textView3 = this.f21738u;
        textView3.setText("\uffe5" + JsonParse.getMoney(this.B, "totalPrize"));
        int i4 = JsonParse.getInt(this.B, "orderMode");
        if (i4 == 1) {
            this.f21741x.setVisibility(0);
            this.f21742y.setVisibility(0);
            this.f21741x.setText("\u53d6\u6d88\u8ba2\u5355");
            this.f21742y.setText("\u7acb\u5373\u4ed8\u6b3e");
        } else if (i4 == 2) {
            this.f21741x.setVisibility(8);
            this.f21742y.setVisibility(0);
            this.f21742y.setText("\u7533\u8bf7\u9000\u6b3e");
        } else if (i4 == 3) {
            this.f21741x.setVisibility(0);
            this.f21742y.setVisibility(0);
            this.f21741x.setText("\u67e5\u770b\u7269\u6d41");
            this.f21742y.setText("\u786e\u8ba4\u6536\u8d27");
        } else if (i4 == 4) {
            this.f21741x.setVisibility(8);
            this.f21742y.setVisibility(0);
            this.f21742y.setText("\u5220\u9664\u8ba2\u5355");
        } else if (i4 == 5) {
            this.f21741x.setVisibility(8);
            this.f21742y.setVisibility(0);
            this.f21742y.setText("\u5220\u9664\u8ba2\u5355");
        } else if (i4 == 6) {
            this.f21741x.setVisibility(8);
            this.f21742y.setVisibility(0);
            this.f21742y.setText("\u5220\u9664\u8ba2\u5355");
        } else {
            this.f21741x.setVisibility(8);
            this.f21742y.setVisibility(8);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        com.bxkj.student.life.mall.order.a aVar = new com.bxkj.student.life.mall.order.a(this.f1656h);
        aVar.s(new b());
        this.f21741x.setOnClickListener(new c(aVar));
        this.f21742y.setOnClickListener(new d(aVar));
        this.C.k(new e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427446;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("orderId")) {
            this.A = getIntent().getStringExtra("orderId");
        }
        this.f21729l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427733, this.f21743z);
        this.C = aVar;
        this.f21729l.setAdapter(aVar);
        this.f21729l.addItemDecoration(new DividerItemDecoration(this.f1656h, 1));
        r0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8ba2\u5355\u8be6\u60c5");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21729l = (RecyclerView) findViewById(2131232545);
        this.f21728k = (ScrollView) findViewById(2131232571);
        this.f21730m = (TextView) findViewById(2131233057);
        this.f21731n = (TextView) findViewById(2131233056);
        this.f21732o = (TextView) findViewById(2131233058);
        this.f21736s = (TextView) findViewById(2131232978);
        this.f21737t = (TextView) findViewById(2131233099);
        this.f21738u = (TextView) findViewById(2131233207);
        this.f21733p = (TextView) findViewById(2131233040);
        this.f21734q = (TextView) findViewById(2131233089);
        this.f21735r = (TextView) findViewById(2131232841);
        this.f21740w = (TextView) findViewById(2131233047);
        this.f21741x = (Button) findViewById(2131230983);
        this.f21742y = (Button) findViewById(2131231007);
        this.f21739v = (CardView) findViewById(2131231056);
        this.f21728k.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
