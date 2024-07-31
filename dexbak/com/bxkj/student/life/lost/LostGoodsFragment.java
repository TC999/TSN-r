package com.bxkj.student.life.lost;

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
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.tencent.open.SocialConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import p635q.LostApiService;
import p638r0.RefreshLayout;
import p642s0.OnRefreshLoadmoreListener;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LostGoodsFragment extends BaseFragment {

    /* renamed from: h */
    private SmartRefreshLayout f18091h;

    /* renamed from: i */
    private EmptyRecyclerView f18092i;

    /* renamed from: j */
    private FloatingActionButton f18093j;

    /* renamed from: k */
    private FloatingActionButton f18094k;

    /* renamed from: l */
    private FloatingActionButton f18095l;

    /* renamed from: m */
    private FloatingActionButton f18096m;

    /* renamed from: n */
    private CommonAdapter<Map<String, Object>> f18097n;

    /* renamed from: o */
    private List<Map<String, Object>> f18098o = new ArrayList();

    /* renamed from: p */
    private int f18099p = 1;

    /* renamed from: q */
    private int f18100q = 10;

    /* renamed from: r */
    private int f18101r = 0;

    /* renamed from: s */
    private final int f18102s = 80;

    /* renamed from: com.bxkj.student.life.lost.LostGoodsFragment$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4904a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.life.lost.LostGoodsFragment$a$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class C4905a extends cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter<String> {
            C4905a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.CommonAdapter
            /* renamed from: d */
            public void mo40086a(ViewHolder holder, String s) {
                holder.m57850t(C4215R.C4219id.iv_img, s, 2131558617, 2131558617);
            }
        }

        C4904a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            int color;
            holder.m57874J(C4215R.C4219id.tv_sale_empty, JsonParse.getInt(stringObjectMap, "lostOrFound") == 1 ? "丢" : "捡");
            holder.m57874J(2131233004, JsonParse.getString(stringObjectMap, SocialConstants.PARAM_COMMENT));
            holder.m57874J(2131233198, "时间：" + JsonParse.getString(stringObjectMap, "publishTime"));
            if (JsonParse.getInt(stringObjectMap, "lostOrFound") == 1) {
                color = ContextCompat.getColor(this.f1721a, 2131034198);
            } else {
                color = ContextCompat.getColor(this.f1721a, 2131034489);
            }
            holder.m57859k(C4215R.C4219id.tv_sale_empty, color);
            GridView gridView = (GridView) holder.m57862h(C4215R.C4219id.gv_img);
            gridView.setEnabled(false);
            gridView.setPressed(false);
            gridView.setClickable(false);
            gridView.setAdapter((ListAdapter) new C4905a(this.f1721a, C4215R.C4221layout.item_for_lost_img, JsonParse.getList(stringObjectMap, SocialConstants.PARAM_IMG_URL, String.class)));
        }
    }

    /* renamed from: com.bxkj.student.life.lost.LostGoodsFragment$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4906b implements OnItemClickListener {

        /* renamed from: com.bxkj.student.life.lost.LostGoodsFragment$b$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4907a implements AuthorizationUtils.InterfaceC3827g {

            /* renamed from: a */
            final /* synthetic */ int f18106a;

            C4907a(final int val$position) {
                this.f18106a = val$position;
            }

            @Override // com.bxkj.base.auth.AuthorizationUtils.InterfaceC3827g
            /* renamed from: a */
            public void mo40697a() {
                LostGoodsFragment.this.startActivity(new Intent(((BaseFragment) LostGoodsFragment.this).f1678e, LostDetailActivity.class).putExtra("noticeId", JsonParse.getString((Map) LostGoodsFragment.this.f18097n.getItem(this.f18106a), "id")).putExtra("lostType", JsonParse.getInt((Map) LostGoodsFragment.this.f18097n.getItem(this.f18106a), "lostOrFound")));
            }
        }

        C4906b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, final int position) {
            new AuthorizationUtils(((BaseFragment) LostGoodsFragment.this).f1678e).m44322i(new C4907a(position)).m44329b(LostGoodsFragment.this.getChildFragmentManager(), 1);
        }
    }

    /* renamed from: com.bxkj.student.life.lost.LostGoodsFragment$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4908c implements AuthorizationUtils.InterfaceC3827g {
        C4908c() {
        }

        @Override // com.bxkj.base.auth.AuthorizationUtils.InterfaceC3827g
        /* renamed from: a */
        public void mo40697a() {
            LostGoodsFragment.this.startActivity(new Intent(((BaseFragment) LostGoodsFragment.this).f1678e, PublishLostActivity.class).putExtra("type", 1));
        }
    }

    /* renamed from: com.bxkj.student.life.lost.LostGoodsFragment$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4909d implements AuthorizationUtils.InterfaceC3827g {
        C4909d() {
        }

        @Override // com.bxkj.base.auth.AuthorizationUtils.InterfaceC3827g
        /* renamed from: a */
        public void mo40697a() {
            LostGoodsFragment.this.startActivity(new Intent(((BaseFragment) LostGoodsFragment.this).f1678e, PublishLostActivity.class).putExtra("type", 0));
        }
    }

    /* renamed from: com.bxkj.student.life.lost.LostGoodsFragment$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4910e implements AuthorizationUtils.InterfaceC3827g {
        C4910e() {
        }

        @Override // com.bxkj.base.auth.AuthorizationUtils.InterfaceC3827g
        /* renamed from: a */
        public void mo40697a() {
            LostGoodsFragment.this.startActivity(new Intent(((BaseFragment) LostGoodsFragment.this).f1678e, MyLostGoodsActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.lost.LostGoodsFragment$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4911f implements OnRefreshLoadmoreListener {
        C4911f() {
        }

        @Override // p642s0.OnRefreshListener
        /* renamed from: q */
        public void mo322q(RefreshLayout refreshlayout) {
            LostGoodsFragment.this.f18099p = 1;
            LostGoodsFragment.this.m41052d0();
        }

        @Override // p642s0.OnLoadmoreListener
        /* renamed from: s */
        public void mo320s(RefreshLayout refreshlayout) {
            int i = LostGoodsFragment.this.f18101r / LostGoodsFragment.this.f18100q;
            int i2 = LostGoodsFragment.this.f18099p;
            if (LostGoodsFragment.this.f18101r % LostGoodsFragment.this.f18100q != 0) {
                i++;
            }
            if (i2 >= i) {
                LostGoodsFragment.this.f18091h.mo2041g();
                LostGoodsFragment.this.m57918D("没有了");
                return;
            }
            LostGoodsFragment.m41055a0(LostGoodsFragment.this);
            LostGoodsFragment.this.m41052d0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.life.lost.LostGoodsFragment$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4912g extends HttpCallBack {
        C4912g() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFinish() {
            super.netOnFinish();
            if (LostGoodsFragment.this.f18091h != null && LostGoodsFragment.this.f18091h.mo2061S()) {
                LostGoodsFragment.this.f18091h.mo2078B();
            }
            if (LostGoodsFragment.this.f18091h == null || !LostGoodsFragment.this.f18091h.mo2015z()) {
                return;
            }
            LostGoodsFragment.this.f18091h.mo2041g();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LostGoodsFragment.this.f18101r = JsonParse.getInt(data, "total");
            if (LostGoodsFragment.this.f18099p == 1) {
                LostGoodsFragment.this.f18098o.clear();
            }
            LostGoodsFragment.this.f18098o.addAll(JsonParse.getList(data, "data"));
            LostGoodsFragment.this.f18097n.notifyDataSetChanged();
        }
    }

    /* renamed from: a0 */
    static /* synthetic */ int m41055a0(LostGoodsFragment lostGoodsFragment) {
        int i = lostGoodsFragment.f18099p;
        lostGoodsFragment.f18099p = i + 1;
        return i;
    }

    /* renamed from: c0 */
    private void m41053c0() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f18093j, "rotation", 45.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f18096m, "translationY", -Tools.m57620a(240.0f, this.f1678e), 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f18094k, "translationY", -Tools.m57620a(160.0f, this.f1678e), 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f18095l, "translationY", -Tools.m57620a(80.0f, this.f1678e), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d0 */
    public void m41052d0() {
        Http.with(this.f1678e).hideLoadingDialog().setObservable(((LostApiService) Http.getApiService(LostApiService.class)).m2277k(this.f18099p, this.f18100q)).setDataListener(new C4912g());
    }

    /* renamed from: e0 */
    private void m41051e0() {
        this.f18091h.mo2019v(new C4911f());
    }

    /* renamed from: f0 */
    private void m41050f0() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f18093j, "rotation", 0.0f, 45.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f18096m, "translationY", 0.0f, -Tools.m57620a(240.0f, this.f1678e));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f18094k, "translationY", 0.0f, -Tools.m57620a(160.0f, this.f1678e));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f18095l, "translationY", 0.0f, -Tools.m57620a(80.0f, this.f1678e));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.start();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: b */
    public void mo39445b() {
        this.f18093j.setOnClickListener(this);
        this.f18094k.setOnClickListener(this);
        this.f18095l.setOnClickListener(this);
        this.f18096m.setOnClickListener(this);
        this.f18097n.m57834k(new C4906b());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: e */
    public void mo39444e() {
        this.f18092i.setLayoutManager(new LinearLayoutManager(this.f1678e));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1678e, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f18092i.setLayoutAnimation(layoutAnimationController);
        this.f18092i.addItemDecoration(new DividerItemDecoration(this.f1678e, 1));
        C4904a c4904a = new C4904a(this.f1678e, C4215R.C4221layout.item_for_lost_good, this.f18098o);
        this.f18097n = c4904a;
        this.f18092i.setAdapter(c4904a);
        this.f18092i.setEmptyView(m57916c(2131232952));
        m41051e0();
        m41049g0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    /* renamed from: f */
    protected void mo39443f(View view) {
        this.f18091h = (SmartRefreshLayout) m57916c(2131232483);
        this.f18092i = (EmptyRecyclerView) m57916c(C4215R.C4219id.rv_goods_list);
        this.f18093j = (FloatingActionButton) m57916c(2131231287);
        this.f18094k = (FloatingActionButton) m57916c(C4215R.C4219id.fab_lost);
        this.f18095l = (FloatingActionButton) m57916c(C4215R.C4219id.fab_pick);
        FloatingActionButton floatingActionButton = (FloatingActionButton) m57916c(C4215R.C4219id.fab_my);
        this.f18096m = floatingActionButton;
        floatingActionButton.setImageBitmap(m41048h0("我的", 40.0f, -1));
        this.f18094k.setImageBitmap(m41048h0("丢", 40.0f, -1));
        this.f18095l.setImageBitmap(m41048h0("捡", 40.0f, -1));
    }

    /* renamed from: g0 */
    public void m41049g0() {
        this.f18091h.mo2052a0();
    }

    /* renamed from: h0 */
    public Bitmap m41048h0(String text, float textSize, int textColor) {
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
                if (this.f18093j.getTag() == null) {
                    m41050f0();
                    this.f18093j.setTag("open");
                    return;
                }
                m41053c0();
                this.f18093j.setTag(null);
                return;
            case C4215R.C4219id.fab_lost /* 2131231288 */:
                new AuthorizationUtils(this.f1678e).m44322i(new C4908c()).m44329b(getChildFragmentManager(), 1);
                return;
            case C4215R.C4219id.fab_my /* 2131231289 */:
                new AuthorizationUtils(this.f1678e).m44322i(new C4910e()).m44329b(getChildFragmentManager(), 1);
                return;
            case C4215R.C4219id.fab_pick /* 2131231290 */:
                new AuthorizationUtils(this.f1678e).m44322i(new C4909d()).m44329b(getChildFragmentManager(), 1);
                return;
            default:
                return;
        }
    }
}
