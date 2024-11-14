package su.nightexpress.nightcore.util;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import su.nightexpress.nightcore.NightCore;

public class Plugins {

    public static final NightCore CORE = NightCore.getPlugin(NightCore.class);

    public static final String VAULT           = "Vault";
    public static final String PLACEHOLDER_API = "PlaceholderAPI";
    public static final String FLOODGATE = "floodgate";

    private static boolean hasPlaceholderAPI;
    private static boolean hasVault;
    private static boolean hasFloodgate;

    private static NightCore core;

    public static void load(@NotNull NightCore nightCore) {
        core = nightCore;
    }

    public static void detectPlugins() {
        hasPlaceholderAPI = isInstalled(PLACEHOLDER_API);
        hasVault = isInstalled(VAULT);
        hasFloodgate = isInstalled(FLOODGATE);
    }

    @NotNull
    public static NightCore getCore() {
        return core;
    }

    public static boolean isInstalled(@NotNull String pluginName) {
        Plugin plugin = core.getPluginManager().getPlugin(pluginName);
        return plugin != null;
    }

    public static boolean isLoaded(@NotNull String pluginName) {
        Plugin plugin = core.getPluginManager().getPlugin(pluginName);
        return plugin != null && plugin.isEnabled();
    }

    @Deprecated
    public static boolean isSpigot() {
        return Version.isSpigot();
    }

    public static boolean hasPlaceholderAPI() {
        return hasPlaceholderAPI;
    }

    public static boolean hasVault() {
        return hasVault;
    }

    public static boolean hasFloodgate() {
        return hasFloodgate;
    }
}
