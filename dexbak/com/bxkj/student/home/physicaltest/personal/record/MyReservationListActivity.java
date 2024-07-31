package com.bxkj.student.home.physicaltest.personal.record;

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
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
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
public class MyReservationListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f16549k;

    /* renamed from: l */
    private EmptyRecyclerView f16550l;

    /* renamed from: m */
    private List<Map<String, Object>> f16551m = new ArrayList();

    /* renamed from: n */
    private int f16552n = 1;

    /* renamed from: o */
    private int f16553o = 1;

    /* renamed from: p */
    private int f16554p = 10;

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f16555q;

    /* renamed from: r */
    private long f16556r;

    /* renamed from: com.bxkj.student.home.physicaltest.personal.record.MyReservationListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4380a implements OnRefreshLoadmoreListener {
        C4380a() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            MyReservationListActivity.this.f16553o = 1;
            MyReservationListActivity.this.m42514u0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = MyReservationListActivity.this.f16552n / MyReservationListActivity.this.f16554p;
            int i2 = MyReservationListActivity.this.f16553o;
            if (MyReservationListActivity.this.f16552n % MyReservationListActivity.this.f16554p != 0) {
                i++;
            }
            if (i2 >= i) {
                MyReservationListActivity.this.f16549k.mo2041g();
                MyReservationListActivity.this.m57919h0("没有了");
                return;
            }
            MyReservationListActivity.m42522m0(MyReservationListActivity.this);
            MyReservationListActivity.this.m42514u0();
        }
    }

    /* renamed from: com.bxkj.student.home.physicaltest.personal.record.MyReservationListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4381b extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.physicaltest.personal.record.MyReservationListActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4382a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f16559a;

            /* renamed from: b */
            final /* synthetic */ ViewHolder f16560b;

            View$OnClickListenerC4382a(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f16559a = val$stringObjectMap;
                this.f16560b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MyReservationListActivity.this.startActivity(new Intent(((CommonAdapter) C4381b.this).f1721a, MyReservationDetailActivity.class).putExtra("id", JsonParse.getString(this.f16559a, "id")).putExtra("position", this.f16560b.m57864f()));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.physicaltest.personal.record.MyReservationListActivity$b$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4383b implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f16562a;

            /* renamed from: b */
            final /* synthetic */ ViewHolder f16563b;

            View$OnClickListenerC4383b(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f16562a = val$stringObjectMap;
                this.f16563b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                C4381b c4381b = C4381b.this;
                MyReservationListActivity.this.m42513v0(((CommonAdapter) c4381b).f1721a, JsonParse.getString(this.f16562a, "id"), this.f16563b.m57864f());
            }
        }

        C4381b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: o */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            holder.m57874J(2131232981, JsonParse.getString(stringObjectMap, "scheduleName"));
            holder.m57874J(C4215R.C4219id.tv_reserve_time, JsonParse.getString(stringObjectMap, "appointmentBeginTime") + ShellAdbUtils.f33810d + JsonParse.getString(stringObjectMap, "appointmentEndTime"));
            holder.m57874J(C4215R.C4219id.tv_measure_time, JsonParse.getString(stringObjectMap, "meaBeginTime") + ShellAdbUtils.f33810d + JsonParse.getString(stringObjectMap, "meaEndTime"));
            String string = JsonParse.getString(stringObjectMap, "classType");
            if ("0".equals(string)) {
                holder.m57874J(C4215R.C4219id.tv_femail, "混合:" + JsonParse.getInt(stringObjectMap, "totalAppliedNumber") + "/" + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if ("1".equals(string)) {
                holder.m57874J(C4215R.C4219id.tv_femail, "男生：" + JsonParse.getInt(stringObjectMap, "maleAppliedNumber") + "/" + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if ("2".equals(string)) {
                holder.m57874J(C4215R.C4219id.tv_femail, "女生：" + JsonParse.getInt(stringObjectMap, "femaleAppliedNumber") + "/" + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if ("3".equals(string)) {
                holder.m57874J(C4215R.C4219id.tv_femail, "比例:男:" + JsonParse.getString(stringObjectMap, "maleAppliedNumber") + "/" + JsonParse.getInt(stringObjectMap, "totalNumber") + "\u3000女:" + JsonParse.getString(stringObjectMap, "femaleAppliedNumber") + "/" + JsonParse.getString(stringObjectMap, "totalNumber"));
            }
            holder.m57874J(2131233211, "2".equals(JsonParse.getString(stringObjectMap, "appointmentType")) ? "个人预约" : "班长预约");
            holder.m57847w(C4215R.C4219id.bt_detail, new View$OnClickListenerC4382a(stringObjectMap, holder));
            Button button = (Button) holder.m57862h(C4215R.C4219id.bt_reservation);
            button.setText("取消预约");
            try {
                if (MyReservationListActivity.this.f16556r > new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(JsonParse.getString(stringObjectMap, "meaBeginTime")).getTime()) {
                    button.setText("体测已开始");
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                    button.setText("取消预约");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            button.setOnClickListener(new View$OnClickListenerC4383b(stringObjectMap, holder));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.personal.record.MyReservationListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4384c extends HttpCallBack {
        C4384c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            MyReservationListActivity.this.f16549k.mo2078B();
            MyReservationListActivity.this.f16549k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyReservationListActivity.this.f16556r = Long.parseLong(JsonParse.getString(data, "currentTime"));
            MyReservationListActivity.this.f16551m = (List) data.get("meaScheduleList");
            MyReservationListActivity.this.f16555q.m57836g(MyReservationListActivity.this.f16551m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.personal.record.MyReservationListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4385d implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ Context f16566a;

        /* renamed from: b */
        final /* synthetic */ String f16567b;

        /* renamed from: c */
        final /* synthetic */ int f16568c;

        /* renamed from: com.bxkj.student.home.physicaltest.personal.record.MyReservationListActivity$d$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4386a extends HttpCallBack {
            C4386a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                MyReservationListActivity.this.m57919h0("取消预约成功");
                MyReservationListActivity.this.f16555q.m57837d().remove(MyReservationListActivity.this.f16555q.getItem(C4385d.this.f16568c));
                MyReservationListActivity.this.f16555q.notifyItemRemoved(C4385d.this.f16568c);
                Activity activity = AppManager.m57776n().getActivity(MyReservationDetailActivity.class);
                if (activity != null) {
                    activity.finish();
                }
            }
        }

        C4385d(final Context val$mContext, final String val$id, final int val$position) {
            this.f16566a = val$mContext;
            this.f16567b = val$id;
            this.f16568c = val$position;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(this.f16566a).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m137W(this.f16567b, LoginUser.getLoginUser().getUserId())).setDataListener(new C4386a());
        }
    }

    /* renamed from: m0 */
    static /* synthetic */ int m42522m0(MyReservationListActivity myReservationListActivity) {
        int i = myReservationListActivity.f16553o;
        myReservationListActivity.f16553o = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m42514u0() {
        Http.with(this.f1669h).hideLoadingDialog().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m159L(LoginUser.getLoginUser().getUserId(), "1", this.f16553o, this.f16554p)).setDataListener(new C4384c());
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
        this.f16549k.mo2019v(new C4380a());
        this.f16550l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f16550l.setLayoutAnimation(layoutAnimationController);
        C4381b c4381b = new C4381b(this.f1669h, C4215R.C4221layout.item_for_reserve_list, this.f16551m);
        this.f16555q = c4381b;
        this.f16550l.setAdapter(c4381b);
        this.f16549k.mo2050b0(true);
        this.f16549k.mo2064P(true);
        this.f16549k.mo2052a0();
        this.f16550l.setEmptyView(findViewById(2131232952));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我的预约体测列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16549k = (SmartRefreshLayout) findViewById(2131232482);
        this.f16550l = (EmptyRecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* renamed from: v0 */
    public void m42513v0(final Context mContext, final String id, final int position) {
        new iOSTwoButtonDialog(mContext).setTitle("提示").setMessage("确定要取消预约吗？").setRightButtonOnClickListener(new C4385d(mContext, id, position)).show();
    }
}
