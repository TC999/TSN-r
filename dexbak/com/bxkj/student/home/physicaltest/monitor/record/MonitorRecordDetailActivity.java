package com.bxkj.student.home.physicaltest.monitor.record;

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
public class MonitorRecordDetailActivity extends BaseActivity {

    /* renamed from: k */
    private int f16490k;

    /* renamed from: l */
    private String f16491l;

    /* renamed from: m */
    private LinearLayout f16492m;

    /* renamed from: n */
    private Button f16493n;

    /* renamed from: o */
    private long f16494o;

    /* renamed from: com.bxkj.student.home.physicaltest.monitor.record.MonitorRecordDetailActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4362a extends HttpCallBack {
        C4362a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MonitorRecordDetailActivity.this.f16494o = Long.parseLong(JsonParse.getString(data, "currentTime"));
            MonitorRecordDetailActivity.this.m57932R().setVisibility(0);
            MonitorRecordDetailActivity.this.m42573m0(data);
        }
    }

    /* renamed from: k0 */
    private void m42575k0(String text) {
        TextView textView = new TextView(this.f1669h);
        textView.setMinHeight(Tools.m57620a(40.0f, this.f1669h));
        textView.setTextSize(2, 16.0f);
        textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setGravity(16);
        textView.setText(text);
        this.f16492m.addView(textView);
        View view = new View(this.f1669h);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, Tools.m57620a(1.0f, this.f1669h)));
        view.setBackgroundColor(getResources().getColor(2131034191));
        this.f16492m.addView(view);
    }

    /* renamed from: l0 */
    private void m42574l0() {
        MonitorRecordListActivity monitorRecordListActivity = (MonitorRecordListActivity) AppManager.m57776n().getActivity(MonitorRecordListActivity.class);
        if (monitorRecordListActivity != null) {
            monitorRecordListActivity.m42559v0(this.f1669h, this.f16491l, this.f16490k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public void m42573m0(Map<String, Object> data) {
        Map map = (Map) data.get("meaSchedule");
        m42575k0("体测名称：" + JsonParse.getString(map, "scheduleName"));
        m42575k0("预约开始时间：" + JsonParse.getString(map, "appointmentBeginTime"));
        m42575k0("预约结束时间：" + JsonParse.getString(map, "appointmentEndTime"));
        m42575k0("体测开始时间：" + JsonParse.getString(map, "meaBeginTime"));
        m42575k0("体测结束时间：" + JsonParse.getString(map, "meaEndTime"));
        StringBuilder sb = new StringBuilder();
        sb.append("预约类型：");
        sb.append(JsonParse.getString(map, "appointmentType").equals("2") ? "个人预约" : "班长预约");
        m42575k0(sb.toString());
        m42575k0("班级数:" + JsonParse.getString(map, "appliedClasses") + "/" + JsonParse.getInt(map, "appClassAmount"));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("体测说明：");
        sb2.append(JsonParse.getString(map, SocialConstants.PARAM_COMMENT));
        m42575k0(sb2.toString());
        List list = (List) data.get("meaScheduleExams");
        String[] strArr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            strArr[i] = JsonParse.getString((Map) list.get(i), "examName");
        }
        m42575k0("体测项目：" + Arrays.toString(strArr));
        try {
            if (this.f16494o >= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(JsonParse.getString(map, "meaBeginTime")).getTime()) {
                this.f16493n.setText("体测已开始");
                this.f16493n.setEnabled(false);
            } else {
                this.f16493n.setEnabled(true);
                this.f16493n.setText("取消预约");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        LinearLayout linearLayout = this.f16492m;
        linearLayout.removeViewAt(linearLayout.getChildCount() - 1);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16493n.setOnClickListener(this);
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
            this.f16490k = getIntent().getIntExtra("position", 0);
        }
        if (getIntent().hasExtra("id")) {
            this.f16491l = getIntent().getStringExtra("id");
        }
        Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m177E(this.f16491l, LoginUser.getLoginUser().getUserId())).setDataListener(new C4362a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("体测预约详情");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16492m = (LinearLayout) findViewById(2131232182);
        this.f16493n = (Button) findViewById(C4215R.C4219id.bt_reservation);
        m57932R().setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131231005) {
            return;
        }
        m42574l0();
    }
}
