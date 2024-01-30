package com.hoopers;

import com.hoopers.token.Token;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;
import java.util.Locale;

public class HoopersBot {

    private final ShardManager shardManager;

    public  HoopersBot() throws LoginException {
        Token key = new Token();
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(key.token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.playing("NBA2K24"));
        shardManager = builder.build();
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args) {
        try {
            HoopersBot bot = new HoopersBot();
        } catch (LoginException e ) {
            System.out.println("ERROR: Provided bot token is invalid");
        }

    }
}
