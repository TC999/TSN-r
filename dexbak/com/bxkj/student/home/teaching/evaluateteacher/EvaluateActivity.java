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
import cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.alibaba.fastjson.JSON;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p653w.InterfaceC16236a;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class EvaluateActivity extends BaseActivity {

    /* renamed from: k */
    private ViewPager f16665k;

    /* renamed from: l */
    private Button f16666l;

    /* renamed from: m */
    private Button f16667m;

    /* renamed from: n */
    private Button f16668n;

    /* renamed from: o */
    private RelativeLayout f16669o;

    /* renamed from: p */
    private CommonAdapter<Map<String, Object>> f16670p;

    /* renamed from: q */
    private List<Map<String, Object>> f16671q = new ArrayList();

    /* renamed from: r */
    private List<Fragment> f16672r = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4420a implements PopupWindow.OnDismissListener {

        /* renamed from: a */
        final /* synthetic */ FrameLayout f16673a;

        C4420a(final FrameLayout val$outsideView) {
            this.f16673a = val$outsideView;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            FrameLayout frameLayout = this.f16673a;
            if (frameLayout != null) {
                frameLayout.setForeground(new ColorDrawable(0));
            }
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4421b implements BaseActivity.InterfaceC1107c {
        C4421b() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            EvaluateActivity.this.m42393z0();
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4422c implements BaseActivity.InterfaceC1107c {
        C4422c() {
        }

        @Override // cn.bluemobi.dylan.base.BaseActivity.InterfaceC1107c
        public void onClick() {
            EvaluateActivity.this.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4423d implements iOSTwoButtonDialog.RightButtonOnClick {
        C4423d() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            EvaluateActivity.this.finish();
        }
    }

    /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4424e extends CommonAdapter<Map<String, Object>> {
        C4424e(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
        /* renamed from: d */
        public void mo40086a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            Resources resources;
            int i;
            holder.m57874J(2131233051, String.valueOf(holder.m57864f() + 1));
            holder.m57858l(2131233051, JsonParse.getString(stringObjectMap, "checkScore").isEmpty() ? C4215R.C4218drawable.round_cicler_gray : C4215R.C4218drawable.dot_cicler_blue);
            if (JsonParse.getString(stringObjectMap, "checkScore").isEmpty()) {
                resources = EvaluateActivity.this.getResources();
                i = 2131034190;
            } else {
                resources = EvaluateActivity.this.getResources();
                i = 2131034196;
            }
            holder.m57873K(2131233051, resources.getColor(i));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4425f extends HttpCallBack {
        C4425f() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) EvaluateActivity.this).f1669h).setMessage(msg).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            EvaluateActivity.this.f16669o.setVisibility(0);
            EvaluateActivity.this.f16671q = (List) data.get("data");
            EvaluateActivity.this.m42395x0();
            EvaluateActivity.this.f16670p.m57842c(EvaluateActivity.this.f16671q);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4426g extends FragmentPagerAdapter {
        C4426g(FragmentManager fm) {
            super(fm);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return EvaluateActivity.this.f16672r.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int position) {
            return (Fragment) EvaluateActivity.this.f16672r.get(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateActivity$h */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4427h extends HttpCallBack {

        /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateActivity$h$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class View$OnClickListenerC4428a implements View.OnClickListener {
            View$OnClickListenerC4428a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EvaluateActivity.this.finish();
            }
        }

        /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateActivity$h$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class View$OnClickListenerC4429b implements View.OnClickListener {
            View$OnClickListenerC4429b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EvaluateActivity.this.finish();
            }
        }

        C4427h() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) EvaluateActivity.this).f1669h).setMessage(msg).setButtonOnClickListener(new View$OnClickListenerC4429b()).show();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            new iOSOneButtonDialog(((BaseActivity) EvaluateActivity.this).f1669h).setMessage("评价成功").setButtonOnClickListener(new View$OnClickListenerC4428a()).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateActivity$i */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4430i implements ViewPager.OnPageChangeListener {

        /* renamed from: a */
        private int f16684a;

        C4430i() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
            this.f16684a = state;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            if (this.f16684a == 1 && positionOffsetPixels == 0) {
                if (position == 0) {
                    EvaluateActivity.this.m57919h0("已经是第一条了");
                } else if (position == EvaluateActivity.this.f16665k.getAdapter().getCount() - 1) {
                    EvaluateActivity.this.m57919h0("已经是最后一条了");
                }
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            EvaluateActivity evaluateActivity = EvaluateActivity.this;
            evaluateActivity.setTitle((position + 1) + "/" + EvaluateActivity.this.f16665k.getAdapter().getCount());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.teaching.evaluateteacher.EvaluateActivity$j */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4431j implements AdapterView.OnItemClickListener {

        /* renamed from: a */
        final /* synthetic */ PopupWindow f16686a;

        C4431j(final PopupWindow val$popupWindow) {
            this.f16686a = val$popupWindow;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            EvaluateActivity.this.f16665k.setCurrentItem(position);
            this.f16686a.dismiss();
        }
    }

    /* renamed from: A0 */
    private void m42411A0() {
        if (this.f16665k.getCurrentItem() == 0) {
            m57919h0("已经是第一条了");
            return;
        }
        ViewPager viewPager = this.f16665k;
        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    }

    /* renamed from: t0 */
    private void m42399t0() {
        this.f16665k.addOnPageChangeListener(new C4430i());
    }

    /* renamed from: u0 */
    private void m42398u0() {
        String stringExtra = getIntent().getStringExtra("stuTeacherCurriculumId");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f16671q.size(); i++) {
            Map<String, Object> map = this.f16671q.get(i);
            String string = JsonParse.getString(map, "checkScore");
            if (string.isEmpty()) {
                m57919h0("您第" + (i + 1) + "条还未评价");
                return;
            }
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("contentId", JsonParse.getString(map, "id"));
            arrayMap.put("score", string);
            arrayList.add(arrayMap);
        }
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m77r0(stringExtra, LoginUser.getLoginUser().getUserId(), JSON.toJSONString(arrayList))).setDataListener(new C4427h());
    }

    /* renamed from: v0 */
    private void m42397v0() {
        Http.with(this.f1669h).hideOtherStatusMessage().setObservable(((InterfaceC16236a) Http.getApiService(InterfaceC16236a.class)).m71t0(LoginUser.getLoginUser().getUserId())).setDataListener(new C4425f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x0 */
    public void m42395x0() {
        for (int i = 0; i < this.f16671q.size(); i++) {
            EvaluateFragment evaluateFragment = new EvaluateFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            evaluateFragment.setArguments(bundle);
            this.f16672r.add(evaluateFragment);
        }
        this.f16665k.setAdapter(new C4426g(getSupportFragmentManager()));
        setTitle("1/" + this.f16665k.getAdapter().getCount());
    }

    /* renamed from: y0 */
    private void m42394y0() {
        if (this.f16665k.getCurrentItem() == this.f16665k.getAdapter().getCount() - 1) {
            m57919h0("已经是最后一条了");
            return;
        }
        ViewPager viewPager = this.f16665k;
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z0 */
    public void m42393z0() {
        PopupWindow popupWindow = new PopupWindow(-1, -2);
        View inflate = LayoutInflater.from(this.f1669h).inflate(C4215R.C4221layout.pop_dialog, (ViewGroup) null);
        GridView gridView = (GridView) inflate.findViewById(C4215R.C4219id.f15997gv);
        gridView.setAdapter((ListAdapter) this.f16670p);
        gridView.setOnItemClickListener(new C4431j(popupWindow));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131233298);
        popupWindow.setOnDismissListener(new C4420a(frameLayout));
        popupWindow.setContentView(inflate);
        popupWindow.showAsDropDown(findViewById(2131232779));
        if (frameLayout != null) {
            frameLayout.setForeground(new ColorDrawable(Color.parseColor("#7F4c4c4c")));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16666l.setOnClickListener(this);
        this.f16667m.setOnClickListener(this);
        this.f16668n.setOnClickListener(this);
        m42399t0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_evaluate_teacher;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f16670p = new C4424e(this.f1669h, C4215R.C4221layout.item_for_number, this.f16671q);
        m42397v0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        m57925b0(C4215R.mipmap.more_white, new C4421b());
        m57927Z(new C4422c());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16665k = (ViewPager) findViewById(C4215R.C4219id.f16013vp);
        this.f16666l = (Button) findViewById(C4215R.C4219id.bt_previous);
        this.f16667m = (Button) findViewById(C4215R.C4219id.bt_next);
        this.f16668n = (Button) findViewById(2131230989);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2131232217);
        this.f16669o = relativeLayout;
        relativeLayout.setVisibility(8);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        new iOSTwoButtonDialog(this.f1669h).setMessage("正在评价，是否放弃评价？").setRightButtonOnClickListener(new C4423d()).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case C4215R.C4219id.bt_next /* 2131230988 */:
                m42394y0();
                return;
            case 2131230989:
                m42398u0();
                return;
            case C4215R.C4219id.bt_previous /* 2131230994 */:
                m42411A0();
                return;
            default:
                return;
        }
    }

    /* renamed from: w0 */
    public List<Map<String, Object>> m42396w0() {
        return this.f16671q;
    }
}
