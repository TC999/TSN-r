package com.bxkj.student.run.punchcard;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
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
public class RecordListFragment extends BaseFragment {

    /* renamed from: h */
    private EmptyRecyclerView f19802h;

    /* renamed from: j */
    private CommonAdapter<Map<String, Object>> f19804j;

    /* renamed from: k */
    private SmartRefreshLayout f19805k;

    /* renamed from: l */
    private TextView f19806l;

    /* renamed from: q */
    private String f19811q;

    /* renamed from: i */
    private List<Map<String, Object>> f19803i = new ArrayList();

    /* renamed from: m */
    private String f19807m = "all";

    /* renamed from: n */
    private int f19808n = 1;

    /* renamed from: o */
    private int f19809o = 15;

    /* renamed from: p */
    private int f19810p = 1;

    /* renamed from: com.bxkj.student.run.punchcard.RecordListFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5442a extends CommonAdapter<Map<String, Object>> {
        C5442a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233045, String.valueOf(holder.m57864f() + 1));
            if ("all".equals(RecordListFragment.this.f19807m)) {
                holder.m57874J(2131232941, JsonParse.getString(stringObjectMap, "machineName"));
                holder.m57874J(C4215R.C4219id.tv_time_count, JsonParse.getString(stringObjectMap, "state"));
                holder.m57874J(2131233166, JsonParse.getString(stringObjectMap, "weekNum"));
                holder.m57874J(C4215R.C4219id.tv_end_time, JsonParse.getString(stringObjectMap, "punchDay") + "\u3000" + JsonParse.getString(stringObjectMap, "punchTime"));
                holder.m57873K(C4215R.C4219id.tv_time_count, RecordListFragment.this.getResources().getColor(2131034198));
                return;
            }
            holder.m57874J(2131233040, JsonParse.getString(stringObjectMap, "sysUserName"));
            holder.m57874J(C4215R.C4219id.tv_week, JsonParse.getString(stringObjectMap, "weekNum"));
            holder.m57874J(C4215R.C4219id.tv_time_count, JsonParse.getString(stringObjectMap, "machineName"));
            holder.m57874J(2131233166, JsonParse.getString(stringObjectMap, "punchDay"));
        }
    }

    /* renamed from: com.bxkj.student.run.punchcard.RecordListFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5443b implements OnRefreshLoadmoreListener {
        C5443b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            RecordListFragment.this.f19808n = 1;
            RecordListFragment.this.m39446Z();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = RecordListFragment.this.f19810p / RecordListFragment.this.f19809o;
            int i2 = RecordListFragment.this.f19808n;
            if (RecordListFragment.this.f19810p % RecordListFragment.this.f19809o != 0) {
                i++;
            }
            if (i2 >= i) {
                RecordListFragment.this.f19805k.mo2041g();
                RecordListFragment.this.m57918D("没有了");
                return;
            }
            RecordListFragment.m39452T(RecordListFragment.this);
            RecordListFragment.this.m39446Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.punchcard.RecordListFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5444c extends HttpCallBack {
        C5444c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (RecordListFragment.this.f19805k != null && RecordListFragment.this.f19805k.mo2061S()) {
                RecordListFragment.this.f19805k.mo2078B();
            }
            if (RecordListFragment.this.f19805k == null || !RecordListFragment.this.f19805k.mo2015z()) {
                return;
            }
            RecordListFragment.this.f19805k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            new iOSOneButtonDialog(((BaseFragment) RecordListFragment.this).f1678e).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RecordListFragment.this.f19810p = JsonParse.getInt(data, "total");
            if (RecordListFragment.this.f19808n == 1) {
                RecordListFragment.this.f19803i.clear();
            }
            RecordListFragment.this.f19803i.addAll(JsonParse.getList(data, "data"));
            RecordListFragment.this.f19804j.notifyDataSetChanged();
        }
    }

    /* renamed from: T */
    static /* synthetic */ int m39452T(RecordListFragment recordListFragment) {
        int i = recordListFragment.f19808n;
        recordListFragment.f19808n = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public void m39446Z() {
        Observable<Response<ResponseBody>> m174F;
        if ("all".equals(this.f19807m)) {
            m174F = ((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m121c1(LoginUser.getLoginUser().getAccount(), this.f19811q, this.f19808n, this.f19809o);
        } else {
            m174F = ((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m174F(LoginUser.getLoginUser().getAccount(), this.f19811q, this.f19808n, this.f19809o);
        }
        Http.with(this.f1678e).setObservable(m174F).hideLoadingDialog().hideOtherStatusMessage().setDataListener(new C5444c());
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
                this.f19807m = getArguments().getString("type");
            }
            if (getArguments().containsKey("termId")) {
                this.f19811q = getArguments().getString("termId");
            }
        }
        int i = "all".equals(this.f19807m) ? C4215R.C4221layout.item_for_punchcard_recorder_list : C4215R.C4221layout.item_for_effective_recorder_list;
        this.f19802h.setLayoutManager(new LinearLayoutManager(this.f1678e));
        C5442a c5442a = new C5442a(this.f1678e, i, this.f19803i);
        this.f19804j = c5442a;
        this.f19802h.setAdapter(c5442a);
        this.f19806l.setText("暂无打卡数据，赶快去打卡吧！");
        this.f19802h.setEmptyView(this.f19806l);
        this.f19805k.mo2019v(new C5443b());
        this.f19805k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f19802h = (EmptyRecyclerView) m57916c(2131232481);
        this.f19805k = (SmartRefreshLayout) m57916c(2131232482);
        this.f19806l = (TextView) m57916c(2131232952);
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
