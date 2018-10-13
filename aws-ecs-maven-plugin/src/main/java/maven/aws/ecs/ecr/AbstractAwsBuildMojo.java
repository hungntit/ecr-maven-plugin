package maven.aws.ecs.ecr;

import org.apache.maven.plugins.annotations.Parameter;

public abstract class AbstractAwsBuildMojo extends AbstractBuildMojo {

    @Parameter(
            property = "aws.profile"
    )
    protected String profile;
}
