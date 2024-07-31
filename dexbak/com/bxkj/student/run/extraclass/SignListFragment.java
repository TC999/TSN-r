package com.bxkj.student.run.extraclass;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import p638r0.RefreshLayout;
import p640rx.Observable;
import p642s0.OnRefreshLoadmoreListener;
import p653w.InterfaceC16236a;
import retrofit2.Response;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SignListFragment extends BaseFragment {

    /* renamed from: h */
    private EmptyRecyclerView f19786h;

    /* renamed from: j */
    private CommonAdapter<Map<String, Object>> f19788j;

    /* renamed from: k */
    private SmartRefreshLayout f19789k;

    /* renamed from: l */
    private TextView f19790l;

    /* renamed from: q */
    private String f19795q;

    /* renamed from: i */
    private List<Map<String, Object>> f19787i = new ArrayList();

    /* renamed from: m */
    private String f19791m = "all";

    /* renamed from: n */
    private int f19792n = 1;

    /* renamed from: o */
    private int f19793o = 15;

    /* renamed from: p */
    private int f19794p = 1;

    /* renamed from: com.bxkj.student.run.extraclass.SignListFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5436a extends CommonAdapter<Map<String, Object>> {
        C5436a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233045, String.valueOf(holder.m57864f() + 1));
            holder.m57870N(2131231389, false);
            if ("all".equals(SignListFragment.this.f19791m)) {
                holder.m57874J(2131232941, JsonParse.getString(stringObjectMap, "punchDay"));
                holder.m57874J(C4215R.C4219id.tv_time_count, JsonParse.getString(stringObjectMap, "punchTime"));
                holder.m57874J(2131233166, JsonParse.getString(stringObjectMap, "type"));
                holder.m57874J(C4215R.C4219id.tv_end_time, JsonParse.getString(stringObjectMap, "status"));
                holder.m57873K(C4215R.C4219id.tv_end_time, ContextCompat.getColor(this.f1721a, 2131034198));
                return;
            }
            holder.m57874J(2131232941, JsonParse.getString(stringObjectMap, "punchOnTime"));
            holder.m57874J(C4215R.C4219id.tv_time_count, JsonParse.getString(stringObjectMap, "punchOffTime"));
            holder.m57874J(2131233166, JsonParse.getString(stringObjectMap, "punchDay"));
            holder.m57874J(C4215R.C4219id.tv_end_time, JsonParse.getString(stringObjectMap, "timeLength"));
        }
    }

    /* renamed from: com.bxkj.student.run.extraclass.SignListFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5437b implements OnRefreshLoadmoreListener {
        C5437b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            SignListFragment.this.f19792n = 1;
            SignListFragment.this.m39462Z();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = SignListFragment.this.f19794p / SignListFragment.this.f19793o;
            int i2 = SignListFragment.this.f19792n;
            if (SignListFragment.this.f19794p % SignListFragment.this.f19793o != 0) {
                i++;
            }
            if (i2 >= i) {
                SignListFragment.this.f19789k.mo2041g();
                SignListFragment.this.m57918D("没有了");
                return;
            }
            SignListFragment.m39468T(SignListFragment.this);
            SignListFragment.this.m39462Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.extraclass.SignListFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5438c extends HttpCallBack {
        C5438c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (SignListFragment.this.f19789k != null && SignListFragment.this.f19789k.mo2061S()) {
                SignListFragment.this.f19789k.mo2078B();
            }
            if (SignListFragment.this.f19789k == null || !SignListFragment.this.f19789k.mo2015z()) {
                return;
            }
            SignListFragment.this.f19789k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            new iOSOneButtonDialog(((BaseFragment) SignListFragment.this).f1678e).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SignListFragment.this.f19794p = JsonParse.getInt(data, "total");
            if (SignListFragment.this.f19792n == 1) {
                SignListFragment.this.f19787i.clear();
            }
            SignListFragment.this.f19787i.addAll(JsonParse.getList(data, "data"));
            SignListFragment.this.f19788j.notifyDataSetChanged();
        }
    }

    /* renamed from: T */
    static /* synthetic */ int m39468T(SignListFragment signListFragment) {
        int i = signListFragment.f19792n;
        signListFragment.f19792n = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public void m39462Z() {
        Observable<Response<ResponseBody>> m169G1;
        if ("all".equals(this.f19791m)) {
            m169G1 = ((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m90n(LoginUser.getLoginUser().getUserId(), this.f19795q, this.f19792n, this.f19793o);
        } else {
            m169G1 = ((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m169G1(LoginUser.getLoginUser().getUserId(), this.f19795q, this.f19792n, this.f19793o);
        }
        Http.with(this.f1678e).setObservable(m169G1).hideLoadingDialog().hideOtherStatusMessage().setDataListener(new C5438c());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    protected void mo39444e() {
        if (getArguments() != null) {
            if (getArguments().containsKey("type")) {
                this.f19791m = getArguments().getString("type");
            }
            if (getArguments().containsKey("termId")) {
                this.f19795q = getArguments().getString("termId");
            }
        }
        this.f19786h.setLayoutManager(new LinearLayoutManager(this.f1678e));
        C5436a c5436a = new C5436a(this.f1678e, C4215R.C4221layout.item_for_cg_sign_recorder_list, this.f19787i);
        this.f19788j = c5436a;
        this.f19786h.setAdapter(c5436a);
        this.f19790l.setText("暂无打卡数据，赶快去打卡吧！");
        this.f19786h.setEmptyView(this.f19790l);
        this.f19789k.mo2019v(new C5437b());
        this.f19789k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f19786h = (EmptyRecyclerView) m57916c(2131232481);
        this.f19789k = (SmartRefreshLayout) m57916c(2131232482);
        this.f19790l = (TextView) m57916c(2131232952);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return 2131428026;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
