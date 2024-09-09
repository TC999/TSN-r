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
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
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
public class MonitorRecordListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f19886k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f19887l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f19888m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private int f19889n = 1;

    /* renamed from: o  reason: collision with root package name */
    private int f19890o = 1;

    /* renamed from: p  reason: collision with root package name */
    private int f19891p = 10;

    /* renamed from: q  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19892q;

    /* renamed from: r  reason: collision with root package name */
    private long f19893r;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements e {
        a() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            MonitorRecordListActivity.this.f19890o = 1;
            MonitorRecordListActivity.this.u0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = MonitorRecordListActivity.this.f19889n / MonitorRecordListActivity.this.f19891p;
            int i5 = MonitorRecordListActivity.this.f19890o;
            if (MonitorRecordListActivity.this.f19889n % MonitorRecordListActivity.this.f19891p != 0) {
                i4++;
            }
            if (i5 >= i4) {
                MonitorRecordListActivity.this.f19886k.h();
                MonitorRecordListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            MonitorRecordListActivity.m0(MonitorRecordListActivity.this);
            MonitorRecordListActivity.this.u0();
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
            final /* synthetic */ Map f19896a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewHolder f19897b;

            a(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f19896a = val$stringObjectMap;
                this.f19897b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                MonitorRecordListActivity.this.startActivity(new Intent(((CommonAdapter) b.this).f1707a, MonitorRecordDetailActivity.class).putExtra("id", JsonParse.getString(this.f19896a, "id")).putExtra("position", this.f19897b.f()));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.physicaltest.monitor.record.MonitorRecordListActivity$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0222b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f19899a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewHolder f19900b;

            View$OnClickListenerC0222b(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f19899a = val$stringObjectMap;
                this.f19900b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                b bVar = b.this;
                MonitorRecordListActivity.this.v0(((CommonAdapter) bVar).f1707a, JsonParse.getString(this.f19899a, "id"), this.f19900b.f());
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
            holder.w(2131230972, new a(stringObjectMap, holder));
            Button button = (Button) holder.h(2131231005);
            try {
                if (MonitorRecordListActivity.this.f19893r > new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss").parse(JsonParse.getString(stringObjectMap, "meaBeginTime")).getTime()) {
                    button.setText("\u4f53\u6d4b\u5df2\u5f00\u59cb");
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                    button.setText("\u53d6\u6d88\u9884\u7ea6");
                }
            } catch (ParseException e4) {
                e4.printStackTrace();
            }
            button.setOnClickListener(new View$OnClickListenerC0222b(stringObjectMap, holder));
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
            MonitorRecordListActivity.this.f19886k.y();
            MonitorRecordListActivity.this.f19886k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MonitorRecordListActivity.this.f19893r = Long.parseLong(JsonParse.getString(data, "currentTime"));
            MonitorRecordListActivity.this.f19888m = (List) data.get("meaScheduleList");
            MonitorRecordListActivity.this.f19892q.g(MonitorRecordListActivity.this.f19888m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f19903a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19904b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19905c;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                MonitorRecordListActivity.this.h0("\u53d6\u6d88\u9884\u7ea6\u6210\u529f");
                MonitorRecordListActivity.this.f19892q.d().remove(MonitorRecordListActivity.this.f19892q.getItem(d.this.f19905c));
                MonitorRecordListActivity.this.f19892q.notifyItemRemoved(d.this.f19905c);
                Activity activity = cn.bluemobi.dylan.base.utils.a.n().getActivity(MonitorRecordDetailActivity.class);
                if (activity != null) {
                    activity.finish();
                }
            }
        }

        d(final Context val$mContext, final String val$id, final int val$position) {
            this.f19903a = val$mContext;
            this.f19904b = val$id;
            this.f19905c = val$position;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(this.f19903a).setObservable(((w.a) Http.getApiService(w.a.class)).W(this.f19904b, LoginUser.getLoginUser().getUserId())).setDataListener(new a());
        }
    }

    static /* synthetic */ int m0(MonitorRecordListActivity monitorRecordListActivity) {
        int i4 = monitorRecordListActivity.f19890o;
        monitorRecordListActivity.f19890o = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).C1(LoginUser.getLoginUser().getUserId(), "1", this.f19890o, this.f19891p)).setDataListener(new c());
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
        this.f19886k.n1(new a());
        this.f19887l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f19887l.setLayoutAnimation(layoutAnimationController);
        b bVar = new b(this.f1656h, 2131427750, this.f19888m);
        this.f19892q = bVar;
        this.f19887l.setAdapter(bVar);
        this.f19886k.b0(true);
        this.f19886k.O(false);
        this.f19886k.a0();
        this.f19887l.setEmptyView(findViewById(2131232952));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u7684\u9884\u7ea6\u4f53\u6d4b\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19886k = (SmartRefreshLayout) findViewById(2131232482);
        this.f19887l = (EmptyRecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    public void v0(final Context mContext, final String id, final int position) {
        new iOSTwoButtonDialog(mContext).setTitle("\u63d0\u793a").setMessage("\u786e\u5b9a\u8981\u53d6\u6d88\u9884\u7ea6\u5417\uff1f").setRightButtonOnClickListener(new d(mContext, id, position)).show();
    }
}
