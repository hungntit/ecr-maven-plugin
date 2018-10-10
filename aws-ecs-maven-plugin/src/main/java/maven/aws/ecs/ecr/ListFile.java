package maven.aws.ecs.ecr;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Mojo(name = "ls")
public class ListFile extends AbstractCommandMojo {

    @Parameter(
            property = "project.artifactId"
    )
    private String artifactId;

    @Parameter(
            property = "project.groupId"
    )
    private String groupId;

    @Parameter(
            property = "project.version"
    )
    private String version;

    @Parameter(
            property = "user.name"
    )
    private String username;

    @Parameter(
            property = "build.number"
    )
    private String buildNumber;

    @Parameter(defaultValue = "${session.request.startTime}", readonly = true)
    private Date mavenBuildTimeStamp;

    public List<Command> getCommands() {
        handleBuildNumber();
        return Arrays.asList(
                new Command(getWorkingDirectory(), "echo", artifactId, groupId, version, buildNumber),
                new Command(getWorkingDirectory(), "ls", "-la")
        );
    }

    private void handleBuildNumber() {
        if (buildNumber == null) {
            buildNumber = String.format("%s-%s", username, new SimpleDateFormat("yyyyMMddHHmmss").format(mavenBuildTimeStamp));
        }
    }
    public void verify() throws MojoExecutionException {
    }
}
