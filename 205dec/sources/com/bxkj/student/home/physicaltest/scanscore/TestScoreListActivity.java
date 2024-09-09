package com.bxkj.student.home.physicaltest.scanscore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.physicaltest.scanscore.TestScoreListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TestScoreListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f19993k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f19994l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f19995m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19996n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends CommonAdapter<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void o(String str, Map map, View view) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            TestScoreListActivity.this.startActivity(new Intent(this.f1707a, TestProjectScoreListActivity.class).putExtra("meaScoreId", str).putExtra("stuName", JsonParse.getString(map, "stuName")).putExtra("stuNum", JsonParse.getString(map, "stuNum")));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: n */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            final String string = JsonParse.getString(stringObjectMap, "meaScoreId");
            holder.N(2131233135, TextUtils.isEmpty(string));
            if (TextUtils.isEmpty(string)) {
                holder.J(2131232981, JsonParse.getString(stringObjectMap, "year"));
                holder.J(2131233135, JsonParse.getString(stringObjectMap, "gradeType"));
            } else {
                holder.J(2131232981, JsonParse.getString(stringObjectMap, "year") + "\u5e74" + JsonParse.getString(stringObjectMap, "gradeType"));
            }
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "stuName"));
            holder.J(2131233146, JsonParse.getString(stringObjectMap, "totalScore") + "\u5206");
            holder.J(2131233116, JsonParse.getString(stringObjectMap, "rank"));
            holder.J(2131233169, JsonParse.getString(stringObjectMap, "meaStatus"));
            holder.N(2131231389, TextUtils.isEmpty(string) ^ true);
            holder.w(2131231055, new View.OnClickListener() { // from class: com.bxkj.student.home.physicaltest.scanscore.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TestScoreListActivity.a.this.o(string, stringObjectMap, view);
                }
            });
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

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            TestScoreListActivity.this.f19995m = (List) data.get("data");
            TestScoreListActivity.this.f19996n.g(TestScoreListActivity.this.f19995m);
        }
    }

    private void l0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).z1(LoginUser.getLoginUser().getUserId())).setDataListener(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427460;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f19994l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f19994l.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.f1656h, 2131427773, this.f19995m);
        this.f19996n = aVar;
        this.f19994l.setAdapter(aVar);
        this.f19993k.b0(false);
        this.f19993k.O(false);
        this.f19993k.setOverScrollMode(2);
        this.f19994l.setEmptyView(findViewById(2131232952));
        l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4f53\u6d4b\u6210\u7ee9\u6c47\u603b");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19993k = (SmartRefreshLayout) findViewById(2131232482);
        this.f19994l = (EmptyRecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
