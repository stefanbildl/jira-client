package jiraclient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueType {
    private int id;
    private String self, description, iconUrl, name;
    private boolean subtask;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSubtask() {
        return subtask;
    }

    public void setSubtask(boolean subtask) {
        this.subtask = subtask;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IssueType issueType = (IssueType) o;

        return id == issueType.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "IssueType{" +
                "id=" + id +
                ", self='" + self + '\'' +
                ", description='" + description + '\'' +
                ", iconUrl='" + iconUrl + '\'' +
                ", name='" + name + '\'' +
                ", subtask=" + subtask +
                '}';
    }


    public static List<IssueType> all(JiraClient client) throws IOException {
        Response<List<IssueType>> response = client.issueTypeInterface.getIssueTypes().execute();
        if(response.isSuccessful())
            return response.body();
        throw new IOException(response.errorBody().string());
    }

    public static IssueType get(JiraClient client, String key) throws IOException {
        Response<IssueType> response = client.issueTypeInterface.getIssueType(key).execute();
        if(response.isSuccessful())
            return response.body();
        throw new IOException(response.errorBody().string());
    }


}
