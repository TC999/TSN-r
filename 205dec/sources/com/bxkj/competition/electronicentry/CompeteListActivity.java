package com.bxkj.competition.electronicentry;

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
import com.bxkj.competition.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;
import s0.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CompeteListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f18913k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f18914l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f18915m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private int f18916n = 1;

    /* renamed from: o  reason: collision with root package name */
    private int f18917o = 1;

    /* renamed from: p  reason: collision with root package name */
    private int f18918p = 10;

    /* renamed from: q  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18919q;

    /* renamed from: r  reason: collision with root package name */
    private String f18920r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements e {
        a() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            CompeteListActivity.this.f18917o = 1;
            CompeteListActivity.this.u0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = CompeteListActivity.this.f18916n / CompeteListActivity.this.f18918p;
            int i5 = CompeteListActivity.this.f18917o;
            if (CompeteListActivity.this.f18916n % CompeteListActivity.this.f18918p != 0) {
                i4++;
            }
            if (i5 >= i4) {
                CompeteListActivity.this.f18913k.h();
                CompeteListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            CompeteListActivity.n0(CompeteListActivity.this);
            CompeteListActivity.this.u0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ImageView f18923a;

            a(final ImageView val$iv_image) {
                this.f18923a = val$iv_image;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                this.f18923a.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f18923a.getWidth();
                this.f18923a.getHeight();
                return true;
            }
        }

        b(Context x02, int x12, List x22) {
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
    public class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            CompeteListActivity.this.f18913k.y();
            CompeteListActivity.this.f18913k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompeteListActivity.this.f18916n = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (CompeteListActivity.this.f18917o == 1) {
                CompeteListActivity.this.f18915m = list;
            } else {
                CompeteListActivity.this.f18915m.addAll(list);
            }
            CompeteListActivity.this.f18919q.g(CompeteListActivity.this.f18915m);
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
            CompeteListActivity.this.startActivity(new Intent(((BaseActivity) CompeteListActivity.this).f1656h, ElectronicEntryActivity.class).putExtra("competitionId", JsonParse.getString((Map) CompeteListActivity.this.f18919q.getItem(position), "id")));
        }
    }

    static /* synthetic */ int n0(CompeteListActivity competeListActivity) {
        int i4 = competeListActivity.f18917o;
        competeListActivity.f18917o = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).d(this.f18920r, this.f18917o, this.f18918p)).setDataListener(new c());
    }

    private void v0() {
        this.f18914l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f18914l.setLayoutAnimation(layoutAnimationController);
        b bVar = new b(this.f1656h, R.layout.item_for_competition_list, this.f18915m);
        this.f18919q = bVar;
        this.f18914l.setAdapter(bVar);
        this.f18914l.setEmptyView(findViewById(R.id.tv_emptyView));
    }

    private void w0() {
        this.f18913k.n1(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f18919q.k(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_pub_recycle;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("competitionId")) {
            this.f18920r = getIntent().getStringExtra("competitionId");
        }
        w0();
        v0();
        this.f18913k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7ade\u8d5b\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f18913k = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.f18914l = (EmptyRecyclerView) findViewById(R.id.recyclerView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
