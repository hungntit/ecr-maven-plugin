package maven.aws.ecs.ecr;

import org.apache.maven.plugins.annotations.Mojo;

import java.util.Arrays;
import java.util.List;

@Mojo(name = "deploy")
public class EcrFullFlow extends AbstractCommandMojo {

    public List<Command> getCommands() {
        return Arrays.asList(
                new Command(getWorkingDirectory(), "docker", "build", getWorkingDirectory().getAbsolutePath()),
                new Command(getWorkingDirectory(), "aws", "ecs")
        );
    }

    //

}
