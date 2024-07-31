package com.bxkj.student.life.secondhand;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.DividerItemDecoration;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.EmptyRecyclerView;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.auth.AuthorizationUtils;
import com.bxkj.student.C4215R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p635q.SecondHandApiService;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class SecondHandListFragment extends BaseFragment {

    /* renamed from: h */
    private SmartRefreshLayout f18566h;

    /* renamed from: i */
    private EmptyRecyclerView f18567i;

    /* renamed from: j */
    private FloatingActionButton f18568j;

    /* renamed from: k */
    private FloatingActionButton f18569k;

    /* renamed from: l */
    private FloatingActionButton f18570l;

    /* renamed from: m */
    private FloatingActionButton f18571m;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f18572n;

    /* renamed from: o */
    private List<Map<String, Object>> f18573o = new ArrayList();

    /* renamed from: p */
    private int f18574p = 1;

    /* renamed from: q */
    private int f18575q = 15;

    /* renamed from: r */
    private int f18576r = 0;

    /* renamed from: s */
    private final int f18577s = 80;

    /* renamed from: com.bxkj.student.life.secondhand.SecondHandListFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5056a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.secondhand.SecondHandListFragment$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C5057a extends cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter<String> {
            C5057a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
            /* renamed from: d */
            public void mo40086a(ViewHolder holder, String s) {
                holder.m57850t(C4215R.C4219id.iv_img, s, 2131558617, 2131558617);
            }
        }

        C5056a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            int color;
            holder.m57874J(2131233004, JsonParse.getString(stringObjectMap, SocialConstants.PARAM_COMMENT));
            holder.m57874J(2131233198, "时间：" + JsonParse.getString(stringObjectMap, "publishTime"));
            holder.m57874J(2131233101, "价格：" + JsonParse.getString(stringObjectMap, BidResponsed.KEY_PRICE));
            holder.m57874J(C4215R.C4219id.tv_buy_type, JsonParse.getInt(stringObjectMap, "buyOrSell") == 1 ? "卖" : "买");
            if (JsonParse.getInt(stringObjectMap, "buyOrSell") == 1) {
                color = ContextCompat.getColor(this.f1721a, 2131034177);
            } else {
                color = ContextCompat.getColor(this.f1721a, 2131034172);
            }
            holder.m57859k(C4215R.C4219id.tv_buy_type, color);
            GridView gridView = (GridView) holder.m57862h(C4215R.C4219id.gv_img);
            gridView.setEnabled(false);
            gridView.setPressed(false);
            gridView.setClickable(false);
            gridView.setAdapter((ListAdapter) new C5057a(this.f1721a, C4215R.C4221layout.item_for_lost_img, JsonParse.getList(stringObjectMap, SocialConstants.PARAM_IMG_URL, String.class)));
        }
    }

    /* renamed from: com.bxkj.student.life.secondhand.SecondHandListFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5058b implements OnItemClickListener {

        /* renamed from: com.bxkj.student.life.secondhand.SecondHandListFragment$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C5059a implements AuthorizationUtils.InterfaceC3827g {

            /* renamed from: a */
            final /* synthetic */ int f18581a;

            C5059a(final int val$position) {
                this.f18581a = val$position;
            }

            @Override // com.bxkj.base.auth.AuthorizationUtils.InterfaceC3827g
            /* renamed from: a */
            public void mo40697a() {
                SecondHandListFragment.this.startActivity(new Intent(((BaseFragment) SecondHandListFragment.this).f1678e, BuyDetailActivity.class).putExtra("noticeId", JsonParse.getString((Map) SecondHandListFragment.this.f18572n.getItem(this.f18581a), "id")).putExtra("buyType", JsonParse.getInt((Map) SecondHandListFragment.this.f18572n.getItem(this.f18581a), "buyOrSell")));
            }
        }

        C5058b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, final int position) {
            new AuthorizationUtils(((BaseFragment) SecondHandListFragment.this).f1678e).m44322i(new C5059a(position)).m44329b(SecondHandListFragment.this.getChildFragmentManager(), 2);
        }
    }

    /* renamed from: com.bxkj.student.life.secondhand.SecondHandListFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5060c implements AuthorizationUtils.InterfaceC3827g {
        C5060c() {
        }

        @Override // com.bxkj.base.auth.AuthorizationUtils.InterfaceC3827g
        /* renamed from: a */
        public void mo40697a() {
            SecondHandListFragment.this.startActivity(new Intent(((BaseFragment) SecondHandListFragment.this).f1678e, PublishBuyActivity.class).putExtra("type", 0));
        }
    }

    /* renamed from: com.bxkj.student.life.secondhand.SecondHandListFragment$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5061d implements AuthorizationUtils.InterfaceC3827g {
        C5061d() {
        }

        @Override // com.bxkj.base.auth.AuthorizationUtils.InterfaceC3827g
        /* renamed from: a */
        public void mo40697a() {
            SecondHandListFragment.this.startActivity(new Intent(((BaseFragment) SecondHandListFragment.this).f1678e, PublishBuyActivity.class).putExtra("type", 1));
        }
    }

    /* renamed from: com.bxkj.student.life.secondhand.SecondHandListFragment$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5062e implements AuthorizationUtils.InterfaceC3827g {
        C5062e() {
        }

        @Override // com.bxkj.base.auth.AuthorizationUtils.InterfaceC3827g
        /* renamed from: a */
        public void mo40697a() {
            SecondHandListFragment.this.startActivity(new Intent(((BaseFragment) SecondHandListFragment.this).f1678e, MyBuyGoodsActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.secondhand.SecondHandListFragment$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5063f implements OnRefreshLoadmoreListener {
        C5063f() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            SecondHandListFragment.this.f18574p = 1;
            SecondHandListFragment.this.m40704d0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = SecondHandListFragment.this.f18576r / SecondHandListFragment.this.f18575q;
            int i2 = SecondHandListFragment.this.f18574p;
            if (SecondHandListFragment.this.f18576r % SecondHandListFragment.this.f18575q != 0) {
                i++;
            }
            if (i2 >= i) {
                SecondHandListFragment.this.f18566h.mo2041g();
                SecondHandListFragment.this.m57918D("没有了");
                return;
            }
            SecondHandListFragment.m40707a0(SecondHandListFragment.this);
            SecondHandListFragment.this.m40704d0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.secondhand.SecondHandListFragment$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5064g extends HttpCallBack {
        C5064g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (SecondHandListFragment.this.f18566h != null && SecondHandListFragment.this.f18566h.mo2061S()) {
                SecondHandListFragment.this.f18566h.mo2078B();
            }
            if (SecondHandListFragment.this.f18566h == null || !SecondHandListFragment.this.f18566h.mo2015z()) {
                return;
            }
            SecondHandListFragment.this.f18566h.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SecondHandListFragment.this.f18576r = JsonParse.getInt(data, "total");
            if (SecondHandListFragment.this.f18574p == 1) {
                SecondHandListFragment.this.f18573o.clear();
            }
            SecondHandListFragment.this.f18573o.addAll(JsonParse.getList(data, "data"));
            SecondHandListFragment.this.f18572n.notifyDataSetChanged();
        }
    }

    /* renamed from: a0 */
    static /* synthetic */ int m40707a0(SecondHandListFragment secondHandListFragment) {
        int i = secondHandListFragment.f18574p;
        secondHandListFragment.f18574p = i + 1;
        return i;
    }

    /* renamed from: c0 */
    private void m40705c0() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f18568j, "rotation", 45.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f18571m, "translationY", -Tools.m57620a(240.0f, this.f1678e), 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f18569k, "translationY", -Tools.m57620a(160.0f, this.f1678e), 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f18570l, "translationY", -Tools.m57620a(80.0f, this.f1678e), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0 */
    public void m40704d0() {
        Http.with(this.f1678e).hideLoadingDialog().setObservable(((SecondHandApiService) Http.getApiService(SecondHandApiService.class)).m2196d(this.f18574p, this.f18575q)).setDataListener(new C5064g());
    }

    /* renamed from: e0 */
    private void m40703e0() {
        this.f18566h.mo2019v(new C5063f());
    }

    /* renamed from: f0 */
    private void m40702f0() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f18568j, "rotation", 0.0f, 45.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f18571m, "translationY", 0.0f, -Tools.m57620a(240.0f, this.f1678e));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f18569k, "translationY", 0.0f, -Tools.m57620a(160.0f, this.f1678e));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f18570l, "translationY", 0.0f, -Tools.m57620a(80.0f, this.f1678e));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.start();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
        this.f18568j.setOnClickListener(this);
        this.f18569k.setOnClickListener(this);
        this.f18570l.setOnClickListener(this);
        this.f18571m.setOnClickListener(this);
        this.f18572n.m57834k(new C5058b());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    public void mo39444e() {
        this.f18567i.setLayoutManager(new LinearLayoutManager(this.f1678e));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1678e, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f18567i.setLayoutAnimation(layoutAnimationController);
        this.f18567i.addItemDecoration(new DividerItemDecoration(this.f1678e, 1));
        C5056a c5056a = new C5056a(this.f1678e, C4215R.C4221layout.item_for_sencond_hand, this.f18573o);
        this.f18572n = c5056a;
        this.f18567i.setAdapter(c5056a);
        this.f18567i.setEmptyView(m57916c(2131232952));
        m40703e0();
        m40701g0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f18566h = (SmartRefreshLayout) m57916c(2131232483);
        this.f18567i = (EmptyRecyclerView) m57916c(C4215R.C4219id.rv_goods_list);
        this.f18568j = (FloatingActionButton) m57916c(2131231287);
        this.f18569k = (FloatingActionButton) m57916c(C4215R.C4219id.fab_lost);
        this.f18570l = (FloatingActionButton) m57916c(C4215R.C4219id.fab_pick);
        this.f18571m = (FloatingActionButton) m57916c(C4215R.C4219id.fab_my);
        this.f18569k.setImageBitmap(m40700h0("买", 40.0f, -1));
        this.f18570l.setImageBitmap(m40700h0("卖", 40.0f, -1));
        this.f18571m.setImageBitmap(m40700h0("我的", 40.0f, -1));
    }

    /* renamed from: g0 */
    public void m40701g0() {
        this.f18566h.mo2052a0();
    }

    /* renamed from: h0 */
    public Bitmap m40700h0(String text, float textSize, int textColor) {
        Paint paint = new Paint(1);
        paint.setTextSize(textSize);
        paint.setColor(textColor);
        paint.setTextAlign(Paint.Align.LEFT);
        float f = -paint.ascent();
        Bitmap createBitmap = Bitmap.createBitmap((int) (paint.measureText(text) + 0.0f), (int) (paint.descent() + f + 0.0f), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawText(text, 0.0f, f, paint);
        return createBitmap;
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: i */
    protected int mo39442i() {
        return C4215R.C4221layout.fm_lost_goods_list;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        switch (v.getId()) {
            case 2131231287:
                if (this.f18568j.getTag() == null) {
                    m40702f0();
                    this.f18568j.setTag("open");
                    return;
                }
                m40705c0();
                this.f18568j.setTag(null);
                return;
            case C4215R.C4219id.fab_lost /* 2131231288 */:
                new AuthorizationUtils(this.f1678e).m44322i(new C5060c()).m44329b(getChildFragmentManager(), 2);
                return;
            case C4215R.C4219id.fab_my /* 2131231289 */:
                new AuthorizationUtils(this.f1678e).m44322i(new C5062e()).m44329b(getChildFragmentManager(), 2);
                return;
            case C4215R.C4219id.fab_pick /* 2131231290 */:
                new AuthorizationUtils(this.f1678e).m44322i(new C5061d()).m44329b(getChildFragmentManager(), 2);
                return;
            default:
                return;
        }
    }
}
