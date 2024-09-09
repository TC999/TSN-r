package com.bxkj.student.home.teaching.homework.question.list;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.util.i;
import com.bxkj.student.home.teaching.homework.question.list.QuestionListAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class QuestionListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f20483k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f20484l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20485m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f20486n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private QuestionListAdapter f20487o;

    /* renamed from: p  reason: collision with root package name */
    private String f20488p;

    /* renamed from: q  reason: collision with root package name */
    private Integer f20489q;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public void s0() {
        Http.with(this.f1656h).hideSuccessMessage().setObservable(((com.bxkj.student.home.teaching.homework.a) Http.getApiService(com.bxkj.student.home.teaching.homework.a.class)).f(this.f20488p, this.f20489q)).setDataListener(new a());
    }

    private void r0() {
        final ArrayList arrayList = new ArrayList();
        for (int i4 = 1; i4 < 31; i4++) {
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("id", Integer.valueOf(i4));
            arrayMap.put("name", "\u7b2c" + i4 + "\u5468");
            arrayList.add(arrayMap);
        }
        this.f20483k.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.list.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestionListActivity.this.u0(arrayList, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t0(String str, String str2, Map map) {
        int parseInt = Integer.parseInt(str);
        if (parseInt != 0) {
            this.f20489q = Integer.valueOf(parseInt);
            TextView textView = this.f20483k;
            textView.setText("\u7b2c" + this.f20489q + "\u5468");
            this.f20486n.clear();
            this.f20487o.notifyDataSetChanged();
            s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(List list, View view) {
        new i(this.f1656h).i(this.f20483k, "\u8bf7\u9009\u62e9\u5468", list, "id", "name", new i.c() { // from class: com.bxkj.student.home.teaching.homework.question.list.b
            @Override // com.bxkj.base.util.i.c
            public final void a(String str, String str2, Map map) {
                QuestionListActivity.this.t0(str, str2, map);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20487o.u(new QuestionListAdapter.b() { // from class: com.bxkj.student.home.teaching.homework.question.list.c
            @Override // com.bxkj.student.home.teaching.homework.question.list.QuestionListAdapter.b
            public final void onRefresh() {
                QuestionListActivity.this.s0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427411;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f20484l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        QuestionListAdapter questionListAdapter = new QuestionListAdapter(this.f1656h, this.f20486n);
        this.f20487o = questionListAdapter;
        this.f20484l.setAdapter(questionListAdapter);
        this.f20484l.setEmptyView(this.f20485m);
        if (getIntent().hasExtra("teacherCurriculumId")) {
            this.f20488p = getIntent().getStringExtra("teacherCurriculumId");
            s0();
        }
        r0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8bfe\u540e\u4f5c\u4e1a\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20483k = (TextView) findViewById(2131233231);
        this.f20484l = (EmptyRecyclerView) findViewById(2131232481);
        this.f20485m = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        s0();
    }

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
            QuestionListActivity.this.f20486n = JsonParse.getList(data, "data");
            QuestionListActivity.this.f20487o.g(QuestionListActivity.this.f20486n);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
            if (TextUtils.isEmpty(msg)) {
                return;
            }
            QuestionListActivity.this.f20489q = Integer.valueOf(Integer.parseInt(msg));
            TextView textView = QuestionListActivity.this.f20483k;
            textView.setText("\u7b2c" + msg + "\u5468");
        }
    }
}
