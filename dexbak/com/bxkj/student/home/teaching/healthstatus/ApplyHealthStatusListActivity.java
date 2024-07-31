package com.bxkj.student.home.teaching.healthstatus;

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

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ApplyHealthStatusListActivity extends BaseActivity {

    /* renamed from: k */
    private List<Map<String, Object>> f16942k = new ArrayList();

    /* renamed from: l */
    private EmptyRecyclerView f16943l;

    /* renamed from: m */
    private CommonAdapter<Map<String, Object>> f16944m;

    /* renamed from: com.bxkj.student.home.teaching.healthstatus.ApplyHealthStatusListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4508a implements BaseActivity.InterfaceC1107c {
        C4508a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            ApplyHealthStatusListActivity.this.startActivity(new Intent(((BaseActivity) ApplyHealthStatusListActivity.this).f1669h, ApplyHealthStudentActivity.class));
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.healthstatus.ApplyHealthStatusListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4509b extends CommonAdapter<Map<String, Object>> {
        C4509b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "applyerName"));
            holder.m57874J(C4215R.C4219id.tv_team, JsonParse.getString(stringObjectMap, "applyDate"));
            holder.m57874J(2131233211, JsonParse.getString(stringObjectMap, "type"));
            holder.m57874J(2131233169, JsonParse.getString(stringObjectMap, "status"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.healthstatus.ApplyHealthStatusListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4510c extends HttpCallBack {
        C4510c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ApplyHealthStatusListActivity.this.f16942k = JsonParse.getList(data, "data");
            ApplyHealthStatusListActivity.this.f16944m.m57836g(ApplyHealthStatusListActivity.this.f16942k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void m42145o0(ViewGroup viewGroup, View view, Object obj, int i) {
        startActivity(new Intent(this.f1669h, ApplyHealthStatusDetailActivity.class).putExtra("id", JsonParse.getString(this.f16944m.getItem(i), "id")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16944m.m57834k(new OnItemClickListener() { // from class: com.bxkj.student.home.teaching.healthstatus.b
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
            /* renamed from: a */
            public final void mo39403a(ViewGroup viewGroup, View view, Object obj, int i) {
                ApplyHealthStatusListActivity.this.m42145o0(viewGroup, view, obj, i);
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
        this.f16943l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f16943l.setLayoutAnimation(layoutAnimationController);
        C4509b c4509b = new C4509b(this.f1669h, C4215R.C4221layout.item_for_apply_mc_list, this.f16942k);
        this.f16944m = c4509b;
        this.f16943l.setAdapter(c4509b);
        this.f16943l.setEmptyView(findViewById(2131232952));
        m42146n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("状态申请列表");
        m57925b0(2131165495, new C4508a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16943l = (EmptyRecyclerView) findViewById(2131232481);
    }

    /* renamed from: n0 */
    public void m42146n0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m81q(LoginUser.getLoginUser().getUserId())).setDataListener(new C4510c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
