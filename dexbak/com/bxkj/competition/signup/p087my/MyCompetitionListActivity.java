package com.bxkj.competition.signup.p087my;

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
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.C4017R;
import com.bxkj.competition.CompeApiService;
import com.bxkj.competition.signup.CompetitionDetailActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* renamed from: com.bxkj.competition.signup.my.MyCompetitionListActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MyCompetitionListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f15669k;

    /* renamed from: l */
    private EmptyRecyclerView f15670l;

    /* renamed from: m */
    private List<Map<String, Object>> f15671m = new ArrayList();

    /* renamed from: n */
    private int f15672n = 1;

    /* renamed from: o */
    private int f15673o = 1;

    /* renamed from: p */
    private int f15674p = 10;

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f15675q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.my.MyCompetitionListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4121a implements OnRefreshLoadmoreListener {
        C4121a() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            MyCompetitionListActivity.this.f15673o = 1;
            MyCompetitionListActivity.this.m43148u0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = MyCompetitionListActivity.this.f15672n / MyCompetitionListActivity.this.f15674p;
            int i2 = MyCompetitionListActivity.this.f15673o;
            if (MyCompetitionListActivity.this.f15672n % MyCompetitionListActivity.this.f15674p != 0) {
                i++;
            }
            if (i2 >= i) {
                MyCompetitionListActivity.this.f15669k.mo2041g();
                MyCompetitionListActivity.this.m57919h0("没有了");
                return;
            }
            MyCompetitionListActivity.m43155n0(MyCompetitionListActivity.this);
            MyCompetitionListActivity.this.m43148u0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.signup.my.MyCompetitionListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4122b extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.competition.signup.my.MyCompetitionListActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class ViewTreeObserver$OnPreDrawListenerC4123a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a */
            final /* synthetic */ ImageView f15678a;

            ViewTreeObserver$OnPreDrawListenerC4123a(final ImageView val$iv_image) {
                this.f15678a = val$iv_image;
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                this.f15678a.getViewTreeObserver().removeOnPreDrawListener(this);
                this.f15678a.getWidth();
                this.f15678a.getHeight();
                return true;
            }
        }

        C4122b(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            int i = C4017R.C4021id.iv_image;
            ImageView imageView = (ImageView) holder.m57862h(i);
            imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver$OnPreDrawListenerC4123a(imageView));
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
    /* renamed from: com.bxkj.competition.signup.my.MyCompetitionListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4124c extends HttpCallBack {
        C4124c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            MyCompetitionListActivity.this.f15669k.mo2078B();
            MyCompetitionListActivity.this.f15669k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyCompetitionListActivity.this.f15672n = Integer.parseInt(Tools.m57632O(data, "total"));
            List list = (List) data.get("data");
            if (MyCompetitionListActivity.this.f15673o == 1) {
                MyCompetitionListActivity.this.f15671m = list;
            } else {
                MyCompetitionListActivity.this.f15671m.addAll(list);
            }
            MyCompetitionListActivity.this.f15675q.m57836g(MyCompetitionListActivity.this.f15671m);
        }
    }

    /* renamed from: com.bxkj.competition.signup.my.MyCompetitionListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4125d implements OnItemClickListener {
        C4125d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            MyCompetitionListActivity.this.startActivity(new Intent(((BaseActivity) MyCompetitionListActivity.this).f1669h, CompetitionDetailActivity.class).putExtra(Constants.FROM, "my").putExtra("competitionId", JsonParse.getString((Map) MyCompetitionListActivity.this.f15675q.getItem(position), "id")));
        }
    }

    /* renamed from: n0 */
    static /* synthetic */ int m43155n0(MyCompetitionListActivity myCompetitionListActivity) {
        int i = myCompetitionListActivity.f15673o;
        myCompetitionListActivity.f15673o = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m43148u0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43450g(LoginUser.getLoginUser().getUserId())).setDataListener(new C4124c());
    }

    /* renamed from: v0 */
    private void m43147v0() {
        this.f15670l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, C4017R.anim.zoom_in));
        layoutAnimationController.setOrder(0);
        this.f15670l.setLayoutAnimation(layoutAnimationController);
        C4122b c4122b = new C4122b(this.f1669h, C4017R.C4023layout.item_for_competition_list, this.f15671m);
        this.f15675q = c4122b;
        this.f15670l.setAdapter(c4122b);
        this.f15670l.setEmptyView(findViewById(C4017R.C4021id.tv_emptyView));
    }

    /* renamed from: w0 */
    private void m43146w0() {
        this.f15669k.mo2019v(new C4121a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15675q.m57834k(new C4125d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4017R.C4023layout.ac_pub_recycle;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m43146w0();
        m43147v0();
        this.f15669k.mo2064P(false);
        this.f15669k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我的竞赛列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15669k = (SmartRefreshLayout) findViewById(C4017R.C4021id.refresh);
        this.f15670l = (EmptyRecyclerView) findViewById(C4017R.C4021id.recyclerView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
