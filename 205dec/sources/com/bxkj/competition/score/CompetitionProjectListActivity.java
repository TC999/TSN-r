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
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.competition.R;
import com.bxkj.competition.score.student.StudentScoreListActivity;
import com.bxkj.competition.score.teacher.AddScoreMenuActivity;
import com.bxkj.competition.score.teacher.FieldScoreListActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CompetitionProjectListActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private SmartRefreshLayout f18988k;

    /* renamed from: l  reason: collision with root package name */
    private EmptyRecyclerView f18989l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f18990m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f18991n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f18992o;

    /* renamed from: p  reason: collision with root package name */
    private List<Map<String, Object>> f18993p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private List<Map<String, Object>> f18994q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private List<Map<String, Object>> f18995r = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    private List<Map<String, Object>> f18996s = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f18997t;

    /* renamed from: u  reason: collision with root package name */
    private String f18998u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements s0.d {
        a() {
        }

        @Override // s0.d
        public void q(r0.h refreshlayout) {
            CompetitionProjectListActivity.this.F0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends CommonAdapter<Map<String, Object>> {
        b(Context x02, int x12, List x22) {
            super(x02, x12, x22);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_name, JsonParse.getString(stringObjectMap, "sportItem"));
            holder.J(R.id.tv_group, JsonParse.getString(stringObjectMap, "groupName"));
            holder.J(R.id.tv_progress, JsonParse.getString(stringObjectMap, "gameForm"));
            int i4 = R.id.tv_type;
            StringBuilder sb = new StringBuilder();
            sb.append("\u5206\u7ec4\uff1a");
            sb.append(TextUtils.isEmpty(JsonParse.getString(stringObjectMap, "group")) ? "\u672a\u5206\u7ec4" : JsonParse.getString(stringObjectMap, "group"));
            holder.J(i4, sb.toString());
            int i5 = R.id.tv_time;
            holder.J(i5, JsonParse.getString(stringObjectMap, "sportCompetitionDateName") + JsonParse.getString(stringObjectMap, "competitionTime"));
            holder.J(R.id.tv_type2, JsonParse.getString(stringObjectMap, "type").equals("1") ? "\u5f84\u8d5b" : "\u7530\u8d5b");
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
            CompetitionProjectListActivity.this.f18988k.y();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CompetitionProjectListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionProjectListActivity.this.f18996s = JsonParse.getList(data, "data");
            CompetitionProjectListActivity.this.f18997t.g(CompetitionProjectListActivity.this.f18996s);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
            if (LoginUser.getLoginUser().getUserType() == 2) {
                if (JsonParse.getString((Map) CompetitionProjectListActivity.this.f18997t.getItem(position), "type").equals("1")) {
                    CompetitionProjectListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionProjectListActivity.this).f1656h, AddScoreMenuActivity.class).putExtra("scheduleId", JsonParse.getString((Map) CompetitionProjectListActivity.this.f18997t.getItem(position), "id")));
                    return;
                } else {
                    CompetitionProjectListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionProjectListActivity.this).f1656h, FieldScoreListActivity.class).putExtra("scheduleId", JsonParse.getString((Map) CompetitionProjectListActivity.this.f18997t.getItem(position), "id")));
                    return;
                }
            }
            CompetitionProjectListActivity.this.startActivity(new Intent(((BaseActivity) CompetitionProjectListActivity.this).f1656h, StudentScoreListActivity.class).putExtra("scheduleId", JsonParse.getString((Map) CompetitionProjectListActivity.this.f18997t.getItem(position), "id")));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends HttpCallBack {
        e() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CompetitionProjectListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionProjectListActivity.this.f18993p = JsonParse.getList(data, "data");
            HashMap hashMap = new HashMap(2);
            hashMap.put("id", "-1");
            hashMap.put("name", "\u5168\u90e8\u65f6\u95f4");
            CompetitionProjectListActivity.this.f18993p.add(0, hashMap);
            CompetitionProjectListActivity competitionProjectListActivity = CompetitionProjectListActivity.this;
            competitionProjectListActivity.L0(competitionProjectListActivity.f18990m, "\u8bf7\u9009\u62e9\u65f6\u95f4", CompetitionProjectListActivity.this.f18993p);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CompetitionProjectListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionProjectListActivity.this.f18994q = JsonParse.getList(data, "data");
            HashMap hashMap = new HashMap(2);
            hashMap.put("id", "-1");
            hashMap.put("name", "\u5168\u90e8\u5206\u7ec4");
            CompetitionProjectListActivity.this.f18994q.add(0, hashMap);
            CompetitionProjectListActivity competitionProjectListActivity = CompetitionProjectListActivity.this;
            competitionProjectListActivity.L0(competitionProjectListActivity.f18991n, "\u8bf7\u9009\u62e9\u7ec4\u522b", CompetitionProjectListActivity.this.f18994q);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class g extends HttpCallBack {
        g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CompetitionProjectListActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CompetitionProjectListActivity.this.f18995r = JsonParse.getList(data, "data");
            HashMap hashMap = new HashMap(2);
            hashMap.put("id", "-1");
            hashMap.put("name", "\u5168\u90e8\u9879\u76ee");
            CompetitionProjectListActivity.this.f18995r.add(0, hashMap);
            CompetitionProjectListActivity competitionProjectListActivity = CompetitionProjectListActivity.this;
            competitionProjectListActivity.L0(competitionProjectListActivity.f18992o, "\u8bf7\u9009\u62e9\u9879\u76ee", CompetitionProjectListActivity.this.f18995r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class h implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f19006a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f19007b;

        h(final TextView val$dataList, final List val$tv) {
            this.f19006a = val$dataList;
            this.f19007b = val$tv;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int which) {
            this.f19006a.setText(u.O((Map) this.f19007b.get(which), "name"));
            this.f19006a.setTag(u.O((Map) this.f19007b.get(which), "id"));
            if (this.f19006a.getId() == CompetitionProjectListActivity.this.f18991n.getId()) {
                CompetitionProjectListActivity.this.f18992o.setText("\u5168\u90e8\u9879\u76ee");
                CompetitionProjectListActivity.this.f18992o.setTag("-1");
            }
            CompetitionProjectListActivity.this.f18988k.a0();
        }
    }

    private void E0(Dialog dialog, int color) {
        View findViewById = dialog.findViewById(dialog.getContext().getResources().getIdentifier("android:id/titleDivider", null, null));
        if (findViewById != null) {
            findViewById.setBackgroundColor(color);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        Http.with(this.f1656h).hideOtherStatusMessage().hideLoadingDialog().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).t(this.f18998u, this.f18991n.getTag().toString().equals("-1") ? null : this.f18991n.getTag(), this.f18992o.getTag().toString().equals("-1") ? null : this.f18992o.getTag(), this.f18990m.getTag().toString().equals("-1") ? null : this.f18990m.getTag())).setDataListener(new c());
    }

    private void G0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).v(this.f18998u)).setDataListener(new e());
    }

    private void H0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).o(this.f18998u)).setDataListener(new f());
    }

    private void I0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((com.bxkj.competition.b) Http.getApiService(com.bxkj.competition.b.class)).p(this.f18991n.getTag().toString())).setDataListener(new g());
    }

    private void J0() {
        this.f18989l.setLayoutManager(new LinearLayoutManager(this.f1656h));
        b bVar = new b(this.f1656h, R.layout.item_for_addscore_project_list, this.f18996s);
        this.f18997t = bVar;
        this.f18989l.setAdapter(bVar);
        this.f18989l.setEmptyView(findViewById(R.id.tv_emptyView));
    }

    private void K0() {
        this.f18988k.m1(new a());
    }

    public void L0(final TextView tv2, final String title, final List<Map<String, Object>> dataList) {
        String[] strArr = new String[dataList.size()];
        for (int i4 = 0; i4 < dataList.size(); i4++) {
            strArr[i4] = u.O(dataList.get(i4), "name");
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f1656h);
        View inflate = LayoutInflater.from(this.f1656h).inflate(R.layout.dialog_title, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.tvTitle)).setText(title);
        builder.setCustomTitle(inflate);
        builder.setItems(strArr, new h(tv2, dataList));
        AlertDialog create = builder.create();
        create.getListView().setDivider(new ColorDrawable(Color.parseColor("#999999")));
        create.getListView().setDividerHeight(i0(0.5f, this.f1656h));
        create.show();
        E0(create, Color.parseColor("#8e8b8b"));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f18990m.setOnClickListener(this);
        this.f18991n.setOnClickListener(this);
        this.f18992o.setOnClickListener(this);
        this.f18997t.k(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return R.layout.ac_addscore_project_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("competitionId")) {
            this.f18998u = getIntent().getStringExtra("competitionId");
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("id", "-1");
        hashMap.put("name", "\u5168\u90e8\u9879\u76ee");
        this.f18995r.add(hashMap);
        K0();
        J0();
        this.f18988k.b0(true);
        this.f18988k.O(false);
        this.f18988k.a0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7ade\u8d5b\u9879\u76ee\u5217\u8868");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f18988k = (SmartRefreshLayout) findViewById(R.id.refresh);
        this.f18989l = (EmptyRecyclerView) findViewById(R.id.recyclerView);
        this.f18990m = (TextView) findViewById(R.id.tv_time);
        this.f18991n = (TextView) findViewById(R.id.tv_group);
        this.f18992o = (TextView) findViewById(R.id.tv_project);
    }

    public int i0(float size, Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        double d4 = size * displayMetrics.density;
        Double.isNaN(d4);
        return (int) (d4 + 0.5d);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() == this.f18990m.getId()) {
            List<Map<String, Object>> list = this.f18993p;
            if (list != null && list.size() != 0) {
                L0(this.f18990m, "\u8bf7\u9009\u62e9\u7ec4\u522b", this.f18993p);
            } else {
                G0();
            }
        } else if (v3.getId() == this.f18991n.getId()) {
            List<Map<String, Object>> list2 = this.f18994q;
            if (list2 != null && list2.size() != 0) {
                L0(this.f18991n, "\u8bf7\u9009\u62e9\u7ec4\u522b", this.f18994q);
            } else {
                H0();
            }
        } else if (v3.getId() == this.f18992o.getId()) {
            if (this.f18991n.getTag() != null && !this.f18991n.getTag().toString().equals("-1")) {
                I0();
            } else {
                new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u5148\u9009\u62e9\u7ec4\u522b").show();
            }
        }
    }
}
