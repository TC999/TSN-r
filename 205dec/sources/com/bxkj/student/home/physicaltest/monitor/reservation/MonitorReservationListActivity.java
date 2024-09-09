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
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;
import s0.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MonitorReservationListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f19917k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f19918l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f19919m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private int f19920n = 1;

    /* renamed from: o  reason: collision with root package name */
    private int f19921o = 1;

    /* renamed from: p  reason: collision with root package name */
    private int f19922p = 10;

    /* renamed from: q  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19923q;

    /* renamed from: r  reason: collision with root package name */
    private long f19924r;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements e {
        a() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            MonitorReservationListActivity.this.f19921o = 1;
            MonitorReservationListActivity.this.u0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = MonitorReservationListActivity.this.f19920n / MonitorReservationListActivity.this.f19922p;
            int i5 = MonitorReservationListActivity.this.f19921o;
            if (MonitorReservationListActivity.this.f19920n % MonitorReservationListActivity.this.f19922p != 0) {
                i4++;
            }
            if (i5 >= i4) {
                MonitorReservationListActivity.this.f19917k.h();
                MonitorReservationListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            MonitorReservationListActivity.m0(MonitorReservationListActivity.this);
            MonitorReservationListActivity.this.u0();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f19927a;

            a(final Map val$stringObjectMap) {
                this.f19927a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                MonitorReservationListActivity.this.startActivity(new Intent(((CommonAdapter) b.this).f1707a, MonitorReservationDetailActivity.class).putExtra("id", JsonParse.getString(this.f19927a, "id")));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.physicaltest.monitor.reservation.MonitorReservationListActivity$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0224b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f19929a;

            View$OnClickListenerC0224b(final Map val$stringObjectMap) {
                this.f19929a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                b bVar = b.this;
                MonitorReservationListActivity.this.v0(((CommonAdapter) bVar).f1707a, JsonParse.getString(this.f19929a, "id"));
            }
        }

        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.J(2131232981, JsonParse.getString(stringObjectMap, "scheduleName"));
            holder.J(2131233128, JsonParse.getString(stringObjectMap, "appointmentBeginTime") + "\n" + JsonParse.getString(stringObjectMap, "appointmentEndTime"));
            holder.J(2131233031, JsonParse.getString(stringObjectMap, "meaBeginTime") + "\n" + JsonParse.getString(stringObjectMap, "meaEndTime"));
            holder.J(2131232967, "\u73ed\u7ea7\u6570:" + JsonParse.getString(stringObjectMap, "appliedClasses") + TTPathConst.sSeparator + JsonParse.getInt(stringObjectMap, "appClassAmount"));
            holder.J(2131233211, JsonParse.getString(stringObjectMap, "appointmentType").equals("2") ? "\u4e2a\u4eba\u9884\u7ea6" : "\u73ed\u957f\u9884\u7ea6");
            holder.w(2131230972, new a(stringObjectMap));
            Button button = (Button) holder.h(2131231005);
            try {
                if (MonitorReservationListActivity.this.f19924r >= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(JsonParse.getString(stringObjectMap, "appointmentEndTime")).getTime()) {
                    button.setText("\u9884\u7ea6\u5df2\u7ed3\u675f");
                    button.setEnabled(false);
                } else if (JsonParse.getInt(stringObjectMap, "appliedClasses") >= JsonParse.getInt(stringObjectMap, "appClassAmount")) {
                    button.setText("\u9884\u7ea6\u73ed\u7ea7\u5df2\u6ee1");
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                    button.setText("\u7acb\u5373\u9884\u7ea6");
                }
            } catch (ParseException e4) {
                e4.printStackTrace();
            }
            button.setOnClickListener(new View$OnClickListenerC0224b(stringObjectMap));
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
            MonitorReservationListActivity.this.f19917k.y();
            MonitorReservationListActivity.this.f19917k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MonitorReservationListActivity.this.f19924r = Long.parseLong(JsonParse.getString(data, "currentTime"));
            MonitorReservationListActivity.this.f19919m = (List) data.get("meaScheduleList");
            MonitorReservationListActivity.this.f19923q.g(MonitorReservationListActivity.this.f19919m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MonitorReservationListActivity.this.h0("\u9884\u7ea6\u6210\u529f");
            Activity activity = cn.bluemobi.dylan.base.utils.a.n().getActivity(MonitorReservationDetailActivity.class);
            if (activity != null) {
                activity.finish();
            }
        }
    }

    static /* synthetic */ int m0(MonitorReservationListActivity monitorReservationListActivity) {
        int i4 = monitorReservationListActivity.f19921o;
        monitorReservationListActivity.f19921o = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).m1(LoginUser.getLoginUser().getUserId(), this.f19921o, this.f19922p)).setDataListener(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427460;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f19917k.n1(new a());
        this.f19918l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f19918l.setLayoutAnimation(layoutAnimationController);
        b bVar = new b(this.f1656h, 2131427750, this.f19919m);
        this.f19923q = bVar;
        this.f19918l.setAdapter(bVar);
        this.f19917k.b0(true);
        this.f19917k.O(false);
        this.f19917k.a0();
        this.f19918l.setEmptyView(findViewById(2131232952));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u9884\u7ea6\u4f53\u6d4b\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19917k = (SmartRefreshLayout) findViewById(2131232482);
        this.f19918l = (EmptyRecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    public void v0(Context mContext, String id) {
        Http.with(mContext).setObservable(((w.a) Http.getApiService(w.a.class)).x0(id, LoginUser.getLoginUser().getUserId())).setDataListener(new d());
    }
}
