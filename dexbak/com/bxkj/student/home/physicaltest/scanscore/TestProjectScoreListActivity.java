package com.bxkj.student.home.physicaltest.scanscore;

import android.content.Context;
import android.content.Intent;
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
import com.bxkj.student.home.physicaltest.apply.ScoreDoubtActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TestProjectScoreListActivity extends BaseActivity {

    /* renamed from: k */
    private EmptyRecyclerView f16596k;

    /* renamed from: l */
    private TextView f16597l;

    /* renamed from: m */
    private List<Map<String, Object>> f16598m = new ArrayList();

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f16599n;

    /* renamed from: o */
    private String f16600o;

    /* renamed from: com.bxkj.student.home.physicaltest.scanscore.TestProjectScoreListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4396a extends CommonAdapter<Map<String, Object>> {
        C4396a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131232981, JsonParse.getString(stringObjectMap, "examName"));
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "actualScore") + JsonParse.getString(stringObjectMap, "examunit"));
            holder.m57874J(2131233146, JsonParse.getString(stringObjectMap, "score") + "分");
            holder.m57874J(2131233116, JsonParse.getString(stringObjectMap, "rank"));
            holder.m57862h(2131233169).setVisibility(4);
            holder.m57870N(2131231389, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.scanscore.TestProjectScoreListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4397b extends HttpCallBack {
        C4397b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) TestProjectScoreListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TestProjectScoreListActivity.this.f16598m = (List) data.get("data");
            TestProjectScoreListActivity.this.f16599n.m57836g(TestProjectScoreListActivity.this.f16598m);
        }
    }

    /* renamed from: n0 */
    private void m42479n0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m65v0(this.f16600o)).setDataListener(new C4397b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void m42478o0() {
        startActivity(new Intent(this.f1669h, ScoreDoubtActivity.class).putExtra("meaScoreId", this.f16600o));
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
            TextView textView = this.f16597l;
            textView.setText("姓名：" + stringExtra + "\u3000\u3000\u3000学号：" + stringExtra2);
        }
        if (getIntent().hasExtra("meaScoreId")) {
            this.f16600o = getIntent().getStringExtra("meaScoreId");
        }
        this.f16596k.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f16596k.setLayoutAnimation(layoutAnimationController);
        C4396a c4396a = new C4396a(this.f1669h, C4215R.C4221layout.item_for_test_score_list, this.f16598m);
        this.f16599n = c4396a;
        this.f16596k.setAdapter(c4396a);
        this.f16596k.setEmptyView(findViewById(2131232952));
        m42479n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("体测分项汇总");
        m57925b0(C4215R.mipmap.question, new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.student.home.physicaltest.scanscore.a
            @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
            public final void onClick() {
                TestProjectScoreListActivity.this.m42478o0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16596k = (EmptyRecyclerView) findViewById(2131232481);
        this.f16597l = (TextView) findViewById(2131233040);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
