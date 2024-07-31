package com.bxkj.student.life.mall.order;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.life.mall.order.OrderButtonOnClick;
import com.github.mikephil.charting.utils.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p635q.MallApiService;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class OrderFragment extends BaseFragment {

    /* renamed from: h */
    private SmartRefreshLayout f18443h;

    /* renamed from: i */
    private EmptyRecyclerView f18444i;

    /* renamed from: k */
    private int f18446k;

    /* renamed from: l */
    private CommonAdapter<Map<String, Object>> f18447l;

    /* renamed from: m */
    private OrderButtonOnClick f18448m;

    /* renamed from: j */
    private List<Map<String, Object>> f18445j = new ArrayList();

    /* renamed from: n */
    private int f18449n = 1;

    /* renamed from: o */
    private int f18450o = 15;

    /* renamed from: p */
    private int f18451p = 0;

    /* renamed from: com.bxkj.student.life.mall.order.OrderFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5020a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.mall.order.OrderFragment$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C5021a extends cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter<Map<String, Object>> {
            C5021a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
            /* renamed from: d */
            public void mo40086a(ViewHolder holder, Map<String, Object> stringObjectMap) {
                holder.m57850t(2131231451, JsonParse.getString(stringObjectMap, "showImg"), C4215R.mipmap.icon_smal, C4215R.mipmap.icon_smal);
                holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "commName"));
                holder.m57874J(2131233101, "￥" + JsonParse.getMoney(stringObjectMap, "commPrize"));
                holder.m57874J(2131232914, "x" + JsonParse.getInt(stringObjectMap, "commNum"));
                holder.m57874J(C4215R.C4219id.tv_model, JsonParse.getString(stringObjectMap, "modelName"));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.mall.order.OrderFragment$a$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC5022b implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ ViewHolder f18454a;

            /* renamed from: b */
            final /* synthetic */ Map f18455b;

            View$OnClickListenerC5022b(final ViewHolder val$holder, final Map val$stringObjectMap) {
                this.f18454a = val$holder;
                this.f18455b = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                OrderFragment.this.f18448m.m40780d(this.f18454a.m57863g(C4215R.C4219id.bt_left), JsonParse.getString(this.f18455b, "id"), JsonParse.getString(this.f18455b, "orderNum"), JsonParse.getDouble(this.f18455b, "totalPrize"));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.mall.order.OrderFragment$a$c */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC5023c implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ ViewHolder f18457a;

            /* renamed from: b */
            final /* synthetic */ Map f18458b;

            View$OnClickListenerC5023c(final ViewHolder val$holder, final Map val$stringObjectMap) {
                this.f18457a = val$holder;
                this.f18458b = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                OrderFragment.this.f18448m.m40780d(this.f18457a.m57863g(C4215R.C4219id.bt_right), JsonParse.getString(this.f18458b, "id"), JsonParse.getString(this.f18458b, "orderNum"), JsonParse.getDouble(this.f18458b, "totalPrize"));
            }
        }

        C5020a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv_order_no, JsonParse.getString(stringObjectMap, "orderNum"));
            holder.m57874J(C4215R.C4219id.tv_order_status, JsonParse.getString(stringObjectMap, "state"));
            holder.m57874J(C4215R.C4219id.tv_total_number, "共" + JsonParse.getString(stringObjectMap, "commTotalNum") + "件商品");
            StringBuilder sb = new StringBuilder();
            sb.append("合计：￥");
            sb.append(JsonParse.getMoney(stringObjectMap, "totalPrize"));
            holder.m57874J(C4215R.C4219id.tv_total_price, sb.toString());
            double d = JsonParse.getDouble(stringObjectMap, "postFee");
            holder.m57870N(C4215R.C4219id.tv_post_price, d != Utils.DOUBLE_EPSILON);
            if (d != Utils.DOUBLE_EPSILON) {
                holder.m57874J(C4215R.C4219id.tv_post_price, "(含运费￥" + new DecimalFormat("0.00").format(d) + ")");
            }
            ListView listView = (ListView) holder.m57862h(C4215R.C4219id.lv_goods);
            listView.setEnabled(false);
            listView.setPressed(false);
            listView.setClickable(false);
            listView.setAdapter((ListAdapter) new C5021a(this.f1721a, C4215R.C4221layout.item_for_order_goods_list, JsonParse.getList(stringObjectMap, "commArr")));
            int i = JsonParse.getInt(stringObjectMap, "orderMode");
            if (i == 1) {
                holder.m57870N(C4215R.C4219id.bt_left, true);
                holder.m57870N(C4215R.C4219id.bt_right, true);
                holder.m57874J(C4215R.C4219id.bt_left, "取消订单");
                holder.m57874J(C4215R.C4219id.bt_right, "立即付款");
            } else if (i == 2) {
                holder.m57870N(C4215R.C4219id.bt_left, false);
                holder.m57870N(C4215R.C4219id.bt_right, true);
                holder.m57874J(C4215R.C4219id.bt_right, "申请退款");
            } else if (i == 3) {
                holder.m57870N(C4215R.C4219id.bt_left, true);
                holder.m57870N(C4215R.C4219id.bt_right, true);
                holder.m57874J(C4215R.C4219id.bt_left, "查看物流");
                holder.m57874J(C4215R.C4219id.bt_right, "确认收货");
            } else if (i == 4) {
                holder.m57870N(C4215R.C4219id.bt_left, false);
                holder.m57870N(C4215R.C4219id.bt_right, true);
                holder.m57874J(C4215R.C4219id.bt_right, "删除订单");
            } else if (i == 5) {
                holder.m57870N(C4215R.C4219id.bt_left, false);
                holder.m57870N(C4215R.C4219id.bt_right, true);
                holder.m57874J(C4215R.C4219id.bt_right, "删除订单");
            } else if (i == 6) {
                holder.m57870N(C4215R.C4219id.bt_left, false);
                holder.m57870N(C4215R.C4219id.bt_right, true);
                holder.m57874J(C4215R.C4219id.bt_right, "删除订单");
            } else {
                holder.m57870N(C4215R.C4219id.bt_left, false);
                holder.m57870N(C4215R.C4219id.bt_right, false);
            }
            holder.m57847w(C4215R.C4219id.bt_left, new View$OnClickListenerC5022b(holder, stringObjectMap));
            holder.m57847w(C4215R.C4219id.bt_right, new View$OnClickListenerC5023c(holder, stringObjectMap));
        }
    }

    /* renamed from: com.bxkj.student.life.mall.order.OrderFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5024b implements OnItemClickListener {
        C5024b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            OrderFragment.this.startActivity(new Intent(((BaseFragment) OrderFragment.this).f1678e, OrderDetailActivity.class).putExtra("orderId", JsonParse.getString((Map) OrderFragment.this.f18447l.getItem(position), "id")));
        }
    }

    /* renamed from: com.bxkj.student.life.mall.order.OrderFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5025c implements OrderButtonOnClick.InterfaceC5041e {
        C5025c() {
        }

        @Override // com.bxkj.student.life.mall.order.OrderButtonOnClick.InterfaceC5041e
        /* renamed from: a */
        public void mo40763a() {
            OrderFragment.this.m40797b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.order.OrderFragment$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5026d implements OnRefreshLoadmoreListener {
        C5026d() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            OrderFragment.this.f18449n = 1;
            OrderFragment.this.m40799Z();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = OrderFragment.this.f18451p / OrderFragment.this.f18450o;
            int i2 = OrderFragment.this.f18449n;
            if (OrderFragment.this.f18451p % OrderFragment.this.f18450o != 0) {
                i++;
            }
            if (i2 >= i) {
                OrderFragment.this.f18443h.mo2041g();
                OrderFragment.this.m57918D("没有了");
                return;
            }
            OrderFragment.m40803V(OrderFragment.this);
            OrderFragment.this.m40799Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.order.OrderFragment$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5027e extends HttpCallBack {
        C5027e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (OrderFragment.this.f18443h != null && OrderFragment.this.f18443h.mo2061S()) {
                OrderFragment.this.f18443h.mo2078B();
            }
            if (OrderFragment.this.f18443h == null || !OrderFragment.this.f18443h.mo2015z()) {
                return;
            }
            OrderFragment.this.f18443h.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            OrderFragment.this.f18451p = JsonParse.getInt(data, "total");
            if (OrderFragment.this.f18449n == 1) {
                OrderFragment.this.f18445j.clear();
            }
            OrderFragment.this.f18445j.addAll(JsonParse.getList(data, "data"));
            OrderFragment.this.f18447l.notifyDataSetChanged();
        }
    }

    /* renamed from: V */
    static /* synthetic */ int m40803V(OrderFragment orderFragment) {
        int i = orderFragment.f18449n;
        orderFragment.f18449n = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public void m40799Z() {
        String valueOf = String.valueOf(this.f18446k);
        if (this.f18446k == 0) {
            valueOf = "";
        }
        Http.with(this.f1678e).hideLoadingDialog().setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2226v(valueOf, LoginUser.getLoginUser().getOpenId(), this.f18449n, this.f18450o)).setDataListener(new C5027e());
    }

    /* renamed from: a0 */
    private void m40798a0() {
        this.f18443h.mo2019v(new C5026d());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
        this.f18447l.m57834k(new C5024b());
        this.f18448m.m40765s(new C5025c());
    }

    /* renamed from: b0 */
    public void m40797b0() {
        this.f18443h.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    protected void mo39444e() {
        this.f18448m = new OrderButtonOnClick(this.f1678e);
        if (getArguments().containsKey("index")) {
            this.f18446k = getArguments().getInt("index");
        }
        this.f18444i.setLayoutManager(new LinearLayoutManager(this.f1678e));
        C5020a c5020a = new C5020a(this.f1678e, C4215R.C4221layout.item_for_order_list, this.f18445j);
        this.f18447l = c5020a;
        this.f18444i.setAdapter(c5020a);
        this.f18444i.setEmptyView(m57916c(2131232952));
        m40798a0();
        m40797b0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f18443h = (SmartRefreshLayout) m57916c(2131232482);
        this.f18444i = (EmptyRecyclerView) m57916c(2131232481);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return 2131428026;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
