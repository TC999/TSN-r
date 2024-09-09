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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okhttp3.ResponseBody;
import r0.h;
import retrofit2.Response;
import s0.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RecordListFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private EmptyRecyclerView f23032h;

    /* renamed from: j  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f23034j;

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f23035k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f23036l;

    /* renamed from: q  reason: collision with root package name */
    private String f23041q;

    /* renamed from: i  reason: collision with root package name */
    private List<Map<String, Object>> f23033i = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private String f23037m = "all";

    /* renamed from: n  reason: collision with root package name */
    private int f23038n = 1;

    /* renamed from: o  reason: collision with root package name */
    private int f23039o = 15;

    /* renamed from: p  reason: collision with root package name */
    private int f23040p = 1;

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
            holder.J(2131233045, String.valueOf(holder.f() + 1));
            if ("all".equals(RecordListFragment.this.f23037m)) {
                holder.J(2131232941, JsonParse.getString(stringObjectMap, "machineName"));
                holder.J(2131233199, JsonParse.getString(stringObjectMap, "state"));
                holder.J(2131233166, JsonParse.getString(stringObjectMap, "weekNum"));
                holder.J(2131232954, JsonParse.getString(stringObjectMap, "punchDay") + "\u3000" + JsonParse.getString(stringObjectMap, "punchTime"));
                holder.K(2131233199, RecordListFragment.this.getResources().getColor(2131034198));
                return;
            }
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "sysUserName"));
            holder.J(2131233230, JsonParse.getString(stringObjectMap, "weekNum"));
            holder.J(2131233199, JsonParse.getString(stringObjectMap, "machineName"));
            holder.J(2131233166, JsonParse.getString(stringObjectMap, "punchDay"));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements e {
        b() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            RecordListFragment.this.f23038n = 1;
            RecordListFragment.this.Z();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = RecordListFragment.this.f23040p / RecordListFragment.this.f23039o;
            int i5 = RecordListFragment.this.f23038n;
            if (RecordListFragment.this.f23040p % RecordListFragment.this.f23039o != 0) {
                i4++;
            }
            if (i5 >= i4) {
                RecordListFragment.this.f23035k.h();
                RecordListFragment.this.D("\u6ca1\u6709\u4e86");
                return;
            }
            RecordListFragment.T(RecordListFragment.this);
            RecordListFragment.this.Z();
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

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (RecordListFragment.this.f23035k != null && RecordListFragment.this.f23035k.S()) {
                RecordListFragment.this.f23035k.y();
            }
            if (RecordListFragment.this.f23035k == null || !RecordListFragment.this.f23035k.z()) {
                return;
            }
            RecordListFragment.this.f23035k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            new iOSOneButtonDialog(((BaseFragment) RecordListFragment.this).f1665e).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RecordListFragment.this.f23040p = JsonParse.getInt(data, "total");
            if (RecordListFragment.this.f23038n == 1) {
                RecordListFragment.this.f23033i.clear();
            }
            RecordListFragment.this.f23033i.addAll(JsonParse.getList(data, "data"));
            RecordListFragment.this.f23034j.notifyDataSetChanged();
        }
    }

    static /* synthetic */ int T(RecordListFragment recordListFragment) {
        int i4 = recordListFragment.f23038n;
        recordListFragment.f23038n = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        rx.e<Response<ResponseBody>> F;
        if ("all".equals(this.f23037m)) {
            F = ((w.a) Http.getApiService(w.a.class)).c1(LoginUser.getLoginUser().getAccount(), this.f23041q, this.f23038n, this.f23039o);
        } else {
            F = ((w.a) Http.getApiService(w.a.class)).F(LoginUser.getLoginUser().getAccount(), this.f23041q, this.f23038n, this.f23039o);
        }
        Http.with(this.f1665e).setObservable(F).hideLoadingDialog().hideOtherStatusMessage().setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        if (getArguments() != null) {
            if (getArguments().containsKey("type")) {
                this.f23037m = getArguments().getString("type");
            }
            if (getArguments().containsKey("termId")) {
                this.f23041q = getArguments().getString("termId");
            }
        }
        int i4 = "all".equals(this.f23037m) ? 2131427741 : 2131427688;
        this.f23032h.setLayoutManager(new LinearLayoutManager(this.f1665e));
        a aVar = new a(this.f1665e, i4, this.f23033i);
        this.f23034j = aVar;
        this.f23032h.setAdapter(aVar);
        this.f23036l.setText("\u6682\u65e0\u6253\u5361\u6570\u636e\uff0c\u8d76\u5feb\u53bb\u6253\u5361\u5427\uff01");
        this.f23032h.setEmptyView(this.f23036l);
        this.f23035k.n1(new b());
        this.f23035k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f23032h = (EmptyRecyclerView) c(2131232481);
        this.f23035k = (SmartRefreshLayout) c(2131232482);
        this.f23036l = (TextView) c(2131232952);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131428026;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
