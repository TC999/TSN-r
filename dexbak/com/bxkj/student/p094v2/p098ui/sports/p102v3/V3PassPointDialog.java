package com.bxkj.student.p094v2.p098ui.sports.p102v3;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import com.bxkj.base.p085v2.base.BaseAdapter;
import com.bxkj.base.p085v2.base.BaseDialog;
import com.bxkj.base.p085v2.common.utils.JsonGet;
import com.bxkj.student.databinding.ItemForV3PassPointDialogBinding;
import com.bxkj.student.databinding.V3PassPointDialogBinding;
import com.bxkj.student.p094v2.common.data.SportsDataAgent;
import com.bxkj.student.p094v2.common.utils.C5541e;
import com.bxkj.student.p094v2.p103vm.sports.SportsVM;
import com.kuaishou.weapon.p205p0.C7304t;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.C14236x;
import kotlin.collections._Collections;
import kotlin.comparisons.Comparisons;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: V3PassPointDialog.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016R+\u0010\u0014\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000e0\r8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R>\u0010\u001d\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006 "}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/V3PassPointDialog;", "Lcom/bxkj/base/v2/base/BaseDialog;", "Lcom/bxkj/student/databinding/V3PassPointDialogBinding;", "Lcom/bxkj/student/v2/vm/sports/SportsVM;", "Lkotlin/f1;", C7304t.f25048d, "i", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "onStart", ExifInterface.LONGITUDE_EAST, "p", "", "", "", "", "Ljava/util/List;", "k", "()Ljava/util/List;", "dataList", "Lcom/bxkj/base/v2/base/BaseAdapter;", "", "Lcom/bxkj/student/databinding/ItemForV3PassPointDialogBinding;", "j", "Lcom/bxkj/base/v2/base/BaseAdapter;", "()Lcom/bxkj/base/v2/base/BaseAdapter;", "m", "(Lcom/bxkj/base/v2/base/BaseAdapter;)V", "adapter", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.V3PassPointDialog */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3PassPointDialog extends BaseDialog<V3PassPointDialogBinding, SportsVM> {
    @NotNull

    /* renamed from: i */
    private final List<Map<String, Object>> f20557i = new ArrayList();
    @Nullable

    /* renamed from: j */
    private BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> f20558j;

    /* compiled from: Comparisons.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$b", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.V3PassPointDialog$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5710a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int m8803g;
            JsonGet jsonGet = JsonGet.f15134a;
            m8803g = Comparisons.m8803g(Integer.valueOf(jsonGet.m43769k((Map) t, "sort")), Integer.valueOf(jsonGet.m43769k((Map) t2, "sort")));
            return m8803g;
        }
    }

    /* renamed from: i */
    private final void m38594i() {
        int m8957Y;
        Set m12208N5;
        List<Map<String, ? extends Object>> m12115h5;
        List<Map<String, Object>> m43766n = JsonGet.f15134a.m43766n(mo43911x().m38035B(), "list");
        List<Map<String, Object>> m39253s = SportsDataAgent.f19899a.m39253s();
        m8957Y = C14236x.m8957Y(m39253s, 10);
        ArrayList arrayList = new ArrayList(m8957Y);
        Iterator<T> it = m39253s.iterator();
        while (it.hasNext()) {
            arrayList.add(JsonGet.f15134a.m43760t((Map) it.next(), "id"));
        }
        m12208N5 = _Collections.m12208N5(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : m43766n) {
            if (!m12208N5.contains(JsonGet.f15134a.m43760t((Map) obj, "id"))) {
                arrayList2.add(obj);
            }
        }
        m12115h5 = _Collections.m12115h5(arrayList2, new C5710a());
        for (Map<String, ? extends Object> map : m12115h5) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            JsonGet jsonGet = JsonGet.f15134a;
            linkedHashMap.put("sort", jsonGet.m43760t(map, "sort"));
            linkedHashMap.put("name", jsonGet.m43760t(map, "content"));
            m38592k().add(linkedHashMap);
        }
        BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> baseAdapter = this.f20558j;
        if (baseAdapter == null) {
            return;
        }
        baseAdapter.notifyDataSetChanged();
    }

    /* renamed from: l */
    private final void m38591l() {
        final List<Map<String, Object>> list = this.f20557i;
        this.f20558j = new BaseAdapter<Map<String, ? extends Object>, ItemForV3PassPointDialogBinding>(list) { // from class: com.bxkj.student.v2.ui.sports.v3.V3PassPointDialog$initAdapter$1
            @Override // com.bxkj.base.p085v2.base.BaseAdapter
            /* renamed from: m */
            public void mo38351f(@NotNull ItemForV3PassPointDialogBinding itemBinding, @NotNull Map<String, ? extends Object> bean, int i) {
                C14342f0.m8184p(itemBinding, "itemBinding");
                C14342f0.m8184p(bean, "bean");
                JsonGet jsonGet = JsonGet.f15134a;
                if (jsonGet.m43769k(V3PassPointDialog.this.mo43911x().m38035B(), "isSequencePoint") == 1) {
                    itemBinding.ivPoint.setImageBitmap(C5541e.f20105a.m39137a(jsonGet.m43760t(bean, "sort")));
                } else {
                    itemBinding.ivPoint.setImageBitmap(C5541e.f20105a.m39137a("经"));
                }
                itemBinding.tvPoint.setText(jsonGet.m43760t(bean, "name"));
            }
        };
        mo43920M().f16287rv.setAdapter(this.f20558j);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43911x().m38030G(SportsDataAgent.f19899a.m39250v());
        mo43920M().setDialog(this);
        m38594i();
        m38591l();
    }

    @Nullable
    /* renamed from: j */
    public final BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> m38593j() {
        return this.f20558j;
    }

    @NotNull
    /* renamed from: k */
    public final List<Map<String, Object>> m38592k() {
        return this.f20557i;
    }

    /* renamed from: m */
    public final void m38590m(@Nullable BaseAdapter<Map<String, Object>, ItemForV3PassPointDialogBinding> baseAdapter) {
        this.f20558j = baseAdapter;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, 2131886649);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawableResource(2131034508);
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
