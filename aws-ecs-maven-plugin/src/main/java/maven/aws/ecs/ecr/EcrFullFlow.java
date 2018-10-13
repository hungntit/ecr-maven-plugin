package maven.aws.ecs.ecr;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static maven.aws.ecs.ecr.Command.convertClasspathToShCommand;

@Mojo(name = "deploy")
public class EcrFullFlow extends AbstractAwsBuildMojo {

    @Parameter(
            property = "aws.ecr.region",
            required = true
    )
    private String region;

    @Parameter(
            property = "aws.ecr.accountId",
            required = true
    )
    private String ecrAccountId;

    private String getEcrRegistryId() {
        return String.format("%s.dkr.ecr.%s.amazonaws.com", ecrAccountId, region);
    }
    public List<Command> getCommands() throws MojoExecutionException {
        handleBuildNumber();
        Command ecrLogin = convertClasspathToShCommand(new Command(getWorkingDirectory(),
                "classpath:ecr_login.sh", ecrAccountId, region, groupId + "-" + artifactId, version + "-" + buildNumber, profile));
        return Arrays.asList(
                ecrLogin);
    }
}
