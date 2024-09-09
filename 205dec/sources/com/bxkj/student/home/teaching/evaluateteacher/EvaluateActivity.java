package com.bxkj.student.home.teaching.evaluateteacher;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class EvaluateActivity extends BaseActivity {

    /* renamed from: k  reason: collision with root package name */
    private ViewPager f20055k;

    /* renamed from: l  reason: collision with root package name */
    private Button f20056l;

    /* renamed from: m  reason: collision with root package name */
    private Button f20057m;

    /* renamed from: n  reason: collision with root package name */
    private Button f20058n;

    /* renamed from: o  reason: collision with root package name */
    private RelativeLayout f20059o;

    /* renamed from: p  reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f20060p;

    /* renamed from: q  reason: collision with root package name */
    private List<Map<String, Object>> f20061q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private List<Fragment> f20062r = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a implements PopupWindow.OnDismissListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FrameLayout f20063a;

        a(final FrameLayout val$outsideView) {
            this.f20063a = val$outsideView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            FrameLayout frameLayout = this.f20063a;
            if (frameLayout != null) {
                frameLayout.setForeground(new ColorDrawable(0));
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements BaseActivity.c {
        b() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.c
        public void onClick() {
            EvaluateActivity.this.z0();
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
            EvaluateActivity.this.onBackPressed();
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
            EvaluateActivity.this.finish();
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
            Resources resources;
            int i4;
            holder.J(2131233051, String.valueOf(holder.f() + 1));
            holder.l(2131233051, JsonParse.getString(stringObjectMap, "checkScore").isEmpty() ? 2131165924 : 2131165428);
            if (JsonParse.getString(stringObjectMap, "checkScore").isEmpty()) {
                resources = EvaluateActivity.this.getResources();
                i4 = 2131034190;
            } else {
                resources = EvaluateActivity.this.getResources();
                i4 = 2131034196;
            }
            holder.K(2131233051, resources.getColor(i4));
        }
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
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) EvaluateActivity.this).f1656h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            EvaluateActivity.this.f20059o.setVisibility(0);
            EvaluateActivity.this.f20061q = (List) data.get("data");
            EvaluateActivity.this.x0();
            EvaluateActivity.this.f20060p.c(EvaluateActivity.this.f20061q);
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
            return EvaluateActivity.this.f20062r.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return (Fragment) EvaluateActivity.this.f20062r.get(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class h extends HttpCallBack {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements View.OnClickListener {
            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                EvaluateActivity.this.finish();
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
                EvaluateActivity.this.finish();
            }
        }

        h() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) EvaluateActivity.this).f1656h).setMessage(msg).setButtonOnClickListener(new b()).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            new iOSOneButtonDialog(((BaseActivity) EvaluateActivity.this).f1656h).setMessage("\u8bc4\u4ef7\u6210\u529f").setButtonOnClickListener(new a()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class i implements ViewPager.OnPageChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private int f20074a;

        i() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            this.f20074a = state;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (this.f20074a == 1 && positionOffsetPixels == 0) {
                if (position == 0) {
                    EvaluateActivity.this.h0("\u5df2\u7ecf\u662f\u7b2c\u4e00\u6761\u4e86");
                } else if (position == EvaluateActivity.this.f20055k.getAdapter().getCount() - 1) {
                    EvaluateActivity.this.h0("\u5df2\u7ecf\u662f\u6700\u540e\u4e00\u6761\u4e86");
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            EvaluateActivity evaluateActivity = EvaluateActivity.this;
            evaluateActivity.setTitle((position + 1) + TTPathConst.sSeparator + EvaluateActivity.this.f20055k.getAdapter().getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class j implements AdapterView.OnItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PopupWindow f20076a;

        j(final PopupWindow val$popupWindow) {
            this.f20076a = val$popupWindow;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            EvaluateActivity.this.f20055k.setCurrentItem(position);
            this.f20076a.dismiss();
        }
    }

    private void A0() {
        if (this.f20055k.getCurrentItem() == 0) {
            h0("\u5df2\u7ecf\u662f\u7b2c\u4e00\u6761\u4e86");
            return;
        }
        ViewPager viewPager = this.f20055k;
        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    }

    private void t0() {
        this.f20055k.addOnPageChangeListener(new i());
    }

    private void u0() {
        String stringExtra = getIntent().getStringExtra("stuTeacherCurriculumId");
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.f20061q.size(); i4++) {
            Map<String, Object> map = this.f20061q.get(i4);
            String string = JsonParse.getString(map, "checkScore");
            if (string.isEmpty()) {
                h0("\u60a8\u7b2c" + (i4 + 1) + "\u6761\u8fd8\u672a\u8bc4\u4ef7");
                return;
            }
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("contentId", JsonParse.getString(map, "id"));
            arrayMap.put("score", string);
            arrayList.add(arrayMap);
        }
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).r0(stringExtra, LoginUser.getLoginUser().getUserId(), JSON.toJSONString(arrayList))).setDataListener(new h());
    }

    private void v0() {
        Http.with(this.f1656h).hideOtherStatusMessage().setObservable(((w.a) Http.getApiService(w.a.class)).t0(LoginUser.getLoginUser().getUserId())).setDataListener(new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        for (int i4 = 0; i4 < this.f20061q.size(); i4++) {
            EvaluateFragment evaluateFragment = new EvaluateFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("index", i4);
            evaluateFragment.setArguments(bundle);
            this.f20062r.add(evaluateFragment);
        }
        this.f20055k.setAdapter(new g(getSupportFragmentManager()));
        setTitle("1/" + this.f20055k.getAdapter().getCount());
    }

    private void y0() {
        if (this.f20055k.getCurrentItem() == this.f20055k.getAdapter().getCount() - 1) {
            h0("\u5df2\u7ecf\u662f\u6700\u540e\u4e00\u6761\u4e86");
            return;
        }
        ViewPager viewPager = this.f20055k;
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        PopupWindow popupWindow = new PopupWindow(-1, -2);
        View inflate = LayoutInflater.from(this.f1656h).inflate(2131428016, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(2131231333);
        gridView.setAdapter((ListAdapter) this.f20060p);
        gridView.setOnItemClickListener(new j(popupWindow));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131233298);
        popupWindow.setOnDismissListener(new a(frameLayout));
        popupWindow.setContentView(inflate);
        popupWindow.showAsDropDown(findViewById(2131232779));
        if (frameLayout != null) {
            frameLayout.setForeground(new ColorDrawable(Color.parseColor("#7F4c4c4c")));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f20056l.setOnClickListener(this);
        this.f20057m.setOnClickListener(this);
        this.f20058n.setOnClickListener(this);
        t0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427393;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f20060p = new e(this.f1656h, 2131427731, this.f20061q);
        v0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        b0(2131558835, new b());
        Z(new c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f20055k = (ViewPager) findViewById(2131233313);
        this.f20056l = (Button) findViewById(2131230994);
        this.f20057m = (Button) findViewById(2131230988);
        this.f20058n = (Button) findViewById(2131230989);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131232217);
        this.f20059o = relativeLayout;
        relativeLayout.setVisibility(8);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        new iOSTwoButtonDialog(this.f1656h).setMessage("\u6b63\u5728\u8bc4\u4ef7\uff0c\u662f\u5426\u653e\u5f03\u8bc4\u4ef7\uff1f").setRightButtonOnClickListener(new d()).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        switch (v3.getId()) {
            case 2131230988:
                y0();
                return;
            case 2131230989:
                u0();
                return;
            case 2131230994:
                A0();
                return;
            default:
                return;
        }
    }

    public List<Map<String, Object>> w0() {
        return this.f20061q;
    }
}
