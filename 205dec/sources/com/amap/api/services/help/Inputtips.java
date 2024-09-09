package com.amap.api.services.help;

import android.content.Context;
import com.amap.api.col.s.o0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IInputtipsSearch;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class Inputtips {

    /* renamed from: a  reason: collision with root package name */
    private IInputtipsSearch f11100a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface InputtipsListener {
        void onGetInputtips(List<Tip> list, int i4);
    }

    public Inputtips(Context context, InputtipsListener inputtipsListener) throws AMapException {
        this.f11100a = null;
        try {
            this.f11100a = new o0(context, inputtipsListener);
        } catch (Exception e4) {
            e4.printStackTrace();
            if (e4 instanceof AMapException) {
                throw ((AMapException) e4);
            }
        }
    }

    public final InputtipsQuery getQuery() {
        IInputtipsSearch iInputtipsSearch = this.f11100a;
        if (iInputtipsSearch != null) {
            return iInputtipsSearch.getQuery();
        }
        return null;
    }

    public final List<Tip> requestInputtips() throws AMapException {
        IInputtipsSearch iInputtipsSearch = this.f11100a;
        if (iInputtipsSearch != null) {
            return iInputtipsSearch.requestInputtips();
        }
        return null;
    }

    public final void requestInputtipsAsyn() {
        IInputtipsSearch iInputtipsSearch = this.f11100a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtipsAsyn();
        }
    }

    public final void setInputtipsListener(InputtipsListener inputtipsListener) {
        IInputtipsSearch iInputtipsSearch = this.f11100a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.setInputtipsListener(inputtipsListener);
        }
    }

    public final void setQuery(InputtipsQuery inputtipsQuery) {
        IInputtipsSearch iInputtipsSearch = this.f11100a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.setQuery(inputtipsQuery);
        }
    }

    public final void requestInputtips(String str, String str2) throws AMapException {
        IInputtipsSearch iInputtipsSearch = this.f11100a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtips(str, str2);
        }
    }

    public final void requestInputtips(String str, String str2, String str3) throws AMapException {
        IInputtipsSearch iInputtipsSearch = this.f11100a;
        if (iInputtipsSearch != null) {
            iInputtipsSearch.requestInputtips(str, str2, str3);
        }
    }

    public Inputtips(Context context, InputtipsQuery inputtipsQuery) {
        this.f11100a = null;
        try {
            this.f11100a = new o0(context, inputtipsQuery);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
