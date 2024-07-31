package com.bxkj.student.p094v2.p098ui.sports.p102v3.appeal;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.exifinterface.media.ExifInterface;
import cn.bluemobi.dylan.base.adapter.GridViewAddImagesAdapter;
import cn.bluemobi.dylan.base.utils.AppManager;
import cn.bluemobi.dylan.base.utils.Tools;
import com.bxkj.base.p085v2.base.BaseActivity;
import com.bxkj.base.p085v2.common.ext.ContextExt;
import com.bxkj.base.p085v2.common.utils.ImageSelectUtils;
import com.bxkj.student.databinding.AcV3SportsAppealBinding;
import com.bxkj.student.p094v2.p098ui.p099h5.H5AppActivity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.V3SportsHomeActivity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.V3RecordDetailActivity;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.record.tab.V3RecordInValidFragment;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.record.tab.V3RecordValidFragment;
import com.bxkj.student.p094v2.p103vm.sports.appeal.AppealVM;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.C14579x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: V3AppealActivity.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, m12616d2 = {"Lcom/bxkj/student/v2/ui/sports/v3/appeal/V3AppealActivity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcV3SportsAppealBinding;", "Lcom/bxkj/student/v2/vm/sports/appeal/AppealVM;", "Lkotlin/f1;", ExifInterface.LONGITUDE_EAST, "p", "", "", "i", "Ljava/util/List;", "paths", "Lcn/bluemobi/dylan/base/adapter/c;", "j", "Lcn/bluemobi/dylan/base/adapter/c;", "gridViewAddImagesAdapter", "<init>", "()V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: com.bxkj.student.v2.ui.sports.v3.appeal.V3AppealActivity */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class V3AppealActivity extends BaseActivity<AcV3SportsAppealBinding, AppealVM> {
    @NotNull

    /* renamed from: i */
    private final List<String> f20664i = new ArrayList();
    @Nullable

    /* renamed from: j */
    private GridViewAddImagesAdapter f20665j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3AppealActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, m12616d2 = {"Ljava/io/File;", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.appeal.V3AppealActivity$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5757a extends Lambda implements InterfaceC15280l<File, Unit> {
        C5757a() {
            super(1);
        }

        /* renamed from: a */
        public final void m38454a(@NotNull File it) {
            C14342f0.m8184p(it, "it");
            List list = V3AppealActivity.this.f20664i;
            String path = it.getPath();
            C14342f0.m8185o(path, "it.path");
            list.add(path);
            GridViewAddImagesAdapter gridViewAddImagesAdapter = V3AppealActivity.this.f20665j;
            C14342f0.m8187m(gridViewAddImagesAdapter);
            gridViewAddImagesAdapter.m57886c(V3AppealActivity.this.f20664i);
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(File file) {
            m38454a(file);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: V3AppealActivity.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, m12616d2 = {"", "it", "Lkotlin/f1;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.ui.sports.v3.appeal.V3AppealActivity$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static final class C5758b extends Lambda implements InterfaceC15280l<String, Unit> {
        C5758b() {
            super(1);
        }

        /* renamed from: a */
        public final void m38453a(@Nullable String str) {
            if (str == null) {
                str = "申诉提交成功，请耐心等待审核";
            }
            ContextExt.m43847q(V3AppealActivity.this, str);
            H5AppActivity h5AppActivity = (H5AppActivity) AppManager.m57776n().getActivity(H5AppActivity.class);
            if (h5AppActivity != null) {
                h5AppActivity.m38742O();
            }
            V3SportsHomeActivity v3SportsHomeActivity = (V3SportsHomeActivity) AppManager.m57776n().getActivity(V3SportsHomeActivity.class);
            if (v3SportsHomeActivity != null) {
                v3SportsHomeActivity.m38498t0();
            }
            V3RecordDetailActivity v3RecordDetailActivity = (V3RecordDetailActivity) AppManager.m57776n().getActivity(V3RecordDetailActivity.class);
            if (v3RecordDetailActivity != null) {
                v3RecordDetailActivity.m38446N();
            }
            V3RecordValidFragment v3RecordValidFragment = (V3RecordValidFragment) AppManager.m57776n().m57775o(V3RecordValidFragment.class);
            if (v3RecordValidFragment != null) {
                v3RecordValidFragment.m38357m();
            }
            V3RecordInValidFragment v3RecordInValidFragment = (V3RecordInValidFragment) AppManager.m57776n().m57775o(V3RecordInValidFragment.class);
            if (v3RecordInValidFragment != null) {
                v3RecordInValidFragment.m38383O();
            }
            V3AppealActivity.this.finish();
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            m38453a(str);
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static final void m38456g(V3AppealActivity this$0, AdapterView adapterView, View view, int i, long j) {
        C14342f0.m8184p(this$0, "this$0");
        ImageSelectUtils.f15123a.m43786p(this$0.mo43912w(), new C5757a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public static final void m38455h(V3AppealActivity this$0, View view) {
        CharSequence m6523E5;
        C14342f0.m8184p(this$0, "this$0");
        AppealVM mo43911x = this$0.mo43911x();
        String obj = this$0.mo43920M().etReason.getText().toString();
        if (obj != null) {
            m6523E5 = C14579x.m6523E5(obj);
            mo43911x.m38000x(m6523E5.toString(), this$0.f20664i, new C5758b());
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: E */
    public void mo38206E() {
        mo43920M().setBackEvent(this);
        GridViewAddImagesAdapter gridViewAddImagesAdapter = new GridViewAddImagesAdapter(this.f20664i, mo43926C(), 4, Tools.m57620a(10.0f, mo43926C()));
        gridViewAddImagesAdapter.m57884e(3);
        Unit unit = Unit.f41048a;
        this.f20665j = gridViewAddImagesAdapter;
        mo43920M().gvImages.setAdapter((ListAdapter) this.f20665j);
        mo43920M().gvImages.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.appeal.b
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                V3AppealActivity.m38456g(V3AppealActivity.this, adapterView, view, i, j);
            }
        });
        if (getIntent().hasExtra("exerciseRecordId")) {
            mo43911x().m38006F(getIntent().getStringExtra("exerciseRecordId"));
        }
        if (getIntent().hasExtra("identify")) {
            mo43911x().m38005G(getIntent().getStringExtra("identify"));
        }
        mo43920M().btCommit.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.v2.ui.sports.v3.appeal.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                V3AppealActivity.m38455h(V3AppealActivity.this, view);
            }
        });
    }

    @Override // com.bxkj.base.p085v2.base.BaseDataBinding
    /* renamed from: p */
    public void mo38205p() {
    }
}
