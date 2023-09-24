package one.around_music.common.dto;

public class SwaggerConfig {
    public static final String LOGIN_SUCCESS_RESPONSE = "{\"status\": 200, \"message\": \"로그인에 성공했습니다.\", \"data\":{\"accessToken\":\"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX1VTRVIiLCJleHAiOjE2ODU5NjUwMzN9.XfwslGyww3Lx4wFRVwDsH5JVtx4e2WVWtN3F6X5vG56D1qtw7FhwMANiJ70PmJnBaoE8ObsiBmzNdCUILE0P8w\",\"refreshToken\":\"eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2ODcwODgyMzN9.Ye8sXfvsHAZaoq-0c8vianij71Lop9yPeDzJJzvQbIa7AKctMP6gyQfk1Rz2gIbj4zBOa893877w1ZALhAERtg\"} }";
    public static final String REGISTER_SUCCESS_RESPONSE = "{\"status\":200,\"message\":\"회원가입에 성공하였습니다.\"}";

    public static final String ADD_FRIEND_SUCESS_RESPONSE = "{\"status\":200,\"message\":\"친구 요청에 성공하였습니다.\"}";

    public static final String BAD_REQUEST = "잘못된 요청 입니다.";
    public static final String NOT_FOUND = "찾을 수 없습니다.";
}
