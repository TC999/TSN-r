package com.bxkj.student.run.app.record;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.z;
import com.bxkj.student.run.app.StartRunActivity;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.record.RunRecorderListActivity;
import com.bxkj.student.run.app.vm.RunVM;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.f1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RunRecorderListActivity extends BaseActivity {
    private TabLayout.Tab A;
    private TabLayout.OnTabSelectedListener B;
    private SimpleDateFormat C;
    private RunVM D;

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f22545k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f22546l;

    /* renamed from: m  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f22547m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f22548n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f22549o;

    /* renamed from: p  reason: collision with root package name */
    private TextView f22550p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f22551q;

    /* renamed from: r  reason: collision with root package name */
    private CardView f22552r;

    /* renamed from: s  reason: collision with root package name */
    private TabLayout f22553s;

    /* renamed from: t  reason: collision with root package name */
    private List<Map<String, Object>> f22554t = new ArrayList();

    /* renamed from: u  reason: collision with root package name */
    protected int f22555u = 10;

    /* renamed from: v  reason: collision with root package name */
    protected int f22556v = 1;

    /* renamed from: w  reason: collision with root package name */
    protected int f22557w = 1;

    /* renamed from: x  reason: collision with root package name */
    private int f22558x = 2;

    /* renamed from: y  reason: collision with root package name */
    private TabLayout.Tab f22559y;

    /* renamed from: z  reason: collision with root package name */
    private TabLayout.Tab f22560z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.run.app.record.RunRecorderListActivity$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class C0282a implements l1.l<List<RunDb>, f1> {
            C0282a() {
            }

            @Override // l1.l
            /* renamed from: a */
            public f1 invoke(List<RunDb> runDbs) {
                if (runDbs == null || runDbs.size() <= 0) {
                    return null;
                }
                a.this.y(runDbs.get(0));
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class b extends HttpCallBack {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RunDb f22563a;

            b(final RunDb val$runDataDB) {
                this.f22563a = val$runDataDB;
            }

            private void a(String msg) {
                RunRecorderListActivity.this.D.u(this.f22563a.getIdentify());
                RunRecorderListActivity.this.f22545k.a0();
                StartRunActivity startRunActivity = (StartRunActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(StartRunActivity.class);
                if (startRunActivity != null) {
                    startRunActivity.p1();
                }
                new iOSOneButtonDialog(((CommonAdapter) a.this).f1707a).setMessage(msg).show();
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnFailure(Throwable e4) {
                if (e4 instanceof SocketTimeoutException) {
                    new iOSOneButtonDialog(((CommonAdapter) a.this).f1707a).setMessage("\u4e0a\u4f20\u8d85\u65f6,\u8bf7\u68c0\u67e5\u7f51\u7edc\u540e\u91cd\u8bd5").setOneButtonText("\u786e\u5b9a").show();
                    return;
                }
                StringWriter stringWriter = new StringWriter();
                e4.printStackTrace(new PrintWriter(stringWriter));
                stringWriter.toString();
                StringBuilder sb = new StringBuilder("\u4e0a\u4f20\u5931\u8d25,\u8bf7\u7a0d\u540e\u518d\u8bd5");
                sb.append(e4.getMessage());
                new iOSOneButtonDialog(((CommonAdapter) a.this).f1707a).setMessage(sb).show();
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnOtherStatus(int status, String msg) {
                super.netOnOtherStatus(status, msg);
                if (status == 202) {
                    a(msg);
                } else {
                    new iOSOneButtonDialog(((CommonAdapter) a.this).f1707a).setMessage(msg).show();
                }
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data, String msg) {
                super.netOnSuccess(data, msg);
                a(msg);
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccessServerError(int code, String errorMessage) {
                super.netOnSuccessServerError(code, errorMessage);
                iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((CommonAdapter) a.this).f1707a);
                iosonebuttondialog.setMessage("\u4e0a\u4f20\u5f02\u5e38,\u9519\u8bef\u7801\uff1a\u3010" + code + "\u3011,\u9519\u8bef\u4fe1\u606f\uff1a" + errorMessage + ",\u8bf7\u7a0d\u540e\u518d\u8bd5\uff01").show();
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        private int v(String step) {
            if (TextUtils.isEmpty(step)) {
                return 0;
            }
            List arrayList = new ArrayList();
            try {
                if (JSON.parse(step) instanceof JSONArray) {
                    arrayList = JSON.parseArray(step, Integer.class);
                } else {
                    String[] split = step.split(",");
                    if (split.length > 0) {
                        for (String str : split) {
                            arrayList.add(Integer.valueOf(Integer.parseInt(str)));
                        }
                    }
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                String[] split2 = step.split(",");
                if (split2.length > 0) {
                    for (String str2 : split2) {
                        if (str2 != null && !"null".equalsIgnoreCase(str2)) {
                            try {
                                arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
                            } catch (NumberFormatException e5) {
                                e5.printStackTrace();
                            }
                        } else {
                            arrayList.add(0);
                        }
                    }
                }
            }
            if (arrayList == null || arrayList.size() == 0) {
                return 0;
            }
            int i4 = 0;
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                i4 += ((Integer) arrayList.get(i5)).intValue();
            }
            return i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(Map map, View view) {
            RunRecorderListActivity.this.D.v(JsonParse.getString(map, "id"), new C0282a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(Map map, View view) {
            RunRecorderListActivity.this.startActivity(new Intent(this.f1707a, AppealActivity.class).putExtra("id", JsonParse.getString(map, "id")));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y(RunDb runDataDB) {
            long parseLong = Long.parseLong(runDataDB.getCountTime());
            double parseFloat = Float.parseFloat(runDataDB.getDistance());
            Http.with(this.f1707a).setLoadingMessage("\u6b63\u5728\u4e0a\u4f20...").hideSuccessMessage().setTimeout(3L, TimeUnit.MINUTES).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).q(LoginUser.getLoginUser().getUserId(), Integer.parseInt(runDataDB.getSportsType()), Long.parseLong(runDataDB.getStartTime()), Long.parseLong(runDataDB.getEndTime()), TextUtils.isEmpty(runDataDB.getLatLngList()) ? null : runDataDB.getLatLngList(), runDataDB.getIdentify(), com.bxkj.student.run.app.utils.i.g(parseLong), com.bxkj.student.run.app.utils.i.d(parseFloat), com.bxkj.student.run.app.utils.i.a(parseFloat, parseLong), com.bxkj.student.run.app.utils.i.b(parseFloat, parseLong), TextUtils.isEmpty(runDataDB.getPassLatLngList()) ? null : runDataDB.getPassLatLngList(), z.d(), z.e(), "Android", z.c(), z.h(this.f1707a), JSON.toJSONString(runDataDB.getStepList()), runDataDB.isFaceOut(), TextUtils.isEmpty(runDataDB.getPassLatLngList()) ? null : runDataDB.getPassLatLngList(), Integer.valueOf(Integer.parseInt(runDataDB.getUploadType())), null)).setDataListener(new b(runDataDB));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: u */
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            String str;
            int i4;
            holder.J(2131233045, String.valueOf(holder.f() + 1));
            holder.J(2131232941, JsonParse.getString(stringObjectMap, "sportRange"));
            holder.J(2131233199, JsonParse.getString(stringObjectMap, "sportTime"));
            holder.J(2131233166, JsonParse.getString(stringObjectMap, "startTime"));
            holder.J(2131233169, JsonParse.getString(stringObjectMap, "remark"));
            holder.J(2131233171, String.valueOf(v(JsonParse.getString(stringObjectMap, "stepNumbers"))));
            String string = JsonParse.getString(stringObjectMap, "uploadType");
            if (TextUtils.isEmpty(string)) {
                str = "";
            } else {
                str = "\u4e0a\u4f20\u65b9\u5f0f\uff1a" + string;
            }
            holder.J(2131233215, str);
            String string2 = JsonParse.getString(stringObjectMap, "sportStatus");
            CardView cardView = (CardView) holder.h(2131231051);
            if ("-1".equalsIgnoreCase(string2)) {
                i4 = 2131558705;
                holder.J(2131230954, "\u4e0a\u4f20");
                holder.N(2131230954, true);
                holder.n(2131230954, true);
                holder.w(2131230954, new View.OnClickListener() { // from class: com.bxkj.student.run.app.record.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RunRecorderListActivity.a.this.w(stringObjectMap, view);
                    }
                });
                cardView.setCardBackgroundColor(ContextCompat.getColor(this.f1707a, 2131034475));
            } else if ("1".equals(string2)) {
                i4 = 2131165921;
                holder.N(2131230954, false);
                cardView.setCardBackgroundColor(ContextCompat.getColor(this.f1707a, 2131034196));
            } else {
                i4 = 2131165919;
                holder.N(2131230954, true);
                holder.J(2131230954, "\u6211\u8981\u7533\u8bc9");
                holder.n(2131230954, JsonParse.getBoolean(stringObjectMap, "enable"));
                holder.J(2131230954, JsonParse.getString(stringObjectMap, "va"));
                holder.w(2131230954, new View.OnClickListener() { // from class: com.bxkj.student.run.app.record.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RunRecorderListActivity.a.this.x(stringObjectMap, view);
                    }
                });
                cardView.setCardBackgroundColor(ContextCompat.getColor(this.f1707a, 2131034196));
            }
            holder.l(2131232668, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements s0.e {
        b() {
        }

        @Override // s0.d
        public void q(r0.h refreshlayout) {
            RunRecorderListActivity runRecorderListActivity = RunRecorderListActivity.this;
            runRecorderListActivity.f22556v = 1;
            runRecorderListActivity.G0(false);
        }

        @Override // s0.b
        public void s(r0.h refreshlayout) {
            RunRecorderListActivity runRecorderListActivity = RunRecorderListActivity.this;
            int i4 = runRecorderListActivity.f22557w;
            int i5 = runRecorderListActivity.f22555u;
            int i6 = i4 / i5;
            int i7 = runRecorderListActivity.f22556v;
            if (i4 % i5 != 0) {
                i6++;
            }
            if (i7 >= i6) {
                runRecorderListActivity.f22545k.h();
                Toast.makeText(((BaseActivity) RunRecorderListActivity.this).f1656h, "\u6ca1\u6709\u4e86", 0).show();
                return;
            }
            runRecorderListActivity.f22556v = i7 + 1;
            runRecorderListActivity.G0(false);
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
            super.netOnFinish();
            RunRecorderListActivity.this.f22545k.V(0);
            RunRecorderListActivity.this.f22545k.m(0);
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (JsonParse.getInt(data, "isShowMorningRun") == 1 && RunRecorderListActivity.this.f22559y == null) {
                RunRecorderListActivity runRecorderListActivity = RunRecorderListActivity.this;
                runRecorderListActivity.f22559y = runRecorderListActivity.f22553s.newTab().setTag(1).setText(RunRecorderListActivity.this.getString(2131821059));
                RunRecorderListActivity.this.f22553s.addTab(RunRecorderListActivity.this.f22559y);
                RunRecorderListActivity.this.f22553s.setVisibility(0);
            }
            if (JsonParse.getInt(data, "isShowSunRun") == 1 && RunRecorderListActivity.this.f22560z == null) {
                RunRecorderListActivity runRecorderListActivity2 = RunRecorderListActivity.this;
                runRecorderListActivity2.f22560z = runRecorderListActivity2.f22553s.newTab().setTag(2).setText(RunRecorderListActivity.this.getString(2131821368));
                RunRecorderListActivity.this.f22553s.addTab(RunRecorderListActivity.this.f22560z);
                RunRecorderListActivity.this.f22553s.setVisibility(0);
            }
            if (JsonParse.getInt(data, "isShowFreedom") == 1 && RunRecorderListActivity.this.A == null) {
                RunRecorderListActivity runRecorderListActivity3 = RunRecorderListActivity.this;
                runRecorderListActivity3.A = runRecorderListActivity3.f22553s.newTab().setTag(3).setText(RunRecorderListActivity.this.getString(2131820816));
                RunRecorderListActivity.this.f22553s.addTab(RunRecorderListActivity.this.A);
                RunRecorderListActivity.this.f22553s.setVisibility(0);
            }
            for (int i4 = 0; i4 < RunRecorderListActivity.this.f22553s.getTabCount(); i4++) {
                if (Integer.parseInt(RunRecorderListActivity.this.f22553s.getTabAt(i4).getTag().toString()) == RunRecorderListActivity.this.f22558x) {
                    RunRecorderListActivity.this.f22553s.getTabAt(i4).select();
                }
            }
            RunRecorderListActivity.this.f22553s.addOnTabSelectedListener(RunRecorderListActivity.this.B);
            RunRecorderListActivity.this.f22552r.setVisibility(0);
            RunRecorderListActivity.this.f22557w = Integer.parseInt(u.O(data, "total"));
            RunRecorderListActivity.this.f22549o.setText(JsonParse.getString(data, "count"));
            RunRecorderListActivity.this.f22550p.setText(JsonParse.getString(data, "succeed"));
            RunRecorderListActivity.this.f22551q.setText(JsonParse.getString(data, "noSucceed"));
            RunRecorderListActivity.this.f22549o.setText(String.valueOf(JsonParse.getInt(data, "total")));
            List list = (List) data.get("data");
            RunRecorderListActivity runRecorderListActivity4 = RunRecorderListActivity.this;
            if (runRecorderListActivity4.f22556v == 1) {
                runRecorderListActivity4.f22554t = list;
                RunRecorderListActivity.this.H0();
            } else {
                runRecorderListActivity4.f22554t.addAll(list);
            }
            RunRecorderListActivity.this.f22547m.g(RunRecorderListActivity.this.f22554t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d implements l1.l<List<RunDb>, f1> {
        d() {
        }

        @Override // l1.l
        /* renamed from: a */
        public f1 invoke(List<RunDb> runDbs) {
            if (runDbs == null || runDbs.size() <= 0) {
                return null;
            }
            for (RunDb runDb : runDbs) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", runDb.getIdentify());
                hashMap.put("sportStatus", "-1");
                hashMap.put("startTime", RunRecorderListActivity.this.C.format(Long.valueOf(Long.parseLong(runDb.getStartTime()))));
                hashMap.put("sportRange", com.bxkj.student.run.app.utils.i.d(Double.parseDouble(runDb.getDistance())) + "KM");
                hashMap.put("sportTime", com.bxkj.student.run.app.utils.i.g(Long.parseLong(runDb.getCountTime())));
                hashMap.put("stepNumbers", runDb.getStepList());
                hashMap.put("remark", "\u8be5\u6761\u8dd1\u6b65\u8bb0\u5f55\u5728\u672c\u5730\u6682\u5b58,\u8bf7\u5c3d\u5feb\u4e0a\u4f20");
                if (RunRecorderListActivity.this.f22554t == null) {
                    RunRecorderListActivity.this.f22554t = new ArrayList();
                }
                RunRecorderListActivity.this.f22554t.add(0, hashMap);
                RunRecorderListActivity.this.f22547m.g(RunRecorderListActivity.this.f22554t);
            }
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class e implements TabLayout.OnTabSelectedListener {
        e() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            RunRecorderListActivity.this.f22558x = Integer.parseInt(tab.getTag().toString());
            RunRecorderListActivity.this.f22552r.setVisibility(8);
            if (RunRecorderListActivity.this.f22554t != null) {
                RunRecorderListActivity.this.f22554t.clear();
            }
            RunRecorderListActivity.this.f22547m.notifyItemRangeRemoved(0, RunRecorderListActivity.this.f22547m.getItemCount());
            RunRecorderListActivity.this.f22547m.g(RunRecorderListActivity.this.f22554t);
            RunRecorderListActivity runRecorderListActivity = RunRecorderListActivity.this;
            runRecorderListActivity.f22556v = 1;
            runRecorderListActivity.G0(true);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public static String F0(long recordingTime) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        long j4 = recordingTime / 3600;
        if (j4 > 9) {
            sb = new StringBuilder();
            sb.append(j4);
            sb.append("");
        } else {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(j4);
        }
        String sb4 = sb.toString();
        long j5 = recordingTime % 3600;
        long j6 = j5 / 60;
        if (j6 > 9) {
            sb2 = new StringBuilder();
            sb2.append(j6);
            sb2.append("");
        } else {
            sb2 = new StringBuilder();
            sb2.append("0");
            sb2.append(j6);
        }
        String sb5 = sb2.toString();
        long j7 = j5 % 60;
        if (j7 > 9) {
            sb3 = new StringBuilder();
            sb3.append(j7);
            sb3.append("");
        } else {
            sb3 = new StringBuilder();
            sb3.append("0");
            sb3.append(j7);
        }
        String sb6 = sb3.toString();
        return sb4 + ":" + sb5 + ":" + sb6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        this.D.x(this.f22558x, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0(ViewGroup viewGroup, View view, Object obj, int i4) {
        if ("-1".equalsIgnoreCase(JsonParse.getString(this.f22547m.getItem(i4), "sportStatus"))) {
            startActivity(new Intent(this.f1656h, RunDetailActivity.class).putExtra("runDataDbId", JsonParse.getString(this.f22547m.getItem(i4), "id")));
            return;
        }
        startActivity(new Intent(this.f1656h, RunDetailActivity.class).putExtra("sportRecordId", JsonParse.getString(this.f22547m.getItem(i4), "id")));
    }

    public void G0(boolean showLoadingDialog) {
        Http.with(this.f1656h).setShowLoadingDialog(showLoadingDialog).setObservable(((com.bxkj.student.run.app.a) Http.getApiService(com.bxkj.student.run.app.a.class)).j(LoginUser.getLoginUser().getUserId(), this.f22558x, this.f22556v, this.f22555u)).setDataListener(new c());
    }

    public void I0() {
        this.f22545k.n1(new b());
    }

    public void K0() {
        this.f22545k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.B = new e();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427474;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.D = (RunVM) new ViewModelProvider(this).get(RunVM.class);
        if (getIntent().hasExtra("runType")) {
            this.f22558x = getIntent().getIntExtra("runType", 2);
        }
        this.C = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.f22546l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        a aVar = new a(this.f1656h, 2131427753, this.f22554t);
        this.f22547m = aVar;
        this.f22546l.setAdapter(aVar);
        this.f22546l.setEmptyView(this.f22548n);
        this.f22547m.k(new cn.bluemobi.dylan.base.adapter.common.recyclerview.b() { // from class: com.bxkj.student.run.app.record.k
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
            public final void a(ViewGroup viewGroup, View view, Object obj, int i4) {
                RunRecorderListActivity.this.J0(viewGroup, view, obj, i4);
            }
        });
        I0();
        this.f22545k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8dd1\u6b65\u8bb0\u5f55");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f22545k = (SmartRefreshLayout) findViewById(2131232482);
        this.f22546l = (EmptyRecyclerView) findViewById(2131232481);
        this.f22549o = (TextView) findViewById(2131232914);
        this.f22550p = (TextView) findViewById(2131233241);
        this.f22551q = (TextView) findViewById(2131233045);
        this.f22553s = (TabLayout) findViewById(2131232772);
        this.f22552r = (CardView) findViewById(2131231055);
        this.f22548n = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }
}
