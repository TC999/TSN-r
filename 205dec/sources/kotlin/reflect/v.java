package kotlin.reflect;

import java.lang.reflect.Type;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: TypesJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bc\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lkotlin/reflect/v;", "Ljava/lang/reflect/Type;", "", "getTypeName", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@ExperimentalStdlibApi
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface v extends Type {

    /* compiled from: TypesJVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/reflect/Type;", "p1", "", "e", "(Ljava/lang/reflect/Type;)Ljava/lang/String;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final /* synthetic */ class a extends FunctionReferenceImpl implements l1.l<Type, String> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f58694a = new a();

        a() {
            super(1, a0.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
        }

        @Override // l1.l
        @NotNull
        /* renamed from: e */
        public final String invoke(@NotNull Type p12) {
            String j4;
            f0.p(p12, "p1");
            j4 = a0.j(p12);
            return j4;
        }
    }

    @Override // kotlin.reflect.v
    @NotNull
    String getTypeName();
}
