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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.bxkj.student.life.mall.GoodsDetailActivity;
import com.bxkj.student.life.mall.order.OrderButtonOnClick;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p635q.MallApiService;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class OrderDetailActivity extends BaseActivity {

    /* renamed from: A */
    private String f18415A;

    /* renamed from: B */
    private Map<String, Object> f18416B;

    /* renamed from: C */
    private CommonAdapter<Map<String, Object>> f18417C;

    /* renamed from: D */
    private Map<String, Object> f18418D;

    /* renamed from: k */
    private ScrollView f18419k;

    /* renamed from: l */
    private RecyclerView f18420l;

    /* renamed from: m */
    private TextView f18421m;

    /* renamed from: n */
    private TextView f18422n;

    /* renamed from: o */
    private TextView f18423o;

    /* renamed from: p */
    private TextView f18424p;

    /* renamed from: q */
    private TextView f18425q;

    /* renamed from: r */
    private TextView f18426r;

    /* renamed from: s */
    private TextView f18427s;

    /* renamed from: t */
    private TextView f18428t;

    /* renamed from: u */
    private TextView f18429u;

    /* renamed from: v */
    private CardView f18430v;

    /* renamed from: w */
    private TextView f18431w;

    /* renamed from: x */
    private Button f18432x;

    /* renamed from: y */
    private Button f18433y;

    /* renamed from: z */
    private List<Map<String, Object>> f18434z = new ArrayList();

    /* renamed from: com.bxkj.student.life.mall.order.OrderDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5014a extends CommonAdapter<Map<String, Object>> {
        C5014a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57850t(2131231451, JsonParse.getString(stringObjectMap, "showImg"), C4215R.mipmap.icon_smal, C4215R.mipmap.icon_smal);
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "commName"));
            holder.m57874J(2131233101, "￥" + JsonParse.getMoney(stringObjectMap, "commPrize"));
            holder.m57874J(2131232914, "x" + JsonParse.getInt(stringObjectMap, "commNum"));
            holder.m57874J(C4215R.C4219id.tv_model, JsonParse.getString(stringObjectMap, "modelName"));
        }
    }

    /* renamed from: com.bxkj.student.life.mall.order.OrderDetailActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5015b implements OrderButtonOnClick.InterfaceC5041e {
        C5015b() {
        }

        @Override // com.bxkj.student.life.mall.order.OrderButtonOnClick.InterfaceC5041e
        /* renamed from: a */
        public void mo40763a() {
            OrderDetailActivity.this.m40814r0();
        }
    }

    /* renamed from: com.bxkj.student.life.mall.order.OrderDetailActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class View$OnClickListenerC5016c implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ OrderButtonOnClick f18437a;

        View$OnClickListenerC5016c(final OrderButtonOnClick val$orderButtonOnClick) {
            this.f18437a = val$orderButtonOnClick;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            this.f18437a.m40780d(OrderDetailActivity.this.f18432x.getText().toString().trim(), JsonParse.getString(OrderDetailActivity.this.f18416B, "id"), JsonParse.getString(OrderDetailActivity.this.f18416B, "orderNum"), JsonParse.getDouble(OrderDetailActivity.this.f18416B, "totalPrize"));
        }
    }

    /* renamed from: com.bxkj.student.life.mall.order.OrderDetailActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class View$OnClickListenerC5017d implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ OrderButtonOnClick f18439a;

        View$OnClickListenerC5017d(final OrderButtonOnClick val$orderButtonOnClick) {
            this.f18439a = val$orderButtonOnClick;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            this.f18439a.m40780d(OrderDetailActivity.this.f18433y.getText().toString().trim(), JsonParse.getString(OrderDetailActivity.this.f18416B, "id"), JsonParse.getString(OrderDetailActivity.this.f18416B, "orderNum"), JsonParse.getDouble(OrderDetailActivity.this.f18416B, "totalPrize"));
        }
    }

    /* renamed from: com.bxkj.student.life.mall.order.OrderDetailActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5018e implements OnItemClickListener {
        C5018e() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            OrderDetailActivity.this.startActivity(new Intent(((BaseActivity) OrderDetailActivity.this).f1669h, GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString((Map) OrderDetailActivity.this.f18417C.getItem(position), "commId")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.order.OrderDetailActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5019f extends HttpCallBack {
        C5019f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            OrderDetailActivity.this.f18416B = data;
            OrderDetailActivity.this.f18419k.setVisibility(0);
            OrderDetailActivity.this.m40813s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public void m40814r0() {
        Http.with(this.f1669h).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2234n(this.f18415A)).setDataListener(new C5019f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public void m40813s0() {
        this.f18421m.setText(JsonParse.getString(this.f18416B, "state"));
        this.f18422n.setText(JsonParse.getString(this.f18416B, "orderNum"));
        this.f18423o.setText(JsonParse.getString(this.f18416B, "createTime"));
        this.f18424p.setText(JsonParse.getString(this.f18416B, "receiverName"));
        this.f18425q.setText(JsonParse.getString(this.f18416B, "receiverPhone"));
        this.f18426r.setText(JsonParse.getString(this.f18416B, "address"));
        List<Map<String, Object>> list = JsonParse.getList(this.f18416B, "commArr");
        this.f18434z = list;
        this.f18417C.m57836g(list);
        String string = JsonParse.getString(this.f18416B, "memo");
        if (!TextUtils.isEmpty(string)) {
            this.f18430v.setVisibility(0);
            this.f18431w.setText(string);
        }
        TextView textView = this.f18427s;
        textView.setText("￥" + JsonParse.getMoney(this.f18416B, "commPrize"));
        TextView textView2 = this.f18428t;
        textView2.setText("￥" + JsonParse.getMoney(this.f18416B, "postFee"));
        TextView textView3 = this.f18429u;
        textView3.setText("￥" + JsonParse.getMoney(this.f18416B, "totalPrize"));
        int i = JsonParse.getInt(this.f18416B, "orderMode");
        if (i == 1) {
            this.f18432x.setVisibility(0);
            this.f18433y.setVisibility(0);
            this.f18432x.setText("取消订单");
            this.f18433y.setText("立即付款");
        } else if (i == 2) {
            this.f18432x.setVisibility(8);
            this.f18433y.setVisibility(0);
            this.f18433y.setText("申请退款");
        } else if (i == 3) {
            this.f18432x.setVisibility(0);
            this.f18433y.setVisibility(0);
            this.f18432x.setText("查看物流");
            this.f18433y.setText("确认收货");
        } else if (i == 4) {
            this.f18432x.setVisibility(8);
            this.f18433y.setVisibility(0);
            this.f18433y.setText("删除订单");
        } else if (i == 5) {
            this.f18432x.setVisibility(8);
            this.f18433y.setVisibility(0);
            this.f18433y.setText("删除订单");
        } else if (i == 6) {
            this.f18432x.setVisibility(8);
            this.f18433y.setVisibility(0);
            this.f18433y.setText("删除订单");
        } else {
            this.f18432x.setVisibility(8);
            this.f18433y.setVisibility(8);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        OrderButtonOnClick orderButtonOnClick = new OrderButtonOnClick(this.f1669h);
        orderButtonOnClick.m40765s(new C5015b());
        this.f18432x.setOnClickListener(new View$OnClickListenerC5016c(orderButtonOnClick));
        this.f18433y.setOnClickListener(new View$OnClickListenerC5017d(orderButtonOnClick));
        this.f18417C.m57834k(new C5018e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_order_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("orderId")) {
            this.f18415A = getIntent().getStringExtra("orderId");
        }
        this.f18420l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C5014a c5014a = new C5014a(this.f1669h, C4215R.C4221layout.item_for_order_goods_list, this.f18434z);
        this.f18417C = c5014a;
        this.f18420l.setAdapter(c5014a);
        this.f18420l.addItemDecoration(new DividerItemDecoration(this.f1669h, 1));
        m40814r0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("订单详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18420l = (RecyclerView) findViewById(C4215R.C4219id.rv_goods_list);
        this.f18419k = (ScrollView) findViewById(2131232571);
        this.f18421m = (TextView) findViewById(C4215R.C4219id.tv_order_status);
        this.f18422n = (TextView) findViewById(C4215R.C4219id.tv_order_no);
        this.f18423o = (TextView) findViewById(C4215R.C4219id.tv_order_time);
        this.f18427s = (TextView) findViewById(C4215R.C4219id.tv_goods_price);
        this.f18428t = (TextView) findViewById(C4215R.C4219id.tv_post_price);
        this.f18429u = (TextView) findViewById(C4215R.C4219id.tv_total_price);
        this.f18424p = (TextView) findViewById(2131233040);
        this.f18425q = (TextView) findViewById(2131233089);
        this.f18426r = (TextView) findViewById(2131232841);
        this.f18431w = (TextView) findViewById(C4215R.C4219id.tv_note);
        this.f18432x = (Button) findViewById(C4215R.C4219id.bt_left);
        this.f18433y = (Button) findViewById(C4215R.C4219id.bt_right);
        this.f18430v = (CardView) findViewById(C4215R.C4219id.cardView_note);
        this.f18419k.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
