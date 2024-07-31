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
import com.bxkj.student.C4215R;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.HashMap;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CalcActivity extends BaseActivity {

    /* renamed from: k */
    private EditText f16420k;

    /* renamed from: l */
    private RadioGroup f16421l;

    /* renamed from: m */
    private RadioGroup f16422m;

    /* renamed from: n */
    private RadioButton f16423n;

    /* renamed from: o */
    private EditText f16424o;

    /* renamed from: p */
    private EditText f16425p;

    /* renamed from: q */
    private EditText f16426q;

    /* renamed from: r */
    private EditText f16427r;

    /* renamed from: s */
    private EditText f16428s;

    /* renamed from: t */
    private EditText f16429t;

    /* renamed from: u */
    private TextView f16430u;

    /* renamed from: v */
    private EditText f16431v;

    /* renamed from: w */
    private TextView f16432w;

    /* renamed from: x */
    private EditText f16433x;

    /* renamed from: y */
    private Button f16434y;

    /* renamed from: com.bxkj.student.home.physicaltest.calc.CalcActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4341a implements RadioGroup.OnCheckedChangeListener {
        C4341a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            if (checkedId == 2131232476) {
                CalcActivity.this.f16430u.setText("1000米");
                CalcActivity.this.f16432w.setText("引体向上");
                return;
            }
            CalcActivity.this.f16430u.setText("800米");
            CalcActivity.this.f16432w.setText("仰卧起坐");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.physicaltest.calc.CalcActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4342b extends HttpCallBack {
        C4342b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) CalcActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            HashMap hashMap = new HashMap(data);
            SeralizableMap seralizableMap = new SeralizableMap();
            seralizableMap.setMap(hashMap);
            CalcActivity.this.startActivity(new Intent(((BaseActivity) CalcActivity.this).f1669h, CalcResultActivity.class).putExtra(CommonNetImpl.f39534SM, seralizableMap));
        }
    }

    /* renamed from: m0 */
    private void m42632m0() {
        this.f16420k.getText().toString().trim();
        String str = this.f16421l.getCheckedRadioButtonId() == this.f16421l.getChildAt(0).getId() ? "1" : "2";
        RadioGroup radioGroup = this.f16422m;
        String trim = ((RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString().trim();
        String trim2 = this.f16424o.getText().toString().trim();
        String trim3 = this.f16425p.getText().toString().trim();
        String trim4 = this.f16426q.getText().toString().trim();
        String trim5 = this.f16427r.getText().toString().trim();
        String trim6 = this.f16428s.getText().toString().trim();
        String trim7 = this.f16429t.getText().toString().trim();
        String trim8 = this.f16431v.getText().toString().trim();
        String trim9 = this.f16433x.getText().toString().trim();
        if (TextUtils.isEmpty(trim2) && TextUtils.isEmpty(trim3) && TextUtils.isEmpty(trim4) && TextUtils.isEmpty(trim5) && TextUtils.isEmpty(trim6) && TextUtils.isEmpty(trim7) && TextUtils.isEmpty(trim8) && TextUtils.isEmpty(trim9)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请至少输入一项").show();
        } else if (!TextUtils.isEmpty(trim3) && TextUtils.isEmpty(trim2)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请输入身高").show();
        } else if (!TextUtils.isEmpty(trim2) && TextUtils.isEmpty(trim3)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请输入体重").show();
        } else {
            Http.with(this.f1669h).setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m147R(str, trim, trim2, trim3, trim4, trim5, trim6, trim7, trim8, trim9)).setDataListener(new C4342b());
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16421l.setOnCheckedChangeListener(new C4341a());
        this.f16434y.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_physical_testing_calc;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("体测计算器");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16420k = (EditText) findViewById(C4215R.C4219id.et_name);
        this.f16421l = (RadioGroup) findViewById(C4215R.C4219id.rg_sex);
        this.f16423n = (RadioButton) findViewById(C4215R.C4219id.rb_mail);
        this.f16424o = (EditText) findViewById(C4215R.C4219id.et_height);
        this.f16425p = (EditText) findViewById(C4215R.C4219id.et_weight);
        this.f16426q = (EditText) findViewById(C4215R.C4219id.et_vital_capacity);
        this.f16427r = (EditText) findViewById(C4215R.C4219id.et_standing_long_jump);
        this.f16428s = (EditText) findViewById(C4215R.C4219id.et_sitting_body_flexion);
        this.f16429t = (EditText) findViewById(C4215R.C4219id.et_50);
        this.f16430u = (TextView) findViewById(C4215R.C4219id.tv_800_or_1000);
        this.f16431v = (EditText) findViewById(C4215R.C4219id.et_800_or_1000);
        this.f16432w = (TextView) findViewById(C4215R.C4219id.tv_pull_or_sit);
        this.f16433x = (EditText) findViewById(C4215R.C4219id.et_pull_or_sit);
        this.f16434y = (Button) findViewById(2131230989);
        this.f16422m = (RadioGroup) findViewById(C4215R.C4219id.rg_grade);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() != 2131230989) {
            return;
        }
        m42632m0();
    }
}
