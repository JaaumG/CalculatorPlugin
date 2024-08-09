package dev.joao_guilherme.calculator;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Calculator extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("[Calculator] Plugin initialized!");
        Objects.requireNonNull(getCommand("calc")).setExecutor(new CalcCommand());
        Objects.requireNonNull(getCommand("distance")).setExecutor(new DistanceCalculator());
        Objects.requireNonNull(getCommand("nethercoord")).setExecutor(new NetherCoordCalculator());
        Bukkit.getConsoleSender().sendMessage("[Calculator] Commands registered!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
