package com.bxkj.student.home.teaching.learning.question;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
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
import com.bxkj.student.home.teaching.learning.LearningApiService;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RadioQuestionActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f17599k;

    /* renamed from: l */
    private TextView f17600l;

    /* renamed from: m */
    private TextView f17601m;

    /* renamed from: n */
    private TextView f17602n;

    /* renamed from: o */
    private RadioGroup f17603o;

    /* renamed from: p */
    private Button f17604p;

    /* renamed from: q */
    private CountDownTimer f17605q;

    /* renamed from: r */
    private List<Map<String, Object>> f17606r;

    /* renamed from: s */
    private String f17607s;

    /* renamed from: t */
    private int f17608t;

    /* renamed from: u */
    private String f17609u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.question.RadioQuestionActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4719a extends HttpCallBack {
        C4719a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RadioQuestionActivity.this.m57932R().setVisibility(0);
            RadioQuestionActivity.this.m41515p0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.question.RadioQuestionActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4720b implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a */
        final /* synthetic */ List f17611a;

        /* renamed from: b */
        final /* synthetic */ Map f17612b;

        C4720b(final List val$finalAnswers, final Map val$data) {
            this.f17611a = val$finalAnswers;
            this.f17612b = val$data;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            RadioQuestionActivity radioQuestionActivity = RadioQuestionActivity.this;
            radioQuestionActivity.f17609u = JsonParse.getString((Map) this.f17611a.get(radioQuestionActivity.f17603o.indexOfChild((RadioButton) RadioQuestionActivity.this.f17603o.findViewById(checkedId))), "answerId");
            this.f17612b.put("checkAnswerId", RadioQuestionActivity.this.f17609u);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.question.RadioQuestionActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4721c extends HttpCallBack {
        C4721c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RadioQuestionActivity.this.finish();
        }
    }

    /* renamed from: n0 */
    private void m41517n0() {
        Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41639c(this.f17607s, this.f17608t)).setDataListener(new C4719a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o0 */
    public /* synthetic */ void m41516o0(View view) {
        if (TextUtils.isEmpty(this.f17609u)) {
            new iOSOneButtonDialog(this.f1669h).setMessage("请选择答案").show();
        } else {
            Http.with(this.f1669h).setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41640b(this.f17607s, this.f17609u)).setDataListener(new C4721c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p0 */
    public void m41515p0(Map<String, Object> data) {
        Spanned fromHtml;
        setTitle("开始答题-" + JsonParse.getString(data, "questionTypeName"));
        this.f17600l.setText(JsonParse.getString(data, "questionTypeName"));
        TextView textView = this.f17602n;
        textView.setText("(" + JsonParse.getString(data, "socre") + "分)");
        this.f17601m.setText("1");
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml(JsonParse.getString(data, "questionName"), 63);
        } else {
            fromHtml = Html.fromHtml(JsonParse.getString(data, "questionName"));
        }
        this.f17599k.setText(fromHtml);
        String string = JsonParse.getString(data, "stuAnswers");
        this.f17606r = (List) data.get("answers");
        this.f17603o.removeAllViews();
        for (Map<String, Object> map : this.f17606r) {
            RadioButton radioButton = new RadioButton(this.f1669h);
            radioButton.setButtonDrawable(2131165441);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, DisplayUtil.m57760a(this.f1669h, 40.0f));
            radioButton.setPadding(DisplayUtil.m57760a(this.f1669h, 5.0f), 0, 0, 0);
            radioButton.setLayoutParams(layoutParams);
            radioButton.setTag(JsonParse.getString(map, "isRight"));
            radioButton.setTextSize(2, 20.0f);
            radioButton.setText(JsonParse.getString(map, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map, "answerOption"))));
            if (this.f17608t == 1) {
                radioButton.setClickable(false);
                if (string.equals(JsonParse.getString(map, "answerId"))) {
                    radioButton.setChecked(true);
                }
            }
            this.f17603o.addView(radioButton);
        }
        this.f17603o.setOnCheckedChangeListener(new C4720b(this.f17606r, data));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17604p.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RadioQuestionActivity.this.m41516o0(view);
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
            this.f17607s = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f17608t = getIntent().getIntExtra("isQualified", 0);
        }
        if (this.f17608t == 1) {
            this.f17604p.setText("已合格");
            this.f17604p.setEnabled(false);
        }
        m41517n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("开始答题");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17599k = (TextView) findViewById(C4215R.C4219id.tv_question);
        this.f17603o = (RadioGroup) findViewById(C4215R.C4219id.rg_answer);
        this.f17601m = (TextView) findViewById(C4215R.C4219id.tv_index);
        this.f17602n = (TextView) findViewById(2131233146);
        this.f17600l = (TextView) findViewById(2131233211);
        this.f17604p = (Button) findViewById(2131230967);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* renamed from: q0 */
    public void m41514q0() {
        for (int i = 0; i < this.f17603o.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) this.f17603o.getChildAt(i);
            radioButton.setClickable(false);
            radioButton.setFocusable(false);
            radioButton.setFocusableInTouchMode(false);
            if ("0".equals(radioButton.getTag().toString())) {
                radioButton.setBackground(ContextCompat.getDrawable(this.f1669h, C4215R.C4218drawable.exam_radio_right));
            }
        }
    }
}
