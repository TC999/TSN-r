package com.bxkj.student.home.teaching.evaluateteacher;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.C4215R;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class EvaluateFragment extends BaseFragment {

    /* renamed from: h */
    private TextView f16692h;

    /* renamed from: i */
    private RadioGroup f16693i;

    /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4434a implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a */
        final /* synthetic */ Map f16694a;

        /* renamed from: b */
        final /* synthetic */ List f16695b;

        C4434a(final Map val$data, final List val$answers) {
            this.f16694a = val$data;
            this.f16695b = val$answers;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            this.f16694a.put("checkScore", JsonParse.getString((Map) this.f16695b.get(EvaluateFragment.this.f16693i.indexOfChild(EvaluateFragment.this.f16693i.findViewById(checkedId))), "score"));
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
        this.f16692h = (TextView) m57916c(C4215R.C4219id.tv_question);
        this.f16693i = (RadioGroup) m57916c(C4215R.C4219id.rg_answer);
        int i = getArguments().getInt("index");
        Map<String, Object> map = ((EvaluateActivity) getActivity()).m42396w0().get(i);
        TextView textView = this.f16692h;
        textView.setText((i + 1) + "." + JsonParse.getString(map, "content"));
        List<Map> list = (List) map.get("scores");
        this.f16693i.removeAllViews();
        for (Map map2 : list) {
            RadioButton radioButton = new RadioButton(this.f1678e);
            radioButton.setTextSize(2, 16.0f);
            radioButton.setText(JsonParse.getString(map2, "score"));
            this.f16693i.addView(radioButton);
            if (JsonParse.getString(map, "checkScore").equals(JsonParse.getString(map2, "score"))) {
                radioButton.setChecked(true);
            } else {
                radioButton.setChecked(false);
            }
        }
        this.f16693i.setOnCheckedChangeListener(new C4434a(map, list));
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_evaluate_teacher;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
