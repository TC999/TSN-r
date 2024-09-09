package com.kwad.components.ad.feed;

import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.utils.bn;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    private static com.kwad.sdk.core.g.d eg;
    private static Vibrator eh;
    private static List<a> ei = new CopyOnWriteArrayList();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private b ek;
        private Context mContext;

        public a(b bVar, Context context) {
            this.ek = bVar;
            this.mContext = context;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        boolean b(double d4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Vibrator D(Context context) {
        if (eh == null) {
            eh = (Vibrator) context.getSystemService("vibrator");
        }
        return eh;
    }

    public static void a(float f4, Context context, b bVar) {
        if (eg == null) {
            a(f4, context);
        }
        ei.add(new a(bVar, context));
    }

    public static void a(b bVar) {
        for (a aVar : ei) {
            if (aVar.ek == bVar) {
                ei.remove(aVar);
            }
        }
        com.kwad.sdk.core.e.c.d("KSFeedShakeManager", "sShakeItems size " + ei.size());
    }

    private static void a(float f4, Context context) {
        eg = new com.kwad.sdk.core.g.d(f4);
        ei = new CopyOnWriteArrayList();
        eg.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.feed.d.1
            @Override // com.kwad.sdk.core.g.b
            public final void a(double d4) {
                if (d.ei != null) {
                    Iterator it = d.ei.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        a aVar = (a) it.next();
                        if (aVar.ek != null && aVar.ek.b(d4)) {
                            bn.a(aVar.mContext, d.D(aVar.mContext));
                            break;
                        }
                    }
                    bn.a(new Runnable() { // from class: com.kwad.components.ad.feed.d.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.e.c.d("KSFeedShakeManager", "onShakeEvent openGate2");
                            d.eg.Fu();
                        }
                    }, null, 500L);
                }
            }

            @Override // com.kwad.sdk.core.g.b
            public final void aV() {
            }
        });
        eg.e(f4);
        eg.bi(context);
    }
}
