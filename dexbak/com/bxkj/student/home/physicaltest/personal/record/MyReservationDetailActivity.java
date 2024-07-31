package com.bxkj.student.home.physicaltest.personal.record;

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
public class MyReservationDetailActivity extends BaseActivity {

    /* renamed from: k */
    private int f16543k;

    /* renamed from: l */
    private String f16544l;

    /* renamed from: m */
    private LinearLayout f16545m;

    /* renamed from: n */
    private Button f16546n;

    /* renamed from: o */
    private long f16547o;

    /* renamed from: com.bxkj.student.home.physicaltest.personal.record.MyReservationDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4379a extends HttpCallBack {
        C4379a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyReservationDetailActivity.this.f16547o = Long.parseLong(JsonParse.getString(data, "currentTime"));
            MyReservationDetailActivity.this.m57932R().setVisibility(0);
            MyReservationDetailActivity.this.m42527m0(data);
        }
    }

    /* renamed from: k0 */
    private void m42529k0(String text) {
        TextView textView = new TextView(this.f1669h);
        textView.setMinHeight(Tools.m57620a(40.0f, this.f1669h));
        textView.setTextSize(2, 16.0f);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setGravity(16);
        textView.setText(text);
        this.f16545m.addView(textView);
        View view = new View(this.f1669h);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, Tools.m57620a(1.0f, this.f1669h)));
        view.setBackgroundColor(getResources().getColor(2131034191));
        this.f16545m.addView(view);
    }

    /* renamed from: l0 */
    private void m42528l0() {
        MyReservationListActivity myReservationListActivity = (MyReservationListActivity) AppManager.m57776n().getActivity(MyReservationListActivity.class);
        if (myReservationListActivity != null) {
            myReservationListActivity.m42513v0(this.f1669h, this.f16544l, this.f16543k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public void m42527m0(Map<String, Object> data) {
        Map map = (Map) data.get("meaSchedule");
        m42529k0("体测名称：" + JsonParse.getString(map, "scheduleName"));
        m42529k0("预约开始时间：" + JsonParse.getString(map, "appointmentBeginTime"));
        m42529k0("预约结束时间：" + JsonParse.getString(map, "appointmentEndTime"));
        m42529k0("体测开始时间：" + JsonParse.getString(map, "meaBeginTime"));
        m42529k0("体测结束时间：" + JsonParse.getString(map, "meaEndTime"));
        String string = JsonParse.getString(map, "classType");
        if (string.equals("0")) {
            m42529k0("班级类型：混合班");
            m42529k0("总人数：" + JsonParse.getString(map, "totalNumber"));
            m42529k0("已预约人数：" + JsonParse.getString(map, "totalAppliedNumber"));
        } else if (string.equals("1")) {
            m42529k0("班级类型：男生班");
            m42529k0("总人数：" + JsonParse.getString(map, "totalNumber"));
            m42529k0("已预约人数：" + JsonParse.getString(map, "totalAppliedNumber"));
        } else if (string.equals("2")) {
            m42529k0("班级类型：女生班");
            m42529k0("总人数：" + JsonParse.getString(map, "totalNumber"));
            m42529k0("已预约人数：" + JsonParse.getString(map, "totalAppliedNumber"));
        } else if (string.equals("3")) {
            m42529k0("班级类型：比例班");
            m42529k0("总人数：" + JsonParse.getString(map, "totalNumber"));
            m42529k0("已预约人数：男:" + JsonParse.getString(map, "maleAppliedNumber") + ";女：" + JsonParse.getString(map, "femaleAppliedNumber"));
        }
        m42529k0("体测说明：" + JsonParse.getString(map, SocialConstants.PARAM_COMMENT));
        List list = (List) data.get("meaScheduleExams");
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = JsonParse.getString((Map) list.get(i), "examName");
        }
        m42529k0("体测项目：" + Arrays.toString(strArr));
        try {
            if (this.f16547o > new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(JsonParse.getString(map, "meaBeginTime")).getTime()) {
                this.f16546n.setText("体测已开始");
                this.f16546n.setEnabled(false);
            } else {
                this.f16546n.setEnabled(true);
                this.f16546n.setText("取消预约");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LinearLayout linearLayout = this.f16545m;
        linearLayout.removeViewAt(linearLayout.getChildCount() - 1);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16546n.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_reservation_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("position")) {
            this.f16543k = getIntent().getIntExtra("position", 0);
        }
        if (getIntent().hasExtra("id")) {
            this.f16544l = getIntent().getStringExtra("id");
        }
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m177E(this.f16544l, LoginUser.getLoginUser().getUserId())).setDataListener(new C4379a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("体测预约详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16545m = (LinearLayout) findViewById(2131232182);
        this.f16546n = (Button) findViewById(C4215R.C4219id.bt_reservation);
        m57932R().setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131231005) {
            return;
        }
        m42528l0();
    }
}
