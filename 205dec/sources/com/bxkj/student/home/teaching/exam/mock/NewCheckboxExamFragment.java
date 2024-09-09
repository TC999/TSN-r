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
public class NewCheckboxExamFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private TextView f20205h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f20206i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f20207j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f20208k;

    /* renamed from: l  reason: collision with root package name */
    private RadioGroup f20209l;

    /* renamed from: m  reason: collision with root package name */
    private List<Map<String, Object>> f20210m;

    /* renamed from: n  reason: collision with root package name */
    private Map<String, Object> f20211n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f20212a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ NewExamActivity f20213b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ CheckBox f20214c;

        a(final Map val$answer, final NewExamActivity val$newExamActivity, final CheckBox val$checkBox) {
            this.f20212a = val$answer;
            this.f20213b = val$newExamActivity;
            this.f20214c = val$checkBox;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            Context context;
            int i4;
            this.f20212a.put("icChecked", Boolean.valueOf(isChecked));
            if (isChecked) {
                this.f20213b.f20220o.setEnabled(true);
                this.f20213b.f20221p.setEnabled(true);
            }
            String obj = this.f20214c.getTag().toString();
            CheckBox checkBox = this.f20214c;
            if ("0".equals(obj)) {
                context = ((BaseFragment) NewCheckboxExamFragment.this).f1665e;
                i4 = 2131165440;
            } else {
                context = ((BaseFragment) NewCheckboxExamFragment.this).f1665e;
                i4 = 2131165439;
            }
            checkBox.setBackground(ContextCompat.getDrawable(context, i4));
            this.f20214c.setFocusable(false);
            this.f20214c.setFocusableInTouchMode(false);
            this.f20214c.setClickable(false);
        }
    }

    public void P() {
        if (this.f20209l == null) {
            return;
        }
        for (int i4 = 0; i4 < this.f20209l.getChildCount(); i4++) {
            CheckBox checkBox = (CheckBox) this.f20209l.getChildAt(i4);
            checkBox.setFocusable(false);
            checkBox.setFocusableInTouchMode(false);
            checkBox.setClickable(false);
            if ("0".equals(checkBox.getTag().toString())) {
                checkBox.setBackground(ContextCompat.getDrawable(this.f1665e, 2131165440));
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
        this.f20205h = (TextView) c(2131233112);
        this.f20209l = (RadioGroup) c(2131232490);
        this.f20207j = (TextView) c(2131233002);
        this.f20208k = (TextView) c(2131233146);
        TextView textView = (TextView) c(2131233211);
        this.f20206i = textView;
        textView.setText("\u591a\u9009");
        int i5 = getArguments().getInt("index");
        NewExamActivity newExamActivity = (NewExamActivity) getActivity();
        Map<String, Object> map = ((SeralizableMap) getArguments().getSerializable("seralizableMap")).getMap();
        TextView textView2 = this.f20207j;
        textView2.setText((i5 + 1) + "");
        this.f20205h.setText(Html.fromHtml(JsonParse.getString(map, "questionName")));
        TextView textView3 = this.f20208k;
        textView3.setText("(" + JsonParse.getString(map, "score") + ")\u5206");
        this.f20210m = (List) map.get("answers");
        this.f20209l.removeAllViews();
        boolean z3 = false;
        for (Map<String, Object> map2 : this.f20210m) {
            CheckBox checkBox = new CheckBox(this.f1665e);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, d.a(this.f1665e, 40.0f));
            layoutParams.topMargin = d.a(this.f1665e, 10.0f);
            layoutParams.leftMargin = d.a(this.f1665e, 10.0f);
            checkBox.setPadding(d.a(this.f1665e, 10.0f), 0, 0, 0);
            checkBox.setLayoutParams(layoutParams);
            checkBox.setTextSize(2, 16.0f);
            checkBox.setText(JsonParse.getString(map2, DomainCampaignEx.ROVER_KEY_MARK) + "." + ((Object) Html.fromHtml(JsonParse.getString(map2, "answerOption"))));
            checkBox.setTag(JsonParse.getString(map2, "isRight"));
            this.f20209l.addView(checkBox);
            boolean z4 = map2.containsKey("icChecked") && ((Boolean) map2.get("icChecked")).booleanValue();
            if (z4) {
                z3 = true;
            }
            checkBox.setChecked(z4);
            checkBox.setOnCheckedChangeListener(new a(map2, newExamActivity, checkBox));
        }
        if (z3 || JsonParse.getBoolean(map, "timeFinish")) {
            for (int i6 = 0; i6 < this.f20209l.getChildCount(); i6++) {
                CheckBox checkBox2 = (CheckBox) this.f20209l.getChildAt(i6);
                checkBox2.setFocusable(false);
                checkBox2.setFocusableInTouchMode(false);
                checkBox2.setClickable(false);
                String obj = checkBox2.getTag().toString();
                if (JsonParse.getBoolean(this.f20210m.get(i6), "icChecked")) {
                    if ("0".equals(obj)) {
                        context = this.f1665e;
                        i4 = 2131165440;
                    } else {
                        context = this.f1665e;
                        i4 = 2131165439;
                    }
                    checkBox2.setBackground(ContextCompat.getDrawable(context, i4));
                }
            }
            newExamActivity.f20220o.setEnabled(true);
            newExamActivity.f20221p.setEnabled(true);
            P();
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
