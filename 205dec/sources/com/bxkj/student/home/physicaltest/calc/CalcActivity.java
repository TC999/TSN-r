package com.bxkj.student.home.physicaltest.calc;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CalcActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private EditText f19810k;

    /* renamed from: l  reason: collision with root package name */
    private RadioGroup f19811l;

    /* renamed from: m  reason: collision with root package name */
    private RadioGroup f19812m;

    /* renamed from: n  reason: collision with root package name */
    private RadioButton f19813n;

    /* renamed from: o  reason: collision with root package name */
    private EditText f19814o;

    /* renamed from: p  reason: collision with root package name */
    private EditText f19815p;

    /* renamed from: q  reason: collision with root package name */
    private EditText f19816q;

    /* renamed from: r  reason: collision with root package name */
    private EditText f19817r;

    /* renamed from: s  reason: collision with root package name */
    private EditText f19818s;

    /* renamed from: t  reason: collision with root package name */
    private EditText f19819t;

    /* renamed from: u  reason: collision with root package name */
    private TextView f19820u;

    /* renamed from: v  reason: collision with root package name */
    private EditText f19821v;

    /* renamed from: w  reason: collision with root package name */
    private TextView f19822w;

    /* renamed from: x  reason: collision with root package name */
    private EditText f19823x;

    /* renamed from: y  reason: collision with root package name */
    private Button f19824y;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements RadioGroup.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == 2131232476) {
                CalcActivity.this.f19820u.setText("1000\u7c73");
                CalcActivity.this.f19822w.setText("\u5f15\u4f53\u5411\u4e0a");
                return;
            }
            CalcActivity.this.f19820u.setText("800\u7c73");
            CalcActivity.this.f19822w.setText("\u4ef0\u5367\u8d77\u5750");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CalcActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            HashMap hashMap = new HashMap(data);
            SeralizableMap seralizableMap = new SeralizableMap();
            seralizableMap.setMap(hashMap);
            CalcActivity.this.startActivity(new Intent(((BaseActivity) CalcActivity.this).f1656h, CalcResultActivity.class).putExtra("sm", seralizableMap));
        }
    }

    private void m0() {
        this.f19810k.getText().toString().trim();
        String str = this.f19811l.getCheckedRadioButtonId() == this.f19811l.getChildAt(0).getId() ? "1" : "2";
        RadioGroup radioGroup = this.f19812m;
        String trim = ((RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString().trim();
        String trim2 = this.f19814o.getText().toString().trim();
        String trim3 = this.f19815p.getText().toString().trim();
        String trim4 = this.f19816q.getText().toString().trim();
        String trim5 = this.f19817r.getText().toString().trim();
        String trim6 = this.f19818s.getText().toString().trim();
        String trim7 = this.f19819t.getText().toString().trim();
        String trim8 = this.f19821v.getText().toString().trim();
        String trim9 = this.f19823x.getText().toString().trim();
        if (TextUtils.isEmpty(trim2) && TextUtils.isEmpty(trim3) && TextUtils.isEmpty(trim4) && TextUtils.isEmpty(trim5) && TextUtils.isEmpty(trim6) && TextUtils.isEmpty(trim7) && TextUtils.isEmpty(trim8) && TextUtils.isEmpty(trim9)) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u81f3\u5c11\u8f93\u5165\u4e00\u9879").show();
        } else if (!TextUtils.isEmpty(trim3) && TextUtils.isEmpty(trim2)) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u8f93\u5165\u8eab\u9ad8").show();
        } else if (!TextUtils.isEmpty(trim2) && TextUtils.isEmpty(trim3)) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u8f93\u5165\u4f53\u91cd").show();
        } else {
            Http.with(this.f1656h).setObservable(((w.a) Http.getApiService(w.a.class)).R(str, trim, trim2, trim3, trim4, trim5, trim6, trim7, trim8, trim9)).setDataListener(new b());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19811l.setOnCheckedChangeListener(new a());
        this.f19824y.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427451;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u4f53\u6d4b\u8ba1\u7b97\u5668");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19810k = (EditText) findViewById(2131231260);
        this.f19811l = (RadioGroup) findViewById(2131232494);
        this.f19813n = (RadioButton) findViewById(2131232476);
        this.f19814o = (EditText) findViewById(2131231258);
        this.f19815p = (EditText) findViewById(2131231282);
        this.f19816q = (EditText) findViewById(2131231280);
        this.f19817r = (EditText) findViewById(2131231277);
        this.f19818s = (EditText) findViewById(2131231276);
        this.f19819t = (EditText) findViewById(2131231248);
        this.f19820u = (TextView) findViewById(2131232834);
        this.f19821v = (EditText) findViewById(2131231249);
        this.f19822w = (TextView) findViewById(2131233108);
        this.f19823x = (EditText) findViewById(2131231268);
        this.f19824y = (Button) findViewById(2131230989);
        this.f19812m = (RadioGroup) findViewById(2131232493);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (v3.getId() != 2131230989) {
            return;
        }
        m0();
    }
}
