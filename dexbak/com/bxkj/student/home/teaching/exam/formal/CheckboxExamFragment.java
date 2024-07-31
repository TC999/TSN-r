package com.bxkj.student.home.teaching.exam.formal;

import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CheckboxExamFragment extends BaseFragment {

    /* renamed from: h */
    private TextView f16750h;

    /* renamed from: i */
    private TextView f16751i;

    /* renamed from: j */
    private TextView f16752j;

    /* renamed from: k */
    private TextView f16753k;

    /* renamed from: l */
    private RadioGroup f16754l;

    /* renamed from: m */
    private ExamActivity f16755m;

    /* renamed from: com.bxkj.student.home.teaching.exam.formal.CheckboxExamFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4458a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a */
        final /* synthetic */ Map f16756a;

        C4458a(final Map val$answer) {
            this.f16756a = val$answer;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            this.f16756a.put("icChecked", Boolean.valueOf(isChecked));
            if (isChecked) {
                CheckboxExamFragment.this.f16755m.f16774l.setEnabled(true);
                CheckboxExamFragment.this.f16755m.f16775m.setEnabled(true);
                CheckboxExamFragment.this.f16755m.f16770M = true;
            }
        }
    }

    /* renamed from: O */
    public void m42325O() {
        if (this.f16755m.f16768K != 1) {
            for (int i = 0; i < this.f16754l.getChildCount(); i++) {
                CheckBox checkBox = (CheckBox) this.f16754l.getChildAt(i);
                checkBox.setFocusable(false);
                checkBox.setFocusableInTouchMode(false);
                checkBox.setClickable(false);
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
        this.f16750h = (TextView) m57916c(C4215R.C4219id.tv_question);
        this.f16754l = (RadioGroup) m57916c(C4215R.C4219id.rg_answer);
        this.f16752j = (TextView) m57916c(C4215R.C4219id.tv_index);
        this.f16753k = (TextView) m57916c(2131233146);
        TextView textView = (TextView) m57916c(2131233211);
        this.f16751i = textView;
        textView.setText("多选");
        int i = getArguments().getInt("index");
        this.f16755m = (ExamActivity) getActivity();
        Map<String, Object> map = ((SeralizableMap) getArguments().getSerializable("seralizableMap")).getMap();
        TextView textView2 = this.f16752j;
        textView2.setText((i + 1) + "");
        this.f16750h.setText(Html.fromHtml(JsonParse.getString(map, "questionName")));
        TextView textView3 = this.f16753k;
        textView3.setText("(" + JsonParse.getString(map, "score") + ")分");
        this.f16754l.removeAllViews();
        boolean z = false;
        for (Map map2 : (List) map.get("answers")) {
            CheckBox checkBox = new CheckBox(this.f1678e);
            checkBox.setTextSize(2, 16.0f);
            checkBox.setText(JsonParse.getString(map2, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map2, "answerOption"))));
            this.f16754l.addView(checkBox);
            checkBox.setChecked(map2.containsKey("icChecked") && ((Boolean) map2.get("icChecked")).booleanValue());
            checkBox.setOnCheckedChangeListener(new C4458a(map2));
            if (map2.containsKey("icChecked") && ((Boolean) map2.get("icChecked")).booleanValue()) {
                z = true;
            }
        }
        if (z || JsonParse.getBoolean(map, "timeFinish")) {
            m42325O();
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
