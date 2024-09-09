package kotlinx.coroutines.channels;

import kotlin.Metadata;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class h {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f59420a;

    static {
        int[] iArr = new int[BufferOverflow.values().length];
        f59420a = iArr;
        iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
        iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
        iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
    }
}
