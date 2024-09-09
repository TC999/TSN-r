package cn.jiguang.api;

import android.content.Context;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class JActionExtra {
    public Object beforLogin(Context context, int i4, String str) {
        return null;
    }

    public Object beforRegister(Context context, int i4, String str) {
        return null;
    }

    public boolean checkAction(int i4) {
        return true;
    }

    public Object onSendData(Context context, long j4, long j5, int i4, int i5) {
        return null;
    }
}
