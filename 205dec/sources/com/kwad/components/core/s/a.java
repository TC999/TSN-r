package com.kwad.components.core.s;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.utils.h;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a {
    private static volatile a SW;
    private com.kwad.sdk.utils.h SS;
    private List<WeakReference<OfflineOnAudioConflictListener>> ST = new ArrayList();
    private boolean SU = false;
    private boolean SV = false;

    private a(@NonNull Context context) {
        init(context);
    }

    public static a ah(@NonNull Context context) {
        if (SW == null) {
            synchronized (a.class) {
                if (SW == null) {
                    SW = new a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            }
        }
        return SW;
    }

    private void init(Context context) {
        this.SU = false;
        com.kwad.sdk.utils.h hVar = new com.kwad.sdk.utils.h(context);
        this.SS = hVar;
        hVar.c(new h.a() { // from class: com.kwad.components.core.s.a.1
            @Override // com.kwad.sdk.utils.h.a
            public final void onAudioBeOccupied() {
                Iterator it = a.this.ST.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null) {
                        it.remove();
                    } else {
                        OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                        if (offlineOnAudioConflictListener != null) {
                            offlineOnAudioConflictListener.onAudioBeOccupied();
                        } else {
                            it.remove();
                        }
                    }
                }
                a.a(a.this, true);
            }

            @Override // com.kwad.sdk.utils.h.a
            public final void onAudioBeReleased() {
                Iterator it = a.this.ST.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null) {
                        it.remove();
                    } else {
                        OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                        if (offlineOnAudioConflictListener != null) {
                            offlineOnAudioConflictListener.onAudioBeReleased();
                        } else {
                            it.remove();
                        }
                    }
                }
            }
        });
    }

    public final boolean aN(boolean z3) {
        com.kwad.sdk.utils.h hVar = this.SS;
        if (hVar == null) {
            return false;
        }
        if (z3 || !this.SU) {
            this.SU = true;
            this.SV = false;
            return hVar.Le();
        }
        return false;
    }

    public final void b(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        Iterator<WeakReference<OfflineOnAudioConflictListener>> it = this.ST.iterator();
        while (it.hasNext()) {
            WeakReference<OfflineOnAudioConflictListener> next = it.next();
            if (next == null || next.get() == offlineOnAudioConflictListener) {
                it.remove();
            }
        }
    }

    public final boolean qW() {
        return this.SV;
    }

    public final boolean qX() {
        return this.SU;
    }

    static /* synthetic */ boolean a(a aVar, boolean z3) {
        aVar.SV = true;
        return true;
    }

    public final void a(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        this.ST.add(new WeakReference<>(offlineOnAudioConflictListener));
    }
}
