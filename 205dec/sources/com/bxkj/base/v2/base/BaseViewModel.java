package com.bxkj.base.v2.base;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bxkj.base.v2.http.exception.ApiException;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.q0;
import l1.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BaseViewModel.kt */
@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u001d\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b:\u0010;JE\u0010\f\u001a\u00020\u000b2\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032$\u0010\n\u001a \b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0005H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u00d8\u0002\u0010\u0016\u001a\u00020\u000b2\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e2&\b\u0002\u0010\n\u001a \b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00052H\b\u0002\u0010\u0012\u001aB\b\u0001\u0012&\u0012$0\u0002j\u0011`\u0003\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00052H\b\u0002\u0010\u0013\u001aB\b\u0001\u0012&\u0012$0\u0002j\u0011`\u0003\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00052 \b\u0002\u0010\u0014\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000e2H\b\u0002\u0010\u0015\u001aB\b\u0001\u0012&\u0012$0\u0002j\u0011`\u0003\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0005H\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u00f0\u0002\u0010\u001c\u001a\u00020\u001b2\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000e2&\b\u0002\u0010\n\u001a \b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00052H\b\u0002\u0010\u0012\u001aB\b\u0001\u0012&\u0012$0\u0002j\u0011`\u0003\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00052H\b\u0002\u0010\u0013\u001aB\b\u0001\u0012&\u0012$0\u0002j\u0011`\u0003\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00052 \b\u0002\u0010\u0014\u001a\u001a\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000e2H\b\u0002\u0010\u0015\u001aB\b\u0001\u0012&\u0012$0\u0002j\u0011`\u0003\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R(\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010!\u001a\u0004\b&\u0010#\"\u0004\b'\u0010(R(\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010!\u001a\u0004\b\u0004\u0010#\"\u0004\b*\u0010(R(\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b,\u0010#\"\u0004\b-\u0010(R(\u00101\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010!\u001a\u0004\b/\u0010#\"\u0004\b0\u0010(R(\u00104\u001a\b\u0012\u0004\u0012\u00020\u00190\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010!\u001a\u0004\b2\u0010#\"\u0004\b3\u0010(R$\u00109\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00105\u001a\u0004\b%\u00106\"\u0004\b7\u00108\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006<"}, d2 = {"Lcom/bxkj/base/v2/base/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "Lkotlin/Function2;", "Lcom/bxkj/base/v2/http/exception/ApiException;", "Lkotlin/coroutines/c;", "", "", "otherCode", "Lkotlin/f1;", "m", "(Ljava/lang/Exception;Ll1/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "success", "Lkotlin/ParameterName;", "name", "error", "cancel", CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, "fail", "k", "(Ll1/l;Ll1/p;Ll1/p;Ll1/p;Ll1/l;Ll1/p;)V", "isShowLoading", "", "loadingMsg", "Lkotlinx/coroutines/e2;", "i", "(Ll1/l;Ll1/p;Ll1/p;Ll1/p;Ll1/l;Ll1/p;Ljava/lang/Boolean;Ljava/lang/String;)Lkotlinx/coroutines/e2;", "Landroidx/lifecycle/MutableLiveData;", "", "a", "Landroidx/lifecycle/MutableLiveData;", "c", "()Landroidx/lifecycle/MutableLiveData;", "loadingLiveData", "b", "d", "o", "(Landroidx/lifecycle/MutableLiveData;)V", "loadingMessage", "p", "networkRequestStatus", "h", "s", "showOkToast", "g", "r", "showErrorToast", "f", CampaignEx.JSON_KEY_AD_Q, "showDialog", "Lkotlinx/coroutines/e2;", "()Lkotlinx/coroutines/e2;", "n", "(Lkotlinx/coroutines/e2;)V", "jobs", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class BaseViewModel extends ViewModel {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final MutableLiveData<Integer> f18484a = new MutableLiveData<>();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private MutableLiveData<String> f18485b = new MutableLiveData<>("Loading...");
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private MutableLiveData<String> f18486c = new MutableLiveData<>();
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private MutableLiveData<String> f18487d = new MutableLiveData<>();
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private MutableLiveData<String> f18488e = new MutableLiveData<>();
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private MutableLiveData<String> f18489f = new MutableLiveData<>();
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private e2 f18490g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BaseViewModel.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.base.v2.base.BaseViewModel$launch$job$1", f = "BaseViewModel.kt", i = {2, 4}, l = {93, 114, 95, 99, 104, 106, 114, 114}, m = "invokeSuspend", n = {"e", "e"}, s = {"L$0", "L$0"})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f18491a;

        /* renamed from: b  reason: collision with root package name */
        int f18492b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f18493c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Boolean f18494d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ BaseViewModel f18495e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ l1.l<kotlin.coroutines.c<? super f1>, Object> f18496f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ p<Exception, kotlin.coroutines.c<? super f1>, Object> f18497g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ p<Exception, kotlin.coroutines.c<? super f1>, Object> f18498h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ p<Exception, kotlin.coroutines.c<? super Boolean>, Object> f18499i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ p<ApiException, kotlin.coroutines.c<? super Boolean>, Object> f18500j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ l1.l<kotlin.coroutines.c<? super f1>, Object> f18501k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(String str, Boolean bool, BaseViewModel baseViewModel, l1.l<? super kotlin.coroutines.c<? super f1>, ? extends Object> lVar, p<? super Exception, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar, p<? super Exception, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar2, p<? super Exception, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar3, p<? super ApiException, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar4, l1.l<? super kotlin.coroutines.c<? super f1>, ? extends Object> lVar2, kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
            this.f18493c = str;
            this.f18494d = bool;
            this.f18495e = baseViewModel;
            this.f18496f = lVar;
            this.f18497g = pVar;
            this.f18498h = pVar2;
            this.f18499i = pVar3;
            this.f18500j = pVar4;
            this.f18501k = lVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new a(this.f18493c, this.f18494d, this.f18495e, this.f18496f, this.f18497g, this.f18498h, this.f18499i, this.f18500j, this.f18501k, cVar);
        }

        @Override // l1.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00c8  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x0119 A[Catch: all -> 0x003d, TryCatch #1 {all -> 0x003d, blocks: (B:7:0x001d, B:10:0x0026, B:69:0x0115, B:71:0x0119, B:73:0x0123, B:13:0x002f, B:55:0x00e3, B:57:0x00e7, B:60:0x00f7, B:63:0x0103, B:66:0x0109, B:16:0x0039, B:33:0x0086, B:49:0x00d2, B:52:0x00d7), top: B:106:0x0009, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0132 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x013f  */
        /* JADX WARN: Removed duplicated region for block: B:86:0x0169  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                Method dump skipped, instructions count: 468
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.v2.base.BaseViewModel.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: BaseViewModel.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.bxkj.base.v2.base.BaseViewModel", f = "BaseViewModel.kt", i = {3, 3}, l = {180, 180, 180, 188}, m = "onError", n = {"this", "e"}, s = {"L$0", "L$1"})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        Object f18502a;

        /* renamed from: b  reason: collision with root package name */
        Object f18503b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f18504c;

        /* renamed from: e  reason: collision with root package name */
        int f18506e;

        b(kotlin.coroutines.c<? super b> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18504c = obj;
            this.f18506e |= Integer.MIN_VALUE;
            return BaseViewModel.this.m(null, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ e2 j(BaseViewModel baseViewModel, l1.l lVar, p pVar, p pVar2, p pVar3, l1.l lVar2, p pVar4, Boolean bool, String str, int i4, Object obj) {
        if (obj == null) {
            return baseViewModel.i(lVar, (i4 & 2) != 0 ? null : pVar, (i4 & 4) != 0 ? null : pVar2, (i4 & 8) != 0 ? null : pVar3, (i4 & 16) != 0 ? null : lVar2, (i4 & 32) == 0 ? pVar4 : null, (i4 & 64) != 0 ? Boolean.TRUE : bool, (i4 & 128) != 0 ? "Loading.." : str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launch");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void l(BaseViewModel baseViewModel, l1.l lVar, p pVar, p pVar2, p pVar3, l1.l lVar2, p pVar4, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchWithOutLoading");
        }
        baseViewModel.k(lVar, (i4 & 2) != 0 ? null : pVar, (i4 & 4) != 0 ? null : pVar2, (i4 & 8) != 0 ? null : pVar3, (i4 & 16) != 0 ? null : lVar2, (i4 & 32) == 0 ? pVar4 : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(java.lang.Exception r11, l1.p<? super com.bxkj.base.v2.http.exception.ApiException, ? super kotlin.coroutines.c<? super java.lang.Boolean>, ? extends java.lang.Object> r12, kotlin.coroutines.c<? super kotlin.f1> r13) {
        /*
            Method dump skipped, instructions count: 738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.v2.base.BaseViewModel.m(java.lang.Exception, l1.p, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    public final e2 b() {
        return this.f18490g;
    }

    @NotNull
    public final MutableLiveData<Integer> c() {
        return this.f18484a;
    }

    @NotNull
    public final MutableLiveData<String> d() {
        return this.f18485b;
    }

    @NotNull
    public final MutableLiveData<String> e() {
        return this.f18486c;
    }

    @NotNull
    public final MutableLiveData<String> f() {
        return this.f18489f;
    }

    @NotNull
    public final MutableLiveData<String> g() {
        return this.f18488e;
    }

    @NotNull
    public final MutableLiveData<String> h() {
        return this.f18487d;
    }

    @NotNull
    protected final e2 i(@NotNull l1.l<? super kotlin.coroutines.c<? super f1>, ? extends Object> success, @Nullable p<? super ApiException, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, @Nullable p<? super Exception, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar2, @Nullable p<? super Exception, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar3, @Nullable l1.l<? super kotlin.coroutines.c<? super f1>, ? extends Object> lVar, @Nullable p<? super Exception, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar4, @Nullable Boolean bool, @Nullable String str) {
        f0.p(success, "success");
        e2 f4 = kotlinx.coroutines.h.f(ViewModelKt.getViewModelScope(this), (kotlin.coroutines.f) null, (CoroutineStart) null, new a(str, bool, this, success, pVar4, pVar3, pVar2, pVar, lVar, null), 3, (Object) null);
        this.f18490g = f4;
        return f4;
    }

    protected final void k(@NotNull l1.l<? super kotlin.coroutines.c<? super f1>, ? extends Object> success, @Nullable p<? super ApiException, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar, @Nullable p<? super Exception, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar2, @Nullable p<? super Exception, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar3, @Nullable l1.l<? super kotlin.coroutines.c<? super f1>, ? extends Object> lVar, @Nullable p<? super Exception, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar4) {
        f0.p(success, "success");
        this.f18490g = j(this, success, pVar, pVar2, pVar3, lVar, pVar4, Boolean.FALSE, null, 128, null);
    }

    public final void n(@Nullable e2 e2Var) {
        this.f18490g = e2Var;
    }

    public final void o(@NotNull MutableLiveData<String> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f18485b = mutableLiveData;
    }

    public final void p(@NotNull MutableLiveData<String> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f18486c = mutableLiveData;
    }

    public final void q(@NotNull MutableLiveData<String> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f18489f = mutableLiveData;
    }

    public final void r(@NotNull MutableLiveData<String> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f18488e = mutableLiveData;
    }

    public final void s(@NotNull MutableLiveData<String> mutableLiveData) {
        f0.p(mutableLiveData, "<set-?>");
        this.f18487d = mutableLiveData;
    }
}
