package com.menu;

public class CheckCommand implements Command {
    @Override
    public void execute() {
        Main.printGiftComposition();
    }
}
