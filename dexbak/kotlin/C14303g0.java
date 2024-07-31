package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.tencent.open.SocialConstants;
import com.umeng.ccg.CcgConstant;
import kotlin.internal.InlineOnly;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* compiled from: Standard.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u001a\t\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0011\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a4\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\b\u0010\t\u001aI\u0010\r\u001a\u00028\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u0005*\u00028\u00002\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0002\b\fH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\r\u0010\u000e\u001aM\u0010\u0010\u001a\u00028\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u00052\u0006\u0010\u000f\u001a\u00028\u00002\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0002\b\fH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\u0010\u0010\u000e\u001aC\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\n*\u00028\u00002\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u000b¢\u0006\u0002\b\fH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0012\u0010\u000e\u001a>\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\n*\u00028\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u000bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0013\u0010\u000e\u001aD\u0010\u0014\u001a\u00028\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u0005*\u00028\u00002\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0014\u0010\u000e\u001a@\u0010\u0017\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\n*\u00028\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u000bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0017\u0010\u000e\u001a@\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\n*\u00028\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00150\u000bH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\b\u0018\u0010\u000e\u001a3\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00192\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00110\u000bH\u0087\bø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d"}, m12616d2 = {"", "a", "", MediationConstant.KEY_REASON, "b", "R", "Lkotlin/Function0;", "block", "h", "(Ll1/a;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "g", "(Ljava/lang/Object;Ll1/l;)Ljava/lang/Object;", SocialConstants.PARAM_RECEIVER, "k", "Lkotlin/f1;", "d", "c", "e", "", "predicate", "i", "j", "", "times", CcgConstant.f38549t, "f", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/StandardKt")
/* renamed from: kotlin.g0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class C14303g0 {
    @InlineOnly
    /* renamed from: a */
    private static final Void m8574a() {
        throw new Standard(null, 1, null);
    }

    @InlineOnly
    /* renamed from: b */
    private static final Void m8573b(String str) {
        throw new Standard("An operation is not implemented: " + str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: c */
    private static final <T> T m8572c(T t, InterfaceC15280l<? super T, Unit> interfaceC15280l) {
        interfaceC15280l.invoke(t);
        return t;
    }

    @InlineOnly
    /* renamed from: d */
    private static final <T> T m8571d(T t, InterfaceC15280l<? super T, Unit> interfaceC15280l) {
        interfaceC15280l.invoke(t);
        return t;
    }

    @InlineOnly
    /* renamed from: e */
    private static final <T, R> R m8570e(T t, InterfaceC15280l<? super T, ? extends R> interfaceC15280l) {
        return interfaceC15280l.invoke(t);
    }

    @InlineOnly
    /* renamed from: f */
    private static final void m8569f(int i, InterfaceC15280l<? super Integer, Unit> interfaceC15280l) {
        for (int i2 = 0; i2 < i; i2++) {
            interfaceC15280l.invoke(Integer.valueOf(i2));
        }
    }

    @InlineOnly
    /* renamed from: g */
    private static final <T, R> R m8568g(T t, InterfaceC15280l<? super T, ? extends R> interfaceC15280l) {
        return interfaceC15280l.invoke(t);
    }

    @InlineOnly
    /* renamed from: h */
    private static final <R> R m8567h(InterfaceC15269a<? extends R> interfaceC15269a) {
        return interfaceC15269a.invoke();
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: i */
    private static final <T> T m8566i(T t, InterfaceC15280l<? super T, Boolean> interfaceC15280l) {
        if (interfaceC15280l.invoke(t).booleanValue()) {
            return t;
        }
        return null;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: j */
    private static final <T> T m8565j(T t, InterfaceC15280l<? super T, Boolean> interfaceC15280l) {
        if (interfaceC15280l.invoke(t).booleanValue()) {
            return null;
        }
        return t;
    }

    @InlineOnly
    /* renamed from: k */
    private static final <T, R> R m8564k(T t, InterfaceC15280l<? super T, ? extends R> interfaceC15280l) {
        return interfaceC15280l.invoke(t);
    }
}
