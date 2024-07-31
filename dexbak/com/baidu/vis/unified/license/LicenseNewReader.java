package com.baidu.vis.unified.license;

import android.content.Context;
import android.util.Log;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
class LicenseNewReader {
    public static final String TAG = "License-SDK";

    LicenseNewReader() {
    }

    public static HttpStatus httpPostRequest(Context context, String str, String str2) {
        String str3 = "";
        HttpStatus httpStatus = null;
        try {
            if (!"".equals(str2)) {
                JSONObject jSONObject = new JSONObject(str2);
                str3 = String.format("sdk_v=%s&query=%s", jSONObject.getString("sdk_v"), jSONObject.getString("query"));
            }
            Log.e("License-SDK", "request get_remote_license =" + str);
            httpStatus = HttpUtils.requestPost(str, str3, HttpHeaders.Values.APPLICATION_X_WWW_FORM_URLENCODED, "License-SDK");
            if (httpStatus != null) {
                Log.e("jni", "java result = " + httpStatus.responseStr);
            }
        } catch (Exception e) {
            Log.e("License-SDK", "Exception " + e.getMessage());
            e.printStackTrace();
        }
        return httpStatus;
    }

    public static int readFile(Context context, String str, ArrayList<String> arrayList) {
        if (context == null || str == null || arrayList == null) {
            return -1;
        }
        ArrayList arrayList2 = new ArrayList();
        InputStream inputStream = null;
        ReadStatusCode readStatusCode = new ReadStatusCode();
        readStatusCode.is_from_asset = false;
        try {
            try {
                InputStream inputStream2 = LicenseReaderUtils.get_local_license_file_inputstream(context, str, readStatusCode);
                if (inputStream2 == null) {
                    Log.e("License-SDK", "open license file error.");
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return -1;
                }
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2));
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        arrayList2.add(readLine);
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
                inputStream2.close();
                if (arrayList2.size() > 0) {
                    if (readStatusCode.is_from_asset) {
                        LicenseReaderUtils.write_license_content(context, str, arrayList2);
                    }
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        arrayList.add(str2);
                        Log.e("License-SDK", "license file info =" + str2);
                    }
                }
                return arrayList2.size();
            } catch (FileNotFoundException unused) {
                Log.e("License-SDK", "license file FileNotFoundException " + str);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return -1;
            } catch (IOException unused2) {
                Log.e("License-SDK", "license file IOException " + str);
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return -2;
            } catch (Exception e5) {
                Log.e("License-SDK", "license file Exception " + str + " " + e5.getMessage());
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                return -2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static int writeFile(Context context, String str, String str2) {
        File dir;
        if (context == null || str == null || str2 == null) {
            return -1;
        }
        if (str.startsWith("/")) {
            dir = new File(str);
        } else {
            dir = context.getDir(str, 0);
            Log.e("License-SDK", "put_local_license =" + dir.getAbsolutePath());
        }
        dir.delete();
        if (!dir.exists()) {
            try {
                dir.createNewFile();
            } catch (IOException unused) {
                Log.e("License-SDK", "IOException");
                return -2;
            }
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(dir);
                    try {
                        fileOutputStream2.write(str2.getBytes());
                        fileOutputStream2.close();
                        return 1;
                    } catch (FileNotFoundException e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        Log.e("License-SDK", "FileNotFoundException");
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                            return -1;
                        }
                        return -1;
                    } catch (IOException e2) {
                        e = e2;
                        fileOutputStream = fileOutputStream2;
                        Log.e("License-SDK", "IOException");
                        e.printStackTrace();
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return -2;
                    } catch (Exception unused2) {
                        fileOutputStream = fileOutputStream2;
                        Log.e("License-SDK", "Exception");
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        return -2;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e4) {
                    e = e4;
                } catch (IOException e5) {
                    e = e5;
                } catch (Exception unused3) {
                }
            } catch (IOException e6) {
                e6.printStackTrace();
                return -2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
