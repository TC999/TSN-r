package cn.jpush.android.helper;

import android.content.Context;
import android.os.Bundle;
import cn.jiguang.api.JDispatchAction;
import cn.jpush.android.local.ActionHelper;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.local.JPushResponse;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b extends JDispatchAction {
    @Override // cn.jiguang.api.JDispatchAction
    public Object beforLogin(Context context, String str, int i4, String str2) {
        return ActionHelper.getInstance().beforLogin(context, str, i4, str2);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchMessage(Context context, String str, int i4, int i5, long j4, long j5, ByteBuffer byteBuffer) {
        Logger.d("JPushDispacthAction", "dispatchMessage command:" + i4 + ",ver:" + i5 + ",rid:" + j4 + ",requestid:" + j5);
        ActionHelper.getInstance().doAction(context, "msg", new JPushResponse(i4, j4, j5, byteBuffer));
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchTimeOutMessage(Context context, String str, long j4, int i4) {
        Bundle bundle = new Bundle();
        bundle.putLong("rid", j4);
        bundle.putInt("cmd", i4);
        ActionHelper.getInstance().doAction(context, "msg_time_out", bundle);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Object getDataByCmd(Context context, int i4) {
        if (30001 == i4) {
            return "sdk_ver_local";
        }
        if (30002 == i4) {
            return JPushConstants.SDK_VERSION_NAME;
        }
        return null;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLogPriority(String str) {
        return (short) 1;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLoginFlag(String str) {
        return (short) 1;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public Bundle getPInfo(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("pid", 2);
        bundle.putString("code", JPushConstants.SDK_VERSION_CODE + "");
        return bundle;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegFlag(String str) {
        return (short) 1;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegPriority(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getReportVersionKey(String str) {
        return "sdk_ver";
    }

    @Override // cn.jiguang.api.JDispatchAction
    public int getSdkType() {
        return super.getSdkType();
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getSdkVersion(String str) {
        return ActionHelper.getInstance().getSdkVersion(str);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getUserCtrlProperty(String str) {
        return (short) 1;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void handleMessage(Context context, String str, Object obj) {
        ActionHelper.getInstance().doAction(context, "handle_msg", obj);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean isSupportedCMD(String str, int i4) {
        return ActionHelper.getInstance().isSupportedCMD(str, i4);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onActionRun(Context context, String str, String str2, Bundle bundle) {
        ActionHelper.getInstance().doAction(context, str2, bundle);
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onEvent(Context context, String str, int i4, int i5, String str2) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", i4);
        bundle.putInt("code", i5);
        bundle.putString("msg", str2);
        ActionHelper.getInstance().doAction(context, "jcore_on_event", bundle);
    }
}
