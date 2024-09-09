package com.bxkj.student.v2.vm.sports.appeal;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import cn.bluemobi.dylan.http.RequestParameter;
import com.bxkj.base.v2.base.BaseViewModel;
import com.bxkj.student.v2.repository.sports.g;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.o;
import kotlin.q;
import l1.l;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AppealVM.kt */
@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b1\u00102J.\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002JA\u0010\u0013\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\rJ2\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001b\u0010+\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b)\u0010*R\u001b\u00100\u001a\u00020,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010#\u001a\u0004\b.\u0010/\u00a8\u00063"}, d2 = {"Lcom/bxkj/student/v2/vm/sports/appeal/AppealVM;", "Lcom/bxkj/base/v2/base/BaseViewModel;", "", DomainCampaignEx.LOOPBACK_KEY, "", "Ljava/io/File;", "files", "", "Lokhttp3/RequestBody;", "B", "reason", "", "paths", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "msg", "Lkotlin/f1;", "callBack", "x", "exerciseRecordId", "Lkotlin/Function0;", "y", "h", "Ljava/lang/String;", "z", "()Ljava/lang/String;", "F", "(Ljava/lang/String;)V", "i", "C", "G", "identify", "Lcom/bxkj/student/v2/repository/sports/b;", "j", "Lkotlin/o;", "D", "()Lcom/bxkj/student/v2/repository/sports/b;", "recordRepository", "Lcom/bxkj/student/v2/repository/sports/g;", "k", "E", "()Lcom/bxkj/student/v2/repository/sports/g;", "sportsRepository", "Lcom/bxkj/student/v2/repository/face/c;", "l", "A", "()Lcom/bxkj/student/v2/repository/face/c;", "faceDetectRepository", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class AppealVM extends BaseViewModel {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private String f24622h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private String f24623i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final o f24624j = q.c(d.f24644a);
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final o f24625k = q.c(e.f24645a);
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final o f24626l = q.c(c.f24643a);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AppealVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.appeal.AppealVM$appealV3$1", f = "AppealVM.kt", i = {0, 1, 1, 2, 2, 2, 3, 3, 3, 4}, l = {54, 59, 63, 64, 71, 110, 120}, m = "invokeSuspend", n = {"identify", "identify", "it", "identify", "it", "faceFile", "identify", "it", "faceFile", "identify"}, s = {"L$1", "L$1", "L$3", "L$1", "L$3", "L$5", "L$1", "L$3", "L$5", "L$1"})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static final class a extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        Object f24627a;

        /* renamed from: b  reason: collision with root package name */
        Object f24628b;

        /* renamed from: c  reason: collision with root package name */
        Object f24629c;

        /* renamed from: d  reason: collision with root package name */
        Object f24630d;

        /* renamed from: e  reason: collision with root package name */
        Object f24631e;

        /* renamed from: f  reason: collision with root package name */
        Object f24632f;

        /* renamed from: g  reason: collision with root package name */
        int f24633g;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ List<String> f24635i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ String f24636j;

        /* renamed from: k  reason: collision with root package name */
        final /* synthetic */ l<String, f1> f24637k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(List<String> list, String str, l<? super String, f1> lVar, kotlin.coroutines.c<? super a> cVar) {
            super(1, cVar);
            this.f24635i = list;
            this.f24636j = str;
            this.f24637k = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new a(this.f24635i, this.f24636j, this.f24637k, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x03f3  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00f8  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x012d  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0132  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0140  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x01b7 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0280  */
        /* JADX WARN: Removed duplicated region for block: B:70:0x0283  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x02df  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x02e2  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x02e6  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x02e9  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x0343 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0344  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x034e  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x0395 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:96:0x03a9 A[LOOP:0: B:94:0x03a3->B:96:0x03a9, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:99:0x03ed A[RETURN] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:55:0x015a -> B:65:0x01c2). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x01b5 -> B:64:0x01b8). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r44) {
            /*
                Method dump skipped, instructions count: 1044
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.vm.sports.appeal.AppealVM.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AppealVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.vm.sports.appeal.AppealVM$commit$2", f = "AppealVM.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class b extends SuspendLambda implements l<kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f24638a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f24639b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24640c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Map<String, RequestBody> f24641d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ l1.a<f1> f24642e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(String str, String str2, Map<String, ? extends RequestBody> map, l1.a<f1> aVar, kotlin.coroutines.c<? super b> cVar) {
            super(1, cVar);
            this.f24639b = str;
            this.f24640c = str2;
            this.f24641d = map;
            this.f24642e = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@NotNull kotlin.coroutines.c<?> cVar) {
            return new b(this.f24639b, this.f24640c, this.f24641d, this.f24642e, cVar);
        }

        @Override // l1.l
        @Nullable
        /* renamed from: d */
        public final Object invoke(@Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((b) create(cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f24638a;
            if (i4 == 0) {
                d0.n(obj);
                com.bxkj.student.v2.repository.sports.c cVar = new com.bxkj.student.v2.repository.sports.c();
                RequestBody requestBody = RequestParameter.getRequestBody(this.f24639b);
                f0.o(requestBody, "getRequestBody(exerciseRecordId)");
                RequestBody requestBody2 = RequestParameter.getRequestBody(this.f24640c);
                f0.o(requestBody2, "getRequestBody(reason)");
                Map<String, RequestBody> map = this.f24641d;
                this.f24638a = 1;
                if (cVar.a(requestBody, requestBody2, map, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            this.f24642e.invoke();
            return f1.f55527a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AppealVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/face/c;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class c extends Lambda implements l1.a<com.bxkj.student.v2.repository.face.c> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f24643a = new c();

        c() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.face.c invoke() {
            return new com.bxkj.student.v2.repository.face.c();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AppealVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/b;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class d extends Lambda implements l1.a<com.bxkj.student.v2.repository.sports.b> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f24644a = new d();

        d() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final com.bxkj.student.v2.repository.sports.b invoke() {
            return new com.bxkj.student.v2.repository.sports.b();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: AppealVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/bxkj/student/v2/repository/sports/g;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    static final class e extends Lambda implements l1.a<g> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f24645a = new e();

        e() {
            super(0);
        }

        @NotNull
        /* renamed from: a */
        public final g invoke() {
            return new g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.face.c A() {
        return (com.bxkj.student.v2.repository.face.c) this.f24626l.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, RequestBody> B(String str, List<? extends File> list) {
        File file;
        ArrayMap arrayMap = new ArrayMap();
        int size = list.size() - 1;
        if (size >= 0) {
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                arrayMap.put(str + "\"; filename=\"" + ((Object) file.getName()), RequestBody.Companion.create(MediaType.Companion.parse("image/png"), list.get(i4)));
                if (i5 > size) {
                    break;
                }
                i4 = i5;
            }
        }
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.bxkj.student.v2.repository.sports.b D() {
        return (com.bxkj.student.v2.repository.sports.b) this.f24624j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g E() {
        return (g) this.f24625k.getValue();
    }

    @Nullable
    public final String C() {
        return this.f24623i;
    }

    public final void F(@Nullable String str) {
        this.f24622h = str;
    }

    public final void G(@Nullable String str) {
        this.f24623i = str;
    }

    public final void x(@NotNull String reason, @NotNull List<String> paths, @NotNull l<? super String, f1> callBack) {
        f0.p(reason, "reason");
        f0.p(paths, "paths");
        f0.p(callBack, "callBack");
        if (TextUtils.isEmpty(reason)) {
            f().postValue("\u8bf7\u8f93\u5165\u7533\u8bc9\u7406\u7531");
        } else {
            BaseViewModel.j(this, new a(paths, reason, callBack, null), null, null, null, null, null, null, null, 254, null);
        }
    }

    public final void y(@NotNull String exerciseRecordId, @NotNull String reason, @NotNull List<String> paths, @NotNull l1.a<f1> callBack) {
        f0.p(exerciseRecordId, "exerciseRecordId");
        f0.p(reason, "reason");
        f0.p(paths, "paths");
        f0.p(callBack, "callBack");
        if (TextUtils.isEmpty(reason)) {
            f().postValue("\u8bf7\u8f93\u5165\u7533\u8bc9\u7406\u7531");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : paths) {
            arrayList.add(new File(str));
        }
        BaseViewModel.j(this, new b(exerciseRecordId, reason, B("files", arrayList), callBack, null), null, null, null, null, null, null, null, 254, null);
    }

    @Nullable
    public final String z() {
        return this.f24622h;
    }
}
