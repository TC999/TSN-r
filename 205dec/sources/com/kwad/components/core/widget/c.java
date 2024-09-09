package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.utils.bq;
import com.kwad.sdk.utils.br;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@SuppressLint({"ViewConstructor"})
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c extends View implements br.a {
    private View UI;
    private final AtomicBoolean UJ;
    private final int abA;
    private boolean abe;
    private boolean abf;
    private a aby;
    private boolean abz;
    private final br hh;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void eq();
    }

    public c(Context context, View view) {
        super(context);
        this.hh = new br(this);
        this.UJ = new AtomicBoolean(true);
        this.abA = (int) (com.kwad.sdk.core.config.d.Cl() * 100.0f);
        this.UI = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
    }

    private void tg() {
        if (this.abf) {
            this.hh.removeCallbacksAndMessages(null);
            this.abf = false;
        }
    }

    private void th() {
        if (!this.abz || this.abf) {
            return;
        }
        this.abf = true;
        this.hh.sendEmptyMessage(1);
    }

    private void tl() {
        this.UJ.getAndSet(false);
    }

    private void tm() {
        this.UJ.getAndSet(true);
    }

    @Override // com.kwad.sdk.utils.br.a
    public final void a(Message message) {
        a aVar;
        int i4 = message.what;
        if (i4 != 1) {
            if (i4 != 2) {
                return;
            }
            if (!bq.a(this.UI, this.abA, false)) {
                if (this.abe) {
                    return;
                }
                setNeedCheckingShow(true);
                return;
            }
            if (message.arg1 == 1000 && (aVar = this.aby) != null) {
                aVar.eq();
            }
            this.hh.sendEmptyMessageDelayed(2, 500L);
            return;
        }
        com.kwad.sdk.core.e.c.d("EmptyView", "handleMsg MSG_CHECKING");
        if (this.abf) {
            if (bq.a(this.UI, this.abA, false)) {
                tg();
                Message obtainMessage = this.hh.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 1000;
                this.hh.sendMessageDelayed(obtainMessage, 1000L);
                return;
            }
            this.hh.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.kwad.sdk.core.e.c.d("EmptyView", "onAttachedToWindow:" + this);
        th();
        this.abe = false;
        tl();
    }

    @Override // android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.sdk.core.e.c.d("EmptyView", "onDetachedFromWindow" + this);
        tg();
        this.abe = true;
        tm();
    }

    @Override // android.view.View
    public final void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        com.kwad.sdk.core.e.c.d("EmptyView", "onFinishTemporaryDetach:" + this.UI.getParent());
        tl();
    }

    @Override // android.view.View
    public final void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        com.kwad.sdk.core.e.c.d("EmptyView", "onStartTemporaryDetach:" + this.UI.getParent());
        tm();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        com.kwad.sdk.core.e.c.d("EmptyView", "onWindowFocusChanged hasWindowFocus:" + z3);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        com.kwad.sdk.core.e.c.d("EmptyView", "onWindowVisibilityChanged visibility:" + i4);
    }

    public final void setNeedCheckingShow(boolean z3) {
        this.abz = z3;
        if (!z3 && this.abf) {
            tg();
        } else if (!z3 || this.abf) {
        } else {
            th();
        }
    }

    public final void setViewCallback(a aVar) {
        this.aby = aVar;
    }
}
