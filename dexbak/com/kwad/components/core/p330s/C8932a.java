package com.kwad.components.core.p330s;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.utils.C11096h;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.kwad.components.core.s.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8932a {

    /* renamed from: SW */
    private static volatile C8932a f28844SW;

    /* renamed from: SS */
    private C11096h f28845SS;

    /* renamed from: ST */
    private List<WeakReference<OfflineOnAudioConflictListener>> f28846ST = new ArrayList();

    /* renamed from: SU */
    private boolean f28847SU = false;

    /* renamed from: SV */
    private boolean f28848SV = false;

    private C8932a(@NonNull Context context) {
        init(context);
    }

    /* renamed from: ah */
    public static C8932a m29575ah(@NonNull Context context) {
        if (f28844SW == null) {
            synchronized (C8932a.class) {
                if (f28844SW == null) {
                    f28844SW = new C8932a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            }
        }
        return f28844SW;
    }

    private void init(Context context) {
        this.f28847SU = false;
        C11096h c11096h = new C11096h(context);
        this.f28845SS = c11096h;
        c11096h.m23788c(new C11096h.InterfaceC11099a() { // from class: com.kwad.components.core.s.a.1
            @Override // com.kwad.sdk.utils.C11096h.InterfaceC11099a
            public final void onAudioBeOccupied() {
                Iterator it = C8932a.this.f28846ST.iterator();
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
                C8932a.m29578a(C8932a.this, true);
            }

            @Override // com.kwad.sdk.utils.C11096h.InterfaceC11099a
            public final void onAudioBeReleased() {
                Iterator it = C8932a.this.f28846ST.iterator();
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

    /* renamed from: aN */
    public final boolean m29576aN(boolean z) {
        C11096h c11096h = this.f28845SS;
        if (c11096h == null) {
            return false;
        }
        if (z || !this.f28847SU) {
            this.f28847SU = true;
            this.f28848SV = false;
            return c11096h.m23791Le();
        }
        return false;
    }

    /* renamed from: b */
    public final void m29574b(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        Iterator<WeakReference<OfflineOnAudioConflictListener>> it = this.f28846ST.iterator();
        while (it.hasNext()) {
            WeakReference<OfflineOnAudioConflictListener> next = it.next();
            if (next == null || next.get() == offlineOnAudioConflictListener) {
                it.remove();
            }
        }
    }

    /* renamed from: qW */
    public final boolean m29573qW() {
        return this.f28848SV;
    }

    /* renamed from: qX */
    public final boolean m29572qX() {
        return this.f28847SU;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m29578a(C8932a c8932a, boolean z) {
        c8932a.f28848SV = true;
        return true;
    }

    /* renamed from: a */
    public final void m29577a(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        this.f28846ST.add(new WeakReference<>(offlineOnAudioConflictListener));
    }
}
