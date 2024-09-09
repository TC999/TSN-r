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
public class SignListFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private EmptyRecyclerView f23016h;

    /* renamed from: j  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f23018j;

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f23019k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f23020l;

    /* renamed from: q  reason: collision with root package name */
    private String f23025q;

    /* renamed from: i  reason: collision with root package name */
    private List<Map<String, Object>> f23017i = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private String f23021m = "all";

    /* renamed from: n  reason: collision with root package name */
    private int f23022n = 1;

    /* renamed from: o  reason: collision with root package name */
    private int f23023o = 15;

    /* renamed from: p  reason: collision with root package name */
    private int f23024p = 1;

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
            holder.N(2131231389, false);
            if ("all".equals(SignListFragment.this.f23021m)) {
                holder.J(2131232941, JsonParse.getString(stringObjectMap, "punchDay"));
                holder.J(2131233199, JsonParse.getString(stringObjectMap, "punchTime"));
                holder.J(2131233166, JsonParse.getString(stringObjectMap, "type"));
                holder.J(2131232954, JsonParse.getString(stringObjectMap, "status"));
                holder.K(2131232954, ContextCompat.getColor(this.f1707a, 2131034198));
                return;
            }
            holder.J(2131232941, JsonParse.getString(stringObjectMap, "punchOnTime"));
            holder.J(2131233199, JsonParse.getString(stringObjectMap, "punchOffTime"));
            holder.J(2131233166, JsonParse.getString(stringObjectMap, "punchDay"));
            holder.J(2131232954, JsonParse.getString(stringObjectMap, "timeLength"));
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
            SignListFragment.this.f23022n = 1;
            SignListFragment.this.Z();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = SignListFragment.this.f23024p / SignListFragment.this.f23023o;
            int i5 = SignListFragment.this.f23022n;
            if (SignListFragment.this.f23024p % SignListFragment.this.f23023o != 0) {
                i4++;
            }
            if (i5 >= i4) {
                SignListFragment.this.f23019k.h();
                SignListFragment.this.D("\u6ca1\u6709\u4e86");
                return;
            }
            SignListFragment.T(SignListFragment.this);
            SignListFragment.this.Z();
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
            if (SignListFragment.this.f23019k != null && SignListFragment.this.f23019k.S()) {
                SignListFragment.this.f23019k.y();
            }
            if (SignListFragment.this.f23019k == null || !SignListFragment.this.f23019k.z()) {
                return;
            }
            SignListFragment.this.f23019k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            new iOSOneButtonDialog(((BaseFragment) SignListFragment.this).f1665e).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SignListFragment.this.f23024p = JsonParse.getInt(data, "total");
            if (SignListFragment.this.f23022n == 1) {
                SignListFragment.this.f23017i.clear();
            }
            SignListFragment.this.f23017i.addAll(JsonParse.getList(data, "data"));
            SignListFragment.this.f23018j.notifyDataSetChanged();
        }
    }

    static /* synthetic */ int T(SignListFragment signListFragment) {
        int i4 = signListFragment.f23022n;
        signListFragment.f23022n = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        rx.e<Response<ResponseBody>> G1;
        if ("all".equals(this.f23021m)) {
            G1 = ((w.a) Http.getApiService(w.a.class)).n(LoginUser.getLoginUser().getUserId(), this.f23025q, this.f23022n, this.f23023o);
        } else {
            G1 = ((w.a) Http.getApiService(w.a.class)).G1(LoginUser.getLoginUser().getUserId(), this.f23025q, this.f23022n, this.f23023o);
        }
        Http.with(this.f1665e).setObservable(G1).hideLoadingDialog().hideOtherStatusMessage().setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        if (getArguments() != null) {
            if (getArguments().containsKey("type")) {
                this.f23021m = getArguments().getString("type");
            }
            if (getArguments().containsKey("termId")) {
                this.f23025q = getArguments().getString("termId");
            }
        }
        this.f23016h.setLayoutManager(new LinearLayoutManager(this.f1665e));
        a aVar = new a(this.f1665e, 2131427675, this.f23017i);
        this.f23018j = aVar;
        this.f23016h.setAdapter(aVar);
        this.f23020l.setText("\u6682\u65e0\u6253\u5361\u6570\u636e\uff0c\u8d76\u5feb\u53bb\u6253\u5361\u5427\uff01");
        this.f23016h.setEmptyView(this.f23020l);
        this.f23019k.n1(new b());
        this.f23019k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f23016h = (EmptyRecyclerView) c(2131232481);
        this.f23019k = (SmartRefreshLayout) c(2131232482);
        this.f23020l = (TextView) c(2131232952);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131428026;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
