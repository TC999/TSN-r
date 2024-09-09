package com.bxkj.competition.signup;

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
public class CompetitionListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f19130k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f19131l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f19132m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private int f19133n = 1;

    /* renamed from: o  reason: collision with root package name */
    private int f19134o = 1;

    /* renamed from: p  reason: collision with root package name */
    private int f19135p = 10;

    /* renamed from: q  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19136q;

    /* renamed from: r  reason: collision with root package name */
    private String f19137r;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            CompetitionListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionListActivity.this).f1656h, MyCompetitionListActivity.class));
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
            CompetitionListActivity.this.f19134o = 1;
            CompetitionListActivity.this.w0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = CompetitionListActivity.this.f19133n / CompetitionListActivity.this.f19135p;
            int i5 = CompetitionListActivity.this.f19134o;
            if (CompetitionListActivity.this.f19133n % CompetitionListActivity.this.f19135p != 0) {
                i4++;
            }
            if (i5 >= i4) {
                CompetitionListActivity.this.f19130k.h();
                CompetitionListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            CompetitionListActivity.o0(CompetitionListActivity.this);
            CompetitionListActivity.this.w0();
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
            final /* synthetic */ ImageView f19141a;

            a(final ImageView val$iv_image) {
                this.f19141a = val$iv_image;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                this.f19141a.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f19141a.getWidth();
                this.f19141a.getHeight();
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
            CompetitionListActivity.this.f19130k.y();
            CompetitionListActivity.this.f19130k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionListActivity.this.f19133n = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (CompetitionListActivity.this.f19134o == 1) {
                CompetitionListActivity.this.f19132m = list;
            } else {
                CompetitionListActivity.this.f19132m.addAll(list);
            }
            CompetitionListActivity.this.f19136q.g(CompetitionListActivity.this.f19132m);
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
            if (JsonParse.getInt((Map) CompetitionListActivity.this.f19136q.getItem(position), "hasCompetitions") == 1) {
                CompetitionListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionListActivity.this).f1656h, CompetitionListActivity.class).putExtra("competitionId", JsonParse.getString((Map) CompetitionListActivity.this.f19136q.getItem(position), "id")));
            } else {
                CompetitionListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionListActivity.this).f1656h, CompetitionDetailActivity.class).putExtra("competitionId", JsonParse.getString((Map) CompetitionListActivity.this.f19136q.getItem(position), "id")));
            }
        }
    }

    static /* synthetic */ int o0(CompetitionListActivity competitionListActivity) {
        int i4 = competitionListActivity.f19134o;
        competitionListActivity.f19134o = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).d(this.f19137r, this.f19134o, this.f19135p)).setDataListener(new d());
    }

    private void x0() {
        this.f19131l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f19131l.setLayoutAnimation(layoutAnimationController);
        c cVar = new c(this.f1656h, R.layout.item_for_competition_list, this.f19132m);
        this.f19136q = cVar;
        this.f19131l.setAdapter(cVar);
        this.f19131l.setEmptyView(findViewById(R.id.tv_emptyView));
    }

    private void y0() {
        this.f19130k.n1(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19136q.k(new e());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_pub_recycle;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("competitionId")) {
            this.f19137r = getIntent().getStringExtra("competitionId");
        } else {
            b0(R.mipmap.my_write, new a());
            invalidateOptionsMenu();
        }
        y0();
        x0();
        this.f19130k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7ade\u8d5b\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19130k = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.f19131l = (EmptyRecyclerView) findViewById(R.id.recyclerView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
