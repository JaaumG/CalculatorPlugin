package dev.joao_guilherme.calculator;

import dev.joao_guilherme.Expression;
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

public class CalcCommand implements CommandExecutor, TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            try {
                String expression = String.join(" ", strings);
                player.sendMessage(Component.text(expression + " = " + new Expression(expression).evaluate().toPlainString()).color(NamedTextColor.GREEN));
            } catch (Exception e) {
                player.sendMessage(Component.text("Erro ao calcular a expressão!").color(NamedTextColor.RED));
            }
        } else {
            commandSender.sendMessage(Component.text("Você precisa ser um jogador para usar este comando!").color(NamedTextColor.RED));
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return List.of();
    }
}
