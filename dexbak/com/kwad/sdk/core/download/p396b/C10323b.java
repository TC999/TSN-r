package com.kwad.sdk.core.download.p396b;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ICompletedRemoteView;
import com.kwad.sdk.api.core.RemoteViewBuilder;
import com.kwad.sdk.core.p397e.C10331c;

/* renamed from: com.kwad.sdk.core.download.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10323b {
    private ICompletedRemoteView auJ;

    private C10323b(ICompletedRemoteView iCompletedRemoteView) {
        this.auJ = iCompletedRemoteView;
    }

    @Nullable
    /* renamed from: aY */
    public static C10323b m26285aY(Context context) {
        try {
            return new C10323b(RemoteViewBuilder.createCompletedView(context));
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final RemoteViews build() {
        ICompletedRemoteView iCompletedRemoteView = this.auJ;
        if (iCompletedRemoteView != null) {
            return iCompletedRemoteView.build();
        }
        return null;
    }

    public final void setIcon(Bitmap bitmap) {
        ICompletedRemoteView iCompletedRemoteView = this.auJ;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setIcon(bitmap);
        }
    }

    public final void setInstallText(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.auJ;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setInstallText(str);
        }
    }

    public final void setName(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.auJ;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setName(str);
        }
    }

    public final void setSize(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.auJ;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setSize(str);
        }
    }

    public final void setStatus(String str) {
        ICompletedRemoteView iCompletedRemoteView = this.auJ;
        if (iCompletedRemoteView != null) {
            iCompletedRemoteView.setStatus(str);
        }
    }
}
