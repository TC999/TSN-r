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
public class MyReservationListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f19939k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f19940l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f19941m = new ArrayList();

    /* renamed from: n  reason: collision with root package name */
    private int f19942n = 1;

    /* renamed from: o  reason: collision with root package name */
    private int f19943o = 1;

    /* renamed from: p  reason: collision with root package name */
    private int f19944p = 10;

    /* renamed from: q  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19945q;

    /* renamed from: r  reason: collision with root package name */
    private long f19946r;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements e {
        a() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            MyReservationListActivity.this.f19943o = 1;
            MyReservationListActivity.this.u0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = MyReservationListActivity.this.f19942n / MyReservationListActivity.this.f19944p;
            int i5 = MyReservationListActivity.this.f19943o;
            if (MyReservationListActivity.this.f19942n % MyReservationListActivity.this.f19944p != 0) {
                i4++;
            }
            if (i5 >= i4) {
                MyReservationListActivity.this.f19939k.h();
                MyReservationListActivity.this.h0("\u6ca1\u6709\u4e86");
                return;
            }
            MyReservationListActivity.m0(MyReservationListActivity.this);
            MyReservationListActivity.this.u0();
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
            final /* synthetic */ Map f19949a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewHolder f19950b;

            a(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f19949a = val$stringObjectMap;
                this.f19950b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                MyReservationListActivity.this.startActivity(new Intent(((CommonAdapter) b.this).f1707a, MyReservationDetailActivity.class).putExtra("id", JsonParse.getString(this.f19949a, "id")).putExtra("position", this.f19950b.f()));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.home.physicaltest.personal.record.MyReservationListActivity$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class View$OnClickListenerC0225b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f19952a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewHolder f19953b;

            View$OnClickListenerC0225b(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f19952a = val$stringObjectMap;
                this.f19953b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                b bVar = b.this;
                MyReservationListActivity.this.v0(((CommonAdapter) bVar).f1707a, JsonParse.getString(this.f19952a, "id"), this.f19953b.f());
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
            if ("0".equals(string)) {
                holder.J(2131232967, "\u6df7\u5408:" + JsonParse.getInt(stringObjectMap, "totalAppliedNumber") + TTPathConst.sSeparator + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if ("1".equals(string)) {
                holder.J(2131232967, "\u7537\u751f\uff1a" + JsonParse.getInt(stringObjectMap, "maleAppliedNumber") + TTPathConst.sSeparator + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if ("2".equals(string)) {
                holder.J(2131232967, "\u5973\u751f\uff1a" + JsonParse.getInt(stringObjectMap, "femaleAppliedNumber") + TTPathConst.sSeparator + JsonParse.getInt(stringObjectMap, "totalNumber"));
            } else if ("3".equals(string)) {
                holder.J(2131232967, "\u6bd4\u4f8b:\u7537:" + JsonParse.getString(stringObjectMap, "maleAppliedNumber") + TTPathConst.sSeparator + JsonParse.getInt(stringObjectMap, "totalNumber") + "\u3000\u5973:" + JsonParse.getString(stringObjectMap, "femaleAppliedNumber") + TTPathConst.sSeparator + JsonParse.getString(stringObjectMap, "totalNumber"));
            }
            holder.J(2131233211, "2".equals(JsonParse.getString(stringObjectMap, "appointmentType")) ? "\u4e2a\u4eba\u9884\u7ea6" : "\u73ed\u957f\u9884\u7ea6");
            holder.w(2131230972, new a(stringObjectMap, holder));
            Button button = (Button) holder.h(2131231005);
            button.setText("\u53d6\u6d88\u9884\u7ea6");
            try {
                if (MyReservationListActivity.this.f19946r > new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(JsonParse.getString(stringObjectMap, "meaBeginTime")).getTime()) {
                    button.setText("\u4f53\u6d4b\u5df2\u5f00\u59cb");
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                    button.setText("\u53d6\u6d88\u9884\u7ea6");
                }
            } catch (ParseException e4) {
                e4.printStackTrace();
            }
            button.setOnClickListener(new View$OnClickListenerC0225b(stringObjectMap, holder));
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
            MyReservationListActivity.this.f19939k.y();
            MyReservationListActivity.this.f19939k.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyReservationListActivity.this.f19946r = Long.parseLong(JsonParse.getString(data, "currentTime"));
            MyReservationListActivity.this.f19941m = (List) data.get("meaScheduleList");
            MyReservationListActivity.this.f19945q.g(MyReservationListActivity.this.f19941m);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f19956a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f19957b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f19958c;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                MyReservationListActivity.this.h0("\u53d6\u6d88\u9884\u7ea6\u6210\u529f");
                MyReservationListActivity.this.f19945q.d().remove(MyReservationListActivity.this.f19945q.getItem(d.this.f19958c));
                MyReservationListActivity.this.f19945q.notifyItemRemoved(d.this.f19958c);
                Activity activity = cn.bluemobi.dylan.base.utils.a.n().getActivity(MyReservationDetailActivity.class);
                if (activity != null) {
                    activity.finish();
                }
            }
        }

        d(final Context val$mContext, final String val$id, final int val$position) {
            this.f19956a = val$mContext;
            this.f19957b = val$id;
            this.f19958c = val$position;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Http.with(this.f19956a).setObservable(((w.a) Http.getApiService(w.a.class)).W(this.f19957b, LoginUser.getLoginUser().getUserId())).setDataListener(new a());
        }
    }

    static /* synthetic */ int m0(MyReservationListActivity myReservationListActivity) {
        int i4 = myReservationListActivity.f19943o;
        myReservationListActivity.f19943o = i4 + 1;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        Http.with(this.f1656h).hideLoadingDialog().setObservable(((w.a) Http.getApiService(w.a.class)).L(LoginUser.getLoginUser().getUserId(), "1", this.f19943o, this.f19944p)).setDataListener(new c());
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
        this.f19939k.n1(new a());
        this.f19940l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f19940l.setLayoutAnimation(layoutAnimationController);
        b bVar = new b(this.f1656h, 2131427750, this.f19941m);
        this.f19945q = bVar;
        this.f19940l.setAdapter(bVar);
        this.f19939k.b0(true);
        this.f19939k.O(true);
        this.f19939k.a0();
        this.f19940l.setEmptyView(findViewById(2131232952));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u6211\u7684\u9884\u7ea6\u4f53\u6d4b\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19939k = (SmartRefreshLayout) findViewById(2131232482);
        this.f19940l = (EmptyRecyclerView) findViewById(2131232481);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    public void v0(final Context mContext, final String id, final int position) {
        new iOSTwoButtonDialog(mContext).setTitle("\u63d0\u793a").setMessage("\u786e\u5b9a\u8981\u53d6\u6d88\u9884\u7ea6\u5417\uff1f").setRightButtonOnClickListener(new d(mContext, id, position)).show();
    }
}
