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
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.view.CountDownTimeView;
import com.bxkj.student.common.view.CustomViewPager;
import com.bxkj.student.home.teaching.learning.answer.AnswerActivity;
import com.bxkj.student.home.teaching.learning.detail.backup.H5Activity;
import com.bxkj.student.home.teaching.learning.detail.backup.VideoPlayActivity;
import com.bxkj.student.home.teaching.learning.m;
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
public class AnswerActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private TextView f20552k;

    /* renamed from: l  reason: collision with root package name */
    private TextView f20553l;

    /* renamed from: m  reason: collision with root package name */
    private CountDownTimeView f20554m;

    /* renamed from: n  reason: collision with root package name */
    private CustomViewPager f20555n;

    /* renamed from: o  reason: collision with root package name */
    public Button f20556o;

    /* renamed from: p  reason: collision with root package name */
    public Button f20557p;

    /* renamed from: q  reason: collision with root package name */
    private Button f20558q;

    /* renamed from: r  reason: collision with root package name */
    private TextView f20559r;

    /* renamed from: s  reason: collision with root package name */
    private RelativeLayout f20560s;

    /* renamed from: t  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f20561t;

    /* renamed from: u  reason: collision with root package name */
    private CountDownTimer f20562u;

    /* renamed from: v  reason: collision with root package name */
    private ConnectivityManager f20563v;

    /* renamed from: w  reason: collision with root package name */
    private l f20564w;

    /* renamed from: x  reason: collision with root package name */
    private String f20565x;

    /* renamed from: y  reason: collision with root package name */
    private int f20566y = 60000;

    /* renamed from: z  reason: collision with root package name */
    private List<Map<String, Object>> f20567z = new ArrayList();
    private List<Fragment> A = new ArrayList();
    private boolean B = true;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a implements AdapterView.OnItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PopupWindow f20568a;

        a(final PopupWindow val$popupWindow) {
            this.f20568a = val$popupWindow;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            AnswerActivity.this.f20555n.setCurrentItem(position);
            this.f20568a.dismiss();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements PopupWindow.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FrameLayout f20570a;

        b(final FrameLayout val$outsideView) {
            this.f20570a = val$outsideView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            FrameLayout frameLayout = this.f20570a;
            if (frameLayout != null) {
                frameLayout.setForeground(new ColorDrawable(0));
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements BaseActivity.c {
        c() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            AnswerActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d implements iOSTwoButtonDialog.RightButtonOnClick {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            AnswerActivity.this.finish();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class e extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        e(Context context, int layoutId, List datas) {
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
                holder.K(2131233051, arrayList.isEmpty() ? AnswerActivity.this.getResources().getColor(2131034190) : AnswerActivity.this.getResources().getColor(2131034196));
                return;
            }
            holder.l(2131233051, JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty() ? 2131165924 : 2131165428);
            holder.K(2131233051, JsonParse.getString(stringObjectMap, "checkAnswerId").isEmpty() ? AnswerActivity.this.getResources().getColor(2131034190) : AnswerActivity.this.getResources().getColor(2131034196));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class g extends FragmentPagerAdapter {
        g(FragmentManager fm) {
            super(fm);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return AnswerActivity.this.A.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return (Fragment) AnswerActivity.this.A.get(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class h extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SimpleDateFormat f20577a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(long millisInFuture, long countDownInterval, final SimpleDateFormat val$simpleDateFormat) {
            super(millisInFuture, countDownInterval);
            this.f20577a = val$simpleDateFormat;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            AnswerActivity.this.f20554m.i(60, 0);
            ((Map) AnswerActivity.this.f20567z.get(AnswerActivity.this.f20555n.getCurrentItem())).put("timeFinish", Boolean.TRUE);
            Fragment fragment = (Fragment) AnswerActivity.this.A.get(AnswerActivity.this.f20555n.getCurrentItem());
            if (fragment instanceof RadioAnswerFragment) {
                ((RadioAnswerFragment) fragment).R();
                AnswerActivity.this.f20556o.setEnabled(true);
                AnswerActivity.this.f20557p.setEnabled(true);
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
            AnswerActivity.this.f20554m.i(60, ((int) millisUntilFinished) / 1000);
            AnswerActivity.this.f20559r.setText(this.f20577a.format(Long.valueOf(millisUntilFinished)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class i implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f20579a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ List f20580b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f20581c;

        i(final boolean val$autoCommit, final List val$radioData, final List val$checkData) {
            this.f20579a = val$autoCommit;
            this.f20580b = val$radioData;
            this.f20581c = val$checkData;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            AnswerActivity.this.G0(this.f20579a, this.f20580b, this.f20581c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class j extends HttpCallBack {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f20583a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                AnswerActivity.this.finish();
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
                AnswerActivity.this.finish();
            }
        }

        j(final boolean val$autoCommit) {
            this.f20583a = val$autoCommit;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(View view) {
            H5Activity h5Activity = (H5Activity) cn.bluemobi.dylan.base.utils.a.n().getActivity(H5Activity.class);
            VideoPlayActivity videoPlayActivity = (VideoPlayActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(VideoPlayActivity.class);
            if (h5Activity != null) {
                h5Activity.n0();
            }
            if (videoPlayActivity != null) {
                videoPlayActivity.w0();
            }
            AnswerActivity.this.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            if (this.f20583a) {
                new iOSOneButtonDialog(((BaseActivity) AnswerActivity.this).f1656h).setButtonOnClickListener(new b()).setMessage("\u65f6\u95f4\u5df2\u5230\uff0c\u81ea\u52a8\u4ea4\u5377\u5931\u8d25\uff0c\u8bf7\u91cd\u65b0\u8003\u8bd5").show();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) AnswerActivity.this).f1656h).setButtonOnClickListener(new a()).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            String str = this.f20583a ? "\u65f6\u95f4\u5df2\u5230\uff0c\u5df2\u7ecf\u4e3a\u60a8\u81ea\u52a8\u4ea4\u5377\u6210\u529f" : "\u4ea4\u5377\u6210\u529f";
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(((BaseActivity) AnswerActivity.this).f1656h);
            iosonebuttondialog.setCancelable(false);
            iosonebuttondialog.setMessage(str).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.teaching.learning.answer.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AnswerActivity.j.this.b(view);
                }
            }).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class k implements ViewPager.OnPageChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private int f20587a;

        k() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            this.f20587a = state;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (this.f20587a == 1 && positionOffsetPixels == 0) {
                if (position == 0) {
                    AnswerActivity.this.h0("\u5df2\u7ecf\u662f\u7b2c\u4e00\u9898\u4e86");
                } else if (position == AnswerActivity.this.f20555n.getAdapter().getCount() - 1) {
                    AnswerActivity.this.h0("\u5df2\u7ecf\u662f\u6700\u540e\u4e00\u9898\u4e86");
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            AnswerActivity answerActivity = AnswerActivity.this;
            answerActivity.setTitle((position + 1) + TTPathConst.sSeparator + AnswerActivity.this.f20555n.getAdapter().getCount());
            if (AnswerActivity.this.f20562u != null) {
                AnswerActivity.this.f20562u.cancel();
            }
            AnswerActivity.this.f20554m.i(60, 0);
            if (!JsonParse.getBoolean((Map) AnswerActivity.this.f20567z.get(AnswerActivity.this.f20555n.getCurrentItem()), "timeFinish") && TextUtils.isEmpty(JsonParse.getString((Map) AnswerActivity.this.f20567z.get(AnswerActivity.this.f20555n.getCurrentItem()), "checkAnswerId"))) {
                AnswerActivity.this.f20556o.setEnabled(false);
                AnswerActivity.this.f20557p.setEnabled(false);
                AnswerActivity.this.O0();
            }
            TextView textView = AnswerActivity.this.f20553l;
            textView.setText("\u51fa\u9898\u4eba\uff1a" + JsonParse.getString((Map) AnswerActivity.this.f20567z.get(position), "questionsSetter"));
            TextView textView2 = AnswerActivity.this.f20552k;
            textView2.setText("\u8bfe\u7a0b\u540d\u79f0\uff1a" + JsonParse.getString((Map) AnswerActivity.this.f20567z.get(position), "curriculum"));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    private class l extends BroadcastReceiver {
        private l() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
        }
    }

    private void D0() {
        this.f20555n.addOnPageChangeListener(new k());
    }

    private void E0() {
        H0(true);
    }

    private String F0(long milliSecondTime) {
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
    public void G0(final boolean autoCommit, List<Map<String, Object>> radioData, List<Map<String, Object>> checkData) {
        String jSONString = JSON.toJSONString(radioData);
        String jSONString2 = JSON.toJSONString(checkData);
        com.orhanobut.logger.j.h(jSONString);
        com.orhanobut.logger.j.h(jSONString2);
        Http.with(this.f1656h).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((m) Http.getApiService(m.class)).k(LoginUser.getLoginUser().getUserId(), jSONString, jSONString2)).setDataListener(new j(autoCommit));
    }

    private void H0(final boolean autoCommit) {
        List<Map<String, Object>> arrayList = new ArrayList<>();
        List<Map<String, Object>> arrayList2 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < this.f20567z.size(); i4++) {
            Map<String, Object> map = this.f20567z.get(i4);
            if ("1".equals(JsonParse.getString(this.f20567z.get(i4), "questionType"))) {
                ArrayList arrayList3 = new ArrayList();
                Iterator it = ((List) this.f20567z.get(i4).get("answers")).iterator();
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
            new iOSTwoButtonDialog(this.f1656h).setMessage(TextUtils.isEmpty(sb) ? "\u786e\u5b9a\u8981\u63d0\u4ea4\u8bd5\u5377\u5417\uff1f" : "\u60a8\u8fd8\u6709\u7b2c" + sb.toString() + "\u9898\u672a\u4f5c\u7b54\uff0c\u662f\u5426\u8981\u63d0\u4ea4\u8bd5\u5377\uff1f").setLeftButtonText("\u7ee7\u7eed\u7b54\u9898").setRightButtonText("\u76f4\u63a5\u4ea4\u5377").setRightButtonOnClickListener(new i(autoCommit, arrayList, arrayList2)).show();
            return;
        }
        G0(autoCommit, arrayList, arrayList2);
    }

    private void I0() {
        Http.with(this.f1656h).hideSuccessMessage().hideOtherStatusMessage().hideFailMessage().setObservable(((m) Http.getApiService(m.class)).x(LoginUser.getLoginUser().getUserId(), this.f20565x)).setDataListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        int i4 = 0;
        while (i4 < this.f20567z.size()) {
            Fragment fragment = null;
            if ("0".equals(JsonParse.getString(this.f20567z.get(i4), "questionType"))) {
                fragment = new RadioAnswerFragment();
            } else if ("1".equals(JsonParse.getString(this.f20567z.get(i4), "questionType"))) {
                fragment = new CheckboxAnswerFragment();
            } else if ("3".equals(JsonParse.getString(this.f20567z.get(i4), "questionType"))) {
                fragment = new RadioAnswerFragment();
            } else {
                this.f20567z.remove(i4);
                i4--;
            }
            if (fragment != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("index", i4);
                fragment.setArguments(bundle);
                this.A.add(fragment);
            }
            i4++;
        }
        this.f20555n.setAdapter(new g(getSupportFragmentManager()));
        setTitle("1/" + this.f20555n.getAdapter().getCount());
        try {
            this.f20553l.setVisibility(8);
            this.f20552k.setVisibility(8);
            this.f20556o.setEnabled(false);
            this.f20557p.setEnabled(false);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void L0() {
        if (this.f20555n.getCurrentItem() == this.f20555n.getAdapter().getCount() - 1) {
            h0("\u5df2\u7ecf\u662f\u6700\u540e\u4e00\u9898\u4e86");
            return;
        }
        CustomViewPager customViewPager = this.f20555n;
        customViewPager.setCurrentItem(customViewPager.getCurrentItem() + 1);
    }

    private void M0() {
        PopupWindow popupWindow = new PopupWindow(-1, -2);
        View inflate = LayoutInflater.from(this.f1656h).inflate(2131428016, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(2131231333);
        gridView.setAdapter((ListAdapter) this.f20561t);
        gridView.setOnItemClickListener(new a(popupWindow));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131233298);
        popupWindow.setOnDismissListener(new b(frameLayout));
        popupWindow.setContentView(inflate);
        popupWindow.showAsDropDown(findViewById(2131232779));
        if (frameLayout != null) {
            frameLayout.setForeground(new ColorDrawable(Color.parseColor("#7F4c4c4c")));
        }
    }

    private void N0() {
        if (this.f20555n.getCurrentItem() == 0) {
            h0("\u5df2\u7ecf\u662f\u7b2c\u4e00\u9898\u4e86");
            return;
        }
        CustomViewPager customViewPager = this.f20555n;
        customViewPager.setCurrentItem(customViewPager.getCurrentItem() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        h hVar = new h(this.f20566y, 1000L, simpleDateFormat);
        this.f20562u = hVar;
        hVar.start();
    }

    private boolean i0() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
            this.f20563v = connectivityManager;
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
        NetworkInfo.State state = this.f20563v.getNetworkInfo(0).getState();
        NetworkInfo.State state2 = this.f20563v.getNetworkInfo(1).getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            Toast.makeText(this, "\u5f53\u524d\u4e3a\u7f51\u7edc\u72b6\u6001\u4e3aMOBILE", 0).show();
        }
        if (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING) {
            Toast.makeText(this, "\u5f53\u524d\u4e3a\u7f51\u7edc\u72b6\u6001\u4e3aWi-Fi", 0).show();
        }
    }

    public List<Map<String, Object>> J0() {
        return this.f20567z;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20556o.setOnClickListener(this);
        this.f20557p.setOnClickListener(this);
        this.f20558q.setOnClickListener(this);
        D0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427395;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        if (getIntent().hasExtra("id")) {
            this.f20565x = getIntent().getStringExtra("id");
        }
        this.f20561t = new e(this.f1656h, 2131427731, this.f20567z);
        I0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        Z(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20552k = (TextView) findViewById(2131233113);
        this.f20553l = (TextView) findViewById(2131233114);
        this.f20555n = (CustomViewPager) findViewById(2131233313);
        this.f20556o = (Button) findViewById(2131230994);
        this.f20557p = (Button) findViewById(2131230988);
        this.f20558q = (Button) findViewById(2131230989);
        this.f20559r = (TextView) findViewById(2131233198);
        this.f20560s = (RelativeLayout) findViewById(2131232217);
        this.f20554m = (CountDownTimeView) findViewById(2131231089);
        this.f20560s.setVisibility(8);
        this.f20555n.setPagingEnabled(false);
        this.f20554m.i(60, 0);
        this.f20554m.setTextSize(cn.bluemobi.dylan.base.utils.d.d(this.f1656h, 20.0f));
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        new iOSTwoButtonDialog(this.f1656h).setMessage("\u6b63\u5728\u7b54\u9898\uff0c\u662f\u5426\u653e\u5f03\u7b54\u9898\uff1f").setRightButtonOnClickListener(new d()).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        switch (v3.getId()) {
            case 2131230988:
                L0();
                return;
            case 2131230989:
                H0(false);
                return;
            case 2131230994:
                N0();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        CountDownTimer countDownTimer = this.f20562u;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        l lVar = this.f20564w;
        if (lVar != null) {
            unregisterReceiver(lVar);
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f extends HttpCallBack {
        f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((BaseActivity) AnswerActivity.this).f1656h).setMessage("\u83b7\u53d6\u8003\u8bd5\u5185\u5bb9\u5f02\u5e38\uff0c\u8bf7\u8054\u7cfb\u7ba1\u7406\u5458").show();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) AnswerActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            AnswerActivity.this.f20560s.setVisibility(0);
            AnswerActivity.this.f20567z = (List) data.get("data");
            AnswerActivity.this.K0();
            AnswerActivity.this.f20561t.c(AnswerActivity.this.f20567z);
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data, String msg) {
            super.netOnSuccess(data, msg);
            AnswerActivity.this.O0();
        }
    }
}
