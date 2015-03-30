package com.thomas15v.mcmmocap;

import com.gmail.nossr50.datatypes.skills.SkillType;
import com.gmail.nossr50.events.experience.McMMOPlayerLevelUpEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by thomas15v on 30/03/15.
 */
public class Plugin extends JavaPlugin implements Listener {


    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerLevelUp(final McMMOPlayerLevelUpEvent event) {
        event.setCancelled(canHaveLevel(event.getPlayer(), event.getSkill(), event.getSkillLevel()));
    }

    private boolean canHaveLevel(Player player, SkillType skill, int level){
        for (int i = 0; i < skill.getMaxLevel(); i++)
            if (player.hasPermission("mcmmocap." + skill.getName() + "." + i))
                if (i >= level)
                    return true;
                else
                    return false;

        return true;
    }

}
