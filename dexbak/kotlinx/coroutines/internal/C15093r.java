package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.PublishedApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: LockFreeLinkedList.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0000H\u0001\"\u001a\u0010\t\u001a\u00020\u00048\u0000X\u0081T¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\u0007\u0010\b\"\u001a\u0010\f\u001a\u00020\u00048\u0000X\u0081T¢\u0006\f\n\u0004\b\n\u0010\u0006\u0012\u0004\b\u000b\u0010\b\"\u001a\u0010\u000f\u001a\u00020\u00048\u0000X\u0081T¢\u0006\f\n\u0004\b\r\u0010\u0006\u0012\u0004\b\u000e\u0010\b\" \u0010\u0014\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0005\u0010\u0012\" \u0010\u0017\u001a\u00020\u00008\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0010\u0010\u0012*\n\u0010\u0019\"\u00020\u00182\u00020\u0018*\u001c\u0010\u001c\u001a\u0004\b\u0000\u0010\u001a\"\b\u0012\u0004\u0012\u00028\u00000\u001b2\b\u0012\u0004\u0012\u00028\u00000\u001b*\f\b\u0002\u0010\u001d\"\u00020\u00012\u00020\u0001*\n\u0010\u001f\"\u00020\u001e2\u00020\u001e*\u001c\u0010!\u001a\u0004\b\u0000\u0010\u001a\"\b\u0012\u0004\u0012\u00028\u00000 2\b\u0012\u0004\u0012\u00028\u00000 ¨\u0006\""}, m12616d2 = {"", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/Node;", "h", "", "a", "I", "getUNDECIDED$annotations", "()V", "UNDECIDED", "b", "getSUCCESS$annotations", "SUCCESS", "c", "getFAILURE$annotations", "FAILURE", "d", "Ljava/lang/Object;", "()Ljava/lang/Object;", "getCONDITION_FALSE$annotations", "CONDITION_FALSE", "e", "getLIST_EMPTY$annotations", "LIST_EMPTY", "Lkotlinx/coroutines/internal/s$a;", "AbstractAtomicDesc", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/s$b;", "AddLastDesc", "Node", "Lkotlinx/coroutines/internal/s$d;", "PrepareOp", "Lkotlinx/coroutines/internal/s$e;", "RemoveFirstDesc", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.r */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15093r {

    /* renamed from: a */
    public static final int f43078a = 0;

    /* renamed from: b */
    public static final int f43079b = 1;

    /* renamed from: c */
    public static final int f43080c = 2;
    @NotNull

    /* renamed from: d */
    private static final Object f43081d = new Symbol("CONDITION_FALSE");
    @NotNull

    /* renamed from: e */
    private static final Object f43082e = new Symbol("LIST_EMPTY");

    @NotNull
    /* renamed from: a */
    public static final Object m4240a() {
        return f43081d;
    }

    @PublishedApi
    /* renamed from: b */
    public static /* synthetic */ void m4239b() {
    }

    @PublishedApi
    /* renamed from: c */
    public static /* synthetic */ void m4238c() {
    }

    @NotNull
    /* renamed from: d */
    public static final Object m4237d() {
        return f43082e;
    }

    @PublishedApi
    /* renamed from: e */
    public static /* synthetic */ void m4236e() {
    }

    @PublishedApi
    /* renamed from: f */
    public static /* synthetic */ void m4235f() {
    }

    @PublishedApi
    /* renamed from: g */
    public static /* synthetic */ void m4234g() {
    }

    @PublishedApi
    @NotNull
    /* renamed from: h */
    public static final C15094s m4233h(@NotNull Object obj) {
        C15094s c15094s;
        LockFreeLinkedList lockFreeLinkedList = (LockFreeLinkedList) (!(obj instanceof LockFreeLinkedList) ? null : obj);
        if (lockFreeLinkedList == null || (c15094s = lockFreeLinkedList.f43037a) == null) {
            if (obj != null) {
                return (C15094s) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        return c15094s;
    }
}
