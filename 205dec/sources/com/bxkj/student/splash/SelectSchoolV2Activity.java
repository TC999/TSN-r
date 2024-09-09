package com.bxkj.student.splash;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.base.BaseAdapter;
import com.bxkj.base.v2.common.ext.ContextExtKt;
import com.bxkj.base.v2.data.a;
import com.bxkj.base.view.SearchView;
import com.bxkj.student.databinding.AcSchoolListV2Binding;
import com.bxkj.student.databinding.ItemForSchoolListV2Binding;
import com.bxkj.student.splash.SelectSchoolV2Activity$adapter$2;
import com.bxkj.student.v2.vm.splash.SelectSchoolVM;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.v;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.o;
import kotlin.q;
import l1.l;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SelectSchoolV2Activity.kt */
@Metadata(bv = {}, d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\t*\u0001\u000e\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016R*\u0010\r\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b0\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/bxkj/student/splash/SelectSchoolV2Activity;", "Lcom/bxkj/base/v2/base/BaseActivity;", "Lcom/bxkj/student/databinding/AcSchoolListV2Binding;", "Lcom/bxkj/student/v2/vm/splash/SelectSchoolVM;", "Lkotlin/f1;", "E", "p", "", "", "", "", "i", "Ljava/util/List;", "schoolList", "com/bxkj/student/splash/SelectSchoolV2Activity$adapter$2$1", "j", "Lkotlin/o;", "N", "()Lcom/bxkj/student/splash/SelectSchoolV2Activity$adapter$2$1;", "adapter", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class SelectSchoolV2Activity extends BaseActivity<AcSchoolListV2Binding, SelectSchoolVM> {
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private List<? extends Map<String, Object>> f23075i = v.E();
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final o f23076j = q.c(new l1.a<SelectSchoolV2Activity$adapter$2.AnonymousClass1>() { // from class: com.bxkj.student.splash.SelectSchoolV2Activity$adapter$2

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
        /* compiled from: SelectSchoolV2Activity.kt */
        @Metadata(bv = {}, d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001c\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002\u0012\u0004\u0012\u00020\u00050\u0001J.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/bxkj/student/splash/SelectSchoolV2Activity$adapter$2$1", "Lcom/bxkj/base/v2/base/BaseAdapter;", "", "", "", "Lcom/bxkj/student/databinding/ItemForSchoolListV2Binding;", "itemBinding", "bean", "", "position", "Lkotlin/f1;", "n", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.splash.SelectSchoolV2Activity$adapter$2$1  reason: invalid class name */
        /* loaded from: E:\TSN-r\205dec\5141176.dex */
        public static final class AnonymousClass1 extends BaseAdapter<Map<String, Object>, ItemForSchoolListV2Binding> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ SelectSchoolV2Activity f23079b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
            /* compiled from: SelectSchoolV2Activity.kt */
            @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcn/bluemobi/dylan/base/view/iOSTwoButtonDialog;", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
            /* renamed from: com.bxkj.student.splash.SelectSchoolV2Activity$adapter$2$1$a */
            /* loaded from: E:\TSN-r\205dec\5141176.dex */
            public static final class a extends Lambda implements l<iOSTwoButtonDialog, f1> {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Map<String, Object> f23080a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ SelectSchoolV2Activity f23081b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                a(Map<String, Object> map, SelectSchoolV2Activity selectSchoolV2Activity) {
                    super(1);
                    this.f23080a = map;
                    this.f23081b = selectSchoolV2Activity;
                }

                public final void a(@NotNull iOSTwoButtonDialog it) {
                    f0.p(it, "it");
                    com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
                    String t3 = lVar.t(this.f23080a, "school_name");
                    LoginUser.getLoginUser().setSchoolId(lVar.t(this.f23080a, "school_id"));
                    LoginUser.getLoginUser().setSysType(lVar.k(this.f23080a, "sysType"));
                    a.b bVar = com.bxkj.base.v2.data.a.b;
                    bVar.a().Q(lVar.k(this.f23080a, "isOpenLive"));
                    bVar.a().R(lVar.l(this.f23080a, "isOpenSQZS", 1));
                    bVar.a().P(lVar.l(this.f23080a, "isOpenGGLBT", 1));
                    if (LoginUser.getLoginUser().getSysType() == 2) {
                        bVar.a().V(t3);
                        bVar.a().U(lVar.t(this.f23080a, "schoolCode"));
                        bVar.a().W(lVar.u(this.f23080a, "lan_url", "http://a.sxstczx.com/"));
                        com.bxkj.student.v2.retrofit.b.f23700a.a();
                        bVar.a().I(lVar.t(this.f23080a, "school_url"));
                    } else {
                        LoginUser.getLoginUser().setSchoolName(t3);
                        LoginUser.getLoginUser().setIsOpenKeep(lVar.k(this.f23080a, "isOpenKeep"));
                        LoginUser.getLoginUser().setIsOpenEncry(lVar.t(this.f23080a, "isOpenEncry"));
                        LoginUser.getLoginUser().setAppId(JsonParse.getString(this.f23080a, "openId"));
                        LoginUser.getLoginUser().setServerUrl(lVar.t(this.f23080a, "school_url"));
                        Http.changeBaseUrl(LoginUser.getLoginUser().getServerUrl());
                    }
                    this.f23081b.C().startActivity(new Intent(this.f23081b.C(), SplashActivity.class));
                    new HashSet().add(t3);
                    this.f23081b.finish();
                }

                @Override // l1.l
                public /* bridge */ /* synthetic */ f1 invoke(iOSTwoButtonDialog iostwobuttondialog) {
                    a(iostwobuttondialog);
                    return f1.f55527a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(SelectSchoolV2Activity selectSchoolV2Activity, List<? extends Map<String, Object>> list) {
                super(list);
                this.f23079b = selectSchoolV2Activity;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void o(SelectSchoolV2Activity this$0, Map bean, View view) {
                f0.p(this$0, "this$0");
                f0.p(bean, "$bean");
                FragmentActivity w3 = this$0.w();
                ContextExtKt.h(w3, null, "\u786e\u5b9a\u60a8\u8981\u9009\u62e9" + com.bxkj.base.v2.common.utils.l.f18624a.t(bean, "school_name") + "\u5417?", new a(bean, this$0), null, null, null, 57, null);
            }

            @Override // com.bxkj.base.v2.base.BaseAdapter
            /* renamed from: n */
            public void f(@NotNull ItemForSchoolListV2Binding itemBinding, @NotNull final Map<String, Object> bean, int i4) {
                f0.p(itemBinding, "itemBinding");
                f0.p(bean, "bean");
                TextView textView = itemBinding.tvName;
                StringBuilder sb = new StringBuilder();
                com.bxkj.base.v2.common.utils.l lVar = com.bxkj.base.v2.common.utils.l.f18624a;
                sb.append(lVar.t(bean, "school_name"));
                sb.append(" (");
                sb.append(lVar.t(bean, "provinceName"));
                sb.append(')');
                textView.setText(sb.toString());
                TextView textView2 = itemBinding.tvName;
                final SelectSchoolV2Activity selectSchoolV2Activity = this.f23079b;
                textView2.setOnClickListener(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003f: INVOKE  
                      (r4v1 'textView2' android.widget.TextView)
                      (wrap: android.view.View$OnClickListener : 0x003c: CONSTRUCTOR  (r0v2 android.view.View$OnClickListener A[REMOVE]) = 
                      (r6v4 'selectSchoolV2Activity' com.bxkj.student.splash.SelectSchoolV2Activity A[DONT_INLINE])
                      (r5v0 'bean' java.util.Map<java.lang.String, java.lang.Object> A[DONT_INLINE])
                     call: com.bxkj.student.splash.f.<init>(com.bxkj.student.splash.SelectSchoolV2Activity, java.util.Map):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.widget.TextView.setOnClickListener(android.view.View$OnClickListener):void in method: com.bxkj.student.splash.SelectSchoolV2Activity$adapter$2.1.n(com.bxkj.student.databinding.ItemForSchoolListV2Binding, java.util.Map<java.lang.String, java.lang.Object>, int):void, file: E:\TSN-r\205dec\5141176.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:309)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:272)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:91)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:296)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:275)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:377)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:306)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.bxkj.student.splash.f, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:302)
                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:769)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:718)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:417)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:144)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1097)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:872)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:421)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:302)
                    	... 15 more
                    */
                /*
                    this = this;
                    java.lang.String r6 = "itemBinding"
                    kotlin.jvm.internal.f0.p(r4, r6)
                    java.lang.String r6 = "bean"
                    kotlin.jvm.internal.f0.p(r5, r6)
                    android.widget.TextView r6 = r4.tvName
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    com.bxkj.base.v2.common.utils.l r1 = com.bxkj.base.v2.common.utils.l.f18624a
                    java.lang.String r2 = "school_name"
                    java.lang.String r2 = r1.t(r5, r2)
                    r0.append(r2)
                    java.lang.String r2 = " ("
                    r0.append(r2)
                    java.lang.String r2 = "provinceName"
                    java.lang.String r1 = r1.t(r5, r2)
                    r0.append(r1)
                    r1 = 41
                    r0.append(r1)
                    java.lang.String r0 = r0.toString()
                    r6.setText(r0)
                    android.widget.TextView r4 = r4.tvName
                    com.bxkj.student.splash.SelectSchoolV2Activity r6 = r3.f23079b
                    com.bxkj.student.splash.f r0 = new com.bxkj.student.splash.f
                    r0.<init>(r6, r5)
                    r4.setOnClickListener(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.splash.SelectSchoolV2Activity$adapter$2.AnonymousClass1.f(com.bxkj.student.databinding.ItemForSchoolListV2Binding, java.util.Map, int):void");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final AnonymousClass1 invoke() {
            List list;
            list = SelectSchoolV2Activity.this.f23075i;
            return new AnonymousClass1(SelectSchoolV2Activity.this, list);
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SelectSchoolV2Activity.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0010!\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0006\u001a\u00020\u00052\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000H\n"}, d2 = {"", "", "", "", "it", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends Lambda implements l<List<Map<String, Object>>, f1> {
        a() {
            super(1);
        }

        public final void a(@NotNull List<Map<String, Object>> it) {
            f0.p(it, "it");
            SelectSchoolV2Activity.this.N().l(v.I5(it));
        }

        @Override // l1.l
        public /* bridge */ /* synthetic */ f1 invoke(List<Map<String, Object>> list) {
            a(list);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SelectSchoolV2Activity$adapter$2.AnonymousClass1 N() {
        return (SelectSchoolV2Activity$adapter$2.AnonymousClass1) this.f23076j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(SelectSchoolV2Activity this$0, String it) {
        f0.p(this$0, "this$0");
        f0.o(it, "it");
        if (it.length() == 0) {
            this$0.N().l(new ArrayList());
        } else if (it.length() >= 4) {
            this$0.x().v(it, new a());
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void E() {
        M().setActivity(this);
        M().rvSchool.setAdapter(N());
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
        M().searchView.setOnSearchListener(new SearchView.a() { // from class: com.bxkj.student.splash.e
            @Override // com.bxkj.base.view.SearchView.a
            public final void a(String str) {
                SelectSchoolV2Activity.O(SelectSchoolV2Activity.this, str);
            }
        });
    }
}
