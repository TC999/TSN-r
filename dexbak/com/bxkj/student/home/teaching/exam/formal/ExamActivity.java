package com.bxkj.student.home.teaching.exam.formal;

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
import com.bxkj.base.p085v2.common.ext.PermissionExt;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.C3916w;
import com.bxkj.base.view.CountDownTimeView;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.view.CustomViewPager;
import com.bxkj.student.home.teaching.exam.FaceDetectExamActivity;
import com.bxkj.student.home.teaching.exam.formal.ExamActivity;
import com.orhanobut.logger.C11792j;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Unit;
import p617l1.InterfaceC15269a;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class ExamActivity extends BaseActivity {

    /* renamed from: B */
    private int f16759B;

    /* renamed from: C */
    private int f16760C;

    /* renamed from: D */
    private int f16761D;

    /* renamed from: N */
    private iOSOneButtonDialog f16771N;

    /* renamed from: k */
    private CustomViewPager f16773k;

    /* renamed from: l */
    public Button f16774l;

    /* renamed from: m */
    public Button f16775m;

    /* renamed from: n */
    private Button f16776n;

    /* renamed from: o */
    private TextView f16777o;

    /* renamed from: p */
    private RelativeLayout f16778p;

    /* renamed from: q */
    private CountDownTimeView f16779q;

    /* renamed from: r */
    private CommonAdapter<Map<String, Object>> f16780r;

    /* renamed from: s */
    private CountDownTimer f16781s;

    /* renamed from: t */
    private CountDownTimer f16782t;

    /* renamed from: u */
    private ConnectivityManager f16783u;

    /* renamed from: v */
    private C4469h f16784v;

    /* renamed from: x */
    private PopupWindow f16786x;

    /* renamed from: y */
    private iOSOneButtonDialog f16787y;

    /* renamed from: w */
    private int f16785w = 0;

    /* renamed from: z */
    private List<Map<String, Object>> f16788z = new ArrayList();

    /* renamed from: A */
    private List<Fragment> f16758A = new ArrayList();

    /* renamed from: E */
    private List<Integer> f16762E = new ArrayList();

    /* renamed from: F */
    private List<Integer> f16763F = new ArrayList();

    /* renamed from: G */
    private final int f16764G = 170;

    /* renamed from: H */
    private final int f16765H = 187;

    /* renamed from: I */
    private final int f16766I = 255;

    /* renamed from: J */
    private int f16767J = 0;

    /* renamed from: K */
    public int f16768K = 1;

    /* renamed from: L */
    private int f16769L = 10800;

    /* renamed from: M */
    public boolean f16770M = true;

    /* renamed from: O */
    private boolean f16772O = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.formal.ExamActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4459a extends CommonAdapter<Map<String, Object>> {
        C4459a(Context context, int layoutId, List datas) {
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
                holder.m57873K(2131233051, arrayList.isEmpty() ? ExamActivity.this.getResources().getColor(2131034190) : ExamActivity.this.getResources().getColor(2131034196));
                return;
            }
            if (!JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty()) {
                i = C4215R.C4218drawable.dot_cicler_blue;
            }
            holder.m57858l(2131233051, i);
            holder.m57873K(2131233051, JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty() ? ExamActivity.this.getResources().getColor(2131034190) : ExamActivity.this.getResources().getColor(2131034196));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.formal.ExamActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4460b extends HttpCallBack {
        C4460b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public /* synthetic */ Unit m42249c() {
            ExamActivity.this.startActivityForResult(new Intent(((BaseActivity) ExamActivity.this).f1669h, FaceDetectExamActivity.class), 170);
            ExamActivity.this.overridePendingTransition(2130771987, 2130771986);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: d */
        public /* synthetic */ void m42248d(View view) {
            PermissionExt.m43841c(((BaseActivity) ExamActivity.this).f1670i, "人脸识别", new InterfaceC15269a() { // from class: com.bxkj.student.home.teaching.exam.formal.k
                @Override // p617l1.InterfaceC15269a
                public final Object invoke() {
                    Unit m42249c;
                    m42249c = ExamActivity.C4460b.this.m42249c();
                    return m42249c;
                }
            });
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1669h).setMessage("获取考试内容异常，请联系管理员").show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamActivity.this.f16767J = JsonParse.getInt(data, "isReturnExam");
            ExamActivity.this.f16759B = JsonParse.getInt(data, "isExamStartFace");
            ExamActivity.this.f16760C = JsonParse.getInt(data, "isExamEndFace");
            ExamActivity.this.f16761D = JsonParse.getInt(data, "isExamFaceNum");
            ExamActivity examActivity = ExamActivity.this;
            examActivity.f16768K = JsonParse.getInt(data, "examTimeType", examActivity.f16768K);
            ExamActivity examActivity2 = ExamActivity.this;
            examActivity2.f16769L = JsonParse.getInt(data, "examTime", examActivity2.f16769L);
            ExamActivity.this.f16788z = JsonParse.getList(data, "examArray");
            if (ExamActivity.this.f16788z != null && ExamActivity.this.f16788z.size() > 0) {
                ExamActivity.this.m42279m1();
                if (ExamActivity.this.f16761D > 0) {
                    ExamActivity examActivity3 = ExamActivity.this;
                    examActivity3.f16762E = C3916w.m44020a(examActivity3.f16788z.size(), ExamActivity.this.f16761D);
                }
                if (ExamActivity.this.f16759B == 1) {
                    ExamActivity.this.f16787y = new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1669h).setMessage("考试开始前，请先进行人脸识别").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.formal.j
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ExamActivity.C4460b.this.m42248d(view);
                        }
                    });
                    ExamActivity.this.f16787y.setClickAutoCancel(false);
                    ExamActivity.this.f16787y.setCancelable(false);
                    ExamActivity.this.f16787y.setCanceledOnTouchOutside(false);
                    ExamActivity.this.f16787y.show();
                    return;
                }
                ExamActivity.this.m42283k1();
                return;
            }
            new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1669h).setMessage("没有题目").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.formal.ExamActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4461c extends FragmentPagerAdapter {
        C4461c(FragmentManager fm) {
            super(fm);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ExamActivity.this.f16758A.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return (Fragment) ExamActivity.this.f16758A.get(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.formal.ExamActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class CountDownTimerC4462d extends CountDownTimer {
        CountDownTimerC4462d(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ExamActivity.this.f16779q.m43529i(ExamActivity.this.f16769L, 0);
            if (ExamActivity.this.f16788z != null) {
                ((Map) ExamActivity.this.f16788z.get(ExamActivity.this.f16773k.getCurrentItem())).put("timeFinish", Boolean.TRUE);
                ExamActivity.this.m42259w1();
                ExamActivity.this.f16774l.setEnabled(true);
                ExamActivity.this.f16775m.setEnabled(true);
                ExamActivity.this.f16770M = true;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            ExamActivity.this.f16779q.m43529i(ExamActivity.this.f16769L, ((int) millisUntilFinished) / 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.formal.ExamActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class CountDownTimerC4463e extends CountDownTimer {

        /* renamed from: a */
        final /* synthetic */ SimpleDateFormat f16793a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        CountDownTimerC4463e(long millisInFuture, long countDownInterval, final SimpleDateFormat val$simpleDateFormat) {
            super(millisInFuture, countDownInterval);
            this.f16793a = val$simpleDateFormat;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ExamActivity.this.m42291f1();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            ExamActivity.this.f16777o.setText(this.f16793a.format(Long.valueOf(millisUntilFinished)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.formal.ExamActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4464f extends HttpCallBack {

        /* renamed from: a */
        final /* synthetic */ boolean f16795a;

        /* renamed from: com.bxkj.student.home.teaching.exam.formal.ExamActivity$f$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class View$OnClickListenerC4465a implements View.OnClickListener {
            View$OnClickListenerC4465a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ExamActivity.this.finish();
            }
        }

        /* renamed from: com.bxkj.student.home.teaching.exam.formal.ExamActivity$f$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class View$OnClickListenerC4466b implements View.OnClickListener {
            View$OnClickListenerC4466b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ExamActivity.this.finish();
            }
        }

        /* renamed from: com.bxkj.student.home.teaching.exam.formal.ExamActivity$f$c */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class View$OnClickListenerC4467c implements View.OnClickListener {
            View$OnClickListenerC4467c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                ExamActivity.this.finish();
            }
        }

        C4464f(final boolean val$autoCommit) {
            this.f16795a = val$autoCommit;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            if (this.f16795a) {
                new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1669h).setButtonOnClickListener(new View$OnClickListenerC4467c()).setMessage("时间已到，自动交卷失败，请重新考试").show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1669h).setButtonOnClickListener(new View$OnClickListenerC4466b()).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            String str = (this.f16795a && ExamActivity.this.f16760C == 0) ? "时间已到，已经为您自动交卷成功" : "交卷成功";
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1669h);
            iosonebuttondialog.setCancelable(false);
            iosonebuttondialog.setMessage(str).setButtonOnClickListener(new View$OnClickListenerC4465a()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.exam.formal.ExamActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4468g implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        private int f16800a;

        C4468g() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            this.f16800a = state;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (this.f16800a == 1 && positionOffsetPixels == 0) {
                if (position == 0) {
                    ExamActivity.this.m57919h0("已经是第一题了");
                } else if (position == ExamActivity.this.f16773k.getAdapter().getCount() - 1) {
                    ExamActivity.this.m57919h0("已经是最后一题了");
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            ExamActivity examActivity = ExamActivity.this;
            examActivity.setTitle("理论考试" + (position + 1) + "/" + ExamActivity.this.f16773k.getAdapter().getCount());
            ExamActivity examActivity2 = ExamActivity.this;
            if (examActivity2.f16768K != 1) {
                if (examActivity2.f16781s != null) {
                    ExamActivity.this.f16781s.cancel();
                }
                ExamActivity.this.f16779q.m43529i(ExamActivity.this.f16769L, 0);
                if ("1".equals(JsonParse.getString((Map) ExamActivity.this.f16788z.get(ExamActivity.this.f16773k.getCurrentItem()), "questionType"))) {
                    boolean z = false;
                    for (Map<String, Object> map : JsonParse.getList((Map) ExamActivity.this.f16788z.get(ExamActivity.this.f16773k.getCurrentItem()), "answers")) {
                        if (map.containsKey("icChecked") && ((Boolean) map.get("icChecked")).booleanValue()) {
                            z = true;
                        }
                    }
                    if (JsonParse.getBoolean((Map) ExamActivity.this.f16788z.get(ExamActivity.this.f16773k.getCurrentItem()), "timeFinish") || z) {
                        return;
                    }
                    ExamActivity.this.m42323A1();
                } else if (!JsonParse.getBoolean((Map) ExamActivity.this.f16788z.get(ExamActivity.this.f16773k.getCurrentItem()), "timeFinish") && TextUtils.isEmpty(JsonParse.getString((Map) ExamActivity.this.f16788z.get(ExamActivity.this.f16773k.getCurrentItem()), "checkAnswerId"))) {
                    ExamActivity.this.m42323A1();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bxkj.student.home.teaching.exam.formal.ExamActivity$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4469h extends BroadcastReceiver {
        private C4469h() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!ExamActivity.this.m42270r0()) {
                new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1669h).setMessage("已脱离后台监控，请检查网络后开始考试").show();
            } else if (!ExamActivity.this.f16772O) {
                new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1669h).setMessage("网络已恢复，请继续开始考试").show();
            }
            C11792j.m20470c("网络状态发生变化");
            ExamActivity examActivity = ExamActivity.this;
            examActivity.f16772O = examActivity.m42270r0();
        }

        /* synthetic */ C4469h(ExamActivity examActivity, C4459a c4459a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A1 */
    public void m42323A1() {
        new SimpleDateFormat("HH:mm:ss").setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        this.f16774l.setEnabled(false);
        this.f16775m.setEnabled(false);
        this.f16770M = false;
        CountDownTimerC4462d countDownTimerC4462d = new CountDownTimerC4462d(this.f16769L * 1000, 1000L);
        this.f16781s = countDownTimerC4462d;
        countDownTimerC4462d.start();
    }

    /* renamed from: B1 */
    private void m42321B1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        CountDownTimerC4463e countDownTimerC4463e = new CountDownTimerC4463e(this.f16769L * 1000, 1000L, simpleDateFormat);
        this.f16782t = countDownTimerC4463e;
        countDownTimerC4463e.start();
    }

    /* renamed from: e1 */
    private void m42292e1() {
        this.f16773k.addOnPageChangeListener(new C4468g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f1 */
    public void m42291f1() {
        m42287i1(true);
    }

    /* renamed from: g1 */
    private boolean m42290g1(int index) {
        final int i = index + 1;
        if (!this.f16762E.contains(Integer.valueOf(i)) || this.f16763F.contains(Integer.valueOf(i))) {
            return false;
        }
        iOSOneButtonDialog buttonOnClickListener = new iOSOneButtonDialog(this.f1669h).setMessage("考试已暂停，请先进行人脸识别").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.formal.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamActivity.this.m42275o1(i, view);
            }
        });
        this.f16771N = buttonOnClickListener;
        buttonOnClickListener.setClickAutoCancel(false);
        this.f16771N.setCancelable(false);
        this.f16771N.setCanceledOnTouchOutside(false);
        this.f16771N.show();
        return true;
    }

    /* renamed from: h1 */
    private void m42289h1(final boolean autoCommit, String stuTeacherCurriculumId, List<Map<String, Object>> radioData, List<Map<String, Object>> checkData) {
        String jSONString = JSON.toJSONString(radioData);
        String jSONString2 = JSON.toJSONString(checkData);
        C11792j.m20465h(jSONString);
        C11792j.m20465h(jSONString2);
        Http.with(this.f1669h).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m70t1(stuTeacherCurriculumId, LoginUser.getLoginUser().getUserId(), jSONString, jSONString2, "", null, this.f16785w)).setDataListener(new C4464f(autoCommit));
    }

    /* renamed from: i1 */
    private void m42287i1(final boolean autoCommit) {
        final String stringExtra = getIntent().getStringExtra("stuTeacherCurriculumId");
        final List<Map<String, Object>> arrayList = new ArrayList<>();
        final List<Map<String, Object>> arrayList2 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f16788z.size(); i++) {
            Map<String, Object> map = this.f16788z.get(i);
            boolean z = JsonParse.getBoolean(map, "timeFinish");
            String str = ",";
            if ("1".equals(JsonParse.getString(this.f16788z.get(i), "questionType"))) {
                ArrayList arrayList3 = new ArrayList();
                Iterator it = ((List) this.f16788z.get(i).get("answers")).iterator();
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
                if (!z && arrayList3.isEmpty() && !autoCommit) {
                    sb.append(TextUtils.isEmpty(sb) ? "" : str3);
                    sb.append(String.valueOf(i + 1));
                }
            } else {
                String string = JsonParse.getString(map, "checkAnswerId");
                if (!z && string.isEmpty() && !autoCommit) {
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
            new iOSTwoButtonDialog(this.f1669h).setMessage(TextUtils.isEmpty(sb) ? "确定要提交试卷吗？" : "您还有第" + sb.toString() + "题未作答，是否要提交试卷？").setLeftButtonText("继续答题").setRightButtonText("直接交卷").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.exam.formal.g
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    ExamActivity.this.m42271q1(autoCommit, stringExtra, arrayList, arrayList2);
                }
            }).show();
            return;
        }
        m42289h1(autoCommit, stringExtra, arrayList, arrayList2);
    }

    /* renamed from: j1 */
    private void m42285j1() {
        String str;
        String str2 = null;
        String stringExtra = getIntent().hasExtra("stuTeacherCurriculumId") ? getIntent().getStringExtra("stuTeacherCurriculumId") : null;
        if (getIntent().hasExtra("selectIds")) {
            str = getIntent().getStringExtra("selectIds");
        } else {
            str2 = stringExtra;
            str = null;
        }
        Http.with(this.f1669h).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m69u(str2, str, LoginUser.getLoginUser().getUserId(), this.f16785w)).setDataListener(new C4460b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k1 */
    public void m42283k1() {
        if (m42290g1(0)) {
            return;
        }
        this.f16778p.setVisibility(0);
        m42281l1();
        this.f16780r.m57842c(this.f16788z);
        if (this.f16768K == 1) {
            this.f16777o.setVisibility(0);
            this.f16779q.setVisibility(8);
            m42321B1();
        } else {
            this.f16774l.setEnabled(false);
            this.f16775m.setEnabled(false);
            this.f16770M = false;
            this.f16777o.setVisibility(8);
            this.f16779q.setVisibility(0);
            m42323A1();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        C4469h c4469h = new C4469h(this, null);
        this.f16784v = c4469h;
        registerReceiver(c4469h, intentFilter);
    }

    /* renamed from: l1 */
    private void m42281l1() {
        int i = 0;
        while (i < this.f16788z.size()) {
            Fragment fragment = null;
            Map<String, Object> map = this.f16788z.get(i);
            if ("0".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new RadioExamFragment();
            } else if ("1".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new CheckboxExamFragment();
            } else if ("3".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new RadioExamFragment();
            } else {
                this.f16788z.remove(i);
                i--;
            }
            if (fragment != null) {
                Bundle bundle = new Bundle();
                SeralizableMap seralizableMap = new SeralizableMap();
                seralizableMap.setMap(map);
                bundle.putInt("index", i);
                bundle.putSerializable("seralizableMap", seralizableMap);
                fragment.setArguments(bundle);
                this.f16758A.add(fragment);
            }
            i++;
        }
        this.f16773k.setAdapter(new C4461c(getSupportFragmentManager()));
        setTitle("理论考试1/" + this.f16773k.getAdapter().getCount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m1 */
    public void m42279m1() {
        if (this.f16767J == 1) {
            this.f16774l.setVisibility(0);
            m57925b0(C4215R.mipmap.more_white, new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.student.home.teaching.exam.formal.e
                @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
                public final void onClick() {
                    ExamActivity.this.m42269r1();
                }
            });
            invalidateOptionsMenu();
            return;
        }
        this.f16774l.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n1 */
    public /* synthetic */ Unit m42277n1(int i) {
        Intent intent = new Intent(this.f1669h, FaceDetectExamActivity.class);
        intent.putExtra("faceIndex", i);
        startActivityForResult(intent, 187);
        overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: o1 */
    public /* synthetic */ void m42275o1(final int i, View view) {
        PermissionExt.m43841c(this.f1670i, "人脸识别", new InterfaceC15269a() { // from class: com.bxkj.student.home.teaching.exam.formal.i
            @Override // p617l1.InterfaceC15269a
            public final Object invoke() {
                Unit m42277n1;
                m42277n1 = ExamActivity.this.m42277n1(i);
                return m42277n1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p1 */
    public /* synthetic */ Unit m42273p1() {
        startActivityForResult(new Intent(this.f1669h, FaceDetectExamActivity.class), 255);
        overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q1 */
    public /* synthetic */ void m42271q1(boolean z, String str, List list, List list2) {
        if (this.f16760C == 1) {
            PermissionExt.m43841c(this.f1670i, "人脸识别", new InterfaceC15269a() { // from class: com.bxkj.student.home.teaching.exam.formal.h
                @Override // p617l1.InterfaceC15269a
                public final Object invoke() {
                    Unit m42273p1;
                    m42273p1 = ExamActivity.this.m42273p1();
                    return m42273p1;
                }
            });
        } else {
            m42289h1(z, str, list, list2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r0 */
    public boolean m42270r0() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            this.f16783u = connectivityManager;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r1 */
    public /* synthetic */ void m42269r1() {
        if (this.f16770M) {
            if (!this.f16772O) {
                new iOSOneButtonDialog(this.f1669h).setMessage("已脱离后台监控，请检查网络后开始考试").show();
            } else {
                m42255y1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t1 */
    public /* synthetic */ void m42265t1() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u1 */
    public /* synthetic */ void m42263u1(AdapterView adapterView, View view, int i, long j) {
        if (m42290g1(i)) {
            return;
        }
        m42259w1();
        this.f16773k.setCurrentItem(i);
        this.f16786x.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v1 */
    public static /* synthetic */ void m42261v1(FrameLayout frameLayout) {
        if (frameLayout != null) {
            frameLayout.setForeground(new ColorDrawable(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w1 */
    public void m42259w1() {
        Fragment fragment;
        List<Fragment> list = this.f16758A;
        if (list == null || (fragment = list.get(this.f16773k.getCurrentItem())) == null) {
            return;
        }
        if (fragment instanceof RadioExamFragment) {
            ((RadioExamFragment) fragment).m42245P();
        } else if (fragment instanceof CheckboxExamFragment) {
            ((CheckboxExamFragment) fragment).m42325O();
        }
    }

    /* renamed from: x1 */
    private void m42257x1() {
        if (this.f16773k.getCurrentItem() == this.f16773k.getAdapter().getCount() - 1) {
            m57919h0("已经是最后一题了");
        } else if (m42290g1(this.f16773k.getCurrentItem() + 1)) {
        } else {
            m42259w1();
            CustomViewPager customViewPager = this.f16773k;
            customViewPager.setCurrentItem(customViewPager.getCurrentItem() + 1);
        }
    }

    /* renamed from: y1 */
    private void m42255y1() {
        this.f16786x = new PopupWindow(-1, -2);
        View inflate = LayoutInflater.from(this.f1669h).inflate(C4215R.C4221layout.pop_dialog, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(C4215R.C4219id.f15997gv);
        gridView.setAdapter((ListAdapter) this.f16780r);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.exam.formal.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                ExamActivity.this.m42263u1(adapterView, view, i, j);
            }
        });
        this.f16786x.setBackgroundDrawable(new BitmapDrawable());
        this.f16786x.setOutsideTouchable(true);
        this.f16786x.setFocusable(true);
        final FrameLayout frameLayout = (FrameLayout) findViewById(2131233298);
        this.f16786x.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.bxkj.student.home.teaching.exam.formal.c
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                ExamActivity.m42261v1(frameLayout);
            }
        });
        this.f16786x.setContentView(inflate);
        this.f16786x.showAsDropDown(findViewById(2131232779));
        if (frameLayout != null) {
            frameLayout.setForeground(new ColorDrawable(Color.parseColor("#7F4c4c4c")));
        }
    }

    /* renamed from: z1 */
    private void m42253z1() {
        if (this.f16773k.getCurrentItem() == 0) {
            m57919h0("已经是第一题了");
            return;
        }
        int currentItem = this.f16773k.getCurrentItem() - 1;
        if (m42290g1(currentItem)) {
            return;
        }
        m42259w1();
        this.f16773k.setCurrentItem(currentItem);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16774l.setOnClickListener(this);
        this.f16775m.setOnClickListener(this);
        this.f16776n.setOnClickListener(this);
        m42292e1();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_exam;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        if (getIntent().hasExtra("onlineType")) {
            this.f16785w = getIntent().getIntExtra("onlineType", 0);
        }
        this.f16780r = new C4459a(this.f1669h, C4215R.C4221layout.item_for_number, this.f16788z);
        m42285j1();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("理论考试");
        m57927Z(new BaseActivity.InterfaceC1107c() { // from class: com.bxkj.student.home.teaching.exam.formal.d
            @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
            public final void onClick() {
                ExamActivity.this.m42267s1();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16773k = (CustomViewPager) findViewById(C4215R.C4219id.f16013vp);
        this.f16774l = (Button) findViewById(C4215R.C4219id.bt_previous);
        this.f16775m = (Button) findViewById(C4215R.C4219id.bt_next);
        this.f16776n = (Button) findViewById(2131230989);
        this.f16777o = (TextView) findViewById(2131233198);
        this.f16778p = (RelativeLayout) findViewById(2131232217);
        this.f16779q = (CountDownTimeView) findViewById(C4215R.C4219id.cdtv);
        this.f16773k.setPagingEnabled(false);
        this.f16778p.setVisibility(8);
        this.f16779q.setTextSize(DisplayUtil.m57757d(this.f1669h, 20.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 170 && resultCode == 187) {
            iOSOneButtonDialog iosonebuttondialog = this.f16787y;
            if (iosonebuttondialog != null && iosonebuttondialog.isShowing()) {
                this.f16787y.dismiss();
            }
            m42283k1();
            new iOSOneButtonDialog(this.f1669h).setMessage("人脸识别成功，请开始答题").show();
        } else if (requestCode != 187 || resultCode != 187) {
            if (requestCode == 255 && resultCode == 187) {
                m42287i1(true);
            } else if (resultCode == 170) {
                startActivityForResult(data.setClass(this.f1669h, FaceDetectExamActivity.class), requestCode);
                overridePendingTransition(2130771987, 2130771986);
            }
        } else {
            if (data.hasExtra("faceIndex")) {
                int intExtra = data.getIntExtra("faceIndex", 0);
                C11792j.m20470c("onActivityResult-faceIndex=" + intExtra);
                this.f16763F.add(Integer.valueOf(intExtra));
                int i = intExtra - 1;
                if (i == 0) {
                    m42283k1();
                } else {
                    m42259w1();
                    this.f16773k.setCurrentItem(i);
                    PopupWindow popupWindow = this.f16786x;
                    if (popupWindow != null && popupWindow.isShowing()) {
                        this.f16786x.dismiss();
                    }
                }
            }
            iOSOneButtonDialog iosonebuttondialog2 = this.f16771N;
            if (iosonebuttondialog2 != null && iosonebuttondialog2.isShowing()) {
                this.f16771N.dismiss();
            }
            new iOSOneButtonDialog(this.f1669h).setMessage("人脸识别成功，请继续答题").show();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void m42267s1() {
        new iOSTwoButtonDialog(this.f1669h).setMessage("正在考试，是否放弃考试？").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.exam.formal.f
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                ExamActivity.this.m42265t1();
            }
        }).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (!this.f16772O) {
            new iOSOneButtonDialog(this.f1669h).setMessage("已脱离后台监控，请检查网络后开始考试").show();
            return;
        }
        switch (v.getId()) {
            case C4215R.C4219id.bt_next /* 2131230988 */:
                m42257x1();
                return;
            case 2131230989:
                m42287i1(false);
                return;
            case C4215R.C4219id.bt_previous /* 2131230994 */:
                m42253z1();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CountDownTimer countDownTimer = this.f16782t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.f16781s;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        C4469h c4469h = this.f16784v;
        if (c4469h != null) {
            unregisterReceiver(c4469h);
        }
        super.onDestroy();
    }
}
