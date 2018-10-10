package maven.aws.ecs.ecr;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

import java.util.Arrays;
import java.util.List;

@Mojo(name = "push")
public class EcsPush extends AbstractCommandMojo {

    public List<Command> getCommands() {
        return Arrays.asList(
                new Command(getWorkingDirectory(), "aws", "ecs")
        );
    }

    public void verify() throws MojoExecutionException {

    }
}
