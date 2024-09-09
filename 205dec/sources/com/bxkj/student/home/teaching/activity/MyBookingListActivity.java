package com.bxkj.student.home.teaching.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;
import s0.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MyBookingListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f20040k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f20041l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20042m;

    /* renamed from: o  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f20044o;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f20043n = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private int f20045p = 1;

    /* renamed from: q  reason: collision with root package name */
    private int f20046q = 15;

    /* renamed from: r  reason: collision with root package name */
    private int f20047r = 0;

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
            holder.J(2131232821, JsonParse.getString(stringObjectMap, "activityName"));
            holder.J(2131232823, JsonParse.getString(stringObjectMap, "beginTime"));
            holder.J(2131232825, JsonParse.getString(stringObjectMap, "endTime"));
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
            MyBookingListActivity.this.f20045p = 1;
            MyBookingListActivity.this.t0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = MyBookingListActivity.this.f20047r / MyBookingListActivity.this.f20046q;
            int i5 = MyBookingListActivity.this.f20045p;
            if (MyBookingListActivity.this.f20047r % MyBookingListActivity.this.f20046q != 0) {
                i4++;
            }
            if (i5 >= i4) {
                MyBookingListActivity.this.f20040k.h();
                MyBookingListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            MyBookingListActivity.n0(MyBookingListActivity.this);
            MyBookingListActivity.this.t0();
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
            if (MyBookingListActivity.this.f20040k != null && MyBookingListActivity.this.f20040k.S()) {
                MyBookingListActivity.this.f20040k.y();
            }
            if (MyBookingListActivity.this.f20040k == null || !MyBookingListActivity.this.f20040k.z()) {
                return;
            }
            MyBookingListActivity.this.f20040k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyBookingListActivity.this.f20043n = JsonParse.getList(data, "data");
            MyBookingListActivity.this.f20044o.g(MyBookingListActivity.this.f20043n);
        }
    }

    static /* synthetic */ int n0(MyBookingListActivity myBookingListActivity) {
        int i4 = myBookingListActivity.f20045p;
        myBookingListActivity.f20045p = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((w.a) Http.getApiService(w.a.class)).b1(LoginUser.getLoginUser().getUserId(), this.f20045p, this.f20046q)).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(ViewGroup viewGroup, View view, Object obj, int i4) {
        startActivity(new Intent(this.f1656h, BookingDetailActivity.class).putExtra("id", JsonParse.getString(this.f20044o.getItem(i4), "id")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20040k.n1(new b());
        this.f20040k.a0();
        this.f20044o.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.home.teaching.activity.d
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i4) {
                MyBookingListActivity.this.u0(viewGroup, view, obj, i4);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427460;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f20041l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427727, this.f20043n);
        this.f20044o = aVar;
        this.f20041l.setAdapter(aVar);
        this.f20041l.setEmptyView(this.f20042m);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u9884\u7ea6\u7684\u6d3b\u52a8\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20040k = (SmartRefreshLayout) findViewById(2131232482);
        this.f20041l = (EmptyRecyclerView) findViewById(2131232481);
        this.f20042m = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.f20040k.a0();
    }
}
