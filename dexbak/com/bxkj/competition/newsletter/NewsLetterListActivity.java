package com.bxkj.competition.newsletter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.C4017R;
import com.bxkj.competition.CompeApiService;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class NewsLetterListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f15412k;

    /* renamed from: l */
    private EmptyRecyclerView f15413l;

    /* renamed from: m */
    private TextView f15414m;

    /* renamed from: n */
    private Button f15415n;

    /* renamed from: o */
    private List<Map<String, Object>> f15416o = new ArrayList();

    /* renamed from: p */
    private int f15417p = 1;

    /* renamed from: q */
    private int f15418q = 1;

    /* renamed from: r */
    private int f15419r = 10;

    /* renamed from: s */
    private CommonAdapter<Map<String, Object>> f15420s;

    /* renamed from: t */
    private String f15421t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.newsletter.NewsLetterListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4041a implements OnRefreshLoadmoreListener {
        C4041a() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            NewsLetterListActivity.this.f15418q = 1;
            NewsLetterListActivity.this.m43379u0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = NewsLetterListActivity.this.f15417p / NewsLetterListActivity.this.f15419r;
            int i2 = NewsLetterListActivity.this.f15418q;
            if (NewsLetterListActivity.this.f15417p % NewsLetterListActivity.this.f15419r != 0) {
                i++;
            }
            if (i2 >= i) {
                NewsLetterListActivity.this.f15412k.mo2041g();
                NewsLetterListActivity.this.m57919h0("没有了");
                return;
            }
            NewsLetterListActivity.m43386n0(NewsLetterListActivity.this);
            NewsLetterListActivity.this.m43379u0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.newsletter.NewsLetterListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4042b extends CommonAdapter<Map<String, Object>> {
        C4042b(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(C4017R.C4021id.tv_name, JsonParse.getString(stringObjectMap, "content"));
            holder.m57874J(C4017R.C4021id.tv_status, JsonParse.getString(stringObjectMap, "auditState"));
            holder.m57874J(C4017R.C4021id.tv_time, JsonParse.getString(stringObjectMap, "publishDate"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.newsletter.NewsLetterListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4043c extends HttpCallBack {
        C4043c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            NewsLetterListActivity.this.f15412k.mo2078B();
            NewsLetterListActivity.this.f15412k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            NewsLetterListActivity.this.f15417p = JsonParse.getInt(data, "total");
            List list = (List) data.get("data");
            if (NewsLetterListActivity.this.f15418q == 1) {
                NewsLetterListActivity.this.f15416o = list;
            } else {
                NewsLetterListActivity.this.f15416o.addAll(list);
            }
            NewsLetterListActivity.this.f15420s.m57836g(NewsLetterListActivity.this.f15416o);
        }
    }

    /* renamed from: com.bxkj.competition.newsletter.NewsLetterListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4044d implements OnItemClickListener {
        C4044d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            NewsLetterListActivity.this.startActivity(new Intent(((BaseActivity) NewsLetterListActivity.this).f1669h, PostActivity.class).putExtra("content", JsonParse.getString((Map) NewsLetterListActivity.this.f15420s.getItem(position), "content")));
        }
    }

    /* renamed from: n0 */
    static /* synthetic */ int m43386n0(NewsLetterListActivity newsLetterListActivity) {
        int i = newsLetterListActivity.f15418q;
        newsLetterListActivity.f15418q = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m43379u0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43439r(this.f15421t, LoginUser.getLoginUser().getUserId(), this.f15418q, this.f15419r)).setDataListener(new C4043c());
    }

    /* renamed from: v0 */
    private void m43378v0() {
        this.f15413l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, C4017R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f15413l.setLayoutAnimation(layoutAnimationController);
        C4042b c4042b = new C4042b(this.f1669h, C4017R.C4023layout.item_for_newsletter, this.f15416o);
        this.f15420s = c4042b;
        this.f15413l.setAdapter(c4042b);
        this.f15413l.setEmptyView(findViewById(C4017R.C4021id.tv_emptyView));
    }

    /* renamed from: w0 */
    private void m43377w0() {
        this.f15412k.mo2019v(new C4041a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15420s.m57834k(new C4044d());
        this.f15415n.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4017R.C4023layout.ac_my_newsletter_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("competitionId")) {
            this.f15421t = getIntent().getStringExtra("competitionId");
        }
        m43377w0();
        m43378v0();
        this.f15412k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我的通讯稿");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15412k = (SmartRefreshLayout) findViewById(C4017R.C4021id.refresh);
        this.f15413l = (EmptyRecyclerView) findViewById(C4017R.C4021id.recyclerView);
        this.f15414m = (TextView) findViewById(C4017R.C4021id.tv_emptyView);
        this.f15415n = (Button) findViewById(C4017R.C4021id.bt_post);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == C4017R.C4021id.bt_post) {
            startActivity(new Intent(this.f1669h, PostActivity.class).putExtra("competitionId", this.f15421t));
        }
    }

    /* renamed from: x0 */
    public void m43376x0() {
        this.f15412k.mo2052a0();
    }
}
