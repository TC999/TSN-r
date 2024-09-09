package com.bxkj.student.home;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.common.db.HomeMenuDB;
import com.bxkj.student.common.utils.UniversalItemDecoration;
import com.bxkj.student.main.HomeFragment;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class HomeMenuListActivity extends BaseActivity {

    /* renamed from: l  reason: collision with root package name */
    private RecyclerView f19684l;

    /* renamed from: m  reason: collision with root package name */
    private RecyclerView f19685m;

    /* renamed from: n  reason: collision with root package name */
    private Button f19686n;

    /* renamed from: p  reason: collision with root package name */
    private CommonAdapter<Map<String, Object>> f19688p;

    /* renamed from: r  reason: collision with root package name */
    private List<Map<String, Object>> f19690r;

    /* renamed from: s  reason: collision with root package name */
    private HomeFragment f19691s;

    /* renamed from: t  reason: collision with root package name */
    private ItemTouchHelper f19692t;

    /* renamed from: k  reason: collision with root package name */
    private final String f19683k = "groupType";

    /* renamed from: o  reason: collision with root package name */
    private List<Map<String, Object>> f19687o = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private boolean f19689q = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends ItemTouchHelper.Callback {
        a() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            viewHolder.itemView.setBackgroundColor(-1);
            super.clearView(recyclerView, viewHolder);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            int i4;
            if (viewHolder.getItemViewType() == 1 || viewHolder.getItemViewType() != viewHolder.getItemViewType() || !HomeMenuListActivity.this.f19689q || viewHolder.getAdapterPosition() >= HomeMenuListActivity.this.f19690r.size() || JsonParse.getString((Map) HomeMenuListActivity.this.f19690r.get(viewHolder.getAdapterPosition()), "name").isEmpty()) {
                i4 = 0;
            } else {
                i4 = recyclerView.getLayoutManager() instanceof GridLayoutManager ? 15 : 3;
            }
            return ItemTouchHelper.Callback.makeMovementFlags(i4, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            if (HomeMenuListActivity.this.f19689q) {
                ((Vibrator) ((BaseActivity) HomeMenuListActivity.this).f1656h.getSystemService("vibrator")).vibrate(500L);
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            int adapterPosition = viewHolder.getAdapterPosition();
            int adapterPosition2 = target.getAdapterPosition();
            if (JsonParse.getString((Map) HomeMenuListActivity.this.f19690r.get(adapterPosition), "name").isEmpty() || JsonParse.getString((Map) HomeMenuListActivity.this.f19690r.get(adapterPosition2), "name").isEmpty()) {
                return false;
            }
            if (adapterPosition < adapterPosition2) {
                int i4 = adapterPosition;
                while (i4 < adapterPosition2) {
                    int i5 = i4 + 1;
                    Collections.swap(HomeMenuListActivity.this.f19690r, i4, i5);
                    i4 = i5;
                }
            } else {
                for (int i6 = adapterPosition; i6 > adapterPosition2; i6--) {
                    Collections.swap(HomeMenuListActivity.this.f19690r, i6, i6 - 1);
                }
            }
            HomeMenuListActivity.this.f19688p.notifyItemMoved(adapterPosition, adapterPosition2);
            return true;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            if (actionState != 0) {
                viewHolder.itemView.setBackgroundColor(-3355444);
            }
            super.onSelectedChanged(viewHolder, actionState);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class b extends CommonAdapter<Map<String, Object>> {
        b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.r(2131231433, HomeMenuListActivity.this.w0(JsonParse.getString(stringObjectMap, RewardPlus.ICON)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends UniversalItemDecoration {
        c() {
        }

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration
        public UniversalItemDecoration.b a(int position) {
            UniversalItemDecoration.a aVar = new UniversalItemDecoration.a();
            aVar.f19611a = u.a(7.0f, ((BaseActivity) HomeMenuListActivity.this).f1656h);
            aVar.f19610f = -1;
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class d implements cn.bluemobi.dylan.base.adapter.common.recyclerview.a<Map<String, Object>> {
        d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        public int b(int itemType) {
            return itemType == 1 ? 2131427700 : 2131427701;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.a
        /* renamed from: c */
        public int a(int position, Map<String, Object> stringObjectMap) {
            return JsonParse.getInt(stringObjectMap, "type");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends MultiItemCommonAdapter<Map<String, Object>> {

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        class a extends GridLayoutManager.SpanSizeLookup {
            a() {
            }

            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                return e.this.getItemViewType(position) != 1 ? 1 : 4;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class b implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f19699a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ ViewHolder f19700b;

            b(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f19699a = val$stringObjectMap;
                this.f19700b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                e.this.r(this.f19699a, this.f19700b);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class c implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f19702a;

            c(final int val$index) {
                this.f19702a = val$index;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                e.this.s(this.f19702a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public class d implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Map f19704a;

            d(final Map val$stringObjectMap) {
                this.f19704a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v3) {
                e.this.p(this.f19704a);
            }
        }

        e(Context context, List datas, cn.bluemobi.dylan.base.adapter.common.recyclerview.a multiItemTypeSupport) {
            super(context, datas, multiItemTypeSupport);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(Map<String, Object> stringObjectMap) {
            int size = HomeMenuListActivity.this.f19690r.size();
            HashMap hashMap = new HashMap(stringObjectMap);
            hashMap.put("groupType", -1);
            if (size == 12 && JsonParse.getString((Map) HomeMenuListActivity.this.f19690r.get(HomeMenuListActivity.this.f19690r.size() - 1), "name").isEmpty()) {
                int i4 = size - 1;
                HomeMenuListActivity.this.f19690r.set(i4, hashMap);
                HomeMenuListActivity.this.f19687o.set(i4, hashMap);
                notifyItemRangeChanged(i4, HomeMenuListActivity.this.f19687o.size());
            } else if (size < 12) {
                int i5 = size - 1;
                HomeMenuListActivity.this.f19690r.add(i5, hashMap);
                HomeMenuListActivity.this.f19687o.add(i5, hashMap);
                int i6 = size - 2;
                notifyItemInserted(i6);
                notifyItemRangeChanged(i6, HomeMenuListActivity.this.f19687o.size());
            } else {
                HomeMenuListActivity.this.h0("\u9996\u9875\u6700\u591a\u6dfb\u52a011\u4e2a\u5e94\u7528");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r(Map<String, Object> stringObjectMap, ViewHolder holder) {
            HomeMenuListActivity.this.f19687o.remove(stringObjectMap);
            HomeMenuListActivity.this.f19690r.remove(stringObjectMap);
            if (!JsonParse.getString((Map) HomeMenuListActivity.this.f19690r.get(HomeMenuListActivity.this.f19690r.size() - 1), "name").isEmpty()) {
                ArrayMap arrayMap = new ArrayMap();
                arrayMap.put("name", "");
                arrayMap.put("type", 2);
                HomeMenuListActivity.this.f19690r.add(arrayMap);
                HomeMenuListActivity.this.f19687o.add(HomeMenuListActivity.this.f19690r.size() - 1, arrayMap);
            }
            notifyItemRemoved(holder.f());
            notifyItemRangeChanged(holder.f(), HomeMenuListActivity.this.f19687o.size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s(int index) {
            HomeMenuListActivity.this.f19687o.remove(index);
            HomeMenuListActivity.this.f19690r.remove(index);
            if (!JsonParse.getString((Map) HomeMenuListActivity.this.f19690r.get(HomeMenuListActivity.this.f19690r.size() - 1), "name").isEmpty()) {
                ArrayMap arrayMap = new ArrayMap();
                arrayMap.put("name", "");
                arrayMap.put("type", 2);
                HomeMenuListActivity.this.f19690r.add(arrayMap);
                HomeMenuListActivity.this.f19687o.add(HomeMenuListActivity.this.f19690r.size() - 1, arrayMap);
            }
            notifyItemRemoved(index);
            notifyItemRangeChanged(index, HomeMenuListActivity.this.f19687o.size());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                ((GridLayoutManager) layoutManager).setSpanSizeLookup(new a());
            }
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: q */
        public void c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            String string = JsonParse.getString(stringObjectMap, "name");
            if (string.equals("\u9996\u9875\u5e94\u7528")) {
                SpannableString spannableString = new SpannableString(string + "(\u6309\u4f4f\u62d6\u52a8\u8c03\u6574\u987a\u5e8f)");
                spannableString.setSpan(new ForegroundColorSpan(HomeMenuListActivity.this.getResources().getColor(2131034269)), 4, spannableString.length(), 34);
                ((TextView) holder.h(2131233040)).setText(spannableString);
            } else {
                holder.J(2131233040, string);
            }
            if (getItemViewType(holder.f()) == 2) {
                boolean z3 = true;
                if (TextUtils.isEmpty(string)) {
                    holder.N(2131233040, false);
                    holder.N(2131231433, false);
                    holder.N(2131231461, false);
                    GridLayoutManager.LayoutParams layoutParams = new GridLayoutManager.LayoutParams(-1, u.a(50.0f, this.f1707a));
                    int a4 = u.a(10.0f, this.f1707a);
                    int a5 = u.a(15.0f, this.f1707a);
                    layoutParams.setMargins(a5, a4, a5, a4);
                    holder.itemView.setLayoutParams(layoutParams);
                    holder.itemView.setBackgroundResource(2131166082);
                } else {
                    holder.N(2131233040, true);
                    holder.N(2131231433, true);
                    holder.N(2131231461, true);
                    holder.itemView.setLayoutParams(new GridLayoutManager.LayoutParams(-1, u.a(70.0f, this.f1707a)));
                    holder.itemView.setBackgroundColor(0);
                }
                if (!JsonParse.getString(stringObjectMap, RewardPlus.ICON).isEmpty()) {
                    holder.N(2131231433, true);
                    holder.r(2131231433, HomeMenuListActivity.this.w0(JsonParse.getString(stringObjectMap, RewardPlus.ICON)));
                } else {
                    holder.N(2131231433, false);
                }
                holder.N(2131231461, (!HomeMenuListActivity.this.f19689q || TextUtils.isEmpty(string)) ? false : false);
                if (JsonParse.getInt(stringObjectMap, "groupType") == -1) {
                    holder.r(2131231461, 2131558776);
                    holder.w(2131231461, new b(stringObjectMap, holder));
                    return;
                }
                int A0 = HomeMenuListActivity.this.A0(string, JsonParse.getString(stringObjectMap, RewardPlus.ICON));
                if (A0 != -1) {
                    holder.r(2131231461, 2131558776);
                    holder.w(2131231461, new c(A0));
                    return;
                }
                holder.r(2131231461, 2131558775);
                holder.w(2131231461, new d(stringObjectMap));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class f extends UniversalItemDecoration {
        f() {
        }

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration
        public UniversalItemDecoration.b a(int position) {
            if (position <= 0 || position >= HomeMenuListActivity.this.f19688p.getItemCount() || JsonParse.getInt((Map) HomeMenuListActivity.this.f19688p.getItem(position), "type") != 1) {
                return null;
            }
            UniversalItemDecoration.a aVar = new UniversalItemDecoration.a();
            aVar.f19613c = u.a(2.0f, ((BaseActivity) HomeMenuListActivity.this).f1656h);
            aVar.f19610f = HomeMenuListActivity.this.getResources().getColor(2131034204);
            return aVar;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class g implements cn.bluemobi.dylan.base.adapter.common.recyclerview.b {
        g() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.b
        public void a(ViewGroup parent, View view, Object o4, int position) {
            if (HomeMenuListActivity.this.f19689q || JsonParse.getInt((Map) HomeMenuListActivity.this.f19688p.getItem(position), "type") != 2) {
                return;
            }
            new com.bxkj.student.home.d(((BaseActivity) HomeMenuListActivity.this).f1657i, JsonParse.getString((Map) HomeMenuListActivity.this.f19688p.getItem(position), RewardPlus.ICON), JsonParse.getString((Map) HomeMenuListActivity.this.f19688p.getItem(position), "name")).f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int A0(String name, String icon) {
        for (int i4 = 0; i4 < this.f19690r.size(); i4++) {
            if (this.f19690r.get(i4).containsValue(name) && this.f19690r.get(i4).containsValue(icon)) {
                return i4;
            }
        }
        return -1;
    }

    private int B0(String name) {
        for (int size = this.f19687o.size() - 1; size >= 0; size--) {
            if (this.f19687o.get(size).containsValue(name)) {
                return size;
            }
        }
        return -1;
    }

    private void C0() {
        d dVar = new d();
        this.f19684l.setLayoutManager(new GridLayoutManager(this.f1656h, 4, 1, false));
        e eVar = new e(this.f1656h, this.f19687o, dVar);
        this.f19688p = eVar;
        this.f19684l.setAdapter(eVar);
        this.f19684l.addItemDecoration(new f());
    }

    private void D0() {
        this.f19687o.addAll(y0());
        this.f19687o.addAll(u0());
        this.f19687o.addAll(t0());
        this.f19687o.addAll(x0());
        this.f19687o.addAll(v0());
        this.f19687o.addAll(z0());
    }

    private void E0() {
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1656h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f19685m.setLayoutAnimation(layoutAnimationController);
        this.f19685m.setLayoutManager(new LinearLayoutManager(this.f1656h, 0, false));
        this.f19685m.setAdapter(new b(this.f1656h, 2131427728, com.bxkj.student.home.a.b().c()));
        this.f19685m.addItemDecoration(new c());
        this.f19686n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeMenuListActivity.this.F0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F0(View view) {
        if (!this.f19689q) {
            this.f19686n.setText("\u5b8c\u6210");
            this.f19689q = true;
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("name", "\u9996\u9875\u5e94\u7528");
            arrayMap.put("type", 1);
            this.f19690r.add(0, arrayMap);
            if (this.f19690r.size() < 12) {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put("name", "");
                arrayMap2.put("type", 2);
                this.f19690r.add(arrayMap2);
            }
            this.f19687o.addAll(0, this.f19690r);
            this.f19688p.notifyDataSetChanged();
            this.f19684l.scrollToPosition(0);
            return;
        }
        this.f19686n.setText("\u7f16\u8f91");
        this.f19689q = false;
        this.f19687o.removeAll(this.f19690r);
        this.f19688p.notifyDataSetChanged();
        this.f19684l.scrollToPosition(0);
        G0();
    }

    private void G0() {
        try {
            cn.bluemobi.dylan.sqlitelibrary.c.h().c(HomeMenuDB.class);
            ArrayList arrayList = new ArrayList();
            this.f19690r.remove(0);
            List<Map<String, Object>> list = this.f19690r;
            if (JsonParse.getString(list.get(list.size() - 1), "name").isEmpty()) {
                List<Map<String, Object>> list2 = this.f19690r;
                list2.remove(list2.size() - 1);
            }
            for (Map<String, Object> map : this.f19690r) {
                HomeMenuDB homeMenuDB = new HomeMenuDB();
                homeMenuDB.setMenuName(JsonParse.getString(map, "name"));
                homeMenuDB.setIconResName(JsonParse.getString(map, RewardPlus.ICON));
                arrayList.add(homeMenuDB);
            }
            cn.bluemobi.dylan.sqlitelibrary.c.h().insert((List) arrayList);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        HomeFragment homeFragment = this.f19691s;
        if (homeFragment != null) {
            homeFragment.Z();
        }
    }

    private void s0() {
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new a());
        this.f19692t = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.f19684l);
    }

    private List<Map<String, Object>> t0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "\u7ade\u8d5b");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "\u7ade\u8d5b\u62a5\u540d");
        arrayMap2.put(RewardPlus.ICON, "icon_3_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("name", "\u7ade\u8d5b\u8bb0\u5f55");
        arrayMap3.put(RewardPlus.ICON, "icon_3_2");
        arrayMap3.put("type", 2);
        arrayList.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put("name", "\u53d1\u5e03\u901a\u8baf\u7a3f");
        arrayMap4.put(RewardPlus.ICON, "icon_3_3");
        arrayMap4.put("type", 2);
        arrayList.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put("name", "\u7535\u5b50\u53c2\u8d5b\u8bc1");
        arrayMap5.put(RewardPlus.ICON, "icon_3_4");
        arrayMap5.put("type", 2);
        arrayList.add(arrayMap5);
        return arrayList;
    }

    private List<Map<String, Object>> u0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "\u4f53\u6d4b");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "\u9884\u7ea6\u4f53\u6d4b");
        arrayMap2.put(RewardPlus.ICON, "icon_2_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("name", "\u4f53\u6d4b\u9884\u7ea6\u8bb0\u5f55");
        arrayMap3.put(RewardPlus.ICON, "icon_2_2");
        arrayMap3.put("type", 2);
        arrayList.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put("name", "\u4f53\u6d4b\u6210\u7ee9");
        arrayMap4.put(RewardPlus.ICON, "icon_2_3");
        arrayMap4.put("type", 2);
        arrayList.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put("name", "\u7533\u8bf7\u514d\u6d4b");
        arrayMap5.put(RewardPlus.ICON, "icon_2_4");
        arrayMap5.put("type", 2);
        arrayList.add(arrayMap5);
        ArrayMap arrayMap6 = new ArrayMap();
        arrayMap6.put("name", "\u73ed\u957f\u9884\u7ea6");
        arrayMap6.put(RewardPlus.ICON, "icon_2_5");
        arrayMap6.put("type", 2);
        arrayList.add(arrayMap6);
        ArrayMap arrayMap7 = new ArrayMap();
        arrayMap7.put("name", "\u73ed\u957f\u8bb0\u5f55");
        arrayMap7.put(RewardPlus.ICON, "icon_2_6");
        arrayMap7.put("type", 2);
        arrayList.add(arrayMap7);
        ArrayMap arrayMap8 = new ArrayMap();
        arrayMap8.put("name", "\u4f53\u6d4b\u8ba1\u7b97\u5668");
        arrayMap8.put(RewardPlus.ICON, "icon_2_7");
        arrayMap8.put("type", 2);
        arrayList.add(arrayMap8);
        ArrayMap arrayMap9 = new ArrayMap();
        arrayMap9.put("name", "\u81ea\u52a9\u89c6\u529b");
        arrayMap9.put(RewardPlus.ICON, "icon_2_8");
        arrayMap9.put("type", 2);
        arrayList.add(arrayMap9);
        ArrayMap arrayMap10 = new ArrayMap();
        arrayMap10.put("name", "\u4f53\u6d4b\u51c6\u8003\u8bc1");
        arrayMap10.put(RewardPlus.ICON, "icon_2_7");
        arrayMap10.put("type", 2);
        arrayList.add(arrayMap10);
        return arrayList;
    }

    private List<Map<String, Object>> v0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "\u573a\u9986");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "\u9884\u7ea6\u573a\u9986");
        arrayMap2.put(RewardPlus.ICON, "icon_5_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        if (!LoginUser.getLoginUser().getSchoolId().equals("342")) {
            ArrayMap arrayMap3 = new ArrayMap();
            arrayMap3.put("name", "\u573a\u9986\u9884\u7ea6\u8bb0\u5f55");
            arrayMap3.put(RewardPlus.ICON, "icon_5_2");
            arrayMap3.put("type", 2);
            arrayList.add(arrayMap3);
            ArrayMap arrayMap4 = new ArrayMap();
            arrayMap4.put("name", "\u7533\u8bf7\u573a\u9986");
            arrayMap4.put(RewardPlus.ICON, "icon_5_3");
            arrayMap4.put("type", 2);
            arrayList.add(arrayMap4);
            ArrayMap arrayMap5 = new ArrayMap();
            arrayMap5.put("name", "\u7533\u8bf7\u8bb0\u5f55");
            arrayMap5.put(RewardPlus.ICON, "icon_5_4");
            arrayMap5.put("type", 2);
            arrayList.add(arrayMap5);
        }
        return arrayList;
    }

    private List<Map<String, Object>> x0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "\u9633\u5149\u4f53\u80b2");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "App\u8dd1\u6b65");
        arrayMap2.put(RewardPlus.ICON, "icon_4_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("name", "\u7ea6\u8dd1");
        arrayMap3.put(RewardPlus.ICON, "icon_4_2");
        arrayMap3.put("type", 2);
        arrayList.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put("name", "\u953b\u70bc\u8003\u52e4");
        arrayMap4.put(RewardPlus.ICON, "icon_4_3");
        arrayMap4.put("type", 2);
        arrayList.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put("name", "\u573a\u9986\u6253\u5361");
        arrayMap5.put(RewardPlus.ICON, "icon_4_4");
        arrayMap5.put("type", 2);
        arrayList.add(arrayMap5);
        ArrayMap arrayMap6 = new ArrayMap();
        arrayMap6.put("name", "\u7533\u8bf7\u514d\u8dd1");
        arrayMap6.put(RewardPlus.ICON, "icon_4_5");
        arrayMap6.put("type", 2);
        arrayList.add(arrayMap6);
        if (LoginUser.getLoginUser().getIsOpenKeep() == 1) {
            ArrayMap arrayMap7 = new ArrayMap();
            arrayMap7.put("name", "\u7ed1\u5b9aKeep\u8d26\u53f7");
            arrayMap7.put(RewardPlus.ICON, "keep");
            arrayMap7.put("type", 2);
            arrayList.add(arrayMap7);
            ArrayMap arrayMap8 = new ArrayMap();
            arrayMap8.put("name", "\u540c\u6b65Keep\u6570\u636e");
            arrayMap8.put(RewardPlus.ICON, "keep");
            arrayMap8.put("type", 2);
            arrayList.add(arrayMap8);
        }
        return arrayList;
    }

    private List<Map<String, Object>> y0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "\u6559\u5b66");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "\u67e5\u770b" + LoginUser.getLoginUser().getViewAfterLabelName());
        arrayMap2.put(RewardPlus.ICON, "icon_1_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("name", "\u5728\u7ebf\u9009" + LoginUser.getLoginUser().getXuanAfterLabelName());
        arrayMap3.put(RewardPlus.ICON, "icon_1_2");
        arrayMap3.put("type", 2);
        arrayList.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put("name", "\u67e5\u770b\u70b9\u540d");
        arrayMap4.put(RewardPlus.ICON, "icon_1_3");
        arrayMap4.put("type", 2);
        arrayList.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put("name", "\u4e0a\u8bfe\u7b7e\u5230");
        arrayMap5.put(RewardPlus.ICON, "icon_1_4");
        arrayMap5.put("type", 2);
        arrayList.add(arrayMap5);
        ArrayMap arrayMap6 = new ArrayMap();
        arrayMap6.put("name", "\u4e0a\u8bfe\u8bf7\u5047");
        arrayMap6.put(RewardPlus.ICON, "icon_1_5");
        arrayMap6.put("type", 2);
        arrayList.add(arrayMap6);
        ArrayMap arrayMap7 = new ArrayMap();
        arrayMap7.put("name", "\u8bc4\u4ef7\u6559\u5e08");
        arrayMap7.put(RewardPlus.ICON, "icon_1_6");
        arrayMap7.put("type", 2);
        arrayList.add(arrayMap7);
        ArrayMap arrayMap8 = new ArrayMap();
        arrayMap8.put("name", "\u7406\u8bba\u8003\u8bd5");
        arrayMap8.put(RewardPlus.ICON, "icon_1_7");
        arrayMap8.put("type", 2);
        arrayList.add(arrayMap8);
        ArrayMap arrayMap9 = new ArrayMap();
        arrayMap9.put("name", "\u5e08\u751f\u4e92\u52a8");
        arrayMap9.put(RewardPlus.ICON, "icon_1_8");
        arrayMap9.put("type", 2);
        arrayList.add(arrayMap9);
        ArrayMap arrayMap10 = new ArrayMap();
        arrayMap10.put("name", "\u7533\u8bf7\u72b6\u6001");
        arrayMap10.put(RewardPlus.ICON, "icon_1_9");
        arrayMap10.put("type", 2);
        arrayList.add(arrayMap10);
        ArrayMap arrayMap11 = new ArrayMap();
        arrayMap11.put("name", "\u671f\u672b\u6210\u7ee9");
        arrayMap11.put(RewardPlus.ICON, "icon_1_10");
        arrayMap11.put("type", 2);
        arrayList.add(arrayMap11);
        ArrayMap arrayMap12 = new ArrayMap();
        arrayMap12.put("name", "\u7533\u8bf7\u73ed\u957f");
        arrayMap12.put(RewardPlus.ICON, "icon_1_11");
        arrayMap12.put("type", 2);
        arrayList.add(arrayMap12);
        ArrayMap arrayMap13 = new ArrayMap();
        arrayMap13.put("name", "\u73ed\u7ea7\u7ba1\u7406");
        arrayMap13.put(RewardPlus.ICON, "icon_1_12");
        arrayMap13.put("type", 2);
        arrayList.add(arrayMap13);
        ArrayMap arrayMap14 = new ArrayMap();
        arrayMap14.put("name", "\u516c\u5171\u73ed\u7ea7");
        arrayMap14.put(RewardPlus.ICON, "icon_1_13");
        arrayMap14.put("type", 2);
        arrayList.add(arrayMap14);
        ArrayMap arrayMap15 = new ArrayMap();
        arrayMap15.put("name", "\u9884\u7ea6\u6d3b\u52a8");
        arrayMap15.put(RewardPlus.ICON, "icon_1_14");
        arrayMap15.put("type", 2);
        arrayList.add(arrayMap15);
        ArrayMap arrayMap16 = new ArrayMap();
        arrayMap16.put("name", "\u6211\u7684\u6d3b\u52a8");
        arrayMap16.put(RewardPlus.ICON, "icon_1_15");
        arrayMap16.put("type", 2);
        arrayList.add(arrayMap16);
        ArrayMap arrayMap17 = new ArrayMap();
        arrayMap17.put("name", "\u5728\u7ebf\u5b66\u4e60");
        arrayMap17.put(RewardPlus.ICON, "icon_1_16");
        arrayMap17.put("type", 2);
        arrayList.add(arrayMap17);
        ArrayMap arrayMap18 = new ArrayMap();
        arrayMap18.put("name", "\u9884\u7ea6\u8003\u8bd5");
        arrayMap18.put(RewardPlus.ICON, "icon_1_17");
        arrayMap18.put("type", 2);
        arrayList.add(arrayMap18);
        if (LoginUser.getLoginUser().getSchoolId().equals("92") || LoginUser.getLoginUser().getSchoolId().equals("11") || LoginUser.getLoginUser().getSchoolId().equals("95") || LoginUser.getLoginUser().getSchoolId().equals("97") || LoginUser.getLoginUser().getSchoolId().equals("130")) {
            ArrayMap arrayMap19 = new ArrayMap();
            arrayMap19.put("name", "\u4f53\u80b2\u4e13\u4e1a\u9898\u5e93");
            arrayMap19.put(RewardPlus.ICON, "icon_1_18");
            arrayMap19.put("type", 2);
            arrayMap19.put("groupType", -1);
            arrayList.add(arrayMap19);
        }
        ArrayMap arrayMap20 = new ArrayMap();
        arrayMap20.put("name", "\u8bfe\u540e\u4f5c\u4e1a");
        arrayMap20.put(RewardPlus.ICON, "ic_home_word");
        arrayMap20.put("type", 2);
        arrayList.add(arrayMap20);
        if (LoginUser.getLoginUser().getSchoolId().equals("92") || LoginUser.getLoginUser().getSchoolId().equals("11") || LoginUser.getLoginUser().getSchoolId().equals("97") || LoginUser.getLoginUser().getSchoolId().equals("130")) {
            ArrayMap arrayMap21 = new ArrayMap();
            arrayMap21.put("name", "\u4f53\u80b2\u77e5\u8bc6\u7ade\u8d5b");
            arrayMap21.put(RewardPlus.ICON, "icon_1_18");
            arrayMap21.put("type", 2);
            arrayMap21.put("groupType", -1);
            arrayList.add(arrayMap21);
        }
        return arrayList;
    }

    private List<Map<String, Object>> z0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "\u5668\u6750");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "\u501f\u7528\u5668\u6750");
        arrayMap2.put(RewardPlus.ICON, "icon_6_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("name", "\u501f\u7528\u8bb0\u5f55");
        arrayMap3.put(RewardPlus.ICON, "icon_6_2");
        arrayMap3.put("type", 2);
        arrayList.add(arrayMap3);
        return arrayList;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void N() {
        this.f19688p.k(new g());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int P() {
        return 2131427410;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        this.f19691s = (HomeFragment) cn.bluemobi.dylan.base.utils.a.n().o(HomeFragment.class);
        this.f19690r = com.bxkj.student.home.a.b().c();
        D0();
        C0();
        E0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U() {
        setTitle("\u5168\u90e8\u5e94\u7528");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void V(Bundle savedInstanceState) {
        this.f19686n = (Button) findViewById(2131230973);
        this.f19685m = (RecyclerView) findViewById(2131232551);
        this.f19684l = (RecyclerView) findViewById(2131232540);
        s0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
    }

    public int w0(String imageName) {
        return imageName.equals("ic_home_word") ? getResources().getIdentifier(imageName, "drawable", getPackageName()) : getResources().getIdentifier(imageName, "mipmap", getPackageName());
    }
}
