package com.pinapp.challenge.challenge.utility;

public abstract class GlobalConstants {

    public static final String HOME = "/";

    public static final String ENDPOINT_POST_CREATE_CLIENT = "creacliente";

    public static final String ENDPOINT_GET_CLIENT_KPI = "kpideclientes";

    public static final String ENDPOINT_GET_LIST_CLIENTS = "listclientes";

    public static final String VALIDATION_DD_MM_YYYY = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    public static final Integer ARG_LIFE_EXPECTANCY_YEARS = 75;

    public static final Integer ARG_LIFE_EXPECTANCY_DAYS = (int) 325.0725;

    public static final String TEST_BIRTH_DATE_INVALID = "Fecha de Nacimiento faltante o no valida";
    public static final String TEST_SURNAME_INVALID = "El apellido del cliente es obligatorio";
    public static final String TEST_NAME_INVALID = "El nombre del cliente es obligatorio";
    public static final String TEST_AGE_INVALID = "La edad del cliente es obligatoria";

    public static final Double TEST_AVG_AGE = 25.33;

    public static final Double TEST_STANDARD_DEV = 2.05;

    public static String AUTHORIZATION_REQUEST = "/auth/*";
    public static String SWAGGER_REQUEST = "/swagger-ui/**";
    public static String OPENAPI_REQUEST = "/v3/api-docs/**";

}
