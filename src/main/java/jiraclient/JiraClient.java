package jiraclient;

import jiraclient.rest.BasicAuthRetrofitProvider;
import jiraclient.rest.RetrofitProvider;
import jiraclient.rest.interfaces.IssueInterface;
import jiraclient.rest.interfaces.PriorityInterface;
import jiraclient.rest.interfaces.ProjectInterface;
import retrofit2.Retrofit;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class JiraClient {
    private final Retrofit retrofit;
    final PriorityInterface priorityInterface;
    final ProjectInterface projectInterface;
    final IssueInterface issueInterface;

    private JiraClient(RetrofitProvider retrofitProvider) {
        this.retrofit = retrofitProvider.getRetrofit();
        priorityInterface = retrofit.create(PriorityInterface.class);
        projectInterface = retrofit.create(ProjectInterface.class);
        issueInterface = retrofit.create(IssueInterface.class);
    }

    public static JiraClient getBasicAuthInstance(final String baseUrl, final String username, final String password) throws URISyntaxException, MalformedURLException {
        URL x = new URL(baseUrl);
        URL url = new URL(x.getProtocol(), x.getHost(), x.getPort(), x.getFile() + "/rest/api/2/", null);
        return new JiraClient(new BasicAuthRetrofitProvider(url.toString(), username, password));
    }
}
