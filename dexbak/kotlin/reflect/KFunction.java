package kotlin.reflect;

import kotlin.Function;
import kotlin.Metadata;
import kotlin.SinceKotlin;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003R\u001a\u0010\u0005\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\b\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\b\u001a\u0004\b\u000b\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0011"}, m12616d2 = {"Lkotlin/reflect/i;", "R", "Lkotlin/reflect/c;", "Lkotlin/j;", "", "isInline", "()Z", "isInline$annotations", "()V", "isExternal", "isExternal$annotations", "isOperator", "isOperator$annotations", "isInfix", "isInfix$annotations", "isSuspend", "isSuspend$annotations", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.reflect.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface KFunction<R> extends KCallable<R>, Function<R> {

    /* compiled from: KFunction.kt */
    @Metadata(m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.i$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14438a {
        @SinceKotlin(version = "1.1")
        /* renamed from: a */
        public static /* synthetic */ void m7328a() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: b */
        public static /* synthetic */ void m7327b() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: c */
        public static /* synthetic */ void m7326c() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: d */
        public static /* synthetic */ void m7325d() {
        }

        @SinceKotlin(version = "1.1")
        /* renamed from: e */
        public static /* synthetic */ void m7324e() {
        }
    }

    boolean isExternal();

    boolean isInfix();

    boolean isInline();

    boolean isOperator();

    @Override // kotlin.reflect.KCallable
    boolean isSuspend();
}
