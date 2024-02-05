package gdsc.insangjinsolutionchallenge.domain.user;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class UserInfo {
    private String id;
    private String email;
    @SerializedName("verified_email")
    private Boolean verifiedEmail;
    private String name;
    @SerializedName("picture")
    private String pictureUrl;
    private String locale;
}
