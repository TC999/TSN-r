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
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CheckboxExamFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private TextView f20140h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f20141i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f20142j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f20143k;

    /* renamed from: l  reason: collision with root package name */
    private RadioGroup f20144l;

    /* renamed from: m  reason: collision with root package name */
    private ExamActivity f20145m;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f20146a;

        a(final Map val$answer) {
            this.f20146a = val$answer;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            this.f20146a.put("icChecked", Boolean.valueOf(isChecked));
            if (isChecked) {
                CheckboxExamFragment.this.f20145m.f20150l.setEnabled(true);
                CheckboxExamFragment.this.f20145m.f20151m.setEnabled(true);
                CheckboxExamFragment.this.f20145m.M = true;
            }
        }
    }

    public void O() {
        if (this.f20145m.K != 1) {
            for (int i4 = 0; i4 < this.f20144l.getChildCount(); i4++) {
                CheckBox checkBox = (CheckBox) this.f20144l.getChildAt(i4);
                checkBox.setFocusable(false);
                checkBox.setFocusableInTouchMode(false);
                checkBox.setClickable(false);
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
        this.f20140h = (TextView) c(2131233112);
        this.f20144l = (RadioGroup) c(2131232490);
        this.f20142j = (TextView) c(2131233002);
        this.f20143k = (TextView) c(2131233146);
        TextView textView = (TextView) c(2131233211);
        this.f20141i = textView;
        textView.setText("\u591a\u9009");
        int i4 = getArguments().getInt("index");
        this.f20145m = (ExamActivity) getActivity();
        Map<String, Object> map = ((SeralizableMap) getArguments().getSerializable("seralizableMap")).getMap();
        TextView textView2 = this.f20142j;
        textView2.setText((i4 + 1) + "");
        this.f20140h.setText(Html.fromHtml(JsonParse.getString(map, "questionName")));
        TextView textView3 = this.f20143k;
        textView3.setText("(" + JsonParse.getString(map, "score") + ")\u5206");
        this.f20144l.removeAllViews();
        boolean z3 = false;
        for (Map map2 : (List) map.get("answers")) {
            CheckBox checkBox = new CheckBox(this.f1665e);
            checkBox.setTextSize(2, 16.0f);
            checkBox.setText(JsonParse.getString(map2, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map2, "answerOption"))));
            this.f20144l.addView(checkBox);
            checkBox.setChecked(map2.containsKey("icChecked") && ((Boolean) map2.get("icChecked")).booleanValue());
            checkBox.setOnCheckedChangeListener(new a(map2));
            if (map2.containsKey("icChecked") && ((Boolean) map2.get("icChecked")).booleanValue()) {
                z3 = true;
            }
        }
        if (z3 || JsonParse.getBoolean(map, "timeFinish")) {
            O();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427627;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
