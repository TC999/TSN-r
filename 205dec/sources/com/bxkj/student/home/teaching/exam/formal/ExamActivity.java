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
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.w;
import com.bxkj.base.view.CountDownTimeView;
import com.bxkj.student.common.view.CustomViewPager;
import com.bxkj.student.home.teaching.exam.FaceDetectExamActivity;
import com.bxkj.student.home.teaching.exam.formal.ExamActivity;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.f1;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class ExamActivity extends BaseActivity {
    private int B;
    private int C;
    private int D;
    private iOSOneButtonDialog N;

    /* renamed from: k  reason: collision with root package name */
    private CustomViewPager f20149k;

    /* renamed from: l  reason: collision with root package name */
    public Button f20150l;

    /* renamed from: m  reason: collision with root package name */
    public Button f20151m;

    /* renamed from: n  reason: collision with root package name */
    private Button f20152n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f20153o;

    /* renamed from: p  reason: collision with root package name */
    private RelativeLayout f20154p;

    /* renamed from: q  reason: collision with root package name */
    private CountDownTimeView f20155q;

    /* renamed from: r  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f20156r;

    /* renamed from: s  reason: collision with root package name */
    private CountDownTimer f20157s;

    /* renamed from: t  reason: collision with root package name */
    private CountDownTimer f20158t;

    /* renamed from: u  reason: collision with root package name */
    private ConnectivityManager f20159u;

    /* renamed from: v  reason: collision with root package name */
    private h f20160v;

    /* renamed from: x  reason: collision with root package name */
    private PopupWindow f20162x;

    /* renamed from: y  reason: collision with root package name */
    private iOSOneButtonDialog f20163y;

    /* renamed from: w  reason: collision with root package name */
    private int f20161w = 0;

    /* renamed from: z  reason: collision with root package name */
    private List<Map<String, Object>> f20164z = new ArrayList();
    private List<Fragment> A = new ArrayList();
    private List<Integer> E = new ArrayList();
    private List<Integer> F = new ArrayList();
    private final int G = 170;
    private final int H = 187;
    private final int I = 255;
    private int J = 0;
    public int K = 1;

    /* renamed from: L  reason: collision with root package name */
    private int f20148L = 10800;
    public boolean M = true;
    private boolean O = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d */
        public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(2131233051, String.valueOf(holder.f() + 1));
            if ("1".equals(JsonParse.getString(stringObjectMap, "questionType"))) {
                List<Map<String, Object>> list = JsonParse.getList(stringObjectMap, "answers");
                ArrayList arrayList = new ArrayList();
                for (Map<String, Object> map : list) {
                    if (map.containsKey("icChecked") && ((Boolean) map.get("icChecked")).booleanValue()) {
                        arrayList.add(JsonParse.getString(map, "answerId"));
                    }
                }
                holder.l(2131233051, arrayList.isEmpty() ? 2131165924 : 2131165428);
                holder.K(2131233051, arrayList.isEmpty() ? ExamActivity.this.getResources().getColor(2131034190) : ExamActivity.this.getResources().getColor(2131034196));
                return;
            }
            holder.l(2131233051, JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty() ? 2131165924 : 2131165428);
            holder.K(2131233051, JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty() ? ExamActivity.this.getResources().getColor(2131034190) : ExamActivity.this.getResources().getColor(2131034196));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends HttpCallBack {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ f1 c() {
            ExamActivity.this.startActivityForResult(new Intent(((BaseActivity) ExamActivity.this).f1656h, FaceDetectExamActivity.class), 170);
            ExamActivity.this.overridePendingTransition(2130771987, 2130771986);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(View view) {
            com.bxkj.base.v2.common.ext.g.c(((BaseActivity) ExamActivity.this).f1657i, "\u4eba\u8138\u8bc6\u522b", new l1.a() { // from class: com.bxkj.student.home.teaching.exam.formal.k
                public final Object invoke() {
                    f1 c4;
                    c4 = ExamActivity.b.this.c();
                    return c4;
                }
            });
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1656h).setMessage("\u83b7\u53d6\u8003\u8bd5\u5185\u5bb9\u5f02\u5e38\uff0c\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458").show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ExamActivity.this.J = JsonParse.getInt(data, "isReturnExam");
            ExamActivity.this.B = JsonParse.getInt(data, "isExamStartFace");
            ExamActivity.this.C = JsonParse.getInt(data, "isExamEndFace");
            ExamActivity.this.D = JsonParse.getInt(data, "isExamFaceNum");
            ExamActivity examActivity = ExamActivity.this;
            examActivity.K = JsonParse.getInt(data, "examTimeType", examActivity.K);
            ExamActivity examActivity2 = ExamActivity.this;
            examActivity2.f20148L = JsonParse.getInt(data, "examTime", examActivity2.f20148L);
            ExamActivity.this.f20164z = JsonParse.getList(data, "examArray");
            if (ExamActivity.this.f20164z != null && ExamActivity.this.f20164z.size() > 0) {
                ExamActivity.this.m1();
                if (ExamActivity.this.D > 0) {
                    ExamActivity examActivity3 = ExamActivity.this;
                    examActivity3.E = w.a(examActivity3.f20164z.size(), ExamActivity.this.D);
                }
                if (ExamActivity.this.B == 1) {
                    ExamActivity.this.f20163y = new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1656h).setMessage("\u8003\u8bd5\u5f00\u59cb\u524d\uff0c\u8bf7\u5148\u8fdb\u884c\u4eba\u8138\u8bc6\u522b").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.formal.j
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            ExamActivity.b.this.d(view);
                        }
                    });
                    ExamActivity.this.f20163y.setClickAutoCancel(false);
                    ExamActivity.this.f20163y.setCancelable(false);
                    ExamActivity.this.f20163y.setCanceledOnTouchOutside(false);
                    ExamActivity.this.f20163y.show();
                    return;
                }
                ExamActivity.this.k1();
                return;
            }
            new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1656h).setMessage("\u6ca1\u6709\u9898\u76ee").show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends FragmentPagerAdapter {
        c(FragmentManager fm) {
            super(fm);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return ExamActivity.this.A.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return (Fragment) ExamActivity.this.A.get(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d extends CountDownTimer {
        d(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ExamActivity.this.f20155q.i(ExamActivity.this.f20148L, 0);
            if (ExamActivity.this.f20164z != null) {
                ((Map) ExamActivity.this.f20164z.get(ExamActivity.this.f20149k.getCurrentItem())).put("timeFinish", Boolean.TRUE);
                ExamActivity.this.w1();
                ExamActivity.this.f20150l.setEnabled(true);
                ExamActivity.this.f20151m.setEnabled(true);
                ExamActivity.this.M = true;
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            ExamActivity.this.f20155q.i(ExamActivity.this.f20148L, ((int) millisUntilFinished) / 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SimpleDateFormat f20169a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long millisInFuture, long countDownInterval, final SimpleDateFormat val$simpleDateFormat) {
            super(millisInFuture, countDownInterval);
            this.f20169a = val$simpleDateFormat;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ExamActivity.this.f1();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            ExamActivity.this.f20153o.setText(this.f20169a.format(Long.valueOf(millisUntilFinished)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f20171a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                ExamActivity.this.finish();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                ExamActivity.this.finish();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class c implements View.OnClickListener {
            c() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                ExamActivity.this.finish();
            }
        }

        f(final boolean val$autoCommit) {
            this.f20171a = val$autoCommit;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            if (this.f20171a) {
                new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1656h).setButtonOnClickListener(new c()).setMessage("\u65f6\u95f4\u5df2\u5230\uff0c\u81ea\u52a8\u4ea4\u5377\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u8003\u8bd5").show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1656h).setButtonOnClickListener(new b()).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            String str = (this.f20171a && ExamActivity.this.C == 0) ? "\u65f6\u95f4\u5df2\u5230\uff0c\u5df2\u7ecf\u4e3a\u60a8\u81ea\u52a8\u4ea4\u5377\u6210\u529f" : "\u4ea4\u5377\u6210\u529f";
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1656h);
            iosonebuttondialog.setCancelable(false);
            iosonebuttondialog.setMessage(str).setButtonOnClickListener(new a()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class g implements ViewPager.OnPageChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private int f20176a;

        g() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            this.f20176a = state;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (this.f20176a == 1 && positionOffsetPixels == 0) {
                if (position == 0) {
                    ExamActivity.this.h0("\u5df2\u7ecf\u662f\u7b2c\u4e00\u9898\u4e86");
                } else if (position == ExamActivity.this.f20149k.getAdapter().getCount() - 1) {
                    ExamActivity.this.h0("\u5df2\u7ecf\u662f\u6700\u540e\u4e00\u9898\u4e86");
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            ExamActivity examActivity = ExamActivity.this;
            examActivity.setTitle("\u7406\u8bba\u8003\u8bd5" + (position + 1) + TTPathConst.sSeparator + ExamActivity.this.f20149k.getAdapter().getCount());
            ExamActivity examActivity2 = ExamActivity.this;
            if (examActivity2.K != 1) {
                if (examActivity2.f20157s != null) {
                    ExamActivity.this.f20157s.cancel();
                }
                ExamActivity.this.f20155q.i(ExamActivity.this.f20148L, 0);
                if ("1".equals(JsonParse.getString((Map) ExamActivity.this.f20164z.get(ExamActivity.this.f20149k.getCurrentItem()), "questionType"))) {
                    boolean z3 = false;
                    for (Map<String, Object> map : JsonParse.getList((Map) ExamActivity.this.f20164z.get(ExamActivity.this.f20149k.getCurrentItem()), "answers")) {
                        if (map.containsKey("icChecked") && ((Boolean) map.get("icChecked")).booleanValue()) {
                            z3 = true;
                        }
                    }
                    if (JsonParse.getBoolean((Map) ExamActivity.this.f20164z.get(ExamActivity.this.f20149k.getCurrentItem()), "timeFinish") || z3) {
                        return;
                    }
                    ExamActivity.this.A1();
                } else if (!JsonParse.getBoolean((Map) ExamActivity.this.f20164z.get(ExamActivity.this.f20149k.getCurrentItem()), "timeFinish") && TextUtils.isEmpty(JsonParse.getString((Map) ExamActivity.this.f20164z.get(ExamActivity.this.f20149k.getCurrentItem()), "checkAnswerId"))) {
                    ExamActivity.this.A1();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class h extends BroadcastReceiver {
        private h() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!ExamActivity.this.r0()) {
                new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1656h).setMessage("\u5df2\u8131\u79bb\u540e\u53f0\u76d1\u63a7\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u540e\u5f00\u59cb\u8003\u8bd5").show();
            } else if (!ExamActivity.this.O) {
                new iOSOneButtonDialog(((BaseActivity) ExamActivity.this).f1656h).setMessage("\u7f51\u7edc\u5df2\u6062\u590d\uff0c\u8bf7\u7ee7\u7eed\u5f00\u59cb\u8003\u8bd5").show();
            }
            com.orhanobut.logger.j.c("\u7f51\u7edc\u72b6\u6001\u53d1\u751f\u53d8\u5316");
            ExamActivity examActivity = ExamActivity.this;
            examActivity.O = examActivity.r0();
        }

        /* synthetic */ h(ExamActivity examActivity, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A1() {
        new SimpleDateFormat("HH:mm:ss").setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        this.f20150l.setEnabled(false);
        this.f20151m.setEnabled(false);
        this.M = false;
        d dVar = new d(this.f20148L * 1000, 1000L);
        this.f20157s = dVar;
        dVar.start();
    }

    private void B1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        e eVar = new e(this.f20148L * 1000, 1000L, simpleDateFormat);
        this.f20158t = eVar;
        eVar.start();
    }

    private void e1() {
        this.f20149k.addOnPageChangeListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1() {
        i1(true);
    }

    private boolean g1(int index) {
        final int i4 = index + 1;
        if (!this.E.contains(Integer.valueOf(i4)) || this.F.contains(Integer.valueOf(i4))) {
            return false;
        }
        iOSOneButtonDialog buttonOnClickListener = new iOSOneButtonDialog(this.f1656h).setMessage("\u8003\u8bd5\u5df2\u6682\u505c\uff0c\u8bf7\u5148\u8fdb\u884c\u4eba\u8138\u8bc6\u522b").setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.exam.formal.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExamActivity.this.o1(i4, view);
            }
        });
        this.N = buttonOnClickListener;
        buttonOnClickListener.setClickAutoCancel(false);
        this.N.setCancelable(false);
        this.N.setCanceledOnTouchOutside(false);
        this.N.show();
        return true;
    }

    private void h1(final boolean autoCommit, String stuTeacherCurriculumId, List<Map<String, Object>> radioData, List<Map<String, Object>> checkData) {
        String jSONString = JSON.toJSONString(radioData);
        String jSONString2 = JSON.toJSONString(checkData);
        com.orhanobut.logger.j.h(jSONString);
        com.orhanobut.logger.j.h(jSONString2);
        Http.with(this.f1656h).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((w.a) Http.getApiService(w.a.class)).t1(stuTeacherCurriculumId, LoginUser.getLoginUser().getUserId(), jSONString, jSONString2, "", null, this.f20161w)).setDataListener(new f(autoCommit));
    }

    private void i1(final boolean autoCommit) {
        final String stringExtra = getIntent().getStringExtra("stuTeacherCurriculumId");
        final List<Map<String, Object>> arrayList = new ArrayList<>();
        final List<Map<String, Object>> arrayList2 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < this.f20164z.size(); i4++) {
            Map<String, Object> map = this.f20164z.get(i4);
            boolean z3 = JsonParse.getBoolean(map, "timeFinish");
            String str = ",";
            if ("1".equals(JsonParse.getString(this.f20164z.get(i4), "questionType"))) {
                ArrayList arrayList3 = new ArrayList();
                Iterator it = ((List) this.f20164z.get(i4).get("answers")).iterator();
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
                if (!z3 && arrayList3.isEmpty() && !autoCommit) {
                    sb.append(TextUtils.isEmpty(sb) ? "" : str3);
                    sb.append(String.valueOf(i4 + 1));
                }
            } else {
                String string = JsonParse.getString(map, "checkAnswerId");
                if (!z3 && string.isEmpty() && !autoCommit) {
                    sb.append(TextUtils.isEmpty(sb) ? "" : ",");
                    sb.append(String.valueOf(i4 + 1));
                }
                Map<String, Object> arrayMap2 = new ArrayMap<>();
                arrayMap2.put("question", JsonParse.getString(map, "questionId"));
                arrayMap2.put("answers", string);
                arrayMap2.put("scoreId", JsonParse.getString(map, "scoreId"));
                arrayList.add(arrayMap2);
            }
        }
        if (!autoCommit) {
            new iOSTwoButtonDialog(this.f1656h).setMessage(TextUtils.isEmpty(sb) ? "\u786e\u5b9a\u8981\u63d0\u4ea4\u8bd5\u5377\u5417\uff1f" : "\u60a8\u8fd8\u6709\u7b2c" + sb.toString() + "\u9898\u672a\u4f5c\u7b54\uff0c\u662f\u5426\u8981\u63d0\u4ea4\u8bd5\u5377\uff1f").setLeftButtonText("\u7ee7\u7eed\u7b54\u9898").setRightButtonText("\u76f4\u63a5\u4ea4\u5377").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.exam.formal.g
                @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
                public final void buttonRightOnClick() {
                    ExamActivity.this.q1(autoCommit, stringExtra, arrayList, arrayList2);
                }
            }).show();
            return;
        }
        h1(autoCommit, stringExtra, arrayList, arrayList2);
    }

    private void j1() {
        String str;
        String str2 = null;
        String stringExtra = getIntent().hasExtra("stuTeacherCurriculumId") ? getIntent().getStringExtra("stuTeacherCurriculumId") : null;
        if (getIntent().hasExtra("selectIds")) {
            str = getIntent().getStringExtra("selectIds");
        } else {
            str2 = stringExtra;
            str = null;
        }
        Http.with(this.f1656h).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((w.a) Http.getApiService(w.a.class)).u(str2, str, LoginUser.getLoginUser().getUserId(), this.f20161w)).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1() {
        if (g1(0)) {
            return;
        }
        this.f20154p.setVisibility(0);
        l1();
        this.f20156r.c(this.f20164z);
        if (this.K == 1) {
            this.f20153o.setVisibility(0);
            this.f20155q.setVisibility(8);
            B1();
        } else {
            this.f20150l.setEnabled(false);
            this.f20151m.setEnabled(false);
            this.M = false;
            this.f20153o.setVisibility(8);
            this.f20155q.setVisibility(0);
            A1();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        h hVar = new h(this, null);
        this.f20160v = hVar;
        registerReceiver(hVar, intentFilter);
    }

    private void l1() {
        int i4 = 0;
        while (i4 < this.f20164z.size()) {
            Fragment fragment = null;
            Map<String, Object> map = this.f20164z.get(i4);
            if ("0".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new RadioExamFragment();
            } else if ("1".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new CheckboxExamFragment();
            } else if ("3".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new RadioExamFragment();
            } else {
                this.f20164z.remove(i4);
                i4--;
            }
            if (fragment != null) {
                Bundle bundle = new Bundle();
                SeralizableMap seralizableMap = new SeralizableMap();
                seralizableMap.setMap(map);
                bundle.putInt("index", i4);
                bundle.putSerializable("seralizableMap", seralizableMap);
                fragment.setArguments(bundle);
                this.A.add(fragment);
            }
            i4++;
        }
        this.f20149k.setAdapter(new c(getSupportFragmentManager()));
        setTitle("\u7406\u8bba\u8003\u8bd51/" + this.f20149k.getAdapter().getCount());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1() {
        if (this.J == 1) {
            this.f20150l.setVisibility(0);
            b0(2131558835, new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.exam.formal.e
                @Override // cn.bluemobi.dylan.base.BaseActivity.c
                public final void onClick() {
                    ExamActivity.this.r1();
                }
            });
            invalidateOptionsMenu();
            return;
        }
        this.f20150l.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 n1(int i4) {
        Intent intent = new Intent(this.f1656h, FaceDetectExamActivity.class);
        intent.putExtra("faceIndex", i4);
        startActivityForResult(intent, 187);
        overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o1(final int i4, View view) {
        com.bxkj.base.v2.common.ext.g.c(this.f1657i, "\u4eba\u8138\u8bc6\u522b", new l1.a() { // from class: com.bxkj.student.home.teaching.exam.formal.i
            public final Object invoke() {
                f1 n12;
                n12 = ExamActivity.this.n1(i4);
                return n12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ f1 p1() {
        startActivityForResult(new Intent(this.f1656h, FaceDetectExamActivity.class), 255);
        overridePendingTransition(2130771987, 2130771986);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q1(boolean z3, String str, List list, List list2) {
        if (this.C == 1) {
            com.bxkj.base.v2.common.ext.g.c(this.f1657i, "\u4eba\u8138\u8bc6\u522b", new l1.a() { // from class: com.bxkj.student.home.teaching.exam.formal.h
                public final Object invoke() {
                    f1 p12;
                    p12 = ExamActivity.this.p1();
                    return p12;
                }
            });
        } else {
            h1(z3, str, list, list2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r0() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            this.f20159u = connectivityManager;
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    return activeNetworkInfo.isAvailable();
                }
                return true;
            }
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r1() {
        if (this.M) {
            if (!this.O) {
                new iOSOneButtonDialog(this.f1656h).setMessage("\u5df2\u8131\u79bb\u540e\u53f0\u76d1\u63a7\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u540e\u5f00\u59cb\u8003\u8bd5").show();
            } else {
                y1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t1() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u1(AdapterView adapterView, View view, int i4, long j4) {
        if (g1(i4)) {
            return;
        }
        w1();
        this.f20149k.setCurrentItem(i4);
        this.f20162x.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v1(FrameLayout frameLayout) {
        if (frameLayout != null) {
            frameLayout.setForeground(new ColorDrawable(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1() {
        Fragment fragment;
        List<Fragment> list = this.A;
        if (list == null || (fragment = list.get(this.f20149k.getCurrentItem())) == null) {
            return;
        }
        if (fragment instanceof RadioExamFragment) {
            ((RadioExamFragment) fragment).P();
        } else if (fragment instanceof CheckboxExamFragment) {
            ((CheckboxExamFragment) fragment).O();
        }
    }

    private void x1() {
        if (this.f20149k.getCurrentItem() == this.f20149k.getAdapter().getCount() - 1) {
            h0("\u5df2\u7ecf\u662f\u6700\u540e\u4e00\u9898\u4e86");
        } else if (g1(this.f20149k.getCurrentItem() + 1)) {
        } else {
            w1();
            CustomViewPager customViewPager = this.f20149k;
            customViewPager.setCurrentItem(customViewPager.getCurrentItem() + 1);
        }
    }

    private void y1() {
        this.f20162x = new PopupWindow(-1, -2);
        View inflate = LayoutInflater.from(this.f1656h).inflate(2131428016, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(2131231333);
        gridView.setAdapter((ListAdapter) this.f20156r);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.home.teaching.exam.formal.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
                ExamActivity.this.u1(adapterView, view, i4, j4);
            }
        });
        this.f20162x.setBackgroundDrawable(new BitmapDrawable());
        this.f20162x.setOutsideTouchable(true);
        this.f20162x.setFocusable(true);
        final FrameLayout frameLayout = (FrameLayout) findViewById(2131233298);
        this.f20162x.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.bxkj.student.home.teaching.exam.formal.c
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                ExamActivity.v1(frameLayout);
            }
        });
        this.f20162x.setContentView(inflate);
        this.f20162x.showAsDropDown(findViewById(2131232779));
        if (frameLayout != null) {
            frameLayout.setForeground(new ColorDrawable(Color.parseColor("#7F4c4c4c")));
        }
    }

    private void z1() {
        if (this.f20149k.getCurrentItem() == 0) {
            h0("\u5df2\u7ecf\u662f\u7b2c\u4e00\u9898\u4e86");
            return;
        }
        int currentItem = this.f20149k.getCurrentItem() - 1;
        if (g1(currentItem)) {
            return;
        }
        w1();
        this.f20149k.setCurrentItem(currentItem);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20150l.setOnClickListener(this);
        this.f20151m.setOnClickListener(this);
        this.f20152n.setOnClickListener(this);
        e1();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427394;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("onlineType")) {
            this.f20161w = getIntent().getIntExtra("onlineType", 0);
        }
        this.f20156r = new a(this.f1656h, 2131427731, this.f20164z);
        j1();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u7406\u8bba\u8003\u8bd5");
        Z(new BaseActivity.c() { // from class: com.bxkj.student.home.teaching.exam.formal.d
            @Override // cn.bluemobi.dylan.base.BaseActivity.c
            public final void onClick() {
                ExamActivity.this.s1();
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20149k = (CustomViewPager) findViewById(2131233313);
        this.f20150l = (Button) findViewById(2131230994);
        this.f20151m = (Button) findViewById(2131230988);
        this.f20152n = (Button) findViewById(2131230989);
        this.f20153o = (TextView) findViewById(2131233198);
        this.f20154p = (RelativeLayout) findViewById(2131232217);
        this.f20155q = (CountDownTimeView) findViewById(2131231089);
        this.f20149k.setPagingEnabled(false);
        this.f20154p.setVisibility(8);
        this.f20155q.setTextSize(cn.bluemobi.dylan.base.utils.d.d(this.f1656h, 20.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 170 && resultCode == 187) {
            iOSOneButtonDialog iosonebuttondialog = this.f20163y;
            if (iosonebuttondialog != null && iosonebuttondialog.isShowing()) {
                this.f20163y.dismiss();
            }
            k1();
            new iOSOneButtonDialog(this.f1656h).setMessage("\u4eba\u8138\u8bc6\u522b\u6210\u529f\uff0c\u8bf7\u5f00\u59cb\u7b54\u9898").show();
        } else if (requestCode != 187 || resultCode != 187) {
            if (requestCode == 255 && resultCode == 187) {
                i1(true);
            } else if (resultCode == 170) {
                startActivityForResult(data.setClass(this.f1656h, FaceDetectExamActivity.class), requestCode);
                overridePendingTransition(2130771987, 2130771986);
            }
        } else {
            if (data.hasExtra("faceIndex")) {
                int intExtra = data.getIntExtra("faceIndex", 0);
                com.orhanobut.logger.j.c("onActivityResult-faceIndex=" + intExtra);
                this.F.add(Integer.valueOf(intExtra));
                int i4 = intExtra - 1;
                if (i4 == 0) {
                    k1();
                } else {
                    w1();
                    this.f20149k.setCurrentItem(i4);
                    PopupWindow popupWindow = this.f20162x;
                    if (popupWindow != null && popupWindow.isShowing()) {
                        this.f20162x.dismiss();
                    }
                }
            }
            iOSOneButtonDialog iosonebuttondialog2 = this.N;
            if (iosonebuttondialog2 != null && iosonebuttondialog2.isShowing()) {
                this.N.dismiss();
            }
            new iOSOneButtonDialog(this.f1656h).setMessage("\u4eba\u8138\u8bc6\u522b\u6210\u529f\uff0c\u8bf7\u7ee7\u7eed\u7b54\u9898").show();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void s1() {
        new iOSTwoButtonDialog(this.f1656h).setMessage("\u6b63\u5728\u8003\u8bd5\uff0c\u662f\u5426\u653e\u5f03\u8003\u8bd5\uff1f").setRightButtonOnClickListener(new iOSTwoButtonDialog.RightButtonOnClick() { // from class: com.bxkj.student.home.teaching.exam.formal.f
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public final void buttonRightOnClick() {
                ExamActivity.this.t1();
            }
        }).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (!this.O) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u5df2\u8131\u79bb\u540e\u53f0\u76d1\u63a7\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u540e\u5f00\u59cb\u8003\u8bd5").show();
            return;
        }
        switch (v3.getId()) {
            case 2131230988:
                x1();
                return;
            case 2131230989:
                i1(false);
                return;
            case 2131230994:
                z1();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CountDownTimer countDownTimer = this.f20158t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.f20157s;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        h hVar = this.f20160v;
        if (hVar != null) {
            unregisterReceiver(hVar);
        }
        super.onDestroy();
    }
}
