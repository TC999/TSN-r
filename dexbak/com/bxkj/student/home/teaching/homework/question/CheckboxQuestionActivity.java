package com.bxkj.student.home.teaching.homework.question;

import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.homework.HomeWorkApiService;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CheckboxQuestionActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f16992k;

    /* renamed from: l */
    private TextView f16993l;

    /* renamed from: m */
    private TextView f16994m;

    /* renamed from: n */
    private TextView f16995n;

    /* renamed from: o */
    private RadioGroup f16996o;

    /* renamed from: p */
    private Button f16997p;

    /* renamed from: q */
    private TextView f16998q;

    /* renamed from: r */
    private String f16999r;

    /* renamed from: s */
    private int f17000s;

    /* renamed from: t */
    private List<Map<String, Object>> f17001t;

    /* renamed from: u */
    private StringBuilder f17002u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.question.CheckboxQuestionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4528a extends HttpCallBack {
        C4528a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CheckboxQuestionActivity.this.m57932R().setVisibility(0);
            CheckboxQuestionActivity.this.m42100o0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.question.CheckboxQuestionActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4529b extends HttpCallBack {
        C4529b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CheckboxQuestionActivity.this.finish();
        }
    }

    /* renamed from: l0 */
    private void m42103l0() {
        Http.with(this.f1669h).setObservable(((HomeWorkApiService) Http.getApiService(HomeWorkApiService.class)).m42110c(this.f16999r, this.f17000s)).setDataListener(new C4528a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void m42102m0(View view) {
        this.f17002u = new StringBuilder();
        for (Map<String, Object> map : this.f17001t) {
            if (map.containsKey("icChecked") && ((Boolean) map.get("icChecked")).booleanValue()) {
                StringBuilder sb = this.f17002u;
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                this.f17002u.append(JsonParse.getString(map, "answerId"));
            }
        }
        if (TextUtils.isEmpty(this.f17002u)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请选择答案").show();
        } else {
            Http.with(this.f1669h).setObservable(((HomeWorkApiService) Http.getApiService(HomeWorkApiService.class)).m42111b(this.f16999r, this.f17002u.toString())).setDataListener(new C4529b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public static /* synthetic */ void m42101n0(Map map, CompoundButton compoundButton, boolean z) {
        map.put("icChecked", Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public void m42100o0(Map<String, Object> data) {
        boolean z = JsonParse.getBoolean(data, "isFlag");
        if (this.f17000s == 1) {
            this.f16997p.setText("已合格");
            this.f16997p.setEnabled(false);
        } else if (z) {
            this.f16997p.setText("提交");
            this.f16997p.setEnabled(true);
        } else {
            this.f16997p.setText("不合格");
            this.f16997p.setEnabled(false);
            this.f16998q.setVisibility(0);
            this.f16998q.setText(JsonParse.getString(data, "markAnswer"));
        }
        this.f16992k.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
        TextView textView = this.f16995n;
        textView.setText("(" + JsonParse.getString(data, "socre") + "分)");
        this.f17001t = (List) data.get("answers");
        this.f16996o.removeAllViews();
        List asList = Arrays.asList(JsonParse.getString(data, "stuAnswers").split(","));
        for (final Map<String, Object> map : this.f17001t) {
            CheckBox checkBox = new CheckBox(this.f1669h);
            checkBox.setTextSize(2, 16.0f);
            checkBox.setText(JsonParse.getString(map, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map, "answerOption"))));
            if (this.f17000s == 1) {
                checkBox.setClickable(false);
                checkBox.setChecked(asList.indexOf(JsonParse.getString(map, "answerId")) != -1);
            } else if (z) {
                checkBox.setClickable(true);
            } else {
                checkBox.setClickable(false);
                checkBox.setChecked(asList.indexOf(JsonParse.getString(map, "answerId")) != -1);
            }
            this.f16996o.addView(checkBox);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bxkj.student.home.teaching.homework.question.b
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                    CheckboxQuestionActivity.m42101n0(map, compoundButton, z2);
                }
            });
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16997p.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckboxQuestionActivity.this.m42102m0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_learn_checkbox_question;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m57932R().setVisibility(8);
        if (getIntent().hasExtra("questionId")) {
            this.f16999r = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f17000s = getIntent().getIntExtra("isQualified", 0);
        }
        m42103l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("课后作业开始答题-多选");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16992k = (TextView) findViewById(C4215R.C4219id.tv_question);
        this.f16996o = (RadioGroup) findViewById(C4215R.C4219id.rg_answer);
        this.f16994m = (TextView) findViewById(C4215R.C4219id.tv_index);
        this.f16995n = (TextView) findViewById(2131233146);
        this.f16993l = (TextView) findViewById(2131233211);
        this.f16997p = (Button) findViewById(2131230967);
        this.f16998q = (TextView) findViewById(C4215R.C4219id.tv_right_answer);
        this.f16993l.setText("多选");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
