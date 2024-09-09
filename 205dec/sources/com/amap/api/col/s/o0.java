package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.interfaces.IInputtipsSearch;
import com.stub.StubApp;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: InputtipsSearchCore.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class o0 implements IInputtipsSearch {

    /* renamed from: a  reason: collision with root package name */
    private Context f10052a;

    /* renamed from: b  reason: collision with root package name */
    private Inputtips.InputtipsListener f10053b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f10054c;

    /* renamed from: d  reason: collision with root package name */
    private InputtipsQuery f10055d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: InputtipsSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.obj = o0.this.f10053b;
            obtainMessage.arg1 = 5;
            try {
                try {
                    o0 o0Var = o0.this;
                    ArrayList<? extends Parcelable> c4 = o0Var.c(o0Var.f10055d);
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("result", c4);
                    obtainMessage.setData(bundle);
                    obtainMessage.what = 1000;
                } catch (AMapException e4) {
                    obtainMessage.what = e4.getErrorCode();
                }
            } finally {
                o0.this.f10054c.sendMessage(obtainMessage);
            }
        }
    }

    public o0(Context context, Inputtips.InputtipsListener inputtipsListener) throws AMapException {
        h1 a4 = cf.a(context, i4.a(false));
        if (a4.f9876a == cf.c.SuccessCode) {
            this.f10052a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f10053b = inputtipsListener;
            this.f10054c = u4.a();
            return;
        }
        String str = a4.f9877b;
        throw new AMapException(str, 1, str, a4.f9876a.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<Tip> c(InputtipsQuery inputtipsQuery) throws AMapException {
        try {
            s4.d(this.f10052a);
            if (inputtipsQuery != null) {
                if (inputtipsQuery.getKeyword() != null && !inputtipsQuery.getKeyword().equals("")) {
                    return new q4(this.f10052a, inputtipsQuery).O();
                }
                throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (Throwable th) {
            j4.i(th, "Inputtips", "requestInputtips");
            if (th instanceof AMapException) {
                throw th;
            }
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final InputtipsQuery getQuery() {
        return this.f10055d;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final ArrayList<Tip> requestInputtips() throws AMapException {
        return c(this.f10055d);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtipsAsyn() {
        try {
            y.a().b(new a());
        } catch (Throwable th) {
            j4.i(th, "Inputtips", "requestInputtipsAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setInputtipsListener(Inputtips.InputtipsListener inputtipsListener) {
        this.f10053b = inputtipsListener;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setQuery(InputtipsQuery inputtipsQuery) {
        this.f10055d = inputtipsQuery;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String str, String str2) throws AMapException {
        requestInputtips(str, str2, null);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String str, String str2, String str3) throws AMapException {
        if (str != null && !str.equals("")) {
            InputtipsQuery inputtipsQuery = new InputtipsQuery(str, str2);
            this.f10055d = inputtipsQuery;
            inputtipsQuery.setType(str3);
            requestInputtipsAsyn();
            return;
        }
        throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
    }

    public o0(Context context, InputtipsQuery inputtipsQuery) {
        this.f10052a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f10055d = inputtipsQuery;
        this.f10054c = u4.a();
    }
}
