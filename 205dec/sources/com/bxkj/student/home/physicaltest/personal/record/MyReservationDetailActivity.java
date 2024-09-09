package com.bxkj.student.home.physicaltest.personal.record;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class MyReservationDetailActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private int f19933k;

    /* renamed from: l  reason: collision with root package name */
    private String f19934l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f19935m;

    /* renamed from: n  reason: collision with root package name */
    private Button f19936n;

    /* renamed from: o  reason: collision with root package name */
    private long f19937o;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            MyReservationDetailActivity.this.f19937o = Long.parseLong(JsonParse.getString(data, "currentTime"));
            MyReservationDetailActivity.this.R().setVisibility(0);
            MyReservationDetailActivity.this.m0(data);
        }
    }

    private void k0(String text) {
        TextView textView = new TextView(this.f1656h);
        textView.setMinHeight(u.a(40.0f, this.f1656h));
        textView.setTextSize(2, 16.0f);
        textView.setTextColor(-16777216);
        textView.setGravity(16);
        textView.setText(text);
        this.f19935m.addView(textView);
        View view = new View(this.f1656h);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, u.a(1.0f, this.f1656h)));
        view.setBackgroundColor(getResources().getColor(2131034191));
        this.f19935m.addView(view);
    }

    private void l0() {
        MyReservationListActivity myReservationListActivity = (MyReservationListActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(MyReservationListActivity.class);
        if (myReservationListActivity != null) {
            myReservationListActivity.v0(this.f1656h, this.f19934l, this.f19933k);
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
        String string = JsonParse.getString(map, "classType");
        if (string.equals("0")) {
            k0("\u73ed\u7ea7\u7c7b\u578b\uff1a\u6df7\u5408\u73ed");
            k0("\u603b\u4eba\u6570\uff1a" + JsonParse.getString(map, "totalNumber"));
            k0("\u5df2\u9884\u7ea6\u4eba\u6570\uff1a" + JsonParse.getString(map, "totalAppliedNumber"));
        } else if (string.equals("1")) {
            k0("\u73ed\u7ea7\u7c7b\u578b\uff1a\u7537\u751f\u73ed");
            k0("\u603b\u4eba\u6570\uff1a" + JsonParse.getString(map, "totalNumber"));
            k0("\u5df2\u9884\u7ea6\u4eba\u6570\uff1a" + JsonParse.getString(map, "totalAppliedNumber"));
        } else if (string.equals("2")) {
            k0("\u73ed\u7ea7\u7c7b\u578b\uff1a\u5973\u751f\u73ed");
            k0("\u603b\u4eba\u6570\uff1a" + JsonParse.getString(map, "totalNumber"));
            k0("\u5df2\u9884\u7ea6\u4eba\u6570\uff1a" + JsonParse.getString(map, "totalAppliedNumber"));
        } else if (string.equals("3")) {
            k0("\u73ed\u7ea7\u7c7b\u578b\uff1a\u6bd4\u4f8b\u73ed");
            k0("\u603b\u4eba\u6570\uff1a" + JsonParse.getString(map, "totalNumber"));
            k0("\u5df2\u9884\u7ea6\u4eba\u6570\uff1a\u7537:" + JsonParse.getString(map, "maleAppliedNumber") + ";\u5973\uff1a" + JsonParse.getString(map, "femaleAppliedNumber"));
        }
        k0("\u4f53\u6d4b\u8bf4\u660e\uff1a" + JsonParse.getString(map, "description"));
        List list = (List) data.get("meaScheduleExams");
        String[] strArr = new String[list.size()];
        for (int i4 = 0; i4 < list.size(); i4++) {
            strArr[i4] = JsonParse.getString((Map) list.get(i4), "examName");
        }
        k0("\u4f53\u6d4b\u9879\u76ee\uff1a" + Arrays.toString(strArr));
        try {
            if (this.f19937o > new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(JsonParse.getString(map, "meaBeginTime")).getTime()) {
                this.f19936n.setText("\u4f53\u6d4b\u5df2\u5f00\u59cb");
                this.f19936n.setEnabled(false);
            } else {
                this.f19936n.setEnabled(true);
                this.f19936n.setText("\u53d6\u6d88\u9884\u7ea6");
            }
        } catch (ParseException e4) {
            e4.printStackTrace();
        }
        LinearLayout linearLayout = this.f19935m;
        linearLayout.removeViewAt(linearLayout.getChildCount() - 1);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19936n.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427469;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("position")) {
            this.f19933k = getIntent().getIntExtra("position", 0);
        }
        if (getIntent().hasExtra("id")) {
            this.f19934l = getIntent().getStringExtra("id");
        }
        Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).E(this.f19934l, LoginUser.getLoginUser().getUserId())).setDataListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4f53\u6d4b\u9884\u7ea6\u8be6\u60c5");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19935m = (LinearLayout) findViewById(2131232182);
        this.f19936n = (Button) findViewById(2131231005);
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
