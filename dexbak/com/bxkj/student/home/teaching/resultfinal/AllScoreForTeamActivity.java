package com.bxkj.student.home.teaching.resultfinal;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AllScoreForTeamActivity extends BaseActivity {

    /* renamed from: k */
    private EmptyRecyclerView f17876k;

    /* renamed from: l */
    private TextView f17877l;

    /* renamed from: m */
    private List<Map<String, Object>> f17878m = new ArrayList();

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f17879n;

    /* renamed from: o */
    private String f17880o;

    /* renamed from: com.bxkj.student.home.teaching.resultfinal.AllScoreForTeamActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4822a extends CommonAdapter<Map<String, Object>> {
        C4822a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv_exam, JsonParse.getString(stringObjectMap, "exam"));
            holder.m57874J(C4215R.C4219id.tv_fenshu, JsonParse.getString(stringObjectMap, "fenshu"));
            holder.m57874J(C4215R.C4219id.tv_duizhaofen, JsonParse.getString(stringObjectMap, "duizhaofen"));
            holder.m57874J(C4215R.C4219id.tv_bili, JsonParse.getString(stringObjectMap, "bili"));
            holder.m57874J(2131233146, JsonParse.getString(stringObjectMap, "score"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.resultfinal.AllScoreForTeamActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4823b extends HttpCallBack {
        C4823b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) AllScoreForTeamActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            AllScoreForTeamActivity.this.f17878m = (List) data.get("data");
            AllScoreForTeamActivity.this.f17879n.m57836g(AllScoreForTeamActivity.this.f17878m);
        }
    }

    /* renamed from: m0 */
    private void m41268m0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m133Y(this.f17880o)).setDataListener(new C4823b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_test_project_score_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("stuName")) {
            String stringExtra = getIntent().getStringExtra("stuName");
            String stringExtra2 = getIntent().getStringExtra("stuNum");
            TextView textView = this.f17877l;
            textView.setText("姓名：" + stringExtra + "\u3000\u3000\u3000学号：" + stringExtra2);
        }
        if (getIntent().hasExtra("stuTeamScoreId")) {
            this.f17880o = getIntent().getStringExtra("stuTeamScoreId");
        }
        this.f17876k.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f17876k.setLayoutAnimation(layoutAnimationController);
        C4822a c4822a = new C4822a(this.f1669h, C4215R.C4221layout.item_for_result_score_all, this.f17878m);
        this.f17879n = c4822a;
        this.f17876k.setAdapter(c4822a);
        this.f17876k.setEmptyView(findViewById(2131232952));
        m41268m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("期末分项成绩汇总");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17876k = (EmptyRecyclerView) findViewById(2131232481);
        this.f17877l = (TextView) findViewById(2131233040);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
