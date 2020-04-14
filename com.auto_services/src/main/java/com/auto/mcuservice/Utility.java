package com.auto.mcuservice;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.util.Log;

import com.auto.constant.McuConstant;

import java.util.Iterator;
import java.util.List;

import com.auto.setting.SettingService;

public class Utility implements McuConstant, McuConstant.McuSourceIndex {
    static final char[] crc_ta = new char[] {
            0x0000, 0x1021, 0x2042, 0x3063, 0x4084, 0x50a5, 0x60c6, 0x70e7, 0x8108, 0x9129, 0xa14a, 0xb16b, 0xc18c, 0xd1ad, 0xe1ce, 0xf1ef,
            0x1231, 0x0210, 0x3273, 0x2252, 0x52b5, 0x4294, 0x72f7, 0x62d6, 0x9339, 0x8318, 0xb37b, 0xa35a, 0xd3bd, 0xc39c, 0xf3ff, 0xe3de,
            0x2462, 0x3443, 0x0420, 0x1401, 0x64e6, 0x74c7, 0x44a4, 0x5485, 0xa56a, 0xb54b, 0x8528, 0x9509, 0xe5ee, 0xf5cf, 0xc5ac, 0xd58d,
            0x3653, 0x2672, 0x1611, 0x0630, 0x76d7, 0x66f6, 0x5695, 0x46b4, 0xb75b, 0xa77a, 0x9719, 0x8738, 0xf7df, 0xe7fe, 0xd79d, 0xc7bc,
            0x48c4, 0x58e5, 0x6886, 0x78a7, 0x0840, 0x1861, 0x2802, 0x3823, 0xc9cc, 0xd9ed, 0xe98e, 0xf9af, 0x8948, 0x9969, 0xa90a, 0xb92b,
            0x5af5, 0x4ad4, 0x7ab7, 0x6a96, 0x1a71, 0x0a50, 0x3a33, 0x2a12, 0xdbfd, 0xcbdc, 0xfbbf, 0xeb9e, 0x9b79, 0x8b58, 0xbb3b, 0xab1a,
            0x6ca6, 0x7c87, 0x4ce4, 0x5cc5, 0x2c22, 0x3c03, 0x0c60, 0x1c41, 0xedae, 0xfd8f, 0xcdec, 0xddcd, 0xad2a, 0xbd0b, 0x8d68, 0x9d49,
            0x7e97, 0x6eb6, 0x5ed5, 0x4ef4, 0x3e13, 0x2e32, 0x1e51, 0x0e70, 0xff9f, 0xefbe, 0xdfdd, 0xcffc, 0xbf1b, 0xaf3a, 0x9f59, 0x8f78,
            0x9188, 0x81a9, 0xb1ca, 0xa1eb, 0xd10c, 0xc12d, 0xf14e, 0xe16f, 0x1080, 0x00a1, 0x30c2, 0x20e3, 0x5004, 0x4025, 0x7046, 0x6067,
            0x83b9, 0x9398, 0xa3fb, 0xb3da, 0xc33d, 0xd31c, 0xe37f, 0xf35e, 0x02b1, 0x1290, 0x22f3, 0x32d2, 0x4235, 0x5214, 0x6277, 0x7256,
            0xb5ea, 0xa5cb, 0x95a8, 0x8589, 0xf56e, 0xe54f, 0xd52c, 0xc50d, 0x34e2, 0x24c3, 0x14a0, 0x0481, 0x7466, 0x6447, 0x5424, 0x4405,
            0xa7db, 0xb7fa, 0x8799, 0x97b8, 0xe75f, 0xf77e, 0xc71d, 0xd73c, 0x26d3, 0x36f2, 0x0691, 0x16b0, 0x6657, 0x7676, 0x4615, 0x5634,
            0xd94c, 0xc96d, 0xf90e, 0xe92f, 0x99c8, 0x89e9, 0xb98a, 0xa9ab, 0x5844, 0x4865, 0x7806, 0x6827, 0x18c0, 0x08e1, 0x3882, 0x28a3,
            0xcb7d, 0xdb5c, 0xeb3f, 0xfb1e, 0x8bf9, 0x9bd8, 0xabbb, 0xbb9a, 0x4a75, 0x5a54, 0x6a37, 0x7a16, 0x0af1, 0x1ad0, 0x2ab3, 0x3a92,
            0xfd2e, 0xed0f, 0xdd6c, 0xcd4d, 0xbdaa, 0xad8b, 0x9de8, 0x8dc9, 0x7c26, 0x6c07, 0x5c64, 0x4c45, 0x3ca2, 0x2c83, 0x1ce0, 0x0cc1,
            0xef1f, 0xff3e, 0xcf5d, 0xdf7c, 0xaf9b, 0xbfba, 0x8fd9, 0x9ff8, 0x6e17, 0x7e36, 0x4e55, 0x5e74, 0x2e93, 0x3eb2, 0x0ed1, 0x1ef0
    };

    public static final String[] mAppClasses = new String[] {
            "android.dgl.radio.RadioMain",
            "android.dgl.btclient.hfp.customer.MainActivity",
            "android.dgl.btclient.music.MainActivity",
            "android.dgl.mediaplayer.MediaActivity.MusicPlayerUiActivity",
            "android.dgl.mediaplayer.MediaActivity.VideoPlayerUiActivity",
            null,
            "android.dgl.backcar.auxin.AuxInRearActivity",
            "android.dgl.backcar.auxin.AuxInRearActivity",
            "com.dgl.autocmmb.CmmbMain"
    };
    public static final String[] mAppPackages = new String[] {
            "android.dgl.radio",
            "android.dgl.btclient.hfp",
            "android.dgl.btclient.music",
            "android.dgl.mediaplayer",
            "android.dgl.mediaplayer",
            "com.autonavi.xmgd.navigator",
            "android.dgl.backcar",
            "android.dgl.backcar",
            "com.dgl.autocmmb",
            "com.goodocom.gocsdk",
            "android.dgl.backcar",
            "com.dgl.autocan",
            "com.dgl.autodvr"
    };

    private static Context mContext = null;

    public static boolean init(Context context) {
        mContext = context;
        return true;
    }

    public static char CalculateCRC(byte[] buff, int nLength) {
        char crc = 0x0000;

        for (int i = 0; i < nLength; i++) {
            byte da = (byte)(crc / 256);
            char c = (char)(crc << 8);
            crc = (char)(crc_ta[(buff[i] ^ da) & 0xFF] ^ c);
        }
        return crc;
    }

    public static byte HiByte(char word) {
        return (byte)(word >> 8 & 0xFF);
    }

    public static byte LoByte(char word) {
        return (byte)word;
    }

    public static char MakeWord(byte byte1, byte byte2) {
        int i = byte1 & 0xFF;
        int j = byte2 & 0xFF;
        return (char)((j << 8 | i) & 0xFFFF);
    }

    public static byte getData(byte b, int begin, int end) {
        // TODO: Doesn't really understand what this do...
        byte dataTemp = 1;
        for (int i = 1; i < end - begin + 1; i++)
            dataTemp = (byte)(1 << i | dataTemp);
        return (byte)((byte)(b >> begin) & dataTemp);
    }

    public static boolean isServiceRunning(String className) {
        boolean bool = false;
        List list = ((ActivityManager)mContext.getSystemService(Context.ACTIVITY_SERVICE)).getRunningServices(50);
        if (list.size() <= 0) { return false; }

        for (int i = 0; i < list.size() ; i++) {
            if (list.get(i) != null && ((ActivityManager.RunningServiceInfo)list.get(i)).service != null && ((ActivityManager.RunningServiceInfo)list.get(i)).service.getClassName().equals(className) == true) {
                return true;
            }
        }

        return false;
    }

    public static boolean isPkgInstalled(String packageName) {
        try {
            PackageInfo packageInfo = mContext.getPackageManager().getPackageInfo(packageName, 0);
            if (packageInfo == null) { return false; }
        } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean isAppTopRunning(String packageName) {
        boolean bool1;
        boolean bool2 = false;
        Iterator<ActivityManager.RunningTaskInfo> iterator = ((ActivityManager)mContext.getSystemService(Context.ACTIVITY_SERVICE)).getRunningTasks(1).iterator();
        while (iterator.hasNext()) {
            ActivityManager.RunningTaskInfo runningTaskInfo = iterator.next();
            if (runningTaskInfo != null && runningTaskInfo.topActivity != null && runningTaskInfo.topActivity.getPackageName().equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    public static void RunApp(String packageName, String className) {
        if (!isPkgInstalled(packageName)) {
            Log.i("Utility", packageName + "is not installed");
            return;
        }
        if (!mAppPackages[5].equals(packageName) || !isAppTopRunning(packageName)) {
            if (className != null) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setComponent(new ComponentName(packageName, className));
                mContext.startActivity(intent);
            } else {
                try {
                    PackageInfo packageInfo = mContext.getPackageManager().getPackageInfo(packageName, 0);
                    Intent intent = new Intent("android.intent.action.MAIN", null);
                    intent.setPackage(packageInfo.packageName);
                    ResolveInfo resolveInfo = mContext.getPackageManager().queryIntentActivities(intent, 0).iterator().next();
                    if (resolveInfo != null) {
                        String str1 = resolveInfo.activityInfo.packageName;
                        String str2 = resolveInfo.activityInfo.name;
                        Intent intent1 = new Intent("android.intent.action.MAIN");
                        intent1.addCategory("android.intent.category.LAUNCHER");
                        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent1.setComponent(new ComponentName(str1, str2));
                        mContext.startActivity(intent1);
                    }
                } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
                    nameNotFoundException.printStackTrace();
                } catch (Exception exception) {
                    Log.e("Utility", "RunApp erre-->" + exception);
                    exception.printStackTrace();
                }
            }
        }
    }

    public static void turnMode(int nMode) {
        String str;
        switch (nMode) {
            case 0:
                RunApp(mAppPackages[0], mAppClasses[0]);
                break;
            case 1:
                RunApp(mAppPackages[3], mAppClasses[3]);
                break;
            case 2:
                RunApp(mAppPackages[4], mAppClasses[4]);
                break;
            case 4:
                try {
                    RunApp(SettingService.getInstance().getNaviPackageName(), null);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                break;
            case 5:
                RunApp(mAppPackages[7], mAppClasses[7]);
                break;
            case 6:
                RunApp(mAppPackages[6], mAppClasses[6]);
                break;
            case 7:
                RunApp(mAppPackages[8], mAppClasses[8]);
                break;
            case 9:
                RunApp(mAppPackages[1], mAppClasses[1]);
                break;
            case 10:
                RunApp(mAppPackages[2], mAppClasses[2]);
                break;
        }
    }

    public static int mapMcuModeToAppMode(int mcuMode) {
        switch (mcuMode) {
            case 0:
                return 0;
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 1;
            case 5:
                return 11;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case 9:
                return 7;
            case 13:
                return 9;
            case 15:
                return 1;
            case 16:
                return 2;
            case 21:
                return 10;
            case 20:
                return 13;
            default:
                return 0;
        }
    }

    public static int byteToInt(byte b) {
        return b & 0xFF;
    }
}
