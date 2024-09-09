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
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.auth.a;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class LostGoodsFragment extends BaseFragment {

    /* renamed from: h  reason: collision with root package name */
    private SmartRefreshLayout f21422h;

    /* renamed from: i  reason: collision with root package name */
    private EmptyRecyclerView f21423i;

    /* renamed from: j  reason: collision with root package name */
    private FloatingActionButton f21424j;

    /* renamed from: k  reason: collision with root package name */
    private FloatingActionButton f21425k;

    /* renamed from: l  reason: collision with root package name */
    private FloatingActionButton f21426l;

    /* renamed from: m  reason: collision with root package name */
    private FloatingActionButton f21427m;

    /* renamed from: n  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f21428n;

    /* renamed from: o  reason: collision with root package name */
    private List<Map<String, Object>> f21429o = new ArrayList();

    /* renamed from: p  reason: collision with root package name */
    private int f21430p = 1;

    /* renamed from: q  reason: collision with root package name */
    private int f21431q = 10;

    /* renamed from: r  reason: collision with root package name */
    private int f21432r = 0;

    /* renamed from: s  reason: collision with root package name */
    private final int f21433s = 80;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class a extends CommonAdapter<Map<String, Object>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* renamed from: com.bxkj.student.life.lost.LostGoodsFragment$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class C0254a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<String> {
            C0254a(Context context, int layoutId, List datas) {
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
        public void c(ViewHolder holder, final Map<String, Object> stringObjectMap) {
            int color;
            holder.J(2131233141, JsonParse.getInt(stringObjectMap, "lostOrFound") == 1 ? "\u4e22" : "\u6361");
            holder.J(2131233004, JsonParse.getString(stringObjectMap, "description"));
            holder.J(2131233198, "\u65f6\u95f4\uff1a" + JsonParse.getString(stringObjectMap, "publishTime"));
            if (JsonParse.getInt(stringObjectMap, "lostOrFound") == 1) {
                color = ContextCompat.getColor(this.f1707a, 2131034198);
            } else {
                color = ContextCompat.getColor(this.f1707a, 2131034489);
            }
            holder.k(2131233141, color);
            GridView gridView = (GridView) holder.h(2131231336);
            gridView.setEnabled(false);
            gridView.setPressed(false);
            gridView.setClickable(false);
            gridView.setAdapter((ListAdapter) new C0254a(this.f1707a, 2131427721, JsonParse.getList(stringObjectMap, "img", String.class)));
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
            final /* synthetic */ int f21437a;

            a(final int val$position) {
                this.f21437a = val$position;
            }

            @Override // com.bxkj.base.auth.a.g
            public void a() {
                LostGoodsFragment.this.startActivity(new Intent(((BaseFragment) LostGoodsFragment.this).f1665e, LostDetailActivity.class).putExtra("noticeId", JsonParse.getString((Map) LostGoodsFragment.this.f21428n.getItem(this.f21437a), "id")).putExtra("lostType", JsonParse.getInt((Map) LostGoodsFragment.this.f21428n.getItem(this.f21437a), "lostOrFound")));
            }
        }

        b() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, final int position) {
            new com.bxkj.base.auth.a(((BaseFragment) LostGoodsFragment.this).f1665e).i(new a(position)).b(LostGoodsFragment.this.getChildFragmentManager(), 1);
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
            LostGoodsFragment.this.startActivity(new Intent(((BaseFragment) LostGoodsFragment.this).f1665e, PublishLostActivity.class).putExtra("type", 1));
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
            LostGoodsFragment.this.startActivity(new Intent(((BaseFragment) LostGoodsFragment.this).f1665e, PublishLostActivity.class).putExtra("type", 0));
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
            LostGoodsFragment.this.startActivity(new Intent(((BaseFragment) LostGoodsFragment.this).f1665e, MyLostGoodsActivity.class));
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
            LostGoodsFragment.this.f21430p = 1;
            LostGoodsFragment.this.d0();
        }

        @Override // s0.b
        public void s(h refreshlayout) {
            int i4 = LostGoodsFragment.this.f21432r / LostGoodsFragment.this.f21431q;
            int i5 = LostGoodsFragment.this.f21430p;
            if (LostGoodsFragment.this.f21432r % LostGoodsFragment.this.f21431q != 0) {
                i4++;
            }
            if (i5 >= i4) {
                LostGoodsFragment.this.f21422h.h();
                LostGoodsFragment.this.D("\u6ca1\u6709\u4e86");
                return;
            }
            LostGoodsFragment.a0(LostGoodsFragment.this);
            LostGoodsFragment.this.d0();
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
            if (LostGoodsFragment.this.f21422h != null && LostGoodsFragment.this.f21422h.S()) {
                LostGoodsFragment.this.f21422h.y();
            }
            if (LostGoodsFragment.this.f21422h == null || !LostGoodsFragment.this.f21422h.z()) {
                return;
            }
            LostGoodsFragment.this.f21422h.h();
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LostGoodsFragment.this.f21432r = JsonParse.getInt(data, "total");
            if (LostGoodsFragment.this.f21430p == 1) {
                LostGoodsFragment.this.f21429o.clear();
            }
            LostGoodsFragment.this.f21429o.addAll(JsonParse.getList(data, "data"));
            LostGoodsFragment.this.f21428n.notifyDataSetChanged();
        }
    }

    static /* synthetic */ int a0(LostGoodsFragment lostGoodsFragment) {
        int i4 = lostGoodsFragment.f21430p;
        lostGoodsFragment.f21430p = i4 + 1;
        return i4;
    }

    private void c0() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f21424j, "rotation", 45.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f21427m, "translationY", -u.a(240.0f, this.f1665e), 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f21425k, "translationY", -u.a(160.0f, this.f1665e), 0.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f21426l, "translationY", -u.a(80.0f, this.f1665e), 0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        Http.with(this.f1665e).hideLoadingDialog().setObservable(((q.e) Http.getApiService(q.e.class)).k(this.f21430p, this.f21431q)).setDataListener(new g());
    }

    private void e0() {
        this.f21422h.n1(new f());
    }

    private void f0() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f21424j, "rotation", 0.0f, 45.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f21427m, "translationY", 0.0f, -u.a(240.0f, this.f1665e));
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f21425k, "translationY", 0.0f, -u.a(160.0f, this.f1665e));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f21426l, "translationY", 0.0f, -u.a(80.0f, this.f1665e));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500L);
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4);
        animatorSet.start();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
        this.f21424j.setOnClickListener(this);
        this.f21425k.setOnClickListener(this);
        this.f21426l.setOnClickListener(this);
        this.f21427m.setOnClickListener(this);
        this.f21428n.k(new b());
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void e() {
        this.f21423i.setLayoutManager(new LinearLayoutManager(this.f1665e));
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1665e, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f21423i.setLayoutAnimation(layoutAnimationController);
        this.f21423i.addItemDecoration(new DividerItemDecoration(this.f1665e, 1));
        a aVar = new a(this.f1665e, 2131427720, this.f21429o);
        this.f21428n = aVar;
        this.f21423i.setAdapter(aVar);
        this.f21423i.setEmptyView(c(2131232952));
        e0();
        g0();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f21422h = (SmartRefreshLayout) c(2131232483);
        this.f21423i = (EmptyRecyclerView) c(2131232545);
        this.f21424j = (FloatingActionButton) c(2131231287);
        this.f21425k = (FloatingActionButton) c(2131231288);
        this.f21426l = (FloatingActionButton) c(2131231290);
        FloatingActionButton floatingActionButton = (FloatingActionButton) c(2131231289);
        this.f21427m = floatingActionButton;
        floatingActionButton.setImageBitmap(h0("\u6211\u7684", 40.0f, -1));
        this.f21425k.setImageBitmap(h0("\u4e22", 40.0f, -1));
        this.f21426l.setImageBitmap(h0("\u6361", 40.0f, -1));
    }

    public void g0() {
        this.f21422h.a0();
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
                if (this.f21424j.getTag() == null) {
                    f0();
                    this.f21424j.setTag("open");
                    return;
                }
                c0();
                this.f21424j.setTag(null);
                return;
            case 2131231288:
                new com.bxkj.base.auth.a(this.f1665e).i(new c()).b(getChildFragmentManager(), 1);
                return;
            case 2131231289:
                new com.bxkj.base.auth.a(this.f1665e).i(new e()).b(getChildFragmentManager(), 1);
                return;
            case 2131231290:
                new com.bxkj.base.auth.a(this.f1665e).i(new d()).b(getChildFragmentManager(), 1);
                return;
            default:
                return;
        }
    }
}
