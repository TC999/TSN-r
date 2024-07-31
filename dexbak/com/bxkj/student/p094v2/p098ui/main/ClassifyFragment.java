package com.bxkj.student.p094v2.p098ui.main;

import android.animation.ObjectAnimator;
import android.widget.TextView;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import com.bxkj.base.p085v2.base.BaseAdapter;
import com.bxkj.base.p085v2.base.BaseFragment;
import com.bxkj.base.p085v2.base.BaseMultiItemAdapter;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.databinding.V2ItemForClassifyMenuBinding;
import com.bxkj.student.databinding.V2MainTabClassifyFragmentBinding;
import com.bxkj.student.p094v2.common.view.CardGridMenuItemDecoration;
import com.bxkj.student.p094v2.p103vm.MainViewModel;
import com.kuaishou.weapon.p205p0.C7304t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClassifyFragment.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004R&\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000fR(\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR*\u0010\u0014\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0013R>\u0010\u001c\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u0017\u0010\u001b¨\u0006\u001f"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/main/ClassifyFragment;", "Lcom/bxkj/base/v2/base/BaseFragment;", "Lcom/bxkj/student/databinding/V2MainTabClassifyFragmentBinding;", "Lcom/bxkj/student/v2/vm/MainViewModel;", "Lkotlin/f1;", "k", C7304t.f25048d, ExifInterface.LONGITUDE_EAST, "p", "D", "j", "", "", "", "", "Ljava/util/List;", "menuListData", "homeMenuList", "Lcom/bxkj/base/v2/base/BaseMultiItemAdapter;", "Lcom/bxkj/base/v2/base/BaseMultiItemAdapter;", "adapter", "Lcom/bxkj/base/v2/base/BaseAdapter;", "Lcom/bxkj/student/databinding/V2ItemForClassifyMenuBinding;", "m", "Lcom/bxkj/base/v2/base/BaseAdapter;", "g", "()Lcom/bxkj/base/v2/base/BaseAdapter;", "(Lcom/bxkj/base/v2/base/BaseAdapter;)V", "homeMenuAdapter", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.main.ClassifyFragment */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class ClassifyFragment extends BaseFragment<V2MainTabClassifyFragmentBinding, MainViewModel> {
    @NotNull

    /* renamed from: j */
    private final List<Map<String, Object>> f20487j = new ArrayList();
    @NotNull

    /* renamed from: k */
    private final List<Map<String, Object>> f20488k = new ArrayList();
    @Nullable

    /* renamed from: l */
    private BaseMultiItemAdapter<Map<String, Object>> f20489l;
    @Nullable

    /* renamed from: m */
    private BaseAdapter<Map<String, Object>, V2ItemForClassifyMenuBinding> f20490m;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static final void m38708h(ClassifyFragment this$0, List list) {
        Integer valueOf;
        C14342f0.m8184p(this$0, "this$0");
        this$0.f20488k.clear();
        if (list == null) {
            valueOf = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (C14342f0.m8193g(JsonGet.f15134a.m43760t((Map) obj, "isShow"), "1")) {
                    arrayList.add(obj);
                }
            }
            valueOf = Integer.valueOf(arrayList.size());
        }
        TextView textView = this$0.mo43920M().tvHomeMenuCount;
        textView.setText("已收起" + valueOf + "个应用");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static final void m38707i(ClassifyFragment this$0, List list) {
        C14342f0.m8184p(this$0, "this$0");
        BaseMultiItemAdapter<Map<String, Object>> baseMultiItemAdapter = this$0.f20489l;
        if (baseMultiItemAdapter != null) {
            baseMultiItemAdapter.notifyItemRangeRemoved(0, this$0.f20487j.size());
        }
        this$0.f20487j.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Map<String, ? extends Object> map = (Map) it.next();
                ArrayMap arrayMap = new ArrayMap();
                JsonGet jsonGet = JsonGet.f15134a;
                arrayMap.put("name", jsonGet.m43760t(map, "typeName"));
                arrayMap.put("type", 0);
                this$0.f20487j.add(arrayMap);
                List<Map<String, Object>> m43766n = jsonGet.m43766n(map, "menus");
                ArrayList arrayList = new ArrayList();
                for (Object obj : m43766n) {
                    if (C14342f0.m8193g(JsonGet.f15134a.m43760t((Map) obj, "isShow"), "1")) {
                        arrayList.add(obj);
                    }
                }
                this$0.f20487j.addAll(arrayList);
            }
        }
        BaseMultiItemAdapter<Map<String, Object>> baseMultiItemAdapter2 = this$0.f20489l;
        if (baseMultiItemAdapter2 == null) {
            return;
        }
        baseMultiItemAdapter2.notifyItemRangeInserted(0, this$0.f20487j.size());
    }

    /* renamed from: k */
    private final void m38705k() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(mo43920M().tvHomeMenuArrow, "rotation", 0.0f, 90.0f);
        ofFloat.setDuration(200L);
        ofFloat.start();
    }

    /* renamed from: l */
    private final void m38704l() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(mo43920M().tvHomeMenuArrow, "rotation", 90.0f, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.start();
    }

    /* renamed from: D */
    public final void m38712D() {
        BaseAdapter<Map<String, Object>, V2ItemForClassifyMenuBinding> baseAdapter = this.f20490m;
        boolean z = false;
        if (baseAdapter != null && baseAdapter.getItemCount() == 0) {
            z = true;
        }
        if (z) {
            List<Map<String, Object>> value = mo43911x().m38171O().getValue();
            if (value != null) {
                ArrayList<Map<String, Object>> arrayList = new ArrayList();
                for (Object obj : value) {
                    if (C14342f0.m8193g(JsonGet.f15134a.m43760t((Map) obj, "isShow"), "1")) {
                        arrayList.add(obj);
                    }
                }
                for (Map<String, Object> map : arrayList) {
                    this.f20488k.add(map);
                }
            }
            m38705k();
        } else {
            this.f20488k.clear();
            m38704l();
        }
        BaseAdapter<Map<String, Object>, V2ItemForClassifyMenuBinding> baseAdapter2 = this.f20490m;
        if (baseAdapter2 == null) {
            return;
        }
        baseAdapter2.notifyDataSetChanged();
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        m43975d(mo43912w());
        mo43920M().setClassifyFragment(this);
        this.f20489l = new ClassifyFragment$initUiData$1(this, this.f20487j);
        mo43920M().rvMenu.setAdapter(this.f20489l);
        mo43920M().rvMenu.addItemDecoration(new CardGridMenuItemDecoration());
        mo43911x().m38175K();
        this.f20490m = new ClassifyFragment$initUiData$2(this, this.f20488k);
        mo43920M().rvHomeMenu.setAdapter(this.f20490m);
    }

    @Nullable
    /* renamed from: g */
    public final BaseAdapter<Map<String, Object>, V2ItemForClassifyMenuBinding> m38709g() {
        return this.f20490m;
    }

    /* renamed from: j */
    public final void m38706j() {
        ClassifyFragment classifyFragment = this.f20487j.isEmpty() ? this : null;
        if (classifyFragment == null) {
            return;
        }
        if ((m43977b() ? classifyFragment : null) == null) {
            return;
        }
        mo43911x().m38175K();
    }

    /* renamed from: m */
    public final void m38703m(@Nullable BaseAdapter<Map<String, Object>, V2ItemForClassifyMenuBinding> baseAdapter) {
        this.f20490m = baseAdapter;
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
        mo43911x().m38171O().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClassifyFragment.m38708h(ClassifyFragment.this, (List) obj);
            }
        });
        mo43911x().m38174L().observe(mo43912w(), new Observer() { // from class: com.bxkj.student.v2.ui.main.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ClassifyFragment.m38707i(ClassifyFragment.this, (List) obj);
            }
        });
    }
}
