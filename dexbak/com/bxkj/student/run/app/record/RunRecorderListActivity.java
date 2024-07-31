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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.SystemUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.RunApiService;
import com.bxkj.student.run.app.StartRunActivity;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.p093vm.RunVM;
import com.bxkj.student.run.app.record.RunRecorderListActivity;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.google.android.material.tabs.TabLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.umeng.analytics.AnalyticsConfig;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import p617l1.InterfaceC15280l;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RunRecorderListActivity extends BaseActivity {

    /* renamed from: A */
    private TabLayout.Tab f19309A;

    /* renamed from: B */
    private TabLayout.OnTabSelectedListener f19310B;

    /* renamed from: C */
    private SimpleDateFormat f19311C;

    /* renamed from: D */
    private RunVM f19312D;

    /* renamed from: k */
    private SmartRefreshLayout f19313k;

    /* renamed from: l */
    private EmptyRecyclerView f19314l;

    /* renamed from: m */
    private CommonAdapter<Map<String, Object>> f19315m;

    /* renamed from: n */
    private TextView f19316n;

    /* renamed from: o */
    private TextView f19317o;

    /* renamed from: p */
    private TextView f19318p;

    /* renamed from: q */
    private TextView f19319q;

    /* renamed from: r */
    private CardView f19320r;

    /* renamed from: s */
    private TabLayout f19321s;

    /* renamed from: t */
    private List<Map<String, Object>> f19322t = new ArrayList();

    /* renamed from: u */
    protected int f19323u = 10;

    /* renamed from: v */
    protected int f19324v = 1;

    /* renamed from: w */
    protected int f19325w = 1;

    /* renamed from: x */
    private int f19326x = 2;

    /* renamed from: y */
    private TabLayout.Tab f19327y;

    /* renamed from: z */
    private TabLayout.Tab f19328z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.record.RunRecorderListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5320a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.run.app.record.RunRecorderListActivity$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C5321a implements InterfaceC15280l<List<RunDb>, Unit> {
            C5321a() {
            }

            @Override // p617l1.InterfaceC15280l
            /* renamed from: a */
            public Unit invoke(List<RunDb> runDbs) {
                if (runDbs == null || runDbs.size() <= 0) {
                    return null;
                }
                C5320a.this.m39810y(runDbs.get(0));
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.run.app.record.RunRecorderListActivity$a$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C5322b extends HttpCallBack {

            /* renamed from: a */
            final /* synthetic */ RunDb f19331a;

            C5322b(final RunDb val$runDataDB) {
                this.f19331a = val$runDataDB;
            }

            /* renamed from: a */
            private void m39808a(String msg) {
                RunRecorderListActivity.this.f19312D.m39504u(this.f19331a.getIdentify());
                RunRecorderListActivity.this.f19313k.mo2052a0();
                StartRunActivity startRunActivity = (StartRunActivity) AppManager.m57776n().getActivity(StartRunActivity.class);
                if (startRunActivity != null) {
                    startRunActivity.m40151p1();
                }
                new iOSOneButtonDialog(((CommonAdapter) C5320a.this).f1721a).setMessage(msg).show();
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnFailure(Throwable e) {
                if (e instanceof SocketTimeoutException) {
                    new iOSOneButtonDialog(((CommonAdapter) C5320a.this).f1721a).setMessage("上传超时,请检查网络后重试").setOneButtonText("确定").show();
                    return;
                }
                StringWriter stringWriter = new StringWriter();
                e.printStackTrace(new PrintWriter(stringWriter));
                stringWriter.toString();
                StringBuilder sb = new StringBuilder("上传失败,请稍后再试");
                sb.append(e.getMessage());
                new iOSOneButtonDialog(((CommonAdapter) C5320a.this).f1721a).setMessage(sb).show();
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnOtherStatus(int status, String msg) {
                super.netOnOtherStatus(status, msg);
                if (status == 202) {
                    m39808a(msg);
                } else {
                    new iOSOneButtonDialog(((CommonAdapter) C5320a.this).f1721a).setMessage(msg).show();
                }
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data, String msg) {
                super.netOnSuccess(data, msg);
                m39808a(msg);
            }

            @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccessServerError(int code, String errorMessage) {
                super.netOnSuccessServerError(code, errorMessage);
                iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((CommonAdapter) C5320a.this).f1721a);
                iosonebuttondialog.setMessage("上传异常,错误码：【" + code + "】,错误信息：" + errorMessage + ",请稍后再试！").show();
            }
        }

        C5320a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        /* renamed from: v */
        private int m39813v(String step) {
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
            } catch (Exception e) {
                e.printStackTrace();
                String[] split2 = step.split(",");
                if (split2.length > 0) {
                    for (String str2 : split2) {
                        if (str2 != null && !"null".equalsIgnoreCase(str2)) {
                            try {
                                arrayList.add(Integer.valueOf(Integer.parseInt(str2)));
                            } catch (NumberFormatException e2) {
                                e2.printStackTrace();
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
            int i = 0;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                i += ((Integer) arrayList.get(i2)).intValue();
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: w */
        public /* synthetic */ void m39812w(Map map, View view) {
            RunRecorderListActivity.this.f19312D.m39503v(JsonParse.getString(map, "id"), new C5321a());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: x */
        public /* synthetic */ void m39811x(Map map, View view) {
            RunRecorderListActivity.this.startActivity(new Intent(this.f1721a, AppealActivity.class).putExtra("id", JsonParse.getString(map, "id")));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: y */
        public void m39810y(RunDb runDataDB) {
            long parseLong = Long.parseLong(runDataDB.getCountTime());
            double parseFloat = Float.parseFloat(runDataDB.getDistance());
            Http.with(this.f1721a).setLoadingMessage("正在上传...").hideSuccessMessage().setTimeout(3L, TimeUnit.MINUTES).setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40104q(LoginUser.getLoginUser().getUserId(), Integer.parseInt(runDataDB.getSportsType()), Long.parseLong(runDataDB.getStartTime()), Long.parseLong(runDataDB.getEndTime()), TextUtils.isEmpty(runDataDB.getLatLngList()) ? null : runDataDB.getLatLngList(), runDataDB.getIdentify(), FormatUtils.m39630g(parseLong), FormatUtils.m39633d(parseFloat), FormatUtils.m39636a(parseFloat, parseLong), FormatUtils.m39635b(parseFloat, parseLong), TextUtils.isEmpty(runDataDB.getPassLatLngList()) ? null : runDataDB.getPassLatLngList(), SystemUtils.m44002d(), SystemUtils.m44001e(), "Android", SystemUtils.m44003c(), SystemUtils.m43998h(this.f1721a), JSON.toJSONString(runDataDB.getStepList()), runDataDB.isFaceOut(), TextUtils.isEmpty(runDataDB.getPassLatLngList()) ? null : runDataDB.getPassLatLngList(), Integer.valueOf(Integer.parseInt(runDataDB.getUploadType())), null)).setDataListener(new C5322b(runDataDB));
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: u */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            String str;
            int i;
            holder.m57874J(2131233045, String.valueOf(holder.m57864f() + 1));
            holder.m57874J(2131232941, JsonParse.getString(stringObjectMap, "sportRange"));
            holder.m57874J(C4215R.C4219id.tv_time_count, JsonParse.getString(stringObjectMap, "sportTime"));
            holder.m57874J(2131233166, JsonParse.getString(stringObjectMap, AnalyticsConfig.RTD_START_TIME));
            holder.m57874J(2131233169, JsonParse.getString(stringObjectMap, "remark"));
            holder.m57874J(C4215R.C4219id.tv_step_count, String.valueOf(m39813v(JsonParse.getString(stringObjectMap, "stepNumbers"))));
            String string = JsonParse.getString(stringObjectMap, "uploadType");
            if (TextUtils.isEmpty(string)) {
                str = "";
            } else {
                str = "上传方式：" + string;
            }
            holder.m57874J(C4215R.C4219id.tv_upload_type, str);
            String string2 = JsonParse.getString(stringObjectMap, "sportStatus");
            CardView cardView = (CardView) holder.m57862h(2131231051);
            if ("-1".equalsIgnoreCase(string2)) {
                i = C4215R.mipmap.icon_local;
                holder.m57874J(C4215R.C4219id.bt_appeal, "上传");
                holder.m57870N(C4215R.C4219id.bt_appeal, true);
                holder.m57856n(C4215R.C4219id.bt_appeal, true);
                holder.m57847w(C4215R.C4219id.bt_appeal, new View.OnClickListener() { // from class: com.bxkj.student.run.app.record.m
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RunRecorderListActivity.C5320a.this.m39812w(stringObjectMap, view);
                    }
                });
                cardView.setCardBackgroundColor(ContextCompat.getColor(this.f1721a, 2131034475));
            } else if ("1".equals(string2)) {
                i = C4215R.C4218drawable.round_blue;
                holder.m57870N(C4215R.C4219id.bt_appeal, false);
                cardView.setCardBackgroundColor(ContextCompat.getColor(this.f1721a, 2131034196));
            } else {
                i = C4215R.C4218drawable.red_round;
                holder.m57870N(C4215R.C4219id.bt_appeal, true);
                holder.m57874J(C4215R.C4219id.bt_appeal, "我要申诉");
                holder.m57856n(C4215R.C4219id.bt_appeal, JsonParse.getBoolean(stringObjectMap, "enable"));
                holder.m57874J(C4215R.C4219id.bt_appeal, JsonParse.getString(stringObjectMap, "va"));
                holder.m57847w(C4215R.C4219id.bt_appeal, new View.OnClickListener() { // from class: com.bxkj.student.run.app.record.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RunRecorderListActivity.C5320a.this.m39811x(stringObjectMap, view);
                    }
                });
                cardView.setCardBackgroundColor(ContextCompat.getColor(this.f1721a, 2131034196));
            }
            holder.m57858l(C4215R.C4219id.status, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.record.RunRecorderListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5323b implements OnRefreshLoadmoreListener {
        C5323b() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            RunRecorderListActivity runRecorderListActivity = RunRecorderListActivity.this;
            runRecorderListActivity.f19324v = 1;
            runRecorderListActivity.m39845G0(false);
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            RunRecorderListActivity runRecorderListActivity = RunRecorderListActivity.this;
            int i = runRecorderListActivity.f19325w;
            int i2 = runRecorderListActivity.f19323u;
            int i3 = i / i2;
            int i4 = runRecorderListActivity.f19324v;
            if (i % i2 != 0) {
                i3++;
            }
            if (i4 >= i3) {
                runRecorderListActivity.f19313k.mo2041g();
                Toast.makeText(((BaseActivity) RunRecorderListActivity.this).f1669h, "没有了", 0).show();
                return;
            }
            runRecorderListActivity.f19324v = i4 + 1;
            runRecorderListActivity.m39845G0(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.record.RunRecorderListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5324c extends HttpCallBack {
        C5324c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            RunRecorderListActivity.this.f19313k.mo2057W(0);
            RunRecorderListActivity.this.f19313k.mo2027n(0);
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (JsonParse.getInt(data, "isShowMorningRun") == 1 && RunRecorderListActivity.this.f19327y == null) {
                RunRecorderListActivity runRecorderListActivity = RunRecorderListActivity.this;
                runRecorderListActivity.f19327y = runRecorderListActivity.f19321s.newTab().setTag(1).setText(RunRecorderListActivity.this.getString(C4215R.C4224string.morning_run));
                RunRecorderListActivity.this.f19321s.addTab(RunRecorderListActivity.this.f19327y);
                RunRecorderListActivity.this.f19321s.setVisibility(0);
            }
            if (JsonParse.getInt(data, "isShowSunRun") == 1 && RunRecorderListActivity.this.f19328z == null) {
                RunRecorderListActivity runRecorderListActivity2 = RunRecorderListActivity.this;
                runRecorderListActivity2.f19328z = runRecorderListActivity2.f19321s.newTab().setTag(2).setText(RunRecorderListActivity.this.getString(C4215R.C4224string.sunshine_run));
                RunRecorderListActivity.this.f19321s.addTab(RunRecorderListActivity.this.f19328z);
                RunRecorderListActivity.this.f19321s.setVisibility(0);
            }
            if (JsonParse.getInt(data, "isShowFreedom") == 1 && RunRecorderListActivity.this.f19309A == null) {
                RunRecorderListActivity runRecorderListActivity3 = RunRecorderListActivity.this;
                runRecorderListActivity3.f19309A = runRecorderListActivity3.f19321s.newTab().setTag(3).setText(RunRecorderListActivity.this.getString(C4215R.C4224string.free_run));
                RunRecorderListActivity.this.f19321s.addTab(RunRecorderListActivity.this.f19309A);
                RunRecorderListActivity.this.f19321s.setVisibility(0);
            }
            for (int i = 0; i < RunRecorderListActivity.this.f19321s.getTabCount(); i++) {
                if (Integer.parseInt(RunRecorderListActivity.this.f19321s.getTabAt(i).getTag().toString()) == RunRecorderListActivity.this.f19326x) {
                    RunRecorderListActivity.this.f19321s.getTabAt(i).select();
                }
            }
            RunRecorderListActivity.this.f19321s.addOnTabSelectedListener(RunRecorderListActivity.this.f19310B);
            RunRecorderListActivity.this.f19320r.setVisibility(0);
            RunRecorderListActivity.this.f19325w = Integer.parseInt(Tools.m57632O(data, "total"));
            RunRecorderListActivity.this.f19317o.setText(JsonParse.getString(data, "count"));
            RunRecorderListActivity.this.f19318p.setText(JsonParse.getString(data, "succeed"));
            RunRecorderListActivity.this.f19319q.setText(JsonParse.getString(data, "noSucceed"));
            RunRecorderListActivity.this.f19317o.setText(String.valueOf(JsonParse.getInt(data, "total")));
            List list = (List) data.get("data");
            RunRecorderListActivity runRecorderListActivity4 = RunRecorderListActivity.this;
            if (runRecorderListActivity4.f19324v == 1) {
                runRecorderListActivity4.f19322t = list;
                RunRecorderListActivity.this.m39844H0();
            } else {
                runRecorderListActivity4.f19322t.addAll(list);
            }
            RunRecorderListActivity.this.f19315m.m57836g(RunRecorderListActivity.this.f19322t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.record.RunRecorderListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5325d implements InterfaceC15280l<List<RunDb>, Unit> {
        C5325d() {
        }

        @Override // p617l1.InterfaceC15280l
        /* renamed from: a */
        public Unit invoke(List<RunDb> runDbs) {
            if (runDbs == null || runDbs.size() <= 0) {
                return null;
            }
            for (RunDb runDb : runDbs) {
                HashMap hashMap = new HashMap();
                hashMap.put("id", runDb.getIdentify());
                hashMap.put("sportStatus", "-1");
                hashMap.put(AnalyticsConfig.RTD_START_TIME, RunRecorderListActivity.this.f19311C.format(Long.valueOf(Long.parseLong(runDb.getStartTime()))));
                hashMap.put("sportRange", FormatUtils.m39633d(Double.parseDouble(runDb.getDistance())) + "KM");
                hashMap.put("sportTime", FormatUtils.m39630g(Long.parseLong(runDb.getCountTime())));
                hashMap.put("stepNumbers", runDb.getStepList());
                hashMap.put("remark", "该条跑步记录在本地暂存,请尽快上传");
                if (RunRecorderListActivity.this.f19322t == null) {
                    RunRecorderListActivity.this.f19322t = new ArrayList();
                }
                RunRecorderListActivity.this.f19322t.add(0, hashMap);
                RunRecorderListActivity.this.f19315m.m57836g(RunRecorderListActivity.this.f19322t);
            }
            return null;
        }
    }

    /* renamed from: com.bxkj.student.run.app.record.RunRecorderListActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5326e implements TabLayout.OnTabSelectedListener {
        C5326e() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            RunRecorderListActivity.this.f19326x = Integer.parseInt(tab.getTag().toString());
            RunRecorderListActivity.this.f19320r.setVisibility(8);
            if (RunRecorderListActivity.this.f19322t != null) {
                RunRecorderListActivity.this.f19322t.clear();
            }
            RunRecorderListActivity.this.f19315m.notifyItemRangeRemoved(0, RunRecorderListActivity.this.f19315m.getItemCount());
            RunRecorderListActivity.this.f19315m.m57836g(RunRecorderListActivity.this.f19322t);
            RunRecorderListActivity runRecorderListActivity = RunRecorderListActivity.this;
            runRecorderListActivity.f19324v = 1;
            runRecorderListActivity.m39845G0(true);
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* renamed from: F0 */
    public static String m39846F0(long recordingTime) {
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        long j = recordingTime / 3600;
        if (j > 9) {
            sb = new StringBuilder();
            sb.append(j);
            sb.append("");
        } else {
            sb = new StringBuilder();
            sb.append("0");
            sb.append(j);
        }
        String sb4 = sb.toString();
        long j2 = recordingTime % 3600;
        long j3 = j2 / 60;
        if (j3 > 9) {
            sb2 = new StringBuilder();
            sb2.append(j3);
            sb2.append("");
        } else {
            sb2 = new StringBuilder();
            sb2.append("0");
            sb2.append(j3);
        }
        String sb5 = sb2.toString();
        long j4 = j2 % 60;
        if (j4 > 9) {
            sb3 = new StringBuilder();
            sb3.append(j4);
            sb3.append("");
        } else {
            sb3 = new StringBuilder();
            sb3.append("0");
            sb3.append(j4);
        }
        String sb6 = sb3.toString();
        return sb4 + ":" + sb5 + ":" + sb6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H0 */
    public void m39844H0() {
        this.f19312D.m39501x(this.f19326x, new C5325d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J0 */
    public /* synthetic */ void m39842J0(ViewGroup viewGroup, View view, Object obj, int i) {
        if ("-1".equalsIgnoreCase(JsonParse.getString(this.f19315m.getItem(i), "sportStatus"))) {
            startActivity(new Intent(this.f1669h, RunDetailActivity.class).putExtra("runDataDbId", JsonParse.getString(this.f19315m.getItem(i), "id")));
            return;
        }
        startActivity(new Intent(this.f1669h, RunDetailActivity.class).putExtra("sportRecordId", JsonParse.getString(this.f19315m.getItem(i), "id")));
    }

    /* renamed from: G0 */
    public void m39845G0(boolean showLoadingDialog) {
        Http.with(this.f1669h).setShowLoadingDialog(showLoadingDialog).setObservable(((RunApiService) Http.getApiService(RunApiService.class)).m40111j(LoginUser.getLoginUser().getUserId(), this.f19326x, this.f19324v, this.f19323u)).setDataListener(new C5324c());
    }

    /* renamed from: I0 */
    public void m39843I0() {
        this.f19313k.mo2019v(new C5323b());
    }

    /* renamed from: K0 */
    public void m39841K0() {
        this.f19313k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f19310B = new C5326e();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_run_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f19312D = (RunVM) new ViewModelProvider(this).get(RunVM.class);
        if (getIntent().hasExtra("runType")) {
            this.f19326x = getIntent().getIntExtra("runType", 2);
        }
        this.f19311C = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.f19314l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C5320a c5320a = new C5320a(this.f1669h, C4215R.C4221layout.item_for_run_recorder_list, this.f19322t);
        this.f19315m = c5320a;
        this.f19314l.setAdapter(c5320a);
        this.f19314l.setEmptyView(this.f19316n);
        this.f19315m.m57834k(new OnItemClickListener() { // from class: com.bxkj.student.run.app.record.k
            @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
            /* renamed from: a */
            public final void mo39403a(ViewGroup viewGroup, View view, Object obj, int i) {
                RunRecorderListActivity.this.m39842J0(viewGroup, view, obj, i);
            }
        });
        m39843I0();
        this.f19313k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("跑步记录");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f19313k = (SmartRefreshLayout) findViewById(2131232482);
        this.f19314l = (EmptyRecyclerView) findViewById(2131232481);
        this.f19317o = (TextView) findViewById(2131232914);
        this.f19318p = (TextView) findViewById(C4215R.C4219id.tv_yes);
        this.f19319q = (TextView) findViewById(2131233045);
        this.f19321s = (TabLayout) findViewById(C4215R.C4219id.tl_run_type);
        this.f19320r = (CardView) findViewById(2131231055);
        this.f19316n = (TextView) findViewById(2131232952);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
    }
}
