package com.bxkj.student.main;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.circle.CircleDetailActivity;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CircleFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private SmartRefreshLayout f21897h;

    /* renamed from: i  reason: collision with root package name */
    private EmptyRecyclerView f21898i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f21899j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f21900k;

    /* renamed from: l  reason: collision with root package name */
    private TabLayout f21901l;

    /* renamed from: m  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21902m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f21903n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private int f21904o = 10;

    /* renamed from: p  reason: collision with root package name */
    private int f21905p = 1;

    /* renamed from: q  reason: collision with root package name */
    private int f21906q = 0;

    /* renamed from: r  reason: collision with root package name */
    private String f21907r;

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
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131233040, "\u59d3\u540d\uff1a" + JsonParse.getString(stringObjectMap, "sysStudentName"));
            holder.J(2131233012, "\u8bfe\u7a0b\uff1a" + JsonParse.getString(stringObjectMap, "teacherCurriculumName"));
            holder.J(2131233191, "\u6559\u5e08\uff1a" + JsonParse.getString(stringObjectMap, "sysTeacherName"));
            holder.J(2131233050, "\u7968\u6570\uff1a" + JsonParse.getString(stringObjectMap, "votesTotalNumber"));
            holder.J(2131233116, "\u6392\u540d\uff1a" + JsonParse.getString(stringObjectMap, "rank"));
            holder.t(2131231426, JsonParse.getString(stringObjectMap, "sysStudentImage"), 2131558617, 2131558617);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements TabLayout.OnTabSelectedListener {
            a() {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                CircleFragment.this.f21905p = 1;
                CircleFragment.this.f21907r = tab.getText().toString();
                CircleFragment.this.d0();
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CircleFragment.this.f21901l.setVisibility(0);
            CircleFragment.this.f21901l.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new a());
            List<String> list = JsonParse.getList(data, "data", String.class);
            CircleFragment.this.f21901l.removeAllTabs();
            for (String str : list) {
                CircleFragment.this.f21901l.addTab(CircleFragment.this.f21901l.newTab().setText(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c implements s0.e {
        c() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            CircleFragment.this.f21905p = 1;
            CircleFragment.this.d0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = CircleFragment.this.f21906q / CircleFragment.this.f21904o;
            int i5 = CircleFragment.this.f21905p;
            if (CircleFragment.this.f21906q % CircleFragment.this.f21904o != 0) {
                i4++;
            }
            if (i5 >= i4) {
                CircleFragment.this.f21897h.h();
                Toast.makeText(((BaseFragment) CircleFragment.this).f1665e, "\u6ca1\u6709\u4e86", 0).show();
                return;
            }
            CircleFragment.T(CircleFragment.this);
            CircleFragment.this.d0();
        }
    }

    static /* synthetic */ int T(CircleFragment circleFragment) {
        int i4 = circleFragment.f21905p;
        circleFragment.f21905p = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        if (!LoginUser.getLoginUser().isLogin()) {
            SmartRefreshLayout smartRefreshLayout = this.f21897h;
            if (smartRefreshLayout != null && smartRefreshLayout.S()) {
                this.f21897h.y();
            }
            SmartRefreshLayout smartRefreshLayout2 = this.f21897h;
            if (smartRefreshLayout2 == null || !smartRefreshLayout2.z()) {
                return;
            }
            this.f21897h.h();
            return;
        }
        Http.with(this.f1665e).hideLoadingDialog().hideSuccessMessage().setObservable(((w.a) Http.getApiService(w.a.class)).a1(this.f21905p, this.f21904o, this.f21907r)).setDataListener(new d());
    }

    private void e0() {
        LoginUser.getLoginUser().addLoginListener(new LoginUser.LoginListener() { // from class: com.bxkj.student.main.b
            @Override // com.bxkj.base.user.LoginUser.LoginListener
            public final void loginStatusChange(boolean z3) {
                CircleFragment.this.h0(z3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(ViewGroup viewGroup, View view, Object obj, int i4) {
        startActivity(new Intent(this.f1665e, CircleDetailActivity.class).putExtra("learnSelectionWorkId", JsonParse.getString(this.f21902m.getItem(i4), "id")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public void h0(boolean isLogin) {
        if (isLogin) {
            if (!"79".equalsIgnoreCase(LoginUser.getLoginUser().getSchoolId()) && !"130".equalsIgnoreCase(LoginUser.getLoginUser().getSchoolId())) {
                this.f21901l.setVisibility(8);
                this.f21897h.a0();
                return;
            }
            Http.with(this.f1665e).setObservable(((w.a) Http.getApiService(w.a.class)).p()).setDataListener(new b());
            return;
        }
        this.f21900k.setVisibility(8);
        this.f21903n.clear();
        this.f21902m.notifyDataSetChanged();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f21902m.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.main.a
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i4) {
                CircleFragment.this.g0(viewGroup, view, obj, i4);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        this.f21898i.setLayoutManager(new LinearLayoutManager(this.f1665e));
        a aVar = new a(this.f1665e, 2131427678, this.f21903n);
        this.f21902m = aVar;
        this.f21898i.setAdapter(aVar);
        this.f21898i.setEmptyView(this.f21899j);
        f0();
        e0();
        h0(LoginUser.getLoginUser().isLogin());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f21897h = (SmartRefreshLayout) c(2131232482);
        this.f21898i = (EmptyRecyclerView) c(2131232481);
        this.f21899j = (TextView) c(2131232952);
        this.f21900k = (TextView) c(2131232939);
        this.f21901l = (TabLayout) c(2131232721);
    }

    public void f0() {
        this.f21897h.n1(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427623;
    }

    public void j0() {
        this.f21897h.a0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (CircleFragment.this.f21897h != null && CircleFragment.this.f21897h.S()) {
                CircleFragment.this.f21897h.y();
            }
            if (CircleFragment.this.f21897h == null || !CircleFragment.this.f21897h.z()) {
                return;
            }
            CircleFragment.this.f21897h.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
            if (!TextUtils.isEmpty(msg) && !"null".equalsIgnoreCase(msg)) {
                CircleFragment.this.f21900k.setText(msg);
            } else {
                CircleFragment.this.f21900k.setVisibility(8);
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CircleFragment.this.f21906q = JsonParse.getInt(data, "total");
            if (CircleFragment.this.f21906q > 0) {
                CircleFragment.this.f21900k.setVisibility(0);
            }
            if (CircleFragment.this.f21905p == 1) {
                CircleFragment.this.f21903n.clear();
            }
            CircleFragment.this.f21903n.addAll(JsonParse.getList(data, "data"));
            CircleFragment.this.f21902m.notifyDataSetChanged();
        }
    }
}
