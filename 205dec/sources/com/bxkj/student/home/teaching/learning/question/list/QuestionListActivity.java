package com.bxkj.student.home.teaching.learning.question.list;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.home.teaching.homework.question.list.QuestionListAdapter;
import com.bxkj.student.home.teaching.learning.LearnHomeListActivity;
import com.bxkj.student.home.teaching.learning.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class QuestionListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EmptyRecyclerView f21009k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f21010l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f21011m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private QuestionListAdapter f21012n;

    /* renamed from: o  reason: collision with root package name */
    private int f21013o;

    /* renamed from: p  reason: collision with root package name */
    private String f21014p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            QuestionListActivity.this.f21011m = JsonParse.getList(data, "data");
            QuestionListActivity.this.f21012n.g(QuestionListActivity.this.f21011m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public void p0() {
        Http.with(this.f1656h).setObservable(((m) Http.getApiService(m.class)).g(this.f21013o, this.f21014p)).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(ViewGroup viewGroup, View view, Object obj, int i4) {
        this.f21012n.v(i4);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f21012n.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.home.teaching.learning.question.list.a
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i4) {
                QuestionListActivity.this.o0(viewGroup, view, obj, i4);
            }
        });
        this.f21012n.u(new QuestionListAdapter.b() { // from class: com.bxkj.student.home.teaching.learning.question.list.b
            @Override // com.bxkj.student.home.teaching.homework.question.list.QuestionListAdapter.b
            public final void onRefresh() {
                QuestionListActivity.this.p0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131428025;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("type")) {
            this.f21013o = getIntent().getIntExtra("type", 0);
        }
        if (getIntent().hasExtra("resourceId")) {
            this.f21014p = getIntent().getStringExtra("resourceId");
        }
        this.f21009k.setLayoutManager(new LinearLayoutManager(this.f1656h));
        QuestionListAdapter questionListAdapter = new QuestionListAdapter(this.f1656h, this.f21011m);
        this.f21012n = questionListAdapter;
        this.f21009k.setAdapter(questionListAdapter);
        p0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u95ee\u9898\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21009k = (EmptyRecyclerView) findViewById(2131232481);
        this.f21010l = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        p0();
        LearnHomeListActivity learnHomeListActivity = (LearnHomeListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(LearnHomeListActivity.class);
        if (learnHomeListActivity != null) {
            learnHomeListActivity.V0();
        }
    }
}
