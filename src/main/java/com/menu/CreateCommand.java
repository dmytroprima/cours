package com.menu;

public class CreateCommand implements Command {
    @Override
    public void execute() {
        Main.createGift();
    }
}
