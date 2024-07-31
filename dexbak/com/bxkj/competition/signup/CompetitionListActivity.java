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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.competition.C4017R;
import com.bxkj.competition.CompeApiService;
import com.bxkj.competition.signup.p087my.MyCompetitionListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CompetitionListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f15594k;

    /* renamed from: l */
    private EmptyRecyclerView f15595l;

    /* renamed from: m */
    private List<Map<String, Object>> f15596m = new ArrayList();

    /* renamed from: n */
    private int f15597n = 1;

    /* renamed from: o */
    private int f15598o = 1;

    /* renamed from: p */
    private int f15599p = 10;

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f15600q;

    /* renamed from: r */
    private String f15601r;

    /* renamed from: com.bxkj.competition.signup.CompetitionListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4099a implements BaseActivity.InterfaceC1107c {
        C4099a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            CompetitionListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionListActivity.this).f1669h, MyCompetitionListActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.CompetitionListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4100b implements OnRefreshLoadmoreListener {
        C4100b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            CompetitionListActivity.this.f15598o = 1;
            CompetitionListActivity.this.m43225w0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = CompetitionListActivity.this.f15597n / CompetitionListActivity.this.f15599p;
            int i2 = CompetitionListActivity.this.f15598o;
            if (CompetitionListActivity.this.f15597n % CompetitionListActivity.this.f15599p != 0) {
                i++;
            }
            if (i2 >= i) {
                CompetitionListActivity.this.f15594k.mo2041g();
                CompetitionListActivity.this.m57919h0("没有了");
                return;
            }
            CompetitionListActivity.m43233o0(CompetitionListActivity.this);
            CompetitionListActivity.this.m43225w0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.CompetitionListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4101c extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.competition.signup.CompetitionListActivity$c$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class ViewTreeObserver$OnPreDrawListenerC4102a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a */
            final /* synthetic */ ImageView f15605a;

            ViewTreeObserver$OnPreDrawListenerC4102a(final ImageView val$iv_image) {
                this.f15605a = val$iv_image;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                this.f15605a.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f15605a.getWidth();
                this.f15605a.getHeight();
                return true;
            }
        }

        C4101c(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            int i = C4017R.C4021id.iv_image;
            ImageView imageView = (ImageView) holder.m57862h(i);
            imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver$OnPreDrawListenerC4102a(imageView));
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
    /* renamed from: com.bxkj.competition.signup.CompetitionListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4103d extends HttpCallBack {
        C4103d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            CompetitionListActivity.this.f15594k.mo2078B();
            CompetitionListActivity.this.f15594k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionListActivity.this.f15597n = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            if (CompetitionListActivity.this.f15598o == 1) {
                CompetitionListActivity.this.f15596m = list;
            } else {
                CompetitionListActivity.this.f15596m.addAll(list);
            }
            CompetitionListActivity.this.f15600q.m57836g(CompetitionListActivity.this.f15596m);
        }
    }

    /* renamed from: com.bxkj.competition.signup.CompetitionListActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4104e implements OnItemClickListener {
        C4104e() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            if (JsonParse.getInt((Map) CompetitionListActivity.this.f15600q.getItem(position), "hasCompetitions") == 1) {
                CompetitionListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionListActivity.this).f1669h, CompetitionListActivity.class).putExtra("competitionId", JsonParse.getString((Map) CompetitionListActivity.this.f15600q.getItem(position), "id")));
            } else {
                CompetitionListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionListActivity.this).f1669h, CompetitionDetailActivity.class).putExtra("competitionId", JsonParse.getString((Map) CompetitionListActivity.this.f15600q.getItem(position), "id")));
            }
        }
    }

    /* renamed from: o0 */
    static /* synthetic */ int m43233o0(CompetitionListActivity competitionListActivity) {
        int i = competitionListActivity.f15598o;
        competitionListActivity.f15598o = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w0 */
    public void m43225w0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43453d(this.f15601r, this.f15598o, this.f15599p)).setDataListener(new C4103d());
    }

    /* renamed from: x0 */
    private void m43224x0() {
        this.f15595l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, C4017R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f15595l.setLayoutAnimation(layoutAnimationController);
        C4101c c4101c = new C4101c(this.f1669h, C4017R.C4023layout.item_for_competition_list, this.f15596m);
        this.f15600q = c4101c;
        this.f15595l.setAdapter(c4101c);
        this.f15595l.setEmptyView(findViewById(C4017R.C4021id.tv_emptyView));
    }

    /* renamed from: y0 */
    private void m43223y0() {
        this.f15594k.mo2019v(new C4100b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15600q.m57834k(new C4104e());
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
            this.f15601r = getIntent().getStringExtra("competitionId");
        } else {
            m57925b0(C4017R.mipmap.my_write, new C4099a());
            invalidateOptionsMenu();
        }
        m43223y0();
        m43224x0();
        this.f15594k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("竞赛列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15594k = (SmartRefreshLayout) findViewById(C4017R.C4021id.refresh);
        this.f15595l = (EmptyRecyclerView) findViewById(C4017R.C4021id.recyclerView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
