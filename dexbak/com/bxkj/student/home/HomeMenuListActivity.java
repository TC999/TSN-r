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
import cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.MultiItemCommonAdapter;
import cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.Tools;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.sqlitelibrary.SQLiteDbUtil;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.C4215R;
import com.bxkj.student.common.p088db.HomeMenuDB;
import com.bxkj.student.common.utils.UniversalItemDecoration;
import com.bxkj.student.main.HomeFragment;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class HomeMenuListActivity extends BaseActivity {

    /* renamed from: l */
    private RecyclerView f16294l;

    /* renamed from: m */
    private RecyclerView f16295m;

    /* renamed from: n */
    private Button f16296n;

    /* renamed from: p */
    private CommonAdapter<Map<String, Object>> f16298p;

    /* renamed from: r */
    private List<Map<String, Object>> f16300r;

    /* renamed from: s */
    private HomeFragment f16301s;

    /* renamed from: t */
    private ItemTouchHelper f16302t;

    /* renamed from: k */
    private final String f16293k = "groupType";

    /* renamed from: o */
    private List<Map<String, Object>> f16297o = new ArrayList();

    /* renamed from: q */
    private boolean f16299q = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.HomeMenuListActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4299a extends ItemTouchHelper.Callback {
        C4299a() {
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            viewHolder.itemView.setBackgroundColor(-1);
            super.clearView(recyclerView, viewHolder);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            int i;
            if (viewHolder.getItemViewType() == 1 || viewHolder.getItemViewType() != viewHolder.getItemViewType() || !HomeMenuListActivity.this.f16299q || viewHolder.getAdapterPosition() >= HomeMenuListActivity.this.f16300r.size() || JsonParse.getString((Map) HomeMenuListActivity.this.f16300r.get(viewHolder.getAdapterPosition()), "name").isEmpty()) {
                i = 0;
            } else {
                i = recyclerView.getLayoutManager() instanceof GridLayoutManager ? 15 : 3;
            }
            return ItemTouchHelper.Callback.makeMovementFlags(i, 0);
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean isLongPressDragEnabled() {
            if (HomeMenuListActivity.this.f16299q) {
                ((Vibrator) ((BaseActivity) HomeMenuListActivity.this).f1669h.getSystemService("vibrator")).vibrate(500L);
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            int adapterPosition = viewHolder.getAdapterPosition();
            int adapterPosition2 = target.getAdapterPosition();
            if (JsonParse.getString((Map) HomeMenuListActivity.this.f16300r.get(adapterPosition), "name").isEmpty() || JsonParse.getString((Map) HomeMenuListActivity.this.f16300r.get(adapterPosition2), "name").isEmpty()) {
                return false;
            }
            if (adapterPosition < adapterPosition2) {
                int i = adapterPosition;
                while (i < adapterPosition2) {
                    int i2 = i + 1;
                    Collections.swap(HomeMenuListActivity.this.f16300r, i, i2);
                    i = i2;
                }
            } else {
                for (int i3 = adapterPosition; i3 > adapterPosition2; i3--) {
                    Collections.swap(HomeMenuListActivity.this.f16300r, i3, i3 - 1);
                }
            }
            HomeMenuListActivity.this.f16298p.notifyItemMoved(adapterPosition, adapterPosition2);
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
    /* renamed from: com.bxkj.student.home.HomeMenuListActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4300b extends CommonAdapter<Map<String, Object>> {
        C4300b(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: m */
        public void mo39408c(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.m57852r(2131231433, HomeMenuListActivity.this.m42734w0(JsonParse.getString(stringObjectMap, RewardPlus.ICON)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.HomeMenuListActivity$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4301c extends UniversalItemDecoration {
        C4301c() {
        }

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration
        /* renamed from: a */
        public UniversalItemDecoration.AbstractC4246b mo40391a(int position) {
            UniversalItemDecoration.C4245a c4245a = new UniversalItemDecoration.C4245a();
            c4245a.f16212a = Tools.m57620a(7.0f, ((BaseActivity) HomeMenuListActivity.this).f1669h);
            c4245a.f16211f = -1;
            return c4245a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.HomeMenuListActivity$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4302d implements InterfaceC1125a<Map<String, Object>> {
        C4302d() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a
        /* renamed from: b */
        public int mo40464b(int itemType) {
            return itemType == 1 ? C4215R.C4221layout.item_for_home_class_list : C4215R.C4221layout.item_for_home_menu;
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.InterfaceC1125a
        /* renamed from: c */
        public int mo40465a(int position, Map<String, Object> stringObjectMap) {
            return JsonParse.getInt(stringObjectMap, "type");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.HomeMenuListActivity$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4303e extends MultiItemCommonAdapter<Map<String, Object>> {

        /* renamed from: com.bxkj.student.home.HomeMenuListActivity$e$a */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        class C4304a extends GridLayoutManager.SpanSizeLookup {
            C4304a() {
            }

            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                return C4303e.this.getItemViewType(position) != 1 ? 1 : 4;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.HomeMenuListActivity$e$b */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4305b implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f16309a;

            /* renamed from: b */
            final /* synthetic */ ViewHolder f16310b;

            View$OnClickListenerC4305b(final Map val$stringObjectMap, final ViewHolder val$holder) {
                this.f16309a = val$stringObjectMap;
                this.f16310b = val$holder;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                C4303e.this.m42723r(this.f16309a, this.f16310b);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.HomeMenuListActivity$e$c */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4306c implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ int f16312a;

            View$OnClickListenerC4306c(final int val$index) {
                this.f16312a = val$index;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                C4303e.this.m42722s(this.f16312a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bxkj.student.home.HomeMenuListActivity$e$d */
        /* loaded from: E:\fuckcool\tsn\5141176.dex */
        public class View$OnClickListenerC4307d implements View.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ Map f16314a;

            View$OnClickListenerC4307d(final Map val$stringObjectMap) {
                this.f16314a = val$stringObjectMap;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                C4303e.this.m42725p(this.f16314a);
            }
        }

        C4303e(Context context, List datas, InterfaceC1125a multiItemTypeSupport) {
            super(context, datas, multiItemTypeSupport);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: p */
        public void m42725p(Map<String, Object> stringObjectMap) {
            int size = HomeMenuListActivity.this.f16300r.size();
            HashMap hashMap = new HashMap(stringObjectMap);
            hashMap.put("groupType", -1);
            if (size == 12 && JsonParse.getString((Map) HomeMenuListActivity.this.f16300r.get(HomeMenuListActivity.this.f16300r.size() - 1), "name").isEmpty()) {
                int i = size - 1;
                HomeMenuListActivity.this.f16300r.set(i, hashMap);
                HomeMenuListActivity.this.f16297o.set(i, hashMap);
                notifyItemRangeChanged(i, HomeMenuListActivity.this.f16297o.size());
            } else if (size < 12) {
                int i2 = size - 1;
                HomeMenuListActivity.this.f16300r.add(i2, hashMap);
                HomeMenuListActivity.this.f16297o.add(i2, hashMap);
                int i3 = size - 2;
                notifyItemInserted(i3);
                notifyItemRangeChanged(i3, HomeMenuListActivity.this.f16297o.size());
            } else {
                HomeMenuListActivity.this.m57919h0("首页最多添加11个应用");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: r */
        public void m42723r(Map<String, Object> stringObjectMap, ViewHolder holder) {
            HomeMenuListActivity.this.f16297o.remove(stringObjectMap);
            HomeMenuListActivity.this.f16300r.remove(stringObjectMap);
            if (!JsonParse.getString((Map) HomeMenuListActivity.this.f16300r.get(HomeMenuListActivity.this.f16300r.size() - 1), "name").isEmpty()) {
                ArrayMap arrayMap = new ArrayMap();
                arrayMap.put("name", "");
                arrayMap.put("type", 2);
                HomeMenuListActivity.this.f16300r.add(arrayMap);
                HomeMenuListActivity.this.f16297o.add(HomeMenuListActivity.this.f16300r.size() - 1, arrayMap);
            }
            notifyItemRemoved(holder.m57864f());
            notifyItemRangeChanged(holder.m57864f(), HomeMenuListActivity.this.f16297o.size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: s */
        public void m42722s(int index) {
            HomeMenuListActivity.this.f16297o.remove(index);
            HomeMenuListActivity.this.f16300r.remove(index);
            if (!JsonParse.getString((Map) HomeMenuListActivity.this.f16300r.get(HomeMenuListActivity.this.f16300r.size() - 1), "name").isEmpty()) {
                ArrayMap arrayMap = new ArrayMap();
                arrayMap.put("name", "");
                arrayMap.put("type", 2);
                HomeMenuListActivity.this.f16300r.add(arrayMap);
                HomeMenuListActivity.this.f16297o.add(HomeMenuListActivity.this.f16300r.size() - 1, arrayMap);
            }
            notifyItemRemoved(index);
            notifyItemRangeChanged(index, HomeMenuListActivity.this.f16297o.size());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                ((GridLayoutManager) layoutManager).setSpanSizeLookup(new C4304a());
            }
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.CommonAdapter
        /* renamed from: q */
        public void mo39408c(final ViewHolder holder, final Map<String, Object> stringObjectMap) {
            String string = JsonParse.getString(stringObjectMap, "name");
            if (string.equals("首页应用")) {
                SpannableString spannableString = new SpannableString(string + "(按住拖动调整顺序)");
                spannableString.setSpan(new ForegroundColorSpan(HomeMenuListActivity.this.getResources().getColor(2131034269)), 4, spannableString.length(), 34);
                ((TextView) holder.m57862h(2131233040)).setText(spannableString);
            } else {
                holder.m57874J(2131233040, string);
            }
            if (getItemViewType(holder.m57864f()) == 2) {
                boolean z = true;
                if (TextUtils.isEmpty(string)) {
                    holder.m57870N(2131233040, false);
                    holder.m57870N(2131231433, false);
                    holder.m57870N(C4215R.C4219id.iv_op, false);
                    GridLayoutManager.LayoutParams layoutParams = new GridLayoutManager.LayoutParams(-1, Tools.m57620a(50.0f, this.f1721a));
                    int m57620a = Tools.m57620a(10.0f, this.f1721a);
                    int m57620a2 = Tools.m57620a(15.0f, this.f1721a);
                    layoutParams.setMargins(m57620a2, m57620a, m57620a2, m57620a);
                    holder.itemView.setLayoutParams(layoutParams);
                    holder.itemView.setBackgroundResource(C4215R.C4218drawable.f15991xk);
                } else {
                    holder.m57870N(2131233040, true);
                    holder.m57870N(2131231433, true);
                    holder.m57870N(C4215R.C4219id.iv_op, true);
                    holder.itemView.setLayoutParams(new GridLayoutManager.LayoutParams(-1, Tools.m57620a(70.0f, this.f1721a)));
                    holder.itemView.setBackgroundColor(0);
                }
                if (!JsonParse.getString(stringObjectMap, RewardPlus.ICON).isEmpty()) {
                    holder.m57870N(2131231433, true);
                    holder.m57852r(2131231433, HomeMenuListActivity.this.m42734w0(JsonParse.getString(stringObjectMap, RewardPlus.ICON)));
                } else {
                    holder.m57870N(2131231433, false);
                }
                holder.m57870N(C4215R.C4219id.iv_op, (!HomeMenuListActivity.this.f16299q || TextUtils.isEmpty(string)) ? false : false);
                if (JsonParse.getInt(stringObjectMap, "groupType") == -1) {
                    holder.m57852r(C4215R.C4219id.iv_op, C4215R.mipmap.jian);
                    holder.m57847w(C4215R.C4219id.iv_op, new View$OnClickListenerC4305b(stringObjectMap, holder));
                    return;
                }
                int m42755A0 = HomeMenuListActivity.this.m42755A0(string, JsonParse.getString(stringObjectMap, RewardPlus.ICON));
                if (m42755A0 != -1) {
                    holder.m57852r(C4215R.C4219id.iv_op, C4215R.mipmap.jian);
                    holder.m57847w(C4215R.C4219id.iv_op, new View$OnClickListenerC4306c(m42755A0));
                    return;
                }
                holder.m57852r(C4215R.C4219id.iv_op, C4215R.mipmap.jia);
                holder.m57847w(C4215R.C4219id.iv_op, new View$OnClickListenerC4307d(stringObjectMap));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.home.HomeMenuListActivity$f */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C4308f extends UniversalItemDecoration {
        C4308f() {
        }

        @Override // com.bxkj.student.common.utils.UniversalItemDecoration
        /* renamed from: a */
        public UniversalItemDecoration.AbstractC4246b mo40391a(int position) {
            if (position <= 0 || position >= HomeMenuListActivity.this.f16298p.getItemCount() || JsonParse.getInt((Map) HomeMenuListActivity.this.f16298p.getItem(position), "type") != 1) {
                return null;
            }
            UniversalItemDecoration.C4245a c4245a = new UniversalItemDecoration.C4245a();
            c4245a.f16214c = Tools.m57620a(2.0f, ((BaseActivity) HomeMenuListActivity.this).f1669h);
            c4245a.f16211f = HomeMenuListActivity.this.getResources().getColor(C4215R.C4217color.defaultBackgroundColor);
            return c4245a;
        }
    }

    /* renamed from: com.bxkj.student.home.HomeMenuListActivity$g */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C4309g implements OnItemClickListener {
        C4309g() {
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.recyclerview.OnItemClickListener
        /* renamed from: a */
        public void mo39403a(ViewGroup parent, View view, Object o, int position) {
            if (HomeMenuListActivity.this.f16299q || JsonParse.getInt((Map) HomeMenuListActivity.this.f16298p.getItem(position), "type") != 2) {
                return;
            }
            new MenuOperate(((BaseActivity) HomeMenuListActivity.this).f1670i, JsonParse.getString((Map) HomeMenuListActivity.this.f16298p.getItem(position), RewardPlus.ICON), JsonParse.getString((Map) HomeMenuListActivity.this.f16298p.getItem(position), "name")).m42712f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A0 */
    public int m42755A0(String name, String icon) {
        for (int i = 0; i < this.f16300r.size(); i++) {
            if (this.f16300r.get(i).containsValue(name) && this.f16300r.get(i).containsValue(icon)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: B0 */
    private int m42754B0(String name) {
        for (int size = this.f16297o.size() - 1; size >= 0; size--) {
            if (this.f16297o.get(size).containsValue(name)) {
                return size;
            }
        }
        return -1;
    }

    /* renamed from: C0 */
    private void m42753C0() {
        C4302d c4302d = new C4302d();
        this.f16294l.setLayoutManager(new GridLayoutManager(this.f1669h, 4, 1, false));
        C4303e c4303e = new C4303e(this.f1669h, this.f16297o, c4302d);
        this.f16298p = c4303e;
        this.f16294l.setAdapter(c4303e);
        this.f16294l.addItemDecoration(new C4308f());
    }

    /* renamed from: D0 */
    private void m42752D0() {
        this.f16297o.addAll(m42732y0());
        this.f16297o.addAll(m42736u0());
        this.f16297o.addAll(m42737t0());
        this.f16297o.addAll(m42733x0());
        this.f16297o.addAll(m42735v0());
        this.f16297o.addAll(m42731z0());
    }

    /* renamed from: E0 */
    private void m42751E0() {
        LayoutAnimationController layoutAnimationController = new LayoutAnimationController(AnimationUtils.loadAnimation(this.f1669h, 2130772089));
        layoutAnimationController.setOrder(0);
        this.f16295m.setLayoutAnimation(layoutAnimationController);
        this.f16295m.setLayoutManager(new LinearLayoutManager(this.f1669h, 0, false));
        this.f16295m.setAdapter(new C4300b(this.f1669h, C4215R.C4221layout.item_for_my_menu, HomeMenu.m42720b().m42719c()));
        this.f16295m.addItemDecoration(new C4301c());
        this.f16296n.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.home.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeMenuListActivity.this.m42750F0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F0 */
    public /* synthetic */ void m42750F0(View view) {
        if (!this.f16299q) {
            this.f16296n.setText("完成");
            this.f16299q = true;
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("name", "首页应用");
            arrayMap.put("type", 1);
            this.f16300r.add(0, arrayMap);
            if (this.f16300r.size() < 12) {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put("name", "");
                arrayMap2.put("type", 2);
                this.f16300r.add(arrayMap2);
            }
            this.f16297o.addAll(0, this.f16300r);
            this.f16298p.notifyDataSetChanged();
            this.f16294l.scrollToPosition(0);
            return;
        }
        this.f16296n.setText("编辑");
        this.f16299q = false;
        this.f16297o.removeAll(this.f16300r);
        this.f16298p.notifyDataSetChanged();
        this.f16294l.scrollToPosition(0);
        m42749G0();
    }

    /* renamed from: G0 */
    private void m42749G0() {
        try {
            SQLiteDbUtil.m57474h().m57479c(HomeMenuDB.class);
            ArrayList arrayList = new ArrayList();
            this.f16300r.remove(0);
            List<Map<String, Object>> list = this.f16300r;
            if (JsonParse.getString(list.get(list.size() - 1), "name").isEmpty()) {
                List<Map<String, Object>> list2 = this.f16300r;
                list2.remove(list2.size() - 1);
            }
            for (Map<String, Object> map : this.f16300r) {
                HomeMenuDB homeMenuDB = new HomeMenuDB();
                homeMenuDB.setMenuName(JsonParse.getString(map, "name"));
                homeMenuDB.setIconResName(JsonParse.getString(map, RewardPlus.ICON));
                arrayList.add(homeMenuDB);
            }
            SQLiteDbUtil.m57474h().insert((List) arrayList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HomeFragment homeFragment = this.f16301s;
        if (homeFragment != null) {
            homeFragment.m40660Z();
        }
    }

    /* renamed from: s0 */
    private void m42738s0() {
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new C4299a());
        this.f16302t = itemTouchHelper;
        itemTouchHelper.attachToRecyclerView(this.f16294l);
    }

    /* renamed from: t0 */
    private List<Map<String, Object>> m42737t0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "竞赛");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "竞赛报名");
        arrayMap2.put(RewardPlus.ICON, "icon_3_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("name", "竞赛记录");
        arrayMap3.put(RewardPlus.ICON, "icon_3_2");
        arrayMap3.put("type", 2);
        arrayList.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put("name", "发布通讯稿");
        arrayMap4.put(RewardPlus.ICON, "icon_3_3");
        arrayMap4.put("type", 2);
        arrayList.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put("name", "电子参赛证");
        arrayMap5.put(RewardPlus.ICON, "icon_3_4");
        arrayMap5.put("type", 2);
        arrayList.add(arrayMap5);
        return arrayList;
    }

    /* renamed from: u0 */
    private List<Map<String, Object>> m42736u0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "体测");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "预约体测");
        arrayMap2.put(RewardPlus.ICON, "icon_2_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("name", "体测预约记录");
        arrayMap3.put(RewardPlus.ICON, "icon_2_2");
        arrayMap3.put("type", 2);
        arrayList.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put("name", "体测成绩");
        arrayMap4.put(RewardPlus.ICON, "icon_2_3");
        arrayMap4.put("type", 2);
        arrayList.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put("name", "申请免测");
        arrayMap5.put(RewardPlus.ICON, "icon_2_4");
        arrayMap5.put("type", 2);
        arrayList.add(arrayMap5);
        ArrayMap arrayMap6 = new ArrayMap();
        arrayMap6.put("name", "班长预约");
        arrayMap6.put(RewardPlus.ICON, "icon_2_5");
        arrayMap6.put("type", 2);
        arrayList.add(arrayMap6);
        ArrayMap arrayMap7 = new ArrayMap();
        arrayMap7.put("name", "班长记录");
        arrayMap7.put(RewardPlus.ICON, "icon_2_6");
        arrayMap7.put("type", 2);
        arrayList.add(arrayMap7);
        ArrayMap arrayMap8 = new ArrayMap();
        arrayMap8.put("name", "体测计算器");
        arrayMap8.put(RewardPlus.ICON, "icon_2_7");
        arrayMap8.put("type", 2);
        arrayList.add(arrayMap8);
        ArrayMap arrayMap9 = new ArrayMap();
        arrayMap9.put("name", "自助视力");
        arrayMap9.put(RewardPlus.ICON, "icon_2_8");
        arrayMap9.put("type", 2);
        arrayList.add(arrayMap9);
        ArrayMap arrayMap10 = new ArrayMap();
        arrayMap10.put("name", "体测准考证");
        arrayMap10.put(RewardPlus.ICON, "icon_2_7");
        arrayMap10.put("type", 2);
        arrayList.add(arrayMap10);
        return arrayList;
    }

    /* renamed from: v0 */
    private List<Map<String, Object>> m42735v0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "场馆");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "预约场馆");
        arrayMap2.put(RewardPlus.ICON, "icon_5_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        if (!LoginUser.getLoginUser().getSchoolId().equals("342")) {
            ArrayMap arrayMap3 = new ArrayMap();
            arrayMap3.put("name", "场馆预约记录");
            arrayMap3.put(RewardPlus.ICON, "icon_5_2");
            arrayMap3.put("type", 2);
            arrayList.add(arrayMap3);
            ArrayMap arrayMap4 = new ArrayMap();
            arrayMap4.put("name", "申请场馆");
            arrayMap4.put(RewardPlus.ICON, "icon_5_3");
            arrayMap4.put("type", 2);
            arrayList.add(arrayMap4);
            ArrayMap arrayMap5 = new ArrayMap();
            arrayMap5.put("name", "申请记录");
            arrayMap5.put(RewardPlus.ICON, "icon_5_4");
            arrayMap5.put("type", 2);
            arrayList.add(arrayMap5);
        }
        return arrayList;
    }

    /* renamed from: x0 */
    private List<Map<String, Object>> m42733x0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "阳光体育");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "App跑步");
        arrayMap2.put(RewardPlus.ICON, "icon_4_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("name", "约跑");
        arrayMap3.put(RewardPlus.ICON, "icon_4_2");
        arrayMap3.put("type", 2);
        arrayList.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put("name", "锻炼考勤");
        arrayMap4.put(RewardPlus.ICON, "icon_4_3");
        arrayMap4.put("type", 2);
        arrayList.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put("name", "场馆打卡");
        arrayMap5.put(RewardPlus.ICON, "icon_4_4");
        arrayMap5.put("type", 2);
        arrayList.add(arrayMap5);
        ArrayMap arrayMap6 = new ArrayMap();
        arrayMap6.put("name", "申请免跑");
        arrayMap6.put(RewardPlus.ICON, "icon_4_5");
        arrayMap6.put("type", 2);
        arrayList.add(arrayMap6);
        if (LoginUser.getLoginUser().getIsOpenKeep() == 1) {
            ArrayMap arrayMap7 = new ArrayMap();
            arrayMap7.put("name", "绑定Keep账号");
            arrayMap7.put(RewardPlus.ICON, "keep");
            arrayMap7.put("type", 2);
            arrayList.add(arrayMap7);
            ArrayMap arrayMap8 = new ArrayMap();
            arrayMap8.put("name", "同步Keep数据");
            arrayMap8.put(RewardPlus.ICON, "keep");
            arrayMap8.put("type", 2);
            arrayList.add(arrayMap8);
        }
        return arrayList;
    }

    /* renamed from: y0 */
    private List<Map<String, Object>> m42732y0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "教学");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "查看" + LoginUser.getLoginUser().getViewAfterLabelName());
        arrayMap2.put(RewardPlus.ICON, "icon_1_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("name", "在线选" + LoginUser.getLoginUser().getXuanAfterLabelName());
        arrayMap3.put(RewardPlus.ICON, "icon_1_2");
        arrayMap3.put("type", 2);
        arrayList.add(arrayMap3);
        ArrayMap arrayMap4 = new ArrayMap();
        arrayMap4.put("name", "查看点名");
        arrayMap4.put(RewardPlus.ICON, "icon_1_3");
        arrayMap4.put("type", 2);
        arrayList.add(arrayMap4);
        ArrayMap arrayMap5 = new ArrayMap();
        arrayMap5.put("name", "上课签到");
        arrayMap5.put(RewardPlus.ICON, "icon_1_4");
        arrayMap5.put("type", 2);
        arrayList.add(arrayMap5);
        ArrayMap arrayMap6 = new ArrayMap();
        arrayMap6.put("name", "上课请假");
        arrayMap6.put(RewardPlus.ICON, "icon_1_5");
        arrayMap6.put("type", 2);
        arrayList.add(arrayMap6);
        ArrayMap arrayMap7 = new ArrayMap();
        arrayMap7.put("name", "评价教师");
        arrayMap7.put(RewardPlus.ICON, "icon_1_6");
        arrayMap7.put("type", 2);
        arrayList.add(arrayMap7);
        ArrayMap arrayMap8 = new ArrayMap();
        arrayMap8.put("name", "理论考试");
        arrayMap8.put(RewardPlus.ICON, "icon_1_7");
        arrayMap8.put("type", 2);
        arrayList.add(arrayMap8);
        ArrayMap arrayMap9 = new ArrayMap();
        arrayMap9.put("name", "师生互动");
        arrayMap9.put(RewardPlus.ICON, "icon_1_8");
        arrayMap9.put("type", 2);
        arrayList.add(arrayMap9);
        ArrayMap arrayMap10 = new ArrayMap();
        arrayMap10.put("name", "申请状态");
        arrayMap10.put(RewardPlus.ICON, "icon_1_9");
        arrayMap10.put("type", 2);
        arrayList.add(arrayMap10);
        ArrayMap arrayMap11 = new ArrayMap();
        arrayMap11.put("name", "期末成绩");
        arrayMap11.put(RewardPlus.ICON, "icon_1_10");
        arrayMap11.put("type", 2);
        arrayList.add(arrayMap11);
        ArrayMap arrayMap12 = new ArrayMap();
        arrayMap12.put("name", "申请班长");
        arrayMap12.put(RewardPlus.ICON, "icon_1_11");
        arrayMap12.put("type", 2);
        arrayList.add(arrayMap12);
        ArrayMap arrayMap13 = new ArrayMap();
        arrayMap13.put("name", "班级管理");
        arrayMap13.put(RewardPlus.ICON, "icon_1_12");
        arrayMap13.put("type", 2);
        arrayList.add(arrayMap13);
        ArrayMap arrayMap14 = new ArrayMap();
        arrayMap14.put("name", "公共班级");
        arrayMap14.put(RewardPlus.ICON, "icon_1_13");
        arrayMap14.put("type", 2);
        arrayList.add(arrayMap14);
        ArrayMap arrayMap15 = new ArrayMap();
        arrayMap15.put("name", "预约活动");
        arrayMap15.put(RewardPlus.ICON, "icon_1_14");
        arrayMap15.put("type", 2);
        arrayList.add(arrayMap15);
        ArrayMap arrayMap16 = new ArrayMap();
        arrayMap16.put("name", "我的活动");
        arrayMap16.put(RewardPlus.ICON, "icon_1_15");
        arrayMap16.put("type", 2);
        arrayList.add(arrayMap16);
        ArrayMap arrayMap17 = new ArrayMap();
        arrayMap17.put("name", "在线学习");
        arrayMap17.put(RewardPlus.ICON, "icon_1_16");
        arrayMap17.put("type", 2);
        arrayList.add(arrayMap17);
        ArrayMap arrayMap18 = new ArrayMap();
        arrayMap18.put("name", "预约考试");
        arrayMap18.put(RewardPlus.ICON, "icon_1_17");
        arrayMap18.put("type", 2);
        arrayList.add(arrayMap18);
        if (LoginUser.getLoginUser().getSchoolId().equals("92") || LoginUser.getLoginUser().getSchoolId().equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE) || LoginUser.getLoginUser().getSchoolId().equals("95") || LoginUser.getLoginUser().getSchoolId().equals("97") || LoginUser.getLoginUser().getSchoolId().equals("130")) {
            ArrayMap arrayMap19 = new ArrayMap();
            arrayMap19.put("name", "体育专业题库");
            arrayMap19.put(RewardPlus.ICON, "icon_1_18");
            arrayMap19.put("type", 2);
            arrayMap19.put("groupType", -1);
            arrayList.add(arrayMap19);
        }
        ArrayMap arrayMap20 = new ArrayMap();
        arrayMap20.put("name", "课后作业");
        arrayMap20.put(RewardPlus.ICON, "ic_home_word");
        arrayMap20.put("type", 2);
        arrayList.add(arrayMap20);
        if (LoginUser.getLoginUser().getSchoolId().equals("92") || LoginUser.getLoginUser().getSchoolId().equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE) || LoginUser.getLoginUser().getSchoolId().equals("97") || LoginUser.getLoginUser().getSchoolId().equals("130")) {
            ArrayMap arrayMap21 = new ArrayMap();
            arrayMap21.put("name", "体育知识竞赛");
            arrayMap21.put(RewardPlus.ICON, "icon_1_18");
            arrayMap21.put("type", 2);
            arrayMap21.put("groupType", -1);
            arrayList.add(arrayMap21);
        }
        return arrayList;
    }

    /* renamed from: z0 */
    private List<Map<String, Object>> m42731z0() {
        ArrayList arrayList = new ArrayList();
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("name", "器材");
        arrayMap.put("type", 1);
        arrayList.add(arrayMap);
        ArrayMap arrayMap2 = new ArrayMap();
        arrayMap2.put("name", "借用器材");
        arrayMap2.put(RewardPlus.ICON, "icon_6_1");
        arrayMap2.put("type", 2);
        arrayList.add(arrayMap2);
        ArrayMap arrayMap3 = new ArrayMap();
        arrayMap3.put("name", "借用记录");
        arrayMap3.put(RewardPlus.ICON, "icon_6_2");
        arrayMap3.put("type", 2);
        arrayList.add(arrayMap3);
        return arrayList;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: N */
    public void mo39376N() {
        this.f16298p.m57834k(new C4309g());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: P */
    protected int mo39375P() {
        return C4215R.C4221layout.ac_home_menu_list;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: T */
    public void mo39374T() {
        this.f16301s = (HomeFragment) AppManager.m57776n().m57775o(HomeFragment.class);
        this.f16300r = HomeMenu.m42720b().m42719c();
        m42752D0();
        m42753C0();
        m42751E0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: U */
    public void mo39373U() {
        setTitle("全部应用");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    /* renamed from: V */
    public void mo39372V(Bundle savedInstanceState) {
        this.f16296n = (Button) findViewById(C4215R.C4219id.bt_edit);
        this.f16295m = (RecyclerView) findViewById(C4215R.C4219id.rv_my);
        this.f16294l = (RecyclerView) findViewById(2131232540);
        m42738s0();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    /* renamed from: w0 */
    public int m42734w0(String imageName) {
        return imageName.equals("ic_home_word") ? getResources().getIdentifier(imageName, "drawable", getPackageName()) : getResources().getIdentifier(imageName, "mipmap", getPackageName());
    }
}
