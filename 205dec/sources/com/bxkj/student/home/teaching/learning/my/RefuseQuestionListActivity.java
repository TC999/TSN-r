package com.bxkj.student.home.teaching.learning.my;

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
import com.bxkj.student.home.teaching.learning.m;
import com.bxkj.student.home.teaching.learning.question.list.QuestionListAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RefuseQuestionListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f20894k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f20895l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20896m;

    /* renamed from: o  reason: collision with root package name */
    private QuestionListAdapter f20898o;

    /* renamed from: p  reason: collision with root package name */
    private int f20899p;

    /* renamed from: q  reason: collision with root package name */
    private String f20900q;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f20897n = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private int f20901r = 1;

    /* renamed from: s  reason: collision with root package name */
    private int f20902s = 10;

    /* renamed from: t  reason: collision with root package name */
    private int f20903t = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements s0.e {
        a() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            RefuseQuestionListActivity.this.f20901r = 1;
            RefuseQuestionListActivity.this.t0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = RefuseQuestionListActivity.this.f20903t / RefuseQuestionListActivity.this.f20902s;
            int i5 = RefuseQuestionListActivity.this.f20901r;
            if (RefuseQuestionListActivity.this.f20903t % RefuseQuestionListActivity.this.f20902s != 0) {
                i4++;
            }
            if (i5 >= i4) {
                RefuseQuestionListActivity.this.f20894k.h();
                RefuseQuestionListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            RefuseQuestionListActivity.o0(RefuseQuestionListActivity.this);
            RefuseQuestionListActivity.this.t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (RefuseQuestionListActivity.this.f20894k != null && RefuseQuestionListActivity.this.f20894k.S()) {
                RefuseQuestionListActivity.this.f20894k.y();
            }
            if (RefuseQuestionListActivity.this.f20894k == null || !RefuseQuestionListActivity.this.f20894k.z()) {
                return;
            }
            RefuseQuestionListActivity.this.f20894k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RefuseQuestionListActivity.this.f20903t = JsonParse.getInt(data, "total");
            if (RefuseQuestionListActivity.this.f20901r == 1) {
                RefuseQuestionListActivity.this.f20897n.clear();
            }
            RefuseQuestionListActivity.this.f20897n.addAll(JsonParse.getList(data, "data"));
            RefuseQuestionListActivity.this.f20898o.g(RefuseQuestionListActivity.this.f20897n);
        }
    }

    static /* synthetic */ int o0(RefuseQuestionListActivity refuseQuestionListActivity) {
        int i4 = refuseQuestionListActivity.f20901r;
        refuseQuestionListActivity.f20901r = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        if (isDestroyed()) {
            return;
        }
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((m) Http.getApiService(m.class)).w(Integer.valueOf(this.f20902s), Integer.valueOf(this.f20901r))).setDataListener(new b());
    }

    private void u0() {
        this.f20894k.n1(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v0(ViewGroup viewGroup, View view, Object obj, int i4) {
        this.f20898o.v(i4);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20898o.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.home.teaching.learning.my.g
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i4) {
                RefuseQuestionListActivity.this.v0(viewGroup, view, obj, i4);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131428026;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("type")) {
            this.f20899p = getIntent().getIntExtra("type", 0);
        }
        if (getIntent().hasExtra("resourceId")) {
            this.f20900q = getIntent().getStringExtra("resourceId");
        }
        this.f20895l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        QuestionListAdapter questionListAdapter = new QuestionListAdapter(this.f1656h, this.f20897n);
        this.f20898o = questionListAdapter;
        this.f20895l.setAdapter(questionListAdapter);
        this.f20895l.setEmptyView(this.f20896m);
        u0();
        this.f20894k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5f85\u5904\u7406\u4f5c\u4e1a\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20894k = (SmartRefreshLayout) findViewById(2131232482);
        this.f20895l = (EmptyRecyclerView) findViewById(2131232481);
        this.f20896m = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.f20894k.a0();
    }
}
