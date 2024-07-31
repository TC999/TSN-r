package com.bxkj.student.home.teaching.learning.answer;

import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CheckboxAnswerFragment extends BaseFragment {

    /* renamed from: h */
    private TextView f17237h;

    /* renamed from: i */
    private TextView f17238i;

    /* renamed from: j */
    private TextView f17239j;

    /* renamed from: k */
    private TextView f17240k;

    /* renamed from: l */
    private RadioGroup f17241l;

    /* renamed from: com.bxkj.student.home.teaching.learning.answer.CheckboxAnswerFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4605a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a */
        final /* synthetic */ Map f17242a;

        C4605a(final Map val$answer) {
            this.f17242a = val$answer;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            this.f17242a.put("icChecked", Boolean.valueOf(isChecked));
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
        this.f17237h = (TextView) m57916c(C4215R.C4219id.tv_question);
        this.f17241l = (RadioGroup) m57916c(C4215R.C4219id.rg_answer);
        this.f17239j = (TextView) m57916c(C4215R.C4219id.tv_index);
        this.f17240k = (TextView) m57916c(2131233146);
        TextView textView = (TextView) m57916c(2131233211);
        this.f17238i = textView;
        textView.setText("多选");
        int i = getArguments().getInt("index");
        Map<String, Object> map = ((AnswerActivity) getActivity()).m41904J0().get(i);
        TextView textView2 = this.f17239j;
        textView2.setText((i + 1) + "");
        this.f17237h.setText(Html.fromHtml(JsonParse.getString(map, "questionName")));
        TextView textView3 = this.f17240k;
        textView3.setText("(" + JsonParse.getString(map, "score") + ")分");
        this.f17241l.removeAllViews();
        for (Map map2 : (List) map.get("answers")) {
            CheckBox checkBox = new CheckBox(this.f1678e);
            checkBox.setTextSize(2, 16.0f);
            checkBox.setText(JsonParse.getString(map2, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map2, "answerOption"))));
            this.f17241l.addView(checkBox);
            checkBox.setChecked(map2.containsKey("icChecked") && ((Boolean) map2.get("icChecked")).booleanValue());
            checkBox.setOnCheckedChangeListener(new C4605a(map2));
        }
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
