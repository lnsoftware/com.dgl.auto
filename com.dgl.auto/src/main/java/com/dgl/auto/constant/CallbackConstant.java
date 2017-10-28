package com.dgl.auto.constant;

public abstract interface CallbackConstant {

    public static abstract interface OpandoraKeyIndex {
        public static final int KEY_0 =                     0x1d;
        public static final int KEY_1 =                     0x1e;
        public static final int KEY_10_ =                   0x27;
        public static final int KEY_2 =                     0x1f;
        public static final int KEY_3 =                     0x20;
        public static final int KEY_4 =                     0x21;
        public static final int KEY_5 =                     0x22;
        public static final int KEY_6 =                     0x23;
        public static final int KEY_7 =                     0x24;
        public static final int KEY_8 =                     0x25;
        public static final int KEY_9 =                     0x26;
        public static final int KEY_ANGLE =                 0x1c;
        public static final int KEY_AS =                    0x2a;
        public static final int KEY_AUDIO =                 0x1b;
        public static final int KEY_A_B =                   0x18;
        public static final int KEY_BAND =                  0x15;
        public static final int KEY_CALL_OFF =              0x2e;
        public static final int KEY_CALL_ON =               0x2d;
        public static final int KEY_DOWN =                  0xa;
        public static final int KEY_ENTER =                 0xd;
        public static final int KEY_EQ =                    0x19;
        public static final int KEY_INFO =                  0x16;
        public static final int KEY_LEFT =                  0xb;
        public static final int KEY_MENU =                  0xe;
        public static final int KEY_MODE =                  0x3;
        public static final int KEY_MUTE =                  0x4;
        public static final int KEY_NAV =                   0x29;
        public static final int KEY_OPEN =                  0x2;
        public static final int KEY_PAGE_DOWN =             0x34;
        public static final int KEY_PAGE_UP =               0x33;
        public static final int KEY_PAUSE =                 0x9f;
        public static final int KEY_PLAY =                  0x9e;
        public static final int KEY_POWER =                 0x1;
        public static final int KEY_PS =                    0x2b;
        public static final int KEY_RANDOM =                0x10;
        public static final int KEY_REPEAT =                0x17;
        public static final int KEY_RETURN =                0x5;
        public static final int KEY_RIGHT =                 0xc;
        public static final int KEY_ROOT =                  0xf;
        public static final int KEY_SCAN =                  0x2c;
        public static final int KEY_SEARCH =                0x35;
        public static final int KEY_SEEK_DOWN =             0x12;
        public static final int KEY_SEEK_STEP_DOWN =        0x14;
        public static final int KEY_SEEK_STEP_UP =          0x13;
        public static final int KEY_SEEK_UP =               0x11;
        public static final int KEY_SMART_CCW =             0x32;
        public static final int KEY_SMART_CW =              0x31;
        public static final int KEY_SUB =                   0x28;
        public static final int KEY_TITLE =                 0x6;
        public static final int KEY_UICC_A2DP =             0x3f;
        public static final int KEY_UICC_AUX =              0x44;
        public static final int KEY_UICC_CAN_SET =          0x40;
        public static final int KEY_UICC_DVD =              0x38;
        public static final int KEY_UICC_HOME =             0x46;
        public static final int KEY_UICC_LOC =              0x45;
        public static final int KEY_UICC_NUMBER =           0x43;
        public static final int KEY_UICC_PLAY_PAUSE =       0x39;
        public static final int KEY_UICC_RESET =            0x37;
        public static final int KEY_UICC_RETURN =           0x3b;
        public static final int KEY_UICC_SMART_ENTER =      0x3a;
        public static final int KEY_UICC_STAR =             0x42;
        public static final int KEY_UICC_TEST_BT_ONOFF =    0x3d;
        public static final int KEY_UICC_TEST_PARKING_ON =  0x3c;
        public static final int KEY_UICC_TIME_SET =         0x41;
        public static final int KEY_UICC_VOICE_WAKEUP =     0x3e;
        public static final int KEY_UP =                    0x9;
        public static final int KEY_VERSION =               0x36;
        public static final int KEY_VOLUME_CCW =            0x30;
        public static final int KEY_VOLUME_CW =             0x2f;
        public static final int KEY_VOL_ADD =               0x8;
        public static final int KEY_VOL_DEC =               0x7;
        public static final int KEY_ZOOM =                  0x1a;

    }

    public static abstract interface KeySource {
        public static final int Front =                     0x1;
        public static final int Panel =                     0x0;
        public static final int Rear =                      0x2;
    }

    public static abstract interface KeyStatus {
        public static final int KeyLongPress =              0x1;
        public static final int KeyShortPress =             0x0;
    }

    public class OpandoraKey {
        public int mKeyCode;
        public int mKeySrc;
        public int mKeyStatus;
    }

    public static abstract interface OpandoraCallbackConstant {
        public static final int UPDATE_ACC_STATUS =             0x2;
        public static final int UPDATE_AFTER_POWER_ON =         0x5;
        public static final int UPDATE_AGING_MODE =             0x8;
        public static final int UPDATE_AUTO_TEST_MODE =         0x7;
        public static final int UPDATE_KEY_STATUS =             0x0;
        public static final int UPDATE_PEND_POWER_OFF =         0x4;
        public static final int UPDATE_POWER_STATUS =           0x3;
        public static final int UPDATE_RADAR_DATA =             0x6;
        public static final int UPDATE_SHUT_DOWN_BK_STATUS =    0xa;
        public static final int UPDATE_VOL_STATUS =             0x1;
        public static final int UPDATE_WIRTE_BARCODE_SUCCESS =  0x9;
    }

    public static abstract interface SWCCallbackConstant {
        public static final int UPDATE_KEY_TABLE =              0x3;
        public static final int UPDATE_KEY_VALUE_STATUS =       0x1;
        public static final int UPDATE_RESISTANCE =             0x2;
        public static final int UPDATE_VERIFY_END =             0x0;
    }

    public static abstract interface AutoEventCallbackConstant {
        public static final java.lang.String ACTION_AUTO_BACKCAR_STATUS =   "com.auto.backcar.status";
        public static final java.lang.String ACTION_AUTO_BRAKE_STATUS =     "com.auto.brake.status";
        public static final java.lang.String ACTION_AUTO_IIIUMINE_STATUS =  "com.auto.iiiumine.status";
        public static final java.lang.String EVENT_START =                  "start";
        public static final java.lang.String EVENT_STOP =                   "stop";
        public static final int UPDATE_AUTO_BACKCAR_STATUS =                0x2;
        public static final int UPDATE_AUTO_BRAKE_STATUS =                  0x1;
        public static final int UPDATE_AUTO_IIIUMINE_STATUS =               0x3;
    }

    public static abstract interface CanbusCallbackConstant {
        public static final int UPDATE_CANBUS_DATA =            0x1;
    }

    public static abstract interface RadioCallbackConstant {
        public static final int UPDATE_PRESET_LIST_INFO =       0x2;
        public static final int UPDATE_TUNER_INFO =             0x1;
        public static final int UPDATE_TUNER_RANGE =            0x3;
        public static final int UPDATE_TUNER_RDSINFO =          0x5;
        public static final int UPDATE_TUNER_READY =            0x4;
    }

    public static abstract interface SettingCallbackConstant {
        public static final int UPDATE_MCU_VERSION =            0x3;
        public static final int UPDATE_SETUP_AUDIO_INFO =       0x2;
        public static final int UPDATE_SETUP_GENERAL_INFO =     0x1;
    }
}
