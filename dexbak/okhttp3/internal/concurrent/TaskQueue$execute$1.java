package okhttp3.internal.concurrent;

import kotlin.Metadata;
import p617l1.InterfaceC15269a;

/* compiled from: TaskQueue.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m12616d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class TaskQueue$execute$1 extends Task {
    final /* synthetic */ InterfaceC15269a $block;
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ String $name;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue$execute$1(InterfaceC15269a interfaceC15269a, String str, boolean z, String str2, boolean z2) {
        super(str2, z2);
        this.$block = interfaceC15269a;
        this.$name = str;
        this.$cancelable = z;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        this.$block.invoke();
        return -1L;
    }
}
