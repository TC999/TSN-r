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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.competition.C4017R;
import com.bxkj.competition.CompeApiService;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CompeteListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f15369k;

    /* renamed from: l */
    private EmptyRecyclerView f15370l;

    /* renamed from: m */
    private List<Map<String, Object>> f15371m = new ArrayList();

    /* renamed from: n */
    private int f15372n = 1;

    /* renamed from: o */
    private int f15373o = 1;

    /* renamed from: p */
    private int f15374p = 10;

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f15375q;

    /* renamed from: r */
    private String f15376r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.electronicentry.CompeteListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4029a implements OnRefreshLoadmoreListener {
        C4029a() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            CompeteListActivity.this.f15373o = 1;
            CompeteListActivity.this.m43420u0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = CompeteListActivity.this.f15372n / CompeteListActivity.this.f15374p;
            int i2 = CompeteListActivity.this.f15373o;
            if (CompeteListActivity.this.f15372n % CompeteListActivity.this.f15374p != 0) {
                i++;
            }
            if (i2 >= i) {
                CompeteListActivity.this.f15369k.mo2041g();
                CompeteListActivity.this.m57919h0("没有了");
                return;
            }
            CompeteListActivity.m43427n0(CompeteListActivity.this);
            CompeteListActivity.this.m43420u0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.electronicentry.CompeteListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4030b extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.competition.electronicentry.CompeteListActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class ViewTreeObserver$OnPreDrawListenerC4031a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a */
            final /* synthetic */ ImageView f15379a;

            ViewTreeObserver$OnPreDrawListenerC4031a(final ImageView val$iv_image) {
                this.f15379a = val$iv_image;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                this.f15379a.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f15379a.getWidth();
                this.f15379a.getHeight();
                return true;
            }
        }

        C4030b(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            int i = C4017R.C4021id.iv_image;
            ImageView imageView = (ImageView) holder.m57862h(i);
            imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver$OnPreDrawListenerC4031a(imageView));
            holder.m57851s(i, JsonParse.getString(stringObjectMap, "majorImg"));
            holder.m57874J(C4017R.C4021id.tv_name, JsonParse.getString(stringObjectMap, "name"));
            holder.m57874J(C4017R.C4021id.tv_location, JsonParse.getString(stringObjectMap, "address"));
            holder.m57874J(C4017R.C4021id.tv_time, JsonParse.getString(stringObjectMap, "startDate"));
            int i2 = C4017R.C4021id.tv_day;
            holder.m57874J(i2, "" + JsonParse.getString(stringObjectMap, "diffCurrDay"));
            holder.m57870N(i2, TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "diffCurrDay")) ^ true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.electronicentry.CompeteListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4032c extends HttpCallBack {
        C4032c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            CompeteListActivity.this.f15369k.mo2078B();
            CompeteListActivity.this.f15369k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompeteListActivity.this.f15372n = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            if (CompeteListActivity.this.f15373o == 1) {
                CompeteListActivity.this.f15371m = list;
            } else {
                CompeteListActivity.this.f15371m.addAll(list);
            }
            CompeteListActivity.this.f15375q.m57836g(CompeteListActivity.this.f15371m);
        }
    }

    /* renamed from: com.bxkj.competition.electronicentry.CompeteListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4033d implements OnItemClickListener {
        C4033d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            CompeteListActivity.this.startActivity(new Intent(((BaseActivity) CompeteListActivity.this).f1669h, ElectronicEntryActivity.class).putExtra("competitionId", JsonParse.getString((Map) CompeteListActivity.this.f15375q.getItem(position), "id")));
        }
    }

    /* renamed from: n0 */
    static /* synthetic */ int m43427n0(CompeteListActivity competeListActivity) {
        int i = competeListActivity.f15373o;
        competeListActivity.f15373o = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m43420u0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43453d(this.f15376r, this.f15373o, this.f15374p)).setDataListener(new C4032c());
    }

    /* renamed from: v0 */
    private void m43419v0() {
        this.f15370l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, C4017R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f15370l.setLayoutAnimation(layoutAnimationController);
        C4030b c4030b = new C4030b(this.f1669h, C4017R.C4023layout.item_for_competition_list, this.f15371m);
        this.f15375q = c4030b;
        this.f15370l.setAdapter(c4030b);
        this.f15370l.setEmptyView(findViewById(C4017R.C4021id.tv_emptyView));
    }

    /* renamed from: w0 */
    private void m43418w0() {
        this.f15369k.mo2019v(new C4029a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15375q.m57834k(new C4033d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4017R.C4023layout.ac_pub_recycle;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("competitionId")) {
            this.f15376r = getIntent().getStringExtra("competitionId");
        }
        m43418w0();
        m43419v0();
        this.f15369k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("竞赛列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15369k = (SmartRefreshLayout) findViewById(C4017R.C4021id.refresh);
        this.f15370l = (EmptyRecyclerView) findViewById(C4017R.C4021id.recyclerView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
