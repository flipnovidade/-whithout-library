package br.com.test.claro.net.utils;

import java.util.Locale;

public class Constants {


    public class Format {
        public static final String DATA_US = "yyyy-MM-dd";
        public static final String DATA_HORA_US = "yyyy-MM-dd HH:mm:ss";
        public static final String DATA_HORA_US_2 = "yyyy-MM-dd HH:mm";
        public static final String DATA_BR = "dd/MM/yyyy";
        public static final String DATA_CUSTOM = "dd/MMM";
        public static final String HORA_MINUTO_BR = "HH:mm";
        public static final String ANO = "yyyy";
        public static final String DATA_BR_AMIGAVEL = "dd MMM yyyy";
    }

    public class Mask {
        public static final String DATA = "##/##/####";
        public static final String TIPO_MOTOR = "#.#";

    }

    public static class Localizacao {
        public static final Locale PTBR = new Locale("pt", "BR");
    }

    public static class Dribbble{
        public static final String Client_ID = "f74640a7172aa82a903058318f528a1f1f91478aba951336cbe3aef0e3635040";
        public static final String Client_Secret = "d7ba69698b097b1d227b06432d476f07a8993066dd6f15039700cc65bc0b646a";
        public static final String Token = "e0034121efb871d1c1e511fc0995f9987b10198606efef55ff580be372f9be6b";
        public static final String Account = "felippenovidade";
        public static final String URL = "https://api.dribbble.com/v2/user/shots?&access_token=e0034121efb871d1c1e511fc0995f9987b10198606efef55ff580be372f9be6b&page=0&per_page=30";
        public static final int PER_PAGE = 30;


//        {
//            "access_token": "e0034121efb871d1c1e511fc0995f9987b10198606efef55ff580be372f9be6b",
//                "token_type": "Bearer",
//                "scope": "public",
//                "created_at": 1534049572
//        }

    }
}
