package com.bxkj.competition;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.competition.signup.my.MyCompetitionListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class HomeListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f18888k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f18889l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f18890m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private int f18891n = 1;

    /* renamed from: o  reason: collision with root package name */
    private int f18892o = 1;

    /* renamed from: p  reason: collision with root package name */
    private int f18893p = 10;

    /* renamed from: q  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18894q;

    /* renamed from: r  reason: collision with root package name */
    private String f18895r;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            HomeListActivity.this.startActivity(new Intent(((BaseActivity) HomeListActivity.this).f1656h, MyCompetitionListActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements s0.e {
        b() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            HomeListActivity.this.f18892o = 1;
            HomeListActivity.this.v0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = HomeListActivity.this.f18891n / HomeListActivity.this.f18893p;
            int i5 = HomeListActivity.this.f18892o;
            if (HomeListActivity.this.f18891n % HomeListActivity.this.f18893p != 0) {
                i4++;
            }
            if (i5 >= i4) {
                HomeListActivity.this.f18888k.h();
                HomeListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            HomeListActivity.o0(HomeListActivity.this);
            HomeListActivity.this.v0();
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
        public class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ImageView f18899a;

            a(final ImageView val$iv_image) {
                this.f18899a = val$iv_image;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                this.f18899a.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f18899a.getWidth();
                this.f18899a.getHeight();
                return true;
            }
        }

        c(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            int i4 = R.id.iv_image;
            ImageView imageView = (ImageView) holder.h(i4);
            imageView.getViewTreeObserver().addOnPreDrawListener(new a(imageView));
            holder.s(i4, JsonParse.getString(stringObjectMap, "majorImg"));
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, "name"));
            holder.J(R.id.tv_location, JsonParse.getString(stringObjectMap, "address"));
            holder.J(R.id.tv_time, JsonParse.getString(stringObjectMap, "startDate"));
            int i5 = R.id.tv_day;
            holder.J(i5, "" + JsonParse.getString(stringObjectMap, "diffCurrDay"));
            holder.N(i5, TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "diffCurrDay")) ^ true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            HomeListActivity.this.f18888k.y();
            HomeListActivity.this.f18888k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            HomeListActivity.this.f18891n = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (HomeListActivity.this.f18892o == 1) {
                HomeListActivity.this.f18890m = list;
            } else {
                HomeListActivity.this.f18890m.addAll(list);
            }
            HomeListActivity.this.f18894q.g(HomeListActivity.this.f18890m);
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
            HomeListActivity.this.startActivity(new Intent(((BaseActivity) HomeListActivity.this).f1656h, MenuActivity.class).putExtra("competitionId", JsonParse.getString((Map) HomeListActivity.this.f18894q.getItem(position), "id")));
        }
    }

    static /* synthetic */ int o0(HomeListActivity homeListActivity) {
        int i4 = homeListActivity.f18892o;
        homeListActivity.f18892o = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).d(this.f18895r, this.f18892o, this.f18893p)).setDataListener(new d());
    }

    private void w0() {
        this.f18889l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f18889l.setLayoutAnimation(layoutAnimationController);
        c cVar = new c(this.f1656h, R.layout.item_for_competition_list, this.f18890m);
        this.f18894q = cVar;
        this.f18889l.setAdapter(cVar);
        this.f18889l.setEmptyView(findViewById(R.id.tv_emptyView));
    }

    private void x0() {
        this.f18888k.n1(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f18894q.k(new e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_pub_recycle;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("competitionId")) {
            this.f18895r = getIntent().getStringExtra("competitionId");
        } else {
            b0(R.mipmap.my_write, new a());
            invalidateOptionsMenu();
        }
        x0();
        w0();
        this.f18888k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7ade\u8d5b\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f18888k = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.f18889l = (EmptyRecyclerView) findViewById(R.id.recyclerView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
