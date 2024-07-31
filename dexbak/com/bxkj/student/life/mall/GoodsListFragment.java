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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.auth.AuthorizationUtils;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p635q.MallApiService;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class GoodsListFragment extends BaseFragment {

    /* renamed from: h */
    private RecyclerView f18257h;

    /* renamed from: i */
    private SmartRefreshLayout f18258i;

    /* renamed from: j */
    private EmptyRecyclerView f18259j;

    /* renamed from: k */
    private TextView f18260k;

    /* renamed from: l */
    private FloatingActionButton f18261l;

    /* renamed from: m */
    private FrameLayout f18262m;

    /* renamed from: n */
    private TextView f18263n;

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f18266q;

    /* renamed from: s */
    private CommonAdapter<Map<String, Object>> f18268s;

    /* renamed from: o */
    private List<Map<String, Object>> f18264o = new ArrayList();

    /* renamed from: p */
    private List<Map<String, Object>> f18265p = new ArrayList();

    /* renamed from: r */
    private int f18267r = 0;

    /* renamed from: t */
    private int f18269t = 1;

    /* renamed from: u */
    private int f18270u = 15;

    /* renamed from: v */
    private int f18271v = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsListFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4960a extends HttpCallBack {
        C4960a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            int i = JsonParse.getInt(data, "data");
            if (i > 0) {
                GoodsListFragment.this.f18263n.setVisibility(0);
            } else {
                GoodsListFragment.this.f18263n.setVisibility(8);
            }
            GoodsListFragment.this.f18263n.setText(String.valueOf(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsListFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4961b extends CommonAdapter<Map<String, Object>> {
        C4961b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.m57853q(C4215R.C4219id.f15999iv, holder.m57864f() == GoodsListFragment.this.f18267r ? GoodsListFragment.this.getResources().getDrawable(2131166073) : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsListFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4962c extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.mall.GoodsListFragment$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C4963a extends cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter<Map<String, Object>> {
            C4963a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
            /* renamed from: d */
            public void mo40086a(ViewHolder holder, final Map<String, Object> stringObjectMap) {
                holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
                holder.m57850t(2131231451, JsonParse.getString(stringObjectMap, "showImg"), 2131558617, 2131558617);
                holder.m57874J(2131233101, "￥" + JsonParse.getMoney(stringObjectMap, "showPrize"));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.mall.GoodsListFragment$c$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C4964b implements AdapterView.OnItemClickListener {

            /* renamed from: a */
            final /* synthetic */ cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter f18276a;

            C4964b(final cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter val$adapter) {
                this.f18276a = val$adapter;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                GoodsListFragment.this.startActivity(new Intent(((CommonAdapter) C4962c.this).f1721a, GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString((Map) this.f18276a.getItem(position), "id")));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.mall.GoodsListFragment$c$c */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4965c implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f18278a;

            View$OnClickListenerC4965c(final Map val$stringObjectMap) {
                this.f18278a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                GoodsListFragment.this.startActivity(new Intent(((CommonAdapter) C4962c.this).f1721a, SearchGoodsActivity.class).putExtra("typeId", JsonParse.getString(this.f18278a, "id")).putExtra("typeName", JsonParse.getString(this.f18278a, "typeName")));
            }
        }

        C4962c(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv_classify_name, JsonParse.getString(stringObjectMap, "typeName"));
            List<Map<String, Object>> list = JsonParse.getList(stringObjectMap, "goods");
            GridView gridView = (GridView) holder.m57862h(C4215R.C4219id.gv_goods);
            C4963a c4963a = new C4963a(this.f1721a, C4215R.C4221layout.item_for_mall_home_goods, list);
            gridView.setAdapter((ListAdapter) c4963a);
            gridView.setOnItemClickListener(new C4964b(c4963a));
            holder.m57847w(C4215R.C4219id.ll_classify2, new View$OnClickListenerC4965c(stringObjectMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsListFragment$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4966d implements OnRefreshLoadmoreListener {
        C4966d() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            GoodsListFragment.this.f18269t = 1;
            if (GoodsListFragment.this.f18266q.getItemCount() == 0) {
                GoodsListFragment.this.m40927i0();
            } else {
                GoodsListFragment.this.m40928h0();
            }
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = GoodsListFragment.this.f18271v / GoodsListFragment.this.f18270u;
            int i2 = GoodsListFragment.this.f18269t;
            if (GoodsListFragment.this.f18271v % GoodsListFragment.this.f18270u != 0) {
                i++;
            }
            if (i2 >= i) {
                GoodsListFragment.this.f18258i.mo2041g();
                GoodsListFragment.this.m57918D("没有了");
                return;
            }
            GoodsListFragment.m40934b0(GoodsListFragment.this);
            GoodsListFragment.this.m40928h0();
        }
    }

    /* renamed from: com.bxkj.student.life.mall.GoodsListFragment$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4967e implements OnItemClickListener {
        C4967e() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            GoodsListFragment.this.f18266q.notifyItemChanged(GoodsListFragment.this.f18267r);
            GoodsListFragment.this.f18267r = position;
            GoodsListFragment.this.f18266q.notifyItemChanged(GoodsListFragment.this.f18267r);
            GoodsListFragment.this.f18258i.mo2052a0();
        }
    }

    /* renamed from: com.bxkj.student.life.mall.GoodsListFragment$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class View$OnClickListenerC4968f implements View.OnClickListener {
        View$OnClickListenerC4968f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            GoodsListFragment.this.startActivity(new Intent(((BaseFragment) GoodsListFragment.this).f1678e, CartActivity.class));
        }
    }

    /* renamed from: com.bxkj.student.life.mall.GoodsListFragment$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class View$OnClickListenerC4969g implements View.OnClickListener {

        /* renamed from: com.bxkj.student.life.mall.GoodsListFragment$g$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4970a implements AuthorizationUtils.InterfaceC3827g {
            C4970a() {
            }

            @Override // com.bxkj.base.auth.AuthorizationUtils.InterfaceC3827g
            /* renamed from: a */
            public void mo40697a() {
                GoodsListFragment.this.startActivity(new Intent(((BaseFragment) GoodsListFragment.this).f1678e, CartActivity.class));
            }
        }

        View$OnClickListenerC4969g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            new AuthorizationUtils(((BaseFragment) GoodsListFragment.this).f1678e).m44322i(new C4970a()).m44329b(GoodsListFragment.this.getChildFragmentManager(), 0);
        }
    }

    /* renamed from: com.bxkj.student.life.mall.GoodsListFragment$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4971h implements OnItemClickListener {
        C4971h() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsListFragment$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4972i extends HttpCallBack {
        C4972i() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (GoodsListFragment.this.f18258i != null && GoodsListFragment.this.f18258i.mo2061S()) {
                GoodsListFragment.this.f18258i.mo2078B();
            }
            if (GoodsListFragment.this.f18258i == null || !GoodsListFragment.this.f18258i.mo2015z()) {
                return;
            }
            GoodsListFragment.this.f18258i.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            GoodsListFragment.this.f18265p.clear();
            GoodsListFragment.this.f18265p.addAll(JsonParse.getList(data, "data"));
            GoodsListFragment.this.f18266q.notifyItemRangeInserted(0, GoodsListFragment.this.f18265p.size());
            GoodsListFragment.this.f18258i.mo2052a0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.GoodsListFragment$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4973j extends HttpCallBack {
        C4973j() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (GoodsListFragment.this.f18258i != null && GoodsListFragment.this.f18258i.mo2061S()) {
                GoodsListFragment.this.f18258i.mo2078B();
            }
            if (GoodsListFragment.this.f18258i == null || !GoodsListFragment.this.f18258i.mo2015z()) {
                return;
            }
            GoodsListFragment.this.f18258i.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            GoodsListFragment.this.f18271v = JsonParse.getInt(data, "total");
            if (GoodsListFragment.this.f18269t == 1) {
                GoodsListFragment.this.f18264o.clear();
            }
            GoodsListFragment.this.f18264o.addAll(JsonParse.getList(data, "data"));
            GoodsListFragment.this.f18268s.notifyDataSetChanged();
        }
    }

    /* renamed from: b0 */
    static /* synthetic */ int m40934b0(GoodsListFragment goodsListFragment) {
        int i = goodsListFragment.f18269t;
        goodsListFragment.f18269t = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h0 */
    public void m40928h0() {
        CommonAdapter<Map<String, Object>> commonAdapter = this.f18266q;
        if (commonAdapter != null) {
            int itemCount = commonAdapter.getItemCount();
            int i = this.f18267r;
            if (itemCount <= i) {
                return;
            }
            Http.with(this.f1678e).hideLoadingDialog().setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2245c(JsonParse.getString(this.f18266q.getItem(i), "id"), this.f18269t, this.f18270u)).setDataListener(new C4973j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public void m40927i0() {
        Http.with(this.f1678e).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2247a()).setDataListener(new C4972i());
    }

    /* renamed from: j0 */
    private void m40926j0() {
        this.f18258i.mo2019v(new C4966d());
    }

    /* renamed from: k0 */
    private void m40925k0() {
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1678e, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f18259j.setLayoutAnimation(layoutAnimationController);
        this.f18268s = new C4962c(this.f1678e, C4215R.C4221layout.item_for_goods_classify2, this.f18264o);
        this.f18259j.setLayoutManager(new LinearLayoutManager(this.f1678e));
        this.f18259j.setAdapter(this.f18268s);
        this.f18259j.setEmptyView(this.f18260k);
    }

    /* renamed from: l0 */
    private void m40924l0() {
        this.f18257h.setLayoutManager(new LinearLayoutManager(this.f1678e));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1678e, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f18257h.setLayoutAnimation(layoutAnimationController);
        this.f18257h.addItemDecoration(new DividerItemDecoration(this.f1678e, 1));
        C4961b c4961b = new C4961b(this.f1678e, C4215R.C4221layout.item_for_video_type_list, this.f18265p);
        this.f18266q = c4961b;
        this.f18257h.setAdapter(c4961b);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
        this.f18266q.m57834k(new C4967e());
        this.f18261l.setOnClickListener(new View$OnClickListenerC4968f());
        this.f18262m.setOnClickListener(new View$OnClickListenerC4969g());
        this.f18268s.m57834k(new C4971h());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    protected void mo39444e() {
        m40924l0();
        m40925k0();
        m40927i0();
        m40926j0();
        m40929g0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f18257h = (RecyclerView) m57916c(C4215R.C4219id.rv_type);
        this.f18258i = (SmartRefreshLayout) m57916c(2131232483);
        this.f18259j = (EmptyRecyclerView) m57916c(C4215R.C4219id.rv_goods_list);
        this.f18260k = (TextView) m57916c(2131232952);
        this.f18261l = (FloatingActionButton) m57916c(C4215R.C4219id.fab);
        this.f18262m = (FrameLayout) m57916c(C4215R.C4219id.fl_cart);
        this.f18263n = (TextView) m57916c(2131232914);
    }

    /* renamed from: g0 */
    public void m40929g0() {
        if (LoginUser.getLoginUser().isLogin() && LoginUser.getLoginUser().isAuthorizationInMall()) {
            Http.with(this.f1678e).hideLoadingDialog().hideSuccessMessage().hideFailMessage().hideOtherStatusMessage().setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2251B(LoginUser.getLoginUser().getOpenId())).setDataListener(new C4960a());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_goods_list;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
