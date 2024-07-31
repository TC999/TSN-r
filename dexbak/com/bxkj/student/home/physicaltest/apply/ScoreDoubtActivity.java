package com.bxkj.student.home.physicaltest.apply;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ScoreDoubtActivity extends BaseActivity {

    /* renamed from: k */
    private List<Map<String, Object>> f16409k;

    /* renamed from: l */
    private EmptyRecyclerView f16410l;

    /* renamed from: m */
    private TextView f16411m;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f16412n;

    /* renamed from: o */
    private String f16413o;

    /* renamed from: com.bxkj.student.home.physicaltest.apply.ScoreDoubtActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4335a implements BaseActivity.InterfaceC1107c {
        C4335a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            ScoreDoubtActivity scoreDoubtActivity = ScoreDoubtActivity.this;
            scoreDoubtActivity.startActivity(scoreDoubtActivity.getIntent().setClass(((BaseActivity) ScoreDoubtActivity.this).f1669h, ApplyScoreDoubtActivity.class));
        }
    }

    /* renamed from: com.bxkj.student.home.physicaltest.apply.ScoreDoubtActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4336b extends CommonAdapter<Map<String, Object>> {
        C4336b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131232981, JsonParse.getString(stringObjectMap, "year"));
            holder.m57874J(2131233107, JsonParse.getString(stringObjectMap, "examName"));
            holder.m57874J(2131233146, "原始成绩:" + JsonParse.getString(stringObjectMap, "rawScores"));
            holder.m57874J(2131233116, "申诉成绩:" + JsonParse.getString(stringObjectMap, "complaintResults"));
            holder.m57874J(2131233198, JsonParse.getString(stringObjectMap, "createTime"));
            holder.m57874J(2131233169, JsonParse.getString(stringObjectMap, "status"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.apply.ScoreDoubtActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4337c extends HttpCallBack {
        C4337c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ScoreDoubtActivity.this.f16409k = JsonParse.getList(data, "data");
            ScoreDoubtActivity.this.f16412n.m57836g(ScoreDoubtActivity.this.f16409k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void m42638o0(ViewGroup viewGroup, View view, Object obj, int i) {
        startActivity(new Intent(this.f1669h, ApplyTestScoreDetailActivity.class).putExtra("id", JsonParse.getString(this.f16412n.getItem(i), "id")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16412n.m57834k(new OnItemClickListener() { // from class: com.bxkj.student.home.physicaltest.apply.c
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
            /* renamed from: a */
            public final void mo39403a(ViewGroup viewGroup, View view, Object obj, int i) {
                ScoreDoubtActivity.this.m42638o0(viewGroup, view, obj, i);
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
        if (getIntent().hasExtra("meaScoreId")) {
            this.f16413o = getIntent().getStringExtra("meaScoreId");
        }
        this.f16410l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4336b c4336b = new C4336b(this.f1669h, C4215R.C4221layout.item_for_apply_test_score_list, this.f16409k);
        this.f16412n = c4336b;
        this.f16410l.setAdapter(c4336b);
        this.f16411m.setText("如果对成绩有异议，请点击右上角+号反馈");
        this.f16410l.setEmptyView(this.f16411m);
        m42639n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我的体测成绩申诉列表");
        m57925b0(2131165495, new C4335a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16410l = (EmptyRecyclerView) findViewById(2131232481);
        this.f16411m = (TextView) findViewById(2131232952);
    }

    /* renamed from: n0 */
    public void m42639n0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m163J(LoginUser.getLoginUser().getUserId(), this.f16413o)).setDataListener(new C4337c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
