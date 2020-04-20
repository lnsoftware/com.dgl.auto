package com.auto.mcuservice;

import android.util.Log;

import com.auto.autoevent.AutoEvent;
import com.auto.constant.McuConstant;
import com.auto.opandora.Opandora;
import com.auto.swc.SWCService;
import com.dgl.auto.constant.CallbackConstant;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import com.auto.radioservice.RadioService;
import com.auto.setting.SettingService;

public class McuMsgQueueManager implements CallbackConstant {
    private static final int HAND_MCU_HANDLE_TIME_OUT = 20;

    static McuMsgQueueManager mcuMsgQueueManager = null;
    private static Object sMcuMsgDequeLock = new Object();

    public static interface MainInternalMsgIndex {
        public static final int eMieiIdle =                         0;
        public static final int eMieiUpdateTunerRangeInfo =         1;
        public static final int eMieiUpdateTunerRdsInfo =           2;
        public static final int eMieiUpdateTunerRdsPTYInfo =        3;
        public static final int eMieiUpdateTunerRdsPSInfo =         4;
        public static final int eMieiUpdateTunerRdsSettingInfo =    5;
        public static final int eMieiUpdateTunerInfo =              6;
        public static final int eMieiUpdateTunerPresetList =        7;
        public static final int eMieiUpdateMcuVersion =             8;
        public static final int eMieiUpdateSetupGeneralInfo =       9;
        public static final int eMieiUpdateSetupAudioInfo =         10;
        public static final int eMieiUpdateReverseState =           11;
        public static final int eMieiUpdateBrakeStatus =            12;
        public static final int eMieiUpdateDiscDetectStatus =       13;
        public static final int eMieiProcessKey =                   14;
        public static final int eMieiSteeringWheelInfoMsg =         15;
        public static final int eMieiVolMsg =                       16;
        public static final int eMieiUpdateIIIumineStatus =         17;
        public static final int eMieiUpdateDTVStatus =              18;
        public static final int eMieiUpdateATVInfo =                19;
        public static final int eMieiUpdateATVPresetList =          20;
        public static final int eMieiUpdateIlluminPWMValue =        21;
        public static final int eMieiUpdateTestMode =               22;
        public static final int eMieiAccOn2Off =                    23;
        public static final int eMieiCarBTCallStatus =              24;
        public static final int eMieiUpdateAgingMode =              25;
        public static final int eMieiAVINCheckStatus =              26;
        public static final int eMieiCanDataReady =                 27;
        public static final int eMieiPowerStatus =                  28;
        public static final int eMieiPendPowerOff =                 29;
        public static final int eMieiPendPowerOn =                  30;
        public static final int eMieiUpdateTunerRdsRTInfo =         31;
        public static final int eMieiUpdateBKLightStatus =          32;
    }

    public class McuMsgNode {
        private int mIndex;
        private int mParam;

        public McuMsgNode(int index, int param) {
            mIndex = index;
            mParam = param;
        }
        boolean equal(McuMsgNode node) {
            return (mIndex == node.mIndex && mParam == node.mParam);
        }
        public int getmIndex() {
            return mIndex;
        }
        public int getmParam() {
            return mParam;
        }
        public void setmIndex(int index) {
            mIndex = index;
        }
        public void setmParam(int param) {
            mParam = param;
        }
    }

    public class HandMcuMsgQueueTask implements Runnable {
        public void run() {
            try {
                McuMsgQueueManager.McuMsgNode mcuMsgNode = McuMsgQueueManager.this.popNode();
                if (mcuMsgNode != null)
                    McuMsgQueueManager.this.processInternalMsg(mcuMsgNode);
                return;
            } catch (Exception exception) {
                Log.e("McuMsgQueueManager", "HandMcuMsgQueueTask erre-->" + exception);
                exception.printStackTrace();
                return;
            }
        }
    }

    private HandMcuMsgQueueTask handMcuMsgQueueTask = null;
    private ArrayDeque<McuMsgNode> mMcuMsgQueueArrayDeque = new ArrayDeque<McuMsgNode>();
    private ScheduledThreadPoolExecutor stpemcuMsgQueueExecutor = null;

    void init() {
        startMcuMsgTimer();
    }
    void unInit() {
        stopMcuMsgTimer();
    }
    public static McuMsgQueueManager getInstance() {
        if (mcuMsgQueueManager == null) mcuMsgQueueManager = new McuMsgQueueManager();
        return mcuMsgQueueManager;
    }
    private void _pushNode(int index, int param, boolean bIgnoreDouble) {
        McuMsgNode mcuMsgNode = new McuMsgNode(index, param);
        if (bIgnoreDouble) {
            Iterator<McuMsgNode> iterator = mMcuMsgQueueArrayDeque.iterator();
            while (iterator.hasNext()) {
                if (((McuMsgNode)iterator.next()).equals(mcuMsgNode))
                    return;
            }
        }
        if (index == 11) {
            for (McuMsgNode tmpNode : mMcuMsgQueueArrayDeque) {
                if (tmpNode.getmIndex() == mcuMsgNode.getmIndex() && tmpNode.getmParam() != mcuMsgNode.getmParam()) {
                    tmpNode.setmIndex(0);
                    tmpNode.setmParam(0);
                    return;
                }
            }
            mMcuMsgQueueArrayDeque.addFirst(mcuMsgNode);
        } else {
            mMcuMsgQueueArrayDeque.addLast(mcuMsgNode);
        }
    }
    void startMcuMsgTimer() {
        if (stpemcuMsgQueueExecutor == null) stpemcuMsgQueueExecutor = new ScheduledThreadPoolExecutor(5);
        if (handMcuMsgQueueTask == null) handMcuMsgQueueTask = new HandMcuMsgQueueTask();
        stpemcuMsgQueueExecutor.scheduleWithFixedDelay(handMcuMsgQueueTask, HAND_MCU_HANDLE_TIME_OUT, HAND_MCU_HANDLE_TIME_OUT, TimeUnit.MILLISECONDS);
    }
    void stopMcuMsgTimer() {
        stpemcuMsgQueueExecutor.shutdown();
    }
    McuMsgNode popNode() {
        synchronized (sMcuMsgDequeLock) {
            if (mMcuMsgQueueArrayDeque.isEmpty()) {
                return null;
            } else {
                return mMcuMsgQueueArrayDeque.remove();
            }
        }
    }
    void pushNode(int index, int param, boolean bIgnoreDouble) {
        synchronized (sMcuMsgDequeLock) {
            _pushNode(index, param, bIgnoreDouble);
        }
    }
    void pushNode(int index, boolean bIgnoreDouble) {
        pushNode(index, 0, bIgnoreDouble);
    }
    void processInternalMsg(McuMsgNode mcuMsgNode) {
        Log.e("McuMsgQueueManager", "McuMsgNode=" + mcuMsgNode.getmIndex());

        switch (mcuMsgNode.getmIndex()) {
            case 1:
                RadioService.getInstance().onMessage(RadioCallbackConstant.UPDATE_TUNER_RANGE, null);
                break;
            case 2:
                RadioService.getInstance().onMessage(RadioCallbackConstant.UPDATE_TUNER_RDSINFO, null);
                Opandora.getInstance().broadcastShowTA();
                break;
            case 3:
                RadioService.getInstance().onMessage(RadioCallbackConstant.UPDATE_TUNER_RDSINFO, null);
                break;
            case 4:
                RadioService.getInstance().onMessage(RadioCallbackConstant.UPDATE_TUNER_RDSINFO, null);
                break;
            case 5:
                RadioService.getInstance().onMessage(RadioCallbackConstant.UPDATE_TUNER_RDSINFO, null);
                break;
            case 6:
                RadioService.getInstance().onMessage(RadioCallbackConstant.UPDATE_TUNER_INFO, null);
                break;
            case 7:
                RadioService.getInstance().onMessage(RadioCallbackConstant.UPDATE_PRESET_LIST_INFO, null);
                break;
            case 9:
                SettingService.getInstance().onMessage(SettingCallbackConstant.UPDATE_SETUP_GENERAL_INFO, null);
                break;
            case 10:
                SettingService.getInstance().onMessage(SettingCallbackConstant.UPDATE_SETUP_AUDIO_INFO, null);
                break;
            case 11:
                AutoEvent.getInstance().onBackCarEvent(mcuMsgNode.getmParam() == 1);
                break;
            case 12:
                AutoEvent.getInstance().onBrakeEvent(mcuMsgNode.getmParam() == 1);
                break;
            case 14:
                Opandora.getInstance().onEvent(OpandoraCallbackConstant.UPDATE_KEY_STATUS, null);
                break;
            case 15:
                SWCService.getInstance().onMessage(mcuMsgNode.getmParam(), null);
                break;
            case 16:
                Opandora.getInstance().onEvent(OpandoraCallbackConstant.UPDATE_VOL_STATUS, null);
                break;
            case 17:
                AutoEvent.getInstance().onIIIumine(mcuMsgNode.getmParam() == 1);
                break;
            case MainInternalMsgIndex.eMieiUpdateIlluminPWMValue:
                AutoEvent.getInstance().onIlluminPWMValue(mcuMsgNode.getmParam());
                break;
            case 22:
                Opandora.getInstance().onEvent(OpandoraCallbackConstant.UPDATE_AUTO_TEST_MODE, Integer.toString(mcuMsgNode.getmParam()));
                break;
            case 23:
                Opandora.getInstance().onEvent(OpandoraCallbackConstant.UPDATE_ACC_STATUS, Integer.toString(mcuMsgNode.getmParam()));
                break;
            case 25:
                Opandora.getInstance().onEvent(OpandoraCallbackConstant.UPDATE_AGING_MODE, Integer.toString(mcuMsgNode.getmParam()));
                break;
            case 28:
                Opandora.getInstance().onEvent(OpandoraCallbackConstant.UPDATE_POWER_STATUS, Integer.toString(mcuMsgNode.getmParam()));
                break;
            case MainInternalMsgIndex.eMieiPendPowerOff:
                Log.e("TAG", "McuService handle  eMieiPendPowerOff 999999999999999999999999");
                Opandora.getInstance().onEvent(OpandoraCallbackConstant.UPDATE_PEND_POWER_OFF, null);
                Log.e("TAG", "McuService HandleSleep tell mcu to poweroff now");
                McuService.getMcuService().SndCmd(McuConstant.HostCmd.CMD_RESP_ENTER_POWER_OFF);
                break;
            case 30:
                Opandora.getInstance().onEvent(OpandoraCallbackConstant.UPDATE_AFTER_POWER_ON, null);
                break;
            case 31:
                RadioService.getInstance().onMessage(RadioCallbackConstant.UPDATE_TUNER_RDSINFO, null);
                break;
            case 32:
                Log.e("TAG", "BKLight============== processInternalMsg eMieiUpdateBKLightStatus 111111111111111111111111111111111" + Integer.toString(mcuMsgNode.getmParam()));
                Opandora.getInstance().onEvent(OpandoraCallbackConstant.UPDATE_SHUT_DOWN_BK_STATUS, Integer.toString(mcuMsgNode.getmParam()));
                break;
        }
    }
}
