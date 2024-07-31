package com.bxkj.student.home.teaching.learning.p091my;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import com.bxkj.student.home.teaching.learning.question.list.QuestionListAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* renamed from: com.bxkj.student.home.teaching.learning.my.RefuseQuestionListActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RefuseQuestionListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f17551k;

    /* renamed from: l */
    private EmptyRecyclerView f17552l;

    /* renamed from: m */
    private TextView f17553m;

    /* renamed from: o */
    private QuestionListAdapter f17555o;

    /* renamed from: p */
    private int f17556p;

    /* renamed from: q */
    private String f17557q;

    /* renamed from: n */
    private List<Map<String, Object>> f17554n = new ArrayList();

    /* renamed from: r */
    private int f17558r = 1;

    /* renamed from: s */
    private int f17559s = 10;

    /* renamed from: t */
    private int f17560t = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.my.RefuseQuestionListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4703a implements OnRefreshLoadmoreListener {
        C4703a() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            RefuseQuestionListActivity.this.f17558r = 1;
            RefuseQuestionListActivity.this.m41547t0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = RefuseQuestionListActivity.this.f17560t / RefuseQuestionListActivity.this.f17559s;
            int i2 = RefuseQuestionListActivity.this.f17558r;
            if (RefuseQuestionListActivity.this.f17560t % RefuseQuestionListActivity.this.f17559s != 0) {
                i++;
            }
            if (i2 >= i) {
                RefuseQuestionListActivity.this.f17551k.mo2041g();
                RefuseQuestionListActivity.this.m57919h0("没有了");
                return;
            }
            RefuseQuestionListActivity.m41552o0(RefuseQuestionListActivity.this);
            RefuseQuestionListActivity.this.m41547t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.my.RefuseQuestionListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4704b extends HttpCallBack {
        C4704b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (RefuseQuestionListActivity.this.f17551k != null && RefuseQuestionListActivity.this.f17551k.mo2061S()) {
                RefuseQuestionListActivity.this.f17551k.mo2078B();
            }
            if (RefuseQuestionListActivity.this.f17551k == null || !RefuseQuestionListActivity.this.f17551k.mo2015z()) {
                return;
            }
            RefuseQuestionListActivity.this.f17551k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RefuseQuestionListActivity.this.f17560t = JsonParse.getInt(data, "total");
            if (RefuseQuestionListActivity.this.f17558r == 1) {
                RefuseQuestionListActivity.this.f17554n.clear();
            }
            RefuseQuestionListActivity.this.f17554n.addAll(JsonParse.getList(data, "data"));
            RefuseQuestionListActivity.this.f17555o.m57836g(RefuseQuestionListActivity.this.f17554n);
        }
    }

    /* renamed from: o0 */
    static /* synthetic */ int m41552o0(RefuseQuestionListActivity refuseQuestionListActivity) {
        int i = refuseQuestionListActivity.f17558r;
        refuseQuestionListActivity.f17558r = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public void m41547t0() {
        if (isDestroyed()) {
            return;
        }
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41619w(Integer.valueOf(this.f17559s), Integer.valueOf(this.f17558r))).setDataListener(new C4704b());
    }

    /* renamed from: u0 */
    private void m41546u0() {
        this.f17551k.mo2019v(new C4703a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v0 */
    public /* synthetic */ void m41545v0(ViewGroup viewGroup, View view, Object obj, int i) {
        this.f17555o.m41442v(i);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17555o.m57834k(new OnItemClickListener() { // from class: com.bxkj.student.home.teaching.learning.my.g
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
            /* renamed from: a */
            public final void mo39403a(ViewGroup viewGroup, View view, Object obj, int i) {
                RefuseQuestionListActivity.this.m41545v0(viewGroup, view, obj, i);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return 2131428026;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("type")) {
            this.f17556p = getIntent().getIntExtra("type", 0);
        }
        if (getIntent().hasExtra("resourceId")) {
            this.f17557q = getIntent().getStringExtra("resourceId");
        }
        this.f17552l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        QuestionListAdapter questionListAdapter = new QuestionListAdapter(this.f1669h, this.f17554n);
        this.f17555o = questionListAdapter;
        this.f17552l.setAdapter(questionListAdapter);
        this.f17552l.setEmptyView(this.f17553m);
        m41546u0();
        this.f17551k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("待处理作业列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17551k = (SmartRefreshLayout) findViewById(2131232482);
        this.f17552l = (EmptyRecyclerView) findViewById(2131232481);
        this.f17553m = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.f17551k.mo2052a0();
    }
}
