package com.bxkj.student.home.physicaltest.personal.reservation;

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
public class ReservationListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f16580k;

    /* renamed from: l */
    private EmptyRecyclerView f16581l;

    /* renamed from: m */
    private List<Map<String, Object>> f16582m = new ArrayList();

    /* renamed from: n */
    private int f16583n = 1;

    /* renamed from: o */
    private int f16584o = 1;

    /* renamed from: p */
    private int f16585p = 10;

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f16586q;

    /* renamed from: r */
    private long f16587r;

    /* renamed from: com.bxkj.student.home.physicaltest.personal.reservation.ReservationListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4390a implements OnRefreshLoadmoreListener {
        C4390a() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            ReservationListActivity.this.f16584o = 1;
            ReservationListActivity.this.m42489u0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = ReservationListActivity.this.f16583n / ReservationListActivity.this.f16585p;
            int i2 = ReservationListActivity.this.f16584o;
            if (ReservationListActivity.this.f16583n % ReservationListActivity.this.f16585p != 0) {
                i++;
            }
            if (i2 >= i) {
                ReservationListActivity.this.f16580k.mo2041g();
                ReservationListActivity.this.m57919h0("没有了");
                return;
            }
            ReservationListActivity.m42497m0(ReservationListActivity.this);
            ReservationListActivity.this.m42489u0();
        }
    }

    /* renamed from: com.bxkj.student.home.physicaltest.personal.reservation.ReservationListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4391b extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.physicaltest.personal.reservation.ReservationListActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4392a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f16590a;

            View$OnClickListenerC4392a(final Map val$stringObjectMap) {
                this.f16590a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ReservationListActivity.this.startActivity(new Intent(((CommonAdapter) C4391b.this).f1721a, ReservationDetailActivity.class).putExtra("id", JsonParse.getString(this.f16590a, "id")));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.physicaltest.personal.reservation.ReservationListActivity$b$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4393b implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f16592a;

            View$OnClickListenerC4393b(final Map val$stringObjectMap) {
                this.f16592a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                C4391b c4391b = C4391b.this;
                ReservationListActivity.this.m42488v0(((CommonAdapter) c4391b).f1721a, JsonParse.getString(this.f16592a, "id"));
            }
        }

        C4391b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131232981, JsonParse.getString(stringObjectMap, "scheduleName"));
            holder.m57874J(C4215R.C4219id.tv_reserve_time, JsonParse.getString(stringObjectMap, "appointmentBeginTime") + ShellAdbUtils.f33810d + JsonParse.getString(stringObjectMap, "appointmentEndTime"));
            holder.m57874J(C4215R.C4219id.tv_measure_time, JsonParse.getString(stringObjectMap, "meaBeginTime") + ShellAdbUtils.f33810d + JsonParse.getString(stringObjectMap, "meaEndTime"));
            String string = JsonParse.getString(stringObjectMap, "classType");
            if (string.equals("0")) {
                holder.m57874J(C4215R.C4219id.tv_femail, "混合:" + JsonParse.getInt(stringObjectMap, "totalAppliedNumber") + "/" + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if (string.equals("1")) {
                holder.m57874J(C4215R.C4219id.tv_femail, "男生：" + JsonParse.getInt(stringObjectMap, "maleAppliedNumber") + "/" + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if (string.equals("2")) {
                holder.m57874J(C4215R.C4219id.tv_femail, "女生：" + JsonParse.getInt(stringObjectMap, "femaleAppliedNumber") + "/" + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if (string.equals("3")) {
                holder.m57874J(C4215R.C4219id.tv_femail, "比例:男:" + JsonParse.getString(stringObjectMap, "maleAppliedNumber") + "/" + JsonParse.getInt(stringObjectMap, "maleTotalNumber") + "\u3000女:" + JsonParse.getString(stringObjectMap, "femaleAppliedNumber") + "/" + JsonParse.getString(stringObjectMap, "femaleTotalNumber"));
            }
            holder.m57874J(2131233211, JsonParse.getString(stringObjectMap, "appointmentType").equals("2") ? "个人预约" : "班长预约");
            holder.m57847w(C4215R.C4219id.bt_detail, new View$OnClickListenerC4392a(stringObjectMap));
            Button button = (Button) holder.m57862h(C4215R.C4219id.bt_reservation);
            String string2 = JsonParse.getString(stringObjectMap, "appointmentEndTime");
            if ("1".equals(JsonParse.getString(stringObjectMap, "ismeastate"))) {
                button.setText("已预约");
                button.setEnabled(false);
            } else {
                try {
                    if (ReservationListActivity.this.f16587r >= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(string2).getTime()) {
                        button.setText("预约已结束");
                        button.setEnabled(false);
                    } else if (JsonParse.getInt(stringObjectMap, "totalAppliedNumber") >= JsonParse.getInt(stringObjectMap, "totalNumber")) {
                        button.setText("预约人数已满");
                        button.setEnabled(false);
                    } else {
                        button.setEnabled(true);
                        button.setText("立即预约");
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            button.setOnClickListener(new View$OnClickListenerC4393b(stringObjectMap));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.personal.reservation.ReservationListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4394c extends HttpCallBack {
        C4394c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            ReservationListActivity.this.f16580k.mo2078B();
            ReservationListActivity.this.f16580k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ReservationListActivity.this.f16587r = Long.parseLong(JsonParse.getString(data, "currentTime"));
            ReservationListActivity.this.f16582m = (List) data.get("meaScheduleList");
            ReservationListActivity.this.f16586q.m57836g(ReservationListActivity.this.f16582m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.personal.reservation.ReservationListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4395d extends HttpCallBack {
        C4395d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ReservationListActivity.this.m57919h0("预约成功");
            ReservationListActivity.this.m42489u0();
            ReservationDetailActivity reservationDetailActivity = (ReservationDetailActivity) AppManager.m57776n().getActivity(ReservationDetailActivity.class);
            if (reservationDetailActivity != null) {
                reservationDetailActivity.mo39374T();
            }
        }
    }

    /* renamed from: m0 */
    static /* synthetic */ int m42497m0(ReservationListActivity reservationListActivity) {
        int i = reservationListActivity.f16584o;
        reservationListActivity.f16584o = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m42489u0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m131Z(LoginUser.getLoginUser().getUserId(), "2", this.f16584o, this.f16585p)).setDataListener(new C4394c());
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
        this.f16580k.mo2019v(new C4390a());
        this.f16581l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f16581l.setLayoutAnimation(layoutAnimationController);
        C4391b c4391b = new C4391b(this.f1669h, C4215R.C4221layout.item_for_reserve_list, this.f16582m);
        this.f16586q = c4391b;
        this.f16581l.setAdapter(c4391b);
        this.f16580k.mo2050b0(true);
        this.f16580k.mo2064P(true);
        this.f16580k.mo2052a0();
        this.f16581l.setEmptyView(findViewById(2131232952));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("预约体测列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16580k = (SmartRefreshLayout) findViewById(2131232482);
        this.f16581l = (EmptyRecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* renamed from: v0 */
    public void m42488v0(Context mContext, String id) {
        Http.with(mContext).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m59x0(id, LoginUser.getLoginUser().getUserId())).setDataListener(new C4395d());
    }
}
