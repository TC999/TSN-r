package com.bxkj.student.life.mall;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.appcompat.widget.SearchView;
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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p635q.MallApiService;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SearchGoodsActivity extends BaseActivity {

    /* renamed from: k */
    private SearchView f18296k;

    /* renamed from: l */
    private SmartRefreshLayout f18297l;

    /* renamed from: m */
    private RecyclerView f18298m;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f18299n;

    /* renamed from: p */
    private String f18301p;

    /* renamed from: t */
    private String f18305t;

    /* renamed from: o */
    private List<Map<String, Object>> f18300o = new ArrayList();

    /* renamed from: q */
    private int f18302q = 1;

    /* renamed from: r */
    private int f18303r = 15;

    /* renamed from: s */
    private int f18304s = 0;

    /* renamed from: com.bxkj.student.life.mall.SearchGoodsActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class RunnableC4979a implements Runnable {
        RunnableC4979a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchGoodsActivity.this.f18296k.clearFocus();
        }
    }

    /* renamed from: com.bxkj.student.life.mall.SearchGoodsActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4980b extends CommonAdapter<Map<String, Object>> {
        C4980b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.m57850t(2131231451, JsonParse.getString(stringObjectMap, "showImg"), 2131558617, 2131558617);
            holder.m57874J(2131233101, "￥" + JsonParse.getMoney(stringObjectMap, "showPrize"));
            holder.m57874J(C4215R.C4219id.tv_stock, "库存：" + JsonParse.getString(stringObjectMap, "stock"));
            holder.m57874J(2131233051, "销量：" + JsonParse.getString(stringObjectMap, "saleNum"));
        }
    }

    /* renamed from: com.bxkj.student.life.mall.SearchGoodsActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4981c implements SearchView.OnQueryTextListener {
        C4981c() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String newText) {
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String query) {
            SearchGoodsActivity.this.f18305t = query;
            SearchGoodsActivity.this.f18297l.mo2052a0();
            return false;
        }
    }

    /* renamed from: com.bxkj.student.life.mall.SearchGoodsActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4982d implements OnItemClickListener {
        C4982d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            SearchGoodsActivity.this.startActivity(new Intent(((BaseActivity) SearchGoodsActivity.this).f1669h, GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString((Map) SearchGoodsActivity.this.f18299n.getItem(position), "id")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.SearchGoodsActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4983e implements OnRefreshLoadmoreListener {
        C4983e() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            SearchGoodsActivity.this.f18302q = 1;
            SearchGoodsActivity.this.m40894v0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = SearchGoodsActivity.this.f18304s / SearchGoodsActivity.this.f18303r;
            int i2 = SearchGoodsActivity.this.f18302q;
            if (SearchGoodsActivity.this.f18304s % SearchGoodsActivity.this.f18303r != 0) {
                i++;
            }
            if (i2 >= i) {
                SearchGoodsActivity.this.f18297l.mo2041g();
                SearchGoodsActivity.this.m57919h0("没有了");
                return;
            }
            SearchGoodsActivity.m40897s0(SearchGoodsActivity.this);
            SearchGoodsActivity.this.m40894v0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.mall.SearchGoodsActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4984f extends HttpCallBack {
        C4984f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (SearchGoodsActivity.this.f18297l != null && SearchGoodsActivity.this.f18297l.mo2061S()) {
                SearchGoodsActivity.this.f18297l.mo2078B();
            }
            if (SearchGoodsActivity.this.f18297l == null || !SearchGoodsActivity.this.f18297l.mo2015z()) {
                return;
            }
            SearchGoodsActivity.this.f18297l.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SearchGoodsActivity.this.f18304s = JsonParse.getInt(data, "total");
            if (SearchGoodsActivity.this.f18302q == 1) {
                SearchGoodsActivity.this.f18300o.clear();
            }
            SearchGoodsActivity.this.f18300o.addAll(JsonParse.getList(data, "data"));
            SearchGoodsActivity.this.f18299n.notifyDataSetChanged();
        }
    }

    /* renamed from: s0 */
    static /* synthetic */ int m40897s0(SearchGoodsActivity searchGoodsActivity) {
        int i = searchGoodsActivity.f18302q;
        searchGoodsActivity.f18302q = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public void m40894v0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((MallApiService) Http.getApiService(MallApiService.class)).m2229s(this.f18301p, this.f18305t, this.f18302q, this.f18303r)).setDataListener(new C4984f());
    }

    /* renamed from: w0 */
    private void m40893w0() {
        this.f18297l.mo2019v(new C4983e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f18296k.setOnQueryTextListener(new C4981c());
        this.f18299n.m57834k(new C4982d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_search_goods;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f18298m.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f18298m.setLayoutAnimation(layoutAnimationController);
        this.f18298m.addItemDecoration(new DividerItemDecoration(this.f1669h, 1));
        C4980b c4980b = new C4980b(this.f1669h, C4215R.C4221layout.item_for_goods_list, this.f18300o);
        this.f18299n = c4980b;
        this.f18298m.setAdapter(c4980b);
        this.f18297l.mo2052a0();
        m40893w0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("全部商品");
        if (getIntent().hasExtra("typeName")) {
            setTitle(getIntent().getStringExtra("typeName"));
        }
        if (getIntent().hasExtra("typeId")) {
            this.f18301p = getIntent().getStringExtra("typeId");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f18297l = (SmartRefreshLayout) findViewById(2131232483);
        this.f18298m = (RecyclerView) findViewById(C4215R.C4219id.rv_goods_list);
        SearchView searchView = (SearchView) findViewById(C4215R.C4219id.search);
        this.f18296k = searchView;
        searchView.post(new RunnableC4979a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
