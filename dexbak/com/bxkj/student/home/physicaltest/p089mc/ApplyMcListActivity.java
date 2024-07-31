package com.bxkj.student.home.physicaltest.p089mc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* renamed from: com.bxkj.student.home.physicaltest.mc.ApplyMcListActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ApplyMcListActivity extends BaseActivity {

    /* renamed from: k */
    private List<Map<String, Object>> f16478k = new ArrayList();

    /* renamed from: l */
    private EmptyRecyclerView f16479l;

    /* renamed from: m */
    private CommonAdapter<Map<String, Object>> f16480m;

    /* renamed from: com.bxkj.student.home.physicaltest.mc.ApplyMcListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4353a implements BaseActivity.InterfaceC1107c {
        C4353a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            ApplyMcListActivity.this.startActivity(new Intent(((BaseActivity) ApplyMcListActivity.this).f1669h, ApplyMCActivity.class));
        }
    }

    /* renamed from: com.bxkj.student.home.physicaltest.mc.ApplyMcListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4354b extends CommonAdapter<Map<String, Object>> {
        C4354b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "userName"));
            holder.m57874J(2131233051, JsonParse.getString(stringObjectMap, "userNum"));
            holder.m57874J(C4215R.C4219id.tv_team, JsonParse.getString(stringObjectMap, "year"));
            holder.m57874J(2131233211, JsonParse.getString(stringObjectMap, "meaStatusName"));
            holder.m57874J(2131233169, JsonParse.getString(stringObjectMap, "status"));
            holder.m57874J(2131233198, JsonParse.getString(stringObjectMap, "applyDate"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.mc.ApplyMcListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4355c extends HttpCallBack {
        C4355c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyMcListActivity.this.f16478k = JsonParse.getList(data, "data");
            ApplyMcListActivity.this.f16480m.m57836g(ApplyMcListActivity.this.f16478k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void m42579o0(ViewGroup viewGroup, View view, Object obj, int i) {
        startActivity(new Intent(this.f1669h, ApplyMCDetailActivity.class).putExtra("meaNonStuApplyId", JsonParse.getString(this.f16480m.getItem(i), "meaNonStuApplyId")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16480m.m57834k(new OnItemClickListener() { // from class: com.bxkj.student.home.physicaltest.mc.f
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
            /* renamed from: a */
            public final void mo39403a(ViewGroup viewGroup, View view, Object obj, int i) {
                ApplyMcListActivity.this.m42579o0(viewGroup, view, obj, i);
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
        this.f16479l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f16479l.setLayoutAnimation(layoutAnimationController);
        C4354b c4354b = new C4354b(this.f1669h, C4215R.C4221layout.item_for_apply_mc_list, this.f16478k);
        this.f16480m = c4354b;
        this.f16479l.setAdapter(c4354b);
        this.f16479l.setEmptyView(findViewById(2131232952));
        m42580n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("免测申请列表");
        m57925b0(2131165495, new C4353a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16479l = (EmptyRecyclerView) findViewById(2131232481);
    }

    /* renamed from: n0 */
    public void m42580n0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m98k0(LoginUser.getLoginUser().getUserId())).setDataListener(new C4355c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
