package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;

@Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.internal.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class C14980d {

    /* renamed from: a */
    public static final /* synthetic */ int[] f42813a;

    static {
        int[] iArr = new int[BufferOverflow.values().length];
        f42813a = iArr;
        iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
        iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 2;
        iArr[BufferOverflow.DROP_LATEST.ordinal()] = 3;
    }
}
