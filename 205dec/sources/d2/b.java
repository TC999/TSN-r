package d2;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import kotlin.Metadata;
import org.repackage.a.a.a.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Functions.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0006\b\u0001\u0010\u0002 \u0000*\u0006\b\u0002\u0010\u0003 \u0000*\u0006\b\u0003\u0010\u0004 \u0000*\u0006\b\u0004\u0010\u0005 \u0000*\u0006\b\u0005\u0010\u0006 \u0000*\u0006\b\u0006\u0010\u0007 \u0000*\u0006\b\u0007\u0010\b \u0000*\u0006\b\b\u0010\t \u0000*\u0006\b\t\u0010\n \u0000*\u0006\b\n\u0010\u000b \u00012\b\u0012\u0004\u0012\u00028\n0\fJ`\u0010\u0017\u001a\u00028\n2\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00028\u00022\u0006\u0010\u0010\u001a\u00028\u00032\u0006\u0010\u0011\u001a\u00028\u00042\u0006\u0010\u0012\u001a\u00028\u00052\u0006\u0010\u0013\u001a\u00028\u00062\u0006\u0010\u0014\u001a\u00028\u00072\u0006\u0010\u0015\u001a\u00028\b2\u0006\u0010\u0016\u001a\u00028\tH\u00a6\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"Ld2/b;", "P1", "P2", "P3", "P4", "P5", "P6", "P7", "P8", "P9", "P10", "R", "Lkotlin/k;", "p1", "p2", "p3", "p4", "p5", "p6", "p7", "p8", "p9", "p10", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface b<P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R> extends kotlin.k<R> {

    /* compiled from: OpenIDHelper.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.a = a.AbstractBinderC1249a.a(iBinder);
            synchronized (b.this.d) {
                b.this.d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.a = null;
        }
    }

    /* compiled from: OpenIDHelper.java */
    /* renamed from: d2.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    private static class C1076b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f54623a = new b(null);
    }

    R invoke(P1 p12, P2 p22, P3 p3, P4 p4, P5 p5, P6 p6, P7 p7, P8 p8, P9 p9, P10 p10);
}
