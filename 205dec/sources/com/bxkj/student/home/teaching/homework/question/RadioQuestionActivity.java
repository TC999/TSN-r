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
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RadioQuestionActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f20414k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f20415l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20416m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f20417n;

    /* renamed from: o  reason: collision with root package name */
    private RadioGroup f20418o;

    /* renamed from: p  reason: collision with root package name */
    private Button f20419p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f20420q;

    /* renamed from: r  reason: collision with root package name */
    private List<Map<String, Object>> f20421r;

    /* renamed from: s  reason: collision with root package name */
    private String f20422s;

    /* renamed from: t  reason: collision with root package name */
    private int f20423t;

    /* renamed from: u  reason: collision with root package name */
    private String f20424u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends HttpCallBack {
        a() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RadioQuestionActivity.this.R().setVisibility(0);
            RadioQuestionActivity.this.p0(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f20426a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f20427b;

        b(final List val$finalAnswers, final Map val$data) {
            this.f20426a = val$finalAnswers;
            this.f20427b = val$data;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            RadioQuestionActivity radioQuestionActivity = RadioQuestionActivity.this;
            radioQuestionActivity.f20424u = JsonParse.getString((Map) this.f20426a.get(radioQuestionActivity.f20418o.indexOfChild((RadioButton) RadioQuestionActivity.this.f20418o.findViewById(checkedId))), "answerId");
            this.f20427b.put("checkAnswerId", RadioQuestionActivity.this.f20424u);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            RadioQuestionActivity.this.finish();
        }
    }

    private void n0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.student.home.teaching.homework.a) Http.getApiService(com.bxkj.student.home.teaching.homework.a.class)).c(this.f20422s, this.f20423t)).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(View view) {
        if (TextUtils.isEmpty(this.f20424u)) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u9009\u62e9\u7b54\u6848").show();
        } else {
            Http.with(this.f1656h).setObservable(((com.bxkj.student.home.teaching.homework.a) Http.getApiService(com.bxkj.student.home.teaching.homework.a.class)).b(this.f20422s, this.f20424u)).setDataListener(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(Map<String, Object> data) {
        Spanned fromHtml;
        boolean z3 = JsonParse.getBoolean(data, "isFlag");
        if (this.f20423t == 1) {
            this.f20419p.setText("\u5df2\u5408\u683c");
            this.f20419p.setEnabled(false);
        } else if (z3) {
            this.f20419p.setText("\u63d0\u4ea4");
            this.f20419p.setEnabled(true);
        } else {
            this.f20419p.setText("\u4e0d\u5408\u683c");
            this.f20419p.setEnabled(false);
            this.f20420q.setVisibility(0);
            this.f20420q.setText(JsonParse.getString(data, "markAnswer"));
        }
        setTitle("\u8bfe\u540e\u4f5c\u4e1a\u5f00\u59cb\u7b54\u9898-" + JsonParse.getString(data, "questionTypeName"));
        this.f20415l.setText(JsonParse.getString(data, "questionTypeName"));
        TextView textView = this.f20417n;
        textView.setText("(" + JsonParse.getString(data, "socre") + "\u5206)");
        this.f20416m.setText("1");
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml(JsonParse.getString(data, "questionName"), 63);
        } else {
            fromHtml = Html.fromHtml(JsonParse.getString(data, "questionName"));
        }
        this.f20414k.setText(fromHtml);
        String string = JsonParse.getString(data, "stuAnswers");
        this.f20421r = (List) data.get("answers");
        this.f20418o.removeAllViews();
        for (Map<String, Object> map : this.f20421r) {
            RadioButton radioButton = new RadioButton(this.f1656h);
            radioButton.setButtonDrawable(2131165441);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, cn.bluemobi.dylan.base.utils.d.a(this.f1656h, 40.0f));
            radioButton.setPadding(cn.bluemobi.dylan.base.utils.d.a(this.f1656h, 5.0f), 0, 0, 0);
            radioButton.setLayoutParams(layoutParams);
            radioButton.setTag(JsonParse.getString(map, "isRight"));
            radioButton.setTextSize(2, 20.0f);
            radioButton.setText(JsonParse.getString(map, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map, "answerOption"))));
            if (this.f20423t == 1) {
                radioButton.setClickable(false);
                radioButton.setChecked(string.equals(JsonParse.getString(map, "answerId")));
            } else if (z3) {
                radioButton.setClickable(true);
            } else {
                radioButton.setClickable(false);
                radioButton.setChecked(string.equals(JsonParse.getString(map, "answerId")));
            }
            this.f20418o.addView(radioButton);
        }
        this.f20418o.setOnCheckedChangeListener(new b(this.f20421r, data));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20419p.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RadioQuestionActivity.this.o0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427423;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        R().setVisibility(8);
        if (getIntent().hasExtra("questionId")) {
            this.f20422s = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f20423t = getIntent().getIntExtra("isQualified", 0);
        }
        n0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8bfe\u540e\u4f5c\u4e1a\u5f00\u59cb\u7b54\u9898");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20414k = (TextView) findViewById(2131233112);
        this.f20418o = (RadioGroup) findViewById(2131232490);
        this.f20416m = (TextView) findViewById(2131233002);
        this.f20417n = (TextView) findViewById(2131233146);
        this.f20415l = (TextView) findViewById(2131233211);
        this.f20419p = (Button) findViewById(2131230967);
        this.f20420q = (TextView) findViewById(2131233134);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    public void q0() {
        for (int i4 = 0; i4 < this.f20418o.getChildCount(); i4++) {
            RadioButton radioButton = (RadioButton) this.f20418o.getChildAt(i4);
            radioButton.setClickable(false);
            radioButton.setFocusable(false);
            radioButton.setFocusableInTouchMode(false);
            if ("0".equals(radioButton.getTag().toString())) {
                radioButton.setBackground(ContextCompat.getDrawable(this.f1656h, 2131165440));
            }
        }
    }
}
