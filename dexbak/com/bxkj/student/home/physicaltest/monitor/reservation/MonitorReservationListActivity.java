package com.bxkj.student.home.physicaltest.monitor.reservation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MonitorReservationListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f16527k;

    /* renamed from: l */
    private EmptyRecyclerView f16528l;

    /* renamed from: m */
    private List<Map<String, Object>> f16529m = new ArrayList();

    /* renamed from: n */
    private int f16530n = 1;

    /* renamed from: o */
    private int f16531o = 1;

    /* renamed from: p */
    private int f16532p = 10;

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f16533q;

    /* renamed from: r */
    private long f16534r;

    /* renamed from: com.bxkj.student.home.physicaltest.monitor.reservation.MonitorReservationListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4373a implements OnRefreshLoadmoreListener {
        C4373a() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            MonitorReservationListActivity.this.f16531o = 1;
            MonitorReservationListActivity.this.m42536u0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = MonitorReservationListActivity.this.f16530n / MonitorReservationListActivity.this.f16532p;
            int i2 = MonitorReservationListActivity.this.f16531o;
            if (MonitorReservationListActivity.this.f16530n % MonitorReservationListActivity.this.f16532p != 0) {
                i++;
            }
            if (i2 >= i) {
                MonitorReservationListActivity.this.f16527k.mo2041g();
                MonitorReservationListActivity.this.m57919h0("没有了");
                return;
            }
            MonitorReservationListActivity.m42544m0(MonitorReservationListActivity.this);
            MonitorReservationListActivity.this.m42536u0();
        }
    }

    /* renamed from: com.bxkj.student.home.physicaltest.monitor.reservation.MonitorReservationListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4374b extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.physicaltest.monitor.reservation.MonitorReservationListActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4375a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f16537a;

            View$OnClickListenerC4375a(final Map val$stringObjectMap) {
                this.f16537a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MonitorReservationListActivity.this.startActivity(new Intent(((CommonAdapter) C4374b.this).f1721a, MonitorReservationDetailActivity.class).putExtra("id", JsonParse.getString(this.f16537a, "id")));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.physicaltest.monitor.reservation.MonitorReservationListActivity$b$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4376b implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f16539a;

            View$OnClickListenerC4376b(final Map val$stringObjectMap) {
                this.f16539a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                C4374b c4374b = C4374b.this;
                MonitorReservationListActivity.this.m42535v0(((CommonAdapter) c4374b).f1721a, JsonParse.getString(this.f16539a, "id"));
            }
        }

        C4374b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131232981, JsonParse.getString(stringObjectMap, "scheduleName"));
            holder.m57874J(C4215R.C4219id.tv_reserve_time, JsonParse.getString(stringObjectMap, "appointmentBeginTime") + ShellAdbUtils.f33810d + JsonParse.getString(stringObjectMap, "appointmentEndTime"));
            holder.m57874J(C4215R.C4219id.tv_measure_time, JsonParse.getString(stringObjectMap, "meaBeginTime") + ShellAdbUtils.f33810d + JsonParse.getString(stringObjectMap, "meaEndTime"));
            holder.m57874J(C4215R.C4219id.tv_femail, "班级数:" + JsonParse.getString(stringObjectMap, "appliedClasses") + "/" + JsonParse.getInt(stringObjectMap, "appClassAmount"));
            holder.m57874J(2131233211, JsonParse.getString(stringObjectMap, "appointmentType").equals("2") ? "个人预约" : "班长预约");
            holder.m57847w(C4215R.C4219id.bt_detail, new View$OnClickListenerC4375a(stringObjectMap));
            Button button = (Button) holder.m57862h(C4215R.C4219id.bt_reservation);
            try {
                if (MonitorReservationListActivity.this.f16534r >= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(JsonParse.getString(stringObjectMap, "appointmentEndTime")).getTime()) {
                    button.setText("预约已结束");
                    button.setEnabled(false);
                } else if (JsonParse.getInt(stringObjectMap, "appliedClasses") >= JsonParse.getInt(stringObjectMap, "appClassAmount")) {
                    button.setText("预约班级已满");
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                    button.setText("立即预约");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            button.setOnClickListener(new View$OnClickListenerC4376b(stringObjectMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.monitor.reservation.MonitorReservationListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4377c extends HttpCallBack {
        C4377c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            MonitorReservationListActivity.this.f16527k.mo2078B();
            MonitorReservationListActivity.this.f16527k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MonitorReservationListActivity.this.f16534r = Long.parseLong(JsonParse.getString(data, "currentTime"));
            MonitorReservationListActivity.this.f16529m = (List) data.get("meaScheduleList");
            MonitorReservationListActivity.this.f16533q.m57836g(MonitorReservationListActivity.this.f16529m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.monitor.reservation.MonitorReservationListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4378d extends HttpCallBack {
        C4378d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MonitorReservationListActivity.this.m57919h0("预约成功");
            Activity activity = AppManager.m57776n().getActivity(MonitorReservationDetailActivity.class);
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* renamed from: m0 */
    static /* synthetic */ int m42544m0(MonitorReservationListActivity monitorReservationListActivity) {
        int i = monitorReservationListActivity.f16531o;
        monitorReservationListActivity.f16531o = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m42536u0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m91m1(LoginUser.getLoginUser().getUserId(), this.f16531o, this.f16532p)).setDataListener(new C4377c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return 2131427460;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f16527k.mo2019v(new C4373a());
        this.f16528l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f16528l.setLayoutAnimation(layoutAnimationController);
        C4374b c4374b = new C4374b(this.f1669h, C4215R.C4221layout.item_for_reserve_list, this.f16529m);
        this.f16533q = c4374b;
        this.f16528l.setAdapter(c4374b);
        this.f16527k.mo2050b0(true);
        this.f16527k.mo2064P(false);
        this.f16527k.mo2052a0();
        this.f16528l.setEmptyView(findViewById(2131232952));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("预约体测列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16527k = (SmartRefreshLayout) findViewById(2131232482);
        this.f16528l = (EmptyRecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* renamed from: v0 */
    public void m42535v0(Context mContext, String id) {
        Http.with(mContext).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m59x0(id, LoginUser.getLoginUser().getUserId())).setDataListener(new C4378d());
    }
}
