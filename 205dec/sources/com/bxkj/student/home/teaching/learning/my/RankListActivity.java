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
public class RankListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f20883k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f20884l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20885m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f20886n = new ArrayList();

    /* renamed from: o  reason: collision with root package name */
    private int f20887o = 10;

    /* renamed from: p  reason: collision with root package name */
    private int f20888p = 1;

    /* renamed from: q  reason: collision with root package name */
    private int f20889q = 0;

    /* renamed from: r  reason: collision with root package name */
    private CommonAdapter f20890r;

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
            holder.J(2131233045, String.valueOf(e(holder) + 1));
            holder.J(2131233040, JsonParse.getString(stringObjectMap, "name"));
            holder.J(2131233198, JsonParse.getString(stringObjectMap, "sumIntegral"));
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
            RankListActivity.this.f20888p = 1;
            RankListActivity.this.s0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = RankListActivity.this.f20889q / RankListActivity.this.f20887o;
            int i5 = RankListActivity.this.f20888p;
            if (RankListActivity.this.f20889q % RankListActivity.this.f20887o != 0) {
                i4++;
            }
            if (i5 >= i4) {
                RankListActivity.this.f20883k.h();
                RankListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            RankListActivity.n0(RankListActivity.this);
            RankListActivity.this.s0();
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
            if (RankListActivity.this.f20883k != null && RankListActivity.this.f20883k.S()) {
                RankListActivity.this.f20883k.y();
            }
            if (RankListActivity.this.f20883k == null || !RankListActivity.this.f20883k.z()) {
                return;
            }
            RankListActivity.this.f20883k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RankListActivity.this.f20889q = JsonParse.getInt(data, "total");
            if (RankListActivity.this.f20888p == 1) {
                RankListActivity.this.f20886n.clear();
            }
            RankListActivity.this.f20886n.addAll(JsonParse.getList(data, "data"));
            RankListActivity.this.f20890r.g(RankListActivity.this.f20886n);
        }
    }

    static /* synthetic */ int n0(RankListActivity rankListActivity) {
        int i4 = rankListActivity.f20888p;
        rankListActivity.f20888p = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((m) Http.getApiService(m.class)).e(LoginUser.getLoginUser().getUserId(), getIntent().getStringExtra("resultType"), Integer.valueOf(this.f20887o), Integer.valueOf(this.f20888p))).setDataListener(new c());
    }

    private void t0() {
        this.f20883k.n1(new b());
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
        this.f20884l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427745, this.f20886n);
        this.f20890r = aVar;
        this.f20884l.setAdapter(aVar);
        this.f20884l.setEmptyView(this.f20885m);
        t0();
        this.f20883k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u603b\u6392\u540d");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20883k = (SmartRefreshLayout) findViewById(2131232482);
        this.f20884l = (EmptyRecyclerView) findViewById(2131232481);
        this.f20885m = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.f20883k.a0();
    }
}
