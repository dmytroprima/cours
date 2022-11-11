package com.menu;

public class DeleteCommand implements Command {
    @Override
    public void execute() {
        Main.deleteGift();
    }
}
