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
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.life.mall.order.a;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import q.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class OrderFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private SmartRefreshLayout f21752h;

    /* renamed from: i  reason: collision with root package name */
    private EmptyRecyclerView f21753i;

    /* renamed from: k  reason: collision with root package name */
    private int f21755k;

    /* renamed from: l  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21756l;

    /* renamed from: m  reason: collision with root package name */
    private com.bxkj.student.life.mall.order.a f21757m;

    /* renamed from: j  reason: collision with root package name */
    private List<Map<String, Object>> f21754j = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private int f21758n = 1;

    /* renamed from: o  reason: collision with root package name */
    private int f21759o = 15;

    /* renamed from: p  reason: collision with root package name */
    private int f21760p = 0;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.life.mall.order.OrderFragment$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class C0267a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
            C0267a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
            /* renamed from: d */
            public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
                holder.t(2131231451, JsonParse.getString(stringObjectMap, "showImg"), 2131558744, 2131558744);
                holder.J(2131233040, JsonParse.getString(stringObjectMap, "commName"));
                holder.J(2131233101, "\uffe5" + JsonParse.getMoney(stringObjectMap, "commPrize"));
                holder.J(2131232914, "x" + JsonParse.getInt(stringObjectMap, "commNum"));
                holder.J(2131233033, JsonParse.getString(stringObjectMap, "modelName"));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ViewHolder f21763a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Map f21764b;

            b(final ViewHolder val$holder, final Map val$stringObjectMap) {
                this.f21763a = val$holder;
                this.f21764b = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                OrderFragment.this.f21757m.d(this.f21763a.g(2131230983), JsonParse.getString(this.f21764b, "id"), JsonParse.getString(this.f21764b, "orderNum"), JsonParse.getDouble(this.f21764b, "totalPrize"));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ViewHolder f21766a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Map f21767b;

            c(final ViewHolder val$holder, final Map val$stringObjectMap) {
                this.f21766a = val$holder;
                this.f21767b = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                OrderFragment.this.f21757m.d(this.f21766a.g(2131231007), JsonParse.getString(this.f21767b, "id"), JsonParse.getString(this.f21767b, "orderNum"), JsonParse.getDouble(this.f21767b, "totalPrize"));
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233056, JsonParse.getString(stringObjectMap, "orderNum"));
            holder.J(2131233057, JsonParse.getString(stringObjectMap, "state"));
            holder.J(2131233206, "\u5171" + JsonParse.getString(stringObjectMap, "commTotalNum") + "\u4ef6\u5546\u54c1");
            StringBuilder sb = new StringBuilder();
            sb.append("\u5408\u8ba1\uff1a\uffe5");
            sb.append(JsonParse.getMoney(stringObjectMap, "totalPrize"));
            holder.J(2131233207, sb.toString());
            double d4 = JsonParse.getDouble(stringObjectMap, "postFee");
            holder.N(2131233099, d4 != 0.0d);
            if (d4 != 0.0d) {
                holder.J(2131233099, "(\u542b\u8fd0\u8d39\uffe5" + new DecimalFormat("0.00").format(d4) + ")");
            }
            ListView listView = (ListView) holder.h(2131232248);
            listView.setEnabled(false);
            listView.setPressed(false);
            listView.setClickable(false);
            listView.setAdapter((ListAdapter) new C0267a(this.f1707a, 2131427733, JsonParse.getList(stringObjectMap, "commArr")));
            int i4 = JsonParse.getInt(stringObjectMap, "orderMode");
            if (i4 == 1) {
                holder.N(2131230983, true);
                holder.N(2131231007, true);
                holder.J(2131230983, "\u53d6\u6d88\u8ba2\u5355");
                holder.J(2131231007, "\u7acb\u5373\u4ed8\u6b3e");
            } else if (i4 == 2) {
                holder.N(2131230983, false);
                holder.N(2131231007, true);
                holder.J(2131231007, "\u7533\u8bf7\u9000\u6b3e");
            } else if (i4 == 3) {
                holder.N(2131230983, true);
                holder.N(2131231007, true);
                holder.J(2131230983, "\u67e5\u770b\u7269\u6d41");
                holder.J(2131231007, "\u786e\u8ba4\u6536\u8d27");
            } else if (i4 == 4) {
                holder.N(2131230983, false);
                holder.N(2131231007, true);
                holder.J(2131231007, "\u5220\u9664\u8ba2\u5355");
            } else if (i4 == 5) {
                holder.N(2131230983, false);
                holder.N(2131231007, true);
                holder.J(2131231007, "\u5220\u9664\u8ba2\u5355");
            } else if (i4 == 6) {
                holder.N(2131230983, false);
                holder.N(2131231007, true);
                holder.J(2131231007, "\u5220\u9664\u8ba2\u5355");
            } else {
                holder.N(2131230983, false);
                holder.N(2131231007, false);
            }
            holder.w(2131230983, new b(holder, stringObjectMap));
            holder.w(2131231007, new c(holder, stringObjectMap));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
            OrderFragment.this.startActivity(new Intent(((BaseFragment) OrderFragment.this).f1665e, OrderDetailActivity.class).putExtra("orderId", JsonParse.getString((Map) OrderFragment.this.f21756l.getItem(position), "id")));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements a.e {
        c() {
        }

        @Override // com.bxkj.student.life.mall.order.a.e
        public void a() {
            OrderFragment.this.b0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d implements s0.e {
        d() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            OrderFragment.this.f21758n = 1;
            OrderFragment.this.Z();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = OrderFragment.this.f21760p / OrderFragment.this.f21759o;
            int i5 = OrderFragment.this.f21758n;
            if (OrderFragment.this.f21760p % OrderFragment.this.f21759o != 0) {
                i4++;
            }
            if (i5 >= i4) {
                OrderFragment.this.f21752h.h();
                OrderFragment.this.D("\u6ca1\u6709\u4e86");
                return;
            }
            OrderFragment.V(OrderFragment.this);
            OrderFragment.this.Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (OrderFragment.this.f21752h != null && OrderFragment.this.f21752h.S()) {
                OrderFragment.this.f21752h.y();
            }
            if (OrderFragment.this.f21752h == null || !OrderFragment.this.f21752h.z()) {
                return;
            }
            OrderFragment.this.f21752h.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            OrderFragment.this.f21760p = JsonParse.getInt(data, "total");
            if (OrderFragment.this.f21758n == 1) {
                OrderFragment.this.f21754j.clear();
            }
            OrderFragment.this.f21754j.addAll(JsonParse.getList(data, "data"));
            OrderFragment.this.f21756l.notifyDataSetChanged();
        }
    }

    static /* synthetic */ int V(OrderFragment orderFragment) {
        int i4 = orderFragment.f21758n;
        orderFragment.f21758n = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        String valueOf = String.valueOf(this.f21755k);
        if (this.f21755k == 0) {
            valueOf = "";
        }
        Http.with(this.f1665e).hideLoadingDialog().setObservable(((g) Http.getApiService(g.class)).v(valueOf, LoginUser.getLoginUser().getOpenId(), this.f21758n, this.f21759o)).setDataListener(new e());
    }

    private void a0() {
        this.f21752h.n1(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f21756l.k(new b());
        this.f21757m.s(new c());
    }

    public void b0() {
        this.f21752h.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        this.f21757m = new com.bxkj.student.life.mall.order.a(this.f1665e);
        if (getArguments().containsKey("index")) {
            this.f21755k = getArguments().getInt("index");
        }
        this.f21753i.setLayoutManager(new LinearLayoutManager(this.f1665e));
        a aVar = new a(this.f1665e, 2131427734, this.f21754j);
        this.f21756l = aVar;
        this.f21753i.setAdapter(aVar);
        this.f21753i.setEmptyView(c(2131232952));
        a0();
        b0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f21752h = (SmartRefreshLayout) c(2131232482);
        this.f21753i = (EmptyRecyclerView) c(2131232481);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131428026;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
