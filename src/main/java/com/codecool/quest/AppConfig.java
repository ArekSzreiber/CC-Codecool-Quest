package com.codecool.quest;

import com.codecool.quest.model.keybining.KeyBinding;
import com.codecool.quest.model.keybining.WSADKeyBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.codecool.quest")
public class AppConfig {
    @Bean
    public KeyBinding WSADKeyBinding() {
        return new WSADKeyBinding();
    }
}
