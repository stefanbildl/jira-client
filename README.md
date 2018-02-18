# A Simple Jira Rest Client 



This Jira client is still under development. 
As of now, it only allows creating issues.
If you want to contribute, please let me know.

The client uses retrofit2 and jackson.

## Usage



```java
try {
    JiraClient client = JiraClient.getBasicAuthInstance("https://jirabaseurl", "user", "password");
    // load information about all projects
    List<Project> projects = Project.allProjects(client);

    System.out.println("== Projects ==");
    for(Project project: projects)
        System.out.println(project.getName() + " (" + project.getKey() + ")");

    // get a project with a given key
    Project project = Project.get(client, "TEST");
    IssueType issueType = project.getIssueType("Story");

    // fluently create issue
    new Issue.Builder(project)
            .issueType(issueType)
            .summary("Summary")
            .description("this is the Description")
            .priority(Priority.LOWEST)
            .build()
            .save(client);

} catch (IOException e) {
    e.printStackTrace();
} catch (URISyntaxException e) {
    e.printStackTrace();
}
```
