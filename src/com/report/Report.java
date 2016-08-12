package com.report;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author creeper
 *
 */
public class Report extends JavaPlugin {

	@Override
	public void onEnable(){
		this.getLogger().info("Reportをロードしました");
		saveDefaultConfig();
	}


	@Override
	public void onDisable(){
		this.getLogger().info("Reportをアンロードしました");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] arges){
    // プレイヤーがコマンドを投入した際の処理
		if(cmd.getName().equalsIgnoreCase("report")){
			//何かの処理
		if (!(sender instanceof Player)) {
			sender.sendMessage("このコマンドはゲーム内から実行してください.");
		} else {
				Player Player = (Player) sender;
		}
			return true;
			//コマンドが実行された場合は、trueを返してメソッドを抜ける
		}
	return false;
	//コマンドが実行されなかった場合は、falseを返してメソッドを抜ける
		}
}
