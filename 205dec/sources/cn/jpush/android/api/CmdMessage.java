package cn.jpush.android.api;

import android.os.Bundle;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class CmdMessage {
    public int cmd;
    public int errorCode;
    public Bundle extra;
    public String msg;

    public CmdMessage(int i4, int i5) {
        this.cmd = i4;
        this.errorCode = i5;
    }

    public CmdMessage(int i4, int i5, String str) {
        this.cmd = i4;
        this.errorCode = i5;
        this.msg = str;
    }

    public CmdMessage(int i4, int i5, String str, Bundle bundle) {
        this.cmd = i4;
        this.errorCode = i5;
        this.msg = str;
        this.extra = bundle;
    }

    public String toString() {
        return "CmdMessage{cmd=" + this.cmd + ", errorCode=" + this.errorCode + ", msg='" + this.msg + "', extra=" + this.extra + '}';
    }
}
