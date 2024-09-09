package com.jg.ids.meizu;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class c extends com.jg.ids.a implements b {
    public c(Context context) {
        super(context, "meizu_thread");
        a.a().a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jg.ids.a
    public final void a(Message message) {
        if (message != null) {
            try {
                int i4 = message.getData().getInt("type", -1);
                String str = "";
                switch (i4) {
                    case 0:
                        str = a.a().c(this.f37822a);
                        break;
                    case 1:
                        str = a.a().d(this.f37822a);
                        break;
                    case 2:
                        str = a.a().b(this.f37822a);
                        break;
                }
                a(i4, str);
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.jg.ids.a
    protected final void b() {
        b(2);
        b(0);
        b(1);
    }

    private void b(int i4) {
        try {
            Message a4 = a();
            a4.what = 0;
            Bundle bundle = new Bundle();
            bundle.putInt("type", i4);
            a4.setData(bundle);
            b(a4);
        } catch (Throwable th) {
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        return a.a().a(this.f37822a);
    }

    @Override // com.jg.ids.meizu.b
    public final void a(int i4) {
        switch (i4) {
            case 0:
                b(0);
                return;
            case 1:
                b(1);
                return;
            case 2:
                b(2);
                return;
            default:
                return;
        }
    }
}
