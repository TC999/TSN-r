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
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.auth.a;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import q.i;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class SecondHandListFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private SmartRefreshLayout f21873h;

    /* renamed from: i  reason: collision with root package name */
    private EmptyRecyclerView f21874i;

    /* renamed from: j  reason: collision with root package name */
    private FloatingActionButton f21875j;

    /* renamed from: k  reason: collision with root package name */
    private FloatingActionButton f21876k;

    /* renamed from: l  reason: collision with root package name */
    private FloatingActionButton f21877l;

    /* renamed from: m  reason: collision with root package name */
    private FloatingActionButton f21878m;

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21879n;

    /* renamed from: o  reason: collision with root package name */
    private List<Map<String, Object>> f21880o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private int f21881p = 1;

    /* renamed from: q  reason: collision with root package name */
    private int f21882q = 15;

    /* renamed from: r  reason: collision with root package name */
    private int f21883r = 0;

    /* renamed from: s  reason: collision with root package name */
    private final int f21884s = 80;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.life.secondhand.SecondHandListFragment$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class C0274a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
            C0274a(Context context, int layoutId, List datas) {
                super(context, layoutId, datas);
            }

            @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
            /* renamed from: d */
            public void a(ViewHolder holder, String s3) {
                holder.t(2131231436, s3, 2131558617, 2131558617);
            }
        }

        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            int color;
            holder.J(2131233004, JsonParse.getString(stringObjectMap, "description"));
            holder.J(2131233198, "\u65f6\u95f4\uff1a" + JsonParse.getString(stringObjectMap, "publishTime"));
            holder.J(2131233101, "\u4ef7\u683c\uff1a" + JsonParse.getString(stringObjectMap, BidResponsed.KEY_PRICE));
            holder.J(2131232888, JsonParse.getInt(stringObjectMap, "buyOrSell") == 1 ? "\u5356" : "\u4e70");
            if (JsonParse.getInt(stringObjectMap, "buyOrSell") == 1) {
                color = ContextCompat.getColor(this.f1707a, 2131034177);
            } else {
                color = ContextCompat.getColor(this.f1707a, 2131034172);
            }
            holder.k(2131232888, color);
            GridView gridView = (GridView) holder.h(2131231336);
            gridView.setEnabled(false);
            gridView.setPressed(false);
            gridView.setClickable(false);
            gridView.setAdapter((ListAdapter) new C0274a(this.f1707a, 2131427721, JsonParse.getList(stringObjectMap, "img", String.class)));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a implements a.g {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f21888a;

            a(final int val$position) {
                this.f21888a = val$position;
            }

            @Override // com.bxkj.base.auth.a.g
            public void a() {
                SecondHandListFragment.this.startActivity(new Intent(((BaseFragment) SecondHandListFragment.this).f1665e, BuyDetailActivity.class).putExtra("noticeId", JsonParse.getString((Map) SecondHandListFragment.this.f21879n.getItem(this.f21888a), "id")).putExtra("buyType", JsonParse.getInt((Map) SecondHandListFragment.this.f21879n.getItem(this.f21888a), "buyOrSell")));
            }
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, final int position) {
            new com.bxkj.base.auth.a(((BaseFragment) SecondHandListFragment.this).f1665e).i(new a(position)).b(SecondHandListFragment.this.getChildFragmentManager(), 2);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c implements a.g {
        c() {
        }

        @Override // com.bxkj.base.auth.a.g
        public void a() {
            SecondHandListFragment.this.startActivity(new Intent(((BaseFragment) SecondHandListFragment.this).f1665e, PublishBuyActivity.class).putExtra("type", 0));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d implements a.g {
        d() {
        }

        @Override // com.bxkj.base.auth.a.g
        public void a() {
            SecondHandListFragment.this.startActivity(new Intent(((BaseFragment) SecondHandListFragment.this).f1665e, PublishBuyActivity.class).putExtra("type", 1));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class e implements a.g {
        e() {
        }

        @Override // com.bxkj.base.auth.a.g
        public void a() {
            SecondHandListFragment.this.startActivity(new Intent(((BaseFragment) SecondHandListFragment.this).f1665e, MyBuyGoodsActivity.class));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f implements s0.e {
        f() {
        }

        @Override // s0.d
        public void q(h refreshlayout) {
            SecondHandListFragment.this.f21881p = 1;
            SecondHandListFragment.this.d0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = SecondHandListFragment.this.f21883r / SecondHandListFragment.this.f21882q;
            int i5 = SecondHandListFragment.this.f21881p;
            if (SecondHandListFragment.this.f21883r % SecondHandListFragment.this.f21882q != 0) {
                i4++;
            }
            if (i5 >= i4) {
                SecondHandListFragment.this.f21873h.h();
                SecondHandListFragment.this.D("\u6ca1\u6709\u4e86");
                return;
            }
            SecondHandListFragment.a0(SecondHandListFragment.this);
            SecondHandListFragment.this.d0();
        }
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
        public void netOnFinish() {
            super.netOnFinish();
            if (SecondHandListFragment.this.f21873h != null && SecondHandListFragment.this.f21873h.S()) {
                SecondHandListFragment.this.f21873h.y();
            }
            if (SecondHandListFragment.this.f21873h == null || !SecondHandListFragment.this.f21873h.z()) {
                return;
            }
            SecondHandListFragment.this.f21873h.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            SecondHandListFragment.this.f21883r = JsonParse.getInt(data, "total");
            if (SecondHandListFragment.this.f21881p == 1) {
                SecondHandListFragment.this.f21880o.clear();
            }
            SecondHandListFragment.this.f21880o.addAll(JsonParse.getList(data, "data"));
            SecondHandListFragment.this.f21879n.notifyDataSetChanged();
        }
    }

    static /* synthetic */ int a0(SecondHandListFragment secondHandListFragment) {
        int i4 = secondHandListFragment.f21881p;
        secondHandListFragment.f21881p = i4 + 1;
        return i4;
    }

    private void c0() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f21875j, "rotation", 45.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f21878m, "translationY", -u.a(240.0f, this.f1665e), 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f21876k, "translationY", -u.a(160.0f, this.f1665e), 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f21877l, "translationY", -u.a(80.0f, this.f1665e), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        Http.with(this.f1665e).hideLoadingDialog().setObservable(((i) Http.getApiService(i.class)).d(this.f21881p, this.f21882q)).setDataListener(new g());
    }

    private void e0() {
        this.f21873h.n1(new f());
    }

    private void f0() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f21875j, "rotation", 0.0f, 45.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f21878m, "translationY", 0.0f, -u.a(240.0f, this.f1665e));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f21876k, "translationY", 0.0f, -u.a(160.0f, this.f1665e));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f21877l, "translationY", 0.0f, -u.a(80.0f, this.f1665e));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.start();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f21875j.setOnClickListener(this);
        this.f21876k.setOnClickListener(this);
        this.f21877l.setOnClickListener(this);
        this.f21878m.setOnClickListener(this);
        this.f21879n.k(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void e() {
        this.f21874i.setLayoutManager(new LinearLayoutManager(this.f1665e));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1665e, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f21874i.setLayoutAnimation(layoutAnimationController);
        this.f21874i.addItemDecoration(new DividerItemDecoration(this.f1665e, 1));
        a aVar = new a(this.f1665e, 2131427761, this.f21880o);
        this.f21879n = aVar;
        this.f21874i.setAdapter(aVar);
        this.f21874i.setEmptyView(c(2131232952));
        e0();
        g0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f21873h = (SmartRefreshLayout) c(2131232483);
        this.f21874i = (EmptyRecyclerView) c(2131232545);
        this.f21875j = (FloatingActionButton) c(2131231287);
        this.f21876k = (FloatingActionButton) c(2131231288);
        this.f21877l = (FloatingActionButton) c(2131231290);
        this.f21878m = (FloatingActionButton) c(2131231289);
        this.f21876k.setImageBitmap(h0("\u4e70", 40.0f, -1));
        this.f21877l.setImageBitmap(h0("\u5356", 40.0f, -1));
        this.f21878m.setImageBitmap(h0("\u6211\u7684", 40.0f, -1));
    }

    public void g0() {
        this.f21873h.a0();
    }

    public Bitmap h0(String text, float textSize, int textColor) {
        Paint paint = new Paint(1);
        paint.setTextSize(textSize);
        paint.setColor(textColor);
        paint.setTextAlign(Paint.Align.LEFT);
        float f4 = -paint.ascent();
        Bitmap createBitmap = Bitmap.createBitmap((int) (paint.measureText(text) + 0.0f), (int) (paint.descent() + f4 + 0.0f), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawText(text, 0.0f, f4, paint);
        return createBitmap;
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return 2131427635;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        switch (v3.getId()) {
            case 2131231287:
                if (this.f21875j.getTag() == null) {
                    f0();
                    this.f21875j.setTag("open");
                    return;
                }
                c0();
                this.f21875j.setTag(null);
                return;
            case 2131231288:
                new com.bxkj.base.auth.a(this.f1665e).i(new c()).b(getChildFragmentManager(), 2);
                return;
            case 2131231289:
                new com.bxkj.base.auth.a(this.f1665e).i(new e()).b(getChildFragmentManager(), 2);
                return;
            case 2131231290:
                new com.bxkj.base.auth.a(this.f1665e).i(new d()).b(getChildFragmentManager(), 2);
                return;
            default:
                return;
        }
    }
}
