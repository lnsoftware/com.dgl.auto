package com.auto.constant;

public interface McuConstant {

    public static interface AudioSetIndex {
        public static final int AUDIO_SET_EQ =                      0;
        public static final int AUDIO_SET_BALANCE =                 1;
        public static final int AUDIO_SET_FADE =                    2;
        public static final int AUDIO_SET_LOUD =                    3;
        public static final int AUDIO_SET_SUBWOOFER =               4;
        public static final int AUDIO_SET_SUB_FILTER_FREQ =         5;
        public static final int AUDIO_SET_SUB_PHASE =               6;
        public static final int AUDIO_SET_BASS =                    7;
        public static final int AUDIO_SET_MIDDLE =                  8;
        public static final int AUDIO_SET_TREBLE =                  9;
        public static final int AUDIO_SET_BASS_FREQ =               10;
        public static final int AUDIO_SET_MIDDLE_FREQ =             11;
        public static final int AUDIO_SET_TREBLE_FREQ =             12;
        public static final int AUDIO_SET_BASS_Q =                  13;
        public static final int AUDIO_SET_MIDDLE_Q =                14;
        public static final int AUDIO_SET_TREBLE_Q =                16;     //TODO: why 16? maybe 15?
    }

    public static interface GeneralSetIndex {
        public static final int GENERAL_SET_BRIGHT =                0;
        public static final int GENERAL_SET_CONTRAST =              1;
        public static final int GENERAL_SET_CLOCK_MODE =            2;
        public static final int GENERAL_SET_BEEP =                  3;
        public static final int GENERAL_SET_ILLUME_DETECTION =      4;
        public static final int GENERAL_SET_REVERSE_DETECTION =     5;
        public static final int GENERAL_SET_REVERSE_IMAGE =         6;
        public static final int GENERAL_SET_REVERSE_GAIN =          7;
        public static final int GENERAL_SET_RADIO_FIELD =           8;
        public static final int GENERAL_SET_NAVI_MODE =             9;
        public static final int GENERAL_SET_CLOCK_H =               10;
        public static final int GENERAL_SET_CLOCK_M =               11;
        public static final int GENERAL_SET_HUE =                   12;
        public static final int GENERAL_SET_SATURATION =            13;
        public static final int GENERAL_SET_REVERSE_MIRROR =        14;
        public static final int GENERAL_SET_AUX_LINE =              15;
        public static final int GENERAL_SET_CART_CONFIGURE =        16;
        public static final int GENERAL_SET_SWC_TYPE =              17;
        public static final int GENERAL_SET_BOOT_TIME =             18;
    }

    public static interface HostCmd {
        public static final int CMD_HOST_ACK =                      0;
        public static final int CMD_POWER_ON =                      1;
        public static final int CMD_SND_MODE_FRONT =                3;
        public static final int CMD_GET_MODE_FRONT =                4;
        public static final int CMD_SND_MODE_REAR =                 6;
        public static final int CMD_GET_MODE_REAR =                 7;
        public static final int CMD_SND_MENU_STATUS =               9;
        public static final int CMD_SND_BT_AUDIO_STATAUS =          10;
        public static final int CMD_SND_NAV_AUDIO_STATUS =          11;
        public static final int CMD_GET_AUDIO_SETTING =             12;
        public static final int CMD_GET_GENERAL_SETTING =           14;
        public static final int CMD_SND_VOL_SETTING =               16;
        public static final int CMD_BEEP_NOW =                      18;
        public static final int CMD_SAVE_PRESET_FREQ =              19;
        public static final int CMD_LOAD_PRESET_FREQ =              20;
        public static final int CMD_SND_TS_EVENTS =                 21;
        public static final int CMD_SND_SEEK_STOP =                 22;
        public static final int CMD_SND_AUDIO_SETTING =             23;
        public static final int CMD_SND_GENERAL_SETTING =           24;
        public static final int CMD_GET_VERSION =                   25;
        public static final int CMD_SND_MCU_TEST_DISC_MODE =        27;
        public static final int CMD_SND_MUTE =                      28;
        public static final int CMD_SND_STANDBY =                   30;
        public static final int CMD_SND_LOADFACTORY =               31;
        public static final int CMD_GET_TUNER_INFO =                33;
        public static final int CMD_GET_TUNER_PRESET_LIST_INFO =    35;
        public static final int CMD_GET_DEVICE_DETECTION_INFO =     38;
        public static final int CMD_RESET_DEVICE =                  40;
        public static final int CMD_RESP_ENTER_POWER_OFF =          48;
        public static final int CMD_RESP_EJECT =                    49;
        public static final int CMD_SND_BT_AUDIO_MUTE =             50;
        public static final int CMD_SND_MCU_STEERING_WHEEL_CTRL =   51;
        public static final int CMD_GET_TUNER_RANGE =               53;
        public static final int CMD_SND_TUNER_FREQ_SET =            55;
        public static final int CMD_SND_CAN_PUBLIC_CMD =            58;
        public static final int CMD_GET_TV_INFO =                   60;
        public static final int CMD_GET_PRESET_CH_INFO =            62;
        public static final int CMD_SND_RDS_SETTING =               64;
        public static final int CMD_SND_GET_RDS_SETTING =           65;
        public static final int CMD_SND_SET_VOL_OFFSET =            74;
        public static final int CMD_GET_CAR_TYPE =                  81;
        public static final int CMD_SND_POWEROFF_DVD =              81;
        public static final int CMD_GET_CAN_APP_ON =                85;
        public static final int CMD_SET_TEST_AGING_MODE =           86;
        public static final int CMD_GET_PWR_STATUS =                91;
        public static final int CMD_SET_BOOT_TIME =                 94;
        public static final int CMD_SET_BT_RING =                   95;
        public static final int CMD_GET_MCU_RESET_TYPE =            96;
        public static final int CMD_SND_SHUTDOWN_BK =               106;
    }

    public static interface KeyIndex {
        public static final int KEY_POWER =                         1;
        public static final int KEY_OPEN =                          2;
        public static final int KEY_MODE =                          3;
        public static final int KEY_MUTE =                          4;
        public static final int KEY_RETURN =                        5;
        public static final int KEY_TITLE =                         6;
        public static final int KEY_VOL_DEC =                       7;
        public static final int KEY_VOL_ADD =                       8;
        public static final int KEY_UP =                            9;
        public static final int KEY_DOWN =                          10;
        public static final int KEY_LEFT =                          11;
        public static final int KEY_RIGHT =                         12;
        public static final int KEY_ENTER =                         13;
        public static final int KEY_MENU =                          14;
        public static final int KEY_ROOT =                          15;
        public static final int KEY_RANDOM =                        16;
        public static final int KEY_SEEK_UP =                       17;
        public static final int KEY_SEEK_DOWN =                     18;
        public static final int KEY_SEEK_STEP_UP =                  19;
        public static final int KEY_SEEK_STEP_DOWN =                20;
        public static final int KEY_BAND =                          21;
        public static final int KEY_INFO =                          22;
        public static final int KEY_REPEAT =                        23;
        public static final int KEY_A_B =                           24;
        public static final int KEY_EQ =                            25;
        public static final int KEY_ZOOM =                          26;
        public static final int KEY_AUDIO =                         27;
        public static final int KEY_ANGLE =                         28;
        public static final int KEY_0 =                             29;
        public static final int KEY_1 =                             30;
        public static final int KEY_2 =                             31;
        public static final int KEY_3 =                             32;
        public static final int KEY_4 =                             33;
        public static final int KEY_5 =                             34;
        public static final int KEY_6 =                             35;
        public static final int KEY_7 =                             36;
        public static final int KEY_8 =                             37;
        public static final int KEY_9 =                             38;
        public static final int KEY_10_ =                           39;
        public static final int KEY_SUB =                           40;
        public static final int KEY_NAV =                           41;
        public static final int KEY_AS =                            42;
        public static final int KEY_PS =                            43;
        public static final int KEY_SCAN =                          44;
        public static final int KEY_CALL_ON =                       45;
        public static final int KEY_CALL_OFF =                      46;
        public static final int KEY_VOLUME_CW =                     47;
        public static final int KEY_VOLUME_CCW =                    48;
        public static final int KEY_SMART_CW =                      49;
        public static final int KEY_SMART_CCW =                     50;
        public static final int KEY_PAGE_UP =                       51;
        public static final int KEY_PAGE_DOWN =                     52;
        public static final int KEY_SEARCH =                        53;
        public static final int KEY_VERSION =                       54;
        public static final int KEY_UICC_RESET =                    55;
        public static final int KEY_UICC_DVD =                      56;
        public static final int KEY_UICC_PLAY_PAUSE =               57;
        public static final int KEY_UICC_SMART_ENTER =              58;
        public static final int KEY_UICC_RETURN =                   59;
        public static final int KEY_UICC_TEST_PARKING_ON =          60;
        public static final int KEY_UICC_TEST_BT_ONOFF =            61;
        public static final int KEY_UICC_VOICE_WAKEUP =             62;
        public static final int KEY_UICC_A2DP =                     63;
        public static final int KEY_UICC_CAN_SET =                  64;
        public static final int KEY_UICC_TIME_SET =                 65;
        public static final int KEY_UICC_STAR =                     66;
        public static final int KEY_UICC_NUMBER =                   67;
        public static final int KEY_UICC_AUX =                      68;
        public static final int KEY_UICC_LOC =                      69;
        public static final int KEY_PLAY =                          158;
        public static final int KEY_PAUSE =                         159;
    }

    public static interface McuCmd {
        public static final int CMD_MCU_ACK =                       0;
        public static final int CMD_RESP_POWER_ON =                 2;
        public static final int CMD_RET_MODE_FRONT =                5;
        public static final int CMD_RET_MODE_REAR =                 8;
        public static final int CMD_RET_AUDIO_SETTING =             13;
        public static final int CMD_RET_GENERAL_SETTING =           15;
        public static final int CMD_RET_VOL_VALUE =                 17;
        public static final int CMD_RET_VERSION =                   26;
        public static final int CMD_RET_KEY =                       32;
        public static final int CMD_RET_TUNER_INFO =                34;
        public static final int CMD_RET_TUNER_PRESET_LIST_INFO =    36;
        public static final int CMD_RET_TUNER_SIGNAL_TRENGTH =      37;
        public static final int CMD_RET_DEVICE_DETECTION_INFO =     39;
        public static final int CMD_ENTER_POWER_OFF =               41;
        public static final int CMD_RET_STEERING_WHEEL_INFO =       52;
        public static final int CMD_RET_TUNER_RANGE =               54;
        public static final int CMD_RET_CAN_CMD =                   59;
        public static final int CMD_RET_TV_INFO =                   61;
        public static final int CMD_RET_PRESET_CH_INFO =            63;
        public static final int CMD_RET_RDS_SETTING =               66;
        public static final int CMD_RET_RDS_INFO =                  67;
        public static final int CMD_RET_RDS_PTY =                   68;
        public static final int CMD_RET_RDS_PS =                    69;
        public static final int CMD_RET_RDS_RT =                    71;
        public static final int CMD_RET_RDS_CT =                    72;
        public static final int CMD_RET_VOL_OFFSET =                75;
        public static final int CMD_RET_CAR_TYPE =                  82;
        public static final int CMD_RET_PWM_DUTYCYCLE =             84;
        public static final int CMD_RET_PWR_STATUS =                92;
        public static final int CMD_RET_MCU_RESET_TYPE =            97;
        public static final int CMD_RET_MCU_SHUTDOWN_BK_STATUS =    107;
    }

    public static interface McuPacketStatus {
        public static final int PACKET_INDEX_SYNC =                 0;
        public static final int PACKET_INDEX_START =                1;
        public static final int PACKET_INDEX_TRANSACTION_ID =       2;
        public static final int PACKET_INDEX_LENGTH =               3;
        public static final int PACKET_INDEX_CMD =                  4;
        public static final int PACKET_INDEX_PAYLOAD =              5;
        public static final int PACKET_INDEX_CRC_H =                6;
        public static final int PACKET_INDEX_CRC_L =                7;
        public static final int PACKET_INDEX_MAX =                  8;
    }

    public static interface McuSourceIndex {
        public static final int SOURCE_TUNER =                      0;
        public static final int SOURCE_DVD =                        1;
        public static final int SOURCE_NAVI =                       2;
        public static final int SOURCE_SD =                         3;
        public static final int SOURCE_USB =                        4;
        public static final int SOURCE_IPOD =                       5;
        public static final int SOURCE_AUX =                        6;
        public static final int SOURCE_FRONT_AUX =                  7;
        public static final int SOURCE_DTV =                        8;
        public static final int SOURCE_TV =                         9;
        public static final int SOURCE_HDRADIO =                    10;
        public static final int SOURCE_XM =                         11;
        public static final int SOURCE_SIRIUS =                     12;
        public static final int SOURCE_BT =                         13;
        public static final int SOURCE_CAMERA =                     14;
        public static final int SOURCE_MUSIC =                      15;
        public static final int SOURCE_VIDEO =                      16;
        public static final int SOURCE_PICTURE =                    17;
        public static final int SOURCE_DVR =                        18;
        public static final int SOURCE_CAR_USB =                    19;
        public static final int SOURCE_ARM =                        20;
        public static final int SOURCE_A2DP =                       21;
        public static final int NUM_OF_SOURCE =                     22;
    }

    public static interface PacketExtraMsg {
        public static final int CREATE_APP_TIME =                   200;
        public static final int HEADER =                            0xAA;
        public static final int MAX_BUFFER_SIZE =                   1022;
        public static final int MAX_RX_COMMAND_LENGTH =             0x01FA;
        public static final int MAX_TX_COMMAND_LENGTH =             0x01FA;
        public static final int RESEND_CNT_MAX =                    2;
        public static final int RESEND_POWER_UP =                   1000;
        public static final int RESEND_TIME_OUT =                   500;
        public static final int SYNC =                              0xFF;
        public static final int TIMER_EVENTS_ACTIVE_DEVICE =        14;
        public static final int TIMER_EVENTS_COREMAIN =             11;
        public static final int TIMER_EVENTS_CREATE_APP =           13;
        public static final int TIMER_EVENTS_HOST_COMM =            10;
        public static final int TIMER_EVENTS_TICK_100 =             12;
    }

    public static interface PowerUpStatus {
        public static final int POWER_UP_IDLE =                     0;
        public static final int SEND_POWER_ON =                     1;
        public static final int WAITING_POWER_ON_RESP =             2;
        public static final int GET_FRONT_SOURCE =                  3;
        public static final int WAITING_RETURN_FRONT_SOURCE =       4;
        public static final int GET_CAR_TYPE =                      5;
        public static final int WAITING_RETURN_CAR_TYPE =           6;
        public static final int GET_AUDIO_SETTING =                 7;
        public static final int WAITING_RETURN_AUDIO_SETTING =      8;
        public static final int GET_GEN_SETTING =                   9;
        public static final int WAITING_RETURN_GEN_SETTING =        10;
        public static final int GET_DEVICE_DETECTION_INFO =         11;
        public static final int WAITING_RETURN_DEVICE_DETECTION_INFO = 12;
        public static final int POWER_UP_SUCCESS =                  13;
        public static final int POWER_UP_REVERSE =                  14;
    }

    public static interface SubCutFeq {
        public static final int SUB_CUT_FREQ_OFF =                  0;
        public static final int SUB_CUT_FREQ_80HZ =                 1;
        public static final int SUB_CUT_FREQ_120HZ =                2;
        public static final int SUB_CUT_FREQ_160HZ =                3;
    }

    public static interface TsEvents {
        public static final int TS_EVENT_INDEX_SEEK_UP =            0;
        public static final int TS_EVENT_INDEX_SEEK_DOWN =          1;
        public static final int TS_EVENT_INDEX_AS =                 2;
        public static final int TS_EVENT_INDEX_PS =                 3;
        public static final int TS_EVENT_INDEX_SCAN =               4;
        public static final int TS_EVENT_INDEX_DX_LOC =             5;
        public static final int TS_EVENT_INDEX_BAND =               6;
        public static final int TS_EVENT_INDEX_MANUAL_UP =          7;
        public static final int TS_EVENT_INDEX_MANUAL_DOWN =        8;
        public static final int TS_EVENT_INDEX_RETURN =             9;
    }

}
