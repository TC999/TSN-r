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
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ApplyHealthStatusListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private List<Map<String, Object>> f20312k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f20313l;

    /* renamed from: m  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f20314m;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements BaseActivity.c {
        a() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            ApplyHealthStatusListActivity.this.startActivity(new Intent(((BaseActivity) ApplyHealthStatusListActivity.this).f1656h, ApplyHealthStudentActivity.class));
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
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "applyerName"));
            holder.J(2131233194, JsonParse.getString(stringObjectMap, "applyDate"));
            holder.J(2131233211, JsonParse.getString(stringObjectMap, "type"));
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
            ApplyHealthStatusListActivity.this.f20312k = JsonParse.getList(data, "data");
            ApplyHealthStatusListActivity.this.f20314m.g(ApplyHealthStatusListActivity.this.f20312k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(ViewGroup viewGroup, View view, Object obj, int i4) {
        startActivity(new Intent(this.f1656h, ApplyHealthStatusDetailActivity.class).putExtra("id", JsonParse.getString(this.f20314m.getItem(i4), "id")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20314m.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.home.teaching.healthstatus.b
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i4) {
                ApplyHealthStatusListActivity.this.o0(viewGroup, view, obj, i4);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131428025;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f20313l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1656h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f20313l.setLayoutAnimation(layoutAnimationController);
        b bVar = new b(this.f1656h, 2131427669, this.f20312k);
        this.f20314m = bVar;
        this.f20313l.setAdapter(bVar);
        this.f20313l.setEmptyView(findViewById(2131232952));
        n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u72b6\u6001\u7533\u8bf7\u5217\u8868");
        b0(2131165495, new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20313l = (EmptyRecyclerView) findViewById(2131232481);
    }

    public void n0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).q(LoginUser.getLoginUser().getUserId())).setDataListener(new c());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
