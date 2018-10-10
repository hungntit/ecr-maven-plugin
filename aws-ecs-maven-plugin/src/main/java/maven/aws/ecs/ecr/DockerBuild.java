package maven.aws.ecs.ecr;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Mojo(name = "build")
public class DockerBuild extends AbstractCommandMojo {

    public List<Command> getCommands() {
        return Arrays.asList(
                new Command(getWorkingDirectory(), "docker", "build", getWorkingDirectory().getAbsolutePath())
        );
    }

    //

}
