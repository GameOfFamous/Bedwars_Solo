package fr.GameOfFamous.bedwars_Solo.Utils.Gestion;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.UUID;

public class CreateItem {

    public static ItemStack newItem(Material material, int amount, String displayName, Boolean hasEnchant, String[] lore){

        // Vérifie si le matériel est valide pour éviter une erreur
        if (material == null || amount <= 0) {
            throw new IllegalArgumentException("Material cannot be null, and amount must be greater than 0.");
        }

        // Crée l'objet avec le matériel et la quantité spécifiés
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();

        if (itemMeta != null) {
            // Définit le nom personnalisé
            if (displayName != null && !displayName.isEmpty()) {
                itemMeta.setDisplayName(displayName);
            }

            // Ajoute l'enchantement si spécifié
            if (hasEnchant) {
                itemMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            }

            // Ajoute la description (lore) si elle est fournie
            if (lore != null && lore.length > 0) {
                itemMeta.setLore(Arrays.asList(lore));
            }

            // Cache les enchantements et attributs pour un affichage propre
            itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

            // Applique les métadonnées à l'ItemStack
            itemStack.setItemMeta(itemMeta);
        }

        return itemStack;

    }

    public static ItemStack newItemBedwars(Material material, int amount, Boolean hasEnchant){
        if (material == null || amount <= 0) {
            throw new IllegalArgumentException("Material cannot be null, and amount must be greater than 0.");
        }

        // Crée l'objet avec le matériel et la quantité spécifiés
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();

        if (itemMeta != null) {
            // Ajoute l'enchantement si spécifié
            if (hasEnchant) {
                itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            }
            itemMeta.setUnbreakable(true);

            itemStack.setItemMeta(itemMeta);
        }

        return itemStack;
    }

    public static ItemStack getSkull(String name,String[] lore , String textures) {

        // Crée un nouvel ItemStack pour une tête de joueur
        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);

        if (item.getType() == Material.PLAYER_HEAD) {
            SkullMeta meta = (SkullMeta) item.getItemMeta();

            if (meta != null) {
                // Définit le nom affiché de l'objet
                meta.setDisplayName(name);

                // Crée un GameProfile pour la texture personnalisée
                GameProfile profile = new GameProfile(UUID.randomUUID(), "CustomProfile");
                profile.getProperties().put("textures", new Property("textures", textures));

                // Injecte le profil dans les métadonnées via réflexion
                try {
                    Field profileField = meta.getClass().getDeclaredField("profile");
                    profileField.setAccessible(true);
                    profileField.set(meta, profile);
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    Bukkit.getLogger().warning("Failed to set the base64 skull texture: " + e.getMessage());
                }

                // Ajoute la description (lore) si elle est fournie
                if (lore != null && lore.length > 0) {
                    meta.setLore(Arrays.asList(lore));
                }

                // Applique les métadonnées à l'objet
                item.setItemMeta(meta);
            }
        }

        return item;

    }

    public static ItemStack getPlayerSkull(String playerName, String[] lore){

        ItemStack item = new ItemStack(Material.PLAYER_HEAD, 1);

        // Récupère les métadonnées de l'objet
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        if (meta != null) {
            // Définit le propriétaire de la tête
            OfflinePlayer p = Bukkit.getOfflinePlayer(playerName);
            meta.setOwningPlayer(p);

            // Définit le nom de l'objet
            meta.setDisplayName(playerName);

            // Ajoute la description (lore) si elle est fournie
            if (lore != null && lore.length > 0) {
                meta.setLore(Arrays.asList(lore));
            }

            // Applique les métadonnées à l'objet
            item.setItemMeta(meta);
        }

        return item;

    }

    public static ItemStack createColoredArmor(Material material, Color color, int enchantLevel) {
        // Créer l'armure en cuir
        ItemStack item = new ItemStack(material);

        // Appliquer la couleur à l'armure
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        if (meta != null) {
            meta.setColor(color);
            if(!(enchantLevel == 0)){
                meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, enchantLevel, true);
            }
            item.setItemMeta(meta);
        }

        return item;
    }

}
