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
import com.bxkj.student.home.physicaltest.apply.ScoreDoubtActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TestProjectScoreListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EmptyRecyclerView f19986k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f19987l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f19988m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19989n;

    /* renamed from: o  reason: collision with root package name */
    private String f19990o;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131232981, JsonParse.getString(stringObjectMap, "examName"));
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "actualScore") + JsonParse.getString(stringObjectMap, "examunit"));
            holder.J(2131233146, JsonParse.getString(stringObjectMap, "score") + "\u5206");
            holder.J(2131233116, JsonParse.getString(stringObjectMap, "rank"));
            holder.h(2131233169).setVisibility(4);
            holder.N(2131231389, false);
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
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) TestProjectScoreListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TestProjectScoreListActivity.this.f19988m = (List) data.get("data");
            TestProjectScoreListActivity.this.f19989n.g(TestProjectScoreListActivity.this.f19988m);
        }
    }

    private void n0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).v0(this.f19990o)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0() {
        startActivity(new Intent(this.f1656h, ScoreDoubtActivity.class).putExtra("meaScoreId", this.f19990o));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427502;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("stuName")) {
            String stringExtra = getIntent().getStringExtra("stuName");
            String stringExtra2 = getIntent().getStringExtra("stuNum");
            TextView textView = this.f19987l;
            textView.setText("\u59d3\u540d\uff1a" + stringExtra + "\u3000\u3000\u3000\u5b66\u53f7\uff1a" + stringExtra2);
        }
        if (getIntent().hasExtra("meaScoreId")) {
            this.f19990o = getIntent().getStringExtra("meaScoreId");
        }
        this.f19986k.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f19986k.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.f1656h, 2131427773, this.f19988m);
        this.f19989n = aVar;
        this.f19986k.setAdapter(aVar);
        this.f19986k.setEmptyView(findViewById(2131232952));
        n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4f53\u6d4b\u5206\u9879\u6c47\u603b");
        b0(2131558926, new BaseActivity.c() { // from class: com.bxkj.student.home.physicaltest.scanscore.a
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                TestProjectScoreListActivity.this.o0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19986k = (EmptyRecyclerView) findViewById(2131232481);
        this.f19987l = (TextView) findViewById(2131233040);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
