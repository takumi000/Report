package com.report;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Creeper
 *
 */

public class Report extends JavaPlugin {

	/**
	 * plugin
	 */
	public static Plugin plugin;

	@Override
	public void onEnable(){
		plugin = this;
		plugin.getLogger().info("Reportをロードしました");
		//saveDefaultConfig();
	}


	@Override
	public void onDisable(){
		this.getLogger().info("Reportをアンロードしました");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    // 指定したコマンドか判定
		if(cmd.getName().equalsIgnoreCase("report")){
			// 送信者がプレイヤーか判定
			if (!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "このコマンドはゲーム内から実行してください.");
			} else {
				// メッセージがあるか
				if (!(args.length == 0)){
					// 実行者が権限を所持しているか
					if (sender.hasPermission("report.report")){
						for(Player p : Bukkit.getServer().getOnlinePlayers()){
							String p2 = p.getName();
							Player stf = Bukkit.getPlayerExact(p2);
							// オンラインプレイヤーの中のスタッフに表示を行う
							if (stf.hasPermission("report.view")){
								Player Sender = Bukkit.getPlayer(sender.getName());

								// コメントにスペースを挟んでも表示されるように
								StringBuilder msg = new StringBuilder();
								for (int i = 1; i<args.length; i++){
									msg.append(args[i] + " ");
								}

								// 送信
								sender.sendMessage(ChatColor.RED + "------------Report------------");
								sender.sendMessage(ChatColor.AQUA + "Name: " + ChatColor.RESET + args[0]);
								sender.sendMessage(ChatColor.AQUA + "Executed: " + ChatColor.RESET + Sender.getDisplayName());
								sender.sendMessage(ChatColor.AQUA + "Location: " + ChatColor.RESET + Sender.getLocation().getWorld().getName() + ", " + Sender.getLocation().getBlockX() + ", " + Sender.getLocation().getBlockY() + ", " + Sender.getLocation().getBlockZ());
								sender.sendMessage(ChatColor.AQUA + "Comment: " + ChatColor.RESET + msg);
								sender.sendMessage(ChatColor.RED + "------------------------------");
								return true;
								//コマンドが実行された場合は、trueを返してメソッドを抜ける
							}
						}
					} else {
						// 権限を持っていなかった場合
						sender.sendMessage(ChatColor.RED + "You don't have Permission.");
						return true;
					}
				}
				else {
					// メッセージがなかった場合
					sender.sendMessage(ChatColor.RED + "メッセージを入力して下さい");
				}
			}

		}
		return false;
		//コマンドが実行されなかった場合は、falseを返してメソッドを抜ける
	}
}