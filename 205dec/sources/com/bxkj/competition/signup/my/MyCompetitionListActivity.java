package com.bxkj.competition.signup.my;

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
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.R;
import com.bxkj.competition.signup.CompetitionDetailActivity;
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
public class MyCompetitionListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f19199k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f19200l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f19201m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private int f19202n = 1;

    /* renamed from: o  reason: collision with root package name */
    private int f19203o = 1;

    /* renamed from: p  reason: collision with root package name */
    private int f19204p = 10;

    /* renamed from: q  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19205q;

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
            MyCompetitionListActivity.this.f19203o = 1;
            MyCompetitionListActivity.this.u0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = MyCompetitionListActivity.this.f19202n / MyCompetitionListActivity.this.f19204p;
            int i5 = MyCompetitionListActivity.this.f19203o;
            if (MyCompetitionListActivity.this.f19202n % MyCompetitionListActivity.this.f19204p != 0) {
                i4++;
            }
            if (i5 >= i4) {
                MyCompetitionListActivity.this.f19199k.h();
                MyCompetitionListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            MyCompetitionListActivity.n0(MyCompetitionListActivity.this);
            MyCompetitionListActivity.this.u0();
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
            final /* synthetic */ ImageView f19208a;

            a(final ImageView val$iv_image) {
                this.f19208a = val$iv_image;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                this.f19208a.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f19208a.getWidth();
                this.f19208a.getHeight();
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
            MyCompetitionListActivity.this.f19199k.y();
            MyCompetitionListActivity.this.f19199k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyCompetitionListActivity.this.f19202n = Integer.parseInt(u.O(data, "total"));
            List list = (List) data.get("data");
            if (MyCompetitionListActivity.this.f19203o == 1) {
                MyCompetitionListActivity.this.f19201m = list;
            } else {
                MyCompetitionListActivity.this.f19201m.addAll(list);
            }
            MyCompetitionListActivity.this.f19205q.g(MyCompetitionListActivity.this.f19201m);
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
            MyCompetitionListActivity.this.startActivity(new Intent(((BaseActivity) MyCompetitionListActivity.this).f1656h, CompetitionDetailActivity.class).putExtra("from", "my").putExtra("competitionId", JsonParse.getString((Map) MyCompetitionListActivity.this.f19205q.getItem(position), "id")));
        }
    }

    static /* synthetic */ int n0(MyCompetitionListActivity myCompetitionListActivity) {
        int i4 = myCompetitionListActivity.f19203o;
        myCompetitionListActivity.f19203o = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).g(LoginUser.getLoginUser().getUserId())).setDataListener(new c());
    }

    private void v0() {
        this.f19200l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f19200l.setLayoutAnimation(layoutAnimationController);
        b bVar = new b(this.f1656h, R.layout.item_for_competition_list, this.f19201m);
        this.f19205q = bVar;
        this.f19200l.setAdapter(bVar);
        this.f19200l.setEmptyView(findViewById(R.id.tv_emptyView));
    }

    private void w0() {
        this.f19199k.n1(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19205q.k(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_pub_recycle;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        w0();
        v0();
        this.f19199k.O(false);
        this.f19199k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u7684\u7ade\u8d5b\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19199k = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.f19200l = (EmptyRecyclerView) findViewById(R.id.recyclerView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
