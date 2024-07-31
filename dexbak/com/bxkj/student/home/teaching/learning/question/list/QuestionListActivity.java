package com.bxkj.student.home.teaching.learning.question.list;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.home.teaching.homework.question.list.QuestionListAdapter;
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class QuestionListActivity extends BaseActivity {

    /* renamed from: k */
    private EmptyRecyclerView f17671k;

    /* renamed from: l */
    private TextView f17672l;

    /* renamed from: m */
    private List<Map<String, Object>> f17673m = new ArrayList();

    /* renamed from: n */
    private QuestionListAdapter f17674n;

    /* renamed from: o */
    private int f17675o;

    /* renamed from: p */
    private String f17676p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.question.list.QuestionListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4741a extends HttpCallBack {
        C4741a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            QuestionListActivity.this.f17673m = JsonParse.getList(data, "data");
            QuestionListActivity.this.f17674n.m57836g(QuestionListActivity.this.f17673m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public void m41452p0() {
        Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41635g(this.f17675o, this.f17676p)).setDataListener(new C4741a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void m41453o0(ViewGroup viewGroup, View view, Object obj, int i) {
        this.f17674n.m41442v(i);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17674n.m57834k(new OnItemClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.list.a
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
            /* renamed from: a */
            public final void mo39403a(ViewGroup viewGroup, View view, Object obj, int i) {
                QuestionListActivity.this.m41453o0(viewGroup, view, obj, i);
            }
        });
        this.f17674n.m41443u(new QuestionListAdapter.InterfaceC4561b() { // from class: com.bxkj.student.home.teaching.learning.question.list.b
            @Override // com.bxkj.student.home.teaching.homework.question.list.QuestionListAdapter.InterfaceC4561b
            public final void onRefresh() {
                QuestionListActivity.this.m41452p0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return 2131428025;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("type")) {
            this.f17675o = getIntent().getIntExtra("type", 0);
        }
        if (getIntent().hasExtra("resourceId")) {
            this.f17676p = getIntent().getStringExtra("resourceId");
        }
        this.f17671k.setLayoutManager(new LinearLayoutManager(this.f1669h));
        QuestionListAdapter questionListAdapter = new QuestionListAdapter(this.f1669h, this.f17673m);
        this.f17674n = questionListAdapter;
        this.f17671k.setAdapter(questionListAdapter);
        m41452p0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("问题列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17671k = (EmptyRecyclerView) findViewById(2131232481);
        this.f17672l = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        m41452p0();
        LearnHomeListActivity learnHomeListActivity = (LearnHomeListActivity) AppManager.m57776n().getActivity(LearnHomeListActivity.class);
        if (learnHomeListActivity != null) {
            learnHomeListActivity.m41949V0();
        }
    }
}
