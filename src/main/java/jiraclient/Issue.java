package jiraclient;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import okhttp3.ResponseBody;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {
    private HashMap<String, Object> fields;

    public HashMap<String, Object> getFields() {
        return fields;
    }

    public void setFields(HashMap<String, Object> fields) {
        this.fields = fields;
    }


    public static class Builder {
        private HashMap<String, Object> fields = new HashMap<>();

        public Builder(Project project) {
            HashMap<String, String> projectMap = new HashMap<>();
            projectMap.put("id", String.valueOf(project.getId()));
            fields.put("project", projectMap);
        }

        public Builder(int id) {
            HashMap<String, String> projectMap = new HashMap<>();
            projectMap.put("id", String.valueOf(id));
            fields.put("project", projectMap);
        }

        public Builder summary(final String summary) {
            fields.put("summary", summary);
            return this;
        }

        public Builder description(final String description) {
            fields.put("description", description);
            return this;
        }

        public Builder customField(final String key, final Object value) {
            fields.put(key, value);
            return this;
        }

        public Builder issueType(int id) {
            HashMap<String, String> issueTypeMap = new HashMap<>();
            issueTypeMap.put("id", String.valueOf(id));
            fields.put("issuetype", issueTypeMap);
            return this;
        }

        public Builder issueType(IssueType issueType) {
            HashMap<String, String> issueTypeMap = new HashMap<>();
            issueTypeMap.put("id", String.valueOf(issueType.getId()));
            fields.put("issuetype", issueTypeMap);
            return this;
        }
        public Builder priority(int priority) {
            HashMap<String, String> prioMap = new HashMap<>();
            prioMap.put("id", String.valueOf(priority));
            fields.put("priority", prioMap);
            return this;
        }

        public Builder priority(Priority priority) {
            HashMap<String, String> prioMap = new HashMap<>();
            prioMap.put("id", String.valueOf(priority.getId()));
            fields.put("priority", prioMap);
            return this;
        }

        public Issue build() {
            final Issue issue = new Issue();
            issue.setFields(fields);
            return issue;
        }
    }

    public void save(JiraClient client) throws IOException {
        Response<ResponseBody> response = client.issueInterface.createIssue(this).execute();
        if (response.isSuccessful())
            return;
        else throw new IOException(response.errorBody().string());
    }
}
