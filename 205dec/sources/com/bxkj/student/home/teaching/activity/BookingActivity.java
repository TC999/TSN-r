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
public class BookingActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f20003k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f20004l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20005m;

    /* renamed from: o  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f20007o;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f20006n = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private int f20008p = 1;

    /* renamed from: q  reason: collision with root package name */
    private int f20009q = 15;

    /* renamed from: r  reason: collision with root package name */
    private int f20010r = 0;

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
            holder.J(2131232821, JsonParse.getString(stringObjectMap, "name"));
            holder.J(2131232823, JsonParse.getString(stringObjectMap, "orderDate"));
            holder.J(2131232825, JsonParse.getString(stringObjectMap, "activeDate"));
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
            BookingActivity.this.f20008p = 1;
            BookingActivity.this.t0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = BookingActivity.this.f20010r / BookingActivity.this.f20009q;
            int i5 = BookingActivity.this.f20008p;
            if (BookingActivity.this.f20010r % BookingActivity.this.f20009q != 0) {
                i4++;
            }
            if (i5 >= i4) {
                BookingActivity.this.f20003k.h();
                BookingActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            BookingActivity.n0(BookingActivity.this);
            BookingActivity.this.t0();
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
            if (BookingActivity.this.f20003k != null && BookingActivity.this.f20003k.S()) {
                BookingActivity.this.f20003k.y();
            }
            if (BookingActivity.this.f20003k == null || !BookingActivity.this.f20003k.z()) {
                return;
            }
            BookingActivity.this.f20003k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BookingActivity.this.f20006n = JsonParse.getList(data, "data");
            BookingActivity.this.f20007o.g(BookingActivity.this.f20006n);
        }
    }

    static /* synthetic */ int n0(BookingActivity bookingActivity) {
        int i4 = bookingActivity.f20008p;
        bookingActivity.f20008p = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((w.a) Http.getApiService(w.a.class)).o(LoginUser.getLoginUser().getUserId(), this.f20008p, this.f20009q)).setDataListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(ViewGroup viewGroup, View view, Object obj, int i4) {
        startActivity(new Intent(this.f1656h, BookingDetailActivity.class).putExtra("id", JsonParse.getString(this.f20007o.getItem(i4), "id")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20003k.n1(new b());
        this.f20003k.a0();
        this.f20007o.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.home.teaching.activity.a
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i4) {
                BookingActivity.this.u0(viewGroup, view, obj, i4);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427460;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f20004l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427673, this.f20006n);
        this.f20007o = aVar;
        this.f20004l.setAdapter(aVar);
        this.f20004l.setEmptyView(this.f20005m);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u9884\u7ea6\u6d3b\u52a8\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20003k = (SmartRefreshLayout) findViewById(2131232482);
        this.f20004l = (EmptyRecyclerView) findViewById(2131232481);
        this.f20005m = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
