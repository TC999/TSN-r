package com.bxkj.competition.newsletter;

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
public class CompetitionListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f18942k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f18943l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f18944m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private int f18945n = 1;

    /* renamed from: o  reason: collision with root package name */
    private int f18946o = 1;

    /* renamed from: p  reason: collision with root package name */
    private int f18947p = 10;

    /* renamed from: q  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18948q;

    /* renamed from: r  reason: collision with root package name */
    private String f18949r;

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
            CompetitionListActivity.this.f18946o = 1;
            CompetitionListActivity.this.u0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = CompetitionListActivity.this.f18945n / CompetitionListActivity.this.f18947p;
            int i5 = CompetitionListActivity.this.f18946o;
            if (CompetitionListActivity.this.f18945n % CompetitionListActivity.this.f18947p != 0) {
                i4++;
            }
            if (i5 >= i4) {
                CompetitionListActivity.this.f18942k.h();
                CompetitionListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            CompetitionListActivity.n0(CompetitionListActivity.this);
            CompetitionListActivity.this.u0();
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
            final /* synthetic */ ImageView f18952a;

            a(final ImageView val$iv_image) {
                this.f18952a = val$iv_image;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                this.f18952a.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f18952a.getWidth();
                this.f18952a.getHeight();
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
            CompetitionListActivity.this.f18942k.y();
            CompetitionListActivity.this.f18942k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionListActivity.this.f18945n = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (CompetitionListActivity.this.f18946o == 1) {
                CompetitionListActivity.this.f18944m = list;
            } else {
                CompetitionListActivity.this.f18944m.addAll(list);
            }
            CompetitionListActivity.this.f18948q.g(CompetitionListActivity.this.f18944m);
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
            CompetitionListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionListActivity.this).f1656h, NewsLetterListActivity.class).putExtra("competitionId", JsonParse.getString((Map) CompetitionListActivity.this.f18948q.getItem(position), "id")));
        }
    }

    static /* synthetic */ int n0(CompetitionListActivity competitionListActivity) {
        int i4 = competitionListActivity.f18946o;
        competitionListActivity.f18946o = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).d(this.f18949r, this.f18946o, this.f18947p)).setDataListener(new c());
    }

    private void v0() {
        this.f18943l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f18943l.setLayoutAnimation(layoutAnimationController);
        b bVar = new b(this.f1656h, R.layout.item_for_competition_list, this.f18944m);
        this.f18948q = bVar;
        this.f18943l.setAdapter(bVar);
        this.f18943l.setEmptyView(findViewById(R.id.tv_emptyView));
    }

    private void w0() {
        this.f18942k.n1(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f18948q.k(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_pub_recycle;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("competitionId")) {
            this.f18949r = getIntent().getStringExtra("competitionId");
        }
        w0();
        v0();
        this.f18942k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7ade\u8d5b\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f18942k = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.f18943l = (EmptyRecyclerView) findViewById(R.id.recyclerView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
