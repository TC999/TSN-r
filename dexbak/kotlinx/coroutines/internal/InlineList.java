package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.umeng.ccg.CcgConstant;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0080@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0016\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0004\u0010\u0005J$\u0010\t\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\t\u0010\u000e\u001a\u00020\rHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÖ\u0003R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0017"}, m12616d2 = {"Lkotlinx/coroutines/internal/n;", ExifInterface.LONGITUDE_EAST, "", "element", "h", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/f1;", CcgConstant.f38549t, "f", "(Ljava/lang/Object;Ll1/l;)V", "", "toString", "", TTDownloadField.TT_HASHCODE, AdnName.OTHER, "", "equals", "a", "Ljava/lang/Object;", "holder", "b", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.n */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class InlineList<E> {

    /* renamed from: a */
    private final Object f43064a;

    private /* synthetic */ InlineList(@Nullable Object obj) {
        this.f43064a = obj;
    }

    @NotNull
    /* renamed from: a */
    public static final /* synthetic */ InlineList m4271a(@Nullable Object obj) {
        return new InlineList(obj);
    }

    @NotNull
    /* renamed from: b */
    public static Object m4270b(@Nullable Object obj) {
        return obj;
    }

    /* renamed from: c */
    public static /* synthetic */ Object m4269c(Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            obj = null;
        }
        return m4270b(obj);
    }

    /* renamed from: d */
    public static boolean m4268d(Object obj, @Nullable Object obj2) {
        return (obj2 instanceof InlineList) && C14342f0.m8193g(obj, ((InlineList) obj2).m4262j());
    }

    /* renamed from: e */
    public static final boolean m4267e(@Nullable Object obj, @Nullable Object obj2) {
        return C14342f0.m8193g(obj, obj2);
    }

    /* renamed from: f */
    public static final void m4266f(Object obj, @NotNull InterfaceC15280l<? super E, Unit> interfaceC15280l) {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof ArrayList)) {
            interfaceC15280l.invoke(obj);
            return;
        }
        ArrayList arrayList = (ArrayList) obj;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            interfaceC15280l.invoke((Object) arrayList.get(size));
        }
    }

    /* renamed from: g */
    public static int m4265g(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    @NotNull
    /* renamed from: h */
    public static final Object m4264h(Object obj, E e) {
        if (obj == null) {
            return m4270b(e);
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(e);
            return m4270b(obj);
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(e);
        return m4270b(arrayList);
    }

    @NotNull
    /* renamed from: i */
    public static String m4263i(Object obj) {
        return "InlineList(holder=" + obj + ")";
    }

    public boolean equals(Object obj) {
        return m4268d(this.f43064a, obj);
    }

    public int hashCode() {
        return m4265g(this.f43064a);
    }

    @Nullable
    /* renamed from: j */
    public final /* synthetic */ Object m4262j() {
        return this.f43064a;
    }

    public String toString() {
        return m4263i(this.f43064a);
    }
}
