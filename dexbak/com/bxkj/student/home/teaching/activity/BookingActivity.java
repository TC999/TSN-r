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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BookingActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f16613k;

    /* renamed from: l */
    private EmptyRecyclerView f16614l;

    /* renamed from: m */
    private TextView f16615m;

    /* renamed from: o */
    private CommonAdapter<Map<String, Object>> f16617o;

    /* renamed from: n */
    private List<Map<String, Object>> f16616n = new ArrayList();

    /* renamed from: p */
    private int f16618p = 1;

    /* renamed from: q */
    private int f16619q = 15;

    /* renamed from: r */
    private int f16620r = 0;

    /* renamed from: com.bxkj.student.home.teaching.activity.BookingActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4402a extends CommonAdapter<Map<String, Object>> {
        C4402a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv11, JsonParse.getString(stringObjectMap, "name"));
            holder.m57874J(C4215R.C4219id.tv21, JsonParse.getString(stringObjectMap, "orderDate"));
            holder.m57874J(C4215R.C4219id.tv31, JsonParse.getString(stringObjectMap, "activeDate"));
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.activity.BookingActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4403b implements OnRefreshLoadmoreListener {
        C4403b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            BookingActivity.this.f16618p = 1;
            BookingActivity.this.m42458t0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = BookingActivity.this.f16620r / BookingActivity.this.f16619q;
            int i2 = BookingActivity.this.f16618p;
            if (BookingActivity.this.f16620r % BookingActivity.this.f16619q != 0) {
                i++;
            }
            if (i2 >= i) {
                BookingActivity.this.f16613k.mo2041g();
                BookingActivity.this.m57919h0("没有了");
                return;
            }
            BookingActivity.m42464n0(BookingActivity.this);
            BookingActivity.this.m42458t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.activity.BookingActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4404c extends HttpCallBack {
        C4404c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (BookingActivity.this.f16613k != null && BookingActivity.this.f16613k.mo2061S()) {
                BookingActivity.this.f16613k.mo2078B();
            }
            if (BookingActivity.this.f16613k == null || !BookingActivity.this.f16613k.mo2015z()) {
                return;
            }
            BookingActivity.this.f16613k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            BookingActivity.this.f16616n = JsonParse.getList(data, "data");
            BookingActivity.this.f16617o.m57836g(BookingActivity.this.f16616n);
        }
    }

    /* renamed from: n0 */
    static /* synthetic */ int m42464n0(BookingActivity bookingActivity) {
        int i = bookingActivity.f16618p;
        bookingActivity.f16618p = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public void m42458t0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m87o(LoginUser.getLoginUser().getUserId(), this.f16618p, this.f16619q)).setDataListener(new C4404c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void m42457u0(ViewGroup viewGroup, View view, Object obj, int i) {
        startActivity(new Intent(this.f1669h, BookingDetailActivity.class).putExtra("id", JsonParse.getString(this.f16617o.getItem(i), "id")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16613k.mo2019v(new C4403b());
        this.f16613k.mo2052a0();
        this.f16617o.m57834k(new OnItemClickListener() { // from class: com.bxkj.student.home.teaching.activity.a
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
            /* renamed from: a */
            public final void mo39403a(ViewGroup viewGroup, View view, Object obj, int i) {
                BookingActivity.this.m42457u0(viewGroup, view, obj, i);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return 2131427460;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f16614l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4402a c4402a = new C4402a(this.f1669h, C4215R.C4221layout.item_for_booking_activity, this.f16616n);
        this.f16617o = c4402a;
        this.f16614l.setAdapter(c4402a);
        this.f16614l.setEmptyView(this.f16615m);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("预约活动列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16613k = (SmartRefreshLayout) findViewById(2131232482);
        this.f16614l = (EmptyRecyclerView) findViewById(2131232481);
        this.f16615m = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
