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
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class RadioExamFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private TextView f20179h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f20180i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f20181j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f20182k;

    /* renamed from: l  reason: collision with root package name */
    private RadioGroup f20183l;

    /* renamed from: m  reason: collision with root package name */
    private ExamActivity f20184m;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f20185a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f20186b;

        a(final Map val$data, final List val$answers) {
            this.f20185a = val$data;
            this.f20186b = val$answers;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            this.f20185a.put("checkAnswerId", JsonParse.getString((Map) this.f20186b.get(RadioExamFragment.this.f20183l.indexOfChild(RadioExamFragment.this.f20183l.findViewById(checkedId))), "answerId"));
            RadioExamFragment.this.f20184m.f20150l.setEnabled(true);
            RadioExamFragment.this.f20184m.f20151m.setEnabled(true);
            RadioExamFragment.this.f20184m.M = true;
        }
    }

    public void P() {
        if (this.f20184m.K != 1) {
            for (int i4 = 0; i4 < this.f20183l.getChildCount(); i4++) {
                RadioButton radioButton = (RadioButton) this.f20183l.getChildAt(i4);
                radioButton.setClickable(false);
                radioButton.setFocusable(false);
                radioButton.setFocusableInTouchMode(false);
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
        this.f20179h = (TextView) c(2131233112);
        this.f20183l = (RadioGroup) c(2131232490);
        this.f20181j = (TextView) c(2131233002);
        this.f20182k = (TextView) c(2131233146);
        this.f20180i = (TextView) c(2131233211);
        int i4 = getArguments().getInt("index");
        this.f20184m = (ExamActivity) getActivity();
        Map<String, Object> map = ((SeralizableMap) getArguments().getSerializable("seralizableMap")).getMap();
        TextView textView = this.f20181j;
        textView.setText((i4 + 1) + "");
        this.f20179h.setText(Html.fromHtml(JsonParse.getString(map, "questionName")));
        TextView textView2 = this.f20182k;
        textView2.setText("(" + JsonParse.getString(map, "score") + ")\u5206");
        List<Map> list = (List) map.get("answers");
        this.f20183l.removeAllViews();
        if ("0".equals(JsonParse.getString(map, "questionType"))) {
            this.f20180i.setText("\u5355\u9009");
        } else if ("1".equals(JsonParse.getString(map, "questionType"))) {
            this.f20180i.setText("\u591a\u9009");
        } else if ("3".equals(JsonParse.getString(map, "questionType"))) {
            this.f20180i.setText("\u5224\u65ad");
        }
        for (Map map2 : list) {
            RadioButton radioButton = new RadioButton(this.f1665e);
            radioButton.setTextSize(2, 16.0f);
            radioButton.setText(JsonParse.getString(map2, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map2, "answerOption"))));
            this.f20183l.addView(radioButton);
            if (JsonParse.getString(map, "checkAnswerId").equals(JsonParse.getString(map2, "answerId"))) {
                radioButton.setChecked(true);
            } else {
                radioButton.setChecked(false);
            }
        }
        if (!TextUtils.isEmpty(JsonParse.getString(map, "checkAnswerId")) || JsonParse.getBoolean(map, "timeFinish")) {
            P();
        }
        this.f20183l.setOnCheckedChangeListener(new a(map, list));
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427627;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
