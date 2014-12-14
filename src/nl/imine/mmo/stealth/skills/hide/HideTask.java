package nl.imine.mmo.stealth.skills.hide;

import nl.makertim.MMOmain.lib.MMOOutlaws;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class HideTask extends BukkitRunnable {

    public static Plugin plugin;
    private Hide hide;

    public HideTask(Hide hide, Plugin plugin) {
        this.plugin = plugin;
        this.hide = hide;
        this.runTaskTimer(plugin, 1L, 10L);
    }

    public void run() {
        for (Player p : plugin.getServer().getOnlinePlayers()) {
            //if (hide.hasSkill(p)) {
                Block pBlock = p.getLocation().getBlock();
                if ((pBlock.getType().equals(Material.DOUBLE_PLANT)
                        || pBlock.getRelative(BlockFace.DOWN).getType().equals(Material.HAY_BLOCK) && p.isSneaking())) {
                    MMOOutlaws.setInvis(p, 100);
                }
                MMOOutlaws.setInvis(p, 0);
            //}
        }
    }
}
