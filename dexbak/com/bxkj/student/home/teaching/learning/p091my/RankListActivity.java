package com.bxkj.student.home.teaching.learning.p091my;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* renamed from: com.bxkj.student.home.teaching.learning.my.RankListActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RankListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f17540k;

    /* renamed from: l */
    private EmptyRecyclerView f17541l;

    /* renamed from: m */
    private TextView f17542m;

    /* renamed from: n */
    private List<Map<String, Object>> f17543n = new ArrayList();

    /* renamed from: o */
    private int f17544o = 10;

    /* renamed from: p */
    private int f17545p = 1;

    /* renamed from: q */
    private int f17546q = 0;

    /* renamed from: r */
    private CommonAdapter f17547r;

    /* renamed from: com.bxkj.student.home.teaching.learning.my.RankListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4700a extends CommonAdapter<Map<String, Object>> {
        C4700a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233045, String.valueOf(mo57829e(holder) + 1));
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.m57874J(2131233198, JsonParse.getString(stringObjectMap, "sumIntegral"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.my.RankListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4701b implements OnRefreshLoadmoreListener {
        C4701b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            RankListActivity.this.f17545p = 1;
            RankListActivity.this.m41561s0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = RankListActivity.this.f17546q / RankListActivity.this.f17544o;
            int i2 = RankListActivity.this.f17545p;
            if (RankListActivity.this.f17546q % RankListActivity.this.f17544o != 0) {
                i++;
            }
            if (i2 >= i) {
                RankListActivity.this.f17540k.mo2041g();
                RankListActivity.this.m57919h0("没有了");
                return;
            }
            RankListActivity.m41566n0(RankListActivity.this);
            RankListActivity.this.m41561s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.my.RankListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4702c extends HttpCallBack {
        C4702c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (RankListActivity.this.f17540k != null && RankListActivity.this.f17540k.mo2061S()) {
                RankListActivity.this.f17540k.mo2078B();
            }
            if (RankListActivity.this.f17540k == null || !RankListActivity.this.f17540k.mo2015z()) {
                return;
            }
            RankListActivity.this.f17540k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RankListActivity.this.f17546q = JsonParse.getInt(data, "total");
            if (RankListActivity.this.f17545p == 1) {
                RankListActivity.this.f17543n.clear();
            }
            RankListActivity.this.f17543n.addAll(JsonParse.getList(data, "data"));
            RankListActivity.this.f17547r.m57836g(RankListActivity.this.f17543n);
        }
    }

    /* renamed from: n0 */
    static /* synthetic */ int m41566n0(RankListActivity rankListActivity) {
        int i = rankListActivity.f17545p;
        rankListActivity.f17545p = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public void m41561s0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41637e(LoginUser.getLoginUser().getUserId(), getIntent().getStringExtra("resultType"), Integer.valueOf(this.f17544o), Integer.valueOf(this.f17545p))).setDataListener(new C4702c());
    }

    /* renamed from: t0 */
    private void m41560t0() {
        this.f17540k.mo2019v(new C4701b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return 2131428026;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f17541l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4700a c4700a = new C4700a(this.f1669h, C4215R.C4221layout.item_for_rank_list, this.f17543n);
        this.f17547r = c4700a;
        this.f17541l.setAdapter(c4700a);
        this.f17541l.setEmptyView(this.f17542m);
        m41560t0();
        this.f17540k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("总排名");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17540k = (SmartRefreshLayout) findViewById(2131232482);
        this.f17541l = (EmptyRecyclerView) findViewById(2131232481);
        this.f17542m = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.f17540k.mo2052a0();
    }
}
