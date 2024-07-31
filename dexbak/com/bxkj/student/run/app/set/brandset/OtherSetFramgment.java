package com.bxkj.student.run.app.set.brandset;

import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseFragment;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class OtherSetFramgment extends BaseFragment {

    /* renamed from: h */
    private TextView f19404h;

    /* renamed from: N */
    private void m39753N(SpannableString spannableString, String text) {
        int indexOf = spannableString.toString().indexOf(text);
        spannableString.setSpan(new StyleSpan(1), indexOf, text.length() + indexOf, 33);
    }

    /* renamed from: O */
    private void m39752O(SpannableString spannableString, String text) {
        int lastIndexOf = spannableString.toString().lastIndexOf(text);
        spannableString.setSpan(new StyleSpan(1), lastIndexOf, text.length() + lastIndexOf, 33);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    protected void mo39444e() {
        SpannableString spannableString = new SpannableString(getString(C4215R.C4224string.set_hint));
        m39753N(spannableString, "【" + getString(2131820604) + "】");
        m39752O(spannableString, "【" + getString(2131820604) + "】");
        m39753N(spannableString, "【后台运行】");
        m39753N(spannableString, "【自启动】");
        m39753N(spannableString, "【后台定位】");
        m39753N(spannableString, "【后台联网】");
        this.f19404h.setText(spannableString);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f19404h = (TextView) m57916c(C4215R.C4219id.tv_set);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_other_set;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
