package com.bxkj.student.home.physicaltest.monitor.record;

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
public class MonitorRecordListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f16496k;

    /* renamed from: l */
    private EmptyRecyclerView f16497l;

    /* renamed from: m */
    private List<Map<String, Object>> f16498m = new ArrayList();

    /* renamed from: n */
    private int f16499n = 1;

    /* renamed from: o */
    private int f16500o = 1;

    /* renamed from: p */
    private int f16501p = 10;

    /* renamed from: q */
    private CommonAdapter<Map<String, Object>> f16502q;

    /* renamed from: r */
    private long f16503r;

    /* renamed from: com.bxkj.student.home.physicaltest.monitor.record.MonitorRecordListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4363a implements OnRefreshLoadmoreListener {
        C4363a() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            MonitorRecordListActivity.this.f16500o = 1;
            MonitorRecordListActivity.this.m42560u0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = MonitorRecordListActivity.this.f16499n / MonitorRecordListActivity.this.f16501p;
            int i2 = MonitorRecordListActivity.this.f16500o;
            if (MonitorRecordListActivity.this.f16499n % MonitorRecordListActivity.this.f16501p != 0) {
                i++;
            }
            if (i2 >= i) {
                MonitorRecordListActivity.this.f16496k.mo2041g();
                MonitorRecordListActivity.this.m57919h0("没有了");
                return;
            }
            MonitorRecordListActivity.m42568m0(MonitorRecordListActivity.this);
            MonitorRecordListActivity.this.m42560u0();
        }
    }

    /* renamed from: com.bxkj.student.home.physicaltest.monitor.record.MonitorRecordListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4364b extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.physicaltest.monitor.record.MonitorRecordListActivity$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4365a implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f16506a;

            /* renamed from: b */
            final /* synthetic */ ViewHolder f16507b;

            View$OnClickListenerC4365a(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f16506a = val$stringObjectMap;
                this.f16507b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                MonitorRecordListActivity.this.startActivity(new Intent(((CommonAdapter) C4364b.this).f1721a, MonitorRecordDetailActivity.class).putExtra("id", JsonParse.getString(this.f16506a, "id")).putExtra("position", this.f16507b.m57864f()));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.physicaltest.monitor.record.MonitorRecordListActivity$b$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4366b implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f16509a;

            /* renamed from: b */
            final /* synthetic */ ViewHolder f16510b;

            View$OnClickListenerC4366b(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f16509a = val$stringObjectMap;
                this.f16510b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                C4364b c4364b = C4364b.this;
                MonitorRecordListActivity.this.m42559v0(((CommonAdapter) c4364b).f1721a, JsonParse.getString(this.f16509a, "id"), this.f16510b.m57864f());
            }
        }

        C4364b(Context context, int layoutId, List datas) {
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
            holder.m57847w(C4215R.C4219id.bt_detail, new View$OnClickListenerC4365a(stringObjectMap, holder));
            Button button = (Button) holder.m57862h(C4215R.C4219id.bt_reservation);
            try {
                if (MonitorRecordListActivity.this.f16503r > new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss").parse(JsonParse.getString(stringObjectMap, "meaBeginTime")).getTime()) {
                    button.setText("体测已开始");
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                    button.setText("取消预约");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
            button.setOnClickListener(new View$OnClickListenerC4366b(stringObjectMap, holder));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.monitor.record.MonitorRecordListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4367c extends HttpCallBack {
        C4367c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            MonitorRecordListActivity.this.f16496k.mo2078B();
            MonitorRecordListActivity.this.f16496k.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MonitorRecordListActivity.this.f16503r = Long.parseLong(JsonParse.getString(data, "currentTime"));
            MonitorRecordListActivity.this.f16498m = (List) data.get("meaScheduleList");
            MonitorRecordListActivity.this.f16502q.m57836g(MonitorRecordListActivity.this.f16498m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.monitor.record.MonitorRecordListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4368d implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ Context f16513a;

        /* renamed from: b */
        final /* synthetic */ String f16514b;

        /* renamed from: c */
        final /* synthetic */ int f16515c;

        /* renamed from: com.bxkj.student.home.physicaltest.monitor.record.MonitorRecordListActivity$d$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4369a extends HttpCallBack {
            C4369a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                MonitorRecordListActivity.this.m57919h0("取消预约成功");
                MonitorRecordListActivity.this.f16502q.m57837d().remove(MonitorRecordListActivity.this.f16502q.getItem(C4368d.this.f16515c));
                MonitorRecordListActivity.this.f16502q.notifyItemRemoved(C4368d.this.f16515c);
                Activity activity = AppManager.m57776n().getActivity(MonitorRecordDetailActivity.class);
                if (activity != null) {
                    activity.finish();
                }
            }
        }

        C4368d(final Context val$mContext, final String val$id, final int val$position) {
            this.f16513a = val$mContext;
            this.f16514b = val$id;
            this.f16515c = val$position;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(this.f16513a).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m137W(this.f16514b, LoginUser.getLoginUser().getUserId())).setDataListener(new C4369a());
        }
    }

    /* renamed from: m0 */
    static /* synthetic */ int m42568m0(MonitorRecordListActivity monitorRecordListActivity) {
        int i = monitorRecordListActivity.f16500o;
        monitorRecordListActivity.f16500o = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u0 */
    public void m42560u0() {
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m181C1(LoginUser.getLoginUser().getUserId(), "1", this.f16500o, this.f16501p)).setDataListener(new C4367c());
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
        this.f16496k.mo2019v(new C4363a());
        this.f16497l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f16497l.setLayoutAnimation(layoutAnimationController);
        C4364b c4364b = new C4364b(this.f1669h, C4215R.C4221layout.item_for_reserve_list, this.f16498m);
        this.f16502q = c4364b;
        this.f16497l.setAdapter(c4364b);
        this.f16496k.mo2050b0(true);
        this.f16496k.mo2064P(false);
        this.f16496k.mo2052a0();
        this.f16497l.setEmptyView(findViewById(2131232952));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("我的预约体测列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16496k = (SmartRefreshLayout) findViewById(2131232482);
        this.f16497l = (EmptyRecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* renamed from: v0 */
    public void m42559v0(final Context mContext, final String id, final int position) {
        new iOSTwoButtonDialog(mContext).setTitle("提示").setMessage("确定要取消预约吗？").setRightButtonOnClickListener(new C4368d(mContext, id, position)).show();
    }
}
