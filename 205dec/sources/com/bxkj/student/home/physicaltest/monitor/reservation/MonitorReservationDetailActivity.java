package com.bxkj.student.home.physicaltest.monitor.reservation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MonitorReservationDetailActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private String f19912k;

    /* renamed from: l  reason: collision with root package name */
    private LinearLayout f19913l;

    /* renamed from: m  reason: collision with root package name */
    private Button f19914m;

    /* renamed from: n  reason: collision with root package name */
    private long f19915n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MonitorReservationDetailActivity.this.f19915n = Long.parseLong(JsonParse.getString(data, "currentTime"));
            MonitorReservationDetailActivity.this.R().setVisibility(0);
            MonitorReservationDetailActivity.this.m0(data);
        }
    }

    private void k0(String text) {
        TextView textView = new TextView(this.f1656h);
        textView.setMinHeight(u.a(40.0f, this.f1656h));
        textView.setTextSize(2, 16.0f);
        textView.setTextColor(-16777216);
        textView.setGravity(16);
        textView.setText(text);
        this.f19913l.addView(textView);
        View view = new View(this.f1656h);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, u.a(1.0f, this.f1656h)));
        view.setBackgroundColor(getResources().getColor(2131034191));
        this.f19913l.addView(view);
    }

    private void l0() {
        MonitorReservationListActivity monitorReservationListActivity = (MonitorReservationListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(MonitorReservationListActivity.class);
        if (monitorReservationListActivity != null) {
            monitorReservationListActivity.v0(this.f1656h, this.f19912k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(Map<String, Object> data) {
        Map map = (Map) data.get("meaSchedule");
        k0("\u4f53\u6d4b\u540d\u79f0\uff1a" + JsonParse.getString(map, "scheduleName"));
        k0("\u9884\u7ea6\u5f00\u59cb\u65f6\u95f4\uff1a" + JsonParse.getString(map, "appointmentBeginTime"));
        k0("\u9884\u7ea6\u7ed3\u675f\u65f6\u95f4\uff1a" + JsonParse.getString(map, "appointmentEndTime"));
        k0("\u4f53\u6d4b\u5f00\u59cb\u65f6\u95f4\uff1a" + JsonParse.getString(map, "meaBeginTime"));
        k0("\u4f53\u6d4b\u7ed3\u675f\u65f6\u95f4\uff1a" + JsonParse.getString(map, "meaEndTime"));
        StringBuilder sb = new StringBuilder();
        sb.append("\u9884\u7ea6\u7c7b\u578b\uff1a");
        sb.append(JsonParse.getString(map, "appointmentType").equals("2") ? "\u4e2a\u4eba\u9884\u7ea6" : "\u73ed\u957f\u9884\u7ea6");
        k0(sb.toString());
        k0("\u73ed\u7ea7\u6570:" + JsonParse.getString(map, "appliedClasses") + TTPathConst.sSeparator + JsonParse.getInt(map, "appClassAmount"));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\u4f53\u6d4b\u8bf4\u660e\uff1a");
        sb2.append(JsonParse.getString(map, "description"));
        k0(sb2.toString());
        List list = (List) data.get("meaScheduleExams");
        String[] strArr = new String[list.size()];
        for (int i4 = 0; i4 < list.size(); i4++) {
            strArr[i4] = JsonParse.getString((Map) list.get(i4), "examName");
        }
        k0("\u4f53\u6d4b\u9879\u76ee\uff1a" + Arrays.toString(strArr));
        try {
            if (this.f19915n >= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(JsonParse.getString(map, "appointmentEndTime")).getTime()) {
                this.f19914m.setText("\u9884\u7ea6\u5df2\u7ed3\u675f");
                this.f19914m.setEnabled(false);
            } else if (JsonParse.getInt(map, "appliedClasses") >= JsonParse.getInt(map, "appClassAmount")) {
                this.f19914m.setText("\u9884\u7ea6\u73ed\u7ea7\u5df2\u6ee1");
                this.f19914m.setEnabled(false);
            } else {
                this.f19914m.setEnabled(true);
                this.f19914m.setText("\u7acb\u5373\u9884\u7ea6");
            }
        } catch (ParseException e4) {
            e4.printStackTrace();
        }
        LinearLayout linearLayout = this.f19913l;
        linearLayout.removeViewAt(linearLayout.getChildCount() - 1);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19914m.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427469;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("id")) {
            this.f19912k = getIntent().getStringExtra("id");
        }
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).E(this.f19912k, LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4f53\u6d4b\u9884\u7ea6\u8be6\u60c5");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19913l = (LinearLayout) findViewById(2131232182);
        this.f19914m = (Button) findViewById(2131231005);
        R().setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() != 2131231005) {
            return;
        }
        l0();
    }
}
