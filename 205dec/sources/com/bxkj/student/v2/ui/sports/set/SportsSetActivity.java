package com.bxkj.student.v2.ui.sports.set;

import androidx.fragment.app.FragmentActivity;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.utils.m;
import com.bxkj.student.databinding.AcV2SportsSetBinding;
import com.bxkj.student.v2.common.utils.i;
import com.bxkj.student.v2.ui.sports.v3.record.V3RecordListActivity;
import com.bxkj.student.v2.ui.sports.v3.set.V3StatisticsActivity;
import com.bxkj.student.v2.vm.sports.set.SportsSetVM;
import d2.l;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SportsSetActivity.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004\u00a8\u0006\u000f"}, d2 = {"Lcom/bxkj/student/v2/ui/sports/set/SportsSetActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV2SportsSetBinding;", "Lcom/bxkj/student/v2/vm/sports/set/SportsSetVM;", "Lkotlin/f1;", "E", "p", "N", "P", "O", "R", "Q", "S", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class SportsSetActivity extends BaseActivity<AcV2SportsSetBinding, SportsSetVM> {

    /* compiled from: SportsSetActivity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0000H\n"}, d2 = {"", "", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    static final class a extends Lambda implements l<Map<String, Object>, f1> {
        a() {
            super(1);
        }

        public final void a(@NotNull Map<String, Object> it) {
            f0.p(it, "it");
            m mVar = m.a;
            String t3 = mVar.t(it, "name");
            String t4 = mVar.t(it, "linkUrl");
            i iVar = i.f23368a;
            FragmentActivity w3 = SportsSetActivity.this.w();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("name", t3);
            linkedHashMap.put("linkUrl", t4);
            f1 f1Var = f1.f55527a;
            iVar.b(w3, linkedHashMap);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(Map<String, Object> map) {
            a(map);
            return f1.f55527a;
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        M().setMSportsSetActivity(this);
    }

    public final void N() {
        startActivity(getIntent().setClass(C(), SportsDescriptionActivity.class).putExtra("showBottom", false));
    }

    public final void O() {
        startActivity(getIntent().setClass(C(), SportsRankActivity.class));
    }

    public final void P() {
        startActivity(getIntent().setClass(C(), V3RecordListActivity.class));
    }

    public final void Q() {
        startActivity(getIntent().setClass(C(), SoundFrequencyActivity.class));
    }

    public final void R() {
        startActivity(getIntent().setClass(C(), V3StatisticsActivity.class));
    }

    public final void S() {
        startActivity(getIntent().setClass(C(), PermissionSetActivity.class));
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
