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
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.CountDownTimeView;
import com.bxkj.student.common.view.CustomViewPager;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class NewExamActivity extends BaseActivity {
    private long A;

    /* renamed from: k  reason: collision with root package name */
    private TextView f20216k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f20217l;

    /* renamed from: m  reason: collision with root package name */
    private CountDownTimeView f20218m;

    /* renamed from: n  reason: collision with root package name */
    private CustomViewPager f20219n;

    /* renamed from: o  reason: collision with root package name */
    public Button f20220o;

    /* renamed from: p  reason: collision with root package name */
    public Button f20221p;

    /* renamed from: q  reason: collision with root package name */
    private Button f20222q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f20223r;

    /* renamed from: s  reason: collision with root package name */
    private RelativeLayout f20224s;

    /* renamed from: t  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f20225t;

    /* renamed from: u  reason: collision with root package name */
    private CountDownTimer f20226u;

    /* renamed from: v  reason: collision with root package name */
    private CountDownTimer f20227v;

    /* renamed from: w  reason: collision with root package name */
    private ConnectivityManager f20228w;

    /* renamed from: x  reason: collision with root package name */
    private m f20229x;

    /* renamed from: y  reason: collision with root package name */
    private int f20230y = 30;

    /* renamed from: z  reason: collision with root package name */
    private int f20231z = 0;
    private String B = "\u4f53\u80b2\u4e13\u4e1a\u9898\u5e93";
    public int C = 1;
    private List<Map<String, Object>> D = new ArrayList();
    private List<Fragment> E = new ArrayList();
    private boolean F = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements ViewPager.OnPageChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private int f20232a;

        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            this.f20232a = state;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (this.f20232a == 1 && positionOffsetPixels == 0) {
                if (position == 0) {
                    NewExamActivity.this.h0("\u5df2\u7ecf\u662f\u7b2c\u4e00\u9898\u4e86");
                } else if (position == NewExamActivity.this.f20219n.getAdapter().getCount() - 1) {
                    NewExamActivity.this.h0("\u5df2\u7ecf\u662f\u6700\u540e\u4e00\u9898\u4e86");
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            NewExamActivity newExamActivity = NewExamActivity.this;
            newExamActivity.setTitle(NewExamActivity.this.B + (position + 1) + TTPathConst.sSeparator + NewExamActivity.this.f20219n.getAdapter().getCount());
            if (NewExamActivity.this.f20226u != null) {
                NewExamActivity.this.f20226u.cancel();
            }
            NewExamActivity.this.f20218m.i(NewExamActivity.this.f20230y, 0);
            if ("1".equals(JsonParse.getString((Map) NewExamActivity.this.D.get(NewExamActivity.this.f20219n.getCurrentItem()), "questionType"))) {
                boolean z3 = false;
                for (Map<String, Object> map : JsonParse.getList((Map) NewExamActivity.this.D.get(NewExamActivity.this.f20219n.getCurrentItem()), "answers")) {
                    if (map.containsKey("icChecked") && ((Boolean) map.get("icChecked")).booleanValue()) {
                        z3 = true;
                    }
                }
                if (!JsonParse.getBoolean((Map) NewExamActivity.this.D.get(NewExamActivity.this.f20219n.getCurrentItem()), "timeFinish") && !z3) {
                    NewExamActivity.this.f20220o.setEnabled(false);
                    NewExamActivity.this.f20221p.setEnabled(false);
                    NewExamActivity newExamActivity2 = NewExamActivity.this;
                    if (newExamActivity2.C == 0) {
                        newExamActivity2.e1();
                    }
                }
            } else if (!JsonParse.getBoolean((Map) NewExamActivity.this.D.get(NewExamActivity.this.f20219n.getCurrentItem()), "timeFinish") && TextUtils.isEmpty(JsonParse.getString((Map) NewExamActivity.this.D.get(NewExamActivity.this.f20219n.getCurrentItem()), "checkAnswerId"))) {
                NewExamActivity.this.f20220o.setEnabled(false);
                NewExamActivity.this.f20221p.setEnabled(false);
                NewExamActivity newExamActivity3 = NewExamActivity.this;
                if (newExamActivity3.C == 0) {
                    newExamActivity3.e1();
                }
            }
            TextView textView = NewExamActivity.this.f20217l;
            textView.setText("\u51fa\u9898\u4eba\uff1a" + JsonParse.getString((Map) NewExamActivity.this.D.get(position), "questionsSetter"));
            TextView textView2 = NewExamActivity.this.f20216k;
            textView2.setText("\u8bfe\u7a0b\u540d\u79f0\uff1a" + JsonParse.getString((Map) NewExamActivity.this.D.get(position), "curriculum"));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements AdapterView.OnItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PopupWindow f20234a;

        b(final PopupWindow val$popupWindow) {
            this.f20234a = val$popupWindow;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            NewExamActivity.this.f20219n.setCurrentItem(position);
            this.f20234a.dismiss();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements PopupWindow.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FrameLayout f20236a;

        c(final FrameLayout val$outsideView) {
            this.f20236a = val$outsideView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            FrameLayout frameLayout = this.f20236a;
            if (frameLayout != null) {
                frameLayout.setForeground(new ColorDrawable(0));
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d implements BaseActivity.c {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            NewExamActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e implements iOSTwoButtonDialog.RightButtonOnClick {
        e() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            NewExamActivity.this.finish();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class f extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        f(Context context, int layoutId, List datas) {
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
                holder.K(2131233051, arrayList.isEmpty() ? NewExamActivity.this.getResources().getColor(2131034190) : NewExamActivity.this.getResources().getColor(2131034196));
                return;
            }
            holder.l(2131233051, JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty() ? 2131165924 : 2131165428);
            holder.K(2131233051, JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty() ? NewExamActivity.this.getResources().getColor(2131034190) : NewExamActivity.this.getResources().getColor(2131034196));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class h extends FragmentPagerAdapter {
        h(FragmentManager fm) {
            super(fm);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return NewExamActivity.this.E.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return (Fragment) NewExamActivity.this.E.get(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class i extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SimpleDateFormat f20243a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(long millisInFuture, long countDownInterval, final SimpleDateFormat val$simpleDateFormat) {
            super(millisInFuture, countDownInterval);
            this.f20243a = val$simpleDateFormat;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            for (Map map : NewExamActivity.this.D) {
                map.put("timeFinish", Boolean.TRUE);
            }
            for (Fragment fragment : NewExamActivity.this.E) {
                if (fragment instanceof NewRadioExamFragment) {
                    ((NewRadioExamFragment) fragment).R();
                } else if (fragment instanceof NewCheckboxExamFragment) {
                    ((NewCheckboxExamFragment) fragment).P();
                }
            }
            NewExamActivity.this.U0();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            NewExamActivity.this.f20223r.setText(this.f20243a.format(Long.valueOf(millisUntilFinished)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class j extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SimpleDateFormat f20245a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(long millisInFuture, long countDownInterval, final SimpleDateFormat val$simpleDateFormat) {
            super(millisInFuture, countDownInterval);
            this.f20245a = val$simpleDateFormat;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            NewExamActivity.this.f20218m.i(NewExamActivity.this.f20230y, 0);
            if (NewExamActivity.this.D != null) {
                ((Map) NewExamActivity.this.D.get(NewExamActivity.this.f20219n.getCurrentItem())).put("timeFinish", Boolean.TRUE);
                Fragment fragment = (Fragment) NewExamActivity.this.E.get(NewExamActivity.this.f20219n.getCurrentItem());
                if (fragment instanceof NewRadioExamFragment) {
                    ((NewRadioExamFragment) fragment).R();
                    NewExamActivity.this.f20220o.setEnabled(true);
                    NewExamActivity.this.f20221p.setEnabled(true);
                } else if (fragment instanceof NewCheckboxExamFragment) {
                    ((NewCheckboxExamFragment) fragment).P();
                    NewExamActivity.this.f20220o.setEnabled(true);
                    NewExamActivity.this.f20221p.setEnabled(true);
                }
                NewExamActivity.this.a1();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            NewExamActivity.this.f20218m.i(NewExamActivity.this.f20230y, ((int) millisUntilFinished) / 1000);
            NewExamActivity.this.f20223r.setText(this.f20245a.format(Long.valueOf(millisUntilFinished)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class k implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f20247a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f20248b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f20249c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ List f20250d;

        k(final boolean val$autoCommit, final String val$stuTeacherCurriculumId, final List val$radioData, final List val$checkData) {
            this.f20247a = val$autoCommit;
            this.f20248b = val$stuTeacherCurriculumId;
            this.f20249c = val$radioData;
            this.f20250d = val$checkData;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            NewExamActivity.this.W0(this.f20247a, this.f20248b, this.f20249c, this.f20250d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class l extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f20252a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                NewExamActivity.this.finish();
            }
        }

        l(final boolean val$autoCommit) {
            this.f20252a = val$autoCommit;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            if (this.f20252a) {
                new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).f1656h).setMessage("\u65f6\u95f4\u5df2\u5230\uff0c\u81ea\u52a8\u4ea4\u5377\u5931\u8d25\uff0c\u8bf7\u624b\u52a8\u4ea4\u5377").show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            String str = this.f20252a ? "\u65f6\u95f4\u5df2\u5230\uff0c\u5df2\u7ecf\u4e3a\u60a8\u81ea\u52a8\u4ea4\u5377\u6210\u529f" : "\u4ea4\u5377\u6210\u529f";
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).f1656h);
            iosonebuttondialog.setCancelable(false);
            iosonebuttondialog.setMessage(str).setButtonOnClickListener(new a()).show();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    private class m extends BroadcastReceiver {
        private m() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!NewExamActivity.this.i0()) {
                new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).f1656h).setMessage("\u5df2\u8131\u79bb\u540e\u53f0\u76d1\u63a7\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u540e\u5f00\u59cb\u8003\u8bd5").show();
            } else if (!NewExamActivity.this.F) {
                new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).f1656h).setMessage("\u7f51\u7edc\u5df2\u6062\u590d\uff0c\u8bf7\u7ee7\u7eed\u5f00\u59cb\u8003\u8bd5").show();
            }
            com.orhanobut.logger.j.c("\u7f51\u7edc\u72b6\u6001\u53d1\u751f\u53d8\u5316");
            NewExamActivity newExamActivity = NewExamActivity.this;
            newExamActivity.F = newExamActivity.i0();
        }

        /* synthetic */ m(NewExamActivity newExamActivity, d dVar) {
            this();
        }
    }

    private void T0() {
        this.f20219n.addOnPageChangeListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        X0(true);
    }

    private String V0(long milliSecondTime) {
        String valueOf;
        String valueOf2;
        String valueOf3;
        long j4 = milliSecondTime / 3600000;
        long j5 = milliSecondTime - (((j4 * 60) * 60) * 1000);
        long j6 = j5 / 60000;
        long j7 = (j5 - ((j6 * 60) * 1000)) / 1000;
        if (j7 >= 60) {
            j7 %= 60;
            j6 += j7 / 60;
        }
        if (j6 >= 60) {
            j6 %= 60;
            j4 += j6 / 60;
        }
        if (j4 < 10) {
            valueOf = "0" + String.valueOf(j4);
        } else {
            valueOf = String.valueOf(j4);
        }
        if (j6 < 10) {
            valueOf2 = "0" + String.valueOf(j6);
        } else {
            valueOf2 = String.valueOf(j6);
        }
        if (j7 < 10) {
            valueOf3 = "0" + String.valueOf(j7);
        } else {
            valueOf3 = String.valueOf(j7);
        }
        return valueOf + ":" + valueOf2 + ":" + valueOf3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(final boolean autoCommit, String stuTeacherCurriculumId, List<Map<String, Object>> radioData, List<Map<String, Object>> checkData) {
        String jSONString = JSON.toJSONString(radioData);
        String jSONString2 = JSON.toJSONString(checkData);
        com.orhanobut.logger.j.h(jSONString);
        com.orhanobut.logger.j.h(jSONString2);
        Http.with(this.f1656h).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((w.a) Http.getApiService(w.a.class)).t1(stuTeacherCurriculumId, LoginUser.getLoginUser().getUserId(), jSONString, jSONString2, "", String.valueOf(this.A), this.f20231z)).setDataListener(new l(autoCommit));
    }

    private void X0(final boolean autoCommit) {
        String stringExtra = getIntent().getStringExtra("stuTeacherCurriculumId");
        List<Map<String, Object>> arrayList = new ArrayList<>();
        List<Map<String, Object>> arrayList2 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < this.D.size(); i4++) {
            Map<String, Object> map = this.D.get(i4);
            String str = "";
            if ("1".equals(JsonParse.getString(this.D.get(i4), "questionType"))) {
                ArrayList arrayList3 = new ArrayList();
                Iterator it = ((List) this.D.get(i4).get("answers")).iterator();
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
                    sb.append(String.valueOf(i4 + 1));
                }
            } else {
                String string = JsonParse.getString(map, "checkAnswerId");
                if (string.isEmpty() && !autoCommit) {
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
            new iOSTwoButtonDialog(this.f1656h).setMessage("\u786e\u5b9a\u8981\u63d0\u4ea4\u8bd5\u5377\u5417\uff1f").setLeftButtonText("\u7ee7\u7eed\u7b54\u9898").setRightButtonText("\u76f4\u63a5\u4ea4\u5377").setRightButtonOnClickListener(new k(autoCommit, stringExtra, arrayList, arrayList2)).show();
        } else {
            W0(autoCommit, stringExtra, arrayList, arrayList2);
        }
    }

    private void Y0() {
        String str;
        String str2 = null;
        String stringExtra = getIntent().hasExtra("stuTeacherCurriculumId") ? getIntent().getStringExtra("stuTeacherCurriculumId") : null;
        if (getIntent().hasExtra("selectIds")) {
            str = getIntent().getStringExtra("selectIds");
        } else {
            str2 = stringExtra;
            str = null;
        }
        Http.with(this.f1656h).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((w.a) Http.getApiService(w.a.class)).u(str2, str, LoginUser.getLoginUser().getUserId(), this.f20231z)).setDataListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        int i4 = 0;
        while (i4 < this.D.size()) {
            Fragment fragment = null;
            Map<String, Object> map = this.D.get(i4);
            if ("0".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new NewRadioExamFragment();
            } else if ("1".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new NewCheckboxExamFragment();
            } else if ("3".equals(JsonParse.getString(map, "questionType"))) {
                fragment = new NewRadioExamFragment();
            } else {
                this.D.remove(i4);
                i4--;
            }
            if (fragment != null) {
                Bundle bundle = new Bundle();
                SeralizableMap seralizableMap = new SeralizableMap();
                seralizableMap.setMap(map);
                bundle.putInt("index", i4);
                bundle.putSerializable("seralizableMap", seralizableMap);
                fragment.setArguments(bundle);
                this.E.add(fragment);
            }
            i4++;
        }
        this.f20219n.setAdapter(new h(getSupportFragmentManager()));
        setTitle(this.B + "1/" + this.f20219n.getAdapter().getCount());
        try {
            String string = JsonParse.getString(this.D.get(0), "questionsSetter");
            if (TextUtils.isEmpty(string)) {
                this.f20217l.setVisibility(8);
            } else {
                this.f20217l.setVisibility(0);
                this.f20217l.setText("\u51fa\u9898\u4eba\uff1a" + string);
            }
            String string2 = JsonParse.getString(this.D.get(0), "curriculum");
            if (TextUtils.isEmpty(string2)) {
                this.f20216k.setVisibility(8);
            } else {
                this.f20216k.setVisibility(0);
                this.f20216k.setText("\u8bfe\u7a0b\u540d\u79f0\uff1a" + string2);
            }
            this.f20220o.setEnabled(false);
            this.f20221p.setEnabled(false);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1() {
        if (this.f20219n.getCurrentItem() == this.f20219n.getAdapter().getCount() - 1) {
            h0("\u5df2\u7ecf\u662f\u6700\u540e\u4e00\u9898\u4e86");
            return;
        }
        List<Fragment> list = this.E;
        if (list != null) {
            Fragment fragment = list.get(this.f20219n.getCurrentItem());
            if (fragment instanceof NewCheckboxExamFragment) {
                ((NewCheckboxExamFragment) fragment).P();
            }
        }
        CustomViewPager customViewPager = this.f20219n;
        customViewPager.setCurrentItem(customViewPager.getCurrentItem() + 1);
    }

    private void b1() {
        PopupWindow popupWindow = new PopupWindow(-1, -2);
        View inflate = LayoutInflater.from(this.f1656h).inflate(2131428016, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(2131231333);
        gridView.setAdapter((ListAdapter) this.f20225t);
        gridView.setOnItemClickListener(new b(popupWindow));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131233298);
        popupWindow.setOnDismissListener(new c(frameLayout));
        popupWindow.setContentView(inflate);
        popupWindow.showAsDropDown(findViewById(2131232779));
        if (frameLayout != null) {
            frameLayout.setForeground(new ColorDrawable(Color.parseColor("#7F4c4c4c")));
        }
    }

    private void c1() {
        if (this.f20219n.getCurrentItem() == 0) {
            h0("\u5df2\u7ecf\u662f\u7b2c\u4e00\u9898\u4e86");
            return;
        }
        CustomViewPager customViewPager = this.f20219n;
        customViewPager.setCurrentItem(customViewPager.getCurrentItem() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        i iVar = new i(this.f20230y * 1000, 1000L, simpleDateFormat);
        this.f20227v = iVar;
        iVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        j jVar = new j(this.f20230y * 1000, 1000L, simpleDateFormat);
        this.f20226u = jVar;
        jVar.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i0() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            this.f20228w = connectivityManager;
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

    private void j0() {
        NetworkInfo.State state = this.f20228w.getNetworkInfo(0).getState();
        NetworkInfo.State state2 = this.f20228w.getNetworkInfo(1).getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            Toast.makeText(this, "\u5f53\u524d\u4e3a\u7f51\u7edc\u72b6\u6001\u4e3aMOBILE", 0).show();
        }
        if (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING) {
            Toast.makeText(this, "\u5f53\u524d\u4e3a\u7f51\u7edc\u72b6\u6001\u4e3aWi-Fi", 0).show();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20220o.setOnClickListener(this);
        this.f20221p.setOnClickListener(this);
        this.f20222q.setOnClickListener(this);
        T0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427395;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("onlineType")) {
            this.f20231z = getIntent().getIntExtra("onlineType", 0);
        }
        this.f20225t = new f(this.f1656h, 2131427731, this.D);
        Y0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        String stringExtra = getIntent().getStringExtra("title");
        this.B = stringExtra;
        setTitle(stringExtra);
        Z(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20216k = (TextView) findViewById(2131233113);
        this.f20217l = (TextView) findViewById(2131233114);
        this.f20219n = (CustomViewPager) findViewById(2131233313);
        this.f20220o = (Button) findViewById(2131230994);
        this.f20221p = (Button) findViewById(2131230988);
        this.f20222q = (Button) findViewById(2131230989);
        this.f20223r = (TextView) findViewById(2131233198);
        this.f20224s = (RelativeLayout) findViewById(2131232217);
        this.f20218m = (CountDownTimeView) findViewById(2131231089);
        this.f20224s.setVisibility(8);
        this.f20219n.setPagingEnabled(false);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        new iOSTwoButtonDialog(this.f1656h).setMessage("\u6b63\u5728\u8003\u8bd5\uff0c\u662f\u5426\u653e\u5f03\u8003\u8bd5\uff1f").setRightButtonOnClickListener(new e()).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        if (!this.F) {
            new iOSOneButtonDialog(this.f1656h).setMessage("\u5df2\u8131\u79bb\u540e\u53f0\u76d1\u63a7\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u540e\u5f00\u59cb\u8003\u8bd5").show();
            return;
        }
        switch (v3.getId()) {
            case 2131230988:
                a1();
                return;
            case 2131230989:
                X0(false);
                return;
            case 2131230994:
                c1();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CountDownTimer countDownTimer = this.f20227v;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.f20226u;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        m mVar = this.f20229x;
        if (mVar != null) {
            unregisterReceiver(mVar);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class g extends HttpCallBack {
        g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).f1656h).setMessage("\u83b7\u53d6\u8003\u8bd5\u5185\u5bb9\u5f02\u5e38\uff0c\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458").show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            NewExamActivity.this.A = System.currentTimeMillis();
            NewExamActivity newExamActivity = NewExamActivity.this;
            newExamActivity.C = JsonParse.getInt(data, "examTimeType", newExamActivity.C);
            NewExamActivity newExamActivity2 = NewExamActivity.this;
            newExamActivity2.f20230y = JsonParse.getInt(data, "examTime", newExamActivity2.f20230y);
            NewExamActivity.this.D = (List) data.get("examArray");
            if (NewExamActivity.this.D != null && NewExamActivity.this.D.size() > 0) {
                NewExamActivity.this.f20224s.setVisibility(0);
                NewExamActivity.this.Z0();
                NewExamActivity.this.f20225t.c(NewExamActivity.this.D);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                NewExamActivity.this.f20229x = new m(NewExamActivity.this, null);
                NewExamActivity newExamActivity3 = NewExamActivity.this;
                newExamActivity3.registerReceiver(newExamActivity3.f20229x, intentFilter);
                NewExamActivity.this.f20218m.i(NewExamActivity.this.f20230y, 0);
                NewExamActivity.this.f20218m.setTextSize(cn.bluemobi.dylan.base.utils.d.d(((BaseActivity) NewExamActivity.this).f1656h, 20.0f));
                NewExamActivity newExamActivity4 = NewExamActivity.this;
                if (newExamActivity4.C == 1) {
                    ((View) newExamActivity4.f20223r.getParent()).setVisibility(0);
                    NewExamActivity.this.f20218m.setVisibility(8);
                    NewExamActivity.this.d1();
                    return;
                }
                ((View) newExamActivity4.f20223r.getParent()).setVisibility(8);
                NewExamActivity.this.f20218m.setVisibility(0);
                NewExamActivity.this.e1();
                return;
            }
            new iOSOneButtonDialog(((BaseActivity) NewExamActivity.this).f1656h).setMessage("\u6ca1\u6709\u9898\u76ee").show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
        }
    }
}
