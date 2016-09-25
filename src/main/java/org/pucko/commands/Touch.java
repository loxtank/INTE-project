
package org.pucko.commands;

/**
 * Created by Tobias on 15/09/16.
 */

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


import org.pucko.core.InputHandler;
import org.pucko.core.OutputHandler;
import org.pucko.core.WorkingDirectory;

public class Touch extends Command {


    public Touch(ArrayList<String> args, WorkingDirectory workingDirectory, OutputHandler outputHandler, OutputHandler errorHandler, InputHandler inputHandler) {
        super(args, workingDirectory, outputHandler, errorHandler, inputHandler);
    }

    @Override
    public boolean execute() {

        Path currentDir = getWorkingDirectory();
        Path argsPath;
        Path newPath;

        ArrayList<String> args = getArgs();


        for (String s : args) {

            argsPath = Paths.get(s);
            newPath = currentDir.resolve(argsPath);

            try {
                Files.createFile(newPath);
            } catch (FileAlreadyExistsException e) {
                error("File already exist.");
            } catch (IOException e) {
            }

        }
        
        return true;
    }

    @Override
    protected boolean verifyExecutable() {

        if (getArgs().size() < 2) {
            error("Filename is missing");
            return false;
        }
        return true;

    }

    @Override
    protected boolean undo() {
        return false;
    }

    @Override
    protected boolean verifyUndoable() {
        return false;
    }


}
