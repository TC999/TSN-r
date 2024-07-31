package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import com.amap.api.col.p047s.C2033cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import com.amap.api.services.interfaces.IInputtipsSearch;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;

/* renamed from: com.amap.api.col.s.o0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class InputtipsSearchCore implements IInputtipsSearch {

    /* renamed from: a */
    private Context f6324a;

    /* renamed from: b */
    private Inputtips.InputtipsListener f6325b;

    /* renamed from: c */
    private Handler f6326c;

    /* renamed from: d */
    private InputtipsQuery f6327d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: InputtipsSearchCore.java */
    /* renamed from: com.amap.api.col.s.o0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class RunnableC2104a implements Runnable {
        RunnableC2104a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.obj = InputtipsSearchCore.this.f6325b;
            obtainMessage.arg1 = 5;
            try {
                try {
                    InputtipsSearchCore inputtipsSearchCore = InputtipsSearchCore.this;
                    ArrayList<? extends Parcelable> m52721c = inputtipsSearchCore.m52721c(inputtipsSearchCore.f6327d);
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList(CommonNetImpl.RESULT, m52721c);
                    obtainMessage.setData(bundle);
                    obtainMessage.what = 1000;
                } catch (AMapException e) {
                    obtainMessage.what = e.getErrorCode();
                }
            } finally {
                InputtipsSearchCore.this.f6326c.sendMessage(obtainMessage);
            }
        }
    }

    public InputtipsSearchCore(Context context, Inputtips.InputtipsListener inputtipsListener) throws AMapException {
        C2066h1 m53127a = C2033cf.m53127a(context, C2077i4.m52895a(false));
        if (m53127a.f6148a == C2033cf.EnumC2036c.SuccessCode) {
            this.f6324a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f6325b = inputtipsListener;
            this.f6326c = MessageHandler.m52418a();
            return;
        }
        String str = m53127a.f6149b;
        throw new AMapException(str, 1, str, m53127a.f6148a.m53102a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public ArrayList<Tip> m52721c(InputtipsQuery inputtipsQuery) throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6324a);
            if (inputtipsQuery != null) {
                if (inputtipsQuery.getKeyword() != null && !inputtipsQuery.getKeyword().equals("")) {
                    return new InputtipsHandler(this.f6324a, inputtipsQuery).m53251O();
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (Throwable th) {
            C2082j4.m52825i(th, "Inputtips", "requestInputtips");
            if (th instanceof AMapException) {
                throw th;
            }
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final InputtipsQuery getQuery() {
        return this.f6327d;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final ArrayList<Tip> requestInputtips() throws AMapException {
        return m52721c(this.f6327d);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtipsAsyn() {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2104a());
        } catch (Throwable th) {
            C2082j4.m52825i(th, "Inputtips", "requestInputtipsAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setInputtipsListener(Inputtips.InputtipsListener inputtipsListener) {
        this.f6325b = inputtipsListener;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void setQuery(InputtipsQuery inputtipsQuery) {
        this.f6327d = inputtipsQuery;
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String str, String str2) throws AMapException {
        requestInputtips(str, str2, null);
    }

    @Override // com.amap.api.services.interfaces.IInputtipsSearch
    public final void requestInputtips(String str, String str2, String str3) throws AMapException {
        if (str != null && !str.equals("")) {
            InputtipsQuery inputtipsQuery = new InputtipsQuery(str, str2);
            this.f6327d = inputtipsQuery;
            inputtipsQuery.setType(str3);
            requestInputtipsAsyn();
            return;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    public InputtipsSearchCore(Context context, InputtipsQuery inputtipsQuery) {
        this.f6324a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f6327d = inputtipsQuery;
        this.f6326c = MessageHandler.m52418a();
    }
}
