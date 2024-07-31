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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.competition.signup.p087my.MyCompetitionListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class HomeListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f15318k;

    /* renamed from: l */
    private EmptyRecyclerView f15319l;

    /* renamed from: m */
    private List<Map<String, Object>> f15320m = new ArrayList();

    /* renamed from: n */
    private int f15321n = 1;

    /* renamed from: o */
    private int f15322o = 1;

    /* renamed from: p */
    private int f15323p = 10;

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f15324q;

    /* renamed from: r */
    private String f15325r;

    /* renamed from: com.bxkj.competition.HomeListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4009a implements BaseActivity.InterfaceC1107c {
        C4009a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            HomeListActivity.this.startActivity(new Intent(((BaseActivity) HomeListActivity.this).f1669h, MyCompetitionListActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.HomeListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4010b implements OnRefreshLoadmoreListener {
        C4010b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            HomeListActivity.this.f15322o = 1;
            HomeListActivity.this.m43462v0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = HomeListActivity.this.f15321n / HomeListActivity.this.f15323p;
            int i2 = HomeListActivity.this.f15322o;
            if (HomeListActivity.this.f15321n % HomeListActivity.this.f15323p != 0) {
                i++;
            }
            if (i2 >= i) {
                HomeListActivity.this.f15318k.mo2041g();
                HomeListActivity.this.m57919h0("没有了");
                return;
            }
            HomeListActivity.m43469o0(HomeListActivity.this);
            HomeListActivity.this.m43462v0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.HomeListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4011c extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.competition.HomeListActivity$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class ViewTreeObserver$OnPreDrawListenerC4012a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a */
            final /* synthetic */ ImageView f15329a;

            ViewTreeObserver$OnPreDrawListenerC4012a(final ImageView val$iv_image) {
                this.f15329a = val$iv_image;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                this.f15329a.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f15329a.getWidth();
                this.f15329a.getHeight();
                return true;
            }
        }

        C4011c(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            int i = C4017R.C4021id.iv_image;
            ImageView imageView = (ImageView) holder.m57862h(i);
            imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver$OnPreDrawListenerC4012a(imageView));
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
    /* renamed from: com.bxkj.competition.HomeListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4013d extends HttpCallBack {
        C4013d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            HomeListActivity.this.f15318k.mo2078B();
            HomeListActivity.this.f15318k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            HomeListActivity.this.f15321n = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            if (HomeListActivity.this.f15322o == 1) {
                HomeListActivity.this.f15320m = list;
            } else {
                HomeListActivity.this.f15320m.addAll(list);
            }
            HomeListActivity.this.f15324q.m57836g(HomeListActivity.this.f15320m);
        }
    }

    /* renamed from: com.bxkj.competition.HomeListActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4014e implements OnItemClickListener {
        C4014e() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            HomeListActivity.this.startActivity(new Intent(((BaseActivity) HomeListActivity.this).f1669h, MenuActivity.class).putExtra("competitionId", JsonParse.getString((Map) HomeListActivity.this.f15324q.getItem(position), "id")));
        }
    }

    /* renamed from: o0 */
    static /* synthetic */ int m43469o0(HomeListActivity homeListActivity) {
        int i = homeListActivity.f15322o;
        homeListActivity.f15322o = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public void m43462v0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43453d(this.f15325r, this.f15322o, this.f15323p)).setDataListener(new C4013d());
    }

    /* renamed from: w0 */
    private void m43461w0() {
        this.f15319l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, C4017R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f15319l.setLayoutAnimation(layoutAnimationController);
        C4011c c4011c = new C4011c(this.f1669h, C4017R.C4023layout.item_for_competition_list, this.f15320m);
        this.f15324q = c4011c;
        this.f15319l.setAdapter(c4011c);
        this.f15319l.setEmptyView(findViewById(C4017R.C4021id.tv_emptyView));
    }

    /* renamed from: x0 */
    private void m43460x0() {
        this.f15318k.mo2019v(new C4010b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15324q.m57834k(new C4014e());
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
            this.f15325r = getIntent().getStringExtra("competitionId");
        } else {
            m57925b0(C4017R.mipmap.my_write, new C4009a());
            invalidateOptionsMenu();
        }
        m43460x0();
        m43461w0();
        this.f15318k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("竞赛列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15318k = (SmartRefreshLayout) findViewById(C4017R.C4021id.refresh);
        this.f15319l = (EmptyRecyclerView) findViewById(C4017R.C4021id.recyclerView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
