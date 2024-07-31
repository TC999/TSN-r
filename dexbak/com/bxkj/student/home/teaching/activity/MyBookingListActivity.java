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
public class MyBookingListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f16650k;

    /* renamed from: l */
    private EmptyRecyclerView f16651l;

    /* renamed from: m */
    private TextView f16652m;

    /* renamed from: o */
    private CommonAdapter<Map<String, Object>> f16654o;

    /* renamed from: n */
    private List<Map<String, Object>> f16653n = new ArrayList();

    /* renamed from: p */
    private int f16655p = 1;

    /* renamed from: q */
    private int f16656q = 15;

    /* renamed from: r */
    private int f16657r = 0;

    /* renamed from: com.bxkj.student.home.teaching.activity.MyBookingListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4413a extends CommonAdapter<Map<String, Object>> {
        C4413a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(C4215R.C4219id.tv11, JsonParse.getString(stringObjectMap, "activityName"));
            holder.m57874J(C4215R.C4219id.tv21, JsonParse.getString(stringObjectMap, "beginTime"));
            holder.m57874J(C4215R.C4219id.tv31, JsonParse.getString(stringObjectMap, "endTime"));
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.activity.MyBookingListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4414b implements OnRefreshLoadmoreListener {
        C4414b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            MyBookingListActivity.this.f16655p = 1;
            MyBookingListActivity.this.m42414t0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = MyBookingListActivity.this.f16657r / MyBookingListActivity.this.f16656q;
            int i2 = MyBookingListActivity.this.f16655p;
            if (MyBookingListActivity.this.f16657r % MyBookingListActivity.this.f16656q != 0) {
                i++;
            }
            if (i2 >= i) {
                MyBookingListActivity.this.f16650k.mo2041g();
                MyBookingListActivity.this.m57919h0("没有了");
                return;
            }
            MyBookingListActivity.m42420n0(MyBookingListActivity.this);
            MyBookingListActivity.this.m42414t0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.activity.MyBookingListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4415c extends HttpCallBack {
        C4415c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (MyBookingListActivity.this.f16650k != null && MyBookingListActivity.this.f16650k.mo2061S()) {
                MyBookingListActivity.this.f16650k.mo2078B();
            }
            if (MyBookingListActivity.this.f16650k == null || !MyBookingListActivity.this.f16650k.mo2015z()) {
                return;
            }
            MyBookingListActivity.this.f16650k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyBookingListActivity.this.f16653n = JsonParse.getList(data, "data");
            MyBookingListActivity.this.f16654o.m57836g(MyBookingListActivity.this.f16653n);
        }
    }

    /* renamed from: n0 */
    static /* synthetic */ int m42420n0(MyBookingListActivity myBookingListActivity) {
        int i = myBookingListActivity.f16655p;
        myBookingListActivity.f16655p = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t0 */
    public void m42414t0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m124b1(LoginUser.getLoginUser().getUserId(), this.f16655p, this.f16656q)).setDataListener(new C4415c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public /* synthetic */ void m42413u0(ViewGroup viewGroup, View view, Object obj, int i) {
        startActivity(new Intent(this.f1669h, BookingDetailActivity.class).putExtra("id", JsonParse.getString(this.f16654o.getItem(i), "id")));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16650k.mo2019v(new C4414b());
        this.f16650k.mo2052a0();
        this.f16654o.m57834k(new OnItemClickListener() { // from class: com.bxkj.student.home.teaching.activity.d
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
            /* renamed from: a */
            public final void mo39403a(ViewGroup viewGroup, View view, Object obj, int i) {
                MyBookingListActivity.this.m42413u0(viewGroup, view, obj, i);
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
        this.f16651l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4413a c4413a = new C4413a(this.f1669h, C4215R.C4221layout.item_for_my_booking_activity, this.f16653n);
        this.f16654o = c4413a;
        this.f16651l.setAdapter(c4413a);
        this.f16651l.setEmptyView(this.f16652m);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我预约的活动列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16650k = (SmartRefreshLayout) findViewById(2131232482);
        this.f16651l = (EmptyRecyclerView) findViewById(2131232481);
        this.f16652m = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        this.f16650k.mo2052a0();
    }
}
