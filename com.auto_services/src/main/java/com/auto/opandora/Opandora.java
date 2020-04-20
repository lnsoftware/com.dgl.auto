package com.auto.opandora;

import android.app.Instrumentation;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.storage.StorageManager;
import android.os.storage.IMountService;
import android.util.Log;

import com.auto.autoevent.AutoEvent;
import com.auto.mcuservice.McuService;
import com.auto.mcuservice.Utility;
import com.auto.setting.SettingService;
import com.auto.source.McuCBMService;
import com.dgl.auto.constant.CallbackConstant;

import java.util.ArrayList;
import java.util.Iterator;

import static com.auto.constant.McuConstant.HostCmd.CMD_SND_SHUTDOWN_BK;

public class Opandora extends IOpandora.Stub implements CallbackConstant.OpandoraCallbackConstant, CallbackConstant.OpandoraKeyIndex, CallbackConstant.KeyStatus, CallbackConstant.KeySource {
    // TODO: Complete
    private final class FilterHandler extends Handler {

    }

    private static Opandora sInstance = null;
    private Context mContext = null;
    private final ArrayList<IOpandoraCallback> mCallBacks = new ArrayList<IOpandoraCallback>();
    private McuService mMcuService = null;
    private SettingService mSettingService = null;
    private AudioManager mAudioManager = null;
    private FilterHandler mFilterHandler = new FilterHandler();
    private McuCBMService mMcuCBMService = null;
    private StorageManager mStorageManager = null;
    private IMountService mMountService = null;
    private boolean m_bPendingPowerOff = false;
    private boolean m_bPowerOff = false;
    private boolean mbwifiState = false;

    public static Opandora getInstance() {
        if (sInstance == null) { sInstance = new Opandora(); }
        return sInstance;
    }

    boolean ignoreSomeKeys(int nKeyCode, int nKeyStatus) {
        return false;
    }
    void processKey(int nKeyCode, int nKeyStatus, int nKeySrc) {
        boolean bool = true;
        Log.v("Opandora", "keyCode-" + Integer.toString(nKeyCode) + "keyStatus-" + Integer.toString(nKeyStatus) + "nKeySrc-" + Integer.toString(nKeySrc));
        if (tellMcuOpenBKLight()) { ; }
        if (nKeyCode == KEY_POWER) {
            mMcuService.SndCmd(21, 11);
            return;
        }
        if (!hookSomeKey(nKeyCode) && !m_bPendingPowerOff && (!m_bPowerOff || nKeyCode == 1)) {
            if (isUserKeyCode(nKeyCode))
                broadCastKeyEvent(nKeyCode, nKeyStatus, nKeySrc);
            switch (nKeyCode) {
                case 2:
                case 3:
                case 6:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 15:
                case 16:
                case 19:
                case 20:
                case 22:
                case 24:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 55:
                case 56:
                case 58:
                case 61:
                case 62:
                case 64:
                case 66:
                case 67:
                case 68:
                case 69:
                case 158:
                case 159:
                    break;
                case KEY_POWER:
                    if (!m_bPowerOff) { return; }
                case KEY_MUTE:
                    try {
                        MuteSystem(!mSettingService.isMcuMute());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case KEY_RETURN:
                    simulateKeystroke(4);
                    break;
                case KEY_VOL_DEC:
                    decvolume();
                    break;
                case KEY_VOL_ADD:
                    addvolume();
                    return;
                case KEY_MENU:
                    simulateKeystroke(82);
                    break;
                case KEY_SEEK_UP:
                    simulateKeystroke(88);
                    break;
                case KEY_SEEK_DOWN:
                    simulateKeystroke(87);
                    break;
                case KEY_BAND:
                    if (getCurAppUIMode() != 0) {
                        broadcastAppMode(0);
                    } else {
                        mMcuService.SndCmd(21, 6);
                    }
                    break;
                case KEY_REPEAT:
                    simulateKeystroke(89);
                    break;
                case KEY_EQ:
                    broadcastShowEQ();
                    break;
                case KEY_NAV:
                    broadcastAppMode(4);
                    break;
                case KEY_VERSION:
                    mFilterHandler.sendEmptyMessage(12);
                    break;
                case KEY_UICC_PLAY_PAUSE:
                    simulateKeystroke(85);
                    break;
                case KEY_UICC_RETURN:
                    simulateKeystroke(4);
                    break;
                case KEY_UICC_TEST_PARKING_ON:
                    mFilterHandler.sendEmptyMessage(14);
                    break;
                case KEY_UICC_A2DP:
                    broadcastAppMode(10);
                    break;
                case KEY_UICC_TIME_SET:
                    mFilterHandler.sendEmptyMessage(13);
                    break;
                case KEY_UICC_HOME:
                    simulateKeystroke(3);
                    break;
            }
        }
    }

    private boolean tellMcuOpenBKLight() {
        if (McuService.getMcuService().getMcuInfo().getmCurrentBKStatus().getmBKStatus() == 1) {
            mMcuService.SndCmd(CMD_SND_SHUTDOWN_BK);
            return true;
        }
        return false;
    }
    private boolean hookSomeKey(int nKeyCode) {
        // TODO: Fix
        switch (nKeyCode) {
            default:
                switch (nKeyCode) {
                    default:
                        return false;
                    case 25:
                        break;
                }
                break;
            case 1:
            case 25:
                if (mMcuCBMService.isInCalling())
                    return true;
        }
        try {
            if (AutoEvent.getInstance().isInBackcar()) { return true; }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false; //?????
    }
    private boolean isUserKeyCode(int nKeyCode) {
        switch (nKeyCode) {
            case KEY_POWER:
            case KEY_VOL_DEC:
            case KEY_VOL_ADD:
                return false;
            default:
                return true;
        }
    }
    private void broadCastKeyEvent(int nKeyCode, int nKeyStatus, int nKeySrc) {
        Bundle bundle = new Bundle();
        bundle.putInt("AutoKeyCode", nKeyCode);
        bundle.putInt("AutoKeyStatus", nKeyStatus);
        bundle.putInt("KEY_SRC", nKeySrc);
        Intent intent = new Intent("AutoActionKeyEvent");
        intent.putExtra("KeyInfo", bundle);
        if (this.mContext != null)
            this.mContext.sendBroadcast(intent);
    }
    private void simulateKeystroke(final int KeyCode) {
        (new Thread(new Runnable() {
            public void run() {
                try {
                    (new Instrumentation()).sendKeyDownUpSync(KeyCode);
                    return;
                } catch (Exception e) {
                    Log.e("Opandora", e.toString());
                    return;
                }
            }
        })).start();
    }
    private void MuteSystem(boolean paramBoolean) {
        try {
            mSettingService.setMcuMute(paramBoolean ? 1 : 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void decvolume() {
        if (mSettingService != null)
            try {
                int j = mSettingService.getMcuVol();
                int i = j;
                if (j > 0)
                    i = j - 1;
                mSettingService.setMcuVol(i);
                SetArmVol(i);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
    }
    private void addvolume() {
        if (mSettingService != null)
            try {
                int j = mSettingService.getMcuVol();
                int i = j;
                if (j < 40)
                    i = j + 1;
                mSettingService.setMcuVol(i);
                SetArmVol(i);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
    }
    private void SetArmVol(int vol) {
        if (mAudioManager == null)
            mAudioManager = (AudioManager)mContext.getSystemService(Context.AUDIO_SERVICE);
        mAudioManager.setStreamVolume(3, vol, 1);
    }
    private void broadcastShowEQ() {
        Log.v("Opandora", "broadcastShowEQ");
        Intent intent = new Intent("autochips.intent.action.ACTION_SHOW_EQ");
        if (this.mContext != null)
            this.mContext.sendBroadcast(intent);
    }
    private void broadcastAppMode(int paramInt) {
        Intent intent = new Intent("com.dgl.autosource.AppMode");
        intent.putExtra("APPMODE", paramInt);
        if (this.mContext != null)
            this.mContext.sendBroadcast(intent);
    }
    private int getCurAppUIMode() {
        return mMcuCBMService.getNormalAppMode();
    }
    private void onPowerStatus(boolean paramBoolean) {
        m_bPowerOff = paramBoolean;
        if (!paramBoolean && mSettingService != null)
            try {
                mSettingService.isMcuMute();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
    }
    private void onPendPowerStatus(boolean paramBoolean) {
        mSettingService.saveSysemConfig();
        SetPendingPowerOffStatus(paramBoolean);
        if (paramBoolean)
            checkAndUnmuteSystem();
    }
    public void SetPendingPowerOffStatus(boolean paramBoolean) {
        m_bPendingPowerOff = paramBoolean;
    }
    private void checkAndUnmuteSystem() {
        if (mSettingService != null) {
            try {
                if (mSettingService.isMcuMute()) {
                    MuteSystem(false);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    public void HandleReInitTouch() {}
    public void HandleSleep() {
        Log.e("Opandora", "McuService HandleSleep begin");
        try {
            if (mSettingService.getMcuVol() >= 15)
                mSettingService.setMcuVol(15);
            Utility.KillNaviForSleep();
            Log.e("Opandora", "McuService HandleSleep 11111111111111");
            Utility.KillEasyconnForSleep();
            Log.e("Opandora", "McuService HandleSleep 22222222222222");
            Utility.KillGoogleForSleep();
            Log.e("Opandora", "McuService HandleSleep 333333333333333");
            mFilterHandler.removeMessages(5);
            mMcuService.SndCmd(11, 0);
            Utility.KillThirdApp();
            Log.e("Opandora", "McuService HandleSleep 4444444444444444");
            getWifiStatus();
            if (mbwifiState)
                SetWifiStatus(false);
            SetBtStatus(false);
            Log.e("Opandora", "McuService HandleSleep 55555555555555555");
            broadcastWakeStatus(false);
            Log.e("Opandora", "McuService HandleSleep 666666666666666666");
            HandleStorageUnMount();
            Log.e("Opandora", "McuService HandleSleep 77777777777777777777");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        Log.e("Opandora", "HandleSleep end");
    }
    public void HandleWakeUp() {
        mbwifiState = SystemProperties.get("persist.sys.mbwifiState", "fail").equals("true");
        if (mbwifiState)
            SetWifiStatus(true);
        SetBtStatus(true);
        broadcastWakeStatus(true);
        mFilterHandler.removeMessages(7);
        mFilterHandler.sendEmptyMessageDelayed(7, 4000L);
        Log.e("Opandora", "HandleWakeUp");
    }
    private void getWifiStatus() {
        WifiManager wifiManager = (WifiManager)mContext.getSystemService(Context.WIFI_SERVICE);
        if (wifiManager != null) {
            if (wifiManager.getWifiState() > 1) {
                mbwifiState = true;
                SystemProperties.set("persist.sys.mbwifiState", "true");
            } else {
                mbwifiState = false;
                SystemProperties.set("persist.sys.mbwifiState", "false");
            }
            Log.e("Opandora", "getWifiStatus=" + i);
        }
    }
    private void SetWifiStatus(boolean paramBoolean) {
        WifiManager wifiManager = (WifiManager)this.mContext.getSystemService(Context.WIFI_SERVICE);
        if (wifiManager != null) {
            int i = wifiManager.getWifiApState();
            if ((paramBoolean && i == 12) || i == 13)
                wifiManager.setWifiApEnabled(null, false);
            wifiManager.setWifiEnabled(paramBoolean);
            // TODO: Fix
            i = 0;
            while (true) {
                if (!paramBoolean && wifiManager.getWifiState() > 1 && i < 50) {
                    i++;
                    try {
                        Thread.sleep(100L);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    continue;
                }
                return;
            }
        }
    }
    public void SetBtStatus(boolean paramBoolean) {
        // TODO: Fix
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter != null) {
            if (paramBoolean) {
                bluetoothAdapter.enable();
                return;
            }
            if (bluetoothAdapter.isEnabled())
                bluetoothAdapter.disable();
            try {
                Thread.sleep(200L);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            int i = 0;
            while (true) {
                if (bluetoothAdapter.isEnabled() && i < 50) {
                    i++;
                    try {
                        Thread.sleep(100L);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    continue;
                }
                return;
            }
        }
    }
    private void broadcastWakeStatus(boolean paramBoolean) {
        Intent intent;
        if (paramBoolean) {
            intent = new Intent("autochips.intent.action.QB_POWERON");
        } else {
            intent = new Intent("autochips.intent.action.QB_POWEROFF");
        }
        if (this.mContext != null)
            this.mContext.sendBroadcast(intent);
        Log.w("Opandora", "broadcastWakeStatus [" + paramBoolean + "]");
    }
    public void HandleStorageUnMount() {
        Log.e("Opandora", "HandleStorageUnMount in");
        if (mStorageManager == null && mContext != null)
            mStorageManager = (StorageManager)mContext.getSystemService(Context.STORAGE_SERVICE);
        if (mStorageManager != null) {
            String[] mountPoints = null;
            try {
                mountPoints = mStorageManager.getVolumePaths();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            if (mountPoints != null) {
                for (int i = 0; i < mountPoints.length; i++) {
                    if (mountPoints[i].startsWith("/storage/usbotg"))
                        UnMount(mountPoints[i]);
                    }
            }
        }
    }
    public void UnMount(String paramString) {
        if (mMountService == null) {
            IBinder iBinder = ServiceManager.getService("mount");
            if (iBinder != null)
                mMountService = IMountService.Stub.asInterface(iBinder);
        }
        try {
            mMountService.unmountVolume(paramString, true, false);
        } catch (Exception exception) {}
        for (int i = 0; getStorageState(paramString).equals("mounted") && i < 20; i++) {
            try {
                Thread.sleep(500L);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    public String getStorageState(String paramString) {
        if (mStorageManager == null && mContext != null)
            mStorageManager = (StorageManager)mContext.getSystemService(Context.STORAGE_SERVICE);
        if (mStorageManager == null)
            return null;
        try {
            return mStorageManager.getVolumeState(paramString);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public void broadcastShowTA() {
        Log.v("Opandora", "broadcastShowTA");
        Intent intent = new Intent("com.dgl.Radio.action.ACTION_SHOW_TA");
        if (this.mContext != null) { mContext.sendBroadcast(intent); }
    }

    public void onEvent(int paramInt, String paramString) {
        switch (paramInt) {
            case UPDATE_KEY_STATUS:
                int keyCode = McuService.getMcuService().getMcuInfo().getmKeyCode().getKeyCode();
                int keyStatus = McuService.getMcuService().getMcuInfo().getmKeyCode().getKeyStatus();
                int keySource = McuService.getMcuService().getMcuInfo().getmKeyCode().getKeySrc();
                paramString = Integer.toString(keyCode) + "," + Integer.toString(keyStatus) + "," + Integer.toString(keySource);
                if (ignoreSomeKeys(keyCode, keyStatus)) {
                    Log.v("Opandora", "ignoreKey[" + Integer.toString(paramInt));
                    return;
                }
                callCallbacks(UPDATE_KEY_STATUS, paramString);
                processKey(keyCode, keyStatus, keySource);
                break;
            case UPDATE_VOL_STATUS:
                McuService.getMcuService().getMcuInfo().getmCurrentVolStatus().getmVol();
                Intent intent = new Intent("AutoMuteStatus");
                intent.putExtra("KeyMuteStatus", McuService.getMcuService().getMcuInfo().getmCurrentVolStatus().ismMute());
                mContext.sendBroadcast(intent);
                break;
            case UPDATE_ACC_STATUS:
                callCallbacks(UPDATE_ACC_STATUS, paramString);
                break;
            case UPDATE_POWER_STATUS:
                onPowerStatus(paramString.equals("0"));
                if (!paramString.equals("0")) {
                    onPendPowerStatus(true);
                    HandleReInitTouch();
                }
                Log.v("Opandora", "CallbackConstant.OpandoraCallbackConstant.UPDATE_POWER_STATUS [" + intent + "]");
                callCallbacks(UPDATE_POWER_STATUS, paramString);
                break;
            case UPDATE_PEND_POWER_OFF:
                Log.e("Opandora", "McuService UPDATE_PEND_POWER_OFF begin");
                onPendPowerStatus(false);
                Log.e("Opandora", "McuService UPDATE_PEND_POWER_OFF 111111111111111111111");
                callCallbacks(UPDATE_PEND_POWER_OFF, null);
                Log.e("Opandora", "McuService UPDATE_PEND_POWER_OFF 22222222222222222222222222");
                HandleSleep();
                Log.e("Opandora", "McuService UPDATE_PEND_POWER_OFF 333333333333333333333333333333");
                break;
            case UPDATE_AFTER_POWER_ON:
                onPendPowerStatus(true);
                HandleWakeUp();
                callCallbacks(UPDATE_AFTER_POWER_ON, null);
                break;
            case UPDATE_AUTO_TEST_MODE:
                callCallbacks(UPDATE_AUTO_TEST_MODE, paramString);
                if (paramString.equals("1")) {
                    mFilterHandler.obtainMessage(10, 1, 0).sendToTarget();
                    return;
                }
                mFilterHandler.obtainMessage(10, 0, 0).sendToTarget();
                break;
            case UPDATE_AGING_MODE:
                callCallbacks(UPDATE_AGING_MODE, paramString);
                if (paramString.equals("1")) {
                    this.mFilterHandler.obtainMessage(11, 1, 0).sendToTarget();
                    return;
                }
                mFilterHandler.obtainMessage(11, 0, 0).sendToTarget();
                break;
            case UPDATE_WIRTE_BARCODE_SUCCESS:
                callCallbacks(UPDATE_WIRTE_BARCODE_SUCCESS, (String)intent);
                break;
            case UPDATE_SHUT_DOWN_BK_STATUS:
                callCallbacks(UPDATE_SHUT_DOWN_BK_STATUS, (String)intent);
                break;
        }
    }
    public void callCallbacks(int paramInt, String paramString) {
        synchronized (mCallBacks) {
            Iterator<IOpandoraCallback> iterator = mCallBacks.iterator();
            while (iterator.hasNext()) {
                IOpandoraCallback iOpandoraCallback = iterator.next();
                if (iOpandoraCallback != null)
                    try {
                        Log.e("Opandora", "McuService callCallbacks begin 111111111111111111111" + iOpandoraCallback.toString());
                        iOpandoraCallback.onEvent(paramInt, paramString);
                        Log.e("Opandora", "McuService callCallbacks end 111111111111111111111" + iOpandoraCallback.toString());
                    } catch (RemoteException remoteException) {
                        Log.e("Opandora", "remove IOpandoraCallback callCallbacks");
                        iterator.remove();
                    } catch (Exception exception) {
                        Log.e("Opandora", "callCallbacks  -->" + exception);
                    }
            }
        }
    }
}