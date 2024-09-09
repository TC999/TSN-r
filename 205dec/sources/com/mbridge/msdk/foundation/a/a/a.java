package com.mbridge.msdk.foundation.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.x;

/* compiled from: SharedPerferenceManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39024a = "a";

    /* renamed from: e  reason: collision with root package name */
    private static a f39025e;

    /* renamed from: b  reason: collision with root package name */
    SharedPreferences f39026b;

    /* renamed from: c  reason: collision with root package name */
    FastKV f39027c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f39028d = b.a().d();

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f39025e == null) {
                f39025e = new a();
            }
            aVar = f39025e;
        }
        return aVar;
    }

    public final int b(String str, int i4) {
        try {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            if (j4 == null) {
                return i4;
            }
            if (this.f39028d && this.f39027c == null) {
                try {
                    this.f39027c = new FastKV.Builder(e.b(c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f39027c = null;
                }
            }
            FastKV fastKV = this.f39027c;
            if (fastKV != null) {
                try {
                    return fastKV.getInt(str, i4);
                } catch (Exception unused2) {
                    return i4;
                }
            }
            if (this.f39026b == null) {
                this.f39026b = j4.getSharedPreferences("mbridge", 0);
            }
            return this.f39026b.getInt(str, i4);
        } catch (Exception e4) {
            e4.printStackTrace();
            return i4;
        }
    }

    public final void c(String str) {
        Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
        if (j4 == null) {
            return;
        }
        if (this.f39028d && this.f39027c == null) {
            try {
                this.f39027c = new FastKV.Builder(e.b(c.MBRIDGE_700_CONFIG), "mbridge").build();
            } catch (Exception unused) {
                this.f39027c = null;
            }
        }
        FastKV fastKV = this.f39027c;
        if (fastKV != null) {
            try {
                fastKV.remove(str);
                return;
            } catch (Exception unused2) {
                return;
            }
        }
        if (this.f39026b == null) {
            this.f39026b = j4.getSharedPreferences("mbridge", 0);
        }
        this.f39026b.edit().remove(str).apply();
    }

    public final void a(String str, String str2) {
        try {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            if (j4 == null) {
                return;
            }
            if (this.f39028d && this.f39027c == null) {
                try {
                    this.f39027c = new FastKV.Builder(e.b(c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f39027c = null;
                }
            }
            FastKV fastKV = this.f39027c;
            if (fastKV != null) {
                try {
                    fastKV.putString(str, str2);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            if (this.f39026b == null) {
                this.f39026b = j4.getSharedPreferences("mbridge", 0);
            }
            SharedPreferences.Editor edit = this.f39026b.edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final String b(String str) {
        try {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            if (j4 == null) {
                return null;
            }
            if (this.f39028d && this.f39027c == null) {
                try {
                    this.f39027c = new FastKV.Builder(e.b(c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f39027c = null;
                }
            }
            FastKV fastKV = this.f39027c;
            if (fastKV != null) {
                try {
                    return fastKV.getString(str, "");
                } catch (Exception unused2) {
                    return "";
                }
            }
            if (this.f39026b == null) {
                this.f39026b = j4.getSharedPreferences("mbridge", 0);
            }
            return this.f39026b.getString(str, "");
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public final void a(String str, int i4) {
        try {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            if (j4 == null) {
                return;
            }
            if (this.f39028d && this.f39027c == null) {
                try {
                    this.f39027c = new FastKV.Builder(e.b(c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f39027c = null;
                }
            }
            FastKV fastKV = this.f39027c;
            if (fastKV != null) {
                try {
                    fastKV.putInt(str, i4);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            if (this.f39026b == null) {
                this.f39026b = j4.getSharedPreferences("mbridge", 0);
            }
            SharedPreferences.Editor edit = this.f39026b.edit();
            edit.putInt(str, i4);
            edit.apply();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final void a(String str, long j4) {
        try {
            Context j5 = com.mbridge.msdk.foundation.controller.a.f().j();
            if (j5 == null) {
                x.d(f39024a, "context is null in put");
                return;
            }
            if (this.f39028d && this.f39027c == null) {
                try {
                    this.f39027c = new FastKV.Builder(e.b(c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f39027c = null;
                }
            }
            FastKV fastKV = this.f39027c;
            if (fastKV != null) {
                try {
                    fastKV.putLong(str, j4);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            }
            if (this.f39026b == null) {
                this.f39026b = j5.getSharedPreferences("mbridge", 0);
            }
            SharedPreferences.Editor edit = this.f39026b.edit();
            edit.putLong(str, j4);
            edit.apply();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public final Long a(String str) {
        try {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            if (j4 == null) {
                x.d(f39024a, "context is null in get");
                return 0L;
            }
            if (this.f39028d && this.f39027c == null) {
                try {
                    this.f39027c = new FastKV.Builder(e.b(c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.f39027c = null;
                }
            }
            FastKV fastKV = this.f39027c;
            if (fastKV != null) {
                try {
                    return Long.valueOf(fastKV.getLong(str, 0L));
                } catch (Exception unused2) {
                    return 0L;
                }
            }
            if (this.f39026b == null) {
                this.f39026b = j4.getSharedPreferences("mbridge", 0);
            }
            return Long.valueOf(this.f39026b.getLong(str, 0L));
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0L;
        }
    }
}
