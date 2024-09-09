package com.bxkj.student.home.teaching.learning.my;

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
import com.bxkj.student.home.teaching.learning.m;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MyRecordListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f20873k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f20874l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20875m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f20876n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private int f20877o = 10;

    /* renamed from: p  reason: collision with root package name */
    private int f20878p = 1;

    /* renamed from: q  reason: collision with root package name */
    private int f20879q = 0;

    /* renamed from: r  reason: collision with root package name */
    private LearnHomeListAdapter f20880r;

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
            MyRecordListActivity.this.f20878p = 1;
            MyRecordListActivity.this.s0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = MyRecordListActivity.this.f20879q / MyRecordListActivity.this.f20877o;
            int i5 = MyRecordListActivity.this.f20878p;
            if (MyRecordListActivity.this.f20879q % MyRecordListActivity.this.f20877o != 0) {
                i4++;
            }
            if (i5 >= i4) {
                MyRecordListActivity.this.f20873k.h();
                MyRecordListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            MyRecordListActivity.n0(MyRecordListActivity.this);
            MyRecordListActivity.this.s0();
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
            if (MyRecordListActivity.this.f20873k != null && MyRecordListActivity.this.f20873k.S()) {
                MyRecordListActivity.this.f20873k.y();
            }
            if (MyRecordListActivity.this.f20873k == null || !MyRecordListActivity.this.f20873k.z()) {
                return;
            }
            MyRecordListActivity.this.f20873k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyRecordListActivity.this.f20879q = JsonParse.getInt(data, "total");
            if (MyRecordListActivity.this.f20878p == 1) {
                MyRecordListActivity.this.f20876n.clear();
            }
            MyRecordListActivity.this.f20876n.addAll(JsonParse.getList(data, "data"));
            MyRecordListActivity.this.f20880r.g(MyRecordListActivity.this.f20876n);
        }
    }

    static /* synthetic */ int n0(MyRecordListActivity myRecordListActivity) {
        int i4 = myRecordListActivity.f20878p;
        myRecordListActivity.f20878p = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((m) Http.getApiService(m.class)).e(LoginUser.getLoginUser().getUserId(), getIntent().getStringExtra("resultType"), Integer.valueOf(this.f20877o), Integer.valueOf(this.f20878p))).setDataListener(new b());
    }

    private void t0() {
        this.f20873k.n1(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131428026;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f20874l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LearnHomeListAdapter learnHomeListAdapter = new LearnHomeListAdapter(this.f1656h, this.f20876n);
        this.f20880r = learnHomeListAdapter;
        this.f20874l.setAdapter(learnHomeListAdapter);
        this.f20874l.setEmptyView(this.f20875m);
        t0();
        this.f20873k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        if (getIntent().hasExtra("title")) {
            setTitle(getIntent().getStringExtra("title"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20873k = (SmartRefreshLayout) findViewById(2131232482);
        this.f20874l = (EmptyRecyclerView) findViewById(2131232481);
        this.f20875m = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.f20873k.a0();
    }
}
