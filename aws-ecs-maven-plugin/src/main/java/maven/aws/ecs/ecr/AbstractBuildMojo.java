package maven.aws.ecs.ecr;

import org.apache.maven.plugins.annotations.Parameter;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractBuildMojo extends AbstractCommandMojo {
    @Parameter(
            property = "project.artifactId"
    )
    protected String artifactId;

    @Parameter(
            property = "project.groupId"
    )
    protected String groupId;

    @Parameter(
            property = "project.version"
    )
    protected String version;

    @Parameter(
            property = "user.name"
    )
    protected String username;

    @Parameter(
            property = "build.number"
    )

    protected String buildNumber;

    @Parameter(defaultValue = "${session.request.startTime}", readonly = true)
    protected Date mavenBuildTimeStamp;


    public void handleBuildNumber() {
        if (buildNumber == null) {
            buildNumber = new SimpleDateFormat("yyyyMMddHHmmss").format(mavenBuildTimeStamp);
        }
    }
}
