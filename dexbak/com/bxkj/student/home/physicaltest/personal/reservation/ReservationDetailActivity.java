package com.bxkj.student.home.physicaltest.personal.reservation;

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
public class ReservationDetailActivity extends BaseActivity {

    /* renamed from: k */
    private String f16575k;

    /* renamed from: l */
    private LinearLayout f16576l;

    /* renamed from: m */
    private Button f16577m;

    /* renamed from: n */
    private long f16578n;

    /* renamed from: com.bxkj.student.home.physicaltest.personal.reservation.ReservationDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4389a extends HttpCallBack {
        C4389a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ReservationDetailActivity.this.f16576l.removeAllViews();
            ReservationDetailActivity.this.f16578n = Long.parseLong(JsonParse.getString(data, "currentTime"));
            ReservationDetailActivity.this.m57932R().setVisibility(0);
            ReservationDetailActivity.this.m42502n0(data);
        }
    }

    /* renamed from: l0 */
    private void m42504l0(String text) {
        TextView textView = new TextView(this.f1669h);
        textView.setMinHeight(Tools.m57620a(40.0f, this.f1669h));
        textView.setTextSize(2, 16.0f);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setGravity(16);
        textView.setText(text);
        this.f16576l.addView(textView);
        View view = new View(this.f1669h);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, Tools.m57620a(1.0f, this.f1669h)));
        view.setBackgroundColor(getResources().getColor(2131034191));
        this.f16576l.addView(view);
    }

    /* renamed from: m0 */
    private void m42503m0() {
        ReservationListActivity reservationListActivity = (ReservationListActivity) AppManager.m57776n().getActivity(ReservationListActivity.class);
        if (reservationListActivity != null) {
            reservationListActivity.m42488v0(this.f1669h, this.f16575k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public void m42502n0(Map<String, Object> data) {
        Map map = (Map) data.get("meaSchedule");
        m42504l0("体测名称：" + JsonParse.getString(map, "scheduleName"));
        m42504l0("预约开始时间：" + JsonParse.getString(map, "appointmentBeginTime"));
        m42504l0("预约结束时间：" + JsonParse.getString(map, "appointmentEndTime"));
        m42504l0("体测开始时间：" + JsonParse.getString(map, "meaBeginTime"));
        m42504l0("体测结束时间：" + JsonParse.getString(map, "meaEndTime"));
        String string = JsonParse.getString(map, "classType");
        if (string.equals("0")) {
            m42504l0("班级类型：混合班");
            m42504l0("总人数：" + JsonParse.getString(map, "totalNumber"));
            m42504l0("已预约人数：" + JsonParse.getString(map, "totalAppliedNumber"));
        } else if (string.equals("1")) {
            m42504l0("班级类型：男生班");
            m42504l0("总人数：" + JsonParse.getString(map, "totalNumber"));
            m42504l0("已预约人数：" + JsonParse.getString(map, "totalAppliedNumber"));
        } else if (string.equals("2")) {
            m42504l0("班级类型：女生班");
            m42504l0("总人数：" + JsonParse.getString(map, "totalNumber"));
            m42504l0("已预约人数：" + JsonParse.getString(map, "totalAppliedNumber"));
        } else if (string.equals("3")) {
            m42504l0("班级类型：比例班");
            m42504l0("总人数：" + JsonParse.getString(map, "totalNumber"));
            m42504l0("已预约人数：男:" + JsonParse.getString(map, "maleAppliedNumber") + ";女：" + JsonParse.getString(map, "femaleAppliedNumber"));
        }
        m42504l0("体测说明：" + JsonParse.getString(map, SocialConstants.PARAM_COMMENT));
        List list = (List) data.get("meaScheduleExams");
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = JsonParse.getString((Map) list.get(i), "examName");
        }
        m42504l0("体测项目：" + Arrays.toString(strArr));
        String string2 = JsonParse.getString(map, "appointmentEndTime");
        if ("1".equals(JsonParse.getString(map, "ismeastate"))) {
            this.f16577m.setText("已预约");
            this.f16577m.setEnabled(false);
        } else {
            try {
                if (this.f16578n >= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(string2).getTime()) {
                    this.f16577m.setText("预约已结束");
                    this.f16577m.setEnabled(false);
                } else if (JsonParse.getInt(map, "totalAppliedNumber") >= JsonParse.getInt(map, "totalNumber")) {
                    this.f16577m.setText("预约人数已满");
                    this.f16577m.setEnabled(false);
                } else {
                    this.f16577m.setEnabled(true);
                    this.f16577m.setText("立即预约");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        LinearLayout linearLayout = this.f16576l;
        linearLayout.removeViewAt(linearLayout.getChildCount() - 1);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16577m.setOnClickListener(this);
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
            this.f16575k = getIntent().getStringExtra("id");
        }
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m177E(this.f16575k, LoginUser.getLoginUser().getUserId())).setDataListener(new C4389a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("体测预约详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16576l = (LinearLayout) findViewById(2131232182);
        this.f16577m = (Button) findViewById(C4215R.C4219id.bt_reservation);
        m57932R().setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131231005) {
            return;
        }
        m42503m0();
    }
}
