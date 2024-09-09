package com.baidu.vis.unified.license;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class LicenseReaderUtils {
    public static final String TAG = "License-SDK";

    LicenseReaderUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0026 -> B:34:0x008a). Please submit an issue!!! */
    public static String getSuccessInfo(Context context, String str) {
        String str2 = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            FileInputStream read_license_from_data = read_license_from_data(context, str);
            try {
            } catch (IOException e4) {
                e4.printStackTrace();
                read_license_from_data = e4;
            }
            if (read_license_from_data != null) {
                try {
                    try {
                        try {
                            try {
                                str2 = new BufferedReader(new InputStreamReader(read_license_from_data)).readLine();
                                read_license_from_data.close();
                                read_license_from_data = read_license_from_data;
                            } catch (Throwable th) {
                                try {
                                    read_license_from_data.close();
                                } catch (IOException e5) {
                                    e5.printStackTrace();
                                }
                                throw th;
                            }
                        } catch (FileNotFoundException unused) {
                            Log.e("License-SDK", "reade_success_content FileNotFoundException " + str);
                            read_license_from_data.close();
                            read_license_from_data = read_license_from_data;
                        }
                    } catch (IOException unused2) {
                        Log.e("License-SDK", "reade_success_content IOException " + str);
                        read_license_from_data.close();
                        read_license_from_data = read_license_from_data;
                    }
                } catch (Exception e6) {
                    Log.e("License-SDK", "reade_success_content Exception " + str + " " + e6.getMessage());
                    read_license_from_data.close();
                    read_license_from_data = read_license_from_data;
                }
            }
        }
        return str2;
    }

    public static InputStream get_local_license_file_inputstream(Context context, String str, ReadStatusCode readStatusCode) {
        FileInputStream read_license_from_data;
        if (context == null) {
            return null;
        }
        readStatusCode.is_from_asset = false;
        if (str.startsWith(TTPathConst.sSeparator)) {
            read_license_from_data = read_license_from_system_path(str);
        } else {
            read_license_from_data = read_license_from_data(context, str);
        }
        if (read_license_from_data == null) {
            Log.e("License-SDK", "read_license_from_asset");
            InputStream read_license_from_asset = read_license_from_asset(context, str);
            readStatusCode.is_from_asset = true;
            return read_license_from_asset;
        }
        return read_license_from_data;
    }

    private static ArrayList<String> read_license_content(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<String> arrayList = new ArrayList<>();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    private static InputStream read_license_from_asset(Context context, String str) {
        if (context == null) {
            Log.e("License-SDK", "read_license_from_asset context is null");
            return null;
        }
        try {
            return context.getAssets().open(str);
        } catch (IOException e4) {
            Log.e("License-SDK", "read_license_from_asset IOException");
            e4.printStackTrace();
            return null;
        } catch (Exception e5) {
            Log.e("License-SDK", "read_license_from_asset Exception " + e5.getMessage());
            e5.printStackTrace();
            return null;
        }
    }

    private static FileInputStream read_license_from_data(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            File dir = context.getDir(str, 0);
            if (dir != null && dir.exists() && dir.isFile()) {
                if (dir.length() == 0) {
                    Log.e("License-SDK", "read_license_from_data file is empty");
                    return null;
                }
                return new FileInputStream(dir);
            }
            Log.e("License-SDK", "read_license_from_data file not found");
            return null;
        } catch (FileNotFoundException e4) {
            Log.e("License-SDK", "read_license_from_data FileNotFoundException");
            e4.printStackTrace();
            return null;
        } catch (Exception e5) {
            Log.e("License-SDK", "read_license_from_data Exception " + e5.getMessage());
            e5.printStackTrace();
            return null;
        }
    }

    private static FileInputStream read_license_from_system_path(String str) {
        try {
            return new FileInputStream(new File(str));
        } catch (FileNotFoundException e4) {
            Log.e("License-SDK", "read_license_from_system_path FileNotFoundException");
            e4.printStackTrace();
            return null;
        }
    }

    public static int setSuccessInfo(Context context, String str, String str2) {
        int i4 = -1;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return -1;
        }
        File dir = context.getDir(str, 0);
        if (dir != null && dir.exists()) {
            dir.delete();
        }
        if (dir != null && !dir.exists()) {
            try {
                dir.createNewFile();
            } catch (IOException e4) {
                Log.e("License-SDK", "write_success_info_content IOException");
                e4.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(dir);
                    try {
                        fileOutputStream2.write(str2.getBytes());
                        fileOutputStream2.write(10);
                        fileOutputStream2.close();
                        i4 = 0;
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        fileOutputStream = fileOutputStream2;
                        Log.e("License-SDK", "write_success_content FileNotFoundException");
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return i4;
                    } catch (IOException e6) {
                        e = e6;
                        fileOutputStream = fileOutputStream2;
                        Log.e("License-SDK", "write_success_content IOException");
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return i4;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e8) {
                    e = e8;
                } catch (IOException e9) {
                    e = e9;
                }
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            return i4;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean write_license_content(Context context, String str, ArrayList<String> arrayList) {
        Log.e("License-SDK", "write_license_content");
        boolean z3 = false;
        if (arrayList == null || arrayList.size() == 0 || context == null) {
            return false;
        }
        File dir = context.getDir(str, 0);
        if (dir != null && dir.exists()) {
            dir.delete();
        }
        if (dir != null && !dir.exists()) {
            try {
                dir.createNewFile();
            } catch (IOException e4) {
                Log.e("License-SDK", "write_license_content IOException");
                e4.printStackTrace();
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(dir);
                    try {
                        Iterator<String> it = arrayList.iterator();
                        while (it.hasNext()) {
                            fileOutputStream2.write(it.next().getBytes());
                            fileOutputStream2.write(10);
                        }
                        fileOutputStream2.close();
                        z3 = true;
                    } catch (FileNotFoundException e5) {
                        e = e5;
                        fileOutputStream = fileOutputStream2;
                        Log.e("License-SDK", "write_license_content FileNotFoundException");
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return z3;
                    } catch (IOException e6) {
                        e = e6;
                        fileOutputStream = fileOutputStream2;
                        Log.e("License-SDK", "write_license_content IOException");
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return z3;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e8) {
                    e = e8;
                } catch (IOException e9) {
                    e = e9;
                }
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            return z3;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
