package com.bxkj.student.run.app.apply;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ApplyAvoidRunListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private List<Map<String, Object>> f22310k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f22311l;

    /* renamed from: m  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f22312m;

    /* renamed from: n  reason: collision with root package name */
    private SmartRefreshLayout f22313n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f22314o;

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
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "userName"));
            holder.J(2131233194, JsonParse.getString(stringObjectMap, "sysTermName"));
            holder.J(2131233169, JsonParse.getString(stringObjectMap, "avoidRunningState"));
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
            ApplyAvoidRunListActivity.this.f22310k = JsonParse.getList(data, "data");
            ApplyAvoidRunListActivity.this.f22312m.g(ApplyAvoidRunListActivity.this.f22310k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(ViewGroup viewGroup, View view, Object obj, int i4) {
        startActivity(new Intent(this.f1656h, ApplyAvoidRunDetailActivity.class).putExtra("id", JsonParse.getString(this.f22312m.getItem(i4), "id")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p0() {
        startActivity(new Intent(this.f1656h, ApplyAvoidRunActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f22312m.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.run.app.apply.d
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i4) {
                ApplyAvoidRunListActivity.this.o0(viewGroup, view, obj, i4);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131428026;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f22311l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1656h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f22311l.setLayoutAnimation(layoutAnimationController);
        a aVar = new a(this.f1656h, 2131427669, this.f22310k);
        this.f22312m = aVar;
        this.f22311l.setAdapter(aVar);
        this.f22314o.setText("\u6682\u65e0\u7533\u8bf7\u6570\u636e,\u70b9\u51fb\u53f3\u4e0a\u89d2+\u53f7\u7533\u8bf7\u514d\u8dd1");
        this.f22311l.setEmptyView(this.f22314o);
        n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7533\u8bf7\u514d\u8dd1\u5217\u8868");
        b0(2131165495, new BaseActivity.c() { // from class: com.bxkj.student.run.app.apply.c
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                ApplyAvoidRunListActivity.this.p0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22311l = (EmptyRecyclerView) findViewById(2131232481);
        this.f22314o = (TextView) findViewById(2131232952);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById(2131232482);
        this.f22313n = smartRefreshLayout;
        smartRefreshLayout.b0(false);
        this.f22313n.O(false);
    }

    public void n0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).l(LoginUser.getLoginUser().getUserId(), 1, 100)).setDataListener(new b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
