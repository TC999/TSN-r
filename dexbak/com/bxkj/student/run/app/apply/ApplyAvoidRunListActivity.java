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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.RunApiService;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ApplyAvoidRunListActivity extends BaseActivity {

    /* renamed from: k */
    private List<Map<String, Object>> f19064k = new ArrayList();

    /* renamed from: l */
    private EmptyRecyclerView f19065l;

    /* renamed from: m */
    private CommonAdapter<Map<String, Object>> f19066m;

    /* renamed from: n */
    private SmartRefreshLayout f19067n;

    /* renamed from: o */
    private TextView f19068o;

    /* renamed from: com.bxkj.student.run.app.apply.ApplyAvoidRunListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5209a extends CommonAdapter<Map<String, Object>> {
        C5209a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "userName"));
            holder.m57874J(C4215R.C4219id.tv_team, JsonParse.getString(stringObjectMap, "sysTermName"));
            holder.m57874J(2131233169, JsonParse.getString(stringObjectMap, "avoidRunningState"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.apply.ApplyAvoidRunListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5210b extends HttpCallBack {
        C5210b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyAvoidRunListActivity.this.f19064k = JsonParse.getList(data, "data");
            ApplyAvoidRunListActivity.this.f19066m.m57836g(ApplyAvoidRunListActivity.this.f19064k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void m40078o0(ViewGroup viewGroup, View view, Object obj, int i) {
        startActivity(new Intent(this.f1669h, ApplyAvoidRunDetailActivity.class).putExtra("id", JsonParse.getString(this.f19066m.getItem(i), "id")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public /* synthetic */ void m40077p0() {
        startActivity(new Intent(this.f1669h, ApplyAvoidRunActivity.class));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f19066m.m57834k(new OnItemClickListener() { // from class: com.bxkj.student.run.app.apply.d
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
            /* renamed from: a */
            public final void mo39403a(ViewGroup viewGroup, View view, Object obj, int i) {
                ApplyAvoidRunListActivity.this.m40078o0(viewGroup, view, obj, i);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return 2131428026;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f19065l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f19065l.setLayoutAnimation(layoutAnimationController);
        C5209a c5209a = new C5209a(this.f1669h, C4215R.C4221layout.item_for_apply_mc_list, this.f19064k);
        this.f19066m = c5209a;
        this.f19065l.setAdapter(c5209a);
        this.f19068o.setText("暂无申请数据,点击右上角+号申请免跑");
        this.f19065l.setEmptyView(this.f19068o);
        m40079n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("申请免跑列表");
        m57925b0(2131165495, new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.student.run.app.apply.c
            @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
            public final void onClick() {
                ApplyAvoidRunListActivity.this.m40077p0();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f19065l = (EmptyRecyclerView) findViewById(2131232481);
        this.f19068o = (TextView) findViewById(2131232952);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById(2131232482);
        this.f19067n = smartRefreshLayout;
        smartRefreshLayout.mo2050b0(false);
        this.f19067n.mo2064P(false);
    }

    /* renamed from: n0 */
    public void m40079n0() {
        Http.with(this.f1669h).setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40109l(LoginUser.getLoginUser().getUserId(), 1, 100)).setDataListener(new C5210b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
