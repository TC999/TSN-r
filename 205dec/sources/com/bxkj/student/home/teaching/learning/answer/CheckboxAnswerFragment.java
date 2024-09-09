package com.bxkj.student.home.teaching.learning.answer;

import android.text.Html;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.http.JsonParse;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class CheckboxAnswerFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private TextView f20590h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f20591i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f20592j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f20593k;

    /* renamed from: l  reason: collision with root package name */
    private RadioGroup f20594l;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f20595a;

        a(final Map val$answer) {
            this.f20595a = val$answer;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            this.f20595a.put("icChecked", Boolean.valueOf(isChecked));
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
        this.f20590h = (TextView) c(2131233112);
        this.f20594l = (RadioGroup) c(2131232490);
        this.f20592j = (TextView) c(2131233002);
        this.f20593k = (TextView) c(2131233146);
        TextView textView = (TextView) c(2131233211);
        this.f20591i = textView;
        textView.setText("\u591a\u9009");
        int i4 = getArguments().getInt("index");
        Map<String, Object> map = ((AnswerActivity) getActivity()).J0().get(i4);
        TextView textView2 = this.f20592j;
        textView2.setText((i4 + 1) + "");
        this.f20590h.setText(Html.fromHtml(JsonParse.getString(map, "questionName")));
        TextView textView3 = this.f20593k;
        textView3.setText("(" + JsonParse.getString(map, "score") + ")\u5206");
        this.f20594l.removeAllViews();
        for (Map map2 : (List) map.get("answers")) {
            CheckBox checkBox = new CheckBox(this.f1665e);
            checkBox.setTextSize(2, 16.0f);
            checkBox.setText(JsonParse.getString(map2, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map2, "answerOption"))));
            this.f20594l.addView(checkBox);
            checkBox.setChecked(map2.containsKey("icChecked") && ((Boolean) map2.get("icChecked")).booleanValue());
            checkBox.setOnCheckedChangeListener(new a(map2));
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
