package com.bxkj.student.home.teaching.exam.mock;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
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
public class NewCheckboxExamFragment extends BaseFragment {

    /* renamed from: h */
    private TextView f16829h;

    /* renamed from: i */
    private TextView f16830i;

    /* renamed from: j */
    private TextView f16831j;

    /* renamed from: k */
    private TextView f16832k;

    /* renamed from: l */
    private RadioGroup f16833l;

    /* renamed from: m */
    private List<Map<String, Object>> f16834m;

    /* renamed from: n */
    private Map<String, Object> f16835n;

    /* renamed from: com.bxkj.student.home.teaching.exam.mock.NewCheckboxExamFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4482a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a */
        final /* synthetic */ Map f16836a;

        /* renamed from: b */
        final /* synthetic */ NewExamActivity f16837b;

        /* renamed from: c */
        final /* synthetic */ CheckBox f16838c;

        C4482a(final Map val$answer, final NewExamActivity val$newExamActivity, final CheckBox val$checkBox) {
            this.f16836a = val$answer;
            this.f16837b = val$newExamActivity;
            this.f16838c = val$checkBox;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Context context;
            int i;
            this.f16836a.put("icChecked", Boolean.valueOf(isChecked));
            if (isChecked) {
                this.f16837b.f16850o.setEnabled(true);
                this.f16837b.f16851p.setEnabled(true);
            }
            String obj = this.f16838c.getTag().toString();
            CheckBox checkBox = this.f16838c;
            if ("0".equals(obj)) {
                context = ((BaseFragment) NewCheckboxExamFragment.this).f1678e;
                i = C4215R.C4218drawable.exam_radio_right;
            } else {
                context = ((BaseFragment) NewCheckboxExamFragment.this).f1678e;
                i = C4215R.C4218drawable.exam_radio_error;
            }
            checkBox.setBackground(ContextCompat.getDrawable(context, i));
            this.f16838c.setFocusable(false);
            this.f16838c.setFocusableInTouchMode(false);
            this.f16838c.setClickable(false);
        }
    }

    /* renamed from: P */
    public void m42242P() {
        if (this.f16833l == null) {
            return;
        }
        for (int i = 0; i < this.f16833l.getChildCount(); i++) {
            CheckBox checkBox = (CheckBox) this.f16833l.getChildAt(i);
            checkBox.setFocusable(false);
            checkBox.setFocusableInTouchMode(false);
            checkBox.setClickable(false);
            if ("0".equals(checkBox.getTag().toString())) {
                checkBox.setBackground(ContextCompat.getDrawable(this.f1678e, C4215R.C4218drawable.exam_radio_right));
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
        this.f16829h = (TextView) m57916c(C4215R.C4219id.tv_question);
        this.f16833l = (RadioGroup) m57916c(C4215R.C4219id.rg_answer);
        this.f16831j = (TextView) m57916c(C4215R.C4219id.tv_index);
        this.f16832k = (TextView) m57916c(2131233146);
        TextView textView = (TextView) m57916c(2131233211);
        this.f16830i = textView;
        textView.setText("多选");
        int i2 = getArguments().getInt("index");
        NewExamActivity newExamActivity = (NewExamActivity) getActivity();
        Map<String, Object> map = ((SeralizableMap) getArguments().getSerializable("seralizableMap")).getMap();
        TextView textView2 = this.f16831j;
        textView2.setText((i2 + 1) + "");
        this.f16829h.setText(Html.fromHtml(JsonParse.getString(map, "questionName")));
        TextView textView3 = this.f16832k;
        textView3.setText("(" + JsonParse.getString(map, "score") + ")分");
        this.f16834m = (List) map.get("answers");
        this.f16833l.removeAllViews();
        boolean z = false;
        for (Map<String, Object> map2 : this.f16834m) {
            CheckBox checkBox = new CheckBox(this.f1678e);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, DisplayUtil.m57760a(this.f1678e, 40.0f));
            layoutParams.topMargin = DisplayUtil.m57760a(this.f1678e, 10.0f);
            layoutParams.leftMargin = DisplayUtil.m57760a(this.f1678e, 10.0f);
            checkBox.setPadding(DisplayUtil.m57760a(this.f1678e, 10.0f), 0, 0, 0);
            checkBox.setLayoutParams(layoutParams);
            checkBox.setTextSize(2, 16.0f);
            checkBox.setText(JsonParse.getString(map2, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map2, "answerOption"))));
            checkBox.setTag(JsonParse.getString(map2, "isRight"));
            this.f16833l.addView(checkBox);
            boolean z2 = map2.containsKey("icChecked") && ((Boolean) map2.get("icChecked")).booleanValue();
            if (z2) {
                z = true;
            }
            checkBox.setChecked(z2);
            checkBox.setOnCheckedChangeListener(new C4482a(map2, newExamActivity, checkBox));
        }
        if (z || JsonParse.getBoolean(map, "timeFinish")) {
            for (int i3 = 0; i3 < this.f16833l.getChildCount(); i3++) {
                CheckBox checkBox2 = (CheckBox) this.f16833l.getChildAt(i3);
                checkBox2.setFocusable(false);
                checkBox2.setFocusableInTouchMode(false);
                checkBox2.setClickable(false);
                String obj = checkBox2.getTag().toString();
                if (JsonParse.getBoolean(this.f16834m.get(i3), "icChecked")) {
                    if ("0".equals(obj)) {
                        context = this.f1678e;
                        i = C4215R.C4218drawable.exam_radio_right;
                    } else {
                        context = this.f1678e;
                        i = C4215R.C4218drawable.exam_radio_error;
                    }
                    checkBox2.setBackground(ContextCompat.getDrawable(context, i));
                }
            }
            newExamActivity.f16850o.setEnabled(true);
            newExamActivity.f16851p.setEnabled(true);
            m42242P();
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
