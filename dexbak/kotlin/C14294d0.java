package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.ccg.CcgConstant;
import kotlin.Result;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* compiled from: Result.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0001\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u0006\u0012\u0002\b\u00030\u0004H\u0001ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a0\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u001aE\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\b*\u00028\u00002\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e¢\u0006\u0002\b\u000fH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a`\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b\"\b\b\u0001\u0010\r*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00042!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\u0017\u0010\u0011\u001a5\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b\"\b\b\u0001\u0010\r*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u0018\u001a\u00028\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0089\u0001\u0010\u001d\u001a\u00028\u0000\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00010\u00042!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00028\u00000\u000e2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\u0014\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001ab\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00010\u00042!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00028\u00000\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b \u0010\u0011\u001aU\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00010\u00042!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00028\u00000\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u0011\u001af\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\b\"\b\b\u0001\u0010\r*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00042!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b\"\u0010\u0011\u001aY\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\b\"\b\b\u0001\u0010\r*\u00028\u0000*\b\u0012\u0004\u0012\u00028\u00010\u00042!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00028\u00000\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0011\u001a\\\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00042!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0001\u0012\u0004\u0012\u00020\u00050\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b%\u0010\u0011\u001a\\\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00042!\u0010$\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00050\u000eH\u0087\bø\u0001\u0000ø\u0001\u0001\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0004\b&\u0010\u0011\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006'"}, m12616d2 = {"", "exception", "", "a", "Lkotlin/Result;", "Lkotlin/f1;", "n", "(Ljava/lang/Object;)V", "R", "Lkotlin/Function0;", "block", "m", "(Ll1/a;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", C7304t.f25048d, "(Ljava/lang/Object;Ll1/l;)Ljava/lang/Object;", "e", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/ParameterName;", "name", "onFailure", "d", "defaultValue", "c", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_VALUE, "onSuccess", "b", "(Ljava/lang/Object;Ll1/l;Ll1/l;)Ljava/lang/Object;", "transform", "f", "g", "j", "k", CcgConstant.f38549t, "h", "i", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.d0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14294d0 {
    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    /* renamed from: a */
    public static final Object m8609a(@NotNull Throwable exception) {
        C14342f0.m8184p(exception, "exception");
        return new Result.Failure(exception);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: b */
    private static final <R, T> R m8608b(Object obj, InterfaceC15280l<? super T, ? extends R> interfaceC15280l, InterfaceC15280l<? super Throwable, ? extends R> interfaceC15280l2) {
        Throwable m60151exceptionOrNullimpl = Result.m60151exceptionOrNullimpl(obj);
        if (m60151exceptionOrNullimpl == null) {
            return interfaceC15280l.invoke(obj);
        }
        return interfaceC15280l2.invoke(m60151exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: c */
    private static final <R, T extends R> R m8607c(Object obj, R r) {
        return Result.m60154isFailureimpl(obj) ? r : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: d */
    private static final <R, T extends R> R m8606d(Object obj, InterfaceC15280l<? super Throwable, ? extends R> interfaceC15280l) {
        Throwable m60151exceptionOrNullimpl = Result.m60151exceptionOrNullimpl(obj);
        return m60151exceptionOrNullimpl == null ? obj : interfaceC15280l.invoke(m60151exceptionOrNullimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: e */
    private static final <T> T m8605e(Object obj) {
        m8596n(obj);
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: f */
    private static final <R, T> Object m8604f(Object obj, InterfaceC15280l<? super T, ? extends R> interfaceC15280l) {
        if (Result.m60155isSuccessimpl(obj)) {
            Result.C14124a c14124a = Result.Companion;
            return Result.m60148constructorimpl(interfaceC15280l.invoke(obj));
        }
        return Result.m60148constructorimpl(obj);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: g */
    private static final <R, T> Object m8603g(Object obj, InterfaceC15280l<? super T, ? extends R> interfaceC15280l) {
        if (Result.m60155isSuccessimpl(obj)) {
            try {
                Result.C14124a c14124a = Result.Companion;
                return Result.m60148constructorimpl(interfaceC15280l.invoke(obj));
            } catch (Throwable th) {
                Result.C14124a c14124a2 = Result.Companion;
                return Result.m60148constructorimpl(m8609a(th));
            }
        }
        return Result.m60148constructorimpl(obj);
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: h */
    private static final <T> Object m8602h(Object obj, InterfaceC15280l<? super Throwable, Unit> interfaceC15280l) {
        Throwable m60151exceptionOrNullimpl = Result.m60151exceptionOrNullimpl(obj);
        if (m60151exceptionOrNullimpl != null) {
            interfaceC15280l.invoke(m60151exceptionOrNullimpl);
        }
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: i */
    private static final <T> Object m8601i(Object obj, InterfaceC15280l<? super T, Unit> interfaceC15280l) {
        if (Result.m60155isSuccessimpl(obj)) {
            interfaceC15280l.invoke(obj);
        }
        return obj;
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: j */
    private static final <R, T extends R> Object m8600j(Object obj, InterfaceC15280l<? super Throwable, ? extends R> interfaceC15280l) {
        Throwable m60151exceptionOrNullimpl = Result.m60151exceptionOrNullimpl(obj);
        if (m60151exceptionOrNullimpl == null) {
            return obj;
        }
        Result.C14124a c14124a = Result.Companion;
        return Result.m60148constructorimpl(interfaceC15280l.invoke(m60151exceptionOrNullimpl));
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: k */
    private static final <R, T extends R> Object m8599k(Object obj, InterfaceC15280l<? super Throwable, ? extends R> interfaceC15280l) {
        Throwable m60151exceptionOrNullimpl = Result.m60151exceptionOrNullimpl(obj);
        if (m60151exceptionOrNullimpl == null) {
            return obj;
        }
        try {
            Result.C14124a c14124a = Result.Companion;
            return Result.m60148constructorimpl(interfaceC15280l.invoke(m60151exceptionOrNullimpl));
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            return Result.m60148constructorimpl(m8609a(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: l */
    private static final <T, R> Object m8598l(T t, InterfaceC15280l<? super T, ? extends R> interfaceC15280l) {
        try {
            Result.C14124a c14124a = Result.Companion;
            return Result.m60148constructorimpl(interfaceC15280l.invoke(t));
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            return Result.m60148constructorimpl(m8609a(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @InlineOnly
    /* renamed from: m */
    private static final <R> Object m8597m(InterfaceC15269a<? extends R> interfaceC15269a) {
        try {
            Result.C14124a c14124a = Result.Companion;
            return Result.m60148constructorimpl(interfaceC15269a.invoke());
        } catch (Throwable th) {
            Result.C14124a c14124a2 = Result.Companion;
            return Result.m60148constructorimpl(m8609a(th));
        }
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    /* renamed from: n */
    public static final void m8596n(@NotNull Object obj) {
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
    }
}
