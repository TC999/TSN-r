package com.bxkj.student.life.mall.collect;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.life.mall.GoodsDetailActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p635q.MallApiService;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CollectGoodsFragment extends BaseFragment {

    /* renamed from: h */
    private SearchView f18370h;

    /* renamed from: i */
    private SmartRefreshLayout f18371i;

    /* renamed from: j */
    private EmptyRecyclerView f18372j;

    /* renamed from: k */
    private CommonAdapter<Map<String, Object>> f18373k;

    /* renamed from: m */
    private String f18375m;

    /* renamed from: q */
    private String f18379q;

    /* renamed from: l */
    private List<Map<String, Object>> f18374l = new ArrayList();

    /* renamed from: n */
    private int f18376n = 1;

    /* renamed from: o */
    private int f18377o = 15;

    /* renamed from: p */
    private int f18378p = 0;

    /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5001a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsFragment$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC5002a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f18381a;

            /* renamed from: b */
            final /* synthetic */ ViewHolder f18382b;

            /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsFragment$a$a$a */
            /* loaded from: E:\fuckcool\tsn\5141176.dex */
            class C5003a implements iOSTwoButtonDialog.RightButtonOnClick {

                /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsFragment$a$a$a$a */
                /* loaded from: E:\fuckcool\tsn\5141176.dex */
                class C5004a extends HttpCallBack {
                    C5004a() {
                    }

                    @Override // cn.bluemobi.dylan.http.HttpResponse
                    public void netOnSuccess(Map<String, Object> data) {
                        CollectGoodsFragment.this.f18374l.remove(View$OnClickListenerC5002a.this.f18381a);
                        CollectGoodsFragment.this.f18373k.notifyItemRemoved(View$OnClickListenerC5002a.this.f18382b.m57864f());
                    }
                }

                C5003a() {
                }

                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public void buttonRightOnClick() {
                    Http.with(((CommonAdapter) C5001a.this).f1721a).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2230r(JsonParse.getString(View$OnClickListenerC5002a.this.f18381a, "commId"), LoginUser.getLoginUser().getOpenId())).setDataListener(new C5004a());
                }
            }

            View$OnClickListenerC5002a(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f18381a = val$stringObjectMap;
                this.f18382b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                new iOSTwoButtonDialog(((CommonAdapter) C5001a.this).f1721a).setMessage("确定要删除吗？").setRightButtonOnClickListener(new C5003a()).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsFragment$a$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC5005b implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f18386a;

            View$OnClickListenerC5005b(final Map val$stringObjectMap) {
                this.f18386a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CollectGoodsFragment.this.startActivity(new Intent(((CommonAdapter) C5001a.this).f1721a, GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString(this.f18386a, "commId")));
            }
        }

        C5001a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: p */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.m57850t(2131231451, JsonParse.getString(stringObjectMap, "showImg"), 2131558617, 2131558617);
            holder.m57874J(2131233101, "￥" + JsonParse.getString(stringObjectMap, "showPrize"));
            holder.m57847w(C4215R.C4219id.bt_delete, new View$OnClickListenerC5002a(stringObjectMap, holder));
            holder.m57847w(2131232182, new View$OnClickListenerC5005b(stringObjectMap));
        }
    }

    /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5006b implements SearchView.OnQueryTextListener {
        C5006b() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String newText) {
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String query) {
            CollectGoodsFragment.this.f18379q = query;
            CollectGoodsFragment.this.f18371i.mo2052a0();
            return false;
        }
    }

    /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5007c implements OnItemClickListener {
        C5007c() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            CollectGoodsFragment.this.startActivity(new Intent(((BaseFragment) CollectGoodsFragment.this).f1678e, GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString((Map) CollectGoodsFragment.this.f18373k.getItem(position), "commId")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsFragment$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5008d implements OnRefreshLoadmoreListener {
        C5008d() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            CollectGoodsFragment.this.f18376n = 1;
            CollectGoodsFragment.this.m40833b0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = CollectGoodsFragment.this.f18378p / CollectGoodsFragment.this.f18377o;
            int i2 = CollectGoodsFragment.this.f18376n;
            if (CollectGoodsFragment.this.f18378p % CollectGoodsFragment.this.f18377o != 0) {
                i++;
            }
            if (i2 >= i) {
                CollectGoodsFragment.this.f18371i.mo2041g();
                CollectGoodsFragment.this.m57918D("没有了");
                return;
            }
            CollectGoodsFragment.m40843R(CollectGoodsFragment.this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsFragment$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5009e extends HttpCallBack {
        C5009e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (CollectGoodsFragment.this.f18371i != null && CollectGoodsFragment.this.f18371i.mo2061S()) {
                CollectGoodsFragment.this.f18371i.mo2078B();
            }
            if (CollectGoodsFragment.this.f18371i == null || !CollectGoodsFragment.this.f18371i.mo2015z()) {
                return;
            }
            CollectGoodsFragment.this.f18371i.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CollectGoodsFragment.this.f18378p = JsonParse.getInt(data, "total");
            if (CollectGoodsFragment.this.f18376n == 1) {
                CollectGoodsFragment.this.f18374l.clear();
            }
            CollectGoodsFragment.this.f18374l.addAll(JsonParse.getList(data, "data"));
            CollectGoodsFragment.this.f18373k.notifyDataSetChanged();
        }
    }

    /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsFragment$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5010f implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsFragment$f$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5011a extends HttpCallBack {
            C5011a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                CollectGoodsFragment.this.f18373k.notifyItemRangeRemoved(0, CollectGoodsFragment.this.f18374l.size());
                CollectGoodsFragment.this.f18374l.clear();
            }
        }

        C5010f() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(((BaseFragment) CollectGoodsFragment.this).f1678e).setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2224x(LoginUser.getLoginUser().getOpenId())).setDataListener(new C5011a());
        }
    }

    /* renamed from: R */
    static /* synthetic */ int m40843R(CollectGoodsFragment collectGoodsFragment) {
        int i = collectGoodsFragment.f18376n;
        collectGoodsFragment.f18376n = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0 */
    public void m40833b0() {
        Http.with(this.f1678e).hideLoadingDialog().setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2250C(this.f18379q, LoginUser.getLoginUser().getOpenId(), this.f18376n, this.f18377o)).setDataListener(new C5009e());
    }

    /* renamed from: c0 */
    private void m40832c0() {
        this.f18371i.mo2019v(new C5008d());
    }

    /* renamed from: a0 */
    public void m40834a0() {
        new iOSTwoButtonDialog(this.f1678e).setMessage("确定要清空所有商品吗？").setRightButtonOnClickListener(new C5010f()).show();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
        this.f18370h.setOnQueryTextListener(new C5006b());
        this.f18373k.m57834k(new C5007c());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    public void mo39444e() {
        this.f18372j.setLayoutManager(new LinearLayoutManager(this.f1678e));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1678e, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f18372j.setLayoutAnimation(layoutAnimationController);
        this.f18372j.addItemDecoration(new DividerItemDecoration(this.f1678e, 1));
        C5001a c5001a = new C5001a(this.f1678e, C4215R.C4221layout.item_for_collect_goods_list, this.f18374l);
        this.f18373k = c5001a;
        this.f18372j.setAdapter(c5001a);
        this.f18372j.setEmptyView(m57916c(2131232952));
        this.f18371i.mo2052a0();
        m40832c0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f18371i = (SmartRefreshLayout) m57916c(2131232483);
        this.f18372j = (EmptyRecyclerView) m57916c(C4215R.C4219id.rv_goods_list);
        this.f18370h = (SearchView) m57916c(C4215R.C4219id.search);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.ac_search_goods;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
