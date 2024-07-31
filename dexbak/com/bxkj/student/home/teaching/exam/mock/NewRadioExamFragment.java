package com.bxkj.student.home.teaching.exam.mock;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.Html;
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
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class NewRadioExamFragment extends BaseFragment {

    /* renamed from: h */
    private TextView f16886h;

    /* renamed from: i */
    private TextView f16887i;

    /* renamed from: j */
    private TextView f16888j;

    /* renamed from: k */
    private TextView f16889k;

    /* renamed from: l */
    private RadioGroup f16890l;

    /* renamed from: m */
    private CountDownTimer f16891m;

    /* renamed from: n */
    private List<Map<String, Object>> f16892n;

    /* renamed from: com.bxkj.student.home.teaching.exam.mock.NewRadioExamFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4497a implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a */
        final /* synthetic */ Map f16893a;

        /* renamed from: b */
        final /* synthetic */ NewExamActivity f16894b;

        C4497a(final Map val$data, final NewExamActivity val$newExamActivity) {
            this.f16893a = val$data;
            this.f16894b = val$newExamActivity;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            Context context;
            int i;
            RadioButton radioButton = (RadioButton) NewRadioExamFragment.this.f16890l.findViewById(checkedId);
            this.f16893a.put("checkAnswerId", JsonParse.getString((Map) NewRadioExamFragment.this.f16892n.get(NewRadioExamFragment.this.f16890l.indexOfChild(radioButton)), "answerId"));
            if ("0".equals(radioButton.getTag().toString())) {
                context = ((BaseFragment) NewRadioExamFragment.this).f1678e;
                i = C4215R.C4218drawable.exam_radio_right;
            } else {
                context = ((BaseFragment) NewRadioExamFragment.this).f1678e;
                i = C4215R.C4218drawable.exam_radio_error;
            }
            radioButton.setBackground(ContextCompat.getDrawable(context, i));
            NewRadioExamFragment.this.m42187R();
            this.f16894b.f16850o.setEnabled(true);
            this.f16894b.f16851p.setEnabled(true);
        }
    }

    /* renamed from: R */
    public void m42187R() {
        if (this.f16890l == null) {
            return;
        }
        for (int i = 0; i < this.f16890l.getChildCount(); i++) {
            RadioButton radioButton = (RadioButton) this.f16890l.getChildAt(i);
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
        Context context;
        int i;
        this.f16886h = (TextView) m57916c(C4215R.C4219id.tv_question);
        this.f16890l = (RadioGroup) m57916c(C4215R.C4219id.rg_answer);
        this.f16888j = (TextView) m57916c(C4215R.C4219id.tv_index);
        this.f16889k = (TextView) m57916c(2131233146);
        this.f16887i = (TextView) m57916c(2131233211);
        int i2 = getArguments().getInt("index");
        NewExamActivity newExamActivity = (NewExamActivity) getActivity();
        Map<String, Object> map = ((SeralizableMap) getArguments().getSerializable("seralizableMap")).getMap();
        TextView textView = this.f16888j;
        textView.setText((i2 + 1) + "");
        this.f16886h.setText(Html.fromHtml(JsonParse.getString(map, "questionName")));
        TextView textView2 = this.f16889k;
        textView2.setText("(" + JsonParse.getString(map, "score") + ")分");
        this.f16892n = (List) map.get("answers");
        this.f16890l.removeAllViews();
        if ("0".equals(JsonParse.getString(map, "questionType"))) {
            this.f16887i.setText("单选");
        } else if ("1".equals(JsonParse.getString(map, "questionType"))) {
            this.f16887i.setText("多选");
        } else if ("3".equals(JsonParse.getString(map, "questionType"))) {
            this.f16887i.setText("判断");
        }
        for (Map<String, Object> map2 : this.f16892n) {
            RadioButton radioButton = new RadioButton(this.f1678e);
            radioButton.setButtonDrawable(2131165441);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, DisplayUtil.m57760a(this.f1678e, 40.0f));
            layoutParams.topMargin = DisplayUtil.m57760a(this.f1678e, 5.0f);
            layoutParams.leftMargin = DisplayUtil.m57760a(this.f1678e, 10.0f);
            radioButton.setPadding(DisplayUtil.m57760a(this.f1678e, 10.0f), 0, 0, 0);
            radioButton.setLayoutParams(layoutParams);
            String string = JsonParse.getString(map2, "isRight");
            radioButton.setTag(string);
            radioButton.setTextSize(2, 16.0f);
            radioButton.setText(JsonParse.getString(map2, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map2, "answerOption"))));
            this.f16890l.addView(radioButton);
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
                m42187R();
            }
        }
        this.f16890l.setOnCheckedChangeListener(new C4497a(map, newExamActivity));
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_exam;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
