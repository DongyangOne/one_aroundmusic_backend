package one.around_music.common.dto;

public class SwaggerConfig {

    // 유저
    public static final String LOGIN_SUCCESS_RESPONSE = "{\"code\": 200, \"message\": \"로그인에 성공했습니다.\", \"data\":{\"accessToken\":\"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1dGgiOiJST0xFX1VTRVIiLCJleHAiOjE2ODU5NjUwMzN9.XfwslGyww3Lx4wFRVwDsH5JVtx4e2WVWtN3F6X5vG56D1qtw7FhwMANiJ70PmJnBaoE8ObsiBmzNdCUILE0P8w\",\"refreshToken\":\"eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2ODcwODgyMzN9.Ye8sXfvsHAZaoq-0c8vianij71Lop9yPeDzJJzvQbIa7AKctMP6gyQfk1Rz2gIbj4zBOa893877w1ZALhAERtg\"} }";
    public static final String REGISTER_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"회원가입에 성공하였습니다.\"}";
    public static final String UPDATE_PROFILEIMG_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"프로필 이미지 변경에 성공했습니다.\"}";

    // 친구
    public static final String ADD_FRIEND_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"친구 요청에 성공하였습니다.\"}";
    public static final String DELETE_FRIEND_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"친구 삭제에 성공하였습니다.\"}";
    public static final String UPDATE_INVITE_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"친구 요청 업데이트에 성공하였습니다.\"}";
    public static final String FIND_ALL_RECIVE_INVITE_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"받은 친구 요청 전체 조회에 성공했습니다.\", \"data\":[{\"id\": 1, \"friendId\": 3, \"nickname\": \"nickname\", \"profileImg\": \"proflie/default.png\"}]}";
    public static final String FIND_ALL_SEND_INVITE_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"보낸 친구 요청 전체 조회에 성공했습니다.\", \"data\":[{\"id\": 1, \"friendId\": 3, \"nickname\": \"nickname\", \"profileImg\": \"proflie/default.png\"}]}";
    public static final String FIND_ALL_FRIEND_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"모든 친구 요청 전체 조회에 성공했습니다.\", \"data\":[{\"id\": 1, \"friendId\": 3, \"nickname\": \"nickname\", \"profileImg\": \"proflie/default.png\"}]}";
    public static final String FIND_ALL_USER_EXCEPT_FRIEND_SUCCESS_RESPONSE = "{\n" +
            "  \"code\": 200,\n" +
            "  \"message\": \"유저 목록을 조회합니다.\",\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"id\": 3,\n" +
            "      \"nickname\": \"admin\",\n" +
            "      \"profileImg\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 4,\n" +
            "      \"nickname\": \"dkdkdkd\",\n" +
            "      \"profileImg\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"id\": 6,\n" +
            "      \"nickname\": \"문효찬\",\n" +
            "      \"profileImg\": null\n" +
            "    }\n" +
            "  ]\n" +
            "}";


    // 마커, ar
    public static final String FIND_ALL_MARKER_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"주변 마커를 조회합니다.\", \"data\":{\"reward\": {\"id\": 1, \"reward\": \"/walk/default.png\"}, \"marker\": [{\"id\": 1, \"latitude\": 37.500584, \"longitude\": 126.925425}]}}";
    public static final String AR_SAVE_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"AR 게시에 성공했습니다.\"}";
    public static final String FIND_ALL_AR_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"해당 마커 AR 전체 조회에 성공했습니다.\", \"data\":[{\"id\": 1, \"music\": {\"id\": 1, \"youtubeId\": \"string\", \"title\": \"title\", \"thumbnail\": \"/thumbnail/default.png\"}, \"reward\": \"/pop/default.png\", \"latitude\": 37.500584, \"longitude\": 126.925425}]}";
    public static final String AR_DELETE_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"AR 삭제에 성공했습니다.\"}";
    public static final String REWARD_SAVE_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"리워드 저장에 성공했습니다.\"}";
    public static final String FIND_ALL_REWARD_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"리워드 전체 조회에 성공했습니다.\", \"data\": {\"selectedReward\": { \"id\": 3, \"reward\": \"/pop/default.png\" }, \"rewards\": [{\"id\": 3, \"reward\": \"/pop/default.png\"}, {\"id\": 4, \"reward\": \"/pop/test.png\"}]}}";
    public static final String REWARD_SELECT_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"리워드 적용에 성공했습니다.\"}";

    // 스토리
    public static final String STORY_SAVE_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"스토리 게시에 성공했습니다.\"}";
    public static final String FIND_STORY_USER_SUCCESS_RESPONSE =  "{\"code\":200,\"message\":\"스토리 게시 유저 조회에 성공했습니다.\", \"data\":[{\"id\": 1, \"nickname\": \"nickname\", \"profileImg\": \"/pop/default.png\" }]}";
    public static final String FIND_STORY_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"스토리 조회에 성공했습니다.\", \"data\":[{\"id\": 1, \"youtubeId\": \"v_gO_P8gug8\", \"title\": \"퀸카(Queencard)\", \"thumbnail\": \"https://i.ytimg.com/vi/v_gO_P8gug8/hqdefault.jpg\" }]}";

    // 게시판
    public static final String BOARD_SAVE_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"게시물 작성에 성공했습니다.\"}";
    public static final String FIND_BOARD_SUCCESS_RESPONSE = 
            "{\n" +
            "  \"code\": 200,\n" +
            "  \"message\": \"게시글을 조회합니다.\",\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"id\": 2,\n" +
            "      \"user\": {\n" +
            "        \"id\": 2,\n" +
            "        \"nickname\": \"nickname\",\n" +
            "        \"profileImg\": null\n" +
            "      },\n" +
            "      \"content\": \"게시글 내용\",\n" +
            "      \"location\": \"서울시 구로구 고척동 234-5\",\n" +
            "      \"img\": \"/board/test.png\",\n" +
            "      \"createdDate\": [\n" +
            "        2023,\n" +
            "        10,\n" +
            "        12,\n" +
            "        14,\n" +
            "        35,\n" +
            "        48,\n" +
            "        944410000\n" +
            "      ]\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static final String DELETE_BOARD_SUCCESS_RESPONSE = "{\"code\":200,\"message\":\"게시물 삭제에 성공했습니다.\"}";


    public static final String BAD_REQUEST = "잘못된 요청 입니다.";
    public static final String NOT_FOUND = "찾을 수 없습니다.";
}
