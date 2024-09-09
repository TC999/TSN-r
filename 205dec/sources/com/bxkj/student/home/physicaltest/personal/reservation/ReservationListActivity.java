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
public class ReservationListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f19970k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f19971l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f19972m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private int f19973n = 1;

    /* renamed from: o  reason: collision with root package name */
    private int f19974o = 1;

    /* renamed from: p  reason: collision with root package name */
    private int f19975p = 10;

    /* renamed from: q  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19976q;

    /* renamed from: r  reason: collision with root package name */
    private long f19977r;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements e {
        a() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            ReservationListActivity.this.f19974o = 1;
            ReservationListActivity.this.u0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = ReservationListActivity.this.f19973n / ReservationListActivity.this.f19975p;
            int i5 = ReservationListActivity.this.f19974o;
            if (ReservationListActivity.this.f19973n % ReservationListActivity.this.f19975p != 0) {
                i4++;
            }
            if (i5 >= i4) {
                ReservationListActivity.this.f19970k.h();
                ReservationListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            ReservationListActivity.m0(ReservationListActivity.this);
            ReservationListActivity.this.u0();
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
            final /* synthetic */ Map f19980a;

            a(final Map val$stringObjectMap) {
                this.f19980a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                ReservationListActivity.this.startActivity(new Intent(((CommonAdapter) b.this).f1707a, ReservationDetailActivity.class).putExtra("id", JsonParse.getString(this.f19980a, "id")));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.physicaltest.personal.reservation.ReservationListActivity$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0227b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f19982a;

            View$OnClickListenerC0227b(final Map val$stringObjectMap) {
                this.f19982a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                b bVar = b.this;
                ReservationListActivity.this.v0(((CommonAdapter) bVar).f1707a, JsonParse.getString(this.f19982a, "id"));
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
            String string = JsonParse.getString(stringObjectMap, "classType");
            if (string.equals("0")) {
                holder.J(2131232967, "\u6df7\u5408:" + JsonParse.getInt(stringObjectMap, "totalAppliedNumber") + TTPathConst.sSeparator + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if (string.equals("1")) {
                holder.J(2131232967, "\u7537\u751f\uff1a" + JsonParse.getInt(stringObjectMap, "maleAppliedNumber") + TTPathConst.sSeparator + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if (string.equals("2")) {
                holder.J(2131232967, "\u5973\u751f\uff1a" + JsonParse.getInt(stringObjectMap, "femaleAppliedNumber") + TTPathConst.sSeparator + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if (string.equals("3")) {
                holder.J(2131232967, "\u6bd4\u4f8b:\u7537:" + JsonParse.getString(stringObjectMap, "maleAppliedNumber") + TTPathConst.sSeparator + JsonParse.getInt(stringObjectMap, "maleTotalNumber") + "\u3000\u5973:" + JsonParse.getString(stringObjectMap, "femaleAppliedNumber") + TTPathConst.sSeparator + JsonParse.getString(stringObjectMap, "femaleTotalNumber"));
            }
            holder.J(2131233211, JsonParse.getString(stringObjectMap, "appointmentType").equals("2") ? "\u4e2a\u4eba\u9884\u7ea6" : "\u73ed\u957f\u9884\u7ea6");
            holder.w(2131230972, new a(stringObjectMap));
            Button button = (Button) holder.h(2131231005);
            String string2 = JsonParse.getString(stringObjectMap, "appointmentEndTime");
            if ("1".equals(JsonParse.getString(stringObjectMap, "ismeastate"))) {
                button.setText("\u5df2\u9884\u7ea6");
                button.setEnabled(false);
            } else {
                try {
                    if (ReservationListActivity.this.f19977r >= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(string2).getTime()) {
                        button.setText("\u9884\u7ea6\u5df2\u7ed3\u675f");
                        button.setEnabled(false);
                    } else if (JsonParse.getInt(stringObjectMap, "totalAppliedNumber") >= JsonParse.getInt(stringObjectMap, "totalNumber")) {
                        button.setText("\u9884\u7ea6\u4eba\u6570\u5df2\u6ee1");
                        button.setEnabled(false);
                    } else {
                        button.setEnabled(true);
                        button.setText("\u7acb\u5373\u9884\u7ea6");
                    }
                } catch (ParseException e4) {
                    e4.printStackTrace();
                }
            }
            button.setOnClickListener(new View$OnClickListenerC0227b(stringObjectMap));
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
            ReservationListActivity.this.f19970k.y();
            ReservationListActivity.this.f19970k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ReservationListActivity.this.f19977r = Long.parseLong(JsonParse.getString(data, "currentTime"));
            ReservationListActivity.this.f19972m = (List) data.get("meaScheduleList");
            ReservationListActivity.this.f19976q.g(ReservationListActivity.this.f19972m);
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
            ReservationListActivity.this.h0("\u9884\u7ea6\u6210\u529f");
            ReservationListActivity.this.u0();
            ReservationDetailActivity reservationDetailActivity = (ReservationDetailActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(ReservationDetailActivity.class);
            if (reservationDetailActivity != null) {
                reservationDetailActivity.T();
            }
        }
    }

    static /* synthetic */ int m0(ReservationListActivity reservationListActivity) {
        int i4 = reservationListActivity.f19974o;
        reservationListActivity.f19974o = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).Z(LoginUser.getLoginUser().getUserId(), "2", this.f19974o, this.f19975p)).setDataListener(new c());
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
        this.f19970k.n1(new a());
        this.f19971l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f19971l.setLayoutAnimation(layoutAnimationController);
        b bVar = new b(this.f1656h, 2131427750, this.f19972m);
        this.f19976q = bVar;
        this.f19971l.setAdapter(bVar);
        this.f19970k.b0(true);
        this.f19970k.O(true);
        this.f19970k.a0();
        this.f19971l.setEmptyView(findViewById(2131232952));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u9884\u7ea6\u4f53\u6d4b\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19970k = (SmartRefreshLayout) findViewById(2131232482);
        this.f19971l = (EmptyRecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    public void v0(Context mContext, String id) {
        Http.with(mContext).setObservable(((w.a) Http.getApiService(w.a.class)).x0(id, LoginUser.getLoginUser().getUserId())).setDataListener(new d());
    }
}
