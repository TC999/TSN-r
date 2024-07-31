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
public class CompetitionListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f15398k;

    /* renamed from: l */
    private EmptyRecyclerView f15399l;

    /* renamed from: m */
    private List<Map<String, Object>> f15400m = new ArrayList();

    /* renamed from: n */
    private int f15401n = 1;

    /* renamed from: o */
    private int f15402o = 1;

    /* renamed from: p */
    private int f15403p = 10;

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f15404q;

    /* renamed from: r */
    private String f15405r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.newsletter.CompetitionListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4036a implements OnRefreshLoadmoreListener {
        C4036a() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            CompetitionListActivity.this.f15402o = 1;
            CompetitionListActivity.this.m43395u0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = CompetitionListActivity.this.f15401n / CompetitionListActivity.this.f15403p;
            int i2 = CompetitionListActivity.this.f15402o;
            if (CompetitionListActivity.this.f15401n % CompetitionListActivity.this.f15403p != 0) {
                i++;
            }
            if (i2 >= i) {
                CompetitionListActivity.this.f15398k.mo2041g();
                CompetitionListActivity.this.m57919h0("没有了");
                return;
            }
            CompetitionListActivity.m43402n0(CompetitionListActivity.this);
            CompetitionListActivity.this.m43395u0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.newsletter.CompetitionListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4037b extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.competition.newsletter.CompetitionListActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class ViewTreeObserver$OnPreDrawListenerC4038a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a */
            final /* synthetic */ ImageView f15408a;

            ViewTreeObserver$OnPreDrawListenerC4038a(final ImageView val$iv_image) {
                this.f15408a = val$iv_image;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                this.f15408a.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f15408a.getWidth();
                this.f15408a.getHeight();
                return true;
            }
        }

        C4037b(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            int i = C4017R.C4021id.iv_image;
            ImageView imageView = (ImageView) holder.m57862h(i);
            imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver$OnPreDrawListenerC4038a(imageView));
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
    /* renamed from: com.bxkj.competition.newsletter.CompetitionListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4039c extends HttpCallBack {
        C4039c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            CompetitionListActivity.this.f15398k.mo2078B();
            CompetitionListActivity.this.f15398k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionListActivity.this.f15401n = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            if (CompetitionListActivity.this.f15402o == 1) {
                CompetitionListActivity.this.f15400m = list;
            } else {
                CompetitionListActivity.this.f15400m.addAll(list);
            }
            CompetitionListActivity.this.f15404q.m57836g(CompetitionListActivity.this.f15400m);
        }
    }

    /* renamed from: com.bxkj.competition.newsletter.CompetitionListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4040d implements OnItemClickListener {
        C4040d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            CompetitionListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionListActivity.this).f1669h, NewsLetterListActivity.class).putExtra("competitionId", JsonParse.getString((Map) CompetitionListActivity.this.f15404q.getItem(position), "id")));
        }
    }

    /* renamed from: n0 */
    static /* synthetic */ int m43402n0(CompetitionListActivity competitionListActivity) {
        int i = competitionListActivity.f15402o;
        competitionListActivity.f15402o = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m43395u0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43453d(this.f15405r, this.f15402o, this.f15403p)).setDataListener(new C4039c());
    }

    /* renamed from: v0 */
    private void m43394v0() {
        this.f15399l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, C4017R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f15399l.setLayoutAnimation(layoutAnimationController);
        C4037b c4037b = new C4037b(this.f1669h, C4017R.C4023layout.item_for_competition_list, this.f15400m);
        this.f15404q = c4037b;
        this.f15399l.setAdapter(c4037b);
        this.f15399l.setEmptyView(findViewById(C4017R.C4021id.tv_emptyView));
    }

    /* renamed from: w0 */
    private void m43393w0() {
        this.f15398k.mo2019v(new C4036a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15404q.m57834k(new C4040d());
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
            this.f15405r = getIntent().getStringExtra("competitionId");
        }
        m43393w0();
        m43394v0();
        this.f15398k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("竞赛列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15398k = (SmartRefreshLayout) findViewById(C4017R.C4021id.refresh);
        this.f15399l = (EmptyRecyclerView) findViewById(C4017R.C4021id.recyclerView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
