package cn.jiguang.ao;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JDispatchAction;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends JDispatchAction {
    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchMessage(Context context, String str, int i4, int i5, long j4, long j5, ByteBuffer byteBuffer) {
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Object getDataByAction(Context context, String str, String str2, Bundle bundle, Object obj) {
        str.hashCode();
        if (str.equals("jportrait")) {
            return cn.jiguang.s.a.a(context, str2, bundle, obj);
        }
        if (str.equals("jcommon")) {
            return d.a(context, str2, obj);
        }
        return null;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLogPriority(String str) {
        return (short) 9;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLoginFlag(String str) {
        return (short) 4096;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegFlag(String str) {
        return (short) 4096;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegPriority(String str) {
        return (short) 9;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getReportVersionKey(String str) {
        return "portrait_sdk_ver";
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getSdkVersion(String str) {
        return "4.7.3";
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getUserCtrlProperty(String str) {
        return (short) 14;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean isSupportedCMD(String str, int i4) {
        return false;
    }
}
