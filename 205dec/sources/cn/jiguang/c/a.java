package cn.jiguang.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.bl.c;
import cn.jiguang.bq.d;
import cn.jiguang.bx.e;
import cn.jiguang.bx.h;
import cn.jiguang.bx.k;
import cn.jiguang.cn.g;
import cn.jiguang.internal.JConstants;
import java.nio.ByteBuffer;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends JDispatchAction {
    private static JSONObject a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            ByteBuffer wrap = ByteBuffer.wrap(byteBuffer.array());
            wrap.getLong();
            byte[] bArr = new byte[wrap.getShort()];
            wrap.get(bArr);
            String str = new String(bArr, "UTF-8");
            d.c("JCoreDispatchAction", "parseBundle2Json content: " + str);
            return new JSONObject(str);
        } catch (Exception e4) {
            d.i("JCoreDispatchAction", "parseBundle2Json exception:" + e4.getMessage());
            return null;
        }
    }

    private void a(Context context, long j4, int i4, ByteBuffer byteBuffer) {
        if (i4 == 19) {
            h.a().a(context, "tcp_a18", null);
        } else if (i4 == 30 || i4 == 32) {
            cn.jiguang.e.a.b().a(context, 0, i4);
        } else if (i4 == 25) {
            a(context, byteBuffer);
        } else if (i4 == 26 && byteBuffer != null) {
            short s3 = byteBuffer.getShort();
            if (s3 == 0) {
                k.a().a(context, j4);
            } else {
                k.a().a(context, j4, s3);
            }
        }
    }

    private void a(Context context, Bundle bundle) {
        if (bundle != null) {
            try {
                JSONObject jSONObject = new JSONObject(g.b(bundle.getString("aes"), cn.jiguang.a.a.f2017i));
                d.c("JCoreDispatchAction", "jsonObject=" + jSONObject);
                c.a(context, jSONObject);
                if (jSONObject.has("u_l")) {
                    d.c("JCoreDispatchAction", "startUpload");
                    cn.jiguang.bq.a.b(context);
                }
                if (jSONObject.has("e_l")) {
                    d.c("JCoreDispatchAction", "set e_l");
                    cn.jiguang.g.b.a(context, cn.jiguang.g.a.ah().a((cn.jiguang.g.a<Boolean>) Boolean.valueOf(jSONObject.optBoolean("e_l"))));
                }
            } catch (Throwable unused) {
            }
        }
    }

    private void a(Context context, ByteBuffer byteBuffer) {
        JSONObject a4 = a(byteBuffer);
        if (a4 == null) {
            return;
        }
        try {
            int optInt = a4.optInt("cmd");
            JSONObject optJSONObject = a4.optJSONObject("content");
            String jSONObject = optJSONObject != null ? optJSONObject.toString() : "";
            d.c("JCoreDispatchAction", "deal command, cmd: " + optInt + ", content: " + jSONObject);
            if (optInt == 75) {
                h.a().a(optJSONObject);
            } else if (optInt == 80) {
                cn.jiguang.bk.b.a(context, optJSONObject);
            }
            Bundle bundle = new Bundle();
            bundle.putByteArray("RESPONSE_BODY", byteBuffer.array());
            e.a(context, "cmd", bundle);
        } catch (Throwable th) {
            d.i("JCoreDispatchAction", "deal command failed, " + th.getMessage());
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void dispatchMessage(Context context, String str, int i4, int i5, long j4, long j5, ByteBuffer byteBuffer) {
        try {
            a(context, j5, i4, byteBuffer);
        } catch (Throwable th) {
            d.i("JCoreDispatchAction", "dispatchMessage failed:" + th.getMessage());
        }
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLogPriority(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getLoginFlag(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegFlag(String str) {
        return (short) 0;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getRegPriority(String str) {
        return (short) 3;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getReportVersionKey(String str) {
        return "core_sdk_ver";
    }

    @Override // cn.jiguang.api.JDispatchAction
    public String getSdkVersion(String str) {
        return cn.jiguang.a.a.f2010b;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public short getUserCtrlProperty(String str) {
        return (short) 6;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void handleMessage(Context context, String str, Object obj) {
    }

    @Override // cn.jiguang.api.JDispatchAction
    public boolean isSupportedCMD(String str, int i4) {
        return i4 == 0 || i4 == 1 || i4 == 19 || i4 == 25 || i4 == 26 || i4 == 30 || i4 == 32;
    }

    @Override // cn.jiguang.api.JDispatchAction
    public void onActionRun(Context context, String str, String str2, Bundle bundle) {
        if (bundle != null) {
            try {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                if (str2.equals("asm")) {
                    cn.jiguang.e.a.b().a(context, bundle);
                } else if (str2.equals("asmr")) {
                    cn.jiguang.e.a.b().b(context, bundle);
                } else if (str2.equals("lbsenable")) {
                    e.a(context, str2, bundle);
                    cn.jiguang.g.b.a(context, cn.jiguang.g.a.Y().a((cn.jiguang.g.a<Boolean>) Boolean.valueOf(bundle.getBoolean("enable"))));
                } else if (str2.equals("lbsforenry")) {
                    long j4 = bundle.getLong("forenry");
                    d.c("JCoreDispatchAction", "setLbsPermissionDialogShieldDelay=" + j4);
                    if (((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.V())).longValue() <= 0) {
                        cn.jiguang.g.b.a(context, cn.jiguang.g.a.V().a((cn.jiguang.g.a<Long>) Long.valueOf(System.currentTimeMillis())));
                    }
                    cn.jiguang.g.a[] aVarArr = new cn.jiguang.g.a[1];
                    aVarArr[0] = cn.jiguang.g.a.X().a((cn.jiguang.g.a<Long>) (j4 > 0 ? Long.valueOf(j4) : null));
                    cn.jiguang.g.b.a(context, aVarArr);
                } else {
                    if (!str2.equals("notification_state") && !str2.equals("old_cmd") && !str2.equals("user_present") && !str2.equals("set_wake_enable")) {
                        if (str2.equals("open_log")) {
                            a(context, bundle);
                            return;
                        } else if ("country".equals(str2)) {
                            JConstants.testCountry = bundle.getString("country");
                            return;
                        } else {
                            return;
                        }
                    }
                    e.a(context, str2, bundle);
                }
            } catch (Throwable th) {
                d.i("JCoreDispatchAction", "onActionRun failed:" + th.getMessage());
            }
        }
    }
}
