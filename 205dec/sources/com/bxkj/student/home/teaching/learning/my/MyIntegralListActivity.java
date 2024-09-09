package com.bxkj.student.home.teaching.learning.my;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.home.teaching.learning.m;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MyIntegralListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f20848k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f20849l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20850m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f20851n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private int f20852o = 20;

    /* renamed from: p  reason: collision with root package name */
    private int f20853p = 1;

    /* renamed from: q  reason: collision with root package name */
    private int f20854q = 0;

    /* renamed from: r  reason: collision with root package name */
    private CommonAdapter f20855r;

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
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "title"));
            holder.J(2131233198, JsonParse.getString(stringObjectMap, "integral"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements s0.e {
        b() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            MyIntegralListActivity.this.f20853p = 1;
            MyIntegralListActivity.this.s0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = MyIntegralListActivity.this.f20854q / MyIntegralListActivity.this.f20852o;
            int i5 = MyIntegralListActivity.this.f20853p;
            if (MyIntegralListActivity.this.f20854q % MyIntegralListActivity.this.f20852o != 0) {
                i4++;
            }
            if (i5 >= i4) {
                MyIntegralListActivity.this.f20848k.h();
                MyIntegralListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            MyIntegralListActivity.n0(MyIntegralListActivity.this);
            MyIntegralListActivity.this.s0();
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
            if (MyIntegralListActivity.this.f20848k != null && MyIntegralListActivity.this.f20848k.S()) {
                MyIntegralListActivity.this.f20848k.y();
            }
            if (MyIntegralListActivity.this.f20848k == null || !MyIntegralListActivity.this.f20848k.z()) {
                return;
            }
            MyIntegralListActivity.this.f20848k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyIntegralListActivity.this.f20854q = JsonParse.getInt(data, "total");
            if (MyIntegralListActivity.this.f20853p == 1) {
                MyIntegralListActivity.this.f20851n.clear();
            }
            MyIntegralListActivity.this.f20851n.addAll(JsonParse.getList(data, "data"));
            MyIntegralListActivity.this.f20855r.g(MyIntegralListActivity.this.f20851n);
        }
    }

    static /* synthetic */ int n0(MyIntegralListActivity myIntegralListActivity) {
        int i4 = myIntegralListActivity.f20853p;
        myIntegralListActivity.f20853p = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((m) Http.getApiService(m.class)).e(LoginUser.getLoginUser().getUserId(), getIntent().getStringExtra("resultType"), Integer.valueOf(this.f20852o), Integer.valueOf(this.f20853p))).setDataListener(new c());
    }

    private void t0() {
        this.f20848k.n1(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131428026;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f20849l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427764, this.f20851n);
        this.f20855r = aVar;
        this.f20849l.setAdapter(aVar);
        this.f20849l.setEmptyView(this.f20850m);
        t0();
        this.f20848k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u7684\u79ef\u5206");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20848k = (SmartRefreshLayout) findViewById(2131232482);
        this.f20849l = (EmptyRecyclerView) findViewById(2131232481);
        this.f20850m = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.f20848k.a0();
    }
}
