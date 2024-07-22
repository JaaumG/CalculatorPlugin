package dev.joao_guilherme.calculator;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class NetherCoordCalculator implements CommandExecutor, TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            if (strings.length == 0) {
                player.sendMessage(Component.text("As coordenadas no Nether são: " + player.getLocation().getBlockX() / 8 + " " + player.getLocation().getBlockZ() / 8).color(NamedTextColor.AQUA));
            } else if (strings.length == 2) {
                try {
                    double x = Double.parseDouble(strings[0]);
                    double z = Double.parseDouble(strings[1]);
                    player.sendMessage(Component.text("As coordenadas no Nether são: " + x / 8 + " " + z / 8).color(NamedTextColor.AQUA));
                } catch (NumberFormatException e) {
                    player.sendMessage(Component.text("Coordenadas inválidas!").color(NamedTextColor.RED));
                }
            } else {
                player.sendMessage(Component.text("Uso correto: /nethercoord <x> <z>").color(NamedTextColor.RED));
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            if (strings.length == 1) {
                return List.of(String.valueOf(player.getLocation().getBlockX()));
            } else if (strings.length == 2) {
                return List.of(String.valueOf(player.getLocation().getBlockZ()));
            }
        }
        return List.of();
    }
}
