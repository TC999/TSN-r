package com.bxkj.student.run.app.set.brandset;

import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseFragment;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class OtherSetFramgment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private TextView f22635h;

    private void N(SpannableString spannableString, String text) {
        int indexOf = spannableString.toString().indexOf(text);
        spannableString.setSpan(new StyleSpan(1), indexOf, text.length() + indexOf, 33);
    }

    private void O(SpannableString spannableString, String text) {
        int lastIndexOf = spannableString.toString().lastIndexOf(text);
        spannableString.setSpan(new StyleSpan(1), lastIndexOf, text.length() + lastIndexOf, 33);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        SpannableString spannableString = new SpannableString(getString(2131821305));
        N(spannableString, "\u3010" + getString(2131820604) + "\u3011");
        O(spannableString, "\u3010" + getString(2131820604) + "\u3011");
        N(spannableString, "\u3010\u540e\u53f0\u8fd0\u884c\u3011");
        N(spannableString, "\u3010\u81ea\u542f\u52a8\u3011");
        N(spannableString, "\u3010\u540e\u53f0\u5b9a\u4f4d\u3011");
        N(spannableString, "\u3010\u540e\u53f0\u8054\u7f51\u3011");
        this.f22635h.setText(spannableString);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f22635h = (TextView) c(2131233150);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427639;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
