package com.mbridge.msdk.foundation.p468a.p469a;

import android.content.Context;
import android.content.SharedPreferences;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.SDKController;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.SameLogTool;

/* renamed from: com.mbridge.msdk.foundation.a.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class SharedPerferenceManager {

    /* renamed from: a */
    public static final String f30197a = "a";

    /* renamed from: e */
    private static SharedPerferenceManager f30198e;

    /* renamed from: b */
    SharedPreferences f30199b;

    /* renamed from: c */
    FastKV f30200c;

    /* renamed from: d */
    private final boolean f30201d = SDKController.m22827a().m22818d();

    private SharedPerferenceManager() {
    }

    /* renamed from: a */
    public static synchronized SharedPerferenceManager m22949a() {
        SharedPerferenceManager sharedPerferenceManager;
        synchronized (SharedPerferenceManager.class) {
            if (f30198e == null) {
                f30198e = new SharedPerferenceManager();
            }
            sharedPerferenceManager = f30198e;
        }
        return sharedPerferenceManager;
    }

    /* renamed from: b */
    public final int m22943b(String str, int i) {
        try {
            Context m22861j = MBSDKContext.m22865f().m22861j();
            if (m22861j == null) {
                return i;
            }
            if (this.f30201d && this.f30200c == null) {
                try {
                    this.f30200c = new FastKV.Builder(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f30200c = null;
                }
            }
            FastKV fastKV = this.f30200c;
            if (fastKV != null) {
                try {
                    return fastKV.getInt(str, i);
                } catch (Exception unused2) {
                    return i;
                }
            }
            if (this.f30199b == null) {
                this.f30199b = m22861j.getSharedPreferences("mbridge", 0);
            }
            return this.f30199b.getInt(str, i);
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    /* renamed from: c */
    public final void m22942c(String str) {
        Context m22861j = MBSDKContext.m22865f().m22861j();
        if (m22861j == null) {
            return;
        }
        if (this.f30201d && this.f30200c == null) {
            try {
                this.f30200c = new FastKV.Builder(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_CONFIG), "mbridge").build();
            } catch (Exception unused) {
                this.f30200c = null;
            }
        }
        FastKV fastKV = this.f30200c;
        if (fastKV != null) {
            try {
                fastKV.remove(str);
                return;
            } catch (Exception unused2) {
                return;
            }
        }
        if (this.f30199b == null) {
            this.f30199b = m22861j.getSharedPreferences("mbridge", 0);
        }
        this.f30199b.edit().remove(str).apply();
    }

    /* renamed from: a */
    public final void m22945a(String str, String str2) {
        try {
            Context m22861j = MBSDKContext.m22865f().m22861j();
            if (m22861j == null) {
                return;
            }
            if (this.f30201d && this.f30200c == null) {
                try {
                    this.f30200c = new FastKV.Builder(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f30200c = null;
                }
            }
            FastKV fastKV = this.f30200c;
            if (fastKV != null) {
                try {
                    fastKV.putString(str, str2);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            if (this.f30199b == null) {
                this.f30199b = m22861j.getSharedPreferences("mbridge", 0);
            }
            SharedPreferences.Editor edit = this.f30199b.edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public final String m22944b(String str) {
        try {
            Context m22861j = MBSDKContext.m22865f().m22861j();
            if (m22861j == null) {
                return null;
            }
            if (this.f30201d && this.f30200c == null) {
                try {
                    this.f30200c = new FastKV.Builder(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f30200c = null;
                }
            }
            FastKV fastKV = this.f30200c;
            if (fastKV != null) {
                try {
                    return fastKV.getString(str, "");
                } catch (Exception unused2) {
                    return "";
                }
            }
            if (this.f30199b == null) {
                this.f30199b = m22861j.getSharedPreferences("mbridge", 0);
            }
            return this.f30199b.getString(str, "");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public final void m22947a(String str, int i) {
        try {
            Context m22861j = MBSDKContext.m22865f().m22861j();
            if (m22861j == null) {
                return;
            }
            if (this.f30201d && this.f30200c == null) {
                try {
                    this.f30200c = new FastKV.Builder(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f30200c = null;
                }
            }
            FastKV fastKV = this.f30200c;
            if (fastKV != null) {
                try {
                    fastKV.putInt(str, i);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            if (this.f30199b == null) {
                this.f30199b = m22861j.getSharedPreferences("mbridge", 0);
            }
            SharedPreferences.Editor edit = this.f30199b.edit();
            edit.putInt(str, i);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m22946a(String str, long j) {
        try {
            Context m22861j = MBSDKContext.m22865f().m22861j();
            if (m22861j == null) {
                SameLogTool.m21733d(f30197a, "context is null in put");
                return;
            }
            if (this.f30201d && this.f30200c == null) {
                try {
                    this.f30200c = new FastKV.Builder(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f30200c = null;
                }
            }
            FastKV fastKV = this.f30200c;
            if (fastKV != null) {
                try {
                    fastKV.putLong(str, j);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            if (this.f30199b == null) {
                this.f30199b = m22861j.getSharedPreferences("mbridge", 0);
            }
            SharedPreferences.Editor edit = this.f30199b.edit();
            edit.putLong(str, j);
            edit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public final Long m22948a(String str) {
        try {
            Context m22861j = MBSDKContext.m22865f().m22861j();
            if (m22861j == null) {
                SameLogTool.m21733d(f30197a, "context is null in get");
                return 0L;
            }
            if (this.f30201d && this.f30200c == null) {
                try {
                    this.f30200c = new FastKV.Builder(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f30200c = null;
                }
            }
            FastKV fastKV = this.f30200c;
            if (fastKV != null) {
                try {
                    return Long.valueOf(fastKV.getLong(str, 0L));
                } catch (Exception unused2) {
                    return 0L;
                }
            }
            if (this.f30199b == null) {
                this.f30199b = m22861j.getSharedPreferences("mbridge", 0);
            }
            return Long.valueOf(this.f30199b.getLong(str, 0L));
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }
}
