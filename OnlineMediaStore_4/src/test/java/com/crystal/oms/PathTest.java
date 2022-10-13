package com.crystal.oms;


import com.crystal.path.ResourcesPath;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Objects;

public class PathTest {
    @Test
    public void absolutePath() {
        File file = new File("OnlineMediaStore_4/src/main/resources/media.json");
        System.out.println(file.getAbsolutePath());
    }
    @Test
    public void testClassResourcePath(){
        String rootPath = Objects.requireNonNull(this.getClass().getResource("")).getPath().split("target")[0];

        System.out.println(rootPath);
        System.out.println(ResourcesPath.getModuleRootPathAsString(this.getClass()));
    }
}
