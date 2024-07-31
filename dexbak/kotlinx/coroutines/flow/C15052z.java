package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;

@Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.z */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class C15052z {

    /* renamed from: a */
    public static final /* synthetic */ int[] f43015a;

    static {
        int[] iArr = new int[BufferOverflow.values().length];
        f43015a = iArr;
        iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
        iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
        iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
    }
}
