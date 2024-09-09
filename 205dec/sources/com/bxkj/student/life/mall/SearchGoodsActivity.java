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
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import q.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SearchGoodsActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SearchView f21611k;

    /* renamed from: l  reason: collision with root package name */
    private SmartRefreshLayout f21612l;

    /* renamed from: m  reason: collision with root package name */
    private RecyclerView f21613m;

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21614n;

    /* renamed from: p  reason: collision with root package name */
    private String f21616p;

    /* renamed from: t  reason: collision with root package name */
    private String f21620t;

    /* renamed from: o  reason: collision with root package name */
    private List<Map<String, Object>> f21615o = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private int f21617q = 1;

    /* renamed from: r  reason: collision with root package name */
    private int f21618r = 15;

    /* renamed from: s  reason: collision with root package name */
    private int f21619s = 0;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchGoodsActivity.this.f21611k.clearFocus();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends CommonAdapter<Map<String, Object>> {
        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.t(2131231451, JsonParse.getString(stringObjectMap, "showImg"), 2131558617, 2131558617);
            holder.J(2131233101, "\uffe5" + JsonParse.getMoney(stringObjectMap, "showPrize"));
            holder.J(2131233185, "\u5e93\u5b58\uff1a" + JsonParse.getString(stringObjectMap, "stock"));
            holder.J(2131233051, "\u9500\u91cf\uff1a" + JsonParse.getString(stringObjectMap, "saleNum"));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements SearchView.OnQueryTextListener {
        c() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String newText) {
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String query) {
            SearchGoodsActivity.this.f21620t = query;
            SearchGoodsActivity.this.f21612l.a0();
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
            SearchGoodsActivity.this.startActivity(new Intent(((BaseActivity) SearchGoodsActivity.this).f1656h, GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString((Map) SearchGoodsActivity.this.f21614n.getItem(position), "id")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e implements s0.e {
        e() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            SearchGoodsActivity.this.f21617q = 1;
            SearchGoodsActivity.this.v0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = SearchGoodsActivity.this.f21619s / SearchGoodsActivity.this.f21618r;
            int i5 = SearchGoodsActivity.this.f21617q;
            if (SearchGoodsActivity.this.f21619s % SearchGoodsActivity.this.f21618r != 0) {
                i4++;
            }
            if (i5 >= i4) {
                SearchGoodsActivity.this.f21612l.h();
                SearchGoodsActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            SearchGoodsActivity.s0(SearchGoodsActivity.this);
            SearchGoodsActivity.this.v0();
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

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (SearchGoodsActivity.this.f21612l != null && SearchGoodsActivity.this.f21612l.S()) {
                SearchGoodsActivity.this.f21612l.y();
            }
            if (SearchGoodsActivity.this.f21612l == null || !SearchGoodsActivity.this.f21612l.z()) {
                return;
            }
            SearchGoodsActivity.this.f21612l.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SearchGoodsActivity.this.f21619s = JsonParse.getInt(data, "total");
            if (SearchGoodsActivity.this.f21617q == 1) {
                SearchGoodsActivity.this.f21615o.clear();
            }
            SearchGoodsActivity.this.f21615o.addAll(JsonParse.getList(data, "data"));
            SearchGoodsActivity.this.f21614n.notifyDataSetChanged();
        }
    }

    static /* synthetic */ int s0(SearchGoodsActivity searchGoodsActivity) {
        int i4 = searchGoodsActivity.f21617q;
        searchGoodsActivity.f21617q = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((g) Http.getApiService(g.class)).s(this.f21616p, this.f21620t, this.f21617q, this.f21618r)).setDataListener(new f());
    }

    private void w0() {
        this.f21612l.n1(new e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21611k.setOnQueryTextListener(new c());
        this.f21614n.k(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427486;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f21613m.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1656h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f21613m.setLayoutAnimation(layoutAnimationController);
        this.f21613m.addItemDecoration(new DividerItemDecoration(this.f1656h, 1));
        b bVar = new b(this.f1656h, 2131427698, this.f21615o);
        this.f21614n = bVar;
        this.f21613m.setAdapter(bVar);
        this.f21612l.a0();
        w0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5168\u90e8\u5546\u54c1");
        if (getIntent().hasExtra("typeName")) {
            setTitle(getIntent().getStringExtra("typeName"));
        }
        if (getIntent().hasExtra("typeId")) {
            this.f21616p = getIntent().getStringExtra("typeId");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21612l = (SmartRefreshLayout) findViewById(2131232483);
        this.f21613m = (RecyclerView) findViewById(2131232545);
        SearchView searchView = (SearchView) findViewById(2131232589);
        this.f21611k = searchView;
        searchView.post(new a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
