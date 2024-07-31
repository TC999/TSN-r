package com.bxkj.student.home.teaching.homework.question;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.DisplayUtil;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.bxkj.student.home.teaching.homework.HomeWorkApiService;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RadioQuestionActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f17050k;

    /* renamed from: l */
    private TextView f17051l;

    /* renamed from: m */
    private TextView f17052m;

    /* renamed from: n */
    private TextView f17053n;

    /* renamed from: o */
    private RadioGroup f17054o;

    /* renamed from: p */
    private Button f17055p;

    /* renamed from: q */
    private TextView f17056q;

    /* renamed from: r */
    private List<Map<String, Object>> f17057r;

    /* renamed from: s */
    private String f17058s;

    /* renamed from: t */
    private int f17059t;

    /* renamed from: u */
    private String f17060u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.question.RadioQuestionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4537a extends HttpCallBack {
        C4537a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RadioQuestionActivity.this.m57932R().setVisibility(0);
            RadioQuestionActivity.this.m42057p0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.question.RadioQuestionActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4538b implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a */
        final /* synthetic */ List f17062a;

        /* renamed from: b */
        final /* synthetic */ Map f17063b;

        C4538b(final List val$finalAnswers, final Map val$data) {
            this.f17062a = val$finalAnswers;
            this.f17063b = val$data;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            RadioQuestionActivity radioQuestionActivity = RadioQuestionActivity.this;
            radioQuestionActivity.f17060u = JsonParse.getString((Map) this.f17062a.get(radioQuestionActivity.f17054o.indexOfChild((RadioButton) RadioQuestionActivity.this.f17054o.findViewById(checkedId))), "answerId");
            this.f17063b.put("checkAnswerId", RadioQuestionActivity.this.f17060u);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.homework.question.RadioQuestionActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4539c extends HttpCallBack {
        C4539c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RadioQuestionActivity.this.finish();
        }
    }

    /* renamed from: n0 */
    private void m42059n0() {
        Http.with(this.f1669h).setObservable(((HomeWorkApiService) Http.getApiService(HomeWorkApiService.class)).m42110c(this.f17058s, this.f17059t)).setDataListener(new C4537a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void m42058o0(View view) {
        if (TextUtils.isEmpty(this.f17060u)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请选择答案").show();
        } else {
            Http.with(this.f1669h).setObservable(((HomeWorkApiService) Http.getApiService(HomeWorkApiService.class)).m42111b(this.f17058s, this.f17060u)).setDataListener(new C4539c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public void m42057p0(Map<String, Object> data) {
        Spanned fromHtml;
        boolean z = JsonParse.getBoolean(data, "isFlag");
        if (this.f17059t == 1) {
            this.f17055p.setText("已合格");
            this.f17055p.setEnabled(false);
        } else if (z) {
            this.f17055p.setText("提交");
            this.f17055p.setEnabled(true);
        } else {
            this.f17055p.setText("不合格");
            this.f17055p.setEnabled(false);
            this.f17056q.setVisibility(0);
            this.f17056q.setText(JsonParse.getString(data, "markAnswer"));
        }
        setTitle("课后作业开始答题-" + JsonParse.getString(data, "questionTypeName"));
        this.f17051l.setText(JsonParse.getString(data, "questionTypeName"));
        TextView textView = this.f17053n;
        textView.setText("(" + JsonParse.getString(data, "socre") + "分)");
        this.f17052m.setText("1");
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml(JsonParse.getString(data, "questionName"), 63);
        } else {
            fromHtml = Html.fromHtml(JsonParse.getString(data, "questionName"));
        }
        this.f17050k.setText(fromHtml);
        String string = JsonParse.getString(data, "stuAnswers");
        this.f17057r = (List) data.get("answers");
        this.f17054o.removeAllViews();
        for (Map<String, Object> map : this.f17057r) {
            RadioButton radioButton = new RadioButton(this.f1669h);
            radioButton.setButtonDrawable(2131165441);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, DisplayUtil.m57760a(this.f1669h, 40.0f));
            radioButton.setPadding(DisplayUtil.m57760a(this.f1669h, 5.0f), 0, 0, 0);
            radioButton.setLayoutParams(layoutParams);
            radioButton.setTag(JsonParse.getString(map, "isRight"));
            radioButton.setTextSize(2, 20.0f);
            radioButton.setText(JsonParse.getString(map, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map, "answerOption"))));
            if (this.f17059t == 1) {
                radioButton.setClickable(false);
                radioButton.setChecked(string.equals(JsonParse.getString(map, "answerId")));
            } else if (z) {
                radioButton.setClickable(true);
            } else {
                radioButton.setClickable(false);
                radioButton.setChecked(string.equals(JsonParse.getString(map, "answerId")));
            }
            this.f17054o.addView(radioButton);
        }
        this.f17054o.setOnCheckedChangeListener(new C4538b(this.f17057r, data));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17055p.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RadioQuestionActivity.this.m42058o0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_learn_radio_question;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        m57932R().setVisibility(8);
        if (getIntent().hasExtra("questionId")) {
            this.f17058s = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f17059t = getIntent().getIntExtra("isQualified", 0);
        }
        m42059n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("课后作业开始答题");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17050k = (TextView) findViewById(C4215R.C4219id.tv_question);
        this.f17054o = (RadioGroup) findViewById(C4215R.C4219id.rg_answer);
        this.f17052m = (TextView) findViewById(C4215R.C4219id.tv_index);
        this.f17053n = (TextView) findViewById(2131233146);
        this.f17051l = (TextView) findViewById(2131233211);
        this.f17055p = (Button) findViewById(2131230967);
        this.f17056q = (TextView) findViewById(C4215R.C4219id.tv_right_answer);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* renamed from: q0 */
    public void m42056q0() {
        for (int i = 0; i < this.f17054o.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) this.f17054o.getChildAt(i);
            radioButton.setClickable(false);
            radioButton.setFocusable(false);
            radioButton.setFocusableInTouchMode(false);
            if ("0".equals(radioButton.getTag().toString())) {
                radioButton.setBackground(ContextCompat.getDrawable(this.f1669h, C4215R.C4218drawable.exam_radio_right));
            }
        }
    }
}
