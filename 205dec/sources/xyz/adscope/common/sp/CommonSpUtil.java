package xyz.adscope.common.sp;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CommonSpUtil {
    public static void clear(Context context) {
        if (context == null) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ad_scope_config", 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.apply();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean contains(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ad_scope_config", 0);
            if (sharedPreferences != null) {
                return sharedPreferences.contains(str);
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static Object get(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences("ad_scope_config", 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (sharedPreferences == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Set) {
            return sharedPreferences.getStringSet(str, (Set) obj);
        }
        return null;
    }

    public static Object get(Context context, String str, String str2, Object obj) {
        SharedPreferences sharedPreferences;
        if (context == null) {
            return null;
        }
        try {
            sharedPreferences = context.getSharedPreferences(str, 0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (sharedPreferences == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str2, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str2, ((Float) obj).floatValue()));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str2, ((Integer) obj).intValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str2, ((Long) obj).longValue()));
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str2, (String) obj);
        }
        if (obj instanceof Set) {
            return sharedPreferences.getStringSet(str2, (Set) obj);
        }
        return null;
    }

    public static Map<String, ?> getAll(Context context) {
        if (context == null) {
            return null;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ad_scope_config", 0);
            if (sharedPreferences != null) {
                return sharedPreferences.getAll();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static String getString(Context context, String str) {
        if (context != null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("ad_scope_config", 0);
                if (sharedPreferences == null) {
                    return null;
                }
                return sharedPreferences.getString(str, "");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static String getString(Context context, String str, String str2) {
        if (context != null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
                if (sharedPreferences == null) {
                    return null;
                }
                return sharedPreferences.getString(str2, "");
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static String getUpdated(Context context, String str) {
        try {
            return context.getSharedPreferences("ad_scope_config", 0).getString(str, String.valueOf(System.currentTimeMillis() / 1000));
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static void put(Context context, String str, Object obj) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ad_scope_config", 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (obj instanceof Boolean) {
                    edit.putBoolean(str, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Float) {
                    edit.putFloat(str, ((Float) obj).floatValue());
                } else if (obj instanceof Integer) {
                    edit.putInt(str, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    edit.putLong(str, ((Long) obj).longValue());
                } else if (obj instanceof String) {
                    edit.putString(str, (String) obj);
                } else if (obj instanceof Set) {
                    edit.remove(str);
                    edit.putStringSet(str, (Set) obj);
                }
                edit.commit();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void putCommit(Context context, String str, String str2, Object obj) {
        if (context == null) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (obj instanceof Boolean) {
                    edit.putBoolean(str2, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Float) {
                    edit.putFloat(str2, ((Float) obj).floatValue());
                } else if (obj instanceof Integer) {
                    edit.putInt(str2, ((Integer) obj).intValue());
                } else if (obj instanceof Long) {
                    edit.putLong(str2, ((Long) obj).longValue());
                } else if (obj instanceof String) {
                    edit.putString(str2, (String) obj);
                } else if (obj instanceof Set) {
                    edit.remove(str2);
                    edit.putStringSet(str2, (Set) obj);
                }
                edit.commit();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void putString(Context context, String str, String str2) {
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("ad_scope_config", 0).edit();
                edit.putString(str, str2);
                edit.commit();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void putString(Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
                edit.putString(str2, str3);
                edit.commit();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void remove(Context context, String str) {
        if (context == null) {
            return;
        }
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("ad_scope_config", 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove(str);
                edit.apply();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void saveUpdated(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences("ad_scope_config", 0).edit();
            edit.putString(str, str2);
            edit.commit();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
