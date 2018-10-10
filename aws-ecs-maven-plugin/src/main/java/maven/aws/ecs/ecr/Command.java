package maven.aws.ecs.ecr;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Command {

    private String executable;

    private List<String> commandArgs;
    private File workingDirectory;
    private boolean ignoreExecuteFailure;

    public Command(File workingDirectory, boolean ignoreExecuteFailure, String executable, List<String> commandArgs) {
        this.executable = executable;
        this.commandArgs = commandArgs;
        this.workingDirectory = workingDirectory;
        this.ignoreExecuteFailure = ignoreExecuteFailure;
    }

    public Command(File workingDirectory, String executable, List<String> commandArgs) {
        this(workingDirectory, false, executable, commandArgs);
    }

    public Command( File workingDirectory, String executable, String... args) {
        this(workingDirectory, false, executable, args == null? Collections.<String>emptyList() : Arrays.asList(args));
    }

    public String getExecutable() {
        return executable;
    }

    public void setExecutable(String executable) {
        this.executable = executable;
    }

    public List<String> getCommandArgs() {
        return commandArgs;
    }

    public void setCommandArgs(List<String> commandArgs) {
        this.commandArgs = commandArgs;
    }

    public File getWorkingDirectory() {
        return workingDirectory;
    }

    public void setWorkingDirectory(File workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

    public boolean isIgnoreExecuteFailure() {
        return ignoreExecuteFailure;
    }

    public void setIgnoreExecuteFailure(boolean ignoreExecuteFailure) {
        this.ignoreExecuteFailure = ignoreExecuteFailure;
    }

    @Override
    public String toString() {
        return "Command{" +
                "executable='" + executable + '\'' +
                ", commandArgs=" + commandArgs +
                ", workingDirectory=" + workingDirectory +
                ", ignoreExecuteFailure=" + ignoreExecuteFailure +
                '}';
    }
}
