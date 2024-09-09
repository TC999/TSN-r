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
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ScoreDoubtActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private List<Map<String, Object>> f19799k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f19800l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f19801m;

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19802n;

    /* renamed from: o  reason: collision with root package name */
    private String f19803o;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            ScoreDoubtActivity scoreDoubtActivity = ScoreDoubtActivity.this;
            scoreDoubtActivity.startActivity(scoreDoubtActivity.getIntent().setClass(((BaseActivity) ScoreDoubtActivity.this).f1656h, ApplyScoreDoubtActivity.class));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends CommonAdapter<Map<String, Object>> {
        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131232981, JsonParse.getString(stringObjectMap, "year"));
            holder.J(2131233107, JsonParse.getString(stringObjectMap, "examName"));
            holder.J(2131233146, "\u539f\u59cb\u6210\u7ee9:" + JsonParse.getString(stringObjectMap, "rawScores"));
            holder.J(2131233116, "\u7533\u8bc9\u6210\u7ee9:" + JsonParse.getString(stringObjectMap, "complaintResults"));
            holder.J(2131233198, JsonParse.getString(stringObjectMap, "createTime"));
            holder.J(2131233169, JsonParse.getString(stringObjectMap, "status"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ScoreDoubtActivity.this.f19799k = JsonParse.getList(data, "data");
            ScoreDoubtActivity.this.f19802n.g(ScoreDoubtActivity.this.f19799k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(ViewGroup viewGroup, View view, Object obj, int i4) {
        startActivity(new Intent(this.f1656h, ApplyTestScoreDetailActivity.class).putExtra("id", JsonParse.getString(this.f19802n.getItem(i4), "id")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19802n.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.home.physicaltest.apply.c
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i4) {
                ScoreDoubtActivity.this.o0(viewGroup, view, obj, i4);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131428025;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("meaScoreId")) {
            this.f19803o = getIntent().getStringExtra("meaScoreId");
        }
        this.f19800l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        b bVar = new b(this.f1656h, 2131427672, this.f19799k);
        this.f19802n = bVar;
        this.f19800l.setAdapter(bVar);
        this.f19801m.setText("\u5982\u679c\u5bf9\u6210\u7ee9\u6709\u5f02\u8bae\uff0c\u8bf7\u70b9\u51fb\u53f3\u4e0a\u89d2+\u53f7\u53cd\u9988");
        this.f19800l.setEmptyView(this.f19801m);
        n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u7684\u4f53\u6d4b\u6210\u7ee9\u7533\u8bc9\u5217\u8868");
        b0(2131165495, new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19800l = (EmptyRecyclerView) findViewById(2131232481);
        this.f19801m = (TextView) findViewById(2131232952);
    }

    public void n0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).J(LoginUser.getLoginUser().getUserId(), this.f19803o)).setDataListener(new c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
