package com.bxkj.student.life.mall;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.auth.a;
import com.bxkj.base.user.LoginUser;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class GoodsListFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private RecyclerView f21572h;

    /* renamed from: i  reason: collision with root package name */
    private SmartRefreshLayout f21573i;

    /* renamed from: j  reason: collision with root package name */
    private EmptyRecyclerView f21574j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f21575k;

    /* renamed from: l  reason: collision with root package name */
    private FloatingActionButton f21576l;

    /* renamed from: m  reason: collision with root package name */
    private FrameLayout f21577m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f21578n;

    /* renamed from: q  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21581q;

    /* renamed from: s  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21583s;

    /* renamed from: o  reason: collision with root package name */
    private List<Map<String, Object>> f21579o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private List<Map<String, Object>> f21580p = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private int f21582r = 0;

    /* renamed from: t  reason: collision with root package name */
    private int f21584t = 1;

    /* renamed from: u  reason: collision with root package name */
    private int f21585u = 15;

    /* renamed from: v  reason: collision with root package name */
    private int f21586v = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i4 = JsonParse.getInt(data, "data");
            if (i4 > 0) {
                GoodsListFragment.this.f21578n.setVisibility(0);
            } else {
                GoodsListFragment.this.f21578n.setVisibility(8);
            }
            GoodsListFragment.this.f21578n.setText(String.valueOf(i4));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends CommonAdapter<Map<String, Object>> {
        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.q(2131231382, holder.f() == GoodsListFragment.this.f21582r ? GoodsListFragment.this.getResources().getDrawable(2131166073) : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
            a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
            /* renamed from: d */
            public void a(ViewHolder holder, final Map<String, Object> stringObjectMap) {
                holder.J(2131233040, JsonParse.getString(stringObjectMap, "name"));
                holder.t(2131231451, JsonParse.getString(stringObjectMap, "showImg"), 2131558617, 2131558617);
                holder.J(2131233101, "\uffe5" + JsonParse.getMoney(stringObjectMap, "showPrize"));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class b implements AdapterView.OnItemClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ cn.bluemobi.dylan.base.adapter.common.abslistview.a f21591a;

            b(final cn.bluemobi.dylan.base.adapter.common.abslistview.a val$adapter) {
                this.f21591a = val$adapter;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GoodsListFragment.this.startActivity(new Intent(((CommonAdapter) c.this).f1707a, GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString((Map) this.f21591a.getItem(position), "id")));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.life.mall.GoodsListFragment$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0259c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f21593a;

            View$OnClickListenerC0259c(final Map val$stringObjectMap) {
                this.f21593a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                GoodsListFragment.this.startActivity(new Intent(((CommonAdapter) c.this).f1707a, SearchGoodsActivity.class).putExtra("typeId", JsonParse.getString(this.f21593a, "id")).putExtra("typeName", JsonParse.getString(this.f21593a, "typeName")));
            }
        }

        c(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131232905, JsonParse.getString(stringObjectMap, "typeName"));
            List<Map<String, Object>> list = JsonParse.getList(stringObjectMap, "goods");
            GridView gridView = (GridView) holder.h(2131231334);
            a aVar = new a(this.f1707a, 2131427722, list);
            gridView.setAdapter((ListAdapter) aVar);
            gridView.setOnItemClickListener(new b(aVar));
            holder.w(2131232175, new View$OnClickListenerC0259c(stringObjectMap));
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
        public void q(r0.h refreshlayout) {
            GoodsListFragment.this.f21584t = 1;
            if (GoodsListFragment.this.f21581q.getItemCount() == 0) {
                GoodsListFragment.this.i0();
            } else {
                GoodsListFragment.this.h0();
            }
        }

        @Override // s0.b
        public void s(r0.h refreshlayout) {
            int i4 = GoodsListFragment.this.f21586v / GoodsListFragment.this.f21585u;
            int i5 = GoodsListFragment.this.f21584t;
            if (GoodsListFragment.this.f21586v % GoodsListFragment.this.f21585u != 0) {
                i4++;
            }
            if (i5 >= i4) {
                GoodsListFragment.this.f21573i.h();
                GoodsListFragment.this.D("\u6ca1\u6709\u4e86");
                return;
            }
            GoodsListFragment.b0(GoodsListFragment.this);
            GoodsListFragment.this.h0();
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
            GoodsListFragment.this.f21581q.notifyItemChanged(GoodsListFragment.this.f21582r);
            GoodsListFragment.this.f21582r = position;
            GoodsListFragment.this.f21581q.notifyItemChanged(GoodsListFragment.this.f21582r);
            GoodsListFragment.this.f21573i.a0();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            GoodsListFragment.this.startActivity(new Intent(((BaseFragment) GoodsListFragment.this).f1665e, CartActivity.class));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class g implements View.OnClickListener {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements a.g {
            a() {
            }

            @Override // com.bxkj.base.auth.a.g
            public void a() {
                GoodsListFragment.this.startActivity(new Intent(((BaseFragment) GoodsListFragment.this).f1665e, CartActivity.class));
            }
        }

        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v3) {
            new com.bxkj.base.auth.a(((BaseFragment) GoodsListFragment.this).f1665e).i(new a()).b(GoodsListFragment.this.getChildFragmentManager(), 0);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class h implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        h() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class i extends HttpCallBack {
        i() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (GoodsListFragment.this.f21573i != null && GoodsListFragment.this.f21573i.S()) {
                GoodsListFragment.this.f21573i.y();
            }
            if (GoodsListFragment.this.f21573i == null || !GoodsListFragment.this.f21573i.z()) {
                return;
            }
            GoodsListFragment.this.f21573i.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            GoodsListFragment.this.f21580p.clear();
            GoodsListFragment.this.f21580p.addAll(JsonParse.getList(data, "data"));
            GoodsListFragment.this.f21581q.notifyItemRangeInserted(0, GoodsListFragment.this.f21580p.size());
            GoodsListFragment.this.f21573i.a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class j extends HttpCallBack {
        j() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (GoodsListFragment.this.f21573i != null && GoodsListFragment.this.f21573i.S()) {
                GoodsListFragment.this.f21573i.y();
            }
            if (GoodsListFragment.this.f21573i == null || !GoodsListFragment.this.f21573i.z()) {
                return;
            }
            GoodsListFragment.this.f21573i.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            GoodsListFragment.this.f21586v = JsonParse.getInt(data, "total");
            if (GoodsListFragment.this.f21584t == 1) {
                GoodsListFragment.this.f21579o.clear();
            }
            GoodsListFragment.this.f21579o.addAll(JsonParse.getList(data, "data"));
            GoodsListFragment.this.f21583s.notifyDataSetChanged();
        }
    }

    static /* synthetic */ int b0(GoodsListFragment goodsListFragment) {
        int i4 = goodsListFragment.f21584t;
        goodsListFragment.f21584t = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        CommonAdapter<Map<String, Object>> commonAdapter = this.f21581q;
        if (commonAdapter != null) {
            int itemCount = commonAdapter.getItemCount();
            int i4 = this.f21582r;
            if (itemCount <= i4) {
                return;
            }
            Http.with(this.f1665e).hideLoadingDialog().setObservable(((q.g) Http.getApiService(q.g.class)).c(JsonParse.getString(this.f21581q.getItem(i4), "id"), this.f21584t, this.f21585u)).setDataListener(new j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        Http.with(this.f1665e).setObservable(((q.g) Http.getApiService(q.g.class)).a()).setDataListener(new i());
    }

    private void j0() {
        this.f21573i.n1(new d());
    }

    private void k0() {
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1665e, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f21574j.setLayoutAnimation(layoutAnimationController);
        this.f21583s = new c(this.f1665e, 2131427696, this.f21579o);
        this.f21574j.setLayoutManager(new LinearLayoutManager(this.f1665e));
        this.f21574j.setAdapter(this.f21583s);
        this.f21574j.setEmptyView(this.f21575k);
    }

    private void l0() {
        this.f21572h.setLayoutManager(new LinearLayoutManager(this.f1665e));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1665e, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f21572h.setLayoutAnimation(layoutAnimationController);
        this.f21572h.addItemDecoration(new DividerItemDecoration(this.f1665e, 1));
        b bVar = new b(this.f1665e, 2131427776, this.f21580p);
        this.f21581q = bVar;
        this.f21572h.setAdapter(bVar);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f21581q.k(new e());
        this.f21576l.setOnClickListener(new f());
        this.f21577m.setOnClickListener(new g());
        this.f21583s.k(new h());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        l0();
        k0();
        i0();
        j0();
        g0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f21572h = (RecyclerView) c(2131232561);
        this.f21573i = (SmartRefreshLayout) c(2131232483);
        this.f21574j = (EmptyRecyclerView) c(2131232545);
        this.f21575k = (TextView) c(2131232952);
        this.f21576l = (FloatingActionButton) c(2131231286);
        this.f21577m = (FrameLayout) c(2131231305);
        this.f21578n = (TextView) c(2131232914);
    }

    public void g0() {
        if (LoginUser.getLoginUser().isLogin() && LoginUser.getLoginUser().isAuthorizationInMall()) {
            Http.with(this.f1665e).hideLoadingDialog().hideSuccessMessage().hideFailMessage().hideOtherStatusMessage().setObservable(((q.g) Http.getApiService(q.g.class)).B(LoginUser.getLoginUser().getOpenId())).setDataListener(new a());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427628;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
