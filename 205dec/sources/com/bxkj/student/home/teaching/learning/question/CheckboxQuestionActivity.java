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
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CheckboxQuestionActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f20914k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f20915l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20916m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f20917n;

    /* renamed from: o  reason: collision with root package name */
    private RadioGroup f20918o;

    /* renamed from: p  reason: collision with root package name */
    private Button f20919p;

    /* renamed from: q  reason: collision with root package name */
    private String f20920q;

    /* renamed from: r  reason: collision with root package name */
    private int f20921r;

    /* renamed from: s  reason: collision with root package name */
    private List<Map<String, Object>> f20922s;

    /* renamed from: t  reason: collision with root package name */
    private StringBuilder f20923t;

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
            CheckboxQuestionActivity.this.R().setVisibility(0);
            CheckboxQuestionActivity.this.o0(data);
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

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            CheckboxQuestionActivity.this.finish();
        }
    }

    private void l0() {
        Http.with(this.f1656h).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).c(this.f20920q, this.f20921r)).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(View view) {
        this.f20923t = new StringBuilder();
        for (Map<String, Object> map : this.f20922s) {
            if (map.containsKey("icChecked") && ((Boolean) map.get("icChecked")).booleanValue()) {
                StringBuilder sb = this.f20923t;
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                this.f20923t.append(JsonParse.getString(map, "answerId"));
            }
        }
        if (TextUtils.isEmpty(this.f20923t)) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u9009\u62e9\u7b54\u6848").show();
        } else {
            Http.with(this.f1656h).setObservable(((com.bxkj.student.home.teaching.learning.m) Http.getApiService(com.bxkj.student.home.teaching.learning.m.class)).b(this.f20920q, this.f20923t.toString())).setDataListener(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n0(Map map, CompoundButton compoundButton, boolean z3) {
        map.put("icChecked", Boolean.valueOf(z3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(Map<String, Object> data) {
        this.f20916m.setText("1");
        this.f20914k.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
        TextView textView = this.f20917n;
        textView.setText("(" + JsonParse.getString(data, "socre") + "\u5206)");
        this.f20922s = (List) data.get("answers");
        this.f20918o.removeAllViews();
        List asList = Arrays.asList(JsonParse.getString(data, "stuAnswers").split(","));
        for (final Map<String, Object> map : this.f20922s) {
            CheckBox checkBox = new CheckBox(this.f1656h);
            checkBox.setTextSize(2, 16.0f);
            checkBox.setText(JsonParse.getString(map, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map, "answerOption"))));
            if (this.f20921r == 1) {
                checkBox.setClickable(false);
                if (asList.indexOf(JsonParse.getString(map, "answerId")) != -1) {
                    checkBox.setChecked(true);
                }
            }
            this.f20918o.addView(checkBox);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bxkj.student.home.teaching.learning.question.b
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
                    CheckboxQuestionActivity.n0(map, compoundButton, z3);
                }
            });
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20919p.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.question.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CheckboxQuestionActivity.this.m0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427420;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        R().setVisibility(8);
        if (getIntent().hasExtra("questionId")) {
            this.f20920q = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f20921r = getIntent().getIntExtra("isQualified", 0);
        }
        if (this.f20921r == 1) {
            this.f20919p.setText("\u5df2\u5408\u683c");
            this.f20919p.setEnabled(false);
        }
        l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5f00\u59cb\u7b54\u9898-\u591a\u9009");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20914k = (TextView) findViewById(2131233112);
        this.f20918o = (RadioGroup) findViewById(2131232490);
        this.f20916m = (TextView) findViewById(2131233002);
        this.f20917n = (TextView) findViewById(2131233146);
        this.f20915l = (TextView) findViewById(2131233211);
        this.f20919p = (Button) findViewById(2131230967);
        this.f20915l.setText("\u591a\u9009");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
