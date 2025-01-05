package fr.GameOfFamous.bedwars_Solo.Utils.Manager;

import fr.GameOfFamous.bedwars_Solo.Bedwars_Solo;
import fr.GameOfFamous.bedwars_Solo.Utils.Redis.RedisAccess;
import fr.GameOfFamous.commons.BedwarsAccount;
import org.bukkit.Bukkit;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class AccountManager {

    private static final ConcurrentHashMap<UUID, BedwarsAccount> accounts = new ConcurrentHashMap<>();

    public static ConcurrentHashMap<UUID, BedwarsAccount> getAccounts(){return accounts;}

    public static void loadAccounts(UUID uuid){

        Bukkit.getScheduler().runTaskAsynchronously(Bedwars_Solo.instance, ()-> {
            final RedisAccess redisAccess = RedisAccess.INSTANCE;
            final RedissonClient redissonClient = redisAccess.getRedissonClient();
            final RBucket<BedwarsAccount> accountRBucket = redissonClient.getBucket("bedwars:" + uuid.toString());
            final BedwarsAccount account = accountRBucket.get();

            if(account != null){
                accounts.put(uuid, account);
                System.out.println("Bedwars Account chargé pour : "+ account.getPseudo());
            }
        });

    }

    public static void sendAccounts(UUID uuid){

        Bukkit.getScheduler().runTaskAsynchronously(Bedwars_Solo.instance, ()-> {
            final RedisAccess redisAccess = RedisAccess.INSTANCE;
            final RedissonClient redissonClient = redisAccess.getRedissonClient();
            final RBucket<BedwarsAccount> accountRBucket = redissonClient.getBucket("bedwars:" + uuid.toString());

            BedwarsAccount account = accounts.get(uuid);

            if(account != null){
                accountRBucket.set(account);
                System.out.println("Bedwars Account sauvegardé pour : "+ account.getPseudo());
            }
        });

    }



    public static int getGamePlayed(UUID uuid){
        BedwarsAccount account = accounts.get(uuid);
        if(account != null){
            return account.getGamePlayed();
        }

        return 0;
    }

    public static void addGamePlayed(UUID uuid){
        BedwarsAccount account = accounts.get(uuid);
        if(account != null){
            account.setGamePlayed(account.getGamePlayed() + 1);
        }
    }

    public static int getGameWin(UUID uuid){
        BedwarsAccount account = accounts.get(uuid);
        if(account != null){
            return account.getGameWin();
        }

        return 0;
    }

    public static void addGameWin(UUID uuid){
        BedwarsAccount account = accounts.get(uuid);
        if(account != null){
            account.setGamePlayed(account.getGameWin() + 1);
        }
    }

    public static int getKills(UUID uuid){
        BedwarsAccount account = accounts.get(uuid);
        if(account != null){
            return account.getKills();
        }

        return 0;
    }

    public static void addKills(UUID uuid){
        BedwarsAccount account = accounts.get(uuid);
        if(account != null){
            account.setGamePlayed(account.getKills() + 1);
        }
    }

    public static int getDeath(UUID uuid){
        BedwarsAccount account = accounts.get(uuid);
        if(account != null){
            return account.getDeath();
        }

        return 0;
    }

    public static void addDeath(UUID uuid){
        BedwarsAccount account = accounts.get(uuid);
        if(account != null){
            account.setGamePlayed(account.getDeath() + 1);
        }
    }

    public static int getBedDestroy(UUID uuid){
        BedwarsAccount account = accounts.get(uuid);
        if(account != null){
            return account.getBedDestroy();
        }

        return 0;
    }

    public static void addBedDestroy(UUID uuid){
        BedwarsAccount account = accounts.get(uuid);
        if(account != null){
            account.setGamePlayed(account.getBedDestroy() + 1);
        }
    }

    public static int getBlockPlaced(UUID uuid){
        BedwarsAccount account = accounts.get(uuid);
        if(account != null){
            return account.getBlockplaced();
        }

        return 0;
    }

    public static void addBlockPlace(UUID uuid){
        BedwarsAccount account = accounts.get(uuid);
        if(account != null){
            account.setGamePlayed(account.getBlockplaced() + 1);
        }
    }

}
