package com.bxkj.student.home.teaching.exam.mock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
import cn.bluemobi.dylan.base.utils.DisplayUtil;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
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
import com.kuaishou.weapon.p205p0.C7193bi;
import com.orhanobut.logger.C11792j;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class NewExamActivity extends BaseActivity {

    /* renamed from: A */
    private long f16840A;

    /* renamed from: k */
    private TextView f16846k;

    /* renamed from: l */
    private TextView f16847l;

    /* renamed from: m */
    private CountDownTimeView f16848m;

    /* renamed from: n */
    private CustomViewPager f16849n;

    /* renamed from: o */
    public Button f16850o;

    /* renamed from: p */
    public Button f16851p;

    /* renamed from: q */
    private Button f16852q;

    /* renamed from: r */
    private TextView f16853r;

    /* renamed from: s */
    private RelativeLayout f16854s;

    /* renamed from: t */
    private CommonAdapter<Map<String, Object>> f16855t;

    /* renamed from: u */
    private CountDownTimer f16856u;

    /* renamed from: v */
    private CountDownTimer f16857v;

    /* renamed from: w */
    private ConnectivityManager f16858w;

    /* renamed from: x */
    private C4496m f16859x;

    /* renamed from: y */
    private int f16860y = 30;

    /* renamed from: z */
    private int f16861z = 0;

    /* renamed from: B */
    private String f16841B = "体育专业题库";

    /* renamed from: C */
    public int f16842C = 1;

    /* renamed from: D */
    private List<Map<String, Object>> f16843D = new ArrayList();

    /* renamed from: E */
    private List<Fragment> f16844E = new ArrayList();

    /* renamed from: F */
    private boolean f16845F = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.mock.NewExamActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4483a implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        private int f16862a;

        C4483a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            this.f16862a = state;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (this.f16862a == 1 && positionOffsetPixels == 0) {
                if (position == 0) {
                    NewExamActivity.this.m57919h0("已经是第一题了");
                } else if (position == NewExamActivity.this.f16849n.getAdapter().getCount() - 1) {
                    NewExamActivity.this.m57919h0("已经是最后一题了");
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            NewExamActivity newExamActivity = NewExamActivity.this;
            newExamActivity.setTitle(NewExamActivity.this.f16841B + (position + 1) + "/" + NewExamActivity.this.f16849n.getAdapter().getCount());
            if (NewExamActivity.this.f16856u != null) {
                NewExamActivity.this.f16856u.cancel();
            }
            NewExamActivity.this.f16848m.m43529i(NewExamActivity.this.f16860y, 0);
            if ("1".equals(JsonParse.getString((Map) NewExamActivity.this.f16843D.get(NewExamActivity.this.f16849n.getCurrentItem()), "questionType"))) {
                boolean z = false;
                for (Map<String, Object> map : JsonParse.getList((Map) NewExamActivity.this.f16843D.get(NewExamActivity.this.f16849n.getCurrentItem()), "answers")) {
                    if (map.containsKey("icChecked") && ((Boolean) map.get("icChecked")).booleanValue()) {
                        z = true;
                    }
                }
                if (!JsonParse.getBoolean((Map) NewExamActivity.this.f16843D.get(NewExamActivity.this.f16849n.getCurrentItem()), "timeFinish") && !z) {
                    NewExamActivity.this.f16850o.setEnabled(false);
                    NewExamActivity.this.f16851p.setEnabled(false);
                    NewExamActivity newExamActivity2 = NewExamActivity.this;
                    if (newExamActivity2.f16842C == 0) {
                        newExamActivity2.m42211e1();
                    }
                }
            } else if (!JsonParse.getBoolean((Map) NewExamActivity.this.f16843D.get(NewExamActivity.this.f16849n.getCurrentItem()), "timeFinish") && TextUtils.isEmpty(JsonParse.getString((Map) NewExamActivity.this.f16843D.get(NewExamActivity.this.f16849n.getCurrentItem()), "checkAnswerId"))) {
                NewExamActivity.this.f16850o.setEnabled(false);
                NewExamActivity.this.f16851p.setEnabled(false);
                NewExamActivity newExamActivity3 = NewExamActivity.this;
                if (newExamActivity3.f16842C == 0) {
                    newExamActivity3.m42211e1();
                }
            }
            TextView textView = NewExamActivity.this.f16847l;
            textView.setText("出题人：" + JsonParse.getString((Map) NewExamActivity.this.f16843D.get(position), "questionsSetter"));
            TextView textView2 = NewExamActivity.this.f16846k;
            textView2.setText("课程名称：" + JsonParse.getString((Map) NewExamActivity.this.f16843D.get(position), "curriculum"));
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.exam.mock.NewExamActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4484b implements AdapterView.OnItemClickListener {

        /* renamed from: a */
        final /* synthetic */ PopupWindow f16864a;

        C4484b(final PopupWindow val$popupWindow) {
            this.f16864a = val$popupWindow;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            NewExamActivity.this.f16849n.setCurrentItem(position);
            this.f16864a.dismiss();
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.exam.mock.NewExamActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4485c implements PopupWindow.OnDismissListener {

        /* renamed from: a */
        final /* synthetic */ FrameLayout f16866a;

        C4485c(final FrameLayout val$outsideView) {
            this.f16866a = val$outsideView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            FrameLayout frameLayout = this.f16866a;
            if (frameLayout != null) {
                frameLayout.setForeground(new ColorDrawable(0));
            }
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.exam.mock.NewExamActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4486d implements BaseActivity.InterfaceC1107c {
        C4486d() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            NewExamActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.mock.NewExamActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4487e implements iOSTwoButtonDialog.RightButtonOnClick {
        C4487e() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            NewExamActivity.this.finish();
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.exam.mock.NewExamActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4488f extends CommonAdapter<Map<String, Object>> {
        C4488f(Context context, int layoutId, List datas) {
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
                holder.m57873K(2131233051, arrayList.isEmpty() ? NewExamActivity.this.getResources().getColor(2131034190) : NewExamActivity.this.getResources().getColor(2131034196));
                return;
            }
            if (!JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty()) {
                i = C4215R.C4218drawable.dot_cicler_blue;
            }
            holder.m57858l(2131233051, i);
            holder.m57873K(2131233051, JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty() ? NewExamActivity.this.getResources().getColor(2131034190) : NewExamActivity.this.getResources().getColor(2131034196));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.mock.NewExamActivity$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4490h extends FragmentPagerAdapter {
        C4490h(FragmentManager fm) {
            super(fm);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return NewExamActivity.this.f16844E.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return (Fragment) NewExamActivity.this.f16844E.get(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.mock.NewExamActivity$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class CountDownTimerC4491i extends CountDownTimer {

        /* renamed from: a */
        final /* synthetic */ SimpleDateFormat f16873a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        CountDownTimerC4491i(long millisInFuture, long countDownInterval, final SimpleDateFormat val$simpleDateFormat) {
            super(millisInFuture, countDownInterval);
            this.f16873a = val$simpleDateFormat;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            for (Map map : NewExamActivity.this.f16843D) {
                map.put("timeFinish", Boolean.TRUE);
            }
            for (Fragment fragment : NewExamActivity.this.f16844E) {
                if (fragment instanceof NewRadioExamFragment) {
                    ((NewRadioExamFragment) fragment).m42187R();
                } else if (fragment instanceof NewCheckboxExamFragment) {
                    ((NewCheckboxExamFragment) fragment).m42242P();
                }
            }
            NewExamActivity.this.m42221U0();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            NewExamActivity.this.f16853r.setText(this.f16873a.format(Long.valueOf(millisUntilFinished)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.mock.NewExamActivity$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class CountDownTimerC4492j extends CountDownTimer {

        /* renamed from: a */
        final /* synthetic */ SimpleDateFormat f16875a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        CountDownTimerC4492j(long millisInFuture, long countDownInterval, final SimpleDateFormat val$simpleDateFormat) {
            super(millisInFuture, countDownInterval);
            this.f16875a = val$simpleDateFormat;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            NewExamActivity.this.f16848m.m43529i(NewExamActivity.this.f16860y, 0);
            if (NewExamActivity.this.f16843D != null) {
                ((Map) NewExamActivity.this.f16843D.get(NewExamActivity.this.f16849n.getCurrentItem())).put("timeFinish", Boolean.TRUE);
                Fragment fragment = (Fragment) NewExamActivity.this.f16844E.get(NewExamActivity.this.f16849n.getCurrentItem());
                if (fragment instanceof NewRadioExamFragment) {
                    ((NewRadioExamFragment) fragment).m42187R();
                    NewExamActivity.this.f16850o.setEnabled(true);
                    NewExamActivity.this.f16851p.setEnabled(true);
                } else if (fragment instanceof NewCheckboxExamFragment) {
                    ((NewCheckboxExamFragment) fragment).m42242P();
                    NewExamActivity.this.f16850o.setEnabled(true);
                    NewExamActivity.this.f16851p.setEnabled(true);
                }
                NewExamActivity.this.m42215a1();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            NewExamActivity.this.f16848m.m43529i(NewExamActivity.this.f16860y, ((int) millisUntilFinished) / 1000);
            NewExamActivity.this.f16853r.setText(this.f16875a.format(Long.valueOf(millisUntilFinished)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.mock.NewExamActivity$k */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4493k implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a */
        final /* synthetic */ boolean f16877a;

        /* renamed from: b */
        final /* synthetic */ String f16878b;

        /* renamed from: c */
        final /* synthetic */ List f16879c;

        /* renamed from: d */
        final /* synthetic */ List f16880d;

        C4493k(final boolean val$autoCommit, final String val$stuTeacherCurriculumId, final List val$radioData, final List val$checkData) {
            this.f16877a = val$autoCommit;
            this.f16878b = val$stuTeacherCurriculumId;
            this.f16879c = val$radioData;
            this.f16880d = val$checkData;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            NewExamActivity.this.m42219W0(this.f16877a, this.f16878b, this.f16879c, this.f16880d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.mock.NewExamActivity$l */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4494l extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ boolean f16882a;

        /* renamed from: com.bxkj.student.home.teaching.exam.mock.NewExamActivity$l$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class View$OnClickListenerC4495a implements View.OnClickListener {
            View$OnClickListenerC4495a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                NewExamActivity.this.finish();
            }
        }

        C4494l(final boolean val$autoCommit) {
            this.f16882a = val$autoCommit;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            if (this.f16882a) {
                new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).f1669h).setMessage("时间已到，自动交卷失败，请手动交卷").show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            String str = this.f16882a ? "时间已到，已经为您自动交卷成功" : "交卷成功";
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).f1669h);
            iosonebuttondialog.setCancelable(false);
            iosonebuttondialog.setMessage(str).setButtonOnClickListener(new View$OnClickListenerC4495a()).show();
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.exam.mock.NewExamActivity$m */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    private class C4496m extends BroadcastReceiver {
        private C4496m() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!NewExamActivity.this.m42210i0()) {
                new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).f1669h).setMessage("已脱离后台监控，请检查网络后开始考试").show();
            } else if (!NewExamActivity.this.f16845F) {
                new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).f1669h).setMessage("网络已恢复，请继续开始考试").show();
            }
            C11792j.m20470c("网络状态发生变化");
            NewExamActivity newExamActivity = NewExamActivity.this;
            newExamActivity.f16845F = newExamActivity.m42210i0();
        }

        /* synthetic */ C4496m(NewExamActivity newExamActivity, C4486d c4486d) {
            this();
        }
    }

    /* renamed from: T0 */
    private void m42222T0() {
        this.f16849n.addOnPageChangeListener(new C4483a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: U0 */
    public void m42221U0() {
        m42218X0(true);
    }

    /* renamed from: V0 */
    private String m42220V0(long milliSecondTime) {
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
    /* renamed from: W0 */
    public void m42219W0(final boolean autoCommit, String stuTeacherCurriculumId, List<Map<String, Object>> radioData, List<Map<String, Object>> checkData) {
        String jSONString = JSON.toJSONString(radioData);
        String jSONString2 = JSON.toJSONString(checkData);
        C11792j.m20465h(jSONString);
        C11792j.m20465h(jSONString2);
        Http.with(this.f1669h).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m70t1(stuTeacherCurriculumId, LoginUser.getLoginUser().getUserId(), jSONString, jSONString2, "", String.valueOf(this.f16840A), this.f16861z)).setDataListener(new C4494l(autoCommit));
    }

    /* renamed from: X0 */
    private void m42218X0(final boolean autoCommit) {
        String stringExtra = getIntent().getStringExtra("stuTeacherCurriculumId");
        List<Map<String, Object>> arrayList = new ArrayList<>();
        List<Map<String, Object>> arrayList2 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f16843D.size(); i++) {
            Map<String, Object> map = this.f16843D.get(i);
            String str = "";
            if ("1".equals(JsonParse.getString(this.f16843D.get(i), "questionType"))) {
                ArrayList arrayList3 = new ArrayList();
                Iterator it = ((List) this.f16843D.get(i).get("answers")).iterator();
                while (it.hasNext()) {
                    Iterator it2 = it;
                    Map map2 = (Map) it.next();
                    String str2 = str;
                    if (map2.containsKey("icChecked") && ((Boolean) map2.get("icChecked")).booleanValue()) {
                        arrayList3.add(JsonParse.getString(map2, "answerId"));
                    }
                    str = str2;
                    it = it2;
                }
                String str3 = str;
                Map<String, Object> arrayMap = new ArrayMap<>();
                arrayMap.put("question", JsonParse.getString(map, "questionId"));
                arrayMap.put("answers", arrayList3);
                arrayMap.put("scoreId", JsonParse.getString(map, "scoreId"));
                arrayList2.add(arrayMap);
                if (arrayList3.isEmpty() && !autoCommit) {
                    sb.append(TextUtils.isEmpty(sb) ? str3 : ",");
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
            new iOSTwoButtonDialog(this.f1669h).setMessage("确定要提交试卷吗？").setLeftButtonText("继续答题").setRightButtonText("直接交卷").setRightButtonOnClickListener(new C4493k(autoCommit, stringExtra, arrayList, arrayList2)).show();
        } else {
            m42219W0(autoCommit, stringExtra, arrayList, arrayList2);
        }
    }

    /* renamed from: Y0 */
    private void m42217Y0() {
        String str;
        String str2 = null;
        String stringExtra = getIntent().hasExtra("stuTeacherCurriculumId") ? getIntent().getStringExtra("stuTeacherCurriculumId") : null;
        if (getIntent().hasExtra("selectIds")) {
            str = getIntent().getStringExtra("selectIds");
        } else {
            str2 = stringExtra;
            str = null;
        }
        Http.with(this.f1669h).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m69u(str2, str, LoginUser.getLoginUser().getUserId(), this.f16861z)).setDataListener(new C4489g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z0 */
    public void m42216Z0() {
        int i = 0;
        while (i < this.f16843D.size()) {
            Fragment fragment = null;
            Map<String, Object> map = this.f16843D.get(i);
            if ("0".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new NewRadioExamFragment();
            } else if ("1".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new NewCheckboxExamFragment();
            } else if ("3".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new NewRadioExamFragment();
            } else {
                this.f16843D.remove(i);
                i--;
            }
            if (fragment != null) {
                Bundle bundle = new Bundle();
                SeralizableMap seralizableMap = new SeralizableMap();
                seralizableMap.setMap(map);
                bundle.putInt("index", i);
                bundle.putSerializable("seralizableMap", seralizableMap);
                fragment.setArguments(bundle);
                this.f16844E.add(fragment);
            }
            i++;
        }
        this.f16849n.setAdapter(new C4490h(getSupportFragmentManager()));
        setTitle(this.f16841B + "1/" + this.f16849n.getAdapter().getCount());
        try {
            String string = JsonParse.getString(this.f16843D.get(0), "questionsSetter");
            if (TextUtils.isEmpty(string)) {
                this.f16847l.setVisibility(8);
            } else {
                this.f16847l.setVisibility(0);
                this.f16847l.setText("出题人：" + string);
            }
            String string2 = JsonParse.getString(this.f16843D.get(0), "curriculum");
            if (TextUtils.isEmpty(string2)) {
                this.f16846k.setVisibility(8);
            } else {
                this.f16846k.setVisibility(0);
                this.f16846k.setText("课程名称：" + string2);
            }
            this.f16850o.setEnabled(false);
            this.f16851p.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a1 */
    public void m42215a1() {
        if (this.f16849n.getCurrentItem() == this.f16849n.getAdapter().getCount() - 1) {
            m57919h0("已经是最后一题了");
            return;
        }
        List<Fragment> list = this.f16844E;
        if (list != null) {
            Fragment fragment = list.get(this.f16849n.getCurrentItem());
            if (fragment instanceof NewCheckboxExamFragment) {
                ((NewCheckboxExamFragment) fragment).m42242P();
            }
        }
        CustomViewPager customViewPager = this.f16849n;
        customViewPager.setCurrentItem(customViewPager.getCurrentItem() + 1);
    }

    /* renamed from: b1 */
    private void m42214b1() {
        PopupWindow popupWindow = new PopupWindow(-1, -2);
        View inflate = LayoutInflater.from(this.f1669h).inflate(C4215R.C4221layout.pop_dialog, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(C4215R.C4219id.f15997gv);
        gridView.setAdapter((ListAdapter) this.f16855t);
        gridView.setOnItemClickListener(new C4484b(popupWindow));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131233298);
        popupWindow.setOnDismissListener(new C4485c(frameLayout));
        popupWindow.setContentView(inflate);
        popupWindow.showAsDropDown(findViewById(2131232779));
        if (frameLayout != null) {
            frameLayout.setForeground(new ColorDrawable(Color.parseColor("#7F4c4c4c")));
        }
    }

    /* renamed from: c1 */
    private void m42213c1() {
        if (this.f16849n.getCurrentItem() == 0) {
            m57919h0("已经是第一题了");
            return;
        }
        CustomViewPager customViewPager = this.f16849n;
        customViewPager.setCurrentItem(customViewPager.getCurrentItem() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d1 */
    public void m42212d1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        CountDownTimerC4491i countDownTimerC4491i = new CountDownTimerC4491i(this.f16860y * 1000, 1000L, simpleDateFormat);
        this.f16857v = countDownTimerC4491i;
        countDownTimerC4491i.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e1 */
    public void m42211e1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        CountDownTimerC4492j countDownTimerC4492j = new CountDownTimerC4492j(this.f16860y * 1000, 1000L, simpleDateFormat);
        this.f16856u = countDownTimerC4492j;
        countDownTimerC4492j.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i0 */
    public boolean m42210i0() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            this.f16858w = connectivityManager;
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
    private void m42209j0() {
        NetworkInfo.State state = this.f16858w.getNetworkInfo(0).getState();
        NetworkInfo.State state2 = this.f16858w.getNetworkInfo(1).getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            Toast.makeText(this, "当前为网络状态为MOBILE", 0).show();
        }
        if (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING) {
            Toast.makeText(this, "当前为网络状态为Wi-Fi", 0).show();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16850o.setOnClickListener(this);
        this.f16851p.setOnClickListener(this);
        this.f16852q.setOnClickListener(this);
        m42222T0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_exam_new;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("onlineType")) {
            this.f16861z = getIntent().getIntExtra("onlineType", 0);
        }
        this.f16855t = new C4488f(this.f1669h, C4215R.C4221layout.item_for_number, this.f16843D);
        m42217Y0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        String stringExtra = getIntent().getStringExtra("title");
        this.f16841B = stringExtra;
        setTitle(stringExtra);
        m57927Z(new C4486d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16846k = (TextView) findViewById(C4215R.C4219id.tv_question_lesson);
        this.f16847l = (TextView) findViewById(C4215R.C4219id.tv_question_teacher);
        this.f16849n = (CustomViewPager) findViewById(C4215R.C4219id.f16013vp);
        this.f16850o = (Button) findViewById(C4215R.C4219id.bt_previous);
        this.f16851p = (Button) findViewById(C4215R.C4219id.bt_next);
        this.f16852q = (Button) findViewById(2131230989);
        this.f16853r = (TextView) findViewById(2131233198);
        this.f16854s = (RelativeLayout) findViewById(2131232217);
        this.f16848m = (CountDownTimeView) findViewById(C4215R.C4219id.cdtv);
        this.f16854s.setVisibility(8);
        this.f16849n.setPagingEnabled(false);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        new iOSTwoButtonDialog(this.f1669h).setMessage("正在考试，是否放弃考试？").setRightButtonOnClickListener(new C4487e()).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (!this.f16845F) {
            new iOSOneButtonDialog(this.f1669h).setMessage("已脱离后台监控，请检查网络后开始考试").show();
            return;
        }
        switch (v.getId()) {
            case C4215R.C4219id.bt_next /* 2131230988 */:
                m42215a1();
                return;
            case 2131230989:
                m42218X0(false);
                return;
            case C4215R.C4219id.bt_previous /* 2131230994 */:
                m42213c1();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CountDownTimer countDownTimer = this.f16857v;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.f16856u;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        C4496m c4496m = this.f16859x;
        if (c4496m != null) {
            unregisterReceiver(c4496m);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.mock.NewExamActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4489g extends HttpCallBack {
        C4489g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).f1669h).setMessage("获取考试内容异常，请联系管理员").show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            NewExamActivity.this.f16840A = System.currentTimeMillis();
            NewExamActivity newExamActivity = NewExamActivity.this;
            newExamActivity.f16842C = JsonParse.getInt(data, "examTimeType", newExamActivity.f16842C);
            NewExamActivity newExamActivity2 = NewExamActivity.this;
            newExamActivity2.f16860y = JsonParse.getInt(data, "examTime", newExamActivity2.f16860y);
            NewExamActivity.this.f16843D = (List) data.get("examArray");
            if (NewExamActivity.this.f16843D != null && NewExamActivity.this.f16843D.size() > 0) {
                NewExamActivity.this.f16854s.setVisibility(0);
                NewExamActivity.this.m42216Z0();
                NewExamActivity.this.f16855t.m57842c(NewExamActivity.this.f16843D);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                NewExamActivity.this.f16859x = new C4496m(NewExamActivity.this, null);
                NewExamActivity newExamActivity3 = NewExamActivity.this;
                newExamActivity3.registerReceiver(newExamActivity3.f16859x, intentFilter);
                NewExamActivity.this.f16848m.m43529i(NewExamActivity.this.f16860y, 0);
                NewExamActivity.this.f16848m.setTextSize(DisplayUtil.m57757d(((BaseActivity) NewExamActivity.this).f1669h, 20.0f));
                NewExamActivity newExamActivity4 = NewExamActivity.this;
                if (newExamActivity4.f16842C == 1) {
                    ((View) newExamActivity4.f16853r.getParent()).setVisibility(0);
                    NewExamActivity.this.f16848m.setVisibility(8);
                    NewExamActivity.this.m42212d1();
                    return;
                }
                ((View) newExamActivity4.f16853r.getParent()).setVisibility(8);
                NewExamActivity.this.f16848m.setVisibility(0);
                NewExamActivity.this.m42211e1();
                return;
            }
            new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).f1669h).setMessage("没有题目").show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
        }
    }
}
