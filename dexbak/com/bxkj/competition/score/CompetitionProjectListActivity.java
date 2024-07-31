package com.bxkj.competition.score;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.C4017R;
import com.bxkj.competition.CompeApiService;
import com.bxkj.competition.score.student.StudentScoreListActivity;
import com.bxkj.competition.score.teacher.AddScoreMenuActivity;
import com.bxkj.competition.score.teacher.FieldScoreListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p638r0.RefreshLayout;
import p642s0.OnRefreshListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CompetitionProjectListActivity extends BaseActivity {

    /* renamed from: k */
    private SmartRefreshLayout f15444k;

    /* renamed from: l */
    private EmptyRecyclerView f15445l;

    /* renamed from: m */
    private TextView f15446m;

    /* renamed from: n */
    private TextView f15447n;

    /* renamed from: o */
    private TextView f15448o;

    /* renamed from: p */
    private List<Map<String, Object>> f15449p = new ArrayList();

    /* renamed from: q */
    private List<Map<String, Object>> f15450q = new ArrayList();

    /* renamed from: r */
    private List<Map<String, Object>> f15451r = new ArrayList();

    /* renamed from: s */
    private List<Map<String, Object>> f15452s = new ArrayList();

    /* renamed from: t */
    private CommonAdapter<Map<String, Object>> f15453t;

    /* renamed from: u */
    private String f15454u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.CompetitionProjectListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4051a implements OnRefreshListener {
        C4051a() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            CompetitionProjectListActivity.this.m43351F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.CompetitionProjectListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4052b extends CommonAdapter<Map<String, Object>> {
        C4052b(Context x0, int x1, List x2) {
            super(x0, x1, x2);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(C4017R.C4021id.tv_name, JsonParse.getString(stringObjectMap, "sportItem"));
            holder.m57874J(C4017R.C4021id.tv_group, JsonParse.getString(stringObjectMap, "groupName"));
            holder.m57874J(C4017R.C4021id.tv_progress, JsonParse.getString(stringObjectMap, "gameForm"));
            int i = C4017R.C4021id.tv_type;
            StringBuilder sb = new StringBuilder();
            sb.append("分组：");
            sb.append(TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "group")) ? "未分组" : JsonParse.getString(stringObjectMap, "group"));
            holder.m57874J(i, sb.toString());
            int i2 = C4017R.C4021id.tv_time;
            holder.m57874J(i2, JsonParse.getString(stringObjectMap, "sportCompetitionDateName") + JsonParse.getString(stringObjectMap, "competitionTime"));
            holder.m57874J(C4017R.C4021id.tv_type2, JsonParse.getString(stringObjectMap, "type").equals("1") ? "径赛" : "田赛");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.CompetitionProjectListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4053c extends HttpCallBack {
        C4053c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            CompetitionProjectListActivity.this.f15444k.mo2078B();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CompetitionProjectListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionProjectListActivity.this.f15452s = JsonParse.getList(data, "data");
            CompetitionProjectListActivity.this.f15453t.m57836g(CompetitionProjectListActivity.this.f15452s);
        }
    }

    /* renamed from: com.bxkj.competition.score.CompetitionProjectListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4054d implements OnItemClickListener {
        C4054d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            if (LoginUser.getLoginUser().getUserType() == 2) {
                if (JsonParse.getString((Map) CompetitionProjectListActivity.this.f15453t.getItem(position), "type").equals("1")) {
                    CompetitionProjectListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionProjectListActivity.this).f1669h, AddScoreMenuActivity.class).putExtra("scheduleId", JsonParse.getString((Map) CompetitionProjectListActivity.this.f15453t.getItem(position), "id")));
                    return;
                } else {
                    CompetitionProjectListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionProjectListActivity.this).f1669h, FieldScoreListActivity.class).putExtra("scheduleId", JsonParse.getString((Map) CompetitionProjectListActivity.this.f15453t.getItem(position), "id")));
                    return;
                }
            }
            CompetitionProjectListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionProjectListActivity.this).f1669h, StudentScoreListActivity.class).putExtra("scheduleId", JsonParse.getString((Map) CompetitionProjectListActivity.this.f15453t.getItem(position), "id")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.CompetitionProjectListActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4055e extends HttpCallBack {
        C4055e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CompetitionProjectListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionProjectListActivity.this.f15449p = JsonParse.getList(data, "data");
            HashMap hashMap = new HashMap(2);
            hashMap.put("id", "-1");
            hashMap.put("name", "全部时间");
            CompetitionProjectListActivity.this.f15449p.add(0, hashMap);
            CompetitionProjectListActivity competitionProjectListActivity = CompetitionProjectListActivity.this;
            competitionProjectListActivity.m43345L0(competitionProjectListActivity.f15446m, "请选择时间", CompetitionProjectListActivity.this.f15449p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.CompetitionProjectListActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4056f extends HttpCallBack {
        C4056f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CompetitionProjectListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionProjectListActivity.this.f15450q = JsonParse.getList(data, "data");
            HashMap hashMap = new HashMap(2);
            hashMap.put("id", "-1");
            hashMap.put("name", "全部分组");
            CompetitionProjectListActivity.this.f15450q.add(0, hashMap);
            CompetitionProjectListActivity competitionProjectListActivity = CompetitionProjectListActivity.this;
            competitionProjectListActivity.m43345L0(competitionProjectListActivity.f15447n, "请选择组别", CompetitionProjectListActivity.this.f15450q);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.CompetitionProjectListActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4057g extends HttpCallBack {
        C4057g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CompetitionProjectListActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionProjectListActivity.this.f15451r = JsonParse.getList(data, "data");
            HashMap hashMap = new HashMap(2);
            hashMap.put("id", "-1");
            hashMap.put("name", "全部项目");
            CompetitionProjectListActivity.this.f15451r.add(0, hashMap);
            CompetitionProjectListActivity competitionProjectListActivity = CompetitionProjectListActivity.this;
            competitionProjectListActivity.m43345L0(competitionProjectListActivity.f15448o, "请选择项目", CompetitionProjectListActivity.this.f15451r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.competition.score.CompetitionProjectListActivity$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class DialogInterface$OnClickListenerC4058h implements DialogInterface.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ TextView f15462a;

        /* renamed from: b */
        final /* synthetic */ List f15463b;

        DialogInterface$OnClickListenerC4058h(final TextView val$dataList, final List val$tv) {
            this.f15462a = val$dataList;
            this.f15463b = val$tv;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int which) {
            this.f15462a.setText(Tools.m57632O((Map) this.f15463b.get(which), "name"));
            this.f15462a.setTag(Tools.m57632O((Map) this.f15463b.get(which), "id"));
            if (this.f15462a.getId() == CompetitionProjectListActivity.this.f15447n.getId()) {
                CompetitionProjectListActivity.this.f15448o.setText("全部项目");
                CompetitionProjectListActivity.this.f15448o.setTag("-1");
            }
            CompetitionProjectListActivity.this.f15444k.mo2052a0();
        }
    }

    /* renamed from: E0 */
    private void m43352E0(Dialog dialog, int color) {
        View findViewById = dialog.findViewById(dialog.getContext().getResources().getIdentifier("android:id/titleDivider", null, null));
        if (findViewById != null) {
            findViewById.setBackgroundColor(color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public void m43351F0() {
        Http.with(this.f1669h).hideOtherStatusMessage().hideLoadingDialog().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43437t(this.f15454u, this.f15447n.getTag().toString().equals("-1") ? null : this.f15447n.getTag(), this.f15448o.getTag().toString().equals("-1") ? null : this.f15448o.getTag(), this.f15446m.getTag().toString().equals("-1") ? null : this.f15446m.getTag())).setDataListener(new C4053c());
    }

    /* renamed from: G0 */
    private void m43350G0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43435v(this.f15454u)).setDataListener(new C4055e());
    }

    /* renamed from: H0 */
    private void m43349H0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43442o(this.f15454u)).setDataListener(new C4056f());
    }

    /* renamed from: I0 */
    private void m43348I0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((CompeApiService) Http.getApiService(CompeApiService.class)).m43441p(this.f15447n.getTag().toString())).setDataListener(new C4057g());
    }

    /* renamed from: J0 */
    private void m43347J0() {
        this.f15445l.setLayoutManager(new LinearLayoutManager(this.f1669h));
        C4052b c4052b = new C4052b(this.f1669h, C4017R.C4023layout.item_for_addscore_project_list, this.f15452s);
        this.f15453t = c4052b;
        this.f15445l.setAdapter(c4052b);
        this.f15445l.setEmptyView(findViewById(C4017R.C4021id.tv_emptyView));
    }

    /* renamed from: K0 */
    private void m43346K0() {
        this.f15444k.mo2035j(new C4051a());
    }

    /* renamed from: L0 */
    public void m43345L0(final TextView tv2, final String title, final List<Map<String, Object>> dataList) {
        String[] strArr = new String[dataList.size()];
        for (int i = 0; i < dataList.size(); i++) {
            strArr[i] = Tools.m57632O(dataList.get(i), "name");
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f1669h);
        View inflate = LayoutInflater.from(this.f1669h).inflate(C4017R.C4023layout.dialog_title, (ViewGroup) null);
        ((TextView) inflate.findViewById(C4017R.C4021id.tvTitle)).setText(title);
        builder.setCustomTitle(inflate);
        builder.setItems(strArr, new DialogInterface$OnClickListenerC4058h(tv2, dataList));
        AlertDialog create = builder.create();
        create.getListView().setDivider(new ColorDrawable(Color.parseColor("#999999")));
        create.getListView().setDividerHeight(m43344i0(0.5f, this.f1669h));
        create.show();
        m43352E0(create, Color.parseColor("#8e8b8b"));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f15446m.setOnClickListener(this);
        this.f15447n.setOnClickListener(this);
        this.f15448o.setOnClickListener(this);
        this.f15453t.m57834k(new C4054d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4017R.C4023layout.ac_addscore_project_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("competitionId")) {
            this.f15454u = getIntent().getStringExtra("competitionId");
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("id", "-1");
        hashMap.put("name", "全部项目");
        this.f15451r.add(hashMap);
        m43346K0();
        m43347J0();
        this.f15444k.mo2050b0(true);
        this.f15444k.mo2064P(false);
        this.f15444k.mo2052a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("竞赛项目列表");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f15444k = (SmartRefreshLayout) findViewById(C4017R.C4021id.refresh);
        this.f15445l = (EmptyRecyclerView) findViewById(C4017R.C4021id.recyclerView);
        this.f15446m = (TextView) findViewById(C4017R.C4021id.tv_time);
        this.f15447n = (TextView) findViewById(C4017R.C4021id.tv_group);
        this.f15448o = (TextView) findViewById(C4017R.C4021id.tv_project);
    }

    /* renamed from: i0 */
    public int m43344i0(float size, Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        double d = size * displayMetrics.density;
        Double.isNaN(d);
        return (int) (d + 0.5d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == this.f15446m.getId()) {
            List<Map<String, Object>> list = this.f15449p;
            if (list != null && list.size() != 0) {
                m43345L0(this.f15446m, "请选择组别", this.f15449p);
            } else {
                m43350G0();
            }
        } else if (v.getId() == this.f15447n.getId()) {
            List<Map<String, Object>> list2 = this.f15450q;
            if (list2 != null && list2.size() != 0) {
                m43345L0(this.f15447n, "请选择组别", this.f15450q);
            } else {
                m43349H0();
            }
        } else if (v.getId() == this.f15448o.getId()) {
            if (this.f15447n.getTag() != null && !this.f15447n.getTag().toString().equals("-1")) {
                m43348I0();
            } else {
                new iOSOneButtonDialog(this.f1669h).setMessage("请先选择组别").show();
            }
        }
    }
}
