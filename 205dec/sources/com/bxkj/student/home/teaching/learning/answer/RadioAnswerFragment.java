package com.bxkj.student.home.teaching.learning.answer;

import android.content.Context;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.d;
import cn.bluemobi.dylan.http.JsonParse;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RadioAnswerFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private TextView f20597h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f20598i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f20599j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f20600k;

    /* renamed from: l  reason: collision with root package name */
    private RadioGroup f20601l;

    /* renamed from: m  reason: collision with root package name */
    private CountDownTimer f20602m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f20603n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f20604a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AnswerActivity f20605b;

        a(final Map val$data, final AnswerActivity val$evaluateActivity) {
            this.f20604a = val$data;
            this.f20605b = val$evaluateActivity;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            Context context;
            int i4;
            RadioButton radioButton = (RadioButton) RadioAnswerFragment.this.f20601l.findViewById(checkedId);
            this.f20604a.put("checkAnswerId", JsonParse.getString((Map) RadioAnswerFragment.this.f20603n.get(RadioAnswerFragment.this.f20601l.indexOfChild(radioButton)), "answerId"));
            if ("0".equals(radioButton.getTag().toString())) {
                context = ((BaseFragment) RadioAnswerFragment.this).f1665e;
                i4 = 2131165440;
            } else {
                context = ((BaseFragment) RadioAnswerFragment.this).f1665e;
                i4 = 2131165439;
            }
            radioButton.setBackground(ContextCompat.getDrawable(context, i4));
            RadioAnswerFragment.this.R();
            this.f20605b.f20556o.setEnabled(true);
            this.f20605b.f20557p.setEnabled(true);
        }
    }

    public void R() {
        for (int i4 = 0; i4 < this.f20601l.getChildCount(); i4++) {
            RadioButton radioButton = (RadioButton) this.f20601l.getChildAt(i4);
            radioButton.setClickable(false);
            radioButton.setFocusable(false);
            radioButton.setFocusableInTouchMode(false);
            if ("0".equals(radioButton.getTag().toString())) {
                radioButton.setBackground(ContextCompat.getDrawable(this.f1665e, 2131165440));
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        Spanned fromHtml;
        Context context;
        int i4;
        this.f20597h = (TextView) c(2131233112);
        this.f20601l = (RadioGroup) c(2131232490);
        this.f20599j = (TextView) c(2131233002);
        this.f20600k = (TextView) c(2131233146);
        TextView textView = (TextView) c(2131233211);
        this.f20598i = textView;
        textView.setVisibility(8);
        int i5 = getArguments().getInt("index");
        AnswerActivity answerActivity = (AnswerActivity) getActivity();
        Map<String, Object> map = answerActivity.J0().get(i5);
        TextView textView2 = this.f20599j;
        textView2.setText((i5 + 1) + "");
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml(JsonParse.getString(map, "questionName"), 63);
        } else {
            fromHtml = Html.fromHtml(JsonParse.getString(map, "questionName"));
        }
        this.f20597h.setText(fromHtml);
        TextView textView3 = this.f20600k;
        textView3.setText("(" + JsonParse.getString(map, "score") + ")\u5206");
        this.f20603n = (List) map.get("answers");
        this.f20601l.removeAllViews();
        if ("0".equals(JsonParse.getString(map, "questionType"))) {
            this.f20598i.setText("\u5355\u9009");
        } else if ("1".equals(JsonParse.getString(map, "questionType"))) {
            this.f20598i.setText("\u591a\u9009");
        } else if ("3".equals(JsonParse.getString(map, "questionType"))) {
            this.f20598i.setText("\u5224\u65ad");
        }
        for (Map<String, Object> map2 : this.f20603n) {
            RadioButton radioButton = new RadioButton(this.f1665e);
            radioButton.setButtonDrawable(2131165441);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, d.a(this.f1665e, 40.0f));
            layoutParams.topMargin = d.a(this.f1665e, 5.0f);
            layoutParams.leftMargin = d.a(this.f1665e, 10.0f);
            radioButton.setPadding(d.a(this.f1665e, 5.0f), 0, 0, 0);
            radioButton.setLayoutParams(layoutParams);
            String string = JsonParse.getString(map2, "isRight");
            radioButton.setTag(string);
            radioButton.setTextSize(2, 20.0f);
            radioButton.setText(JsonParse.getString(map2, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map2, "answerOption"))));
            this.f20601l.addView(radioButton);
            String string2 = JsonParse.getString(map, "checkAnswerId");
            if (!TextUtils.isEmpty(string2) || JsonParse.getBoolean(map, "timeFinish")) {
                radioButton.setFocusable(false);
                radioButton.setFocusableInTouchMode(false);
                if (string2.equals(JsonParse.getString(map2, "answerId"))) {
                    if ("0".equals(string)) {
                        context = this.f1665e;
                        i4 = 2131165440;
                    } else {
                        context = this.f1665e;
                        i4 = 2131165439;
                    }
                    radioButton.setBackground(ContextCompat.getDrawable(context, i4));
                    radioButton.setChecked(true);
                } else {
                    radioButton.setChecked(false);
                }
                R();
            }
        }
        this.f20601l.setOnCheckedChangeListener(new a(map, answerActivity));
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427620;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
