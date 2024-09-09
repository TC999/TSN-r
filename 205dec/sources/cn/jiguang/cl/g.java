package cn.jiguang.cl;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JAction;
import cn.jiguang.api.JActionExtra;
import cn.jiguang.api.JCoreInterface;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.api.SdkType;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g extends JDispatchAction {
    private JAction a(String str) {
        return a.a().a(str);
    }

    private JActionExtra b(String str) {
        return a.a().b(str);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Object beforLogin(Context context, String str, int i4, String str2) {
        JActionExtra b4 = b(str);
        if (b4 != null) {
            return b4.beforLogin(context, i4, str2);
        }
        return null;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Object beforRegister(Context context, String str, int i4, String str2) {
        JActionExtra b4 = b(str);
        if (b4 != null) {
            return b4.beforRegister(context, i4, str2);
        }
        return null;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean checkAction(String str, int i4) {
        JActionExtra b4 = b(str);
        if (b4 != null) {
            return b4.checkAction(i4);
        }
        return true;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchMessage(Context context, String str, int i4, int i5, long j4, long j5, ByteBuffer byteBuffer) {
        JAction a4 = a(str);
        if (a4 != null) {
            d.b("SupportDispatchAction", "dispatchMessage ,command:" + i4 + ",ver:" + i5 + ",rid:" + j4 + ",reuqestId:" + j5);
            a4.dispatchMessage(context, 0L, i4, str.equals(SdkType.JMESSAGE.name()) ? new c(false, byteBuffer.limit() + 20, i5, i4, j4, JCoreInterface.getSid(), JCoreInterface.getUid()) : new c(false, i5, i4, j5), byteBuffer);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchTimeOutMessage(Context context, String str, long j4, int i4) {
        JAction a4 = a(str);
        if (a4 != null) {
            a4.dispatchTimeOutMessage(context, 0L, j4, i4);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLogPriority(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 2;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JAD.name())) {
            return (short) 5;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 3;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 6;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 7 : (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLoginFlag(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 8;
        }
        if (str.equals(SdkType.JAD.name())) {
            return (short) 128;
        }
        if (str.equals(SdkType.JMESSAGE.name())) {
            return (short) 32;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 256;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 512;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 1024 : (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegFlag(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 8;
        }
        if (str.equals(SdkType.JAD.name())) {
            return (short) 128;
        }
        if (str.equals(SdkType.JMESSAGE.name())) {
            return (short) 32;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 256;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 512;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 1024 : (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegPriority(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 0;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 2;
        }
        if (str.equals(SdkType.JAD.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 5;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 6;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 7 : (short) 3;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getReportVersionKey(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return "sdk_ver";
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return "statistics_sdk_ver";
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return "share_sdk_ver";
        }
        if (str.equals(SdkType.JAD.name())) {
            return "ssp_sdk_ver";
        }
        if (str.equals(SdkType.JMESSAGE.name())) {
            return "im_sdk_ver";
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return "verification_sdk_ver";
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return "mlink_sdk_ver";
        }
        if (str.equals(SdkType.JUNION.name())) {
            return "junion_sdk_ver";
        }
        return null;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getSdkVersion(String str) {
        JAction a4 = a(str);
        return a4 != null ? a4.getSdkVersion() : "";
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getUserCtrlProperty(String str) {
        if (str.equals(SdkType.JPUSH.name())) {
            return (short) 1;
        }
        if (str.equals(SdkType.JMESSAGE.name())) {
            return (short) 2;
        }
        if (str.equals(SdkType.JANALYTICS.name())) {
            return (short) 4;
        }
        if (str.equals(SdkType.JSHARE.name())) {
            return (short) 5;
        }
        if (str.equals(SdkType.JAD.name())) {
            return (short) 9;
        }
        if (str.equals(SdkType.JVERIFICATION.name())) {
            return (short) 10;
        }
        if (str.equals(SdkType.JMLINK.name())) {
            return (short) 11;
        }
        return str.equals(SdkType.JUNION.name()) ? (short) 12 : (short) 6;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void handleMessage(Context context, String str, Object obj) {
        d.b("SupportDispatchAction", "handleMessage,sdkType:" + str);
        JAction a4 = a(str);
        if (a4 != null) {
            a4.handleMessage(context, 0L, obj);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean isSupportedCMD(String str, int i4) {
        JAction a4 = a(str);
        if (a4 != null) {
            return a4.isSupportedCMD(i4);
        }
        return false;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onActionRun(Context context, String str, String str2, Bundle bundle) {
        JAction a4 = a(str);
        if (a4 != null) {
            a4.onActionRun(context, 0L, bundle, null);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onEvent(Context context, String str, int i4, int i5, String str2) {
        JAction a4 = a(str);
        if (a4 != null) {
            a4.onEvent(context, 0L, i4);
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Object onSendData(Context context, String str, long j4, int i4, int i5) {
        JActionExtra b4 = b(str);
        if (b4 != null) {
            return b4.onSendData(context, 0L, j4, i4, i5);
        }
        return null;
    }
}
