package com.menu;

public class InfoCommand implements Command {
    @Override
    public void execute() {
        System.out.println("\"create\" for creating of your gift\n" +
                "\"check\" for viewing of your gift\n" +
                "\"delete\" for deleting of your gift\n" +
                "\"sort\" for sorting of your gift\n" +
                "\"exit\" for exiting the program" );
    }
}
