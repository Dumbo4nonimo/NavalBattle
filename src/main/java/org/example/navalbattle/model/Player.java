package org.example.navalbattle.model;

import java.io.IOException;

public class Player implements IPlayer{


    private String nickname;
    private String record;

    public String getNickname(){
        return nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }


    public Player() throws IOException {
    }
}
