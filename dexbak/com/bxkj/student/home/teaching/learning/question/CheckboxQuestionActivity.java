package com.bxkj.student.home.teaching.learning.question;

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
import com.bxkj.student.home.teaching.learning.LearningApiService;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CheckboxQuestionActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f17571k;

    /* renamed from: l */
    private TextView f17572l;

    /* renamed from: m */
    private TextView f17573m;

    /* renamed from: n */
    private TextView f17574n;

    /* renamed from: o */
    private RadioGroup f17575o;

    /* renamed from: p */
    private Button f17576p;

    /* renamed from: q */
    private String f17577q;

    /* renamed from: r */
    private int f17578r;

    /* renamed from: s */
    private List<Map<String, Object>> f17579s;

    /* renamed from: t */
    private StringBuilder f17580t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.question.CheckboxQuestionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4713a extends HttpCallBack {
        C4713a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CheckboxQuestionActivity.this.m57932R().setVisibility(0);
            CheckboxQuestionActivity.this.m41538o0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.question.CheckboxQuestionActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4714b extends HttpCallBack {
        C4714b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CheckboxQuestionActivity.this.finish();
        }
    }

    /* renamed from: l0 */
    private void m41541l0() {
        Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41639c(this.f17577q, this.f17578r)).setDataListener(new C4713a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0 */
    public /* synthetic */ void m41540m0(View view) {
        this.f17580t = new StringBuilder();
        for (Map<String, Object> map : this.f17579s) {
            if (map.containsKey("icChecked") && ((Boolean) map.get("icChecked")).booleanValue()) {
                StringBuilder sb = this.f17580t;
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                this.f17580t.append(JsonParse.getString(map, "answerId"));
            }
        }
        if (TextUtils.isEmpty(this.f17580t)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请选择答案").show();
        } else {
            Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41640b(this.f17577q, this.f17580t.toString())).setDataListener(new C4714b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n0 */
    public static /* synthetic */ void m41539n0(Map map, CompoundButton compoundButton, boolean z) {
        map.put("icChecked", Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public void m41538o0(Map<String, Object> data) {
        this.f17573m.setText("1");
        this.f17571k.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
        TextView textView = this.f17574n;
        textView.setText("(" + JsonParse.getString(data, "socre") + "分)");
        this.f17579s = (List) data.get("answers");
        this.f17575o.removeAllViews();
        List asList = Arrays.asList(JsonParse.getString(data, "stuAnswers").split(","));
        for (final Map<String, Object> map : this.f17579s) {
            CheckBox checkBox = new CheckBox(this.f1669h);
            checkBox.setTextSize(2, 16.0f);
            checkBox.setText(JsonParse.getString(map, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map, "answerOption"))));
            if (this.f17578r == 1) {
                checkBox.setClickable(false);
                if (asList.indexOf(JsonParse.getString(map, "answerId")) != -1) {
                    checkBox.setChecked(true);
                }
            }
            this.f17575o.addView(checkBox);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bxkj.student.home.teaching.learning.question.b
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    CheckboxQuestionActivity.m41539n0(map, compoundButton, z);
                }
            });
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17576p.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckboxQuestionActivity.this.m41540m0(view);
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
            this.f17577q = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f17578r = getIntent().getIntExtra("isQualified", 0);
        }
        if (this.f17578r == 1) {
            this.f17576p.setText("已合格");
            this.f17576p.setEnabled(false);
        }
        m41541l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("开始答题-多选");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17571k = (TextView) findViewById(C4215R.C4219id.tv_question);
        this.f17575o = (RadioGroup) findViewById(C4215R.C4219id.rg_answer);
        this.f17573m = (TextView) findViewById(C4215R.C4219id.tv_index);
        this.f17574n = (TextView) findViewById(2131233146);
        this.f17572l = (TextView) findViewById(2131233211);
        this.f17576p = (Button) findViewById(2131230967);
        this.f17572l.setText("多选");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
