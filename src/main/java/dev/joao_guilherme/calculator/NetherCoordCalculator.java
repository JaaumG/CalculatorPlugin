package dev.joao_guilherme.calculator;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class NetherCoordCalculator implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            if (strings.length == 3) {
                try {
                    int x = Integer.parseInt(strings[0]);
                    int z = Integer.parseInt(strings[1]);
                    int y = Integer.parseInt(strings[2]);
                    player.sendMessage("As coordenadas no Nether são: " + x / 8 + " " + y + " " + z / 8);
                } catch (NumberFormatException e) {
                    player.sendMessage("As coordenadas precisam ser números inteiros!");
                }
            } else {
                player.sendMessage("Uso correto: /nethercoord <x> <z> <y>");
            }
        }
        return true;
    }
}
