package com.bxkj.student.home.teaching.exam.formal;

import android.text.Html;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class RadioExamFragment extends BaseFragment {

    /* renamed from: h */
    private TextView f16803h;

    /* renamed from: i */
    private TextView f16804i;

    /* renamed from: j */
    private TextView f16805j;

    /* renamed from: k */
    private TextView f16806k;

    /* renamed from: l */
    private RadioGroup f16807l;

    /* renamed from: m */
    private ExamActivity f16808m;

    /* renamed from: com.bxkj.student.home.teaching.exam.formal.RadioExamFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4470a implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a */
        final /* synthetic */ Map f16809a;

        /* renamed from: b */
        final /* synthetic */ List f16810b;

        C4470a(final Map val$data, final List val$answers) {
            this.f16809a = val$data;
            this.f16810b = val$answers;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            this.f16809a.put("checkAnswerId", JsonParse.getString((Map) this.f16810b.get(RadioExamFragment.this.f16807l.indexOfChild(RadioExamFragment.this.f16807l.findViewById(checkedId))), "answerId"));
            RadioExamFragment.this.f16808m.f16774l.setEnabled(true);
            RadioExamFragment.this.f16808m.f16775m.setEnabled(true);
            RadioExamFragment.this.f16808m.f16770M = true;
        }
    }

    /* renamed from: P */
    public void m42245P() {
        if (this.f16808m.f16768K != 1) {
            for (int i = 0; i < this.f16807l.getChildCount(); i++) {
                RadioButton radioButton = (RadioButton) this.f16807l.getChildAt(i);
                radioButton.setClickable(false);
                radioButton.setFocusable(false);
                radioButton.setFocusableInTouchMode(false);
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
        this.f16803h = (TextView) m57916c(C4215R.C4219id.tv_question);
        this.f16807l = (RadioGroup) m57916c(C4215R.C4219id.rg_answer);
        this.f16805j = (TextView) m57916c(C4215R.C4219id.tv_index);
        this.f16806k = (TextView) m57916c(2131233146);
        this.f16804i = (TextView) m57916c(2131233211);
        int i = getArguments().getInt("index");
        this.f16808m = (ExamActivity) getActivity();
        Map<String, Object> map = ((SeralizableMap) getArguments().getSerializable("seralizableMap")).getMap();
        TextView textView = this.f16805j;
        textView.setText((i + 1) + "");
        this.f16803h.setText(Html.fromHtml(JsonParse.getString(map, "questionName")));
        TextView textView2 = this.f16806k;
        textView2.setText("(" + JsonParse.getString(map, "score") + ")分");
        List<Map> list = (List) map.get("answers");
        this.f16807l.removeAllViews();
        if ("0".equals(JsonParse.getString(map, "questionType"))) {
            this.f16804i.setText("单选");
        } else if ("1".equals(JsonParse.getString(map, "questionType"))) {
            this.f16804i.setText("多选");
        } else if ("3".equals(JsonParse.getString(map, "questionType"))) {
            this.f16804i.setText("判断");
        }
        for (Map map2 : list) {
            RadioButton radioButton = new RadioButton(this.f1678e);
            radioButton.setTextSize(2, 16.0f);
            radioButton.setText(JsonParse.getString(map2, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map2, "answerOption"))));
            this.f16807l.addView(radioButton);
            if (JsonParse.getString(map, "checkAnswerId").equals(JsonParse.getString(map2, "answerId"))) {
                radioButton.setChecked(true);
            } else {
                radioButton.setChecked(false);
            }
        }
        if (!TextUtils.isEmpty(JsonParse.getString(map, "checkAnswerId")) || JsonParse.getBoolean(map, "timeFinish")) {
            m42245P();
        }
        this.f16807l.setOnCheckedChangeListener(new C4470a(map, list));
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
