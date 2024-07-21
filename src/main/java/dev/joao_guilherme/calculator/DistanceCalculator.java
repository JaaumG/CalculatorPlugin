package dev.joao_guilherme.calculator;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DistanceCalculator implements CommandExecutor, TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            if (strings.length == 1) {
                Player target = Bukkit.getPlayer(strings[0]);
                if (target != null) {
                    double distance = player.getLocation().distance(target.getLocation());
                    player.sendMessage("A distância entre você e " + target.getName() + " é de " + distance + " blocos.");
                } else {
                    player.sendMessage("Jogador não encontrado!");
                }
            } else {
                player.sendMessage("Uso correto: /distance <jogador>");
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            if (strings.length == 0) {
                return Bukkit.getOnlinePlayers().stream().filter(p -> p.getUniqueId() != player.getUniqueId()).map(Player::getName).toList();
            }
        }
        return List.of();
    }
}
