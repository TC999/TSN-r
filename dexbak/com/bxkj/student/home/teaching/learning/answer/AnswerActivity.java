package com.bxkj.student.home.teaching.learning.answer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.DisplayUtil;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.CountDownTimeView;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.view.CustomViewPager;
import com.bxkj.student.home.teaching.learning.LearningApiService;
import com.bxkj.student.home.teaching.learning.answer.AnswerActivity;
import com.bxkj.student.home.teaching.learning.detail.backup.H5Activity;
import com.bxkj.student.home.teaching.learning.detail.backup.VideoPlayActivity;
import com.kuaishou.weapon.p205p0.C7193bi;
import com.orhanobut.logger.C11792j;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AnswerActivity extends BaseActivity {

    /* renamed from: k */
    private TextView f17199k;

    /* renamed from: l */
    private TextView f17200l;

    /* renamed from: m */
    private CountDownTimeView f17201m;

    /* renamed from: n */
    private CustomViewPager f17202n;

    /* renamed from: o */
    public Button f17203o;

    /* renamed from: p */
    public Button f17204p;

    /* renamed from: q */
    private Button f17205q;

    /* renamed from: r */
    private TextView f17206r;

    /* renamed from: s */
    private RelativeLayout f17207s;

    /* renamed from: t */
    private CommonAdapter<Map<String, Object>> f17208t;

    /* renamed from: u */
    private CountDownTimer f17209u;

    /* renamed from: v */
    private ConnectivityManager f17210v;

    /* renamed from: w */
    private C4604l f17211w;

    /* renamed from: x */
    private String f17212x;

    /* renamed from: y */
    private int f17213y = 60000;

    /* renamed from: z */
    private List<Map<String, Object>> f17214z = new ArrayList();

    /* renamed from: A */
    private List<Fragment> f17197A = new ArrayList();

    /* renamed from: B */
    private boolean f17198B = true;

    /* renamed from: com.bxkj.student.home.teaching.learning.answer.AnswerActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4591a implements AdapterView.OnItemClickListener {

        /* renamed from: a */
        final /* synthetic */ PopupWindow f17215a;

        C4591a(final PopupWindow val$popupWindow) {
            this.f17215a = val$popupWindow;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            AnswerActivity.this.f17202n.setCurrentItem(position);
            this.f17215a.dismiss();
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.learning.answer.AnswerActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4592b implements PopupWindow.OnDismissListener {

        /* renamed from: a */
        final /* synthetic */ FrameLayout f17217a;

        C4592b(final FrameLayout val$outsideView) {
            this.f17217a = val$outsideView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            FrameLayout frameLayout = this.f17217a;
            if (frameLayout != null) {
                frameLayout.setForeground(new ColorDrawable(0));
            }
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.learning.answer.AnswerActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4593c implements BaseActivity.InterfaceC1107c {
        C4593c() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            AnswerActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.answer.AnswerActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4594d implements iOSTwoButtonDialog.RightButtonOnClick {
        C4594d() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            AnswerActivity.this.finish();
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.learning.answer.AnswerActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4595e extends CommonAdapter<Map<String, Object>> {
        C4595e(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57874J(2131233051, String.valueOf(holder.m57864f() + 1));
            boolean equals = "1".equals(JsonParse.getString(stringObjectMap, "questionType"));
            int i = C4215R.C4218drawable.round_cicler_gray;
            if (equals) {
                List<Map<String, Object>> list = JsonParse.getList(stringObjectMap, "answers");
                ArrayList arrayList = new ArrayList();
                for (Map<String, Object> map : list) {
                    if (map.containsKey("icChecked") && ((Boolean) map.get("icChecked")).booleanValue()) {
                        arrayList.add(JsonParse.getString(map, "answerId"));
                    }
                }
                if (!arrayList.isEmpty()) {
                    i = C4215R.C4218drawable.dot_cicler_blue;
                }
                holder.m57858l(2131233051, i);
                holder.m57873K(2131233051, arrayList.isEmpty() ? AnswerActivity.this.getResources().getColor(2131034190) : AnswerActivity.this.getResources().getColor(2131034196));
                return;
            }
            if (!JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty()) {
                i = C4215R.C4218drawable.dot_cicler_blue;
            }
            holder.m57858l(2131233051, i);
            holder.m57873K(2131233051, JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty() ? AnswerActivity.this.getResources().getColor(2131034190) : AnswerActivity.this.getResources().getColor(2131034196));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.answer.AnswerActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4597g extends FragmentPagerAdapter {
        C4597g(FragmentManager fm) {
            super(fm);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return AnswerActivity.this.f17197A.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return (Fragment) AnswerActivity.this.f17197A.get(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.answer.AnswerActivity$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class CountDownTimerC4598h extends CountDownTimer {

        /* renamed from: a */
        final /* synthetic */ SimpleDateFormat f17224a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        CountDownTimerC4598h(long millisInFuture, long countDownInterval, final SimpleDateFormat val$simpleDateFormat) {
            super(millisInFuture, countDownInterval);
            this.f17224a = val$simpleDateFormat;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            AnswerActivity.this.f17201m.m43529i(60, 0);
            ((Map) AnswerActivity.this.f17214z.get(AnswerActivity.this.f17202n.getCurrentItem())).put("timeFinish", Boolean.TRUE);
            Fragment fragment = (Fragment) AnswerActivity.this.f17197A.get(AnswerActivity.this.f17202n.getCurrentItem());
            if (fragment instanceof RadioAnswerFragment) {
                ((RadioAnswerFragment) fragment).m41873R();
                AnswerActivity.this.f17203o.setEnabled(true);
                AnswerActivity.this.f17204p.setEnabled(true);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            AnswerActivity.this.f17201m.m43529i(60, ((int) millisUntilFinished) / 1000);
            AnswerActivity.this.f17206r.setText(this.f17224a.format(Long.valueOf(millisUntilFinished)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.answer.AnswerActivity$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4599i implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ boolean f17226a;

        /* renamed from: b */
        final /* synthetic */ List f17227b;

        /* renamed from: c */
        final /* synthetic */ List f17228c;

        C4599i(final boolean val$autoCommit, final List val$radioData, final List val$checkData) {
            this.f17226a = val$autoCommit;
            this.f17227b = val$radioData;
            this.f17228c = val$checkData;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            AnswerActivity.this.m41907G0(this.f17226a, this.f17227b, this.f17228c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.answer.AnswerActivity$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4600j extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ boolean f17230a;

        /* renamed from: com.bxkj.student.home.teaching.learning.answer.AnswerActivity$j$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class View$OnClickListenerC4601a implements View.OnClickListener {
            View$OnClickListenerC4601a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AnswerActivity.this.finish();
            }
        }

        /* renamed from: com.bxkj.student.home.teaching.learning.answer.AnswerActivity$j$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class View$OnClickListenerC4602b implements View.OnClickListener {
            View$OnClickListenerC4602b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                AnswerActivity.this.finish();
            }
        }

        C4600j(final boolean val$autoCommit) {
            this.f17230a = val$autoCommit;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public /* synthetic */ void m41878b(View view) {
            H5Activity h5Activity = (H5Activity) AppManager.m57776n().getActivity(H5Activity.class);
            VideoPlayActivity videoPlayActivity = (VideoPlayActivity) AppManager.m57776n().getActivity(VideoPlayActivity.class);
            if (h5Activity != null) {
                h5Activity.m41781n0();
            }
            if (videoPlayActivity != null) {
                videoPlayActivity.m41765w0();
            }
            AnswerActivity.this.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            if (this.f17230a) {
                new iOSOneButtonDialog(((BaseActivity) AnswerActivity.this).f1669h).setButtonOnClickListener(new View$OnClickListenerC4602b()).setMessage("时间已到，自动交卷失败，请重新考试").show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) AnswerActivity.this).f1669h).setButtonOnClickListener(new View$OnClickListenerC4601a()).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            String str = this.f17230a ? "时间已到，已经为您自动交卷成功" : "交卷成功";
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((BaseActivity) AnswerActivity.this).f1669h);
            iosonebuttondialog.setCancelable(false);
            iosonebuttondialog.setMessage(str).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.answer.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnswerActivity.C4600j.this.m41878b(view);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.answer.AnswerActivity$k */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4603k implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        private int f17234a;

        C4603k() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            this.f17234a = state;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (this.f17234a == 1 && positionOffsetPixels == 0) {
                if (position == 0) {
                    AnswerActivity.this.m57919h0("已经是第一题了");
                } else if (position == AnswerActivity.this.f17202n.getAdapter().getCount() - 1) {
                    AnswerActivity.this.m57919h0("已经是最后一题了");
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            AnswerActivity answerActivity = AnswerActivity.this;
            answerActivity.setTitle((position + 1) + "/" + AnswerActivity.this.f17202n.getAdapter().getCount());
            if (AnswerActivity.this.f17209u != null) {
                AnswerActivity.this.f17209u.cancel();
            }
            AnswerActivity.this.f17201m.m43529i(60, 0);
            if (!JsonParse.getBoolean((Map) AnswerActivity.this.f17214z.get(AnswerActivity.this.f17202n.getCurrentItem()), "timeFinish") && TextUtils.isEmpty(JsonParse.getString((Map) AnswerActivity.this.f17214z.get(AnswerActivity.this.f17202n.getCurrentItem()), "checkAnswerId"))) {
                AnswerActivity.this.f17203o.setEnabled(false);
                AnswerActivity.this.f17204p.setEnabled(false);
                AnswerActivity.this.m41899O0();
            }
            TextView textView = AnswerActivity.this.f17200l;
            textView.setText("出题人：" + JsonParse.getString((Map) AnswerActivity.this.f17214z.get(position), "questionsSetter"));
            TextView textView2 = AnswerActivity.this.f17199k;
            textView2.setText("课程名称：" + JsonParse.getString((Map) AnswerActivity.this.f17214z.get(position), "curriculum"));
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.learning.answer.AnswerActivity$l */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private class C4604l extends BroadcastReceiver {
        private C4604l() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
        }
    }

    /* renamed from: D0 */
    private void m41910D0() {
        this.f17202n.addOnPageChangeListener(new C4603k());
    }

    /* renamed from: E0 */
    private void m41909E0() {
        m41906H0(true);
    }

    /* renamed from: F0 */
    private String m41908F0(long milliSecondTime) {
        String valueOf;
        String valueOf2;
        String valueOf3;
        long j = milliSecondTime / C7193bi.f24584s;
        long j2 = milliSecondTime - (((j * 60) * 60) * 1000);
        long j3 = j2 / 60000;
        long j4 = (j2 - ((j3 * 60) * 1000)) / 1000;
        if (j4 >= 60) {
            j4 %= 60;
            j3 += j4 / 60;
        }
        if (j3 >= 60) {
            j3 %= 60;
            j += j3 / 60;
        }
        if (j < 10) {
            valueOf = "0" + String.valueOf(j);
        } else {
            valueOf = String.valueOf(j);
        }
        if (j3 < 10) {
            valueOf2 = "0" + String.valueOf(j3);
        } else {
            valueOf2 = String.valueOf(j3);
        }
        if (j4 < 10) {
            valueOf3 = "0" + String.valueOf(j4);
        } else {
            valueOf3 = String.valueOf(j4);
        }
        return valueOf + ":" + valueOf2 + ":" + valueOf3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: G0 */
    public void m41907G0(final boolean autoCommit, List<Map<String, Object>> radioData, List<Map<String, Object>> checkData) {
        String jSONString = JSON.toJSONString(radioData);
        String jSONString2 = JSON.toJSONString(checkData);
        C11792j.m20465h(jSONString);
        C11792j.m20465h(jSONString2);
        Http.with(this.f1669h).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41631k(LoginUser.getLoginUser().getUserId(), jSONString, jSONString2)).setDataListener(new C4600j(autoCommit));
    }

    /* renamed from: H0 */
    private void m41906H0(final boolean autoCommit) {
        List<Map<String, Object>> arrayList = new ArrayList<>();
        List<Map<String, Object>> arrayList2 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f17214z.size(); i++) {
            Map<String, Object> map = this.f17214z.get(i);
            if ("1".equals(JsonParse.getString(this.f17214z.get(i), "questionType"))) {
                ArrayList arrayList3 = new ArrayList();
                Iterator it = ((List) this.f17214z.get(i).get("answers")).iterator();
                while (it.hasNext()) {
                    Map map2 = (Map) it.next();
                    Iterator it2 = it;
                    if (map2.containsKey("icChecked") && ((Boolean) map2.get("icChecked")).booleanValue()) {
                        arrayList3.add(JsonParse.getString(map2, "answerId"));
                    }
                    it = it2;
                }
                Map<String, Object> arrayMap = new ArrayMap<>();
                arrayMap.put("question", JsonParse.getString(map, "questionId"));
                arrayMap.put("answers", arrayList3);
                arrayMap.put("scoreId", JsonParse.getString(map, "scoreId"));
                arrayList2.add(arrayMap);
                if (arrayList3.isEmpty() && !autoCommit) {
                    sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                    sb.append(String.valueOf(i + 1));
                }
            } else {
                String string = JsonParse.getString(map, "checkAnswerId");
                if (string.isEmpty() && !autoCommit) {
                    sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                    sb.append(String.valueOf(i + 1));
                }
                Map<String, Object> arrayMap2 = new ArrayMap<>();
                arrayMap2.put("question", JsonParse.getString(map, "questionId"));
                arrayMap2.put("answers", string);
                arrayMap2.put("scoreId", JsonParse.getString(map, "scoreId"));
                arrayList.add(arrayMap2);
            }
        }
        if (!autoCommit) {
            new iOSTwoButtonDialog(this.f1669h).setMessage(TextUtils.isEmpty(sb) ? "确定要提交试卷吗？" : "您还有第" + sb.toString() + "题未作答，是否要提交试卷？").setLeftButtonText("继续答题").setRightButtonText("直接交卷").setRightButtonOnClickListener(new C4599i(autoCommit, arrayList, arrayList2)).show();
            return;
        }
        m41907G0(autoCommit, arrayList, arrayList2);
    }

    /* renamed from: I0 */
    private void m41905I0() {
        Http.with(this.f1669h).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((LearningApiService) Http.getApiService(LearningApiService.class)).m41618x(LoginUser.getLoginUser().getUserId(), this.f17212x)).setDataListener(new C4596f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K0 */
    public void m41903K0() {
        int i = 0;
        while (i < this.f17214z.size()) {
            Fragment fragment = null;
            if ("0".equals(JsonParse.getString(this.f17214z.get(i), "questionType"))) {
                fragment = new RadioAnswerFragment();
            } else if ("1".equals(JsonParse.getString(this.f17214z.get(i), "questionType"))) {
                fragment = new CheckboxAnswerFragment();
            } else if ("3".equals(JsonParse.getString(this.f17214z.get(i), "questionType"))) {
                fragment = new RadioAnswerFragment();
            } else {
                this.f17214z.remove(i);
                i--;
            }
            if (fragment != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("index", i);
                fragment.setArguments(bundle);
                this.f17197A.add(fragment);
            }
            i++;
        }
        this.f17202n.setAdapter(new C4597g(getSupportFragmentManager()));
        setTitle("1/" + this.f17202n.getAdapter().getCount());
        try {
            this.f17200l.setVisibility(8);
            this.f17199k.setVisibility(8);
            this.f17203o.setEnabled(false);
            this.f17204p.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: L0 */
    private void m41902L0() {
        if (this.f17202n.getCurrentItem() == this.f17202n.getAdapter().getCount() - 1) {
            m57919h0("已经是最后一题了");
            return;
        }
        CustomViewPager customViewPager = this.f17202n;
        customViewPager.setCurrentItem(customViewPager.getCurrentItem() + 1);
    }

    /* renamed from: M0 */
    private void m41901M0() {
        PopupWindow popupWindow = new PopupWindow(-1, -2);
        View inflate = LayoutInflater.from(this.f1669h).inflate(C4215R.C4221layout.pop_dialog, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(C4215R.C4219id.f15997gv);
        gridView.setAdapter((ListAdapter) this.f17208t);
        gridView.setOnItemClickListener(new C4591a(popupWindow));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131233298);
        popupWindow.setOnDismissListener(new C4592b(frameLayout));
        popupWindow.setContentView(inflate);
        popupWindow.showAsDropDown(findViewById(2131232779));
        if (frameLayout != null) {
            frameLayout.setForeground(new ColorDrawable(Color.parseColor("#7F4c4c4c")));
        }
    }

    /* renamed from: N0 */
    private void m41900N0() {
        if (this.f17202n.getCurrentItem() == 0) {
            m57919h0("已经是第一题了");
            return;
        }
        CustomViewPager customViewPager = this.f17202n;
        customViewPager.setCurrentItem(customViewPager.getCurrentItem() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O0 */
    public void m41899O0() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        CountDownTimerC4598h countDownTimerC4598h = new CountDownTimerC4598h(this.f17213y, 1000L, simpleDateFormat);
        this.f17209u = countDownTimerC4598h;
        countDownTimerC4598h.start();
    }

    /* renamed from: i0 */
    private boolean m41898i0() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            this.f17210v = connectivityManager;
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return activeNetworkInfo.isAvailable();
                }
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: j0 */
    private void m41897j0() {
        NetworkInfo.State state = this.f17210v.getNetworkInfo(0).getState();
        NetworkInfo.State state2 = this.f17210v.getNetworkInfo(1).getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            Toast.makeText(this, "当前为网络状态为MOBILE", 0).show();
        }
        if (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING) {
            Toast.makeText(this, "当前为网络状态为Wi-Fi", 0).show();
        }
    }

    /* renamed from: J0 */
    public List<Map<String, Object>> m41904J0() {
        return this.f17214z;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f17203o.setOnClickListener(this);
        this.f17204p.setOnClickListener(this);
        this.f17205q.setOnClickListener(this);
        m41910D0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_exam_new;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("id")) {
            this.f17212x = getIntent().getStringExtra("id");
        }
        this.f17208t = new C4595e(this.f1669h, C4215R.C4221layout.item_for_number, this.f17214z);
        m41905I0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        m57927Z(new C4593c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f17199k = (TextView) findViewById(C4215R.C4219id.tv_question_lesson);
        this.f17200l = (TextView) findViewById(C4215R.C4219id.tv_question_teacher);
        this.f17202n = (CustomViewPager) findViewById(C4215R.C4219id.f16013vp);
        this.f17203o = (Button) findViewById(C4215R.C4219id.bt_previous);
        this.f17204p = (Button) findViewById(C4215R.C4219id.bt_next);
        this.f17205q = (Button) findViewById(2131230989);
        this.f17206r = (TextView) findViewById(2131233198);
        this.f17207s = (RelativeLayout) findViewById(2131232217);
        this.f17201m = (CountDownTimeView) findViewById(C4215R.C4219id.cdtv);
        this.f17207s.setVisibility(8);
        this.f17202n.setPagingEnabled(false);
        this.f17201m.m43529i(60, 0);
        this.f17201m.setTextSize(DisplayUtil.m57757d(this.f1669h, 20.0f));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        new iOSTwoButtonDialog(this.f1669h).setMessage("正在答题，是否放弃答题？").setRightButtonOnClickListener(new C4594d()).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case C4215R.C4219id.bt_next /* 2131230988 */:
                m41902L0();
                return;
            case 2131230989:
                m41906H0(false);
                return;
            case C4215R.C4219id.bt_previous /* 2131230994 */:
                m41900N0();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CountDownTimer countDownTimer = this.f17209u;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        C4604l c4604l = this.f17211w;
        if (c4604l != null) {
            unregisterReceiver(c4604l);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.learning.answer.AnswerActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4596f extends HttpCallBack {
        C4596f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((BaseActivity) AnswerActivity.this).f1669h).setMessage("获取考试内容异常，请联系管理员").show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) AnswerActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            AnswerActivity.this.f17207s.setVisibility(0);
            AnswerActivity.this.f17214z = (List) data.get("data");
            AnswerActivity.this.m41903K0();
            AnswerActivity.this.f17208t.m57842c(AnswerActivity.this.f17214z);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
            AnswerActivity.this.m41899O0();
        }
    }
}
