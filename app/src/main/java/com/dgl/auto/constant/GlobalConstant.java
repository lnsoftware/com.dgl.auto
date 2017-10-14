package com.dgl.auto.constant;

public abstract interface GlobalConstant {

    public static abstract interface AppMode {
        public static final int TUNER           = 0;
        public static final int MUSIC           = 1;
        public static final int VIDEO           = 2;
        public static final int DVD             = 3;
        public static final int NAVI            = 4;
        public static final int AUX             = 5;
        public static final int FRONT_AUX       = 6;
        public static final int TV              = 7;
        public static final int BACKCAR         = 8;
        public static final int BTHFP           = 9;
        public static final int BTA2DP          = 10;
        public static final int IPOD            = 11;
        public static final int HCN4G           = 12;
        public static final int ARM             = 13;
    }

    public static abstract interface AppModePriority {
        public static final int LEVEL0_RDS      = 0;
        public static final int LEVEL1_BACKCAR  = 1;
        public static final int LEVEL2_BTSCO    = 2;
        public static final int LEVEL3_RING     = 3;
        public static final int LEVEL4_GIS      = 4;
        public static final int LEVEL5_NORMAL   = 5;
        public static final int LEVEL_COUNT     = 6;
    }

    public static abstract interface AutoBroadcastEvent {
        public static final String ACTION_KEY_EVENT         = "AutoActionKeyEvent";
        public static final String ACTION_MUTE_STATUS       = "AutoMuteStatus";
        public static final String ACTION_SHORTCUT_STATUS   = "AutoActionShortCutStatus";
        public static final String KEY_CODE                 = "AutoKeyCode";
        public static final String KEY_INFO                 = "KeyInfo";
        public static final String KEY_MUTE_STATUS          = "KeyMuteStatus";
        public static final String KEY_SRC                  = "KEY_SRC";
        public static final String KEY_STATUS               = "AutoKeyStatus";
        public static final String SHORTCUT_STATUS          = "AutoShortStatus";
    }

    public static abstract interface GetSysConstant {
        public static final int GET_SYS_CUR_BT_STATUS       = 1;
        public static final int GET_SYS_CUR_MODE            = 0;
        public static final int GET_SYS_CUR_UI_MODE         = 2;
    }

    public static abstract interface SWCConstant {

        public static abstract interface SWCResitance {
            public static final int SWC_RESITANCE_1K        = 0;
            public static final int SWC_RESITANCE_10K       = 1;
            public static final int SWC_RESITANCE_20K       = 2;
        }

    }

}
