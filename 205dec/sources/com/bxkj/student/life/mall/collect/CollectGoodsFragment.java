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
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.life.mall.GoodsDetailActivity;
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
public class CollectGoodsFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private SearchView f21685h;

    /* renamed from: i  reason: collision with root package name */
    private SmartRefreshLayout f21686i;

    /* renamed from: j  reason: collision with root package name */
    private EmptyRecyclerView f21687j;

    /* renamed from: k  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21688k;

    /* renamed from: m  reason: collision with root package name */
    private String f21690m;

    /* renamed from: q  reason: collision with root package name */
    private String f21694q;

    /* renamed from: l  reason: collision with root package name */
    private List<Map<String, Object>> f21689l = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private int f21691n = 1;

    /* renamed from: o  reason: collision with root package name */
    private int f21692o = 15;

    /* renamed from: p  reason: collision with root package name */
    private int f21693p = 0;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsFragment$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0264a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f21696a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewHolder f21697b;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsFragment$a$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            class C0265a implements iOSTwoButtonDialog.RightButtonOnClick {

                /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
                /* renamed from: com.bxkj.student.life.mall.collect.CollectGoodsFragment$a$a$a$a  reason: collision with other inner class name */
                /* loaded from: E:\TSN-r\205dec\5141176.dex */
                class C0266a extends HttpCallBack {
                    C0266a() {
                    }

                    @Override // cn.bluemobi.dylan.http.HttpResponse
                    public void netOnSuccess(Map<String, Object> data) {
                        CollectGoodsFragment.this.f21689l.remove(View$OnClickListenerC0264a.this.f21696a);
                        CollectGoodsFragment.this.f21688k.notifyItemRemoved(View$OnClickListenerC0264a.this.f21697b.f());
                    }
                }

                C0265a() {
                }

                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public void buttonRightOnClick() {
                    Http.with(((CommonAdapter) a.this).f1707a).setObservable(((g) Http.getApiService(g.class)).r(JsonParse.getString(View$OnClickListenerC0264a.this.f21696a, "commId"), LoginUser.getLoginUser().getOpenId())).setDataListener(new C0266a());
                }
            }

            View$OnClickListenerC0264a(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f21696a = val$stringObjectMap;
                this.f21697b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                new iOSTwoButtonDialog(((CommonAdapter) a.this).f1707a).setMessage("\u786e\u5b9a\u8981\u5220\u9664\u5417\uff1f").setRightButtonOnClickListener(new C0265a()).show();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f21701a;

            b(final Map val$stringObjectMap) {
                this.f21701a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                CollectGoodsFragment.this.startActivity(new Intent(((CommonAdapter) a.this).f1707a, GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString(this.f21701a, "commId")));
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: p */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.t(2131231451, JsonParse.getString(stringObjectMap, "showImg"), 2131558617, 2131558617);
            holder.J(2131233101, "\uffe5" + JsonParse.getString(stringObjectMap, "showPrize"));
            holder.w(2131230971, new View$OnClickListenerC0264a(stringObjectMap, holder));
            holder.w(2131232182, new b(stringObjectMap));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements SearchView.OnQueryTextListener {
        b() {
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextChange(String newText) {
            return false;
        }

        @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
        public boolean onQueryTextSubmit(String query) {
            CollectGoodsFragment.this.f21694q = query;
            CollectGoodsFragment.this.f21686i.a0();
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        c() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
            CollectGoodsFragment.this.startActivity(new Intent(((BaseFragment) CollectGoodsFragment.this).f1665e, GoodsDetailActivity.class).putExtra("goodsId", JsonParse.getString((Map) CollectGoodsFragment.this.f21688k.getItem(position), "commId")));
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
            CollectGoodsFragment.this.f21691n = 1;
            CollectGoodsFragment.this.b0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = CollectGoodsFragment.this.f21693p / CollectGoodsFragment.this.f21692o;
            int i5 = CollectGoodsFragment.this.f21691n;
            if (CollectGoodsFragment.this.f21693p % CollectGoodsFragment.this.f21692o != 0) {
                i4++;
            }
            if (i5 >= i4) {
                CollectGoodsFragment.this.f21686i.h();
                CollectGoodsFragment.this.D("\u6ca1\u6709\u4e86");
                return;
            }
            CollectGoodsFragment.R(CollectGoodsFragment.this);
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
            if (CollectGoodsFragment.this.f21686i != null && CollectGoodsFragment.this.f21686i.S()) {
                CollectGoodsFragment.this.f21686i.y();
            }
            if (CollectGoodsFragment.this.f21686i == null || !CollectGoodsFragment.this.f21686i.z()) {
                return;
            }
            CollectGoodsFragment.this.f21686i.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CollectGoodsFragment.this.f21693p = JsonParse.getInt(data, "total");
            if (CollectGoodsFragment.this.f21691n == 1) {
                CollectGoodsFragment.this.f21689l.clear();
            }
            CollectGoodsFragment.this.f21689l.addAll(JsonParse.getList(data, "data"));
            CollectGoodsFragment.this.f21688k.notifyDataSetChanged();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class f implements iOSTwoButtonDialog.RightButtonOnClick {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                CollectGoodsFragment.this.f21688k.notifyItemRangeRemoved(0, CollectGoodsFragment.this.f21689l.size());
                CollectGoodsFragment.this.f21689l.clear();
            }
        }

        f() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(((BaseFragment) CollectGoodsFragment.this).f1665e).setObservable(((g) Http.getApiService(g.class)).x(LoginUser.getLoginUser().getOpenId())).setDataListener(new a());
        }
    }

    static /* synthetic */ int R(CollectGoodsFragment collectGoodsFragment) {
        int i4 = collectGoodsFragment.f21691n;
        collectGoodsFragment.f21691n = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        Http.with(this.f1665e).hideLoadingDialog().setObservable(((g) Http.getApiService(g.class)).C(this.f21694q, LoginUser.getLoginUser().getOpenId(), this.f21691n, this.f21692o)).setDataListener(new e());
    }

    private void c0() {
        this.f21686i.n1(new d());
    }

    public void a0() {
        new iOSTwoButtonDialog(this.f1665e).setMessage("\u786e\u5b9a\u8981\u6e05\u7a7a\u6240\u6709\u5546\u54c1\u5417\uff1f").setRightButtonOnClickListener(new f()).show();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f21685h.setOnQueryTextListener(new b());
        this.f21688k.k(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void e() {
        this.f21687j.setLayoutManager(new LinearLayoutManager(this.f1665e));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1665e, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f21687j.setLayoutAnimation(layoutAnimationController);
        this.f21687j.addItemDecoration(new DividerItemDecoration(this.f1665e, 1));
        a aVar = new a(this.f1665e, 2131427681, this.f21689l);
        this.f21688k = aVar;
        this.f21687j.setAdapter(aVar);
        this.f21687j.setEmptyView(c(2131232952));
        this.f21686i.a0();
        c0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f21686i = (SmartRefreshLayout) c(2131232483);
        this.f21687j = (EmptyRecyclerView) c(2131232545);
        this.f21685h = (SearchView) c(2131232589);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427486;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
