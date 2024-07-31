package com.bxkj.student.home.teaching.learning.p091my;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.learning.LearnHomeListAdapter;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* renamed from: com.bxkj.student.home.teaching.learning.my.MyRecordListActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MyRecordListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f17530k;

    /* renamed from: l */
    private EmptyRecyclerView f17531l;

    /* renamed from: m */
    private TextView f17532m;

    /* renamed from: n */
    private List<Map<String, Object>> f17533n = new ArrayList();

    /* renamed from: o */
    private int f17534o = 10;

    /* renamed from: p */
    private int f17535p = 1;

    /* renamed from: q */
    private int f17536q = 0;

    /* renamed from: r */
    private LearnHomeListAdapter f17537r;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.my.MyRecordListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4698a implements OnRefreshLoadmoreListener {
        C4698a() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            MyRecordListActivity.this.f17535p = 1;
            MyRecordListActivity.this.m41573s0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = MyRecordListActivity.this.f17536q / MyRecordListActivity.this.f17534o;
            int i2 = MyRecordListActivity.this.f17535p;
            if (MyRecordListActivity.this.f17536q % MyRecordListActivity.this.f17534o != 0) {
                i++;
            }
            if (i2 >= i) {
                MyRecordListActivity.this.f17530k.mo2041g();
                MyRecordListActivity.this.m57919h0("没有了");
                return;
            }
            MyRecordListActivity.m41578n0(MyRecordListActivity.this);
            MyRecordListActivity.this.m41573s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.my.MyRecordListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4699b extends HttpCallBack {
        C4699b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (MyRecordListActivity.this.f17530k != null && MyRecordListActivity.this.f17530k.mo2061S()) {
                MyRecordListActivity.this.f17530k.mo2078B();
            }
            if (MyRecordListActivity.this.f17530k == null || !MyRecordListActivity.this.f17530k.mo2015z()) {
                return;
            }
            MyRecordListActivity.this.f17530k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyRecordListActivity.this.f17536q = JsonParse.getInt(data, "total");
            if (MyRecordListActivity.this.f17535p == 1) {
                MyRecordListActivity.this.f17533n.clear();
            }
            MyRecordListActivity.this.f17533n.addAll(JsonParse.getList(data, "data"));
            MyRecordListActivity.this.f17537r.m57836g(MyRecordListActivity.this.f17533n);
        }
    }

    /* renamed from: n0 */
    static /* synthetic */ int m41578n0(MyRecordListActivity myRecordListActivity) {
        int i = myRecordListActivity.f17535p;
        myRecordListActivity.f17535p = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s0 */
    public void m41573s0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41637e(LoginUser.getLoginUser().getUserId(), getIntent().getStringExtra("resultType"), Integer.valueOf(this.f17534o), Integer.valueOf(this.f17535p))).setDataListener(new C4699b());
    }

    /* renamed from: t0 */
    private void m41572t0() {
        this.f17530k.mo2019v(new C4698a());
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
        this.f17531l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LearnHomeListAdapter learnHomeListAdapter = new LearnHomeListAdapter(this.f1669h, this.f17533n);
        this.f17537r = learnHomeListAdapter;
        this.f17531l.setAdapter(learnHomeListAdapter);
        this.f17531l.setEmptyView(this.f17532m);
        m41572t0();
        this.f17530k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        if (getIntent().hasExtra("title")) {
            setTitle(getIntent().getStringExtra("title"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17530k = (SmartRefreshLayout) findViewById(2131232482);
        this.f17531l = (EmptyRecyclerView) findViewById(2131232481);
        this.f17532m = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.f17530k.mo2052a0();
    }
}
