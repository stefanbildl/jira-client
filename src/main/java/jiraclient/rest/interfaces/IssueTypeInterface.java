package jiraclient.rest.interfaces;

import jiraclient.IssueType;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface IssueTypeInterface {
    @GET("issuetype")
    Call<List<IssueType>> getIssueTypes();

    @GET("issuetype/{key}")
    Call<IssueType> getIssueType(@Path("key") String key);
}
