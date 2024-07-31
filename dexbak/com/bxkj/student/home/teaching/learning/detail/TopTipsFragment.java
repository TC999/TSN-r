package com.bxkj.student.home.teaching.learning.detail;

import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseFragment;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TopTipsFragment extends BaseFragment {

    /* renamed from: h */
    private TextView f17295h;

    /* renamed from: N */
    public String m41821N(long recordingTime) {
        long j = recordingTime / 60;
        if (j < 10) {
            return "0" + j;
        }
        return String.valueOf(j);
    }

    /* renamed from: O */
    public String m41820O(long recordingTime) {
        long j = recordingTime % 60;
        if (j < 10) {
            return "0" + j;
        }
        return String.valueOf(j);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    protected void mo39444e() {
        if (getArguments().containsKey("duration")) {
            String string = getArguments().getString("duration");
            String string2 = getArguments().getString("integral");
            this.f17295h.setText("本资源时长" + m41821N(Long.parseLong(string)) + "分" + m41820O(Long.parseLong(string)) + "秒，积分" + string2 + "分，底部倒计时结束后，方可积分。提前退出资源观看页面，不积分，不显示进度条。只有第一次积分。");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f17295h = (TextView) m57916c(2131232939);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_learn_top_tips;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }
}
