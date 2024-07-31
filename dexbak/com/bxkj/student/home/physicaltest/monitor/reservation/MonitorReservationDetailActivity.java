package com.bxkj.student.home.physicaltest.monitor.reservation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.tencent.open.SocialConstants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MonitorReservationDetailActivity extends BaseActivity {

    /* renamed from: k */
    private String f16522k;

    /* renamed from: l */
    private LinearLayout f16523l;

    /* renamed from: m */
    private Button f16524m;

    /* renamed from: n */
    private long f16525n;

    /* renamed from: com.bxkj.student.home.physicaltest.monitor.reservation.MonitorReservationDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4372a extends HttpCallBack {
        C4372a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MonitorReservationDetailActivity.this.f16525n = Long.parseLong(JsonParse.getString(data, "currentTime"));
            MonitorReservationDetailActivity.this.m57932R().setVisibility(0);
            MonitorReservationDetailActivity.this.m42549m0(data);
        }
    }

    /* renamed from: k0 */
    private void m42551k0(String text) {
        TextView textView = new TextView(this.f1669h);
        textView.setMinHeight(Tools.m57620a(40.0f, this.f1669h));
        textView.setTextSize(2, 16.0f);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setGravity(16);
        textView.setText(text);
        this.f16523l.addView(textView);
        View view = new View(this.f1669h);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, Tools.m57620a(1.0f, this.f1669h)));
        view.setBackgroundColor(getResources().getColor(2131034191));
        this.f16523l.addView(view);
    }

    /* renamed from: l0 */
    private void m42550l0() {
        MonitorReservationListActivity monitorReservationListActivity = (MonitorReservationListActivity) AppManager.m57776n().getActivity(MonitorReservationListActivity.class);
        if (monitorReservationListActivity != null) {
            monitorReservationListActivity.m42535v0(this.f1669h, this.f16522k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public void m42549m0(Map<String, Object> data) {
        Map map = (Map) data.get("meaSchedule");
        m42551k0("体测名称：" + JsonParse.getString(map, "scheduleName"));
        m42551k0("预约开始时间：" + JsonParse.getString(map, "appointmentBeginTime"));
        m42551k0("预约结束时间：" + JsonParse.getString(map, "appointmentEndTime"));
        m42551k0("体测开始时间：" + JsonParse.getString(map, "meaBeginTime"));
        m42551k0("体测结束时间：" + JsonParse.getString(map, "meaEndTime"));
        StringBuilder sb = new StringBuilder();
        sb.append("预约类型：");
        sb.append(JsonParse.getString(map, "appointmentType").equals("2") ? "个人预约" : "班长预约");
        m42551k0(sb.toString());
        m42551k0("班级数:" + JsonParse.getString(map, "appliedClasses") + "/" + JsonParse.getInt(map, "appClassAmount"));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("体测说明：");
        sb2.append(JsonParse.getString(map, SocialConstants.PARAM_COMMENT));
        m42551k0(sb2.toString());
        List list = (List) data.get("meaScheduleExams");
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = JsonParse.getString((Map) list.get(i), "examName");
        }
        m42551k0("体测项目：" + Arrays.toString(strArr));
        try {
            if (this.f16525n >= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(JsonParse.getString(map, "appointmentEndTime")).getTime()) {
                this.f16524m.setText("预约已结束");
                this.f16524m.setEnabled(false);
            } else if (JsonParse.getInt(map, "appliedClasses") >= JsonParse.getInt(map, "appClassAmount")) {
                this.f16524m.setText("预约班级已满");
                this.f16524m.setEnabled(false);
            } else {
                this.f16524m.setEnabled(true);
                this.f16524m.setText("立即预约");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LinearLayout linearLayout = this.f16523l;
        linearLayout.removeViewAt(linearLayout.getChildCount() - 1);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16524m.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_reservation_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("id")) {
            this.f16522k = getIntent().getStringExtra("id");
        }
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m177E(this.f16522k, LoginUser.getLoginUser().getUserId())).setDataListener(new C4372a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("体测预约详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16523l = (LinearLayout) findViewById(2131232182);
        this.f16524m = (Button) findViewById(C4215R.C4219id.bt_reservation);
        m57932R().setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131231005) {
            return;
        }
        m42550l0();
    }
}
