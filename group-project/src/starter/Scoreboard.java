
package starter;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;
import javafx.print.PrintColor;

import java.awt.*;
import java.awt.List;

import javax.swing.*;

import com.sun.org.apache.xml.internal.utils.CharKey;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Scanner;

public abstract class Scoreboard extends WinPane {
	
	public Scoreboard(MainApplication app) {
		super(app);
		// TODO Auto-generated constructor stub
	}

	public void onSpectateLeave(FlagSpectate.SpectateLeaveEvent event) {
	SpleefPlayer player = event.getPlayer();
	Player bukkitPlayer = player.getBukkitPlayer();
	
	team.removePlayer(bukkitPlayer);
	bukkitPlayer.removePotionEffect(PotionEffectType.INVISIBILITY);
	
	for (SpleefPlayer ingamePlayer : game.getPlayers()) {
		if (ingamePlayer.getBukkitPlayer().canSee(bukkitPlayer)) {
			continue;
		}
		
		ingamePlayer.getBukkitPlayer().showPlayer(bukkitPlayer);
	}
	
	Scoreboard mainScoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
	bukkitPlayer.setScoreboard(mainScoreboard);
}
}




