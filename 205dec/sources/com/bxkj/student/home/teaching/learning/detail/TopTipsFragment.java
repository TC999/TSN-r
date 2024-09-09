package com.bxkj.student.home.teaching.learning.detail;

import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseFragment;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class TopTipsFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private TextView f20643h;

    public String N(long recordingTime) {
        long j4 = recordingTime / 60;
        if (j4 < 10) {
            return "0" + j4;
        }
        return String.valueOf(j4);
    }

    public String O(long recordingTime) {
        long j4 = recordingTime % 60;
        if (j4 < 10) {
            return "0" + j4;
        }
        return String.valueOf(j4);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        if (getArguments().containsKey("duration")) {
            String string = getArguments().getString("duration");
            String string2 = getArguments().getString("integral");
            this.f20643h.setText("\u672c\u8d44\u6e90\u65f6\u957f" + N(Long.parseLong(string)) + "\u5206" + O(Long.parseLong(string)) + "\u79d2\uff0c\u79ef\u5206" + string2 + "\u5206\uff0c\u5e95\u90e8\u5012\u8ba1\u65f6\u7ed3\u675f\u540e\uff0c\u65b9\u53ef\u79ef\u5206\u3002\u63d0\u524d\u9000\u51fa\u8d44\u6e90\u89c2\u770b\u9875\u9762\uff0c\u4e0d\u79ef\u5206\uff0c\u4e0d\u663e\u793a\u8fdb\u5ea6\u6761\u3002\u53ea\u6709\u7b2c\u4e00\u6b21\u79ef\u5206\u3002");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f20643h = (TextView) c(2131232939);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427632;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }
}
