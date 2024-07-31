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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.circle.CircleDetailActivity;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CircleFragment extends BaseFragment {

    /* renamed from: h */
    private SmartRefreshLayout f18590h;

    /* renamed from: i */
    private EmptyRecyclerView f18591i;

    /* renamed from: j */
    private TextView f18592j;

    /* renamed from: k */
    private TextView f18593k;

    /* renamed from: l */
    private TabLayout f18594l;

    /* renamed from: m */
    private CommonAdapter<Map<String, Object>> f18595m;

    /* renamed from: n */
    private List<Map<String, Object>> f18596n = new ArrayList();

    /* renamed from: o */
    private int f18597o = 10;

    /* renamed from: p */
    private int f18598p = 1;

    /* renamed from: q */
    private int f18599q = 0;

    /* renamed from: r */
    private String f18600r;

    /* renamed from: com.bxkj.student.main.CircleFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5067a extends CommonAdapter<Map<String, Object>> {
        C5067a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233040, "姓名：" + JsonParse.getString(stringObjectMap, "sysStudentName"));
            holder.m57874J(C4215R.C4219id.tv_lesson, "课程：" + JsonParse.getString(stringObjectMap, "teacherCurriculumName"));
            holder.m57874J(C4215R.C4219id.tv_teacher, "教师：" + JsonParse.getString(stringObjectMap, "sysTeacherName"));
            holder.m57874J(2131233050, "票数：" + JsonParse.getString(stringObjectMap, "votesTotalNumber"));
            holder.m57874J(2131233116, "排名：" + JsonParse.getString(stringObjectMap, "rank"));
            holder.m57850t(2131231426, JsonParse.getString(stringObjectMap, "sysStudentImage"), 2131558617, 2131558617);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.CircleFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5068b extends HttpCallBack {

        /* renamed from: com.bxkj.student.main.CircleFragment$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5069a implements TabLayout.OnTabSelectedListener {
            C5069a() {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabReselected(TabLayout.Tab tab) {
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabSelected(TabLayout.Tab tab) {
                CircleFragment.this.f18598p = 1;
                CircleFragment.this.f18600r = tab.getText().toString();
                CircleFragment.this.m40680d0();
            }

            @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
            public void onTabUnselected(TabLayout.Tab tab) {
            }
        }

        C5068b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CircleFragment.this.f18594l.setVisibility(0);
            CircleFragment.this.f18594l.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new C5069a());
            List<String> list = JsonParse.getList(data, "data", String.class);
            CircleFragment.this.f18594l.removeAllTabs();
            for (String str : list) {
                CircleFragment.this.f18594l.addTab(CircleFragment.this.f18594l.newTab().setText(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.CircleFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5070c implements OnRefreshLoadmoreListener {
        C5070c() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            CircleFragment.this.f18598p = 1;
            CircleFragment.this.m40680d0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = CircleFragment.this.f18599q / CircleFragment.this.f18597o;
            int i2 = CircleFragment.this.f18598p;
            if (CircleFragment.this.f18599q % CircleFragment.this.f18597o != 0) {
                i++;
            }
            if (i2 >= i) {
                CircleFragment.this.f18590h.mo2041g();
                Toast.makeText(((BaseFragment) CircleFragment.this).f1678e, "没有了", 0).show();
                return;
            }
            CircleFragment.m40690T(CircleFragment.this);
            CircleFragment.this.m40680d0();
        }
    }

    /* renamed from: T */
    static /* synthetic */ int m40690T(CircleFragment circleFragment) {
        int i = circleFragment.f18598p;
        circleFragment.f18598p = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0 */
    public void m40680d0() {
        if (!LoginUser.getLoginUser().isLogin()) {
            SmartRefreshLayout smartRefreshLayout = this.f18590h;
            if (smartRefreshLayout != null && smartRefreshLayout.mo2061S()) {
                this.f18590h.mo2078B();
            }
            SmartRefreshLayout smartRefreshLayout2 = this.f18590h;
            if (smartRefreshLayout2 == null || !smartRefreshLayout2.mo2015z()) {
                return;
            }
            this.f18590h.mo2041g();
            return;
        }
        Http.with(this.f1678e).hideLoadingDialog().hideSuccessMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m127a1(this.f18598p, this.f18597o, this.f18600r)).setDataListener(new C5071d());
    }

    /* renamed from: e0 */
    private void m40679e0() {
        LoginUser.getLoginUser().addLoginListener(new LoginUser.LoginListener() { // from class: com.bxkj.student.main.b
            @Override // com.bxkj.base.user.LoginUser.LoginListener
            public final void loginStatusChange(boolean z) {
                CircleFragment.this.m40676h0(z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g0 */
    public /* synthetic */ void m40677g0(ViewGroup viewGroup, View view, Object obj, int i) {
        startActivity(new Intent(this.f1678e, CircleDetailActivity.class).putExtra("learnSelectionWorkId", JsonParse.getString(this.f18595m.getItem(i), "id")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public void m40676h0(boolean isLogin) {
        if (isLogin) {
            if (!"79".equalsIgnoreCase(LoginUser.getLoginUser().getSchoolId()) && !"130".equalsIgnoreCase(LoginUser.getLoginUser().getSchoolId())) {
                this.f18594l.setVisibility(8);
                this.f18590h.mo2052a0();
                return;
            }
            Http.with(this.f1678e).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m84p()).setDataListener(new C5068b());
            return;
        }
        this.f18593k.setVisibility(8);
        this.f18596n.clear();
        this.f18595m.notifyDataSetChanged();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
        this.f18595m.m57834k(new OnItemClickListener() { // from class: com.bxkj.student.main.a
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
            /* renamed from: a */
            public final void mo39403a(ViewGroup viewGroup, View view, Object obj, int i) {
                CircleFragment.this.m40677g0(viewGroup, view, obj, i);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    protected void mo39444e() {
        this.f18591i.setLayoutManager(new LinearLayoutManager(this.f1678e));
        C5067a c5067a = new C5067a(this.f1678e, C4215R.C4221layout.item_for_circle, this.f18596n);
        this.f18595m = c5067a;
        this.f18591i.setAdapter(c5067a);
        this.f18591i.setEmptyView(this.f18592j);
        m40678f0();
        m40679e0();
        m40676h0(LoginUser.getLoginUser().isLogin());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f18590h = (SmartRefreshLayout) m57916c(2131232482);
        this.f18591i = (EmptyRecyclerView) m57916c(2131232481);
        this.f18592j = (TextView) m57916c(2131232952);
        this.f18593k = (TextView) m57916c(2131232939);
        this.f18594l = (TabLayout) m57916c(C4215R.C4219id.tb_type);
    }

    /* renamed from: f0 */
    public void m40678f0() {
        this.f18590h.mo2019v(new C5070c());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_circle;
    }

    /* renamed from: j0 */
    public void m40674j0() {
        this.f18590h.mo2052a0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.main.CircleFragment$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5071d extends HttpCallBack {
        C5071d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (CircleFragment.this.f18590h != null && CircleFragment.this.f18590h.mo2061S()) {
                CircleFragment.this.f18590h.mo2078B();
            }
            if (CircleFragment.this.f18590h == null || !CircleFragment.this.f18590h.mo2015z()) {
                return;
            }
            CircleFragment.this.f18590h.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
            if (!TextUtils.isEmpty(msg) && !"null".equalsIgnoreCase(msg)) {
                CircleFragment.this.f18593k.setText(msg);
            } else {
                CircleFragment.this.f18593k.setVisibility(8);
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CircleFragment.this.f18599q = JsonParse.getInt(data, "total");
            if (CircleFragment.this.f18599q > 0) {
                CircleFragment.this.f18593k.setVisibility(0);
            }
            if (CircleFragment.this.f18598p == 1) {
                CircleFragment.this.f18596n.clear();
            }
            CircleFragment.this.f18596n.addAll(JsonParse.getList(data, "data"));
            CircleFragment.this.f18595m.notifyDataSetChanged();
        }
    }
}
