package com.dgl.auto.constant;

public abstract interface ISettingConstant {

    public static abstract interface BootTime {
        public static final int BOOT_TIME_EVERYTIME     = 0x00;
        public static final int BOOT_TIME_2_HOURS       = 0x01;
        public static final int BOOT_TIME_12_HOURS      = 0x02;
        public static final int BOOT_TIME_24_HOURS      = 0x03;
    }

    public static abstract interface EQType {
        public static final int EQ_USER                 = 0x00;
        public static final int EQ_FLAT                 = 0x01;
        public static final int EQ_JAZZ                 = 0x02;
        public static final int EQ_POP                  = 0x03;
        public static final int EQ_CLASSIC              = 0x04;
        public static final int EQ_ROCK                 = 0x05;
        public static final int EQ_NEWS                 = 0x06;
        public static final int EQ_CITY                 = 0x07;
        public static final int EQ_ELECTRONIC           = 0x08;
        public static final int EQ_MOVIE                = 0x09;
    }

}
