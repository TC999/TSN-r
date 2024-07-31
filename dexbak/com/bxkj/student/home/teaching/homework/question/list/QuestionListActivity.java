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
import com.bxkj.base.util.DropDownSpinnerDialog;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.homework.HomeWorkApiService;
import com.bxkj.student.home.teaching.homework.question.list.QuestionListAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class QuestionListActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f17125k;

    /* renamed from: l */
    private EmptyRecyclerView f17126l;

    /* renamed from: m */
    private TextView f17127m;

    /* renamed from: n */
    private List<Map<String, Object>> f17128n = new ArrayList();

    /* renamed from: o */
    private QuestionListAdapter f17129o;

    /* renamed from: p */
    private String f17130p;

    /* renamed from: q */
    private Integer f17131q;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q0 */
    public void m41992s0() {
        Http.with(this.f1669h).hideSuccessMessage().setObservable(((HomeWorkApiService) Http.getApiService(HomeWorkApiService.class)).m42107f(this.f17130p, this.f17131q)).setDataListener(new C4559a());
    }

    /* renamed from: r0 */
    private void m41993r0() {
        final ArrayList arrayList = new ArrayList();
        for (int i = 1; i < 31; i++) {
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("id", Integer.valueOf(i));
            arrayMap.put("name", "第" + i + "周");
            arrayList.add(arrayMap);
        }
        this.f17125k.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.list.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QuestionListActivity.this.m41990u0(arrayList, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public /* synthetic */ void m41991t0(String str, String str2, Map map) {
        int parseInt = Integer.parseInt(str);
        if (parseInt != 0) {
            this.f17131q = Integer.valueOf(parseInt);
            TextView textView = this.f17125k;
            textView.setText("第" + this.f17131q + "周");
            this.f17128n.clear();
            this.f17129o.notifyDataSetChanged();
            m41992s0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void m41990u0(List list, View view) {
        new DropDownSpinnerDialog(this.f1669h).m44082i(this.f17125k, "请选择周", list, "id", "name", new DropDownSpinnerDialog.InterfaceC3904c() { // from class: com.bxkj.student.home.teaching.homework.question.list.b
            @Override // com.bxkj.base.util.DropDownSpinnerDialog.InterfaceC3904c
            /* renamed from: a */
            public final void mo41979a(String str, String str2, Map map) {
                QuestionListActivity.this.m41991t0(str, str2, map);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17129o.m41981u(new QuestionListAdapter.InterfaceC4561b() { // from class: com.bxkj.student.home.teaching.homework.question.list.c
            @Override // com.bxkj.student.home.teaching.homework.question.list.QuestionListAdapter.InterfaceC4561b
            public final void onRefresh() {
                QuestionListActivity.this.m41992s0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_homewrok_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f17126l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        QuestionListAdapter questionListAdapter = new QuestionListAdapter(this.f1669h, this.f17128n);
        this.f17129o = questionListAdapter;
        this.f17126l.setAdapter(questionListAdapter);
        this.f17126l.setEmptyView(this.f17127m);
        if (getIntent().hasExtra("teacherCurriculumId")) {
            this.f17130p = getIntent().getStringExtra("teacherCurriculumId");
            m41992s0();
        }
        m41993r0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("课后作业列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17125k = (TextView) findViewById(C4215R.C4219id.tv_week_type);
        this.f17126l = (EmptyRecyclerView) findViewById(2131232481);
        this.f17127m = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        m41992s0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.question.list.QuestionListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4559a extends HttpCallBack {
        C4559a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            QuestionListActivity.this.f17128n = JsonParse.getList(data, "data");
            QuestionListActivity.this.f17129o.m57836g(QuestionListActivity.this.f17128n);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
            if (TextUtils.isEmpty(msg)) {
                return;
            }
            QuestionListActivity.this.f17131q = Integer.valueOf(Integer.parseInt(msg));
            TextView textView = QuestionListActivity.this.f17125k;
            textView.setText("第" + msg + "周");
        }
    }
}
