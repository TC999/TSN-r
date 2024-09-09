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
    private TextView f20362k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f20363l;

    /* renamed from: m  reason: collision with root package name */
    private TextView f20364m;

    /* renamed from: n  reason: collision with root package name */
    private TextView f20365n;

    /* renamed from: o  reason: collision with root package name */
    private RadioGroup f20366o;

    /* renamed from: p  reason: collision with root package name */
    private Button f20367p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f20368q;

    /* renamed from: r  reason: collision with root package name */
    private String f20369r;

    /* renamed from: s  reason: collision with root package name */
    private int f20370s;

    /* renamed from: t  reason: collision with root package name */
    private List<Map<String, Object>> f20371t;

    /* renamed from: u  reason: collision with root package name */
    private StringBuilder f20372u;

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
        Http.with(this.f1656h).setObservable(((com.bxkj.student.home.teaching.homework.a) Http.getApiService(com.bxkj.student.home.teaching.homework.a.class)).c(this.f20369r, this.f20370s)).setDataListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m0(View view) {
        this.f20372u = new StringBuilder();
        for (Map<String, Object> map : this.f20371t) {
            if (map.containsKey("icChecked") && ((Boolean) map.get("icChecked")).booleanValue()) {
                StringBuilder sb = this.f20372u;
                sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                this.f20372u.append(JsonParse.getString(map, "answerId"));
            }
        }
        if (TextUtils.isEmpty(this.f20372u)) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u8bf7\u9009\u62e9\u7b54\u6848").show();
        } else {
            Http.with(this.f1656h).setObservable(((com.bxkj.student.home.teaching.homework.a) Http.getApiService(com.bxkj.student.home.teaching.homework.a.class)).b(this.f20369r, this.f20372u.toString())).setDataListener(new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n0(Map map, CompoundButton compoundButton, boolean z3) {
        map.put("icChecked", Boolean.valueOf(z3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(Map<String, Object> data) {
        boolean z3 = JsonParse.getBoolean(data, "isFlag");
        if (this.f20370s == 1) {
            this.f20367p.setText("\u5df2\u5408\u683c");
            this.f20367p.setEnabled(false);
        } else if (z3) {
            this.f20367p.setText("\u63d0\u4ea4");
            this.f20367p.setEnabled(true);
        } else {
            this.f20367p.setText("\u4e0d\u5408\u683c");
            this.f20367p.setEnabled(false);
            this.f20368q.setVisibility(0);
            this.f20368q.setText(JsonParse.getString(data, "markAnswer"));
        }
        this.f20362k.setText(Html.fromHtml(JsonParse.getString(data, "questionName")));
        TextView textView = this.f20365n;
        textView.setText("(" + JsonParse.getString(data, "socre") + "\u5206)");
        this.f20371t = (List) data.get("answers");
        this.f20366o.removeAllViews();
        List asList = Arrays.asList(JsonParse.getString(data, "stuAnswers").split(","));
        for (final Map<String, Object> map : this.f20371t) {
            CheckBox checkBox = new CheckBox(this.f1656h);
            checkBox.setTextSize(2, 16.0f);
            checkBox.setText(JsonParse.getString(map, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map, "answerOption"))));
            if (this.f20370s == 1) {
                checkBox.setClickable(false);
                checkBox.setChecked(asList.indexOf(JsonParse.getString(map, "answerId")) != -1);
            } else if (z3) {
                checkBox.setClickable(true);
            } else {
                checkBox.setClickable(false);
                checkBox.setChecked(asList.indexOf(JsonParse.getString(map, "answerId")) != -1);
            }
            this.f20366o.addView(checkBox);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.bxkj.student.home.teaching.homework.question.b
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                    CheckboxQuestionActivity.n0(map, compoundButton, z4);
                }
            });
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20367p.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.homework.question.a
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
            this.f20369r = getIntent().getStringExtra("questionId");
        }
        if (getIntent().hasExtra("isQualified")) {
            this.f20370s = getIntent().getIntExtra("isQualified", 0);
        }
        l0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u8bfe\u540e\u4f5c\u4e1a\u5f00\u59cb\u7b54\u9898-\u591a\u9009");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20362k = (TextView) findViewById(2131233112);
        this.f20366o = (RadioGroup) findViewById(2131232490);
        this.f20364m = (TextView) findViewById(2131233002);
        this.f20365n = (TextView) findViewById(2131233146);
        this.f20363l = (TextView) findViewById(2131233211);
        this.f20367p = (Button) findViewById(2131230967);
        this.f20368q = (TextView) findViewById(2131233134);
        this.f20363l.setText("\u591a\u9009");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
