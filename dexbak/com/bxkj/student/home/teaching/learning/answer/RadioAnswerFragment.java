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
import cn.bluemobi.dylan.base.utils.DisplayUtil;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RadioAnswerFragment extends BaseFragment {

    /* renamed from: h */
    private TextView f17244h;

    /* renamed from: i */
    private TextView f17245i;

    /* renamed from: j */
    private TextView f17246j;

    /* renamed from: k */
    private TextView f17247k;

    /* renamed from: l */
    private RadioGroup f17248l;

    /* renamed from: m */
    private CountDownTimer f17249m;

    /* renamed from: n */
    private List<Map<String, Object>> f17250n;

    /* renamed from: com.bxkj.student.home.teaching.learning.answer.RadioAnswerFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4606a implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a */
        final /* synthetic */ Map f17251a;

        /* renamed from: b */
        final /* synthetic */ AnswerActivity f17252b;

        C4606a(final Map val$data, final AnswerActivity val$evaluateActivity) {
            this.f17251a = val$data;
            this.f17252b = val$evaluateActivity;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            Context context;
            int i;
            RadioButton radioButton = (RadioButton) RadioAnswerFragment.this.f17248l.findViewById(checkedId);
            this.f17251a.put("checkAnswerId", JsonParse.getString((Map) RadioAnswerFragment.this.f17250n.get(RadioAnswerFragment.this.f17248l.indexOfChild(radioButton)), "answerId"));
            if ("0".equals(radioButton.getTag().toString())) {
                context = ((BaseFragment) RadioAnswerFragment.this).f1678e;
                i = C4215R.C4218drawable.exam_radio_right;
            } else {
                context = ((BaseFragment) RadioAnswerFragment.this).f1678e;
                i = C4215R.C4218drawable.exam_radio_error;
            }
            radioButton.setBackground(ContextCompat.getDrawable(context, i));
            RadioAnswerFragment.this.m41873R();
            this.f17252b.f17203o.setEnabled(true);
            this.f17252b.f17204p.setEnabled(true);
        }
    }

    /* renamed from: R */
    public void m41873R() {
        for (int i = 0; i < this.f17248l.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) this.f17248l.getChildAt(i);
            radioButton.setClickable(false);
            radioButton.setFocusable(false);
            radioButton.setFocusableInTouchMode(false);
            if ("0".equals(radioButton.getTag().toString())) {
                radioButton.setBackground(ContextCompat.getDrawable(this.f1678e, C4215R.C4218drawable.exam_radio_right));
            }
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    protected void mo39444e() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        Spanned fromHtml;
        Context context;
        int i;
        this.f17244h = (TextView) m57916c(C4215R.C4219id.tv_question);
        this.f17248l = (RadioGroup) m57916c(C4215R.C4219id.rg_answer);
        this.f17246j = (TextView) m57916c(C4215R.C4219id.tv_index);
        this.f17247k = (TextView) m57916c(2131233146);
        TextView textView = (TextView) m57916c(2131233211);
        this.f17245i = textView;
        textView.setVisibility(8);
        int i2 = getArguments().getInt("index");
        AnswerActivity answerActivity = (AnswerActivity) getActivity();
        Map<String, Object> map = answerActivity.m41904J0().get(i2);
        TextView textView2 = this.f17246j;
        textView2.setText((i2 + 1) + "");
        if (Build.VERSION.SDK_INT >= 24) {
            fromHtml = Html.fromHtml(JsonParse.getString(map, "questionName"), 63);
        } else {
            fromHtml = Html.fromHtml(JsonParse.getString(map, "questionName"));
        }
        this.f17244h.setText(fromHtml);
        TextView textView3 = this.f17247k;
        textView3.setText("(" + JsonParse.getString(map, "score") + ")分");
        this.f17250n = (List) map.get("answers");
        this.f17248l.removeAllViews();
        if ("0".equals(JsonParse.getString(map, "questionType"))) {
            this.f17245i.setText("单选");
        } else if ("1".equals(JsonParse.getString(map, "questionType"))) {
            this.f17245i.setText("多选");
        } else if ("3".equals(JsonParse.getString(map, "questionType"))) {
            this.f17245i.setText("判断");
        }
        for (Map<String, Object> map2 : this.f17250n) {
            RadioButton radioButton = new RadioButton(this.f1678e);
            radioButton.setButtonDrawable(2131165441);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, DisplayUtil.m57760a(this.f1678e, 40.0f));
            layoutParams.topMargin = DisplayUtil.m57760a(this.f1678e, 5.0f);
            layoutParams.leftMargin = DisplayUtil.m57760a(this.f1678e, 10.0f);
            radioButton.setPadding(DisplayUtil.m57760a(this.f1678e, 5.0f), 0, 0, 0);
            radioButton.setLayoutParams(layoutParams);
            String string = JsonParse.getString(map2, "isRight");
            radioButton.setTag(string);
            radioButton.setTextSize(2, 20.0f);
            radioButton.setText(JsonParse.getString(map2, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map2, "answerOption"))));
            this.f17248l.addView(radioButton);
            String string2 = JsonParse.getString(map, "checkAnswerId");
            if (!TextUtils.isEmpty(string2) || JsonParse.getBoolean(map, "timeFinish")) {
                radioButton.setFocusable(false);
                radioButton.setFocusableInTouchMode(false);
                if (string2.equals(JsonParse.getString(map2, "answerId"))) {
                    if ("0".equals(string)) {
                        context = this.f1678e;
                        i = C4215R.C4218drawable.exam_radio_right;
                    } else {
                        context = this.f1678e;
                        i = C4215R.C4218drawable.exam_radio_error;
                    }
                    radioButton.setBackground(ContextCompat.getDrawable(context, i));
                    radioButton.setChecked(true);
                } else {
                    radioButton.setChecked(false);
                }
                m41873R();
            }
        }
        this.f17248l.setOnCheckedChangeListener(new C4606a(map, answerActivity));
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_answerm;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
