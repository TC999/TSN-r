package com.bxkj.student.home.teaching.evaluateteacher;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.http.JsonParse;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class EvaluateFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private TextView f20082h;

    /* renamed from: i  reason: collision with root package name */
    private RadioGroup f20083i;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map f20084a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f20085b;

        a(final Map val$data, final List val$answers) {
            this.f20084a = val$data;
            this.f20085b = val$answers;
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            this.f20084a.put("checkScore", JsonParse.getString((Map) this.f20085b.get(EvaluateFragment.this.f20083i.indexOfChild(EvaluateFragment.this.f20083i.findViewById(checkedId))), "score"));
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
        this.f20082h = (TextView) c(2131233112);
        this.f20083i = (RadioGroup) c(2131232490);
        int i4 = getArguments().getInt("index");
        Map<String, Object> map = ((EvaluateActivity) getActivity()).w0().get(i4);
        TextView textView = this.f20082h;
        textView.setText((i4 + 1) + "." + JsonParse.getString(map, "content"));
        List<Map> list = (List) map.get("scores");
        this.f20083i.removeAllViews();
        for (Map map2 : list) {
            RadioButton radioButton = new RadioButton(this.f1665e);
            radioButton.setTextSize(2, 16.0f);
            radioButton.setText(JsonParse.getString(map2, "score"));
            this.f20083i.addView(radioButton);
            if (JsonParse.getString(map, "checkScore").equals(JsonParse.getString(map2, "score"))) {
                radioButton.setChecked(true);
            } else {
                radioButton.setChecked(false);
            }
        }
        this.f20083i.setOnCheckedChangeListener(new a(map, list));
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427626;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
