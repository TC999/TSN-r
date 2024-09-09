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
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.base.utils.d;
import cn.bluemobi.dylan.http.JsonParse;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class NewRadioExamFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private TextView f20256h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f20257i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f20258j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f20259k;

    /* renamed from: l  reason: collision with root package name */
    private RadioGroup f20260l;

    /* renamed from: m  reason: collision with root package name */
    private CountDownTimer f20261m;

    /* renamed from: n  reason: collision with root package name */
    private List<Map<String, Object>> f20262n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f20263a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NewExamActivity f20264b;

        a(final Map val$data, final NewExamActivity val$newExamActivity) {
            this.f20263a = val$data;
            this.f20264b = val$newExamActivity;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            Context context;
            int i4;
            RadioButton radioButton = (RadioButton) NewRadioExamFragment.this.f20260l.findViewById(checkedId);
            this.f20263a.put("checkAnswerId", JsonParse.getString((Map) NewRadioExamFragment.this.f20262n.get(NewRadioExamFragment.this.f20260l.indexOfChild(radioButton)), "answerId"));
            if ("0".equals(radioButton.getTag().toString())) {
                context = ((BaseFragment) NewRadioExamFragment.this).f1665e;
                i4 = 2131165440;
            } else {
                context = ((BaseFragment) NewRadioExamFragment.this).f1665e;
                i4 = 2131165439;
            }
            radioButton.setBackground(ContextCompat.getDrawable(context, i4));
            NewRadioExamFragment.this.R();
            this.f20264b.f20220o.setEnabled(true);
            this.f20264b.f20221p.setEnabled(true);
        }
    }

    public void R() {
        if (this.f20260l == null) {
            return;
        }
        for (int i4 = 0; i4 < this.f20260l.getChildCount(); i4++) {
            RadioButton radioButton = (RadioButton) this.f20260l.getChildAt(i4);
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
        Context context;
        int i4;
        this.f20256h = (TextView) c(2131233112);
        this.f20260l = (RadioGroup) c(2131232490);
        this.f20258j = (TextView) c(2131233002);
        this.f20259k = (TextView) c(2131233146);
        this.f20257i = (TextView) c(2131233211);
        int i5 = getArguments().getInt("index");
        NewExamActivity newExamActivity = (NewExamActivity) getActivity();
        Map<String, Object> map = ((SeralizableMap) getArguments().getSerializable("seralizableMap")).getMap();
        TextView textView = this.f20258j;
        textView.setText((i5 + 1) + "");
        this.f20256h.setText(Html.fromHtml(JsonParse.getString(map, "questionName")));
        TextView textView2 = this.f20259k;
        textView2.setText("(" + JsonParse.getString(map, "score") + ")\u5206");
        this.f20262n = (List) map.get("answers");
        this.f20260l.removeAllViews();
        if ("0".equals(JsonParse.getString(map, "questionType"))) {
            this.f20257i.setText("\u5355\u9009");
        } else if ("1".equals(JsonParse.getString(map, "questionType"))) {
            this.f20257i.setText("\u591a\u9009");
        } else if ("3".equals(JsonParse.getString(map, "questionType"))) {
            this.f20257i.setText("\u5224\u65ad");
        }
        for (Map<String, Object> map2 : this.f20262n) {
            RadioButton radioButton = new RadioButton(this.f1665e);
            radioButton.setButtonDrawable(2131165441);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, d.a(this.f1665e, 40.0f));
            layoutParams.topMargin = d.a(this.f1665e, 5.0f);
            layoutParams.leftMargin = d.a(this.f1665e, 10.0f);
            radioButton.setPadding(d.a(this.f1665e, 10.0f), 0, 0, 0);
            radioButton.setLayoutParams(layoutParams);
            String string = JsonParse.getString(map2, "isRight");
            radioButton.setTag(string);
            radioButton.setTextSize(2, 16.0f);
            radioButton.setText(JsonParse.getString(map2, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map2, "answerOption"))));
            this.f20260l.addView(radioButton);
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
        this.f20260l.setOnCheckedChangeListener(new a(map, newExamActivity));
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427627;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
