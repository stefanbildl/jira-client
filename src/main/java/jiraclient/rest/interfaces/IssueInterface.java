package jiraclient.rest.interfaces;

import jiraclient.Issue;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IssueInterface {
    @POST("issue")
    Call<ResponseBody> createIssue(@Body Issue issue);
}
