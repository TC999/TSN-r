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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class AllScoreForTeamActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EmptyRecyclerView f21214k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f21215l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f21216m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21217n;

    /* renamed from: o  reason: collision with root package name */
    private String f21218o;

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
            holder.J(2131232957, JsonParse.getString(stringObjectMap, "exam"));
            holder.J(2131232968, JsonParse.getString(stringObjectMap, "fenshu"));
            holder.J(2131232946, JsonParse.getString(stringObjectMap, "duizhaofen"));
            holder.J(2131232880, JsonParse.getString(stringObjectMap, "bili"));
            holder.J(2131233146, JsonParse.getString(stringObjectMap, "score"));
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
            new iOSOneButtonDialog(((BaseActivity) AllScoreForTeamActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            AllScoreForTeamActivity.this.f21216m = (List) data.get("data");
            AllScoreForTeamActivity.this.f21217n.g(AllScoreForTeamActivity.this.f21216m);
        }
    }

    private void m0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).Y(this.f21218o)).setDataListener(new b());
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
            TextView textView = this.f21215l;
            textView.setText("\u59d3\u540d\uff1a" + stringExtra + "\u3000\u3000\u3000\u5b66\u53f7\uff1a" + stringExtra2);
        }
        if (getIntent().hasExtra("stuTeamScoreId")) {
            this.f21218o = getIntent().getStringExtra("stuTeamScoreId");
        }
        this.f21214k.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f21214k.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.f1656h, 2131427751, this.f21216m);
        this.f21217n = aVar;
        this.f21214k.setAdapter(aVar);
        this.f21214k.setEmptyView(findViewById(2131232952));
        m0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u671f\u672b\u5206\u9879\u6210\u7ee9\u6c47\u603b");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f21214k = (EmptyRecyclerView) findViewById(2131232481);
        this.f21215l = (TextView) findViewById(2131233040);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
