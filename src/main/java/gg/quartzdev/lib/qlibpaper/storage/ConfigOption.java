package gg.quartzdev.lib.qlibpaper.storage;

import org.bukkit.configuration.file.YamlConfiguration;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConfigOption<T> implements IConfigOption {
    private String path;
    private YamlConfiguration yamlConfiguration;
    private T value;
    private final Supplier<T> loader;

    public ConfigOption(String path, YamlConfiguration yamlConfiguration, Supplier<T> loader){
        this.path = path;
        this.yamlConfiguration = yamlConfiguration;
        this.loader = loader;
        save();
    }

    public void load(){
        value = loader.get();
    }

    public T get(){
        return value;
    }

    public void setValue(T value){
        this.value = value;
    }

    public void save(){
        yamlConfiguration.set(path, value);
    }

}
